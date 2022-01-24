package kr.co.mlec.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.mlec.board.dao.MBoardDAO;
import kr.co.mlec.board.vo.MBoardFileVO;
import kr.co.mlec.board.vo.MBoardVO;

public class MBoardService {
	
	private MBoardDAO boardDao;  //모든 보드dao 가져와야하니까 만들어줌 
	//private BoardVO boardVo;
	
	public MBoardService() {
		boardDao = new MBoardDAO();     //인스턴스 객체 생성
		//boardVo = new BoardVO();
	}

	/**
	 * 게시글 조회 서비스
	 */
	public List<MBoardVO> selectAllBoard() {
		List<MBoardVO> list = boardDao.selectAllBoard();
		return list;
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
         MBoardVO board = boardDao.selectBoardByNo(no);
         // 2.
         List<MBoardFileVO> fileList = boardDao.selectFileByNo(no);
         
        Map<String, Object> data = new HashMap<>();
        data.put("board",board);
        data.put("fileList",fileList);
         
        return data;
      }
	

	/**
	 * 게시물 등록 서비스
	 */
	public void insertBoard(MBoardVO board) {
		boardDao.insertBoard(board);
	}

	/**
	 * 게시물 등록(첨부파일포함) 서비스
	 */
	public void insertBoard(MBoardVO board, List<MBoardFileVO> fileList) {
		
		//게시물 번호(seq_tbl_board_no) 추출
		int boardNo = boardDao.selectBoardNo();
		
		//tbl_board 저장
		board.setNo(boardNo);
		boardDao.insertBoard(board);
		
		//tbl_board_file 저장
		for(MBoardFileVO fileVO : fileList) {
			fileVO.setBoardNo(boardNo);
			boardDao.insertFile(fileVO);
		}
	}
	

}
