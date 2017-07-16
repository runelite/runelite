import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ir")
public class class254 extends CacheableNode {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   public static NodeCache field3427;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   public static NodeCache field3412;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   public static NodeCache field3430;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lif;"
   )
   public static IndexDataBase field3409;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lif;"
   )
   public static IndexDataBase field3408;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lif;"
   )
   public static IndexDataBase field3410;
   @ObfuscatedName("i")
   String field3411;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1517031267
   )
   int field3423;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 2066226627
   )
   int field3415;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1046704611
   )
   int field3420;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -628229643
   )
   int field3422;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -899470557
   )
   int field3421;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 66047243
   )
   int field3416;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 192481547
   )
   int field3431;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1504186883
   )
   public int field3413;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1895918027
   )
   public int field3419;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1700026335
   )
   public int field3418;
   @ObfuscatedName("q")
   public int[] field3429;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1957952139
   )
   public int field3417;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1722150095
   )
   public int field3425;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 575990875
   )
   public int field3424;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -310841593
   )
   public int field3432;

   static {
      field3427 = new NodeCache(64);
      field3430 = new NodeCache(64);
      field3412 = new NodeCache(20);
   }

   class254() {
      this.field3416 = -1;
      this.field3419 = 16777215;
      this.field3418 = 70;
      this.field3415 = -1;
      this.field3420 = -1;
      this.field3421 = -1;
      this.field3422 = -1;
      this.field3417 = 0;
      this.field3424 = 0;
      this.field3425 = -1;
      this.field3411 = "";
      this.field3413 = -1;
      this.field3432 = 0;
      this.field3423 = -1;
      this.field3431 = -1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lfe;II)V",
      garbageValue = "-1558652446"
   )
   void method4437(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3416 = var1.method3221();
      } else if(var2 == 2) {
         this.field3419 = var1.read24BitInt();
      } else if(var2 == 3) {
         this.field3415 = var1.method3221();
      } else if(var2 == 4) {
         this.field3421 = var1.method3221();
      } else if(var2 == 5) {
         this.field3420 = var1.method3221();
      } else if(var2 == 6) {
         this.field3422 = var1.method3221();
      } else if(var2 == 7) {
         this.field3417 = var1.readShort();
      } else if(var2 == 8) {
         this.field3411 = var1.getJagString();
      } else if(var2 == 9) {
         this.field3418 = var1.readUnsignedShort();
      } else if(var2 == 10) {
         this.field3424 = var1.readShort();
      } else if(var2 == 11) {
         this.field3425 = 0;
      } else if(var2 == 12) {
         this.field3413 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3432 = var1.readShort();
      } else if(var2 == 14) {
         this.field3425 = var1.readUnsignedShort();
      } else if(var2 == 17 || var2 == 18) {
         this.field3423 = var1.readUnsignedShort();
         if(this.field3423 == '\uffff') {
            this.field3423 = -1;
         }

         this.field3431 = var1.readUnsignedShort();
         if(this.field3431 == '\uffff') {
            this.field3431 = -1;
         }

         int var3 = -1;
         if(var2 == 18) {
            var3 = var1.readUnsignedShort();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         int var4 = var1.readUnsignedByte();
         this.field3429 = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field3429[var5] = var1.readUnsignedShort();
            if(this.field3429[var5] == '\uffff') {
               this.field3429[var5] = -1;
            }
         }

         this.field3429[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lfe;I)V",
      garbageValue = "1392968529"
   )
   void method4450(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4437(var1, var2);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Lir;",
      garbageValue = "109846675"
   )
   public final class254 method4431() {
      int var1 = -1;
      if(this.field3423 != -1) {
         var1 = class1.method3(this.field3423);
      } else if(this.field3431 != -1) {
         var1 = class211.widgetSettings[this.field3431];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field3429.length - 1) {
         var2 = this.field3429[var1];
      } else {
         var2 = this.field3429[this.field3429.length - 1];
      }

      return var2 != -1?class21.method154(var2):null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Ljt;",
      garbageValue = "470317651"
   )
   public SpritePixels method4457() {
      if(this.field3415 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3430.get((long)this.field3415);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class27.method217(field3408, this.field3415, 0);
            if(var1 != null) {
               field3430.put(var1, (long)this.field3415);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Ljt;",
      garbageValue = "1997915107"
   )
   public SpritePixels method4432() {
      if(this.field3420 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3430.get((long)this.field3420);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class27.method217(field3408, this.field3420, 0);
            if(var1 != null) {
               field3430.put(var1, (long)this.field3420);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Ljt;",
      garbageValue = "-1481569320"
   )
   public SpritePixels method4461() {
      if(this.field3421 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3430.get((long)this.field3421);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class27.method217(field3408, this.field3421, 0);
            if(var1 != null) {
               field3430.put(var1, (long)this.field3421);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Ljt;",
      garbageValue = "-1939096175"
   )
   public SpritePixels method4436() {
      if(this.field3422 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3430.get((long)this.field3422);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class27.method217(field3408, this.field3422, 0);
            if(var1 != null) {
               field3430.put(var1, (long)this.field3422);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Ljc;",
      garbageValue = "-1264705011"
   )
   public Font method4434() {
      if(this.field3416 == -1) {
         return null;
      } else {
         Font var1 = (Font)field3412.get((long)this.field3416);
         if(var1 != null) {
            return var1;
         } else {
            IndexDataBase var3 = field3408;
            IndexDataBase var4 = field3410;
            int var5 = this.field3416;
            Font var2;
            if(!IndexData.method4200(var3, var5, 0)) {
               var2 = null;
            } else {
               byte[] var7 = var4.getConfigData(var5, 0);
               Font var6;
               if(var7 == null) {
                  var6 = null;
               } else {
                  Font var8 = new Font(var7, class286.field3795, class31.offsetsY, class286.field3797, class90.field1405, class286.field3796, class177.spritePixels);
                  class18.method138();
                  var6 = var8;
               }

               var2 = var6;
            }

            if(var2 != null) {
               field3412.put(var2, (long)this.field3416);
            }

            return var2;
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1284539502"
   )
   public String method4460(int var1) {
      String var2 = this.field3411;

      while(true) {
         int var3 = var2.indexOf("%1");
         if(var3 < 0) {
            return var2;
         }

         var2 = var2.substring(0, var3) + GameEngine.method1005(var1, false) + var2.substring(var3 + 2);
      }
   }
}
