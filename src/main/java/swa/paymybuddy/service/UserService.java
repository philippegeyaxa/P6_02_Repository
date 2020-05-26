package swa.paymybuddy.service;

import swa.paymybuddy.model.User;
import swa.paymybuddy.service.exception.InvalidSocialNetworkCodeException;
import swa.paymybuddy.service.exception.NoAuthenticatedUserException;

public interface UserService {
	
	User getUserByEmail(String email);
	
	User getAuthenticatedUser() throws NoAuthenticatedUserException;
	
	User registerUserInternal(User user);

	User registerUserSocialNetwork(User user) throws InvalidSocialNetworkCodeException;
}
