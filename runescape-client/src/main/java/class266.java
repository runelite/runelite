import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ji")
public class class266 {
   @ObfuscatedName("g")
   public static short[][] field3671;
   @ObfuscatedName("n")
   public static final char[] field3673;

   @ObfuscatedName("fk")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-108"
   )
   static final void method4878(int var0, int var1, int var2, int var3) {
      ++Client.field1019;
      class83.method1650(class66.field800);
      boolean var4 = false;
      int var5;
      int var7;
      if(Client.field1044 >= 0) {
         var5 = class96.field1499;
         int[] var19 = class96.field1501;

         for(var7 = 0; var7 < var5; ++var7) {
            if(Client.field1044 == var19[var7]) {
               var4 = true;
               break;
            }
         }
      }

      if(var4) {
         class83.method1650(class66.field805);
      }

      class217.method4073(true);
      class83.method1650(var4?class66.field802:class66.field806);
      class217.method4073(false);
      CombatInfo2.method4423();
      PendingSpawn.method1482();
      class211.method3950(var0, var1, var2, var3, true);
      var0 = Client.field1177;
      var1 = Client.field1150;
      var2 = Client.viewportHeight;
      var3 = Client.viewportWidth;
      Rasterizer2D.method4961(var0, var1, var0 + var2, var3 + var1);
      class136.method2594();
      int var6;
      int var8;
      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      if(!Client.field987) {
         var5 = Client.field1107;
         if(Client.field1007 / 256 > var5) {
            var5 = Client.field1007 / 256;
         }

         if(Client.field1164[4] && Client.field1190[4] + 128 > var5) {
            var5 = Client.field1190[4] + 128;
         }

         var6 = Client.mapAngle + Client.field1125 & 2047;
         var7 = class27.field404;
         var8 = class181.method3424(class168.localPlayer.x, class168.localPlayer.y, class92.plane) - Client.field1004;
         var9 = class155.field2258;
         var10 = var5 * 3 + 600;
         var11 = 2048 - var5 & 2047;
         var12 = 2048 - var6 & 2047;
         var13 = 0;
         var14 = 0;
         int var15 = var10;
         int var16;
         int var17;
         int var18;
         if(var11 != 0) {
            var16 = class136.SINE[var11];
            var17 = class136.COSINE[var11];
            var18 = var14 * var17 - var16 * var10 >> 16;
            var15 = var17 * var10 + var16 * var14 >> 16;
            var14 = var18;
         }

         if(var12 != 0) {
            var16 = class136.SINE[var12];
            var17 = class136.COSINE[var12];
            var18 = var13 * var17 + var15 * var16 >> 16;
            var15 = var15 * var17 - var13 * var16 >> 16;
            var13 = var18;
         }

         class2.cameraX = var7 - var13;
         class203.cameraZ = var8 - var14;
         XItemContainer.cameraY = var9 - var15;
         Client.cameraPitch = var5;
         GraphicsObject.cameraYaw = var6;
      }

      if(!Client.field987) {
         var5 = class20.method167();
      } else {
         if(class66.field801.field1318) {
            var6 = class92.plane;
         } else {
            var7 = class181.method3424(class2.cameraX, XItemContainer.cameraY, class92.plane);
            if(var7 - class203.cameraZ < 800 && (class61.tileSettings[class92.plane][class2.cameraX >> 7][XItemContainer.cameraY >> 7] & 4) != 0) {
               var6 = class92.plane;
            } else {
               var6 = 3;
            }
         }

         var5 = var6;
      }

      var6 = class2.cameraX;
      var7 = class203.cameraZ;
      var8 = XItemContainer.cameraY;
      var9 = Client.cameraPitch;
      var10 = GraphicsObject.cameraYaw;

      for(var11 = 0; var11 < 5; ++var11) {
         if(Client.field1164[var11]) {
            var12 = (int)(Math.random() * (double)(Client.field1165[var11] * 2 + 1) - (double)Client.field1165[var11] + Math.sin((double)Client.field1168[var11] * ((double)Client.field1167[var11] / 100.0D)) * (double)Client.field1190[var11]);
            if(var11 == 0) {
               class2.cameraX += var12;
            }

            if(var11 == 1) {
               class203.cameraZ += var12;
            }

            if(var11 == 2) {
               XItemContainer.cameraY += var12;
            }

            if(var11 == 3) {
               GraphicsObject.cameraYaw = var12 + GraphicsObject.cameraYaw & 2047;
            }

            if(var11 == 4) {
               Client.cameraPitch += var12;
               if(Client.cameraPitch < 128) {
                  Client.cameraPitch = 128;
               }

               if(Client.cameraPitch > 383) {
                  Client.cameraPitch = 383;
               }
            }
         }
      }

      var11 = class59.field729;
      var12 = class59.field715;
      if(class59.field713 != 0) {
         var11 = class59.field723;
         var12 = class59.field724;
      }

      if(var11 >= var0 && var11 < var0 + var2 && var12 >= var1 && var12 < var1 + var3) {
         var13 = var11 - var0;
         var14 = var12 - var1;
         class134.field2001 = var13;
         class134.field2003 = var14;
         class134.field2007 = true;
         class134.field2009 = 0;
         class134.field2004 = false;
      } else {
         class14.method103();
      }

      class24.method202();
      Rasterizer2D.method5040(var0, var1, var2, var3, 0);
      class24.method202();
      var13 = class136.field2028;
      class136.field2028 = Client.scale;
      class61.region.method2716(class2.cameraX, class203.cameraZ, XItemContainer.cameraY, Client.cameraPitch, GraphicsObject.cameraYaw, var5);
      class211.method3948();
      class136.field2028 = var13;
      class24.method202();
      class61.region.method2689();
      class89.method1696(var0, var1, var2, var3);
      GroundObject.method2496(var0, var1);
      ((TextureProvider)class136.field2039).method2405(Client.field990);
      ChatMessages.method1800(var0, var1, var2, var3);
      class2.cameraX = var6;
      class203.cameraZ = var7;
      XItemContainer.cameraY = var8;
      Client.cameraPitch = var9;
      GraphicsObject.cameraYaw = var10;
      if(Client.field921 && FileOnDisk.method2385(true, false) == 0) {
         Client.field921 = false;
      }

      if(Client.field921) {
         Rasterizer2D.method5040(var0, var1, var2, var3, 0);
         class157.method2976("Loading - please wait.", false);
      }

   }

   static {
      field3673 = new char[]{'€', '\u0000', '‚', 'ƒ', '„', '…', '†', '‡', 'ˆ', '‰', 'Š', '‹', 'Œ', '\u0000', 'Ž', '\u0000', '\u0000', '‘', '’', '“', '”', '•', '–', '—', '˜', '™', 'š', '›', 'œ', '\u0000', 'ž', 'Ÿ'};
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "-144193670"
   )
   static String method4883(byte[] var0, int var1, int var2) {
      StringBuilder var3 = new StringBuilder();

      for(int var4 = var1; var4 < var1 + var2; var4 += 3) {
         int var5 = var0[var4] & 255;
         var3.append(class269.field3687[var5 >>> 2]);
         if(var4 < var2 - 1) {
            int var6 = var0[var4 + 1] & 255;
            var3.append(class269.field3687[(var5 & 3) << 4 | var6 >>> 4]);
            if(var4 < var2 - 2) {
               int var7 = var0[var4 + 2] & 255;
               var3.append(class269.field3687[(var6 & 15) << 2 | var7 >>> 6]).append(class269.field3687[var7 & 63]);
            } else {
               var3.append(class269.field3687[(var6 & 15) << 2]).append("=");
            }
         } else {
            var3.append(class269.field3687[(var5 & 3) << 4]).append("==");
         }
      }

      return var3.toString();
   }
}
