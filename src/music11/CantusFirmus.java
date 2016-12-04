package music11;

import java.util.HashSet;
import java.util.Set;

public class CantusFirmus {

    private int[] notes;

//takes an int[] of notes where middle C = 1, Db = 2, D = 3...
    public CantusFirmus(int[] notes) {
        this.notes = notes;
    }

    public enum Interval {
        PU, P4, P5, P8,
        m2, m3, m6, m7, m9, m10,
        M2, M3, M6, M7, M9, M10,
        TT;
    }
    
    public int getGenericInterval(Interval intervalA) {
        int answer = 0;
        switch (intervalA) {
            case PU:
                answer = 1;
                break;
            case m2:
                answer = 2;
                break;
            case M2:
                answer = 2;
                break;
            case m3:
                answer = 3;
                break;
            case M3:
                answer = 3;
                break;
            case P4:
                answer = 4;
                break;
            case TT:
                //not allowed to have this interval anyway
                break;
            case P5:
                answer = 5;
                break;
            case m6:
                answer = 6;
                break;
            case M6:
                answer = 6;
                break;
            case m7:
                answer = 7;
                break;
            case M7:
                answer = 7;
                break;
            case P8:
                answer = 8;
                break;
            case m9:
                answer = 9;
                break;
            case M9:
                answer = 9;
                break;
            case m10:
                answer = 10;
                break;
            case M10:
                answer = 10;
                break;
        }
        return answer;
    }

    public int compareGenericInterval(Interval intervalA, Interval intervalB) {
        int answer = 0;
        switch (intervalB) {
            case PU:
                if (intervalA == Interval.PU) {
                    answer = 1;
                }
                break;
            case m2:
                if (intervalA == Interval.m2 || intervalA == Interval.M2) {
                    answer = 1;
                }
                break;
            case M2:
                if (intervalA == Interval.m2 || intervalA == Interval.M2) {
                    answer = 1;
                }
                break;
            case m3:
                if (intervalA == Interval.m3 || intervalA == Interval.M3) {
                    answer = 1;
                }
                break;
            case M3:
                if (intervalA == Interval.m3 || intervalA == Interval.M3) {
                    answer = 1;
                }
                break;
            case P4:
                if (intervalA == Interval.P4) {
                    answer = 1;
                }
                break;
            case TT:
                if (intervalA == Interval.TT) {
                    answer = 1;
                }
                break;
            case P5:
                if (intervalA == Interval.P5) {
                    answer = 1;
                }
                break;
            case m6:
                if (intervalA == Interval.m6 || intervalA == Interval.M6) {
                    answer = 1;
                }
                break;
            case M6:
                if (intervalA == Interval.m6 || intervalA == Interval.M6) {
                    answer = 1;
                }
                break;
            case m7:
                if (intervalA == Interval.m7 || intervalA == Interval.M7) {
                    answer = 1;
                }
                break;
            case M7:
                if (intervalA == Interval.m7 || intervalA == Interval.M7) {
                    answer = 1;
                }
                break;
            case P8:
                if (intervalA == Interval.P8) {
                    answer = 1;
                }
                break;
            case m9:
                if (intervalA == Interval.m9 || intervalA == Interval.M9) {
                    answer = 1;
                }
                break;
            case M9:
                if (intervalA == Interval.m9 || intervalA == Interval.M9) {
                    answer = 1;
                }
                break;
            case m10:
                if (intervalA == Interval.m10 || intervalA == Interval.M10) {
                    answer = 1;
                }
                break;
            case M10:
                if (intervalA == Interval.m10 || intervalA == Interval.M10) {
                    answer = 1;
                }
                break;
        }
        return answer;
    }

    private Interval getInterval(int noteOne, int noteTwo) {
        Interval answer;
        int difference = (noteTwo > noteOne) ? (noteTwo - noteOne) : (noteOne - noteTwo);

        switch (difference) {
            case 0:
                answer = Interval.PU;
                break;
            case 1:
                answer = Interval.m2;
                break;
            case 2:
                answer = Interval.M2;
                break;
            case 3:
                answer = Interval.m3;
                break;
            case 4:
                answer = Interval.M3;
                break;
            case 5:
                answer = Interval.P4;
                break;
            case 6:
                answer = Interval.TT;
                break;
            case 7:
                answer = Interval.P5;
                break;
            case 8:
                answer = Interval.m6;
                break;
            case 9:
                answer = Interval.M6;
                break;
            case 10:
                answer = Interval.m7;
                break;
            case 11:
                answer = Interval.M7;
                break;
            case 12:
                answer = Interval.P8;
                break;
            case 13:
                answer = Interval.m9;
                break;
            case 14:
                answer = Interval.M9;
                break;
            case 15:
                answer = Interval.m10;
                break;
            case 16:
                answer = Interval.M10;
                break;
            default:
                int newNote;
                newNote = (noteTwo > noteOne) ? (noteTwo - 12) : (noteTwo + 12);
                answer = getInterval(noteOne, newNote);
                break;
        }
        return answer;
    }
    
    private boolean checkInKey() {
        Set<Integer> diatonic = new HashSet<>();
        diatonic.add(notes[0]);
        diatonic.add(notes[0] + 2);
        diatonic.add(notes[0] + 4);
        diatonic.add(notes[0] + 5);
        diatonic.add(notes[0] + 7);
        diatonic.add(notes[0] + 9);
        diatonic.add(notes[0] + 11);
        diatonic.add(notes[0] + 12);
        diatonic.add(notes[0] + 14);
        diatonic.add(notes[0] + 16);
        diatonic.add(notes[0] + 17);
        
        for(int i : notes) {
            if(!diatonic.contains(i)){
                return false;
            }
        }
        return true;
    }

    private boolean checkEitherEnd() {
        if (notes[0] != notes[notes.length - 1]) {
            return false;
        }
        if(notes.length >=4) {
            if ((notes[notes.length - 2] != (notes[0] + 2))
                && (notes[notes.length - 2] != (notes[0] - 1))) {
                return false;
            }
        }

        int highest, lowest;
        highest = lowest = notes[0];

        for (int i : notes) {
            if (i > highest) {
                highest = i;
            }
            if (i < lowest) {
                lowest = i;
            }
        }

        if ((highest - lowest) > 16) {
            return false;
        }

        return true;
    }

    private boolean checkIntervals() {
        for (int i = 1; i<notes.length-1; i++) {
            Interval firstInterval = getInterval(notes[i], notes[i - 1]);
            Interval secondInterval = getInterval(notes[i], notes[i + 1]);
            if (firstInterval == Interval.TT || firstInterval == Interval.m7
                    || firstInterval == Interval.M7 || secondInterval == Interval.TT
                    || secondInterval == Interval.m7 || secondInterval == Interval.M7) {
                return false;
            }
        }
        return true;
    }

    private boolean checkOutlines() {
        for (int i = 0; i < notes.length - 2; i++) {
            if (getInterval(notes[i], notes[i + 2]) == Interval.TT) {
                return false;
            }
            if (getInterval(notes[i], notes[i + 2]) == Interval.m7
                    || getInterval(notes[i], notes[i + 2]) == Interval.M7) {
                if (getInterval(notes[i], notes[i + 1]) != Interval.P8) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkRepeat() {
        for (int i = 0; i < notes.length - 2; i++) {
            if (notes[i] == notes[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private boolean checkChangeDirection() {
        for (int i = 0; i < notes.length - 3; i++) {
            if (getInterval(notes[i], notes[i + 1]) == Interval.P4) {
                if (((notes[i + 2] > notes[i + 1])
                        && (notes[i + 1] > notes[i]))
                        || ((notes[i + 2] < notes[i + 1])
                        && (notes[i + 1] < notes[i]))) {
                    return false;
                }
            }
            if ((getInterval(notes[i], notes[i + 1]) != Interval.PU)
                    && (getInterval(notes[i], notes[i + 1]) != Interval.m2)
                    && (getInterval(notes[i], notes[i + 1]) != Interval.M2)
                    && (getInterval(notes[i], notes[i + 1]) != Interval.m3)
                    && (getInterval(notes[i], notes[i + 1]) != Interval.M3)
                    && (getInterval(notes[i], notes[i + 1]) != Interval.P4)) {
                if (((notes[i + 2] > notes[i + 1])
                        && (notes[i + 1] > notes[i]))
                        || ((notes[i + 2] < notes[i + 1])
                        && (notes[i + 1] < notes[i]))) {
                    return false;
                } else if ((getInterval(notes[i + 1], notes[i + 2]) != Interval.m2)
                        && (getInterval(notes[i + 1], notes[i + 2]) != Interval.M2)) {
                    return false;
                }
            }

        }
        return true;
    }
    
    public boolean isItGood() {
        
        boolean answer = (checkInKey() && checkEitherEnd() && checkIntervals() && checkOutlines()
                && checkRepeat() && checkChangeDirection());
        
       /* System.out.println("Is it diatonic? : " + checkInKey());
        System.out.println("Do the beginning and end work? : " + checkEitherEnd());
        System.out.println("Are the intervals legal? : " + checkIntervals());
        System.out.println("Are there no illegal outlines? : " + checkOutlines());
        System.out.println("Is it not repetitive? : " + checkRepeat());
        System.out.println("Does it follow rules when changing direction? : " + checkChangeDirection());
        */
       return answer;
    }
    
    
    @Override
    public String toString() {
        String answer = "";
        for(int i : notes) {
            String toAdd = "";
            switch(i) {
                case 1 : toAdd = "C"; break;
                case 2 : toAdd = "C#/Db"; break;
                case 3 : toAdd = "D"; break;
                case 4 : toAdd = "D#/Eb"; break;
                case 5 : toAdd = "E"; break;
                case 6 : toAdd = "F"; break;
                case 7 : toAdd = "F#/Gb"; break;
                case 8 : toAdd = "G"; break;
                case 9 : toAdd = "G#/Ab"; break;
                case 10 : toAdd = "A"; break;
                case 11 : toAdd = "A#/Bb"; break;
                case 12 : toAdd = "B"; break;
                case 13 : toAdd = "C^"; break;
                case 14 : toAdd = "C#^/Db^"; break;
                case 15 : toAdd = "D^"; break; 
            }
            answer += " " + toAdd;
        }
        return answer;
    }
}