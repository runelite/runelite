import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
@Implements("Renderable")
public abstract class class85 extends class204 {
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = -2045931643
   )
   @Export("modelHeight")
   public int field1443 = 1000;

   @ObfuscatedName("au")
   void vmethod2301(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      class105 var10 = this.vmethod1900();
      if(var10 != null) {
         this.field1443 = var10.field1443;
         var10.vmethod2301(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Lclass105;",
      garbageValue = "-1145523992"
   )
   protected class105 vmethod1900() {
      return null;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I[BLclass134;I)V",
      garbageValue = "1941516908"
   )
   static void method1901(int var0, byte[] var1, class134 var2) {
      class169 var3 = new class169();
      var3.field2694 = 0;
      var3.field3122 = (long)var0;
      var3.field2693 = var1;
      var3.field2699 = var2;
      class199 var4 = class170.field2702;
      synchronized(class170.field2702) {
         class170.field2702.method3779(var3);
      }

      class162.method3163();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass119;IIIIIII)V",
      garbageValue = "1197185579"
   )
   static final void method1902(class119 var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class5.field84[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.method2500();
            if(var7 == 0) {
               if(var1 == 0) {
                  class5.field91[0][var2][var3] = -class46.method953(var4 + 932731 + var2, var5 + 556238 + var3) * 8;
               } else {
                  class5.field91[var1][var2][var3] = class5.field91[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(1 == var7) {
               int var8 = var0.method2500();
               if(1 == var8) {
                  var8 = 0;
               }

               if(0 == var1) {
                  class5.field91[0][var2][var3] = 8 * -var8;
               } else {
                  class5.field91[var1][var2][var3] = class5.field91[var1 - 1][var2][var3] - 8 * var8;
               }
               break;
            }

            if(var7 <= 49) {
               class5.field87[var1][var2][var3] = var0.method2670();
               class51.field1138[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class5.field88[var1][var2][var3] = (byte)(var7 - 2 + var6 & 3);
            } else if(var7 <= 81) {
               class5.field84[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class5.field100[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.method2500();
            if(var7 == 0) {
               break;
            }

            if(1 == var7) {
               var0.method2500();
               break;
            }

            if(var7 <= 49) {
               var0.method2500();
            }
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Lclass40;",
      garbageValue = "50912481"
   )
   public static class40 method1903(int var0) {
      class40 var1 = (class40)class40.field932.method3704((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class40.field905.method3217(6, var0);
         var1 = new class40();
         var1.field924 = var0;
         if(var2 != null) {
            var1.method825(new class119(var2));
         }

         var1.method790();
         if(var1.field944) {
            var1.field922 = 0;
            var1.field923 = false;
         }

         class40.field932.method3706(var1, (long)var0);
         return var1;
      }
   }
}
