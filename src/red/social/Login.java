package red.social;

import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Login{
    private String Nombre;
    private String Genero;
    private String Edad;
    private String Usuario;
    private String Contra;
    private static Login UsuarioRegistrado;
    private String FechaIngreso;
    private boolean Activo;
    private static String[] Usuarios = new String[100];
    private static String[] Contraseñas = new String[100];
    private static String[] FechasIngresos = new String[100];
    private static boolean[] Activos = new boolean[100];
    private static int Contar = 0;

    public Login() {
    }

    public Login(String user, String password) {
        this.Usuario = user;
        this.Contra = password;
        this.FechaIngreso = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        this.Activo = true;
    }

    public String getUsuario() {
        return Usuario;
    }

    public String getPassword() {
        return Contra;
    }


    public String [] getFechaIngreso() {
        return FechasIngresos;
    }

    public boolean Activo() {
        return Activo;
    }
    
    public static String ObtenerNombreUsuarioRegistrado() {
        if (UsuarioRegistrado != null) {
            return UsuarioRegistrado.getUsuario();
        } else {
            return "Ningun usuario registrado.";
        }
    }

    
    // Método para cambiar la contraseña
    public boolean CambiarContraseña(String nuevaContraseña) {
        if (nuevaContraseña.length() != 5) {
            JOptionPane.showMessageDialog(null, "La contraseña debe tener exactamente 5 caracteres.");
            return false;
        }
        this.Contra = nuevaContraseña;
        JOptionPane.showMessageDialog(null, "Contraseña cambiada exitosamente.");
        return true;
    }

    // Método para cambiar el nombre de usuario
    public boolean CambiarUsuario(String nuevoUsuario) {
        for (int i = 0; i <Contar; i++) {
            if (Usuarios[i].equalsIgnoreCase(nuevoUsuario)) {
                JOptionPane.showMessageDialog(null, "El usuario ya existe, favor elegir otro Nombre de Usuario");
                return false;
            }
        }
        this.Usuario = nuevoUsuario;
        JOptionPane.showMessageDialog(null, "Nombre de usuario cambiado exitosamente.");
        return true;
    }

    // Método para eliminar la cuenta
    public boolean EliminarCuenta() {
    boolean eliminacionExitosa = false;
    for (int i = 0; i <Contar; i++) {
        if (Usuarios[i].equalsIgnoreCase(Usuario)) {
            Usuarios[i] = null;
            Contraseñas[i] = null;
            FechasIngresos[i] = null;
            Activos[i] = false;
            Usuario = null;
            Contra = null;
            FechaIngreso = null;
            Activo = false;
            JOptionPane.showMessageDialog(null, "Cuenta eliminada exitosamente.");
            eliminacionExitosa = true;
            break;
        }
    }
    return eliminacionExitosa;
}
    
    
  
    //de aqui empiza el ingreso de datos
    public boolean IniciaSecion(String usuario, String password) {
        for (int i = 0; i <Contar; i++) {
            if (Usuarios[i].equalsIgnoreCase(usuario)) {
                if (Contraseñas[i].equals(password)) {
                    this.Usuario = usuario;
                    this.Contra = password;
                    this.Activo = true;
                    UsuarioRegistrado = this;
                    String message = "Bienvenido " + usuario;
                    System.out.println(message);
                    JOptionPane.showMessageDialog(null, message);
                    return true;
                } else {
                    String message = "Contraseña incorrecta";
                    System.out.println(message);
                    JOptionPane.showMessageDialog(null, message);
                    return false;
                }
            }
        }
        String message = "Favor Registrarse";
        System.out.println(message);
        JOptionPane.showMessageDialog(null, message);
        return false;
    }
    
    public boolean CrearUsuario(String usuario, String password) {
        if (usuario.length() == 0 || password.length() != 5) {
            JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña no válidos. La contraseña debe tener exactamente 5 caracteres.");
            return false;
        }

        for (int i = 0; i <Contar; i++) {
            if (Usuarios[i].equalsIgnoreCase(usuario)) {
                JOptionPane.showMessageDialog(null, "El usuario ya existe, favor elegir otro Nombre de Usuario");
                return false;
            }
        }

        if (Contar< Usuarios.length) {
            Usuarios[Contar] = usuario;
            Contraseñas[Contar] = password;
            FechasIngresos[Contar] = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
            Activos[Contar] = true;
            Contar++;
            JOptionPane.showMessageDialog(null, "Usuario Registrado");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "No se pueden registrar más usuarios.");
            return false;
        }
    }
    
    //Mostrar foto perfil
    
    

    boolean cambiarNombreUsuario(String nuevoUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    

   

    void setText(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
