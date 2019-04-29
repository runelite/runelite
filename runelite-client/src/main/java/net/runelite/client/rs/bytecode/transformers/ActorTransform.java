package net.runelite.client.rs.bytecode.transformers;

import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.NotFoundException;
import net.runelite.client.rs.bytecode.ByteCodePatcher;

public class ActorTransform implements Transform {
    public CtClass ct = null;

    @Override
    public void modify(Class actor) {
        try {
            ct = ByteCodePatcher.classPool.get(actor.getName());
            transformGetAnimation();
            transformAnimationChanged();
            transformGraphicChanged();
            ByteCodePatcher.modifiedClasses.add(ct);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void transform() { }

    public void transformGetAnimation() {
        try {
            CtMethod protectedAnimation = ct.getDeclaredMethod("1protect$getRsAnimation");
            ct.removeMethod(protectedAnimation);
            protectedAnimation.setName("getRsAnimation");
            ct.addMethod(protectedAnimation);
            CtMethod getAnimation = ct.getDeclaredMethod("getAnimation");
            ct.removeMethod(getAnimation);
            getAnimation = CtNewMethod.make("public int getAnimation() { return this.getRsAnimation(); }",ct);
            ct.addMethod(getAnimation);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void transformAnimationChanged() {
        try {
            CtMethod getAnimationChanged = ct.getDeclaredMethod("animationChanged", new CtClass[]{CtClass.intType});
            ct.removeMethod(getAnimationChanged);
            getAnimationChanged = CtNewMethod.make("public void animationChanged(int n) { " +
                    "                                       net.runelite.api.events.AnimationChanged animationChanged = new net.runelite.api.events.AnimationChanged();" +
                    "                                       animationChanged.setActor((net.runelite.api.Actor)this);" +
                    "                                       "+ByteCodePatcher.clientInstance+".getCallbacks().post((java.lang.Object)animationChanged); }",ct);
            ct.addMethod(getAnimationChanged);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void transformGraphicChanged() {
        try {
            CtMethod graphicChanged = ct.getDeclaredMethod("graphicChanged", new CtClass[]{CtClass.intType});
            ct.removeMethod(graphicChanged);
            graphicChanged = CtNewMethod.make("public void graphicChanged(int paramInt){" +
                    "                                       net.runelite.api.events.GraphicChanged localGraphicChanged = new net.runelite.api.events.GraphicChanged();" +
                    "                                       localGraphicChanged.setActor(this);" +
                    "                                       "+ByteCodePatcher.clientInstance+".getCallbacks().post(localGraphicChanged);}",ct);
            ct.addMethod(graphicChanged);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
