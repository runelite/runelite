import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cm")
public class class89 {
   @ObfuscatedName("pa")
   static class8 field1548;
   @ObfuscatedName("a")
   public static class142 field1549;

   @ObfuscatedName("cp")
   static final int method2100(class172 var0, int var1) {
      if(var0.field2853 != null && var1 < var0.field2853.length) {
         try {
            int[] var2 = var0.field2853[var1];
            int var3 = 0;
            int var4 = 0;
            byte var5 = 0;

            while(true) {
               int var6 = var2[var4++];
               int var7 = 0;
               byte var8 = 0;
               if(0 == var6) {
                  return var3;
               }

               if(1 == var6) {
                  var7 = client.field430[var2[var4++]];
               }

               if(2 == var6) {
                  var7 = client.field337[var2[var4++]];
               }

               if(var6 == 3) {
                  var7 = client.field290[var2[var4++]];
               }

               int var9;
               class172 var10;
               int var11;
               int var12;
               if(var6 == 4) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class92.method2180(var9);
                  var11 = var2[var4++];
                  if(-1 != var11 && (!class75.method1648(var11).field1128 || client.field296)) {
                     for(var12 = 0; var12 < var10.field2859.length; ++var12) {
                        if(var11 + 1 == var10.field2859[var12]) {
                           var7 += var10.field2860[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = class175.field2890[var2[var4++]];
               }

               if(6 == var6) {
                  var7 = class154.field2279[client.field337[var2[var4++]] - 1];
               }

               if(7 == var6) {
                  var7 = class175.field2890[var2[var4++]] * 100 / '뜛';
               }

               if(var6 == 8) {
                  var7 = class151.field2253.field31;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class154.field2280[var9]) {
                        var7 += client.field337[var9];
                     }
                  }
               }

               if(10 == var6) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class92.method2180(var9);
                  var11 = var2[var4++];
                  if(-1 != var11 && (!class75.method1648(var11).field1128 || client.field296)) {
                     for(var12 = 0; var12 < var10.field2859.length; ++var12) {
                        if(var11 + 1 == var10.field2859[var12]) {
                           var7 = 999999999;
                           break;
                        }
                     }
                  }
               }

               if(11 == var6) {
                  var7 = client.field458;
               }

               if(12 == var6) {
                  var7 = client.field336;
               }

               if(var6 == 13) {
                  var9 = class175.field2890[var2[var4++]];
                  int var14 = var2[var4++];
                  var7 = 0 != (var9 & 1 << var14)?1:0;
               }

               if(14 == var6) {
                  var9 = var2[var4++];
                  var7 = class126.method2820(var9);
               }

               if(15 == var6) {
                  var8 = 1;
               }

               if(var6 == 16) {
                  var8 = 2;
               }

               if(17 == var6) {
                  var8 = 3;
               }

               if(18 == var6) {
                  var7 = class147.field2214 + (class151.field2253.field870 >> 7);
               }

               if(var6 == 19) {
                  var7 = class17.field257 + (class151.field2253.field813 >> 7);
               }

               if(var6 == 20) {
                  var7 = var2[var4++];
               }

               if(var8 == 0) {
                  if(0 == var5) {
                     var3 += var7;
                  }

                  if(var5 == 1) {
                     var3 -= var7;
                  }

                  if(2 == var5 && 0 != var7) {
                     var3 /= var7;
                  }

                  if(var5 == 3) {
                     var3 *= var7;
                  }

                  var5 = 0;
               } else {
                  var5 = var8;
               }
            }
         } catch (Exception var13) {
            return -1;
         }
      } else {
         return -2;
      }
   }
}
