package com.template.service;

import com.template.model.Template;
import com.template.repository.Templates;
import com.template.service.exception.TemplateAlreadyExistException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Optional;

import static com.template.model.TemplateType.BUSINESS;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

public class TemplateServiceTest {
    private static final String NAME_TEMPLATE = "Center";
    private static final BigDecimal MONEY_TEMPLATE = new BigDecimal(99999);

    private TemplateService service;

    @Mock
    private Templates templatesMocked;

    /*Carrega antes de executar os teste*/
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        service = new TemplateService(templatesMocked);
    }

    @Test(expected = TemplateAlreadyExistException.class)
    public void should_deny_creation_of_template_exists() {
        when(templatesMocked.findByNameAndType(NAME_TEMPLATE, BUSINESS)).thenReturn(Optional.of(createTemplate()));
        service.save(createTemplate());
    }

    @Test
    public void should_create_new_template() {
        Template newTemplate = createTemplate();
        when(templatesMocked.save(newTemplate)).thenReturn(createTemplate());
        Template savedTemplate = service.save(newTemplate);

        assertThat(savedTemplate.getId(), equalTo(10L));
        assertThat(savedTemplate.getName(), equalTo(NAME_TEMPLATE));
        assertThat(savedTemplate.getType(), equalTo(BUSINESS));
    }

    /*Reutilizar um template*/
    private Template createTemplate() {
        return Template.builder()
                .id(10L)
                .name(NAME_TEMPLATE)
                .money(MONEY_TEMPLATE)
                .type(BUSINESS)
                .build();
    }

}
