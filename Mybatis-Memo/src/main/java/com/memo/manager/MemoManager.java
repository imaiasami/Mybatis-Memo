package com.memo.manager;

import java.util.*;

import com.memo.dao.MemoDao;
import com.memo.vo.Memo;

public class MemoManager {
	private MemoDao dao = new MemoDao();

	// 메모 등록
	public boolean insertMemo(Memo memo) {
		return dao.insertMemo(memo);
	}

	// 메모 수정
	public boolean updateMemo(Memo memo) {
		return dao.updateMemo(memo);
	}

	// 메모 삭제
	public boolean deleteMemo(int no) {
		return dao.deleteMemo(no);
	}

	// 메모 검색
	public Memo selectMemo(int no) {
		return dao.selectMemo(no);
	}

	// 메모 전체출력
	public ArrayList<Memo> selectAllMemo() {
		return dao.selectAllMemo();
	}

}
