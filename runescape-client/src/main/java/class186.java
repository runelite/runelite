import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gg")
public class class186 extends class66 {
   @ObfuscatedName("p")
   class55 field3022 = new class55();
   @ObfuscatedName("az")
   static class168 field3023;
   @ObfuscatedName("j")
   class199 field3024 = new class199();
   @ObfuscatedName("s")
   class184 field3025;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)[Lclass130;",
      garbageValue = "63"
   )
   static class130[] method3702() {
      return new class130[]{class130.field2070, class130.field2068, class130.field2069};
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass187;II)V",
      garbageValue = "-188821037"
   )
   void method3703(class187 var1, int var2) {
      if((this.field3025.field2984[var1.field3046] & 4) != 0 && var1.field3027 < 0) {
         int var3 = this.field3025.field2998[var1.field3046] / class56.field1186;
         int var4 = (1048575 + var3 - var1.field3047) / var3;
         var1.field3047 = var3 * var2 + var1.field3047 & 1048575;
         if(var4 <= var2) {
            if(0 == this.field3025.field2986[var1.field3046]) {
               var1.field3045 = class64.method1281(var1.field3041, var1.field3045.method1296(), var1.field3045.method1354(), var1.field3045.method1346());
            } else {
               var1.field3045 = class64.method1281(var1.field3041, var1.field3045.method1296(), 0, var1.field3045.method1346());
               this.field3025.method3590(var1, var1.field3038.field2947[var1.field3031] < 0);
            }

            if(var1.field3038.field2947[var1.field3031] < 0) {
               var1.field3045.method1428(-1);
            }

            var2 = var1.field3047 / var3;
         }
      }

      var1.field3045.vmethod3707(var2);
   }

   @ObfuscatedName("o")
   protected class66 vmethod3704() {
      class187 var1;
      do {
         var1 = (class187)this.field3024.method3817();
         if(null == var1) {
            return null;
         }
      } while(var1.field3045 == null);

      return var1.field3045;
   }

   @ObfuscatedName("b")
   protected int vmethod3705() {
      return 0;
   }

   @ObfuscatedName("k")
   protected void vmethod3706(int[] var1, int var2, int var3) {
      this.field3022.vmethod3706(var1, var2, var3);

      for(class187 var4 = (class187)this.field3024.method3812(); var4 != null; var4 = (class187)this.field3024.method3817()) {
         if(!this.field3025.method3611(var4)) {
            int var5 = var2;
            int var6 = var3;

            do {
               if(var6 <= var4.field3030) {
                  this.method3708(var4, var1, var5, var6, var6 + var5);
                  var4.field3030 -= var6;
                  break;
               }

               this.method3708(var4, var1, var5, var4.field3030, var6 + var5);
               var5 += var4.field3030;
               var6 -= var4.field3030;
            } while(!this.field3025.method3640(var4, var1, var5, var6));
         }
      }

   }

   @ObfuscatedName("l")
   protected void vmethod3707(int var1) {
      this.field3022.vmethod3707(var1);

      for(class187 var2 = (class187)this.field3024.method3812(); null != var2; var2 = (class187)this.field3024.method3817()) {
         if(!this.field3025.method3611(var2)) {
            int var3 = var1;

            do {
               if(var3 <= var2.field3030) {
                  this.method3703(var2, var3);
                  var2.field3030 -= var3;
                  break;
               }

               this.method3703(var2, var2.field3030);
               var3 -= var2.field3030;
            } while(!this.field3025.method3640(var2, (int[])null, 0, var3));
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass187;[IIIII)V",
      garbageValue = "1806294273"
   )
   void method3708(class187 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field3025.field2984[var1.field3046] & 4) != 0 && var1.field3027 < 0) {
         int var6 = this.field3025.field2998[var1.field3046] / class56.field1186;

         while(true) {
            int var7 = (1048575 + var6 - var1.field3047) / var6;
            if(var7 > var4) {
               var1.field3047 += var6 * var4;
               break;
            }

            var1.field3045.vmethod3706(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field3047 += var7 * var6 - 1048576;
            int var8 = class56.field1186 / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class64 var10 = var1.field3045;
            if(0 == this.field3025.field2986[var1.field3046]) {
               var1.field3045 = class64.method1281(var1.field3041, var10.method1296(), var10.method1354(), var10.method1346());
            } else {
               var1.field3045 = class64.method1281(var1.field3041, var10.method1296(), 0, var10.method1346());
               this.field3025.method3590(var1, var1.field3038.field2947[var1.field3031] < 0);
               var1.field3045.method1430(var8, var10.method1354());
            }

            if(var1.field3038.field2947[var1.field3031] < 0) {
               var1.field3045.method1428(-1);
            }

            var10.method1439(var8);
            var10.vmethod3706(var2, var3, var5 - var3);
            if(var10.method1326()) {
               this.field3022.method1127(var10);
            }
         }
      }

      var1.field3045.vmethod3706(var2, var3, var4);
   }

   @ObfuscatedName("u")
   protected class66 vmethod3709() {
      class187 var1 = (class187)this.field3024.method3812();
      return (class66)(var1 == null?null:(null != var1.field3045?var1.field3045:this.vmethod3704()));
   }

   class186(class184 var1) {
      this.field3025 = var1;
   }
}
