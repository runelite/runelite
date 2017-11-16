import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ib")
@Implements("Area")
public class Area extends CacheableNode {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   public static IndexDataBase field3351;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "[Lib;"
   )
   public static Area[] field3345;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1660740871
   )
   public static int field3346;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   @Export("skeletonsIndex")
   static NodeCache skeletonsIndex;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1303453487
   )
   public final int field3348;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 17723133
   )
   @Export("spriteId")
   public int spriteId;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 552318761
   )
   int field3350;
   @ObfuscatedName("t")
   @Export("name")
   public String name;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1747552209
   )
   public int field3352;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -928835717
   )
   public int field3359;
   @ObfuscatedName("o")
   public String[] field3349;
   @ObfuscatedName("a")
   public String field3353;
   @ObfuscatedName("q")
   int[] field3356;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1343933301
   )
   int field3357;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 914736715
   )
   int field3355;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 594448357
   )
   int field3354;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 162351185
   )
   int field3360;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Ljp;"
   )
   public class264 field3361;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   public class246 field3344;
   @ObfuscatedName("i")
   int[] field3363;
   @ObfuscatedName("l")
   byte[] field3364;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -479942267
   )
   public int field3365;

   static {
      skeletonsIndex = new NodeCache(256);
   }

   public Area(int var1) {
      this.spriteId = -1;
      this.field3350 = -1;
      this.field3359 = 0;
      this.field3349 = new String[5];
      this.field3357 = Integer.MAX_VALUE;
      this.field3355 = Integer.MAX_VALUE;
      this.field3354 = Integer.MIN_VALUE;
      this.field3360 = Integer.MIN_VALUE;
      this.field3361 = class264.field3596;
      this.field3344 = class246.field3326;
      this.field3365 = -1;
      this.field3348 = var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lfs;B)V",
      garbageValue = "1"
   )
   public void method4268(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4269(var1, var2);
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lfs;II)V",
      garbageValue = "1585908542"
   )
   void method4269(Buffer var1, int var2) {
      if(var2 == 1) {
         this.spriteId = var1.method3201();
      } else if(var2 == 2) {
         this.field3350 = var1.method3201();
      } else if(var2 == 3) {
         this.name = var1.readString();
      } else if(var2 == 4) {
         this.field3352 = var1.read24BitInt();
      } else if(var2 == 5) {
         var1.read24BitInt();
      } else if(var2 == 6) {
         this.field3359 = var1.readUnsignedByte();
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
            this.field3349[var2 - 10] = var1.readString();
         } else if(var2 == 15) {
            var3 = var1.readUnsignedByte();
            this.field3356 = new int[var3 * 2];

            int var4;
            for(var4 = 0; var4 < var3 * 2; ++var4) {
               this.field3356[var4] = var1.readShort();
            }

            var1.readInt();
            var4 = var1.readUnsignedByte();
            this.field3363 = new int[var4];

            int var5;
            for(var5 = 0; var5 < this.field3363.length; ++var5) {
               this.field3363[var5] = var1.readInt();
            }

            this.field3364 = new byte[var3];

            for(var5 = 0; var5 < var3; ++var5) {
               this.field3364[var5] = var1.readByte();
            }
         } else if(var2 != 16) {
            if(var2 == 17) {
               this.field3353 = var1.readString();
            } else if(var2 == 18) {
               var1.method3201();
            } else if(var2 == 19) {
               this.field3365 = var1.readUnsignedShort();
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
               var1.method3201();
            } else if(var2 == 28) {
               var1.readUnsignedByte();
            } else if(var2 == 29) {
               class264[] var6 = new class264[]{class264.field3595, class264.field3596, class264.field3594};
               this.field3361 = (class264)class153.forOrdinal(var6, var1.readUnsignedByte());
            } else if(var2 == 30) {
               this.field3344 = (class246)class153.forOrdinal(class234.method4092(), var1.readUnsignedByte());
            }
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1458063063"
   )
   public void method4270() {
      if(this.field3356 != null) {
         for(int var1 = 0; var1 < this.field3356.length; var1 += 2) {
            if(this.field3356[var1] < this.field3357) {
               this.field3357 = this.field3356[var1];
            } else if(this.field3356[var1] > this.field3354) {
               this.field3354 = this.field3356[var1];
            }

            if(this.field3356[var1 + 1] < this.field3355) {
               this.field3355 = this.field3356[var1 + 1];
            } else if(this.field3356[var1 + 1] > this.field3360) {
               this.field3360 = this.field3356[var1 + 1];
            }
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ZI)Lkb;",
      garbageValue = "-1736277370"
   )
   public SpritePixels method4275(boolean var1) {
      int var2 = this.spriteId;
      return this.method4272(var2);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Lkb;",
      garbageValue = "2107077677"
   )
   SpritePixels method4272(int var1) {
      if(var1 < 0) {
         return null;
      } else {
         SpritePixels var2 = (SpritePixels)skeletonsIndex.get((long)var1);
         if(var2 != null) {
            return var2;
         } else {
            var2 = class163.method3082(field3351, var1, 0);
            if(var2 != null) {
               skeletonsIndex.put(var2, (long)var1);
            }

            return var2;
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "23703"
   )
   public int method4273() {
      return this.field3348;
   }

   @ObfuscatedName("if")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;B)[Ljava/lang/String;",
      garbageValue = "42"
   )
   static final String[] method4292(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(var0 != null && var0[var2] != null) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }
}
