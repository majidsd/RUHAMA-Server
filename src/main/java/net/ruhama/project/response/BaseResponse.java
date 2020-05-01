/**
 * 
 */
package net.ruhama.project.response;

import net.ruhama.project.util.ResponseEnum;

/**
 * @author ahmedozy
 *
 */
public class BaseResponse {

	private Integer responseCode;
	private String responseMessage;
	public Integer getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	@Override
	public String toString() {
		return "BaseResponse [responseCode=" + responseCode + ", responseMessage=" + responseMessage + "]";
	}
	public BaseResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BaseResponse(Integer responseCode, String responseMessage) {
		super();
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
	}
	
	public BaseResponse(ResponseEnum responseEnum) {
		super();
		switch(responseEnum) {
		case DUPLICATED_ITEM:
			this.responseCode = 401;
			this.responseMessage = "Duplicated Item";
			break;
		case ITEM_NOT_FOUND:
			this.responseCode = 404;
			this.responseMessage = "Item Not Found";
			break;
		case SUCCESS:
			this.responseCode = 201;
			this.responseMessage = "Success";
			break;
		default:
			this.responseCode = 500;
			this.responseMessage = "None";
			break;
		
		}
	}
	
}
