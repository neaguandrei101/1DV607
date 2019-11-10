package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BoatClub {
	@JsonProperty("membersArray")
	private List<Member> membersArray = new ArrayList<>();

	BoatClub() {} // this is bad but it is required by RegistryHandler

	public void addMember(Member member) {
		this.membersArray.add(member);
	}

    public void removeMember(int id) throws RuntimeException {
        boolean found = this.membersArray.removeIf(member -> member.getMemberId() == id);
        if (!found)
            throw new RuntimeException("Member Not Found!");
    }

	public void removeBoatFromMember(int id, int boatPos) {
        Optional<Member> memberOptional= this.membersArray.stream()
                .filter(member -> member.getMemberId() == id)
                .findAny();
        memberOptional.ifPresent(member -> member.removeBoat(boatPos));
        memberOptional.orElseThrow(() -> new RuntimeException("Member Not Found!"));
	}

	public void changeBoatInfoFromMember(int id, int boatPos, int length, String boatType) {
        Optional<Member> memberOptional= this.membersArray.stream()
                .filter(member -> member.getMemberId() == id)
                .findAny();
        memberOptional.ifPresent(member -> member.changeBoatInfo(boatPos, length, boatType));
        memberOptional.orElseThrow(() -> new RuntimeException("Member Not Found!"));
	}

	public String getMemberInfo(int id) {
	    Optional<Member> memberOptional = this.membersArray.stream()
                .filter(member -> member.getMemberId() == id)
                .findAny();
	    Member member = memberOptional.orElseThrow(() -> new RuntimeException("Member Not Found!"));
	    return member.toString();
	}

	public void changeMemberName(int id, String newName) {
        Optional<Member> memberOptional= this.membersArray.stream()
                .filter(member -> member.getMemberId() == id)
                .findAny();
        memberOptional.ifPresent(member -> member.setName(newName));
        memberOptional.orElseThrow(() -> new RuntimeException("Member Not Found!"));
	}
	
	public void changeMemberPersonalNumber(int id, String newPersonalNumber) {
        Optional<Member> memberOptional= this.membersArray.stream()
                .filter(member -> member.getMemberId() == id)
                .findAny();
        memberOptional.ifPresent(member -> member.setPersonalNumber(newPersonalNumber));
        memberOptional.orElseThrow(() -> new RuntimeException("Member Not Found!"));
	}

	public String compactListString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Member member : membersArray) {
			stringBuilder.append("Name: ");
			stringBuilder.append(member.getName()).append(" ,");
			stringBuilder.append("id: ");
			stringBuilder.append(member.getMemberId()).append(" ,");
			stringBuilder.append("boats: ");
			stringBuilder.append(member.getNumberOfBoats()).append("\n");
		}
		return stringBuilder.toString();
	}

	public String verboseListString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Member member : membersArray) {
			stringBuilder.append("Name: ");
			stringBuilder.append(member.getName()).append(" ,");
			stringBuilder.append("Personal number: ");
			stringBuilder.append(member.getPersonalNumber()).append(" ,");
			stringBuilder.append("id: ");
			stringBuilder.append(member.getMemberId()).append("\n");
			stringBuilder.append("boat list: \n");
			stringBuilder.append(member.boatArrayToString());
		}
		return stringBuilder.toString();
	}

    public int generateId() {
        Random rand = new Random();
        boolean idAlreadyExists;
        int randomId = rand.nextInt(999) + 1;

        idAlreadyExists = this.membersArray.stream()
                .anyMatch(member -> member.getMemberId() == randomId);
        if(!idAlreadyExists) {
            return randomId;
        } else {
            generateId();
        }
        return 0;
    }

	byte[] getJsonFileMembers() {
		JSONArray jsonMemberArray = new JSONArray();
		for (Member member : membersArray) {
			JSONObject jsonMember = new JSONObject();
			jsonMember.put("name", member.getName());
			jsonMember.put("personalNumber", member.getPersonalNumber());
			jsonMember.put("memberId", member.getMemberId());

			JSONArray jsonMemberBoatArray = new JSONArray();
			for (Boat boat : member.boatArray) {
				JSONObject jsonBoat = new JSONObject();
				jsonBoat.put("length", boat.getLength());
				jsonBoat.put("boatType", boat.getType());
				jsonMemberBoatArray.add(jsonBoat);
			}
			jsonMember.put("boatArray", jsonMemberBoatArray);
			jsonMemberArray.add(jsonMember);
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("membersArray", jsonMemberArray);
		return jsonObject.toJSONString().getBytes();
	}
}
