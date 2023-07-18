package com.gl.cryptoAuthenticationApplication.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.cryptoAuthenticationApplication.bean.Cryptouser;
 
@Repository
public interface CryptouserRepository extends JpaRepository<Cryptouser, String> {
	Optional<Cryptouser> findUserByUsername(String username);
}