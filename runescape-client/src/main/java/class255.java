import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ib")
public class class255 extends CacheableNode {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   static NodeCache field3404;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   static NodeCache field3402;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   static NodeCache field3403;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   static IndexDataBase field3405;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   static IndexDataBase field3400;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   static IndexDataBase field3401;
   @ObfuscatedName("u")
   String field3419;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 648555107
   )
   int field3415;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -211079625
   )
   int field3408;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1535277463
   )
   int field3412;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1219342387
   )
   int field3413;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 502802981
   )
   int field3414;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 68768669
   )
   int field3422;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 116086037
   )
   int field3407;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -700085019
   )
   public int field3399;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -58624409
   )
   public int field3409;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -976759977
   )
   public int field3410;
   @ObfuscatedName("n")
   public int[] field3421;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -556801421
   )
   public int field3420;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1669117457
   )
   public int field3417;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -758186211
   )
   public int field3416;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1003401711
   )
   public int field3423;

   static {
      field3402 = new NodeCache(64);
      field3403 = new NodeCache(64);
      field3404 = new NodeCache(20);
   }

   class255() {
      this.field3422 = -1;
      this.field3409 = 16777215;
      this.field3410 = 70;
      this.field3408 = -1;
      this.field3412 = -1;
      this.field3413 = -1;
      this.field3414 = -1;
      this.field3420 = 0;
      this.field3416 = 0;
      this.field3417 = -1;
      this.field3419 = "";
      this.field3399 = -1;
      this.field3423 = 0;
      this.field3415 = -1;
      this.field3407 = -1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lfb;II)V",
      garbageValue = "672962428"
   )
   void method4512(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3422 = var1.method3189();
      } else if(var2 == 2) {
         this.field3409 = var1.read24BitInt();
      } else if(var2 == 3) {
         this.field3408 = var1.method3189();
      } else if(var2 == 4) {
         this.field3413 = var1.method3189();
      } else if(var2 == 5) {
         this.field3412 = var1.method3189();
      } else if(var2 == 6) {
         this.field3414 = var1.method3189();
      } else if(var2 == 7) {
         this.field3420 = var1.readShort();
      } else if(var2 == 8) {
         this.field3419 = var1.getJagString();
      } else if(var2 == 9) {
         this.field3410 = var1.readUnsignedShort();
      } else if(var2 == 10) {
         this.field3416 = var1.readShort();
      } else if(var2 == 11) {
         this.field3417 = 0;
      } else if(var2 == 12) {
         this.field3399 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3423 = var1.readShort();
      } else if(var2 == 14) {
         this.field3417 = var1.readUnsignedShort();
      } else if(var2 == 17 || var2 == 18) {
         this.field3415 = var1.readUnsignedShort();
         if(this.field3415 == '\uffff') {
            this.field3415 = -1;
         }

         this.field3407 = var1.readUnsignedShort();
         if(this.field3407 == '\uffff') {
            this.field3407 = -1;
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

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lfb;B)V",
      garbageValue = "-48"
   )
   void method4511(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4512(var1, var2);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Lib;",
      garbageValue = "-556016538"
   )
   public final class255 method4513() {
      int var1 = -1;
      if(this.field3415 != -1) {
         var1 = BaseVarType.method12(this.field3415);
      } else if(this.field3407 != -1) {
         var1 = class212.widgetSettings[this.field3407];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field3421.length - 1) {
         var2 = this.field3421[var1];
      } else {
         var2 = this.field3421[this.field3421.length - 1];
      }

      return var2 != -1?BuildType.method4099(var2):null;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Lkp;",
      garbageValue = "1829597391"
   )
   public SpritePixels method4515() {
      if(this.field3408 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3403.get((long)this.field3408);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class252.method4470(field3400, this.field3408, 0);
            if(var1 != null) {
               field3403.put(var1, (long)this.field3408);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Lkp;",
      garbageValue = "-1539202009"
   )
   public SpritePixels method4510() {
      if(this.field3412 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3403.get((long)this.field3412);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class252.method4470(field3400, this.field3412, 0);
            if(var1 != null) {
               field3403.put(var1, (long)this.field3412);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)Lkp;",
      garbageValue = "1"
   )
   public SpritePixels method4517() {
      if(this.field3413 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3403.get((long)this.field3413);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class252.method4470(field3400, this.field3413, 0);
            if(var1 != null) {
               field3403.put(var1, (long)this.field3413);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Lkp;",
      garbageValue = "-576538281"
   )
   public SpritePixels method4518() {
      if(this.field3414 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3403.get((long)this.field3414);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class252.method4470(field3400, this.field3414, 0);
            if(var1 != null) {
               field3403.put(var1, (long)this.field3414);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Ljh;",
      garbageValue = "312835246"
   )
   public Font method4521() {
      if(this.field3422 == -1) {
         return null;
      } else {
         Font var1 = (Font)field3404.get((long)this.field3422);
         if(var1 != null) {
            return var1;
         } else {
            var1 = FileSystem.method4108(field3400, field3401, this.field3422, 0);
            if(var1 != null) {
               field3404.put(var1, (long)this.field3422);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1933931797"
   )
   public String method4514(int var1) {
      String var2 = this.field3419;

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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)I",
      garbageValue = "-46"
   )
   public static int method4554(CharSequence var0) {
      return class19.parseInt(var0, 10, true);
   }
}
