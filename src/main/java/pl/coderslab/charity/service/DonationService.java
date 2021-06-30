package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.repository.DonationRepository;

@Service
public class DonationService {
    private DonationRepository donationRepository;

    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    public long totalBags(){
        long totalQuantity = 0;
        for (Donation donation : donationRepository.findAll()) {
            totalQuantity += donation.getQuantity();
        }

        return totalQuantity;
    }

    public long totalDonations(){

        return donationRepository.count();
    }
}
