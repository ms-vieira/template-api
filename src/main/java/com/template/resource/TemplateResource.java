package com.template.resource;

import com.template.model.TemplateEntity;
import com.template.repository.Templates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/template")
public class TemplateResource {

    /*Resource de templates*/

    @Autowired
    private Templates templates;

    @GetMapping
    public List<TemplateEntity> all() {
        return templates.findAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public TemplateEntity create(@Valid @RequestBody TemplateEntity templateEntity) {
        return templates.save(templateEntity);
    }
}
