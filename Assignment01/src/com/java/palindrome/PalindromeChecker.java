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
        /**
         * Prompts user to enter text and reads input string.
         */
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your string: ");
        String inputString = scanner.nextLine();
        
        /**
         * Initializes the list of Element objects.
         */
        ArrayList<Element> elementList = new ArrayList<Element>();
        
        /**
         * Iterates through the characters of the input string.
         */
        for(int index = 0; index < inputString.length(); index++)
        {
            boolean characterFoundFlag = false;
            for(int elementListIndex = 0; elementListIndex < elementList.size(); elementListIndex++)
            {
                if(elementList.get(elementListIndex).getItem() == inputString.charAt(index))
                {
                    /**
                     * Raises flag if the character already exists in the Element list and increases corresponding counter. 
                     */
                    characterFoundFlag = true;
                    elementList.get(elementListIndex).setCount(elementList.get(elementListIndex).getCount()+1);
                    break;
                }
            }
            /**
             * Adds new character to the Element list with counter value as 1.
             */
            if (characterFoundFlag == false)
            {
                elementList.add(new Element(inputString.charAt(index), 1));
            }
        }
        /**
         * Prints 'true' if list of elements contains only one type of character.
         */
        if(elementList.size() == 1)
        {
            System.out.println("true");
        }
        else
        {
            /**
             * Input string contains more than one type of characters.
             * Type of characters can be either odd or even.
             */
            int oddCounter = 0;
            if(inputString.length() % 2 != 0)
            {
                /**
                 * If length of input string is odd, then only one type of characters can be odd at maximum,
                 * to meet the criteria of making at least one Palindrome.
                 */
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
                /**
                 * If length of input string is even, then all type of characters MUST be even,
                 * to meet the criteria of making at least one Palindrome.
                 */
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