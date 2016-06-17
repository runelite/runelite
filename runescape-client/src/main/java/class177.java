import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fr")
public class class177 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -2084941825
   )
   public static int field2903;
   @ObfuscatedName("er")
   static class80[] field2905;
   @ObfuscatedName("w")
   public static class59 field2906;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass119;IIIIIIB)V",
      garbageValue = "8"
   )
   static final void method3464(class119 var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class5.field69[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.method2514();
            if(var7 == 0) {
               if(var1 == 0) {
                  class5.field83[0][var2][var3] = -class14.method162(var2 + 932731 + var4, var5 + var3 + 556238) * 8;
               } else {
                  class5.field83[var1][var2][var3] = class5.field83[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var8 = var0.method2514();
               if(var8 == 1) {
                  var8 = 0;
               }

               if(var1 == 0) {
                  class5.field83[0][var2][var3] = 8 * -var8;
               } else {
                  class5.field83[var1][var2][var3] = class5.field83[var1 - 1][var2][var3] - var8 * 8;
               }
               break;
            }

            if(var7 <= 49) {
               class5.field72[var1][var2][var3] = var0.method2515();
               class5.field73[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class49.field1067[var1][var2][var3] = (byte)(var6 + (var7 - 2) & 3);
            } else if(var7 <= 81) {
               class5.field69[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class5.field71[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.method2514();
            if(var7 == 0) {
               break;
            }

            if(var7 == 1) {
               var0.method2514();
               break;
            }

            if(var7 <= 49) {
               var0.method2514();
            }
         }
      }

   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-10282"
   )
   static final void method3468(int var0) {
      if(var0 >= 0) {
         int var1 = client.field419[var0];
         int var2 = client.field431[var0];
         int var3 = client.field432[var0];
         int var4 = client.field433[var0];
         String var5 = client.field434[var0];
         String var6 = client.field396[var0];
         class96.method2198(var1, var2, var3, var4, var5, var6, class140.field2141, class140.field2142);
      }
   }
}
