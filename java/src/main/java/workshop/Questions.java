package workshop;

import java.util.HashMap;
import java.util.LinkedList;

public class Questions {
    private HashMap<String,LinkedList<String>>question;
    private String catagories[] = {"Pop","Science","Sports","Rock"};
   public  Questions(){
       question = new HashMap<>();
   }
   public void generateQuestions(){
       for(String catagory : catagories){
           LinkedList<String> ques = new LinkedList<>();
           for(int i=0; i<50; i++){
               ques.addLast(createQuestion(catagory,i));
           }
           question.put(catagory,ques);
       }

   }

    public String createQuestion(String catagory, int index){
       String strReturn = catagory+" Question "+ index;
       return strReturn;
    }

    public String getQuestion(String catagory){
       String strReturn = question.get(catagory).removeFirst();
       return strReturn;
    }
}
