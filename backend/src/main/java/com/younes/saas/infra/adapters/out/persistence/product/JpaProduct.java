package com.younes.saas.infra.adapters.out.persistence.product;

import com.younes.saas.infra.adapters.out.persistence.common.AbstractEntity;
import com.younes.saas.infra.adapters.out.persistence.category.JpaCategory;
import com.younes.saas.infra.adapters.out.persistence.stockmvt.JpaStockMvt;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "products")
public class JpaProduct extends AbstractEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "reference", nullable = false, unique = true)
    private String reference;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "alert_threshold", nullable = false)
    private Integer alertThreshold;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private JpaCategory category;

    @OneToMany(mappedBy = "product")
    private List<JpaStockMvt> stockMovements;

}
