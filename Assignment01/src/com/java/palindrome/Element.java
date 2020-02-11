/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.palindrome;

/**
 *
 * @author soura
 */
public class Element
{
    private char item;
    private int count;
    
    public Element()
    {
        // Default constructor
    }
    
    public Element(char item, int count)
    {
        this.item = item;
        this.count = count;
    }
    
    public void setItem(char item)
    {
        this.item = item;
    }
    
    public char getItem()
    {
        return item;
    }
    
    public void setCount(int count)
    {
        this.count = count;
    }
    
    public int getCount()
    {
        return count;
    }
}