package kr.co.mlec.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.board.vo.PagingVO;
import kr.co.mlec.util.ConnectionFactory;
import kr.co.mlec.util.JDBCClose;
/**
 * 게시판 DB(tbl_board) CRUD
 * @author user
 *
 *사실 여기는 board라고 이름 붙일 필요 없고 boardservice에서 board로 쓰는게 나음
 *
 */
	

public class BoardDAO {

	/**
	 * 전체 게시글 조회 (페이징 추가)
	 */
	public List<BoardVO> selectAllBoard(PagingVO paging) {
		
		//int startNum = (page-1)*10+1;
		//int endNum = page*10;
		   
		int startNum = paging.getStartNum();
		int endNum = paging.getEndNum();
		
		List<BoardVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
				
		try {
		   conn = new ConnectionFactory().getConnection();
		   StringBuilder sql = new StringBuilder();
		   sql.append(" SELECT * FROM (SELECT * FROM (SELECT ROWNUM row_num ");
		   sql.append(" , tbl_board.* FROM tbl_board) WHERE row_num >= ?) ");
		   sql.append(" WHERE row_num <= ? "); 
		   sql.append(" ORDER by no desc ");
		   
		   
		   pstmt = conn.prepareStatement(sql.toString());
		   pstmt.setInt(1, startNum);
           pstmt.setInt(2, endNum);
           ResultSet rs = pstmt.executeQuery();

		   while(rs.next()) {
			   int no = rs.getInt("no");
			   String title = rs.getString("title");
			   String writer = rs.getString("writer");
			   int viewCnt = rs.getInt("view_cnt");
			   String regDate = rs.getString("reg_date");
			   BoardVO board = new BoardVO(no, title, writer, viewCnt, regDate);
						   
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
	
	public void insertBoard(BoardVO board) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = new ConnectionFactory().getConnection();
		    StringBuilder sql = new StringBuilder();
		    sql.append("insert into tbl_board(no, title, writer, content) ");
		    sql.append(" values(seq_tbl_board_no.nextval, ?, ?, ?) ");
		    pstmt = conn.prepareStatement(sql.toString());
		    
		    pstmt.setString(1, board.getTitle());
		    pstmt.setString(2, board.getWriter());
		    pstmt.setString(3, board.getContent());
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
	public BoardVO selectBoardByNo(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		BoardVO board = null;
		
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
				
				board = new BoardVO(no, title, writer, content, viewCnt, regDate);
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
public void updateBoard(BoardVO board) {
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
    /**
     * 페이징
     */
    
public int getAllCount() {
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	int count = 0;
	
	try {
		conn = new ConnectionFactory().getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT COUNT(*) as count FROM tbl_board ");

		pstmt = conn.prepareStatement(sql.toString());
		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			count = rs.getInt("count");
		}

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		JDBCClose.close(pstmt, conn);
	}

	return count;
}
}
