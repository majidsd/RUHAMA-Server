/**
 * 
 */
package net.ruhama.project.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.ruhama.project.dto.DonationDto;
import net.ruhama.project.response.ListResponse;
import net.ruhama.project.response.ObjectResponse;
import net.ruhama.project.service.IDonationService;

/**
 * @author MaJiD
 *
 */
@RestController
@RequestMapping("/api/donation")
public class DonationApiController {

	@Autowired
	IDonationService donationService;
	
	@PostMapping("/donate")
	public ObjectResponse<DonationDto> donate(@RequestBody DonationDto donation){
		ObjectResponse<DonationDto> response = donationService.donate(donation);
		return response;
	}
	
	@GetMapping("/all/{userId}")
	public ListResponse<DonationDto> getDonations(@PathVariable Integer userId){
		DonationDto donationDto = new DonationDto();
		donationDto.setDonator_id(userId);
		ListResponse<DonationDto> response = donationService.getUserDonations(donationDto);
		return response;
	}
}
