import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fr")
public class class171 {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lfr;"
   )
   public static final class171 field2274;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lfr;"
   )
   public static final class171 field2267;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lfr;"
   )
   public static final class171 field2269;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lfr;"
   )
   public static final class171 field2270;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lfr;"
   )
   public static final class171 field2271;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lfr;"
   )
   public static final class171 field2276;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lfr;"
   )
   public static final class171 field2273;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lfr;"
   )
   public static final class171 field2268;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lfr;"
   )
   public static final class171 field2275;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lfr;"
   )
   public static final class171 field2272;

   static {
      field2274 = new class171(14);
      field2267 = new class171(5);
      field2269 = new class171(2);
      field2270 = new class171(4);
      field2271 = new class171(15);
      field2276 = new class171(5);
      field2273 = new class171(7);
      field2268 = new class171(6);
      field2275 = new class171(4);
      field2272 = new class171(3);
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "14"
   )
   class171(int var1) {
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-423054347"
   )
   static void method3474() {
      class50.tileUnderlayIds = null;
      class139.tileOverlayIds = null;
      NPC.tileOverlayPath = null;
      class50.overlayRotations = null;
      MouseRecorder.field534 = null;
      class50.field449 = null;
      WorldMapDecoration.field162 = null;
      class50.floorHues = null;
      Size.floorSaturations = null;
      class50.field451 = null;
      MapIconReference.floorMultiplier = null;
      class50.field452 = null;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(CI)C",
      garbageValue = "999018951"
   )
   static char method3473(char var0) {
      switch(var0) {
      case ' ':
      case '-':
      case '_':
      case ' ':
         return '_';
      case '#':
      case '[':
      case ']':
         return var0;
      case 'À':
      case 'Á':
      case 'Â':
      case 'Ã':
      case 'Ä':
      case 'à':
      case 'á':
      case 'â':
      case 'ã':
      case 'ä':
         return 'a';
      case 'Ç':
      case 'ç':
         return 'c';
      case 'È':
      case 'É':
      case 'Ê':
      case 'Ë':
      case 'è':
      case 'é':
      case 'ê':
      case 'ë':
         return 'e';
      case 'Í':
      case 'Î':
      case 'Ï':
      case 'í':
      case 'î':
      case 'ï':
         return 'i';
      case 'Ñ':
      case 'ñ':
         return 'n';
      case 'Ò':
      case 'Ó':
      case 'Ô':
      case 'Õ':
      case 'Ö':
      case 'ò':
      case 'ó':
      case 'ô':
      case 'õ':
      case 'ö':
         return 'o';
      case 'Ù':
      case 'Ú':
      case 'Û':
      case 'Ü':
      case 'ù':
      case 'ú':
      case 'û':
      case 'ü':
         return 'u';
      case 'ß':
         return 'b';
      case 'ÿ':
      case 'Ÿ':
         return 'y';
      default:
         return Character.toLowerCase(var0);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIIIZB)Llc;",
      garbageValue = "62"
   )
   @Export("createSprite")
   public static final SpritePixels createSprite(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(var1 == -1) {
         var4 = 0;
      } else if(var4 == 2 && var1 != 1) {
         var4 = 1;
      }

      long var6 = ((long)var3 << 42) + ((long)var4 << 40) + ((long)var2 << 38) + (long)var0 + ((long)var1 << 16);
      SpritePixels var8;
      if(!var5) {
         var8 = (SpritePixels)ItemComposition.itemSpriteCache.get(var6);
         if(var8 != null) {
            return var8;
         }
      }

      ItemComposition var9 = class120.getItemDefinition(var0);
      if(var1 > 1 && var9.countObj != null) {
         int var10 = -1;

         for(int var11 = 0; var11 < 10; ++var11) {
            if(var1 >= var9.countCo[var11] && var9.countCo[var11] != 0) {
               var10 = var9.countObj[var11];
            }
         }

         if(var10 != -1) {
            var9 = class120.getItemDefinition(var10);
         }
      }

      Model var21 = var9.getModel(1);
      if(var21 == null) {
         return null;
      } else {
         SpritePixels var22 = null;
         if(var9.notedTemplate != -1) {
            var22 = createSprite(var9.note, 10, 1, 0, 0, true);
            if(var22 == null) {
               return null;
            }
         } else if(var9.notedId != -1) {
            var22 = createSprite(var9.unnotedId, var1, var2, var3, 0, false);
            if(var22 == null) {
               return null;
            }
         } else if(var9.placeholderTemplateId != -1) {
            var22 = createSprite(var9.placeholderId, var1, 0, 0, 0, false);
            if(var22 == null) {
               return null;
            }
         }

         int[] var12 = Rasterizer2D.graphicsPixels;
         int var13 = Rasterizer2D.graphicsPixelsWidth;
         int var14 = Rasterizer2D.graphicsPixelsHeight;
         int[] var15 = new int[4];
         Rasterizer2D.copyDrawRegion(var15);
         var8 = new SpritePixels(36, 32);
         Rasterizer2D.setRasterBuffer(var8.pixels, 36, 32);
         Rasterizer2D.reset();
         Graphics3D.Rasterizer3D_method1();
         Graphics3D.method2821(16, 16);
         Graphics3D.rasterGouraudLowRes = false;
         if(var9.placeholderTemplateId != -1) {
            var22.drawAt(0, 0);
         }

         int var16 = var9.zoom2d;
         if(var5) {
            var16 = (int)((double)var16 * 1.5D);
         } else if(var2 == 2) {
            var16 = (int)(1.04D * (double)var16);
         }

         int var17 = var16 * Graphics3D.SINE[var9.xan2d] >> 16;
         int var18 = var16 * Graphics3D.COSINE[var9.xan2d] >> 16;
         var21.calculateBoundsCylinder();
         var21.method2738(0, var9.yan2d, var9.zan2d, var9.xan2d, var9.offsetX2d, var21.modelHeight / 2 + var17 + var9.offsetY2d, var18 + var9.offsetY2d);
         if(var9.notedId != -1) {
            var22.drawAt(0, 0);
         }

         if(var2 >= 1) {
            var8.method5991(1);
         }

         if(var2 >= 2) {
            var8.method5991(16777215);
         }

         if(var3 != 0) {
            var8.method5892(var3);
         }

         Rasterizer2D.setRasterBuffer(var8.pixels, 36, 32);
         if(var9.notedTemplate != -1) {
            var22.drawAt(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.isStackable == 1) {
            Font var19 = GameSocket.field2036;
            String var20;
            if(var1 < 100000) {
               var20 = "<col=ffff00>" + var1 + "</col>";
            } else if(var1 < 10000000) {
               var20 = "<col=ffffff>" + var1 / 1000 + "K" + "</col>";
            } else {
               var20 = "<col=00ff80>" + var1 / 1000000 + "M" + "</col>";
            }

            var19.method5541(var20, 0, 9, 16776960, 1);
         }

         if(!var5) {
            ItemComposition.itemSpriteCache.put(var8, var6);
         }

         Rasterizer2D.setRasterBuffer(var12, var13, var14);
         Rasterizer2D.setDrawRegion(var15);
         Graphics3D.Rasterizer3D_method1();
         Graphics3D.rasterGouraudLowRes = true;
         return var8;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1621995107"
   )
   @Export("decodeSprite")
   static void decodeSprite(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.offset = var0.length - 2;
      class319.indexedSpriteCount = var1.readUnsignedShort();
      class319.indexedSpriteOffsetXs = new int[class319.indexedSpriteCount];
      class319.indexedSpriteOffsetYs = new int[class319.indexedSpriteCount];
      class192.indexSpriteWidths = new int[class319.indexedSpriteCount];
      class319.indexedSpriteHeights = new int[class319.indexedSpriteCount];
      class294.spritePixels = new byte[class319.indexedSpriteCount][];
      var1.offset = var0.length - 7 - class319.indexedSpriteCount * 8;
      class319.indexedSpriteWidth = var1.readUnsignedShort();
      class275.indexedSpriteHeight = var1.readUnsignedShort();
      int var2 = (var1.readUnsignedByte() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class319.indexedSpriteCount; ++var3) {
         class319.indexedSpriteOffsetXs[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class319.indexedSpriteCount; ++var3) {
         class319.indexedSpriteOffsetYs[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class319.indexedSpriteCount; ++var3) {
         class192.indexSpriteWidths[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class319.indexedSpriteCount; ++var3) {
         class319.indexedSpriteHeights[var3] = var1.readUnsignedShort();
      }

      var1.offset = var0.length - 7 - class319.indexedSpriteCount * 8 - (var2 - 1) * 3;
      class319.indexedSpritePalette = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class319.indexedSpritePalette[var3] = var1.read24BitInt();
         if(class319.indexedSpritePalette[var3] == 0) {
            class319.indexedSpritePalette[var3] = 1;
         }
      }

      var1.offset = 0;

      for(var3 = 0; var3 < class319.indexedSpriteCount; ++var3) {
         int var4 = class192.indexSpriteWidths[var3];
         int var5 = class319.indexedSpriteHeights[var3];
         int var6 = var4 * var5;
         byte[] var7 = new byte[var6];
         class294.spritePixels[var3] = var7;
         int var8 = var1.readUnsignedByte();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.readByte();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var9 + var10 * var4] = var1.readByte();
               }
            }
         }
      }

   }

   @ObfuscatedName("gk")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2032412192"
   )
   static void method3470(int var0) {
      Client.field803 = 0L;
      if(var0 >= 2) {
         Client.isResized = true;
      } else {
         Client.isResized = false;
      }

      int var1 = Client.isResized?2:1;
      if(var1 == 1) {
         class37.clientInstance.method896(765, 503);
      } else {
         class37.clientInstance.method896(7680, 2160);
      }

      if(Client.gameState >= 25) {
         PacketNode var2 = DecorativeObject.method3115(ClientPacket.field2206, Client.field739.field1250);
         PacketBuffer var3 = var2.packetBuffer;
         int var4 = Client.isResized?2:1;
         var3.putByte(var4);
         var2.packetBuffer.putShort(class9.canvasWidth);
         var2.packetBuffer.putShort(class37.canvasHeight);
         Client.field739.method2019(var2);
      }

   }

   @ObfuscatedName("gl")
   @ObfuscatedSignature(
      signature = "(Lbu;I)Z",
      garbageValue = "-536291877"
   )
   static boolean method3469(Player var0) {
      if(Client.playerNameMask == 0) {
         return false;
      } else {
         boolean var1;
         if(MilliTimer.localPlayer == var0) {
            var1 = (Client.playerNameMask & 8) != 0;
            return var1;
         } else {
            var1 = class16.method188();
            boolean var2;
            if(!var1) {
               var2 = (Client.playerNameMask & 1) != 0;
               var1 = var2 && var0.isFriend();
            }

            var2 = var1;
            if(!var1) {
               boolean var3 = (Client.playerNameMask & 2) != 0;
               var2 = var3 && var0.isClanMember();
            }

            return var2;
         }
      }
   }

   @ObfuscatedName("ht")
   @ObfuscatedSignature(
      signature = "(IIS)V",
      garbageValue = "14520"
   )
   @Export("groundItemSpawned")
   static final void groundItemSpawned(int var0, int var1) {
      Deque var2 = Client.groundItemDeque[class192.plane][var0][var1];
      if(var2 == null) {
         ScriptEvent.region.removeGroundItemPile(class192.plane, var0, var1);
      } else {
         long var3 = -99999999L;
         Item var5 = null;

         Item var6;
         for(var6 = (Item)var2.getFront(); var6 != null; var6 = (Item)var2.getNext()) {
            ItemComposition var7 = class120.getItemDefinition(var6.id);
            long var8 = (long)var7.price;
            if(var7.isStackable == 1) {
               var8 *= (long)(var6.quantity + 1);
            }

            if(var8 > var3) {
               var3 = var8;
               var5 = var6;
            }
         }

         if(var5 == null) {
            ScriptEvent.region.removeGroundItemPile(class192.plane, var0, var1);
         } else {
            var2.addTail(var5);
            Item var12 = null;
            Item var11 = null;

            for(var6 = (Item)var2.getFront(); var6 != null; var6 = (Item)var2.getNext()) {
               if(var6.id != var5.id) {
                  if(var12 == null) {
                     var12 = var6;
                  }

                  if(var12.id != var6.id && var11 == null) {
                     var11 = var6;
                  }
               }
            }

            long var9 = class59.method1129(var0, var1, 3, false, 0);
            ScriptEvent.region.addItemPile(class192.plane, var0, var1, class264.getTileHeight(var0 * 128 + 64, var1 * 128 + 64, class192.plane), var5, var9, var12, var11);
         }
      }
   }
}
