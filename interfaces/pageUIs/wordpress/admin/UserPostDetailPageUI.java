package pageUIs.wordpress.admin;

public class UserPostDetailPageUI {
	public static final String POST_TITLE_TEXT = "xpath=//article//h1[text()='%s']";
	public static final String POST_CURRENT_DATE_TEXT_BY_POTS_TITLE = "xpath=//article//h1[text()='%s']/parent::header//time[text()='%s']";
	public static final String POST_BODY_TEXT = "xpath=//article//h1[text()='%s']/parent::header/following-sibling::div//p[text()='%s']";
	public static final String POST_AUTHOR_TEXT = "xpath=//article//h1[text()='%s']/parent::header//a[text()='%s']";


}
