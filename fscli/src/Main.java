import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Выбор языка
        System.out.println("Select the language for help (1 - English, 2 - Russian):");
        int languageChoice = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера после ввода числа

        System.out.println("My FS 1.0 commands:");

        // Вывод справки на выбранном языке
        switch (languageChoice) {
            case 1:
                MyFile.helpEnglish();
                break;
            case 2:
                MyFile.helpRussian();
                break;
            default:
                System.out.println("An invalid language is selected. The default English language is used.");
                MyFile.helpEnglish();
        }

        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine();
            String[] parts = command.split(" ");
            String cmd = parts[0];
            String path = parts.length > 1 ? parts[1] : null;
            String permissions = parts.length > 2 ? parts[2] : null;

            switch (cmd) {
                case "ls":
                    MyFile.listDirectory(path);
                    break;
                case "ls_py":
                    MyFile.listPythonFiles(path);
                    break;
                case "is_dir":
                    MyFile.isDirectory(path);
                    break;
                case "define":
                    MyFile.define(path);
                    break;
                case "readmod":
                    MyFile.printPermissions(path);
                    break;
                case "setmod":
                    MyFile.setPermissions(path, permissions);
                    break;
                case "cat":
                    MyFile.printContent(path);
                    break;
                case "append":
                    MyFile.appendFooter(path);
                    break;
                case "bc":
                    MyFile.createBackup(path);
                    break;
                case "greplong":
                    MyFile.printLongestWord(path);
                    break;
                case "help":
                    // Вывод справки на выбранном языке при запросе справки
                    switch (languageChoice) {
                        case 1:
                            MyFile.helpEnglish();
                            break;
                        case 2:
                            MyFile.helpRussian();
                            break;
                        default:
                            System.out.println("An invalid language is selected. The default English language is used.");
                            MyFile.helpEnglish();
                    }
                    break;
                case "exit":
                    MyFile.exit();
                    return;
                default:
                    System.out.println("Unknown command. Type 'help' for a list of commands.");
            }
        }
    }
}
