package com.infer.docapi.helper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.infer.docapi.domain.Paragraph;
import com.infer.docapi.domain.UserInteractionMatrics;

@Component
public class MatricsScoreCalculator {
	
	@Value("${interaction.user.copy.factor}")
	private double copyFactor;
	
	@Value("${interaction.user.select.factor}")
	private double selectionFactor;
	
	@Value("${interaction.user.count.factor}")
	private double countFactor;
	
	@Value("${interaction.user.mouse.factor}")
	private double mouseOverFactor;
	
	@Value("${interaction.user.mouse.time.factor}")
	private double mouseOverTimeFactor;
	
	@Value("${interaction.user.scroll.factor}")
	private double scrollFactor;
	
	@Value("${interaction.user.scroll.time.factor}")
	private double scrollTimeFactor;
	
	/**
	 * Calculate the score of a paragraph using the event data
	 * more events to be added and factors to be refined
	 * @param interactionMatrics
	 * @return
	 */
	public void calculateScore(Paragraph paragraph, UserInteractionMatrics interactionMatrics) {
		paragraph.getUserScore().setCopyCountScore(copyFactor * interactionMatrics.getCopyCount());	
		paragraph.getUserScore().setSelectionCountScore(selectionFactor * interactionMatrics.getSelectionCount());
		paragraph.getUserScore().setCountScore(countFactor * interactionMatrics.getCount());
		paragraph.getUserScore().setMouseOverCountScore(mouseOverFactor * interactionMatrics.getMouseOverCount());
		paragraph.getUserScore().setMouseOverTimeScore(mouseOverTimeFactor * interactionMatrics.getMouseOverTime());
		paragraph.getUserScore().setScrollCountScore(scrollFactor * interactionMatrics.getScrollCount());
		paragraph.getUserScore().setScrollTimeScore(scrollTimeFactor * interactionMatrics.getScrollTime());
	}
}
