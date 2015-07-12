package VibhakthiVachana;

/*
 * Get a word from the user. Identify its pos & IF noun, get its vibhakthi & vachana. Give the root word and meaning.
 */


import java.util.ArrayList;


/**
 *
 * @author user
 */
public class AnveshVibhakthi {

    
    wordCheck wc=new wordCheck();
    public String findWord(String word)//Takes a word in devnagari form and finds out the pos and vibhakthi.
    {
        String details=null;
        details=wc.checkWord(word);
        System.out.println(details);
        return details;
    }
    public static void main(String args[])
    {
        try{
        AnveshVibhakthi vib=new AnveshVibhakthi();
        String word="इन्द्रेभ्यः";
        String vibhakthivachana=null;
         vibhakthivachana=vib.getVibhakthiVachana(word);
        }
        catch(Exception ex){
        //System.out.println("Sorry, the word is not present in the dictionary");
            ex.printStackTrace();
        }
    }
    public String getVibhakthiVachana(String word){
        int index=-1,rowid,columnid;
        String vibhakthi=null,vachana=null;

        try{
        Vibhakthi v=new Vibhakthi();

        
       String complete_last_word=findWord(word);

        String last_word[]=complete_last_word.split("_");//get root word of each individual word
        ArrayList<Integer> vibhakthivachanas=new ArrayList();
        vibhakthivachanas= v.getVibhakthi(last_word[0], last_word[1],word);
    for(int i=0;i<vibhakthivachanas.size();i++){

         index=vibhakthivachanas.get(i);
         int row_founder=(index)/3;
         int col_founder=index%3;

         switch(col_founder){

             case 0: columnid=0;
                     vachana="ekavachana_singular";
                     break;
             case 1: columnid=1;
                     vachana="dwivachana_dual";
                     break;
             case 2: columnid=2;
                     vachana="bahuvachana_plural";
                     break;
         }
           switch(row_founder){

             case 0: rowid=0;
                     vibhakthi="pradhama";
                     break;
             case 1: rowid=1;
                     vibhakthi="dwitheeya";
                     break;
             case 2: rowid=2;
                      vibhakthi="tritheeya";
                     break;

             case 3: rowid=3;
                     vibhakthi="chathurthy";
                     break;
             case 4: rowid=4;
                     vibhakthi="panchami";
                     break;
             case 5: rowid=5;
                      vibhakthi="shashti";
                     break;

             case 6: rowid=6;
                     vibhakthi="sapthami";
                     break;
             case 7: rowid=7;
                     vibhakthi="sambodhana";
                     break;
         }
         
         //if(index % 8==2)
              System.out.println(vibhakthi+" "+vachana);
            }
        
  

     }
        catch(Exception ex)
        {
            ex.printStackTrace();
            System.out.println("Sorry, word was not entered correctly.Please check the input");
        }
        finally{
     return(vibhakthi+vachana);
    }}

}
