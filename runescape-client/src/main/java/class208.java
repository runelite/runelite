import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hu")
public class class208 extends class119 {
   @ObfuscatedName("p")
   Deque field2594;
   @ObfuscatedName("n")
   class204 field2595;
   @ObfuscatedName("i")
   class102 field2596;

   @ObfuscatedName("m")
   protected class119 vmethod3906() {
      class205 var1 = (class205)this.field2594.method3622();
      return (class119)(var1 == null?null:(var1.field2560 != null?var1.field2560:this.vmethod3907()));
   }

   @ObfuscatedName("c")
   protected class119 vmethod3907() {
      class205 var1;
      do {
         var1 = (class205)this.field2594.method3608();
         if(var1 == null) {
            return null;
         }
      } while(var1.field2560 == null);

      return var1.field2560;
   }

   @ObfuscatedName("z")
   protected int vmethod3908() {
      return 0;
   }

   @ObfuscatedName("h")
   protected void vmethod3909(int[] var1, int var2, int var3) {
      this.field2596.vmethod3909(var1, var2, var3);

      for(class205 var6 = (class205)this.field2594.method3622(); var6 != null; var6 = (class205)this.field2594.method3608()) {
         if(!this.field2595.method3743(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field2568) {
                  this.method3919(var6, var1, var4, var5, var4 + var5);
                  var6.field2568 -= var5;
                  break;
               }

               this.method3919(var6, var1, var4, var6.field2568, var5 + var4);
               var4 += var6.field2568;
               var5 -= var6.field2568;
            } while(!this.field2595.method3744(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("e")
   protected void vmethod3910(int var1) {
      this.field2596.vmethod3910(var1);

      for(class205 var3 = (class205)this.field2594.method3622(); var3 != null; var3 = (class205)this.field2594.method3608()) {
         if(!this.field2595.method3743(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field2568) {
                  this.method3912(var3, var2);
                  var3.field2568 -= var2;
                  break;
               }

               this.method3912(var3, var3.field2568);
               var2 -= var3.field2568;
            } while(!this.field2595.method3744(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass205;II)V",
      garbageValue = "-938952540"
   )
   void method3912(class205 var1, int var2) {
      if((this.field2595.field2532[var1.field2551] & 4) != 0 && var1.field2563 < 0) {
         int var3 = this.field2595.field2537[var1.field2551] / class109.field1633;
         int var4 = (var3 + 1048575 - var1.field2549) / var3;
         var1.field2549 = var2 * var3 + var1.field2549 & 1048575;
         if(var4 <= var2) {
            if(this.field2595.field2520[var1.field2551] == 0) {
               var1.field2560 = class117.method2122(var1.field2556, var1.field2560.method2193(), var1.field2560.method2117(), var1.field2560.method2144());
            } else {
               var1.field2560 = class117.method2122(var1.field2556, var1.field2560.method2193(), 0, var1.field2560.method2144());
               this.field2595.method3721(var1, var1.field2550.field2586[var1.field2558] < 0);
            }

            if(var1.field2550.field2586[var1.field2558] < 0) {
               var1.field2560.method2124(-1);
            }

            var2 = var1.field2549 / var3;
         }
      }

      var1.field2560.vmethod3910(var2);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass205;[IIIII)V",
      garbageValue = "1679068336"
   )
   void method3919(class205 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field2595.field2532[var1.field2551] & 4) != 0 && var1.field2563 < 0) {
         int var6 = this.field2595.field2537[var1.field2551] / class109.field1633;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field2549) / var6;
            if(var7 > var4) {
               var1.field2549 += var4 * var6;
               break;
            }

            var1.field2560.vmethod3909(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field2549 += var6 * var7 - 1048576;
            int var8 = class109.field1633 / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class117 var10 = var1.field2560;
            if(this.field2595.field2520[var1.field2551] == 0) {
               var1.field2560 = class117.method2122(var1.field2556, var10.method2193(), var10.method2117(), var10.method2144());
            } else {
               var1.field2560 = class117.method2122(var1.field2556, var10.method2193(), 0, var10.method2144());
               this.field2595.method3721(var1, var1.field2550.field2586[var1.field2558] < 0);
               var1.field2560.method2133(var8, var10.method2117());
            }

            if(var1.field2550.field2586[var1.field2558] < 0) {
               var1.field2560.method2124(-1);
            }

            var10.method2135(var8);
            var10.vmethod3909(var2, var3, var5 - var3);
            if(var10.method2132()) {
               this.field2596.method1861(var10);
            }
         }
      }

      var1.field2560.vmethod3909(var2, var3, var4);
   }

   class208(class204 var1) {
      this.field2594 = new Deque();
      this.field2596 = new class102();
      this.field2595 = var1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IB)Lclass252;",
      garbageValue = "3"
   )
   public static class252 method3927(int var0) {
      class252 var1 = (class252)class252.field3403.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class252.field3401.getConfigData(34, var0);
         var1 = new class252();
         if(var2 != null) {
            var1.method4474(new Buffer(var2));
         }

         var1.method4473();
         class252.field3403.put(var1, (long)var0);
         return var1;
      }
   }
}
