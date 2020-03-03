/**
 * 
 */
package net.ruhama.project.response;

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
	
}
