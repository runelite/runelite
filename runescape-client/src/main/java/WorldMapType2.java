import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
@Implements("WorldMapType2")
public class WorldMapType2 implements WorldMapSectionBase {
   @ObfuscatedName("qk")
   @ObfuscatedSignature(
      signature = "Lr;"
   )
   @Export("grandExchangeEvents")
   static GrandExchangeEvents grandExchangeEvents;
   @ObfuscatedName("y")
   static byte[][][] field519;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1964147021
   )
   int field512;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1636152453
   )
   int field511;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1919510991
   )
   int field513;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1149828097
   )
   int field515;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1694471617
   )
   int field514;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1889803057
   )
   int field516;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Las;I)V",
      garbageValue = "1011910161"
   )
   public void vmethod763(WorldMapData var1) {
      if(var1.minX > this.field514) {
         var1.minX = this.field514;
      }

      if(var1.field448 < this.field514) {
         var1.field448 = this.field514;
      }

      if(var1.minY > this.field516) {
         var1.minY = this.field516;
      }

      if(var1.field450 < this.field516) {
         var1.field450 = this.field516;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "516050332"
   )
   public boolean containsCoord(int var1, int var2, int var3) {
      return var1 >= this.field512 && var1 < this.field511 + this.field512?var2 >> 6 == this.field513 && var3 >> 6 == this.field515:false;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "2066198604"
   )
   public boolean vmethod766(int var1, int var2) {
      return var1 >> 6 == this.field514 && var2 >> 6 == this.field516;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIB)[I",
      garbageValue = "-3"
   )
   public int[] vmethod767(int var1, int var2, int var3) {
      if(!this.containsCoord(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field514 * 64 - this.field513 * 64 + var2, var3 + (this.field516 * 64 - this.field515 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIB)Lio;",
      garbageValue = "0"
   )
   public Coordinates vmethod768(int var1, int var2) {
      if(!this.vmethod766(var1, var2)) {
         return null;
      } else {
         int var3 = this.field513 * 64 - this.field514 * 64 + var1;
         int var4 = this.field515 * 64 - this.field516 * 64 + var2;
         return new Coordinates(this.field512, var3, var4);
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lgg;B)V",
      garbageValue = "67"
   )
   public void vmethod769(Buffer var1) {
      this.field512 = var1.readUnsignedByte();
      this.field511 = var1.readUnsignedByte();
      this.field513 = var1.readUnsignedShort();
      this.field515 = var1.readUnsignedShort();
      this.field514 = var1.readUnsignedShort();
      this.field516 = var1.readUnsignedShort();
      this.method556();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "535380263"
   )
   void method556() {
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Llz;",
      garbageValue = "-863201004"
   )
   public static class320 method581(int var0) {
      class320[] var1 = new class320[]{class320.field3934, class320.field3936, class320.field3937};
      class320[] var2 = var1;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class320 var4 = var2[var3];
         if(var0 == var4.field3935) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "1878289919"
   )
   @Export("decodeSprite")
   static void decodeSprite(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.offset = var0.length - 2;
      class332.indexedSpriteCount = var1.readUnsignedShort();
      class332.indexedSpriteOffsetXs = new int[class332.indexedSpriteCount];
      WorldComparator.indexedSpriteOffsetYs = new int[class332.indexedSpriteCount];
      class332.indexSpriteWidths = new int[class332.indexedSpriteCount];
      GrandExchangeEvents.indexedSpriteHeights = new int[class332.indexedSpriteCount];
      ChatPlayer.spritePixels = new byte[class332.indexedSpriteCount][];
      var1.offset = var0.length - 7 - class332.indexedSpriteCount * 8;
      class332.indexedSpriteWidth = var1.readUnsignedShort();
      class332.indexedSpriteHeight = var1.readUnsignedShort();
      int var2 = (var1.readUnsignedByte() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class332.indexedSpriteCount; ++var3) {
         class332.indexedSpriteOffsetXs[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class332.indexedSpriteCount; ++var3) {
         WorldComparator.indexedSpriteOffsetYs[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class332.indexedSpriteCount; ++var3) {
         class332.indexSpriteWidths[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class332.indexedSpriteCount; ++var3) {
         GrandExchangeEvents.indexedSpriteHeights[var3] = var1.readUnsignedShort();
      }

      var1.offset = var0.length - 7 - class332.indexedSpriteCount * 8 - (var2 - 1) * 3;
      class332.indexedSpritePalette = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class332.indexedSpritePalette[var3] = var1.read24BitInt();
         if(class332.indexedSpritePalette[var3] == 0) {
            class332.indexedSpritePalette[var3] = 1;
         }
      }

      var1.offset = 0;

      for(var3 = 0; var3 < class332.indexedSpriteCount; ++var3) {
         int var4 = class332.indexSpriteWidths[var3];
         int var5 = GrandExchangeEvents.indexedSpriteHeights[var3];
         int var6 = var4 * var5;
         byte[] var7 = new byte[var6];
         ChatPlayer.spritePixels[var3] = var7;
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

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lbx;B)V",
      garbageValue = "35"
   )
   @Export("changeWorld")
   static void changeWorld(World var0) {
      if(var0.method1727() != Client.isMembers) {
         Client.isMembers = var0.method1727();
         boolean var1 = var0.method1727();
         if(var1 != ItemComposition.isMembersWorld) {
            ItemComposition.items.reset();
            ItemComposition.itemModelCache.reset();
            ItemComposition.itemSpriteCache.reset();
            ItemComposition.isMembersWorld = var1;
         }
      }

      class185.host = var0.address;
      Client.world = var0.id;
      Client.flags = var0.mask;
      class18.port1 = Client.socketType == 0?43594:var0.id + 40000;
      class18.port2 = Client.socketType == 0?443:var0.id + 50000;
      class47.myWorldPort = class18.port1;
   }

   @ObfuscatedName("jy")
   @ObfuscatedSignature(
      signature = "(Liz;I)Liz;",
      garbageValue = "-76229572"
   )
   static Widget method580(Widget var0) {
      Widget var2 = var0;
      int var4 = class1.getWidgetClickMask(var0);
      int var3 = var4 >> 17 & 7;
      int var5 = var3;
      Widget var1;
      if(var3 == 0) {
         var1 = null;
      } else {
         int var6 = 0;

         while(true) {
            if(var6 >= var5) {
               var1 = var2;
               break;
            }

            var2 = UnitPriceComparator.getWidget(var2.parentId);
            if(var2 == null) {
               var1 = null;
               break;
            }

            ++var6;
         }
      }

      Widget var7 = var1;
      if(var1 == null) {
         var7 = var0.dragParent;
      }

      return var7;
   }
}
