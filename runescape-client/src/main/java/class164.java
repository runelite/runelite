import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fo")
public class class164 {
   @ObfuscatedName("ey")
   @ObfuscatedGetter(
      intValue = -475674607
   )
   @Export("baseY")
   static int baseY;
   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "[Ljx;"
   )
   static IndexedSprite[] field2280;

   @ObfuscatedName("iy")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "798843986"
   )
   static final void method3010(int var0) {
      class18.method139();
      class48.method685();
      int var1 = class92.method1695(var0).configType;
      if(var1 != 0) {
         int var2 = class211.widgetSettings[var0];
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

            if(var3 != Client.field1139) {
               if(Client.field1139 == 0 && Client.field1140 != -1) {
                  class18.method136(class8.indexTrack1, Client.field1140, 0, var3, false);
                  Client.field1141 = false;
               } else if(var3 == 0) {
                  Client.method1459();
                  Client.field1141 = false;
               } else if(class203.field2471 != 0) {
                  WorldMapType2.field513 = var3;
               } else {
                  class203.field2470.method3642(var3);
               }

               Client.field1139 = var3;
            }
         }

         if(var1 == 4) {
            if(var2 == 0) {
               Client.field1136 = 127;
            }

            if(var2 == 1) {
               Client.field1136 = 96;
            }

            if(var2 == 2) {
               Client.field1136 = 64;
            }

            if(var2 == 3) {
               Client.field1136 = 32;
            }

            if(var2 == 4) {
               Client.field1136 = 0;
            }
         }

         if(var1 == 5) {
            Client.field1041 = var2;
         }

         if(var1 == 6) {
            Client.field916 = var2;
         }

         if(var1 == 9) {
            Client.field1067 = var2;
         }

         if(var1 == 10) {
            if(var2 == 0) {
               Client.field1035 = 127;
            }

            if(var2 == 1) {
               Client.field1035 = 96;
            }

            if(var2 == 2) {
               Client.field1035 = 64;
            }

            if(var2 == 3) {
               Client.field1035 = 32;
            }

            if(var2 == 4) {
               Client.field1035 = 0;
            }
         }

         if(var1 == 17) {
            Client.field1072 = var2 & '\uffff';
         }

         class91[] var4;
         if(var1 == 18) {
            var4 = new class91[]{class91.field1386, class91.field1388, class91.field1393, class91.field1387};
            Client.field940 = (class91)class36.forOrdinal(var4, var2);
            if(Client.field940 == null) {
               Client.field940 = class91.field1386;
            }
         }

         if(var1 == 19) {
            if(var2 == -1) {
               Client.field1033 = -1;
            } else {
               Client.field1033 = var2 & 2047;
            }
         }

         if(var1 == 22) {
            var4 = new class91[]{class91.field1386, class91.field1388, class91.field1393, class91.field1387};
            Client.field1161 = (class91)class36.forOrdinal(var4, var2);
            if(Client.field1161 == null) {
               Client.field1161 = class91.field1386;
            }
         }

      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-77"
   )
   public static boolean method3009(int var0) {
      return (var0 >> 20 & 1) != 0;
   }
}
