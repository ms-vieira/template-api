package com.template.repository;

import com.template.model.Template;
import com.template.model.TemplateType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Templates extends JpaRepository <Template, Long> {

    /*Query Methods: Busca um template passando o nome e o tipo*/
    Optional<Template> findByNameAndType(String name, TemplateType type);
}
