package com.biz.grade.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.biz.grade.vo.StudentVO;

public class StudentServiceImplV1 implements StudentService {
	protected List<StudentVO> stList;

	public StudentServiceImplV1() {
		stList = new ArrayList<StudentVO>();
	}

	@Override
	public boolean input() {
		StudentVO sVO = new StudentVO();
		Scanner scan = new Scanner(System.in);
		System.out.print("학번 : (END로 입력중지) >>");
		String strNum = scan.nextLine();
		if(strNum.equals("END")) {
			return false;
		}
		sVO.setNum(strNum);

		// 인트형은 점수말고학년 sc
		System.out.print("이름 >>");
		String strName = scan.nextLine();
		sVO.setName(strName);

		System.out.print("학과 >>");
		String strMajor = scan.nextLine();
		sVO.setMajor(strMajor);

		System.out.print("전화번호 >>");
		String strTel = scan.nextLine();
		sVO.setTel(strTel);

		System.out.print("학년 >>"); // sc는 학년(정수 보고점수인줄암)
		String strSc = scan.nextLine();
		sVO.setSc(Integer.valueOf(strSc));

		int intSc = 0;
		sVO.setSc(intSc);

		try {
			intSc = Integer.valueOf(strSc);
			
		} catch (Exception e) {
			System.out.println("학년은 숫자");
			System.out.println(sVO.getSc() + "다시 입력");
			return true;
		}
		if (intSc < 1 || intSc > 4) {
			System.out.println("학년은 1~4학년까지");
			System.out.println(sVO.getSc() + "다시 입력");
			return true;
		}

		

		stList.add(sVO);
		return true;

	}

	@Override
	public void studentList() {

	}

}
