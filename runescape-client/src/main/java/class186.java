import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gh")
public class class186 extends class66 {
   @ObfuscatedName("t")
   class184 field3022;
   @ObfuscatedName("i")
   class199 field3023 = new class199();
   @ObfuscatedName("bb")
   static class168 field3024;
   @ObfuscatedName("g")
   class55 field3025 = new class55();

   @ObfuscatedName("f")
   protected class66 vmethod3677() {
      class187 var1;
      do {
         var1 = (class187)this.field3023.method3779();
         if(var1 == null) {
            return null;
         }
      } while(var1.field3045 == null);

      return var1.field3045;
   }

   @ObfuscatedName("s")
   protected int vmethod3678() {
      return 0;
   }

   @ObfuscatedName("d")
   protected void vmethod3679(int[] var1, int var2, int var3) {
      this.field3025.vmethod3679(var1, var2, var3);

      for(class187 var6 = (class187)this.field3023.method3797(); null != var6; var6 = (class187)this.field3023.method3779()) {
         if(!this.field3022.method3581(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field3048) {
                  this.method3681(var6, var1, var4, var5, var4 + var5);
                  var6.field3048 -= var5;
                  break;
               }

               this.method3681(var6, var1, var4, var6.field3048, var4 + var5);
               var4 += var6.field3048;
               var5 -= var6.field3048;
            } while(!this.field3022.method3582(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass187;[IIIII)V",
      garbageValue = "-1883957438"
   )
   void method3681(class187 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field3022.field2994[var1.field3043] & 4) != 0 && var1.field3041 < 0) {
         int var6 = this.field3022.field2999[var1.field3043] / class56.field1194;

         while(true) {
            int var7 = (1048575 + var6 - var1.field3047) / var6;
            if(var7 > var4) {
               var1.field3047 += var4 * var6;
               break;
            }

            var1.field3045.vmethod3679(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field3047 += var6 * var7 - 1048576;
            int var8 = class56.field1194 / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class64 var10 = var1.field3045;
            if(this.field3022.field3006[var1.field3043] == 0) {
               var1.field3045 = class64.method1340(var1.field3029, var10.method1404(), var10.method1270(), var10.method1271());
            } else {
               var1.field3045 = class64.method1340(var1.field3029, var10.method1404(), 0, var10.method1271());
               this.field3022.method3559(var1, var1.field3028.field2952[var1.field3032] < 0);
               var1.field3045.method1275(var8, var10.method1270());
            }

            if(var1.field3028.field2952[var1.field3032] < 0) {
               var1.field3045.method1266(-1);
            }

            var10.method1277(var8);
            var10.vmethod3679(var2, var3, var5 - var3);
            if(var10.method1281()) {
               this.field3025.method1094(var10);
            }
         }
      }

      var1.field3045.vmethod3679(var2, var3, var4);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass187;II)V",
      garbageValue = "-168015765"
   )
   void method3682(class187 var1, int var2) {
      if((this.field3022.field2994[var1.field3043] & 4) != 0 && var1.field3041 < 0) {
         int var3 = this.field3022.field2999[var1.field3043] / class56.field1194;
         int var4 = (var3 + 1048575 - var1.field3047) / var3;
         var1.field3047 = var2 * var3 + var1.field3047 & 1048575;
         if(var4 <= var2) {
            if(this.field3022.field3006[var1.field3043] == 0) {
               var1.field3045 = class64.method1340(var1.field3029, var1.field3045.method1404(), var1.field3045.method1270(), var1.field3045.method1271());
            } else {
               var1.field3045 = class64.method1340(var1.field3029, var1.field3045.method1404(), 0, var1.field3045.method1271());
               this.field3022.method3559(var1, var1.field3028.field2952[var1.field3032] < 0);
            }

            if(var1.field3028.field2952[var1.field3032] < 0) {
               var1.field3045.method1266(-1);
            }

            var2 = var1.field3047 / var3;
         }
      }

      var1.field3045.vmethod3686(var2);
   }

   @ObfuscatedName("y")
   protected void vmethod3686(int var1) {
      this.field3025.vmethod3686(var1);

      for(class187 var3 = (class187)this.field3023.method3797(); null != var3; var3 = (class187)this.field3023.method3779()) {
         if(!this.field3022.method3581(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field3048) {
                  this.method3682(var3, var2);
                  var3.field3048 -= var2;
                  break;
               }

               this.method3682(var3, var3.field3048);
               var2 -= var3.field3048;
            } while(!this.field3022.method3582(var3, (int[])null, 0, var2));
         }
      }

   }

   class186(class184 var1) {
      this.field3022 = var1;
   }

   @ObfuscatedName("r")
   protected class66 vmethod3695() {
      class187 var1 = (class187)this.field3023.method3797();
      return (class66)(null == var1?null:(null != var1.field3045?var1.field3045:this.vmethod3677()));
   }
}
