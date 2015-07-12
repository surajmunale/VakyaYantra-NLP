/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SemanticDictionary;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import java.util.ArrayList;
import wordProcessor.db;

/**
 *
 * @author user
 */
public class SemanticDictionary {

   static ArrayList<Word> wordlist=null;
   static Model m;
   public SemanticDictionary()
    {
  


   }

    public static void main(String[] args){
 m= ModelFactory.createDefaultModel();
     db dbo=new db();
     wordlist= dbo.getSemantic("noun");
     System.out.println(wordlist.size());
     for(int i=0;i<wordlist.size();i++){
//          System.out.println(wordlist.get(i).meaning);

          Resource r=m.createResource("http://anvesh.com/word/"+wordlist.get(i).word);
          Property p=m.createProperty("http://anvesh.com/meaning");

          r.addProperty(p, wordlist.get(i).meaning);
        //  m.write(System.out, "Turtle");
     }


     // list the statements in the Model
StmtIterator iter = m.listStatements();

// print out the predicate, subject and object of each statement
while (iter.hasNext()) {
    Statement stmt      = iter.nextStatement();  // get next statement
    Resource  subject   = stmt.getSubject();     // get the subject
    Property  predicate = stmt.getPredicate();   // get the predicate
    RDFNode   object    = stmt.getObject();      // get the object

    System.out.print(subject.toString());
    System.out.print(" " + predicate.toString() + " ");
    if (object instanceof Resource) {
       System.out.print(object.toString());
    } else {
        // object is a literal
        System.out.print(" \"" + object.toString() + "\"");
    }

    System.out.println(" .");
}
    }


}
