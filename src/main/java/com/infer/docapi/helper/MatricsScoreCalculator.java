package com.infer.docapi.helper;

import org.springframework.stereotype.Component;

import com.infer.docapi.domain.UserInteractionMatrics;

@Component
public class MatricsScoreCalculator {
	
	private static final double COPY_COUNT = 0.7;
	private static final double MOUSE_OVER_COUNT = 0.3;
	
	/**
	 * Calculate the score of a paragraph using the event data
	 * more events to be added and factors to be refined
	 * @param interactionMatrics
	 * @return
	 */
	public Double calculateScore(UserInteractionMatrics interactionMatrics) {
		return (interactionMatrics.getCopyCount() * COPY_COUNT + interactionMatrics.getMouseOverCount() * MOUSE_OVER_COUNT) ;
	}
}
