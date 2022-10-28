package modelos;

public class Permisos {

    private String name;
    private String permiso;


    public Permisos(String name, String permiso) {
        this.name = name;
        this.permiso = permiso;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermiso() {
        return permiso;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }
}
