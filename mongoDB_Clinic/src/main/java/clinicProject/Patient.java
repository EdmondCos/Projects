package clinicProject;

class Patient {
    private String name;
    private String diagnostic;

    Patient(String name, String diagnostic) {
        this.name = name;
        this.diagnostic = diagnostic;
    }

    String toJSON() {
        return "{\"name\":" + name + "\"," + "\"diagnostic\":\"" + diagnostic + "\"}";

    }
}
