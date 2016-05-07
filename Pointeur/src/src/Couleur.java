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
package src;

/**
 *
 * @author GABI
 */
public class Couleur {
    private int rouge;
    private  int vert;
    private int bleu;

    public Couleur(){
        rouge = 0;
        vert = 1;
        bleu = 2;
    }

    public Couleur(int rouge, int vert, int bleu){
        this.rouge = rouge;
        this.vert = vert;
        this.bleu = bleu;
    }

    public int getRouge() {

        return rouge;
    }

    public void setRouge(int rouge) {

        this.rouge = (rouge >= 0 && rouge <= 255) ? rouge : this.getRouge();
    }

    public int getVert() {
        return vert;
    }

    public void setVert(int vert) {

        this.vert = (vert >= 0 && vert <= 255) ? vert: this.getVert();
    }

    public int getBleu() {

        return bleu;
    }

    public void setBleu(int bleu) {

        this.bleu = (bleu >= 0 && bleu <= 255) ? bleu: this.getBleu();
    }

    public void blanchir(){
        rouge = ( rouge + 255 ) / 2;
        vert = ( vert + 255 ) / 2;
        bleu = ( bleu + 255 ) / 2;
    }

    @Override
    public String toString() {
        return "Couleur{" +
                "rouge=" + rouge +
                ", vert=" + vert +
                ", bleu=" + bleu +
                '}';
    }
}

