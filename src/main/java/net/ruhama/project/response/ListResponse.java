/**
 * 
 */
package net.ruhama.project.response;

import java.util.List;

/**
 * @author ahmedozy
 *
 */

public class ListResponse<T> extends BaseResponse {

	private List<T> dtos;

	public List<T> getDtos() {
		return dtos;
	}

	public void setDtos(List<T> dtos) {
		this.dtos = dtos;
	}

	@Override
	public String toString() {
		return "ListResponse [dtos=" + dtos + "]";
	}
	
	
}
