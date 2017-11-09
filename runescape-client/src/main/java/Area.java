import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("if")
@Implements("Area")
public class Area extends CacheableNode {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   public static IndexDataBase field3365;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "[Lif;"
   )
   public static Area[] field3358;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 597944079
   )
   public static int field3350;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   @Export("skeletonsIndex")
   public static NodeCache skeletonsIndex;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1717028975
   )
   public final int field3352;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1830857621
   )
   @Export("spriteId")
   public int spriteId;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -935476091
   )
   int field3355;
   @ObfuscatedName("l")
   @Export("name")
   public String name;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -372250065
   )
   public int field3366;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1497547685
   )
   public int field3354;
   @ObfuscatedName("a")
   public String[] field3359;
   @ObfuscatedName("y")
   public String field3363;
   @ObfuscatedName("w")
   int[] field3360;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1696397257
   )
   int field3361;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -2029051837
   )
   int field3362;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1374565747
   )
   int field3356;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -2131519317
   )
   int field3364;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lju;"
   )
   public class264 field3348;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lic;"
   )
   public class246 field3349;
   @ObfuscatedName("z")
   int[] field3367;
   @ObfuscatedName("o")
   byte[] field3368;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1191235087
   )
   public int field3369;

   static {
      skeletonsIndex = new NodeCache(256);
   }

   public Area(int var1) {
      this.spriteId = -1;
      this.field3355 = -1;
      this.field3354 = 0;
      this.field3359 = new String[5];
      this.field3361 = Integer.MAX_VALUE;
      this.field3362 = Integer.MAX_VALUE;
      this.field3356 = Integer.MIN_VALUE;
      this.field3364 = Integer.MIN_VALUE;
      this.field3348 = class264.field3597;
      this.field3349 = class246.field3337;
      this.field3369 = -1;
      this.field3352 = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lfv;B)V",
      garbageValue = "-28"
   )
   public void method4466(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4477(var1, var2);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lfv;II)V",
      garbageValue = "-282123521"
   )
   void method4477(Buffer var1, int var2) {
      if(var2 == 1) {
         this.spriteId = var1.method3301();
      } else if(var2 == 2) {
         this.field3355 = var1.method3301();
      } else if(var2 == 3) {
         this.name = var1.readString();
      } else if(var2 == 4) {
         this.field3366 = var1.read24BitInt();
      } else if(var2 == 5) {
         var1.read24BitInt();
      } else if(var2 == 6) {
         this.field3354 = var1.readUnsignedByte();
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
            this.field3359[var2 - 10] = var1.readString();
         } else if(var2 == 15) {
            var3 = var1.readUnsignedByte();
            this.field3360 = new int[var3 * 2];

            int var4;
            for(var4 = 0; var4 < var3 * 2; ++var4) {
               this.field3360[var4] = var1.readShort();
            }

            var1.readInt();
            var4 = var1.readUnsignedByte();
            this.field3367 = new int[var4];

            int var5;
            for(var5 = 0; var5 < this.field3367.length; ++var5) {
               this.field3367[var5] = var1.readInt();
            }

            this.field3368 = new byte[var3];

            for(var5 = 0; var5 < var3; ++var5) {
               this.field3368[var5] = var1.readByte();
            }
         } else if(var2 != 16) {
            if(var2 == 17) {
               this.field3363 = var1.readString();
            } else if(var2 == 18) {
               var1.method3301();
            } else if(var2 == 19) {
               this.field3369 = var1.readUnsignedShort();
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
               var1.method3301();
            } else if(var2 == 28) {
               var1.readUnsignedByte();
            } else if(var2 == 29) {
               class264[] var6 = new class264[]{class264.field3601, class264.field3599, class264.field3597};
               this.field3348 = (class264)class47.forOrdinal(var6, var1.readUnsignedByte());
            } else if(var2 == 30) {
               this.field3349 = (class246)class47.forOrdinal(DecorativeObject.method3002(), var1.readUnsignedByte());
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1775270147"
   )
   public void method4468() {
      if(this.field3360 != null) {
         for(int var1 = 0; var1 < this.field3360.length; var1 += 2) {
            if(this.field3360[var1] < this.field3361) {
               this.field3361 = this.field3360[var1];
            } else if(this.field3360[var1] > this.field3356) {
               this.field3356 = this.field3360[var1];
            }

            if(this.field3360[var1 + 1] < this.field3362) {
               this.field3362 = this.field3360[var1 + 1];
            } else if(this.field3360[var1 + 1] > this.field3364) {
               this.field3364 = this.field3360[var1 + 1];
            }
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ZB)Lkd;",
      garbageValue = "16"
   )
   public SpritePixels method4485(boolean var1) {
      int var2 = this.spriteId;
      return this.method4470(var2);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)Lkd;",
      garbageValue = "-1861697191"
   )
   SpritePixels method4470(int var1) {
      if(var1 < 0) {
         return null;
      } else {
         SpritePixels var2 = (SpritePixels)skeletonsIndex.get((long)var1);
         if(var2 != null) {
            return var2;
         } else {
            var2 = class21.method176(field3365, var1, 0);
            if(var2 != null) {
               skeletonsIndex.put(var2, (long)var1);
            }

            return var2;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-880305757"
   )
   public int method4482() {
      return this.field3352;
   }
}
