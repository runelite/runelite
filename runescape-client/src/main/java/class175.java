import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fm")
public class class175 {
   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "433447783"
   )
   static final void method3263(int var0, int var1, int var2, int var3, int var4) {
      int var5 = class172.region.method1747(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      if(var5 != 0) {
         var6 = class172.region.method1751(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = ISAACCipher.field2000.image;
         var11 = (103 - var2) * 2048 + var1 * 4 + 24624;
         var12 = var5 >> 14 & 32767;
         ObjectComposition var13 = class26.getObjectDefinition(var12);
         if(var13.mapSceneId != -1) {
            ModIcon var14 = GroundObject.field1284[var13.mapSceneId];
            if(var14 != null) {
               int var15 = (var13.sizeX * 4 - var14.originalWidth) / 2;
               int var16 = (var13.sizeY * 4 - var14.height) / 2;
               var14.method4170(var1 * 4 + 48 + var15, var16 + (104 - var2 - var13.sizeY) * 4 + 48);
            }
         } else {
            if(var8 == 0 || var8 == 2) {
               if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 1) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 3] = var9;
                  var10[var11 + 3 + 512] = var9;
                  var10[var11 + 3 + 1024] = var9;
                  var10[var11 + 3 + 1536] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }

            if(var8 == 3) {
               if(var7 == 0) {
                  var10[var11] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 3 + 1536] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
               }
            }

            if(var8 == 2) {
               if(var7 == 3) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
                  var10[var11 + 3 + 512] = var9;
                  var10[var11 + 3 + 1024] = var9;
                  var10[var11 + 3 + 1536] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 1536] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }
         }
      }

      var5 = class172.region.method1818(var0, var1, var2);
      if(var5 != 0) {
         var6 = class172.region.method1751(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         ObjectComposition var23 = class26.getObjectDefinition(var9);
         int var18;
         if(var23.mapSceneId != -1) {
            ModIcon var21 = GroundObject.field1284[var23.mapSceneId];
            if(var21 != null) {
               var12 = (var23.sizeX * 4 - var21.originalWidth) / 2;
               var18 = (var23.sizeY * 4 - var21.height) / 2;
               var21.method4170(var1 * 4 + 48 + var12, (104 - var2 - var23.sizeY) * 4 + 48 + var18);
            }
         } else if(var8 == 9) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var17 = ISAACCipher.field2000.image;
            var18 = (103 - var2) * 2048 + var1 * 4 + 24624;
            if(var7 != 0 && var7 != 2) {
               var17[var18] = var11;
               var17[var18 + 512 + 1] = var11;
               var17[var18 + 1024 + 2] = var11;
               var17[var18 + 1536 + 3] = var11;
            } else {
               var17[var18 + 1536] = var11;
               var17[var18 + 1024 + 1] = var11;
               var17[var18 + 512 + 2] = var11;
               var17[var18 + 3] = var11;
            }
         }
      }

      var5 = class172.region.method1750(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         ObjectComposition var20 = class26.getObjectDefinition(var6);
         if(var20.mapSceneId != -1) {
            ModIcon var19 = GroundObject.field1284[var20.mapSceneId];
            if(var19 != null) {
               var9 = (var20.sizeX * 4 - var19.originalWidth) / 2;
               int var22 = (var20.sizeY * 4 - var19.height) / 2;
               var19.method4170(var9 + var1 * 4 + 48, var22 + (104 - var2 - var20.sizeY) * 4 + 48);
            }
         }
      }

   }

   class175() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("dl")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "185628712"
   )
   static final boolean method3264(Widget var0) {
      if(var0.field2320 == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.field2320.length; ++var1) {
            int var2 = class3.method28(var0, var1);
            int var3 = var0.field2321[var1];
            if(var0.field2320[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.field2320[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.field2320[var1] == 4) {
               if(var2 == var3) {
                  return false;
               }
            } else if(var3 != var2) {
               return false;
            }
         }

         return true;
      }
   }
}
