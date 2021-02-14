package PPJ_01.Z21;

public class Test {
    public static void main(String[] args) {
        Patient[] patients = {
                new IllHead("Johny"),
                new IllLeg("Eddy"),
                new IllDyspepsia("Manny")
        };
        for (Patient p : patients) {
            System.out.println("Patient: " +
                    p.name() + '\n' + "Illness: " +
                    p.illness() + '\n' + "Treatment: " +
                    p.treatment() + "\n\n"
            );
        }
    }
}
class IllLeg extends Patient {
    private String illness = "Leg", treatment = "cut it, just cut it";
    IllLeg(String name){super(name); super.illness = illness; super.treatment = treatment;}
}
class IllDyspepsia extends Patient {
    private String illness = "Dyspepsia", treatment = "kiss it till it's okay";
    IllDyspepsia(String name){super(name); super.illness = illness; super.treatment = treatment;}
}
class IllHead extends Patient {
    private String illness = "Head", treatment = "you're retarded";
    IllHead(String name){super(name); super.illness = illness; super.treatment = treatment;}
}
class Patient {
    String name, illness, treatment;
    Patient(String name){this.name = name;}
    public String name(){return name;}
    public String illness(){return illness;}
    public String treatment(){return treatment;}
}