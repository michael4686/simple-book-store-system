/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarysystem;

/**
 *
 * @author m
 */
public class Non_fictionBook extends Book
{
    private String subject;
    public Non_fictionBook(String ISBN,String title,String[] authors,String publisher,int publishingyear,String subject)
    {
        super(ISBN,title,authors,publisher,publishingyear);
        this.subject=subject;
    }    

    public String getSubject() 
    {
        return subject;
    }
    @Override
    public String getbooktype()
    {
        return "non-Fiction";
    }
    @Override
    public String toString()
    {
        return super.toString()+"\n subject : "+subject;
    }    
}
