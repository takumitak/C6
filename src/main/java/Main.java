/*
Program sprawdza poprawność wpisywanego imienia. W przypadku wystąpienia spacji w imieniu, funkcja wyrzuca zdefiniowany wyjątek WrongStudentName, który jest wyłapywany w pętli głównej Commit6_0.
Poniższe zadania będą się sprowadzały do modyfikacji bazowego kodu. Proces modyfikacji ogólnie może wyglądać następująco:
• Ustalenie jaki błąd chcę się sprawdzić i wyłapać.
• Decyzja, czy użyje się własnej klasy wyjątku, czy wykorzysta już istniejące (np. Exception, IOException).
• Napisanie kodu sprawdzającego daną funkcjonalność. W przypadku warunku błędu wyrzucany będzie wyjątek: throw new WrongStudentName().
• W definicji funkcji, która zawiera kod wyrzucania wyjątku dopisuje się daną nazwę wyjątku, np. public static String ReadName() throws WrongStudentName.
• We wszystkich funkcjach, które wywołują powyższą funkcję także należy dopisać, że one wyrzucają ten wyjątek – inaczej program się nie skompiluje.
• W pętli głównej, w main’ie, w zdefiniowanym już try-catch dopisuje się Nazwę wyjątku i go obsługuje, np. wypisuje w konsoli co się stało.
*/

//Commit6_1. Na podstawie analogii do wyjątku WrongStudentName utwórz i obsłuż wyjątki WrongAge oraz WrongDateOfBirth. 
//Niepoprawny wiek – gdy jest mniejszy od 0 lub większy niż 100. Niepoprawna data urodzenia – gdy nie jest zapisana w formacie DD-MM-YYYY, np. 28-02-2023.

import java.io.IOException;
import java.util.Scanner;
import java.io.IOException;

class WrongStudentName extends Exception { }
class WrongStudentAge extends Exception { }
class WrongStudentDate extends Exception { }
class WrongMenu extends Exception { }

class Main {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        while(true) {
            try {
                int ex = menu();
                switch(ex) {
                    case 1: exercise1(); break;
                    case 2: exercise2(); break;
                    case 3: exercise3(); break;
                    default: return;
                }
            } catch(IOException e) {

            } catch(WrongStudentName e) {
                System.out.println("Błędne imie studenta!");
            }
            catch(WrongStudentAge e) {
                System.out.println("Błędne wiek studenta!");
            }
            catch(WrongStudentDate e) {
                System.out.println("Błędna data urodzenia studenta!");
            }
            catch(WrongMenu e) {
                System.out.println("Niepoprawny wybór!");
            }


        }
    }
    public static int menu() throws WrongMenu {
        System.out.println("Wciśnij:");
        System.out.println("1 - aby dodać studenta");
        System.out.println("2 - aby wypisać wszystkich studentów");
        System.out.println("3 - aby wyszukać studenta po imieniu");
        System.out.println("0 - aby wyjść z programu");
        int ex=scan.nextInt();
        if(ex<0 || ex>3)
            throw new WrongMenu();
        return ex;
    }

    public static String ReadName() throws WrongStudentName {
        scan.nextLine();
        System.out.println("Podaj imie: ");
        String name = scan.nextLine();
        if(name.contains(" "))
            throw new WrongStudentName();

        return name;
    }

    public static int PobierzWiek() throws WrongStudentAge{
        System.out.println("Podaj wiek: ");
        int age = scan.nextInt();
        if(age < 0 || age > 100)
            throw new WrongStudentAge();
        return age;
    } 

    public static int PobierzDataDzien() throws WrongStudentDate{
        System.out.println("Podaj dzień uridzenia: ");
        int dzien = scan.nextInt();
        if(dzien < 0 || dzien > 31)
            throw new WrongStudentDate();
        return dzien;
    }

    public static int PobierzDataMiesiac() throws WrongStudentDate{
        System.out.println("Podaj miesiąc uridzenia: ");
        int miesiac = scan.nextInt();
        if(miesiac < 0 || miesiac > 12)
            throw new WrongStudentDate();
        return miesiac;
    }

    public static int PobierzDataRok() throws WrongStudentDate{
        System.out.println("Podaj rok uridzenia: ");
        int rok = scan.nextInt();
        if(rok < 0 || rok > 2023)
            throw new WrongStudentDate();
        return rok;
    }

    public static void exercise1() throws IOException, WrongStudentName, WrongStudentAge, WrongStudentDate {
        var name = ReadName();
        var age = PobierzWiek();
        var dzien = PobierzDataDzien();
        var miesiac = PobierzDataMiesiac();
        var rok = PobierzDataRok();
        (new Service()).addStudent(new Student(name, age,dzien,miesiac,rok ));;
    }

    public static void exercise2() throws IOException {
        var students = (new Service()).getStudents();
        for(Student current : students) {
            System.out.println(current.ToString());
        }
    }

    public static void exercise3() throws IOException {
        scan.nextLine();
        System.out.println("Podaj imie: ");
        var name = scan.nextLine();
        var wanted = (new Service()).findStudentByName(name);
        if(wanted == null)
            System.out.println("Nie znaleziono...");
        else {
            System.out.println("Znaleziono: ");
            System.out.println(wanted.ToString());
        }
    }
}