package basicProject.javaSpring;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaSpringApplication implements CommandLineRunner {
	@Autowired
	Apple obj;

	@Autowired
	private DbService db;

	public static void main(String[] args) {

		SpringApplication.run(JavaSpringApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
//		obj.eatApple();
//		System.out.println(obj.hashCode());
		System.out.println(db.getData());

	}

}
