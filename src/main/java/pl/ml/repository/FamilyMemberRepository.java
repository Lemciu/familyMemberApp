package pl.ml.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ml.model.FamilyMember;

import java.util.List;

public interface FamilyMemberRepository extends JpaRepository<FamilyMember, Long> {
    List<FamilyMember> findAllByFamilyId(Long id);
}
