import java.awt.Component;
import java.awt.datatransfer.Clipboard;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
public final class class16 extends Node {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -543311955
   )
   int field224;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 59675201
   )
   int field225;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1341649477
   )
   int field226;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -815316727
   )
   int field227;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -719684489
   )
   int field228;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 214150475
   )
   int field229;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1234820559
   )
   int field230;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -887334853
   )
   int field231;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1586210435
   )
   int field232;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1104429343
   )
   int field233 = 0;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1315228599
   )
   int field234 = -1;
   @ObfuscatedName("mj")
   @ObfuscatedGetter(
      intValue = -1146887283
   )
   static int field235;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 252600267
   )
   int field236;
   @ObfuscatedName("pn")
   static Clipboard field237;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-835200473"
   )
   public static void method169(Component var0) {
      var0.setFocusTraversalKeysEnabled(false);
      var0.addKeyListener(class140.keyboard);
      var0.addFocusListener(class140.keyboard);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;I)V",
      garbageValue = "2017672306"
   )
   public static void method170(class170 var0, class170 var1) {
      NPCComposition.field916 = var0;
      class22.field584 = var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "200412938"
   )
   static final void method171() {
      if(null != class28.field671) {
         class28.field671.method3020();
         class28.field671 = null;
      }

      class31.method676();
      Frames.region.method2016();

      for(int var1 = 0; var1 < 4; ++var1) {
         Client.collisionMaps[var1].method2469();
      }

      System.gc();
      XItemContainer.method167(2);
      Client.field541 = -1;
      Client.field519 = false;

      for(class24 var0 = (class24)class24.field609.method3864(); var0 != null; var0 = (class24)class24.field609.method3851()) {
         if(var0.field601 != null) {
            class112.field1970.method1177(var0.field601);
            var0.field601 = null;
         }

         if(var0.field614 != null) {
            class112.field1970.method1177(var0.field614);
            var0.field614 = null;
         }
      }

      class24.field609.method3850();
      class127.setGameState(10);
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "355455831"
   )
   static final void method172() {
      int var0 = Actor.field887 * 128 + 64;
      int var1 = XItemContainer.field217 * 128 + 64;
      int var2 = class109.method2439(var0, var1, class145.plane) - ChatLineBuffer.field688;
      if(class79.cameraX < var0) {
         class79.cameraX += class21.field576 * (var0 - class79.cameraX) / 1000 + class180.field2958;
         if(class79.cameraX > var0) {
            class79.cameraX = var0;
         }
      }

      if(class79.cameraX > var0) {
         class79.cameraX -= class180.field2958 + (class79.cameraX - var0) * class21.field576 / 1000;
         if(class79.cameraX < var0) {
            class79.cameraX = var0;
         }
      }

      if(class10.cameraZ < var2) {
         class10.cameraZ += class180.field2958 + (var2 - class10.cameraZ) * class21.field576 / 1000;
         if(class10.cameraZ > var2) {
            class10.cameraZ = var2;
         }
      }

      if(class10.cameraZ > var2) {
         class10.cameraZ -= (class10.cameraZ - var2) * class21.field576 / 1000 + class180.field2958;
         if(class10.cameraZ < var2) {
            class10.cameraZ = var2;
         }
      }

      if(class170.cameraY < var1) {
         class170.cameraY += class21.field576 * (var1 - class170.cameraY) / 1000 + class180.field2958;
         if(class170.cameraY > var1) {
            class170.cameraY = var1;
         }
      }

      if(class170.cameraY > var1) {
         class170.cameraY -= class180.field2958 + class21.field576 * (class170.cameraY - var1) / 1000;
         if(class170.cameraY < var1) {
            class170.cameraY = var1;
         }
      }

      var0 = class13.field196 * 128 + 64;
      var1 = class110.field1945 * 128 + 64;
      var2 = class109.method2439(var0, var1, class145.plane) - class26.field630;
      int var3 = var0 - class79.cameraX;
      int var4 = var2 - class10.cameraZ;
      int var5 = var1 - class170.cameraY;
      int var6 = (int)Math.sqrt((double)(var3 * var3 + var5 * var5));
      int var7 = (int)(Math.atan2((double)var4, (double)var6) * 325.949D) & 2047;
      int var8 = (int)(Math.atan2((double)var3, (double)var5) * -325.949D) & 2047;
      if(var7 < 128) {
         var7 = 128;
      }

      if(var7 > 383) {
         var7 = 383;
      }

      if(class116.cameraPitch < var7) {
         class116.cameraPitch += (var7 - class116.cameraPitch) * FrameMap.field1827 / 1000 + Sequence.field1024;
         if(class116.cameraPitch > var7) {
            class116.cameraPitch = var7;
         }
      }

      if(class116.cameraPitch > var7) {
         class116.cameraPitch -= (class116.cameraPitch - var7) * FrameMap.field1827 / 1000 + Sequence.field1024;
         if(class116.cameraPitch < var7) {
            class116.cameraPitch = var7;
         }
      }

      int var9 = var8 - SecondaryBufferProvider.cameraYaw;
      if(var9 > 1024) {
         var9 -= 2048;
      }

      if(var9 < -1024) {
         var9 += 2048;
      }

      if(var9 > 0) {
         SecondaryBufferProvider.cameraYaw += var9 * FrameMap.field1827 / 1000 + Sequence.field1024;
         SecondaryBufferProvider.cameraYaw &= 2047;
      }

      if(var9 < 0) {
         SecondaryBufferProvider.cameraYaw -= FrameMap.field1827 * -var9 / 1000 + Sequence.field1024;
         SecondaryBufferProvider.cameraYaw &= 2047;
      }

      int var10 = var8 - SecondaryBufferProvider.cameraYaw;
      if(var10 > 1024) {
         var10 -= 2048;
      }

      if(var10 < -1024) {
         var10 += 2048;
      }

      if(var10 < 0 && var9 > 0 || var10 > 0 && var9 < 0) {
         SecondaryBufferProvider.cameraYaw = var8;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LBuffer;IIIIIII)V",
      garbageValue = "1769278496"
   )
   static final void method173(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class5.tileSettings[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.method2571();
            if(var7 == 0) {
               if(var1 == 0) {
                  int[] var8 = class5.tileHeights[0][var2];
                  int var11 = 932731 + var2 + var4;
                  int var12 = var3 + 556238 + var5;
                  int var13 = class140.method2959('넵' + var11, var12 + 91923, 4) - 128 + (class140.method2959(10294 + var11, var12 + '鎽', 2) - 128 >> 1) + (class140.method2959(var11, var12, 1) - 128 >> 2);
                  var13 = 35 + (int)(0.3D * (double)var13);
                  if(var13 < 10) {
                     var13 = 10;
                  } else if(var13 > 60) {
                     var13 = 60;
                  }

                  var8[var3] = -var13 * 8;
               } else {
                  class5.tileHeights[var1][var2][var3] = class5.tileHeights[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var14 = var0.method2571();
               if(var14 == 1) {
                  var14 = 0;
               }

               if(var1 == 0) {
                  class5.tileHeights[0][var2][var3] = -var14 * 8;
               } else {
                  class5.tileHeights[var1][var2][var3] = class5.tileHeights[var1 - 1][var2][var3] - var14 * 8;
               }
               break;
            }

            if(var7 <= 49) {
               class5.field75[var1][var2][var3] = var0.method2572();
               class212.field3169[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class13.field199[var1][var2][var3] = (byte)(var7 - 2 + var6 & 3);
            } else if(var7 <= 81) {
               class5.tileSettings[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class5.field78[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.method2571();
            if(var7 == 0) {
               break;
            }

            if(var7 == 1) {
               var0.method2571();
               break;
            }

            if(var7 <= 49) {
               var0.method2571();
            }
         }
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "653196902"
   )
   static final void method174() {
      for(int var0 = 0; var0 < Client.field319; ++var0) {
         int var1 = Client.field501[var0];
         NPC var2 = Client.cachedNPCs[var1];
         if(null != var2) {
            class62.method1302(var2, var2.composition.field899);
         }
      }

   }

   @ObfuscatedName("dq")
   @ObfuscatedSignature(
      signature = "(LWidgetNode;ZB)V",
      garbageValue = "-76"
   )
   static final void method175(WidgetNode var0, boolean var1) {
      int var2 = var0.id;
      int var3 = (int)var0.hash;
      var0.unlink();
      if(var1) {
         class0.method3(var2);
      }

      class139.method2930(var2);
      Widget var4 = class144.method3012(var3);
      if(var4 != null) {
         class166.method3253(var4);
      }

      class117.method2510();
      if(Client.widgetRoot != -1) {
         class158.method3191(Client.widgetRoot, 1);
      }

   }
}
