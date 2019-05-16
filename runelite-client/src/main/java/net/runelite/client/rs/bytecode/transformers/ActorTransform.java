package net.runelite.client.rs.bytecode.transformers;

import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.rs.bytecode.ByteCodePatcher;

@Slf4j
public class ActorTransform implements Transform
{
	private CtClass ct;

	@Override
	public void modify(Class actor)
	{
		try
		{
			ct = ByteCodePatcher.classPool.get(actor.getName());

			transformGetAnimation();
			transformAnimationChanged();
			transformGraphicChanged();

			ByteCodePatcher.modifiedClasses.add(ct);
		}
		catch (CannotCompileException | NotFoundException e)
		{
			e.printStackTrace();
		}
	}

	private void transformGetAnimation() throws CannotCompileException, NotFoundException
	{
		CtMethod protectedAnimation = ct.getDeclaredMethod("1protect$getRsAnimation");
		ct.removeMethod(protectedAnimation);

		protectedAnimation.setName("getRsAnimation");
		ct.addMethod(protectedAnimation);

		CtMethod getAnimation = ct.getDeclaredMethod("getAnimation");
		ct.removeMethod(getAnimation);

		getAnimation = CtNewMethod.make(
			"public int getAnimation()" +
				"{" +
				"	return this.getRsAnimation();" +
				"}", ct);
		ct.addMethod(getAnimation);

		log.info(
			"[RuneLitePlus] transformed {} ({}) at class: {}",
			this.getClass().getSimpleName(),
			new Object(){}.getClass().getEnclosingMethod().getName(),
			ct.getName()
		);
	}


	private void transformAnimationChanged() throws CannotCompileException, NotFoundException
	{
		CtMethod getAnimationChanged = ct.getDeclaredMethod("animationChanged", new CtClass[]{CtClass.intType});
		ct.removeMethod(getAnimationChanged);

		getAnimationChanged = CtNewMethod.make(
			"public void animationChanged(int n)" +
				"{" +
				"	net.runelite.api.events.AnimationChanged animationChanged = new net.runelite.api.events.AnimationChanged();" +
				"	animationChanged.setActor((net.runelite.api.Actor) this);" +
					ByteCodePatcher.clientInstance + ".getCallbacks().post((java.lang.Object)animationChanged);" +
				"}", ct);
		ct.addMethod(getAnimationChanged);

		log.info(
			"[RuneLitePlus] transformed {} ({}) at class: {}",
			this.getClass().getSimpleName(),
			new Object(){}.getClass().getEnclosingMethod().getName(),
			ct.getName()
		);
	}

	private void transformGraphicChanged() throws CannotCompileException, NotFoundException
	{
		CtMethod graphicChanged = ct.getDeclaredMethod("graphicChanged", new CtClass[]{CtClass.intType});
		ct.removeMethod(graphicChanged);

		graphicChanged = CtNewMethod.make(
			"public void graphicChanged(int paramInt)" +
				"{" +
				"	net.runelite.api.events.GraphicChanged localGraphicChanged = new net.runelite.api.events.GraphicChanged();" +
				"	localGraphicChanged.setActor(this);" +
					ByteCodePatcher.clientInstance + ".getCallbacks().post(localGraphicChanged);" +
				"}", ct);
		ct.addMethod(graphicChanged);

		log.info(
			"[RuneLitePlus] transformed {} ({}) at class: {}",
			this.getClass().getSimpleName(),
			new Object(){}.getClass().getEnclosingMethod().getName(),
			ct.getName()
		);
	}

}
