import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("in")
@Implements("Area")
public class Area extends CacheableNode {
   @ObfuscatedName("z")
   @Export("name")
   public String name;
   @ObfuscatedName("j")
   public static NodeCache field3295;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1777669767
   )
   int field3296;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -90760805
   )
   @Export("spriteId")
   public int spriteId;
   @ObfuscatedName("n")
   public static IndexDataBase field3298;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -61379385
   )
   int field3299;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1843341993
   )
   public int field3300;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -83672717
   )
   public int field3301;
   @ObfuscatedName("o")
   public String[] field3302;
   @ObfuscatedName("x")
   public String field3303;
   @ObfuscatedName("a")
   int[] field3304;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -331431277
   )
   int field3305;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 392474789
   )
   int field3306;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1677781099
   )
   public final int field3307;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1411287455
   )
   int field3308;
   @ObfuscatedName("v")
   public class257 field3309;
   @ObfuscatedName("t")
   public class239 field3310;
   @ObfuscatedName("w")
   int[] field3311;
   @ObfuscatedName("l")
   byte[] field3312;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 2015032541
   )
   public int field3313;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-2133967037"
   )
   public void method4310(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4311(var1, var2);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1785333459"
   )
   void method4311(Buffer var1, int var2) {
      if(var2 == 1) {
         this.spriteId = var1.method3338();
      } else if(var2 == 2) {
         this.field3296 = var1.method3338();
      } else if(var2 == 3) {
         this.name = var1.readString();
      } else if(var2 == 4) {
         this.field3300 = var1.read24BitInt();
      } else if(var2 == 5) {
         var1.read24BitInt();
      } else if(var2 == 6) {
         this.field3301 = var1.readUnsignedByte();
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
            this.field3302[var2 - 10] = var1.readString();
         } else if(var2 == 15) {
            var3 = var1.readUnsignedByte();
            this.field3304 = new int[var3 * 2];

            int var4;
            for(var4 = 0; var4 < var3 * 2; ++var4) {
               this.field3304[var4] = var1.readShort();
            }

            var1.readInt();
            var4 = var1.readUnsignedByte();
            this.field3311 = new int[var4];

            int var5;
            for(var5 = 0; var5 < this.field3311.length; ++var5) {
               this.field3311[var5] = var1.readInt();
            }

            this.field3312 = new byte[var3];

            for(var5 = 0; var5 < var3; ++var5) {
               this.field3312[var5] = var1.readByte();
            }
         } else if(var2 != 16) {
            if(var2 == 17) {
               this.field3303 = var1.readString();
            } else if(var2 == 18) {
               var1.method3338();
            } else if(var2 == 19) {
               this.field3313 = var1.readUnsignedShort();
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
               var1.method3338();
            } else if(var2 == 28) {
               var1.readUnsignedByte();
            } else if(var2 == 29) {
               this.field3309 = (class257)Projectile.method1737(GameEngine.method966(), var1.readUnsignedByte());
            } else if(var2 == 30) {
               this.field3310 = (class239)Projectile.method1737(class64.method1059(), var1.readUnsignedByte());
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-123138170"
   )
   public void method4312() {
      if(this.field3304 != null) {
         for(int var1 = 0; var1 < this.field3304.length; var1 += 2) {
            if(this.field3304[var1] < this.field3305) {
               this.field3305 = this.field3304[var1];
            } else if(this.field3304[var1] > this.field3299) {
               this.field3299 = this.field3304[var1];
            }

            if(this.field3304[var1 + 1] < this.field3306) {
               this.field3306 = this.field3304[var1 + 1];
            } else if(this.field3304[var1 + 1] > this.field3308) {
               this.field3308 = this.field3304[var1 + 1];
            }
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IS)LSpritePixels;",
      garbageValue = "128"
   )
   SpritePixels method4314(int var1) {
      if(var1 < 0) {
         return null;
      } else {
         SpritePixels var2 = (SpritePixels)field3295.get((long)var1);
         if(var2 != null) {
            return var2;
         } else {
            var2 = WallObject.method2876(field3298, var1, 0);
            if(var2 != null) {
               field3295.put(var2, (long)var1);
            }

            return var2;
         }
      }
   }

   static {
      field3295 = new NodeCache(256);
   }

   public Area(int var1) {
      this.spriteId = -1;
      this.field3296 = -1;
      this.field3301 = 0;
      this.field3302 = new String[5];
      this.field3305 = Integer.MAX_VALUE;
      this.field3306 = Integer.MAX_VALUE;
      this.field3299 = Integer.MIN_VALUE;
      this.field3308 = Integer.MIN_VALUE;
      this.field3309 = class257.field3555;
      this.field3310 = class239.field3274;
      this.field3313 = -1;
      this.field3307 = var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ZI)LSpritePixels;",
      garbageValue = "462678570"
   )
   public SpritePixels method4325(boolean var1) {
      int var2 = this.spriteId;
      return this.method4314(var2);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-10524"
   )
   public int method4327() {
      return this.field3307;
   }
}
