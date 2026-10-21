/*
 * Copyright (c) 2026 Abex
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.util;

import com.google.common.base.CharMatcher;
import com.google.common.collect.ImmutableSet;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.CopyOption;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.ProviderMismatchException;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Nullable;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import lombok.NonNull;
import net.runelite.api.Client;
import net.runelite.client.plugins.Plugin;
import org.jetbrains.annotations.VisibleForTesting;

/**
 * A path to a file or directory that cannot escape its original location.
 *
 * A {@code Filepath} wraps {@link Path} in a way that prevents Plugins from
 * writing to unexpected locations. Plugins may obtain a {@code Filepath} by
 * calling {@link Plugin#getPluginDirectory()} or using a {@link Chooser}
 *
 * @see Path
 */
public class Filepath implements Comparable<Filepath>
{
	private static final CharMatcher BAD_CHARS = CharMatcher.inRange('\0', '\u001f')
		.or(CharMatcher.anyOf("<>:\"/\\|?*~"));

	@VisibleForTesting
	static final Set<String> DOS_DEVICES = ImmutableSet.of(
		"con",
		"conin$",
		"conout$",
		"prn",
		"aux",
		"nul",
		"com1",
		"com2",
		"com3",
		"com4",
		"com5",
		"com6",
		"com7",
		"com8",
		"com9",
		"com¹",
		"com²",
		"com³",
		"lpt1",
		"lpt2",
		"lpt3",
		"lpt4",
		"lpt5",
		"lpt6",
		"lpt7",
		"lpt8",
		"lpt9",
		"lpt¹",
		"lpt²",
		"lpt³"
	);

	private final Path root;
	private final Path fullPath;

	private Filepath(Path root, Path fullPath)
	{
		if (root == null)
		{
			throw new IllegalArgumentException("invalid (null) root");
		}

		if (fullPath == null)
		{
			throw new IllegalArgumentException("Path escaped its root");
		}

		if (root.getFileSystem() != fullPath.getFileSystem())
		{
			throw new ProviderMismatchException();
		}

		root = root.toAbsolutePath().normalize();
		fullPath = fullPath.toAbsolutePath().normalize();

		if (!fullPath.startsWith(root))
		{
			throw new IllegalArgumentException("Path escaped its root");
		}

		this.root = root;
		this.fullPath = fullPath;
	}

	/**
	 * Append the given path segments to this path
	 *
	 * @see Path#resolve
	 */
	public Filepath join(String append, String... more)
	{
		var appendPath = root.getFileSystem().getPath(append, more);
		if (appendPath.isAbsolute())
		{
			throw new IllegalArgumentException("Cannot append an absolute path");
		}
		var newPath = fullPath.resolve(appendPath).toAbsolutePath().normalize();
		if (!newPath.startsWith(root))
		{
			throw new IllegalArgumentException("Path escaped its root");
		}

		for (var p = newPath; !root.equals(p); p = p.getParent())
		{
			Path name;
			if (p == null || (name = p.getFileName()) == null)
			{
				throw new IllegalArgumentException("bad path");
			}

			checkName(name.toString());
		}

		return new Filepath(root, newPath);
	}

	/**
	 * Append a single segment to this path, throwing if {@code append} is
	 * not a single segment
	 */
	public Filepath joinSegment(String append)
	{
		checkName(append);
		var fp = join(append);

		if (!Objects.equals(fp.fullPath.getParent(), fullPath))
		{
			throw new IllegalArgumentException("invalid segment: " + append);
		}

		return fp;
	}

	/**
	 * Gets the parent directory of this filepath.
	 *
	 * @throws IllegalArgumentException if this filepath {@link #isRoot}
	 *
	 * @see Path#getParent()
	 */
	public Filepath getParent()
	{
		return new Filepath(root, fullPath.getParent());
	}

	/**
	 * @return true if this path can't be used to access it's parent
	 */
	public boolean isRoot()
	{
		return root.equals(fullPath);
	}

	/**
	 * Gets the highest level {@code Filepath} this can access.
	 */
	public Filepath getRoot()
	{
		return new Filepath(root, root);
	}

	/**
	 * Create a new filepath with its root set to this filepath
	 */
	public Filepath rooted()
	{
		return new Filepath(fullPath, fullPath);
	}

	/**
	 * @see Path#getFileName()
	 */
	public String getFileName()
	{
		return fullPath.getFileName().toString();
	}

	/**
	 * @see Path#startsWith(Path)
	 */
	public boolean startsWith(Filepath other)
	{
		return fullPath.startsWith(other.fullPath);
	}

	/**
	 * @see Files#createTempFile
	 */
	public Filepath createTempFile(String prefix, String suffix) throws IOException
	{
		checkName(prefix + "0" + suffix);
		var path = Files.createTempFile(fullPath, prefix, suffix);
		return new Filepath(root, path);
	}

	/**
	 * @see Files#createTempDirectory
	 */
	public Filepath createTempDir(String prefix) throws IOException
	{
		checkName(prefix + "0");
		var path = Files.createTempDirectory(fullPath, prefix);
		return new Filepath(root, path);
	}

	/**
	 * @see Files#walk(Path, FileVisitOption...)
	 *
	 * The resulting Stream must be {@link AutoCloseable#close()}ed or used
	 * in a try-with-resources statement
	 */
	public Stream<Filepath> walk(FileVisitOption... options) throws IOException
	{
		return walk(Integer.MAX_VALUE, options);
	}

	/**
	 * @see Files#walk(Path, int, FileVisitOption...)
	 *
	 * The resulting Stream must be {@link AutoCloseable#close()}ed or used
	 * in a try-with-resources statement
	 */
	public Stream<Filepath> walk(int maxDepth, FileVisitOption... options) throws IOException
	{
		return Files.walk(fullPath, maxDepth, options)
			.map(p -> new Filepath(root, p));
	}

	/**
	 * @see Files#exists(Path, LinkOption...)
	 */
	public boolean exists()
	{
		return Files.exists(fullPath);
	}

	/**
	 * @see Files#isRegularFile(Path, LinkOption...)
	 */
	public boolean isFile()
	{
		return Files.isRegularFile(fullPath);
	}

	/**
	 * @see Files#isDirectory(Path, LinkOption...)
	 */
	public boolean isDirectory()
	{
		return Files.isDirectory(fullPath);
	}

	/**
	 * @see Files#size(Path)
	 */
	public long size() throws IOException
	{
		return Files.size(fullPath);
	}

	/**
	 * @see Files#getLastModifiedTime(Path, LinkOption...)
	 */
	public FileTime getLastModifiedTime() throws IOException
	{
		return Files.getLastModifiedTime(fullPath);
	}

	/**
	 * @see Files#delete(Path)
	 */
	public void delete() throws IOException
	{
		Files.delete(fullPath);
	}

	/**
	 * @see Files#deleteIfExists(Path)
	 */
	public void deleteIfExists() throws IOException
	{
		Files.deleteIfExists(fullPath);
	}

	/**
	 * Deletes this file/directory, and all of the files inside it.
	 */
	public void deleteRecursively() throws IOException
	{
		Files.walkFileTree(fullPath, new SimpleFileVisitor<>()
		{
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException
			{
				Files.delete(file);
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException
			{
				Files.delete(dir);
				return FileVisitResult.CONTINUE;
			}
		});
	}

	/**
	 * @see Files#createDirectory
	 */
	public void createDirectory() throws IOException
	{
		Files.createDirectory(fullPath);
	}

	/**
	 * @see Files#createDirectories
	 */
	public void createDirectories() throws IOException
	{
		Files.createDirectories(fullPath);
	}

	/**
	 * Copies this file to {@code target}
	 *
	 * @see Files#copy(Path, Path, CopyOption...)
	 */
	public void copyTo(Filepath target, CopyOption... options) throws IOException
	{
		Files.copy(fullPath, target.fullPath, options);
	}

	/**
	 * Moves this file to {@code target}
	 *
	 * @see Files#move(Path, Path, CopyOption...)
	 */
	public void moveTo(Filepath target, CopyOption... options) throws IOException
	{
		Files.move(fullPath, target.fullPath, options);
	}

	/**
	 * @see FileChannel#open(Path, OpenOption...)
	 */
	public FileChannel openFileChannel(OpenOption... options) throws IOException
	{
		return FileChannel.open(fullPath, options);
	}

	/**
	 * @see Files#newInputStream(Path, OpenOption...)
	 */
	public InputStream openInputStream(OpenOption... options) throws IOException
	{
		return Files.newInputStream(fullPath, options);
	}

	/**
	 * @see Files#newOutputStream(Path, OpenOption...)
	 */
	public OutputStream openOutputStream(OpenOption... options) throws IOException
	{
		return Files.newOutputStream(fullPath, options);
	}

	/**
	 * Opens a file, returning an unbuffered UTF-8 {@link Reader}
	 */
	public Reader openReader(OpenOption... options) throws IOException
	{
		return new InputStreamReader(openInputStream(options), StandardCharsets.UTF_8);
	}

	/**
	 * Opens a file, returning a buffered UTF-8 {@link Reader}
	 */
	public BufferedReader openBufferedReader(OpenOption... options) throws IOException
	{
		return new BufferedReader(openReader(options));
	}

	/**
	 * Opens or creates a file, returning an unbuffered UTF-8 {@link Writer}
	 */
	public Writer openWriter(OpenOption... options) throws IOException
	{
		return new OutputStreamWriter(openOutputStream(options), StandardCharsets.UTF_8);
	}

	/**
	 * Opens or creates a file, returning an buffered UTF-8 {@link Writer}
	 */
	public BufferedWriter openBufferedWriter(OpenOption... options) throws IOException
	{
		return new BufferedWriter(openWriter(options));
	}

	/**
	 * @see Files#write(Path, byte[], OpenOption...)
	 */
	public void write(byte @NonNull [] bytes, OpenOption... options) throws IOException
	{
		try (var os = openOutputStream(options))
		{
			os.write(bytes);
		}
	}

	/**
	 * Writes {@code string} to this filepath as UTF-8.
	 *
	 * @see Files#write(Path, byte[], OpenOption...)
	 */
	public void write(@NonNull String string, OpenOption... options) throws IOException
	{
		try (var w = openWriter(options))
		{
			w.write(string);
		}
	}

	@Override
	public int compareTo(Filepath o)
	{
		return fullPath.compareTo(o.fullPath);
	}

	@Override
	public String toString()
	{
		return fullPath.toString();
	}

	@Override
	public int hashCode()
	{
		return fullPath.hashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof Filepath)
		{
			return ((Filepath) obj).fullPath.equals(fullPath);
		}

		return false;
	}

	/**
	 * Provides a dialog for users to select a Filepath
	 *
	 * @see JFileChooser
	 */
	public static class Chooser
	{
		private final JFileChooser chooser = new JFileChooser();

		private String defaultExtension;
		private boolean open = false;

		/**
		 * Sets if this dialog is for opening files (the default) instead of saving them.
		 *
		 * @see JFileChooser#setDialogType(int)
		 */
		public synchronized Chooser setIsOpen()
		{
			if (!open)
			{
				chooser.setDialogType(JFileChooser.OPEN_DIALOG);
			}
			return this;
		}

		/**
		 * Sets that this dialog is for saving files instead of opening them.
		 *
		 * @see JFileChooser#setDialogType(int)
		 */
		public synchronized Chooser setIsSave()
		{
			if (!open)
			{
				chooser.setDialogType(JFileChooser.SAVE_DIALOG);
			}
			return this;
		}

		/**
		 * Sets that this dialog is for selecting files instead of directories.
		 *
		 * @see JFileChooser#setFileSelectionMode(int)
		 */
		public synchronized Chooser setAcceptsFiles()
		{
			if (!open)
			{
				chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			}
			return this;
		}

		/**
		 * Sets that this dialog is for selecting directories instead of files.
		 *
		 * @see JFileChooser#setFileSelectionMode(int)
		 */
		public synchronized Chooser setAcceptsDirectories()
		{
			if (!open)
			{
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			}
			return this;
		}

		/**
		 * @see JFileChooser#setDialogTitle(String)
		 */
		public synchronized Chooser setDialogTitle(String title)
		{
			if (!open)
			{
				chooser.setDialogTitle(title);
			}
			return this;
		}

		/**
		 * @see JFileChooser#setCurrentDirectory(File)
		 */
		public synchronized Chooser setCurrentDirectory(Filepath filepath)
		{
			if (!open)
			{
				chooser.setCurrentDirectory(Unchecked.getFile(filepath));
			}
			return this;
		}

		/**
		 * @see JFileChooser#setFileHidingEnabled(boolean)
		 */
		public synchronized Chooser setFileHidingEnabled(boolean useFileHiding)
		{
			if (!open)
			{
				chooser.setFileHidingEnabled(useFileHiding);
			}
			return this;
		}

		/**
		 * @see FileNameExtensionFilter
		 */
		public synchronized Chooser addExtensionFilter(String description, String... extensions)
		{
			if (!open)
			{
				chooser.addChoosableFileFilter(new FileNameExtensionFilter(description, extensions));
			}
			return this;
		}

		/**
		 * Sets the default extension given to files that lack one
		 */
		public synchronized Chooser setDefaultExtension(String defaultExtension)
		{
			if (!open)
			{
				if (defaultExtension != null)
				{
					checkName("." + defaultExtension);
				}
				this.defaultExtension = defaultExtension;
			}
			return this;
		}

		/**
		 * Sets the default name given to the file chooser
		 */
		public synchronized Chooser setFileName(String name)
		{
			if (!open)
			{
				checkName(name);
				chooser.setSelectedFile(new File(chooser.getCurrentDirectory(), name));
			}
			return this;
		}

		/**
		 * @see JFileChooser#setMultiSelectionEnabled(boolean)
		 */
		public synchronized Chooser setMultiSelectionEnabled(boolean multiSelectionEnabled)
		{
			if (!open)
			{
				chooser.setMultiSelectionEnabled(multiSelectionEnabled);
			}
			return this;
		}

		/**
		 * @see #showDialog(Component)
		 */
		@Nullable
		public List<Filepath> showDialog(Client parent)
		{
			return showDialog((Component) parent);
		}

		/**
		 * Shows this dialog on the screen, blocking until the user closes it.
		 *
		 * @return The files the user selected, or {@code null} if they canceled the dialog
		 */
		@Nullable
		public List<Filepath> showDialog(Component parent)
		{
			if (!SwingUtilities.isEventDispatchThread())
			{
				throw new IllegalStateException("must be on the EDT");
			}

			synchronized (this)
			{
				if (open)
				{
					throw new IllegalStateException("Choosers cannot be re-used");
				}

				open = true;
			}

			int result = chooser.showDialog(parent, null);
			if (result != JFileChooser.APPROVE_OPTION)
			{
				return null;
			}

			return getFiles();
		}

		private List<Filepath> getFiles()
		{
			Stream<File> selection;
			if (chooser.isMultiSelectionEnabled())
			{
				selection = Arrays.stream(chooser.getSelectedFiles());
			}
			else
			{
				selection = Stream.of(chooser.getSelectedFile());
			}

			return selection.filter(Objects::nonNull)
				.map(f ->
				{
					var path = f.toPath()
						.toAbsolutePath()
						.normalize();

					if (defaultExtension != null
						&& path.getParent() != null
						&& !path.getFileName().toString().contains("."))
					{
						var parent = path.getParent();
						path = parent.resolve(path.getFileName() + "." + defaultExtension);
						if (!parent.equals(path.getParent()))
						{
							throw new IllegalStateException("Invalid defaultExtension");
						}
					}

					return Unchecked.getRooted(path);
				})
				.collect(Collectors.toList());
		}
	}

	static void checkName(String name)
	{
		var badChars = BAD_CHARS.retainFrom(name);
		if (!badChars.isEmpty())
		{
			throw new IllegalArgumentException("name has disallowed characters " + badChars);
		}

		if (name.endsWith(" ") || name.endsWith("."))
		{
			// windows will strip these characters at the end of a path
			throw new IllegalArgumentException("name cannot end with . or space");
		}

		var normName = name.toLowerCase(Locale.ROOT);
		var extIdx = normName.indexOf('.');
		if (extIdx != -1)
		{
			normName = normName.substring(0, extIdx);
		}

		if (DOS_DEVICES.contains(normName.trim()))
		{
			throw new IllegalArgumentException("name cannot be a Windows reserved name");
		}
	}

	/**
	 * Interacting with these methods prevent PluginHub plugins from
	 * being automatically reviewed
	 */
	public static class Unchecked
	{
		@VisibleForTesting
		static final Set<String> DOT_RUNELITE_DIRS = ImmutableSet.of(
			"",
			"cache",
			"credentials.properties",
			"cursor.png",
			"fonts",
			"icon.png",
			"jagexcache",
			"launcher",
			"login.png",
			"logs",
			"notification.wav",
			"notifications",
			"plugin-data",
			"plugins",
			"profiles",
			"profiles2",
			"random.dat",
			"repository",
			"repository2",
			"screenshots",
			"session",
			"settings.properties",
			"sideloaded-plugins"
		);

		public static Filepath getLegacyPluginDirectory(Path dotRuneLite, String dirName)
		{
			var path = getRooted(dotRuneLite)
				.joinSegment(dirName)
				.rooted();

			if (DOT_RUNELITE_DIRS.contains(path.getFileName().toLowerCase(Locale.ROOT)))
			{
				throw new IllegalArgumentException("Legacy plugin directory cannot be " + dirName);
			}

			return path;
		}

		public static Filepath getRooted(Path path)
		{
			return new Filepath(path, path);
		}

		public static Path getPath(Filepath fp)
		{
			return fp.fullPath;
		}

		public static File getFile(Filepath fp)
		{
			return fp.fullPath.toFile();
		}
	}
}
