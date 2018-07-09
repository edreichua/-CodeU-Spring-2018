package codeu.style;

import codeu.model.store.basic.UserStore;
import org.kefirsf.bb.BBProcessorFactory;
import org.kefirsf.bb.TextProcessor;
import emoji4j.EmojiUtils;
import java.util.*;

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

  // regular expression to parse from string to space into an array than go through the array and see if it is a valid user
  // split text by the regular expression = an array of strings
  // go through array and check if it is valid user
  // substring to remove @
  // .replace

    public static String styleUserTags2(String text) {
        // putting tagged user names in an array
        String[] taggedUsers = text.split("@[A-Za-z0-9]*");
        String[] userNames = new String[1];
        String[] validTaggedUsers = new String[1];
        int count = 0;
        for (String user : taggedUsers) {
          userNames[count] = user.substring(1,user.length());
          count++;
        }
        int count2 = 0;
        for (String userName : userNames) {
          if(UserStore.getInstance().getUser(userName) != null) {
              validTaggedUsers[count2] = userName;
            }
          }
        String editedText = "";
        for (String users : validTaggedUsers) {
          editedText = text.replace(users, "<span id='userMentioned'>" + "@" + users + "</span>");
        }
        return editedText;
      }

   public static void main(String[] args) {
      System.out.println("here");
     TextSyle x = new TextStyle();
     System.out.println(x.styleUserTags2(“@j”));
    //  System.out.println(styleUserTags2("hi @Talia"));
    //  System.out.println(styleUserTags2("@j"));
    //  System.out.println(styleUserTags("@Talia"));
    //  System.out.println(styleUserTags("@Patrick"));
  }
}
