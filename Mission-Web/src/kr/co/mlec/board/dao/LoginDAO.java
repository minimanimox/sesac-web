package kr.co.mlec.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.co.mlec.board.vo.LoginVO;
import kr.co.mlec.util.ConnectionFactory;

//원래 memberdao에 넣어주면 되는데 이번에만 헷갈릴까봐 따로 만듦
public class LoginDAO {

	/**
	 * 로그인 서비스
	 * @param loginVO (사용자가 입력한 id, pw저장)
	 * @return userVO (id,pw로 조회된 회원정보) 조회된 정보 없다면 null반환
	 */
	public LoginVO login(LoginVO loginVO) {
		
		//검색해서 나오는 값이 1개일때 기억할 그릇
		LoginVO userVO = null;
		
		//1.7버젼 트라이캐치문 autocloseable 포함하는 애들만 ()안에 써줄수 있음 사용하면 마지막에 close안해줘도 됨
		//stringbuilder는 ()안에 올수 없어서 위로 빼줌
		StringBuilder sql = new StringBuilder();
		sql.append("select id, password, type ");
		sql.append(" from tbl_member ");
		sql.append(" where id = ? and password = ? ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, loginVO.getId());
			pstmt.setString(2, loginVO.getPassword());
			
			ResultSet rs = pstmt.executeQuery();
			//나오는 값은 최소 0개에서 1개
			if(rs.next()) {
				userVO = new LoginVO();
				//String id = rs.getString("id");
				//userVO.setId(id);
				userVO.setId(rs.getString("id"));
				userVO.setPassword(rs.getString("password"));
				userVO.setType(rs.getString("type"));
			} 
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return userVO;
	}
}
