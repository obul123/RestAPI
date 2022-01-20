package com.spring.udemy.SpringRestFromUdemy.User;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResouirce {

	@Autowired
	private DaoUser doa;

	/*
	 * 1. Retrieve All Users 
	 * 2. Retrieve One User
	 */

	// GET/users/
	@RequestMapping(method = RequestMethod.GET, path = "/users")
	public List<User> getAll() {
		return doa.getAll();
	}

	// GET/users/{id}
	@RequestMapping(method = RequestMethod.GET, path = "/users/{id}")
	public User getOneuser(@PathVariable int id) {
		User unser = doa.GetOneUser(id);
		if (unser == null) {
				throw new UserNotFoundException("id -"+id);
		}
		return unser;
	}

	// POST/users
	@RequestMapping(method = RequestMethod.POST, path = "/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		/*
		 * if(user.getDob()==null ) { System.out.println("Print somehting 1"); throw new
		 * ValueNotFoundException("DOB is - "+user.getDob()); } if(user.getId()==null )
		 * { System.out.println("Print somehting 2 "); throw new
		 * ValueNotFoundException("Id is - "+user.getId()); } if( user.getName()==null )
		 * { System.out.println("Print somehting 3"); throw new
		 * ValueNotFoundException("Name is - "+user.getName()); }
		 */
		User savedUser = doa.createOne(user);
		/*
		 * 1.Return status as Created 
		 * 2.Return the location of the created user
		 * /users/{id} -- > id should be replaced by savedUser.getId()
		 */

		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}
	
	//Delete a user
	@DeleteMapping(path="/users/{id}")
	public void DeleteUser(@PathVariable int id)
	{
		User user=doa.DeleteUserById(id);
		if(user==null)
		{
			throw new UserNotFoundException("id - "+id);
		}
	}
	
}
