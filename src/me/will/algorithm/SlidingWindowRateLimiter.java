package me.will.algorithm;

import java.util.concurrent.atomic.AtomicInteger;

public class SlidingWindowRateLimiter {
	//时间窗口，单位是毫秒
	private int windowSizeInMills;
	//在一个完整窗口期内允许通过的最大阈值
	private int maxRequests;

	//时间片数组
	private AtomicInteger[] slices;
	private int slicesSize;
	//每个时间片的时长，单位是毫秒
	private int millsPerSlice;
	private long startTime;
	private long lastAddTime;

}
