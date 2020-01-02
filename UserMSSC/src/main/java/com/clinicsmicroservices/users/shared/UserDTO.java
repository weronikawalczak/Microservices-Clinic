package com.clinicsmicroservices.users.shared;

import com.clinicsmicroservices.users.data.UserEntity;
import com.clinicsmicroservices.users.ui.model.AlbumResponseModel;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class UserDTO implements Serializable {

	private static final long serialVersionUID = 6634584373684104039L;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String userId;
	private String encryptedPassword;
	private List<AlbumResponseModel> albums;

}
