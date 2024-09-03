import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager
import time

# Pre-Requisite : Install Python Selenium, pytest framework before execute it

# To run this Problem, follow the below instruction
# 1. Store this file anywhere in your local machine
# 2. Navigate to the Terminal/Command Line and execute the below command
# 3. Command "pytest -v test_autify.py"

@pytest.fixture(scope="module")
def setup():
    driver = webdriver.Chrome(service=Service(ChromeDriverManager().install()))
    driver.maximize_window()
    yield driver
    driver.quit()

def test_autify_logo_present(setup):
    driver = setup
    driver.get("https://autify.com/")
    
    WebDriverWait(driver, 10).until(
        EC.visibility_of_element_located((By.XPATH, "//a[@aria-label='home']/img"))
    )
    
    logo = driver.find_element(By.XPATH, "//a[@aria-label='home']/img")
    assert logo.is_displayed(), "Autify logo is not present on the top left side of the page."

def test_english_as_default_language(setup):
    driver = setup
    assert "com" in driver.current_url, "The web page language is not English by default."

def test_change_language(setup):
    driver = setup

    language_dropdown = driver.find_elements(By.CSS_SELECTOR, ".language-dropdown")
    actions = ActionChains(driver)
    actions.move_to_element(language_dropdown[1]).perform()

    japananese_dropdown = driver.find_elements(By.XPATH, "//*[text()='Japanese']")
    japananese_dropdown[1].click()

    WebDriverWait(driver, 10).until(
        EC.url_contains('jp')
    )
    
    assert "jp" in driver.current_url, "The web page language did not change successfully."

if __name__ == "__main__":
    pytest.main(["-v", "test_autify.py"])
