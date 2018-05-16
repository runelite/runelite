import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("in")
@Implements("Area")
public class Area extends CacheableNode {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   public static IndexDataBase field3256;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "[Lin;"
   )
   @Export("mapAreaType")
   public static Area[] mapAreaType;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -218417121
   )
   public static int field3257;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   @Export("areaSpriteCache")
   public static NodeCache areaSpriteCache;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1984544485
   )
   @Export("id")
   public final int id;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1491820591
   )
   @Export("spriteId")
   public int spriteId;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1173914367
   )
   int field3259;
   @ObfuscatedName("x")
   @Export("name")
   public String name;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1101846903
   )
   public int field3263;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 2031329049
   )
   public int field3276;
   @ObfuscatedName("d")
   public String[] field3266;
   @ObfuscatedName("s")
   public String field3270;
   @ObfuscatedName("p")
   int[] field3255;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 343486843
   )
   int field3269;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1058425241
   )
   int field3268;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1022428681
   )
   int field3271;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -103142247
   )
   int field3272;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lja;"
   )
   @Export("horizontalAlignment")
   public HorizontalAlignment horizontalAlignment;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lis;"
   )
   @Export("verticalAlignment")
   public VerticalAlignment verticalAlignment;
   @ObfuscatedName("i")
   int[] field3275;
   @ObfuscatedName("z")
   byte[] field3264;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1673978829
   )
   public int field3277;

   static {
      areaSpriteCache = new NodeCache(256);
   }

   public Area(int var1) {
      this.spriteId = -1;
      this.field3259 = -1;
      this.field3276 = 0;
      this.field3266 = new String[5];
      this.field3269 = Integer.MAX_VALUE;
      this.field3268 = Integer.MAX_VALUE;
      this.field3271 = Integer.MIN_VALUE;
      this.field3272 = Integer.MIN_VALUE;
      this.horizontalAlignment = HorizontalAlignment.field3495;
      this.verticalAlignment = VerticalAlignment.field3241;
      this.field3277 = -1;
      this.id = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgy;B)V",
      garbageValue = "81"
   )
   public void method4826(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4832(var1, var2);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgy;II)V",
      garbageValue = "-2040143632"
   )
   void method4832(Buffer var1, int var2) {
      if(var2 == 1) {
         this.spriteId = var1.method3585();
      } else if(var2 == 2) {
         this.field3259 = var1.method3585();
      } else if(var2 == 3) {
         this.name = var1.readString();
      } else if(var2 == 4) {
         this.field3263 = var1.read24BitInt();
      } else if(var2 == 5) {
         var1.read24BitInt();
      } else if(var2 == 6) {
         this.field3276 = var1.readUnsignedByte();
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
            this.field3266[var2 - 10] = var1.readString();
         } else if(var2 == 15) {
            var3 = var1.readUnsignedByte();
            this.field3255 = new int[var3 * 2];

            int var4;
            for(var4 = 0; var4 < var3 * 2; ++var4) {
               this.field3255[var4] = var1.readShort();
            }

            var1.readInt();
            var4 = var1.readUnsignedByte();
            this.field3275 = new int[var4];

            int var5;
            for(var5 = 0; var5 < this.field3275.length; ++var5) {
               this.field3275[var5] = var1.readInt();
            }

            this.field3264 = new byte[var3];

            for(var5 = 0; var5 < var3; ++var5) {
               this.field3264[var5] = var1.readByte();
            }
         } else if(var2 != 16) {
            if(var2 == 17) {
               this.field3270 = var1.readString();
            } else if(var2 == 18) {
               var1.method3585();
            } else if(var2 == 19) {
               this.field3277 = var1.readUnsignedShort();
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
               var1.method3585();
            } else if(var2 == 28) {
               var1.readUnsignedByte();
            } else if(var2 == 29) {
               this.horizontalAlignment = (HorizontalAlignment)class7.forOrdinal(class240.method4602(), var1.readUnsignedByte());
            } else if(var2 == 30) {
               VerticalAlignment[] var6 = new VerticalAlignment[]{VerticalAlignment.field3243, VerticalAlignment.field3241, VerticalAlignment.field3242};
               this.verticalAlignment = (VerticalAlignment)class7.forOrdinal(var6, var1.readUnsignedByte());
            }
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2043410865"
   )
   public void method4827() {
      if(this.field3255 != null) {
         for(int var1 = 0; var1 < this.field3255.length; var1 += 2) {
            if(this.field3255[var1] < this.field3269) {
               this.field3269 = this.field3255[var1];
            } else if(this.field3255[var1] > this.field3271) {
               this.field3271 = this.field3255[var1];
            }

            if(this.field3255[var1 + 1] < this.field3268) {
               this.field3268 = this.field3255[var1 + 1];
            } else if(this.field3255[var1 + 1] > this.field3272) {
               this.field3272 = this.field3255[var1 + 1];
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ZI)Llc;",
      garbageValue = "1484942310"
   )
   @Export("getMapIcon")
   public SpritePixels getMapIcon(boolean var1) {
      int var2 = this.spriteId;
      return this.method4830(var2);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IB)Llc;",
      garbageValue = "100"
   )
   SpritePixels method4830(int var1) {
      if(var1 < 0) {
         return null;
      } else {
         SpritePixels var2 = (SpritePixels)areaSpriteCache.get((long)var1);
         if(var2 != null) {
            return var2;
         } else {
            var2 = ChatLineBuffer.getSpriteAsSpritePixels(field3256, var1, 0);
            if(var2 != null) {
               areaSpriteCache.put(var2, (long)var1);
            }

            return var2;
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-534969127"
   )
   public int method4831() {
      return this.id;
   }
}
