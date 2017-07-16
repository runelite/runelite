import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bk")
@Implements("XItemContainer")
public class XItemContainer extends Node {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   @Export("itemContainers")
   static XHashTable itemContainers;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Ljt;"
   )
   static SpritePixels field781;
   @ObfuscatedName("gc")
   @ObfuscatedSignature(
      signature = "[Ljt;"
   )
   @Export("hitmarks")
   static SpritePixels[] hitmarks;
   @ObfuscatedName("gw")
   @ObfuscatedGetter(
      intValue = 2147364451
   )
   @Export("cameraZ")
   static int cameraZ;
   @ObfuscatedName("pb")
   @ObfuscatedGetter(
      intValue = -1794970531
   )
   static int field782;
   @ObfuscatedName("j")
   @Export("itemIds")
   int[] itemIds;
   @ObfuscatedName("n")
   @Export("stackSizes")
   int[] stackSizes;

   static {
      itemContainers = new XHashTable(32);
   }

   XItemContainer() {
      this.itemIds = new int[]{-1};
      this.stackSizes = new int[]{0};
   }

   @ObfuscatedName("gv")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1190795800"
   )
   static final void method1078(int var0) {
      int[] var1 = class221.field2833.image;
      int var2 = var1.length;

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         var1[var3] = 0;
      }

      int var4;
      int var5;
      for(var3 = 1; var3 < 103; ++var3) {
         var4 = (103 - var3) * 2048 + 24628;

         for(var5 = 1; var5 < 103; ++var5) {
            if((class61.tileSettings[var0][var5][var3] & 24) == 0) {
               class29.region.method2813(var1, var4, 512, var0, var5, var3);
            }

            if(var0 < 3 && (class61.tileSettings[var0 + 1][var5][var3] & 8) != 0) {
               class29.region.method2813(var1, var4, 512, var0 + 1, var5, var3);
            }

            var4 += 4;
         }
      }

      var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
      var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
      class221.field2833.method4974();

      int var6;
      for(var5 = 1; var5 < 103; ++var5) {
         for(var6 = 1; var6 < 103; ++var6) {
            if((class61.tileSettings[var0][var6][var5] & 24) == 0) {
               class10.method57(var0, var6, var5, var3, var4);
            }

            if(var0 < 3 && (class61.tileSettings[var0 + 1][var6][var5] & 8) != 0) {
               class10.method57(var0 + 1, var6, var5, var3, var4);
            }
         }
      }

      Client.field1134 = 0;

      for(var5 = 0; var5 < 104; ++var5) {
         for(var6 = 0; var6 < 104; ++var6) {
            int var7 = class29.region.method2747(class45.plane, var5, var6);
            if(var7 != 0) {
               var7 = var7 >> 14 & 32767;
               int var8 = PlayerComposition.getObjectDefinition(var7).mapIconId;
               if(var8 >= 0) {
                  int var9 = var5;
                  int var10 = var6;
                  if(var8 != 22 && var8 != 29 && var8 != 34 && var8 != 36 && var8 != 46 && var8 != 47 && var8 != 48) {
                     int[][] var13 = Client.collisionMaps[class45.plane].flags;

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

                  Client.field1035[Client.field1134] = class54.field662[var8].method4249(false);
                  Client.field1135[Client.field1134] = var9;
                  Client.field1136[Client.field1134] = var10;
                  ++Client.field1134;
               }
            }
         }
      }

      GZipDecompressor.field2327.setRaster();
   }
}
