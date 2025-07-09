package modelo.dto;

public class MascotaDTO {
    private String codigo;
    private String nombre;
    private String especie;
    private String raza;
    private int edad;
    private String documentoPropietario;

    public MascotaDTO() {}

    public MascotaDTO(String codigo, String nombre, String especie, String raza, int edad, String documentoPropietario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.documentoPropietario = documentoPropietario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDocumentoPropietario() {
        return documentoPropietario;
    }

    public void setDocumentoPropietario(String documentoPropietario) {
        this.documentoPropietario = documentoPropietario;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + "\n" +
                "Nombre: " + nombre + "\n" +
                "Especie: " + especie + "\n" +
                "Raza: " + raza + "\n" +
                "Edad: " + edad + "\n" +
                "Documento del Propietario: " + documentoPropietario + "\n";
    }
}