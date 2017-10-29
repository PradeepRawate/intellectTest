package com.intellect.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String fname;
	private String lname;
	private String email;
	private Integer pinCode;
	private Date birthDate;
	private Boolean isActive;
}
