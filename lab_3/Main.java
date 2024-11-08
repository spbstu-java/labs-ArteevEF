package Lab3;

import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary ();
        Path path = Path.of(".\\dictionary.txt");
        try {
            dictionary.fileReader(path);
        }
        catch (FileReadException | InvalidFileFormatException e) {
            System.err.println("Ошибка:" + e.getMessage());
        }

        Scanner console = new Scanner(System.in);
        String text = console.nextLine().toLowerCase();
        //для примера
        //one one one slone two two one HELLO ONE ONE twotwo hello two hello
        Translator translator = new Translator();

        System.out.println(translator.translate (dictionary, text));

        console.close();
    }
}
