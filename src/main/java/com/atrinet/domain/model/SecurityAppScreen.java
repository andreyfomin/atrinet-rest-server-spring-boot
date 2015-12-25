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
public class SecurityAppScreen {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter
    @Getter
    private long id;

    @Setter
    @Getter
    private String applicationId;

    @Setter
    @Getter
    private String screenId;

    @Setter
    @Getter
    @OneToMany
    @JoinColumn(name = "SCREEN_ID", referencedColumnName = "id")
    private List<SecurityUserRole> authorities;
}
