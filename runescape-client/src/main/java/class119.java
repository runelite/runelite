import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dq")
public abstract class class119 {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 579596225
   )
   public int field1837;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1350491353
   )
   public int field1838;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 446910417
   )
   public int field1840;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -593998597
   )
   public int field1841;
   @ObfuscatedName("bl")
   static class184 field1843;
   @ObfuscatedName("g")
   static byte[][] field1845;

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-149407552"
   )
   static void method2275(int var0, int var1, int var2) {
      if(Client.field358 != 0 && var1 != 0 && Client.field516 < 50) {
         Client.field500[Client.field516] = var0;
         Client.field292[Client.field516] = var1;
         Client.field526[Client.field516] = var2;
         Client.field528[Client.field516] = null;
         Client.field527[Client.field516] = 0;
         ++Client.field516;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIILCollisionData;I)Z",
      garbageValue = "703014920"
   )
   protected abstract boolean vmethod2276(int var1, int var2, int var3, CollisionData var4);

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "8"
   )
   static final void method2278() {
      for(int var0 = 0; var0 < Client.field516; ++var0) {
         --Client.field526[var0];
         if(Client.field526[var0] >= -10) {
            class53 var9 = Client.field528[var0];
            if(null == var9) {
               Object var2 = null;
               var9 = class53.method955(class10.field94, Client.field500[var0], 0);
               if(null == var9) {
                  continue;
               }

               Client.field526[var0] += var9.method950();
               Client.field528[var0] = var9;
            }

            if(Client.field526[var0] < 0) {
               int var10;
               if(Client.field527[var0] != 0) {
                  int var3 = (Client.field527[var0] & 255) * 128;
                  int var4 = Client.field527[var0] >> 16 & 255;
                  int var5 = 64 + var4 * 128 - class148.localPlayer.x;
                  if(var5 < 0) {
                     var5 = -var5;
                  }

                  int var6 = Client.field527[var0] >> 8 & 255;
                  int var7 = 128 * var6 + 64 - class148.localPlayer.y;
                  if(var7 < 0) {
                     var7 = -var7;
                  }

                  int var8 = var5 + var7 - 128;
                  if(var8 > var3) {
                     Client.field526[var0] = -100;
                     continue;
                  }

                  if(var8 < 0) {
                     var8 = 0;
                  }

                  var10 = (var3 - var8) * Client.field557 / var3;
               } else {
                  var10 = Client.field358;
               }

               if(var10 > 0) {
                  class55 var11 = var9.method953().method994(class140.field1961);
                  class66 var12 = class66.method1130(var11, 100, var10);
                  var12.method1133(Client.field292[var0] - 1);
                  class20.field222.method889(var12);
               }

               Client.field526[var0] = -100;
            }
         } else {
            --Client.field516;

            for(int var1 = var0; var1 < Client.field516; ++var1) {
               Client.field500[var1] = Client.field500[1 + var1];
               Client.field528[var1] = Client.field528[1 + var1];
               Client.field292[var1] = Client.field292[1 + var1];
               Client.field526[var1] = Client.field526[var1 + 1];
               Client.field527[var1] = Client.field527[var1 + 1];
            }

            --var0;
         }
      }

      if(Client.field519 && !class20.method193()) {
         if(Client.field517 != 0 && Client.field444 != -1) {
            class107.method2001(class37.field781, Client.field444, 0, Client.field517, false);
         }

         Client.field519 = false;
      }

   }
}
