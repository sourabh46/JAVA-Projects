/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.geometry;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author soura
 */
public class DrawLine
{
    public static void main(String[] args)
    {
        /**
         * Prompts user to input two points (x0, y0) and (x1, y1).
         */
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter x0: ");
        float x0 = scanner.nextInt();
        System.out.print("Enter y0: ");
        float y0 = scanner.nextInt();
        System.out.print("Enter x1: ");
        float x1 = scanner.nextInt();
        System.out.print("Enter y1: ");
        float y1 = scanner.nextInt();
        
        /**
         * Initializes initial point (x0, y0) and final point (x1, y1).
         */
        Coordinate initialPointFloat = new Coordinate(x0, y0);
        Coordinate finalPointFloat = new Coordinate(x1, y1);
        
        /**
         * Initializes the list of Coordinate objects.
         */
        ArrayList<Coordinate> coordinateList = new ArrayList<Coordinate>();

        if ((initialPointFloat.getX() == finalPointFloat.getX()) && (initialPointFloat.getY() == finalPointFloat.getY()))
        {
            /**
             * If initial point and final point represent the same coordinate.
             */
            System.out.println("Sorry, (x0, y0) and (x1, y1) are pointing to the same co-ordinate");
        }
        else if (initialPointFloat.getX() == finalPointFloat.getX())
        {
            /**
             * If initial point and final point have same X value.
             */
            if (initialPointFloat.getY() < finalPointFloat.getY())
            {
                for (float yValue = initialPointFloat.getY(); yValue <= finalPointFloat.getY(); yValue += 1)
                {
                    coordinateList.add(new Coordinate(initialPointFloat.getX(), yValue));
                }
            }
            else
            {
                for (float yValue = finalPointFloat.getY(); yValue <= initialPointFloat.getY(); yValue += 1)
                {
                    coordinateList.add(new Coordinate(initialPointFloat.getX(), yValue));
                }
            }
        }
        else if (initialPointFloat.getY() == finalPointFloat.getY())
        {
            /**
             * If initial point and final point have same Y value.
             */
            if (initialPointFloat.getX() < finalPointFloat.getX())
            {
                for (float xValue = initialPointFloat.getX(); xValue <= finalPointFloat.getX(); xValue += 1)
                {
                    coordinateList.add(new Coordinate(xValue, initialPointFloat.getY()));
                }
            }
            else
            {
                for (float xValue = finalPointFloat.getX(); xValue <= initialPointFloat.getX(); xValue += 1)
                {
                    coordinateList.add(new Coordinate(xValue, initialPointFloat.getY()));
                }
            }
        }
        else
        {
            /**
             * If initial point and final point have different X and Y values.
             */
            float initialXValue = (finalPointFloat.getX() > initialPointFloat.getX()) ? initialPointFloat.getX() : finalPointFloat.getX();
            float maxXValue = (finalPointFloat.getX() > initialPointFloat.getX()) ? finalPointFloat.getX() : initialPointFloat.getX();

            float initialYValue = (finalPointFloat.getY() > initialPointFloat.getY()) ? initialPointFloat.getY() : finalPointFloat.getY();
            float maxYValue = (finalPointFloat.getY() > initialPointFloat.getY()) ? finalPointFloat.getY() : initialPointFloat.getY();
            
            float delta = (float)(0.01);
            
            /**
             * Iterates through list of possible coordinates with a delta step-increment for both X value and Y value.
             */
            for (float xValue = initialXValue; xValue <= maxXValue; xValue += delta)
            {
                for (float yValue = initialYValue; yValue <= maxYValue; yValue += delta)
                {
                    if (lineEquation(initialPointFloat.getX(), initialPointFloat.getY(), finalPointFloat.getX(), finalPointFloat.getY(), xValue, yValue) == 0)
                    {
                        /**
                         * Prepares list of coordinates that satisfies the equation of straight line.
                         */
                        coordinateList.add(new Coordinate(xValue, yValue));
                    }
                }
            }
        }
        /**
         * Initializes list of interpolated (final) coordinates.
         */
        ArrayList<Coordinate> interpolatedCoordinateList = new ArrayList<Coordinate>();

        float x = 0;
        float y = 0;
        
        /**
         * Iterates through the list of coordinates to discard duplicate coordinates.
         */
        for (int indexOfCoordinateList = 0; indexOfCoordinateList < coordinateList.size(); indexOfCoordinateList++)
        {
            x = (float) (Math.round(coordinateList.get(indexOfCoordinateList).getX()));
            y = (float) (Math.round(coordinateList.get(indexOfCoordinateList).getY()));

            boolean isCoordinateAlreadyAddedFlag = false;
            int iterator = 0;
            do
            {
                if (interpolatedCoordinateList.size() == 0)
                {
                    interpolatedCoordinateList.add(new Coordinate(x, y));
                    continue;
                }
                else
                {
                    if (interpolatedCoordinateList.get(iterator).getX() == x && interpolatedCoordinateList.get(iterator).getY() == y)
                    {
                        isCoordinateAlreadyAddedFlag = true;
                        break;
                    }
                    iterator++;
                }
            }
            while (iterator < interpolatedCoordinateList.size());
            if (isCoordinateAlreadyAddedFlag == false)
            {
                interpolatedCoordinateList.add(new Coordinate(x, y));
            }
        }
        /**
         * Prints the final coordinate list.
         */
        for (int index = 0; index < interpolatedCoordinateList.size(); index++)
        {
            interpolatedCoordinateList.get(index).print();
        }
    }
    /**
     * Returns 0 if (x, y) is situated on the straight line between (x0, y0) and (x1, y1).
     * @param x0 X value of coordinate (x0, y0).
     * @param y0 Y value of coordinate (x0, y0).
     * @param x1 X value of coordinate (x1, y1).
     * @param y1 Y value of coordinate (x1, y1).
     * @param x X value of coordinate (x, y).
     * @param y Y value of coordinate (x, y).
     * @return 
     */
    public static long lineEquation(float x0, float y0, float x1, float y1, float x, float y)
    {
        return Math.round((x - x0) * (y0 - y1) - (y - y0) * (x0 - x1));
    }
}