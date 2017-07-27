from cortexutils.analyzer import Analyzer
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.action_chains import ActionChains
import time
import re


class SophosAnalyzer(Analyzer):

	def __init(self):

		Analyzer.__init__(self)


	def run(self):

		result={}

		if(self.data_type=='machine_name'):

			machine = self.data

			scan_bool = scan_machine(machine)


		else:
			return self.error("Unsupported observable data type")

		result["success"]=scan_bool




	def scan_machine(machine):

		try:
			sophos_login =  "https://cloud.sophos.com/manage/login"
			sophos_devices = "https://cloud.sophos.com/manage/devices/computers/all"
			sophos_main =  "https://cloud.sophos.com/manage/dashboard"

			#	change raw_input below to input if you are using python 3
			EMAIL = "alexander.wlezien@dps.texas.gov"
			PASSWORD = "SophosCentral1"

			driver = webdriver.Firefox()

			driver.get(sophos_login)

			user_elem = WebDriverWait(driver,10).until(EC.element_to_be_clickable((By.ID,"username")))

			user_elem = driver.find_element_by_name("username")

			pass_elem = driver.find_element_by_name("password")

			user_elem.send_keys(EMAIL)

			pass_elem.send_keys(PASSWORD)

			pass_elem.send_keys(Keys.RETURN)

			time.sleep(5)

			for name in device_names:

				driver.get(sophos_devices)
				
				
				search_elem = WebDriverWait(driver,10).until(EC.element_to_be_clickable((By.ID,"computers-search-search-input")))
				
				time.sleep(3)

				search_elem.send_keys(name)

				search_elem.send_keys(Keys.ENTER)

				time.sleep(5)

				comp_elem = WebDriverWait(driver,30).until(EC.element_to_be_clickable((By.ID,"computers-table-name-0")))

				comp_elem.click()

				time.sleep(3)

				scan_elem = WebDriverWait(driver,10).until(EC.element_to_be_clickable((By.ID,"scan-btn")))

				scan_elem.click()

				scan_elem.click()

				scan_elem.click()

				#print("scan_elem was clicked")

				time.sleep(3)

				scan_btn = driver.find_element_by_xpath("//button[@translate='devices.computer-details.button.scan']")

				#print("scan_btn: " + str(scan_btn))

				scan_btn.click()

				#print("scan_btn was clicked")

				time.sleep(5)
		except:
			return False

		return True
if(__name__=="__main__"):
	SophosAnalyzer().run()