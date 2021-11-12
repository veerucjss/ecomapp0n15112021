package com.cjss.ecomapp.model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    public LoadDatabase() {
    }

    @Bean
    CommandLineRunner initDatabase(CustomerRepository repository) {
        return args -> {

            log.info("Preloading " + repository.save(new Customer("ramakrishna","nadendla","rk@gmail.com",
                    "8484234432 ","passwor234", new CustomerAddress("mpnagar","kkdpalli",524126,"AP","amaravathi"))));
            log.info("Preloading " + repository.save(new Customer("Srikanth","Banthu","srika@gmail.com",
                    "5684234432 ","passwor334", new CustomerAddress("npnagar","kukatpalli",524125,"AP","Amaravathi",true,false))));
        };
    }
}