import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ix")
@Implements("JagexGame")
public enum JagexGame implements Enumerated {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   field3159("runescape", "RuneScape", 0),
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   field3154("stellardawn", "Stellar Dawn", 1),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   field3155("game3", "Game 3", 2),
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   field3156("game4", "Game 4", 3),
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   field3153("game5", "Game 5", 4),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   field3158("oldscape", "RuneScape 2007", 5);

   @ObfuscatedName("h")
   @Export("name")
   public final String name;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -514214381
   )
   @Export("id")
   final int id;

   JagexGame(String var3, String var4, int var5) {
      this.name = var3;
      this.id = var5;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "60"
   )
   public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-26"
   )
   @Export("getSmoothNoise2D")
   static final int getSmoothNoise2D(int var0, int var1) {
      int var2 = MapCacheArchiveNames.method518(var0 - 1, var1 - 1) + MapCacheArchiveNames.method518(1 + var0, var1 - 1) + MapCacheArchiveNames.method518(var0 - 1, 1 + var1) + MapCacheArchiveNames.method518(1 + var0, var1 + 1);
      int var3 = MapCacheArchiveNames.method518(var0 - 1, var1) + MapCacheArchiveNames.method518(1 + var0, var1) + MapCacheArchiveNames.method518(var0, var1 - 1) + MapCacheArchiveNames.method518(var0, 1 + var1);
      int var4 = MapCacheArchiveNames.method518(var0, var1);
      return var2 / 16 + var3 / 8 + var4 / 4;
   }
}
