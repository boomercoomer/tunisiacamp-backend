package tn.esponline.esprit.tunisiacamp.controller;

import org.springframework.web.bind.annotation.*;
import tn.esponline.esprit.tunisiacamp.model.Article;
import tn.esponline.esprit.tunisiacamp.model.PredefCategory;
import tn.esponline.esprit.tunisiacamp.repository.ArticleRepo;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/article")
public class ArticleController {
    private ArticleRepo repository;
    public ArticleController(ArticleRepo repository){
        this.repository = repository;
    }
    @PostMapping("/add")
    public void create(@RequestBody Article article){
        repository.save(article);
    }
    @GetMapping("/findAll")
    public List<Article> findAll(){
        return repository.findAll();
    }
    @GetMapping("/findAllDesc")
    public List<Article> findAllDesc(){return repository.findByOrderByStarsDesc();}
    @GetMapping("/category/{category}")
    public List<Article> findByCategory(@PathVariable String category){
        return repository.findArticleByCategory(category);
    }
    @GetMapping("/search/{term}")
    public List<Article> findByName(@PathVariable String term){
        return repository.findArticleByNameContains(term);
    }
    @GetMapping("/{id}")
    public Optional<Article> findById(@PathVariable long id){
        return repository.findById(id);
    }
    @PutMapping("/update")
    public void update(@RequestBody Article article){
        repository.save(article);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        repository.deleteById(id);
    }


}
