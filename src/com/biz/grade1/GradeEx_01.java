package com.biz.grade1;

import com.biz.grade.service.StudentService;
import com.biz.grade.service.StudentServiceImplV2;

public class GradeEx_01 {

	public static void main(String[] args) {
		StudentService s2 = new StudentServiceImplV2();
		s2.input();
		s2.studentList();
	}
}
