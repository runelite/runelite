import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ja")
@Implements("Area")
public class Area extends CacheableNode {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   public static IndexDataBase field3456;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "[Lja;"
   )
   @Export("mapAreaType")
   public static Area[] mapAreaType;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1478509921
   )
   public static int field3450;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("areaSpriteCache")
   public static NodeCache areaSpriteCache;
   @ObfuscatedName("gc")
   @ObfuscatedGetter(
      intValue = -1747289681
   )
   @Export("cameraZ")
   static int cameraZ;
   @ObfuscatedName("gr")
   @ObfuscatedGetter(
      intValue = -1763106337
   )
   static int field3457;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 969341623
   )
   @Export("id")
   public final int id;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 589537747
   )
   @Export("spriteId")
   public int spriteId;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -76584199
   )
   int field3454;
   @ObfuscatedName("p")
   @Export("name")
   public String name;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1140034543
   )
   public int field3459;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1182410567
   )
   public int field3449;
   @ObfuscatedName("a")
   public String[] field3461;
   @ObfuscatedName("e")
   public String field3460;
   @ObfuscatedName("f")
   int[] field3453;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 642837621
   )
   int field3462;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2052848161
   )
   int field3448;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1189475407
   )
   int field3468;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 177196857
   )
   int field3465;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ljl;"
   )
   @Export("horizontalAlignment")
   public HorizontalAlignment horizontalAlignment;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Ljd;"
   )
   @Export("verticalAlignment")
   public VerticalAlignment verticalAlignment;
   @ObfuscatedName("n")
   int[] field3464;
   @ObfuscatedName("u")
   byte[] field3469;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1541046729
   )
   public int field3463;

   static {
      areaSpriteCache = new NodeCache(256);
   }

   public Area(int var1) {
      this.spriteId = -1;
      this.field3454 = -1;
      this.field3449 = 0;
      this.field3461 = new String[5];
      this.field3462 = Integer.MAX_VALUE;
      this.field3448 = Integer.MAX_VALUE;
      this.field3468 = Integer.MIN_VALUE;
      this.field3465 = Integer.MIN_VALUE;
      this.horizontalAlignment = HorizontalAlignment.field3690;
      this.verticalAlignment = VerticalAlignment.field3435;
      this.field3463 = -1;
      this.id = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lgp;I)V",
      garbageValue = "-842802464"
   )
   public void method4751(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4752(var1, var2);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgp;II)V",
      garbageValue = "2122282097"
   )
   void method4752(Buffer var1, int var2) {
      if(var2 == 1) {
         this.spriteId = var1.method3603();
      } else if(var2 == 2) {
         this.field3454 = var1.method3603();
      } else if(var2 == 3) {
         this.name = var1.readString();
      } else if(var2 == 4) {
         this.field3459 = var1.read24BitInt();
      } else if(var2 == 5) {
         var1.read24BitInt();
      } else if(var2 == 6) {
         this.field3449 = var1.readUnsignedByte();
      } else {
         int var3;
         if(var2 == 7) {
            var3 = var1.readUnsignedByte();
            if((var3 & 1) == 0) {
               ;
            }

            if((var3 & 2) == 2) {
               ;
            }
         } else if(var2 == 8) {
            var1.readUnsignedByte();
         } else if(var2 >= 10 && var2 <= 14) {
            this.field3461[var2 - 10] = var1.readString();
         } else if(var2 == 15) {
            var3 = var1.readUnsignedByte();
            this.field3453 = new int[var3 * 2];

            int var4;
            for(var4 = 0; var4 < var3 * 2; ++var4) {
               this.field3453[var4] = var1.readShort();
            }

            var1.readInt();
            var4 = var1.readUnsignedByte();
            this.field3464 = new int[var4];

            int var5;
            for(var5 = 0; var5 < this.field3464.length; ++var5) {
               this.field3464[var5] = var1.readInt();
            }

            this.field3469 = new byte[var3];

            for(var5 = 0; var5 < var3; ++var5) {
               this.field3469[var5] = var1.readByte();
            }
         } else if(var2 != 16) {
            if(var2 == 17) {
               this.field3460 = var1.readString();
            } else if(var2 == 18) {
               var1.method3603();
            } else if(var2 == 19) {
               this.field3463 = var1.readUnsignedShort();
            } else if(var2 == 21) {
               var1.readInt();
            } else if(var2 == 22) {
               var1.readInt();
            } else if(var2 == 23) {
               var1.readUnsignedByte();
               var1.readUnsignedByte();
               var1.readUnsignedByte();
            } else if(var2 == 24) {
               var1.readShort();
               var1.readShort();
            } else if(var2 == 25) {
               var1.method3603();
            } else if(var2 == 28) {
               var1.readUnsignedByte();
            } else if(var2 == 29) {
               this.horizontalAlignment = (HorizontalAlignment)class44.forOrdinal(GraphicsObject.method1805(), var1.readUnsignedByte());
            } else if(var2 == 30) {
               this.verticalAlignment = (VerticalAlignment)class44.forOrdinal(Permission.method4534(), var1.readUnsignedByte());
            }
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   public void method4756() {
      if(this.field3453 != null) {
         for(int var1 = 0; var1 < this.field3453.length; var1 += 2) {
            if(this.field3453[var1] < this.field3462) {
               this.field3462 = this.field3453[var1];
            } else if(this.field3453[var1] > this.field3468) {
               this.field3468 = this.field3453[var1];
            }

            if(this.field3453[var1 + 1] < this.field3448) {
               this.field3448 = this.field3453[var1 + 1];
            } else if(this.field3453[var1 + 1] > this.field3465) {
               this.field3465 = this.field3453[var1 + 1];
            }
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ZI)Lla;",
      garbageValue = "-1936941675"
   )
   @Export("getMapIcon")
   public SpritePixels getMapIcon(boolean var1) {
      int var2 = this.spriteId;
      return this.method4754(var2);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Lla;",
      garbageValue = "-1662932257"
   )
   SpritePixels method4754(int var1) {
      if(var1 < 0) {
         return null;
      } else {
         SpritePixels var2 = (SpritePixels)areaSpriteCache.get((long)var1);
         if(var2 != null) {
            return var2;
         } else {
            var2 = BufferProvider.method5831(field3456, var1, 0);
            if(var2 != null) {
               areaSpriteCache.put(var2, (long)var1);
            }

            return var2;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "129877775"
   )
   public int method4755() {
      return this.id;
   }

   @ObfuscatedName("c")
   public static final int method4771(double var0, double var2, double var4) {
      double var6 = var4;
      double var8 = var4;
      double var10 = var4;
      if(0.0D != var2) {
         double var12;
         if(var4 < 0.5D) {
            var12 = var4 * (var2 + 1.0D);
         } else {
            var12 = var2 + var4 - var2 * var4;
         }

         double var14 = var4 * 2.0D - var12;
         double var16 = var0 + 0.3333333333333333D;
         if(var16 > 1.0D) {
            --var16;
         }

         double var20 = var0 - 0.3333333333333333D;
         if(var20 < 0.0D) {
            ++var20;
         }

         if(var16 * 6.0D < 1.0D) {
            var6 = var14 + (var12 - var14) * 6.0D * var16;
         } else if(var16 * 2.0D < 1.0D) {
            var6 = var12;
         } else if(var16 * 3.0D < 2.0D) {
            var6 = (var12 - var14) * (0.6666666666666666D - var16) * 6.0D + var14;
         } else {
            var6 = var14;
         }

         if(var0 * 6.0D < 1.0D) {
            var8 = var14 + var0 * 6.0D * (var12 - var14);
         } else if(2.0D * var0 < 1.0D) {
            var8 = var12;
         } else if(var0 * 3.0D < 2.0D) {
            var8 = 6.0D * (0.6666666666666666D - var0) * (var12 - var14) + var14;
         } else {
            var8 = var14;
         }

         if(var20 * 6.0D < 1.0D) {
            var10 = var20 * (var12 - var14) * 6.0D + var14;
         } else if(2.0D * var20 < 1.0D) {
            var10 = var12;
         } else if(3.0D * var20 < 2.0D) {
            var10 = var14 + 6.0D * (0.6666666666666666D - var20) * (var12 - var14);
         } else {
            var10 = var14;
         }
      }

      int var22 = (int)(var6 * 256.0D);
      int var13 = (int)(var8 * 256.0D);
      int var23 = (int)(256.0D * var10);
      int var15 = var23 + (var13 << 8) + (var22 << 16);
      return var15;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BI)Lkw;",
      garbageValue = "-1984825310"
   )
   public static Font method4772(byte[] var0) {
      if(var0 == null) {
         return null;
      } else {
         Font var1 = new Font(var0, GameCanvas.indexedSpriteOffsetXs, class332.indexedSpriteOffsetYs, class25.indexSpriteWidths, class332.indexedSpriteHeights, class332.indexedSpritePalette, class332.spritePixels);
         FileSystem.method4544();
         return var1;
      }
   }
}
