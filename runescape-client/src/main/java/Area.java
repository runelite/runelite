import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iz")
@Implements("Area")
public class Area extends CacheableNode {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   public static IndexDataBase field3381;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "[Liz;"
   )
   @Export("mapAreaType")
   public static Area[] mapAreaType;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   @Export("areaSpriteCache")
   static NodeCache areaSpriteCache;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 521842361
   )
   public final int field3366;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1578893913
   )
   @Export("spriteId")
   public int spriteId;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1664559141
   )
   int field3368;
   @ObfuscatedName("t")
   @Export("name")
   public String name;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1594928389
   )
   public int field3370;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1196388697
   )
   public int field3371;
   @ObfuscatedName("u")
   public String[] field3377;
   @ObfuscatedName("n")
   public String field3374;
   @ObfuscatedName("c")
   int[] field3375;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -2067321063
   )
   int field3367;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -486302745
   )
   int field3363;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1706802093
   )
   int field3385;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1549342781
   )
   int field3376;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   public class264 field3380;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lih;"
   )
   public class246 field3379;
   @ObfuscatedName("h")
   int[] field3382;
   @ObfuscatedName("i")
   byte[] field3383;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1034426603
   )
   public int field3384;

   static {
      areaSpriteCache = new NodeCache(256);
   }

   public Area(int var1) {
      this.spriteId = -1;
      this.field3368 = -1;
      this.field3371 = 0;
      this.field3377 = new String[5];
      this.field3367 = Integer.MAX_VALUE;
      this.field3363 = Integer.MAX_VALUE;
      this.field3385 = Integer.MIN_VALUE;
      this.field3376 = Integer.MIN_VALUE;
      this.field3380 = class264.field3606;
      this.field3379 = class246.field3344;
      this.field3384 = -1;
      this.field3366 = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lfr;I)V",
      garbageValue = "-1954224840"
   )
   public void method4443(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4444(var1, var2);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lfr;II)V",
      garbageValue = "1931511997"
   )
   void method4444(Buffer var1, int var2) {
      if(var2 == 1) {
         this.spriteId = var1.method3444();
      } else if(var2 == 2) {
         this.field3368 = var1.method3444();
      } else if(var2 == 3) {
         this.name = var1.readString();
      } else if(var2 == 4) {
         this.field3370 = var1.read24BitInt();
      } else if(var2 == 5) {
         var1.read24BitInt();
      } else if(var2 == 6) {
         this.field3371 = var1.readUnsignedByte();
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
            this.field3377[var2 - 10] = var1.readString();
         } else if(var2 == 15) {
            var3 = var1.readUnsignedByte();
            this.field3375 = new int[var3 * 2];

            int var4;
            for(var4 = 0; var4 < var3 * 2; ++var4) {
               this.field3375[var4] = var1.readShort();
            }

            var1.readInt();
            var4 = var1.readUnsignedByte();
            this.field3382 = new int[var4];

            int var5;
            for(var5 = 0; var5 < this.field3382.length; ++var5) {
               this.field3382[var5] = var1.readInt();
            }

            this.field3383 = new byte[var3];

            for(var5 = 0; var5 < var3; ++var5) {
               this.field3383[var5] = var1.readByte();
            }
         } else if(var2 != 16) {
            if(var2 == 17) {
               this.field3374 = var1.readString();
            } else if(var2 == 18) {
               var1.method3444();
            } else if(var2 == 19) {
               this.field3384 = var1.readUnsignedShort();
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
               var1.method3444();
            } else if(var2 == 28) {
               var1.readUnsignedByte();
            } else if(var2 == 29) {
               this.field3380 = (class264)class94.forOrdinal(class29.method243(), var1.readUnsignedByte());
            } else if(var2 == 30) {
               class246[] var6 = new class246[]{class246.field3348, class246.field3344, class246.field3346};
               this.field3379 = (class246)class94.forOrdinal(var6, var1.readUnsignedByte());
            }
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-37"
   )
   public void method4445() {
      if(this.field3375 != null) {
         for(int var1 = 0; var1 < this.field3375.length; var1 += 2) {
            if(this.field3375[var1] < this.field3367) {
               this.field3367 = this.field3375[var1];
            } else if(this.field3375[var1] > this.field3385) {
               this.field3385 = this.field3375[var1];
            }

            if(this.field3375[var1 + 1] < this.field3363) {
               this.field3363 = this.field3375[var1 + 1];
            } else if(this.field3375[var1 + 1] > this.field3376) {
               this.field3376 = this.field3375[var1 + 1];
            }
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ZB)Lky;",
      garbageValue = "-71"
   )
   @Export("getMapIcon")
   public SpritePixels getMapIcon(boolean var1) {
      int var2 = this.spriteId;
      return this.method4462(var2);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)Lky;",
      garbageValue = "1620046659"
   )
   SpritePixels method4462(int var1) {
      if(var1 < 0) {
         return null;
      } else {
         SpritePixels var2 = (SpritePixels)areaSpriteCache.get((long)var1);
         if(var2 != null) {
            return var2;
         } else {
            var2 = ClassInfo.method5123(field3381, var1, 0);
            if(var2 != null) {
               areaSpriteCache.put(var2, (long)var1);
            }

            return var2;
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-12968333"
   )
   public int method4448() {
      return this.field3366;
   }
}
