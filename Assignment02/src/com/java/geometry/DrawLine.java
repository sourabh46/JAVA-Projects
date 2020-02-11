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
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter x0: ");
        float x0 = scanner.nextInt();
        System.out.print("Enter y0: ");
        float y0 = scanner.nextInt();
        System.out.print("Enter x1: ");
        float x1 = scanner.nextInt();
        System.out.print("Enter y1: ");
        float y1 = scanner.nextInt();

        Coordinate initialPofloat = new Coordinate(x0, y0);
        Coordinate finalPofloat = new Coordinate(x1, y1);

        ArrayList<Coordinate> coordinateList = new ArrayList<Coordinate>();

        if ((initialPofloat.getX() == finalPofloat.getX()) && (initialPofloat.getY() == finalPofloat.getY()))
        {
            System.out.println("Sorry, (x0, y0) and (x1, y1) are pointing to the same co-ordinate");
        }
        else if (initialPofloat.getX() == finalPofloat.getX())
        {
            if (initialPofloat.getY() < finalPofloat.getY())
            {
                for (float yValue = initialPofloat.getY(); yValue <= finalPofloat.getY(); yValue += 1)
                {
                    coordinateList.add(new Coordinate(initialPofloat.getX(), yValue));
                }
            }
            else
            {
                for (float yValue = finalPofloat.getY(); yValue <= initialPofloat.getY(); yValue += 1)
                {
                    coordinateList.add(new Coordinate(initialPofloat.getX(), yValue));
                }
            }
        }
        else if (initialPofloat.getY() == finalPofloat.getY())
        {
            if (initialPofloat.getX() < finalPofloat.getX())
            {
                for (float xValue = initialPofloat.getX(); xValue <= finalPofloat.getX(); xValue += 1)
                {
                    coordinateList.add(new Coordinate(xValue, initialPofloat.getY()));
                }
            }
            else
            {
                for (float xValue = finalPofloat.getX(); xValue <= initialPofloat.getX(); xValue += 1)
                {
                    coordinateList.add(new Coordinate(xValue, initialPofloat.getY()));
                }
            }
        }
        else
        {
            float initialXValue = (finalPofloat.getX() > initialPofloat.getX()) ? initialPofloat.getX() : finalPofloat.getX();
            float maxXValue = (finalPofloat.getX() > initialPofloat.getX()) ? finalPofloat.getX() : initialPofloat.getX();

            float initialYValue = (finalPofloat.getY() > initialPofloat.getY()) ? initialPofloat.getY() : finalPofloat.getY();
            float maxYValue = (finalPofloat.getY() > initialPofloat.getY()) ? finalPofloat.getY() : initialPofloat.getY();

            for (float xValue = initialXValue; xValue <= maxXValue; xValue += 0.01)
            {
                for (float yValue = initialYValue; yValue <= maxYValue; yValue += 0.01)
                {
                    if (lineEquation(initialPofloat.getX(), initialPofloat.getY(), finalPofloat.getX(), finalPofloat.getY(), xValue, yValue) == 0)
                    {
                        coordinateList.add(new Coordinate(xValue, yValue));
                    }
                }
            }
        }
        ArrayList<Coordinate> interpolatedCoordinateList = new ArrayList<Coordinate>();

        float x = 0;
        float y = 0;

        for (int i = 0; i < coordinateList.size(); i++)
        {
            x = (float) (Math.round(coordinateList.get(i).getX()));
            y = (float) (Math.round(coordinateList.get(i).getY()));

            boolean isCoordinateAlreadyAddedFlag = false;
            int j = 0;
            do
            {
                if (interpolatedCoordinateList.size() == 0)
                {
                    interpolatedCoordinateList.add(new Coordinate(x, y));
                    continue;
                }
                else
                {
                    if (interpolatedCoordinateList.get(j).getX() == x && interpolatedCoordinateList.get(j).getY() == y)
                    {
                        isCoordinateAlreadyAddedFlag = true;
                        break;
                    }
                    j++;
                }
            }
            while (j < interpolatedCoordinateList.size());
            if (isCoordinateAlreadyAddedFlag == false)
            {
                interpolatedCoordinateList.add(new Coordinate(x, y));
            }
        }

        for (int index = 0; index < interpolatedCoordinateList.size(); index++)
        {
            interpolatedCoordinateList.get(index).print();
        }
    }

    public static long lineEquation(float x0, float y0, float x1, float y1, float x, float y)
    {
        return Math.round((x - x0) * (y0 - y1) - (y - y0) * (x0 - x1));
        //return Math.round((float)(x - x0)/(float)(x0 - x1) - (float)(y - y0)/(float)(y0 - y1));
    }
}