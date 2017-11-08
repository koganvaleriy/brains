package kogan.herokuresttest.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import kogan.herokuresttest.api.AccountData;
import kogan.herokuresttest.entities.Account;

public class AccountsOrm {
	@PersistenceContext(unitName = "springHibernate")
	EntityManager em;
	
	@Transactional
	public boolean addAccount(AccountData accountData) {
		
		//createAllTables();

		if (em.find(Account.class, accountData.username) != null)
			return false;
		else {
			em.persist(new Account(accountData.username, accountData.email, accountData.password));
			return true;
		}
	}

	public Account getAccount(String username) {
		return em.find(Account.class, username);
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
