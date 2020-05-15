/**
 * 
 */
package net.ruhama.project.util;

/**
 * @author ahmedozy
 *
 */
public enum ResponseEnum {

	SUCCESS(201,"Successful"),
	ITEM_NOT_FOUND(404, "Item not found"),
	DUPLICATED_ITEM(440, "Duplicated item");
	
	private Integer responseCode;
	private String responseMessage;
	
	private ResponseEnum(Integer responseCode, String responseMessage) {
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
	}
	
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
	
	
	
}
