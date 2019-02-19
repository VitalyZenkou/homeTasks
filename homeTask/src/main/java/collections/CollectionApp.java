package collections;

import collections.first.PairMaxIterable;
import collections.second.textApp.Text;
import collections.second.textApp.TextUtil;
import homeTaskGeneric.firstSecond.Pair;

import java.util.Arrays;

public class CollectionApp {

    private static String text = "Anyone who reads Old and Middle English literary texts will be familiar with the mid-brown volumes of the EETS, with the symbol of Alfred's jewel embossed on the front cover. Most of the works attributed to King Alfred or to Aelfric, along with some of those by bishop Wulfstan and much anonymous prose and verse from the pre-Conquest period, are to be found within the Society's three series; all of the surviving medieval drama, most of the Middle English romances, much religious and secular prose and verse including the English works of John Gower, Thomas Hoccleve and most of Caxton's prints all find their place in the publications. Without EETS editions, study of medieval English texts would hardly be possible.";
    public static void main(String[] args) {

        for (Integer integer : new PairMaxIterable(Arrays.asList(new Pair<>(1, 4), new Pair<>(6, 11), new Pair<>(17, 19)))) {
            System.out.println(integer);
        }

        TextUtil.countUniqueWords(new Text(text));
    }
}
