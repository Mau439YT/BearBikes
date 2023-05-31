package com.example.bearbikes.modeles;

public class DueñoTaller {

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPat() {
        return apellidoPat;
    }

    public void setApellidoPat(String apellidoPat) {
        this.apellidoPat = apellidoPat;
    }

    public String getApellidoMat() {
        return apellidoMat;
    }

    public void setApellidoMat(String apellidoMat) {
        this.apellidoMat = apellidoMat;
    }

    public String getNumerocelular() {
        return numerocelular;
    }

    public void setNumerocelular(String numerocelular) {
        this.numerocelular = numerocelular;
    }

    public String getRfcFisica() {
        return rfcFisica;
    }

    public void setRfcFisica(String rfcFisica) {
        this.rfcFisica = rfcFisica;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "DueñoComercio{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidoPat='" + apellidoPat + '\'' +
                ", apellidoMat='" + apellidoMat + '\'' +
                ", numerocelular='" + numerocelular + '\'' +
                ", rfcFisica='" + rfcFisica + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public DueñoTaller(String email, String password, String nombre, String apellidoPat, String apellidoMat, String numerocelular, String rfcFisica, String type) {
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.apellidoPat = apellidoPat;
        this.apellidoMat = apellidoMat;
        this.numerocelular = numerocelular;
        this.rfcFisica = rfcFisica;
        this.type = type;
    }

    private String email;
    private String password;
    private String nombre;
    private String apellidoPat;
    private String apellidoMat;
    private String numerocelular;
    private String rfcFisica;
    private String type;

}
