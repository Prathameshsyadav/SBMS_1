package in.ashokit.config;

import org.springframework.batch.item.ItemProcessor;

import in.ashokit.entity.Customer;

public class CustomerProcessor implements ItemProcessor<Customer, Customer> {

	@Override
	public Customer process(Customer item) throws Exception {
		// TODO Auto-generated method stub
		
		//logic
		
		return item;
	}

}
