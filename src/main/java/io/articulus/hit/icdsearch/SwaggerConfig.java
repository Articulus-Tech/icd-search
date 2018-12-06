package io.articulus.hit.icdsearch;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.TagsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("io.articulus.hit.icdsearch.service"))
                .paths(PathSelectors.any())
                .build()
                //           .produces(ImmutableSet.of(MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE))
                .pathMapping("/")
                .apiInfo(apiInfo())
                .tags(
                        new Tag("icd9", "ICD 9 diagnosis code lookup"),
                        new Tag("icd9sg", "ICD 9 procedure code lookup"),
                        new Tag("icd10", "ICD 10 code lookup")
                );
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Articulus ICD Code Lookup API",
                "ICD-9 CM and ICD-10 Code Loockup",
                "API TOS",
                "Terms of service",
                new Contact("Tracy Snell", "articulus.io", "tjs@articulus.io"),
                "License of API", "API license URL", Collections.emptyList());
    }


    @Bean
    UiConfiguration uiConfig() {
        return UiConfigurationBuilder.builder()
                                     .deepLinking(true)
                                     .displayOperationId(false)
                                     .defaultModelsExpandDepth(1)
                                     .defaultModelExpandDepth(1)
                                     .defaultModelRendering(ModelRendering.EXAMPLE)
                                     .displayRequestDuration(false)
                                     .docExpansion(DocExpansion.LIST)
                                     .filter(false)
                                     .maxDisplayedTags(null)
                                     .operationsSorter(OperationsSorter.ALPHA)
                                     .showExtensions(false)
                                     .tagsSorter(TagsSorter.ALPHA)
                                     .validatorUrl(null)
                                     .build();
    }
}