package red.social;

import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Login{
     private static final int MAX_USUARIOS = 100;
    private static int numUsuarios = 0;
    
    private String Nombre;
    private String Genero;
    private String Edad;
    private String Usuario;
    private String Contra;
    static Login UsuarioRegistrado;
    private String FechaIngreso;
    private boolean Activo;
    static String[] Usuarios = new String[MAX_USUARIOS];
    private static String[] Contraseñas = new String[100];
    private static String[] FechasIngresos = new String[100];
    private static boolean[] Activos = new boolean[100];
    private String[] Generos=new String[100];
    static int Contar = 0;
    
    private static String[][] seguidores=new String[MAX_USUARIOS][MAX_USUARIOS];
    
    //se agrego esto
    private String[] usuarios={};
    private String[] contraseñas;
    private String[] generos={};
    private String[] fechasIngreso;
    private int contadorUsuarios;
    private String[] edades;
    //hasta aqui se agrego
    
    private String Hasthtag;
    private String[] CrearHasthtags=new String[100];
    private String[] Hasthtags=new String[100];
    private String[] BuscarUsuarios=new String [100];
    String getNombre;
    
    public Login() {
        usuarios = new String[100];        // Suponiendo un máximo de 100 usuarios
        contraseñas = new String[100];
        generos = new String[100];
        fechasIngreso = new String[100];
        contadorUsuarios = 0;
    }

    public Login(String user, String password, String genero) {
        this.Usuario = user;
        this.Contra = password;
        this.FechaIngreso = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        this.Genero=genero;
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
    
    //aqui
    public String obtenerNombre(String usuario) {
        // Implementa el código para obtener el nombre del usuario
        return "";
    }

    public String obtenerFechaRegistrado(String usuario) {
        // Implementa el código para obtener la fecha de registro del usuario
        return "";
    }

    public String obtenerEdad(String usuario) {
        // Implementa el código para obtener la edad del usuario
        return "";
    }

    public String obtenerGenero(String usuario) {
        // Implementa el código para obtener el género del usuario
        return "";
    }
    //aqui

    
    // Método para cambiar la contraseña
    public boolean CambiarContraseña(String nuevaContraseña) {
        if (nuevaContraseña.length()==0) {
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
    
    /**
     *
     * @param usuario
     * @param password
     * @param genero
     * @return
     */
    
    public boolean CreaUsuario(String usuario, String contraseña, String genero) {
        // Verificar si el usuario ya existe
        if (buscarUsuario(usuario) != -1) {
            return false; // El usuario ya existe
        }
        
        if (contadorUsuarios < usuarios.length) {
            usuarios[contadorUsuarios] = usuario;
            contraseñas[contadorUsuarios] = contraseña;
            generos[contadorUsuarios] = genero;
            fechasIngreso[contadorUsuarios] = "01/09/2024";  // Simulando fecha de creación
            contadorUsuarios++;
            return true;
        } else {
            System.out.println("No hay más espacio para usuarios.");
            return false;
        }
    }

    // Buscar el índice de un usuario
    private int buscarUsuario(String usuario) {
        for (int i = 0; i < contadorUsuarios; i++) {
            if (usuarios[i].equals(usuario)) {
                return i;
            }
        }
        return -1; // Usuario no encontrado
    }

    public String[] obtenerDatosUsuario(String usuario) {
        int index = buscarUsuario(usuario);
        if (index != -1) {
            return new String[]{usuarios[index], generos[index], fechasIngreso[index]};
        } else {
            return null;  // Usuario no encontrado
        }
    }

    
    public boolean CrearUsuario(String usuario, String password, String genero) {
        if (usuario.length() == 0 ) {
            JOptionPane.showMessageDialog(null, "Nombre de usuario no validos.");
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
            Generos[Contar]=genero;
            Contar++;
            JOptionPane.showMessageDialog(null, "Usuario Registrado");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "No se pueden registrar más usuarios.");
            return false;
        }
    } 
    
    
    
    public String ObtenerHasthtags(String hasthtags){
        for (int i=0;i<Contar;i++){
            if(Hasthtags[i].equals(hasthtags)){
                return CrearHasthtags[i];
            }
        }
        return null;
    }
    public boolean esSeguido(String usuarioSeguido, String usuarioActual){
        for(int i=0;i<Contar;i++){
            if(Usuarios[i].equals(usuarioActual)){
                for(int j=0; j<100;j++){
                    if(seguidores[i][j] !=null && seguidores[i][j].equals(usuarioSeguido)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean seguirUsuario(String usuarioSeguido) {
    for (int i = 0; i < Contar; i++) {
        if (Usuarios[i].equals(Usuario)) {
            for (int j = 0; j < 100; j++) {
                if (seguidores[i][j] == null) {
                    seguidores[i][j] = usuarioSeguido;
                    JOptionPane.showMessageDialog(null, "Ahora sigues a " + usuarioSeguido);
                    return true;
                }
            }
        }
    }
    return false;
}

public boolean dejarDeSeguirUsuario(String usuarioSeguido) {
    for (int i = 0; i < Contar; i++) {
        if (Usuarios[i].equals(Usuario)) {
            for (int j = 0; j < 100; j++) {
                if (seguidores[i][j] != null && seguidores[i][j].equals(usuarioSeguido)) {
                    seguidores[i][j] = null;
                    JOptionPane.showMessageDialog(null, "Has dejado de seguir a " + usuarioSeguido);
                    return true;
                }
            }
        }
    }
    return false;
}

public String getFechaIngreso(String usuario) {
    for (int i = 0; i < Contar; i++) {
        if (Usuarios[i].equals(usuario)) {
            return FechasIngresos[i];
        }
    }
    return "Fecha no disponible";
}

 public String ObtenerNombre(String usuario) {
        int index = buscarUsuario(usuario);
        if (index != -1) {
            return Usuarios[index];
        }
        return "Usuario no encontrado.";
    }

    public String ObtenerFechaRegistrada(String usuario) {
        int index = buscarUsuario(usuario);
        if (index != -1) {
            return FechasIngresos[index];
        }
        return "Fecha no disponible.";
    }

   public String ObtenerEdad(String usuario) {
        int index = buscarUsuario(usuario);
        if (index != -1) {
            return edades[index];  // Suponiendo que `edades` es un array correctamente inicializado
        }
        return "Edad no disponible.";
    }

    public String ObtenerGenero(String usuario) {
        int index = buscarUsuario(usuario);
        if (index != -1) {
            return Generos[index];
        }
        return "Género no disponible.";
    }


    

    boolean cambiarNombreUsuario(String nuevoUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    void setText(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setNombre() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getNombre() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String obtenerGeneros() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String obtenerEdadades() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

  
