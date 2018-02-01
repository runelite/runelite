import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
public class class92 {
   @ObfuscatedName("w")
   static byte[] field1375;
   @ObfuscatedName("s")
   static byte[] field1383;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "[Lgj;"
   )
   static Buffer[] field1377;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1280364333
   )
   @Export("playerIndexesCount")
   static int playerIndexesCount;
   @ObfuscatedName("t")
   @Export("playerIndices")
   static int[] playerIndices;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1191705189
   )
   static int field1373;
   @ObfuscatedName("m")
   static int[] field1384;
   @ObfuscatedName("h")
   @Export("Players_regions")
   static int[] Players_regions;
   @ObfuscatedName("o")
   @Export("Players_orientations")
   static int[] Players_orientations;
   @ObfuscatedName("x")
   @Export("Players_targetIndices")
   static int[] Players_targetIndices;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1313958243
   )
   static int field1385;
   @ObfuscatedName("v")
   static int[] field1376;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   static Buffer field1387;
   @ObfuscatedName("fo")
   @ObfuscatedSignature(
      signature = "Lko;"
   )
   @Export("mapedge")
   static SpritePixels mapedge;

   static {
      field1375 = new byte[2048];
      field1383 = new byte[2048];
      field1377 = new Buffer[2048];
      playerIndexesCount = 0;
      playerIndices = new int[2048];
      field1373 = 0;
      field1384 = new int[2048];
      Players_regions = new int[2048];
      Players_orientations = new int[2048];
      Players_targetIndices = new int[2048];
      field1385 = 0;
      field1376 = new int[2048];
      field1387 = new Buffer(new byte[5000]);
   }
}
