package red.social;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Login{
    private String Nombre;
    private char Genero;
    private String[]Usuario=new String[100];
    private String[]Contraseña=new String[100];
    private String[] FechaIngreso=new String[100];
    private int Edad;
    private boolean[]Activa=new boolean[100];
    private static int Contar=0;
    private String MasUsuarios;
    private String OtraContra;
    
    public Login() {
        
    }

    public Login(String Nombre, char Genero, String Usuario, String Contraseña, Date FechaIngreso, int Edad, boolean Activa) {
        this.Nombre = Nombre;
        this.Genero = Genero;
        this.Edad = Edad;
        this.MasUsuarios= Usuario;
        this.OtraContra=Contraseña;
        
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public char getGenero() {
        return Genero;
    }

    public void setGenero(char Genero) {
        this.Genero = Genero;
    }

    public String[] getUsuario() {
        return Usuario;
    }

    public void setUsuario(String[] Usuario) {
        this.Usuario = Usuario;
    }

    public String[] getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String[] Contraseña) {
        this.Contraseña = Contraseña;
    }

    public String[] getFecha() {
        return FechaIngreso;
    }

    public void setFecha(String[] Fecha) {
        this.FechaIngreso = Fecha;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public boolean[] isActiva() {
        return Activa;
    }

    public void setActiva(boolean[] Activa) {
        this.Activa = Activa;
    }
    
    public String MasUsuarios(){
        return MasUsuarios;
    }
    
    //Se llama a la clase pantalla
    public boolean CrearUsuario(String Usuario, String Contraseña) {
        if (Usuario.length() == 0 || Contraseña.length() != 8) {
            JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña no validos. La contraseña debe tener exactamente 5 caracteres.");
            return false;
        }

        for (int i = 0; i < Contar; i++) {
            if (this.Usuario[i].equalsIgnoreCase(Usuario)) {
                JOptionPane.showMessageDialog(null, "El usuario ya existe, favor elegir otro Nombre de Usuario");
                return false;
            }
        }

        if (Contar < this.Usuario.length) {
            this.Usuario[Contar] = Usuario;
            this.Contraseña[Contar] = Contraseña;
            this.FechaIngreso[Contar] = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
            this.Activa[Contar] = true;
            this.Contar++;
            JOptionPane.showMessageDialog(null, "Usuario Exitosamente Registrado");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "No se pueden registrar mas usuarios.");
            return false;
        }    
    }
    
    public boolean CambiarUsuario( String NuevoUsuario){
        
            for(int usuario=0; usuario<Contar; usuario++){
                if(this.Usuario[usuario].equalsIgnoreCase(NuevoUsuario)){
               
                    JOptionPane.showMessageDialog(null,"El usuario ya existe, Elija otro nombre");
                    return false;
                }
            }
            for (int nombre=0; nombre<Contar; nombre++) {
            if (this.Usuario[nombre].equalsIgnoreCase(this.MasUsuarios)) {
                this.Usuario[nombre]=NuevoUsuario;
                JOptionPane.showMessageDialog(null, "Nombre de usuario cambiado exitosamente");
                return true;
            }
        }
            return true;
        }

        public boolean eliminarCuenta() {
    boolean eliminacionExitosa = false;
    for (int i = 0; i < Contar; i++) {
        if (Usuario[i].equalsIgnoreCase(MasUsuarios)) {
            Usuario[i] = null;
            Contraseña[i] = null;
            FechaIngreso[i] = null;
            Activa[i] = false;
            MasUsuarios = null;
            OtraContra = null;
            int puntos = 0;
            Object FechaEntrada = null;
            boolean activo = false;
            JOptionPane.showMessageDialog(null, "Cuenta eliminada exitosamente.");
            eliminacionExitosa = true;
            break;
        }
    }
    return eliminacionExitosa;
     }    

        
  }
