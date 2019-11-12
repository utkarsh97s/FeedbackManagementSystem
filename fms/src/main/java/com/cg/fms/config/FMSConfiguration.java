package com.cg.fms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;



/**
 *author: Utkarsh  
 *created Date: 04/11/2019
 *last modified : 04/11/2019     
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class FMSConfiguration {
	/**
	 *author: Utkarsh
	 *Description : this method is used to return the annotated fields value with
	 *              custom values    
	 *created Date: 04/11/2019
	 *last modified : 04/11/2019     
	 *output : AuditorAwareImpl Object      
	 */
	    @Bean
	    public AuditorAware<String> auditorProvider() {
	        return new AuditorAwareImpl();
	    }
}
