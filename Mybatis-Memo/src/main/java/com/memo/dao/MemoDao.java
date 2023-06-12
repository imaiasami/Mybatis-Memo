package com.memo.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.memo.config.MybatisConfig;
import com.memo.vo.Memo;

public class MemoDao {

	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

	// 메모 등록
	public boolean insertMemo(Memo memo) {
		try (SqlSession session = factory.openSession()) {
			MemoMapper mapper = session.getMapper(MemoMapper.class);
			Memo selectMemo = mapper.selectMemo(memo.getNo());
			if (selectMemo == null) {
				mapper.insertMemo(memo);
				session.commit();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// 메모 수정
	public boolean updateMemo(Memo memo) {
		try (SqlSession session = factory.openSession()) {
			MemoMapper mapper = session.getMapper(MemoMapper.class);
			if (mapper.updateMemo(memo) > 0) {
				session.commit();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// 메모 삭제
	public boolean deleteMemo(int no) {
		try (SqlSession session = factory.openSession()) {
			MemoMapper mapper = session.getMapper(MemoMapper.class);
			if (mapper.deleteMemo(no) > 0) {
				session.commit();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// 메모 검색
	public Memo selectMemo(int no) {
		try (SqlSession session = factory.openSession()) {
			MemoMapper mapper = session.getMapper(MemoMapper.class);
			return mapper.selectMemo(no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 메모 전체출력
	public ArrayList<Memo> selectAllMemo() {
		try (SqlSession session = factory.openSession()) {
			MemoMapper mapper = session.getMapper(MemoMapper.class);
			return mapper.selectAllMemo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
