import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bc")
public class class64 {
   @ObfuscatedName("i")
   int field1080 = class54.method1062(24);
   @ObfuscatedName("h")
   int field1081 = class54.method1062(8);
   @ObfuscatedName("b")
   int field1082 = class54.method1062(16);
   @ObfuscatedName("t")
   int field1083 = class54.method1062(24) + 1;
   @ObfuscatedName("k")
   int field1084 = class54.method1062(6) + 1;
   @ObfuscatedName("l")
   int field1085 = class54.method1062(24);
   @ObfuscatedName("n")
   int[] field1086;

   @ObfuscatedName("b")
   void method1219(float[] var1, int var2, boolean var3) {
      int var4;
      for(var4 = 0; var4 < var2; ++var4) {
         var1[var4] = 0.0F;
      }

      if(!var3) {
         var4 = class54.field1003[this.field1081].field966;
         int var5 = this.field1080 - this.field1085;
         int var6 = var5 / this.field1083;
         int[] var7 = new int[var6];

         for(int var8 = 0; var8 < 8; ++var8) {
            int var9 = 0;

            while(var9 < var6) {
               int var10;
               int var11;
               if(var8 == 0) {
                  var10 = class54.field1003[this.field1081].method1033();

                  for(var11 = var4 - 1; var11 >= 0; --var11) {
                     if(var9 + var11 < var6) {
                        var7[var9 + var11] = var10 % this.field1084;
                     }

                     var10 /= this.field1084;
                  }
               }

               for(var10 = 0; var10 < var4; ++var10) {
                  var11 = var7[var9];
                  int var12 = this.field1086[var11 * 8 + var8];
                  if(var12 >= 0) {
                     int var13 = this.field1085 + var9 * this.field1083;
                     class52 var14 = class54.field1003[var12];
                     int var15;
                     if(this.field1082 == 0) {
                        var15 = this.field1083 / var14.field966;

                        for(int var20 = 0; var20 < var15; ++var20) {
                           float[] var17 = var14.method1035();

                           for(int var18 = 0; var18 < var14.field966; ++var18) {
                              var1[var13 + var20 + var18 * var15] += var17[var18];
                           }
                        }
                     } else {
                        var15 = 0;

                        while(var15 < this.field1083) {
                           float[] var16 = var14.method1035();

                           for(int var19 = 0; var19 < var14.field966; ++var19) {
                              var1[var13 + var15] += var16[var19];
                              ++var15;
                           }
                        }
                     }
                  }

                  ++var9;
                  if(var9 >= var6) {
                     break;
                  }
               }
            }
         }

      }
   }

   class64() {
      int[] var1 = new int[this.field1084];

      int var2;
      for(var2 = 0; var2 < this.field1084; ++var2) {
         int var3 = 0;
         int var4 = class54.method1062(3);
         boolean var5 = class54.method1065() != 0;
         if(var5) {
            var3 = class54.method1062(5);
         }

         var1[var2] = var3 << 3 | var4;
      }

      this.field1086 = new int[this.field1084 * 8];

      for(var2 = 0; var2 < this.field1084 * 8; ++var2) {
         this.field1086[var2] = (var1[var2 >> 3] & 1 << (var2 & 7)) != 0?class54.method1062(8):-1;
      }

   }
}
