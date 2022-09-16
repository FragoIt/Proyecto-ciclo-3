package udea.techlogistics.demo.entities;

public enum Roles {
    ADMINISTRADOR ("Administrador"),
    OPERATIVO ("Operativo");

    private final String name;

    Roles(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
