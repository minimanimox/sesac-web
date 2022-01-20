package kr.co.mlec.board.vo;

public class BoardPagingVO {

	    private final static int pageCount = 5;
	    private int blockStartNum = 0;
	    private int blockLastNum = 0;
	    private int lastPageNum = 0;
		
	    public BoardPagingVO() {
			super();
			
		}

		public BoardPagingVO(int blockStartNum, int blockLastNum, int lastPageNum) {
			super();
			this.blockStartNum = blockStartNum;
			this.blockLastNum = blockLastNum;
			this.lastPageNum = lastPageNum;
		}

		public int getBlockStartNum() {
			return blockStartNum;
		}

		public void setBlockStartNum(int blockStartNum) {
			this.blockStartNum = blockStartNum;
		}

		public int getBlockLastNum() {
			return blockLastNum;
		}

		public void setBlockLastNum(int blockLastNum) {
			this.blockLastNum = blockLastNum;
		}

		public int getLastPageNum() {
			return lastPageNum;
		}

		public void setLastPageNum(int lastPageNum) {
			this.lastPageNum = lastPageNum;
		}

		public static int getPagecount() {
			return pageCount;
		}

		@Override
		public String toString() {
			return "BoardPagingVO [blockStartNum=" + blockStartNum + ", blockLastNum=" + blockLastNum + ", lastPageNum="
					+ lastPageNum + "]";
		}
	    
	    
}
