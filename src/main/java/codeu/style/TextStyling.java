package codeu.style;

import org.kefirsf.bb.TextProcessor;
import org.kefirsf.bb.BBProcessorFactory;


public class TextStyling {
  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to convert the user's entered BBCode into styled text
   *  @param  text         String representing user's original message with BBCode
   *  @return String that has replaced the BBCode with HTML so it can be implemented in chat.jsp
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public static String BBCodeToHTML(String text) {
     TextProcessor processor = BBProcessorFactory.getInstance().create();
     return processor.process(text);
   }
   public static void main(String[] args) {
     System.out.println(BBCodeToHTML("[b]text[/b]"));
   }
 }