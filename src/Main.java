import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main {
    public static String replace(String input) // Метод для поиска и замены паттерна
    {
        Pattern pattern = Pattern.compile("\\[\\{\"image\":\"(.*?)\"}]"); // Сам паттерн
        Matcher matcher = pattern.matcher(input); // Поиск
        StringBuffer output = new StringBuffer();
        while (matcher.find()) {
            String match = matcher.group(1);
            String replacement = "<img src=\"" + match + "\" alt=\"" + match.substring(match.lastIndexOf("/") + 1) + "\">"; // То, как должен выглядеть конечный рез-тат
            matcher.appendReplacement(output, replacement); // Замена
        }
        matcher.appendTail(output); // Завершение замены
        return output.toString(); // Возврат значения
    }

    public static void main(String[] args) {
        String input = "На этой картинке изображён ребенок осла: [{\"image\":\"img_example.png\"}]";
        String output = Main.replace(input);
        System.out.println(output); // Вывод
    }
}