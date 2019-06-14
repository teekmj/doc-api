package com.infer.docapi.parser;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.springframework.stereotype.Component;

import com.infer.docapi.domain.ISOGuidelinePolicy;

@Component
public class ISOParser {

	public List<ISOGuidelinePolicy> parseISO() {

		List<String> policySections = new ArrayList<>();
		policySections.add("A.6.1 Internal organization");
		policySections.add("A.6.2 External parties");
		policySections.add("A.8.1 Prior to employment");
		policySections.add("A.8.2 During employment");
		policySections.add("A.8.3 Termination or change of employment");
		policySections.add("A.7.1 Responsibility for assets");
		policySections.add("A.7.2 Information classification");
		policySections.add("A.9.1 Secure areas");
		policySections.add("A.9.2 Equipment security");
		policySections.add("A.10.1 Operational procedures and responsibilities");
		policySections.add("A.10.2 Third party service delivery management");
		policySections.add("A.10.3 System planning and acceptance");
		policySections.add("A.10.4 Protection against malicious and mobile code");
		policySections.add("A.10.5 Back-up");
		policySections.add("A.10.6 Network security management");
		policySections.add("A.10.7 Media handling");
		policySections.add("A.10.8 Exchange of information");
		policySections.add("A.10.9 Electronic commerce services");
		policySections.add("A.10.10 Monitoring");
		policySections.add("A.10.2 Third party service delivery management");
		policySections.add("A.11.1 Business requirement for access control");
		policySections.add("A.11.2 User access management");
		policySections.add("A.11.3 User responsibilities");
		policySections.add("A.11.4 Network access control");
		policySections.add("A.11.5 Operating system access control");
		policySections.add("A.11.6 Application and information access control");
		policySections.add("A.11.7 Mobile computing and teleworking");
		policySections.add("A.12.1 Security requirements of information systems");
		policySections.add("A.12.2 Correct processing in applications");
		policySections.add("A.12.3 Cryptographic controls");
		policySections.add("A.12.4 Security of system files");
		policySections.add("A.12.5 Security in development and support processes");
		policySections.add("A.12.6 Technical Vulnerability Management");
		policySections.add("A.13.1 Reporting information security events and weaknesses");
		policySections.add("A.13.2 Management of information security incidents and improvements");
		policySections.add("A.14.1 Information security aspects of business continuity management");
		policySections.add("A.15.1 Compliance with legal requirements");
		policySections.add("A.15.2 Compliance with security policies and standards, and technical compliance");
		policySections.add("A.15.3 Information systems audit considerations");

		List<String> policies = new ArrayList<>();
		policies.add("Organization of information security");
		policies.add("Asset management");
		policies.add("Human resources security");
		policies.add("Physical and environmental security");
		policies.add("Communications and operations management");
		policies.add("Access control");
		policies.add("Information systems acquisition, development and maintenance");
		policies.add("Information security incident management");
		policies.add("Business continuity management");
		policies.add("Compliance");
		
		List<ISOGuidelinePolicy> isoList =new ArrayList<>();

		try (FileInputStream fis = new FileInputStream("C:\\Users\\TANAY\\Desktop\\ISO27001.docx");
				XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));) {

			List<XWPFParagraph> paragraphs = xdoc.getParagraphs();

			String currentPolicy = null;
			String currentSubPolicy = null;
			boolean iscontrol = false;
			StringBuffer policyText = new StringBuffer();
			boolean isChanged = false;
			ISOGuidelinePolicy iso = new ISOGuidelinePolicy();;
			for (XWPFParagraph para : paragraphs) {
				
				isChanged = false;
				
				for (String p : policies) {
					if (para.getText().contains(p)) {
						currentPolicy = p;
						iscontrol=false;
						isChanged = true;
					}
				}
				
				for (String p : policySections) {
					if (para.getText().contains(p)) {
						
						currentSubPolicy = p;
						
						if(!policyText.toString().isEmpty()) {
							iso.setPolicyText(policyText.toString());
							isoList.add(iso);
							System.out.println(iso);
						}
						iso = new ISOGuidelinePolicy();
						iso.setPolicyName(currentPolicy);
						iso.setSubpolicyName(currentSubPolicy);
						iso.setObjective("Objective: To ensure compliance of systems with organizational security policies and standards.");
						
						policyText = new StringBuffer();
						iscontrol=false;
						isChanged = true;
					}
				}
				
				if(isChanged) {
					continue;
				}
				

				if (currentPolicy != null && currentSubPolicy != null) {
					if(para.getText().contains("Control")) {
						iscontrol = true;
					} else if (para.getText().contains(": ") || para.getText().contains("Objective: ")) {
						System.out.println("Obj--------"+para.getText());
						iso.setObjective(para.getText());
					} else if(!para.getText().contains("A.") && iscontrol) {
						policyText.append(para.getText());
						iscontrol=false;
					} 
				}

			}
			
			if(!policyText.toString().isEmpty()) {
				iso.setPolicyText(policyText.toString());
				isoList.add(iso);
				System.out.println(iso);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return isoList;
	}
}
