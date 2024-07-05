package giovannighirardelli.u5w3d5.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import giovannighirardelli.u5w3d5.enums.RuoliUtente;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "utenti")
@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties({"password", "ruolo", "enabled", "authorities", "accountNonExpired", "credentialsNonExpired", "accountNonLocked"})
public class Utenti implements UserDetails {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;
    private String nome;
    private String cognome;
    private String username;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name = "ruolo")
    private RuoliUtente ruoliUtente;

    public Utenti(String nome, String cognome, String username, String email, String password, RuoliUtente ruoliUtente) {
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.email = email;
        this.password = password;
        this.ruoliUtente = ruoliUtente;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.ruoliUtente.name()));
    }




    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
