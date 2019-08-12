package clinicProject.entities;

public class Patient {
    private String name;
    private String diagnostic;;

    public Patient(String name, String diagnostic) {
        this.name = name;
        this.diagnostic = diagnostic;
    }

    String toJSON(){
        return "{\"name\":\"" + name + "\",\"diagnostic\":\"" + diagnostic + "\"}";
    }
}
