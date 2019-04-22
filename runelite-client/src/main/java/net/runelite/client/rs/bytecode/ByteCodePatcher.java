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

	public static void applyHooks(File jf, Hooks hooks) {
		try {
			URLClassLoader child = new URLClassLoader(
					new URL[] {jf.toURI().toURL()},
					cl
			);
			try {
				Class actorClass = Class.forName(hooks.actorClass, false, child);
				transformActor(actorClass);
				Class projectileClass = Class.forName(hooks.projectileClass, false, child);
				transformProjectile(projectileClass);
				Class playerClass = Class.forName(hooks.playerClass, false, child);
				transformPlayer(playerClass);
				Class clientClass = Class.forName("client", false, child);
				transformBlackjack(clientClass);

				//Odds and ends
				ErrorTransform et = new ErrorTransform();
				et.modify(null);

				ByteCodeUtils.updateHijackedJar();
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void findHooks(String jf) {
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
						checkClasses(new File(jf), entry);
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

	public static void transformBlackjack(Class clazz) {
		System.out.println("[RuneLitePlus] Transforming Blackjack at class: "+clazz.getName());
		ClientTransform bt = new ClientTransform();
		bt.modify(clazz);
	}


}
