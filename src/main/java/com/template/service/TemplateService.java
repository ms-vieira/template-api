package com.template.service;

import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import com.template.model.Template;
import com.template.repository.Templates;
import com.template.service.exception.TemplateAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TemplateService {

    private Templates repository;

    public TemplateService(@Autowired Templates repository) {
        this.repository = repository;
    }

    public Template save(final Template template) {
        Optional<Template> templateByNameAndType = repository.findByNameAndType(template.getName(), template.getType());
        if (templateByNameAndType.isPresent())
            throw new TemplateAlreadyExistException();
        return repository.save(template);
    }

    public List<Template> findAll() {
        return repository.findAll();
    }

   public void delete(final Template template) throws Exception {
        Optional<Template> findTemplate = repository.findById(template.getId());
        if(!findTemplate.isPresent())
            throw new Exception("Template not found");
        repository.delete(template);
   }
}
