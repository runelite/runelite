import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gf")
public class class189 extends class69 {
   @ObfuscatedName("s")
   class187 field3052;
   @ObfuscatedName("z")
   Deque field3053 = new Deque();
   @ObfuscatedName("t")
   class58 field3054 = new class58();

   @ObfuscatedName("f")
   protected int vmethod3707() {
      return 0;
   }

   @ObfuscatedName("g")
   protected class69 vmethod3708() {
      class190 var1 = (class190)this.field3053.method3808();
      return (class69)(null == var1?null:(var1.field3073 != null?var1.field3073:this.vmethod3709()));
   }

   @ObfuscatedName("m")
   protected class69 vmethod3709() {
      class190 var1;
      do {
         var1 = (class190)this.field3053.method3810();
         if(null == var1) {
            return null;
         }
      } while(null == var1.field3073);

      return var1.field3073;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass190;[IIIII)V",
      garbageValue = "258846274"
   )
   void method3710(class190 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field3052.field3022[var1.field3067] & 4) != 0 && var1.field3060 < 0) {
         int var6 = this.field3052.field3027[var1.field3067] / class59.field1219;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field3075) / var6;
            if(var7 > var4) {
               var1.field3075 += var4 * var6;
               break;
            }

            var1.field3073.vmethod3711(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field3075 += var7 * var6 - 1048576;
            int var8 = class59.field1219 / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class67 var10 = var1.field3073;
            if(this.field3052.field3025[var1.field3067] == 0) {
               var1.field3073 = class67.method1309(var1.field3057, var10.method1325(), var10.method1315(), var10.method1439());
            } else {
               var1.field3073 = class67.method1309(var1.field3057, var10.method1325(), 0, var10.method1439());
               this.field3052.method3593(var1, var1.field3069.field2972[var1.field3072] < 0);
               var1.field3073.method1448(var8, var10.method1315());
            }

            if(var1.field3069.field2972[var1.field3072] < 0) {
               var1.field3073.method1311(-1);
            }

            var10.method1322(var8);
            var10.vmethod3711(var2, var3, var5 - var3);
            if(var10.method1326()) {
               this.field3054.method1143(var10);
            }
         }
      }

      var1.field3073.vmethod3711(var2, var3, var4);
   }

   @ObfuscatedName("k")
   protected void vmethod3711(int[] var1, int var2, int var3) {
      this.field3054.vmethod3711(var1, var2, var3);

      for(class190 var6 = (class190)this.field3053.method3808(); null != var6; var6 = (class190)this.field3053.method3810()) {
         if(!this.field3052.method3615(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field3074) {
                  this.method3710(var6, var1, var4, var5, var5 + var4);
                  var6.field3074 -= var5;
                  break;
               }

               this.method3710(var6, var1, var4, var6.field3074, var5 + var4);
               var4 += var6.field3074;
               var5 -= var6.field3074;
            } while(!this.field3052.method3665(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("r")
   protected void vmethod3712(int var1) {
      this.field3054.vmethod3712(var1);

      for(class190 var3 = (class190)this.field3053.method3808(); null != var3; var3 = (class190)this.field3053.method3810()) {
         if(!this.field3052.method3615(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field3074) {
                  this.method3714(var3, var2);
                  var3.field3074 -= var2;
                  break;
               }

               this.method3714(var3, var3.field3074);
               var2 -= var3.field3074;
            } while(!this.field3052.method3665(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lclass190;II)V",
      garbageValue = "-936588433"
   )
   void method3714(class190 var1, int var2) {
      if((this.field3052.field3022[var1.field3067] & 4) != 0 && var1.field3060 < 0) {
         int var3 = this.field3052.field3027[var1.field3067] / class59.field1219;
         int var4 = (var3 + 1048575 - var1.field3075) / var3;
         var1.field3075 = var2 * var3 + var1.field3075 & 1048575;
         if(var4 <= var2) {
            if(this.field3052.field3025[var1.field3067] == 0) {
               var1.field3073 = class67.method1309(var1.field3057, var1.field3073.method1325(), var1.field3073.method1315(), var1.field3073.method1439());
            } else {
               var1.field3073 = class67.method1309(var1.field3057, var1.field3073.method1325(), 0, var1.field3073.method1439());
               this.field3052.method3593(var1, var1.field3069.field2972[var1.field3072] < 0);
            }

            if(var1.field3069.field2972[var1.field3072] < 0) {
               var1.field3073.method1311(-1);
            }

            var2 = var1.field3075 / var3;
         }
      }

      var1.field3073.vmethod3712(var2);
   }

   class189(class187 var1) {
      this.field3052 = var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;Lclass170;I)V",
      garbageValue = "-587606464"
   )
   public static void method3728(class170 var0, class170 var1, class170 var2) {
      Sequence.field965 = var0;
      class93.field1607 = var1;
      Sequence.field966 = var2;
   }
}
