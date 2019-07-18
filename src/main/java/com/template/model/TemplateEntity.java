package com.template.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity(name = "TEMPLATE")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TemplateEntity {

    /*Entidade do banco de dados*/

    @Id
    @SequenceGenerator(name = "template_seq", sequenceName = "template_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "template_seq")
    @EqualsAndHashCode.Include
    private Long id;

    @NotBlank(message = "templates-1")
    private String name;

    @NotNull(message = "templates-2")
    private TemplateType type;

    @NotNull(message = "templates-3")
    @DecimalMin(value = "0", message = "templates-4")
    private BigDecimal money;

}
