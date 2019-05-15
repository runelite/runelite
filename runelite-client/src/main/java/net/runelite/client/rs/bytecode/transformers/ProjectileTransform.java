package net.runelite.client.rs.bytecode.transformers;

import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.NotFoundException;
import net.runelite.client.rs.bytecode.ByteCodePatcher;

public class ProjectileTransform implements Transform
{
	private CtClass ct;

	// Next variable is manually added, and will break on rev update
	private static final String interactingIntvalue = "-1655053057";

	@Override
	public void modify(Class projectile)
	{
		try
		{
			ct = ByteCodePatcher.classPool.get(projectile.getName());
			transformGetAnimation();
			transformInteracting();
			ByteCodePatcher.modifiedClasses.add(ct);
		}
		catch (CannotCompileException | NotFoundException e)
		{
			e.printStackTrace();
		}
	}

	private void transformGetAnimation() throws CannotCompileException, NotFoundException
	{
		CtMethod getAnimation;

		getAnimation = ct.getDeclaredMethod("projectileMoved", new CtClass[]{CtClass.intType, CtClass.intType, CtClass.intType, CtClass.intType});
		ct.removeMethod(getAnimation);

		getAnimation = CtNewMethod.make(
			"public void projectileMoved(int n, int n2, int n3, int n4)" +
				"{ " +
				"	int n5 = this.getId();" +
				"	net.runelite.api.coords.LocalPoint localPoint = new net.runelite.api.coords.LocalPoint(n, n2);" +
				"	net.runelite.api.events.ProjectileMoved projectileMoved = new net.runelite.api.events.ProjectileMoved();" +
				"	projectileMoved.setProjectile(this);" +
				"	projectileMoved.setPosition(localPoint);" +
				"	projectileMoved.setZ(n3);" +
					ByteCodePatcher.clientInstance + ".getCallbacks().post(projectileMoved);" +
				"}", ct);
		ct.addMethod(getAnimation);
	}

	private void transformInteracting() throws CannotCompileException
	{
		CtMethod getRsInteracting;
		CtMethod getInteracting;

		getRsInteracting = CtNewMethod.make("public int getRsInteracting() { return this.n * " + interactingIntvalue + "; }", ct);
		ct.addMethod(getRsInteracting);

		getInteracting = CtNewMethod.make(
			"public net.runelite.api.Actor getInteracting()" +
				"{" +
				"	int var1 = this.getRsInteracting();" +
				"	if (var1 == 0)" +
				"	{" +
				"		return null;" +
				"	}" +
				"	else" +
				"	{" +
				"		int var2;" +
				"		if (var1 > 0)" +
				"		{" +
				"			var2 = var1 - 1;" +
				"			net.runelite.rs.api.RSNPC[] var4 = " + ByteCodePatcher.clientInstance + ".getCachedNPCs();" +
				"			return var4[var2];" +
				"		}" +
				"		else" +
				"		{" +
				"			var2 = -var1 - 1;" +
				"			if (var2 == " + ByteCodePatcher.clientInstance + ".getLocalInteractingIndex())" +
				"			{" +
				"				return " + ByteCodePatcher.clientInstance + ".getLocalPlayer();" +
				"			}" +
				"			else" +
				"			{" +
				"				net.runelite.rs.api.RSPlayer[] var3 = " + ByteCodePatcher.clientInstance + ".getCachedPlayers();" +
				"				return var3[var2];" +
				"			}" +
				"		}" +
				"	}" +
				"}", ct);
		ct.addMethod(getInteracting);
	}
}
