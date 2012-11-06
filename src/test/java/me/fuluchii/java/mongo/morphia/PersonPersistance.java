package me.fuluchii.java.mongo.morphia;

import static junit.framework.Assert.assertEquals;

import java.net.UnknownHostException;
import java.util.List;

import no.kh.mongo.direct.Person;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.query.Query;
import com.mongodb.Mongo;

public class PersonPersistance {
	
	private Datastore ds;
	
	
    @Before
    public void setUp() throws UnknownHostException {
       Mongo m = new Mongo( "127.0.0.1" , 27017 );
       Morphia morphia = new Morphia();
       morphia.map(Persion.class).map(Address.class);
       ds = morphia.createDatastore(m, "personDB");
       ds.ensureIndexes();
       ds.ensureCaps();
    }
    
    @Test
    public void insertPOJO(){
    	Address address = new Address("steet","200000","testpalce","china");
    	Persion p = new Persion("test-persion", address);
    	ds.save(p);
    }
    
    @Test
    public void queryPOJO(){
    	//use find
    	List<Persion> ps = ds.find(Persion.class).field("name").startsWith("test").asList();
    	assertEquals(ps.get(0).getName(), "test-persion");    
    	
    	//use query need class casting
    	Query query = ds.createQuery(Persion.class).filter("name =", "test-persion");
    	Persion p2 = (Persion) query.asList().get(0);
    	assertEquals(p2.getAddress().getStreetName(), "steet");	
    }
    
    @Test
    public void atomicFindAndDelete(){
    	Persion p = ds.findAndDelete( ds.createQuery(Persion.class).filter("name =", "test-persion"));
    	assertEquals(p.getAddress().getStreetName(), "steet");
    }
    
    @After
    public void tearDown(){
//    	ds.delete(ds.createQuery(Persion.class).field("name").startsWith("test").asList());
    }
}
