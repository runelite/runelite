import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ie")
@Implements("Area")
public class Area extends CacheableNode {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   public static IndexDataBase field3391;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "[Lie;"
   )
   @Export("mapAreaType")
   public static Area[] mapAreaType;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -927293405
   )
   public static int field3382;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   @Export("areaSpriteCache")
   public static NodeCache areaSpriteCache;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 621009947
   )
   public final int field3384;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -328811769
   )
   @Export("spriteId")
   public int spriteId;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -921045421
   )
   int field3386;
   @ObfuscatedName("b")
   @Export("name")
   public String name;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1978273889
   )
   public int field3394;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 2092091675
   )
   public int field3389;
   @ObfuscatedName("u")
   public String[] field3398;
   @ObfuscatedName("p")
   public String field3393;
   @ObfuscatedName("w")
   int[] field3388;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 812183959
   )
   int field3400;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -675242191
   )
   int field3387;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1778272253
   )
   int field3395;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 2019064561
   )
   int field3396;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Ljt;"
   )
   public class268 field3397;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   public class250 field3380;
   @ObfuscatedName("l")
   int[] field3399;
   @ObfuscatedName("j")
   byte[] field3381;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1158279789
   )
   public int field3401;

   static {
      areaSpriteCache = new NodeCache(256);
   }

   public Area(int var1) {
      this.spriteId = -1;
      this.field3386 = -1;
      this.field3389 = 0;
      this.field3398 = new String[5];
      this.field3400 = Integer.MAX_VALUE;
      this.field3387 = Integer.MAX_VALUE;
      this.field3395 = Integer.MIN_VALUE;
      this.field3396 = Integer.MIN_VALUE;
      this.field3397 = class268.field3631;
      this.field3380 = class250.field3365;
      this.field3401 = -1;
      this.field3384 = var1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lgv;I)V",
      garbageValue = "-1682468168"
   )
   public void method4496(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4491(var1, var2);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lgv;II)V",
      garbageValue = "-1717127138"
   )
   void method4491(Buffer var1, int var2) {
      if(var2 == 1) {
         this.spriteId = var1.method3514();
      } else if(var2 == 2) {
         this.field3386 = var1.method3514();
      } else if(var2 == 3) {
         this.name = var1.readString();
      } else if(var2 == 4) {
         this.field3394 = var1.read24BitInt();
      } else if(var2 == 5) {
         var1.read24BitInt();
      } else if(var2 == 6) {
         this.field3389 = var1.readUnsignedByte();
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
            this.field3398[var2 - 10] = var1.readString();
         } else if(var2 == 15) {
            var3 = var1.readUnsignedByte();
            this.field3388 = new int[var3 * 2];

            int var4;
            for(var4 = 0; var4 < var3 * 2; ++var4) {
               this.field3388[var4] = var1.readShort();
            }

            var1.readInt();
            var4 = var1.readUnsignedByte();
            this.field3399 = new int[var4];

            int var5;
            for(var5 = 0; var5 < this.field3399.length; ++var5) {
               this.field3399[var5] = var1.readInt();
            }

            this.field3381 = new byte[var3];

            for(var5 = 0; var5 < var3; ++var5) {
               this.field3381[var5] = var1.readByte();
            }
         } else if(var2 != 16) {
            if(var2 == 17) {
               this.field3393 = var1.readString();
            } else if(var2 == 18) {
               var1.method3514();
            } else if(var2 == 19) {
               this.field3401 = var1.readUnsignedShort();
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
               var1.method3514();
            } else if(var2 == 28) {
               var1.readUnsignedByte();
            } else if(var2 == 29) {
               class268[] var6 = new class268[]{class268.field3631, class268.field3629, class268.field3628};
               this.field3397 = (class268)class34.forOrdinal(var6, var1.readUnsignedByte());
            } else if(var2 == 30) {
               this.field3380 = (class250)class34.forOrdinal(class29.method237(), var1.readUnsignedByte());
            }
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-485263168"
   )
   public void method4492() {
      if(this.field3388 != null) {
         for(int var1 = 0; var1 < this.field3388.length; var1 += 2) {
            if(this.field3388[var1] < this.field3400) {
               this.field3400 = this.field3388[var1];
            } else if(this.field3388[var1] > this.field3395) {
               this.field3395 = this.field3388[var1];
            }

            if(this.field3388[var1 + 1] < this.field3387) {
               this.field3387 = this.field3388[var1 + 1];
            } else if(this.field3388[var1 + 1] > this.field3396) {
               this.field3396 = this.field3388[var1 + 1];
            }
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ZI)Lkg;",
      garbageValue = "1778593956"
   )
   @Export("getMapIcon")
   public SpritePixels getMapIcon(boolean var1) {
      int var2 = this.spriteId;
      return this.method4494(var2);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IS)Lkg;",
      garbageValue = "-18171"
   )
   SpritePixels method4494(int var1) {
      if(var1 < 0) {
         return null;
      } else {
         SpritePixels var2 = (SpritePixels)areaSpriteCache.get((long)var1);
         if(var2 != null) {
            return var2;
         } else {
            var2 = GameCanvas.method772(field3391, var1, 0);
            if(var2 != null) {
               areaSpriteCache.put(var2, (long)var1);
            }

            return var2;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1171806535"
   )
   public int method4495() {
      return this.field3384;
   }
}
