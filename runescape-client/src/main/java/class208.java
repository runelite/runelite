import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hf")
public class class208 extends class119 {
   @ObfuscatedName("v")
   public static boolean field2558;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lch;"
   )
   class102 field2556;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   class204 field2560;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lge;"
   )
   Deque field2555;

   @ObfuscatedSignature(
      signature = "(Lgl;)V"
   )
   class208(class204 var1) {
      this.field2555 = new Deque();
      this.field2556 = new class102();
      this.field2560 = var1;
   }

   @ObfuscatedName("p")
   protected void vmethod3826(int[] var1, int var2, int var3) {
      this.field2556.vmethod3826(var1, var2, var3);

      for(class205 var6 = (class205)this.field2555.getFront(); var6 != null; var6 = (class205)this.field2555.getNext()) {
         if(!this.field2560.method3676(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field2523) {
                  this.method3841(var6, var1, var4, var5, var4 + var5);
                  var6.field2523 -= var5;
                  break;
               }

               this.method3841(var6, var1, var4, var6.field2523, var5 + var4);
               var4 += var6.field2523;
               var5 -= var6.field2523;
            } while(!this.field2560.method3677(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("r")
   protected void vmethod3827(int var1) {
      this.field2556.vmethod3827(var1);

      for(class205 var3 = (class205)this.field2555.getFront(); var3 != null; var3 = (class205)this.field2555.getNext()) {
         if(!this.field2560.method3676(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field2523) {
                  this.method3822(var3, var2);
                  var3.field2523 -= var2;
                  break;
               }

               this.method3822(var3, var3.field2523);
               var2 -= var3.field2523;
            } while(!this.field2560.method3677(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "()Ldk;"
   )
   protected class119 vmethod3835() {
      class205 var1;
      do {
         var1 = (class205)this.field2555.getNext();
         if(var1 == null) {
            return null;
         }
      } while(var1.field2510 == null);

      return var1.field2510;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgz;IB)V",
      garbageValue = "-92"
   )
   void method3822(class205 var1, int var2) {
      if((this.field2560.field2490[var1.field2526] & 4) != 0 && var1.field2522 < 0) {
         int var3 = this.field2560.field2495[var1.field2526] / CombatInfo1.sampleRate;
         int var4 = (var3 + 1048575 - var1.field2528) / var3;
         var1.field2528 = var3 * var2 + var1.field2528 & 1048575;
         if(var4 <= var2) {
            if(this.field2560.field2484[var1.field2526] == 0) {
               var1.field2510 = class117.method2055(var1.field2517, var1.field2510.method2122(), var1.field2510.method2061(), var1.field2510.method2062());
            } else {
               var1.field2510 = class117.method2055(var1.field2517, var1.field2510.method2122(), 0, var1.field2510.method2062());
               this.field2560.method3654(var1, var1.field2509.field2548[var1.field2513] < 0);
            }

            if(var1.field2509.field2548[var1.field2513] < 0) {
               var1.field2510.method2057(-1);
            }

            var2 = var1.field2528 / var3;
         }
      }

      var1.field2510.vmethod3827(var2);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lgz;[IIIIS)V",
      garbageValue = "-8103"
   )
   void method3841(class205 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field2560.field2490[var1.field2526] & 4) != 0 && var1.field2522 < 0) {
         int var6 = this.field2560.field2495[var1.field2526] / CombatInfo1.sampleRate;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field2528) / var6;
            if(var7 > var4) {
               var1.field2528 += var6 * var4;
               break;
            }

            var1.field2510.vmethod3826(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field2528 += var7 * var6 - 1048576;
            int var8 = CombatInfo1.sampleRate / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class117 var10 = var1.field2510;
            if(this.field2560.field2484[var1.field2526] == 0) {
               var1.field2510 = class117.method2055(var1.field2517, var10.method2122(), var10.method2061(), var10.method2062());
            } else {
               var1.field2510 = class117.method2055(var1.field2517, var10.method2122(), 0, var10.method2062());
               this.field2560.method3654(var1, var1.field2509.field2548[var1.field2513] < 0);
               var1.field2510.method2066(var8, var10.method2061());
            }

            if(var1.field2509.field2548[var1.field2513] < 0) {
               var1.field2510.method2057(-1);
            }

            var10.method2068(var8);
            var10.vmethod3826(var2, var3, var5 - var3);
            if(var10.method2072()) {
               this.field2556.method1808(var10);
            }
         }
      }

      var1.field2510.vmethod3826(var2, var3, var4);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "()Ldk;"
   )
   protected class119 vmethod3823() {
      class205 var1 = (class205)this.field2555.getFront();
      return (class119)(var1 == null?null:(var1.field2510 != null?var1.field2510:this.vmethod3835()));
   }

   @ObfuscatedName("x")
   protected int vmethod3825() {
      return 0;
   }

   @ObfuscatedName("ip")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1795479594"
   )
   static final void method3824(int var0, int var1) {
      if(class9.loadWidget(var0)) {
         WorldMapType1.method267(Widget.widgets[var0], var1);
      }
   }

   @ObfuscatedName("o")
   public static String method3829(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(var0 % 37L == 0L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; var3 != 0L; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5 = new StringBuilder(var2);

            while(var0 != 0L) {
               long var6 = var0;
               var0 /= 37L;
               var5.append(class268.field3654[(int)(var6 - var0 * 37L)]);
            }

            return var5.reverse().toString();
         }
      } else {
         return null;
      }
   }
}
