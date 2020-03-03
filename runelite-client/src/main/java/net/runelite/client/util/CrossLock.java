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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import static net.runelite.client.RuneLite.RUNELITE_DIR;

/**
 * Universal cross application instances locker.
 * Allow you to create simple lock like object which can be used for
 * different application instances. Basic idea is simple - just a simple file lock.
 * <br />
 * All you need is to define unique key for each lock type.
 *
 * @author Vladislav Zablotsky
 */
public class CrossLock
{

	private static final HashMap<String, CrossLock> locks = new HashMap<>();

	private final String id;

	private final File fileToLock;

	private FileOutputStream fileStream;

	private FileChannel fileStreamChannel;

	private FileLock lockOnFile;

	/**
	 * Will create or retrieve lock instance.
	 * Each lock id is unique among all you instances,
	 * thus only one instance can acquire lock for this id.
	 *
	 * @param lockId Unique lock identifier
	 * @return Not null
	 */
	public static CrossLock get(String lockId)
	{
		if (locks.containsKey(lockId))
		{
			return locks.get(lockId);
		}
		else
		{
			synchronized (CrossLock.class)
			{
				if (locks.containsKey(lockId))
				{
					return locks.get(lockId);
				}
				else
				{
					CrossLock cl = new CrossLock(lockId);
					locks.put(lockId, cl);
					return cl;
				}
			}
		}
	}

	/**
	 * Will remove lock object for specific id and release lock if any.
	 *
	 * @param lockId Unique lock identifier
	 */
	public static void remove(String lockId)
	{
		if (locks.containsKey(lockId))
		{
			CrossLock lock = null;
			synchronized (CrossLock.class)
			{
				if (locks.containsKey(lockId))
				{
					lock = locks.remove(lockId);
				}
			}
			if (lock != null)
			{
				lock.release();
			}
		}
	}

	CrossLock(String lockId)
	{
		this.id = lockId;
		fileToLock = new File(RUNELITE_DIR, lockId + ".app_lock");
	}

	/**
	 * Return lock instance identifier.
	 */
	public String id()
	{
		return this.id;
	}

	/**
	 * Activate lock.
	 * Note! This is only cross application (cross instances) lock. It will not work
	 * as lock inside single application instance.
	 *
	 * @return true if lock was acquire or false
	 */
	public synchronized boolean lock()
	{
		if (lockOnFile != null && lockOnFile.isValid())
		{
			return true;
		}
		else
		{
			release();
		}

		String lockContent = "#Java AppLock Object\n#Locked by key: " + id() + "\r\n";
		try
		{
			if (fileToLock.exists())
			{
				fileToLock.createNewFile();
			}
			fileStream = new FileOutputStream(fileToLock);
			fileStreamChannel = fileStream.getChannel();
			lockOnFile = fileStreamChannel.tryLock();
			if (lockOnFile != null)
			{
				fileStream.write(lockContent.getBytes());
			}
		}
		catch (Exception ex)
		{
			if (!(ex instanceof OverlappingFileLockException))
			{
				Logger.getLogger(AppLock.class.getName()).log(Level.WARNING,
					"Can not get application lock for id=" + id() + "\n" + ex.getMessage(), ex);
			}
			return false;
		}

		return lockOnFile != null;
	}

	/**
	 * Release lock associated with this object.
	 */
	public synchronized void release()
	{
		try
		{
			if (lockOnFile != null && lockOnFile.isValid())
			{
				lockOnFile.release();
			}
			lockOnFile = null;

			if (fileStream != null)
			{
				fileStream.close();
				fileStream = null;
			}

			if (fileStreamChannel != null && fileStreamChannel.isOpen())
			{
				fileStreamChannel.close();
			}
			fileStreamChannel = null;
		}
		catch (IOException ex)
		{
			Logger.getLogger(AppLock.class.getName()).log(Level.WARNING,
				"Can not get application lock for id=" + id() + "\n" + ex.getMessage(), ex);
		}
	}

	/**
	 * Release lock and remove lock file.
	 */
	public synchronized void clear()
	{
		release();
		if (fileToLock.exists())
		{
			fileToLock.delete();
		}
	}

	@Override
	protected void finalize() throws Throwable
	{
		this.clear();
		super.finalize();
	}

}