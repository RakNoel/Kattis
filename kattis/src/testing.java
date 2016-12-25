import java.util.ArrayList;
import java.util.Arrays;

//Created by RakNoel, 01.12.2016.
public class testing {

    public static void main(String[] args){
        int[] a = {0,1,3,6,4,0,3,2,1,-7,-8,-2};
        System.out.println(lengsteSerie(a));
    }

    /**
     * Metode for å returnere lengden på lengste serie fra heltalls-tabell
     * som sendes inn.
     * @param a Er en heltalstabell som ønskes analysert
     * @return lengden på lengste serie etterfølgende positive eller negative tall
     */
    public static int lengsteSerie(int[] a){
        //int[] a = {0,1,3,6,4,0,3,2,1,-7,-8,-2}

        ArrayList<ArrayList> hovedTabell = new ArrayList<>();
        ArrayList<Integer> heltallTabell = new ArrayList<>();

        //For element nummer 'i' i tabellen 'a' gjør:
        for (int i = 0; i < a.length; i++) {

            if(heltallTabell.size() == 0) {
                heltallTabell.add(a[i]);
            } else if (heltallTabell.get(heltallTabell.size()-1) > 0 && a[i] > 0) {
                heltallTabell.add(a[i]);
            } else if (heltallTabell.get(heltallTabell.size()-1) < 0 && a[i] < 0) {
                heltallTabell.add(a[i]);
            } else {
                hovedTabell.add(heltallTabell);
                System.out.println(Arrays.toString(heltallTabell.toArray()));
                heltallTabell.clear(); //Sletter alle elementer i listen
            }
        }

        //For alle elementer i tabell inni tabell gjør:
        int stoersteTabell = 0;
        for (ArrayList tabellHolder : hovedTabell)
            if (tabellHolder.size() > stoersteTabell)
                stoersteTabell = tabellHolder.size();

        return stoersteTabell;

    }
}
