package com.gl.cryptoAuthenticationApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gl.cryptoAuthenticationApplication.bean.Cryptouser;
import com.gl.cryptoAuthenticationApplication.dao.CryptouserRepository;

@Service
public class CryptouserService implements UserDetailsService {
	@Autowired
	private CryptouserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		return repository.findById(username).get();
	}
	public void save(Cryptouser users) {
		repository.save(users);

}
}
