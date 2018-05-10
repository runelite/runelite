import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
public class class81 {
   @ObfuscatedName("q")
   static byte[] field1183;
   @ObfuscatedName("b")
   static byte[] field1177;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "[Lgy;"
   )
   static Buffer[] field1179;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1358551967
   )
   @Export("playerIndexesCount")
   static int playerIndexesCount;
   @ObfuscatedName("h")
   @Export("playerIndices")
   static int[] playerIndices;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1972551019
   )
   static int field1182;
   @ObfuscatedName("j")
   static int[] field1175;
   @ObfuscatedName("a")
   @Export("Players_regions")
   static int[] Players_regions;
   @ObfuscatedName("l")
   @Export("Players_orientations")
   static int[] Players_orientations;
   @ObfuscatedName("d")
   @Export("Players_targetIndices")
   static int[] Players_targetIndices;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1296694293
   )
   static int field1176;
   @ObfuscatedName("p")
   static int[] field1188;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgy;"
   )
   static Buffer field1189;
   @ObfuscatedName("r")
   static int[] field1178;
   @ObfuscatedName("dm")
   @ObfuscatedGetter(
      intValue = 1649712923
   )
   static int field1192;
   @ObfuscatedName("fx")
   @ObfuscatedSignature(
      signature = "[Llc;"
   )
   @Export("mapDots")
   static SpritePixels[] mapDots;

   static {
      field1183 = new byte[2048];
      field1177 = new byte[2048];
      field1179 = new Buffer[2048];
      playerIndexesCount = 0;
      playerIndices = new int[2048];
      field1182 = 0;
      field1175 = new int[2048];
      Players_regions = new int[2048];
      Players_orientations = new int[2048];
      Players_targetIndices = new int[2048];
      field1176 = 0;
      field1188 = new int[2048];
      field1189 = new Buffer(new byte[5000]);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;Ljava/io/File;I)V",
      garbageValue = "1970983576"
   )
   public static void method1921(File var0, File var1) {
      try {
         FileOnDisk var2 = new FileOnDisk(class155.jagexClDat, "rw", 10000L);
         Buffer var3 = new Buffer(500);
         var3.putByte(3);
         var3.putByte(var1 != null?1:0);
         var3.putCESU8(var0.getPath());
         if(var1 != null) {
            var3.putCESU8("");
         }

         var2.write(var3.payload, 0, var3.offset);
         var2.close();
      } catch (IOException var4) {
         var4.printStackTrace();
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Liv;Liv;Liv;B)V",
      garbageValue = "-124"
   )
   public static void method1923(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2) {
      class267.field3386 = var0;
      class177.field2314 = var1;
      class267.field3366 = var2;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "983127599"
   )
   @Export("nextPowerOfTwo")
   public static int nextPowerOfTwo(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return var0 + 1;
   }
}
