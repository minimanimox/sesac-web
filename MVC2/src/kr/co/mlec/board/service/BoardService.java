package kr.co.mlec.board.service;

import java.util.List;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardVO;

public class BoardService {
	
	private BoardDAO boardDao;  //모든 보드dao 가져와야하니까 만들어줌 
	//private BoardVO boardVo;
	
	public BoardService() {
		boardDao = new BoardDAO();     //인스턴스 객체 생성
		//boardVo = new BoardVO();
	}

	/**
	 * 게시글 조회 서비스
	 */
	public List<BoardVO> selectAllBoard() {
		List<BoardVO> list = boardDao.selectAllBoard();
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
	 * 게시물 등록 서비스
	 */
	public void insertBoard(BoardVO board) {
		boardDao.insertBoard(board);
	}


}
