import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iw")
@Implements("Area")
public class Area extends CacheableNode {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   static IndexDataBase field3369;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "[Liw;"
   )
   @Export("mapAreaType")
   public static Area[] mapAreaType;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 54072319
   )
   static int field3354;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgm;"
   )
   @Export("areaSpriteCache")
   static NodeCache areaSpriteCache;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 696547951
   )
   public final int field3360;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 262475287
   )
   @Export("spriteId")
   public int spriteId;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1192934363
   )
   int field3358;
   @ObfuscatedName("r")
   @Export("name")
   public String name;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 906658865
   )
   public int field3361;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1121474569
   )
   public int field3352;
   @ObfuscatedName("x")
   public String[] field3362;
   @ObfuscatedName("q")
   public String field3366;
   @ObfuscatedName("v")
   int[] field3364;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -516152955
   )
   int field3363;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1864430367
   )
   int field3365;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -2075393721
   )
   int field3367;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -764406585
   )
   int field3368;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Ljl;"
   )
   public class268 field3356;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lih;"
   )
   public class250 field3370;
   @ObfuscatedName("e")
   int[] field3371;
   @ObfuscatedName("u")
   byte[] field3372;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1975918143
   )
   public int field3373;

   static {
      areaSpriteCache = new NodeCache(256);
   }

   Area(int var1) {
      this.spriteId = -1;
      this.field3358 = -1;
      this.field3352 = 0;
      this.field3362 = new String[5];
      this.field3363 = Integer.MAX_VALUE;
      this.field3365 = Integer.MAX_VALUE;
      this.field3367 = Integer.MIN_VALUE;
      this.field3368 = Integer.MIN_VALUE;
      this.field3356 = class268.field3602;
      this.field3370 = class250.field3339;
      this.field3373 = -1;
      this.field3360 = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgj;I)V",
      garbageValue = "1045134926"
   )
   void method4553(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4550(var1, var2);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgj;IB)V",
      garbageValue = "-6"
   )
   void method4550(Buffer var1, int var2) {
      if(var2 == 1) {
         this.spriteId = var1.method3414();
      } else if(var2 == 2) {
         this.field3358 = var1.method3414();
      } else if(var2 == 3) {
         this.name = var1.readString();
      } else if(var2 == 4) {
         this.field3361 = var1.read24BitInt();
      } else if(var2 == 5) {
         var1.read24BitInt();
      } else if(var2 == 6) {
         this.field3352 = var1.readUnsignedByte();
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
            this.field3362[var2 - 10] = var1.readString();
         } else if(var2 == 15) {
            var3 = var1.readUnsignedByte();
            this.field3364 = new int[var3 * 2];

            int var4;
            for(var4 = 0; var4 < var3 * 2; ++var4) {
               this.field3364[var4] = var1.readShort();
            }

            var1.readInt();
            var4 = var1.readUnsignedByte();
            this.field3371 = new int[var4];

            int var5;
            for(var5 = 0; var5 < this.field3371.length; ++var5) {
               this.field3371[var5] = var1.readInt();
            }

            this.field3372 = new byte[var3];

            for(var5 = 0; var5 < var3; ++var5) {
               this.field3372[var5] = var1.readByte();
            }
         } else if(var2 != 16) {
            if(var2 == 17) {
               this.field3366 = var1.readString();
            } else if(var2 == 18) {
               var1.method3414();
            } else if(var2 == 19) {
               this.field3373 = var1.readUnsignedShort();
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
               var1.method3414();
            } else if(var2 == 28) {
               var1.readUnsignedByte();
            } else if(var2 == 29) {
               this.field3356 = (class268)ClanMember.forOrdinal(ObjectComposition.method4825(), var1.readUnsignedByte());
            } else if(var2 == 30) {
               class250[] var6 = new class250[]{class250.field3338, class250.field3339, class250.field3340};
               this.field3370 = (class250)ClanMember.forOrdinal(var6, var1.readUnsignedByte());
            }
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "2"
   )
   void method4570() {
      if(this.field3364 != null) {
         for(int var1 = 0; var1 < this.field3364.length; var1 += 2) {
            if(this.field3364[var1] < this.field3363) {
               this.field3363 = this.field3364[var1];
            } else if(this.field3364[var1] > this.field3367) {
               this.field3367 = this.field3364[var1];
            }

            if(this.field3364[var1 + 1] < this.field3365) {
               this.field3365 = this.field3364[var1 + 1];
            } else if(this.field3364[var1 + 1] > this.field3368) {
               this.field3368 = this.field3364[var1 + 1];
            }
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ZI)Lko;",
      garbageValue = "1056195976"
   )
   @Export("getMapIcon")
   public SpritePixels getMapIcon(boolean var1) {
      int var2 = this.spriteId;
      return this.method4556(var2);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)Lko;",
      garbageValue = "-1987045263"
   )
   SpritePixels method4556(int var1) {
      if(var1 < 0) {
         return null;
      } else {
         SpritePixels var2 = (SpritePixels)areaSpriteCache.get((long)var1);
         if(var2 != null) {
            return var2;
         } else {
            var2 = BaseVarType.method17(field3369, var1, 0);
            if(var2 != null) {
               areaSpriteCache.put(var2, (long)var1);
            }

            return var2;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1006151770"
   )
   public int method4552() {
      return this.field3360;
   }
}
