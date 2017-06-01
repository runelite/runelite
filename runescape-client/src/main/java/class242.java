import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ie")
public class class242 extends CacheableNode {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -866825563
   )
   public final int field3289;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1154535019
   )
   public static int field3290;
   @ObfuscatedName("v")
   public static NodeCache field3291;
   @ObfuscatedName("g")
   int[] field3292;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -331293099
   )
   public int field3293;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1124069309
   )
   int field3294;
   @ObfuscatedName("x")
   public String field3295;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1769503951
   )
   public int field3296;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 780413025
   )
   public int field3297;
   @ObfuscatedName("o")
   public String[] field3298;
   @ObfuscatedName("d")
   public class257 field3299;
   @ObfuscatedName("q")
   int[] field3300;
   @ObfuscatedName("i")
   public static IndexDataBase field3301;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 94010129
   )
   int field3302;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1155778599
   )
   int field3303;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1331157689
   )
   int field3304;
   @ObfuscatedName("s")
   public class239 field3306;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1598702307
   )
   int field3307;
   @ObfuscatedName("z")
   public String field3308;
   @ObfuscatedName("w")
   byte[] field3309;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 829573215
   )
   public int field3310;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "917426542"
   )
   void method4295(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3293 = var1.method3156();
      } else if(var2 == 2) {
         this.field3294 = var1.method3156();
      } else if(var2 == 3) {
         this.field3295 = var1.readString();
      } else if(var2 == 4) {
         this.field3296 = var1.read24BitInt();
      } else if(var2 == 5) {
         var1.read24BitInt();
      } else if(var2 == 6) {
         this.field3310 = var1.readUnsignedByte();
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
            this.field3298[var2 - 10] = var1.readString();
         } else if(var2 == 15) {
            var3 = var1.readUnsignedByte();
            this.field3300 = new int[var3 * 2];

            int var4;
            for(var4 = 0; var4 < var3 * 2; ++var4) {
               this.field3300[var4] = var1.readShort();
            }

            var1.readInt();
            var4 = var1.readUnsignedByte();
            this.field3292 = new int[var4];

            int var5;
            for(var5 = 0; var5 < this.field3292.length; ++var5) {
               this.field3292[var5] = var1.readInt();
            }

            this.field3309 = new byte[var3];

            for(var5 = 0; var5 < var3; ++var5) {
               this.field3309[var5] = var1.readByte();
            }
         } else if(var2 != 16) {
            if(var2 == 17) {
               this.field3308 = var1.readString();
            } else if(var2 == 18) {
               var1.method3156();
            } else if(var2 == 19) {
               this.field3297 = var1.readUnsignedShort();
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
               var1.method3156();
            } else if(var2 == 28) {
               var1.readUnsignedByte();
            } else if(var2 == 29) {
               class257[] var6 = new class257[]{class257.field3538, class257.field3539, class257.field3540};
               this.field3299 = (class257)Item.method1751(var6, var1.readUnsignedByte());
            } else if(var2 == 30) {
               class239[] var7 = new class239[]{class239.field3273, class239.field3275, class239.field3271};
               this.field3306 = (class239)Item.method1751(var7, var1.readUnsignedByte());
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1500438723"
   )
   public void method4296(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4295(var1, var2);
      }
   }

   static {
      field3291 = new NodeCache(256);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)LSpritePixels;",
      garbageValue = "-2124662725"
   )
   SpritePixels method4299(int var1) {
      if(var1 < 0) {
         return null;
      } else {
         SpritePixels var2 = (SpritePixels)field3291.get((long)var1);
         if(var2 != null) {
            return var2;
         } else {
            var2 = GameEngine.method827(field3301, var1, 0);
            if(var2 != null) {
               field3291.put(var2, (long)var1);
            }

            return var2;
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1967204073"
   )
   public int method4300() {
      return this.field3289;
   }

   public class242(int var1) {
      this.field3293 = -1;
      this.field3294 = -1;
      this.field3310 = 0;
      this.field3298 = new String[5];
      this.field3307 = Integer.MAX_VALUE;
      this.field3302 = Integer.MAX_VALUE;
      this.field3303 = Integer.MIN_VALUE;
      this.field3304 = Integer.MIN_VALUE;
      this.field3299 = class257.field3538;
      this.field3306 = class239.field3271;
      this.field3297 = -1;
      this.field3289 = var1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ZI)LSpritePixels;",
      garbageValue = "-843503219"
   )
   public SpritePixels method4313(boolean var1) {
      int var2 = this.field3293;
      return this.method4299(var2);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1560225433"
   )
   public void method4314() {
      if(this.field3300 != null) {
         for(int var1 = 0; var1 < this.field3300.length; var1 += 2) {
            if(this.field3300[var1] < this.field3307) {
               this.field3307 = this.field3300[var1];
            } else if(this.field3300[var1] > this.field3303) {
               this.field3303 = this.field3300[var1];
            }

            if(this.field3300[var1 + 1] < this.field3302) {
               this.field3302 = this.field3300[var1 + 1];
            } else if(this.field3300[var1 + 1] > this.field3304) {
               this.field3304 = this.field3300[var1 + 1];
            }
         }
      }

   }
}
