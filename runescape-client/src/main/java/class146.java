import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ei")
public final class class146 {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1329764337
   )
   int field2163;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -876061963
   )
   int field2164;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -888748611
   )
   int field2166;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1354932179
   )
   int field2167;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1976168813
   )
   int field2168;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -175446471
   )
   int field2169;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1559131667
   )
   int field2170;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1378624987
   )
   int field2171;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 2126992827
   )
   int field2172;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1870417533
   )
   int field2173;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1326136557
   )
   int field2174;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 816476575
   )
   int field2175;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1079649749
   )
   int field2176;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -905453221
   )
   int field2177;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 861431095
   )
   int field2178;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1020194151
   )
   int field2179;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1896725377
   )
   int field2180;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -635934899
   )
   int field2182;

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
         for(var6 = (Item)var2.method3584(); var6 != null; var6 = (Item)var2.method3578()) {
            ItemComposition var7 = class176.getItemDefinition(var6.id);
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
            var2.method3580(var5);
            Item var11 = null;
            Item var10 = null;

            for(var6 = (Item)var2.method3584(); var6 != null; var6 = (Item)var2.method3578()) {
               if(var6.id != var5.id) {
                  if(var11 == null) {
                     var11 = var6;
                  }

                  if(var6.id != var11.id && var10 == null) {
                     var10 = var6;
                  }
               }
            }

            int var9 = var0 + (var1 << 7) + 1610612736;
            class2.region.method2822(WallObject.plane, var0, var1, WorldMapData.method343(var0 * 128 + 64, var1 * 128 + 64, WallObject.plane), var5, var9, var11, var10);
         }
      }
   }
}
