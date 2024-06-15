/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarysystem;


import java.util.*;
public class Library implements Book_Inventory
{
    private ArrayList<Book> inventory;
    public Library()
    {
        this.inventory=new ArrayList<Book>();
    }    
    
    public boolean addBook(Book book)
    {
        if (findBook(book.getISBN())== null)
        {
            inventory.add(book);
            System.out.println("Book is added sucsessfully");
            return true;
        }
        else
        {
            System.out.println("Book already exists in inventory.");
            return false;
        }
    }    
    
    public boolean removeBook(String ISBN)
    {
        Book book=findBook(ISBN);
        if(book!=null)
        {
            inventory.remove(book);
            System.out.println("Book removed from inventory: " + book.toString());
            return true;
        }
        else
        {
            System.out.println("Book not found in inventory.");
            return false;
        }
    }
    @Override
    public Book findBook(String ISBN)
    {
        for(Book book:inventory)
        {
            if(ISBN.equals(book.getISBN())) 
            {
                return book;
            }
        }
        return null;
    }
    @Override
    public void printInventory()
    {
        for(Book book:inventory)
        {
            System.out.println(book.toString());
        }    
    }

    public ArrayList<Book> getInventory() {
        return inventory;
    }
    

}
