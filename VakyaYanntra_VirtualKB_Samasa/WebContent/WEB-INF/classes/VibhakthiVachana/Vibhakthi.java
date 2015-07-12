/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VibhakthiVachana;

import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import wordProcessor.connect;
/**
 *
 * @author user
 *
 */
public class Vibhakthi {
   wordCheck wc;
  
   public Vibhakthi(){
        wc=new wordCheck();
    
    }
    public ArrayList<String> vibhakthiGenerator(String root, String code) {
        int i;
        ArrayList<String> suffixes = suffixExtractor(code);
          ArrayList<String> vibhakthis= new ArrayList();;
      //  if(suffixes.)
        int suffix_size=suffixes.size();
        String temp1,temp2;

        if(suffix_size>24)
        {
            for ( i = 0; i <suffix_size-1; i++) {
                if(suffixes.get(i).equals(suffixes.get(i+1))) {
                    temp1=root.concat(suffixes.get(i));
                    temp1=wc.transform(temp1);
                    temp2=root.concat(suffixes.get(i+1));
                    temp2=wc.transform(temp2);
//                    System.out.println(temp1+" "+temp2);
                    vibhakthis.add(temp1+","+temp2);
                }
                else{
                    vibhakthis.add(wc.transform(root.concat(suffixes.get(i))));
             //vibhakthis.add(wc.transform(vibhakthis.get(i)));
                }

            }
        }
        else
            {
            for(i=0;i<suffix_size;i++){
             vibhakthis.add(wc.transform(root.concat(suffixes.get(i))));
           //  vibhakthis.add((vibhakthis.get(i)));
            }
            //System.out.println(vibhakthis[i]);
        }
        String vibtext="";
        for ( i = 0; i < vibhakthis.size()-3; i = i + 3) {
           // for(int j=0;j<3;j++)
        //       System.out.print(vibhakthis.get(i) + "\t" + vibhakthis.get(i + 1) + "\t" + vibhakthis.get(i + 2) + "\n");
                   vibtext=vibtext+vibhakthis.get(i) + "   " + vibhakthis.get(i + 1) + "   " + vibhakthis.get(i + 2) + "\n";
        }
        vibhakthis.add("हे " + vibhakthis.get(0));
        vibtext=vibtext+"हे "+vibhakthis.get(0)+"   "+"हे " + vibhakthis.get(1)+"   " + "हे " + vibhakthis.get(2);
        vibhakthis.add("हे " + vibhakthis.get(1));
        vibhakthis.add("हे " + vibhakthis.get(2));
       // System.out.print("हे " + vibhakthis[0] + "\t" + "हे " + vibhakthis[1] + "\t" + "हे " + vibhakthis[2] + "\t");
        //}
        // System.out.println("");
        // JOptionPane.showMessageDialog(null,vibtext);
        return vibhakthis;

    }
    
   public ArrayList<String> suffixExtractor(String code) {
        connect c = new connect();
        int i = 0;
        ArrayList<String> suffix_codes = new ArrayList();
        ArrayList<String> suffix_words=new ArrayList();
        String query2 = "select word,code from supsuf where BINARY code like '" + code + '%' + "'";
        String word = "";
        String code_of_suffix="";
        ResultSet rs2;
        try {
            rs2 = c.getResult(query2);
            while (rs2.next()) {
                word = rs2.getString(1);
                code_of_suffix=rs2.getString(2);
                //code = code.substring(0,3);
//                System.out.println("result of suffix extraction " + word+ " "+code_of_suffix);
                suffix_codes.add(code_of_suffix.trim());
                suffix_words.add(word.trim());
                i++;
            }
//            System.out.println("SIZE OF SUFFIX_wORDS "+suffix_words.size());
            if(suffix_words.size()>24){
                int[] removal=new int[suffix_words.size()];
            for(int j=0;j<suffix_codes.size()-1;j++){

                if(suffix_codes.get(j).equals(suffix_codes.get(j+1))){
                    suffix_words.set(j,suffix_words.get(j)+","+suffix_words.get(j+1));
                   removal[j+1]=1;
//                   System.out.println("Removal in suffix extractor & suffix_words"+j+" "+suffix_words.get(j));
                }
            }
                for(int j=0;j<suffix_words.size();j++){
                    if(removal[j]==1)
                suffix_words.remove(j);
                }
           }

        } catch (Exception e) {
        //    System.out.println("CAUGHT");
            e.printStackTrace();
        } finally {
            return suffix_words;
        }
    }
    public String getVibhakthiPada(int vibhakthi,int vachana,String root,String code)
    {/*if a root word and its code are given with a vibhakthi and vachana indices, method returns
       the corresponding vibhakthi pada of the root.For eg. if root word is 'rama' and vibhakthi is 7 and vachana is 3
     the method returns rameshu which is the 7th vibhakthi bahuvachanam(7,3)*/
        ArrayList<String> vibhakthi_tbl=new ArrayList();
        vibhakthi_tbl=vibhakthiGenerator(root, code);
       return vibhakthi_tbl.get(vibhakthi*vachana);//row id * column id;
    }
    public ArrayList<Integer> getVibhakthi(String root,String code,String vibhakthipada)
    {
     /*return the vibakthi index(0-23) for an i/p root,code and the vibhakthipada.For eg. if ramasya is the vibhakthipada, the function should return 18*/
        ArrayList<Integer> matchingResults=new ArrayList();
        ArrayList<String> vibhakthi_table=new ArrayList();
        vibhakthi_table=vibhakthiGenerator(root, code);
        for(int i=0;i<vibhakthi_table.size();i++){
         if(vibhakthipada.equals(vibhakthi_table.get(i)))
         {
             matchingResults.add(i);
         }
        }

        return matchingResults;//row id * column id;
    }
    }


    /*  String p_akaranth_krishna[][];
    String s_aakaranth_seetha[][];
    String n_akaranth_vanam[][];
    String p_ikaranth_hari[][];


    public  Vibhakthi(){
    p_akaranth_krishna=new String[9][3];//(0,0) antha,(0,1)-linga,(0,2)=shabda
    s_aakaranth_seetha=new String[9][3];
    n_akaranth_vanam=new String[9][3];
    p_ikaranth_hari=new String[9][3];

    p_akaranth_krishna[0][0]="अकारान्त:";p_akaranth_krishna[0][1]="0";p_akaranth_krishna[0][2]="क्रिष्ण";
    p_akaranth_krishna[1][0]="क्रिष्ण:";p_akaranth_krishna[1][1]="क्रिष्णौ:";p_akaranth_krishna[1][2]="क्रिष्णा:";
    p_akaranth_krishna[2][0]="क्रिष्णं";p_akaranth_krishna[2][1]="क्रिष्णौ";p_akaranth_krishna[2][2]="क्रिष्णान्";
    p_akaranth_krishna[3][0]="क्रिष्णेन";p_akaranth_krishna[3][1]="क्रिष्णाभ्याम्";p_akaranth_krishna[3][2]="क्रिष्णै:";
    p_akaranth_krishna[4][0]="क्रिष्णाय";p_akaranth_krishna[4][1]="क्रिष्णाभ्याम्";p_akaranth_krishna[4][2]="क्रिष्णेभ्य्:";
    p_akaranth_krishna[5][0]="क्रिष्णात्";p_akaranth_krishna[5][1]="क्रिष्णाभ्याम्";p_akaranth_krishna[5][2]="क्रिष्णेभ्य:";
    p_akaranth_krishna[6][0]="क्रिष्णस्य";p_akaranth_krishna[6][1]="क्रिष्णयो:";p_akaranth_krishna[6][2]="क्रिष्णानाम्";
    p_akaranth_krishna[7][0]="क्रिष्णेन";p_akaranth_krishna[7][1]="क्रिष्णयो:";p_akaranth_krishna[7][2]="क्रिष्णेषु";
    p_akaranth_krishna[8][0]="हे क्रिष्ण:";p_akaranth_krishna[8][1]="हे क्रिष्णौ:";p_akaranth_krishna[8][2]="हे क्रिष्णा:";


    s_aakaranth_seetha[0][0]="आकारन्त्";s_aakaranth_seetha[0][1]="1";s_aakaranth_seetha[0][2]="सीता";
    s_aakaranth_seetha[1][0]="सीता";s_aakaranth_seetha[1][1]="सीते";s_aakaranth_seetha[1][2]="सीता:";
    s_aakaranth_seetha[2][0]="सीताम्";s_aakaranth_seetha[2][1]="सीते";s_aakaranth_seetha[2][2]="सीता:";
    s_aakaranth_seetha[3][0]="सीतया";s_aakaranth_seetha[3][1]="सीताभ्याम्";s_aakaranth_seetha[3][2]="सीताभि:";
    s_aakaranth_seetha[4][0]="सीतायै";s_aakaranth_seetha[4][1]="सीताभ्याम्";s_aakaranth_seetha[4][2]="सीताभ्य:";
    s_aakaranth_seetha[5][0]="सीताया:";s_aakaranth_seetha[5][1]="सीताभ्याम्";s_aakaranth_seetha[5][2]="सीताभ्य:";
    s_aakaranth_seetha[6][0]="सीताया:";s_aakaranth_seetha[6][1]="सीतयो:";s_aakaranth_seetha[6][2]="सीतानाम्";
    s_aakaranth_seetha[7][0]="सीतायाम्";s_aakaranth_seetha[7][1]="सीतयो:";s_aakaranth_seetha[7][2]="सीतासु";
    s_aakaranth_seetha[8][0]="हे सीता";s_aakaranth_seetha[8][1]="हे सीते";s_aakaranth_seetha[8][2]="हे सीता:";

    p_ikaranth_hari[0][0]="इकारान्त्";p_ikaranth_hari[0][1]="0";p_ikaranth_hari[0][1]="हरि";
    p_ikaranth_hari[1][0]="हरि:";p_ikaranth_hari[1][1]="हरी";p_ikaranth_hari[1][2]="हरयः";
    p_ikaranth_hari[8][0]="हे हरे";p_ikaranth_hari[8][1]="हे हरी";p_ikaranth_hari[8][2]="हे हरयः";
    p_ikaranth_hari[2][0]="हरिम्";p_ikaranth_hari[2][1]="हरि";p_ikaranth_hari[2][2]="हरिन्";
    p_ikaranth_hari[4][0]="हरिणा";p_ikaranth_hari[4][1]="हरिभ्यां";p_ikaranth_hari[4][2]="हरिभिः";
    p_ikaranth_hari[5][0]="हरिणा";p_ikaranth_hari[5][1]="हरिभ्यां";p_ikaranth_hari[5][2]="हरिभिः";
    p_ikaranth_hari[6][0]="हरये";p_ikaranth_hari[6][1]="हरिभ्यां";p_ikaranth_hari[6][2]="हरिभ्यः";
    p_ikaranth_hari[7][0]="हरेः";p_ikaranth_hari[7][1]="हर्योः";p_ikaranth_hari[7][2]="हरीणाम्";
    p_ikaranth_hari[8][0]="हरौ";p_ikaranth_hari[8][1]="हर्यो:";p_ikaranth_hari[8][2]="हरिषु";
    }

    public Noun vibhakthiMatcher(String noun){
    int i=1;
    Noun n=new Noun();

    while(i<9){
    if(noun.compareTo(p_akaranth_krishna[i][0])==0){
    n.antha="अकारन्त्";
    n.shabda="क्रिष्ण";
    n.linga=0;
    n.vibhakthi=i;
    n.vachanam=0;
    break;
    }
    else if(noun.compareTo(p_akaranth_krishna[i][1])==0){
    n.antha="अकारन्त्";
    n.shabda="क्रिष्ण";
    n.linga=0;
    n.vibhakthi=i;
    n.vachanam=1;
    break;
    }
    else if(noun.compareTo(p_akaranth_krishna[i][2])==0){
    n.antha="अकारन्त्";
    n.shabda="क्रिष्ण";
    n.linga=0;
    n.vibhakthi=i;
    n.vachanam=2;
    break;
    }
    else if(noun.compareTo(s_aakaranth_seetha[i][0])==0){
    n.antha="आकारन्त्";
    n.shabda="सीता";
    n.linga=1;//Sthree
    n.vibhakthi=i;
    n.vachanam=0;
    break;

    }
    else if(noun.compareTo(s_aakaranth_seetha[i][1])==0){

    n.antha="आकारन्त्";
    n.shabda="सीता";
    n.linga=1;//Sthree
    n.vibhakthi=i;
    n.vachanam=1;
    break;
    }
    else if(noun.compareTo(s_aakaranth_seetha[i][2])==0){

    n.antha="आकारन्त्";
    n.shabda="सीता";
    n.linga=1;//Sthree
    n.vibhakthi=i;
    n.vachanam=2;
    break;
    }
    else{
    n.antha=null;

    }
    i++;

    }
    return n;


    }

    public String getForm(String shabda,int vachanam,int rowno){

    if(vachanam!=0&&vachanam!=1&&vachanam!=2)
    {
    JOptionPane.showMessageDialog(null,"Invalid vachanam");
    return null;
    }
    if( 8<rowno||rowno<0)
    {
    JOptionPane.showMessageDialog(null,"Invalid vibhakthi");
    return null;
    }
    if(shabda.equals(p_akaranth_krishna[0][2]))
    return p_akaranth_krishna[rowno][vachanam];
    
    else if(shabda.equals(s_aakaranth_seetha[0][2]))
    return s_aakaranth_seetha[rowno][vachanam];

    else
    {
    JOptionPane.showMessageDialog(null,"Sorry.Vibhakthi table under construction. Your word is not present in it now");
    return null;
    }
    }
    }*/
