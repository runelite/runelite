package net.runelite.client.rs.bytecode;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;
import net.runelite.client.RuneLite;
import net.runelite.client.rs.ClientLoader;
import net.runelite.client.rs.bytecode.transformers.ActorTransform;
import net.runelite.client.rs.bytecode.transformers.ClientTransform;
import net.runelite.client.rs.bytecode.transformers.ErrorTransform;
import net.runelite.client.rs.bytecode.transformers.PlayerTransform;
import net.runelite.client.rs.bytecode.transformers.ProjectileTransform;
import net.runelite.http.api.RuneLiteAPI;
import org.xeustechnologies.jcl.JarClassLoader;

import javax.swing.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

public class ByteCodePatcher {

	public static List<CtClass> modifiedClasses = new ArrayList<>();
	public static Hooks hooks = new Hooks();
	public static String clientInstance;
	public static JarClassLoader jcl = new JarClassLoader();
	public static ClassPool classPool = null;
	public static ClassLoader cl = ClassLoader.getSystemClassLoader();
	public static int classCount = 0;

	public static void applyHooks(File jf, Hooks hooks) {
		RuneLite.splashScreen.setProgress(0, 5);
		RuneLite.splashScreen.setMessage("Applying cached bytecode patches...");
		try {
			URLClassLoader child = new URLClassLoader(
					new URL[] {jf.toURI().toURL()},
					cl
			);
			try {
				RuneLite.splashScreen.setSubMessage("Transforming Actor");
				Class actorClass = Class.forName(hooks.actorClass, false, child);
				transformActor(actorClass);
				RuneLite.splashScreen.setProgress(1, 5);

				RuneLite.splashScreen.setSubMessage("Transforming Projectile");
				Class projectileClass = Class.forName(hooks.projectileClass, false, child);
				transformProjectile(projectileClass);
				RuneLite.splashScreen.setProgress(2, 5);

				RuneLite.splashScreen.setSubMessage("Transforming Player");
				Class playerClass = Class.forName(hooks.playerClass, false, child);
				transformPlayer(playerClass);
				RuneLite.splashScreen.setProgress(3, 5);

				RuneLite.splashScreen.setSubMessage("Transforming Client");
				Class clientClass = Class.forName("client", false, child);
				transformClient(clientClass);
				RuneLite.splashScreen.setProgress(4, 5);

				//Odds and ends
				RuneLite.splashScreen.setSubMessage("Transforming Error method");
				ErrorTransform et = new ErrorTransform();
				et.modify(null);
				RuneLite.splashScreen.setProgress(5, 5);
				RuneLite.splashScreen.setSubMessage("");
				ByteCodeUtils.updateHijackedJar();
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void findHooks(String jf) {
		RuneLite.splashScreen.setMessage("Hijacking Classes");
		try {
			classPool = new ClassPool(true);
			classPool.appendClassPath(RuneLite.RUNELITE_DIR+"/injectedClient-"+ RuneLiteAPI.getVersion() +"-.jar");
		} catch (NotFoundException e) {
			e.printStackTrace();
		}

		try {
			jcl.add(new FileInputStream(jf));
			try (JarInputStream in = new JarInputStream(new BufferedInputStream(new FileInputStream(jf)))) {
				JarEntry entry;
				while ((entry = in.getNextJarEntry()) != null) {
					if (entry.getName().endsWith(".class")) {
						classCount++;
					}
				}
			}
			int i = 0;
			jcl.add(new FileInputStream(jf));
			try (JarInputStream in = new JarInputStream(new BufferedInputStream(new FileInputStream(jf)))) {
				JarEntry entry;
				while ((entry = in.getNextJarEntry()) != null) {
					if (entry.getName().endsWith(".class")) {
						RuneLite.splashScreen.setProgress(i, classCount);
						RuneLite.splashScreen.setSubMessage("Checking "+entry.getName());
						checkClasses(new File(jf), entry);
						i++;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try {
			Writer writer = new FileWriter(ClientLoader.hooksFile);
			gson.toJson(hooks, writer);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ByteCodeUtils.updateHijackedJar();
	}

	public static void checkClasses(File jf, JarEntry entry) {
		try {
			URLClassLoader child = new URLClassLoader(
					new URL[] {jf.toURI().toURL()},
					cl
			);
			try {
				Class classToLoad = Class.forName(entry.getName().replace(".class", ""), false, child);
				checkActor(classToLoad);
				checkProjectile(classToLoad);
				checkPlayer(classToLoad);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Class not found: "+entry.getName());
		}
	}

	public static void checkActor(Class current) {
		try {
			Method method = current.getDeclaredMethod("setCombatInfo", new Class[] { int.class, int.class, int.class, int.class, int.class, int.class });
			if (method!=null) {
				hooks.actorClass = current.getName();
				System.out.println("[RuneLitePlus] Transforming Actor at class: "+current.getName());
				ActorTransform at = new ActorTransform();
				at.modify(current);
			}
		} catch (NoSuchMethodException e) {
			//e.printStackTrace();
		} catch (NoClassDefFoundError e) {
			//e.printStackTrace();
		}
	}

	public static void transformActor(Class actor) {
		System.out.println("[RuneLitePlus] Transforming Actor at class: "+actor.getName());
		ActorTransform at = new ActorTransform();
		at.modify(actor);
	}

	public static void checkProjectile(Class current) {
		try {
			Method method = current.getDeclaredMethod("projectileMoved", new Class[] { int.class, int.class, int.class, int.class});
			if (method!=null) {
				hooks.projectileClass = current.getName();
				System.out.println("[RuneLitePlus] Transforming Projectile at class: "+current.getName());
				ProjectileTransform pt = new ProjectileTransform();
				pt.modify(current);
			}
		} catch (NoSuchMethodException e) {
			//e.printStackTrace();
		} catch (NoClassDefFoundError e) {
			//e.printStackTrace();
		}
	}

	public static void transformProjectile(Class projectile) {
		System.out.println("[RuneLitePlus] Transforming Projectile at class: "+projectile.getName());
		ProjectileTransform pt = new ProjectileTransform();
		pt.modify(projectile);
	}

	public static void checkPlayer(Class current) {
		try {
			Method method = current.getDeclaredMethod("getSkullIcon");
			if (method!=null) {
				hooks.playerClass = current.getName();
				System.out.println("[RuneLitePlus] Transforming Player at class: "+current.getName());
				PlayerTransform pt = new PlayerTransform();
				pt.modify(current);
			}
		} catch (NoSuchMethodException e) {
			//e.printStackTrace();
		} catch (NoClassDefFoundError e) {
			//e.printStackTrace();
		}
	}

	public static void transformPlayer(Class player) {
		System.out.println("[RuneLitePlus] Transforming Player at class: "+player.getName());
		PlayerTransform pt = new PlayerTransform();
		pt.modify(player);
	}

	public static void transformClient(Class clazz) {
		System.out.println("[RuneLitePlus] Transforming Client");
		ClientTransform bt = new ClientTransform();
		bt.modify(clazz);
	}

}
