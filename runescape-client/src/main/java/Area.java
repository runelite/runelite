import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ie")
@Implements("Area")
public class Area extends CacheableNode {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "[Lie;"
   )
   public static Area[] field3284;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("skeletonsIndex")
   static NodeCache skeletonsIndex;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   public static IndexDataBase field3288;
   @ObfuscatedName("aa")
   protected static boolean field3297;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 926745033
   )
   public static int field3277;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 527603903
   )
   @Export("spriteId")
   public int spriteId;
   @ObfuscatedName("s")
   int[] field3276;
   @ObfuscatedName("l")
   @Export("name")
   public String name;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 559449637
   )
   public final int field3287;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Liq;"
   )
   public class258 field3293;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1819904389
   )
   int field3292;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 379174889
   )
   int field3275;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lis;"
   )
   public class240 field3291;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 558856909
   )
   public int field3283;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1029316209
   )
   public int field3281;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 90656441
   )
   int field3290;
   @ObfuscatedName("m")
   public String[] field3285;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1604993969
   )
   public int field3296;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 718872147
   )
   int field3289;
   @ObfuscatedName("i")
   public String field3286;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1293476505
   )
   int field3282;
   @ObfuscatedName("z")
   int[] field3294;
   @ObfuscatedName("u")
   byte[] field3295;

   static {
      skeletonsIndex = new NodeCache(256);
   }

   public Area(int var1) {
      this.spriteId = -1;
      this.field3292 = -1;
      this.field3281 = 0;
      this.field3285 = new String[5];
      this.field3275 = Integer.MAX_VALUE;
      this.field3289 = Integer.MAX_VALUE;
      this.field3290 = Integer.MIN_VALUE;
      this.field3282 = Integer.MIN_VALUE;
      this.field3293 = class258.field3535;
      this.field3291 = class240.field3258;
      this.field3296 = -1;
      this.field3287 = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ZB)Lkp;",
      garbageValue = "9"
   )
   public SpritePixels method4308(boolean var1) {
      int var2 = this.spriteId;
      return this.method4309(var2);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)Lkp;",
      garbageValue = "-96"
   )
   SpritePixels method4309(int var1) {
      if(var1 < 0) {
         return null;
      } else {
         SpritePixels var2 = (SpritePixels)skeletonsIndex.get((long)var1);
         if(var2 != null) {
            return var2;
         } else {
            var2 = class252.method4470(field3288, var1, 0);
            if(var2 != null) {
               skeletonsIndex.put(var2, (long)var1);
            }

            return var2;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lfb;II)V",
      garbageValue = "-1418516795"
   )
   void method4314(Buffer var1, int var2) {
      if(var2 == 1) {
         this.spriteId = var1.method3189();
      } else if(var2 == 2) {
         this.field3292 = var1.method3189();
      } else if(var2 == 3) {
         this.name = var1.readString();
      } else if(var2 == 4) {
         this.field3283 = var1.read24BitInt();
      } else if(var2 == 5) {
         var1.read24BitInt();
      } else if(var2 == 6) {
         this.field3281 = var1.readUnsignedByte();
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
            this.field3276 = new int[var3 * 2];

            int var4;
            for(var4 = 0; var4 < var3 * 2; ++var4) {
               this.field3276[var4] = var1.readShort();
            }

            var1.readInt();
            var4 = var1.readUnsignedByte();
            this.field3294 = new int[var4];

            int var5;
            for(var5 = 0; var5 < this.field3294.length; ++var5) {
               this.field3294[var5] = var1.readInt();
            }

            this.field3295 = new byte[var3];

            for(var5 = 0; var5 < var3; ++var5) {
               this.field3295[var5] = var1.readByte();
            }
         } else if(var2 != 16) {
            if(var2 == 17) {
               this.field3286 = var1.readString();
            } else if(var2 == 18) {
               var1.method3189();
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
               var1.method3189();
            } else if(var2 == 28) {
               var1.readUnsignedByte();
            } else if(var2 == 29) {
               class258[] var6 = new class258[]{class258.field3534, class258.field3533, class258.field3535};
               this.field3293 = (class258)PlayerComposition.forOrdinal(var6, var1.readUnsignedByte());
            } else if(var2 == 30) {
               this.field3291 = (class240)PlayerComposition.forOrdinal(class56.method860(), var1.readUnsignedByte());
            }
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-818405464"
   )
   public int method4330() {
      return this.field3287;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lfb;I)V",
      garbageValue = "-1167080702"
   )
   public void method4305(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4314(var1, var2);
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "7"
   )
   public void method4311() {
      if(this.field3276 != null) {
         for(int var1 = 0; var1 < this.field3276.length; var1 += 2) {
            if(this.field3276[var1] < this.field3275) {
               this.field3275 = this.field3276[var1];
            } else if(this.field3276[var1] > this.field3290) {
               this.field3290 = this.field3276[var1];
            }

            if(this.field3276[var1 + 1] < this.field3289) {
               this.field3289 = this.field3276[var1 + 1];
            } else if(this.field3276[var1 + 1] > this.field3282) {
               this.field3282 = this.field3276[var1 + 1];
            }
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IB)Lig;",
      garbageValue = "22"
   )
   @Export("getKitDefinition")
   public static KitDefinition getKitDefinition(int var0) {
      KitDefinition var1 = (KitDefinition)KitDefinition.identKits.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = KitDefinition.identKit_ref.getConfigData(3, var0);
         var1 = new KitDefinition();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         KitDefinition.identKits.put(var1, (long)var0);
         return var1;
      }
   }
}
