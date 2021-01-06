package netflixclone.NetflixAssignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class NetflixAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixAssignmentApplication.class, args);
	}

}
