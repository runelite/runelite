import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("go")
public class class189 extends class69 {
   @ObfuscatedName("e")
   Deque field3048 = new Deque();
   @ObfuscatedName("f")
   class187 field3049;
   @ObfuscatedName("t")
   static int[] field3050;
   @ObfuscatedName("n")
   class58 field3051 = new class58();

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass190;II)V",
      garbageValue = "825311664"
   )
   void method3775(class190 var1, int var2) {
      if((this.field3049.field3018[var1.field3073] & 4) != 0 && var1.field3075 < 0) {
         int var3 = this.field3049.field3023[var1.field3073] / class59.field1235;
         int var4 = (1048575 + var3 - var1.field3074) / var3;
         var1.field3074 = var1.field3074 + var3 * var2 & 1048575;
         if(var4 <= var2) {
            if(this.field3049.field3021[var1.field3073] == 0) {
               var1.field3067 = class67.method1356(var1.field3056, var1.field3067.method1371(), var1.field3067.method1362(), var1.field3067.method1363());
            } else {
               var1.field3067 = class67.method1356(var1.field3056, var1.field3067.method1371(), 0, var1.field3067.method1363());
               this.field3049.method3745(var1, var1.field3069.field2971[var1.field3059] < 0);
            }

            if(var1.field3069.field2971[var1.field3059] < 0) {
               var1.field3067.method1384(-1);
            }

            var2 = var1.field3074 / var3;
         }
      }

      var1.field3067.vmethod3780(var2);
   }

   @ObfuscatedName("b")
   protected class69 vmethod3776() {
      class190 var1 = (class190)this.field3048.method3890();
      return (class69)(var1 == null?null:(null != var1.field3067?var1.field3067:this.vmethod3777()));
   }

   @ObfuscatedName("m")
   protected class69 vmethod3777() {
      class190 var1;
      do {
         var1 = (class190)this.field3048.method3892();
         if(null == var1) {
            return null;
         }
      } while(var1.field3067 == null);

      return var1.field3067;
   }

   @ObfuscatedName("k")
   protected int vmethod3778() {
      return 0;
   }

   @ObfuscatedName("l")
   protected void vmethod3780(int var1) {
      this.field3051.vmethod3780(var1);

      for(class190 var3 = (class190)this.field3048.method3890(); var3 != null; var3 = (class190)this.field3048.method3892()) {
         if(!this.field3049.method3690(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field3054) {
                  this.method3775(var3, var2);
                  var3.field3054 -= var2;
                  break;
               }

               this.method3775(var3, var3.field3054);
               var2 -= var3.field3054;
            } while(!this.field3049.method3691(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass190;[IIIII)V",
      garbageValue = "805173459"
   )
   void method3781(class190 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field3049.field3018[var1.field3073] & 4) != 0 && var1.field3075 < 0) {
         int var6 = this.field3049.field3023[var1.field3073] / class59.field1235;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field3074) / var6;
            if(var7 > var4) {
               var1.field3074 += var6 * var4;
               break;
            }

            var1.field3067.vmethod3796(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field3074 += var7 * var6 - 1048576;
            int var8 = class59.field1235 / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class67 var10 = var1.field3067;
            if(this.field3049.field3021[var1.field3073] == 0) {
               var1.field3067 = class67.method1356(var1.field3056, var10.method1371(), var10.method1362(), var10.method1363());
            } else {
               var1.field3067 = class67.method1356(var1.field3056, var10.method1371(), 0, var10.method1363());
               this.field3049.method3745(var1, var1.field3069.field2971[var1.field3059] < 0);
               var1.field3067.method1385(var8, var10.method1362());
            }

            if(var1.field3069.field2971[var1.field3059] < 0) {
               var1.field3067.method1384(-1);
            }

            var10.method1433(var8);
            var10.vmethod3796(var2, var3, var5 - var3);
            if(var10.method1373()) {
               this.field3051.method1184(var10);
            }
         }
      }

      var1.field3067.vmethod3796(var2, var3, var4);
   }

   class189(class187 var1) {
      this.field3049 = var1;
   }

   @ObfuscatedName("c")
   protected void vmethod3796(int[] var1, int var2, int var3) {
      this.field3051.vmethod3796(var1, var2, var3);

      for(class190 var6 = (class190)this.field3048.method3890(); null != var6; var6 = (class190)this.field3048.method3892()) {
         if(!this.field3049.method3690(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field3054) {
                  this.method3781(var6, var1, var4, var5, var4 + var5);
                  var6.field3054 -= var5;
                  break;
               }

               this.method3781(var6, var1, var4, var6.field3054, var5 + var4);
               var4 += var6.field3054;
               var5 -= var6.field3054;
            } while(!this.field3049.method3691(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)Ljava/lang/String;",
      garbageValue = "-866359704"
   )
   public static String method3797(Buffer var0) {
      String var1;
      try {
         int var2 = var0.method2546();
         if(var2 > 32767) {
            var2 = 32767;
         }

         byte[] var3 = new byte[var2];
         var0.offset += class225.field3231.method2463(var0.payload, var0.offset, var3, 0, var2);
         String var4 = class14.method164(var3, 0, var2);
         var1 = var4;
      } catch (Exception var6) {
         var1 = "Cabbage";
      }

      return var1;
   }
}
