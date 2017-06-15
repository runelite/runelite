import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("in")
public class class254 extends CacheableNode {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1939589685
   )
   public int field3416;
   @ObfuscatedName("m")
   public static IndexDataBase field3417;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1854234717
   )
   public int field3418;
   @ObfuscatedName("t")
   public static NodeCache field3419;
   @ObfuscatedName("w")
   public static NodeCache field3420;
   @ObfuscatedName("z")
   public static NodeCache field3421;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1131046161
   )
   public int field3422;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1712862841
   )
   int field3424;
   @ObfuscatedName("e")
   public static IndexDataBase field3425;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -431663267
   )
   public int field3426;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1258226331
   )
   int field3427;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -982540305
   )
   int field3428;
   @ObfuscatedName("p")
   public static IndexDataBase field3429;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 898041125
   )
   int field3430;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -926230535
   )
   int field3431;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -76519473
   )
   public int field3432;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -768991687
   )
   public int field3433;
   @ObfuscatedName("d")
   String field3434;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1500311061
   )
   public int field3435;
   @ObfuscatedName("y")
   public int[] field3436;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 49967931
   )
   int field3438;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -194769307
   )
   int field3439;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-532802795"
   )
   void method4349(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4350(var1, var2);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-2051310713"
   )
   void method4350(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3424 = var1.method3048();
      } else if(var2 == 2) {
         this.field3433 = var1.read24BitInt();
      } else if(var2 == 3) {
         this.field3427 = var1.method3048();
      } else if(var2 == 4) {
         this.field3428 = var1.method3048();
      } else if(var2 == 5) {
         this.field3431 = var1.method3048();
      } else if(var2 == 6) {
         this.field3430 = var1.method3048();
      } else if(var2 == 7) {
         this.field3416 = var1.readShort();
      } else if(var2 == 8) {
         this.field3434 = var1.method3042();
      } else if(var2 == 9) {
         this.field3418 = var1.readUnsignedShort();
      } else if(var2 == 10) {
         this.field3432 = var1.readShort();
      } else if(var2 == 11) {
         this.field3422 = 0;
      } else if(var2 == 12) {
         this.field3435 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3426 = var1.readShort();
      } else if(var2 == 14) {
         this.field3422 = var1.readUnsignedShort();
      } else if(var2 == 17 || var2 == 18) {
         this.field3438 = var1.readUnsignedShort();
         if(this.field3438 == '\uffff') {
            this.field3438 = -1;
         }

         this.field3439 = var1.readUnsignedShort();
         if(this.field3439 == '\uffff') {
            this.field3439 = -1;
         }

         int var3 = -1;
         if(var2 == 18) {
            var3 = var1.readUnsignedShort();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         int var4 = var1.readUnsignedByte();
         this.field3436 = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field3436[var5] = var1.readUnsignedShort();
            if(this.field3436[var5] == '\uffff') {
               this.field3436[var5] = -1;
            }
         }

         this.field3436[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Lclass254;",
      garbageValue = "1502098922"
   )
   public final class254 method4351() {
      int var1 = -1;
      if(this.field3438 != -1) {
         var1 = class50.method728(this.field3438);
      } else if(this.field3439 != -1) {
         var1 = class211.widgetSettings[this.field3439];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field3436.length - 1) {
         var2 = this.field3436[var1];
      } else {
         var2 = this.field3436[this.field3436.length - 1];
      }

      return var2 != -1?class24.method200(var2):null;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "125"
   )
   public String method4352(int var1) {
      String var2 = this.field3434;

      while(true) {
         int var3 = var2.indexOf("%1");
         if(var3 < 0) {
            return var2;
         }

         var2 = var2.substring(0, var3) + ItemLayer.method2308(var1, false) + var2.substring(var3 + 2);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)LFont;",
      garbageValue = "0"
   )
   public Font method4353() {
      if(this.field3424 == -1) {
         return null;
      } else {
         Font var1 = (Font)field3421.get((long)this.field3424);
         if(var1 != null) {
            return var1;
         } else {
            IndexDataBase var3 = field3417;
            IndexDataBase var4 = field3425;
            int var5 = this.field3424;
            Font var2;
            if(!class1.method3(var3, var5, 0)) {
               var2 = null;
            } else {
               var2 = class12.method74(var4.getConfigData(var5, 0));
            }

            if(var2 != null) {
               field3421.put(var2, (long)this.field3424);
            }

            return var2;
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "985290472"
   )
   public SpritePixels method4354() {
      if(this.field3431 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3420.get((long)this.field3431);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class262.method4613(field3417, this.field3431, 0);
            if(var1 != null) {
               field3420.put(var1, (long)this.field3431);
            }

            return var1;
         }
      }
   }

   static {
      field3419 = new NodeCache(64);
      field3420 = new NodeCache(64);
      field3421 = new NodeCache(20);
   }

   class254() {
      this.field3424 = -1;
      this.field3433 = 16777215;
      this.field3418 = 70;
      this.field3427 = -1;
      this.field3431 = -1;
      this.field3428 = -1;
      this.field3430 = -1;
      this.field3416 = 0;
      this.field3432 = 0;
      this.field3422 = -1;
      this.field3434 = "";
      this.field3435 = -1;
      this.field3426 = 0;
      this.field3438 = -1;
      this.field3439 = -1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-780914901"
   )
   public SpritePixels method4376() {
      if(this.field3428 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3420.get((long)this.field3428);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class262.method4613(field3417, this.field3428, 0);
            if(var1 != null) {
               field3420.put(var1, (long)this.field3428);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-1259305177"
   )
   public SpritePixels method4378() {
      if(this.field3427 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3420.get((long)this.field3427);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class262.method4613(field3417, this.field3427, 0);
            if(var1 != null) {
               field3420.put(var1, (long)this.field3427);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-276747672"
   )
   public SpritePixels method4386() {
      if(this.field3430 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3420.get((long)this.field3430);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class262.method4613(field3417, this.field3430, 0);
            if(var1 != null) {
               field3420.put(var1, (long)this.field3430);
            }

            return var1;
         }
      }
   }
}
