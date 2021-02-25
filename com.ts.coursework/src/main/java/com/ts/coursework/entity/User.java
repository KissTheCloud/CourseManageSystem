package com.ts.coursework.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Administrator
 *
 */
public class User implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String password;
	private boolean enabled;
	private boolean locked;
	private List<Role> roles;
	private String realName;
	private String phone;
	private int age;
	private String sex;
	
	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
	}

	
	@Override
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password=password;
	}

	@Override
	public String getUsername() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return !this.locked;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.enabled;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id=id;
	}
	
	public void setRoles(List<Role> roles) {
		this.roles=roles;
	}
	
	@JsonIgnore
	public List<Role> getRoles(){
		return this.roles;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public String getRealName() {
		return realName;
	}


	public void setRealName(String realName) {
		this.realName = realName;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getName() {
		return name;
	}
}
