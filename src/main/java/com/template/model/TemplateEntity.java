package com.template.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Data
public class TemplateEntity {

    @Id
    private Long id;

    @NotBlank(message = "templates-1")
    private String name;

    @NotNull(message = "templates-2")
    private TemplateType type;

    @NotNull(message = "templates-3")
    @DecimalMin(value = "0", message = "templates-4")
    private BigDecimal money;

}
