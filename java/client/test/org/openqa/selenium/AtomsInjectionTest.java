// Licensed to the Software Freedom Conservancy (SFC) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The SFC licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package org.openqa.selenium;

import org.junit.Test;
import org.openqa.selenium.testing.JUnit4TestBase;
import org.openqa.selenium.testing.JavascriptEnabled;
import org.openqa.selenium.testing.NotYetImplemented;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.testing.Ignore.Driver.MARIONETTE;

public class AtomsInjectionTest extends JUnit4TestBase {

  /** http://code.google.com/p/selenium/issues/detail?id=1333 */
  @JavascriptEnabled
  @Test
  @NotYetImplemented({MARIONETTE})
  public void testInjectingAtomShouldNotTrampleOnUnderscoreGlobal() {
    driver.get(pages.underscorePage);
    driver.findElement(By.tagName("body"));
    assertEquals("123", ((JavascriptExecutor) driver).executeScript("return _.join('');"));
  }
}
