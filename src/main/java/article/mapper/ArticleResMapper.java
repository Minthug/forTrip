package article.mapper;

import article.dto.ArticleResDto;
import article.entity.Article;
import global.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ArticleResMapper extends GenericMapper<ArticleResDto, Article> {

    ArticleResMapper INSTANCE = Mappers.getMapper(ArticleResMapper.class);
}

