package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BoatClub {
	@JsonProperty("membersArray")
	private List<Member> membersArray = new ArrayList<>();

	BoatClub() {}

	public void addMember(Member member) {
		this.membersArray.add(member);
	}

	public void removeMemberByPersonalNumber(String pn) {
		boolean found = false;
		for (int i = 0; i < membersArray.size(); i++) {
			if (membersArray.get(i).getPersonalNumber().equals(pn))
				membersArray.remove(membersArray.get(i));
			found = true;
		}
		if (!found)
			throw new RuntimeException("Not Found!");
	}

	public void removeBoatFromMember(String pn, int boatPos) {
		boolean found = false;
		for (Member member : membersArray) {
			if (member.getPersonalNumber().equals(pn))
				member.removeBoat(boatPos);
			found = true;
		}
		if (!found)
			throw new RuntimeException("Not Found!");
	}

	public void changeBoatInfoFromMember(String pn, int boatPos, int length, String boatType) {
		boolean found = false;
		for (Member member : membersArray) {
			if (member.getPersonalNumber().equals(pn))
				member.changeBoatInfo(boatPos, length, boatType);
			found = true;
		}
		if (!found)
			throw new RuntimeException("Not Found!");
	}

	public String memberInfoByPN(String pn) {
		boolean found = false;
		String info = null;
		for (Member member : membersArray) {
			if (member.getPersonalNumber().equals(pn))
				info = member.toString();
			found = true;
		}
		if (!found)
			throw new RuntimeException("Not Found!");
		return info;
	}

	public void changeMemberName(String personalNumber, String newName) {
		boolean found = false;
		for (Member member : membersArray) {
			if (member.getPersonalNumber().equals(personalNumber))
				try {
					member.setName(newName);
				} catch (Exception e) {
					e.printStackTrace();
				}
			found = true;
		}
		if (!found)
			throw new RuntimeException("Not Found!");
	}
	
	public void changeMemberPersonalNumber(String personalNumber, String newPersonalNumber) {
		boolean found = false;
		for (Member member : membersArray) {
			if (member.getPersonalNumber().equals(personalNumber))
				try {
					member.setPersonalNumber(newPersonalNumber);
				} catch (Exception e) {
					e.printStackTrace();
				}
			found = true;
		}
		if (!found)
			throw new RuntimeException("Not Found!");
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
        boolean idAlreadyExists = false;
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

	public byte[] getJsonFileMembers() {
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
