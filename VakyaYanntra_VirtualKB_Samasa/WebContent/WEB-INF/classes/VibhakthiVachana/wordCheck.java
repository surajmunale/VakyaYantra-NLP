package VibhakthiVachana;
import java.sql.ResultSet;
import java.util.ArrayList;
import wordProcessor.connect;

/**
 *
 * @author Priya
 */
public class wordCheck {
    String[][] swaraMapping = new String[14][2];
    ArrayList<Character> swaras = new ArrayList<Character>();
    ArrayList<Character> vowels = new ArrayList<Character>();
    ArrayList<Character> consonants = new ArrayList<Character>();
    public boolean isVowel(char character)
    {
        if(vowels.contains(character))
            return true;
        else return false;
    }
    public boolean isConsonant(char character)
    {
        if(consonants.contains(character))
            return true;
        else return false;
    }
    public boolean isSwara(char character)
    {
        if(swaras.contains(character))
            return true;
        else return false;
    }
    public wordCheck()
    {
        swaras.add('ा'); swaras.add('ि'); swaras.add('ी'); swaras.add('ु'); swaras.add('ू');
        swaras.add('े');swaras.add('ै'); swaras.add('ो');swaras.add('ौ');swaras.add('ः');

        vowels.add('आ');vowels.add('इ');vowels.add('ई'); vowels.add('उ');
        vowels.add('ऊ');vowels.add('ए');vowels.add('ऐ'); vowels.add('ओ'); vowels.add('औ');vowels.add('ः');

        consonants.add('\u0915');  consonants.add('\u0916');  consonants.add('\u0917');  consonants.add('\u0918');  consonants.add('\u0919');
        consonants.add('\u091a');  consonants.add('\u091b');  consonants.add('\u091c');  consonants.add('\u091d');  consonants.add('\u091e');
        consonants.add('\u091f');  consonants.add('\u0920');  consonants.add('\u0921');  consonants.add('\u0922');  consonants.add('\u0923');
        consonants.add('\u0924');  consonants.add('\u0925');  consonants.add('\u0926');  consonants.add('\u0927');  consonants.add('\u0928');
        consonants.add('\u092a');  consonants.add('\u092b');  consonants.add('\u092c');  consonants.add('\u092d');  consonants.add('\u092e');
        consonants.add('\u092f');  consonants.add('\u0930');  consonants.add('\u0932');  consonants.add('\u0935');  consonants.add('\u0936');
        consonants.add('\u0937'); consonants.add('\u0938'); consonants.add('\u0939');

        swaraMapping[0][0]="\u093E";  swaraMapping[0][1]="\u0906"; //ा  आ
        swaraMapping[1][0]="\u093F";  swaraMapping[1][1]="\u0907"; //ि  इ
        swaraMapping[2][0]="\u0940";  swaraMapping[2][1]="\u0908"; //ी  ई
        swaraMapping[3][0]="\u0941";  swaraMapping[3][1]="\u0909"; //ु  उ
        swaraMapping[4][0]="\u0942";  swaraMapping[4][1]="\u090a"; //ू  ऊ
        swaraMapping[5][0]="\u0943";  swaraMapping[5][1]="\u090b"; //ृ  ऋ
        swaraMapping[6][0]="\u0944";  swaraMapping[6][1]="\u0960"; //ॄ  ॠ
        swaraMapping[7][0]="\u0962";  swaraMapping[7][1]="\u090c"; //ॢ  ऌ
        swaraMapping[8][0]="\u0963";  swaraMapping[8][1]="\u0961"; //ॣ  ॡ
        swaraMapping[9][0]="\u0947";  swaraMapping[9][1]="\u090f"; //े  ए
        swaraMapping[10][0]="\u0948";  swaraMapping[10][1]="\u0910"; //ै  ऐ
        swaraMapping[11][0]="\u094b";  swaraMapping[11][1]="\u0913"; // ो  ओ
        swaraMapping[12][0]="\u094c";  swaraMapping[12][1]="\u0914"; //ौ  औ
        swaraMapping[13][0]="\u0903";swaraMapping[13][1]="\u0903";//ः
       /* for(int i=0;i<13;i++)
        {
            System.out.println(swaraMapping[i][0] +"  "+swaraMapping[i][1]);
        }*/

    }
    public String checkWord(String word)
    {

        String newWord="";
       System.out.println(word.length());
      // for(int i=0;i<word.length();i++)
           //System.out.println("characters-"+word.charAt(i));
     for(int i=0;i<word.length();i++)
     {

         char c = word.charAt(i);
       //  System.out.println("c"+c);
         char ch='0';
         if(i != word.length()-1)
             ch = word.charAt(i+1);
 // System.out.println("ch"+ch);
         if(isConsonant(c))
         {
             if(isSwara(ch))
             {
                 int index=swaras.indexOf(ch);
                 newWord=newWord+c+"\u094d"+vowels.get(index);//halanth & vowel (corresponding to the swara) addition->(र् आ)
//                 System.out.println("1st is consonant and 2nd is swara");
                 i++;
             }
             else if(isConsonant(ch) || isVowel(ch))
             {
                 newWord=newWord+c+"\u094d"+"\u0905";//halanth & 'a' sound र् अ
//                 System.out.println("1st is consonant and 2nd is vowel or consonant");
             }
             else if(ch=='\u0903')
             {
                 newWord=newWord+c+"\u094d"+"\u0905"+"\u0903";//':' addition
                 i++;
//                 System.out.println("1st is consonant and 2nd is : ");
             }
             else if(ch=='\u094d')
             {
                 newWord=newWord+c+"\u094d";//if the next character is halanth
                 i++;
//                 System.out.println("1st is consonant and 2nd is halant ");
             }
             else if(ch=='0')
             {
                 if(isConsonant(c))
                    newWord=newWord+c+"\u094d"+"\u0905";//halanth & aa
                
//                 System.out.println("1st is consonant and 2nd is 0");
             }
         }
         else if(isVowel(c))
         {
             newWord=newWord+c;
//             System.out.println("1st is a vowel");
         }

//         System.out.println("new word:"+newWord);

     }
     System.out.println(newWord);
     String r=null;
        for(int i=newWord.length()-1;i>=0 && r==null;i--)
        {
            String left="",right="";
            if(i+1<newWord.length())
            if(newWord.charAt(i+1)!='\u094d')//if the secnd last  letter is not halanth,
            {
            left=(String) newWord.subSequence(0, i+1);//split at the last halanth
            right=(String) newWord.subSequence(i + 1, newWord.length());

            left=transform(left); right=transform(right);
//            System.out.println(left+"\t right: "+right);
             r = checkPrefixSuffix(left,right);

//            System.out.println("result:" +r);
            }

        }


        return r;

    }

//    public static void main(String args[])
//    {
//        wordCheck wc = new wordCheck();
//      //  Dwanda
//      // wc.checkWord("रामरुद्रौ");
//        wc.split_words("रामरुद्रौ");
//        //System.out.println("\u0905");
//    }

    public String transform(String word)
    {
        String newWord=word;
        for(int i=0;i<word.length();i++)
        {
            if(i+1<word.length())

                if(word.charAt(i)=='\u094d' && isVowel(word.charAt(i+1)))//if a vowel follows a halanth
            {
                int index=vowels.indexOf(word.charAt(i+1));
                newWord=newWord.replaceAll("\u094d"+word.charAt(i+1) , swaras.get(index)+"");//replace the vowel by the swara
            }
            else if(word.charAt(i)=='\u094d' && word.charAt(i+1)=='\u0905')
            {
                newWord=newWord.replaceAll("\u094d"+word.charAt(i+1) ,"");
            }
        }
//        System.out.println("New word in transform function : "+newWord);
        return newWord;
    }

    public String checkPrefixSuffix(String left,String right)
    {/*  Takes the prefix and suffix of a word as the i/ps and tries to find a match for them in lexup and supsuf resptly*/
        connect c =new connect();
        ArrayList<String> leftArray = new ArrayList<String>();
        ArrayList<String> rightArray = new ArrayList<String>();
        String query1="select code from lexsup where word like '"+left+"'";
        String query2 = "select code from supsuf where word like '"+right+"'";
        String code="";
        ResultSet rs1,rs2;
        try{
            rs2=c.getResult(query2);
            while(rs2.next())
            {
                code=rs2.getString(1);
                code = code.substring(0,3);
//                System.out.println("code2: "+code);
//
                rightArray.add(code.trim());
            }

            if(!rightArray.isEmpty())
            {
                rs1=c.getResult(query1);
                while(rs1.next())
                {
                    code=rs1.getString(1);
                    code = code.substring(0, 3);
//                    System.out.println("code1: "+code);
                    leftArray.add(code.trim());
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        for(int i=0;i<leftArray.size();i++)
        {
            if(rightArray.contains(leftArray.get(i)))
             {
//              System.out.println("matching code for left and right is "+leftArray.get(i));
           //   System.out.println(left++)
              //vibhakthiGenerator(left,leftArray.get(i));
                                      return (left+"_"+leftArray.get(i));
             }


        }

        return null;
    }
   
}

