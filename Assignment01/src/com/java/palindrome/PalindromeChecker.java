/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.palindrome;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author soura
 */
public class PalindromeChecker 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your string: ");
        String inputString = scanner.nextLine();
        
        ArrayList<Element> elementList = new ArrayList<Element>();
        
        for(int index = 0; index < inputString.length(); index++)
        {
            boolean characterFoundFlag = false;
            for(int elementListIndex = 0; elementListIndex < elementList.size(); elementListIndex++)
            {
                if(elementList.get(elementListIndex).getItem() == inputString.charAt(index))
                {
                    characterFoundFlag = true;
                    elementList.get(elementListIndex).setCount(elementList.get(elementListIndex).getCount()+1);
                    break;
                }
            }
            if (characterFoundFlag == false)
            {
                elementList.add(new Element(inputString.charAt(index), 1));
            }
        }
        
        if(elementList.size() == 1)
        {
            System.out.println("true");
        }
        else
        {
            int oddCounter = 0;
            if(inputString.length() % 2 != 0)
            {
                for(int elementListIndex = 0; elementListIndex < elementList.size(); elementListIndex++)
                {
                    if(elementList.get(elementListIndex).getCount() % 2 == 0)
                    {
                        continue;
                    }
                    else
                    {
                        oddCounter++;
                    }
                }
                if(oddCounter > 1)
                {
                    System.out.println("false");
                }
                else
                {
                    System.out.println("true");
                }
            }
            else
            {
                for(int elementListIndex = 0; elementListIndex < elementList.size(); elementListIndex++)
                {
                    if(elementList.get(elementListIndex).getCount() % 2 == 0)
                    {
                        continue;
                    }
                    else
                    {
                        oddCounter++;
                    }
                }
                if(oddCounter > 0)
                {
                    System.out.println("false");
                }
                else
                {
                    System.out.println("true");
                }
            }
        }
    }
}