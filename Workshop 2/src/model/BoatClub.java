package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BoatClub {
    @JsonProperty("membersArray")
    private List<Member> membersArray = new ArrayList<>();

    public void addMember(String name, String personalNumber, int boatType, int boatLength) {
        Boat boat = new Boat(boatType, boatLength);
        Member member = new Member(name, personalNumber, this.generateId(), boat);
        this.membersArray.add(member);
    }

    public List<Member> getMembersArray() {
        return membersArray;
    }

    public void removeMember(int id) throws RuntimeException {
        boolean found = this.membersArray.removeIf(member -> member.getMemberId() == id);
        if (!found)
            throw new RuntimeException("Member Not Found!");
    }

    public void removeBoatFromMember(int id, int boatPos) {
        Optional<Member> memberOptional = this.membersArray.stream()
                .filter(member -> member.getMemberId() == id)
                .findAny();
        memberOptional.ifPresent(member -> member.removeBoat(boatPos));
        memberOptional.orElseThrow(() -> new RuntimeException("Member Not Found!"));
    }

    public void addBoatToMember(int id, int boatType,int boatLength) {
        Optional<Member> memberOptional = this.membersArray.stream()
                .filter(member -> member.getMemberId() == id)
                .findFirst();
        memberOptional.ifPresent(member -> member.addBoat(new Boat(boatType, boatLength)));
        memberOptional.orElseThrow(() -> new RuntimeException("Member Not Found!"));
    }

    public void changeBoatInfoFromMember(int id, int boatPos, int length, int boatType) {
        Optional<Member> memberOptional = this.membersArray.stream()
                .filter(member -> member.getMemberId() == id)
                .findAny();
        memberOptional.ifPresent(member -> member.changeBoatInfo(boatPos, length, boatType));
        memberOptional.orElseThrow(() -> new RuntimeException("Member Not Found!"));
    }

    public Member getMemberFromClub(int id) {
        Optional<Member> memberOptional = this.membersArray.stream()
                .filter(member -> member.getMemberId() == id)
                .findAny();
        return memberOptional.orElseThrow(() -> new RuntimeException("Member Not Found!"));
    }

    public void changeMemberName(int id, String newName) {
        Optional<Member> memberOptional = this.membersArray.stream()
                .filter(member -> member.getMemberId() == id)
                .findAny();
        memberOptional.ifPresent(member -> member.setName(newName));
        memberOptional.orElseThrow(() -> new RuntimeException("Member Not Found!"));
    }

    public void changeMemberPersonalNumber(int id, String newPersonalNumber) {
        Optional<Member> memberOptional = this.membersArray.stream()
                .filter(member -> member.getMemberId() == id)
                .findAny();
        memberOptional.ifPresent(member -> member.setPersonalNumber(newPersonalNumber));
        memberOptional.orElseThrow(() -> new RuntimeException("Member Not Found!"));
    }

    public int generateId() {
        Random rand = new Random();
        if (this.membersArray.isEmpty()) {
            return rand.nextInt(999) + 1;
        } else {
            boolean idAlreadyExists;
            int randomId = rand.nextInt(999) + 1;

            idAlreadyExists = this.membersArray.stream()
                    .anyMatch(member -> member.getMemberId() == randomId);
            if (!idAlreadyExists) {
                return randomId;
            } else {
                generateId();
            }
        }
        return 0;
    }

}
