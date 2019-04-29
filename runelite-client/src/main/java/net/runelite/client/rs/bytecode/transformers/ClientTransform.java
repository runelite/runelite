package net.runelite.client.rs.bytecode.transformers;

import javassist.CtBehavior;
import javassist.CtClass;
import javassist.CtMember;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.ClassFile;
import javassist.bytecode.ConstPool;
import javassist.bytecode.StackMapTable;
import net.runelite.client.rs.bytecode.ByteCodePatcher;

public class ClientTransform implements Transform {

	public CtClass ct = null;

	@Override
	public void modify(Class clazz) {
		try {
			ct = ByteCodePatcher.classPool.get(clazz.getName());
			transformProtectedGetMenuOptions();
			transformProtectedGetMenuTargets();
			transformProtectedGetMenuIdentifiers();
			transformProtectedGetMenuTypes();
			transformProtectedGetMenuActionParams0();
			transformProtectedGetMenuActionParams1();
			transformGetMenuEntries();
			transformSetMenuEntries();
			transformOnMenuOptionsChanged();
            transformGetProjectiles();
            transformGetCollisionMaps();
            transformDraw2010Menu();
			transformRenderSelf();

			ByteCodePatcher.modifiedClasses.add(ct);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void transformProtectedGetMenuOptions() {
		CtMethod protectedGetMenuOptions;
		try {
			protectedGetMenuOptions = ct.getDeclaredMethod("1protect$getMenuOptions");
			ct.removeMethod(protectedGetMenuOptions);
			protectedGetMenuOptions.setName("getMenuOptions");
			ct.addMethod(protectedGetMenuOptions);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    public void transformGetProjectiles() {

        CtMethod getProjectiles;
        try {
            CtMethod getProjectilesDeque = ct.getDeclaredMethod("1protect$getProjectilesDeque");
            ct.removeMethod(getProjectilesDeque);
			getProjectilesDeque.setName("getProjectilesDeque");
            ct.addMethod(getProjectilesDeque);
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
            System.out.println("Added override annotation for getprojectiles");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	public void transformProtectedGetMenuTargets() {
		CtMethod protectedGetMenuTargets;
		try {
			protectedGetMenuTargets = ct.getDeclaredMethod("1protect$getMenuTargets");
			ct.removeMethod(protectedGetMenuTargets);
			protectedGetMenuTargets.setName("getMenuTargets");
			ct.addMethod(protectedGetMenuTargets);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    public void transformGetCollisionMaps() {
        CtMethod getCollisionMaps;
        try {
            CtMethod protectedMaps = ct.getDeclaredMethod("1protect$getRsCollisionMaps");
            ct.removeMethod(protectedMaps);
            protectedMaps.setName("getRsCollisionMaps");
            ct.addMethod(protectedMaps);
            getCollisionMaps = ct.getDeclaredMethod("getCollisionMaps");
            ct.removeMethod(getCollisionMaps);
            getCollisionMaps = CtMethod.make("public net.runelite.rs.api.RSCollisionData[] getCollisionMaps() {" +
                    "								return getRsCollisionMaps();" +
                    "							}", ct);
            ct.addMethod(getCollisionMaps);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	public void transformProtectedGetMenuIdentifiers() {
		CtMethod protectedGetMenuIdentifiers;
		try {
			protectedGetMenuIdentifiers = ct.getDeclaredMethod("1protect$getMenuIdentifiers");
			ct.removeMethod(protectedGetMenuIdentifiers);
			protectedGetMenuIdentifiers.setName("getMenuIdentifiers");
			ct.addMethod(protectedGetMenuIdentifiers);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void transformProtectedGetMenuTypes() {
		CtMethod protectedGetMenuTypes;
		try {
			protectedGetMenuTypes = ct.getDeclaredMethod("1protect$getMenuTypes");
			// Don't remove as this is referenced elsewhere in client
			//ct.removeMethod(protectedGetMenuTypes);
			CtMethod newProtectedGetMenuTypes = CtNewMethod.copy(protectedGetMenuTypes, ct, null);
			newProtectedGetMenuTypes.setName("getMenuTypes");
			ct.addMethod(newProtectedGetMenuTypes);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void transformProtectedGetMenuActionParams0() {
		CtMethod protectedGetMenuActionParams0;
		try {
			protectedGetMenuActionParams0 = ct.getDeclaredMethod("1protect$getMenuActionParams0");
			ct.removeMethod(protectedGetMenuActionParams0);
			protectedGetMenuActionParams0.setName("getMenuActionParams0");
			ct.addMethod(protectedGetMenuActionParams0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void transformProtectedGetMenuActionParams1() {
		CtMethod protectedGetMenuActionParams1;
		try {
			protectedGetMenuActionParams1 = ct.getDeclaredMethod("1protect$getMenuActionParams1");
			ct.removeMethod(protectedGetMenuActionParams1);
			protectedGetMenuActionParams1.setName("getMenuActionParams1");
			ct.addMethod(protectedGetMenuActionParams1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void transform() {}

	public void transformGetMenuEntries() {
		CtMethod getMenuEntries;
		try {
			getMenuEntries = ct.getDeclaredMethod("getMenuEntries");
			ct.removeMethod(getMenuEntries);
			getMenuEntries = CtMethod.make("public net.runelite.api.MenuEntry[] getMenuEntries() {" +
					"								int n2 = this.getMenuOptionCount();"+
					"								String[] arrstring = this.getMenuOptions();"+
					"								String[] arrstring2 = this.getMenuTargets();"+
					"								int[] arrn = this.getMenuIdentifiers();"+
					"								int[] arrn2 = this.getMenuTypes();"+
					"								int[] arrn3 = this.getMenuActionParams0();"+
					"								int[] arrn4 = this.getMenuActionParams1();"+
					"								boolean[] arrbl = this.getMenuForceLeftClick();"+
					"								net.runelite.api.MenuEntry[] arrmenuEntry = new net.runelite.api.MenuEntry[n2];"+
					"								int n3 = 0;"+
					"								while (n3 < n2) {"+
					"									net.runelite.api.MenuEntry menuEntry = arrmenuEntry[n3] = new net.runelite.api.MenuEntry();"+
					"									menuEntry.setOption(arrstring[n3]);"+
					"									menuEntry.setTarget(arrstring2[n3]);"+
					"									menuEntry.setIdentifier(arrn[n3]);"+
					"									menuEntry.setType(arrn2[n3]);"+
					"									menuEntry.setParam0(arrn3[n3]);"+
					"									menuEntry.setParam1(arrn4[n3]);"+
					"									menuEntry.setForceLeftClick(arrbl[n3]);"+
					"									++n3;"+
					"								}"+
					"								return arrmenuEntry;"+
					"							}", ct);
			ct.addMethod(getMenuEntries);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void transformSetMenuEntries() {
		CtMethod setMenuEntries;
		try {
			setMenuEntries = ct.getDeclaredMethod("setMenuEntries");
			ct.removeMethod(setMenuEntries);
			String src;
			setMenuEntries = CtNewMethod.make(
					"public void setMenuEntries(net.runelite.api.MenuEntry[] arrmenuEntry) {" +
							"int n2 = 0;" +
							"String[] arrstring = this.getMenuOptions();" +
							"String[] arrstring2 = this.getMenuTargets();" +
							"int[] arrn = this.getMenuIdentifiers();" +
							"int[] arrn2 = this.getMenuTypes();" +
							"int[] arrn3 = this.getMenuActionParams0();" +
							"int[] arrn4 = this.getMenuActionParams1();" +
							"boolean[] arrbl = getMenuForceLeftClick();" +
							"net.runelite.api.MenuEntry[] arrmenuEntry2 = arrmenuEntry;" +
							"int n3 = arrmenuEntry2.length;" +
							"int n4 = 0;" +
							"do {" +
								"String string;" +
								"if (n4 >= n3) {" +
									"this.setMenuOptionCount(n2);" +
									"oldMenuEntryCount = n2;" +
									"return;" +
								"}" +
								"net.runelite.api.MenuEntry menuEntry = arrmenuEntry2[n4];" +
								"int n5 = menuEntry.getType();" +
								"arrstring[n2] = menuEntry.getOption();" +
								"arrstring2[n2] = menuEntry.getTarget();" +
								"arrn[n2] = menuEntry.getIdentifier();" +
								"arrn2[n2] = n5;" +
								"arrn3[n2] = menuEntry.getParam0();" +
								"arrn4[n2] = menuEntry.getParam1();" +
								"arrbl[n2] = menuEntry.isForceLeftClick();" +
								"++n2;" +
								"++n4;" +
							"} while (true);" +
						"}"
					, ct);
			ct.addMethod(setMenuEntries);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	public void setMenuEntries(MenuEntry[] arrmenuEntry) {
    int n2 = 0;
    String[] arrstring = this.1protect$getMenuOptions();
    String[] arrstring2 = this.1protect$getMenuTargets();
    int[] arrn = this.1protect$getMenuIdentifiers();
    int[] arrn2 = this.1protect$getMenuTypes();
    int[] arrn3 = this.1protect$getMenuActionParams0();
    int[] arrn4 = this.1protect$getMenuActionParams1();
    boolean[] arrbl = this.getMenuForceLeftClick();
    MenuEntry[] arrmenuEntry2 = arrmenuEntry;
    int n3 = arrmenuEntry2.length;
    int n4 = 0;
    do {
        String string;
        if (n4 >= n3) {
            this.setMenuOptionCount(n2);
            oldMenuEntryCount = n2;
            return;
        }
        MenuEntry menuEntry = arrmenuEntry2[n4];
        int n5 = menuEntry.getType();
        if (!(n5 != MenuAction.NPC_THIRD_OPTION.getId() && n5 != MenuAction.NPC_FIFTH_OPTION.getId() || n2 != arrmenuEntry.length - 1 || bv.ak.getLocalPlayer().getWorldLocation().getRegionID() != 13358 || (string = menuEntry.getOption().toLowerCase()).hashCode() != 974723797 && string.hashCode() != -1108625161)) {
            n5 = MenuAction.CANCEL.getId();
        }
        arrstring[n2] = menuEntry.getOption();
        arrstring2[n2] = menuEntry.getTarget();
        arrn[n2] = menuEntry.getIdentifier();
        arrn2[n2] = n5;
        arrn3[n2] = menuEntry.getParam0();
        arrn4[n2] = menuEntry.getParam1();
        arrbl[n2] = menuEntry.isForceLeftClick();
        ++n2;
        ++n4;
    } while (true);
}
	 */

	public void transformOnMenuOptionsChanged() {
		CtMethod onMenuOptionsChanged;
		try {
			onMenuOptionsChanged = ct.getDeclaredMethod("onMenuOptionsChanged", new CtClass[]{CtClass.intType});
			ct.removeMethod(onMenuOptionsChanged);
			onMenuOptionsChanged = CtMethod.make("	public static void onMenuOptionsChanged(int n2) {"+
					"										int n3;" +
					"										int n4 = oldMenuEntryCount;"+
					"										oldMenuEntryCount = n3 = "+ByteCodePatcher.clientInstance+".getMenuOptionCount();"+
					"										if (n3 != n4 + 1) return;"+
					"										net.runelite.api.events.MenuEntryAdded menuEntryAdded = new net.runelite.api.events.MenuEntryAdded("+ByteCodePatcher.clientInstance+".getMenuOptions()[n3 - 1], "+ByteCodePatcher.clientInstance+".getMenuTargets()[n3 - 1], "+ByteCodePatcher.clientInstance+".getMenuTypes()[n3 - 1], "+ByteCodePatcher.clientInstance+".getMenuIdentifiers()[n3 - 1], "+ByteCodePatcher.clientInstance+".getMenuActionParams0()[n3 - 1], "+ByteCodePatcher.clientInstance+".getMenuActionParams1()[n3 - 1]);"+
					"										"+ByteCodePatcher.clientInstance+".getCallbacks().post((Object)menuEntryAdded);" +
							"							}"
														, ct);
			ct.addMethod(onMenuOptionsChanged);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void transformRenderSelf() {
		CtMethod renderSelf;
		try {
			renderSelf = CtMethod.make("	public void toggleRenderSelf() {"+
							"						jb = !jb;"+
							"					}"
					, ct);
			ClassFile classFile = ct.getClassFile();
			ConstPool constPool = classFile.getConstPool();
			AnnotationsAttribute attr = new AnnotationsAttribute(constPool, AnnotationsAttribute.visibleTag);
			javassist.bytecode.annotation.Annotation annotation = new javassist.bytecode.annotation.Annotation("Export", constPool);
			attr.setAnnotation(annotation);
			renderSelf.getMethodInfo().addAttribute(attr);
			ct.addMethod(renderSelf);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void transformDraw2010Menu() {
		CtMethod draw2010Menu;
		try {
			draw2010Menu = ct.getDeclaredMethod("draw2010Menu");
			ct.removeMethod(draw2010Menu);
			draw2010Menu = CtNewMethod.make(
						"    public void draw2010Menu() {" +
							"        int n2 = this.getMenuX();" +
							"        int n3 = this.getMenuY();" +
							"        int n4 = this.getMenuWidth();" +
							"        int n5 = this.getMenuHeight();" +
							"        this.RasterizerDrawHorizontalLine(n2 + 2, n3, n4 - 4, 7170651);" +
							"        this.RasterizerDrawHorizontalLine(n2 + 2, n3 + n5 - 1, n4 - 4, 7170651);" +
							"        this.RasterizerDrawVerticalLine(n2, n3 + 2, n5 - 4, 7170651);" +
							"        this.RasterizerDrawVerticalLine(n2 + n4 - 1, n3 + 2, n5 - 4, 7170651);" +
							"        this.RasterizerDrawRectangle(n2 + 1, n3 + 5, n4 - 2, n5 - 6, 2827810);" +
							"        this.RasterizerDrawHorizontalLine(n2 + 1, n3 + 17, n4 - 2, 2827810);" +
							"        this.RasterizerDrawCircle(n2 + 2, n3 + n5 - 3, 0, 2827810);" +
							"        this.RasterizerDrawCircle(n2 + n4 - 3, n3 + n5 - 3, 0, 2827810);" +
							"        this.RasterizerDrawGradient(n2 + 2, n3 + 1, n4 - 4, 16, 3288610, 592388);" +
							"        this.RasterizerFillRectangle(n2 + 1, n3 + 1, 2, 4, 2827810);" +
							"        this.RasterizerFillRectangle(n2 + n4 - 3, n3 + 1, 2, 4, 2827810);" +
							"        this.RasterizerDrawHorizontalLine(n2 + 2, n3 + 18, n4 - 4, 5392957);" +
							"        this.RasterizerDrawHorizontalLine(n2 + 3, n3 + n5 - 3, n4 - 6, 5392957);" +
							"        this.RasterizerDrawVerticalLine(n2 + 2, n3 + 18, n5 - 21, 5392957);" +
							"        this.RasterizerDrawVerticalLine(n2 + n4 - 3, n3 + 18, n5 - 21, 5392957);" +
							"        this.RasterizerFillRectangle(n2 + 3, n3 + 19, n4 - 6, n5 - 22, 2828060);" +
							"        this.RasterizerDrawCircle(n2 + 1, n3 + 1, 0, 7170651);" +
							"        this.RasterizerDrawCircle(n2 + n4 - 2, n3 + 1, 0, 7170651);" +
							"        this.RasterizerDrawCircle(n2 + 1, n3 + n5 - 2, 0, 7170651);" +
							"        this.RasterizerDrawCircle(n2 + n4 - 2, n3 + n5 - 2, 0, 7170651);" +
							"        net.runelite.rs.api.RSFont rSFont = this.getFontBold12();" +
							"        rSFont.drawTextLeftAligned(\"Choose Option\", n2 + 3, n3 + 14, 13023381, -1);" +
							"        int n6 = this.getMouseX();" +
							"        int n7 = this.getMouseY();" +
							"        int n8 = this.getMenuOptionCount();" +
							"        String[] arrstring = this.getMenuTargets();" +
							"        String[] arrstring2 = this.getMenuOptions();" +
							"        for (int i = 0; i < n8; ++i) {" +
							"            int n9 = n3 + (n8 - 1 - i) * 15 + 31;" +
							"            String string = arrstring2[i];" +
							"            if (!arrstring[i].isEmpty()) {" +
							"                string = string + \" \" + arrstring[i];" +
							"            }" +
							"            rSFont.drawTextLeftAligned(string, n2 + 3, n9, 13023381, -1);" +
							"            if (n6 <= n2 || n6 >= n4 + n2 || n7 <= n9 - 13 || n7 >= n9 + 3) continue;" +
							"            this.RasterizerFillRectangleAlpha(n2 + 3, n9 - 12, n4 - 6, 15, 16777215, 80);" +
							"        }" +
							"    }"
					, ct);
			ct.addMethod(draw2010Menu);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
