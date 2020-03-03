/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2018 by rumatoest at github.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package net.runelite.client.util;

/**
 * The Class AppLock.
 *
 * @author Vladislav Zablotsky
 */
public class AppLock
{

	private static CrossLock lockInstance;

	/**
	 * Set lock for application instance.
	 * Method must be run only one time at application start.
	 *
	 * @param lockId Unique lock identifiers
	 * @return true if succeeded
	 */
	public synchronized boolean lock(String lockId)
	{
		if (lockInstance == null)
		{
			lockInstance = new CrossLock("application_" + lockId);
		}
		return lockInstance.lock();
	}

	/**
	 * Trying to release application lock.
	 * Thus another application instances will be able to use lock with current ID.
	 */
	public synchronized void release()
	{
		if (lockInstance != null)
		{
			lockInstance.clear();
		}
		lockInstance = null;
	}
}