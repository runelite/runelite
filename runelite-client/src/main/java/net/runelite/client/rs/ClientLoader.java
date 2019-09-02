/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
 * Copyright (c) 2018 Abex
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

import com.google.common.base.Strings;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import com.google.common.io.ByteStreams;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import io.sigpipe.jbsdiff.InvalidHeaderException;
import io.sigpipe.jbsdiff.Patch;
import java.applet.Applet;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import javax.swing.SwingUtilities;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.RuneLite;
import static net.runelite.client.rs.ClientUpdateCheckMode.AUTO;
import static net.runelite.client.rs.ClientUpdateCheckMode.CACHE;
import static net.runelite.client.rs.ClientUpdateCheckMode.NONE;
import static net.runelite.client.rs.ClientUpdateCheckMode.VANILLA;
import net.runelite.client.ui.FatalErrorDialog;
import net.runelite.client.ui.SplashScreen;
import net.runelite.http.api.RuneLiteAPI;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.compress.compressors.CompressorException;

@Slf4j
public class ClientLoader implements Supplier<Applet>
{
	private static final int NUM_ATTEMPTS = 6;

	private ClientUpdateCheckMode updateCheckMode;
	private Object client = null;

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
		if (updateCheckMode == NONE || updateCheckMode == null)
		{
			return null;
		}

		try
		{
			SplashScreen.stage(0, null, "Fetching applet viewer config");

			BufferSizeLimitInterceptor sockets = new BufferSizeLimitInterceptor();
			OkHttpClient httpClient = RuneLiteAPI.CLIENT.newBuilder()
				.addNetworkInterceptor(sockets)
				.build();

			HostSupplier hostSupplier = new HostSupplier();

			// Try to download the jav_config from oldschool.runescape.com
			// or, failing that, try some random game servers in an attempt to work around
			// spotty internet connections
			String host = null;
			RSConfig config;
			for (int attempt = 0; ; attempt++)
			{
				try
				{
					config = ClientConfigLoader.fetch(httpClient, host);

					if (Strings.isNullOrEmpty(config.getCodeBase()) || Strings.isNullOrEmpty(config.getInitialJar()) || Strings.isNullOrEmpty(config.getInitialClass()))
					{
						throw new IOException("Invalid or missing jav_config");
					}

					break;
				}
				catch (IOException e)
				{
					log.info("Failed to get jav_config from host \"{}\" ({})", host, e.getMessage());

					if (attempt >= NUM_ATTEMPTS)
					{
						throw e;
					}

					host = hostSupplier.get();
				}
			}

			if (updateCheckMode == CACHE)
			{
				updateCheckMode = AUTO;
			}

			// Get the target hashes for the cache

			File cache = new File(RuneLite.RUNELITE_DIR, "client-cache");

			byte[] serial = new byte[64];
			if (updateCheckMode == AUTO)
			{
				ClientLoader.class.getResourceAsStream("/patch/serial").read(serial);
			}

			byte[] clientLoaderSerial = Hashing.sha512()
				.hashBytes(ByteStreams.toByteArray(ClientLoader.class.getResourceAsStream("ClientLoader.class")))
				.asBytes();

			long modTime = 0;

			Map<String, byte[]> zipFile = new LinkedHashMap<>();

			DataInputStream cacheStream = null;
			getVanilla:
			try
			{
				long wantedModTime = -1;

				serialCheck:
				if (updateCheckMode == AUTO && cache.exists())
				{
					try
					{
						cacheStream = new DataInputStream(new FileInputStream(cache));

						byte[] wantedSerial = new byte[64];
						cacheStream.read(wantedSerial);

						if (!Arrays.equals(serial, wantedSerial))
						{
							log.info("Serial does not match {} != {}", HashCode.fromBytes(serial), HashCode.fromBytes(wantedSerial));
							break serialCheck;
						}

						byte[] wantedClientLoaderSerial = new byte[64];
						cacheStream.read(wantedClientLoaderSerial);

						if (!Arrays.equals(clientLoaderSerial, wantedClientLoaderSerial))
						{
							log.info("ClientLoader serial does not match {} != {}",
								HashCode.fromBytes(clientLoaderSerial), HashCode.fromBytes(wantedClientLoaderSerial));
							break serialCheck;
						}

						wantedModTime = cacheStream.readLong();

						// at this point we know the cache header matches the client-patch and ClientLoader
						// so if the mtime matches, we can use the cache

						// There is no use setting this <8k because okhttp downloads 8k segments
						sockets.setRecvBufferSize(8 * 1024);
					}
					catch (IOException e)
					{
						log.warn("Unable to load cache", e);
					}
				}

				// start downloading the vanilla client
				// If we have a possibly valid cache (wantedModTime != -1) we check the mtime for the first
				// file. If it matches what was in the cache header we try to load and verify the cache. If
				// loading the cache succeeds we close the connection and skip to classloading by setting the
				// mode to CACHE

				Certificate[] jagexCertificateChain = getJagexCertificateChain();
				String codebase = config.getCodeBase();
				String initialJar = config.getInitialJar();
				HttpUrl url = HttpUrl.parse(codebase + initialJar);

				for (int attempt = 0; ; attempt++)
				{
					// Clear any files from a failed download
					zipFile.clear();

					Request request = new Request.Builder()
						.url(url)
						.build();

					try (Response response = httpClient.newCall(request).execute())
					{
						int length = (int) response.body().contentLength();
						if (length < 0)
						{
							length = 3 * 1024 * 1024;
						}
						final int flength = length;
						InputStream istream = new FilterInputStream(response.body().byteStream())
						{
							private int read = 0;

							@Override
							public int read(byte[] b, int off, int len) throws IOException
							{
								int thisRead = super.read(b, off, len);
								this.read += thisRead;
								SplashScreen.stage(.05, .35, null, "Downloading Old School RuneScape", this.read, flength, true);
								return thisRead;
							}
						};
						JarInputStream jis = new JarInputStream(istream);

						byte[] tmp = new byte[4096];
						ByteArrayOutputStream buffer = new ByteArrayOutputStream(756 * 1024);
						for (; ; )
						{
							JarEntry metadata = jis.getNextJarEntry();
							if (metadata == null)
							{
								break;
							}

							// record the first file's modtime for cache verification and creation
							if (modTime == 0)
							{
								modTime = metadata.getTime();
							}

							if (wantedModTime != -1)
							{
								long wasWantedModTime = wantedModTime;

								// don't try this again if it fails
								wantedModTime = -1;

								if (modTime == wasWantedModTime)
								{
									try
									{
										// the mtime matches, so open the rest of the cache and load the classes into memory
										// as we load we shasum the whole thing and match it against the value in the client-patch
										// so we can't load arbitrary code
										Hasher serialHasher = Hashing.sha512().newHasher();

										ZipInputStream cis = new ZipInputStream(cacheStream);
										for (; ; )
										{
											ZipEntry cacheMetadata = cis.getNextEntry();
											if (cacheMetadata == null)
											{
												break;
											}

											buffer.reset();
											for (; ; )
											{
												int n = cis.read(tmp);
												if (n <= -1)
												{
													break;
												}
												buffer.write(tmp, 0, n);
											}

											byte[] patchedClass = buffer.toByteArray();

											serialHasher.putBytes(patchedClass);
											zipFile.put(cacheMetadata.getName(), patchedClass);
										}

										HashCode readSerial = serialHasher.hash();
										if (Arrays.equals(serial, readSerial.asBytes()))
										{
											updateCheckMode = CACHE;
											log.info("Using cached patched client");
											break getVanilla;
										}
										log.warn("Cached client serial does not match it's header {} != {}", readSerial, HashCode.fromBytes(serial));
									}
									catch (Exception e)
									{
										log.warn("Unable to load cache", e);
									}
									finally
									{
										if (updateCheckMode != CACHE)
										{
											zipFile.clear();
										}
									}
								}
								else
								{
									log.warn("MTime does not match {} != {}", modTime, wasWantedModTime);
								}
							}

							// try to reup the recvbuf size to download faster
							sockets.setRecvBufferSize(64 * 1024);

							buffer.reset();
							for (; ; )
							{
								int n = jis.read(tmp);
								if (n <= -1)
								{
									break;
								}
								buffer.write(tmp, 0, n);
							}

							// verify the classes against the pinned Jagex cert
							if (!Arrays.equals(metadata.getCertificates(), jagexCertificateChain))
							{
								if (metadata.getName().startsWith("META-INF/"))
								{
									// META-INF/JAGEXLTD.SF and META-INF/JAGEXLTD.RSA are not signed, but we don't need
									// anything in META-INF anyway.
									continue;
								}
								else
								{
									throw new VerificationException("Unable to verify jar entry: " + metadata.getName());
								}
							}

							zipFile.put(metadata.getName(), buffer.toByteArray());
						}
						break;
					}
					catch (IOException e)
					{
						log.info("Failed to download gamepack from \"{}\" ({})", url, e.getMessage());

						if (attempt >= NUM_ATTEMPTS)
						{
							throw e;
						}

						url = url.newBuilder().host(hostSupplier.get()).build();
					}
				}
			}
			finally
			{
				if (cacheStream != null)
				{
					cacheStream.close();
				}
			}

			if (updateCheckMode == AUTO)
			{
				SplashScreen.stage(.35, null, "Patching");

				// the injector bakes in the sha512 of each vanilla class, so we can make sure the patch
				// will apply correctly before starting. If the patch won't apply we drop into vanilla mode

				Map<String, String> hashes;
				try (InputStream is = ClientLoader.class.getResourceAsStream("/patch/hashes.json"))
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
					hashes = new Gson().fromJson(new InputStreamReader(is), new TypeToken<HashMap<String, String>>()
					{
					}.getType());
				}

				for (Map.Entry<String, String> file : hashes.entrySet())
				{
					byte[] bytes = zipFile.get(file.getKey());

					String ourHash = null;
					if (bytes != null)
					{
						ourHash = Hashing.sha512().hashBytes(bytes).toString();
					}

					if (!file.getValue().equals(ourHash))
					{
						log.debug("{} had a hash mismatch; falling back to vanilla. {} != {}", file.getKey(), file.getValue(), ourHash);
						log.info("Client is outdated!");
						updateCheckMode = VANILLA;
						break;
					}
				}
			}

			if (updateCheckMode == AUTO)
			{
				// We know the patch will apply now, so actually do it. While applying we also reopen the cache file.
				// We zero the cache header so if the client crashes now it won't even try to load a partial cache.
				// The rest of the cache is just a zip file, so write each file to it in the same order as vanilla

				ByteArrayOutputStream patchOs = new ByteArrayOutputStream(756 * 1024);
				int patchCount = 0;

				try (RandomAccessFile cacheWriter = new RandomAccessFile(cache, "rw"))
				{
					cacheWriter.write(new byte[64 + 64 + 8]);
					ZipOutputStream jos = new ZipOutputStream(new FileOutputStream(cacheWriter.getFD()));

					for (Map.Entry<String, byte[]> file : zipFile.entrySet())
					{
						byte[] bytes;
						try (InputStream is = ClientLoader.class.getResourceAsStream("/patch/" + file.getKey() + ".bs"))
						{
							if (is == null)
							{
								continue;
							}

							bytes = ByteStreams.toByteArray(is);
						}

						patchOs.reset();
						Patch.patch(file.getValue(), bytes, patchOs);
						file.setValue(patchOs.toByteArray());

						jos.putNextEntry(new ZipEntry(file.getKey()));
						patchOs.writeTo(jos);

						++patchCount;
						SplashScreen.stage(.38, .45, null, "Patching", patchCount, zipFile.size(), false);
					}

					jos.finish();

					// we have successfully patched the whole client, so write the header on to finalize the cache

					cacheWriter.seek(0);
					cacheWriter.write(serial);
					cacheWriter.write(clientLoaderSerial);
					cacheWriter.writeLong(modTime);
				}

				log.debug("Patched {} classes", patchCount);
			}

			SplashScreen.stage(.465, "Starting", "Starting Old School RuneScape");

			String initialClass = config.getInitialClass();

			ClassLoader rsClassLoader = new ClassLoader(ClientLoader.class.getClassLoader())
			{
				@Override
				protected Class<?> findClass(String name) throws ClassNotFoundException
				{
					String path = name.replace('.', '/').concat(".class");
					byte[] data = zipFile.get(path);
					if (data == null)
					{
						throw new ClassNotFoundException(name);
					}

					return defineClass(name, data, 0, data.length);
				}
			};

			Class<?> clientClass = rsClassLoader.loadClass(initialClass);

			Applet rs = (Applet) clientClass.newInstance();
			rs.setStub(new RSAppletStub(config));

			if (rs instanceof Client)
			{
				log.info("client-patch {}", ((Client) rs).getBuildID());
			}

			SplashScreen.stage(.5, null, "Starting core classes");

			return rs;
		}
		catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException
			| CompressorException | InvalidHeaderException | CertificateException | VerificationException
			| SecurityException e)
		{
			log.error("Error loading RS!", e);

			SwingUtilities.invokeLater(() -> FatalErrorDialog.showNetErrorWindow("loading the client", e));
			return e;
		}
	}

	private static Certificate[] getJagexCertificateChain() throws CertificateException
	{
		CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
		Collection<? extends Certificate> certificates = certificateFactory.generateCertificates(ClientLoader.class.getResourceAsStream("jagex.crt"));
		return certificates.toArray(new Certificate[certificates.size()]);
	}
}
