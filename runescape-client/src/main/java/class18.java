import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
final class class18 implements Comparator {
   @ObfuscatedName("co")
   @Export("indexSprites")
   static IndexData indexSprites;
   @ObfuscatedName("v")
   public static short[] field323;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass14;Lclass14;I)I",
      garbageValue = "-1552115287"
   )
   int method126(class14 var1, class14 var2) {
      return var1.method66().compareTo(var2.method66());
   }

   public int compare(Object var1, Object var2) {
      return this.method126((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZLjava/lang/String;ZI)V",
      garbageValue = "1172978501"
   )
   public static void method131(String var0, boolean var1, String var2, boolean var3) {
      if(var1) {
         if(!var3 && Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var5) {
               ;
            }
         }

         if(class56.field705.startsWith("win") && !var3) {
            class19.method139(var0, 0);
            return;
         }

         if(class56.field705.startsWith("mac")) {
            class215.method3969(var0, 1, var2);
            return;
         }

         class19.method139(var0, 2);
      } else {
         class19.method139(var0, 3);
      }

   }

   @ObfuscatedName("fo")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-26"
   )
   static final void method132() {
      if(WallObject.plane != Client.field1154) {
         Client.field1154 = WallObject.plane;
         int var0 = WallObject.plane;
         int[] var1 = class59.field758.image;
         int var2 = var1.length;

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            var1[var3] = 0;
         }

         int var4;
         int var5;
         for(var3 = 1; var3 < 103; ++var3) {
            var4 = 2048 * (103 - var3) + 24628;

            for(var5 = 1; var5 < 103; ++var5) {
               if((class61.tileSettings[var0][var5][var3] & 24) == 0) {
                  class2.region.method2788(var1, var4, 512, var0, var5, var3);
               }

               if(var0 < 3 && (class61.tileSettings[1 + var0][var5][var3] & 8) != 0) {
                  class2.region.method2788(var1, var4, 512, var0 + 1, var5, var3);
               }

               var4 += 4;
            }
         }

         var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
         var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
         class59.field758.method5059();

         int var6;
         for(var5 = 1; var5 < 103; ++var5) {
            for(var6 = 1; var6 < 103; ++var6) {
               if((class61.tileSettings[var0][var6][var5] & 24) == 0) {
                  class222.method4071(var0, var6, var5, var3, var4);
               }

               if(var0 < 3 && (class61.tileSettings[1 + var0][var6][var5] & 8) != 0) {
                  class222.method4071(var0 + 1, var6, var5, var3, var4);
               }
            }
         }

         Client.field1155 = 0;

         for(var5 = 0; var5 < 104; ++var5) {
            for(var6 = 0; var6 < 104; ++var6) {
               int var7 = class2.region.method2695(WallObject.plane, var5, var6);
               if(var7 != 0) {
                  var7 = var7 >> 14 & 32767;
                  int var8 = class251.getObjectDefinition(var7).mapIconId;
                  if(var8 >= 0) {
                     int var9 = var5;
                     int var10 = var6;
                     if(var8 != 22 && var8 != 29 && var8 != 34 && var8 != 36 && var8 != 46 && var8 != 47 && var8 != 48) {
                        int[][] var13 = Client.collisionMaps[WallObject.plane].flags;

                        for(int var14 = 0; var14 < 10; ++var14) {
                           int var15 = (int)(Math.random() * 4.0D);
                           if(var15 == 0 && var9 > 0 && var9 > var5 - 3 && (var13[var9 - 1][var10] & 19136776) == 0) {
                              --var9;
                           }

                           if(var15 == 1 && var9 < 103 && var9 < var5 + 3 && (var13[var9 + 1][var10] & 19136896) == 0) {
                              ++var9;
                           }

                           if(var15 == 2 && var10 > 0 && var10 > var6 - 3 && (var13[var9][var10 - 1] & 19136770) == 0) {
                              --var10;
                           }

                           if(var15 == 3 && var10 < 103 && var10 < var6 + 3 && (var13[var9][var10 + 1] & 19136800) == 0) {
                              ++var10;
                           }
                        }
                     }

                     Client.field927[Client.field1155] = Area.field3303[var8].method4291(false);
                     Client.field1156[Client.field1155] = var9;
                     Client.field1011[Client.field1155] = var10;
                     ++Client.field1155;
                  }
               }
            }
         }

         class43.field602.method5006();
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;IZI)LFrames;",
      garbageValue = "-1506743544"
   )
   public static Frames method133(IndexDataBase var0, IndexDataBase var1, int var2, boolean var3) {
      boolean var4 = true;
      int[] var5 = var0.method4121(var2);

      for(int var6 = 0; var6 < var5.length; ++var6) {
         byte[] var7 = var0.method4185(var2, var5[var6]);
         if(var7 == null) {
            var4 = false;
         } else {
            int var8 = (var7[0] & 255) << 8 | var7[1] & 255;
            byte[] var9 = var1.method4185(var8, 0);
            if(var9 == null) {
               var4 = false;
            }
         }
      }

      if(!var4) {
         return null;
      } else {
         try {
            return new Frames(var0, var1, var2, var3);
         } catch (Exception var11) {
            return null;
         }
      }
   }
}
