package flumine.sgm.auxilium.repositories;

import flumine.sgm.auxilium.models.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
    Optional<VerificationToken> findByToken(String token);
    Boolean existsByToken(String token);
}
