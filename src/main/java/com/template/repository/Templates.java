package com.template.repository;

import com.template.model.TemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Templates extends JpaRepository <TemplateEntity, Long> {

}
