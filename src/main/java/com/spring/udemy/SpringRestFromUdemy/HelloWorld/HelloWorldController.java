package com.spring.udemy.SpringRestFromUdemy.HelloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	//@RequestMapping(method = RequestMethod.GET , path = "/helloworld")
	@GetMapping(path="/hello-world")
	public String helloWorld()
	{
		return "Hello World";
	}
	
	@GetMapping("/hello-world-bean")
	public HelloWorldMessage helloWorldBean()
	{
		return new HelloWorldMessage("message");
	}
	
	///hello-world/path-variable/Obulreddy
	@GetMapping(path="/hello-world/path-variable/{name}")
	public HelloWorldMessage helloWorldBeanPathVariable(@PathVariable String name)
	{
		return new HelloWorldMessage("message from "+name);
	}

}
