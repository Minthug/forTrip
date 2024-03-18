package account.mapper;

import account.dto.AccountDto;
import account.entity.Account;
import global.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountMapper extends GenericMapper<AccountDto, Account> {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

}
