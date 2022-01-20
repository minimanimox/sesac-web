package test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import kr.co.mlec.board.service.BoardService;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.user.dao.LoginDAO;
import kr.co.mlec.user.vo.LoginVO;

public class MyTest {
	
	@Ignore
	@Test
	public void 전체게시글조회서비스() throws Exception {
		BoardService service = new BoardService();
		List<BoardVO> list = service.selectAllBoard();
		
		//assertNotNull(list);  //가져온 데이터가 null이 아니라는 것을 확인하는 것
		for(BoardVO vo : list) {
			System.out.println(vo);
		}
	}
	
	
	@Test
	public void 로그인서비스() throws Exception {
		LoginDAO dao = new LoginDAO();
		
		LoginVO vo = new LoginVO();
		vo.setId("hong");
		vo.setPassword("aaa");
		
		LoginVO user = dao.login(vo);
		
		assertNotNull(user);
		}
}
