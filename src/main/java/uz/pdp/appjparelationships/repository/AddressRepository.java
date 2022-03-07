package uz.pdp.appjparelationships.repository;
// Nurkulov Nodirbek 2/20/2022  10:49 AM

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appjparelationships.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
