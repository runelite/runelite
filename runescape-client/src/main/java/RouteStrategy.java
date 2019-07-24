import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fl")
@Implements("RouteStrategy")
public abstract class RouteStrategy {
	@ObfuscatedName("pi")
	@ObfuscatedSignature(
		signature = "Lly;"
	)
	@Export("sceneMinimapSprite")
	static Sprite sceneMinimapSprite;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1876567169
	)
	@Export("approxDestinationX")
	public int approxDestinationX;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1051805723
	)
	@Export("approxDestinationY")
	public int approxDestinationY;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1586804307
	)
	@Export("approxDestinationSizeX")
	public int approxDestinationSizeX;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 775131021
	)
	@Export("approxDestinationSizeY")
	public int approxDestinationSizeY;

	protected RouteStrategy() {
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(IIILfv;I)Z",
		garbageValue = "-1217489379"
	)
	public abstract boolean vmethod3594(int var1, int var2, int var3, CollisionMap var4);

	@ObfuscatedName("ec")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1403573360"
	)
	static final void method3593() {
		Client.packetWriter.close();
		class197.FloorUnderlayDefinition_clearCached();
		FloorUnderlayDefinition.FloorUnderlayDefinition_cached.clear();
		KitDefinition.KitDefinition_cached.clear();
		GroundItemPile.ObjectDefinition_clearCached();
		AbstractWorldMapIcon.NpcDefinition_clearCached();
		ItemDefinition.ItemDefinition_cached.clear();
		ItemDefinition.ItemDefinition_cachedModels.clear();
		ItemDefinition.ItemDefinition_cachedSprites.clear();
		SequenceDefinition.SequenceDefinition_cached.clear();
		SequenceDefinition.SequenceDefinition_cachedFrames.clear();
		SpotAnimationDefinition.SpotAnimationDefinition_cached.clear();
		SpotAnimationDefinition.SpotAnimationDefinition_cachedModels.clear();
		MusicPatch.method3888();
		SecureRandomCallable.method1093();
		HitSplatDefinition.HitSplatDefinition_cached.clear();
		HitSplatDefinition.HitSplatDefinition_cachedSprites.clear();
		HitSplatDefinition.HitSplatDefinition_cachedFonts.clear();
		WorldMapIcon_1.HealthBarDefinition_clearCached();
		StructDefinition.StructDefinition_cached.clear();
		Coord.ParamDefinition_clearCached();
		MouseRecorder.WorldMapElement_clearCached();
		PlayerAppearance.PlayerAppearance_cachedModels.clear();
		Calendar.Widget_clearCached();
		((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).clear();
		Script.Script_cached.clear();
		class197.archive0.clearFiles();
		class167.archive1.clearFiles();
		class43.archive3.clearFiles();
		class13.archive4.clearFiles();
		WorldMapCacheName.archive5.clearFiles();
		WorldMapRegion.archive6.clearFiles();
		NPCDefinition.archive7.clearFiles();
		Client.archive8.clearFiles();
		class4.archive9.clearFiles();
		WorldMapLabelSize.archive10.clearFiles();
		class32.archive11.clearFiles();
		UserComparator4.archive12.clearFiles();
		GrandExchangeOfferWorldComparator.scene.clear();

		for (int var0 = 0; var0 < 4; ++var0) {
			Client.collisionMaps[var0].clear();
		}

		System.gc();
		class40.method729(2);
		Client.field889 = -1;
		Client.field699 = false;

		for (ObjectSound var1 = (ObjectSound)ObjectSound.objectSounds.last(); var1 != null; var1 = (ObjectSound)ObjectSound.objectSounds.previous()) {
			if (var1.stream1 != null) {
				SecureRandomCallable.pcmStreamMixer.removeSubStream(var1.stream1);
				var1.stream1 = null;
			}

			if (var1.stream2 != null) {
				SecureRandomCallable.pcmStreamMixer.removeSubStream(var1.stream2);
				var1.stream2 = null;
			}
		}

		ObjectSound.objectSounds.clear();
		class96.updateGameState(10);
	}
}
