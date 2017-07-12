import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iu")
public class class254 extends CacheableNode {
   @ObfuscatedName("w")
   public static IndexDataBase field3419;
   @ObfuscatedName("t")
   static NodeCache field3421;
   @ObfuscatedName("s")
   static NodeCache field3422;
   @ObfuscatedName("r")
   static NodeCache field3423;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1667032027
   )
   int field3424;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -136836969
   )
   public int field3428;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 692608353
   )
   int field3429;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1145232677
   )
   int field3430;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -102784075
   )
   int field3431;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1861284069
   )
   int field3432;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1175573893
   )
   public int field3433;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1859474825
   )
   public int field3434;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -245068643
   )
   public int field3435;
   @ObfuscatedName("q")
   String field3436;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 206026223
   )
   public int field3437;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1830874405
   )
   public int field3438;
   @ObfuscatedName("g")
   public int[] field3439;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1775661171
   )
   public int field3440;
   @ObfuscatedName("i")
   public static IndexDataBase field3441;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -855632929
   )
   int field3442;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 349268549
   )
   int field3444;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-763981563"
   )
   void method4481(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4486(var1, var2);
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IS)Ljava/lang/String;",
      garbageValue = "-7327"
   )
   public String method4482(int var1) {
      String var2 = this.field3436;

      while(true) {
         int var3 = var2.indexOf("%1");
         if(var3 < 0) {
            return var2;
         }

         var2 = var2.substring(0, var3) + KitDefinition.method4390(var1, false) + var2.substring(var3 + 2);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)Lclass254;",
      garbageValue = "0"
   )
   public final class254 method4483() {
      int var1 = -1;
      if(this.field3424 != -1) {
         var1 = WorldMapType1.method264(this.field3424);
      } else if(this.field3442 != -1) {
         var1 = class211.widgetSettings[this.field3442];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field3439.length - 1) {
         var2 = this.field3439[var1];
      } else {
         var2 = this.field3439[this.field3439.length - 1];
      }

      return var2 != -1?class164.method3059(var2):null;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-1866711526"
   )
   public SpritePixels method4485() {
      if(this.field3429 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3422.get((long)this.field3429);
         if(var1 != null) {
            return var1;
         } else {
            var1 = ObjectComposition.method4574(field3419, this.field3429, 0);
            if(var1 != null) {
               field3422.put(var1, (long)this.field3429);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "-110"
   )
   void method4486(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3431 = var1.method3130();
      } else if(var2 == 2) {
         this.field3438 = var1.read24BitInt();
      } else if(var2 == 3) {
         this.field3429 = var1.method3130();
      } else if(var2 == 4) {
         this.field3444 = var1.method3130();
      } else if(var2 == 5) {
         this.field3430 = var1.method3130();
      } else if(var2 == 6) {
         this.field3432 = var1.method3130();
      } else if(var2 == 7) {
         this.field3433 = var1.readShort();
      } else if(var2 == 8) {
         this.field3436 = var1.getJagString();
      } else if(var2 == 9) {
         this.field3428 = var1.readUnsignedShort();
      } else if(var2 == 10) {
         this.field3434 = var1.readShort();
      } else if(var2 == 11) {
         this.field3435 = 0;
      } else if(var2 == 12) {
         this.field3437 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3440 = var1.readShort();
      } else if(var2 == 14) {
         this.field3435 = var1.readUnsignedShort();
      } else if(var2 == 17 || var2 == 18) {
         this.field3424 = var1.readUnsignedShort();
         if(this.field3424 == '\uffff') {
            this.field3424 = -1;
         }

         this.field3442 = var1.readUnsignedShort();
         if(this.field3442 == '\uffff') {
            this.field3442 = -1;
         }

         int var3 = -1;
         if(var2 == 18) {
            var3 = var1.readUnsignedShort();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         int var4 = var1.readUnsignedByte();
         this.field3439 = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field3439[var5] = var1.readUnsignedShort();
            if(this.field3439[var5] == '\uffff') {
               this.field3439[var5] = -1;
            }
         }

         this.field3439[var4 + 1] = var3;
      }

   }

   class254() {
      this.field3431 = -1;
      this.field3438 = 16777215;
      this.field3428 = 70;
      this.field3429 = -1;
      this.field3430 = -1;
      this.field3444 = -1;
      this.field3432 = -1;
      this.field3433 = 0;
      this.field3434 = 0;
      this.field3435 = -1;
      this.field3436 = "";
      this.field3437 = -1;
      this.field3440 = 0;
      this.field3424 = -1;
      this.field3442 = -1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "697474111"
   )
   public SpritePixels method4502() {
      if(this.field3430 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3422.get((long)this.field3430);
         if(var1 != null) {
            return var1;
         } else {
            var1 = ObjectComposition.method4574(field3419, this.field3430, 0);
            if(var1 != null) {
               field3422.put(var1, (long)this.field3430);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(S)LFont;",
      garbageValue = "402"
   )
   public Font method4506() {
      if(this.field3431 == -1) {
         return null;
      } else {
         Font var1 = (Font)field3423.get((long)this.field3431);
         if(var1 != null) {
            return var1;
         } else {
            IndexDataBase var2 = field3419;
            IndexDataBase var3 = class215.field2639;
            int var4 = this.field3431;
            Font var5;
            if(!class223.method4073(var2, var4, 0)) {
               var5 = null;
            } else {
               byte[] var6 = var3.getConfigData(var4, 0);
               Font var7;
               if(var6 == null) {
                  var7 = null;
               } else {
                  Font var8 = new Font(var6, class286.field3799, class286.offsetsY, class7.field239, class226.field3146, class278.field3745, class210.spritePixels);
                  XGrandExchangeOffer.method113();
                  var7 = var8;
               }

               var5 = var7;
            }

            if(var5 != null) {
               field3423.put(var5, (long)this.field3431);
            }

            return var5;
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(S)LSpritePixels;",
      garbageValue = "255"
   )
   public SpritePixels method4507() {
      if(this.field3444 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3422.get((long)this.field3444);
         if(var1 != null) {
            return var1;
         } else {
            var1 = ObjectComposition.method4574(field3419, this.field3444, 0);
            if(var1 != null) {
               field3422.put(var1, (long)this.field3444);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "24"
   )
   public SpritePixels method4509() {
      if(this.field3432 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3422.get((long)this.field3432);
         if(var1 != null) {
            return var1;
         } else {
            var1 = ObjectComposition.method4574(field3419, this.field3432, 0);
            if(var1 != null) {
               field3422.put(var1, (long)this.field3432);
            }

            return var1;
         }
      }
   }

   static {
      field3421 = new NodeCache(64);
      field3422 = new NodeCache(64);
      field3423 = new NodeCache(20);
   }
}
