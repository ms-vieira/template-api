package com.template.resource;

import com.template.model.TemplateEntity;
import com.template.repository.Templates;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/template")
public class TemplateResource {

    private Templates templates;

    @GetMapping
    public List<TemplateEntity> all() {
        return templates.findAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    @Valid
    public TemplateEntity create(@RequestBody TemplateEntity templateEntity) {
        return templates.save(templateEntity);
    }
}
