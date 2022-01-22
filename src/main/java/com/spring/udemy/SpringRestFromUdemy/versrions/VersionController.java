package com.spring.udemy.SpringRestFromUdemy.versrions;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {

	//URI versioning
	@GetMapping("/version1")
	public PesronVersion1 person1() {
		return new PesronVersion1("obul");
	}

	@GetMapping("/version2")
	public PersonVersion2 person2() {
		return new PersonVersion2(new Name("obul", "REddy"));
	}
	
	// Parameter versioning
//	@GetMapping(value="/param" , params ="version=1")
//	public PesronVersion1 paraperson1() {
//		return new PesronVersion1("obul");
//	}
//
//	@GetMapping(value="/param", params ="version=2")
//	public PersonVersion2 paraperson2() {
//		return new PersonVersion2(new Name("obul", "Reddy"));
//	}
//	
//	// Heasder versioning
//		@GetMapping(value="/param" , headers ="X-API=1")
//		public PesronVersion1 headperson1() {
//			return new PesronVersion1("obul");
//		}
//
//		@GetMapping(value="/param", headers ="X-API=2")
//		public PersonVersion2 headperson2() {
//			return new PersonVersion2(new Name("obul", "Reddy"));
//		}

}
