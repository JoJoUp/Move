import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

/**
 * Класс для перемещения файлов из одной директории в другую.
 * Выводит количество перемещенных файлов.
 *
 * @author Стрыгин М.О. 16ИТ18к
 */

public class MoveFiles {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите путь к папке из которой надо скопировать файлы");

        Path pathSource = Paths.get(scanner.nextLine());
        System.out.println("Введите путь к папке в которую нужно скопировать файлы");
        Path pathDestination = Paths.get(scanner.nextLine());

        int fileCounter = moveFiles(pathSource,pathDestination);

        System.out.println("Количество перемещенных файлов: " + fileCounter);

    }

    /**
     * Метод для перемещения файлов из каталога-источника в каталог-приемник
     * @param pathSource путь до каталога-источника
     * @param pathDestination путь до каталога-приемника
     * @return количество пермещенных файлов
     */
   private static int moveFiles(Path pathSource, Path pathDestination) {
        int fileCounter = 0;
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(pathSource)){
            for (Path file : stream) {
                fileCounter++;
                Files.move(file, Paths.get(pathDestination.toString() + "\\" + file.getFileName()));
                System.out.println("Файл " + file.getFileName() + " успешно перемещен");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileCounter;
   }
}

