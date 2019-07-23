package com.starter.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.starter.model.Customer;
import com.starter.repo.CustomerRepository;
import com.starter.service.ICustomerService;

@Service
public class CustomerServiceImpl
  implements ICustomerService {
	@Autowired
	private CustomerRepository repo;
	
	@Transactional
	public Integer saveCustomer(Customer c) {
		/*Customer c1=repo.save(c);
		Integer id=c1.getCustId();
		return id;*/
		return repo.save(c).getCustId();
	}
	
	@Transactional()
	public List<Customer> getAllCustomers() {
		return repo.findAll();
	}
	
	@Transactional()
	@Cacheable(value="cust-cache",key="#custId")
	public Customer getOneCustomer(Integer custId) {
		Optional<Customer> c= repo.findById(custId);
		if(c.isPresent()) {
			return c.get();
		}
		return null;
	}
	
	@Transactional
	@CacheEvict(value="cust-cache",key="#custId")
	public void deleteCustomer(Integer custId) {
		repo.deleteById(custId);
	}

	
	
}