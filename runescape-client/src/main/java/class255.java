import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ix")
public class class255 extends CacheableNode {
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   public static NodeCache field3406;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   public static NodeCache field3419;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   public static NodeCache field3405;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   static IndexDataBase field3411;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   static IndexDataBase field3413;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   static IndexDataBase field3403;
   @ObfuscatedName("b")
   String field3418;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 97135287
   )
   int field3422;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 215785637
   )
   int field3424;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 768534393
   )
   int field3408;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1880600215
   )
   int field3412;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 426864811
   )
   int field3414;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 803488823
   )
   int field3420;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -571357449
   )
   int field3423;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1681552149
   )
   public int field3402;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -935800789
   )
   public int field3417;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 376474647
   )
   public int field3404;
   @ObfuscatedName("j")
   public int[] field3421;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -745195907
   )
   public int field3415;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 379386019
   )
   public int field3401;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 994112447
   )
   public int field3410;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 2057003463
   )
   public int field3409;

   static {
      field3419 = new NodeCache(64);
      field3405 = new NodeCache(64);
      field3406 = new NodeCache(20);
   }

   class255() {
      this.field3420 = -1;
      this.field3417 = 16777215;
      this.field3404 = 70;
      this.field3424 = -1;
      this.field3412 = -1;
      this.field3408 = -1;
      this.field3414 = -1;
      this.field3415 = 0;
      this.field3410 = 0;
      this.field3401 = -1;
      this.field3418 = "";
      this.field3402 = -1;
      this.field3409 = 0;
      this.field3422 = -1;
      this.field3423 = -1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lfh;II)V",
      garbageValue = "-690110611"
   )
   void method4508(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3420 = var1.method3190();
      } else if(var2 == 2) {
         this.field3417 = var1.read24BitInt();
      } else if(var2 == 3) {
         this.field3424 = var1.method3190();
      } else if(var2 == 4) {
         this.field3408 = var1.method3190();
      } else if(var2 == 5) {
         this.field3412 = var1.method3190();
      } else if(var2 == 6) {
         this.field3414 = var1.method3190();
      } else if(var2 == 7) {
         this.field3415 = var1.readShort();
      } else if(var2 == 8) {
         this.field3418 = var1.getJagString();
      } else if(var2 == 9) {
         this.field3404 = var1.readUnsignedShort();
      } else if(var2 == 10) {
         this.field3410 = var1.readShort();
      } else if(var2 == 11) {
         this.field3401 = 0;
      } else if(var2 == 12) {
         this.field3402 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3409 = var1.readShort();
      } else if(var2 == 14) {
         this.field3401 = var1.readUnsignedShort();
      } else if(var2 == 17 || var2 == 18) {
         this.field3422 = var1.readUnsignedShort();
         if(this.field3422 == '\uffff') {
            this.field3422 = -1;
         }

         this.field3423 = var1.readUnsignedShort();
         if(this.field3423 == '\uffff') {
            this.field3423 = -1;
         }

         int var3 = -1;
         if(var2 == 18) {
            var3 = var1.readUnsignedShort();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         int var4 = var1.readUnsignedByte();
         this.field3421 = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field3421[var5] = var1.readUnsignedShort();
            if(this.field3421[var5] == '\uffff') {
               this.field3421[var5] = -1;
            }
         }

         this.field3421[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lfh;B)V",
      garbageValue = "16"
   )
   void method4501(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4508(var1, var2);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Lix;",
      garbageValue = "-1375683043"
   )
   public final class255 method4497() {
      int var1 = -1;
      if(this.field3422 != -1) {
         var1 = class209.method3887(this.field3422);
      } else if(this.field3423 != -1) {
         var1 = class212.widgetSettings[this.field3423];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field3421.length - 1) {
         var2 = this.field3421[var1];
      } else {
         var2 = this.field3421[this.field3421.length - 1];
      }

      return var2 != -1?CombatInfo1.method1547(var2):null;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)Lkn;",
      garbageValue = "-80"
   )
   public SpritePixels method4509() {
      if(this.field3424 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3405.get((long)this.field3424);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class64.method1087(field3413, this.field3424, 0);
            if(var1 != null) {
               field3405.put(var1, (long)this.field3424);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)Lkn;",
      garbageValue = "-72"
   )
   public SpritePixels method4500() {
      if(this.field3412 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3405.get((long)this.field3412);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class64.method1087(field3413, this.field3412, 0);
            if(var1 != null) {
               field3405.put(var1, (long)this.field3412);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Lkn;",
      garbageValue = "871534589"
   )
   public SpritePixels method4515() {
      if(this.field3408 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3405.get((long)this.field3408);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class64.method1087(field3413, this.field3408, 0);
            if(var1 != null) {
               field3405.put(var1, (long)this.field3408);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Lkn;",
      garbageValue = "-654636456"
   )
   public SpritePixels method4502() {
      if(this.field3414 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3405.get((long)this.field3414);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class64.method1087(field3413, this.field3414, 0);
            if(var1 != null) {
               field3405.put(var1, (long)this.field3414);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Ljk;",
      garbageValue = "-610187737"
   )
   public Font method4503() {
      if(this.field3420 == -1) {
         return null;
      } else {
         Font var1 = (Font)field3406.get((long)this.field3420);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class218.method4053(field3413, field3403, this.field3420, 0);
            if(var1 != null) {
               field3406.put(var1, (long)this.field3420);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-1066271329"
   )
   public String method4498(int var1) {
      String var2 = this.field3418;

      while(true) {
         int var3 = var2.indexOf("%1");
         if(var3 < 0) {
            return var2;
         }

         String var4 = var2.substring(0, var3);
         String var5 = Integer.toString(var1);
         var2 = var4 + var5 + var2.substring(var3 + 2);
      }
   }

   @ObfuscatedName("iz")
   @ObfuscatedSignature(
      signature = "(Lhg;I)V",
      garbageValue = "243398512"
   )
   static void method4531(Widget var0) {
      if(var0.loopCycle == Client.field1106) {
         Client.field1107[var0.boundsIndex] = true;
      }

   }
}
