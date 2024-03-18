package article.mapper;

import article.dto.ArticleReqDto;
import article.entity.Article;
import global.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ArticleReqMapper extends GenericMapper<ArticleReqDto, Article> {
    ArticleReqMapper INSTANCE = Mappers.getMapper(ArticleReqMapper.class);
}
