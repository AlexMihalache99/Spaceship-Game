/**
 * This class represents a user profile.
 * @author Marios Alexandros Butler, Muhammed Fawaz Sharif, Chris Gibson
 */
public class UserProfile {
	private String name;
	private int hiScore;
	private int userLevel;
	private String skin;


	/**
	 * Create a new user profile, given the name of the user.
	 * @param name The name of the user.
	 */
	public UserProfile(String name) {
		this.name = name;

	}

	/**
	 * Set the name of the user.
	 * @param name The new name of the user.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the name of the user.
	 * @return The user's name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the highest level achieved by the user.
	 * @param userLevel The highest level achieved.
	 */
    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }

	/**
	 * Get the highest level achieved by the user.
	 * @return The highest level achieved.
	 */
	public int getUserLevel() {
		return userLevel;
	}

	/**
	 * Set the skin of the user's avatar.
	 * @param skin The skin.
	 */
	public void setSkin(String skin) {
		this.skin = skin;
	}

	/**
	 * Get the skin of the user's avatar.
	 * @return The skin.
	 */
	public String getSkin() {
		return skin;
	}

	/**
	 * Set the user's high score.
	 * @param hiScore The high score.
	 */
	public void setHiScore(int hiScore) {
		this.hiScore = hiScore;
	}

	/**
	 * Get the user's high score.
	 * @return The high score.
	 */
	public int getHiScore() {
		return hiScore;
	}

	/**
	 * Converts a UserProfile into a readable layout.
	 * @return A string giving information regarding the user.
	 */
	@Override
	public String toString() {
		return  this.name +"," + this.hiScore +"," + this.userLevel +"," + this.skin;
	}



}
