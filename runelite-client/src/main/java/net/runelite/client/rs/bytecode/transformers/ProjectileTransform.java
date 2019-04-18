package net.runelite.client.rs.bytecode.transformers;

import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;
import net.runelite.client.rs.bytecode.ByteCodePatcher;

public class ProjectileTransform {
    public CtClass ct = null;

    public void modify(Class projectile) {
        try {
            ct = ByteCodePatcher.classPool.get(projectile.getName());
            transformProjectileMoved();
            ByteCodePatcher.modifiedClasses.add(ct);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void transformProjectileMoved() {
        CtMethod getAnimation;
        try {
            getAnimation = ct.getDeclaredMethod("projectileMoved", new CtClass[]{CtClass.intType, CtClass.intType, CtClass.intType, CtClass.intType});
            ct.removeMethod(getAnimation);
            getAnimation = CtNewMethod.make("public void projectileMoved(int n, int n2, int n3, int n4) { " +
                    "                               int n5 = this.getId();" +
                    "                               net.runelite.api.coords.LocalPoint localPoint = new net.runelite.api.coords.LocalPoint(n, n2);" +
                    "                               net.runelite.api.events.ProjectileMoved projectileMoved = new net.runelite.api.events.ProjectileMoved();" +
                    "                               projectileMoved.setProjectile(this);" +
                    "                               projectileMoved.setPosition(localPoint);" +
                    "                               projectileMoved.setZ(n3);" +
                    "                               "+ByteCodePatcher.clientInstance+".getCallbacks().post(projectileMoved); }",ct);
            ct.addMethod(getAnimation);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
