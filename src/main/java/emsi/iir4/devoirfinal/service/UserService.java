package emsi.iir4.devoirfinal.service;


import emsi.iir4.devoirfinal.models.Role;
import emsi.iir4.devoirfinal.models.User;
import emsi.iir4.devoirfinal.repository.RoleRepository;
import emsi.iir4.devoirfinal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public void save(User user) {
		Role r= roleRepository.findByNom("USER");
		if (r==null)
		r=new Role("USER");
		user.setRoles(Arrays.asList(r));
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user= userRepository.findByUserName(username);
		if(user==null)
			throw new UsernameNotFoundException("Nom d'utilisateur ou mot de passe erroné");
		for (Role r: user.getRoles())
			System.out.println("Role: "+r.getNom());
		return new org.springframework.security.core.userdetails.User(user.getuserName(),user.getPassword() , user.getRoles().stream()
				.map(r ->new SimpleGrantedAuthority("Role_"+r.getNom())).collect(Collectors.toList()));
	}

	
}
