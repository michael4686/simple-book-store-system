package com.mycompany.librarysystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LibrarySystemGui extends JFrame {

    private JTextField isbnTF, titleTF, authorsTF, publisherTF, publishingYearTF, genreTF, subjectTF;
    private JRadioButton fictionRB, nonFictionRB;
    private JButton addBookBtn, removeBookBtn, searchBookBtn;
    private Library library;
    private JButton showInventoryBtn ;
    

    public LibrarySystemGui() {
        library = new Library();
        showInventoryBtn= new JButton("Show Inventory");
        showInventoryBtn.addActionListener(new ShowInventoryListener());
        
        isbnTF = new JTextField(10);
        titleTF = new JTextField(10);
        authorsTF = new JTextField(10);
        publisherTF = new JTextField(10);
        publishingYearTF = new JTextField(10);
        genreTF = new JTextField(10);
        subjectTF = new JTextField(10);

        fictionRB = new JRadioButton("Fiction");
        nonFictionRB = new JRadioButton("Non-Fiction");

        addBookBtn = new JButton("Add Book");
        addBookBtn.addActionListener(new AddBookListener());

        removeBookBtn = new JButton("Remove Book");
        removeBookBtn.addActionListener(new RemoveBookListener());

        searchBookBtn = new JButton("Search Book");
        searchBookBtn.addActionListener(new SearchBookListener());

        setupLayout(); // call the setupLayout() method to set up the layout for the GUI
    }

    private void setupLayout() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel isbnPanel = new JPanel();
        isbnPanel.add(new JLabel("ISBN:"));
        isbnPanel.add(isbnTF);
        mainPanel.add(isbnPanel);

        JPanel titlePanel = new JPanel();
        titlePanel.add(new JLabel("Title:"));
        titlePanel.add(titleTF);
        mainPanel.add(titlePanel);

        JPanel authorsPanel = new JPanel();
        authorsPanel.add(new JLabel("Authors:"));
        authorsPanel.add(authorsTF);
        mainPanel.add(authorsPanel);

        JPanel publisherPanel = new JPanel();
        publisherPanel.add(new JLabel("Publisher:"));
        publisherPanel.add(publisherTF);
        mainPanel.add(publisherPanel);

        JPanel publishingYearPanel = new JPanel();
        publishingYearPanel.add(new JLabel("Publishing Year:"));
        publishingYearPanel.add(publishingYearTF);
        mainPanel.add(publishingYearPanel);

        ButtonGroup group = new ButtonGroup();
        group.add(fictionRB);
        group.add(nonFictionRB);
        JPanel typePanel = new JPanel();
        typePanel.add(new JLabel("Type:"));
        typePanel.add(fictionRB);
        typePanel.add(new JLabel("Genre:"));
        typePanel.add(genreTF);
        typePanel.add(nonFictionRB);
        typePanel.add(new JLabel("Subject:"));
        typePanel.add(subjectTF);
        mainPanel.add(typePanel);

        JPanel btnPanel = new JPanel();
        btnPanel.add(addBookBtn);
        btnPanel.add(removeBookBtn);
        btnPanel.add(searchBookBtn);
        mainPanel.add(btnPanel);
        
        
        JPanel btnPane3 = new JPanel();
        btnPane3.add(showInventoryBtn);
        mainPanel.add(btnPane3);
        
        this.add(mainPanel);
        this.pack();
        this.setVisible(true);
    }

    public class RemoveBookListener implements ActionListener {
         public void actionPerformed(ActionEvent e) {
            String isbn = isbnTF.getText();
            boolean removed = library. removeBook(isbn);
            if (removed) {
                JOptionPane.showMessageDialog(null, "Book removed successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Book not found in inventory");
            }
        }
    }

    public class SearchBookListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String isbn = isbnTF.getText();
            Book book = library.findBook(isbn);
            if (book != null) {
                JOptionPane.showMessageDialog(null, book.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Book not found");
            }
        }
    }
      public class ShowInventoryListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            StringBuilder sb = new StringBuilder();
            for (Book book : library.getInventory()) {
                sb.append(book.toString());
                sb.append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }

    public class AddBookListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String isbn = isbnTF.getText();
            String title = titleTF.getText();
            String[] authors = authorsTF.getText().split(",");
            String publisher = publisherTF.getText();
            int publishingYear;
            try {
                publishingYear = Integer.parseInt(publishingYearTF.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid year format");
                return;
            }
            if (fictionRB.isSelected()) {
                String genre = genreTF.getText();
                boolean added=library.addBook(new FictionBook(isbn, title, authors, publisher, publishingYear, genre));
                if (added) {
                    JOptionPane.showMessageDialog(null, "Book added successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Book already exists in inventory");
                }
            } else if (nonFictionRB.isSelected()) {
                String subject = subjectTF.getText();
                boolean added =library.addBook(new Non_fictionBook(isbn, title, authors, publisher, publishingYear, subject));
                if (added) {
                    JOptionPane.showMessageDialog(null, "Book added successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Book already exists in inventory");
                }
            } else {
                boolean added =library.addBook(new Book(isbn, title, authors, publisher, publishingYear) {
                    @Override
                    public String getbooktype() {
                        return "Unknown";
                    }
                });
                if (added) {
                    JOptionPane.showMessageDialog(null, "Book added successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Book already exists in inventory");
                }
            }
        }
        
    }

    // main method for testing
    public static void main(String[] args) {
        LibrarySystemGui gui = new LibrarySystemGui();
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
