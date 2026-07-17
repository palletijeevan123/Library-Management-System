package dao;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;

import Connect.*;
import java.sql.Date;
public class Operations {
	
	public void insert(int bid,String title,String author,int copies)  {
		Connection c= DBConnection.getConnection();
		try {
		PreparedStatement ps=c.prepareStatement("insert into book values(?,?,?,?)");
		ps.setInt(1, bid);
		ps.setString(2, title);
		ps.setString(3, author);
		ps.setInt(4, copies);
		ps.executeUpdate();
		
		ps.close();
		c.close();
		}
		
//		catch(InputMismatchException e1) {
//			System.out.println("enter id only");
//		}
		catch(SQLException e) {
			System.out.println("failed to insertion");
			
		}

		
	}
	public void update(int bid,String title,String author) throws SQLException {
		Connection c= DBConnection.getConnection();
		try {
		PreparedStatement ps=c.prepareStatement("update book  set title=?,author=? where book_id=? ");
		ps.setString(1, title);
		ps.setString(2, author);
		ps.setInt(3, bid);
		int row=ps.executeUpdate();
		if(row==0) {
			throw new SQLException("Student ID "+bid+" not found");
		}
		ps.close();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		c.close();
	}
	public void delete(int bid) throws SQLException {
		Connection c=DBConnection.getConnection();
		try {
		PreparedStatement ps=c.prepareStatement("delete from book where book_id=?");
		ps.setInt(1,bid);
		int row=ps.executeUpdate();
		if(row==0) {
			throw new SQLException("Student ID "+bid+" not found");
			
		}
		ps.close();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		c.close();
	}
	public void fetch() throws SQLException {
		Connection c=DBConnection.getConnection();
		Statement s=c.createStatement();
		ResultSet rs=s.executeQuery("select * from book");
		while(rs.next()) {
			try {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
				
			}
			catch(Throwable e) {
				System.out.println("Error pleas check the queries");
				break;
			}
		}
		s.close();
		c.close();
		
		
	}
	public void sInsert(int sid,String sname,String phone) throws SQLException {
		Connection c=DBConnection.getConnection();
		try {
		PreparedStatement ps=c.prepareStatement("insert into student values(?,?,?)");
		ps.setInt(1, sid);
		ps.setString(2, sname);
		ps.setString(3, phone);
		ps.executeUpdate();
		ps.close();
		}
		catch(SQLException e) {
			System.out.println("failed to insertion");
			
		}
		c.close();
		
	}
	public void sUpdate(int sid, String phone) throws SQLException {
		Connection c=DBConnection.getConnection();
		try {
		PreparedStatement ps=c.prepareStatement("update student set phone=? where student_id=?");
		ps.setString(1, phone);
		ps.setInt(2, sid);
		ps.executeUpdate();
		ps.close();
		}
		catch(SQLException e) {
			System.out.println("failed to update");
			
		}
		c.close();
		
	}
	public void sDelete(int sid) throws SQLException {
		Connection c=DBConnection.getConnection();
		try {
		PreparedStatement ps=c.prepareStatement("delete from student where student_id=?");
		ps.setInt(1, sid);
		int row=ps.executeUpdate();
		if(row==0) {
			throw new SQLException("Student ID "+sid+" not found");
		}
		System.out.println("Student delete successfully:");
		ps.close();
	}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	
		c.close();
	}
	public void sFetch() throws SQLException {
		Connection c=DBConnection.getConnection();
		PreparedStatement ps=c.prepareStatement("select * from student");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			try {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
			catch(Throwable e) {
				System.out.println("error please check query");
				
			}
		}
		ps.close();
		c.close();
	}
	public void isuInsert(int isid, int bid, int sid, String isdate, String redate) throws SQLException {
Connection c=DBConnection.getConnection();
try {
PreparedStatement ps=c.prepareStatement("insert into issuebook values(?,?,?,?,?)");
  ps.setInt(1, isid);
  ps.setInt(2,bid);
  ps.setInt(3,sid);
  ps.setDate(4,java.sql.Date.valueOf(isdate));
  ps.setDate(5,java.sql.Date.valueOf(redate));
  ps.executeUpdate();
  ps.close();
}
catch(SQLException e) {
	System.out.println("failed to insertion");
	
}
  c.close();
	}
	
	public  void isUpdate(int isid, String reisdate) throws SQLException {
		Connection c=DBConnection.getConnection();
		try {
		PreparedStatement ps=c.prepareStatement("update issuebook set issue_date=? where issue_Id=?");
		ps.setDate(1,java.sql.Date.valueOf(reisdate));
		ps.setInt(2,isid);
		ps.executeUpdate();
		ps.close();
		}
		catch(SQLException e) {
			System.out.println("failed to insertion");
			
		}
		c.close();
		
	}
	public void isDelete(String isdate) throws SQLException {
		Connection c=DBConnection.getConnection();
		try {
		PreparedStatement ps=c.prepareStatement("delete from issuebook where issue_date=?");
		ps.setDate(1,java.sql.Date.valueOf(isdate));
		ps.executeUpdate();
		ps.close();
		}
		catch(SQLException e) {
			System.out.println("failed to delete");
			
		}
		c.close();
	}
	public void isbookFetch() throws SQLException {
		Connection c=DBConnection.getConnection();
		PreparedStatement ps=c.prepareStatement("select * from issuebook");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			try {
				System.out.println(rs.getInt(1)+" "+rs.getInt(2)+" "+rs.getInt(3)+" "+rs.getString(4)+" "+rs.getString(5));
			}
			catch (SQLException e) {
			    e.printStackTrace();
			}
		}
		ps.close();
		c.close();
		
	}
	public void reuInsert(int isid, int bid, int sid, String isdate, String redate) throws SQLException {
		Connection c=DBConnection.getConnection();
		try {
		PreparedStatement ps=c.prepareStatement("insert into issuebook values(?,?,?,?,?)");
		  ps.setInt(1, isid);
		  ps.setInt(2,bid);
		  ps.setInt(3,sid);
		  ps.setDate(4,java.sql.Date.valueOf(isdate));
		  ps.setDate(5,java.sql.Date.valueOf(redate));
		  ps.executeUpdate();
		  ps.close();
		}
		catch(SQLException e) {
			System.out.println("failed to insertion of issuebook");
			
		}
		  c.close();
		
	}
	public void reUpdate(int isid, String redate) throws SQLException {
		Connection c=DBConnection.getConnection();
		try {
		PreparedStatement ps=c.prepareStatement("update issuebook set return_date=? where issue_Id=?");
		ps.setDate(1,java.sql.Date.valueOf(redate));
		ps.setInt(2,isid);
		ps.executeUpdate();
		ps.close();
		}
		catch(SQLException e) {
			System.out.println("failed to update issuebook");
			
		}
		c.close();
		
	}
	public void reDelete(String redate) throws SQLException {
		Connection c=DBConnection.getConnection();
		try {
		PreparedStatement ps=c.prepareStatement("delete from issuebook where return_date=?");
		ps.setDate(1,java.sql.Date.valueOf(redate));
		ps.executeUpdate();
		ps.close();
		}
		catch(SQLException e) {
			System.out.println("failed to delete ");
			
		}
		c.close();
		
	}
	public void rebookFetch() throws SQLException {
		Connection c=DBConnection.getConnection();
		PreparedStatement ps=c.prepareStatement("select b.book_id,b.title,s.return_date from book b join issuebook s on b.book_id=s.book_id;");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			try {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
			catch (SQLException e) {
			    e.printStackTrace();
			}
		}
		ps.close();
		c.close();
		
	}
	public void issuedateFetch() throws SQLException {
		Connection c=DBConnection.getConnection();
		PreparedStatement ps=c.prepareStatement("select s.issue_id, b.title,s.issue_date from book b join issuebook s on b.book_id=s.book_id;");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			try {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
			catch (InputMismatchException e) {
        	    System.out.println("Please enter valid credentials: ");
        	       
        	}
			catch(NumberFormatException e) {
			    System.out.println("Invalid choice. Enter a number.");
			}
		}
		ps.close();
		c.close();
		
		
	}
	
	
	
	
	
}
