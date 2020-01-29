import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
public class class30 {
	@ObfuscatedName("sj")
	@ObfuscatedGetter(
		longValue = -3315031402315742045L
	)
	static long field274;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Laj;"
	)
	static final class30 field270;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Laj;"
	)
	static final class30 field271;
	@ObfuscatedName("h")
	@Export("Tiles_lightness")
	static int[] Tiles_lightness;
	@ObfuscatedName("gy")
	@Export("regionMapArchiveIds")
	static int[] regionMapArchiveIds;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 404466751
	)
	@Export("value")
	final int value;

	static {
		field270 = new class30(0);
		field271 = new class30(1);
	}

	class30(int var1) {
		this.value = var1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)J",
		garbageValue = "25"
	)
	static long method567() {
		try {
			URL var0 = new URL(class42.method809("services", false) + "m=accountappeal/login.ws");
			URLConnection var1 = var0.openConnection();
			var1.setRequestProperty("connection", "close");
			var1.setDoInput(true);
			var1.setDoOutput(true);
			var1.setConnectTimeout(5000);
			OutputStreamWriter var2 = new OutputStreamWriter(var1.getOutputStream());
			var2.write("data1=req");
			var2.flush();
			InputStream var3 = var1.getInputStream();
			Buffer var4 = new Buffer(new byte[1000]);

			do {
				int var5 = var3.read(var4.array, var4.offset, 1000 - var4.offset);
				if (var5 == -1) {
					var4.offset = 0;
					long var7 = var4.readLong();
					return var7;
				}

				var4.offset += var5;
			} while(var4.offset < 1000);

			return 0L;
		} catch (Exception var9) {
			return 0L;
		}
	}

	@ObfuscatedName("fm")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1945263247"
	)
	@Export("logOut")
	static final void logOut() {
		Client.packetWriter.close();
		Skeleton.method3152();
		FloorUnderlayDefinition.FloorUnderlayDefinition_cached.clear();
		FontName.method5402();
		ObjectDefinition.ObjectDefinition_cached.clear();
		ObjectDefinition.ObjectDefinition_cachedModelData.clear();
		ObjectDefinition.ObjectDefinition_cachedEntities.clear();
		ObjectDefinition.ObjectDefinition_cachedModels.clear();
		NPCDefinition.NpcDefinition_cached.clear();
		NPCDefinition.NpcDefinition_cachedModels.clear();
		ItemDefinition.ItemDefinition_cached.clear();
		ItemDefinition.ItemDefinition_cachedModels.clear();
		ItemDefinition.ItemDefinition_cachedSprites.clear();
		SequenceDefinition.SequenceDefinition_cached.clear();
		SequenceDefinition.SequenceDefinition_cachedFrames.clear();
		WorldMapData_0.method181();
		WorldMapSection2.method342();
		WorldMapCacheName.method635();
		HitSplatDefinition.HitSplatDefinition_cached.clear();
		HitSplatDefinition.HitSplatDefinition_cachedSprites.clear();
		HitSplatDefinition.HitSplatDefinition_cachedFonts.clear();
		HealthBarDefinition.HealthBarDefinition_cached.clear();
		HealthBarDefinition.HealthBarDefinition_cachedSprites.clear();
		UserComparator7.method3481();
		class215.method4095();
		WallDecoration.method3359();
		PlayerAppearance.PlayerAppearance_cachedModels.clear();
		MilliClock.method3535();
		((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).clear();
		Script.Script_cached.clear();
		GrandExchangeEvent.archive0.clearFiles();
		class65.archive1.clearFiles();
		class267.archive3.clearFiles();
		Client.archive4.clearFiles();
		NetSocket.archive5.clearFiles();
		MouseHandler.archive6.clearFiles();
		BuddyRankComparator.archive7.clearFiles();
		UserComparator8.archive8.clearFiles();
		GrandExchangeOfferNameComparator.archive9.clearFiles();
		HealthBar.archive10.clearFiles();
		GrandExchangeOffer.archive11.clearFiles();
		MilliClock.archive12.clearFiles();
		ServerBuild.scene.clear();

		for (int var0 = 0; var0 < 4; ++var0) {
			Client.collisionMaps[var0].clear();
		}

		System.gc();
		class197.field2414 = 1;
		UserComparator5.musicTrackArchive = null;
		class197.musicTrackGroupId = -1;
		class83.musicTrackFileId = -1;
		AttackOption.musicTrackVolume = 0;
		KeyHandler.musicTrackBoolean = false;
		class197.field2412 = 2;
		Client.currentTrackGroupId = -1;
		Client.field881 = false;
		UrlRequest.method3375();
		Projectile.updateGameState(10);
	}
}
