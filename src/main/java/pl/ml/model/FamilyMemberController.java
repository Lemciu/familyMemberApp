package pl.ml.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class FamilyMemberController {
    private FamilyMemberService familyMemberService;

    public FamilyMemberController(FamilyMemberService familyMemberService) {
        this.familyMemberService = familyMemberService;
    }

    @GetMapping("/addFamilyMember")
    public String createFamilyMember() {
        FamilyMember familyMember = familyMemberService.getFamilyMember();
        familyMemberService.save(familyMember);
        return "success";
    }

    @GetMapping("/getFamilyMembers")
    @ResponseBody
    public List<FamilyMember> sendMembers() {
        Long familyId = familyMemberService.getFamilyId();
        return familyMemberService.findAllByFamilyId(familyId);
    }

    @GetMapping("/searchFamilyMember")
    public List<FamilyMember> searchFamilyMember() {
        Long familyId = familyMemberService.getFamilyId();
        return familyMemberService.findAllByFamilyId(familyId);
    }

}
