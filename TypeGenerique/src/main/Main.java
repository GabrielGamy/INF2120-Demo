/*
 * The MIT License
 *
 * Copyright 2016 GABI.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package main;

import generique.*;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Integer [] listeEntiers = {1,2,3};
        String [] listeChaines = {"Riz","Patate","Salade"};
        
        System.out.println(trouverElement(listeEntiers, 3));
        System.out.println(trouverElement(listeEntiers, 4));
        
        System.out.println("------");
        
        System.out.println(trouverElement(listeChaines, "Patate"));
        System.out.println(trouverElement(listeChaines, "Autres"));
    }
    
    public static <T> PeutEtre<Integer> trouverElement( T[] tableau, T element){
       List<T> liste = Arrays.asList(tableau);
       return liste.contains(element) ? new QQChose<>(liste.indexOf(element)) : new Rien() ;
    }
}