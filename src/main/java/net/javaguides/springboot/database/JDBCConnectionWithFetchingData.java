package net.javaguides.springboot.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCConnectionWithFetchingData {
	static Connection con;
	static java.sql.Statement stmt;

	public static void main(String[] args) {
		try {
			System.out.println("Enter the id to fetch data:");
			Scanner sc=new Scanner(System.in);
			int n=sc.nextInt();
			getEmployeeById(n);
		} 
		catch(IdNotFoundException e) {
			System.out.println(e);
		}
		catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}}
		public static void databaseConnection() throws SQLException {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_1", "root", "ssrpknt");
		}

		public static void closeConnection() throws SQLException {
			if (con != null || stmt != null) {
				con.close();
				stmt.close();
			}
		}

		public static void getEmployeeById(int id) throws Exception {
			databaseConnection();
			stmt = con.createStatement();
			ResultSet result = stmt.executeQuery("select * from employee1 where id='" + id + "'");
			boolean flag = false;
			while (result.next()) {
				flag = true;
				System.out.print(result.getInt(1) + " " + result.getString(2) + " " + result.getLong(3) + "\n");

			}

			if (flag == false) {
				throw new IdNotFoundException("No such Id present in the database!");
			}
			closeConnection();

		}

	}

