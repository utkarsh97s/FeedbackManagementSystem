package com.cg.fms.config;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

/**
 *author: Utkarsh  
 *created Date: 08/10/2019
 *last modified : 11/10/2019     
 */
public class AuditorAwareImpl implements AuditorAware<String>  {
	/**
	 *author: Utkarsh
	 *Description : this method is used to get the system information 
	 *              for tracking purposes.This class is used to override the default 
	 *              values   
	 *created Date: 08/10/2019
	 *last modified : 11/10/2019     
	 * Output : String                 
	 */
	@Override
	public Optional<String> getCurrentAuditor() {
		InetAddress localhost;
		try {
			localhost = InetAddress.getLocalHost();
			return Optional.of((localhost.getHostAddress().trim())); 
		} catch (UnknownHostException e) {
			return Optional.of(System.getProperty("user.name"));
			
		}
	
	}

}
