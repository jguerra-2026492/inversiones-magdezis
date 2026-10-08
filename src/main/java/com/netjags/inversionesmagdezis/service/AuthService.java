package main.java.com.netjags.inversionesmagdezis.service;

import main.java.com.netjags.inversionesmagdezis.model.Usuario;
import main.java.com.netjags.inversionesmagdezis.repository.UsuarioRepository;
import main.java.com.netjags.inversionesmagdezis.security.BCrypt;

/**
 *
 * @author informatica
 */

public class AuthService {
    private final UsuarioRepository usuarioRepository = new UsuarioRepository();

    public boolean registrarUsuario(String nombre, String email, String contrasenaPlana, String rol) {
        String hashedPassword = BCrypt.hashpw(contrasenaPlana, BCrypt.gensalt());

        Usuario usuario = new Usuario(null, nombre, email, hashedPassword);

        return usuarioRepository.registerUser(usuario, rol);
    }

    public AuthRS autenticar(String email, String contrasenaPlana) {
        Usuario usuario = usuarioRepository.findByEmail(email);

        if (usuario != null) {
            if (BCrypt.checkpw(contrasenaPlana, usuario.getContrasenaHash())) {
                String rol = usuarioRepository.obtenerRolPorEmail(email);
                return new AuthRS(true, rol, usuario);
            }
        }
        return new AuthRS(false, null, null);
    }

    
    public static class AuthRS {
        private final boolean esVerdadero;
        private final String rol;
        private final Usuario usuario;

        public AuthRS(boolean esVerdadero, String rol, Usuario usuario) {
            this.esVerdadero = esVerdadero;
            this.rol = rol;
            this.usuario = usuario;
        }

        public boolean esVerdadero() {
            return esVerdadero;
        }

        public String getRol() {
            return rol;
        }

        public Usuario getUsuario() {
            return usuario;
        }
    }
}    
