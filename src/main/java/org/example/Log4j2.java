package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2 {

    private static Logger logger = LogManager.getLogger(Log4j2.class);

    static void  sayHello(){
        logger.info("Method sayHello is called ");
    }

    static void sayByeBye(){
        logger.info("Method sayBye bye is called");
    }

    public static void main(String[] args) {
        sayHello();
        sayByeBye();

        vote(20,"republic");
    }

    public static void vote (int age,String politic){

        if (age  < 17){
            logger.warn("You can not vote. Bc you are not 18");
            return;
        }

        if (politic.equals("republic")){
            logger.error("Sorry we can not support you.");
            return;
        }


        logger.info("Thank you for voting");
    }

}