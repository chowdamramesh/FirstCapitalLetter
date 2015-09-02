import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
* Capitalize the First character after the fullstop(.) , Question(?), Exclamatory(!).
*/
public class FirstLetterCapital {
 	public static void main(String[] args) {
    BufferedReader read = null;
    String givenText = "";
    try {
     	String allTextFromfile;
      read = new BufferedReader(new FileReader("simple.txt"));
      while ((allTextFromfile = read.readLine()) != null) {
        givenText += allTextFromfile;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    givenText += "."; 
    String fullText =	change(givenText,".");
    String fullText1 = change(fullText,"?");
    String fullText2 = change(fullText1,"!");
    System.out.println(fullText2.substring(0,fullText2.length()-4));
	}
  /**
  *change method make changes in the given string accordingly.
  * @param obtained the string which is obtained.
  * @return the string after changing.
  */
  public static String change (String obtained,String token) {
      StringTokenizer str = new StringTokenizer(obtained,token);
      String temp = "";
      String firstLetter = "";
      String append = "";
      String fullText = "";
      String word = "";
        while(str.hasMoreTokens()){
        temp = str.nextToken();
          for(int i = 0; i <= temp.length(); i++) {
              if(Character.isSpace(temp.charAt(i))) {
                  while(Character.isSpace(temp.charAt(i))) {
                      i++;
                  }
                  i--;
              } else if (Character.isDigit(temp.charAt(i))) {
                  while(Character.isDigit(temp.charAt(i))) {
                      i++;
                  }
                  i--;
              } else if (Character.isLetter(temp.charAt(i))) {
                  while(Character.isLetter(temp.charAt(i))) {
                      word = temp.valueOf(temp.charAt(i));
                      i++;
                      break;
                  }
                  
                  firstLetter = word.toUpperCase();
                  append = firstLetter + temp.substring(i);
                  break;
              }
          }
          fullText += append + token + " ";
    }
    return fullText;
  }
}