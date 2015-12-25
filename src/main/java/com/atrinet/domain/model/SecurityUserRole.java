package com.atrinet.domain.model;

import com.atrinet.domain.common.RoleType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by AFomin on 7/5/2015.
 */
@Entity
public class SecurityUserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_sec_user_role_id")
//    @SequenceGenerator(name="seq_sec_user_role_id", sequenceName="seq_sec_user_role_id")
    @Setter
    @Getter
    private long id;

    @Setter
    @Getter
    @Column(unique = true)
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

}
