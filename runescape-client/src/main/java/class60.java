import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bb")
public class class60 {
   @ObfuscatedName("r")
   int[] field1190;
   @ObfuscatedName("g")
   int field1191 = class70.method1544(24);
   @ObfuscatedName("j")
   int field1192 = class70.method1544(24);
   @ObfuscatedName("d")
   int field1193 = class70.method1544(24) + 1;
   @ObfuscatedName("b")
   int field1194 = class70.method1544(16);
   @ObfuscatedName("x")
   int field1195 = class70.method1544(6) + 1;
   @ObfuscatedName("y")
   int field1196 = class70.method1544(8);

   @ObfuscatedName("b")
   void method1279(float[] var1, int var2, boolean var3) {
      int var4;
      for(var4 = 0; var4 < var2; ++var4) {
         var1[var4] = 0.0F;
      }

      if(!var3) {
         var4 = class70.field1265[this.field1196].field1329;
         int var5 = this.field1192 - this.field1191;
         int var6 = var5 / this.field1193;
         int[] var7 = new int[var6];

         for(int var8 = 0; var8 < 8; ++var8) {
            int var9 = 0;

            while(var9 < var6) {
               int var10;
               int var11;
               if(var8 == 0) {
                  var10 = class70.field1265[this.field1196].method1606();

                  for(var11 = var4 - 1; var11 >= 0; --var11) {
                     if(var9 + var11 < var6) {
                        var7[var9 + var11] = var10 % this.field1195;
                     }

                     var10 /= this.field1195;
                  }
               }

               for(var10 = 0; var10 < var4; ++var10) {
                  var11 = var7[var9];
                  int var12 = this.field1190[var11 * 8 + var8];
                  if(var12 >= 0) {
                     int var13 = this.field1191 + var9 * this.field1193;
                     class73 var14 = class70.field1265[var12];
                     int var15;
                     if(this.field1194 == 0) {
                        var15 = this.field1193 / var14.field1329;

                        for(int var16 = 0; var16 < var15; ++var16) {
                           float[] var17 = var14.method1604();

                           for(int var18 = 0; var18 < var14.field1329; ++var18) {
                              var1[var13 + var16 + var18 * var15] += var17[var18];
                           }
                        }
                     } else {
                        var15 = 0;

                        while(var15 < this.field1193) {
                           float[] var19 = var14.method1604();

                           for(int var20 = 0; var20 < var14.field1329; ++var20) {
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

   class60() {
      int[] var1 = new int[this.field1195];

      int var2;
      for(var2 = 0; var2 < this.field1195; ++var2) {
         int var3 = 0;
         int var4 = class70.method1544(3);
         boolean var5 = class70.method1546() != 0;
         if(var5) {
            var3 = class70.method1544(5);
         }

         var1[var2] = var3 << 3 | var4;
      }

      this.field1190 = new int[this.field1195 * 8];

      for(var2 = 0; var2 < this.field1195 * 8; ++var2) {
         this.field1190[var2] = (var1[var2 >> 3] & 1 << (var2 & 7)) != 0?class70.method1544(8):-1;
      }

   }
}
