/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bookregister.model.bean;

/**
 *
 * @author Giovane Santiago Leacina
 */
public class Book {
    
    private String title;
    private String descrition;
    private String actor;
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public String getTitle(){
        return title;
    }
    
    
    public void setDescrition(String descrition){
        this.descrition = descrition;
    }
    
    public String getDescrition(){
        return descrition;
    }
    
    
    public void setActor(String actor){
        this.actor = actor;
    }
    
    public String getActor(){
        return actor;
    }
}
