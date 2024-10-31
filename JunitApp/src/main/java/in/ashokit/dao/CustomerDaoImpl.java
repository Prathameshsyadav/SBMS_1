package in.ashokit.dao;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Override
	public String findNameById(Integer id) {
		// TODO Auto-generated method stub
		return "John";
	}

}
