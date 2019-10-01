package model;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BoatClub {
	@JsonProperty("membersArray")
	private List<Member> membersArray = new ArrayList<>();

	public BoatClub() {

	}

	public void addMember(Member member) {
		this.membersArray.add(member);
	}

	public void removeMember(int posInArray) {
		try {
			membersArray.remove(posInArray);
		} catch (IndexOutOfBoundsException ex) {
			throw new RuntimeException("Not Found!");
		}
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

	public String memberInfoByPN(String pn) {
		boolean found = false;
		String info = null;
		for (int i = 0; i < membersArray.size(); i++) {
			if (membersArray.get(i).getPersonalNumber().equals(pn))
				info = membersArray.get(i).toString();
			found = true;
		}
		if (!found)
			throw new RuntimeException("Not Found!");
		return info;
	}

	public void changeMemberInfo(int position, String changeName, String changePersonalNumber) throws Exception {
		Member change = membersArray.get(position);

		String var_changeName = changeName;
		String var_changePersonalNumber = changePersonalNumber;

		change.setName(var_changeName);
		change.setPersonalNumber(var_changePersonalNumber);
	}

	public void changeMemberName(String personalNumber, String newName) {
		boolean found = false;
		for (int i = 0; i < membersArray.size(); i++) {
			if (membersArray.get(i).getPersonalNumber().equals(personalNumber))
				try {
					membersArray.get(i).setName(newName);
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
		for (int i = 0; i < membersArray.size(); i++) {
			if (membersArray.get(i).getPersonalNumber().equals(personalNumber))
				try {
					membersArray.get(i).setName(newPersonalNumber);
				} catch (Exception e) {
					e.printStackTrace();
				}
			found = true;
		}
		if (!found)
			throw new RuntimeException("Not Found!");
	}

	public String getMemberInfo(int position) {

		Member member = membersArray.get(position);
		return member.toString();
	}

	public String compactListString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Member member : membersArray) {
			stringBuilder.append("Name: ");
			stringBuilder.append(member.getName() + " ,");
			stringBuilder.append("id: ");
			stringBuilder.append(member.getMemberId() + " ,");
			stringBuilder.append("boats: ");
			stringBuilder.append(member.getNumberOfBoats() + "\n");
		}
		return stringBuilder.toString();
	}

	public String verboseListString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Member member : membersArray) {
			stringBuilder.append("Name: ");
			stringBuilder.append(member.getName() + " ,");
			stringBuilder.append("Personal number: ");
			stringBuilder.append(member.getPersonalNumber() + " ,");
			stringBuilder.append("id: ");
			stringBuilder.append(member.getMemberId() + "\n");
			stringBuilder.append("boat list: \n");
			stringBuilder.append(member.printBoatArray());
		}
		return stringBuilder.toString();
	}

	public JSONObject getJsonFileMembers() throws Exception {
		JSONArray jsonMemberArray = new JSONArray();
		for (Member member : membersArray) {
			JSONObject jsonMember = new JSONObject();
			jsonMember.put("name", member.getName());
			jsonMember.put("personalNumber", member.getPersonalNumber());
			jsonMember.put("memberId", member.getMemberId());

			JSONArray jsonMemberBoatArray = new JSONArray();
			for (Boat boat : member.boatArray) {
				JSONObject jsonBoat = new JSONObject();
				jsonBoat.put("boatCounter", boat.getBoatCounter());
				jsonBoat.put("length", boat.getLength());
				jsonBoat.put("type", boat.getType());
				jsonMemberBoatArray.add(jsonBoat);
			}
			jsonMember.put("boatArray", jsonMemberBoatArray);
			jsonMemberArray.add(jsonMember);
		}
		JSONObject jsonClubHouse = new JSONObject();
		jsonClubHouse.put("membersArray", jsonMemberArray);
		return jsonClubHouse;
	}

}
