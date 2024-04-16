package com.arpit;

import com.arpit.dao.AlienDao;
import com.arpit.model.Alien;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);

        Alien alien = applicationContext.getBean(Alien.class);
        alien.setId(101);
        alien.setName("Arpit");
        alien.setTech("Java");


        //now save this into database

        AlienDao alienDao = applicationContext.getBean(AlienDao.class);
        alienDao.save(alien);

        System.out.println(alienDao.findAll());
    }
}
