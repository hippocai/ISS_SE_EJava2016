/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nus.iss.ejava.ca3.servlet;

import com.nus.iss.ejava.ca3.EJB.DeliveryService;
import com.nus.iss.ejava.ca3.EJB.PodService;
import com.nus.iss.ejava.ca3.POJO.DeliveryBean;
import com.nus.iss.ejava.ca3.POJO.PodBean;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import javax.ejb.EJB;
import javax.json.Json;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.servlet.http.Part;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;

/**
 *
 * @author EasonChua
 */
@WebServlet("/upload")
@MultipartConfig
public class Upload extends HttpServlet {

	private static Client client = null;
	@EJB
	PodService ps;
	@EJB
	DeliveryService ds;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		InputStream inputStream = request.getPart("image").getInputStream();
		Part image = request.getPart("image");
		String note = request.getParameter("note");
		String timeString = request.getParameter("time");
		String podId=request.getParameter("podId");
		//String name=request.get
		byte[] b = new byte[65530];
		inputStream.read(b);
		PodBean pb = new PodBean();
		pb.setImage(b);
		pb.setNote(note);
		Date date = new Date();
		date.setTime(Long.parseLong(timeString));
		DeliveryBean db=ds.getDeliveryBeanByParams(Long.parseLong(podId));
		pb.setDeliveryDate(date);

		pb.setDelivery(db);
		ps.insert(pb);
		long poid=ps.getPodIdByPkgId(Long.parseLong(podId));
		System.out.println(">>>>"+poid);
		client = ClientBuilder.newBuilder().register(MultiPartFeature.class).build();

		// File outputFile = new File("d:\\test.png");
		try (FileOutputStream outputStream = new FileOutputStream("d:\\test.png");) {

			outputStream.write(b);  //write the bytes and your done. 

		} catch (Exception e) {
			e.printStackTrace();
		}
		File outputFile = new File("d:\\test.png");
		//FileDataBodyPart filePart = new FileDataBodyPart("image",outputFile,MediaType.APPLICATION_OCTET_STREAM_TYPE);

		final FileDataBodyPart filePart = new FileDataBodyPart("image", outputFile, MediaType.APPLICATION_OCTET_STREAM_TYPE);
		filePart.setContentDisposition(FormDataContentDisposition.name("image").fileName("test.png").build());
		//DataBodyPart d;
		FormDataMultiPart formDataMultiPart = new FormDataMultiPart();
		final FormDataMultiPart multipart = (FormDataMultiPart) formDataMultiPart.field("podId", poid+"", MediaType.TEXT_PLAIN_TYPE).field("note", note, MediaType.TEXT_PLAIN_TYPE).field("teamId", "e1259f57", MediaType.TEXT_PLAIN_TYPE).field("callback", "http://10.10.25.15:8080/CA3/api/callback", MediaType.TEXT_PLAIN_TYPE).bodyPart(filePart);
		multipart.setMediaType(MediaType.MULTIPART_FORM_DATA_TYPE);
		final WebTarget target = client.target("http://10.10.0.50:8080/epod/upload");
		final Response respons = target.request().post(Entity.entity(multipart, multipart.getMediaType()));
		
		//Response response = target.request(MediaType.APPLICATION_JSON)
		//.get(Response.class);
		System.out.print(respons.getStatus());
	}
}
