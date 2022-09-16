package qi.shen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("qi.shen.dao")
public class CustomApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomApplication.class, args);
    }

}
