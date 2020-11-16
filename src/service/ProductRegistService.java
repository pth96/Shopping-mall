package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.ProductDAO;
import dto.ProductDTO;

public class ProductRegistService {

	public int productregist(HttpServletRequest request, HttpServletResponse response) throws IOException {
         String savePath = "E:\\source\\servlet\\Project\\WebContent\\Uploadfile";
		
		MultipartRequest multi = new MultipartRequest(
				request,
				savePath,
				10*1024*1024,
				"UTF-8",
				new DefaultFileRenamePolicy()
				);
		ProductDTO pDTO = new ProductDTO();
		String pid = multi.getParameter("pid");
		String pname = multi.getParameter("pname");
		int pprice = Integer.parseInt(multi.getParameter("pprice")); 
		String pcontents = multi.getParameter("pcontents");
		String pgender = multi.getParameter("pgender");
		int pquantity = Integer.parseInt(multi.getParameter("pquantity"));
        String pfilename = multi.getOriginalFileName((String)multi.getFileNames().nextElement());
        
        pDTO.setPid(pid);
        pDTO.setPname(pname);
        pDTO.setPprice(pprice);
        pDTO.setPcontents(pcontents);
        pDTO.setPgender(pgender);
        pDTO.setPquantity(pquantity);
        pDTO.setPfilename(pfilename);
        
        ProductDAO pDAO = new ProductDAO(); 
        pDAO.dbConnection();
        int puResult = pDAO.productregist(pDTO);
        pDAO.dbClose();
		return puResult;
	}

}
