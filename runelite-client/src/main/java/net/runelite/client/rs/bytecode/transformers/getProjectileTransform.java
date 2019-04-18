package net.runelite.client.rs.bytecode.transformers;

import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.ClassFile;
import javassist.bytecode.ConstPool;
import net.runelite.client.rs.bytecode.ByteCodePatcher;


public class getProjectileTransform {
    public CtClass ct = null;

    public void modify(Class getprojectile) {
        try {
            ct = ByteCodePatcher.classPool.get(getprojectile.getName());

            transformGetProjectile();
            ByteCodePatcher.modifiedClasses.add(ct);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void transformGetProjectile() {

        CtMethod getProjectiles;
        try {
            CtMethod protectedAnimation = ct.getDeclaredMethod("1protect$getProjectilesDeque");
            ct.removeMethod(protectedAnimation);
            protectedAnimation.setName("getProjectilesDeque");
            ct.addMethod(protectedAnimation);
            getProjectiles = ct.getDeclaredMethod("getProjectiles");
            ct.removeMethod(getProjectiles);
            getProjectiles = CtNewMethod.make("public java.util.List getProjectiles() { " +
                    "                               java.util.ArrayList localArrayList = new java.util.ArrayList();" +
                    "                               net.runelite.rs.api.RSDeque localRSDeque = getProjectilesDeque();" +
                    "                               net.runelite.rs.api.RSNode localRSNode = localRSDeque.getHead();" +
                    "                               for (net.runelite.api.Node localNode = localRSNode.getNext(); localNode != localRSNode; localNode = localNode.getNext()) {" +
                    "                                   net.runelite.api.Projectile localProjectile = (net.runelite.api.Projectile)localNode;" +
                    "                                   localArrayList.add(localProjectile);  }" +
                    "                               return localArrayList; }", ct);

            ct.addMethod(getProjectiles);
            ClassFile classFile = ct.getClassFile();
            ConstPool constPool = classFile.getConstPool();
            AnnotationsAttribute attr = new AnnotationsAttribute(constPool, AnnotationsAttribute.visibleTag);
            javassist.bytecode.annotation.Annotation annotation = new javassist.bytecode.annotation.Annotation("Override", constPool);
            attr.setAnnotation(annotation);
            getProjectiles.getMethodInfo().addAttribute(attr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
