package rs.ems.data.flux.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ems.data.flux.domain.Authority;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {}
