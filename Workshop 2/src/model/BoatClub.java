package model;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class BoatClub {
	private ArrayList<Member> membersArray = new ArrayList<>();

	public BoatClub() {

	}

	public void addMember(Member member) {
		this.membersArray.add(member);
	}

	public void removeMember(int id) {
		try {
			membersArray.remove(id);
		} catch (IndexOutOfBoundsException ex) {
			throw new RuntimeException("Not Found!");
		}
	}

	public void changeMemberInfo(int position, String changeName, String changePersonalNumber) throws Exception {
		Member change = membersArray.get(position);

		String var_changeName = changeName;
		String var_changePersonalNumber = changePersonalNumber;

		change.setName(var_changeName);
		change.setPersonalNumber(var_changePersonalNumber);
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
			stringBuilder.append("id: ");
			stringBuilder.append(member.getMemberId() + "\n");
			stringBuilder.append("boat list: \n");
			stringBuilder.append(member.printBoatArray());
		}
		return stringBuilder.toString();
	}

	// TODO believed to work, needs more testing
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
