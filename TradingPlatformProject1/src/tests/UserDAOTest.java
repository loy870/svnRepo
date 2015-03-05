package tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import dao.UserDAO;
import dto.UserDTO;
import exceptions.NoUserException;


public class UserDAOTest {
	
	@Mock UserDTO user1, user2, user3;
	UserDAO userdao = new UserDAO();

	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		when(user1.getUsername()).thenReturn("Zvi");
		when(user1.getPassword()).thenReturn("p1");
		
		when(user2.getUsername()).thenReturn("antonio");
		when(user2.getPassword()).thenReturn("p2");
		
	
	}
	
	@Test
	public void TestReadUser() throws NoUserException{
		userdao.create(user1);
		UserDTO newuser = userdao.read("Zvi");
		assertTrue(newuser.equals(user1));
	}
	
//	@Test
//	public void TestCreateUserWorks(){
//		userdao.create(user1);
//	}
	
	
	
	@Test
	public void TestUpdateUser() throws NoUserException{
		userdao.create(user1);
		userdao.update(user1, user2);
		assertTrue(userdao.read("antonio").equals(user2));
	}
	
	@Test
	public void TestDeleteUser() throws NoUserException{
		userdao.create(user1);
		userdao.delete("Zvi");
//		assertTrue(userdao.read("Zvi")==null);
//		System.out.println("feafaef"+ UserDAO.userList.get(0));
	}
	

}
