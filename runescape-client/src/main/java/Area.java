import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ip")
@Implements("Area")
public class Area extends CacheableNode {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   static IndexDataBase field3376;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "[Lip;"
   )
   @Export("mapAreaType")
   public static Area[] mapAreaType;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1825310975
   )
   static int field3393;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   @Export("areaSpriteCache")
   public static NodeCache areaSpriteCache;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1572688961
   )
   public final int field3379;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1076809579
   )
   @Export("spriteId")
   public int spriteId;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1367711541
   )
   int field3381;
   @ObfuscatedName("d")
   @Export("name")
   public String name;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -53833687
   )
   public int field3383;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1621398357
   )
   public int field3378;
   @ObfuscatedName("o")
   public String[] field3397;
   @ObfuscatedName("l")
   public String field3387;
   @ObfuscatedName("f")
   int[] field3388;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -788449667
   )
   int field3389;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -559647807
   )
   int field3390;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1873958809
   )
   int field3391;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 265847559
   )
   int field3392;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Ljo;"
   )
   public class268 field3384;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lif;"
   )
   public class250 field3375;
   @ObfuscatedName("y")
   int[] field3386;
   @ObfuscatedName("n")
   byte[] field3394;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1262883045
   )
   public int field3396;

   static {
      areaSpriteCache = new NodeCache(256);
   }

   Area(int var1) {
      this.spriteId = -1;
      this.field3381 = -1;
      this.field3378 = 0;
      this.field3397 = new String[5];
      this.field3389 = Integer.MAX_VALUE;
      this.field3390 = Integer.MAX_VALUE;
      this.field3391 = Integer.MIN_VALUE;
      this.field3392 = Integer.MIN_VALUE;
      this.field3384 = class268.field3622;
      this.field3375 = class250.field3359;
      this.field3396 = -1;
      this.field3379 = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "844252908"
   )
   void method4680(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4690(var1, var2);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgy;II)V",
      garbageValue = "-892885267"
   )
   void method4690(Buffer var1, int var2) {
      if(var2 == 1) {
         this.spriteId = var1.method3715();
      } else if(var2 == 2) {
         this.field3381 = var1.method3715();
      } else if(var2 == 3) {
         this.name = var1.readString();
      } else if(var2 == 4) {
         this.field3383 = var1.read24BitInt();
      } else if(var2 == 5) {
         var1.read24BitInt();
      } else if(var2 == 6) {
         this.field3378 = var1.readUnsignedByte();
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
            this.field3397[var2 - 10] = var1.readString();
         } else if(var2 == 15) {
            var3 = var1.readUnsignedByte();
            this.field3388 = new int[var3 * 2];

            int var4;
            for(var4 = 0; var4 < var3 * 2; ++var4) {
               this.field3388[var4] = var1.readShort();
            }

            var1.readInt();
            var4 = var1.readUnsignedByte();
            this.field3386 = new int[var4];

            int var5;
            for(var5 = 0; var5 < this.field3386.length; ++var5) {
               this.field3386[var5] = var1.readInt();
            }

            this.field3394 = new byte[var3];

            for(var5 = 0; var5 < var3; ++var5) {
               this.field3394[var5] = var1.readByte();
            }
         } else if(var2 != 16) {
            if(var2 == 17) {
               this.field3387 = var1.readString();
            } else if(var2 == 18) {
               var1.method3715();
            } else if(var2 == 19) {
               this.field3396 = var1.readUnsignedShort();
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
               var1.method3715();
            } else if(var2 == 28) {
               var1.readUnsignedByte();
            } else if(var2 == 29) {
               class268[] var6 = new class268[]{class268.field3622, class268.field3623, class268.field3625};
               this.field3384 = (class268)Projectile.forOrdinal(var6, var1.readUnsignedByte());
            } else if(var2 == 30) {
               class250[] var7 = new class250[]{class250.field3359, class250.field3358, class250.field3360};
               this.field3375 = (class250)Projectile.forOrdinal(var7, var1.readUnsignedByte());
            }
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-70"
   )
   void method4682() {
      if(this.field3388 != null) {
         for(int var1 = 0; var1 < this.field3388.length; var1 += 2) {
            if(this.field3388[var1] < this.field3389) {
               this.field3389 = this.field3388[var1];
            } else if(this.field3388[var1] > this.field3391) {
               this.field3391 = this.field3388[var1];
            }

            if(this.field3388[var1 + 1] < this.field3390) {
               this.field3390 = this.field3388[var1 + 1];
            } else if(this.field3388[var1 + 1] > this.field3392) {
               this.field3392 = this.field3388[var1 + 1];
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ZI)Lki;",
      garbageValue = "2057875837"
   )
   @Export("getMapIcon")
   public SpritePixels getMapIcon(boolean var1) {
      int var2 = this.spriteId;
      return this.method4684(var2);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Lki;",
      garbageValue = "1279085000"
   )
   SpritePixels method4684(int var1) {
      if(var1 < 0) {
         return null;
      } else {
         SpritePixels var2 = (SpritePixels)areaSpriteCache.get((long)var1);
         if(var2 != null) {
            return var2;
         } else {
            var2 = ScriptEvent.method1074(field3376, var1, 0);
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
      garbageValue = "6658145"
   )
   public int method4685() {
      return this.field3379;
   }
}
