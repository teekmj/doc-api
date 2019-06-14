package com.infer.docapi.parser;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.stereotype.Component;

import com.infer.docapi.domain.Paragraph;
import com.infer.docapi.domain.PolicyDoc;
import com.infer.docapi.domain.ElementStyle;
import com.infer.docapi.domain.SectionType;

@Component
public class DocumentParser {

	public PolicyDoc parseDoc(File file) {
		PolicyDoc policyDoc = new PolicyDoc();

		try (FileInputStream fis = new FileInputStream(file);
				XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));) {

			List<XWPFParagraph> paragraphs = xdoc.getParagraphs();

			policyDoc.setName(file.getName());
			policyDoc.setType("Security policy");

			List<Paragraph> paraList = new ArrayList<>();

			int paraCount = 1;
			int runCount = 1;
			for (XWPFParagraph para : paragraphs) {
				if (!para.getText().isEmpty()) {

					Paragraph para1 = new Paragraph();
					para1.setText(para.getParagraphText());
					para1.setStyle(para.getStyle());
					para1.setSeqNo(paraCount++);

					runCount = 1;
					List<ElementStyle> elementStyles = new ArrayList<>();
					for (XWPFRun r : para.getRuns()) {
						ElementStyle elementStyle = new ElementStyle();
						elementStyle.setBold(r.isBold());
						elementStyle.setColor(r.getColor());
						elementStyle.setSeqNo(runCount++);
						elementStyle.setText(r.getText(r.getTextPosition()));
						elementStyles.add(elementStyle);
					}

					if (para.getRuns().stream().allMatch(r -> r.isBold()) || para1.getStyle() != null) {
						para1.setSectionType(SectionType.HEADING);
					} else {
						para1.setSectionType(SectionType.TEXT);
						if (!paraList.isEmpty()
								&& paraList.get(paraList.size() - 1).getSectionType().equals(SectionType.HEADING)) {
							para1.setSectionType(SectionType.SECTION_HEADING);
						}
					}
					para1.setElementStyles(elementStyles);

					paraList.add(para1);
				}
			}
			policyDoc.setParagraphs(paraList);
			return policyDoc;
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return policyDoc;
	}

}
