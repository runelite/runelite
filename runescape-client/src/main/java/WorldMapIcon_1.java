import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
@Implements("WorldMapIcon_1")
public class WorldMapIcon_1 extends AbstractWorldMapIcon {
	@ObfuscatedName("cp")
	@Export("mouseCam")
	static boolean mouseCam;
	@ObfuscatedName("gd")
	@Export("regionLandArchives")
	static byte[][] regionLandArchives;
	@ObfuscatedName("hv")
	@ObfuscatedGetter(
		intValue = -767824539
	)
	@Export("cameraZ")
	static int cameraZ;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -90223087
	)
	@Export("objectDefId")
	final int objectDefId;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Laa;"
	)
	@Export("region")
	final WorldMapRegion region;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1981898425
	)
	@Export("element")
	int element;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Law;"
	)
	@Export("label")
	WorldMapLabel label;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 1086525415
	)
	@Export("subWidth")
	int subWidth;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 73044895
	)
	@Export("subHeight")
	int subHeight;

	@ObfuscatedSignature(
		signature = "(Lhb;Lhb;ILaa;)V"
	)
	WorldMapIcon_1(Coord var1, Coord var2, int var3, WorldMapRegion var4) {
		super(var1, var2);
		this.objectDefId = var3;
		this.region = var4;
		this.init();
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "16"
	)
	@Export("getElement")
	public int getElement() {
		return this.element;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)Law;",
		garbageValue = "13348956"
	)
	@Export("getLabel")
	WorldMapLabel getLabel() {
		return this.label;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-175699296"
	)
	@Export("getSubWidth")
	int getSubWidth() {
		return this.subWidth;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "806304417"
	)
	@Export("getSubHeight")
	int getSubHeight() {
		return this.subHeight;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-93"
	)
	@Export("init")
	void init() {
		this.element = GrandExchangeOfferOwnWorldComparator.getObjectDefinition(this.objectDefId).transform().mapIconId;
		this.label = this.region.createMapLabel(Decimator.WorldMapElement_get(this.element));
		WorldMapElement var1 = Decimator.WorldMapElement_get(this.getElement());
		Sprite var2 = var1.getSpriteBool(false);
		if (var2 != null) {
			this.subWidth = var2.subWidth;
			this.subHeight = var2.subHeight;
		} else {
			this.subWidth = 0;
			this.subHeight = 0;
		}

	}

	@ObfuscatedName("eb")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-806150701"
	)
	static final void method314() {
		FloorOverlayDefinition.FloorOverlayDefinition_cached.clear();
		FloorUnderlayDefinition.FloorUnderlayDefinition_cached.clear();
		KitDefinition.KitDefinition_cached.clear();
		ObjectDefinition.ObjectDefinition_cached.clear();
		ObjectDefinition.ObjectDefinition_cachedModelData.clear();
		ObjectDefinition.ObjectDefinition_cachedEntities.clear();
		ObjectDefinition.ObjectDefinition_cachedModels.clear();
		NPCDefinition.NpcDefinition_cached.clear();
		NPCDefinition.NpcDefinition_cachedModels.clear();
		InterfaceParent.method1193();
		SequenceDefinition.SequenceDefinition_cached.clear();
		SequenceDefinition.SequenceDefinition_cachedFrames.clear();
		class219.method4079();
		VarbitDefinition.VarbitDefinition_cached.clear();
		MusicPatch.method3868();
		GrandExchangeEvent.method83();
		HealthBarDefinition.HealthBarDefinition_cached.clear();
		HealthBarDefinition.HealthBarDefinition_cachedSprites.clear();
		StructDefinition.StructDefinition_cached.clear();
		TextureProvider.method2746();
		WorldMapElement.WorldMapElement_cachedSprites.clear();
		UserComparator1.method5847();
		Widget.Widget_cachedSprites.clear();
		Widget.Widget_cachedModels.clear();
		Widget.Widget_cachedFonts.clear();
		Widget.Widget_cachedSpriteMasks.clear();
		((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).clear();
		Script.Script_cached.clear();
		class1.archive0.clearFiles();
		WorldMapLabelSize.archive1.clearFiles();
		BoundaryObject.archive3.clearFiles();
		GrandExchangeOfferAgeComparator.archive4.clearFiles();
		class3.archive5.clearFiles();
		class225.archive6.clearFiles();
		Language.archive7.clearFiles();
		GrandExchangeOfferAgeComparator.archive8.clearFiles();
		AttackOption.archive9.clearFiles();
		Client.archive10.clearFiles();
		ClanMate.archive11.clearFiles();
		GrandExchangeOfferOwnWorldComparator.archive12.clearFiles();
	}
}
