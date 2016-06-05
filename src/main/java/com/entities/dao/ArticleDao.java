package com.entities.dao;

import javax.transaction.Transactional;

import com.entities.Article;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class ArticleDao {
    @Autowired
    private SessionFactory _sessionFactory;

    private Session getSession() {
        return _sessionFactory.getCurrentSession();
    }

    public void save(Article article) {
        getSession().save(article);
    }


    public Article getArticle(int id){
        String hql = "from Article where articleId like :id";
        Session session= getSession();
        Query query = session.createQuery(hql);
        query.setInteger("id",id);
        List results = query.list();
        return (Article) results.get(0);
    }
}
