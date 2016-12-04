package music11;

import static java.lang.Math.random;

/**
 * The main program will generate increasingly large arrays of random notes within
 * the bounds of 0-15 with each being a diatonic pitch. It will then check to
 * see if it is a valid cantus firmus, and if it is it will print it out and move on.
 * This is for the purpose of demonstration. I hope to in the future build the 
 * series' of numbers rather than guess and check them.
*/
public class Music11 {
    public static void main(String[] args) {
        for(int length = 1; length<20; length++) {
           for(int j = 0; j<5; j++){
                boolean bad = true;
                while(bad) {
                    int[] array = new int[length];
                    for(int i = 0; i < length; i++) {
                        array[i] = (int) (random() * 15 + 1);  
                    }
                    //System.out.println(Arrays.toString(array));
                    CantusFirmus cantusfirmus = new CantusFirmus(array);
                    //System.out.println(cantusfirmus);
                    if(cantusfirmus.isItGood()) {
                        System.out.println("this is a good cantus firmus");
                        System.out.println(cantusfirmus);
                        bad = false;
                    } else {
                        //System.out.println("not a good cantus firmus");
                    }
                }
            }
        }
    } 
}
