/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Samasa;
import VibhakthiVachana.Vibhakthi;
import java.util.ArrayList;
import VibhakthiVachana.wordCheck;
import wordProcessor.*;
import java.sql.ResultSet;
import java.lang.String;
/**
 *
 * @author Preethy
 */
public class Dwanda_Old {
    ArrayList<String> splitlist;
    int splitlist_size;
    String vigraha;
    wordCheck wc;
    public Dwanda_Old(){

        splitlist=new ArrayList();
        vigraha="";


    }
    public String getVigraha(String word) {

        //1.split at every character
        //2.check in dictionary for individual words
        //3. for the last word, check the proper roopa in vibhakthi by generating it
        //4. find out the word in dictionary
        splitlist = split_words(word);//individual words
        if (splitlist != null) {
            int i;
            for (i = 0; i < splitlist.size(); i++) {
                vigraha = vigraha + splitlist.get(i) + " च ";
            }
        }

        //  vigraha=vigraha+splitlist.get(i);


        return vigraha;
    }
 public ArrayList<String> split_words(String word){

        String newword=new String();
       // String vibhakthi_roopas[];
        ArrayList<Integer> vibhakthivachanas=new ArrayList();

        try{
        wc=new wordCheck();
        newword="";
        //take each character and concatenate.search in dict. if the word is present,add to the list
            for(int i=0;i<word.length();i++){
            newword=newword+word.charAt(i);
            if(i!=word.length()-1)
            {
                if(wc.isSwara(word.charAt(i+1))||word.charAt(i+1)=='\u094d')//if the nxt character is a swara or halanth
                {
                 newword=newword+word.charAt(i+1);
                 i=i+1;
               //  word.
                }
            }
            if(dict_check(newword)){//if the word is present, add to the list.
                splitlist.add(newword);

     //           System.out.println("newword in splitword-"+newword);
                newword="";
            }

        }
   //             System.out.println("newword outside splitword-"+newword);
                //if the last word is just a swara, add it to the last word found.
                if(newword.length()==1)
                {
                    if (wc.isSwara(newword.charAt(0)))
                    {
                        splitlist.set(splitlist.size() - 1, splitlist.get(splitlist.size() - 1) + newword);
                    }
                }
                else
                {
                    splitlist.add(newword);
                }
         splitlist_size=splitlist.size();

         for(int i=0;i<splitlist_size;i++){
         System.out.println(splitlist.get(i));

         }
      String complete_last_word;//wc.checkWord(newword);//(root+code )of the last word
        while((complete_last_word=wc.checkWord(splitlist.get(splitlist.size()-1)))==null)
        {
           // System.out.println("GOT");
            splitlist=reSplit(splitlist);
     }
        splitlist_size=splitlist.size();
      //   complete_last_word=wc.checkWord(splitlist.get(splitlist_size-1));
        String last_word[]=complete_last_word.split("_");
        Vibhakthi v=new Vibhakthi();
 splitlist_size=splitlist.size();
       vibhakthivachanas= v.getVibhakthi(last_word[0], last_word[1],splitlist.get(splitlist_size - 1));
      //  System.out.println("Size of vibhakthivachanas in dwanda"+vibhakthivachanas.size());
       
        while(( vibhakthivachanas.isEmpty()))
        {
            splitlist=reSplit(splitlist);
            splitlist_size=splitlist.size();
            complete_last_word=wc.checkWord(splitlist.get(splitlist_size-1));//(root+code )of the last word
            last_word=complete_last_word.split("_");
            vibhakthivachanas= v.getVibhakthi(last_word[0], last_word[1],splitlist.get(splitlist_size - 1));
        }//something wrong here also.do a resplit{}
        //else{
       // for(int i=0;i<( v.getVibhakthi(last_word[0], last_word[1],splitlist.get(splitlist_size-1))).size();i++){

        while(( vibhakthivachanas).get(0)==1 && splitlist_size!=2){
      //if the last word is dwivachana & the size of the splitlist is not 2,some error in splitting.resplit
                splitlist=reSplit(splitlist);
                splitlist_size=splitlist.size();
                 complete_last_word=wc.checkWord(splitlist.get(splitlist_size-1));//(root+code )of the last word
                 if(complete_last_word!=null)
                 {
                     last_word = complete_last_word.split("_");
                      vibhakthivachanas= v.getVibhakthi(last_word[0], last_word[1],splitlist.get(splitlist_size - 1));
                 }
        }
            while((vibhakthivachanas).get(0)  == 2 && splitlist_size <= 2)
            {
     //if the last word is bahuvachana & the size of the splitlist is not 2,some error in splitting.resplit
            splitlist=reSplit(splitlist);
            splitlist_size=splitlist.size();
             complete_last_word=wc.checkWord(splitlist.get(splitlist_size-1));//(root+code )of the last word
            last_word=complete_last_word.split("_");
             vibhakthivachanas= v.getVibhakthi(last_word[0], last_word[1],splitlist.get(splitlist_size - 1));
        }
        
    
       
       // vibhakthivachanas= v.getVibhakthi(last_word[0], last_word[1],splitlist.get(splitlist_size-1));//find the vibhakthivachana index of the last word.for eg. lakshmanO in ramalakshmanO
        String vibhakthipada="";
        int vibhakthi_index=0;
       //  for(int i=0;i<vibhakthivachanas.size();i++){
      //  for(int i=0;i<splitlist.size()-1;i++){
            
            if(vibhakthivachanas.get(0)==2)//bahuvachana
             {
                // vibhakthi_index=(vibhakthivachanas.get(i)-2)/3;
                 vibhakthipada=v.getVibhakthiPada(2, 0,last_word[0], last_word[1]);
             }
             else if(vibhakthivachanas.get(0)==1){//dwivachana{
                  //vibhakthi_index=(vibhakthivachanas.get(i)-1)/3;
                 vibhakthipada=v.getVibhakthiPada(1, 0,last_word[0], last_word[1]);
             }
     //}
        splitlist_size=splitlist.size();
     splitlist.set(splitlist_size-1, vibhakthipada)   ;
        for(int j=0;j<splitlist_size-1;j++)
        {
               complete_last_word= wc.checkWord(splitlist.get(j));
                 last_word=complete_last_word.split("_");
                 vibhakthipada=v.getVibhakthiPada(vibhakthi_index, 0,last_word[0], last_word[1]);

                 splitlist.set(j, vibhakthipada);


        }
     return splitlist;
     }
        catch(Exception ex)
        {
            return null;
        }

        
 }
public ArrayList<String> reSplit(ArrayList<String> list){
String splitword="";
String nextword="";
int flag=0;
ArrayList<String> newList=list;
try{
    for(int i=list.size()-1;i>=1;i--){
       nextword=   list.get(i-1);
       splitword=list.get(i);
       for(int j=0;j<splitword.length();j++){
                nextword=nextword+splitword.charAt(j);

            if(dict_check(nextword)){
                flag=1;
                newList.set(i-1,nextword);
                     System.out.println("newword in RE splitword-"+nextword);

               //
                     if(j!=splitword.length()-1)
                     {
                         newList.set(i , splitword.substring(j + 1));
                     }
                     else if((j==splitword.length()-1)&&wc.isSwara(splitword.charAt(j)))
                     {
                        // newList.set(i + 1, nextword.substring(j + 1));
                          newList.set(newList.size() - 1, newList.get(newList.size() - 1) + splitword);
                          newList.remove(i);
                     }
                         
                //break;
           }
       }
       if(flag==0){
            if(splitword.length()==1)
                {
                    if (wc.isSwara(splitword.charAt(0)))
                    {
                       newList.set(newList.size() - 1, newList.get(newList.size() - 1) + splitword);
                      //     newList.set(i,splitword);
                    }
                }
 else
         newList.set(i-1,nextword);
         if(newList.size()>=(i+1))
           newList.remove(i);
            // newList.set(i+1,nextword.substring(j+1));
        }
         String complete_last_word=wc.checkWord(nextword);//(root+code )of the last word
         if(complete_last_word!=null)
         {
             String last_word[] = complete_last_word.split("_");
        Vibhakthi v=new Vibhakthi();
        ArrayList<Integer> vibhakthivachanas;
        vibhakthivachanas= v.getVibhakthi(last_word[0], last_word[1],nextword);
        if(vibhakthivachanas.size()!=0)
            break;
        }
 //else
     
    }

for(int i=0;i<newList.size();i++){
System.out.println("Newlist: "+newList.get(i));
}
    
    }
catch(Exception ex)
{
//    return null;
}
  finally{
   return newList;
  }      

    }



    public boolean dict_check(String word){

        
    connect c =new connect();
         int i=0;
        //String suffix_codes[]=new String[24];
      String word_with_halant=word+'\u094d';
        String query2 = "select word from dict where word like '"+word+"' or word like '"+word_with_halant+"' and pos='noun'";
        //String result="";
        ResultSet rs2;
        try{
            rs2=c.getResult(query2);

            if(rs2.next())
            {
              //  result=rs2.getString(1);
                //code = code.substring(0,3);
       //         System.out.println("Got a noun from dict"+rs2.getString(1));
               return true;
            }
            else
             return false;

    }
        catch(Exception e){
            e.toString();
        return false;
        }/*
        finally{
        return false;
        }*/

    }
}
