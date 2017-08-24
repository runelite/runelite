import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ig")
@Implements("Area")
public class Area extends CacheableNode {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "[Lig;"
   )
   public static Area[] field3294;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   @Export("skeletonsIndex")
   public static NodeCache skeletonsIndex;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   public static IndexDataBase field3310;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -651614475
   )
   @Export("spriteId")
   public int spriteId;
   @ObfuscatedName("y")
   int[] field3293;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1067358391
   )
   public final int field3296;
   @ObfuscatedName("b")
   @Export("name")
   public String name;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   public class258 field3309;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1146629697
   )
   int field3298;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 204734903
   )
   int field3305;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   public class240 field3312;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -274453975
   )
   public int field3300;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -726268827
   )
   public int field3301;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -2040928195
   )
   int field3307;
   @ObfuscatedName("l")
   public String[] field3302;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -169323159
   )
   public int field3313;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 328938113
   )
   int field3306;
   @ObfuscatedName("t")
   public String field3303;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1740501431
   )
   int field3308;
   @ObfuscatedName("m")
   int[] field3311;
   @ObfuscatedName("x")
   byte[] field3304;

   static {
      skeletonsIndex = new NodeCache(256);
   }

   public Area(int var1) {
      this.spriteId = -1;
      this.field3298 = -1;
      this.field3301 = 0;
      this.field3302 = new String[5];
      this.field3305 = Integer.MAX_VALUE;
      this.field3306 = Integer.MAX_VALUE;
      this.field3307 = Integer.MIN_VALUE;
      this.field3308 = Integer.MIN_VALUE;
      this.field3309 = class258.field3540;
      this.field3312 = class240.field3277;
      this.field3313 = -1;
      this.field3296 = var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ZS)Lkd;",
      garbageValue = "257"
   )
   public SpritePixels method4302(boolean var1) {
      int var2 = this.spriteId;
      return this.method4294(var2);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)Lkd;",
      garbageValue = "-357581854"
   )
   SpritePixels method4294(int var1) {
      if(var1 < 0) {
         return null;
      } else {
         SpritePixels var2 = (SpritePixels)skeletonsIndex.get((long)var1);
         if(var2 != null) {
            return var2;
         } else {
            var2 = class255.method4507(field3310, var1, 0);
            if(var2 != null) {
               skeletonsIndex.put(var2, (long)var1);
            }

            return var2;
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lfp;IB)V",
      garbageValue = "58"
   )
   void method4300(Buffer var1, int var2) {
      if(var2 == 1) {
         this.spriteId = var1.method3262();
      } else if(var2 == 2) {
         this.field3298 = var1.method3262();
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
            this.field3293 = new int[var3 * 2];

            int var4;
            for(var4 = 0; var4 < var3 * 2; ++var4) {
               this.field3293[var4] = var1.readShort();
            }

            var1.readInt();
            var4 = var1.readUnsignedByte();
            this.field3311 = new int[var4];

            int var5;
            for(var5 = 0; var5 < this.field3311.length; ++var5) {
               this.field3311[var5] = var1.readInt();
            }

            this.field3304 = new byte[var3];

            for(var5 = 0; var5 < var3; ++var5) {
               this.field3304[var5] = var1.readByte();
            }
         } else if(var2 != 16) {
            if(var2 == 17) {
               this.field3303 = var1.readString();
            } else if(var2 == 18) {
               var1.method3262();
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
               var1.method3262();
            } else if(var2 == 28) {
               var1.readUnsignedByte();
            } else if(var2 == 29) {
               class258[] var6 = new class258[]{class258.field3541, class258.field3539, class258.field3540};
               this.field3309 = (class258)class88.forOrdinal(var6, var1.readUnsignedByte());
            } else if(var2 == 30) {
               class240[] var7 = new class240[]{class240.field3275, class240.field3278, class240.field3277};
               this.field3312 = (class240)class88.forOrdinal(var7, var1.readUnsignedByte());
            }
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2063416402"
   )
   public int method4295() {
      return this.field3296;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lfp;I)V",
      garbageValue = "1778468259"
   )
   public void method4291(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4300(var1, var2);
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "646626660"
   )
   public void method4307() {
      if(this.field3293 != null) {
         for(int var1 = 0; var1 < this.field3293.length; var1 += 2) {
            if(this.field3293[var1] < this.field3305) {
               this.field3305 = this.field3293[var1];
            } else if(this.field3293[var1] > this.field3307) {
               this.field3307 = this.field3293[var1];
            }

            if(this.field3293[var1 + 1] < this.field3306) {
               this.field3306 = this.field3293[var1 + 1];
            } else if(this.field3293[var1 + 1] > this.field3308) {
               this.field3308 = this.field3293[var1 + 1];
            }
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-1460875522"
   )
   public static final void method4292(int var0, int var1, int var2, int var3, int var4) {
      class7.field231.method3638(new class8(var0, var1, var2, var3, var4));
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1313685993"
   )
   static final int method4296() {
      return class133.field2001;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIIIII)I",
      garbageValue = "-888031820"
   )
   public static int method4314(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0 - (var3 - 1):(var2 == 2?7 - var1 - (var4 - 1):var0));
   }
}
