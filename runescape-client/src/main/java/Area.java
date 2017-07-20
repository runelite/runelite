import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("is")
@Implements("Area")
public class Area extends CacheableNode {
   @ObfuscatedName("eb")
   @ObfuscatedSignature(
      signature = "Ljt;"
   )
   static Font field3285;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "[Lis;"
   )
   public static Area[] field3265;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   @Export("skeletonsIndex")
   public static NodeCache skeletonsIndex;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   static IndexDataBase field3277;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1312859915
   )
   @Export("spriteId")
   public int spriteId;
   @ObfuscatedName("h")
   int[] field3272;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1676342831
   )
   public final int field3275;
   @ObfuscatedName("x")
   @Export("name")
   public String name;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   public class257 field3280;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -439670379
   )
   int field3278;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 26960073
   )
   int field3273;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   public class239 field3276;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 743303555
   )
   public int field3268;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2094346319
   )
   public int field3269;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1383865859
   )
   int field3266;
   @ObfuscatedName("w")
   public String[] field3270;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -857820041
   )
   public int field3281;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1838266219
   )
   int field3283;
   @ObfuscatedName("v")
   public String field3271;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1606791093
   )
   int field3264;
   @ObfuscatedName("f")
   int[] field3262;
   @ObfuscatedName("j")
   byte[] field3279;

   static {
      skeletonsIndex = new NodeCache(256);
   }

   Area(int var1) {
      this.spriteId = -1;
      this.field3278 = -1;
      this.field3269 = 0;
      this.field3270 = new String[5];
      this.field3273 = Integer.MAX_VALUE;
      this.field3283 = Integer.MAX_VALUE;
      this.field3266 = Integer.MIN_VALUE;
      this.field3264 = Integer.MIN_VALUE;
      this.field3280 = class257.field3520;
      this.field3276 = class239.field3246;
      this.field3281 = -1;
      this.field3275 = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ZI)Ljj;",
      garbageValue = "1373450652"
   )
   public SpritePixels method4181(boolean var1) {
      int var2 = this.spriteId;
      return this.method4194(var2);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IS)Ljj;",
      garbageValue = "3083"
   )
   SpritePixels method4194(int var1) {
      if(var1 < 0) {
         return null;
      } else {
         SpritePixels var2 = (SpritePixels)skeletonsIndex.get((long)var1);
         if(var2 != null) {
            return var2;
         } else {
            var2 = NPCComposition.method4549(field3277, var1, 0);
            if(var2 != null) {
               skeletonsIndex.put(var2, (long)var1);
            }

            return var2;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lfp;IB)V",
      garbageValue = "-67"
   )
   void method4182(Buffer var1, int var2) {
      if(var2 == 1) {
         this.spriteId = var1.method3266();
      } else if(var2 == 2) {
         this.field3278 = var1.method3266();
      } else if(var2 == 3) {
         this.name = var1.readString();
      } else if(var2 == 4) {
         this.field3268 = var1.read24BitInt();
      } else if(var2 == 5) {
         var1.read24BitInt();
      } else if(var2 == 6) {
         this.field3269 = var1.readUnsignedByte();
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
            this.field3270[var2 - 10] = var1.readString();
         } else if(var2 == 15) {
            var3 = var1.readUnsignedByte();
            this.field3272 = new int[var3 * 2];

            int var4;
            for(var4 = 0; var4 < var3 * 2; ++var4) {
               this.field3272[var4] = var1.readShort();
            }

            var1.readInt();
            var4 = var1.readUnsignedByte();
            this.field3262 = new int[var4];

            int var5;
            for(var5 = 0; var5 < this.field3262.length; ++var5) {
               this.field3262[var5] = var1.readInt();
            }

            this.field3279 = new byte[var3];

            for(var5 = 0; var5 < var3; ++var5) {
               this.field3279[var5] = var1.readByte();
            }
         } else if(var2 != 16) {
            if(var2 == 17) {
               this.field3271 = var1.readString();
            } else if(var2 == 18) {
               var1.method3266();
            } else if(var2 == 19) {
               this.field3281 = var1.readUnsignedShort();
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
               var1.method3266();
            } else if(var2 == 28) {
               var1.readUnsignedByte();
            } else if(var2 == 29) {
               this.field3280 = (class257)class36.forOrdinal(GraphicsObject.method1618(), var1.readUnsignedByte());
            } else if(var2 == 30) {
               this.field3276 = (class239)class36.forOrdinal(class46.method669(), var1.readUnsignedByte());
            }
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "32"
   )
   public int method4187() {
      return this.field3275;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lfp;I)V",
      garbageValue = "-165746067"
   )
   void method4186(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4182(var1, var2);
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-332015562"
   )
   void method4183() {
      if(this.field3272 != null) {
         for(int var1 = 0; var1 < this.field3272.length; var1 += 2) {
            if(this.field3272[var1] < this.field3273) {
               this.field3273 = this.field3272[var1];
            } else if(this.field3272[var1] > this.field3266) {
               this.field3266 = this.field3272[var1];
            }

            if(this.field3272[var1 + 1] < this.field3283) {
               this.field3283 = this.field3272[var1 + 1];
            } else if(this.field3272[var1 + 1] > this.field3264) {
               this.field3264 = this.field3272[var1 + 1];
            }
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IS)Lea;",
      garbageValue = "-26285"
   )
   @Export("getFrames")
   static Frames getFrames(int var0) {
      Frames var1 = (Frames)Sequence.skeletons.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         var1 = Varcs.method1765(Sequence.skel_ref, Sequence.skin_ref, var0, false);
         if(var1 != null) {
            Sequence.skeletons.put(var1, (long)var0);
         }

         return var1;
      }
   }
}
