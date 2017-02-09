import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
public final class class9 {
   @ObfuscatedName("qe")
   @ObfuscatedGetter(
      intValue = -2015907015
   )
   protected static int field84;
   @ObfuscatedName("ds")
   static int[] field85;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass18;I)V",
      garbageValue = "-2100988310"
   )
   static void method118(class18 var0) {
      class99.method1923(var0, 200000);
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(LSequence;IIII)V",
      garbageValue = "-24228145"
   )
   static void method119(Sequence var0, int var1, int var2, int var3) {
      if(Client.field461 < 50 && Client.field512 != 0) {
         if(null != var0.field3038 && var1 < var0.field3038.length) {
            int var4 = var0.field3038[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               Client.field473[Client.field461] = var5;
               Client.field522[Client.field461] = var6;
               Client.field533[Client.field461] = 0;
               Client.field400[Client.field461] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               Client.field524[Client.field461] = (var8 << 16) + (var9 << 8) + var7;
               ++Client.field461;
            }
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-23006"
   )
   public static void method120() {
      ItemComposition.itemSpriteCache.reset();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "-122"
   )
   static final int method121(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var0 / 4 << 10) + (var1 / 32 << 7) + var2 / 2;
      return var3;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1971426485"
   )
   static int method122(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.method2331((long)var0);
      return null == var2?-1:(var1 >= 0 && var1 < var2.itemIds.length?var2.itemIds[var1]:-1);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass182;S)V",
      garbageValue = "-23373"
   )
   public static void method123(class182 var0) {
      class195.field2848 = var0;
   }

   class9() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "77"
   )
   static void method124() {
      for(int var0 = 0; var0 < Client.menuOptionCount; ++var0) {
         if(class1.method21(Client.menuTypes[var0])) {
            if(var0 < Client.menuOptionCount - 1) {
               for(int var1 = var0; var1 < Client.menuOptionCount - 1; ++var1) {
                  Client.menuOptions[var1] = Client.menuOptions[var1 + 1];
                  Client.menuTargets[var1] = Client.menuTargets[var1 + 1];
                  Client.menuTypes[var1] = Client.menuTypes[var1 + 1];
                  Client.menuIdentifiers[var1] = Client.menuIdentifiers[1 + var1];
                  Client.menuActionParams0[var1] = Client.menuActionParams0[1 + var1];
                  Client.menuActionParams1[var1] = Client.menuActionParams1[1 + var1];
               }
            }

            --Client.menuOptionCount;
         }
      }

   }
}
