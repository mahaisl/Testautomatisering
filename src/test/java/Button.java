import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Button extends TestBase {
    @Test
    void SearchDeparture() {

        String loginUrl = ("http://uitestingplayground.com/click");
        page.navigate(loginUrl);
        // Navigate to the website

        // Click the button to emulate a physical mouse click
        Locator button = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Button That Ignores DOM Click Event"));
        button.click();

        assertThat(button).isEnabled();
    }
}
