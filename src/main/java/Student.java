public class Student {

    private String Name;
    private int Age;
    private int Dzien;
    private int Miesiac;
    private int Rok;

    public Student(String name, int age, int dzien, int miesiac, int rok) {
        Name = name;
        Age = age;
        Dzien = dzien;
        Miesiac = miesiac;
        Rok = rok;
    }

    public String GetName() {return Name;}
    public int GetAge() {return Age;}
    public int GetDzien() {return Dzien;}
    public int GetMiesiac() {return Miesiac;}
    public int GetRok() {return Rok;}

    public String ToString() {
        return Name + " " + Integer.toString(Age) + " " + Integer.toString(Dzien) + "-" + Integer.toString(Miesiac) + "-" + Integer.toString(Rok);
    }

    public static Student Parse(String str) {
        String[] data = str.split("[ -]");
        if(data.length != 3)
            return new Student("Parse Error", -1, -2,-3,-4);
        return new Student(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4]));
    }
}