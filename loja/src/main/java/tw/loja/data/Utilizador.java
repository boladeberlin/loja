package tw.loja.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "utilizador")
public class Utilizador {
    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "enable")
    private boolean enable;

    public Utilizador() {
    }

    public Utilizador(String username, String password, String email, boolean enable) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.enable = enable;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    @Override
    public String toString() {
        return "Utilizador{" +
                "username='" + username + 
                '\'' +
                ", password='" + password + 
                '\'' +
                ", enable=" + enable +
                '}';
    }
}