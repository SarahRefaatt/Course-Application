package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AppUser;
import com.example.demo.reposetory.AppUserReposetry;

@Service
public class UserService{
	@Autowired
	AppUserReposetry userreposetry;
	
	//@Autowired
	//PasswordEncoder passwordEncodeer;
	
	public void addAppUser(AppUser user) {
		
		//user.setPassword(passwordEncodeer.encode(user.getPassword()));
		userreposetry.save(user);
	}
	
	public AppUser getAppUser(Long id) {
		return userreposetry.findById(id).orElseThrow();
	}
	
	public void addAlluser(List<AppUser> user) {
		//user.setPassword(passwordEncodeer.encode(user.getPassword()));
		userreposetry.saveAll(user);
	}
	
	
	
	public List<AppUser> getAllAppUser() {
		return userreposetry.findAll();
	}
	
	public void updateAppUser(AppUser user) {
		AppUser current=userreposetry.findById(user.getId()).orElseThrow();
		
		current.setId(user.getId());
		current.setUserName(user.getUserName());
		current.setFullName(user.getFullName());
		current.setPassword(user.getPassword());
		userreposetry.save(current);

		
	}
	
	public void deleteById(Long id) {
		userreposetry.delete(userreposetry.findById(id).orElseThrow());
	}
	
	
	public List<AppUser> findByNameCont (String name){
		return userreposetry.findByUserNameContaining(name);
	}

	
	/*public List<Coursee> findByDescriptionCont(String des){
		return coursereposetry.findByDescriptionContaining(des);
	}

	public 	List<Coursee> findByNameAndEnrolledStudentsName(String name,String studfaculty){
		return coursereposetry.findByNameContainingAndEnrolledStudents_FacultyContaining(name,studfaculty);
	}
	
	
	public List<Coursee> lowPricee( double price){
		return coursereposetry.lowPrice(price);
	}
*/
	/*@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		
		Optional<AppUser> user=userreposetry.findByUserName(username);
		
		if(!user.isPresent()) {
			
			throw new UsernameNotFoundException("there is no user with"+username);
		}
		
		//return new User(user.get().getUserName(),user.get().getPassword(),getAutherities(user.get()));
		return new AppUserDetail(user.get());
		
	}

	
	private static  List<GrantedAuthority> getAutherities(AppUser user) {
		
		List<GrantedAuthority> auth=new ArrayList<>();
		
		if(!user.getRoles().isEmpty())
		{
			user.getRoles().forEach(role->{
				auth.add(new SimpleGrantedAuthority(role.getRoleName()));
			});
		}
		// TODO Auto-generated method stub
		return auth;
	}*/

	

}
