import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bk")
@Implements("WidgetNode")
public class WidgetNode extends Node {
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      longValue = 6761440148330626499L
   )
   static long field838;
   @ObfuscatedName("l")
   static int[] field837;
   @ObfuscatedName("e")
   boolean field836;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 658957821
   )
   @Export("id")
   int id;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1203970345
   )
   @Export("owner")
   int owner;

   WidgetNode() {
      this.field836 = false;
   }

   @ObfuscatedName("jr")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1254442523"
   )
   static final void method1139(int var0) {
      ItemLayer.method2495();
      WorldMapType3.method193();
      int var1 = Buffer.method3461(var0).configType;
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

            if(var3 != Client.field976) {
               if(Client.field976 == 0 && Client.field1086 != -1) {
                  IndexFile.method3094(class268.indexTrack1, Client.field1086, 0, var3, false);
                  Client.field1151 = false;
               } else if(var3 == 0) {
                  CombatInfoListHolder.method1750();
                  Client.field1151 = false;
               } else {
                  class43.method627(var3);
               }

               Client.field976 = var3;
            }
         }

         if(var1 == 4) {
            if(var2 == 0) {
               Client.field942 = 127;
            }

            if(var2 == 1) {
               Client.field942 = 96;
            }

            if(var2 == 2) {
               Client.field942 = 64;
            }

            if(var2 == 3) {
               Client.field942 = 32;
            }

            if(var2 == 4) {
               Client.field942 = 0;
            }
         }

         if(var1 == 5) {
            Client.field1050 = var2;
         }

         if(var1 == 6) {
            Client.field1075 = var2;
         }

         if(var1 == 9) {
            Client.field1076 = var2;
         }

         if(var1 == 10) {
            if(var2 == 0) {
               Client.field1114 = 127;
            }

            if(var2 == 1) {
               Client.field1114 = 96;
            }

            if(var2 == 2) {
               Client.field1114 = 64;
            }

            if(var2 == 3) {
               Client.field1114 = 32;
            }

            if(var2 == 4) {
               Client.field1114 = 0;
            }
         }

         if(var1 == 17) {
            Client.field1081 = var2 & '\uffff';
         }

         class89[] var4;
         if(var1 == 18) {
            var4 = new class89[]{class89.field1402, class89.field1403, class89.field1404, class89.field1401};
            Client.field946 = (class89)class48.forOrdinal(var4, var2);
            if(Client.field946 == null) {
               Client.field946 = class89.field1404;
            }
         }

         if(var1 == 19) {
            if(var2 == -1) {
               Client.field1061 = -1;
            } else {
               Client.field1061 = var2 & 2047;
            }
         }

         if(var1 == 22) {
            var4 = new class89[]{class89.field1402, class89.field1403, class89.field1404, class89.field1401};
            Client.field947 = (class89)class48.forOrdinal(var4, var2);
            if(Client.field947 == null) {
               Client.field947 = class89.field1404;
            }
         }

      }
   }

   @ObfuscatedName("gm")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "929620953"
   )
   static void method1140(int var0, int var1, int var2) {
      if(Client.field942 != 0 && var1 != 0 && Client.field1154 < 50) {
         Client.field1155[Client.field1154] = var0;
         Client.field1156[Client.field1154] = var1;
         Client.field1157[Client.field1154] = var2;
         Client.audioEffects[Client.field1154] = null;
         Client.field1158[Client.field1154] = 0;
         ++Client.field1154;
      }

   }
}
