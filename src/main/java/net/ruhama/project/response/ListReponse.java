/**
 * 
 */
package net.ruhama.project.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author ahmedozy
 *
 */
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ListReponse<T> extends BaseResponse {

	private List<T> dtos;
}
