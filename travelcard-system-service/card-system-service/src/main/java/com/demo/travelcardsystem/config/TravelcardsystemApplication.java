package com.demo.travelcardsystem.config;

import com.demo.travelcardsystem.businessrule.RuleCollection;
import com.demo.travelcardsystem.businessrule.TravelStrategy;
import com.demo.travelcardsystem.constant.Zone;
import com.demo.travelcardsystem.entity.Station;
import com.demo.travelcardsystem.entity.TravelCard;
<<<<<<< HEAD
import com.demo.travelcardsystem.entity.TravelCardObserver;
=======
>>>>>>> sprint-1
import com.demo.travelcardsystem.repository.InMemoryCardTransactionRepository;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {"com.demo.travelcardsystem"})
<<<<<<< HEAD
public class TravelcardsystemApplication{
=======
public class TravelcardsystemApplication {
>>>>>>> sprint-1

    public static void main(String[] args) {
        SpringApplication.run(TravelcardsystemApplication.class, args);
    }

    @Bean
<<<<<<< HEAD
    public TravelCard getTravelCard(TravelCardObserver travelCardObserver) {
        TravelCard travelCard = new TravelCard();
        travelCard.registerObserver(travelCardObserver);
        return travelCard;
    }

    @Bean
    public RuleCollection loadAllTravelStrategy(TravelStrategy travelStrategy) {
       return travelStrategy.loadAllBusinessRules();
=======
    public RuleCollection loadAllTravelStrategy(TravelStrategy travelStrategy) {
        return travelStrategy.loadAllBusinessRules();
>>>>>>> sprint-1
    }

    @Bean
    public Boolean loadAllStation(InMemoryCardTransactionRepository inMemoryCardTransactionRepository) {
        Set<Station> stations = new HashSet<>();
<<<<<<< HEAD

        //ADD Algubaiba
        stations.add(new Station("Algubaiba", new HashSet<>(Arrays.asList(Zone.ONE))));
        //ADD Jumeirah
        stations.add(new Station("Jumeirah", new HashSet<>(Arrays.asList(Zone.ONE, Zone.TWO))));
        //ADD Bur Dubai
        stations.add(new Station("Bur Dubai", new HashSet<>(Arrays.asList(Zone.THREE))));
        //ADD Deirah
        stations.add(new Station("Deirah", new HashSet<>(Arrays.asList(Zone.TWO))));

=======
        stations.add(new Station("Algubaiba", new HashSet<>(Arrays.asList(Zone.ONE))));
        stations.add(new Station("Jumeirah", new HashSet<>(Arrays.asList(Zone.ONE, Zone.TWO))));
        stations.add(new Station("Bur Dubai", new HashSet<>(Arrays.asList(Zone.THREE))));
        stations.add(new Station("Deirah", new HashSet<>(Arrays.asList(Zone.TWO))));
>>>>>>> sprint-1
        return inMemoryCardTransactionRepository.addAllStationsToStationStore(stations);
    }

    @Bean
    public Boolean loadInitialCards(InMemoryCardTransactionRepository inMemoryCardTransactionRepository) {
        TravelCard firstTravelCard = new TravelCard();
        firstTravelCard.setCardNumber("A101");
        firstTravelCard.setBalance(30);

        TravelCard secondTravelCard = new TravelCard();
        secondTravelCard.setCardNumber("B201");
        secondTravelCard.setBalance(50);

        inMemoryCardTransactionRepository.registerNewCard(firstTravelCard);
        inMemoryCardTransactionRepository.registerNewCard(secondTravelCard);
<<<<<<< HEAD

        return true;
    }


}
=======
        return true;
    }
}
>>>>>>> sprint-1
