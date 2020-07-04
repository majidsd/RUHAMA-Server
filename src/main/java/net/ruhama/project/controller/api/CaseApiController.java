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

import io.jsonwebtoken.Claims;
import net.ruhama.project.dto.CaseDto;
import net.ruhama.project.dto.DonationDto;
import net.ruhama.project.dto.UserDto;
import net.ruhama.project.response.ListResponse;
import net.ruhama.project.response.ObjectResponse;
import net.ruhama.project.service.ICaseService;
import net.ruhama.project.service.IUserService;
import net.ruhama.project.util.CaseStatus;
import net.ruhama.project.util.ResponseEnum;

/**
 * @author ahmedozy
 *
 */
@RestController
@RequestMapping("/api/case")
public class CaseApiController {

	@Autowired
	ICaseService caseService;
	
	@Autowired
	IUserService userService;
	
	@GetMapping("/all")
	public ListResponse<CaseDto> getAllCases(){
		return caseService.getCases();
	}
	
	@GetMapping("/get/{caseId}")
	public ObjectResponse<CaseDto> getCaseById(@PathVariable int caseId){
		return caseService.getCaseById(caseId);
	}
	
	@GetMapping("/agent")
	public ListResponse<CaseDto> getAgentCases(Authentication authentication){
		Claims claims = (Claims) authentication.getPrincipal();
		ObjectResponse<?> userResponse = userService.getUser(claims.getSubject());
		Integer agentId;
		if(userResponse.getResponseCode() != ResponseEnum.SUCCESS.getResponseCode()) {
			return new ListResponse<>(userResponse.getResponseCode(), userResponse.getResponseMessage(), null);
		} else {
			agentId = ((UserDto) userResponse.getDto()).getId();
		}
		return caseService.getAgentCases(agentId);
	}
	
	@PostMapping("/create")
	public ObjectResponse<CaseDto> createCase(Authentication authentication, @RequestBody CaseDto caseDto){
		ObjectResponse<CaseDto> response;
		Claims claims = (Claims) authentication.getPrincipal();
		ObjectResponse<?> userResponse = userService.getUser(claims.getSubject());
		if(userResponse.getResponseCode() != ResponseEnum.SUCCESS.getResponseCode()) {
			return (ObjectResponse<CaseDto>) userResponse;
		} else {
			Integer userId = ((UserDto) userResponse.getDto()).getId();
			caseDto.setAgentId(userId);
			caseDto.setStatus(CaseStatus.NEW);
		}
		response = caseService.createCase(caseDto);
		return response;
	}
}
