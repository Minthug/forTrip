package account.repository;


import account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

 List<Account> findByName(String name);

 Optional<Account> findByEmail(String email);

 boolean existsByEmail(String email);

}

