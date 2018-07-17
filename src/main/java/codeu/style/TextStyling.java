package codeu.style;

import codeu.model.data.User;
import codeu.model.store.basic.UserStore;
import emoji4j.EmojiUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.kefirsf.bb.BBProcessorFactory;
import org.kefirsf.bb.TextProcessor;

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


   /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *  Method to style tagged users in chat differently
    *  @param  text         String representing user's original message
    *  @return String with a span wrapped around tagged usernames to assign it special styling properties
    *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public static String styleTaggedUsers(String text) {
        List<String> taggedUsers = new ArrayList<>();
        List<String> userNames = new ArrayList<>();
        List<String> validTaggedUsers = new ArrayList<>();
        String pattern = "@[A-Za-z0-9]*";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(text);
        while (m.find( )) {
          taggedUsers.add(m.group(0) );
        }
        for (String user : taggedUsers) {
          userNames.add(user.substring(1,user.length()));
        }
        for (String userName : userNames) {
          if(UserStore.getInstance().getUser(userName) != null) {
              validTaggedUsers.add(userName);
          }
        }
        String editedText = text;
        for (String user : validTaggedUsers) {
          String userWithTag = "@" + user;
          editedText = editedText.replace(userWithTag, "<span class='userMentioned'>" + userWithTag + "</span>");
        }
        return editedText;
    }
}
