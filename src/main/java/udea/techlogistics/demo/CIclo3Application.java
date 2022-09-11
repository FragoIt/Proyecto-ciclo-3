package udea.techlogistics.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import udea.techlogistics.demo.entities.Enterprise;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@RestController
@SpringBootApplication(exclude ={SecurityAutoConfiguration.class})

public class CIclo3Application {

    @GetMapping("/init")
    public String init(){
    LocalDate hoy = LocalDate.now();
    LocalTime ahora = LocalTime.now();
    LocalDateTime fecha = LocalDateTime.of(hoy, ahora);
    Enterprise ent = new Enterprise("Acuarela", "2320124", "Calle 1 # 1-1"
    , fecha, fecha, "800-232");
    return ent.getEnterprise_name();
    }

    public static void main(String[] args) {
        SpringApplication.run(CIclo3Application.class, args);
    }

}
