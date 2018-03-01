import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jw")
@Implements("Area")
public class Area extends CacheableNode {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   static IndexDataBase field3468;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "[Ljw;"
   )
   @Export("mapAreaType")
   public static Area[] mapAreaType;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   @Export("areaSpriteCache")
   static NodeCache areaSpriteCache;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2136363795
   )
   @Export("id")
   public final int id;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1767204583
   )
   @Export("spriteId")
   public int spriteId;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1784232229
   )
   int field3453;
   @ObfuscatedName("s")
   @Export("name")
   public String name;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2027048553
   )
   public int field3448;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1753781445
   )
   public int field3456;
   @ObfuscatedName("h")
   public String[] field3467;
   @ObfuscatedName("t")
   public String field3462;
   @ObfuscatedName("i")
   int[] field3459;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1165347665
   )
   int field3460;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1515510825
   )
   int field3461;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1245227655
   )
   int field3457;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1631793341
   )
   int field3454;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Ljz;"
   )
   public class284 field3464;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ljh;"
   )
   public class266 field3463;
   @ObfuscatedName("j")
   int[] field3466;
   @ObfuscatedName("l")
   byte[] field3465;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1383188119
   )
   public int field3451;

   static {
      areaSpriteCache = new NodeCache(256);
   }

   Area(int var1) {
      this.spriteId = -1;
      this.field3453 = -1;
      this.field3456 = 0;
      this.field3467 = new String[5];
      this.field3460 = Integer.MAX_VALUE;
      this.field3461 = Integer.MAX_VALUE;
      this.field3457 = Integer.MIN_VALUE;
      this.field3454 = Integer.MIN_VALUE;
      this.field3464 = class284.field3696;
      this.field3463 = class266.field3434;
      this.field3451 = -1;
      this.id = var1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lgy;B)V",
      garbageValue = "-17"
   )
   void method4878(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4879(var1, var2);
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lgy;II)V",
      garbageValue = "1035224682"
   )
   void method4879(Buffer var1, int var2) {
      if(var2 == 1) {
         this.spriteId = var1.method3617();
      } else if(var2 == 2) {
         this.field3453 = var1.method3617();
      } else if(var2 == 3) {
         this.name = var1.readString();
      } else if(var2 == 4) {
         this.field3448 = var1.read24BitInt();
      } else if(var2 == 5) {
         var1.read24BitInt();
      } else if(var2 == 6) {
         this.field3456 = var1.readUnsignedByte();
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
            this.field3467[var2 - 10] = var1.readString();
         } else if(var2 == 15) {
            var3 = var1.readUnsignedByte();
            this.field3459 = new int[var3 * 2];

            int var4;
            for(var4 = 0; var4 < var3 * 2; ++var4) {
               this.field3459[var4] = var1.readShort();
            }

            var1.readInt();
            var4 = var1.readUnsignedByte();
            this.field3466 = new int[var4];

            int var5;
            for(var5 = 0; var5 < this.field3466.length; ++var5) {
               this.field3466[var5] = var1.readInt();
            }

            this.field3465 = new byte[var3];

            for(var5 = 0; var5 < var3; ++var5) {
               this.field3465[var5] = var1.readByte();
            }
         } else if(var2 != 16) {
            if(var2 == 17) {
               this.field3462 = var1.readString();
            } else if(var2 == 18) {
               var1.method3617();
            } else if(var2 == 19) {
               this.field3451 = var1.readUnsignedShort();
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
               var1.method3617();
            } else if(var2 == 28) {
               var1.readUnsignedByte();
            } else if(var2 == 29) {
               class284[] var6 = new class284[]{class284.field3695, class284.field3696, class284.field3700};
               this.field3464 = (class284)MapIcon.forOrdinal(var6, var1.readUnsignedByte());
            } else if(var2 == 30) {
               class266[] var7 = new class266[]{class266.field3439, class266.field3434, class266.field3433};
               this.field3463 = (class266)MapIcon.forOrdinal(var7, var1.readUnsignedByte());
            }
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-218327693"
   )
   void method4880() {
      if(this.field3459 != null) {
         for(int var1 = 0; var1 < this.field3459.length; var1 += 2) {
            if(this.field3459[var1] < this.field3460) {
               this.field3460 = this.field3459[var1];
            } else if(this.field3459[var1] > this.field3457) {
               this.field3457 = this.field3459[var1];
            }

            if(this.field3459[var1 + 1] < this.field3461) {
               this.field3461 = this.field3459[var1 + 1];
            } else if(this.field3459[var1 + 1] > this.field3454) {
               this.field3454 = this.field3459[var1 + 1];
            }
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ZB)Lly;",
      garbageValue = "-84"
   )
   @Export("getMapIcon")
   public SpritePixels getMapIcon(boolean var1) {
      int var2 = this.spriteId;
      return this.method4882(var2);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)Lly;",
      garbageValue = "1742503797"
   )
   SpritePixels method4882(int var1) {
      if(var1 < 0) {
         return null;
      } else {
         SpritePixels var2 = (SpritePixels)areaSpriteCache.get((long)var1);
         if(var2 != null) {
            return var2;
         } else {
            var2 = class45.method640(field3468, var1, 0);
            if(var2 != null) {
               areaSpriteCache.put(var2, (long)var1);
            }

            return var2;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-89"
   )
   public int method4883() {
      return this.id;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)[Lly;",
      garbageValue = "95"
   )
   static SpritePixels[] method4898() {
      SpritePixels[] var0 = new SpritePixels[class18.field325];

      for(int var1 = 0; var1 < class18.field325; ++var1) {
         SpritePixels var2 = var0[var1] = new SpritePixels();
         var2.maxWidth = class332.field3995;
         var2.maxHeight = class332.field3991;
         var2.offsetX = class332.field3990[var1];
         var2.offsetY = class332.offsetsY[var1];
         var2.width = Varbit.field3539[var1];
         var2.height = BoundingBox2D.field242[var1];
         int var3 = var2.height * var2.width;
         byte[] var4 = class332.spritePixels[var1];
         var2.pixels = new int[var3];

         for(int var5 = 0; var5 < var3; ++var5) {
            var2.pixels[var5] = class332.field3994[var4[var5] & 255];
         }
      }

      class151.method3208();
      return var0;
   }
}
