package hoop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan(value = "hoop.Mappers")
@EnableScheduling
public class HoopApplication {

    public static void main(String[] args) {
        SpringApplication.run(HoopApplication.class, args);
    }

}
