package io.amanproject.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.amanproject.entities.Response;
import io.amanproject.entities.User;
import io.amanproject.repositories.ResponseRepository;

@Service
public class ResponseService {

	@Autowired
	private ResponseRepository responseRepository;
	
	public void addResponse(Response response, User user) {
		response.setUser(user);
		responseRepository.save(response);
	}
	
	public List<Response> findUserResponse(User user){
		return responseRepository.findByUser(user);
	}

	public void addResponse1(@Valid Response response) {
		// TODO Auto-generated method stub
		responseRepository.save(response);
	}
}

