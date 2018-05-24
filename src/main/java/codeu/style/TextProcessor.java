  package codeu.style;

// imports?
  public interface TextProcessor {
    public CharSequence process(CharSequence source);
    public String process(String source);
    public StringBuilder process(StringBuilder source);
    public StringBuffer process(StringBuffer source);

    public class TextStyling implements TextProcessor {

      public static String bbcode(String text) {
        String styledText = "";
        TextProcessor processor = BBProcessorFactory.getInstance().create();
        styledText = (processor.process("[b]text[/b]"));
        System.out.println(styledText);

        styledText = (processor.process("[i]text[/i]"));

        styledText = (processor.process("[u]text[/u]"));

        styledText = (processor.process("[url]text[/url]"));

        styledText = (processor.process("[img]text[/img]"));

        styledText =  (processor.process("[list]*text[/list]"));
    }
  }
}
