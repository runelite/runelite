import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ie")
@Implements("Area")
public class Area extends CacheableNode {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   @Export("skeletonsIndex")
   public static NodeCache skeletonsIndex;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lif;"
   )
   public static IndexDataBase field3294;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -191653939
   )
   public static int field3291;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1044583031
   )
   @Export("spriteId")
   public int spriteId;
   @ObfuscatedName("k")
   int[] field3298;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -2073638525
   )
   public final int field3290;
   @ObfuscatedName("s")
   @Export("name")
   public String name;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   public class257 field3303;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -870586831
   )
   int field3292;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1889930291
   )
   int field3299;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   public class239 field3304;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 713641171
   )
   public int field3305;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 972442793
   )
   public int field3300;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1566987847
   )
   int field3301;
   @ObfuscatedName("u")
   public String[] field3296;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -642619181
   )
   public int field3307;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 542858165
   )
   int field3287;
   @ObfuscatedName("g")
   public String field3295;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 910839961
   )
   int field3302;
   @ObfuscatedName("z")
   int[] field3293;
   @ObfuscatedName("i")
   byte[] field3306;

   static {
      skeletonsIndex = new NodeCache(256);
   }

   public Area(int var1) {
      this.spriteId = -1;
      this.field3292 = -1;
      this.field3300 = 0;
      this.field3296 = new String[5];
      this.field3299 = Integer.MAX_VALUE;
      this.field3287 = Integer.MAX_VALUE;
      this.field3301 = Integer.MIN_VALUE;
      this.field3302 = Integer.MIN_VALUE;
      this.field3303 = class257.field3546;
      this.field3304 = class239.field3274;
      this.field3307 = -1;
      this.field3290 = var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ZI)Ljt;",
      garbageValue = "-1519748465"
   )
   public SpritePixels method4249(boolean var1) {
      int var2 = this.spriteId;
      return this.method4250(var2);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)Ljt;",
      garbageValue = "-66071668"
   )
   SpritePixels method4250(int var1) {
      if(var1 < 0) {
         return null;
      } else {
         SpritePixels var2 = (SpritePixels)skeletonsIndex.get((long)var1);
         if(var2 != null) {
            return var2;
         } else {
            var2 = class27.method217(field3294, var1, 0);
            if(var2 != null) {
               skeletonsIndex.put(var2, (long)var1);
            }

            return var2;
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lfe;II)V",
      garbageValue = "-1484379949"
   )
   void method4256(Buffer var1, int var2) {
      if(var2 == 1) {
         this.spriteId = var1.method3221();
      } else if(var2 == 2) {
         this.field3292 = var1.method3221();
      } else if(var2 == 3) {
         this.name = var1.readString();
      } else if(var2 == 4) {
         this.field3305 = var1.read24BitInt();
      } else if(var2 == 5) {
         var1.read24BitInt();
      } else if(var2 == 6) {
         this.field3300 = var1.readUnsignedByte();
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
            this.field3296[var2 - 10] = var1.readString();
         } else if(var2 == 15) {
            var3 = var1.readUnsignedByte();
            this.field3298 = new int[var3 * 2];

            int var4;
            for(var4 = 0; var4 < var3 * 2; ++var4) {
               this.field3298[var4] = var1.readShort();
            }

            var1.readInt();
            var4 = var1.readUnsignedByte();
            this.field3293 = new int[var4];

            int var5;
            for(var5 = 0; var5 < this.field3293.length; ++var5) {
               this.field3293[var5] = var1.readInt();
            }

            this.field3306 = new byte[var3];

            for(var5 = 0; var5 < var3; ++var5) {
               this.field3306[var5] = var1.readByte();
            }
         } else if(var2 != 16) {
            if(var2 == 17) {
               this.field3295 = var1.readString();
            } else if(var2 == 18) {
               var1.method3221();
            } else if(var2 == 19) {
               this.field3307 = var1.readUnsignedShort();
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
               var1.method3221();
            } else if(var2 == 28) {
               var1.readUnsignedByte();
            } else if(var2 == 29) {
               class257[] var6 = new class257[]{class257.field3545, class257.field3546, class257.field3547};
               this.field3303 = (class257)PendingSpawn.forOrdinal(var6, var1.readUnsignedByte());
            } else if(var2 == 30) {
               this.field3304 = (class239)PendingSpawn.forOrdinal(class12.method72(), var1.readUnsignedByte());
            }
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-474381425"
   )
   public int method4253() {
      return this.field3290;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lfe;I)V",
      garbageValue = "-1451049353"
   )
   public void method4247(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4256(var1, var2);
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1034953876"
   )
   public void method4252() {
      if(this.field3298 != null) {
         for(int var1 = 0; var1 < this.field3298.length; var1 += 2) {
            if(this.field3298[var1] < this.field3299) {
               this.field3299 = this.field3298[var1];
            } else if(this.field3298[var1] > this.field3301) {
               this.field3301 = this.field3298[var1];
            }

            if(this.field3298[var1 + 1] < this.field3287) {
               this.field3287 = this.field3298[var1 + 1];
            } else if(this.field3298[var1 + 1] > this.field3302) {
               this.field3302 = this.field3298[var1 + 1];
            }
         }
      }

   }
}
