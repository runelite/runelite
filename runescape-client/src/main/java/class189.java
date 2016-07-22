import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gb")
public class class189 extends class69 {
   @ObfuscatedName("m")
   class187 field3050;
   @ObfuscatedName("e")
   class202 field3051 = new class202();
   @ObfuscatedName("o")
   class58 field3052 = new class58();
   @ObfuscatedName("k")
   static int[] field3053;
   @ObfuscatedName("l")
   static class81 field3054;

   @ObfuscatedName("l")
   protected class69 vmethod3775() {
      class190 var1 = (class190)this.field3051.method3882();
      return (class69)(var1 == null?null:(var1.field3057 != null?var1.field3057:this.vmethod3776()));
   }

   @ObfuscatedName("j")
   protected class69 vmethod3776() {
      class190 var1;
      do {
         var1 = (class190)this.field3051.method3891();
         if(var1 == null) {
            return null;
         }
      } while(null == var1.field3057);

      return var1.field3057;
   }

   @ObfuscatedName("x")
   protected void vmethod3778(int[] var1, int var2, int var3) {
      this.field3052.vmethod3778(var1, var2, var3);

      for(class190 var6 = (class190)this.field3051.method3882(); null != var6; var6 = (class190)this.field3051.method3891()) {
         if(!this.field3050.method3687(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field3063) {
                  this.method3780(var6, var1, var4, var5, var4 + var5);
                  var6.field3063 -= var5;
                  break;
               }

               this.method3780(var6, var1, var4, var6.field3063, var4 + var5);
               var4 += var6.field3063;
               var5 -= var6.field3063;
            } while(!this.field3050.method3688(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("v")
   protected void vmethod3779(int var1) {
      this.field3052.vmethod3779(var1);

      for(class190 var3 = (class190)this.field3051.method3882(); null != var3; var3 = (class190)this.field3051.method3891()) {
         if(!this.field3050.method3687(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field3063) {
                  this.method3781(var3, var2);
                  var3.field3063 -= var2;
                  break;
               }

               this.method3781(var3, var3.field3063);
               var2 -= var3.field3063;
            } while(!this.field3050.method3688(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass190;[IIIII)V",
      garbageValue = "-1207648759"
   )
   void method3780(class190 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field3050.field3018[var1.field3061] & 4) != 0 && var1.field3070 < 0) {
         int var6 = this.field3050.field3034[var1.field3061] / class59.field1268;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field3075) / var6;
            if(var7 > var4) {
               var1.field3075 += var4 * var6;
               break;
            }

            var1.field3057.vmethod3778(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field3075 += var6 * var7 - 1048576;
            int var8 = class59.field1268 / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class67 var10 = var1.field3057;
            if(this.field3050.field3028[var1.field3061] == 0) {
               var1.field3057 = class67.method1390(var1.field3059, var10.method1405(), var10.method1396(), var10.method1417());
            } else {
               var1.field3057 = class67.method1390(var1.field3059, var10.method1405(), 0, var10.method1417());
               this.field3050.method3665(var1, var1.field3056.field2986[var1.field3067] < 0);
               var1.field3057.method1401(var8, var10.method1396());
            }

            if(var1.field3056.field2986[var1.field3067] < 0) {
               var1.field3057.method1392(-1);
            }

            var10.method1403(var8);
            var10.vmethod3778(var2, var3, var5 - var3);
            if(var10.method1407()) {
               this.field3052.method1204(var10);
            }
         }
      }

      var1.field3057.vmethod3778(var2, var3, var4);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass190;II)V",
      garbageValue = "1717928768"
   )
   void method3781(class190 var1, int var2) {
      if((this.field3050.field3018[var1.field3061] & 4) != 0 && var1.field3070 < 0) {
         int var3 = this.field3050.field3034[var1.field3061] / class59.field1268;
         int var4 = (var3 + 1048575 - var1.field3075) / var3;
         var1.field3075 = var2 * var3 + var1.field3075 & 1048575;
         if(var4 <= var2) {
            if(this.field3050.field3028[var1.field3061] == 0) {
               var1.field3057 = class67.method1390(var1.field3059, var1.field3057.method1405(), var1.field3057.method1396(), var1.field3057.method1417());
            } else {
               var1.field3057 = class67.method1390(var1.field3059, var1.field3057.method1405(), 0, var1.field3057.method1417());
               this.field3050.method3665(var1, var1.field3056.field2986[var1.field3067] < 0);
            }

            if(var1.field3056.field2986[var1.field3067] < 0) {
               var1.field3057.method1392(-1);
            }

            var2 = var1.field3075 / var3;
         }
      }

      var1.field3057.vmethod3779(var2);
   }

   @ObfuscatedName("r")
   protected int vmethod3783() {
      return 0;
   }

   class189(class187 var1) {
      this.field3050 = var1;
   }
}
