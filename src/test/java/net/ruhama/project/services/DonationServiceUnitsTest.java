/**
 * 
 */
package net.ruhama.project.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import net.ruhama.project.dto.DonationDto;
import net.ruhama.project.model.Donation;
import net.ruhama.project.response.ListResponse;
import net.ruhama.project.response.ObjectResponse;
import net.ruhama.project.service.IDonationService;

/**
 * @author MaJiD
 *
 */
@SpringBootTest
public class DonationServiceUnitsTest {
	
	@Autowired
	private IDonationService donationService;
	
	@Test
	public void donateUnitTest() {
		DonationDto donationDto = new DonationDto();
		donationDto.setAmount(5000.0);
		donationDto.setCase_id(1);
		donationDto.setCreated_by_id(1);
		donationDto.setDonator_id(1);
		donationDto.setInfo("Helping with it.");
		ObjectResponse<Donation> response = donationService.donate(donationDto);
		System.out.println(response);
	}
	
	@Test
	public void transferDonationUnitTest() {
		DonationDto donationDto = new DonationDto();
		donationDto.setId(1);
		donationDto.setCase_id(1);
		donationDto.setNew_case_id(2);
		donationDto.setCreated_by_id(2);
		ObjectResponse<Donation> response = donationService.transferDonation(donationDto);
		System.out.println(response);
	}
	
	@Test
	public void getCaseDonationsUnitTest() {
		DonationDto donationDto = new DonationDto();
		donationDto.setCase_id(1);
		ListResponse<Donation> response = donationService.getCaseDonations(donationDto);
		System.out.println(response);
	}
	
	@Test
	public void getCaseDonationsPerPeriodUnitTest() throws ParseException {
		DonationDto donationDto = new DonationDto();
		donationDto.setCase_id(1);
		donationDto.setStart_date(new SimpleDateFormat("yyyy-MM-dd").parse("2020-5-14"));
		donationDto.setEnd_date(new SimpleDateFormat("yyyy-MM-dd").parse("2020-5-23"));
		ListResponse<Donation> response = donationService.getCaseDonationsPerPeriod(donationDto);
		System.out.println(response);
	}
	
	@Test
	public void getUserDonationsUnitTest() {
		DonationDto donationDto = new DonationDto();
		donationDto.setDonator_id(1);
		ListResponse<Donation> response = donationService.getUserDonations(donationDto);
		System.out.println(response);
	}
	
	@Test
	public void getUserDonationsPerPeriodUnitTest() throws ParseException {
		DonationDto donationDto = new DonationDto();
		donationDto.setDonator_id(1);
		donationDto.setStart_date(new SimpleDateFormat("yyyy-MM-dd").parse("2020-5-14"));
		donationDto.setEnd_date(new SimpleDateFormat("yyyy-MM-dd").parse("2020-5-23"));
		ListResponse<Donation> response = donationService.getUserDonationsPerPeriod(donationDto);
		System.out.println(response);
	}
	
}
