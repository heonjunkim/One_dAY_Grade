package com.biz.grade.service;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;

import com.biz.grade.vo.ScoreVO;
import com.biz.grade.vo.StudentVO;

public class GrServiceImplV2 extends GrServiceImplV1 {
	protected PrintStream output;
	private List<ScoreVO> ssList;
	private List<StudentVO> dtList;

	public GrServiceImplV2() {
		String sFile = "src/com/biz/exec/grade/data/pot.txt";

		try {
			output = new PrintStream(sFile);
		} catch (FileNotFoundException e) {
			System.out.println(sFile + "파일생성불가");
			return;
		}
	}

	@Override
	public void inputStudent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void inputScore() {
		// TODO Auto-generated method stub

	}

	@Override
	public void CalcSum() {
		// TODO Auto-generated method stub

	}

	@Override
	public void CalcAvg() {
		// TODO Auto-generated method stub

	}

	public void scoreList() {
		for (ScoreVO sVO : ssList) {

			System.out.println(sVO.getNum() + "\t");

			for (StudentVO stVO : dtList) {
				if (sVO.getNum().equals(stVO.getNum())) {
					output.println(stVO.getName() + "\t");
					break;
				}
			}
			output.print(sVO.getKor() + "\t");
			output.print(sVO.getEng() + "\t");
			output.print(sVO.getMath() + "\t");
			output.print(sVO.getMusic() + "\t");
			output.print(sVO.getSum() + "\t");
			output.printf("%5.2f\n", sVO.getAvg());

		}
	}
}
