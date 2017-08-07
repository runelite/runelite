import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("io")
@Implements("Area")
public class Area extends CacheableNode {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "[Lio;"
   )
   public static Area[] field3276;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   @Export("skeletonsIndex")
   public static NodeCache skeletonsIndex;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   static IndexDataBase field3286;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -108368331
   )
   static int field3279;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1546216903
   )
   @Export("spriteId")
   public int spriteId;
   @ObfuscatedName("h")
   int[] field3287;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -497676003
   )
   public final int field3297;
   @ObfuscatedName("z")
   @Export("name")
   public String name;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   public class258 field3291;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 763568695
   )
   int field3281;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1539643205
   )
   int field3288;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   public class240 field3293;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1089387001
   )
   public int field3283;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 957574945
   )
   public int field3284;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1580686993
   )
   int field3290;
   @ObfuscatedName("o")
   public String[] field3285;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1559282169
   )
   public int field3296;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1358067131
   )
   int field3289;
   @ObfuscatedName("l")
   public String field3275;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1256589969
   )
   int field3277;
   @ObfuscatedName("f")
   int[] field3292;
   @ObfuscatedName("b")
   byte[] field3295;

   static {
      skeletonsIndex = new NodeCache(256);
   }

   Area(int var1) {
      this.spriteId = -1;
      this.field3281 = -1;
      this.field3284 = 0;
      this.field3285 = new String[5];
      this.field3288 = Integer.MAX_VALUE;
      this.field3289 = Integer.MAX_VALUE;
      this.field3290 = Integer.MIN_VALUE;
      this.field3277 = Integer.MIN_VALUE;
      this.field3291 = class258.field3533;
      this.field3293 = class240.field3258;
      this.field3296 = -1;
      this.field3297 = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ZB)Lkn;",
      garbageValue = "49"
   )
   public SpritePixels method4294(boolean var1) {
      int var2 = this.spriteId;
      return this.method4291(var2);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Lkn;",
      garbageValue = "738713116"
   )
   SpritePixels method4291(int var1) {
      if(var1 < 0) {
         return null;
      } else {
         SpritePixels var2 = (SpritePixels)skeletonsIndex.get((long)var1);
         if(var2 != null) {
            return var2;
         } else {
            var2 = class64.method1087(field3286, var1, 0);
            if(var2 != null) {
               skeletonsIndex.put(var2, (long)var1);
            }

            return var2;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lfh;IB)V",
      garbageValue = "-104"
   )
   void method4289(Buffer var1, int var2) {
      if(var2 == 1) {
         this.spriteId = var1.method3190();
      } else if(var2 == 2) {
         this.field3281 = var1.method3190();
      } else if(var2 == 3) {
         this.name = var1.readString();
      } else if(var2 == 4) {
         this.field3283 = var1.read24BitInt();
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
            this.field3287 = new int[var3 * 2];

            int var4;
            for(var4 = 0; var4 < var3 * 2; ++var4) {
               this.field3287[var4] = var1.readShort();
            }

            var1.readInt();
            var4 = var1.readUnsignedByte();
            this.field3292 = new int[var4];

            int var5;
            for(var5 = 0; var5 < this.field3292.length; ++var5) {
               this.field3292[var5] = var1.readInt();
            }

            this.field3295 = new byte[var3];

            for(var5 = 0; var5 < var3; ++var5) {
               this.field3295[var5] = var1.readByte();
            }
         } else if(var2 != 16) {
            if(var2 == 17) {
               this.field3275 = var1.readString();
            } else if(var2 == 18) {
               var1.method3190();
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
               var1.method3190();
            } else if(var2 == 28) {
               var1.readUnsignedByte();
            } else if(var2 == 29) {
               this.field3291 = (class258)GroundObject.forOrdinal(class208.method3885(), var1.readUnsignedByte());
            } else if(var2 == 30) {
               this.field3293 = (class240)GroundObject.forOrdinal(class225.method4081(), var1.readUnsignedByte());
            }
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-579413066"
   )
   public int method4293() {
      return this.field3297;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lfh;I)V",
      garbageValue = "-1869588380"
   )
   void method4300(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4289(var1, var2);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   void method4290() {
      if(this.field3287 != null) {
         for(int var1 = 0; var1 < this.field3287.length; var1 += 2) {
            if(this.field3287[var1] < this.field3288) {
               this.field3288 = this.field3287[var1];
            } else if(this.field3287[var1] > this.field3290) {
               this.field3290 = this.field3287[var1];
            }

            if(this.field3287[var1 + 1] < this.field3289) {
               this.field3289 = this.field3287[var1 + 1];
            } else if(this.field3287[var1 + 1] > this.field3277) {
               this.field3277 = this.field3287[var1 + 1];
            }
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lit;Lit;B)V",
      garbageValue = "18"
   )
   public static void method4308(IndexDataBase var0, IndexDataBase var1) {
      Spotanim.field3322 = var0;
      Spotanim.field3316 = var1;
   }
}
