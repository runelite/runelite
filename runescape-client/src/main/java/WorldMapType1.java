import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
@Implements("WorldMapType1")
public class WorldMapType1 implements WorldMapSectionBase {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 718514657
   )
   int field431;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -290135027
   )
   int field422;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1841560079
   )
   int field424;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -514860077
   )
   int field425;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -774022735
   )
   int field426;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -2102139241
   )
   int field427;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 2016384959
   )
   int field423;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -170744079
   )
   int field429;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1411650101
   )
   int field430;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 2109170605
   )
   int field428;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Las;I)V",
      garbageValue = "1011910161"
   )
   public void vmethod763(WorldMapData var1) {
      if(var1.minX > this.field423) {
         var1.minX = this.field423;
      }

      if(var1.field448 < this.field430) {
         var1.field448 = this.field430;
      }

      if(var1.minY > this.field429) {
         var1.minY = this.field429;
      }

      if(var1.field450 < this.field428) {
         var1.field450 = this.field428;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "516050332"
   )
   public boolean containsCoord(int var1, int var2, int var3) {
      return var1 >= this.field431 && var1 < this.field431 + this.field422?var2 >> 6 >= this.field424 && var2 >> 6 <= this.field426 && var3 >> 6 >= this.field425 && var3 >> 6 <= this.field427:false;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "2066198604"
   )
   public boolean vmethod766(int var1, int var2) {
      return var1 >> 6 >= this.field423 && var1 >> 6 <= this.field430 && var2 >> 6 >= this.field429 && var2 >> 6 <= this.field428;
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
         int[] var4 = new int[]{this.field423 * 64 - this.field424 * 64 + var2, var3 + (this.field429 * 64 - this.field425 * 64)};
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
         int var3 = this.field424 * 64 - this.field423 * 64 + var1;
         int var4 = this.field425 * 64 - this.field429 * 64 + var2;
         return new Coordinates(this.field431, var3, var4);
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lgg;B)V",
      garbageValue = "67"
   )
   public void vmethod769(Buffer var1) {
      this.field431 = var1.readUnsignedByte();
      this.field422 = var1.readUnsignedByte();
      this.field424 = var1.readUnsignedShort();
      this.field425 = var1.readUnsignedShort();
      this.field426 = var1.readUnsignedShort();
      this.field427 = var1.readUnsignedShort();
      this.field423 = var1.readUnsignedShort();
      this.field429 = var1.readUnsignedShort();
      this.field430 = var1.readUnsignedShort();
      this.field428 = var1.readUnsignedShort();
      this.method256();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-930720172"
   )
   void method256() {
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SI)V",
      garbageValue = "841424097"
   )
   public static void method273(String[] var0, short[] var1) {
      TotalQuantityComparator.method106(var0, var1, 0, var0.length - 1);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljr;Ljava/lang/String;Ljava/lang/String;I)[Llv;",
      garbageValue = "-1290490625"
   )
   @Export("getSprites")
   public static SpritePixels[] getSprites(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      SpritePixels[] var5;
      if(!class326.method5792(var0, var3, var4)) {
         var5 = null;
      } else {
         SpritePixels[] var7 = new SpritePixels[class332.indexedSpriteCount];

         for(int var8 = 0; var8 < class332.indexedSpriteCount; ++var8) {
            SpritePixels var9 = var7[var8] = new SpritePixels();
            var9.maxWidth = class332.indexedSpriteWidth;
            var9.maxHeight = class332.indexedSpriteHeight;
            var9.offsetX = class332.indexedSpriteOffsetXs[var8];
            var9.offsetY = WorldComparator.indexedSpriteOffsetYs[var8];
            var9.width = class332.indexSpriteWidths[var8];
            var9.height = GrandExchangeEvents.indexedSpriteHeights[var8];
            int var10 = var9.width * var9.height;
            byte[] var11 = ChatPlayer.spritePixels[var8];
            var9.pixels = new int[var10];

            for(int var12 = 0; var12 < var10; ++var12) {
               var9.pixels[var12] = class332.indexedSpritePalette[var11[var12] & 255];
            }
         }

         class93.method2036();
         var5 = var7;
      }

      return var5;
   }

   @ObfuscatedName("jc")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "16"
   )
   static final void method274(int var0) {
      if(class85.loadWidget(var0)) {
         Widget[] var1 = GZipDecompressor.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(var3 != null) {
               var3.field2943 = 0;
               var3.field2896 = 0;
            }
         }

      }
   }
}
