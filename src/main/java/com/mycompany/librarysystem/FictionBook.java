/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarysystem;


public class FictionBook extends Book
{
    private String genere;
    public FictionBook (String ISBN,String title,String[] authors,String publisher,int publishingyear,String genere)
    {
        super(ISBN,title,authors,publisher,publishingyear);
        this.genere=genere;
    }    

    public String getGenere() 
    {
        return genere;
    }
    @Override
    public String getbooktype()
    {
        return "Fiction";
    }
    @Override
    public String toString()
    {
        return super.toString()+"\n genere : "+genere;
    }    
}
