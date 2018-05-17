package com.botsystem.modules.monitor;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

import com.botsystem.core.BotSystemModule;
import com.sun.management.OperatingSystemMXBean;

/**
 * Module for BotSystem for getting process monitoring stats easily
 * @author BlockBa5her
 *
 */
public class MonitorModule extends BotSystemModule {
	private OperatingSystemMXBean systemBean;
	private MemoryMXBean memoryBean;
	
	/**
	 * Get the process's CPU load
	 * @return The CPU load in decimal form
	 */
	public double getProcessCpuLoad() {
		return systemBean.getProcessCpuLoad();
	}
	/**
	 * Get's the system's CPU load
	 * @return The CPU load in decimal form
	 */
	public double getSystemCpuLoad() {
		return systemBean.getSystemCpuLoad();
	}
	/**
	 * Get's the virtual memory usage
	 * @return Total amount of process memory usage in bytes
	 */
	public long getProcessMemoryUsage() {
		return memoryBean.getHeapMemoryUsage().getUsed() + memoryBean.getNonHeapMemoryUsage().getUsed();
	}
	/**
	 * Get's the system memory usage
	 * @return Total amount of system memory usage in bytes
	 */
	public long getSystemMemoryUsage() {
		return systemBean.getTotalPhysicalMemorySize() - systemBean.getFreePhysicalMemorySize();
	}
	/**
	 * Get's the total amount of system memory
	 * @return The total amount of system memory in bytes
	 */
	public long getTotalSystemMemory() {
		return systemBean.getTotalPhysicalMemorySize();
	}
	
	@Override
	public void onTick() {
		// setting the beans and such
		systemBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
		memoryBean = ManagementFactory.getMemoryMXBean();
	}
}