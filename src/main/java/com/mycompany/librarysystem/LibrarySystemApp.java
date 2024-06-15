package com.mycompany.librarysystem;
import java.util.*;
public class LibrarySystemApp 
{
    public static void main(String[] args) 
    {
       Book_Inventory library =new Library();
       Scanner input = new Scanner(System.in);
       int choice =0;
       while(choice!=5)
       {
            System.out.println("Choose an option:");
            System.out.println("1. Add a book to the inventory");
            System.out.println("2. Remove a book from the inventory");
            System.out.println("3. Search for a book in the inventory");
            System.out.println("4. show inventory");
            System.out.println("5. Exit");
            choice = input.nextInt();
            input.nextLine();
            System.out.println("");
            switch(choice)
            {
                case 1:
                    System.out.println("Enter the book details:");
                    System.out.println("ISBN: ");
                    String ISBN = input.nextLine();
                    System.out.print("Title: ");
                    String title = input.nextLine();
                    System.out.print("Authors (comma-separated list): ");
                    String[] authors = input.nextLine().split(",");
                    System.out.print("Publisher: ");
                    String publisher = input.nextLine();
                    int publishingyear = 0;
                    boolean validInput = false;
                    while (!validInput)  
                    {
                        System.out.print("Publishing Year: ");
                    try 
                    {
                        publishingyear = input.nextInt();
                        validInput = true;
                    } 
                    catch (InputMismatchException e) 
                    {
                        System.out.println("Error: Invalid input. Please enter a valid integer for publishing year.");
                        input.nextLine(); 
                    }
                    }
                    input.nextLine();
                    System.out.print("");
                    System.out.println("enter type of book(you dont have to add it enter :fiction or non-fiction if you enter wrong input it will continuo as no type entered) ): ");
                    String type =input.nextLine();
                    String genere=null;
                    String subject=null;
                    if(type.equals("fiction"))
                    {
                    System.out.print("Genre (fiction books only): ");
                     genere = input.nextLine();
                     
                     library.addBook(new FictionBook(ISBN, title, authors, publisher, publishingyear, genere));
                     System.out.println(" ");
                    }
                    else if(type.equals("non-fiction"))
                    {
                     System.out.print("Subject (non-fiction books only): ");
                     subject = input.nextLine();
                     library.addBook(new Non_fictionBook(ISBN, title, authors, publisher, publishingyear, subject));
                     System.out.println(" ");
                    }
                    else 
                    {
                     System.out.println("type not entered");
                     
                     library.addBook(new Book(ISBN, title, authors, publisher, publishingyear) {
                         @Override
                         public String getbooktype() {
                             return  "Unknown"; 
                         }
                     }) ;
                     System.out.println(" ");
                    }
                    
                    break;
                case 2:
                    System.out.print("Enter the ISBN of the book to remove: ");
                    ISBN = input.nextLine();
                    System.out.println(" ");
                    library.removeBook(ISBN);
                    System.out.println(" ");
                    break;
                case 3:
                    System.out.print("Enter the ISBN of the book to search for: ");
                    ISBN = input.nextLine();
                    Book book = library.findBook(ISBN);
                    if(book!=null)
                    {
                        System.out.println(book.toString());
                    }    
                    else {
                        System.out.println("Book not found in inventory.");
                    }
                    System.out.println(" ");
                    break;
                case 4: 
                    library.printInventory();
                    break;
                case 5:
                    System.out.println("Exiting the application...");
                    break;
                default: 
                    System.out.println("Invalid choice. Please try again.");
                    System.out.println(" ");
                    continue;
            }    
       
       }
       input.close();
    }
}
