package com.biz.grade.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.biz.grade.config.SplitPos;
import com.biz.grade.vo.ScoreVO;
import com.biz.grade.vo.StudentVO;

public class GrServiceImplV1 implements GrService {
	private List<ScoreVO> scList; //score 리스트
	private List<StudentVO> dtList; // student 리스트
	private FileReader fileReader;
	private BufferedReader buffer;

	public GrServiceImplV1() {
		scList = new ArrayList<ScoreVO>();
		dtList = new ArrayList<StudentVO>();

	}

	@Override
	public void inputStudent() {
		Scanner scan = new Scanner(System.in);
		String studentFile = "src/com/biz/exec/grade/data/student.txt";
		try {
			fileReader = new FileReader(studentFile);
			buffer = new BufferedReader(fileReader);
			String reader = "";
			while (true) {
				reader = buffer.readLine();
				if (reader == null) {
					break;
				}

				String students[] = reader.split(":");
				StudentVO sVO = new StudentVO();
				sVO.setNum(students[SplitPos.STUDENT.ST_NUM]);
				sVO.setName(students[SplitPos.STUDENT.ST_NAME]);
				sVO.setMajor(students[SplitPos.STUDENT.ST_MAJOR]);
				sVO.setSc(Integer.valueOf(students[SplitPos.STUDENT.ST_SC]));
				sVO.setTel(students[SplitPos.STUDENT.ST_TEL]);
				dtList.add(sVO);
			}
			buffer.close();
			fileReader.close();
		} catch (FileNotFoundException e) {
			System.out.println(studentFile + "오픈오류발생");
			return;
		} catch (NumberFormatException e) {
			System.out.println("점수숫자변환과정에서 오류");

		} catch (IOException e) {
			System.out.println("버퍼로부터 읽어오는데 오류");
		}
		// 오류가 발생하면 내려와서 사건 처리

	}

	@Override
	public void inputScore() {
		String scoreFile = "src/com/biz/exec/grade/data/score.txt";
		fileReader = null;
		buffer = null;
		
		try {
			fileReader = new FileReader(scoreFile);
			buffer = new BufferedReader(fileReader);
			String reader = "";
			while (true) {
				reader = buffer.readLine();
				if (reader == null) {
					break;
				}

				String students[] = reader.split(":");
				StudentVO sVO = new StudentVO();
				sVO.setNum(students[SplitPos.STUDENT.ST_NUM]);
				sVO.setName(students[SplitPos.STUDENT.ST_NAME]);
				sVO.setMajor(students[SplitPos.STUDENT.ST_MAJOR]);
				sVO.setSc(Integer.valueOf(students[SplitPos.STUDENT.ST_SC]));
				sVO.setTel(students[SplitPos.STUDENT.ST_TEL]);
				dtList.add(sVO);
			}
			buffer.close();
			fileReader.close();
		} catch (FileNotFoundException e) {
			System.out.println(scoreFile + "오픈오류발생");
			return;
		} catch (NumberFormatException e) {
			System.out.println("점수숫자변환과정에서 오류");

		} catch (IOException e) {
			System.out.println("버퍼로부터 읽어오는데 오류");
		}

	}

	@Override
	public void CalcSum() {
		for(ScoreVO sVO : scList) {
			int sum = sVO.getKor();
			sum += sVO.getEng();
			sum += sVO.getMath();
			sum += sVO.getMusic();
			sVO.setSum(sum);
		}
		

	}

	@Override
	public void CalcAvg() {
		for(ScoreVO sVO : scList) {
			int sum = sVO.getSum();
			int avg = sum / 4;
			sVO.setAvg(avg);
			
			
			
		}
		
		

	}

	@Override
	public void scoreList() {
		
		System.out.println("======================================================");
		System.out.println("성적 일람표");
		System.out.println("======================================================");
		System.out.println("학번\t이름\t국어\t영어\t수학\t음악\t총점\t평균");
		System.out.println("------------------------------------------------------");
		
		for(ScoreVO sVO : scList) {
			
			System.out.println(sVO.getNum() + "\t" );
			
			for(StudentVO stVO : dtList) {
				if(sVO.getNum().equals(stVO.getNum())) {
					System.out.println(stVO.getName() + "\t");
					break;
				}
			}
			System.out.print(sVO.getKor() + "\t");
			System.out.print(sVO.getEng()+ "\t");
			System.out.print(sVO.getMath()+ "\t");
			System.out.print(sVO.getMusic()+ "\t");
			System.out.print(sVO.getSum()+ "\t");
			System.out.printf("%5.2f\n", sVO.getAvg());
			
		}
		


	}

}
