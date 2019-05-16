package net.runelite.client.rs.bytecode.transformers;

import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.rs.bytecode.ByteCodePatcher;

@Slf4j
public class PlayerTransform implements Transform
{
	private CtClass ct;

	@Override
	public void modify(Class player)
	{
		try
		{
			ct = ByteCodePatcher.classPool.get(player.getName());
			transformProtectedGetSkullIcon();
			transformGetSkullIcon();
			ByteCodePatcher.modifiedClasses.add(ct);
		}
		catch (CannotCompileException | NotFoundException e)
		{
			e.printStackTrace();
		}
	}

	private void transformProtectedGetSkullIcon() throws CannotCompileException, NotFoundException
	{
		CtMethod protectedGetSkullIcon;

		protectedGetSkullIcon = ct.getDeclaredMethod("1protect$getRsSkullIcon");
		ct.removeMethod(protectedGetSkullIcon);
		protectedGetSkullIcon.setName("getRsSkullIcon");

		ct.addMethod(protectedGetSkullIcon);

		log.info(
			"[RuneLitePlus] transformed {} ({}) at class: {}",
			this.getClass().getSimpleName(),
			new Object(){}.getClass().getEnclosingMethod().getName(),
			ct.getName()
		);
	}

	private void transformGetSkullIcon() throws CannotCompileException, NotFoundException
	{
		CtMethod getSkullIcon;

		String SkullIcon = "net.runelite.api.SkullIcon";
		getSkullIcon = ct.getDeclaredMethod("getSkullIcon");
		ct.removeMethod(getSkullIcon);

		getSkullIcon = CtNewMethod.make(
			"public " + SkullIcon + " getSkullIcon()" +
				"{" +
					"switch (this.getRsSkullIcon())" +
					"{" +
						"case 0:" +
							"return " + SkullIcon + ".SKULL;" +
						"case 1:" +
							"return " + SkullIcon + ".SKULL_FIGHT_PIT;" +
						"case 8:" +
							"return " + SkullIcon + ".DEAD_MAN_FIVE;" +
						"case 9:" +
							"return " + SkullIcon + ".DEAD_MAN_FOUR;" +
						"case 10:" +
							"return " + SkullIcon + ".DEAD_MAN_THREE;" +
						"case 11:" +
							"return " + SkullIcon + ".DEAD_MAN_TWO;" +
						"case 12:" +
							"return " + SkullIcon + ".DEAD_MAN_ONE;" +
					"}" +
					"return null;" +
				"}", ct);
		ct.addMethod(getSkullIcon);

		log.info(
			"[RuneLitePlus] transformed {} ({}) at class: {}",
			this.getClass().getSimpleName(),
			new Object(){}.getClass().getEnclosingMethod().getName(),
			ct.getName()
		);
	}
}
