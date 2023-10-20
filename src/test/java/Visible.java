import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import org.junit.jupiter.api.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class Visible extends TestBase {
    @Test
    void ClientDelay() {

        String loginUrl = ("http://uitestingplayground.com/clientdelay");
        page.navigate(loginUrl);


        // Click the button to emulate a physical mouse click
        Locator button = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Button Triggering Client Side Logic"));
        button.click();


        page.waitForLoadState(LoadState.LOAD);

        try {
            Thread.sleep(15000);  // Väntar i 15 sekunder (15000 millisekunder)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Locator delayButton = page.locator("#content");
        assertThat(delayButton).isVisible();

    }
}
