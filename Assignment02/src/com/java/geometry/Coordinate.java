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
    /**
     * Constructs Coordinate object.
     */
    public Coordinate()
    {
        // Empty-body constructor
    }
    /**
     * Constructs Coordinate object.
     * @param coordinate Coordinate object to be created.
     */
    public Coordinate(Coordinate coordinate)
    {
        this.x = coordinate.getX();
        this.y = coordinate.getY();
    }
    /**
     * Constructs Coordinate object.
     * @param x X value of the coordinate.
     * @param y Y value of the coordinate.
     */
    public Coordinate(float x, float y)
    {
        this.x = x;
        this.y = y;
    }
    /**
     * Sets the X value of Coordinate object.
     * @param x X value.
     */
    public void setX(float x)
    {
        this.x = x;
    }
    /**
     * Returns the X value of Coordinate object.
     * @return X value.
     */
    public float getX()
    {
        return x;
    }
    /**
     * Sets the Y value of Coordinate object.
     * @param y Y value.
     */
    public void setY(float y)
    {
        this.y = y;
    }
    /**
     * Returns the Y value of Coordinate object.
     * @return Y value.
     */
    public float getY()
    {
        return y;
    }
    /**
     * Prints the Coordinate object.
     */
    public void print()
    {
        System.out.println("(" + Math.round(this.getX()) + "," + Math.round(this.getY()) + ")");
    }
}