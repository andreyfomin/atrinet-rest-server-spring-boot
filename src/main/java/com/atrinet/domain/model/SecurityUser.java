package com.atrinet.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by AFomin on 7/5/2015.
 * https://en.wikibooks.org/wiki/Java_Persistence/OneToMany#Undirectional_OneToMany.2C_No_Inverse_ManyToOne.2C_No_Join_Table_.28JPA_2.0.29
 */
@Entity
public class SecurityUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter
    @Getter
    private long id;

    @Setter
    @Getter
    private String username;

    @Setter
    @Getter
    private String password;

    @Setter
    @Getter
    @OneToMany
    @JoinColumn(name = "USER_ID", referencedColumnName = "id")
    private List<SecurityUserRole> authorities;
}
