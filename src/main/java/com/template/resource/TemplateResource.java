package com.template.resource;

import com.template.model.Template;
import com.template.repository.Templates;
import com.template.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    private TemplateService service;

    @GetMapping
    public List<Template> all() {
        return service.findAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Template create(@Valid @RequestBody Template templateEntity) {
        return service.save(templateEntity);
    }

    @PutMapping("/{id}")
    public Template update(@PathVariable Long id, @Valid @RequestBody Template template) {
        template.setId(id);
        return service.save(template);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
            Template template = new Template();
            template.setId(id);
            try {
                service.delete(template);
            } catch (Exception e) {
                e.printStackTrace();
            }
        return ResponseEntity.noContent().build();

    }
}
