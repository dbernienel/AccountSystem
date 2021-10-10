package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.nwu.ac.domain.persistence.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRespository extends JpaRepository<Member, Long> {
    Optional<Member> findOneById(Long id);

    List<Member> findAll();

    List<Member> findAllById(List<Long> ids);
}
