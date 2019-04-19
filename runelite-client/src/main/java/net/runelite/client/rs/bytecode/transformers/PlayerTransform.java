package net.runelite.client.rs.bytecode.transformers;

import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;
import net.runelite.client.rs.bytecode.ByteCodePatcher;

public class PlayerTransform {
    public CtClass ct = null;

    public void modify(Class player) {
        try {
            ct = ByteCodePatcher.classPool.get(player.getName());
            transformProtectedGetSkullIcon();
            transformGetSkullIcon();
            ByteCodePatcher.modifiedClasses.add(ct);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void transformProtectedGetSkullIcon() {
        CtMethod protectedGetSkullIcon;
        try {
            protectedGetSkullIcon = ct.getDeclaredMethod("1protect$getRsSkullIcon");
            ct.removeMethod(protectedGetSkullIcon);
            protectedGetSkullIcon.setName("getRsSkullIcon");
            ct.addMethod(protectedGetSkullIcon);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void transformGetSkullIcon() {
        CtMethod getSkullIcon;
        try {
            String SkullIcon = "net.runelite.api.SkullIcon";
            getSkullIcon = ct.getDeclaredMethod("getSkullIcon");
            ct.removeMethod(getSkullIcon);
            getSkullIcon = CtNewMethod.make("public " + SkullIcon + " getSkullIcon() {" +
                    "                               switch (this.getRsSkullIcon()) {" +
                    "                               case 0: {" +
                    "                               return " + SkullIcon + ".SKULL; }" +
                    "                               case 1: {" +
                    "                               return " + SkullIcon + ".SKULL_FIGHT_PIT; }" +
                    "                               case 8: {" +
                    "                               return " + SkullIcon + ".DEAD_MAN_FIVE; }" +
                    "                               case 9: {" +
                    "                               return " + SkullIcon + ".DEAD_MAN_FOUR; }" +
                    "                               case 10: {" +
                    "                               return " + SkullIcon + ".DEAD_MAN_THREE; }" +
                    "                               case 11: {" +
                    "                               return " + SkullIcon + ".DEAD_MAN_TWO; }" +
                    "                               case 12: {" +
                    "                               return " + SkullIcon + ".DEAD_MAN_ONE; } }" +
                    "                               return null; }", ct);
            ct.addMethod(getSkullIcon);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

