import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ip")
@Implements("Area")
public class Area extends CacheableNode {
   @ObfuscatedName("i")
   @Export("name")
   public String name;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2096252019
   )
   int field3299;
   @ObfuscatedName("t")
   public static NodeCache field3300;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1032875037
   )
   public final int field3301;
   @ObfuscatedName("a")
   int[] field3302;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -784938063
   )
   int field3303;
   @ObfuscatedName("m")
   public static Area[] field3304;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1761747951
   )
   public int field3305;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -588510227
   )
   public int field3306;
   @ObfuscatedName("q")
   public String[] field3307;
   @ObfuscatedName("n")
   public String field3308;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1403716129
   )
   int field3309;
   @ObfuscatedName("l")
   public class239 field3310;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -933214203
   )
   int field3311;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -350717439
   )
   @Export("spriteId")
   public int spriteId;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 149648921
   )
   int field3313;
   @ObfuscatedName("r")
   public class257 field3314;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1398893897
   )
   public int field3315;
   @ObfuscatedName("h")
   int[] field3316;
   @ObfuscatedName("d")
   byte[] field3317;
   @ObfuscatedName("p")
   static IndexDataBase field3318;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "96"
   )
   void method4171(Buffer var1, int var2) {
      if(var2 == 1) {
         this.spriteId = var1.method3048();
      } else if(var2 == 2) {
         this.field3303 = var1.method3048();
      } else if(var2 == 3) {
         this.name = var1.readString();
      } else if(var2 == 4) {
         this.field3305 = var1.read24BitInt();
      } else if(var2 == 5) {
         var1.read24BitInt();
      } else if(var2 == 6) {
         this.field3315 = var1.readUnsignedByte();
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
            this.field3307[var2 - 10] = var1.readString();
         } else if(var2 == 15) {
            var3 = var1.readUnsignedByte();
            this.field3302 = new int[var3 * 2];

            int var4;
            for(var4 = 0; var4 < var3 * 2; ++var4) {
               this.field3302[var4] = var1.readShort();
            }

            var1.readInt();
            var4 = var1.readUnsignedByte();
            this.field3316 = new int[var4];

            int var5;
            for(var5 = 0; var5 < this.field3316.length; ++var5) {
               this.field3316[var5] = var1.readInt();
            }

            this.field3317 = new byte[var3];

            for(var5 = 0; var5 < var3; ++var5) {
               this.field3317[var5] = var1.readByte();
            }
         } else if(var2 != 16) {
            if(var2 == 17) {
               this.field3308 = var1.readString();
            } else if(var2 == 18) {
               var1.method3048();
            } else if(var2 == 19) {
               this.field3306 = var1.readUnsignedShort();
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
               var1.method3048();
            } else if(var2 == 28) {
               var1.readUnsignedByte();
            } else if(var2 == 29) {
               this.field3314 = (class257)RSCanvas.method735(class7.method30(), var1.readUnsignedByte());
            } else if(var2 == 30) {
               class239[] var6 = new class239[]{class239.field3283, class239.field3280, class239.field3281};
               this.field3310 = (class239)RSCanvas.method735(var6, var1.readUnsignedByte());
            }
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "392254657"
   )
   void method4172() {
      if(this.field3302 != null) {
         for(int var1 = 0; var1 < this.field3302.length; var1 += 2) {
            if(this.field3302[var1] < this.field3299) {
               this.field3299 = this.field3302[var1];
            } else if(this.field3302[var1] > this.field3309) {
               this.field3309 = this.field3302[var1];
            }

            if(this.field3302[var1 + 1] < this.field3311) {
               this.field3311 = this.field3302[var1 + 1];
            } else if(this.field3302[var1 + 1] > this.field3313) {
               this.field3313 = this.field3302[var1 + 1];
            }
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "115"
   )
   public int method4175() {
      return this.field3301;
   }

   static {
      field3300 = new NodeCache(256);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)LSpotanim;",
      garbageValue = "486233142"
   )
   public static Spotanim method4176(int var0) {
      Spotanim var1 = (Spotanim)Spotanim.field3331.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Spotanim.field3344.getConfigData(13, var0);
         var1 = new Spotanim();
         var1.field3339 = var0;
         if(var2 != null) {
            var1.method4210(new Buffer(var2));
         }

         Spotanim.field3331.put(var1, (long)var0);
         return var1;
      }
   }

   Area(int var1) {
      this.spriteId = -1;
      this.field3303 = -1;
      this.field3315 = 0;
      this.field3307 = new String[5];
      this.field3299 = Integer.MAX_VALUE;
      this.field3311 = Integer.MAX_VALUE;
      this.field3309 = Integer.MIN_VALUE;
      this.field3313 = Integer.MIN_VALUE;
      this.field3314 = class257.field3549;
      this.field3310 = class239.field3283;
      this.field3306 = -1;
      this.field3301 = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "800488880"
   )
   void method4178(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4171(var1, var2);
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)LSpritePixels;",
      garbageValue = "784075097"
   )
   SpritePixels method4180(int var1) {
      if(var1 < 0) {
         return null;
      } else {
         SpritePixels var2 = (SpritePixels)field3300.get((long)var1);
         if(var2 != null) {
            return var2;
         } else {
            var2 = class262.method4613(field3318, var1, 0);
            if(var2 != null) {
               field3300.put(var2, (long)var1);
            }

            return var2;
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ZI)LSpritePixels;",
      garbageValue = "-56322880"
   )
   public SpritePixels method4189(boolean var1) {
      int var2 = this.spriteId;
      return this.method4180(var2);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "10"
   )
   static final String method4190(int var0) {
      return var0 < 100000?"<col=ffff00>" + var0 + "</col>":(var0 < 10000000?"<col=ffffff>" + var0 / 1000 + "K" + "</col>":"<col=00ff80>" + var0 / 1000000 + "M" + "</col>");
   }
}
