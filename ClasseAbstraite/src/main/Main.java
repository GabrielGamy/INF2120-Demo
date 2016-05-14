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

import forme.*;
import formeAbstraite.*;

public class Main {

    public static void main(String[] args) {
        
        Forme2D cercle = new Cercle(2);
        Forme2D rectangle = new Rectangle(5,4);
        Forme2D [] formes2d = {cercle, rectangle};

        System.out.println("Aire des forme2D : " + calculerAire(formes2d));
        
        Forme3D sphere = new Sphere(3);
        Forme3D cylindreDroit = new CylindreDroit(cercle, 2);
        Forme3D [] formes3d = {sphere, cylindreDroit};
        
        System.out.println("Volume des forme3D : " + calculerVolume(formes3d));
    }
    
    /** 
     * Construire une interface IForme pour calculer l'aire de toutes les formes
     * @param formes
     * @return 
     */
    //public static double calculerAire(IForme [] formes){}
    
    public static double calculerAire(Forme2D [] formes){
        double aire = 0;
        for(Forme2D forme : formes){
            aire +=  forme.aire();
        }
        return aire;
    }
    
    public static double calculerVolume(Forme3D [] formes){
        double volume = 0;
        for(Forme3D forme : formes){
            volume +=  forme.volume();
        }
        return volume;
    }
}
