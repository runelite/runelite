import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
@Implements("Occluder")
public final class Occluder {
   @ObfuscatedName("eo")
   @Export("rssocket")
   static RSSocket rssocket;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -2011790505
   )
   @Export("testDirection")
   int testDirection;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1631809755
   )
   @Export("minX")
   int minX;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -275803047
   )
   @Export("type")
   int type;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -935818403
   )
   @Export("minNormalX")
   int minNormalX;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 947857959
   )
   @Export("minTileX")
   int minTileX;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1656003067
   )
   @Export("minZ")
   int minZ;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -91598111
   )
   @Export("minTileZ")
   int minTileZ;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -348823123
   )
   @Export("maxNormalX")
   int maxNormalX;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1650635419
   )
   int field2152;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1799084335
   )
   @Export("maxZ")
   int maxZ;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -934787641
   )
   @Export("minY")
   int minY;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1953113309
   )
   @Export("minNormalY")
   int minNormalY;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -973795785
   )
   int field2153;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -965493659
   )
   @Export("maxX")
   int maxX;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1464645297
   )
   @Export("maxNormalY")
   int maxNormalY;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -2075134731
   )
   @Export("maxY")
   int maxY;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -134272417
   )
   @Export("maxTileZ")
   int maxTileZ;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -454761341
   )
   @Export("maxTIleX")
   int maxTIleX;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILIndexFile;LIndexData;B)V",
      garbageValue = "23"
   )
   static void method2888(int var0, IndexFile var1, IndexData var2) {
      byte[] var3 = null;
      Deque var4 = class236.field3235;
      synchronized(class236.field3235) {
         for(FileSystem var5 = (FileSystem)class236.field3235.getFront(); var5 != null; var5 = (FileSystem)class236.field3235.getNext()) {
            if(var5.hash == (long)var0 && var1 == var5.index && var5.field3204 == 0) {
               var3 = var5.field3202;
               break;
            }
         }
      }

      if(var3 != null) {
         var2.method4179(var1, var0, var3, true);
      } else {
         byte[] var8 = var1.method3011(var0);
         var2.method4179(var1, var0, var8, true);
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;I)V",
      garbageValue = "1570497041"
   )
   public static void method2887(IndexDataBase var0, IndexDataBase var1) {
      CombatInfo2.field3373 = var0;
      class293.field3898 = var1;
   }
}
