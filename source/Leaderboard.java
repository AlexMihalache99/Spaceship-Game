import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This class acts as the leaderboard for the game, storing the user profiles of
 * the three users with the highest score for each of the five levels.
 * @author Alexandru Mihalache and Marios Alexandros Butler
 * */
public class Leaderboard {

    private static UserProfile[] level1 = new UserProfile[3];
    private static UserProfile[] level2 = new UserProfile[3];
    private static UserProfile[] level3 = new UserProfile[3];
    private static UserProfile[] level4 = new UserProfile[3];
    private static UserProfile[] level5 = new UserProfile[3];


    private static File level1file = new File("leaderboard1.txt");
    private static File level2file = new File("leaderboard2.txt");
    private static File level3file = new File("leaderboard3.txt");
    private static File level4file = new File("leaderboard4.txt");
    private static File level5file = new File("leaderboard5.txt");

	/**
	 * Adds a profile to one of the arrays if their score is high enough
	 * to be on the leaderboard for one of the five levels.
	 * @param newProfile The profile.
	 */
    public static void addProfile(UserProfile newProfile) {
        int level = newProfile.getUserLevel();
        if (level == 1) {
            level1Insert(newProfile);
        } else if (level == 2) {
            level2Insert(newProfile);
        } else if (level == 3) {
            level3Insert(newProfile);
        } else if (level == 4) {
            level4Insert(newProfile);
        } else {
            level5Insert(newProfile);
        }
    }

	/**
	 * Inserts a profile in the array which represents the leaderboard for level 1.
	 * @param newProfile The profile to be inserted.
	 * @return The updated array.
	 */
    private static UserProfile[] level1Insert(UserProfile newProfile) {
    	int highScore = newProfile.getHiScore();
    	boolean isNull = false;

      ///if there are no profiles in this level
        if(level1[0] == null) {
        	level1[0] = newProfile;
        	isNull = true;

        } else if(level1[1] == null) {
      ///if there is just one profile for this level

        	if(level1[0].getHiScore() < highScore) {
        		level1[1] = level1[0];
        		level1[0] = newProfile;
        	} else {
        		level1[1] = newProfile;
        	}
        	isNull = true;

        } else if(level1[2] == null) {
       ///if there are just two profiles for this level

        	if(level1[0].getHiScore() < highScore) {
        		level1[2] = level1[1];
        		level1[1] = level1[0];
        		level1[0] = newProfile;
        	} else if (level1[1].getHiScore() < highScore) {
        		level1[2] = level1[1];
        		level1[1] = newProfile;
        	} else {
        		level1[2] = newProfile;
        	}
        	isNull = true;
        }

        if(isNull == false) {

        	if(level1[0].getHiScore() < highScore) {
        		level1[2] = level1[1];
        		level1[1] = level1[0];
        		level1[0] = newProfile;
        	} else if (level1[1].getHiScore() < highScore) {
        		level1[2] = level1[1];
        		level1[1] = newProfile;
        	} else if(level1[2].getHiScore() < highScore){
        		level1[2] = newProfile;
        	}


        }
        return level1;
    }

	/**
	 * Inserts a profile in the array which represents the leaderboard for level 2.
	 * @param newProfile The profile to be inserted.
	 * @return The updated array.
	 */
    private static UserProfile[] level2Insert(UserProfile newProfile) {
        int highScore = newProfile.getHiScore();



        boolean isNull = false;

      ///if there are no profiles in this level
        if(level2[0] == null) {
        	level2[0] = newProfile;
        	isNull = true;

        } else if(level2[1] == null) {
      ///if there is just one profile for this level

        	if(level2[0].getHiScore() < highScore) {
        		level2[1] = level2[0];
        		level2[0] = newProfile;
        	} else {
        		level2[1] = newProfile;
        	}
        	isNull = true;

        } else if(level2[2] == null) {
       ///if there are just two profiles for this level

        	if(level2[0].getHiScore() < highScore) {
        		level2[2] = level2[1];
        		level2[1] = level2[0];
        		level2[0] = newProfile;
        	} else if (level2[1].getHiScore() < highScore) {
        		level2[2] = level2[1];
        		level2[1] = newProfile;
        	} else {
        		level2[2] = newProfile;
        	}
        	isNull = true;
        }

        if(isNull == false) {

        	if(level2[0].getHiScore() < highScore) {
        		level2[2] = level2[1];
        		level2[1] = level2[0];
        		level2[0] = newProfile;
        	} else if (level2[1].getHiScore() < highScore) {
        		level2[2] = level2[1];
        		level2[1] = newProfile;
        	} else if(level2[2].getHiScore() < highScore){
        		level2[2] = newProfile;
        	}

        }
        return level2;
    }

	/**
	 * Inserts a profile in the array which represents the leaderboard for level 3.
	 * @param newProfile The profile to be inserted.
	 * @return The updated array.
	 */
    private static UserProfile[] level3Insert(UserProfile newProfile) {
        int highScore = newProfile.getHiScore();

    	boolean isNull = false;

      ///if there are no profiles in this level
        if(level3[0] == null) {
        	level3[0] = newProfile;
        	isNull = true;

        } else if(level3[1] == null) {
      ///if there is just one profile for this level

        	if(level3[0].getHiScore() < highScore) {
        		level3[1] = level3[0];
        		level3[0] = newProfile;
        	} else {
        		level3[1] = newProfile;
        	}
        	isNull = true;

        } else if(level3[2] == null) {
       ///if there are just two profiles for this level

        	if(level3[0].getHiScore() < highScore) {
        		level3[2] = level3[1];
        		level3[1] = level3[0];
        		level3[0] = newProfile;
        	} else if (level3[1].getHiScore() < highScore) {
        		level3[2] = level3[1];
        		level3[1] = newProfile;
        	} else {
        		level3[2] = newProfile;
        	}
        	isNull = true;
        }

        if(isNull == false) {

        	if(level3[0].getHiScore() < highScore) {
        		level3[2] = level3[1];
        		level3[1] = level3[0];
        		level3[0] = newProfile;
        	} else if (level3[1].getHiScore() < highScore) {
        		level3[2] = level3[1];
        		level3[1] = newProfile;
        	} else if(level3[2].getHiScore() < highScore){
        		level3[2] = newProfile;
        	}


        }
        return level3;
    }

	/**
	 * Inserts a profile in the array which represents the leaderboard for level 4.
	 * @param newProfile The profile to be inserted.
	 * @return The updated array.
	 */
    private static UserProfile[] level4Insert(UserProfile newProfile) {
        int highScore = newProfile.getHiScore();

    	boolean isNull = false;

      ///if there are no profiles in this level
        if(level4[0] == null) {
        	level4[0] = newProfile;
        	isNull = true;

        } else if(level4[1] == null) {
      ///if there is just one profile for this level

        	if(level4[0].getHiScore() < highScore) {
        		level4[1] = level4[0];
        		level4[0] = newProfile;
        	} else {
        		level4[1] = newProfile;
        	}
        	isNull = true;

        } else if(level4[2] == null) {
       ///if there are just two profiles for this level

        	if(level4[0].getHiScore() < highScore) {
        		level4[2] = level4[1];
        		level4[1] = level4[0];
        		level4[0] = newProfile;
        	} else if (level4[1].getHiScore() < highScore) {
        		level4[2] = level4[1];
        		level4[1] = newProfile;
        	} else {
        		level4[2] = newProfile;
        	}
        	isNull = true;
        }

        if(isNull == false) {

        	if(level4[0].getHiScore() < highScore) {
        		level4[2] = level4[1];
        		level4[1] = level4[0];
        		level4[0] = newProfile;
        	} else if (level4[1].getHiScore() < highScore) {
        		level4[2] = level4[1];
        		level4[1] = newProfile;
        	} else if(level4[2].getHiScore() < highScore){
        		level4[2] = newProfile;
        	}


        }
        return level4;
    }

	/**
	 * Inserts a profile in the array which represents the leaderboard for level 5.
	 * @param newProfile The profile to be inserted.
	 * @return The updated array.
	 */
    private static UserProfile[] level5Insert(UserProfile newProfile) {
        int highScore = newProfile.getHiScore();

    	boolean isNull = false;

      ///if there are no profiles in this level
        if(level5[0] == null) {
        	level5[0] = newProfile;
        	isNull = true;

        } else if(level5[1] == null) {
      ///if there is just one profile for this level

        	if(level5[0].getHiScore() < highScore) {
        		level5[1] = level5[0];
        		level5[0] = newProfile;
        	} else {
        		level5[1] = newProfile;
        	}
        	isNull = true;

        } else if(level5[2] == null) {
       ///if there are just two profiles for this level

        	if(level5[0].getHiScore() < highScore) {
        		level5[2] = level5[1];
        		level5[1] = level5[0];
        		level5[0] = newProfile;
        	} else if (level5[1].getHiScore() < highScore) {
        		level5[2] = level5[1];
        		level5[1] = newProfile;
        	} else {
        		level5[2] = newProfile;
        	}
        	isNull = true;
        }

        if(isNull == false) {

        	if(level5[0].getHiScore() < highScore) {
        		level5[2] = level5[1];
        		level5[1] = level5[0];
        		level5[0] = newProfile;
        	} else if (level5[1].getHiScore() < highScore) {
        		level5[2] = level5[1];
        		level5[1] = newProfile;
        	} else if(level5[2].getHiScore() < highScore){
        		level5[2] = newProfile;
        	}


        }
        return level5;
    }

	/**
	 * Updates the text file storing the leaderboard for one of the five levels.
	 * @param file The text file.
	 * @param level The level.
	 * @throws IOException
	 */
    public static void updateLevel(File file, int level) throws IOException {

    	FileWriter fileWriter = new FileWriter(file);
    	PrintWriter printWriter = new PrintWriter(fileWriter);

    	if(level == 1) {
    		printWriter.write(level1[0].getName() + " " +level1[0].getHiScore() + "\n");
    		printWriter.write(level1[1].getName() + " " +level1[1].getHiScore() + "\n");
    		printWriter.write(level1[2].getName() + " " +level1[2].getHiScore());
    	} else if(level == 2) {
    		System.out.println(level2[0].getName());
    		printWriter.write(level2[0].getName() + " " +level2[0].getHiScore() + "\n");
    		printWriter.write(level2[1].getName() + " " +level2[1].getHiScore() + "\n");
    		printWriter.write(level2[2].getName() + " " +level2[2].getHiScore());
    	} else if(level == 3) {

    		printWriter.write(level3[0].getName() + " " +level3[0].getHiScore() + "\n");
    		printWriter.write(level3[1].getName() + " " +level3[1].getHiScore() + "\n");
    		printWriter.write(level3[2].getName() + " " +level3[2].getHiScore());
    	} else if(level == 4) {

    		printWriter.write(level4[0].getName() + " " +level4[0].getHiScore() + "\n");
    		printWriter.write(level4[1].getName() + " " +level4[1].getHiScore() + "\n");
    		printWriter.write(level4[2].getName() + " " +level4[2].getHiScore());
    	} else if(level == 5) {

    		printWriter.write(level5[0].getName() + " " +level5[0].getHiScore() + "\n");
    		printWriter.write(level5[1].getName() + " " +level5[1].getHiScore() + "\n");
    		printWriter.write(level5[2].getName() + " " +level5[2].getHiScore());
    	}

    	printWriter.close();

    }

	/**
	 * Get the level 1 text file.
	 * @return The level 1 text file.
	 */
    public static File getLevel1File() {
    	return Leaderboard.level1file;
    }

	/**
	 * Get the level 2 text file.
	 * @return The level 2 text file.
	 */
    public static File getLevel2File() {
    	return Leaderboard.level2file;
    }

	/**
	 * Get the level 3 text file.
	 * @return The level 3 text file.
	 */
    public static File getLevel3File() {
    	return Leaderboard.level3file;
    }

	/**
	 * Get the level 4 text file.
	 * @return The level 4 text file.
	 */
    public static File getLevel4File() {
    	return Leaderboard.level4file;
    }

	/**
	 * Get the level 5 text file.
	 * @return The level 5 text file.
	 */
    public static File getlevel5File() {
    	return Leaderboard.level5file;
    }

}
