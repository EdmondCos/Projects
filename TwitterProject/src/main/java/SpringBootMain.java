import configuration.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@SpringBootApplication
@ComponentScan({"services", "dao", "controller", "configuration"})
@EnableJpaRepositories
@EntityScan("entities")
public class SpringBootMain {
    public static void main(String[] args) {

        SpringApplication.run(SpringBootMain.class, args);
    }
}
