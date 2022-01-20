package kr.co.mlec.board.paging;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardPagingVO;

public class Paging {
    
    // block을 생성
    // 현재 페이지가 속한 block의 시작 번호, 끝 번호를 계산
    public void makeBlock(int curPage){
        int blockNum = 0;
        
        BoardPagingVO pageVo = new BoardPagingVO();

        blockNum = (int)Math.floor((curPage-1)/ pageCount);
        blockStartNum = (pageCount * blockNum) + 1;
        blockLastNum = blockStartNum + (pageCount-1);
    }

    // 총 페이지의 마지막 번호
    public void makeLastPageNum() {
        BoardDAO dao = new BoardDAO();
        int total = dao.getCount();

        if( total % pageCount == 0 ) {
            lastPageNum = (int)Math.floor(total/pageCount);
        }
        else {
            lastPageNum = (int)Math.floor(total/pageCount) + 1;
        }
    }

    // 검색을 했을 때 총 페이지의 마지막 번호
    public void makeLastPageNum(String kwd) {
        BoardDAO dao = new BoardDAO();
        int total = dao.getCount(kwd);

        if( total % pageCount == 0 ) {
            lastPageNum = (int)Math.floor(total/pageCount);
        }
        else {
            lastPageNum = (int)Math.floor(total/pageCount) + 1;
        }
    }
}
