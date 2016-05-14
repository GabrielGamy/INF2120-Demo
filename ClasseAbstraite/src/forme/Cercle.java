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

public class Cercle extends Forme2D {
    
    private double rayon;
    private final double PI = 3.14;
    
    public Cercle(){
        rayon = 1;
    }
    
    public Cercle(double rayon){
        this.rayon = rayon;
    }
    
    @Override
    public double aire() {
        return PI * Math.pow(getRayon(), 2);
    }

    /**
     * @return the rayon
     */
    public double getRayon() {
        return rayon;
    }

    /**
     * @param rayon the rayon to set
     */
    public void setRayon(double rayon) {
        this.rayon = rayon;
    }
}
