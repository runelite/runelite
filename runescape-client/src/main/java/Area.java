import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jz")
@Implements("Area")
public class Area extends CacheableNode {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   static IndexDataBase field3394;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1169853013
   )
   static int field3408;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("areaSpriteCache")
   static NodeCache areaSpriteCache;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1686133665
   )
   @Export("id")
   public final int id;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 199304021
   )
   @Export("spriteId")
   public int spriteId;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -575741167
   )
   int field3410;
   @ObfuscatedName("y")
   @Export("name")
   public String name;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -834872773
   )
   public int field3396;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 236392477
   )
   public int field3399;
   @ObfuscatedName("r")
   public String[] field3389;
   @ObfuscatedName("d")
   public String field3400;
   @ObfuscatedName("v")
   int[] field3401;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 21844411
   )
   int field3402;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 672763115
   )
   int field3403;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 2108620327
   )
   int field3404;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1922503989
   )
   int field3405;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ljj;"
   )
   public class277 field3390;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lif;"
   )
   public class259 field3407;
   @ObfuscatedName("j")
   int[] field3392;
   @ObfuscatedName("z")
   byte[] field3409;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 440437279
   )
   public int field3397;

   static {
      areaSpriteCache = new NodeCache(256);
   }

   Area(int var1) {
      this.spriteId = -1;
      this.field3410 = -1;
      this.field3399 = 0;
      this.field3389 = new String[5];
      this.field3402 = Integer.MAX_VALUE;
      this.field3403 = Integer.MAX_VALUE;
      this.field3404 = Integer.MIN_VALUE;
      this.field3405 = Integer.MIN_VALUE;
      this.field3390 = class277.field3627;
      this.field3407 = class259.field3380;
      this.field3397 = -1;
      this.id = var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgn;B)V",
      garbageValue = "60"
   )
   void method4750(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4737(var1, var2);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgn;II)V",
      garbageValue = "1146501345"
   )
   void method4737(Buffer var1, int var2) {
      if(var2 == 1) {
         this.spriteId = var1.method3732();
      } else if(var2 == 2) {
         this.field3410 = var1.method3732();
      } else if(var2 == 3) {
         this.name = var1.readString();
      } else if(var2 == 4) {
         this.field3396 = var1.read24BitInt();
      } else if(var2 == 5) {
         var1.read24BitInt();
      } else if(var2 == 6) {
         this.field3399 = var1.readUnsignedByte();
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
            this.field3389[var2 - 10] = var1.readString();
         } else if(var2 == 15) {
            var3 = var1.readUnsignedByte();
            this.field3401 = new int[var3 * 2];

            int var4;
            for(var4 = 0; var4 < var3 * 2; ++var4) {
               this.field3401[var4] = var1.readShort();
            }

            var1.readInt();
            var4 = var1.readUnsignedByte();
            this.field3392 = new int[var4];

            int var5;
            for(var5 = 0; var5 < this.field3392.length; ++var5) {
               this.field3392[var5] = var1.readInt();
            }

            this.field3409 = new byte[var3];

            for(var5 = 0; var5 < var3; ++var5) {
               this.field3409[var5] = var1.readByte();
            }
         } else if(var2 != 16) {
            if(var2 == 17) {
               this.field3400 = var1.readString();
            } else if(var2 == 18) {
               var1.method3732();
            } else if(var2 == 19) {
               this.field3397 = var1.readUnsignedShort();
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
               var1.method3732();
            } else if(var2 == 28) {
               var1.readUnsignedByte();
            } else if(var2 == 29) {
               class277[] var6 = new class277[]{class277.field3624, class277.field3627, class277.field3625};
               this.field3390 = (class277)Tile.forOrdinal(var6, var1.readUnsignedByte());
            } else if(var2 == 30) {
               this.field3407 = (class259)Tile.forOrdinal(WidgetNode.method1127(), var1.readUnsignedByte());
            }
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "71"
   )
   void method4738() {
      if(this.field3401 != null) {
         for(int var1 = 0; var1 < this.field3401.length; var1 += 2) {
            if(this.field3401[var1] < this.field3402) {
               this.field3402 = this.field3401[var1];
            } else if(this.field3401[var1] > this.field3404) {
               this.field3404 = this.field3401[var1];
            }

            if(this.field3401[var1 + 1] < this.field3403) {
               this.field3403 = this.field3401[var1 + 1];
            } else if(this.field3401[var1 + 1] > this.field3405) {
               this.field3405 = this.field3401[var1 + 1];
            }
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ZB)Llm;",
      garbageValue = "-102"
   )
   @Export("getMapIcon")
   public SpritePixels getMapIcon(boolean var1) {
      int var2 = this.spriteId;
      return this.method4762(var2);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)Llm;",
      garbageValue = "-2115735511"
   )
   SpritePixels method4762(int var1) {
      if(var1 < 0) {
         return null;
      } else {
         SpritePixels var2 = (SpritePixels)areaSpriteCache.get((long)var1);
         if(var2 != null) {
            return var2;
         } else {
            var2 = class19.method165(field3394, var1, 0);
            if(var2 != null) {
               areaSpriteCache.put(var2, (long)var1);
            }

            return var2;
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "60916316"
   )
   public int method4741() {
      return this.id;
   }
}
