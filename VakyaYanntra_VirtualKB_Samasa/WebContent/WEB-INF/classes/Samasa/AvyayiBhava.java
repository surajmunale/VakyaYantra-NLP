/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Samasa;

import VibhakthiVachana.Vibhakthi;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class AvyayiBhava {

    String upasarga[][];

    public AvyayiBhava() {
        upasarga = new String[22][3];

       list();

    }

    public void list() {
        upasarga[0][0] = "\u0909\u092A";//upa
        upasarga[0][1] = "\u0938\u092E\u0940\u092A\u0947";//sameepe
        upasarga[0][2] = "6";//take the 6th vibhakthi

        System.out.println(upasarga[0][1]);
    }

    public String check(String input) {

        int i = 0;
        String ruleword=null;
        int rulevibhakthi=-1;
        String noun;
        int nounstartindex = 0;
        String outputvib;
        Noun inputdetails = new Noun();
        Vibhakthi vib = new Vibhakthi();
        while (i < 22) {


            if (input.startsWith(upasarga[i][0])) {
                ruleword = upasarga[i][1];
                rulevibhakthi = Integer.parseInt(upasarga[i][2]);
                 System.out.println("upasarga"+upasarga[i][1]);
                nounstartindex=upasarga[i][0].length();
                break;
            }

            else
                JOptionPane.showMessageDialog(null,"Sorry!Table is under construction");
            i++;

        }
         System.out.println("upasarga"+ruleword);

        System.out.println("rulevibhakthi"+rulevibhakthi);

        noun = input.substring(nounstartindex);
 System.out.println("noun"+noun);
 //       inputdetails = vib.vibhakthiMatcher(noun);
        System.out.println("inputdetails.vibhakhti"+inputdetails.vachanam);
        if (inputdetails.antha == null) {
            JOptionPane.showMessageDialog(null, "Sorry,our vibhakthi table is under construction.Your word doesnt exist in it");
            return null;
        }
        else {
            if (inputdetails.vibhakthi == 2) {
   //             outputvib = vib.getForm(inputdetails.shabda, inputdetails.vachanam, rulevibhakthi);
        //       return(outputvib+" "+ruleword);

            }


        }
        return null;
    }/*
    public static void main(String args[]){
    System.out.println("\u0915\u0954");
    System.out.println("उप");
    String s="उप";
    System.out.println(s.compareTo("\u0909\u092A"));
    AvyayiBhava ab=new AvyayiBhava();
    ab.list();

    }*/

}
