package ro.fasttrackit.curs21;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.fasttrackit.curs21.model.Account;
import ro.fasttrackit.curs21.model.Category;
import ro.fasttrackit.curs21.model.Label;
import ro.fasttrackit.curs21.model.Transaction;
import ro.fasttrackit.curs21.repository.AccountRepository;
import ro.fasttrackit.curs21.repository.LabelRepository;
import ro.fasttrackit.curs21.repository.TransactionRepository;

import java.util.List;

import static ro.fasttrackit.curs21.model.Type.BUY;
import static ro.fasttrackit.curs21.model.Type.SELL;

@SpringBootApplication
public class Curs21Application {

    public static void main(String[] args) {
        SpringApplication.run(Curs21Application.class, args);
    }

    @Bean
    CommandLineRunner atStartup(
            TransactionRepository repo,
            AccountRepository accountRepository,
            LabelRepository labelRepository) {
        return args -> {
            Account electronics = accountRepository.save(new Account("electronics"));
            Account food = accountRepository.save(new Account("food"));
            Account transport = accountRepository.save(new Account("transport"));

            Category personal = new Category("personal");
            Category foodCategory = new Category("food");
            Category entertainment = new Category("entertainment");

            Label christmas = labelRepository.save(new Label("christmas"));
            Label lenovo = labelRepository.save(new Label("lenovo"));
            Label gift = labelRepository.save(new Label("gift"));
            Label iPhone = labelRepository.save(new Label("iPhone"));

            repo.saveAll(List.of(
                    new Transaction("bread", BUY, 10, food, foodCategory),
                    new Transaction("car", SELL, 12000, transport, personal),
                    new Transaction("laptop", SELL, 1200, electronics, personal,
                            List.of(christmas, lenovo, gift)),
                    new Transaction("phone", BUY, 300, electronics, entertainment,
                            List.of(iPhone, gift, christmas))
            ));
        };
    }
}
