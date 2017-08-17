import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
final class class12 implements Comparator {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1308993157
   )
   static int field267;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   @Export("logoSprite")
   static IndexedSprite logoSprite;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lr;Lr;B)I",
      garbageValue = "39"
   )
   int method73(class14 var1, class14 var2) {
      return var1.field293 < var2.field293?-1:(var2.field293 == var1.field293?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method73((class14)var1, (class14)var2);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-640987916"
   )
   public static int method71(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if(var4 <= 127) {
            ++var2;
         } else if(var4 <= 2047) {
            var2 += 2;
         } else {
            var2 += 3;
         }
      }

      return var2;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZI)Ldr;",
      garbageValue = "458227693"
   )
   @Export("getPreferencesFile")
   public static FileOnDisk getPreferencesFile(String var0, String var1, boolean var2) {
      File var3 = new File(class156.field2245, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            FileOnDisk var10 = new FileOnDisk(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(class91.field1417 == 33) {
         var4 = "_rc";
      } else if(class91.field1417 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(WorldMapType1.userHome, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      FileOnDisk var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new FileOnDisk(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new FileOnDisk(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "2024911810"
   )
   @Export("djb2Hash")
   public static int djb2Hash(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + class19.method146(var0.charAt(var3));
      }

      return var2;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZLjava/lang/String;ZB)V",
      garbageValue = "116"
   )
   public static void method70(String var0, boolean var1, String var2, boolean var3) {
      if(var1) {
         if(!var3 && Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var5) {
               ;
            }
         }

         if(class56.field686.startsWith("win") && !var3) {
            Tile.method2522(var0, 0);
            return;
         }

         if(class56.field686.startsWith("mac")) {
            class9.method43(var0, 1, var2);
            return;
         }

         Tile.method2522(var0, 2);
      } else {
         Tile.method2522(var0, 3);
      }

   }

   @ObfuscatedName("iu")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-21"
   )
   static final void method60(int var0) {
      CollisionData.method3075();
      GameEngine.method1029();
      int var1 = class169.method3137(var0).configType;
      if(var1 != 0) {
         int var2 = class212.widgetSettings[var0];
         if(var1 == 1) {
            if(var2 == 1) {
               Graphics3D.setBrightness(0.9D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.9D);
            }

            if(var2 == 2) {
               Graphics3D.setBrightness(0.8D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.8D);
            }

            if(var2 == 3) {
               Graphics3D.setBrightness(0.7D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.7D);
            }

            if(var2 == 4) {
               Graphics3D.setBrightness(0.6D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.6D);
            }

            ItemComposition.itemSpriteCache.reset();
         }

         if(var1 == 3) {
            short var3 = 0;
            if(var2 == 0) {
               var3 = 255;
            }

            if(var2 == 1) {
               var3 = 192;
            }

            if(var2 == 2) {
               var3 = 128;
            }

            if(var2 == 3) {
               var3 = 64;
            }

            if(var2 == 4) {
               var3 = 0;
            }

            if(var3 != Client.field1024) {
               if(Client.field1024 == 0 && Client.field1095 != -1) {
                  class66.method1144(class253.indexTrack1, Client.field1095, 0, var3, false);
                  Client.field1163 = false;
               } else if(var3 == 0) {
                  class204.field2501.method3758();
                  class204.field2507 = 1;
                  class204.field2502 = null;
                  Client.field1163 = false;
               } else {
                  class222.method4083(var3);
               }

               Client.field1024 = var3;
            }
         }

         if(var1 == 4) {
            if(var2 == 0) {
               Client.field974 = 127;
            }

            if(var2 == 1) {
               Client.field974 = 96;
            }

            if(var2 == 2) {
               Client.field974 = 64;
            }

            if(var2 == 3) {
               Client.field974 = 32;
            }

            if(var2 == 4) {
               Client.field974 = 0;
            }
         }

         if(var1 == 5) {
            Client.field1062 = var2;
         }

         if(var1 == 6) {
            Client.field1088 = var2;
         }

         if(var1 == 9) {
            Client.field1089 = var2;
         }

         if(var1 == 10) {
            if(var2 == 0) {
               Client.field1148 = 127;
            }

            if(var2 == 1) {
               Client.field1148 = 96;
            }

            if(var2 == 2) {
               Client.field1148 = 64;
            }

            if(var2 == 3) {
               Client.field1148 = 32;
            }

            if(var2 == 4) {
               Client.field1148 = 0;
            }
         }

         if(var1 == 17) {
            Client.field1094 = var2 & '\uffff';
         }

         class92[] var4;
         if(var1 == 18) {
            var4 = new class92[]{class92.field1422, class92.field1424, class92.field1423, class92.field1426};
            Client.field959 = (class92)PlayerComposition.forOrdinal(var4, var2);
            if(Client.field959 == null) {
               Client.field959 = class92.field1426;
            }
         }

         if(var1 == 19) {
            if(var2 == -1) {
               Client.field1054 = -1;
            } else {
               Client.field1054 = var2 & 2047;
            }
         }

         if(var1 == 22) {
            var4 = new class92[]{class92.field1422, class92.field1424, class92.field1423, class92.field1426};
            Client.field1117 = (class92)PlayerComposition.forOrdinal(var4, var2);
            if(Client.field1117 == null) {
               Client.field1117 = class92.field1426;
            }
         }

      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ILcj;ZI)I",
      garbageValue = "1786014469"
   )
   static int method59(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class84.method1670(class84.intStack[--class84.intStackSize]);
      } else {
         var3 = var2?class43.field582:class208.field2580;
      }

      class90.method1723(var3);
      if(var0 != 1200 && var0 != 1205 && var0 != 1212) {
         if(var0 == 1201) {
            var3.modelType = 2;
            var3.modelId = class84.intStack[--class84.intStackSize];
            return 1;
         } else if(var0 == 1202) {
            var3.modelType = 3;
            var3.modelId = XGrandExchangeOffer.localPlayer.composition.method3966();
            return 1;
         } else {
            return 2;
         }
      } else {
         class84.intStackSize -= 2;
         int var4 = class84.intStack[class84.intStackSize];
         int var5 = class84.intStack[class84.intStackSize + 1];
         var3.itemId = var4;
         var3.itemQuantity = var5;
         ItemComposition var6 = SoundTask.getItemDefinition(var4);
         var3.rotationX = var6.xan2d;
         var3.rotationZ = var6.yan2d;
         var3.rotationY = var6.zan2d;
         var3.field2698 = var6.offsetX2d;
         var3.field2699 = var6.offsetY2d;
         var3.modelZoom = var6.zoom2d;
         if(var0 == 1205) {
            var3.field2707 = 0;
         } else if(var0 == 1212 | 1 == var6.isStackable) {
            var3.field2707 = 1;
         } else {
            var3.field2707 = 2;
         }

         if(var3.field2704 > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.field2704;
         } else if(var3.originalWidth > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.originalWidth;
         }

         return 1;
      }
   }
}
