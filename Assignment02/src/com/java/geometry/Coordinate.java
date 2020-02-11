/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.geometry;

/**
 *
 * @author soura
 */
public class Coordinate
{

    private float x;
    private float y;

    public Coordinate()
    {
        // Default Constructor
    }

    public Coordinate(Coordinate coordinate)
    {
        this.x = coordinate.getX();
        this.y = coordinate.getY();
    }

    public Coordinate(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public void setX(float x)
    {
        this.x = x;
    }

    public float getX()
    {
        return x;
    }

    public void setY(float y)
    {
        this.y = y;
    }

    public float getY()
    {
        return y;
    }

    public void print()
    {
        System.out.println("(" + Math.round(this.getX()) + "," + Math.round(this.getY()) + ")");
    }
}