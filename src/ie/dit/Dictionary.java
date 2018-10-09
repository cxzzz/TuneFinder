package ie.dit;

import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedReader;


public class Dictionary
{
    ArrayList<String> words = new ArrayList<String>();

    public Dictionary()
    {
        loadDictionary();
    }

    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        for(String word:words)
        {
            sb.append(word + ", ");
        }

        return sb.toString();


        // Or use a string
        /*
        String s = "";
        for(String word:words)
        {
            s += word + ", ";
        }

        return s;
        */
    }

    public String[] findClosest(String toFind, int howMany)
    {
/*
      // result for holding those closest words
      String[] result = new String[10];
      // init a new ArrayList
      ArrayList<Words> edOfAll = new ArrayList<Words>();
      // init a temp for add words into ArrayList edOfAll
      Words temp = null;
      for (int i = 0; i < howMany; i++) {
        // find the word's Edit Distance and store it with the word
        temp = new Words(words.get(i), EditDistance.MinimumEditDistance(toFind, words.get(i)));
        // add it onto the ArrayList
        edOfAll.add(temp);
      }

      // sort the arraylist by it's edit distance
      Collections.sort(edOfAll);

      // add them onto the String array
      for (int i = 0; i < 10; i++) {
        result[i] = edOfAll.get(i).word;
      }

      // return the result of the cloest 10 searches
      return result;
*/
        ArrayList<Match> matches = new ArrayList<Match>();
        for(String w:words)
        {
            int ed = EditDistance.minimumEditDistance(
                toFind
                , w);
            matches.add(new Match(w, ed));
        }
        Collections.sort(matches);
        String[] ret = new String[howMany];
        for(int i = 0 ; i < howMany ; i ++)
        {
            ret[i] = matches.get(i).getWord();
        }
        return ret;
    }

    public String findClosest(String word)
    {
        int closestEd = Integer.MAX_VALUE;
        String closestWord = "";
        for(String w:words)
        {
            int ed = EditDistance.minimumEditDistance(word, w);
            if (ed == 0)
            {
                return word;
            }
            if (ed < closestEd)
            {
                closestEd = ed;
                closestWord = w;
            }
        }
        return closestWord;
    }

    public void loadDictionary()
    {

        // Adapted from: https://docs.oracle.com/javase/tutorial/essential/io/charstreams.html
        BufferedReader inputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("words.txt"));
            String l;
            while ((l = inputStream.readLine()) != null) {
                words.add(l);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (inputStream != null) {
                try
                {
                    inputStream.close();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
