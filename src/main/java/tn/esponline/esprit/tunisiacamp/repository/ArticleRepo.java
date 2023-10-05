package tn.esponline.esprit.tunisiacamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esponline.esprit.tunisiacamp.model.Article;
import tn.esponline.esprit.tunisiacamp.model.PredefCategory;

import java.util.List;

public interface ArticleRepo extends JpaRepository<Article,Long> {
    List<Article> findArticleByCategory(String category);
    List<Article> findArticleByNameContains(String term);
    List<Article> findByOrderByStarsDesc();
}
