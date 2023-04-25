package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.CustomerDetails;
import com.example.demo.Service.javaservice;
@RestController
@RequestMapping("/customer")
public class javacon {
	@Autowired
	javaservice cum;
	
	@PostMapping("")
	public String create(@RequestBody CustomerDetails abc)
	{
		return cum.addCustomer(abc);
	}
	@GetMapping("")
	public List<CustomerDetails> read()
	{
		return cum.getCustomer();
	}
	@GetMapping("/{id}")
	public Optional<CustomerDetails>readById(@PathVariable int id)
	{
		return cum.getCustomerById(id);
		
	}
	@PutMapping("/put")
	public String upadate(@RequestBody CustomerDetails abc) 
	{
		return cum.updatecustomerdetails(abc);
	}
	
	@DeleteMapping("/delete")
	public String delete(@RequestParam("cid") int id)
	{
		cum.deleteByRequestParam(id);
		return "Deleted";
	}
}