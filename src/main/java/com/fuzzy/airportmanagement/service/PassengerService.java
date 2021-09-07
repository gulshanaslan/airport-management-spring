package com.fuzzy.airportmanagement.service;

import com.fuzzy.airportmanagement.domain.Passenger;
import com.fuzzy.airportmanagement.dto.request.PassengerRequestDto;
import com.fuzzy.airportmanagement.dto.response.PassengerResponseDto;
import com.fuzzy.airportmanagement.mapper.PassengerMapper;
import com.fuzzy.airportmanagement.repository.PassengerRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PassengerService {

    private final PassengerRepo passengerRepo;
    private final PassengerMapper passengerMapper;

    /*public PassengerService(PassengerRepo passengerRepo, PassengerMapper passengerMapper) {
        this.passengerRepo = passengerRepo;
        this.passengerMapper = passengerMapper;
    }*/

    public List<PassengerResponseDto> getPassengers() {
        log.info("getPassengers service started");
        List<Passenger> passengerList = passengerRepo.findAll();
        log.info("getPassengers service completed");
        return passengerMapper.toPassengerResponseDtoList(passengerList);
    }

    public PassengerResponseDto createPassenger(PassengerRequestDto passengerRequestDto) {
        log.info("createPassenger service started");
        Passenger createdPassenger = passengerRepo.save(passengerMapper.toPassengerRequestDto(passengerRequestDto));
        log.info("createPassenger service completed");
        return passengerMapper.toPassengerResponseDto(createdPassenger);
    }

    public Passenger getPassengerById(Integer id) {
        log.info("getPassengerById service started");
        /*Passenger passenger = passengerRepo.findById(id).orElseThrow(() -> new EntityNotFoundException
                ("Passenger not found with: id" + id));*/
        Passenger passenger = passengerRepo.findById(id).get();
        log.info("getPassengerById service completed");
        return passenger;
    }

    public PassengerResponseDto updatePassenger(Integer id, PassengerRequestDto passengerRequestDto) {
        log.info("updatePassenger service started");
        /*Passenger passenger = passengerRepo.findById(id).orElseThrow(() -> new EntityNotFoundException
                ("Passenger not found with: id" + id));*/
        Passenger passenger = passengerRepo.findById(id).get();
        if (passengerRequestDto.getName() != null) {
            passenger.setName(passengerRequestDto.getName());
            passenger.setSurname(passengerRequestDto.getSurname());
            passenger.setPhone(passengerRequestDto.getPhone());
            passenger.setActive(passengerRequestDto.getActive());
        }
        Passenger updatedPassenger = passengerRepo.save(passenger);
        return passengerMapper.toPassengerResponseDto(updatedPassenger);

    }


}
