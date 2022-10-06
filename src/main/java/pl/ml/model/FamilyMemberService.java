package pl.ml.model;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FamilyMemberService {
    public FamilyMemberRepository familyMemberRepository;

    public FamilyMemberService(FamilyMemberRepository familyMemberRepository) {
        this.familyMemberRepository = familyMemberRepository;
    }

    public List<FamilyMember> findAllByFamilyId(Long id) {
        return familyMemberRepository.findAllByFamilyId(id);
    }

    public void save(FamilyMember familyMember) {
        familyMemberRepository.save(familyMember);
    }

    public Long getFamilyId() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:9091/getFamilyId", Long.class);
    }

    public FamilyMember getFamilyMember() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:9091/getFamilyMember", FamilyMember.class);
    }

}
