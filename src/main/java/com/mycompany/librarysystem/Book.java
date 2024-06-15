/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarysystem;


import java.util.*;
public abstract class Book 
{
    private String ISBN;
    private String title;
    private String[] authors;
    private String publisher;
    private int publishingyear;
    public Book(String ISBN,String title,String[] authors,String publisher,int publishingyear)
    {
        this.ISBN=ISBN;
        this.authors=authors;
        this.publisher=publisher;
        this.publishingyear=publishingyear;
        this.title=title;
    }
    public String getISBN ()
    {
        return ISBN;
    }    

    public String getTitle() 
    {
        return title;
    }

    public String[] getAuthors() 
    {
        return authors;
    }

    public String getPublisher() 
    {
        return publisher;
    }

    public int getPublishingyear() 
    {
        return publishingyear;
    }
    @Override
    public String toString ()
    {
        return "ISBN : "+ISBN+"\n title : "+title+"\n authors : "+Arrays.toString(authors)+"\n publisher : "+publisher+"\n publishing year : "+publishingyear;
    }    
    public abstract String getbooktype ();
    
    
    
}
