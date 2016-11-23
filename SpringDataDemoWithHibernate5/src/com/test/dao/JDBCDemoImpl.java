package com.test.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.test.model.Circle;

@Component
public class JDBCDemoImpl {

	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate = new JdbcTemplate();

	private NamedParameterJdbcTemplate namedParameterJDBCTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {

		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedParameterJDBCTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public int getCircleCount() {

		String sql = "select count(*) from circle";
		// jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.queryForObject(sql, Integer.class);

	}

	/*
	 * public Circle getCircle(int circleId) {
	 * 
	 * Connection conn = null; Circle circle = null; try {
	 * 
	 * conn = dataSource.getConnection(); PreparedStatement ps =
	 * conn.prepareStatement("select * from circle where id = ?"); ps.setInt(1,
	 * circleId);
	 * 
	 * ResultSet rs = ps.executeQuery();
	 * 
	 * if (rs.next()) {
	 * 
	 * circle = new Circle(circleId, rs.getString("name"));
	 * 
	 * } rs.close(); ps.close(); return circle; } catch (SQLException e) {
	 * 
	 * // System.out.println(e.getMessage()); throw new RuntimeException(); }
	 * 
	 * finally { try { conn.close(); } catch (SQLException e) {
	 * 
	 * e.printStackTrace(); } }
	 * 
	 * }
	 */

	public Circle getCircleForId(int circleId) {

		String sql = "select * from circle where id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { circleId }, new CircleMapper());

	}

	private static final class CircleMapper implements RowMapper<Circle> {

		@Override
		public Circle mapRow(ResultSet resultSet, int rowNum) throws SQLException {

			System.out.println("rowNum=" + rowNum);

			Circle circle = new Circle();
			circle.setRadius(resultSet.getInt("id"));
			circle.setName(resultSet.getString("name"));

			return circle;
		}

	}

	public List<Circle> getAllCircle() {

		List<Circle> list = new ArrayList<Circle>();

		String sql = "select * from circle";
		list = jdbcTemplate.query(sql, new CircleMapper());

		System.out.println(list.size());

		return list;

	}

	public void insertCircle(Circle circle) {

		String sql = "insert into circle values (? , ?)";

		jdbcTemplate.update(sql, new Object[] { circle.getRadius(), circle.getName() });
		getAllCircle();

	}

	public void insertCircleNamedParam(Circle circle) {

		String sql = "insert into circle values (:id , :name)";

		SqlParameterSource namedParameter = new MapSqlParameterSource("id", circle.getRadius()).addValue("name",
				circle.getName());

		namedParameterJDBCTemplate.update(sql, namedParameter);

	}

}
