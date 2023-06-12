package com.memo.ui;

import java.util.*;

import com.memo.manager.MemoManager;
import com.memo.vo.Memo;

public class MemoUI {
	private Scanner scan = new Scanner(System.in);
	private MemoManager manager = new MemoManager();
	
	public MemoUI() {
		while (true) {
			System.out.println("1. 메모 등록");
			System.out.println("2. 메모 수정");
			System.out.println("3. 메모 삭제");
			System.out.println("4. 메모 검색");
			System.out.println("5. 메모 전체출력");
			System.out.print("번호 > ");
			String input = scan.nextLine();
			
			switch (input) {
				case "1" : insertMemo(); break;
				case "2" : updateMemo(); break;
				case "3" : deleteMemo(); break;
				case "4" : selectMemo(); break;
				case "5" : selectAllMemo(); break;
				default : System.out.println("다시 입력해 주세요");
			}
		}
	}

	// 메모 등록
	public void insertMemo() {
		System.out.print("메모 제목 : ");
		String title = scan.nextLine();
		System.out.print("메모 내용 : ");
		String content = scan.nextLine();
		
		Memo memo = new Memo();
		memo.setTitle(title);
		memo.setContent(content);
		
		if (manager.insertMemo(memo)) {
			System.out.println("메모 등록 완료");
		} else {
			System.out.println("메모 등록 실패");
		}
	}
	
	// 메모 수정
	public void updateMemo() {
		System.out.print("수정할 메모 번호 : ");
		String input = scan.nextLine();
		int no = 0;
		try {
			no = Integer.parseInt(input);
		} catch (Exception e) {
			System.out.println("숫자를 입력해 주세요");
			return;
		}
		
		Memo memo = manager.selectMemo(no);
		if (memo != null) {
			System.out.print("제목 수정 : ");
			String title = scan.nextLine();
			System.out.print("내용 수정 : ");
			String content = scan.nextLine();
			memo.setTitle(title);
			memo.setContent(content);
			if (manager.updateMemo(memo)) {
				System.out.println("매모가 수정되었습니다.");
			} else {
				System.out.println("메모 수정에 실패했습니다.");
			}
		} else {
			System.out.println("메모 수정에 성공했습니다.");
		}
	}
	
	// 메모 삭제
	public void deleteMemo() {
		System.out.print("삭제할 메모 번호 ");
		String input = scan.nextLine();
		int no = 0;
		try {
			no = Integer.parseInt(input);
		} catch (Exception e) {
			System.out.println("번호를 다시 입력해 주세요");
			return;
		}
		
		if (manager.deleteMemo(no)) {
			System.out.println("메모를 삭제 했습니다.");
		} else {
			System.out.println("메모 삭제에 실패했습니다.");
		}
	}
	
	// 메모 검색
	public void selectMemo() {
		System.out.print("메모 번호 : ");
		String input = scan.nextLine();
		int no = 0;
		try {
			no = Integer.parseInt(input);
		} catch (Exception e) {
			System.out.println("번호를 다시 입력해 주세요");
			return;
		}
		
		Memo memo = manager.selectMemo(no);
		if (memo != null) {
			System.out.println(memo);
		} else {
			System.out.println("검색된 메모가 없습니다.");
		}
		
	}
	
	// 전체 메모 출력
	public void selectAllMemo() {
		ArrayList<Memo> list = manager.selectAllMemo();

		if (list.size() > 0) {
			for (Memo memo : list) {
				System.out.println(memo);
			}
		} else {
			System.out.println("등록된 메모가 없습니다.");
		}
	}
	
	public static void main(String[] args) {
		new MemoUI();
	}
}
