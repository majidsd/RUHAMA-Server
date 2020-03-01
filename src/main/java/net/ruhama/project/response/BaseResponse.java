/**
 * 
 */
package net.ruhama.project.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author ahmedozy
 *
 */
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class BaseResponse {

	private Integer responseCode;
	private String responseMessage;
}
