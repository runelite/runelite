import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gk")
public class class189 extends class69 {
   @ObfuscatedName("x")
   class187 field3058;
   @ObfuscatedName("j")
   class58 field3059 = new class58();
   @ObfuscatedName("r")
   Deque field3060 = new Deque();

   @ObfuscatedName("l")
   protected class69 vmethod3746() {
      class190 var1;
      do {
         var1 = (class190)this.field3060.method3852();
         if(var1 == null) {
            return null;
         }
      } while(var1.field3067 == null);

      return var1.field3067;
   }

   @ObfuscatedName("m")
   protected int vmethod3747() {
      return 0;
   }

   @ObfuscatedName("p")
   protected void vmethod3748(int[] var1, int var2, int var3) {
      this.field3059.vmethod3748(var1, var2, var3);

      for(class190 var6 = (class190)this.field3060.method3850(); var6 != null; var6 = (class190)this.field3060.method3852()) {
         if(!this.field3058.method3657(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field3081) {
                  this.method3750(var6, var1, var4, var5, var5 + var4);
                  var6.field3081 -= var5;
                  break;
               }

               this.method3750(var6, var1, var4, var6.field3081, var4 + var5);
               var4 += var6.field3081;
               var5 -= var6.field3081;
            } while(!this.field3058.method3652(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("d")
   protected void vmethod3749(int var1) {
      this.field3059.vmethod3749(var1);

      for(class190 var3 = (class190)this.field3060.method3850(); var3 != null; var3 = (class190)this.field3060.method3852()) {
         if(!this.field3058.method3657(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field3081) {
                  this.method3757(var3, var2);
                  var3.field3081 -= var2;
                  break;
               }

               this.method3757(var3, var3.field3081);
               var2 -= var3.field3081;
            } while(!this.field3058.method3652(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass190;[IIIII)V",
      garbageValue = "-69008525"
   )
   void method3750(class190 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field3058.field3021[var1.field3070] & 4) != 0 && var1.field3076 < 0) {
         int var6 = this.field3058.field3035[var1.field3070] / class59.field1228;

         while(true) {
            int var7 = (1048575 + var6 - var1.field3082) / var6;
            if(var7 > var4) {
               var1.field3082 += var4 * var6;
               break;
            }

            var1.field3067.vmethod3748(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field3082 += var7 * var6 - 1048576;
            int var8 = class59.field1228 / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class67 var10 = var1.field3067;
            if(this.field3058.field3023[var1.field3070] == 0) {
               var1.field3067 = class67.method1343(var1.field3069, var10.method1395(), var10.method1371(), var10.method1471());
            } else {
               var1.field3067 = class67.method1343(var1.field3069, var10.method1395(), 0, var10.method1471());
               this.field3058.method3629(var1, var1.field3063.field2989[var1.field3080] < 0);
               var1.field3067.method1354(var8, var10.method1371());
            }

            if(var1.field3063.field2989[var1.field3080] < 0) {
               var1.field3067.method1345(-1);
            }

            var10.method1356(var8);
            var10.vmethod3748(var2, var3, var5 - var3);
            if(var10.method1360()) {
               this.field3059.method1179(var10);
            }
         }
      }

      var1.field3067.vmethod3748(var2, var3, var4);
   }

   @ObfuscatedName("b")
   protected class69 vmethod3753() {
      class190 var1 = (class190)this.field3060.method3850();
      return (class69)(null == var1?null:(null != var1.field3067?var1.field3067:this.vmethod3746()));
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass190;IB)V",
      garbageValue = "-101"
   )
   void method3757(class190 var1, int var2) {
      if((this.field3058.field3021[var1.field3070] & 4) != 0 && var1.field3076 < 0) {
         int var3 = this.field3058.field3035[var1.field3070] / class59.field1228;
         int var4 = (var3 + 1048575 - var1.field3082) / var3;
         var1.field3082 = var1.field3082 + var2 * var3 & 1048575;
         if(var4 <= var2) {
            if(this.field3058.field3023[var1.field3070] == 0) {
               var1.field3067 = class67.method1343(var1.field3069, var1.field3067.method1395(), var1.field3067.method1371(), var1.field3067.method1471());
            } else {
               var1.field3067 = class67.method1343(var1.field3069, var1.field3067.method1395(), 0, var1.field3067.method1471());
               this.field3058.method3629(var1, var1.field3063.field2989[var1.field3080] < 0);
            }

            if(var1.field3063.field2989[var1.field3080] < 0) {
               var1.field3067.method1345(-1);
            }

            var2 = var1.field3082 / var3;
         }
      }

      var1.field3067.vmethod3749(var2);
   }

   class189(class187 var1) {
      this.field3058 = var1;
   }
}
