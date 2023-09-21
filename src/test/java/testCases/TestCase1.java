package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseFile;
import base.UtilityFile;


public class TestCase1 extends BaseFile{
	@Test
	public void testSteps() {
			
		udemy.getAlertButton();
		udemy.getScrollBar();
		Assert.assertTrue(utils.tikMark("Course assignment with custom messaging", "team") && utils.notTikMark("Course assignment with custom messaging", "growth"));
		Assert.assertTrue(utils.tikMark("Custom user groups","team") && utils.notTikMark("Custom user groups","growth"));
		Assert.assertTrue(utils.tikMark("User adoption","team") && utils.tikMark("User adoption","growth"));		
		UtilityFile.scroll(0, 1800);
		Assert.assertTrue(utils.tikMark("24/7 customer support","team") && utils.tikMark("24/7 customer support","growth"));
	}}
	
