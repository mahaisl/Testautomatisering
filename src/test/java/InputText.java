import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.LocatorAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class InputText extends TestBase {
    @Test
    void InputTexts() {
        String loginUrl = ("http://uitestingplayground.com/textinput");
        page.navigate(loginUrl);


        // Click the button to emulate a physical mouse click
        page.getByPlaceholder("MyButton").fill("Mahmuda");

        Locator button = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Button That Should Change it's Name Based on Input Value"));
        button.click();


        Locator buttonAfterInput = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Mahmuda"));
        assertThat(buttonAfterInput).hasText("Mahmuda");

    }

}

