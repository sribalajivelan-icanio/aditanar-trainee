package com.example.demo.controller;
import java.util.List;

import com.example.demo.model.User;
import com.example.demo.repository.Mongorepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("api/v1/")
@RestController
public class MyController {

	@Autowired
	private Mongorepo dao;
	
	public String Gmail;
	
	@PostMapping("signup")
	public String addUser(@RequestBody User ob)
	{
		if(!dao.existsByEmail(ob.getEmail()))
		{
			if (!dao.existsByUsername(ob.getUsername())) {
				dao.insert(ob);
			} else {
				return "Username Already Exist";
			}
			return "User created Successfully";
		} else {
			return "Email already Taken";
		}
	}
		
	@PutMapping("login")
	public String Login(@RequestBody User ob) {
		User ob1=dao.findByUsername(ob.getUsername());
		if(ob1 != null)
		{
			String Pass=ob.getPassword();
			if(Pass.equals(ob1.getPassword()))
				return "Login Successfully";
			else 
				return "Password incorrect"; 
		}
		else
		    return "User Not Found";
	}
	
	
	@GetMapping("checkEmail")
	public String check(@RequestParam("email") String Email)
	{
		User ob1=dao.findByEmail(Email);
		if(ob1 == null)
		{
			return "Email is Wrong Try Again";
		}
		else
		{
			Gmail=Email;
			return "Link The page of update Password";
		}
	}
	
	@GetMapping("userPasswordUpdate")
	public String update(@RequestBody User ob)
	{
		String cpass=ob.getCpassword();
		String pass=ob.getPassword();
		User ob1=dao.findByEmail(Gmail);
		if(pass.equals(cpass)) {
			ob1.setPassword(pass);
			dao.save(ob1);
			return "Password Update Successfully ";
		}
		return "confirm Password is wrong";
	}
		
	
	@GetMapping("greaterthan")	
	public List<User> great(@RequestParam("number") int num)
	{
		List <User> ob1=dao.findByAgeGreaterThan(num);
		return ob1;
	}
	
	@GetMapping("lessthan")	
	public List<User> less(@RequestParam("number") int num)
	{
		List <User> ob1=dao.findByAgeLessThan(num);
		return ob1;
	}
	
	@GetMapping("between")	
	public List<User> between(@RequestParam("from") int from, @RequestParam("to") int to)
	{
		List <User> ob1=dao.findByAgeBetween(from,to);
		return ob1;
	}
	
	@GetMapping("notNull")	
	public List<User> notNull()
	{
		List <User> ob1=dao.findByNameNotNull();
		return ob1;
	}
	
	@GetMapping("Null")	
	public List<User> Null()
	{
		List <User> ob1=dao.findByNameNull();
		return ob1;
	}
	
	
	@GetMapping("like")	
	public List<User> like(@RequestParam("name") String name)
	{
		List <User> ob1=dao.findByNameLike(name);
		return ob1;
	}
	
	@GetMapping("regex")	
	public List<User> regex(@RequestParam("name") String name)
	{
		List <User> ob1=dao.findByNameRegex(name);
		return ob1;
	}
	
	@GetMapping("not")	
	public List<User> not(@RequestParam("name") String name)
	{
		List <User> ob1=dao.findByNameNot(name);
		return ob1;
	}
	
	@GetMapping("and")
	public List<User> and(@RequestParam("name") String name, @RequestParam("age") int age)
	{
		List <User> ob1=dao.findByNameAndAge(name,age);
		return ob1;
	}
	
	@GetMapping("or")
	public List<User> or(@RequestParam("name") String name, @RequestParam("age") int age)
	{
		List <User> ob1=dao.findByNameOrAge(name,age);
		return ob1;
	}

}
