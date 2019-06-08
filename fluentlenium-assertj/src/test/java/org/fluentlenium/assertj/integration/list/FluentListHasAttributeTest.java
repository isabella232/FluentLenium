package org.fluentlenium.assertj.integration.list;

import org.fluentlenium.assertj.AssertionTestSupport;
import org.fluentlenium.assertj.FluentLeniumAssertions;
import org.fluentlenium.assertj.integration.IntegrationTest;
import org.testng.annotations.Test;

import static org.fluentlenium.assertj.AssertionTestSupport.assertThatAssertionErrorIsThrownBy;
import static org.fluentlenium.assertj.FluentLeniumAssertions.assertThat;

/**
 * Integration test for{@link org.fluentlenium.assertj.custom.FluentListAssert}.
 */
public class FluentListHasAttributeTest extends IntegrationTest {

    @Test
    public void shouldHaveAttribute() {
        goTo(DEFAULT_URL);
        assertThat($("input")).hasAttribute("type").contains("checkbox");
    }

    @Test
    public void shouldFailWhenDoesNotHaveAttribute() {
        goTo(DEFAULT_URL);
        assertThatAssertionErrorIsThrownBy(() -> assertThat($("input")).hasAttribute("style"))
                .hasMessage("Not all selected elements have attribute style");
    }

    @Test
    public void shouldNotHaveAttribute() {
        goTo(DEFAULT_URL);
        assertThat($("input")).hasNotAttribute("data-type");
    }

    @Test
    public void shouldFailWhenHasAttribute() {
        goTo(DEFAULT_URL);
        assertThatAssertionErrorIsThrownBy(() -> assertThat($("input")).hasNotAttribute("style"))
                .hasMessage("At least one selected element has attribute style");
    }
}
