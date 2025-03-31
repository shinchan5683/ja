import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@SpringBootApplication
@RestController
public class S10A1 {
    @GetMapping("/")
    public String showDate() {
        return "Current Date: " + LocalDate.now();
    }

    public static void main(String[] args) {
        SpringApplication.run(S10A1.class, args);
    }
}

