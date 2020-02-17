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
    
    /**
     * Constructs Element object.
     */
    public Element()
    {
        // Empty Body
    }
    /**
     * Constructs Element object.
     * @param item Character of the Element object.
     * @param count Number of characters of the Element object.
     */
    public Element(char item, int count)
    {
        this.item = item;
        this.count = count;
    }
    /**
     * Sets the character of the Element object.
     * @param item Character to be set.
     */
    public void setItem(char item)
    {
        this.item = item;
    }
    /**
     * Returns the character of the Element object.
     * @return Character of the Element object.
     */
    public char getItem()
    {
        return item;
    }
    /**
     * Sets the number of characters of the Element object.
     * @param count Number of characters of the Element object.
     */
    public void setCount(int count)
    {
        this.count = count;
    }
    /**
     * Returns the number of characters of the Element object.
     * @return Number of characters of the Element object.
     */
    public int getCount()
    {
        return count;
    }
}