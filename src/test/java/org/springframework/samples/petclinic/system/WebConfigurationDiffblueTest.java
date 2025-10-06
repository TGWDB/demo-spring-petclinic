package org.springframework.samples.petclinic.system;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@ContextConfiguration(classes = {WebConfiguration.class})
@ExtendWith(SpringExtension.class)
class WebConfigurationDiffblueTest {
  @Autowired private WebConfiguration webConfiguration;

  /**
   * Test {@link WebConfiguration#localeResolver()}.
   *
   * <ul>
   *   <li>Given {@link WebConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link WebConfiguration#localeResolver()}
   */
  @Test
  @DisplayName("Test localeResolver(); given WebConfiguration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocaleResolver WebConfiguration.localeResolver()"})
  void testLocaleResolver_givenWebConfiguration() {
    // Arrange and Act
    LocaleResolver actualLocaleResolverResult = webConfiguration.localeResolver();

    // Assert
    assertTrue(actualLocaleResolverResult instanceof SessionLocaleResolver);
    assertNull(((SessionLocaleResolver) actualLocaleResolverResult).getDefaultTimeZone());
  }

  /**
   * Test {@link WebConfiguration#localeResolver()}.
   *
   * <ul>
   *   <li>Given {@link WebConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link WebConfiguration#localeResolver()}
   */
  @Test
  @DisplayName("Test localeResolver(); given WebConfiguration (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocaleResolver WebConfiguration.localeResolver()"})
  void testLocaleResolver_givenWebConfiguration2() {
    // Arrange and Act
    LocaleResolver actualLocaleResolverResult = new WebConfiguration().localeResolver();

    // Assert
    assertTrue(actualLocaleResolverResult instanceof SessionLocaleResolver);
    assertNull(((SessionLocaleResolver) actualLocaleResolverResult).getDefaultTimeZone());
  }

  /**
   * Test {@link WebConfiguration#localeChangeInterceptor()}.
   *
   * <ul>
   *   <li>Given {@link WebConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link WebConfiguration#localeChangeInterceptor()}
   */
  @Test
  @DisplayName("Test localeChangeInterceptor(); given WebConfiguration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocaleChangeInterceptor WebConfiguration.localeChangeInterceptor()"})
  void testLocaleChangeInterceptor_givenWebConfiguration() {
    // Arrange and Act
    LocaleChangeInterceptor actualLocaleChangeInterceptorResult =
        webConfiguration.localeChangeInterceptor();

    // Assert
    assertEquals("lang", actualLocaleChangeInterceptorResult.getParamName());
    assertNull(actualLocaleChangeInterceptorResult.getHttpMethods());
    assertFalse(actualLocaleChangeInterceptorResult.isIgnoreInvalidLocale());
  }

  /**
   * Test {@link WebConfiguration#localeChangeInterceptor()}.
   *
   * <ul>
   *   <li>Given {@link WebConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link WebConfiguration#localeChangeInterceptor()}
   */
  @Test
  @DisplayName("Test localeChangeInterceptor(); given WebConfiguration (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocaleChangeInterceptor WebConfiguration.localeChangeInterceptor()"})
  void testLocaleChangeInterceptor_givenWebConfiguration2() {
    // Arrange and Act
    LocaleChangeInterceptor actualLocaleChangeInterceptorResult =
        new WebConfiguration().localeChangeInterceptor();

    // Assert
    assertEquals("lang", actualLocaleChangeInterceptorResult.getParamName());
    assertNull(actualLocaleChangeInterceptorResult.getHttpMethods());
    assertFalse(actualLocaleChangeInterceptorResult.isIgnoreInvalidLocale());
  }
}
