
package com.mycompany.librarysystem;

import java.util.ArrayList;

public interface Book_Inventory 
{
    boolean addBook(Book book);
    boolean removeBook(String ISBN);
    Book findBook(String ISBN);
     void printInventory();
    public ArrayList<Book> getInventory();
}
