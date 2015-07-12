/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Samasa;

//package Samasa;
import VibhakthiVachana.Vibhakthi;
import java.util.ArrayList;
import VibhakthiVachana.wordCheck;
import wordProcessor.*;
import java.sql.ResultSet;
import java.lang.String;
/**
 *
 * @author user
 */
public class Dwanda_Formatted {
 ArrayList<String> splitlist;
    int splitlist_size;
    String vigraha;
    wordCheck wc;
    public Dwanda_Formatted(){

        splitlist=new ArrayList();
        vigraha="";
     }

	public String getVigraha(String word){
   //  String word_array[]=new String[]();
    //1.split 2.check in dictionary for individual words 3. for the last word, check the proper roopa in vibhakthi by generating it 4. find out the word in dictionary
     String word_array[] =word.split("-");//individual words
     ArrayList<Integer> vibhakthivachanas=new ArrayList();
     String vibhakthi_array[]=word_array;//copy of wrds
     Vibhakthi v=new Vibhakthi();
     wc=new wordCheck();
      String complete_last_word =wc.checkWord(word_array[word_array.length-1]);//take each word and find the codes
      if(complete_last_word!=null){
       String last_word[]=complete_last_word.split("_");//get root word of each individual word
     vibhakthivachanas= v.getVibhakthi(last_word[0], last_word[1],word_array[word_array.length-1]);
         String vibhakthipada="";
        if((vibhakthivachanas.get(0))==2)//bahuvachana
             {
                 //vibhakthi_index=(vibhakthivachanas.get(0));
                 vibhakthipada=v.getVibhakthiPada(2, 0,last_word[0], last_word[1]);
             }
             else if((vibhakthivachanas.get(0))==1){//dwivachana{
                //  vibhakthi_index=(vibhakthivachanas.get(i)-1)/3;
                 vibhakthipada=v.getVibhakthiPada(1, 0,last_word[0], last_word[1]);
             }
            vibhakthi_array[word_array.length-1]=vibhakthipada;

        int vibhakthi_index=0;
         for(int i=0;i<word_array.length-1;i++){

complete_last_word= wc.checkWord(word_array[i]);
if(complete_last_word!=null){
                 last_word=complete_last_word.split("_");
                 if(last_word!=null){
             if((vibhakthivachanas.get(0))==2)//bahuvachana
             {
                 //vibhakthi_index=(vibhakthivachanas.get(0));
                 vibhakthipada=v.getVibhakthiPada(2, 0,last_word[0], last_word[1]);
             }
             else if((vibhakthivachanas.get(0))==1){//dwivachana{
                //  vibhakthi_index=(vibhakthivachanas.get(i)-1)/3;
                 vibhakthipada=v.getVibhakthiPada(1, 0,last_word[0], last_word[1]);
             }
             }
             vibhakthi_array[i]=vibhakthipada;
     }
         }}
     for(int i=0;i<vibhakthi_array.length;i++){
         vigraha=vigraha+vibhakthi_array[i]+ " च ";
 }
      return vigraha;
    }
}
