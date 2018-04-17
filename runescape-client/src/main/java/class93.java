import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ca")
public class class93 {
   @ObfuscatedName("t")
   static byte[] field1428;
   @ObfuscatedName("d")
   static byte[] field1429;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "[Lgc;"
   )
   static Buffer[] field1430;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 269820015
   )
   @Export("playerIndexesCount")
   static int playerIndexesCount;
   @ObfuscatedName("z")
   @Export("playerIndices")
   static int[] playerIndices;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 248237131
   )
   static int field1433;
   @ObfuscatedName("u")
   static int[] field1435;
   @ObfuscatedName("x")
   @Export("Players_regions")
   static int[] Players_regions;
   @ObfuscatedName("y")
   @Export("Players_orientations")
   static int[] Players_orientations;
   @ObfuscatedName("a")
   @Export("Players_targetIndices")
   static int[] Players_targetIndices;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -325787373
   )
   static int field1438;
   @ObfuscatedName("n")
   static int[] field1439;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   static Buffer field1432;
   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   @Export("indexSoundEffects")
   static IndexData indexSoundEffects;

   static {
      field1428 = new byte[2048];
      field1429 = new byte[2048];
      field1430 = new Buffer[2048];
      playerIndexesCount = 0;
      playerIndices = new int[2048];
      field1433 = 0;
      field1435 = new int[2048];
      Players_regions = new int[2048];
      Players_orientations = new int[2048];
      Players_targetIndices = new int[2048];
      field1438 = 0;
      field1439 = new int[2048];
      field1432 = new Buffer(new byte[5000]);
   }
}
