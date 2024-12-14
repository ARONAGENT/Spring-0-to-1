package basicProject.javaSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbService {

    // @Autowired
    // private DbInterface db;
    //instead we used Constructor Injection
    // dependencies are provide through class Constructor

    private DbInterface db;
   public DbService(DbInterface db){
      this.db=db;
   }

    String getData(){
        return db.getData();
    }
}
