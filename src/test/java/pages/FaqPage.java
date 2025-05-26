package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;
import java.util.List;

public class FaqPage {

    private static final Logger logger = LogManager.getLogger(FaqPage.class);
    private static final Duration TIMEOUT = Duration.ofSeconds(5);

    public FaqPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "h2.text-sm.font-semibold.text-heading")
    private List<WebElement> questionList;

    @FindBy(css = "div.text-body-dark")
    private List<WebElement> answerList;

    @FindAll({
            @FindBy(css = "svg.flex-shrink-0.stroke-2"),
            @FindBy(css = "svg[stroke='currentColor']"),
            @FindBy(css = "svg.flex-shrink-0.stroke-2[width='18'][height='18']")
    })
    private List<WebElement> toggleList;

    private void logListSizes() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfAllElements(questionList));
        logger.info("questionList boyutu: {}", questionList.size());
        logger.info("answerList boyutu: {}", answerList.size());
        logger.info("toggleList boyutu: {}", toggleList.size());
    }

    private int getToggleListSize() {
        return toggleList.size();
    }

    public String getQuestionText(int index) {
        validateIndex(index, questionList.size(), "questionList");

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(questionList.get(index)));
        return questionList.get(index).getText().trim();
    }

    public String getAnswerText(int index) {
        validateIndex(index, answerList.size(), "answerList");

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(answerList.get(index)));
        return answerList.get(index).getText().trim();
    }

    public void clickToggle(int index) {
        validateIndex(index, toggleList.size(), "toggleList");

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(toggleList.get(index)));
        toggleList.get(index).click();

        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(answerList.get(index)),
                ExpectedConditions.invisibilityOf(answerList.get(index))
        ));
    }

    public boolean isAnswerVisible(int index) {
        if (index >= answerList.size()) {
            logger.error("Index {} answerList boyutunu aşıyor: {}", index, answerList.size());
            return false;
        }

        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(2));
            return wait.until(ExpectedConditions.visibilityOf(answerList.get(index))).isDisplayed();
        } catch (Exception e) {
            logger.error("Cevap görünürlüğü kontrolünde hata: {}", e.getMessage());
            return false;
        }
    }

    private void validateIndex(int index, int size, String listName) {
        if (index >= size) {
            logger.error("Index {} {} boyutunu aşıyor: {}", index, listName, size);
            throw new IndexOutOfBoundsException(
                    "Index " + index + " out of bounds for " + listName + " size " + size
            );
        }
    }
}
