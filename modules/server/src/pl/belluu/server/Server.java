package pl.belluu.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.belluu.server.configuration.hibernate.HibernateUtil;


@SpringBootApplication
@EntityScan
@EnableJpaRepositories
public class Server {

    public static void main(String[] args) {
        ConfigurableApplicationContext startServer = SpringApplication.run(Server.class, args);

            HibernateUtil.getSessionFactory();
        }
    }

