package columbiaviajes;

import java.io.Serializable;

public class Sucursal implements Serializable{
    // Atributo
    private String code;
    private String direccion;
    private String email;
    private String telefono;
    
    // Metodos
    // Constructor
    public Sucursal(String code, String direccion, String email, String telefono) {
        this.code = code;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
    }

    // Getters
    public String getCode() {
        return code;
    }
    public String getDireccion() {
        return direccion;
    }
    public String getEmail() {
        return email;
    }
    public String getTelefono() {
        return telefono;
    }
    
    // Override
    @Override
    public String toString() {
        return ("Code: " + code +
                "\n\tDireccion: " + direccion +
                "\n\tEmail: " + email +
                "\n\tTelefono: " + telefono);
    }   
}