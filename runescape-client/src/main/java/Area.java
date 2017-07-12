import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ij")
@Implements("Area")
public class Area extends CacheableNode {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1658282555
   )
   int field3294;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1539830473
   )
   static int field3295;
   @ObfuscatedName("t")
   @Export("skeletonsIndex")
   static NodeCache skeletonsIndex;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1188109863
   )
   public final int field3297;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1586498981
   )
   int field3299;
   @ObfuscatedName("y")
   @Export("name")
   public String name;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1600014611
   )
   public int field3301;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1304194625
   )
   public int field3302;
   @ObfuscatedName("w")
   public static Area[] field3303;
   @ObfuscatedName("o")
   public String[] field3304;
   @ObfuscatedName("z")
   public String field3305;
   @ObfuscatedName("l")
   int[] field3306;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1042856535
   )
   public int field3307;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1113256817
   )
   @Export("spriteId")
   public int spriteId;
   @ObfuscatedName("u")
   public class239 field3309;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1891181725
   )
   int field3310;
   @ObfuscatedName("n")
   public class257 field3311;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -203579295
   )
   int field3312;
   @ObfuscatedName("p")
   int[] field3313;
   @ObfuscatedName("q")
   byte[] field3314;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1245960855
   )
   int field3315;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-71"
   )
   void method4288(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4303(var1, var2);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1814972588"
   )
   public int method4289() {
      return this.field3297;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ZI)LSpritePixels;",
      garbageValue = "1704270954"
   )
   public SpritePixels method4291(boolean var1) {
      int var2 = this.spriteId;
      return this.method4292(var2);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)LSpritePixels;",
      garbageValue = "2095156677"
   )
   SpritePixels method4292(int var1) {
      if(var1 < 0) {
         return null;
      } else {
         SpritePixels var2 = (SpritePixels)skeletonsIndex.get((long)var1);
         if(var2 != null) {
            return var2;
         } else {
            var2 = ObjectComposition.method4574(class15.field298, var1, 0);
            if(var2 != null) {
               skeletonsIndex.put(var2, (long)var1);
            }

            return var2;
         }
      }
   }

   Area(int var1) {
      this.spriteId = -1;
      this.field3312 = -1;
      this.field3302 = 0;
      this.field3304 = new String[5];
      this.field3294 = Integer.MAX_VALUE;
      this.field3299 = Integer.MAX_VALUE;
      this.field3315 = Integer.MIN_VALUE;
      this.field3310 = Integer.MIN_VALUE;
      this.field3311 = class257.field3553;
      this.field3309 = class239.field3280;
      this.field3307 = -1;
      this.field3297 = var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1621254418"
   )
   void method4303(Buffer var1, int var2) {
      if(var2 == 1) {
         this.spriteId = var1.method3130();
      } else if(var2 == 2) {
         this.field3312 = var1.method3130();
      } else if(var2 == 3) {
         this.name = var1.readString();
      } else if(var2 == 4) {
         this.field3301 = var1.read24BitInt();
      } else if(var2 == 5) {
         var1.read24BitInt();
      } else if(var2 == 6) {
         this.field3302 = var1.readUnsignedByte();
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
            this.field3304[var2 - 10] = var1.readString();
         } else if(var2 == 15) {
            var3 = var1.readUnsignedByte();
            this.field3306 = new int[var3 * 2];

            int var4;
            for(var4 = 0; var4 < var3 * 2; ++var4) {
               this.field3306[var4] = var1.readShort();
            }

            var1.readInt();
            var4 = var1.readUnsignedByte();
            this.field3313 = new int[var4];

            int var5;
            for(var5 = 0; var5 < this.field3313.length; ++var5) {
               this.field3313[var5] = var1.readInt();
            }

            this.field3314 = new byte[var3];

            for(var5 = 0; var5 < var3; ++var5) {
               this.field3314[var5] = var1.readByte();
            }
         } else if(var2 != 16) {
            if(var2 == 17) {
               this.field3305 = var1.readString();
            } else if(var2 == 18) {
               var1.method3130();
            } else if(var2 == 19) {
               this.field3307 = var1.readUnsignedShort();
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
               var1.method3130();
            } else if(var2 == 28) {
               var1.readUnsignedByte();
            } else if(var2 == 29) {
               class257[] var6 = new class257[]{class257.field3552, class257.field3553, class257.field3551};
               this.field3311 = (class257)class134.forOrdinal(var6, var1.readUnsignedByte());
            } else if(var2 == 30) {
               class239[] var7 = new class239[]{class239.field3280, class239.field3283, class239.field3279};
               this.field3309 = (class239)class134.forOrdinal(var7, var1.readUnsignedByte());
            }
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-57"
   )
   void method4310() {
      if(this.field3306 != null) {
         for(int var1 = 0; var1 < this.field3306.length; var1 += 2) {
            if(this.field3306[var1] < this.field3294) {
               this.field3294 = this.field3306[var1];
            } else if(this.field3306[var1] > this.field3315) {
               this.field3315 = this.field3306[var1];
            }

            if(this.field3306[var1 + 1] < this.field3299) {
               this.field3299 = this.field3306[var1 + 1];
            } else if(this.field3306[var1 + 1] > this.field3310) {
               this.field3310 = this.field3306[var1 + 1];
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;ZI)V",
      garbageValue = "-775668954"
   )
   public static void method4312(IndexDataBase var0, IndexDataBase var1, boolean var2) {
      ObjectComposition.objects_ref = var0;
      ObjectComposition.field3447 = var1;
      ObjectComposition.field3464 = var2;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)I",
      garbageValue = "22"
   )
   public static int method4313(String var0) {
      return var0.length() + 2;
   }

   static {
      skeletonsIndex = new NodeCache(256);
   }
}
