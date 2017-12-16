package com.luantran.musicstore.controller;

import javax.servlet.http.HttpServletRequest;

public class GeneralController {
	// get base URL
		public String getBaseURL(HttpServletRequest request) {
			return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath();
		}
}
