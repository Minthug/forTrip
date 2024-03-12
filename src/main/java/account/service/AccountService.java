package account.service;

import account.dto.AccountUpdateDto;
import account.entity.Account;
import global.advice.BusinessLogicException;
import global.exceptionCode.ExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import account.repository.AccountRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountUpdateDto accountUpdateDto;

//    @Transactional
//    public Long join(Account account) {
//        validateDuplicateAccount(account);
//            accountRepository.save(account);
//            return account.getId();
//
//    }

    //Exception
//    private void validateDuplicateAccount(Account account) {
//        List<Account> findAccount = accountRepository.findByName(account.getName());
//        if(!findAccount.isEmpty()) {
//            throw new IllegalStateException("This member already exists.");
//        }
//    }

    // View all members
    public List<Account> findAccount() {
        return accountRepository.findAll();
    }

    // View member
    public Account findOne(Long accountId) {
        return accountRepository.findById(accountId).get();
    }

    // Edit Member
    @Transactional
    public Account update(AccountUpdateDto accountUpdateDto, Long id) {
        Account account = accountRepository.findById(id).get();
        return account.updateAccount(accountUpdateDto);
    }

    @Transactional
    public void removeAccount(Account findAccount) {
        accountRepository.delete(findAccount);
    }

    public void verifyEmailExist(String email) {
        Optional<Account> optionalAccount = accountRepository.findByEmail(email);

        if(optionalAccount.isPresent()) {
            throw new BusinessLogicException(ExceptionCode.ACCOUNT_EXIST);
        }
    }

    public void verifyAuthority(Account findAccount, Long loginAccountId) {
        if(!findAccount.getId().equals(loginAccountId)) {
            throw new BusinessLogicException(ExceptionCode.NOT_FOUND_ACCOUNT);
        }
    }
}
