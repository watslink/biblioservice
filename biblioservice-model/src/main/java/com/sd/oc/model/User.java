package com.sd.oc.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;

    @Column
    @NaturalId
    private String username;

    @Column
    private String password;

    @Column
    private String mail;

    @Column
    private boolean enabled;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Borrowing> listBorrowing;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "role_user",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> listRole;

    public User() {
    }

    public User(String username, String password, String mail, boolean enabled) {
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return user_id == user.user_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id);
    }
}
