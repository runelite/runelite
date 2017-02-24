import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
public class class88 {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1915393825
   )
   static int field1552;
   @ObfuscatedName("g")
   static int[] field1556;

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-717037893"
   )
   @Export("groundItemSpawned")
   static final void groundItemSpawned(int var0, int var1) {
      Deque var2 = Client.groundItemDeque[WallObject.plane][var0][var1];
      if(null == var2) {
         class48.region.method1768(WallObject.plane, var0, var1);
      } else {
         long var3 = -99999999L;
         Item var5 = null;

         Item var6;
         for(var6 = (Item)var2.method2458(); var6 != null; var6 = (Item)var2.method2472()) {
            ItemComposition var7 = class103.getItemDefinition(var6.id);
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
            class48.region.method1768(WallObject.plane, var0, var1);
         } else {
            var2.method2454(var5);
            Item var11 = null;
            Item var10 = null;

            for(var6 = (Item)var2.method2458(); var6 != null; var6 = (Item)var2.method2472()) {
               if(var6.id != var5.id) {
                  if(var11 == null) {
                     var11 = var6;
                  }

                  if(var6.id != var11.id && null == var10) {
                     var10 = var6;
                  }
               }
            }

            int var9 = 1610612736 + var0 + (var1 << 7);
            class48.region.method1754(WallObject.plane, var0, var1, class2.method19(var0 * 128 + 64, var1 * 128 + 64, WallObject.plane), var5, var9, var11, var10);
         }
      }
   }
}
