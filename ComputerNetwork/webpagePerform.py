import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import configparser
from math import pi
from selenium import webdriver

config = configparser.ConfigParser()
config.read('config.ini')
url = "http://www.cnu.ac.kr"
path = config.get('DRIVER', 'chrome')
driver = webdriver.Chrome(path)
driver.get(url)

network_time = driver.execute_script("return performance.timing.connectEnd - performance.timing.navigationStart;")
server_time = driver.execute_script("return performance.timing.responseEnd-performance.timing.requestStart;")
browser_time = driver.execute_script("return performance.timing.loadEventEnd - performance.timing.unloadEventStart;")

labels = ["network", "server", "browser"]
datas = [network_time, server_time, browser_time]

print(datas)

# radar chart
'''
N = len(labels)

datas += datas[:1]

angles = [n / float(N) * 2 * pi for n in range(N)]
angles += angles[:1]

ax = plt.subplot(111, polar=True)

plt.xticks(angles[:-1], labels, color='grey', size=8)

ax.set_rlabel_position(0)
plt.yticks([10, 20, 30], ["10", "20", "30"], color='grey', size=7)
plt.ylim(0, 40)

ax.plot(angles, datas, linewidth=1, linestyle='solid')
ax.fill(angles, datas, 'b', alpha=0.1)

plt.show()
'''
driver.quit()
