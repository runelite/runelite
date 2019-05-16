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

import com.google.common.hash.Hashing;
import com.google.common.io.ByteStreams;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import io.sigpipe.jbsdiff.InvalidHeaderException;
import io.sigpipe.jbsdiff.Patch;
import java.applet.Applet;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import java.util.logging.Logger;
import javassist.ClassPool;
import javassist.NotFoundException;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.RuneLite;
import static net.runelite.client.rs.ClientUpdateCheckMode.AUTO;
import static net.runelite.client.rs.ClientUpdateCheckMode.NONE;
import static net.runelite.client.rs.ClientUpdateCheckMode.VANILLA;
import net.runelite.client.rs.bytecode.ByteCodePatcher;
import net.runelite.client.rs.bytecode.ByteCodeUtils;
import net.runelite.client.rs.bytecode.Hooks;
import net.runelite.http.api.RuneLiteAPI;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.compress.compressors.CompressorException;
import org.xeustechnologies.jcl.JarClassLoader;

@Slf4j
@Singleton
public class ClientLoader
{
	public static File hooksFile = new File(RuneLite.RUNELITE_DIR + "/hooks-" + RuneLiteAPI.getVersion() + "-.json");
	private final ClientConfigLoader clientConfigLoader;
	private ClientUpdateCheckMode updateCheckMode;
	private static String[] preotectedStuffs;
	private static int stepCount;

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
		if (updateCheckMode == NONE)
		{
			return null;
		}

		try
		{
			File injectedClientFile = ByteCodeUtils.injectedClientFile;
			File hijackedClientFile = ByteCodeUtils.hijackedClientFile;
			Manifest manifest = new Manifest();
			manifest.getMainAttributes().put(Attributes.Name.MANIFEST_VERSION, "1.0");
			JarOutputStream target = new JarOutputStream(new FileOutputStream(injectedClientFile), manifest);
			RSConfig config = clientConfigLoader.fetch();

			Map<String, byte[]> zipFile = new HashMap<>();
			{
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

						zipFile.put(metadata.getName(), buffer.toByteArray());
					}
				}
			}

			if (updateCheckMode == AUTO)
			{
				Map<String, String> hashes;
				try (InputStream is = ClientLoader.class.getResourceAsStream("/patch/hashes.json"))
				{
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
						if (hijackedClientFile.exists())
						{
							Logger.getAnonymousLogger().warning("[RuneLitePlus] Hash checking / Client patching skipped due to hijacked client.");
							updateCheckMode = VANILLA;
							break;
						}
						else
						{
							log.info("{} had a hash mismatch; falling back to vanilla. {} != {}", file.getKey(), file.getValue(), ourHash);
							log.info("Client is outdated!");
							updateCheckMode = VANILLA;
							break;
						}
					}
				}
			}

			if (updateCheckMode == AUTO)
			{
				ByteArrayOutputStream patchOs = new ByteArrayOutputStream(756 * 1024);
				int patchCount = 0;

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

					++patchCount;

					if (!file.getKey().startsWith("META"))
					{
						add(file.getValue(), file.getKey(), target);
					}
				}
				target.close();

				log.info("Patched {} classes", patchCount);
			}
			if (hooksFile.exists())
			{
				ByteCodePatcher.classPool = new ClassPool(true);
				ByteCodePatcher.classPool.appendClassPath(RuneLite.RUNELITE_DIR + "/injectedClient-" + RuneLiteAPI.getVersion() + "-.jar");
				Gson gson = new Gson();
				Hooks hooks = gson.fromJson(new BufferedReader(new FileReader(hooksFile)), Hooks.class);

				if (hooks.clientInstance.equals("") ||
					hooks.clientClass.equals("") ||
					hooks.projectileClass.equals("") ||
					hooks.actorClass.equals("") ||
					hooks.playerClass.equals(""))
				{
					log.info("[RuneLitePlus] Bad hooks, re-scraping.");
					stepCount = getStepCount(ByteCodeUtils.injectedClientFile.getPath());
					ByteCodePatcher.clientInstance = initHookScrape(ByteCodeUtils.injectedClientFile.getPath());
					ByteCodePatcher.findHooks(injectedClientFile.getPath());
				}
				else
				{
					ByteCodePatcher.clientInstance = hooks.clientInstance;
					ByteCodePatcher.applyHooks(ByteCodeUtils.injectedClientFile, hooks);
					log.info("[RuneLitePlus] Loaded hooks");
				}

			}
			else
			{
				log.info("[RuneLitePlus] Hooks file not found, scraping hooks.");
				stepCount = getStepCount(ByteCodeUtils.injectedClientFile.getPath());
				ByteCodePatcher.clientInstance = initHookScrape(ByteCodeUtils.injectedClientFile.getPath());
				ByteCodePatcher.hooks.protectedStuff = preotectedStuffs;
				ByteCodePatcher.findHooks(injectedClientFile.getPath());
			}

			Map<String, byte[]> zipFile2 = new HashMap<>();
			JarInputStream jis = new JarInputStream(new FileInputStream(hijackedClientFile));

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

				zipFile2.put(metadata.getName(), buffer.toByteArray());
			}

			String initialClass = config.getInitialClass();

			ClassLoader rsClassLoader = new ClassLoader(ClientLoader.class.getClassLoader())
			{
				@Override
				protected Class<?> findClass(String name) throws ClassNotFoundException
				{
					String path = name.replace('.', '/').concat(".class");
					byte[] data = zipFile2.get(path);
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
			return rs;
		}
		catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException
			| CompressorException | InvalidHeaderException | SecurityException e)
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
		catch (NotFoundException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	private void add(byte[] bytes, String entryName, JarOutputStream target) throws IOException
	{
		JarEntry entry = new JarEntry(entryName);
		target.putNextEntry(entry);
		target.write(bytes);
		target.closeEntry();
	}

	private static int getStepCount(String jarFile)
	{
		int stepCount = 0;
		JarClassLoader jcl = new JarClassLoader();
		try
		{
			ClassPool classPool = new ClassPool(true);
			classPool.appendClassPath(RuneLite.RUNELITE_DIR + "/injectedClient-" + RuneLiteAPI.getVersion() + "-.jar");
		}
		catch (NotFoundException e)
		{
			e.printStackTrace();
		}

		try
		{
			jcl.add(new FileInputStream(jarFile));
			try (JarInputStream in = new JarInputStream(new BufferedInputStream(new FileInputStream(jarFile))))
			{
				JarEntry entry;
				while ((entry = in.getNextJarEntry()) != null)
				{
					if (entry.getName().endsWith(".class"))
					{
						stepCount++;
					}
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return stepCount;
	}

	private static String initHookScrape(String jarFile)
	{
		int currentStep = 0;
		RuneLite.splashScreen.setMessage("Analyzing injected client");
		List<String> protectedStuff = new ArrayList<>();
		String clientInstance = "";
		JarClassLoader jcl = new JarClassLoader();
		try
		{
			ClassPool classPool = new ClassPool(true);
			classPool.appendClassPath(RuneLite.RUNELITE_DIR + "/injectedClient-" + RuneLiteAPI.getVersion() + "-.jar");
		}
		catch (NotFoundException e)
		{
			e.printStackTrace();
		}

		try
		{
			jcl.add(new FileInputStream(jarFile));
			try (JarInputStream in = new JarInputStream(new BufferedInputStream(new FileInputStream(jarFile))))
			{
				JarEntry entry;
				while ((entry = in.getNextJarEntry()) != null)
				{
					if (entry.getName().endsWith(".class"))
					{
						File temp = new File(jarFile);
						ClassLoader cl = ClassLoader.getSystemClassLoader();
						try
						{
							URLClassLoader child = new URLClassLoader(
								new URL[]{temp.toURI().toURL()},
								cl
							);
							try
							{
								Class classToLoad = Class.forName(entry.getName().replace(".class", ""), false, child);
								RuneLite.splashScreen.setSubMessage(entry.getName());
								currentStep++;
								RuneLite.splashScreen.setProgress(currentStep, stepCount);
								JarClassLoader jcl2 = new JarClassLoader();
								try
								{
									jcl2.add(new FileInputStream(ByteCodeUtils.injectedClientFile));
									Field[] fields = classToLoad.getDeclaredFields();
									Method[] methods = classToLoad.getDeclaredMethods();
									for (Field f : fields)
									{
										try
										{
											if (f.getName().contains("$"))
											{
												log.info(classToLoad.getName() + "." + f.getName());
												protectedStuff.add(classToLoad.getName() + "." + f.getName());
											}
											if (f.getType().getName().equals("client"))
											{
												ByteCodePatcher.hooks.clientInstance = classToLoad.getName() + "." + f.getName();
												clientInstance = classToLoad.getName() + "." + f.getName();
											}
										}
										catch (Exception e)
										{
											e.printStackTrace();
										}
									}
									for (Method m : methods)
									{
										RuneLite.splashScreen.setSubMessage("Checked " + m.getName());
										if (m.getName().contains("$"))
										{
											protectedStuff.add(classToLoad.getName() + "." + m.getName());
										}
									}
									RuneLite.splashScreen.setProgress(currentStep, stepCount);
								}
								catch (FileNotFoundException e)
								{
									e.printStackTrace();
								}
							}
							catch (Exception e)
							{
								e.printStackTrace();
							}
							RuneLite.splashScreen.setProgress(2, 5);
						}
						catch (Exception e)
						{
							e.printStackTrace();
							log.info("Class not found: " + entry.getName());
						}
					}
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		int i = 0;
		for (String ignored : protectedStuff)
		{
			i++;
		}

		preotectedStuffs = new String[i];
		i = 0;

		for (String o : protectedStuff)
		{
			preotectedStuffs[i] = o;
			i++;
		}

		return clientInstance;
	}
}
