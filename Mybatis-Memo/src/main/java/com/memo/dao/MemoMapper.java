package com.memo.dao;

import java.util.ArrayList;

import com.memo.vo.Memo;

public interface MemoMapper {
	
	// 메모 등록
	int insertMemo(Memo memo);
	
	// 메모 수정
	int updateMemo(Memo memo);
	
	// 메모 삭제
	int deleteMemo(int no);
	
	// 메모 검색
	Memo selectMemo(int no);
	
	// 메모 전체 출력
	ArrayList<Memo> selectAllMemo();

}
