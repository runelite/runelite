import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ip")
public class class255 extends CacheableNode {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   static NodeCache field3421;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   static NodeCache field3413;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   static NodeCache field3430;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   static IndexDataBase field3419;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   static IndexDataBase field3425;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   static IndexDataBase field3429;
   @ObfuscatedName("x")
   String field3428;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 2015455787
   )
   int field3432;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1778468259
   )
   int field3433;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -640750497
   )
   int field3423;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1374660513
   )
   int field3424;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1885755735
   )
   int field3418;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -905474929
   )
   int field3422;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1755738251
   )
   int field3427;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 2108976349
   )
   public int field3416;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -778587131
   )
   public int field3415;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1006426779
   )
   public int field3420;
   @ObfuscatedName("g")
   public int[] field3431;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -141186643
   )
   public int field3414;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1252658235
   )
   public int field3411;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1527347219
   )
   public int field3426;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -279905169
   )
   public int field3412;

   static {
      field3413 = new NodeCache(64);
      field3430 = new NodeCache(64);
      field3421 = new NodeCache(20);
   }

   class255() {
      this.field3418 = -1;
      this.field3415 = 16777215;
      this.field3420 = 70;
      this.field3433 = -1;
      this.field3422 = -1;
      this.field3423 = -1;
      this.field3424 = -1;
      this.field3414 = 0;
      this.field3426 = 0;
      this.field3411 = -1;
      this.field3428 = "";
      this.field3416 = -1;
      this.field3412 = 0;
      this.field3432 = -1;
      this.field3427 = -1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lfp;IB)V",
      garbageValue = "64"
   )
   void method4499(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3418 = var1.method3262();
      } else if(var2 == 2) {
         this.field3415 = var1.read24BitInt();
      } else if(var2 == 3) {
         this.field3433 = var1.method3262();
      } else if(var2 == 4) {
         this.field3423 = var1.method3262();
      } else if(var2 == 5) {
         this.field3422 = var1.method3262();
      } else if(var2 == 6) {
         this.field3424 = var1.method3262();
      } else if(var2 == 7) {
         this.field3414 = var1.readShort();
      } else if(var2 == 8) {
         this.field3428 = var1.getJagString();
      } else if(var2 == 9) {
         this.field3420 = var1.readUnsignedShort();
      } else if(var2 == 10) {
         this.field3426 = var1.readShort();
      } else if(var2 == 11) {
         this.field3411 = 0;
      } else if(var2 == 12) {
         this.field3416 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3412 = var1.readShort();
      } else if(var2 == 14) {
         this.field3411 = var1.readUnsignedShort();
      } else if(var2 == 17 || var2 == 18) {
         this.field3432 = var1.readUnsignedShort();
         if(this.field3432 == '\uffff') {
            this.field3432 = -1;
         }

         this.field3427 = var1.readUnsignedShort();
         if(this.field3427 == '\uffff') {
            this.field3427 = -1;
         }

         int var3 = -1;
         if(var2 == 18) {
            var3 = var1.readUnsignedShort();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         int var4 = var1.readUnsignedByte();
         this.field3431 = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field3431[var5] = var1.readUnsignedShort();
            if(this.field3431[var5] == '\uffff') {
               this.field3431[var5] = -1;
            }
         }

         this.field3431[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lfp;I)V",
      garbageValue = "-778587131"
   )
   void method4484(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4499(var1, var2);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)Lip;",
      garbageValue = "1"
   )
   public final class255 method4486() {
      int var1 = -1;
      if(this.field3432 != -1) {
         var1 = WidgetNode.method1121(this.field3432);
      } else if(this.field3427 != -1) {
         var1 = class212.widgetSettings[this.field3427];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field3431.length - 1) {
         var2 = this.field3431[var1];
      } else {
         var2 = this.field3431[this.field3431.length - 1];
      }

      return var2 != -1?class61.method1090(var2):null;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Lkd;",
      garbageValue = "1681574618"
   )
   public SpritePixels method4488() {
      if(this.field3433 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3430.get((long)this.field3433);
         if(var1 != null) {
            return var1;
         } else {
            var1 = method4507(field3425, this.field3433, 0);
            if(var1 != null) {
               field3430.put(var1, (long)this.field3433);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)Lkd;",
      garbageValue = "-19"
   )
   public SpritePixels method4496() {
      if(this.field3422 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3430.get((long)this.field3422);
         if(var1 != null) {
            return var1;
         } else {
            var1 = method4507(field3425, this.field3422, 0);
            if(var1 != null) {
               field3430.put(var1, (long)this.field3422);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Lkd;",
      garbageValue = "-97685629"
   )
   public SpritePixels method4490() {
      if(this.field3423 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3430.get((long)this.field3423);
         if(var1 != null) {
            return var1;
         } else {
            var1 = method4507(field3425, this.field3423, 0);
            if(var1 != null) {
               field3430.put(var1, (long)this.field3423);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(S)Lkd;",
      garbageValue = "-12354"
   )
   public SpritePixels method4491() {
      if(this.field3424 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3430.get((long)this.field3424);
         if(var1 != null) {
            return var1;
         } else {
            var1 = method4507(field3425, this.field3424, 0);
            if(var1 != null) {
               field3430.put(var1, (long)this.field3424);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Ljm;",
      garbageValue = "-2143894571"
   )
   public Font method4492() {
      if(this.field3418 == -1) {
         return null;
      } else {
         Font var1 = (Font)field3421.get((long)this.field3418);
         if(var1 != null) {
            return var1;
         } else {
            var1 = PlayerComposition.method4019(field3425, field3429, this.field3418, 0);
            if(var1 != null) {
               field3421.put(var1, (long)this.field3418);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "4"
   )
   public String method4487(int var1) {
      String var2 = this.field3428;

      while(true) {
         int var3 = var2.indexOf("%1");
         if(var3 < 0) {
            return var2;
         }

         var2 = var2.substring(0, var3) + class2.method3(var1, false) + var2.substring(var3 + 2);
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lii;III)Lkd;",
      garbageValue = "-1038273418"
   )
   public static SpritePixels method4507(IndexDataBase var0, int var1, int var2) {
      if(!class178.method3474(var0, var1, var2)) {
         return null;
      } else {
         SpritePixels var4 = new SpritePixels();
         var4.maxWidth = class287.field3797;
         var4.maxHeight = class287.field3798;
         var4.offsetX = class271.field3679[0];
         var4.offsetY = class18.offsetsY[0];
         var4.width = class287.field3796[0];
         var4.height = class245.field3324[0];
         int var5 = var4.height * var4.width;
         byte[] var6 = class274.spritePixels[0];
         var4.image = new int[var5];

         for(int var7 = 0; var7 < var5; ++var7) {
            var4.image[var7] = Varbit.field3387[var6[var7] & 255];
         }

         Buffer.method3330();
         return var4;
      }
   }
}
