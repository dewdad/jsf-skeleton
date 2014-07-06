package com.skeleton.jsf.rewrite;

import javax.servlet.ServletContext;

import lombok.extern.slf4j.Slf4j;

import org.ocpsoft.rewrite.annotation.RewriteConfiguration;
import org.ocpsoft.rewrite.config.Configuration;
import org.ocpsoft.rewrite.config.ConfigurationBuilder;
import org.ocpsoft.rewrite.config.Rule;
import org.ocpsoft.rewrite.servlet.config.HttpConfigurationProvider;
import org.ocpsoft.rewrite.servlet.config.rule.Join;

/**
 * UrlRewritting configuration provider. This file is used instead of @Join annotation (i.e.
 *
 * @Join(path = "/login", to="faces/pages/login.xhtml")) when there is no controller associate with
 *            the page.
 *
 * @author Thery
 *
 */
@RewriteConfiguration
@Slf4j
public class MyConfigurationProvider extends HttpConfigurationProvider {

  @Override
  public Configuration getConfiguration(ServletContext context) {
    log.info("Initialize Rewrite Configuration");
    // Add index rule
    Rule indexRule = Join.path("/index").to("faces/pages/index.xhtml");
    return ConfigurationBuilder.begin().addRule(indexRule);
  }

  @Override
  public int priority() {
    return 10;
  }

}
