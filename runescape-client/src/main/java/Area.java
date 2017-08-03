import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ij")
@Implements("Area")
public class Area extends CacheableNode {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "[Lij;"
   )
   public static Area[] field3286;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   @Export("skeletonsIndex")
   public static NodeCache skeletonsIndex;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   public static IndexDataBase field3289;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -605558247
   )
   public static int field3276;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -2085778977
   )
   @Export("spriteId")
   public int spriteId;
   @ObfuscatedName("p")
   int[] field3288;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 358126683
   )
   public final int field3278;
   @ObfuscatedName("t")
   @Export("name")
   public String name;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   public class257 field3291;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1981237887
   )
   int field3279;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1533796501
   )
   int field3287;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lis;"
   )
   public class239 field3293;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 567039903
   )
   public int field3282;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1256296431
   )
   public int field3283;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1223887917
   )
   int field3280;
   @ObfuscatedName("s")
   public String[] field3284;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -287205571
   )
   public int field3295;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -2088492519
   )
   int field3274;
   @ObfuscatedName("o")
   public String field3285;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1260809449
   )
   int field3290;
   @ObfuscatedName("l")
   int[] field3275;
   @ObfuscatedName("m")
   byte[] field3294;

   static {
      skeletonsIndex = new NodeCache(256);
   }

   public Area(int var1) {
      this.spriteId = -1;
      this.field3279 = -1;
      this.field3283 = 0;
      this.field3284 = new String[5];
      this.field3287 = Integer.MAX_VALUE;
      this.field3274 = Integer.MAX_VALUE;
      this.field3280 = Integer.MIN_VALUE;
      this.field3290 = Integer.MIN_VALUE;
      this.field3291 = class257.field3527;
      this.field3293 = class239.field3254;
      this.field3295 = -1;
      this.field3278 = var1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ZI)Lji;",
      garbageValue = "-1514150473"
   )
   public SpritePixels method4271(boolean var1) {
      int var2 = this.spriteId;
      return this.method4272(var2);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)Lji;",
      garbageValue = "-119"
   )
   SpritePixels method4272(int var1) {
      if(var1 < 0) {
         return null;
      } else {
         SpritePixels var2 = (SpritePixels)skeletonsIndex.get((long)var1);
         if(var2 != null) {
            return var2;
         } else {
            var2 = class13.method72(field3289, var1, 0);
            if(var2 != null) {
               skeletonsIndex.put(var2, (long)var1);
            }

            return var2;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lfw;IB)V",
      garbageValue = "80"
   )
   void method4276(Buffer var1, int var2) {
      if(var2 == 1) {
         this.spriteId = var1.method3216();
      } else if(var2 == 2) {
         this.field3279 = var1.method3216();
      } else if(var2 == 3) {
         this.name = var1.readString();
      } else if(var2 == 4) {
         this.field3282 = var1.read24BitInt();
      } else if(var2 == 5) {
         var1.read24BitInt();
      } else if(var2 == 6) {
         this.field3283 = var1.readUnsignedByte();
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
            this.field3284[var2 - 10] = var1.readString();
         } else if(var2 == 15) {
            var3 = var1.readUnsignedByte();
            this.field3288 = new int[var3 * 2];

            int var4;
            for(var4 = 0; var4 < var3 * 2; ++var4) {
               this.field3288[var4] = var1.readShort();
            }

            var1.readInt();
            var4 = var1.readUnsignedByte();
            this.field3275 = new int[var4];

            int var5;
            for(var5 = 0; var5 < this.field3275.length; ++var5) {
               this.field3275[var5] = var1.readInt();
            }

            this.field3294 = new byte[var3];

            for(var5 = 0; var5 < var3; ++var5) {
               this.field3294[var5] = var1.readByte();
            }
         } else if(var2 != 16) {
            if(var2 == 17) {
               this.field3285 = var1.readString();
            } else if(var2 == 18) {
               var1.method3216();
            } else if(var2 == 19) {
               this.field3295 = var1.readUnsignedShort();
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
               var1.method3216();
            } else if(var2 == 28) {
               var1.readUnsignedByte();
            } else if(var2 == 29) {
               this.field3291 = (class257)CollisionData.forOrdinal(class90.method1721(), var1.readUnsignedByte());
            } else if(var2 == 30) {
               class239[] var6 = new class239[]{class239.field3254, class239.field3255, class239.field3262};
               this.field3293 = (class239)CollisionData.forOrdinal(var6, var1.readUnsignedByte());
            }
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1607631457"
   )
   public int method4273() {
      return this.field3278;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lfw;I)V",
      garbageValue = "1910357705"
   )
   public void method4269(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4276(var1, var2);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1371473267"
   )
   public void method4270() {
      if(this.field3288 != null) {
         for(int var1 = 0; var1 < this.field3288.length; var1 += 2) {
            if(this.field3288[var1] < this.field3287) {
               this.field3287 = this.field3288[var1];
            } else if(this.field3288[var1] > this.field3280) {
               this.field3280 = this.field3288[var1];
            }

            if(this.field3288[var1 + 1] < this.field3274) {
               this.field3274 = this.field3288[var1 + 1];
            } else if(this.field3288[var1 + 1] > this.field3290) {
               this.field3290 = this.field3288[var1 + 1];
            }
         }
      }

   }
}
