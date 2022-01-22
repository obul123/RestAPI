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

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class UserResouirce {

	@Autowired
	private DaoUser doa;

	/*
	 * 1. Retrieve All Users 
	 * 2. Retrieve One User
	 */

	// GET/users/
	@Operation(summary = "Get Users" , description = "Get  All users" , tags = "User Operations")
	@RequestMapping(method = RequestMethod.GET, path = "/users")
	public List<User> getAll() {
		return doa.getAll();
	}

	// GET/users/{id}
	@Operation(summary= " Get One user" , description = "Get One user ", tags = "User Operations")
	@RequestMapping(method = RequestMethod.GET, path = "/users/{id}")
	public User getOneuser(@PathVariable int id) {
		User unser = doa.GetOneUser(id);
		if (unser == null) {
				throw new UserNotFoundException("id -"+id);
		}
		return unser;
	}

	// POST/users
	@Operation(summary="Create user ",description="Create an user" , tags="User Operations")
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
	@Operation(summary="Delete a user ",description="Delete an user",tags="User Operations")
	@DeleteMapping(path="/users/{id}")
	public void DeleteUser(@PathVariable int id)
	{
		User user=doa.DeleteUserById(id);
		if(user==null)
		{
			throw new UserNotFoundException("id - "+id);
		}
	}
	
	@Operation(summary= "Update User" , description =" Delete User",tags = "User Operations")
	@RequestMapping(method=RequestMethod.PUT , path="/users/{id}")
	public User updateUser(@RequestBody User user,@PathVariable("id") int id)
	{
		User u=doa.UpdateUser(user,id);
		if(u==null)
		{
			throw new UserNotFoundException("id - "+id);
		}
		
		return u;
	}
}
