package com.swfinal.register;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterMapper {
	int selectMemberDuplicateCount(Map<String, Object> params); 
	int insertMember(Map<String, Object> params);
	
	Map<String, Object> selectMemberInfo(Map<String, Object> params);
	
	int updateMember(Map<String, Object> params);
	int deleteMember(Map<String, Object> params);
}
