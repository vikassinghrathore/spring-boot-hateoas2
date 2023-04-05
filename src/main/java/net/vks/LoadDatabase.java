package net.vks;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.vks.account.Account;
import net.vks.account.AccountRepository;

@Configuration
public class LoadDatabase {
	private AccountRepository accountRepo;
	public LoadDatabase(AccountRepository accountRepo) {
		this.accountRepo = accountRepo;
	}
	@Bean
	public CommandLineRunner initDatabase() {
		return args -> {			
			Account account1 = new Account("19820801855", 1021.99f);
			Account account2 = new Account("19820321777", 231.50f);
			Account account3 = new Account("19820941288", 6211.00f);
			accountRepo.saveAll(List.of(account1, account2, account3));
			System.out.println("Sample database initialized.");
		};
	}
}
