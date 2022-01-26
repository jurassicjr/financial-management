package br.com.alexandre.financialmanagement.category.controllers;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import br.com.alexandre.financialmanagement.category.dtos.CategoryDTO;
import br.com.alexandre.financialmanagement.category.entities.Category;
import br.com.alexandre.financialmanagement.category.services.CreateCategoryService;
import br.com.alexandre.financialmanagement.category.services.DetailCategoryService;
import br.com.alexandre.financialmanagement.category.services.ListCategoryService;
import br.com.alexandre.financialmanagement.shared.error.WSException;

@Path("/categories")
public class CategoryController {

	@Inject
	private CreateCategoryService createCategoryService;
	
	@Inject
	private DetailCategoryService detailCategoryService;
	
	@Inject
	private ListCategoryService listCategoryService;

	@POST
	@Transactional
	public Response createCategory(CategoryDTO categoryDTO) throws WSException {
		Category category = createCategoryService.createCategory(categoryDTO);
		
		URI uri = UriBuilder.fromUri("/categories/{id}").build(category.getId());

		return Response.created(uri).build();
	}
	
	
	@GET
	@Path("/{id}")
	public Response getCategory(@PathParam("id") String id) throws WSException {
		Category category = detailCategoryService.detailCategoryById(id);
		return Response.ok(category).build();
	}
	
	@GET
	public Response getCatogories() {
		List<Category> categories = listCategoryService.list();
		return Response.ok(categories).build();
	}
}
