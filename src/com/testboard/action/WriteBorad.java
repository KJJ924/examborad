package com.testboard.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.testboard.dao.TestBoardDao;



public class WriteBorad implements IAction {

	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		String fileName = null;
		String uFileName=null;
		StringBuilder filenameBuilder = new StringBuilder();
		StringBuilder ufilenameBuilder = new StringBuilder();
		try {
			request.setCharacterEncoding("utf-8");
		
		Collection<Part> parts = request.getParts();
		
		for(Part p :parts) {
			if(!p.getName().equals("file")) continue;
			
			Part filePart=  p;
			fileName=filePart.getSubmittedFileName();
			filenameBuilder.append(fileName);
			filenameBuilder.append(",");
			
			//파일명 중복을 피하기위한 uuid 사용
			UUID uuid= UUID.randomUUID();
			 uFileName=uuid.toString()+fileName;
			 ufilenameBuilder.append(uFileName);
			 ufilenameBuilder.append(",");
			InputStream fis =filePart.getInputStream();
			String realPath	=request.getServletContext().getRealPath("/upload");
			System.out.println(realPath);
			File path = new File(realPath);
			if(!path.exists())
				path.mkdirs();
			String filePath =realPath +File.separator+ uFileName;
			
			FileOutputStream fos= new FileOutputStream(filePath);
			byte[] buf =new byte[1024];
			int size= 0;
			while((size=fis.read(buf))!=-1)
				fos.write(buf,0,size);
			fos.close();
			fis.close();
		}
		filenameBuilder.delete(filenameBuilder.length()-1, filenameBuilder.length());
		ufilenameBuilder.delete(ufilenameBuilder.length()-1, ufilenameBuilder.length());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HttpSession session = request.getSession();
		String name=request.getParameter("name");
		String title=request.getParameter("title");
		
		if(name==null) 
			name=(String) session.getAttribute("UserID");
		
		String content=request.getParameter("content");
		TestBoardDao dao= new TestBoardDao();
		dao.setInsert(name,title,content,filenameBuilder.toString(),ufilenameBuilder.toString());
		ActionForward forward = new ActionForward();
		forward.setPath("board.do");
		forward.setRedirect(false);
		return forward;
	}

}
