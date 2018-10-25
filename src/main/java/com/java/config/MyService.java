/*package com.java.config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component("myService")
public class MyService implements UserDetailsService {

	@Autowired
	private DataSource ds;

	@Override
	public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
		try {
			Connection c = ds.getConnection();
			PreparedStatement st = c
					.prepareStatement("select u.emailId, u.password , r.rolename from userInfo u, roles r"
							+ " where u.emailId = r.emailId and u.emailId= ?");
			st.setString(1, emailId);
			ResultSet rs = st.executeQuery();
			List<String> roles = new ArrayList<>();
			String password = null;
			while (rs.next()) {
				password = rs.getString("password");
				roles.add(rs.getString("rolename"));
			}
			if (password == null) {
				throw new UsernameNotFoundException("Invalid emailId or password!!");
			}
			return new User(emailId, password, true, true, true, true,
					roles.stream().map(x -> new SimpleGrantedAuthority(x)).collect(Collectors.toList()));
		} catch (SQLException e) {
			throw new RuntimeException("Unable to authenticate user, try after some time!" + e.getMessage());
		}

	}

}
*/