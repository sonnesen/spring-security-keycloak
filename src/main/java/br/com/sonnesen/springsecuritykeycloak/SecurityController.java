package br.com.sonnesen.springsecuritykeycloak;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

  @GetMapping("/public")
  public String publicRoute() {
    return "<h1>Public route, feel free to look around</h1>";
  }

  @GetMapping("/private")
  public String privateRoute() {
    return "<h1>Private route, only authorized personal! </h1>";
  }

  @GetMapping("/cookie")
  public String cookie(@AuthenticationPrincipal OidcUser oidcUser) {
    return String.format("""
        <h1>Cookie route, welcome %s</h1>
        <p>E-mail: %s</p>
        <p>Authorities: %s</p>
        <p>Token: %s</p>
          """, oidcUser.getFullName(), oidcUser.getEmail(), oidcUser.getAuthorities(), oidcUser.getIdToken().getTokenValue());
  }

  @GetMapping("/jwt")
  public String jwt(@AuthenticationPrincipal Jwt jwt) {
    return String.format("""
        <h1>JWT route, welcome %s</h1>
        <p>E-mail: %s</p>
        <p>Authorities: %s</p>
        <p>Token: %s</p>
          """, jwt.getClaimAsString("name"), jwt.getClaimAsString("email"), jwt.getClaimAsString("authorities"),
        jwt.getTokenValue());
  }
}
