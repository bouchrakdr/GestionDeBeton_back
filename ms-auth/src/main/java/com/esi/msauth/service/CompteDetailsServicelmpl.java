package com.esi.msauth.service;

import com.esi.msauth.Repositories.CompteRepository;
import com.esi.msauth.entities.Compte;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

import static java.util.Collections.singletonList;

@AllArgsConstructor
@Service
public class CompteDetailsServicelmpl implements UserDetailsService{
    private final CompteRepository compteRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        Optional<Compte> userOptional = compteRepository.findByUsername(username);
        Compte compte = userOptional
                .orElseThrow(() -> new UsernameNotFoundException("No user " +
                        "Found with username : " + username));

        return new org.springframework.security
                .core.userdetails.User(compte.getUsername(), compte.getPassword(),
                compte.isEnabled(), true, true,
                true, getAuthorities(compte.getType()));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String role) {
        return singletonList(new SimpleGrantedAuthority(role));
    }
}
