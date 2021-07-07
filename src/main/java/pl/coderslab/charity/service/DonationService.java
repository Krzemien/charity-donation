package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repository.DonationRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

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

    public void saveDonation(Donation donation) {
        donationRepository.save(donation);
    }

    public List<Donation> showAllByUser(User user){
        return donationRepository.findAllByUser(user);
    }

}
