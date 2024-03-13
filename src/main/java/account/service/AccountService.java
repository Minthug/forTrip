package account.service;

import account.dto.AccountUpdateDto;
import account.dto.EmailCheckDto;
import account.entity.Account;
import global.advice.BusinessLogicException;
import global.exceptionCode.ExceptionCode;
import global.exceptionCode.NotFoundException;
import global.exceptionCode.UserNotFoundException;
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


    // View all members
    @Transactional(readOnly = true)
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Account findByEmail(String email) {
        return accountRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("Can't find user"));
    }

    // View member
    @Transactional(readOnly = true)
    public Account findById(Long accountId) {
        return accountRepository.findById(accountId).get();
    }

    // Edit Member
    @Transactional
    public Account update(AccountUpdateDto accountUpdateDto, Long id) {
        Account account = findById(id);
        return account.updateAccount(accountUpdateDto); //, passwordEncoder);
    }

    @Transactional
    public void completeSignUp(EmailCheckDto emailCheckDto) {
        Account account = findByEmail(emailCheckDto.getEmail());

        if (!account.isValidEmailCode(emailCheckDto.getCode())) {
            throw new NotFoundException("이메일 인증 코드가 틀립니다.");
        }
        account.completeSignUp();
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
