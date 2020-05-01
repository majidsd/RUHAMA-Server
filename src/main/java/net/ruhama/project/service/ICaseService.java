/**
 * 
 */
package net.ruhama.project.service;

import net.ruhama.project.dto.CaseDto;
import net.ruhama.project.response.ListResponse;
import net.ruhama.project.response.ObjectResponse;

/**
 * @author ahmedozy
 *
 */
public interface ICaseService {

	public ListResponse<CaseDto> getCases();
	public ListResponse<CaseDto> getAgentCases(Integer agentId);
	public ObjectResponse<CaseDto> getCaseById(Integer caseId);
	public ObjectResponse<CaseDto> createCase(CaseDto caseDto);
	public ObjectResponse<CaseDto> cancelCase(CaseDto caseDto);
	public ObjectResponse<CaseDto> updatePaidAmount(CaseDto caseDto);
	public ObjectResponse<CaseDto> completeCase(CaseDto caseDto);
}
