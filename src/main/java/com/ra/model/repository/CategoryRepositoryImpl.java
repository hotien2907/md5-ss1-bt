package com.ra.model.repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.ra.model.entity.Category;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Category> findAll() {
        // TODO Auto-generated method stub
        Session session = sessionFactory.openSession();

        try {
            List list = session.createQuery("from Category").list();
            return list;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;

    }
    @Override
    public Boolean saveOrUpdate(Category category) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            if (category.getCategoryId() == null) {
                session.save(category);
            } else {
                session.update(category);
            }

            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }


    @Override
    public Boolean delete(Integer categoryID) {
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            session.delete(findById(categoryID));
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }


    @Override
    public Category findById(Integer categoryID) {
        Session session = sessionFactory.openSession();
        try {
            Category category = session.get(Category.class,categoryID);
            return category;
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            session.close();
        }
        return null;
    }
}
