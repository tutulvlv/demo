package com.xdailiao.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.taobao.api.ApiException;
import com.xdailiao.entity.Admin;
import com.xdailiao.entity.Clerk;
import com.xdailiao.entity.Pick;
import com.xdailiao.entity.json.AdminList;
import com.xdailiao.service.AdminService;
import com.xdailiao.service.ClerkService;
import com.xdailiao.service.PickService;
import com.xdailiao.service.RelorderService;
import com.xdailiao.service.ResNumStoreService;
import com.xdailiao.utils.Paging;
import com.xdailiao.utils.SendMess;
import com.xdailiao.utils.Upload;

@Controller
@RequestMapping("/test")
public class ResNumStoreController {
	@Resource
	ResNumStoreService resNumStoreService;
	
	@RequestMapping("/update")
	public String upadate(HttpServletRequest request){
		String dept_code=request.getParameter("dept_code");
		Integer id=resNumStoreService.selectDeptCode(dept_code);
		if(id==null){
			resNumStoreService.insertDeptCode(dept_code);
			return "test";
		}
		resNumStoreService.updateDeptCode(id, "change");
		return "test";
	}
}