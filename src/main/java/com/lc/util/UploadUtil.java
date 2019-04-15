package com.lc.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

/**
 * 上传文件
 * 
 * @author MengJinyue
 * 
 */
@SuppressWarnings("all")
public class UploadUtil {
	static Log log = LogFactory.getLog(UploadUtil.class);

	/**
	 * 上传多个文件
	 * 
	 * @param request
	 * @return 所有文件的路径
	 */
	@SuppressWarnings("unchecked")
	public static String uploadFiles(HttpServletRequest request) {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		String trueFileName = null;
		String files = null;
		// 先判断request中是否包涵multipart类型的数据，
		if (multipartResolver.isMultipart(request)) {
			// 再将request中的数据转化成multipart类型的数据
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator iter = multiRequest.getFileNames();
			int i = 0;
			System.out.println("文件个数：" + multiRequest.getMultiFileMap().size());
			while (iter.hasNext()) {
				MultipartFile file = multiRequest.getFile((String) iter.next());
				if (file != null) {
					if (files == null) {
						files = "";
					}

					String fileName = file.getOriginalFilename();
					String type = fileName
							.substring(fileName.lastIndexOf(".") + 1);
					System.out.println("文件类型：" + type);
					if (!fileName.equals("")) {
						String s = request.getSession().getServletContext().getRealPath("/");// 项目所在磁盘路径
						String projectName = request.getContextPath().replaceAll("/", "");
						s = s.substring(0, s.indexOf(projectName));// 去掉项目名
						trueFileName = "/pictures/"+ UUID.randomUUID().toString().replaceAll("-","")
								+ fileName.substring(fileName.lastIndexOf("."));
						String path = s + trueFileName;
						File localFile = new File(path);
						if (!localFile.exists()) {
							localFile.mkdirs();
						}
						// 写文件
						try {
							file.transferTo(localFile);
						} catch (IllegalStateException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
						files += trueFileName + ",";
						i++;
					} else {
						// 此逻辑存在bug
						if (files.equals("")) {
							// 接收的文件不是新上传的文件（编辑---》回显图片----》不改动原始图片，提交表单）
							return null;
						}
					}
				}
				//
			}
		}
		if (files != null) {
			files = files.substring(0, files.length() - 1);
		}
		return files;
	}

	/**
	 * 根据图片路径下载图片
	 * @param request
	 * @param _url
	 * @return
	 * @throws Exception
	 */
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
	
	
	
	public static String uploadFileToPath(MultipartFile file,String basePath ,String path) {

		try {
			String type ;
			String fileName = file.getOriginalFilename();// 文件原名称
			// 判断文件类型
			type = fileName.indexOf(".") != -1 ? fileName.substring(
					fileName.lastIndexOf(".") + 1, fileName.length()) : null;
				if (type.toUpperCase() != null) {

					String trueFileName = RandomUtil.getSimpleDate() + "-" +UUID.randomUUID().toString()
							.replaceAll("-", "").substring(10)
							+ fileName.substring(fileName.lastIndexOf("."));
					basePath = basePath + Constants.SPEADER + path + Constants.SPEADER + new Date().getMonth();
					if(!new File(basePath).exists()){
						new File(basePath).mkdirs();
					}
					trueFileName = basePath + Constants.SPEADER+ trueFileName;
					log.debug("上传文件: " + trueFileName);
					File files = new File(trueFileName );
					try {
						file.transferTo(files);
					} catch (Exception e) {
						log.debug("文件上传异常" + e.getMessage());
						e.printStackTrace();
					}
					trueFileName = trueFileName.replaceAll("\\\\", "/");
					log.debug("返回文件名: " + trueFileName.substring(trueFileName.lastIndexOf(path), trueFileName.length()));
					return trueFileName.substring(trueFileName.lastIndexOf(path), trueFileName.length());
				} else {
					return "";
				}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "";
		}
	}

	/**
	 * 下载图片到指定文件夹下
	 * @param request
	 * @param file
	 * @param path
	 * @return
	 */
	public static String uploadFilesToPath(HttpServletRequest request,MultipartFile file,String path) {
		String basePath = request.getSession().getServletContext().getRealPath("/");
		String contextPath = request.getContextPath();

		System.out.println(basePath+"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		try{
			String tempStr = contextPath.substring(1, contextPath.length() );
			basePath = basePath.substring(0, basePath.lastIndexOf(tempStr) );
		}catch (Exception e){
			System.out.println("在工具类里面存在异常");
		}
		try {
			String type ;
			String fileName = file.getOriginalFilename();// 文件原名称
			// 判断文件类型
			type = fileName.indexOf(".") != -1 ? fileName.substring(
					fileName.lastIndexOf(".") + 1, fileName.length()) : null;
			if (type.toUpperCase() != null) {

				String trueFileName = RandomUtil.getSimpleDate() + "-" +UUID.randomUUID().toString()
						.replaceAll("-", "").substring(10)
						+ fileName.substring(fileName.lastIndexOf("."));
				basePath = basePath + Constants.SPEADER + path + Constants.SPEADER + new Date().getMonth();
				if(!new File(basePath).exists()){
					new File(basePath).mkdirs();
				}
				trueFileName = basePath + Constants.SPEADER+ trueFileName;
				log.debug("上传文件: " + trueFileName);
				File files = new File(trueFileName );
				try {
					file.transferTo(files);
				} catch (Exception e) {
					log.debug("文件上传异常" + e.getMessage());
					e.printStackTrace();
				}
				trueFileName = trueFileName.replaceAll("\\\\", "/");
				log.debug("返回文件名: " + trueFileName.substring(trueFileName.lastIndexOf(path), trueFileName.length()));
				return trueFileName.substring(trueFileName.lastIndexOf(path), trueFileName.length());
			} else {
				return "";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "";
		}
	}
	
	
}
