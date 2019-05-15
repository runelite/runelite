package net.runelite.client.rs.bytecode.transformers;

import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.NotFoundException;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.ClassFile;
import javassist.bytecode.ConstPool;
import net.runelite.client.rs.bytecode.ByteCodePatcher;

public class ClientTransform implements Transform
{

	private CtClass ct;

	@Override
	public void modify(Class clazz)
	{
		try
		{
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
			transformboundingBoxCheck();
			transformcheckClickBox();

			ByteCodePatcher.modifiedClasses.add(ct);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private void transformProtectedGetMenuOptions() throws CannotCompileException, NotFoundException
	{
		CtMethod protectedGetMenuOptions;

		protectedGetMenuOptions = ct.getDeclaredMethod("1protect$getMenuOptions");
		ct.removeMethod(protectedGetMenuOptions);

		protectedGetMenuOptions.setName("getMenuOptions");
		ct.addMethod(protectedGetMenuOptions);
	}

	private void transformGetProjectiles() throws CannotCompileException, NotFoundException
	{
		CtMethod getProjectiles;

		CtMethod getProjectilesDeque = ct.getDeclaredMethod("1protect$getProjectilesDeque");
		ct.removeMethod(getProjectilesDeque);

		getProjectilesDeque.setName("getProjectilesDeque");
		ct.addMethod(getProjectilesDeque);

		getProjectiles = ct.getDeclaredMethod("getProjectiles");
		ct.removeMethod(getProjectiles);

		getProjectiles = CtNewMethod.make(
			"public java.util.List getProjectiles() { " +
				"java.util.ArrayList localArrayList = new java.util.ArrayList();" +
				"net.runelite.rs.api.RSDeque localRSDeque = getProjectilesDeque();" +
				"net.runelite.rs.api.RSNode localRSNode = localRSDeque.getHead();" +
				"for (net.runelite.api.Node localNode = localRSNode.getNext(); localNode != localRSNode; localNode = localNode.getNext()) {" +
				"net.runelite.api.Projectile localProjectile = (net.runelite.api.Projectile)localNode;" +
				"localArrayList.add(localProjectile);  }" +
				"return localArrayList; }", ct);
		ct.addMethod(getProjectiles);

		ClassFile classFile = ct.getClassFile();
		ConstPool constPool = classFile.getConstPool();
		AnnotationsAttribute attr = new AnnotationsAttribute(constPool, AnnotationsAttribute.visibleTag);
		javassist.bytecode.annotation.Annotation annotation = new javassist.bytecode.annotation.Annotation("Override", constPool);
		attr.setAnnotation(annotation);
		getProjectiles.getMethodInfo().addAttribute(attr);
		System.out.println("Added override annotation for getprojectiles");
	}

	private void transformProtectedGetMenuTargets() throws CannotCompileException, NotFoundException
	{
		CtMethod protectedGetMenuTargets;

		protectedGetMenuTargets = ct.getDeclaredMethod("1protect$getMenuTargets");
		ct.removeMethod(protectedGetMenuTargets);

		protectedGetMenuTargets.setName("getMenuTargets");
		ct.addMethod(protectedGetMenuTargets);
	}

	private void transformGetCollisionMaps() throws CannotCompileException, NotFoundException
	{
		CtMethod getCollisionMaps;

		CtMethod protectedMaps = ct.getDeclaredMethod("1protect$getRsCollisionMaps");
		ct.removeMethod(protectedMaps);

		protectedMaps.setName("getRsCollisionMaps");
		ct.addMethod(protectedMaps);

		getCollisionMaps = ct.getDeclaredMethod("getCollisionMaps");
		ct.removeMethod(getCollisionMaps);

		getCollisionMaps = CtMethod.make("public net.runelite.rs.api.RSCollisionData[] getCollisionMaps() {	return getRsCollisionMaps(); }", ct);
		ct.addMethod(getCollisionMaps);
	}

	private void transformProtectedGetMenuIdentifiers() throws CannotCompileException, NotFoundException
	{
		CtMethod protectedGetMenuIdentifiers;

		protectedGetMenuIdentifiers = ct.getDeclaredMethod("1protect$getMenuIdentifiers");
		ct.removeMethod(protectedGetMenuIdentifiers);

		protectedGetMenuIdentifiers.setName("getMenuIdentifiers");
		ct.addMethod(protectedGetMenuIdentifiers);
	}

	private void transformProtectedGetMenuTypes() throws CannotCompileException, NotFoundException
	{
		CtMethod protectedGetMenuTypes;
		protectedGetMenuTypes = ct.getDeclaredMethod("1protect$getMenuTypes");

		// Don't remove as this is referenced elsewhere in client
		// ct.removeMethod(protectedGetMenuTypes);

		CtMethod newProtectedGetMenuTypes = CtNewMethod.copy(protectedGetMenuTypes, ct, null);
		newProtectedGetMenuTypes.setName("getMenuTypes");

		ct.addMethod(newProtectedGetMenuTypes);
	}

	private void transformProtectedGetMenuActionParams0() throws CannotCompileException, NotFoundException
	{
		CtMethod protectedGetMenuActionParams0;

		protectedGetMenuActionParams0 = ct.getDeclaredMethod("1protect$getMenuActionParams0");
		ct.removeMethod(protectedGetMenuActionParams0);

		protectedGetMenuActionParams0.setName("getMenuActionParams0");
		ct.addMethod(protectedGetMenuActionParams0);
	}

	private void transformProtectedGetMenuActionParams1() throws CannotCompileException, NotFoundException
	{
		CtMethod protectedGetMenuActionParams1;

		protectedGetMenuActionParams1 = ct.getDeclaredMethod("1protect$getMenuActionParams1");
		ct.removeMethod(protectedGetMenuActionParams1);
		protectedGetMenuActionParams1.setName("getMenuActionParams1");
		ct.addMethod(protectedGetMenuActionParams1);
	}

	private void transformGetMenuEntries() throws CannotCompileException, NotFoundException
	{
		CtMethod getMenuEntries;

		getMenuEntries = ct.getDeclaredMethod("getMenuEntries");
		ct.removeMethod(getMenuEntries);

		getMenuEntries = CtMethod.make(
			"public net.runelite.api.MenuEntry[] getMenuEntries()" +
				"{" +
				"	int n2 = this.getMenuOptionCount();" +
				"	String[] arrstring = this.getMenuOptions();" +
				"	String[] arrstring2 = this.getMenuTargets();" +
				"	int[] arrn = this.getMenuIdentifiers();" +
				"	int[] arrn2 = this.getMenuTypes();" +
				"	int[] arrn3 = this.getMenuActionParams0();" +
				"	int[] arrn4 = this.getMenuActionParams1();" +
				"	boolean[] arrbl = this.getMenuForceLeftClick();" +
				"	net.runelite.api.MenuEntry[] arrmenuEntry = new net.runelite.api.MenuEntry[n2];" +
				"	int n3 = 0;" +
				"	while (n3 < n2) " +
				"	{" +
				"		net.runelite.api.MenuEntry menuEntry = arrmenuEntry[n3] = new net.runelite.api.MenuEntry();" +
				"		menuEntry.setOption(arrstring[n3]);" +
				"		menuEntry.setTarget(arrstring2[n3]);" +
				"		menuEntry.setIdentifier(arrn[n3]);" +
				"		menuEntry.setType(arrn2[n3]);" +
				"		menuEntry.setParam0(arrn3[n3]);" +
				"		menuEntry.setParam1(arrn4[n3]);" +
				"		menuEntry.setForceLeftClick(arrbl[n3]);" +
				"		++n3;" +
				"	}" +
				"	return arrmenuEntry;" +
				"}", ct);
		ct.addMethod(getMenuEntries);
	}

	private void transformSetMenuEntries() throws CannotCompileException, NotFoundException
	{
		CtMethod setMenuEntries;

		setMenuEntries = ct.getDeclaredMethod("setMenuEntries");
		ct.removeMethod(setMenuEntries);
		setMenuEntries = CtNewMethod.make(
			"public void setMenuEntries(net.runelite.api.MenuEntry[] arrmenuEntry)" +
				"{" +
				"	int n2 = 0;" +
				"	String[] arrstring = this.getMenuOptions();" +
				"	String[] arrstring2 = this.getMenuTargets();" +
				"	int[] arrn = this.getMenuIdentifiers();" +
				"	int[] arrn2 = this.getMenuTypes();" +
				"	int[] arrn3 = this.getMenuActionParams0();" +
				"	int[] arrn4 = this.getMenuActionParams1();" +
				"	boolean[] arrbl = getMenuForceLeftClick();" +
				"	net.runelite.api.MenuEntry[] arrmenuEntry2 = arrmenuEntry;" +
				"	int n3 = arrmenuEntry2.length;" +
				"	int n4 = 0;" +
				"	do" +
				"	{" +
				"		String string;" +
				"		if (n4 >= n3)" +
				"		{" +
				"			this.setMenuOptionCount(n2);" +
				"			oldMenuEntryCount = n2;" +
				"			return;" +
				"		}" +
				"		net.runelite.api.MenuEntry menuEntry = arrmenuEntry2[n4];" +
				"		int n5 = menuEntry.getType();" +
				"		arrstring[n2] = menuEntry.getOption();" +
				"		arrstring2[n2] = menuEntry.getTarget();" +
				"		arrn[n2] = menuEntry.getIdentifier();" +
				"		arrn2[n2] = n5;" +
				"		arrn3[n2] = menuEntry.getParam0();" +
				"		arrn4[n2] = menuEntry.getParam1();" +
				"		arrbl[n2] = menuEntry.isForceLeftClick();" +
				"		++n2;" +
				"		++n4;" +
				"	} while (true);" +
				"}"
			, ct);
		ct.addMethod(setMenuEntries);
	}

	private void transformOnMenuOptionsChanged() throws CannotCompileException, NotFoundException
	{
		CtMethod onMenuOptionsChanged;

		onMenuOptionsChanged = ct.getDeclaredMethod("onMenuOptionsChanged", new CtClass[]{CtClass.intType});
		ct.removeMethod(onMenuOptionsChanged);

		onMenuOptionsChanged = CtMethod.make(
			"public static void onMenuOptionsChanged(int n2)" +
				"{" +
				"	int n3;" +
				"	int n4 = oldMenuEntryCount;" +
				"	oldMenuEntryCount = n3 = " + ByteCodePatcher.clientInstance + ".getMenuOptionCount();" +
				"	if (n3 != n4 + 1) return;" +
				"	net.runelite.api.events.MenuEntryAdded menuEntryAdded = new net.runelite.api.events.MenuEntryAdded(" +
					ByteCodePatcher.clientInstance + ".getMenuOptions()[n3 - 1]," +
					ByteCodePatcher.clientInstance + ".getMenuTargets()[n3 - 1]," +
					ByteCodePatcher.clientInstance + ".getMenuTypes()[n3 - 1]," +
					ByteCodePatcher.clientInstance + ".getMenuIdentifiers()[n3 - 1]," +
					ByteCodePatcher.clientInstance + ".getMenuActionParams0()[n3 - 1]," +
					ByteCodePatcher.clientInstance + ".getMenuActionParams1()[n3 - 1]);" +
					ByteCodePatcher.clientInstance + ".getCallbacks().post((Object)menuEntryAdded);" +
				"}"
			, ct);

		ct.addMethod(onMenuOptionsChanged);
	}

	private void transformRenderSelf() throws CannotCompileException
	{
		CtMethod renderSelf;

		renderSelf = CtMethod.make("public void toggleRenderSelf() { jb = !jb; }", ct);

		ClassFile classFile = ct.getClassFile();
		ConstPool constPool = classFile.getConstPool();
		AnnotationsAttribute attr = new AnnotationsAttribute(constPool, AnnotationsAttribute.visibleTag);
		javassist.bytecode.annotation.Annotation annotation = new javassist.bytecode.annotation.Annotation("Export", constPool);
		attr.setAnnotation(annotation);
		renderSelf.getMethodInfo().addAttribute(attr);

		ct.addMethod(renderSelf);
	}

	private void transformDraw2010Menu() throws CannotCompileException, NotFoundException
	{
		CtMethod draw2010Menu;

		draw2010Menu = ct.getDeclaredMethod("draw2010Menu");
		ct.removeMethod(draw2010Menu);

		draw2010Menu = CtNewMethod.make(
			"public void draw2010Menu()" +
				"{" +
				"	int n2 = this.getMenuX();" +
				"	int n3 = this.getMenuY();" +
				"	int n4 = this.getMenuWidth();" +
				"	int n5 = this.getMenuHeight();" +
				"	this.RasterizerDrawHorizontalLine(n2 + 2, n3, n4 - 4, 7170651);" +
				"	this.RasterizerDrawHorizontalLine(n2 + 2, n3 + n5 - 1, n4 - 4, 7170651);" +
				"	this.RasterizerDrawVerticalLine(n2, n3 + 2, n5 - 4, 7170651);" +
				"	this.RasterizerDrawVerticalLine(n2 + n4 - 1, n3 + 2, n5 - 4, 7170651);" +
				"	this.RasterizerDrawRectangle(n2 + 1, n3 + 5, n4 - 2, n5 - 6, 2827810);" +
				"	this.RasterizerDrawHorizontalLine(n2 + 1, n3 + 17, n4 - 2, 2827810);" +
				"	this.RasterizerDrawCircle(n2 + 2, n3 + n5 - 3, 0, 2827810);" +
				"	this.RasterizerDrawCircle(n2 + n4 - 3, n3 + n5 - 3, 0, 2827810);" +
				"	this.RasterizerDrawGradient(n2 + 2, n3 + 1, n4 - 4, 16, 3288610, 592388);" +
				"	this.RasterizerFillRectangle(n2 + 1, n3 + 1, 2, 4, 2827810);" +
				"	this.RasterizerFillRectangle(n2 + n4 - 3, n3 + 1, 2, 4, 2827810);" +
				"	this.RasterizerDrawHorizontalLine(n2 + 2, n3 + 18, n4 - 4, 5392957);" +
				"	this.RasterizerDrawHorizontalLine(n2 + 3, n3 + n5 - 3, n4 - 6, 5392957);" +
				"	this.RasterizerDrawVerticalLine(n2 + 2, n3 + 18, n5 - 21, 5392957);" +
				"	this.RasterizerDrawVerticalLine(n2 + n4 - 3, n3 + 18, n5 - 21, 5392957);" +
				"	this.RasterizerFillRectangle(n2 + 3, n3 + 19, n4 - 6, n5 - 22, 2828060);" +
				"	this.RasterizerDrawCircle(n2 + 1, n3 + 1, 0, 7170651);" +
				"	this.RasterizerDrawCircle(n2 + n4 - 2, n3 + 1, 0, 7170651);" +
				"	this.RasterizerDrawCircle(n2 + 1, n3 + n5 - 2, 0, 7170651);" +
				"	this.RasterizerDrawCircle(n2 + n4 - 2, n3 + n5 - 2, 0, 7170651);" +
				"	net.runelite.rs.api.RSFont rSFont = this.getFontBold12();" +
				"	rSFont.drawTextLeftAligned(\"Choose Option\", n2 + 3, n3 + 14, 13023381, -1);" +
				"	int n6 = this.getMouseX();" +
				"	int n7 = this.getMouseY();" +
				"	int n8 = this.getMenuOptionCount();" +
				"	String[] arrstring = this.getMenuTargets();" +
				"	String[] arrstring2 = this.getMenuOptions();" +
				"	for (int i = 0; i < n8; ++i)" +
				"	{" +
				"		int n9 = n3 + (n8 - 1 - i) * 15 + 31;" +
				"		String string = arrstring2[i];" +
				"		if (!arrstring[i].isEmpty())" +
				"		{" +
				"			string = string + \" \" + arrstring[i];" +
				"		}" +
				"		rSFont.drawTextLeftAligned(string, n2 + 3, n9, 13023381, -1);" +
				"		if (n6 <= n2 || n6 >= n4 + n2 || n7 <= n9 - 13 || n7 >= n9 + 3)" +
				"		{" +
				"			continue;" +
				"		}" +
				"		this.RasterizerFillRectangleAlpha(n2 + 3, n9 - 12, n4 - 6, 15, 16777215, 80);" +
				"	}" +
				"}"
			, ct);
		ct.addMethod(draw2010Menu);
	}

	//TODO: fix not being able to click far away objects towards top of screen only.
	private void transformboundingBoxCheck() throws CannotCompileException
	{
		CtMethod boundingboxCheck2;

		boundingboxCheck2 = CtMethod.make(
			"public boolean boundingboxCheck2(net.runelite.api.Model model, int n2, int n3, int n4)" +
				"{" +
				"	int n5 = " + ByteCodePatcher.clientInstance + ".getCameraPitch();" +
				"	int n6 = " + ByteCodePatcher.clientInstance + ".getCameraYaw();" +
				"	int n7 = net.runelite.api.Perspective.SINE[n5];" +
				"	int n8 = net.runelite.api.Perspective.COSINE[n5];" +
				"	int n9 = net.runelite.api.Perspective.SINE[n6];" +
				"	int n10 = net.runelite.api.Perspective.COSINE[n6];" +
				"	int n11 = " + ByteCodePatcher.clientInstance + ".getCenterX();" +
				"	int n12 = " + ByteCodePatcher.clientInstance + ".getCenterY();" +
				"	int n13 = " + ByteCodePatcher.clientInstance + ".getViewportMouseX();" +
				"	int n14 = " + ByteCodePatcher.clientInstance + ".getViewportMouseY();" +
				"	int n15 = " + ByteCodePatcher.clientInstance + ".get3dZoom();" +
				"	int n16 = (n13 - n11) * 50 / n15;" +
				"	int n17 = (n14 - n12) * 50 / n15;" +
				"	int n18 = (n13 - n11) * 10000 / n15;" +
				"	int n19 = (n14 - n12) * 10000 / n15;" +
				"	int n20 = client.rl$rot1(n17, 50, n8, n7);" +
				"	int n21 = client.rl$rot2(n17, 50, n8, n7);" +
				"	n17 = n20;" +
				"	n20 = client.rl$rot1(n19, 10000, n8, n7);" +
				"	int n22 = client.rl$rot2(n19, 10000, n8, n7);" +
				"	n19 = n20;" +
				"	n20 = client.rl$rot3(n16, n21, n10, n9);" +
				"	n21 = client.rl$rot4(n16, n21, n10, n9);" +
				"	n16 = n20;" +
				"	n20 = client.rl$rot3(n18, n22, n10, n9);" +
				"	n22 = client.rl$rot4(n18, n22, n10, n9);" +
				"	int n23 = (n20 - n16) / 2;" +
				"	int n24 = (n19 - n17) / 2;" +
				"	int n25 = (n22 - n21) / 2;" +
				"	int n26 = Math.abs(n23);" +
				"	int n27 = Math.abs(n24);" +
				"	int n28 = Math.abs(n25);" +
				"	int n29 = n2 + model.getCenterX();" +
				"	int n30 = n3 + model.getCenterY();" +
				"	int n31 = n4 + model.getCenterZ();" +
				"	int n32 = model.getExtremeX();" +
				"	int n33 = model.getExtremeY();" +
				"	int n34 = model.getExtremeZ();" +
				"	int n35 = (n16 + n20) / 2;" +
				"	int n36 = (n17 + n19) / 2;" +
				"	int n37 = (n22 + n21) / 2;" +
				"	int n38 = n35 - n29;" +
				"	int n39 = n36 - n30;" +
				"	int n40 = n37 - n31;" +
				"	if (Math.abs(n38) > n32 + n26)" +
				"	{" +
				"		return false;" +
				"	}" +
				"	if (Math.abs(n39) > n33 + n27)" +
				"	{" +
				"		return false;" +
				"	}" +
				"	if (Math.abs(n40) > n34 + n28)" +
				"	{" +
				"		return false;" +
				"	}" +
				"	if (Math.abs(n40 * n24 - n39 * n25) > n33 * n28 + n34 * n27)" +
				"	{" +
				"		return false;" +
				"	}" +
				"	if (Math.abs(n38 * n25 - n40 * n23) > n34 * n26 + n32 * n28)" +
				"	{" +
				"		return false;" +
				"	}" +
				"	if (Math.abs(n39 * n23 - n38 * n24) <= n33 * n26 + n32 * n27)" +
				"	{" +
				"		return true;" +
				"	}" +
				"	return false;" +
				"}", ct);
		ct.addMethod(boundingboxCheck2);
	}

	private void transformcheckClickBox() throws CannotCompileException, NotFoundException
	{
		CtMethod checkClickBox;

		checkClickBox = ct.getDeclaredMethod("checkClickbox");
		ct.removeMethod(checkClickBox);

		checkClickBox = CtMethod.make(
			"public void checkClickbox(net.runelite.api.Model model, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, long l2) {" +
				"	int n10;" +
				"	int n11;" +
				"	int n12;" +
				"	int n13;" +
				"	int n14;" +
				"	net.runelite.rs.api.RSModel rSModel = (net.runelite.rs.api.RSModel)model;" +
				"	boolean bl2 = l2 != 0L && (int)(l2 >>> 16 & 1L) != 1;" +
				"	boolean bl3 = " + ByteCodePatcher.clientInstance + ".getViewportContainsMouse();" +
				"	if (!bl2)" +
				"	{" +
				"		return;" +
				"	}" +
				"	if (!bl3)" +
				"	{" +
				"		return;" +
				"	}" +
				"	boolean bl4 = this.boundingboxCheck2((net.runelite.api.Model)rSModel, n7, n8, n9);" +
				"	if (!bl4)" +
				"	{" +
				"		return;" +
				"	}" +
				"	if (rSModel.isClickable())" +
				"	{" +
				"		this.addHashAtMouse(l2);" +
				"		return;" +
				"	}" +
				"	int n15 = rSModel.getVerticesCount();" +
				"	int n16 = rSModel.getTrianglesCount();" +
				"	int[] arrn = rSModel.getVerticesX();" +
				"	int[] arrn2 = rSModel.getVerticesY();" +
				"	int[] arrn3 = rSModel.getVerticesZ();" +
				"	int[] arrn4 = rSModel.getTrianglesX();" +
				"	int[] arrn5 = rSModel.getTrianglesY();" +
				"	int[] arrn6 = rSModel.getTrianglesZ();" +
				"	int[] arrn7 = rSModel.getFaceColors3();" +
				"	int n17 = " + ByteCodePatcher.clientInstance + ".get3dZoom();" +
				"	int n18 = " + ByteCodePatcher.clientInstance + ".getCenterX();" +
				"	int n19 = " + ByteCodePatcher.clientInstance + ".getCenterY();" +
				"	int n20 = 0;" +
				"	int n21 = 0;" +
				"	if (n2 != 0)" +
				"	{" +
				"		n20 = net.runelite.api.Perspective.SINE[n2];" +
				"		n21 = net.runelite.api.Perspective.COSINE[n2];" +
				"	}" +
				"	for (n14 = 0; n14 < n15; ++n14)" +
				"	{" +
				"		n11 = arrn[n14];" +
				"		n13 = arrn2[n14];" +
				"		n12 = arrn3[n14];" +
				"		if (n2 != 0)" +
				"		{" +
				"			n10 = n12 * n20 + n11 * n21 >> 16;" +
				"			n12 = n12 * n21 - n11 * n20 >> 16;" +
				"			n11 = n10;" +
				"		}" +
				"		n10 = (n12 += n9) * n5 + n6 * (n11 += n7) >> 16;" +
				"		n12 = n6 * n12 - n11 * n5 >> 16;" +
				"		n11 = n10;" +
				"		n10 = n4 * (n13 += n8) - n12 * n3 >> 16;" +
				"		if ((n12 = n13 * n3 + n4 * n12 >> 16) >= 50)" +
				"		{" +
				"			client.rl$modelViewportYs[n14] = n11 * n17 / n12 + n18;" +
				"			client.rl$modelViewportXs[n14] = n10 * n17 / n12 + n19;" +
				"			continue;" +
				"		}" +
				"		client.rl$modelViewportYs[n14] = -5000;" +
				"	}" +
				"	n14 = " + ByteCodePatcher.clientInstance + ".getViewportMouseX();" +
				"	n11 = " + ByteCodePatcher.clientInstance + ".getViewportMouseY();" +
				"	n13 = 0;" +
				"	while (n13 < n16)" +
				"	{" +
				"		if (arrn7[n13] != -2)" +
				"		{" +
				"			int n22;" +
				"			boolean bl5;" +
				"			int n23;" +
				"			n12 = arrn4[n13];" +
				"			n10 = arrn5[n13];" +
				"			int n24 = arrn6[n13];" +
				"			int n25 = rl$modelViewportYs[n12];" +
				"			int n26 = rl$modelViewportYs[n10];" +
				"			int n27 = rl$modelViewportYs[n24];" +
				"			int n28 = rl$modelViewportXs[n12];" +
				"			int n29 = rl$modelViewportXs[n10];" +
				"			int n30 = rl$modelViewportXs[n24];" +
				"			if (n25 != -5000 && n26 != -5000 && n27 != -5000 && (bl5 = (n23 = (n22 = rSModel.isClickable() ? 20 : 5) + n11) < n28 && n23 < n29 && n23 < n30 ? false : ((n23 = n11 - n22) > n28 && n23 > n29 && n23 > n30 ? false : ((n23 = n22 + n14) < n25 && n23 < n26 && n23 < n27 ? false : (n23 = n14 - n22) <= n25 || n23 <= n26 || n23 <= n27))))" +
				"			{" +
				"				this.addHashAtMouse(l2);" +
				"				return;" +
				"			}" +
				"		}" +
				"		++n13;" +
				"	}" +
				"}", ct);
		ct.addMethod(checkClickBox);
	}
}
