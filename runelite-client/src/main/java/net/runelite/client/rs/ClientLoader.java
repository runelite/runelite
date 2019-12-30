/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
 * Copyright (c) 2019 Abex
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
package net.runelite.client.rs;

import com.google.archivepatcher.applier.FileByFileV1DeltaApplier;
import com.google.common.base.Strings;
import com.google.common.hash.Hashing;
import com.google.common.hash.HashingOutputStream;
import com.google.common.io.ByteStreams;
import com.google.common.io.Files;
import java.applet.Applet;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.StandardOpenOption;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Enumeration;
import java.util.function.Supplier;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarInputStream;
import javax.swing.SwingUtilities;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.RuneLite;
import net.runelite.client.RuneLiteProperties;
import static net.runelite.client.rs.ClientUpdateCheckMode.AUTO;
import static net.runelite.client.rs.ClientUpdateCheckMode.NONE;
import static net.runelite.client.rs.ClientUpdateCheckMode.VANILLA;
import net.runelite.client.ui.FatalErrorDialog;
import net.runelite.client.ui.SplashScreen;
import net.runelite.client.util.CountingInputStream;
import net.runelite.http.api.RuneLiteAPI;
import net.runelite.http.api.worlds.World;
import net.runelite.client.util.VerificationException;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

@Slf4j
@SuppressWarnings("deprecation")
public class ClientLoader implements Supplier<Applet>
{
	private static final int NUM_ATTEMPTS = 6;
	private static File LOCK_FILE = new File(RuneLite.CACHE_DIR, "cache.lock");
	private static File VANILLA_CACHE = new File(RuneLite.CACHE_DIR, "vanilla.cache");
	private static File PATCHED_CACHE = new File(RuneLite.CACHE_DIR, "patched.cache");

	private ClientUpdateCheckMode updateCheckMode;
	private Object client = null;

	private WorldSupplier worldSupplier = new WorldSupplier();
	private RSConfig config;

	public ClientLoader(ClientUpdateCheckMode updateCheckMode)
	{
		this.updateCheckMode = updateCheckMode;
	}

	@Override
	public synchronized Applet get()
	{
		if (client == null)
		{
			client = doLoad();
		}

		if (client instanceof Throwable)
		{
			throw new RuntimeException((Throwable) client);
		}
		return (Applet) client;
	}

	private Object doLoad()
	{
		if (updateCheckMode == NONE)
		{
			return null;
		}

		try
		{
			SplashScreen.stage(0, null, "Fetching applet viewer config");
			downloadConfig();

			SplashScreen.stage(.05, null, "Waiting for other clients to start");

			LOCK_FILE.getParentFile().mkdirs();
			ClassLoader classLoader;
			try (FileChannel lockfile = FileChannel.open(LOCK_FILE.toPath(),
				StandardOpenOption.CREATE, StandardOpenOption.READ, StandardOpenOption.WRITE);
				FileLock flock = lockfile.lock())
			{
				SplashScreen.stage(.05, null, "Downloading Old School RuneScape");
				updateVanilla();

				if (updateCheckMode == AUTO)
				{
					SplashScreen.stage(.35, null, "Patching");
					applyPatch();
				}

				SplashScreen.stage(.40, null, "Loading client");
				File jarFile = updateCheckMode == AUTO ? PATCHED_CACHE : VANILLA_CACHE;
				// create the classloader for the jar while we hold the lock, and eagerly load and link all classes
				// in the jar. Otherwise the jar can change on disk and can break future classloads.
				classLoader = createJarClassLoader(jarFile);
			}

			SplashScreen.stage(.465, "Starting", "Starting Old School RuneScape");

			Applet rs = loadClient(classLoader);

			SplashScreen.stage(.5, null, "Starting core classes");

			return rs;
		}
		catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException
			| VerificationException | SecurityException e)
		{
			log.error("Error loading RS!", e);

			SwingUtilities.invokeLater(() -> FatalErrorDialog.showNetErrorWindow("loading the client", e));
			return e;
		}
	}

	private void downloadConfig() throws IOException
	{
		HttpUrl url = HttpUrl.parse(RuneLiteProperties.getJavConfig());
		IOException err = null;
		for (int attempt = 0; attempt < NUM_ATTEMPTS; attempt++)
		{
			try
			{
				config = ClientConfigLoader.fetch(url);

				if (Strings.isNullOrEmpty(config.getCodeBase()) || Strings.isNullOrEmpty(config.getInitialJar()) || Strings.isNullOrEmpty(config.getInitialClass()))
				{
					throw new IOException("Invalid or missing jav_config");
				}

				return;
			}
			catch (IOException e)
			{
				log.info("Failed to get jav_config from host \"{}\" ({})", url.host(), e.getMessage());
				String host = worldSupplier.get().getAddress();
				url = url.newBuilder().host(host).build();
				err = e;
			}
		}

		log.info("Falling back to backup client config");

		try
		{
			RSConfig backupConfig = ClientConfigLoader.fetch(HttpUrl.parse(RuneLiteProperties.getJavConfigBackup()));

			if (Strings.isNullOrEmpty(backupConfig.getCodeBase()) || Strings.isNullOrEmpty(backupConfig.getInitialJar()) || Strings.isNullOrEmpty(backupConfig.getInitialClass()))
			{
				throw new IOException("Invalid or missing jav_config");
			}

			if (Strings.isNullOrEmpty(backupConfig.getRuneLiteGamepack()) || Strings.isNullOrEmpty(backupConfig.getRuneLiteWorldParam()))
			{
				throw new IOException("Backup config does not have RuneLite gamepack url");
			}

			// Randomize the codebase
			World world = worldSupplier.get();
			backupConfig.setCodebase("http://" + world.getAddress() + "/");

			// Update the world applet parameter
			Map<String, String> appletProperties = backupConfig.getAppletProperties();
			appletProperties.put(backupConfig.getRuneLiteWorldParam(), Integer.toString(world.getId()));

			config = backupConfig;
		}
		catch (IOException ex)
		{
			throw err; // use error from Jagex's servers
		}
	}

	private void updateVanilla() throws IOException, VerificationException
	{
		Certificate[] jagexCertificateChain = getJagexCertificateChain();

		// Get the mtime of the first thing in the vanilla cache
		// we check this against what the server gives us to let us skip downloading and patching the whole thing

		try (FileChannel vanilla = FileChannel.open(VANILLA_CACHE.toPath(),
			StandardOpenOption.CREATE, StandardOpenOption.READ, StandardOpenOption.WRITE))
		{
			long vanillaCacheMTime = -1;
			boolean vanillaCacheIsInvalid = false;
			try
			{
				JarInputStream vanillaCacheTest = new JarInputStream(Channels.newInputStream(vanilla));
				vanillaCacheTest.skip(Long.MAX_VALUE);
				JarEntry je = vanillaCacheTest.getNextJarEntry();
				if (je != null)
				{
					verifyJarEntry(je, jagexCertificateChain);
					vanillaCacheMTime = je.getLastModifiedTime().toMillis();
				}
				else
				{
					vanillaCacheIsInvalid = true;
				}
			}
			catch (Exception e)
			{
				log.info("Failed to read the vanilla cache: {}", e.toString());
				vanillaCacheIsInvalid = true;
			}
			vanilla.position(0);

			// Start downloading the vanilla client
			HttpUrl url;
			if (config.getRuneLiteGamepack() != null)
			{
				// If we are using the backup config, use our own gamepack and ignore the codebase
				url = HttpUrl.parse(config.getRuneLiteGamepack());
			}
			else
			{
				String codebase = config.getCodeBase();
				String initialJar = config.getInitialJar();
				url = HttpUrl.parse(codebase + initialJar);
			}

			for (int attempt = 0; ; attempt++)
			{
				Request request = new Request.Builder()
					.url(url)
					.build();

				try (Response response = RuneLiteAPI.CLIENT.newCall(request).execute())
				{
					// Its important to not close the response manually - this should be the only close or
					// try-with-resources on this stream or it's children

					if (!response.isSuccessful())
					{
						throw new IOException("unsuccessful response fetching gamepack: " + response.message());
					}

					int length = (int) response.body().contentLength();
					if (length < 0)
					{
						length = 3 * 1024 * 1024;
					}
					else
					{
						if (!vanillaCacheIsInvalid && vanilla.size() != length)
						{
							// The zip trailer filetab can be missing and the ZipInputStream will not notice
							log.info("Vanilla cache is the wrong size");
							vanillaCacheIsInvalid = true;
						}
					}
					final int flength = length;
					TeeInputStream copyStream = new TeeInputStream(new CountingInputStream(response.body().byteStream(),
						read -> SplashScreen.stage(.05, .35, null, "Downloading Old School RuneScape", read, flength, true)));

					// Save the bytes from the mtime test so we can write it to disk
					// if the test fails, or the cache doesn't verify
					ByteArrayOutputStream preRead = new ByteArrayOutputStream();
					copyStream.setOut(preRead);

					JarInputStream networkJIS = new JarInputStream(copyStream);

					// Get the mtime from the first entry so check it against the cache
					{
						JarEntry je = networkJIS.getNextJarEntry();
						if (je == null)
						{
							throw new IOException("unable to peek first jar entry");
						}

						networkJIS.skip(Long.MAX_VALUE);
						verifyJarEntry(je, jagexCertificateChain);
						long vanillaClientMTime = je.getLastModifiedTime().toMillis();
						if (!vanillaCacheIsInvalid && vanillaClientMTime != vanillaCacheMTime)
						{
							log.info("Vanilla cache is out of date: {} != {}", vanillaClientMTime, vanillaCacheMTime);
							vanillaCacheIsInvalid = true;
						}
					}

					// the mtime matches so the cache is probably up to date, but just make sure its fully
					// intact before closing the server connection
					if (!vanillaCacheIsInvalid)
					{
						try
						{
							// as with the request stream, its important to not early close vanilla too
							JarInputStream vanillaCacheTest = new JarInputStream(Channels.newInputStream(vanilla));
							verifyWholeJar(vanillaCacheTest, jagexCertificateChain);
						}
						catch (Exception e)
						{
							log.warn("Failed to verify the vanilla cache", e);
							vanillaCacheIsInvalid = true;
						}
					}

					if (vanillaCacheIsInvalid)
					{
						// the cache is not up to date, commit our peek to the file and write the rest of it, while verifying
						vanilla.position(0);
						OutputStream out = Channels.newOutputStream(vanilla);
						out.write(preRead.toByteArray());
						copyStream.setOut(out);
						verifyWholeJar(networkJIS, jagexCertificateChain);
						copyStream.skip(Long.MAX_VALUE); // write the trailer to the file too
						out.flush();
						vanilla.truncate(vanilla.position());
					}
					else
					{
						log.info("Using cached vanilla client");
					}
					return;
				}
				catch (IOException e)
				{
					log.warn("Failed to download gamepack from \"{}\"", url, e);

					if (attempt >= NUM_ATTEMPTS)
					{
						throw e;
					}

					url = url.newBuilder().host(worldSupplier.get().getAddress()).build();
				}
			}
		}
	}

	private void applyPatch() throws IOException
	{
		byte[] vanillaHash = new byte[64];
		byte[] appliedPatchHash = new byte[64];

		try (InputStream is = ClientLoader.class.getResourceAsStream("/client.serial"))
		{
			if (is == null)
			{
				SwingUtilities.invokeLater(() ->
					new FatalErrorDialog("The client-patch is missing from the classpath. If you are building " +
						"the client you need to re-run maven")
						.addBuildingGuide()
						.open());
				throw new NullPointerException();
			}

			DataInputStream dis = new DataInputStream(is);
			dis.readFully(vanillaHash);
			dis.readFully(appliedPatchHash);
		}

		byte[] vanillaCacheHash = Files.asByteSource(VANILLA_CACHE).hash(Hashing.sha512()).asBytes();
		if (!Arrays.equals(vanillaHash, vanillaCacheHash))
		{
			log.info("Client is outdated!");
			updateCheckMode = VANILLA;
			return;
		}

		if (PATCHED_CACHE.exists())
		{
			byte[] diskBytes = Files.asByteSource(PATCHED_CACHE).hash(Hashing.sha512()).asBytes();
			if (!Arrays.equals(diskBytes, appliedPatchHash))
			{
				log.warn("Cached patch hash mismatches, regenerating patch");
			}
			else
			{
				log.info("Using cached patched client");
				return;
			}
		}

		try (HashingOutputStream hos = new HashingOutputStream(Hashing.sha512(), new FileOutputStream(PATCHED_CACHE));
			InputStream patch = ClientLoader.class.getResourceAsStream("/client.patch"))
		{
			new FileByFileV1DeltaApplier().applyDelta(VANILLA_CACHE, patch, hos);

			if (!Arrays.equals(hos.hash().asBytes(), appliedPatchHash))
			{
				log.error("Patched client hash mismatch");
				updateCheckMode = VANILLA;
				return;
			}
		}
		catch (IOException e)
		{
			log.error("Unable to apply patch despite hash matching", e);
			updateCheckMode = VANILLA;
			return;
		}
	}

	private ClassLoader createJarClassLoader(File jar) throws IOException, ClassNotFoundException
	{
		try (JarFile jarFile = new JarFile(jar))
		{
			ClassLoader classLoader = new ClassLoader(ClientLoader.class.getClassLoader())
			{
				@Override
				protected Class<?> findClass(String name) throws ClassNotFoundException
				{
					String entryName = name.replace('.', '/').concat(".class");
					JarEntry jarEntry = jarFile.getJarEntry(entryName);
					if (jarEntry == null)
					{
						throw new ClassNotFoundException(name);
					}

					try
					{
						InputStream inputStream = jarFile.getInputStream(jarEntry);
						if (inputStream == null)
						{
							throw new ClassNotFoundException(name);
						}

						byte[] bytes = ByteStreams.toByteArray(inputStream);
						return defineClass(name, bytes, 0, bytes.length);
					}
					catch (IOException e)
					{
						throw new ClassNotFoundException(null, e);
					}
				}
			};

			// load all of the classes in this jar; after the jar is closed the classloader
			// will no longer be able to look up classes
			Enumeration<JarEntry> entries = jarFile.entries();
			while (entries.hasMoreElements())
			{
				JarEntry jarEntry = entries.nextElement();
				String name = jarEntry.getName();
				if (name.endsWith(".class"))
				{
					name = name.substring(0, name.length() - 6);
					classLoader.loadClass(name);
				}
			}

			return classLoader;
		}
	}

	private Applet loadClient(ClassLoader classLoader) throws ClassNotFoundException, IllegalAccessException, InstantiationException
	{
		String initialClass = config.getInitialClass();
		Class<?> clientClass = classLoader.loadClass(initialClass);

		Applet rs = (Applet) clientClass.newInstance();
		rs.setStub(new RSAppletStub(config));

		if (rs instanceof Client)
		{
			log.info("client-patch {}", ((Client) rs).getBuildID());
		}

		return rs;
	}

	private static Certificate[] getJagexCertificateChain()
	{
		try
		{
			CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
			Collection<? extends Certificate> certificates = certificateFactory.generateCertificates(ClientLoader.class.getResourceAsStream("jagex.crt"));
			return certificates.toArray(new Certificate[0]);
		}
		catch (CertificateException e)
		{
			throw new RuntimeException("Unable to parse pinned certificates", e);
		}
	}

	private void verifyJarEntry(JarEntry je, Certificate[] certs) throws VerificationException
	{
		switch (je.getName())
		{
			case "META-INF/JAGEXLTD.SF":
			case "META-INF/JAGEXLTD.RSA":
				// You can't sign the signing files
				return;
			default:
				if (!Arrays.equals(je.getCertificates(), certs))
				{
					throw new VerificationException("Unable to verify jar entry: " + je.getName());
				}
		}
	}

	private void verifyWholeJar(JarInputStream jis, Certificate[] certs) throws IOException, VerificationException
	{
		for (JarEntry je; (je = jis.getNextJarEntry()) != null; )
		{
			jis.skip(Long.MAX_VALUE);
			verifyJarEntry(je, certs);
		}
	}
}
