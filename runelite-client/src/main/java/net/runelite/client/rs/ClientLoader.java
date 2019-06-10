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

import net.runelite.api.Client;
import java.applet.Applet;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.jar.Manifest;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import static net.runelite.client.RuneLite.RUNELITE_DIR;
import static net.runelite.client.rs.ClientUpdateCheckMode.CUSTOM;
import net.runelite.http.api.RuneLiteAPI;
import okhttp3.Request;
import okhttp3.Response;

@Slf4j
@Singleton
public class ClientLoader
{
	private static final File CUSTOMFILE = new File("./injected-client/target/injected-client-1.0-SNAPSHOT.jar");
	private final ClientConfigLoader clientConfigLoader;
	private ClientUpdateCheckMode updateCheckMode;
	public static boolean useLocalInjected = false;

	@Inject
	private ClientLoader(
			@Named("updateCheckMode") final ClientUpdateCheckMode updateCheckMode,
			final ClientConfigLoader clientConfigLoader)
	{
		this.updateCheckMode = updateCheckMode;
		this.clientConfigLoader = clientConfigLoader;
	}

	public Applet load()
	{
		try
		{
			Manifest manifest = new Manifest();
			manifest.getMainAttributes().put(Attributes.Name.MANIFEST_VERSION, "1.0");
			RSConfig config = clientConfigLoader.fetch();

			Map<String, byte[]> zipFile = new HashMap<>();
			{
				Certificate[] jagexCertificateChain = getJagexCertificateChain();
				String codebase = config.getCodeBase();
				String initialJar = config.getInitialJar();
				URL url = new URL(codebase + initialJar);
				Request request = new Request.Builder()
						.url(url)
						.build();

				try (Response response = RuneLiteAPI.CLIENT.newCall(request).execute())
				{
					JarInputStream jis;

					jis = new JarInputStream(response.body().byteStream());
					byte[] tmp = new byte[4096];
					ByteArrayOutputStream buffer = new ByteArrayOutputStream(756 * 1024);
					for (; ; )
					{
						JarEntry metadata = jis.getNextJarEntry();
						if (metadata == null)
						{
							break;
						}

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
				}
			}
			URL url = new URL("https://raw.githubusercontent.com/runelite-extended/maven-repo/master/live/injected-client.jar");
			ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream());
			File LOCAL_INJECTED_CLIENT = new File("./injected-client/target/injected-client-" + RuneLiteAPI.getVersion() + ".jar");
			File INJECTED_CLIENT = new File(RUNELITE_DIR + "/injected-client.jar");
			INJECTED_CLIENT.mkdirs();
			if (INJECTED_CLIENT.exists())
			{
				if (getFileSize(INJECTED_CLIENT.toURI().toURL()) != getFileSize(url))
				{
					INJECTED_CLIENT.delete();
					INJECTED_CLIENT.createNewFile();
					System.out.println("Updating Injected Client");
					updateInjectedClient(readableByteChannel);
				}
			}
			else
			{
				INJECTED_CLIENT.createNewFile();
				System.out.println("Initializing Inject Client");
				updateInjectedClient(readableByteChannel);
			}

			JarInputStream fis;

			if (updateCheckMode == CUSTOM)
			{
				System.out.println("Using local injected client");
				fis = new JarInputStream(new FileInputStream(LOCAL_INJECTED_CLIENT));
			}
			else
			{
				System.out.println("Using live injected client");
				fis = new JarInputStream(new FileInputStream(INJECTED_CLIENT));
			}


			byte[] tmp = new byte[4096];
			ByteArrayOutputStream buffer = new ByteArrayOutputStream(756 * 1024);
			for (; ; )
			{
				JarEntry metadata = fis.getNextJarEntry();
				if (metadata == null)
				{
					break;
				}

				buffer.reset();
				for (; ; )
				{
					int n = fis.read(tmp);
					if (n <= -1)
					{
						break;
					}
					buffer.write(tmp, 0, n);
				}
				zipFile.replace(metadata.getName(), buffer.toByteArray());
			}

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
				log.info("client-patch 420 blaze it RL pricks");
			}

			return rs;
		}
		catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException | SecurityException | VerificationException | CertificateException e)
		{
			if (e instanceof ClassNotFoundException)
			{
				log.error("Unable to load client - class not found. This means you"
						+ " are not running RuneLite with Maven as the client patch"
						+ " is not in your classpath.");
			}

			log.error("Error loading RS!", e);
			return null;
		}
	}

	private static int getFileSize(URL url)
	{
		URLConnection conn = null;
		try
		{
			conn = url.openConnection();
			if (conn instanceof HttpURLConnection)
			{
				((HttpURLConnection) conn).setRequestMethod("HEAD");
			}
			conn.getInputStream();
			return conn.getContentLength();
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
		finally
		{
			if (conn instanceof HttpURLConnection)
			{
				((HttpURLConnection) conn).disconnect();
			}
		}
	}

	private void updateInjectedClient(ReadableByteChannel readableByteChannel)
	{
		File INJECTED_CLIENT = new File(RUNELITE_DIR,  "injected-client.jar");
		try
		{
			FileOutputStream fileOutputStream = new FileOutputStream(INJECTED_CLIENT);
			fileOutputStream.getChannel()
					.transferFrom(readableByteChannel, 0, Integer.MAX_VALUE);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private static Certificate[] getJagexCertificateChain() throws CertificateException
	{
		CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
		Collection<? extends Certificate> certificates = certificateFactory.generateCertificates(ClientLoader.class.getResourceAsStream("jagex.crt"));
		return certificates.toArray(new Certificate[0]);
	}
}
