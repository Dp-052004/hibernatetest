package com;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import DAO.BookDAO;
import DAO.BookDAOImpl;

public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc = new Scanner(System.in);

        while(true)
        {
        	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Book_Management_System");
        	EntityManager em=emf.createEntityManager();
        	BookDAO dao = new BookDAOImpl(em);
            System.out.println("\n1 Add Book");
            System.out.println("2 View Books");
            System.out.println("3 View Books By Title");
            System.out.println("4 Update Price By Book id and Book Name");
            System.out.println("5 Delete Book By Title");
            System.out.println("6 Exit");
            
            System.out.println("Enter your choice");
            int ch = sc.nextInt();

            switch(ch)
            {
                case 1: 
                	dao.addBook(); 
                	break;
                case 2: 
                	dao.viewBooks(); 
                	break;
                case 3: 
                	dao.viewBooksByTitle(); 
                	break;
                case 4: 
                	dao.updatePriceByBookIdAndBookAuthor(); 
                	break;
                case 5: 
                	dao.deleteBookByTitle(); 
                	break;
                case 6:
                	em.close();
                    emf.close();
                    System.exit(0);
            }
            em.close();
            emf.close();
            
        }
    }
}
