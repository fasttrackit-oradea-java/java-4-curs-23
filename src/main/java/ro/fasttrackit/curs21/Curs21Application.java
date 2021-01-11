package ro.fasttrackit.curs21;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.fasttrackit.curs21.model.Account;
import ro.fasttrackit.curs21.model.Transaction;
import ro.fasttrackit.curs21.model.Type;
import ro.fasttrackit.curs21.repository.AccountRepository;
import ro.fasttrackit.curs21.repository.TransactionRepository;

import java.util.List;

@SpringBootApplication
public class Curs21Application {

    public static void main(String[] args) {
        SpringApplication.run(Curs21Application.class, args);
    }

    @Bean
    CommandLineRunner atStartup(
            TransactionRepository repo,
            AccountRepository accountRepository) {
        return args -> {
            Account electronics = accountRepository.save(new Account("electronics"));
            Account food = accountRepository.save(new Account("food"));
            Account transport = accountRepository.save(new Account("transport"));

            repo.saveAll(List.of(
                    new Transaction("bread", Type.BUY, 10, food),
                    new Transaction("car", Type.SELL, 12000, transport),
                    new Transaction("laptop", Type.SELL, 1200, electronics),
                    new Transaction("phone", Type.BUY, 300, electronics)
            ));
        };
    }
}
