import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("he")
public class class208 extends class119 {
   @ObfuscatedName("ko")
   @ObfuscatedGetter(
      intValue = 1358910125
   )
   static int field2598;
   @ObfuscatedName("t")
   class102 field2595;
   @ObfuscatedName("i")
   class204 field2593;
   @ObfuscatedName("a")
   Deque field2594;

   class208(class204 var1) {
      this.field2594 = new Deque();
      this.field2595 = new class102();
      this.field2593 = var1;
   }

   @ObfuscatedName("j")
   protected void vmethod3889(int[] var1, int var2, int var3) {
      this.field2595.vmethod3889(var1, var2, var3);

      for(class205 var6 = (class205)this.field2594.getFront(); var6 != null; var6 = (class205)this.field2594.getNext()) {
         if(!this.field2593.method3700(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field2563) {
                  this.method3869(var6, var1, var4, var5, var5 + var4);
                  var6.field2563 -= var5;
                  break;
               }

               this.method3869(var6, var1, var4, var6.field2563, var5 + var4);
               var4 += var6.field2563;
               var5 -= var6.field2563;
            } while(!this.field2593.method3701(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("e")
   protected void vmethod3885(int var1) {
      this.field2595.vmethod3885(var1);

      for(class205 var3 = (class205)this.field2594.getFront(); var3 != null; var3 = (class205)this.field2594.getNext()) {
         if(!this.field2593.method3700(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field2563) {
                  this.method3870(var3, var2);
                  var3.field2563 -= var2;
                  break;
               }

               this.method3870(var3, var3.field2563);
               var2 -= var3.field2563;
            } while(!this.field2593.method3701(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("v")
   protected class119 vmethod3865() {
      class205 var1;
      do {
         var1 = (class205)this.field2594.getNext();
         if(var1 == null) {
            return null;
         }
      } while(var1.field2564 == null);

      return var1.field2564;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass205;II)V",
      garbageValue = "1238392159"
   )
   void method3870(class205 var1, int var2) {
      if((this.field2593.field2531[var1.field2559] & 4) != 0 && var1.field2560 < 0) {
         int var3 = this.field2593.field2535[var1.field2559] / FileSystem.sampleRate;
         int var4 = (var3 + 1048575 - var1.field2556) / var3;
         var1.field2556 = var3 * var2 + var1.field2556 & 1048575;
         if(var4 <= var2) {
            if(this.field2593.field2533[var1.field2559] == 0) {
               var1.field2564 = class117.method2127(var1.field2548, var1.field2564.method2207(), var1.field2564.method2133(), var1.field2564.method2134());
            } else {
               var1.field2564 = class117.method2127(var1.field2548, var1.field2564.method2207(), 0, var1.field2564.method2134());
               this.field2593.method3720(var1, var1.field2547.field2590[var1.field2551] < 0);
            }

            if(var1.field2547.field2590[var1.field2551] < 0) {
               var1.field2564.method2126(-1);
            }

            var2 = var1.field2556 / var3;
         }
      }

      var1.field2564.vmethod3885(var2);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass205;[IIIIS)V",
      garbageValue = "4898"
   )
   void method3869(class205 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field2593.field2531[var1.field2559] & 4) != 0 && var1.field2560 < 0) {
         int var6 = this.field2593.field2535[var1.field2559] / FileSystem.sampleRate;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field2556) / var6;
            if(var7 > var4) {
               var1.field2556 += var6 * var4;
               break;
            }

            var1.field2564.vmethod3889(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field2556 += var7 * var6 - 1048576;
            int var8 = FileSystem.sampleRate / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class117 var10 = var1.field2564;
            if(this.field2593.field2533[var1.field2559] == 0) {
               var1.field2564 = class117.method2127(var1.field2548, var10.method2207(), var10.method2133(), var10.method2134());
            } else {
               var1.field2564 = class117.method2127(var1.field2548, var10.method2207(), 0, var10.method2134());
               this.field2593.method3720(var1, var1.field2547.field2590[var1.field2551] < 0);
               var1.field2564.method2138(var8, var10.method2133());
            }

            if(var1.field2547.field2590[var1.field2551] < 0) {
               var1.field2564.method2126(-1);
            }

            var10.method2140(var8);
            var10.vmethod3889(var2, var3, var5 - var3);
            if(var10.method2251()) {
               this.field2595.method1890(var10);
            }
         }
      }

      var1.field2564.vmethod3889(var2, var3, var4);
   }

   @ObfuscatedName("r")
   protected class119 vmethod3864() {
      class205 var1 = (class205)this.field2594.getFront();
      return (class119)(var1 == null?null:(var1.field2564 != null?var1.field2564:this.vmethod3865()));
   }

   @ObfuscatedName("y")
   protected int vmethod3888() {
      return 0;
   }
}
