import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
final class class0 implements Comparator {
   @ObfuscatedName("bv")
   static class184 field2;
   @ObfuscatedName("hd")
   @ObfuscatedGetter(
      intValue = -1889432945
   )
   @Export("menuX")
   static int menuX;

   public int compare(Object var1, Object var2) {
      return this.method4((class2)var1, (class2)var2);
   }

   @ObfuscatedName("ea")
   @ObfuscatedSignature(
      signature = "([BIB)V",
      garbageValue = "-30"
   )
   static void method2(byte[] var0, int var1) {
      if(null == Client.field349) {
         Client.field349 = new byte[24];
      }

      class163.method3125(var0, var1, Client.field349, 0, 24);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "-1312094230"
   )
   int method4(class2 var1, class2 var2) {
      return var1.field26 < var2.field26?-1:(var2.field26 == var1.field26?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILScript;ZB)I",
      garbageValue = "-34"
   )
   static int method9(int var0, Script var1, boolean var2) {
      if(var0 == 3200) {
         class32.field752 -= 3;
         class142.method2719(class32.field756[class32.field752], class32.field756[class32.field752 + 1], class32.field756[class32.field752 + 2]);
         return 1;
      } else {
         int var3;
         if(var0 != 3201) {
            if(var0 == 3202) {
               class32.field752 -= 2;
               var3 = class32.field756[class32.field752];
               int var6 = class32.field756[1 + class32.field752];
               if(Client.field550 != 0 && var3 != -1) {
                  class40.method821(class1.field12, var3, 0, Client.field550, false);
                  Client.field552 = true;
               }

               return 1;
            } else {
               return 2;
            }
         } else {
            var3 = class32.field756[--class32.field752];
            if(var3 == -1 && !Client.field552) {
               class138.field1919.method2536();
               class138.field1920 = 1;
               class138.field1916 = null;
            } else if(var3 != -1 && Client.field445 != var3 && Client.field550 != 0 && !Client.field552) {
               class184 var4 = class3.field39;
               int var5 = Client.field550;
               class138.field1920 = 1;
               class138.field1916 = var4;
               class138.field1922 = var3;
               class8.field86 = 0;
               Ignore.field245 = var5;
               class138.field1923 = false;
               XClanMember.field302 = 2;
            }

            Client.field445 = var3;
            return 1;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2096719205"
   )
   static void method10() {
      FileOnDisk var0 = null;

      try {
         var0 = class2.method33("", WidgetNode.field218.field2677, true);
         Buffer var1 = class8.field84.method676();
         var0.method1481(var1.payload, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if(null != var0) {
            var0.method1479();
         }
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "1998361416"
   )
   static final void method12(int var0, int var1, int var2, int var3, int var4) {
      int var5 = Friend.region.method1920(var0, var1, var2);
      int var6;
      int var7;
      int var9;
      int var11;
      int var17;
      int var20;
      if(var5 != 0) {
         var6 = Friend.region.method1783(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var20 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = Actor.field685.image;
         var11 = var1 * 4 + 24624 + (103 - var2) * 2048;
         var17 = var5 >> 14 & 32767;
         ObjectComposition var18 = class195.getObjectDefinition(var17);
         if(var18.mapSceneId != -1) {
            ModIcon var14 = class65.field1116[var18.mapSceneId];
            if(var14 != null) {
               int var15 = (var18.sizeX * 4 - var14.originalWidth) / 2;
               int var16 = (var18.sizeY * 4 - var14.height) / 2;
               var14.method4090(var15 + 4 * var1 + 48, 48 + (104 - var2 - var18.sizeY) * 4 + var16);
            }
         } else {
            if(var20 == 0 || var20 == 2) {
               if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[1024 + var11] = var9;
                  var10[1536 + var11] = var9;
               } else if(var7 == 1) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[3 + var11] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 3] = var9;
                  var10[512 + var11 + 3] = var9;
                  var10[1024 + var11 + 3] = var9;
                  var10[3 + var11 + 1536] = var9;
               } else if(var7 == 3) {
                  var10[1536 + var11] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[2 + var11 + 1536] = var9;
                  var10[1536 + var11 + 3] = var9;
               }
            }

            if(var20 == 3) {
               if(var7 == 0) {
                  var10[var11] = var9;
               } else if(var7 == 1) {
                  var10[3 + var11] = var9;
               } else if(var7 == 2) {
                  var10[1536 + var11 + 3] = var9;
               } else if(var7 == 3) {
                  var10[1536 + var11] = var9;
               }
            }

            if(var20 == 2) {
               if(var7 == 3) {
                  var10[var11] = var9;
                  var10[512 + var11] = var9;
                  var10[1024 + var11] = var9;
                  var10[1536 + var11] = var9;
               } else if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[2 + var11] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
                  var10[512 + 3 + var11] = var9;
                  var10[1024 + 3 + var11] = var9;
                  var10[3 + var11 + 1536] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 1536] = var9;
                  var10[1536 + var11 + 1] = var9;
                  var10[2 + 1536 + var11] = var9;
                  var10[3 + 1536 + var11] = var9;
               }
            }
         }
      }

      var5 = Friend.region.method1785(var0, var1, var2);
      if(var5 != 0) {
         var6 = Friend.region.method1783(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var20 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         ObjectComposition var23 = class195.getObjectDefinition(var9);
         int var13;
         if(var23.mapSceneId != -1) {
            ModIcon var21 = class65.field1116[var23.mapSceneId];
            if(null != var21) {
               var17 = (var23.sizeX * 4 - var21.originalWidth) / 2;
               var13 = (var23.sizeY * 4 - var21.height) / 2;
               var21.method4090(48 + 4 * var1 + var17, (104 - var2 - var23.sizeY) * 4 + 48 + var13);
            }
         } else if(var20 == 9) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var12 = Actor.field685.image;
            var13 = 2048 * (103 - var2) + 24624 + var1 * 4;
            if(var7 != 0 && var7 != 2) {
               var12[var13] = var11;
               var12[1 + 512 + var13] = var11;
               var12[2 + var13 + 1024] = var11;
               var12[1536 + var13 + 3] = var11;
            } else {
               var12[var13 + 1536] = var11;
               var12[1 + 1024 + var13] = var11;
               var12[var13 + 512 + 2] = var11;
               var12[var13 + 3] = var11;
            }
         }
      }

      var5 = Friend.region.method1782(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         ObjectComposition var19 = class195.getObjectDefinition(var6);
         if(var19.mapSceneId != -1) {
            ModIcon var8 = class65.field1116[var19.mapSceneId];
            if(null != var8) {
               var9 = (var19.sizeX * 4 - var8.originalWidth) / 2;
               int var22 = (var19.sizeY * 4 - var8.height) / 2;
               var8.method4090(var1 * 4 + 48 + var9, var22 + (104 - var2 - var19.sizeY) * 4 + 48);
            }
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1575724335"
   )
   public static boolean method13(int var0) {
      return (var0 >> 21 & 1) != 0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "29"
   )
   static final int method14(int var0, int var1) {
      int var2 = var0 + 57 * var1;
      var2 ^= var2 << 13;
      int var3 = 1376312589 + (15731 * var2 * var2 + 789221) * var2 & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass182;Ljava/lang/String;Ljava/lang/String;B)[LModIcon;",
      garbageValue = "-32"
   )
   public static ModIcon[] method15(class182 var0, String var1, String var2) {
      int var3 = var0.method3321(var1);
      int var4 = var0.method3322(var3, var2);
      ModIcon[] var5;
      if(!class65.method1246(var0, var3, var4)) {
         var5 = null;
      } else {
         ModIcon[] var7 = new ModIcon[class225.field3235];

         for(int var8 = 0; var8 < class225.field3235; ++var8) {
            ModIcon var9 = var7[var8] = new ModIcon();
            var9.width = class203.field3083;
            var9.originalHeight = class225.field3232;
            var9.offsetX = XItemContainer.field147[var8];
            var9.offsetY = class203.field3085[var8];
            var9.originalWidth = class225.field3233[var8];
            var9.height = class225.field3231[var8];
            var9.palette = class225.field3237;
            var9.pixels = RSCanvas.field1766[var8];
         }

         XItemContainer.field147 = null;
         class203.field3085 = null;
         class225.field3233 = null;
         class225.field3231 = null;
         class225.field3237 = null;
         RSCanvas.field1766 = null;
         var5 = var7;
      }

      return var5;
   }
}
