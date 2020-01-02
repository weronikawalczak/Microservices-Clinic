package com.clinicsmicroservices.users.ui.model;

import lombok.Data;

import java.util.List;

@Data
public class UserResponseModel {
	private String userId;
	private String firstName;
	private String lastName;
	private String email;
	private List<AlbumResponseModel> albums;
}
