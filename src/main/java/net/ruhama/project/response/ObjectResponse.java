/**
 * 
 */
package net.ruhama.project.response;

/**
 * @author ahmedozy
 *
 */

public class ObjectResponse<T> extends BaseResponse {

	private T dto;

	public T getDto() {
		return dto;
	}

	public void setDto(T dto) {
		this.dto = dto;
	}

	public ObjectResponse() {
		super();
	}

	public ObjectResponse(Integer responseCode, String responseMessage, T dto) {
		super(responseCode, responseMessage);
		this.dto = dto;
	}

	@Override
	public String toString() {
		return "ObjectResponse [dto=" + dto + ", toString()=" + super.toString() + "]";
	}
	
}
