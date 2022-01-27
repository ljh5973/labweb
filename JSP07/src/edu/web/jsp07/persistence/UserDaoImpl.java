package edu.web.jsp07.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import static edu.web.jsp07.model.User.Entry.*;

import edu.web.jsp07.model.User;

public class UserDaoImpl implements UserDao{
	private DataSource ds;
	
	private static UserDaoImpl instance =null;
	
	private UserDaoImpl() {
		try {
			Context initContext = new InitialContext();
			Context envContext= (Context) initContext.lookup("java:comp/env");
			ds=(DataSource) envContext.lookup("jdbc/myoracle");
			
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public static UserDaoImpl getInstance() {
		
		if(instance==null) {
			instance=new UserDaoImpl();
		}
		return instance;
	}

	@Override
	public User checkSignIn(String id, String pw) {
		// argument로 전달받은 아이디/ 비밀번호와 일치하는 사용자 계정이 있는지 체크
		System.out.println("userDaoImpl.checkSignIn(id= "+ id+ ", pw= " + pw +") 호출~");
		
		User user = null;
		
		Connection conn=null;
		PreparedStatement pstmt= null;
		ResultSet rs=null;
		
		try {
			conn=ds.getConnection();
			pstmt=conn.prepareStatement(SQL_CHECK_SIGNIN);
			System.out.println(SQL_CHECK_SIGNIN);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs= pstmt.executeQuery();
			
			if(rs.next()) { // 아이디 패스워드가 일치하는 경우
				String userId=rs.getString(COL_USERID);
				String userPw=rs.getString(COL_PWD);
				String userEmail=rs.getString(COL_EMAIL);
				int userPoint=rs.getInt(COL_POINTS);
				user = new User(userId, userPw, userEmail, userPoint);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return user;
	}

}
