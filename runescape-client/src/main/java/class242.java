import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ib")
public class class242 extends CacheableNode {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1603842807
   )
   public int field3275;
   @ObfuscatedName("h")
   public static class242[] field3276;
   @ObfuscatedName("fj")
   @ObfuscatedGetter(
      intValue = 1083458451
   )
   static int field3277;
   @ObfuscatedName("q")
   public static NodeCache field3278;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 222800165
   )
   public final int field3279;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1204644397
   )
   public int field3280;
   @ObfuscatedName("i")
   static IndexDataBase field3281;
   @ObfuscatedName("p")
   public String field3282;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1563855177
   )
   int field3283;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1430816237
   )
   public int field3284;
   @ObfuscatedName("r")
   public String[] field3285;
   @ObfuscatedName("b")
   public String field3286;
   @ObfuscatedName("s")
   public class239 field3287;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -159501209
   )
   int field3288;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1039273449
   )
   int field3289;
   @ObfuscatedName("rt")
   static class291 field3290;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -326807227
   )
   int field3291;
   @ObfuscatedName("e")
   public class257 field3292;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1947422009
   )
   static int field3293;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1500284821
   )
   int field3294;
   @ObfuscatedName("y")
   byte[] field3295;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1615218615
   )
   public int field3296;
   @ObfuscatedName("n")
   int[] field3297;
   @ObfuscatedName("x")
   int[] field3298;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)LSpritePixels;",
      garbageValue = "-621038510"
   )
   SpritePixels method4364(int var1) {
      if(var1 < 0) {
         return null;
      } else {
         SpritePixels var2 = (SpritePixels)field3278.get((long)var1);
         if(var2 != null) {
            return var2;
         } else {
            var2 = class123.method2381(field3281, var1, 0);
            if(var2 != null) {
               field3278.put(var2, (long)var1);
            }

            return var2;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1598726030"
   )
   void method4365(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4366(var1, var2);
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "4"
   )
   void method4366(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3280 = var1.method3214();
      } else if(var2 == 2) {
         this.field3283 = var1.method3214();
      } else if(var2 == 3) {
         this.field3282 = var1.readString();
      } else if(var2 == 4) {
         this.field3275 = var1.read24BitInt();
      } else if(var2 == 5) {
         var1.read24BitInt();
      } else if(var2 == 6) {
         this.field3284 = var1.readUnsignedByte();
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
            this.field3285[var2 - 10] = var1.readString();
         } else if(var2 == 15) {
            var3 = var1.readUnsignedByte();
            this.field3298 = new int[var3 * 2];

            int var4;
            for(var4 = 0; var4 < var3 * 2; ++var4) {
               this.field3298[var4] = var1.readShort();
            }

            var1.readInt();
            var4 = var1.readUnsignedByte();
            this.field3297 = new int[var4];

            int var5;
            for(var5 = 0; var5 < this.field3297.length; ++var5) {
               this.field3297[var5] = var1.readInt();
            }

            this.field3295 = new byte[var3];

            for(var5 = 0; var5 < var3; ++var5) {
               this.field3295[var5] = var1.readByte();
            }
         } else if(var2 != 16) {
            if(var2 == 17) {
               this.field3286 = var1.readString();
            } else if(var2 == 18) {
               var1.method3214();
            } else if(var2 == 19) {
               this.field3296 = var1.readUnsignedShort();
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
               var1.method3214();
            } else if(var2 == 28) {
               var1.readUnsignedByte();
            } else if(var2 == 29) {
               class257[] var6 = new class257[]{class257.field3538, class257.field3536, class257.field3537};
               this.field3292 = (class257)Client.method1381(var6, var1.readUnsignedByte());
            } else if(var2 == 30) {
               this.field3287 = (class239)Client.method1381(Preferences.method1609(), var1.readUnsignedByte());
            }
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1821731036"
   )
   void method4367() {
      if(this.field3298 != null) {
         for(int var1 = 0; var1 < this.field3298.length; var1 += 2) {
            if(this.field3298[var1] < this.field3294) {
               this.field3294 = this.field3298[var1];
            } else if(this.field3298[var1] > this.field3288) {
               this.field3288 = this.field3298[var1];
            }

            if(this.field3298[var1 + 1] < this.field3289) {
               this.field3289 = this.field3298[var1 + 1];
            } else if(this.field3298[var1 + 1] > this.field3291) {
               this.field3291 = this.field3298[var1 + 1];
            }
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ZB)LSpritePixels;",
      garbageValue = "118"
   )
   public SpritePixels method4370(boolean var1) {
      int var2 = this.field3280;
      return this.method4364(var2);
   }

   class242(int var1) {
      this.field3280 = -1;
      this.field3283 = -1;
      this.field3284 = 0;
      this.field3285 = new String[5];
      this.field3294 = Integer.MAX_VALUE;
      this.field3289 = Integer.MAX_VALUE;
      this.field3288 = Integer.MIN_VALUE;
      this.field3291 = Integer.MIN_VALUE;
      this.field3292 = class257.field3537;
      this.field3287 = class239.field3261;
      this.field3296 = -1;
      this.field3279 = var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2138124253"
   )
   public int method4374() {
      return this.field3279;
   }

   static {
      field3278 = new NodeCache(256);
   }
}
