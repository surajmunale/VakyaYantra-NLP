package wordProcessor;

import SemanticDictionary.Word;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author priya
 */
public class db {

    connect c;

    public db() {
        c = new connect();
    }
    public void closeConnection() throws SQLException
    {
        c.closeConnection();
    }
    public String findMeaning(String word) {

        String meaning = null;
        ResultSet S = null, s1 = null;
        String string, r, q, q2;
        try {
            q = "select meaning,word from Dict where word like '" + word + "'";
            S = c.getResult(q);
            if (S.next()) {
                meaning = S.getString(1);
            }
        } catch (Exception e) {
        }

        return meaning;
    }

    String symbolMap(String symbol) {
        String map = null;
        connect c = new connect();

        ResultSet S = null, s1 = null;
        String string, r, q, q2;

        try {
            q = "select symbol from symbolMapping where map='" + symbol + "' ";
            S = c.getResult(q);
            if (S.next()) {
                map = S.getString(1);
            }
        } catch (Exception e) {
        }
        return map;
    }
     public ArrayList<Word> getSemantic(String pos)
     {

       connect c = new connect();

        ResultSet S = null;
        String string, q, word,meaning,translation;
        ArrayList<Word> wordlist=new ArrayList<Word>();
        try {
            q = "select word,translation,meaning from dict where pos='"+ pos + "' ";
            S = c.getResult(q);
            //System.out.println(S)
            while (S.next()) {
               word= S.getString(1);
               translation= S.getString(2);
               meaning= S.getString(3);
               Word w=new Word(word,meaning,pos,translation);
               //word= S.getString(1);
               wordlist.add(w);
            }

        } catch (Exception e) {
        }
        return wordlist;

     }
   public String getMap(String symbol) {
        String map = null;
        connect c = new connect();

        ResultSet S = null, s1 = null;
        String string, r, q, q2;

        try {
            q = "select map from symbolMapping where symbol='" + symbol + "' ";
            S = c.getResult(q);
            if (S.next()) {

                map = S.getString(1);
            }
        } catch (Exception e) {
        }
        return map;
    }

    String getUnicodeMap(char symbol) {
        String map = null;
        connect c = new connect();

        ResultSet S = null, s1 = null;
        String string, r, q, q2;

        try {
            q = "select english from characterMapping where sanskrit='" + symbol + "' ";
            S = c.getResult(q);

            if (S.next()) {
                map = S.getString(1);
            } else {
                q = "select english from swaraMapping where sanskrit='" + symbol + "'";
                S = c.getResult(q);
                if (S.next()) {
                    map = S.getString(1);
                }
            }
        } catch (Exception e) {
        }
        return map;
    }

    String getCharMap(String symbol, int position) {

      
        String map = null;
        connect c = new connect();

        ResultSet S = null, s1 = null;
        String string, r, q, q2;

        if (position == 0) {
    
            try {
                q = "select sanskrit from characterMapping where english='" + symbol + "' ";
                S = c.getResult(q);

                if (S.next()) {
                    map = S.getString(1);
                   
                }
            } catch (Exception e) {
            }
            return map;
        } else {
            try {
            
                q = "select sanskrit from swaraMapping where english='" + symbol + "'";
                S = c.getResult(q);

                if (S.next()) {
                    map = S.getString(1);
                } else {
                    q = "select sanskrit from characterMapping where english='" + symbol + "'";
                    S = c.getResult(q);
                    if (S.next()) {
                        map = S.getString(1);
                    }
                }
            } catch (Exception e) {
            }

        }
        return map;
    }
}
 
    

