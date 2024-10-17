package net.runelite.cache.util;

/*
 * This class is part of MCFS (Mission Control - Flight Software) a development
 * of Team Puli Space, official Google Lunar XPRIZE contestant.
 * This class is released under Creative Commons CC0.
 * @author Zsolt Pocze, Dimitry Polivaev
 * Please like us on facebook, and/or join our Small Step Club.
 * http://www.pulispace.com
 * https://www.facebook.com/pulispace
 * http://nyomdmegteis.hu/en/
 */

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.color.ColorSpace;
import java.awt.image.BandedSampleModel;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ComponentColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.Raster;
import java.awt.image.RenderedImage;
import java.awt.image.SampleModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BigBufferedImage extends BufferedImage
{
	private static final String TMP_DIR = System.getProperty("java.io.tmpdir");
	private static final int MAX_PIXELS_IN_MEMORY = 1024 * 1024;

	public static BufferedImage create(int width, int height, int imageType)
	{
		if (width * height > MAX_PIXELS_IN_MEMORY)
		{
			try
			{
				final File tempDir = new File(TMP_DIR);
				return createBigBufferedImage(tempDir, width, height, imageType);
			}
			catch (IOException e)
			{
				throw new RuntimeException(e);
			}
		}
		else
		{
			return new BufferedImage(width, height, imageType);
		}
	}

	public static BufferedImage create(File inputFile, int imageType) throws IOException
	{
		try (ImageInputStream stream = ImageIO.createImageInputStream(inputFile))
		{
			Iterator<ImageReader> readers = ImageIO.getImageReaders(stream);
			if (readers.hasNext())
			{
				try
				{
					ImageReader reader = readers.next();
					reader.setInput(stream, true, true);
					int width = reader.getWidth(reader.getMinIndex());
					int height = reader.getHeight(reader.getMinIndex());
					BufferedImage image = create(width, height, imageType);
					int cores = Math.max(1, Runtime.getRuntime().availableProcessors() / 2);
					int block = Math.min(MAX_PIXELS_IN_MEMORY / cores / width, (int) (Math.ceil(height / (double) cores)));
					ExecutorService generalExecutor = Executors.newFixedThreadPool(cores);
					List<Callable<ImagePartLoader>> partLoaders = new ArrayList<>();
					for (int y = 0; y < height; y += block)
					{
						partLoaders.add(new ImagePartLoader(
							y, width, Math.min(block, height - y), inputFile, image));
					}
					generalExecutor.invokeAll(partLoaders);
					generalExecutor.shutdown();
					return image;
				}
				catch (InterruptedException ex)
				{
					log.error(null, ex);
				}
			}
		}
		return null;
	}

	private static BufferedImage createBigBufferedImage(File tempDir, int width, int height, int imageType)
		throws IOException
	{
		FileDataBuffer buffer = new FileDataBuffer(tempDir, width * height, 4);
		ColorModel colorModel;
		BandedSampleModel sampleModel;
		switch (imageType)
		{
			case TYPE_INT_RGB:
				colorModel = new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_sRGB),
					new int[]{8, 8, 8, 0},
					false,
					false,
					ComponentColorModel.TRANSLUCENT,
					DataBuffer.TYPE_BYTE);
				sampleModel = new BandedSampleModel(DataBuffer.TYPE_BYTE, width, height, 3);
				break;
			case TYPE_INT_ARGB:
				colorModel = new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_sRGB),
					new int[]{8, 8, 8, 8},
					true,
					false,
					ComponentColorModel.TRANSLUCENT,
					DataBuffer.TYPE_BYTE);
				sampleModel = new BandedSampleModel(DataBuffer.TYPE_BYTE, width, height, 4);
				break;
			default:
				throw new IllegalArgumentException("Unsupported image type: " + imageType);
		}
		SimpleRaster raster = new SimpleRaster(sampleModel, buffer, new Point(0, 0));
		BigBufferedImage image = new BigBufferedImage(colorModel, raster, colorModel.isAlphaPremultiplied(), null);
		return image;
	}

	private static class ImagePartLoader implements Callable<ImagePartLoader>
	{
		private final int y;
		private final BufferedImage image;
		private final Rectangle region;
		private final File file;

		public ImagePartLoader(int y, int width, int height, File file, BufferedImage image)
		{
			this.y = y;
			this.image = image;
			this.file = file;
			region = new Rectangle(0, y, width, height);
		}

		@Override
		public ImagePartLoader call() throws Exception
		{
			Thread.currentThread().setPriority((Thread.MIN_PRIORITY + Thread.NORM_PRIORITY) / 2);
			try (ImageInputStream stream = ImageIO.createImageInputStream(file);)
			{
				Iterator<ImageReader> readers = ImageIO.getImageReaders(stream);
				if (readers.hasNext())
				{
					ImageReader reader = readers.next();
					reader.setInput(stream, true, true);
					ImageReadParam param = reader.getDefaultReadParam();
					param.setSourceRegion(region);
					BufferedImage part = reader.read(0, param);
					Raster source = part.getRaster();
					WritableRaster target = image.getRaster();
					target.setRect(0, y, source);
				}
			}
			return ImagePartLoader.this;
		}
	}

	private BigBufferedImage(ColorModel cm, SimpleRaster raster, boolean isRasterPremultiplied, Hashtable<?, ?> properties)
	{
		super(cm, raster, isRasterPremultiplied, properties);
	}

	public void dispose()
	{
		((SimpleRaster) getRaster()).dispose();
	}

	public static void dispose(RenderedImage image)
	{
		if (image instanceof BigBufferedImage)
		{
			((BigBufferedImage) image).dispose();
		}
	}

	private static class SimpleRaster extends WritableRaster
	{
		public SimpleRaster(SampleModel sampleModel, FileDataBuffer dataBuffer, Point origin)
		{
			super(sampleModel, dataBuffer, origin);
		}

		public void dispose()
		{
			((FileDataBuffer) getDataBuffer()).dispose();
		}
	}

	private static final class FileDataBufferDeleterHook extends Thread
	{
		static
		{
			Runtime.getRuntime().addShutdownHook(new FileDataBufferDeleterHook());
		}

		private static final HashSet<FileDataBuffer> undisposedBuffers = new HashSet<>();

		@Override
		public void run()
		{
			final FileDataBuffer[] buffers = undisposedBuffers.toArray(new FileDataBuffer[0]);
			for (FileDataBuffer b : buffers)
			{
				b.disposeNow();
			}
		}
	}

	private static class FileDataBuffer extends DataBuffer
	{
		private final String id = "buffer-" + System.currentTimeMillis() + "-" + ((int) (Math.random() * 1000));
		private File dir;
		private String path;
		private File[] files;
		private RandomAccessFile[] accessFiles;
		private MappedByteBuffer[] buffer;

		public FileDataBuffer(File dir, int size) throws IOException
		{
			super(TYPE_BYTE, size);
			this.dir = dir;
			init();
		}

		public FileDataBuffer(File dir, int size, int numBanks) throws IOException
		{
			super(TYPE_BYTE, size, numBanks);
			this.dir = dir;
			init();
		}

		private void init() throws IOException
		{
			FileDataBufferDeleterHook.undisposedBuffers.add(this);
			if (dir == null)
			{
				dir = new File(".");
			}
			if (!dir.exists())
			{
				throw new RuntimeException("FileDataBuffer constructor parameter dir does not exist: " + dir);
			}
			if (!dir.isDirectory())
			{
				throw new RuntimeException("FileDataBuffer constructor parameter dir is not a directory: " + dir);
			}
			path = dir.getPath() + "/" + id;
			File subDir = new File(path);
			subDir.mkdir();
			buffer = new MappedByteBuffer[banks];
			accessFiles = new RandomAccessFile[banks];
			files = new File[banks];
			for (int i = 0; i < banks; i++)
			{
				File file = files[i] = new File(path + "/bank" + i + ".dat");
				final RandomAccessFile randomAccessFile = accessFiles[i] = new RandomAccessFile(file, "rw");
				buffer[i] = randomAccessFile.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, getSize());
			}
		}

		@Override
		public int getElem(int bank, int i)
		{
			return buffer[bank].get(i) & 0xff;
		}

		@Override
		public void setElem(int bank, int i, int val)
		{
			buffer[bank].put(i, (byte) val);
		}

		@Override
		protected void finalize() throws Throwable
		{
			dispose();
		}

		public void dispose()
		{
			new Thread()
			{
				@Override
				public void run()
				{
					disposeNow();
				}
			}.start();
		}

		private void disposeNow()
		{
			this.buffer = null;
			if (accessFiles != null)
			{
				for (RandomAccessFile file : accessFiles)
				{
					try
					{
						file.close();
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
				}
				accessFiles = null;
			}
			if (files != null)
			{
				for (File file : files)
				{
					file.delete();
				}
				files = null;
			}
			if (path != null)
			{
				new File(path).delete();
				path = null;
			}
		}

	}
}