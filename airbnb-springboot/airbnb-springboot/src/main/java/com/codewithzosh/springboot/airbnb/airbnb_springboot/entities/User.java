package com.codewithzosh.springboot.airbnb.airbnb_springboot.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	private String username;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String fullName;

	private String phoneNumber;

	@Column(nullable = false)
	private Boolean enabled = true;

	@OneToMany(mappedBy = "owner")
	private List<Property> properties;

	public User(String username2, String encryptedPassword, String email2, String fullName2, String phoneNumber2) {
		this.username = username2;
		this.password = encryptedPassword;
		this.email = email2;
		this.fullName = fullName2;
		this.phoneNumber = phoneNumber2;
	}

//	@OneToMany(mappedBy = "user")
//	private List<Review> reviews;
}
