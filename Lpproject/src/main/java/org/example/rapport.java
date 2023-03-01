/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

/**
 *
 * @author argane
 */
public class rapport extends Activite{
    String pdf;
    String service;
    public rapport(String sujet, String Categorie, String lieu, String date, String details,String image,String service,String pdf) {
        super(sujet, Categorie,lieu,  date,details,image);
        this.pdf = pdf;
        this.service = service;
    }
      public String getPdf() {
        return pdf;
    }
    public void setPdf(String pdf) {
        this.pdf = pdf;
    }
}
