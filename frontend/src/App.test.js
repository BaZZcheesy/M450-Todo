import { render, screen } from '@testing-library/react';
import userEvent from '@testing-library/user-event';
import App from './App';
import { WebDriver } from 'selenium-webdriver';
const { Builder, By, Key, until } = require('selenium-webdriver')


test('renders ToDo Liste title', () => {
  render(<App />);
  // Find the Text
  const linkElement = screen.getByText(/ToDo Liste/i);
  expect(linkElement).toBeInTheDocument();
  expect(linkElement).toBeVisible();
  expect(linkElement).toHaveClass("headline")
});

test('renders input field', () => {
  render(<App />);

  // Find the input field
  const inputElement = screen.getByRole('textbox');

  // Change the value of the inputField
  inputElement.value = "hello";

  // Check if value == "hello" + is in document
  expect(inputElement).toHaveValue("hello");
  expect(inputElement).toBeInTheDocument();
});

test( 'Access localhost:3000', async () => {
  let driver = await new Builder().forBrowser('chrome').build();
  try {
      await driver.get('http://localhost:3000');
  } finally {
      await driver.quit();
  }
})

test( 'Delete multiple', async () => {
  let driver = await new Builder().forBrowser('chrome').build();
  try {
    await driver.get("http://localhost:3000/")
    await driver.manage().window().setRect({ width: 938, height: 824 })
    await driver.findElement(By.css("input")).click()
    await driver.findElement(By.css("input")).sendKeys("Hello")
    await driver.findElement(By.css("input")).sendKeys(Key.ENTER)
    await driver.findElement(By.css("input")).click()
    await driver.findElement(By.css("input")).sendKeys("Welcome")
    await driver.findElement(By.css("input")).sendKeys(Key.ENTER)
    await driver.findElement(By.css("input")).click()
    await driver.findElement(By.css("input")).sendKeys("Bye")
    await driver.findElement(By.css("input")).sendKeys(Key.ENTER)
    await driver.findElement(By.css("li:nth-child(1) > button")).click()
    await driver.findElement(By.css("li:nth-child(1) > button")).click()
    await driver.findElement(By.css("button:nth-child(1)")).click()
  } finally {
    await driver.quit();
  }
})
