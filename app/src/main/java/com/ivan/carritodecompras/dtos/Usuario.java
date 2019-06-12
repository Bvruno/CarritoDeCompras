package com.ivan.carritodecompras.dtos;

public class Usuario {
    private String correo;
    private String clave;
    private String pregunta;
    private String respuesta;

    public Usuario(String correo, String clave) {
        this.correo = correo;
        this.clave = clave;
    }
    public Usuario(String correo, String clave, String pregunta, String respuesta) {
        this.correo = correo;
        this.clave = clave;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    public Usuario(String correo) {
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}
