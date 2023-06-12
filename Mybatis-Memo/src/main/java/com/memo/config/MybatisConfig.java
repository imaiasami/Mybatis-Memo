package com.memo.config;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import java.io.*;

public class MybatisConfig {
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		InputStream inputStream;
		String resource = "mybatis-config.xml";
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
