import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ei")
@Implements("Occluder")
public final class Occluder {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1326136557
   )
   @Export("testDirection")
   int testDirection;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -635934899
   )
   @Export("minX")
   int minX;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1354932179
   )
   @Export("type")
   int type;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1378624987
   )
   @Export("minNormalX")
   int minNormalX;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 2126992827
   )
   @Export("minTileX")
   int minTileX;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1559131667
   )
   @Export("minZ")
   int minZ;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1896725377
   )
   @Export("minTileZ")
   int minTileZ;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 816476575
   )
   @Export("maxNormalX")
   int maxNormalX;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1329764337
   )
   int field2163;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1976168813
   )
   @Export("maxZ")
   int maxZ;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -905453221
   )
   @Export("minY")
   int minY;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1020194151
   )
   @Export("minNormalY")
   int minNormalY;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1079649749
   )
   int field2176;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -175446471
   )
   @Export("maxX")
   int maxX;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 861431095
   )
   @Export("maxNormalY")
   int maxNormalY;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1870417533
   )
   @Export("maxY")
   int maxY;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -888748611
   )
   @Export("maxTileZ")
   int maxTileZ;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -876061963
   )
   @Export("maxTIleX")
   int maxTIleX;

   @ObfuscatedName("gz")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "2"
   )
   @Export("groundItemSpawned")
   static final void groundItemSpawned(int var0, int var1) {
      Deque var2 = Client.groundItemDeque[WallObject.plane][var0][var1];
      if(var2 == null) {
         class2.region.method2666(WallObject.plane, var0, var1);
      } else {
         long var3 = -99999999L;
         Item var5 = null;

         Item var6;
         for(var6 = (Item)var2.getFront(); var6 != null; var6 = (Item)var2.getNext()) {
            ItemComposition var7 = AbstractByteBuffer.getItemDefinition(var6.id);
            long var8 = (long)var7.price;
            if(var7.isStackable == 1) {
               var8 *= (long)(var6.quantity + 1);
            }

            if(var8 > var3) {
               var3 = var8;
               var5 = var6;
            }
         }

         if(var5 == null) {
            class2.region.method2666(WallObject.plane, var0, var1);
         } else {
            var2.addTail(var5);
            Item var11 = null;
            Item var10 = null;

            for(var6 = (Item)var2.getFront(); var6 != null; var6 = (Item)var2.getNext()) {
               if(var6.id != var5.id) {
                  if(var11 == null) {
                     var11 = var6;
                  }

                  if(var11.id != var6.id && var10 == null) {
                     var10 = var6;
                  }
               }
            }

            int var9 = var0 + (var1 << 7) + 1610612736;
            class2.region.addItemPile(WallObject.plane, var0, var1, WorldMapData.getTileHeight(var0 * 128 + 64, var1 * 128 + 64, WallObject.plane), var5, var9, var11, var10);
         }
      }
   }
}
