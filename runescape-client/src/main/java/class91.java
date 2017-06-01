import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
public class class91 implements class178 {
   @ObfuscatedName("e")
   static final class91 field1435;
   @ObfuscatedName("c")
   static final class91 field1436;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1401099917
   )
   final int field1437;
   @ObfuscatedName("v")
   static final class91 field1439;
   @ObfuscatedName("i")
   static final class91 field1440;

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class91(int var1) {
      this.field1437 = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-70"
   )
   public int vmethod5009() {
      return this.field1437;
   }

   static {
      field1440 = new class91(0);
      field1436 = new class91(1);
      field1435 = new class91(2);
      field1439 = new class91(3);
   }

   @ObfuscatedName("gi")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-868559201"
   )
   static final void method1709(int var0, int var1, int var2, int var3, int var4) {
      int var5 = class1.region.method2704(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var12;
      int var17;
      if(var5 != 0) {
         var6 = class1.region.method2835(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = class41.field564.image;
         var17 = var1 * 4 + 24624 + (103 - var2) * 2048;
         var12 = var5 >> 14 & 32767;
         ObjectComposition var18 = class226.getObjectDefinition(var12);
         if(var18.mapSceneId != -1) {
            ModIcon var14 = class112.field1685[var18.mapSceneId];
            if(var14 != null) {
               int var15 = (var18.sizeX * 4 - var14.originalWidth) / 2;
               int var16 = (var18.sizeY * 4 - var14.height) / 2;
               var14.method5017(var15 + var1 * 4 + 48, (104 - var2 - var18.sizeY) * 4 + 48 + var16);
            }
         } else {
            if(var8 == 0 || var8 == 2) {
               if(var7 == 0) {
                  var10[var17] = var9;
                  var10[var17 + 512] = var9;
                  var10[var17 + 1024] = var9;
                  var10[var17 + 1536] = var9;
               } else if(var7 == 1) {
                  var10[var17] = var9;
                  var10[var17 + 1] = var9;
                  var10[var17 + 2] = var9;
                  var10[var17 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var17 + 3] = var9;
                  var10[var17 + 3 + 512] = var9;
                  var10[var17 + 3 + 1024] = var9;
                  var10[var17 + 3 + 1536] = var9;
               } else if(var7 == 3) {
                  var10[var17 + 1536] = var9;
                  var10[var17 + 1536 + 1] = var9;
                  var10[var17 + 1536 + 2] = var9;
                  var10[var17 + 1536 + 3] = var9;
               }
            }

            if(var8 == 3) {
               if(var7 == 0) {
                  var10[var17] = var9;
               } else if(var7 == 1) {
                  var10[var17 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var17 + 3 + 1536] = var9;
               } else if(var7 == 3) {
                  var10[var17 + 1536] = var9;
               }
            }

            if(var8 == 2) {
               if(var7 == 3) {
                  var10[var17] = var9;
                  var10[var17 + 512] = var9;
                  var10[var17 + 1024] = var9;
                  var10[var17 + 1536] = var9;
               } else if(var7 == 0) {
                  var10[var17] = var9;
                  var10[var17 + 1] = var9;
                  var10[var17 + 2] = var9;
                  var10[var17 + 3] = var9;
               } else if(var7 == 1) {
                  var10[var17 + 3] = var9;
                  var10[var17 + 3 + 512] = var9;
                  var10[var17 + 3 + 1024] = var9;
                  var10[var17 + 3 + 1536] = var9;
               } else if(var7 == 2) {
                  var10[var17 + 1536] = var9;
                  var10[var17 + 1536 + 1] = var9;
                  var10[var17 + 1536 + 2] = var9;
                  var10[var17 + 1536 + 3] = var9;
               }
            }
         }
      }

      var5 = class1.region.method2702(var0, var1, var2);
      if(var5 != 0) {
         var6 = class1.region.method2835(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         ObjectComposition var23 = class226.getObjectDefinition(var9);
         int var13;
         if(var23.mapSceneId != -1) {
            ModIcon var11 = class112.field1685[var23.mapSceneId];
            if(var11 != null) {
               var12 = (var23.sizeX * 4 - var11.originalWidth) / 2;
               var13 = (var23.sizeY * 4 - var11.height) / 2;
               var11.method5017(var1 * 4 + 48 + var12, (104 - var2 - var23.sizeY) * 4 + 48 + var13);
            }
         } else if(var8 == 9) {
            var17 = 15658734;
            if(var5 > 0) {
               var17 = 15597568;
            }

            int[] var19 = class41.field564.image;
            var13 = var1 * 4 + 24624 + (103 - var2) * 2048;
            if(var7 != 0 && var7 != 2) {
               var19[var13] = var17;
               var19[var13 + 512 + 1] = var17;
               var19[var13 + 1024 + 2] = var17;
               var19[var13 + 1536 + 3] = var17;
            } else {
               var19[var13 + 1536] = var17;
               var19[var13 + 1024 + 1] = var17;
               var19[var13 + 512 + 2] = var17;
               var19[var13 + 3] = var17;
            }
         }
      }

      var5 = class1.region.method2703(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         ObjectComposition var20 = class226.getObjectDefinition(var6);
         if(var20.mapSceneId != -1) {
            ModIcon var21 = class112.field1685[var20.mapSceneId];
            if(var21 != null) {
               var9 = (var20.sizeX * 4 - var21.originalWidth) / 2;
               int var22 = (var20.sizeY * 4 - var21.height) / 2;
               var21.method5017(var9 + var1 * 4 + 48, (104 - var2 - var20.sizeY) * 4 + 48 + var22);
            }
         }
      }

   }

   @ObfuscatedName("fy")
   @ObfuscatedSignature(
      signature = "(IIIIZB)V",
      garbageValue = "-68"
   )
   static final void method1710(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = Client.field1045 + var5 * (Client.field975 - Client.field1045) / 100;
      int var7 = var6 * var3 * 512 / (var2 * 334);
      int var8;
      int var9;
      short var15;
      if(var7 < Client.field1188) {
         var15 = Client.field1188;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 > Client.field1187) {
            var6 = Client.field1187;
            var8 = var6 * var3 * 512 / (var15 * 334);
            var9 = (var2 - var8) / 2;
            if(var4) {
               Rasterizer2D.method4914();
               Rasterizer2D.method4923(var0, var1, var9, var3, -16777216);
               Rasterizer2D.method4923(var2 + var0 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= var9 * 2;
         }
      } else if(var7 > Client.field1189) {
         var15 = Client.field1189;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 < Client.field1159) {
            var6 = Client.field1159;
            var8 = var15 * var2 * 334 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            if(var4) {
               Rasterizer2D.method4914();
               Rasterizer2D.method4923(var0, var1, var2, var9, -16777216);
               Rasterizer2D.method4923(var0, var1 + var3 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      var8 = Client.field1094 + var5 * (Client.field1185 - Client.field1094) / 100;
      Client.scale = var3 * var6 * var8 / 85504 << 1;
      if(Client.camera2 != var2 || Client.camera3 != var3) {
         int[] var14 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = var10 * 32 + 128 + 15;
            int var12 = var11 * 3 + 600;
            int var13 = class136.SINE[var11];
            var14[var10] = var12 * var13 >> 16;
         }

         Region.method2806(var14, 500, 800, var2, var3);
      }

      Client.field1190 = var0;
      Client.field1191 = var1;
      Client.camera2 = var2;
      Client.camera3 = var3;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1803635967"
   )
   static void method1711(int var0) {
      if(var0 != -1) {
         if(RSSocket.method2986(var0)) {
            Widget[] var1 = CombatInfo1.widgets[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               Widget var3 = var1[var2];
               if(var3.field2732 != null) {
                  class69 var4 = new class69();
                  var4.field852 = var3;
                  var4.field849 = var3.field2732;
                  Projectile.method1746(var4, 2000000);
               }
            }

         }
      }
   }
}
