package com.practice.demo.Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.practice.demo.model.Member;

@RestController
public class MemberController {

    static List<Member> memberList = new ArrayList<>();

    static {
        memberList.add(new Member(1, "Mani"));
        memberList.add(new Member(2, "Deep"));
        memberList.add(new Member(3, "Akula"));
    }

    //get
    @GetMapping("/manage/getall")
    public List<Member> getAllMembers() {
        System.out.println("Request received for getAllMembers(..)");
        return memberList;
    }

    //post
    @PostMapping("/manage/addmember")
    public String addMember(@RequestBody Member member) {
        memberList.add(member);
        return "Member has been successfully added.";
    }

    //delete
    @DeleteMapping("/manage/deletemember")
    public String deleteMember(@RequestParam int id) {
        for(Member member : memberList) {
        	if(member.getId()==id) {
        		memberList.remove(member);
        		return "Member has been successfully deleted.";
        	}
        }
    	
        
        return "Member with id " + id + " not found.";
    }

    //put
    @PutMapping("/manage/updatemember")
    public String updateMember(@RequestBody Member updatedMember) {
        for (Member member : memberList) {
            if (member.getId() == updatedMember.getId()) {
                member.setName(updatedMember.getName());
                return "Member has been successfully updated.";
            }
        }
        return "Member with id " + updatedMember.getId() + " not found.";
    }
}
