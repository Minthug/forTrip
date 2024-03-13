package account.mapper;

import account.dto.JoinDto;
import account.entity.Account;
import global.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface JoinMapper extends GenericMapper<JoinDto, Account> {
   JoinMapper INSTANCE = Mappers.getMapper(JoinMapper.class);
}
