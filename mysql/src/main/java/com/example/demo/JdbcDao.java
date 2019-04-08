package com.example.demo;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public String setDataSource() {
		int rowCount = this.jdbcTemplate.queryForObject("select count(*) from stu", Integer.class);
		System.out.println(rowCount);
		return rowCount+"";
	}
	public String demo2() {
		int countOfActorsNamedJoe = this.jdbcTemplate.queryForObject(
		        "select count(*) from stu where name = ?", Integer.class, "ls");
		System.out.println(countOfActorsNamedJoe);
		return null;
	}
	public String demo3() {
		String lastName = this.jdbcTemplate.queryForObject(
		        "select name from test3 where id = ?",
		        new Object[]{2}, String.class);
		System.out.println(lastName);
		return null;
	}
	public void demo4() {
		User user = this.jdbcTemplate.queryForObject(
		        "select id,name, age from test3 where id = ?",
		        new Object[]{2},
		        new RowMapper<User>() {
		            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		            	User user = new User();
		            	user.setId(rs.getInt("id"));
		            	user.setName(rs.getString("name"));
		            	user.setAge(rs.getInt("age"));
		                return user;
		            }
		        });
		System.out.println(user.toString());
	}
	public void demo5() {
		List<User> users=this.jdbcTemplate.query("select id,name,age from test3", 
				new RowMapper<User>() {
			public User mapRow(ResultSet rs, int rowNum)throws SQLException {
				User user=new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				return user;
			}
		});
		for(User us:users) {
			System.out.println(us.toString());
		}
	}
	public void demo6() {
		List<User> users=this.jdbcTemplate.query("select id,name,age from test3", new UserMapper());
		
		for(User us:users) {
			System.out.println(us.toString());
		}
	}
	public void insertUser(String name,int age) {
		this.jdbcTemplate.update(
				"insert into test3 (name,age) values(?,?)",
				name,age);
	}
	public void updateUser(String name,int id) {
		this.jdbcTemplate.update(
				"update test3 set name=? where id=?",
				name,id);
	}
	//----------------------------------------------------------
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	/*public void setDataSource(DataSource dataSource) {
	    this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}*/
	public int countOfActorsByFirstName(String name) {

	    String sql = "select count(*) from test3 where name = :name";

	    SqlParameterSource namedParameters = new MapSqlParameterSource("name", name); // this
	    
	    //Map<String, String> namedParameters1 = Collections.singletonMap("first_name", name); 

	    return this.namedParameterJdbcTemplate.queryForObject(sql, namedParameters, Integer.class);
	    
	}
	
	public int countOfActorsByFirstName1(String name,int age) {

	    String sql = "select count(*) from test3 where name = :name and age= :age";

	   // SqlParameterSource namedParameters = new MapSqlParameterSource("name", name); // this
	    
	   // SqlParameterSource namedParameters2 = new MapSqlParameterSource("age", age); // this
	    
	    Map<String, Object> namedParameters = new HashMap<>(); 
	    
	    namedParameters.put("name", name);
	    
	    namedParameters.put("age", age);
	    
	    return this.namedParameterJdbcTemplate.queryForObject(sql, namedParameters,  Integer.class);
	    
	}
	public int countOfActors(User exampleUser) { 

	    // notice how the named parameters match the properties of the above 'Actor' class
	    String sql = "select count(*) from test3 where name = :name and age = :age";

	    SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(exampleUser); // 这里

	    return this.namedParameterJdbcTemplate.queryForObject(sql, namedParameters, Integer.class);
	}
	
	/**
	 * 批量修改
	 */
	public void batchUpdate(int [] ids , String [] name) {
		jdbcTemplate.batchUpdate("update test3 set name = ? where id = ?",
				new BatchPreparedStatementSetter() {
					
					@Override
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						ps.setString(1, name[i]);
						ps.setInt(2, ids[i]);
						ps.execute();
					}
					
					@Override
					public int getBatchSize() {
						// TODO Auto-generated method stub
						return ids.length;
					}
				});
	}


	
	

}
