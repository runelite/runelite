import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
public class class23 extends CacheableNode {
   @ObfuscatedName("n")
   int[] field593;
   @ObfuscatedName("e")
   int[] field594;
   @ObfuscatedName("t")
   String[] field596;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 2085244301
   )
   int field597;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1320422115
   )
   int field599;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 718155441
   )
   int field602;
   @ObfuscatedName("ic")
   static class32 field603;
   @ObfuscatedName("cb")
   static class146 field604;
   @ObfuscatedName("u")
   public static class231[] field606;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1965040433
   )
   int field607;
   @ObfuscatedName("f")
   static NodeCache field609 = new NodeCache(128);

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1425199415"
   )
   static final void method588(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var1 + var3; ++var4) {
         for(int var5 = var0; var5 <= var2 + var0; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class5.field81[0][var5][var4] = 127;
               if(var5 == var0 && var5 > 0) {
                  class5.tileHeights[0][var5][var4] = class5.tileHeights[0][var5 - 1][var4];
               }

               if(var5 == var2 + var0 && var5 < 103) {
                  class5.tileHeights[0][var5][var4] = class5.tileHeights[0][var5 + 1][var4];
               }

               if(var4 == var1 && var4 > 0) {
                  class5.tileHeights[0][var5][var4] = class5.tileHeights[0][var5][var4 - 1];
               }

               if(var4 == var1 + var3 && var4 < 103) {
                  class5.tileHeights[0][var5][var4] = class5.tileHeights[0][var5][var4 + 1];
               }
            }
         }
      }

   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1829003388"
   )
   @Export("groundItemSpawned")
   static final void groundItemSpawned(int var0, int var1) {
      Deque var2 = Client.groundItemDeque[XItemContainer.plane][var0][var1];
      if(null == var2) {
         class9.region.method1985(XItemContainer.plane, var0, var1);
      } else {
         long var3 = -99999999L;
         Item var5 = null;

         Item var6;
         for(var6 = (Item)var2.method3890(); var6 != null; var6 = (Item)var2.method3892()) {
            ItemComposition var7 = class45.getItemDefinition(var6.id);
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
            class9.region.method1985(XItemContainer.plane, var0, var1);
         } else {
            var2.method3910(var5);
            Item var11 = null;
            Item var10 = null;

            for(var6 = (Item)var2.method3890(); null != var6; var6 = (Item)var2.method3892()) {
               if(var5.id != var6.id) {
                  if(null == var11) {
                     var11 = var6;
                  }

                  if(var6.id != var11.id && var10 == null) {
                     var10 = var6;
                  }
               }
            }

            int var9 = 1610612736 + (var1 << 7) + var0;
            class9.region.method2040(XItemContainer.plane, var0, var1, Renderable.method1960(var0 * 128 + 64, 64 + 128 * var1, XItemContainer.plane), var5, var9, var11, var10);
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Lclass133;",
      garbageValue = "-1868984573"
   )
   public static class133 method593(int var0) {
      class133[] var1 = CollisionData.method2445();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         class133 var3 = var1[var2];
         if(var3.field2111 == var0) {
            return var3;
         }
      }

      return null;
   }
}
