import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("if")
@Implements("Area")
public class Area extends CacheableNode {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   public static IndexDataBase field3392;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Lif;"
   )
   @Export("mapAreaType")
   public static Area[] mapAreaType;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -911396983
   )
   public static int field3379;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   @Export("areaSpriteCache")
   public static NodeCache areaSpriteCache;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 593527959
   )
   public final int field3395;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1034066741
   )
   @Export("spriteId")
   public int spriteId;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1054892705
   )
   int field3391;
   @ObfuscatedName("f")
   @Export("name")
   public String name;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1308254601
   )
   public int field3385;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1334023361
   )
   public int field3386;
   @ObfuscatedName("c")
   public String[] field3387;
   @ObfuscatedName("s")
   public String field3390;
   @ObfuscatedName("n")
   int[] field3389;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1245461547
   )
   int field3381;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -561550773
   )
   int field3397;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 445777581
   )
   int field3383;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1645255103
   )
   int field3377;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   public class268 field3394;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   public class250 field3388;
   @ObfuscatedName("q")
   int[] field3396;
   @ObfuscatedName("b")
   byte[] field3393;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 141873223
   )
   public int field3398;

   static {
      areaSpriteCache = new NodeCache(256);
   }

   public Area(int var1) {
      this.spriteId = -1;
      this.field3391 = -1;
      this.field3386 = 0;
      this.field3387 = new String[5];
      this.field3381 = Integer.MAX_VALUE;
      this.field3397 = Integer.MAX_VALUE;
      this.field3383 = Integer.MIN_VALUE;
      this.field3377 = Integer.MIN_VALUE;
      this.field3394 = class268.field3614;
      this.field3388 = class250.field3363;
      this.field3398 = -1;
      this.field3395 = var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lgh;I)V",
      garbageValue = "118165631"
   )
   public void method4438(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.decode(var1, var2);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgh;II)V",
      garbageValue = "-767299717"
   )
   @Export("decode")
   void decode(Buffer var1, int var2) {
      if(var2 == 1) {
         this.spriteId = var1.method3372();
      } else if(var2 == 2) {
         this.field3391 = var1.method3372();
      } else if(var2 == 3) {
         this.name = var1.readString();
      } else if(var2 == 4) {
         this.field3385 = var1.read24BitInt();
      } else if(var2 == 5) {
         var1.read24BitInt();
      } else if(var2 == 6) {
         this.field3386 = var1.readUnsignedByte();
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
            this.field3387[var2 - 10] = var1.readString();
         } else if(var2 == 15) {
            var3 = var1.readUnsignedByte();
            this.field3389 = new int[var3 * 2];

            int var4;
            for(var4 = 0; var4 < var3 * 2; ++var4) {
               this.field3389[var4] = var1.readShort();
            }

            var1.readInt();
            var4 = var1.readUnsignedByte();
            this.field3396 = new int[var4];

            int var5;
            for(var5 = 0; var5 < this.field3396.length; ++var5) {
               this.field3396[var5] = var1.readInt();
            }

            this.field3393 = new byte[var3];

            for(var5 = 0; var5 < var3; ++var5) {
               this.field3393[var5] = var1.readByte();
            }
         } else if(var2 != 16) {
            if(var2 == 17) {
               this.field3390 = var1.readString();
            } else if(var2 == 18) {
               var1.method3372();
            } else if(var2 == 19) {
               this.field3398 = var1.readUnsignedShort();
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
               var1.method3372();
            } else if(var2 == 28) {
               var1.readUnsignedByte();
            } else if(var2 == 29) {
               this.field3394 = (class268)class91.forOrdinal(Player.method1077(), var1.readUnsignedByte());
            } else if(var2 == 30) {
               this.field3388 = (class250)class91.forOrdinal(IndexDataBase.method4253(), var1.readUnsignedByte());
            }
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "4274"
   )
   public void method4440() {
      if(this.field3389 != null) {
         for(int var1 = 0; var1 < this.field3389.length; var1 += 2) {
            if(this.field3389[var1] < this.field3381) {
               this.field3381 = this.field3389[var1];
            } else if(this.field3389[var1] > this.field3383) {
               this.field3383 = this.field3389[var1];
            }

            if(this.field3389[var1 + 1] < this.field3397) {
               this.field3397 = this.field3389[var1 + 1];
            } else if(this.field3389[var1 + 1] > this.field3377) {
               this.field3377 = this.field3389[var1 + 1];
            }
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ZS)Lks;",
      garbageValue = "32767"
   )
   @Export("getMapIcon")
   public SpritePixels getMapIcon(boolean var1) {
      int var2 = this.spriteId;
      return this.method4448(var2);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IB)Lks;",
      garbageValue = "98"
   )
   SpritePixels method4448(int var1) {
      if(var1 < 0) {
         return null;
      } else {
         SpritePixels var2 = (SpritePixels)areaSpriteCache.get((long)var1);
         if(var2 != null) {
            return var2;
         } else {
            var2 = SocketSession.getSprite(field3392, var1, 0);
            if(var2 != null) {
               areaSpriteCache.put(var2, (long)var1);
            }

            return var2;
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "5"
   )
   public int method4443() {
      return this.field3395;
   }
}
