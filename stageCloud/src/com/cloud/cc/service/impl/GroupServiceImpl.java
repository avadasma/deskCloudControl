package com.cloud.cc.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.cc.mapper.DevicesMapper;
import com.cloud.cc.mapper.GroupMapper;
import com.cloud.cc.mapper.LogsMapper;
import com.cloud.cc.service.GroupService;
import com.cloud.cc.vo.Devices;
import com.cloud.cc.vo.Group;
import com.cloud.cc.vo.Logs;
@Service
public class GroupServiceImpl implements GroupService {

	@Autowired
	private GroupMapper groupMapper;
	
	@Autowired
	private DevicesMapper devicesMapper;
	
	@Autowired
	private LogsMapper logsMapper;
	
	@Override
	public int addGroupData(Group group) {
		// TODO Auto-generated method stub
		Logs logs=new Logs();
		logs.setContent("添加了分组【"+group.getGroupname()+"】");
		logs.setCreatetime(new Date());
		logs.setUserid(group.getUserid());
		logs.setType(2);
		logsMapper.insertSelective(logs);
		return groupMapper.insertSelective(group);
	}

	@Override
	public int delGroup(Integer groupId,boolean flag,Integer userId) {
		// TODO Auto-generated method stub
		if(flag) {
			List<Devices> lists=devicesMapper.selectByGroupId(groupId);
			String content="";
			for(Devices list:lists) {
				content+=list.getRemark()+",";
			}
			if(content.length()>0){
				content=content.substring(0, content.length()-1);
			}
			Logs logs=new Logs();
			logs.setContent("删除了设备【"+content+"】");
			logs.setCreatetime(new Date());
			logs.setUserid(userId);
			logs.setType(5);
			logsMapper.insertSelective(logs);
			devicesMapper.delByGroupId(groupId);  
		}
		Group group=groupMapper.selectByPrimaryKey(groupId);
		Logs logs=new Logs();
		logs.setContent("删除了分组【"+group.getGroupname()+"】");
		logs.setCreatetime(new Date());
		logs.setUserid(userId);
		logs.setType(2);
		logsMapper.insertSelective(logs);
		return groupMapper.deleteByPrimaryKey(groupId); 
	}

	
	public static void main(String[] args) {
		
	}

	@Override
	public Group selectById(Integer groupId) {
		// TODO Auto-generated method stub
		return groupMapper.selectByPrimaryKey(groupId);
	}

	@Override
	public List<Group> getGroupListByUser(Integer userId) {
		// TODO Auto-generated method stub
		return groupMapper.getGroupListByUser(userId);
	}
}


