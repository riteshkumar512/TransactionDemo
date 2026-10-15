package in.kumar.TransactionDemo.repository;

import in.kumar.TransactionDemo.model.TransferRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<TransferRecord , Long > {

}

