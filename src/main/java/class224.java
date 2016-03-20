import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hk")
public abstract class class224 {
   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "1773111771"
   )
   static final void method4148(int var0, int var1, int var2, int var3, int var4) {
      int var5 = class77.field1396.method1948(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      if(var5 != 0) {
         var6 = class77.field1396.method2087(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = class1.field21.field1397;
         var11 = var1 * 4 + 24624 + (103 - var2) * 2048;
         var12 = var5 >> 14 & 32767;
         class40 var13 = class156.method3176(var12);
         if(var13.field952 != -1) {
            class80 var14 = class27.field676[var13.field952];
            if(null != var14) {
               int var15 = (var13.field938 * 4 - var14.field1418) / 2;
               int var16 = (var13.field939 * 4 - var14.field1417) / 2;
               var14.method1883(var15 + 48 + var1 * 4, var16 + 4 * (104 - var2 - var13.field939) + 48);
            }
         } else {
            if(var8 == 0 || var8 == 2) {
               if(0 == var7) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[1536 + var11] = var9;
               } else if(var7 == 1) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[3 + var11] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 3] = var9;
                  var10[var11 + 3 + 512] = var9;
                  var10[3 + var11 + 1024] = var9;
                  var10[var11 + 3 + 1536] = var9;
               } else if(var7 == 3) {
                  var10[1536 + var11] = var9;
                  var10[1536 + var11 + 1] = var9;
                  var10[2 + var11 + 1536] = var9;
                  var10[1536 + var11 + 3] = var9;
               }
            }

            if(3 == var8) {
               if(0 == var7) {
                  var10[var11] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
               } else if(2 == var7) {
                  var10[3 + var11 + 1536] = var9;
               } else if(3 == var7) {
                  var10[var11 + 1536] = var9;
               }
            }

            if(var8 == 2) {
               if(3 == var7) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[1024 + var11] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 0) {
                  var10[var11] = var9;
                  var10[1 + var11] = var9;
                  var10[2 + var11] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
                  var10[512 + var11 + 3] = var9;
                  var10[var11 + 3 + 1024] = var9;
                  var10[1536 + var11 + 3] = var9;
               } else if(2 == var7) {
                  var10[var11 + 1536] = var9;
                  var10[1536 + var11 + 1] = var9;
                  var10[2 + 1536 + var11] = var9;
                  var10[3 + var11 + 1536] = var9;
               }
            }
         }
      }

      var5 = class77.field1396.method1950(var0, var1, var2);
      if(var5 != 0) {
         var6 = class77.field1396.method2087(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         class40 var19 = class156.method3176(var9);
         int var23;
         if(-1 != var19.field952) {
            class80 var21 = class27.field676[var19.field952];
            if(null != var21) {
               var12 = (var19.field938 * 4 - var21.field1418) / 2;
               var23 = (var19.field939 * 4 - var21.field1417) / 2;
               var21.method1883(48 + var1 * 4 + var12, var23 + 48 + (104 - var2 - var19.field939) * 4);
            }
         } else if(9 == var8) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var22 = class1.field21.field1397;
            var23 = 24624 + var1 * 4 + 2048 * (103 - var2);
            if(0 != var7 && var7 != 2) {
               var22[var23] = var11;
               var22[1 + 512 + var23] = var11;
               var22[var23 + 1024 + 2] = var11;
               var22[3 + var23 + 1536] = var11;
            } else {
               var22[1536 + var23] = var11;
               var22[1024 + var23 + 1] = var11;
               var22[512 + var23 + 2] = var11;
               var22[3 + var23] = var11;
            }
         }
      }

      var5 = class77.field1396.method1951(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         class40 var17 = class156.method3176(var6);
         if(var17.field952 != -1) {
            class80 var18 = class27.field676[var17.field952];
            if(var18 != null) {
               var9 = (var17.field938 * 4 - var18.field1418) / 2;
               int var20 = (var17.field939 * 4 - var18.field1417) / 2;
               var18.method1883(var1 * 4 + 48 + var9, var20 + 4 * (104 - var2 - var17.field939) + 48);
            }
         }
      }

   }
}
