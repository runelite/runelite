import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
@Implements("BufferProvider")
public abstract class BufferProvider {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -2020480751
   )
   @Export("width")
   public int width;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1309804095
   )
   @Export("height")
   int height;
   @ObfuscatedName("b")
   @Export("image")
   public Image image;
   @ObfuscatedName("n")
   @Export("pixels")
   public int[] pixels;
   @ObfuscatedName("np")
   @ObfuscatedGetter(
      intValue = 204729763
   )
   static int field1447;
   @ObfuscatedName("h")
   static Widget field1448;
   @ObfuscatedName("c")
   static byte[][] field1450;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1539997246"
   )
   static final int method1728(int var0, int var1) {
      int var2 = var0 + var1 * 57;
      var2 ^= var2 << 13;
      int var3 = (789221 + var2 * var2 * 15731) * var2 + 1376312589 & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;B)V",
      garbageValue = "-15"
   )
   public abstract void init(int var1, int var2, Component var3);

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "755538366"
   )
   public final void method1730() {
      class82.setRasterBuffer(this.pixels, this.width, this.height);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIB)V",
      garbageValue = "72"
   )
   public abstract void draw(Graphics var1, int var2, int var3);

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(CII)C",
      garbageValue = "1317579468"
   )
   public static char method1733(char var0, int var1) {
      if(var0 >= 192 && var0 <= 255) {
         if(var0 >= 192 && var0 <= 198) {
            return 'A';
         }

         if(var0 == 199) {
            return 'C';
         }

         if(var0 >= 200 && var0 <= 203) {
            return 'E';
         }

         if(var0 >= 204 && var0 <= 207) {
            return 'I';
         }

         if(var0 >= 210 && var0 <= 214) {
            return 'O';
         }

         if(var0 >= 217 && var0 <= 220) {
            return 'U';
         }

         if(var0 == 221) {
            return 'Y';
         }

         if(var0 == 223) {
            return 's';
         }

         if(var0 >= 224 && var0 <= 230) {
            return 'a';
         }

         if(var0 == 231) {
            return 'c';
         }

         if(var0 >= 232 && var0 <= 235) {
            return 'e';
         }

         if(var0 >= 236 && var0 <= 239) {
            return 'i';
         }

         if(var0 >= 242 && var0 <= 246) {
            return 'o';
         }

         if(var0 >= 249 && var0 <= 252) {
            return 'u';
         }

         if(var0 == 253 || var0 == 255) {
            return 'y';
         }
      }

      if(var0 == 338) {
         return 'O';
      } else if(var0 == 339) {
         return 'o';
      } else if(var0 == 376) {
         return 'Y';
      } else {
         return var0;
      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-405298480"
   )
   static final void method1744() {
      int[] var0 = class34.field758;

      int var1;
      for(var1 = 0; var1 < class34.field763; ++var1) {
         Player var2 = Client.cachedPlayers[var0[var1]];
         if(null != var2 && var2.field832 > 0) {
            --var2.field832;
            if(var2.field832 == 0) {
               var2.overhead = null;
            }
         }
      }

      for(var1 = 0; var1 < Client.field321; ++var1) {
         int var4 = Client.field405[var1];
         NPC var3 = Client.cachedNPCs[var4];
         if(null != var3 && var3.field832 > 0) {
            --var3.field832;
            if(var3.field832 == 0) {
               var3.overhead = null;
            }
         }
      }

   }

   @ObfuscatedName("de")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1187169174"
   )
   static final void method1745(int var0) {
      Ignore.method94();
      class21.method573();
      int var1 = FaceNormal.method1951(var0).field1210;
      if(var1 != 0) {
         int var2 = class179.widgetSettings[var0];
         if(var1 == 1) {
            if(var2 == 1) {
               class94.method2137(0.9D);
               ((TextureProvider)class94.field1642).method2206(0.9D);
            }

            if(var2 == 2) {
               class94.method2137(0.8D);
               ((TextureProvider)class94.field1642).method2206(0.8D);
            }

            if(var2 == 3) {
               class94.method2137(0.7D);
               ((TextureProvider)class94.field1642).method2206(0.7D);
            }

            if(var2 == 4) {
               class94.method2137(0.6D);
               ((TextureProvider)class94.field1642).method2206(0.6D);
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

            if(Client.field516 != var3) {
               if(Client.field516 == 0 && Client.field517 != -1) {
                  class1.method16(class47.field1050, Client.field517, 0, var3, false);
                  Client.field470 = false;
               } else if(var3 == 0) {
                  class154.method3172();
                  Client.field470 = false;
               } else {
                  class110.method2408(var3);
               }

               Client.field516 = var3;
            }
         }

         if(var1 == 4) {
            if(var2 == 0) {
               Client.field519 = 127;
            }

            if(var2 == 1) {
               Client.field519 = 96;
            }

            if(var2 == 2) {
               Client.field519 = 64;
            }

            if(var2 == 3) {
               Client.field519 = 32;
            }

            if(var2 == 4) {
               Client.field519 = 0;
            }
         }

         if(var1 == 5) {
            Client.field419 = var2;
         }

         if(var1 == 6) {
            Client.field441 = var2;
         }

         if(var1 == 9) {
            Client.field549 = var2;
         }

         if(var1 == 10) {
            if(var2 == 0) {
               Client.field520 = 127;
            }

            if(var2 == 1) {
               Client.field520 = 96;
            }

            if(var2 == 2) {
               Client.field520 = 64;
            }

            if(var2 == 3) {
               Client.field520 = 32;
            }

            if(var2 == 4) {
               Client.field520 = 0;
            }
         }

         if(var1 == 17) {
            Client.field447 = var2 & '\uffff';
         }

         if(var1 == 18) {
            Client.field510 = (class21)class168.method3262(class162.method3195(), var2);
            if(Client.field510 == null) {
               Client.field510 = class21.field581;
            }
         }

         if(var1 == 19) {
            if(var2 == -1) {
               Client.field471 = -1;
            } else {
               Client.field471 = var2 & 2047;
            }
         }

         if(var1 == 22) {
            Client.field320 = (class21)class168.method3262(class162.method3195(), var2);
            if(null == Client.field320) {
               Client.field320 = class21.field581;
            }
         }

      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1257129087"
   )
   static final void method1746() {
      class38.method754();
      class38.method762();
      class127.method2807();
      ObjectComposition.field923.reset();
      ObjectComposition.field924.reset();
      ObjectComposition.field960.reset();
      ObjectComposition.field926.reset();
      class11.method140();
      class119.method2479();
      XItemContainer.method180();
      Widget.method3495();
      class112.method2455();
      CollisionData.method2449();
      class51.field1100.reset();
      class51.spriteCache.reset();
      class51.field1115.reset();
      class49.field1086.reset();
      class49.field1073.reset();
      PlayerComposition.field2962.reset();
      Widget.field2802.reset();
      Widget.field2783.reset();
      Widget.field2885.reset();
      Widget.field2785.reset();
      ((TextureProvider)class94.field1642).method2212();
      class23.field609.reset();
      class0.field16.method3297();
      class22.field589.method3297();
      class56.field1207.method3297();
      class5.field77.method3297();
      class62.field1267.method3297();
      class47.field1050.method3297();
      XItemContainer.field223.method3297();
      Item.field690.method3297();
      class133.field2113.method3297();
      XItemContainer.field226.method3297();
      class21.field585.method3297();
      Client.field531.method3297();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIII)V",
      garbageValue = "-549410354"
   )
   public abstract void drawSub(Graphics var1, int var2, int var3, int var4, int var5);
}
