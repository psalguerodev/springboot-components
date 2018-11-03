package com.psalguero.rest.webservices.springbootrestwebservices.beans;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Modelo de prueba de usuario - documentando con swagger2")
public class User {
	private Integer id;
	
	@Size(max=20, min=10, message="Name should have atleast 2 characters")
	@ApiModelProperty(notes="Propiedad donde se describe el nombre del Usuario")
	private String name;
	
	@Past
	private Date birthDate;

	public User(Integer id, String name, Date birthDate) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, birthDate=%s]", id, name, birthDate);
	}

}
