import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
@Implements("XGrandExchangeOffer")
public class XGrandExchangeOffer {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1423748413
   )
   @Export("spent")
   public int spent;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1180487959
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1940195613
   )
   @Export("price")
   public int price;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 691261489
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      longValue = 2929718482524445211L
   )
   static long field43;
   @ObfuscatedName("p")
   @Export("progress")
   byte progress;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1120496313
   )
   @Export("quantitySold")
   public int quantitySold;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1046999499"
   )
   public int method45() {
      return this.progress & 7;
   }

   public XGrandExchangeOffer() {
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIII)V",
      garbageValue = "501756353"
   )
   public static void method46(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var2 + var3) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(null == var6 || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method46(var0, var1, var2, var5 - 1);
         method46(var0, var1, var5 + 1, var3);
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-518773"
   )
   static int method47(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.method2374((long)var0);
      return var2 == null?-1:(var1 >= 0 && var1 < var2.itemIds.length?var2.itemIds[var1]:-1);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "830083863"
   )
   public int method48() {
      return (this.progress & 8) == 8?1:0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-65"
   )
   void method50(int var1) {
      this.progress &= -9;
      if(var1 == 1) {
         this.progress = (byte)(this.progress | 8);
      }

   }

   @ObfuscatedSignature(
      signature = "(LBuffer;Z)V",
      garbageValue = "0"
   )
   public XGrandExchangeOffer(Buffer var1, boolean var2) {
      this.progress = var1.readByte();
      this.itemId = var1.readUnsignedShort();
      this.price = var1.method2819();
      this.totalQuantity = var1.method2819();
      this.quantitySold = var1.method2819();
      this.spent = var1.method2819();
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2141992300"
   )
   static final void method59() {
      int var0 = 64 + ChatLineBuffer.field973 * 128;
      int var1 = 64 + class5.field58 * 128;
      int var2 = class65.method1153(var0, var1, WallObject.plane) - class0.field1;
      if(GameEngine.cameraX < var0) {
         GameEngine.cameraX += class65.field1112 + class15.field159 * (var0 - GameEngine.cameraX) / 1000;
         if(GameEngine.cameraX > var0) {
            GameEngine.cameraX = var0;
         }
      }

      if(GameEngine.cameraX > var0) {
         GameEngine.cameraX -= class65.field1112 + (GameEngine.cameraX - var0) * class15.field159 / 1000;
         if(GameEngine.cameraX < var0) {
            GameEngine.cameraX = var0;
         }
      }

      if(class40.cameraZ < var2) {
         class40.cameraZ += (var2 - class40.cameraZ) * class15.field159 / 1000 + class65.field1112;
         if(class40.cameraZ > var2) {
            class40.cameraZ = var2;
         }
      }

      if(class40.cameraZ > var2) {
         class40.cameraZ -= class65.field1112 + class15.field159 * (class40.cameraZ - var2) / 1000;
         if(class40.cameraZ < var2) {
            class40.cameraZ = var2;
         }
      }

      if(class149.cameraY < var1) {
         class149.cameraY += (var1 - class149.cameraY) * class15.field159 / 1000 + class65.field1112;
         if(class149.cameraY > var1) {
            class149.cameraY = var1;
         }
      }

      if(class149.cameraY > var1) {
         class149.cameraY -= (class149.cameraY - var1) * class15.field159 / 1000 + class65.field1112;
         if(class149.cameraY < var1) {
            class149.cameraY = var1;
         }
      }

      var0 = class152.field2086 * 128 + 64;
      var1 = Player.field249 * 128 + 64;
      var2 = class65.method1153(var0, var1, WallObject.plane) - class99.field1647;
      int var3 = var0 - GameEngine.cameraX;
      int var4 = var2 - class40.cameraZ;
      int var5 = var1 - class149.cameraY;
      int var6 = (int)Math.sqrt((double)(var5 * var5 + var3 * var3));
      int var7 = (int)(Math.atan2((double)var4, (double)var6) * 325.949D) & 2047;
      int var8 = (int)(Math.atan2((double)var3, (double)var5) * -325.949D) & 2047;
      if(var7 < 128) {
         var7 = 128;
      }

      if(var7 > 383) {
         var7 = 383;
      }

      if(class13.cameraPitch < var7) {
         class13.cameraPitch += class72.field1187 + MessageNode.field218 * (var7 - class13.cameraPitch) / 1000;
         if(class13.cameraPitch > var7) {
            class13.cameraPitch = var7;
         }
      }

      if(class13.cameraPitch > var7) {
         class13.cameraPitch -= class72.field1187 + (class13.cameraPitch - var7) * MessageNode.field218 / 1000;
         if(class13.cameraPitch < var7) {
            class13.cameraPitch = var7;
         }
      }

      int var9 = var8 - World.cameraYaw;
      if(var9 > 1024) {
         var9 -= 2048;
      }

      if(var9 < -1024) {
         var9 += 2048;
      }

      if(var9 > 0) {
         World.cameraYaw += class72.field1187 + MessageNode.field218 * var9 / 1000;
         World.cameraYaw &= 2047;
      }

      if(var9 < 0) {
         World.cameraYaw -= class72.field1187 + -var9 * MessageNode.field218 / 1000;
         World.cameraYaw &= 2047;
      }

      int var10 = var8 - World.cameraYaw;
      if(var10 > 1024) {
         var10 -= 2048;
      }

      if(var10 < -1024) {
         var10 += 2048;
      }

      if(var10 < 0 && var9 > 0 || var10 > 0 && var9 < 0) {
         World.cameraYaw = var8;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "10"
   )
   static final void method60() {
      short var0 = 256;
      int var1;
      if(class41.field827 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class41.field827 > 768) {
               class41.field829[var1] = class157.method3027(class0.field3[var1], class3.field31[var1], 1024 - class41.field827);
            } else if(class41.field827 > 256) {
               class41.field829[var1] = class3.field31[var1];
            } else {
               class41.field829[var1] = class157.method3027(class3.field31[var1], class0.field3[var1], 256 - class41.field827);
            }
         }
      } else if(class41.field831 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class41.field831 > 768) {
               class41.field829[var1] = class157.method3027(class0.field3[var1], class145.field2018[var1], 1024 - class41.field831);
            } else if(class41.field831 > 256) {
               class41.field829[var1] = class145.field2018[var1];
            } else {
               class41.field829[var1] = class157.method3027(class145.field2018[var1], class0.field3[var1], 256 - class41.field831);
            }
         }
      } else {
         for(var1 = 0; var1 < 256; ++var1) {
            class41.field829[var1] = class0.field3[var1];
         }
      }

      Rasterizer2D.method4008(class41.field818, 9, class41.field818 + 128, 7 + var0);
      class41.field821.method4142(class41.field818, 0);
      Rasterizer2D.method4037();
      var1 = 0;
      int var2 = class57.bufferProvider.width * 9 + class41.field818;

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class41.field830[var3] * (var0 - var3) / var0;
         var5 = var4 + 22;
         if(var5 < 0) {
            var5 = 0;
         }

         var1 += var5;

         for(var6 = var5; var6 < 128; ++var6) {
            var7 = class40.field806[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class41.field829[var7];
               var10 = class57.bufferProvider.pixels[var2];
               class57.bufferProvider.pixels[var2++] = (var9 * (var10 & 16711935) + var8 * (var7 & 16711935) & -16711936) + (var9 * (var10 & '\uff00') + (var7 & '\uff00') * var8 & 16711680) >> 8;
            } else {
               ++var2;
            }
         }

         var2 += var5 + class57.bufferProvider.width - 128;
      }

      Rasterizer2D.method4008(765 + class41.field818 - 128, 9, 765 + class41.field818, var0 + 7);
      CombatInfo1.field658.method4142(382 + class41.field818, 0);
      Rasterizer2D.method4037();
      var1 = 0;
      var2 = class41.field818 + 637 + class57.bufferProvider.width * 9 + 24;

      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class41.field830[var3] * (var0 - var3) / var0;
         var5 = 103 - var4;
         var2 += var4;

         for(var6 = 0; var6 < var5; ++var6) {
            var7 = class40.field806[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class41.field829[var7];
               var10 = class57.bufferProvider.pixels[var2];
               class57.bufferProvider.pixels[var2++] = (var9 * (var10 & '\uff00') + (var7 & '\uff00') * var8 & 16711680) + (var9 * (var10 & 16711935) + var8 * (var7 & 16711935) & -16711936) >> 8;
            } else {
               ++var2;
            }
         }

         var1 += 128 - var5;
         var2 += class57.bufferProvider.width - var5 - var4;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-580515392"
   )
   public static void method62() {
      Object var0 = class183.field2728;
      synchronized(class183.field2728) {
         if(class183.field2725 != 0) {
            class183.field2725 = 1;

            try {
               class183.field2728.wait();
            } catch (InterruptedException var3) {
               ;
            }
         }

      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2138878540"
   )
   void method63(int var1) {
      this.progress &= -8;
      this.progress = (byte)(this.progress | var1 & 7);
   }
}
