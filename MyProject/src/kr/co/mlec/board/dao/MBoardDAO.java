package kr.co.mlec.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.mlec.board.vo.MBoardFileVO;
import kr.co.mlec.board.vo.MBoardVO;
import kr.co.mlec.util.ConnectionFactory;
import kr.co.mlec.util.JDBCClose;



public class MBoardDAO {

	/**
	 * 전체 게시글 조회
	 */
	public List<MBoardVO> selectAllBoard() {
		
		List<MBoardVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
		   conn = new ConnectionFactory().getConnection();
		   StringBuilder sql = new StringBuilder();
		   sql.append("select no, title, writer, view_cnt, to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
		   sql.append(" from tbl_board ");
		   sql.append(" order by no desc ");
		   pstmt = conn.prepareStatement(sql.toString());
		   ResultSet rs = pstmt.executeQuery();
		   
		   while(rs.next()) {
			   int no = rs.getInt("no");
			   String title = rs.getString("title");
			   String writer = rs.getString("writer");
			   int viewCnt = rs.getInt("view_cnt");
			   String regDate = rs.getString("reg_date");
			   MBoardVO board = new MBoardVO(no, title, writer, viewCnt, regDate);
			 //  System.out.println(board);
			   
			   list.add(board);
		   } }
		   catch(Exception e) {
			   e.printStackTrace();
		   } finally {
			   JDBCClose.close(pstmt, conn);
		   }
		   
		return list;
	}
	/**
	* 새글 등록
	* 
	*/
	
	public void insertBoard(MBoardVO board) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = new ConnectionFactory().getConnection();
		    StringBuilder sql = new StringBuilder();
		    sql.append("insert into tbl_board(no, title, writer, content) ");
		    sql.append(" values(?, ?, ?, ?) ");
		    pstmt = conn.prepareStatement(sql.toString());
		    
		    pstmt.setInt(1, board.getNo());
		    pstmt.setString(2, board.getTitle());
		    pstmt.setString(3, board.getWriter());
		    pstmt.setString(4, board.getContent());
		    pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
	}
	
	/**
	* 게시판 번호에 해당하는 게시글 조회
	* 
	*/	
	public MBoardVO selectBoardByNo(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		MBoardVO board = null;
		
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select no, title, writer, content, view_cnt ");
			sql.append("  , to_char(reg_date, 'yyyy-mm-dd') reg_date ");
			sql.append(" from tbl_board ");
			sql.append(" where no = ? ");   
			   
			pstmt =conn.prepareStatement(sql.toString());
			pstmt.setInt(1, boardNo);
			ResultSet rs =  pstmt.executeQuery();
			
			if(rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String content = rs.getString("content");
				int viewCnt = rs.getInt("view_cnt");
				String regDate = rs.getString("reg_date");
				
				board = new MBoardVO(no, title, writer, content, viewCnt, regDate);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		return board;
	
	}
				
	

/**
* 게시글 수정 (제목, 작성자, 내용 날아옴)
* 
*/	
public void updateBoard(MBoardVO board) {
	Connection conn = null;
	PreparedStatement pstmt = null;
		
	try {
		conn = new ConnectionFactory().getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("update tbl_board ");
		sql.append(" set title = ?, writer = ?, content = ? ");
		sql.append(" where no = ? ");   
		   
		pstmt =conn.prepareStatement(sql.toString());
		pstmt.setString(1, board.getTitle());
		pstmt.setString(2, board.getWriter());
		pstmt.setString(3, board.getContent());
		pstmt.setInt(4, board.getNo());
		pstmt.executeUpdate();
		
		
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		JDBCClose.close(pstmt, conn);
	}
	

}

/**
 * 조회수 업데이트
 */
public void updateCnt(int boardNo) {
	Connection conn = null;
	PreparedStatement pstmt = null;

	
    try {
    	conn = new ConnectionFactory().getConnection();
    	StringBuilder sql = new StringBuilder();
    	sql.append("update tbl_board set view_cnt = view_cnt+1 ");
    	sql.append(" where no = ? ");
    	
    	pstmt =conn.prepareStatement(sql.toString());
    	pstmt.setInt(1, boardNo);
    	
    	pstmt.executeUpdate();
    	
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
    	JDBCClose.close(pstmt, conn);
    }
}

    public void insertFile(MBoardFileVO fileVO) {
    	StringBuilder sql = new StringBuilder();
    	sql.append("insert into tbl_board_file( ");
    	sql.append(" no, board_no, file_ori_name ");
    	sql.append(" , file_save_name, file_size " );
    	sql.append(" ) ");
    	sql.append(" values(seq_tbl_board_file_no.nextval, ?, ?, ?, ? ) ");
    	
    	try(
    			Connection conn = new ConnectionFactory().getConnection();
    			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
    			) {
    		pstmt.setInt(1, fileVO.getBoardNo());
    		pstmt.setString(2,  fileVO.getFileOriName());
    		pstmt.setString(3, fileVO.getFileSaveName());
    		pstmt.setInt(4, fileVO.getFileSize());
    		
    		pstmt.executeUpdate();
    		
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    	
    /**
     * 게시물번호 추출(seq_tbl_board_no)
     */
    public int selectBoardNo() {
          String sql = "select seq_tbl_board_no.nextval from dual ";
          int boardNo = 0;
          try(
    	         Connection conn = new ConnectionFactory().getConnection();
    	         PreparedStatement pstmt = conn.prepareStatement(sql);
    	      ) {
    	         ResultSet rs = pstmt.executeQuery();
    	         rs.next();
    	         boardNo = rs.getInt(1);
    	      } catch(Exception e) {
    	         e.printStackTrace();
    	      }
    	      return boardNo;
    	   }

    /**
     * 첨부파일 
     */
    public List<MBoardFileVO> selectFileByNo(int boardNo) {
    	
    	List<MBoardFileVO> fileList = new ArrayList<>();
    	
    	StringBuilder sql = new StringBuilder();
    	sql.append("select no, file_ori_name, file_save_name, file_size ");
    	sql.append(" from tbl_board_file ");
    	sql.append(" where board_no = ?");
    	
    	try(
    		Connection conn = new ConnectionFactory().getConnection();
    		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
    	) {
    		pstmt.setInt(1,  boardNo);
    		ResultSet rs = pstmt.executeQuery();
    		
    		while(rs.next()) {
    			MBoardFileVO fileVO = new MBoardFileVO();
    			fileVO.setNo(rs.getInt("no"));
    			fileVO.setFileOriName(rs.getString("file_ori_name"));
    			fileVO.setFileSaveName(rs.getString("file_save_name"));
    			fileVO.setFileSize(rs.getInt("file_size"));
    			
    			fileList.add(fileVO);
    		}
    		
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	return fileList;
    }
}


