package kogan.brains.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import kogan.brains.api.UserData;
import kogan.brains.entities.Level;
import kogan.brains.entities.User;
import static kogan.brains.api.Tables.*;


public class UsersOrm {
	@PersistenceContext(unitName = "springHibernate")
	EntityManager em;
	
	@Transactional
	public boolean addUser(UserData userData) {
		
		String queryText = "select * from " + USERS + " where email = " + "'" + userData.email + "'";
		Query query = em.createNativeQuery(queryText, User.class);
		@SuppressWarnings("unchecked")
		List<User> userList = (List<User>) query.getResultList();
		
		if (em.find(User.class, userData.username) != null || userList.size() > 0)
			return false;
		else {
		
			em.persist(new User(userData.username, userData.email, userData.password, userData.token, new Level(userData.levelNumber), userData.score,
					userData.userStatus));
			return true;
		}
	}

	public User getUserByUsername(UserData userData) {
		return em.find(User.class, userData.username);
	}

	public User getUserByEmail(UserData userData) {
		
		String queryText = "select * from " + USERS + " where email = " + "'" + userData.email + "'";
		Query query = em.createNativeQuery(queryText, User.class);
		@SuppressWarnings("unchecked")
		List<User> userList = (List<User>) query.getResultList();
		
		if (userList.size() > 0) {
			return userList.get(0);
		} else {
			return null;
		}
	}
	
	public boolean checkPassword(UserData userData) {
		User user = getUserByUsername(userData);
		if (user != null) {
			if ((userData.password).equals(user.getPassword())){
				return true;
			} else {
				return false;
			}
		} else {
			user = getUserByEmail(userData);
			if (user != null) {
				if ((userData.password).equals(user.getPassword())){
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
	}
	
	public Level[] getLevels(){
		
		String queryText = "select * from " + LEVELS;
		Query query = em.createNativeQuery(queryText, User.class);
		@SuppressWarnings("unchecked")
		List<Level> levelsList = (List<Level>) query.getResultList();
		
		return (Level[]) levelsList.toArray();
	}
	
	@Transactional
	public boolean createAllTables() {
		
		String queryText = "CREATE TABLE "+ "users" + 
			      " (username varchar(255) not null PRIMARY KEY, " +    
			      "email varchar(255), " +
			      "password varchar(255) " +
			      ")";
		Query query = em.createNativeQuery(queryText);
		query.executeUpdate();
				
		return true;
		
	}

}
