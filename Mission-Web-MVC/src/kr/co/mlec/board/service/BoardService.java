package kr.co.mlec.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardFileVO;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.board.vo.PagingVO;

public class BoardService {
	
	private BoardDAO boardDao;  //모든 보드dao 가져와야하니까 만들어줌 
	
	public BoardService() {
		boardDao = new BoardDAO();     //인스턴스 객체 생성
	}

	/**
	 * 게시글 조회 서비스
	 */
	public List<BoardVO> selectAllBoard(PagingVO paging) {
		List<BoardVO> list = boardDao.selectAllBoard(paging);
		return list;
	}
	
	/**
	 * 상세 게시글 조회 서비스
	 */
	public BoardVO selectBoardByNo(int boardNo) {
		BoardVO vo = boardDao.selectBoardByNo(boardNo);
		return vo;
	}
	
	/**
	    * 게시판 상세 서비스
	    * 1. 파라미터로 날라온 번호에 해당 게시물 조회
	    * 2. 파라미터에 해당하는 첨부파일 조회
	    */
	/*
	 * public Object[] detailBoard(int no) { // 1. BoardVO board =
	 * boardDao.selectBoardByNo(no); // 2. List<BoardFileVO> fileList =
	 * boardDao.selectFileByNo(no);
	 * 
	 * Object[] arr = {board, fileList};
	 * 
	 * return arr; }
	 */
	
	 public Map<String, Object> detailBoard(int no) {
         // 1.
         BoardVO board = boardDao.selectBoardByNo(no);
         // 2.
         List<BoardFileVO> fileList = boardDao.selectFileByNo(no);
         
        Map<String, Object> data = new HashMap<>();
        data.put("board",board);
        data.put("fileList",fileList);
         
        return data;
      }
	

	/**
	 * 게시물 등록 서비스
	 */
	public void insertBoard(BoardVO board) {
		boardDao.insertBoard(board);
	}

	/**
	 * 게시물 등록(첨부파일포함) 서비스
	 */
	public void insertBoard(BoardVO board, List<BoardFileVO> fileList) {
		
		//게시물 번호(seq_tbl_board_no) 추출
		int boardNo = boardDao.selectBoardNo();
		
		//tbl_board 저장
		board.setNo(boardNo);
		boardDao.insertBoard(board);
		
		//tbl_board_file 저장
		for(BoardFileVO fileVO : fileList) {
			fileVO.setBoardNo(boardNo);
			boardDao.insertFile(fileVO);
		}
	}
	

}
