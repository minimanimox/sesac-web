package kr.co.mlec.board.dao;

import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.util.ConnectionFactory;
import kr.co.mlec.util.JDBCClose;

/**
* �쉶�썝 DB(tbl_member) CRUD
* @author user
*
*
*/

public class UserDAO {

/*
 * 회원가입
 */

	public void signUp(UserVO user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
			
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("update tbl_member ");
			sql.append(" set id = ?, name = ?, password = ?, ");
			sql.append(" set email_id = ?, email_domain = ?, ");
			sql.append(" set tel1 = ?, tel2 = ?, tel3 = ?, ");
			sql.append(" set post = ?, basic_addr = ?, detail_addr = ? ");
			   
			   
			pstmt =conn.prepareStatement(sql.toString());
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmailId());
			pstmt.setInt(4, user.getEmailDomain());
			pstmt.setInt(5, user.getTel1());
			pstmt.setInt(6, user.getTel2());
			pstmt.setInt(7, user.getTel3());
			pstmt.setInt(8, user.getPost());
			pstmt.setInt(9, user.getBasicAddr());
			pstmt.setInt(10, user.getDetailAddr());
			pstmt.executeUpdate();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		

	}
	
/*
* �쉶�썝 媛��엯
*/	

	
/*
 * �쉶�썝 �젙蹂� �닔�젙
 */
	
}
