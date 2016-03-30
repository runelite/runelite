import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gf")
public class class186 extends class66 {
   @ObfuscatedName("t")
   class199 field3012 = new class199();
   @ObfuscatedName("x")
   class184 field3013;
   @ObfuscatedName("p")
   class55 field3014 = new class55();

   @ObfuscatedName("y")
   protected class66 vmethod3729() {
      class187 var1 = (class187)this.field3012.method3836();
      return (class66)(var1 == null?null:(var1.field3033 != null?var1.field3033:this.vmethod3749()));
   }

   @ObfuscatedName("v")
   protected void vmethod3733(int[] var1, int var2, int var3) {
      this.field3014.vmethod3733(var1, var2, var3);

      for(class187 var6 = (class187)this.field3012.method3836(); null != var6; var6 = (class187)this.field3012.method3841()) {
         if(!this.field3013.method3649(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field3034) {
                  this.method3735(var6, var1, var4, var5, var5 + var4);
                  var6.field3034 -= var5;
                  break;
               }

               this.method3735(var6, var1, var4, var6.field3034, var4 + var5);
               var4 += var6.field3034;
               var5 -= var6.field3034;
            } while(!this.field3013.method3714(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("z")
   protected void vmethod3734(int var1) {
      this.field3014.vmethod3734(var1);

      for(class187 var3 = (class187)this.field3012.method3836(); var3 != null; var3 = (class187)this.field3012.method3841()) {
         if(!this.field3013.method3649(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field3034) {
                  this.method3736(var3, var2);
                  var3.field3034 -= var2;
                  break;
               }

               this.method3736(var3, var3.field3034);
               var2 -= var3.field3034;
            } while(!this.field3013.method3714(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass187;[IIIII)V",
      garbageValue = "365251423"
   )
   void method3735(class187 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field3013.field3000[var1.field3026] & 4) != 0 && var1.field3020 < 0) {
         int var6 = this.field3013.field2994[var1.field3026] / class129.field2058;

         while(true) {
            int var7 = (1048575 + var6 - var1.field3031) / var6;
            if(var7 > var4) {
               var1.field3031 += var6 * var4;
               break;
            }

            var1.field3033.vmethod3733(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field3031 += var7 * var6 - 1048576;
            int var8 = class129.field2058 / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class64 var10 = var1.field3033;
            if(this.field3013.field2986[var1.field3026] == 0) {
               var1.field3033 = class64.method1319(var1.field3017, var10.method1442(), var10.method1325(), var10.method1326());
            } else {
               var1.field3033 = class64.method1319(var1.field3017, var10.method1442(), 0, var10.method1326());
               this.field3013.method3627(var1, var1.field3016.field2940[var1.field3037] < 0);
               var1.field3033.method1330(var8, var10.method1325());
            }

            if(var1.field3016.field2940[var1.field3037] < 0) {
               var1.field3033.method1322(-1);
            }

            var10.method1332(var8);
            var10.vmethod3733(var2, var3, var5 - var3);
            if(var10.method1335()) {
               this.field3014.method1188(var10);
            }
         }
      }

      var1.field3033.vmethod3733(var2, var3, var4);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass187;IB)V",
      garbageValue = "6"
   )
   void method3736(class187 var1, int var2) {
      if(0 != (this.field3013.field3000[var1.field3026] & 4) && var1.field3020 < 0) {
         int var3 = this.field3013.field2994[var1.field3026] / class129.field2058;
         int var4 = (var3 + 1048575 - var1.field3031) / var3;
         var1.field3031 = var2 * var3 + var1.field3031 & 1048575;
         if(var4 <= var2) {
            if(this.field3013.field2986[var1.field3026] == 0) {
               var1.field3033 = class64.method1319(var1.field3017, var1.field3033.method1442(), var1.field3033.method1325(), var1.field3033.method1326());
            } else {
               var1.field3033 = class64.method1319(var1.field3017, var1.field3033.method1442(), 0, var1.field3033.method1326());
               this.field3013.method3627(var1, var1.field3016.field2940[var1.field3037] < 0);
            }

            if(var1.field3016.field2940[var1.field3037] < 0) {
               var1.field3033.method1322(-1);
            }

            var2 = var1.field3031 / var3;
         }
      }

      var1.field3033.vmethod3734(var2);
   }

   @ObfuscatedName("c")
   protected int vmethod3745() {
      return 0;
   }

   class186(class184 var1) {
      this.field3013 = var1;
   }

   @ObfuscatedName("m")
   protected class66 vmethod3749() {
      class187 var1;
      do {
         var1 = (class187)this.field3012.method3841();
         if(null == var1) {
            return null;
         }
      } while(null == var1.field3033);

      return var1.field3033;
   }
}
