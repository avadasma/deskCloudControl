package com.cloud.cc.service;

import java.util.List;

import com.cloud.cc.vo.UserTable;
import com.cloud.cc.vo.model.TableModel;
import com.cloud.cc.vo.model.TableProp;

public interface UserTableService {
	
	UserTable selectUserTableByTableId(Integer tableId);
	
	int createTable(TableModel tableModel,UserTable userTable);
	
	int delTable(Integer tableId);
	
	List<TableProp> selectTableFieldList(String tableName);
	
	List<UserTable> selectUserTable(Integer userId,Integer cloudId);
	
	List<UserTable> selectUserTableByCloudId(Integer cloudId);
}
