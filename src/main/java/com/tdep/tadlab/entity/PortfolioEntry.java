package com.tdep.tadlab.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;

import java.io.Serializable;

@Getter
@Entity(name = "PortfolioEntry")
@Table(name = "portfolio_entry")
public class PortfolioEntry  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entry_id")
    private long entryId;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "entrytype", name = "entry_type", nullable = false, length = 50)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    private EntryType entryType;

    @Override
    public String toString() {
        return  "{" +
                "entry id=" + entryId +
                ", entry_type='" + entryType + '\'' +
                '}';
    }
}
