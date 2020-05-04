package com.adrmenam.examples.bowling;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.adrmenam.examples.sharedMethods.NotAllowedRoll;
import com.adrmenam.examples.sharedMethods.sharedMethods;

public class BowlingMatch implements Game {

	private ArrayList<Score> scores;

	public BowlingMatch() {
		this.scores = new ArrayList<Score>();
	}

	@Override
	public void play(String filePath) throws NotAllowedRoll, NumberFormatException {
		// TODO Auto-generated method stub
		
		List<String> attempts = new ArrayList<>();

		try (Stream<String> stream = Files.lines(Paths.get(filePath))) {

			attempts = stream.collect(Collectors.toList());

		} catch (IOException e) {
			System.out.println("File with name: "+filePath+" does not exist.");
		}

		for (String attempt : attempts) {

			int playerIndex = sharedMethods.getIndexByPlayerName(scores, attempt.split("	")[0]);

			if (playerIndex == -1) {
				this.scores.add(new Score(new Player(attempt.split("	")[0])));
				playerIndex = sharedMethods.getIndexByPlayerName(scores, attempt.split("	")[0]);
			}

			if (!this.scores.get(playerIndex).addBall(new Ball(attempt.split("	")[1]))) {
				throw new NotAllowedRoll("More than allowed balls played");
			}

		}
		;

	}

	@Override
	public void printScores() {
		// TODO Auto-generated method stub
		System.out.print("Frame");
		for (int i = 1; i <= BowlingScoreBoard.FRAME_NUMBER; i++) {
			System.out.print("\t\t" + i);
		}

		for (Score score : this.scores) {
			System.out.print("\n");
			System.out.println(score.getPlayer().getName());
			System.out.print("Pinfalls\t");
			for (GenericFrame frame : score.getFrames()) {

				for (int i = 0; i < frame.getBalls().size(); i++) {
					if (frame.getBalls().get(i).getPins() == 10) {
						if (frame.getBalls().size() == 1)
							System.out.print("\t");
						System.out.print("X\t");

					} else if (frame.sumBalls() == 10 && i == frame.getBalls().size() - 1) {
						System.out.print("/\t");
					} else {
						System.out.print(frame.getBalls().get(i).getRollResult() + "\t");
					}

				}
			}
			score.calculateScore();
			System.out.print("\nScore\t\t");
			for (GenericFrame frame : score.getFrames()) {

				System.out.print(frame.getScore() + "\t\t");

			}

		}

	}

}
