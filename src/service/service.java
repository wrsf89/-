package service;

import java.util.ArrayList;

import dao.dao;
import dto.dto;

public class service {

	public int nextCno() {
		dao dao = new dao();
		int nextCno = dao.nextCno()+1;
		return nextCno;
	}

	public int memberJoin(dto dto) {
		dao dao = new dao();
		int joinResult = dao.memberJoin(dto);
		return joinResult;
	}

	public ArrayList<dto> memberList() {
		dao dao = new dao();
		ArrayList<dto> memberList = dao.memberList();
		return memberList;
	}

	public dto memberView(int custno) {
		dao dao = new dao();
		dto memberView = dao.memberView(custno);
		return memberView;
	}

	public int memberUpdate(dto memberUpdate) {
		dao dao = new dao();
		int updateResult = dao.memberUpdate(memberUpdate);
		return updateResult;
	}

	public ArrayList<dto> moneyList() {
		dao dao = new dao();
		ArrayList<dto> moneyList = dao.moneyList();
		return moneyList;
	}

}
