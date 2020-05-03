/**
 * 
 */
package net.ruhama.project.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.ruhama.project.dto.CaseDto;
import net.ruhama.project.model.User;
import net.ruhama.project.response.ListResponse;
import net.ruhama.project.response.ObjectResponse;
import net.ruhama.project.service.ICaseService;

/**
 * @author ahmedozy
 *
 */
@RestController
@RequestMapping("/api/case")
public class CaseApiController {

	@Autowired
	ICaseService caseService;
	
	@GetMapping("/all")
	public ListResponse<CaseDto> getAllCases(){
		return caseService.getCases();
	}
	
	@GetMapping("/get/{caseId}")
	public ObjectResponse<CaseDto> getCaseById(@PathVariable int caseId){
		return caseService.getCaseById(caseId);
	}
	
	@GetMapping("/agent/{agentId}")
	public ListResponse<CaseDto> getAgentCases(@PathVariable int agentId){
		
		return caseService.getAgentCases(agentId);
	}
	
	@PostMapping("/create")
	public ObjectResponse<CaseDto> createCase(@RequestBody CaseDto caseDto){
		ObjectResponse<CaseDto> response;
		response = caseService.createCase(caseDto);
		return response;
	}
}
