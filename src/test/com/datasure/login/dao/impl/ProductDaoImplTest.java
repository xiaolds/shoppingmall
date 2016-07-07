package test.com.datasure.login.dao.impl;


import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.datasure.login.dao.ProductDao;
import com.datasure.login.dao.UserDao;
import com.datasure.login.domain.Product;
import com.datasure.login.domain.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test/config/spring_conf/applicationContext.xml")
@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=true)
@Transactional
public class ProductDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	public ProductDao productDao;
	@Autowired
	public UserDao userDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetProductFromShopcart() {
		System.out.println(productDao);
		User user = 
//			new User("xiaolds","Àî¶«Éý","xiaolds1225","xiao.lds@163.com",1);
			new User(1);

		List<Product> prdtList = productDao.getProductFromShopcart(user);
		System.out.println(prdtList.toString());
	}


}
