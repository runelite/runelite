package net.runelite.client.rs.bytecode.transformers;

import javassist.CtBehavior;
import javassist.CtClass;
import javassist.CtMember;
import javassist.CtMethod;
import javassist.CtNewMethod;
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
								"if (!(n5 != net.runelite.api.MenuAction.NPC_THIRD_OPTION.getId() && n5 != net.runelite.api.MenuAction.NPC_FIFTH_OPTION.getId() || n2 != arrmenuEntry.length - 1 || "+ByteCodePatcher.clientInstance+".getLocalPlayer().getWorldLocation().getRegionID() != 13358 || (string = menuEntry.getOption().toLowerCase()).hashCode() != 974723797 && string.hashCode() != -1108625161)) {" +
									"n5 = net.runelite.api.MenuAction.CANCEL.getId();" +
								"}" +
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
}
