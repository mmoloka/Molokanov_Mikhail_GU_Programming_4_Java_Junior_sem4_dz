package org.example.sem4_dz;

import java.sql.*;

/**
 * 1. С помощью JDBC выполнить:
 * 1.1 Создать таблицу book с колонками id bigint, name varchar, author varchar, ...
 * 1.2 Добавить в таблицу 10 книг
 * 1.3 Сделать запрос select from book where author = 'какое-то имя' и прочитать его с помощью ResultSet
 */

public class JDBC {
    protected static final String URL = "jdbc:mysql://localhost:3306";
    protected static final String USER = "root";
    protected static final String PASSWORD = "admin";

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement statement = connection.createStatement();
        statement.execute("DROP SCHEMA `library`");
        statement.execute("CREATE SCHEMA `library`");
        statement.execute("CREATE TABLE `library`.`book` " +
                "(`id` BIGINT NOT NULL AUTO_INCREMENT, " +
                "`name` VARCHAR(45), " +
                "`author` VARCHAR(45), " +
                "`pages` INT, " +
                "`date` INT, PRIMARY KEY(`id`));");
        statement.execute("INSERT INTO `library`.`book` (`name`, `author`, `pages`, `date`)\nVALUES\n" +
                "('A Tale of Two Cities', 'Charles Dickens', 547, 1859),\n" +
                "('The Little Prince', 'Antoine de Saint-Exupéry', 146, 1943),\n" +
                "('Harry Potter and the Philosopher`s Stone', 'J. K. Rowling', 725, 1997),\n" +
                "('And Then There Were None', 'Agatha Christie', 628, 1939),\n" +
                "('Dream of the Red Chamber', 'Cao Xueqin', 958, 1791),\n" +
                "('The Hobbit', 'J. R. R. Tolkien', 957, 1937),\n" +
                "('Lolita', 'Vladimir Nabokov', 391, 1955),\n" +
                "('Harry Potter and the Chamber of Secrets', 'J. K. Rowling', 740, 1998),\n" +
                "('Hard Times', 'Charles Dickens', 627, 1854),\n" +
                "('Harry Potter and the Prisoner of Azkaban', 'J. K. Rowling', 559, 1999);");

        ResultSet set = statement.executeQuery("SELECT * FROM `library`.`book` WHERE `author` = 'J. K. Rowling'");
        System.out.println("Книги искомого автора:");
        while (set.next()){
            System.out.println(set.getString("name"));}

        connection.close();
    }

}
