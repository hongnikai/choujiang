package com.lc.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

/*	*//**
	 * 根据图片路径下载图片
	 * @param request
	 * @param _url
	 * @return
	 * @throws Exception
	 *//*
*/	
public class ImgsUtil {
	public static Log log = LogFactory.getLog(ImgsUtil.class);
	
	public static String download(HttpServletRequest request, String _url)
			throws Exception {
		String trueFileName = null;
		log.debug("上传文件开始, 地址: " + _url);
		try {
			// 构造URL
			URL url = new URL(_url);
			// 打开连接
			URLConnection con = url.openConnection();
			// 设置请求超时为5s
			// con.setConnectTimeout(5 * 1000);
			// 输入流
			InputStream is = con.getInputStream();

			// 1K的数据缓冲
			byte[] bs = new byte[1024];
			// 读取到的数据长度
			int len;
			String s = request.getSession().getServletContext().getRealPath("/");// 项目所在磁盘路径
			String projectName = request.getContextPath().replaceAll("/", "");
			s = s.substring(0, s.indexOf(projectName));// 去掉项目名
			trueFileName = "/pictures/au_avatar/" + UUID.randomUUID().toString().replaceAll("-", "") + ".jpg";
			String path = s + trueFileName;
			// 输出的文件流
			File sf = new File(path);
			log.debug("文件输出路径: " + path);
			OutputStream os = new FileOutputStream(sf);
			// 开始读取
			while ((len = is.read(bs)) != -1) {
				os.write(bs, 0, len);
			}
			// 完毕，关闭所有链接
			os.close();
			is.close();

		} catch (IOException e) {

		}
		return trueFileName;
	}
	
}
