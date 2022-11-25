package pageUIs.wordpress.admin;

public class AdminPostAddNewPageUI {
	public static final String TITLE_TEXTBOX  = "css=h1.wp-block-post-title";
	public static final String BODY_BUTTON = "css=p[class*='block-editor-default']";
	public static final String BODY_TEXTBOX  = "css=p.block-editor-rich-text__editable";
	public static final String PRE_PUBLISH_BUTTON  = "xpath=//button[@class='components-button editor-post-publish-button editor-post-publish-button__button is-primary']";
	public static final String PUBLISH_BUTTON  = "xpath=//button[@class='components-button editor-post-publish-panel__toggle editor-post-publish-button__button is-primary']";
	public static final String PUBLISHED_MESSAGE  = "xpath=//div[@class='components-snackbar__content' and text() = '%s']";

}
