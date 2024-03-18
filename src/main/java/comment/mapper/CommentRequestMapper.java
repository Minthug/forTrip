package comment.mapper;

import comment.dto.CommentReqDto;
import comment.entity.Comment;
import global.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentRequestMapper extends GenericMapper<CommentReqDto, Comment> {

   CommentRequestMapper INSTANCE = Mappers.getMapper(CommentRequestMapper.class);
   
}
