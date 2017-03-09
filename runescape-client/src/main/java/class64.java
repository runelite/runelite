import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("by")
public class class64 {
   @ObfuscatedName("d")
   int field1101 = class54.method1066(24) + 1;
   @ObfuscatedName("j")
   int field1102 = class54.method1066(24);
   @ObfuscatedName("c")
   int field1103 = class54.method1066(24);
   @ObfuscatedName("x")
   int field1104 = class54.method1066(16);
   @ObfuscatedName("w")
   int field1105 = class54.method1066(6) + 1;
   @ObfuscatedName("h")
   int field1106 = class54.method1066(8);
   @ObfuscatedName("u")
   int[] field1107;

   @ObfuscatedName("x")
   void method1236(float[] var1, int var2, boolean var3) {
      int var4;
      for(var4 = 0; var4 < var2; ++var4) {
         var1[var4] = 0.0F;
      }

      if(!var3) {
         var4 = class54.field1032[this.field1106].field990;
         int var5 = this.field1103 - this.field1102;
         int var6 = var5 / this.field1101;
         int[] var7 = new int[var6];

         for(int var8 = 0; var8 < 8; ++var8) {
            int var9 = 0;

            while(var9 < var6) {
               int var10;
               int var11;
               if(var8 == 0) {
                  var10 = class54.field1032[this.field1106].method1050();

                  for(var11 = var4 - 1; var11 >= 0; --var11) {
                     if(var9 + var11 < var6) {
                        var7[var9 + var11] = var10 % this.field1105;
                     }

                     var10 /= this.field1105;
                  }
               }

               for(var10 = 0; var10 < var4; ++var10) {
                  var11 = var7[var9];
                  int var12 = this.field1107[var11 * 8 + var8];
                  if(var12 >= 0) {
                     int var13 = this.field1102 + var9 * this.field1101;
                     class52 var14 = class54.field1032[var12];
                     int var15;
                     if(this.field1104 == 0) {
                        var15 = this.field1101 / var14.field990;

                        for(int var16 = 0; var16 < var15; ++var16) {
                           float[] var17 = var14.method1037();

                           for(int var18 = 0; var18 < var14.field990; ++var18) {
                              var1[var13 + var16 + var18 * var15] += var17[var18];
                           }
                        }
                     } else {
                        var15 = 0;

                        while(var15 < this.field1101) {
                           float[] var19 = var14.method1037();

                           for(int var20 = 0; var20 < var14.field990; ++var20) {
                              var1[var13 + var15] += var19[var20];
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
      int[] var1 = new int[this.field1105];

      int var2;
      for(var2 = 0; var2 < this.field1105; ++var2) {
         int var3 = 0;
         int var4 = class54.method1066(3);
         boolean var5 = class54.method1065() != 0;
         if(var5) {
            var3 = class54.method1066(5);
         }

         var1[var2] = var3 << 3 | var4;
      }

      this.field1107 = new int[this.field1105 * 8];

      for(var2 = 0; var2 < this.field1105 * 8; ++var2) {
         this.field1107[var2] = (var1[var2 >> 3] & 1 << (var2 & 7)) != 0?class54.method1066(8):-1;
      }

   }
}
