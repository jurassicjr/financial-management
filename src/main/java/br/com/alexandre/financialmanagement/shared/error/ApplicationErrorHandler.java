package br.com.alexandre.financialmanagement.shared.error;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ApplicationErrorHandler implements ExceptionMapper<WSException>{

	@Override
	public Response toResponse(WSException exception) {
		
		 return Response.status(Status.BAD_REQUEST).entity(exception.getMessage()).build();  
	}
	

	

}
