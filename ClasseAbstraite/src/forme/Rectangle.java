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
package forme;

import formeAbstraite.Forme2D;

public class Rectangle extends Forme2D {
    
    private double hauteur;
    private double largeur;
    
    public Rectangle(){
        hauteur = largeur = 1;
    }
    
    public Rectangle(double hauteur,double largeur){
        this.hauteur = hauteur;
        this.largeur = largeur;
    }
    
    @Override
    public double aire() {
        return getHauteur() * getLargeur();
    }

    /**
     * @return the hauteur
     */
    public double getHauteur() {
        return hauteur;
    }

    /**
     * @param hauteur the hauteur to set
     */
    public void setHauteur(double hauteur) {
        this.hauteur = hauteur;
    }

    /**
     * @return the largeur
     */
    public double getLargeur() {
        return largeur;
    }

    /**
     * @param largeur the largeur to set
     */
    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }
}