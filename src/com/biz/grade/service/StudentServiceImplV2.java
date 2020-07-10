package com.biz.grade.service;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import com.biz.grade.vo.StudentVO;

public class StudentServiceImplV2 extends StudentServiceImplV1 {
	protected PrintStream output;

	public StudentServiceImplV2() {
		String stFile = "src/com/biz/exec/grade/data/student.txt";

		try {
			output = new PrintStream(stFile);
		} catch (FileNotFoundException e) {
			System.out.println(stFile + "파일생성불가");
			return;
		}
	}

	public void studentList() {
		System.out.println("파일 저장중...");
		for (StudentVO aVO : stList) {
			output.print(aVO.getNum() + ":");
			output.print(aVO.getName() + ":");
			output.print(aVO.getMajor() + ":");
			output.print(aVO.getSc() + ":");
			output.println(aVO.getTel());
		}
		output.close();
		System.out.println("파일 저장 완료");
	}
}
