package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.dto;

public class dao {

PreparedStatement pstmt;
ResultSet rs;
Connection con;
	
    public dao() {
    	try {
    	 con = getConnection();
    	 System.out.println("db연결성공");
    	}catch(Exception e) {
    		e.printStackTrace();
    		System.out.println("db연결실패");
    	}
    }
    public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@//localhost:1521/xe","PSH_JAVA","1111");
    	return con;   	
    }
    
	public int nextCno() {
		String sql = "SELECT MAX(CUSTNO) FROM MEMBER_TBL_02";
		int nextCno = 0;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				nextCno = rs.getInt("MAX(CUSTNO)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nextCno;
	}
	public int memberJoin(dto dto) {
		String sql = "INSERT INTO MEMBER_TBL_02 VALUES(?,?,?,?,?,?,?)";
		int joinResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,dto.getCustno());
			pstmt.setString(2,dto.getCustname());
			pstmt.setString(3,dto.getPhone());
			pstmt.setString(4,dto.getAddress());
			pstmt.setString(5,dto.getJoindate());
			pstmt.setString(6,dto.getGrade());
			pstmt.setString(7,dto.getCity());
			joinResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return joinResult;
	}
	public ArrayList<dto> memberList() {
		String sql = "SELECT * FROM MEMBER_TBL_02";
		ArrayList<dto> memberList = new ArrayList<dto>();
		dto member = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				member = new dto();
				member.setCustno(rs.getInt(1));
				member.setCustname(rs.getString(2));
				member.setPhone(rs.getString(3));
				member.setAddress(rs.getString(4));
				String joindate = rs.getString(5).substring(0,10);			
				member.setJoindate(joindate);
				String grade = rs.getString(6);
				if(grade.equals("A")) {
					grade = "VIP";
				}else if(grade.equals("B")) {
					grade = "일반";
				}else if(grade.equals("C")) {
					grade = "직원";
				}
				member.setGrade(grade);
				member.setCity(rs.getString(7));
				memberList.add(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return memberList;
	}
	public dto memberView(int custno) {
		String sql = "SELECT * FROM MEMBER_TBL_02 WHERE CUSTNO = ?";
		dto memberView = new dto();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,custno);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				memberView.setCustno(rs.getInt(1));
				memberView.setCustname(rs.getString(2));
				memberView.setPhone(rs.getString(3));
				memberView.setAddress(rs.getString(4));
				String joindate = rs.getString(5).substring(0,10);
				memberView.setJoindate(joindate);
				memberView.setGrade(rs.getString(6));
				memberView.setCity(rs.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(NullPointerException e) {
			e.printStackTrace();
		}
		
		return memberView;
	}
	public int memberUpdate(dto memberUpdate) {
		String sql = "UPDATE MEMBER_TBL_02 SET CUSTNAME=?,PHONE=?,ADDRESS=?,JOINDATE=?,GRADE=?,CITY=? WHERE CUSTNO = ?";
		int updateResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,memberUpdate.getCustname());
			pstmt.setString(2,memberUpdate.getPhone());
			pstmt.setString(3,memberUpdate.getAddress());
			pstmt.setString(4,memberUpdate.getJoindate());
			pstmt.setString(5,memberUpdate.getGrade());
			pstmt.setString(6,memberUpdate.getCity());
			pstmt.setInt(7,memberUpdate.getCustno());
			updateResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updateResult;
	}
	public ArrayList<dto> moneyList() {
		String sql = "SELECT A.CUSTNO,A.CUSTNAME,A.GRADE,SUM(B.PRICE) AS TOTAL FROM MEMBER_TBL_02 A JOIN MONEY_TBL_02 B ON A.CUSTNO = B.CUSTNO GROUP BY(A.CUSTNO , A.CUSTNAME , A.GRADE) ORDER BY TOTAL DESC";
		ArrayList<dto> moneyList = new ArrayList<dto>();
		dto money = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				money = new dto();
				money.setCustno(rs.getInt(1));
				money.setCustname(rs.getString(2));
				money.setGrade(rs.getString(3));
				money.setPrice(rs.getString(4));
				moneyList.add(money);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		return moneyList;
	}

}
