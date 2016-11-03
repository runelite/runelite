import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gw")
public class class189 extends class69 {
   @ObfuscatedName("q")
   Deque field3055 = new Deque();
   @ObfuscatedName("k")
   class187 field3056;
   @ObfuscatedName("f")
   class58 field3057 = new class58();

   @ObfuscatedName("j")
   protected class69 vmethod3751() {
      class190 var1 = (class190)this.field3055.method3864();
      return (class69)(var1 == null?null:(null != var1.field3076?var1.field3076:this.vmethod3755()));
   }

   class189(class187 var1) {
      this.field3056 = var1;
   }

   @ObfuscatedName("l")
   protected void vmethod3754(int var1) {
      this.field3057.vmethod3754(var1);

      for(class190 var3 = (class190)this.field3055.method3864(); var3 != null; var3 = (class190)this.field3055.method3851()) {
         if(!this.field3056.method3673(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field3077) {
                  this.method3756(var3, var2);
                  var3.field3077 -= var2;
                  break;
               }

               this.method3756(var3, var3.field3077);
               var2 -= var3.field3077;
            } while(!this.field3056.method3674(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("m")
   protected class69 vmethod3755() {
      class190 var1;
      do {
         var1 = (class190)this.field3055.method3851();
         if(var1 == null) {
            return null;
         }
      } while(var1.field3076 == null);

      return var1.field3076;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass190;II)V",
      garbageValue = "268206987"
   )
   void method3756(class190 var1, int var2) {
      if((this.field3056.field3035[var1.field3071] & 4) != 0 && var1.field3061 < 0) {
         int var3 = this.field3056.field3032[var1.field3071] / class59.field1249;
         int var4 = (var3 + 1048575 - var1.field3078) / var3;
         var1.field3078 = var2 * var3 + var1.field3078 & 1048575;
         if(var4 <= var2) {
            if(this.field3056.field3037[var1.field3071] == 0) {
               var1.field3076 = class67.method1463(var1.field3060, var1.field3076.method1360(), var1.field3076.method1399(), var1.field3076.method1346());
            } else {
               var1.field3076 = class67.method1463(var1.field3060, var1.field3076.method1360(), 0, var1.field3076.method1346());
               this.field3056.method3725(var1, var1.field3059.field2982[var1.field3063] < 0);
            }

            if(var1.field3059.field2982[var1.field3063] < 0) {
               var1.field3076.method1347(-1);
            }

            var2 = var1.field3078 / var3;
         }
      }

      var1.field3076.vmethod3754(var2);
   }

   @ObfuscatedName("y")
   protected int vmethod3758() {
      return 0;
   }

   @ObfuscatedName("u")
   protected void vmethod3766(int[] var1, int var2, int var3) {
      this.field3057.vmethod3766(var1, var2, var3);

      for(class190 var6 = (class190)this.field3055.method3864(); var6 != null; var6 = (class190)this.field3055.method3851()) {
         if(!this.field3056.method3673(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field3077) {
                  this.method3770(var6, var1, var4, var5, var5 + var4);
                  var6.field3077 -= var5;
                  break;
               }

               this.method3770(var6, var1, var4, var6.field3077, var4 + var5);
               var4 += var6.field3077;
               var5 -= var6.field3077;
            } while(!this.field3056.method3674(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass190;[IIIIS)V",
      garbageValue = "19833"
   )
   void method3770(class190 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field3056.field3035[var1.field3071] & 4) != 0 && var1.field3061 < 0) {
         int var6 = this.field3056.field3032[var1.field3071] / class59.field1249;

         while(true) {
            int var7 = (1048575 + var6 - var1.field3078) / var6;
            if(var7 > var4) {
               var1.field3078 += var6 * var4;
               break;
            }

            var1.field3076.vmethod3766(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field3078 += var6 * var7 - 1048576;
            int var8 = class59.field1249 / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class67 var10 = var1.field3076;
            if(this.field3056.field3037[var1.field3071] == 0) {
               var1.field3076 = class67.method1463(var1.field3060, var10.method1360(), var10.method1399(), var10.method1346());
            } else {
               var1.field3076 = class67.method1463(var1.field3060, var10.method1360(), 0, var10.method1346());
               this.field3056.method3725(var1, var1.field3059.field2982[var1.field3063] < 0);
               var1.field3076.method1356(var8, var10.method1399());
            }

            if(var1.field3059.field2982[var1.field3063] < 0) {
               var1.field3076.method1347(-1);
            }

            var10.method1358(var8);
            var10.vmethod3766(var2, var3, var5 - var3);
            if(var10.method1394()) {
               this.field3057.method1176(var10);
            }
         }
      }

      var1.field3076.vmethod3766(var2, var3, var4);
   }
}
