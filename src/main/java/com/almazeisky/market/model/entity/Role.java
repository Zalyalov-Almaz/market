package com.almazeisky.market.model.entity;

import com.almazeisky.market.model.enums.RoleType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roles",
       uniqueConstraints = @UniqueConstraint(columnNames = {"authority"}))
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Role {

    private static final String SEQUENCE = "role_sequence";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE)
    @SequenceGenerator(name = SEQUENCE, sequenceName = SEQUENCE, allocationSize = 1)
    private Long id;
    @Enumerated(EnumType.STRING)
    private RoleType authority;

    public String getAuthority() {
        return authority.name();
    }
}
