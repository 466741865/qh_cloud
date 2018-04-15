package com.qh.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qh.cloud.model.po.Users;
import com.qh.cloud.model.vo.ResultData;
import com.qh.cloud.service.UsersService;
import com.qh.cloud.utils.ContantStr;

/**
 * @author QingHang
 * @date 2017年1月11日
 */
@RestController
@RequestMapping(value = "/user")
public class UsersController extends BaseController {

	@Autowired
	private UsersService usersService;

	@RequestMapping(value = "list")
	public ResultData<List<Users>> getUsersList() {
		try {
			List<Users> list = usersService.findList();
			logger.info("lqh", list.toString());

			return new ResultData<List<Users>>(list, true, ContantStr.FIND_SUCCESS);
		} catch (Exception e) {
			logger.error(ContantStr.FIND_FAILED, e);
			return new ResultData<>(false, ContantStr.FIND_FAILED);
		}

	}

}
