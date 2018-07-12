package codeu.style;

import codeu.model.store.basic.UserStore;
import org.kefirsf.bb.BBProcessorFactory;
import org.kefirsf.bb.TextProcessor;
import emoji4j.EmojiUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

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

   /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *  Method to enable emoji usage within chat
    *  @param  text         String representing user's original message with  unicode, short code,
    *                       decimal or hexadecimal html entity
    *  @return String with emojis to be ustilized in chat.jsp
    *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public static String emojifyText(String text){
     String emojified = EmojiUtils.emojify(text);
     return emojified;
   }
}
