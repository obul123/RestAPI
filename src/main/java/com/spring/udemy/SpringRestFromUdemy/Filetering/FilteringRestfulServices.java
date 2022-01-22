package com.spring.udemy.SpringRestFromUdemy.Filetering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringRestfulServices {
	
	@RequestMapping(method=RequestMethod.GET,path="/beans")
	public MappingJacksonValue filterBean()
	{
		SomeBean someBean=new SomeBean("val1","val2","val3");
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("val1","val2");
		FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		MappingJacksonValue mapping =new MappingJacksonValue(someBean);
		mapping.setFilters(filters);
		return mapping;
	}
	
	@RequestMapping(method=RequestMethod.GET,path="/beans-list")
	public MappingJacksonValue filterBeanlist()
	{
		List<SomeBean> someBean= Arrays.asList(new SomeBean("val1","val2","val3"),new SomeBean("val11","val22","val33"));
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("val1","val3");
		FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		MappingJacksonValue mapping =new MappingJacksonValue(someBean);
		mapping.setFilters(filters);
		return mapping;
	}

}
