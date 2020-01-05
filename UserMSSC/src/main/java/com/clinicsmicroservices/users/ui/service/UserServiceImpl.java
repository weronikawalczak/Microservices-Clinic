package com.clinicsmicroservices.users.ui.service;

import com.clinicsmicroservices.users.data.AlbumsServiceClient;
import com.clinicsmicroservices.users.data.UserEntity;
import com.clinicsmicroservices.users.data.UserRepository;
import com.clinicsmicroservices.users.shared.UserDTO;
import com.clinicsmicroservices.users.ui.model.AlbumResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

	UserRepository userRepository;
	BCryptPasswordEncoder bCryptPasswordEncoder;
	RestTemplate restTemplate;
	AlbumsServiceClient albumsServiceClient;

	@Autowired
	public UserServiceImpl(UserRepository userRepository,
	                       BCryptPasswordEncoder bCryptPasswordEncoder,
	                       RestTemplate restTemplate,
	                       AlbumsServiceClient albumsServiceClient) {
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.restTemplate = restTemplate;
		this.albumsServiceClient = albumsServiceClient;
	}

	@Override
	public UserDTO createUser(UserDTO userDetails) {
		userDetails.setUserId(UUID.randomUUID().toString());
		userDetails.setEncryptedPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class);

		userRepository.save(userEntity);

		return modelMapper.map(userEntity, UserDTO.class);
	}

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findByEmail(s);
		if(userEntity == null) throw new UsernameNotFoundException(s);
		return new User(
				userEntity.getEmail(),
				userEntity.getEncryptedPassword(),
				true,
				true,
				true,
				true,
				new ArrayList<>());
	}

	@Override
	public UserDTO getUserDetailsByEmail(String email) {
		UserEntity userEntity = userRepository.findByEmail(email);
		if(userEntity == null) throw new UsernameNotFoundException(email);
		return new ModelMapper().map(userEntity, UserDTO.class);
	}

	@Override
	public UserDTO getUserByUserId(String userId) {

		UserEntity userEntity = userRepository.findByUserId(userId);
		if(userEntity == null) throw new UsernameNotFoundException("User not found");
		UserDTO userDTO = new ModelMapper().map(userEntity, UserDTO.class);

		String albumsUrl = String.format("http://albums-ws/users/%s/albums", userId);

//		ResponseEntity<List<AlbumResponseModel>> albumsListResponse = restTemplate.exchange(
//				albumsUrl,
//				HttpMethod.GET,
//				null,
//				new ParameterizedTypeReference<List<AlbumResponseModel>>() {
//		});
//		List<AlbumResponseModel> albumsList = albumsListResponse.getBody();

		List<AlbumResponseModel> albumsList = albumsServiceClient.getAlbums(userId);

		userDTO.setAlbums(albumsList);

		return userDTO;
	}
}
