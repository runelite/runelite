import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gb")
public class class189 extends class69 {
   @ObfuscatedName("qq")
   @ObfuscatedGetter(
      intValue = -906707721
   )
   public static int field3056;
   @ObfuscatedName("g")
   class202 field3057 = new class202();
   @ObfuscatedName("l")
   class187 field3058;
   @ObfuscatedName("r")
   class58 field3061 = new class58();

   @ObfuscatedName("s")
   protected class69 vmethod3870() {
      class190 var1 = (class190)this.field3057.method3980();
      return (class69)(null == var1?null:(var1.field3074 != null?var1.field3074:this.vmethod3871()));
   }

   @ObfuscatedName("k")
   protected class69 vmethod3871() {
      class190 var1;
      do {
         var1 = (class190)this.field3057.method3970();
         if(null == var1) {
            return null;
         }
      } while(null == var1.field3074);

      return var1.field3074;
   }

   @ObfuscatedName("u")
   protected int vmethod3872() {
      return 0;
   }

   @ObfuscatedName("n")
   protected void vmethod3873(int[] var1, int var2, int var3) {
      this.field3061.vmethod3873(var1, var2, var3);

      for(class190 var6 = (class190)this.field3057.method3980(); null != var6; var6 = (class190)this.field3057.method3970()) {
         if(!this.field3058.method3783(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field3073) {
                  this.method3884(var6, var1, var4, var5, var5 + var4);
                  var6.field3073 -= var5;
                  break;
               }

               this.method3884(var6, var1, var4, var6.field3073, var5 + var4);
               var4 += var6.field3073;
               var5 -= var6.field3073;
            } while(!this.field3058.method3784(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("m")
   protected void vmethod3874(int var1) {
      this.field3061.vmethod3874(var1);

      for(class190 var3 = (class190)this.field3057.method3980(); var3 != null; var3 = (class190)this.field3057.method3970()) {
         if(!this.field3058.method3783(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field3073) {
                  this.method3875(var3, var2);
                  var3.field3073 -= var2;
                  break;
               }

               this.method3875(var3, var3.field3073);
               var2 -= var3.field3073;
            } while(!this.field3058.method3784(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass190;II)V",
      garbageValue = "2022156832"
   )
   void method3875(class190 var1, int var2) {
      if((this.field3058.field3026[var1.field3078] & 4) != 0 && var1.field3083 < 0) {
         int var3 = this.field3058.field3014[var1.field3078] / class59.field1254;
         int var4 = (var3 + 1048575 - var1.field3082) / var3;
         var1.field3082 = var1.field3082 + var2 * var3 & 1048575;
         if(var4 <= var2) {
            if(this.field3058.field3029[var1.field3078] == 0) {
               var1.field3074 = class67.method1428(var1.field3067, var1.field3074.method1566(), var1.field3074.method1434(), var1.field3074.method1435());
            } else {
               var1.field3074 = class67.method1428(var1.field3067, var1.field3074.method1566(), 0, var1.field3074.method1435());
               this.field3058.method3761(var1, var1.field3063.field2987[var1.field3081] < 0);
            }

            if(var1.field3063.field2987[var1.field3081] < 0) {
               var1.field3074.method1430(-1);
            }

            var2 = var1.field3082 / var3;
         }
      }

      var1.field3074.vmethod3874(var2);
   }

   class189(class187 var1) {
      this.field3058 = var1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass190;[IIIIB)V",
      garbageValue = "-106"
   )
   void method3884(class190 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field3058.field3026[var1.field3078] & 4) != 0 && var1.field3083 < 0) {
         int var6 = this.field3058.field3014[var1.field3078] / class59.field1254;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field3082) / var6;
            if(var7 > var4) {
               var1.field3082 += var6 * var4;
               break;
            }

            var1.field3074.vmethod3873(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field3082 += var6 * var7 - 1048576;
            int var8 = class59.field1254 / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class67 var10 = var1.field3074;
            if(this.field3058.field3029[var1.field3078] == 0) {
               var1.field3074 = class67.method1428(var1.field3067, var10.method1566(), var10.method1434(), var10.method1435());
            } else {
               var1.field3074 = class67.method1428(var1.field3067, var10.method1566(), 0, var10.method1435());
               this.field3058.method3761(var1, var1.field3063.field2987[var1.field3081] < 0);
               var1.field3074.method1439(var8, var10.method1434());
            }

            if(var1.field3063.field2987[var1.field3081] < 0) {
               var1.field3074.method1430(-1);
            }

            var10.method1431(var8);
            var10.vmethod3873(var2, var3, var5 - var3);
            if(var10.method1445()) {
               this.field3061.method1251(var10);
            }
         }
      }

      var1.field3074.vmethod3873(var2, var3, var4);
   }
}
