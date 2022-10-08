package pl.ml.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.ml.model.FamilyMember;
import pl.ml.service.FamilyMemberService;

import java.util.List;

@Controller
public class FamilyMemberController {
    private FamilyMemberService familyMemberService;

    public FamilyMemberController(FamilyMemberService familyMemberService) {
        this.familyMemberService = familyMemberService;
    }

    @GetMapping("/createFamilyMember")
    @ResponseBody
    public String createFamilyMember(Model model) {
        FamilyMember familyMember = familyMemberService.getFamilyMember();
        familyMemberService.save(familyMember);
        model.addAttribute("familyMember", familyMember);
        return "";
    }

    @GetMapping("/searchFamilyMember")
    @ResponseBody
    public List<FamilyMember> searchFamilyMember() {
        Long familyId = familyMemberService.getFamilyId();
        return familyMemberService.findAllByFamilyId(familyId);
    }

}
