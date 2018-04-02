import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jf")
public class class281 extends CacheableNode {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   public static IndexDataBase field3576;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   public static IndexDataBase field3564;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   public static IndexDataBase field3565;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   static NodeCache field3566;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   static NodeCache field3567;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   static NodeCache field3568;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1015977413
   )
   int field3570;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 269296745
   )
   public int field3571;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1793227475
   )
   public int field3572;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1903556591
   )
   int field3573;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2010116773
   )
   int field3583;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -251855847
   )
   int field3580;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 272304363
   )
   int field3575;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1606990921
   )
   public int field3577;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 197783689
   )
   public int field3578;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1861457283
   )
   public int field3579;
   @ObfuscatedName("u")
   String field3563;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1383999409
   )
   public int field3581;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 887245263
   )
   public int field3582;
   @ObfuscatedName("y")
   public int[] field3569;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1707721593
   )
   int field3585;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -529212551
   )
   int field3574;

   static {
      field3566 = new NodeCache(64);
      field3567 = new NodeCache(64);
      field3568 = new NodeCache(20);
   }

   class281() {
      this.field3570 = -1;
      this.field3571 = 16777215;
      this.field3572 = 70;
      this.field3573 = -1;
      this.field3583 = -1;
      this.field3580 = -1;
      this.field3575 = -1;
      this.field3577 = 0;
      this.field3578 = 0;
      this.field3579 = -1;
      this.field3563 = "";
      this.field3581 = -1;
      this.field3582 = 0;
      this.field3585 = -1;
      this.field3574 = -1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgp;I)V",
      garbageValue = "1655332470"
   )
   void method4977(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4963(var1, var2);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgp;II)V",
      garbageValue = "1184230555"
   )
   void method4963(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3570 = var1.method3603();
      } else if(var2 == 2) {
         this.field3571 = var1.read24BitInt();
      } else if(var2 == 3) {
         this.field3573 = var1.method3603();
      } else if(var2 == 4) {
         this.field3580 = var1.method3603();
      } else if(var2 == 5) {
         this.field3583 = var1.method3603();
      } else if(var2 == 6) {
         this.field3575 = var1.method3603();
      } else if(var2 == 7) {
         this.field3577 = var1.readShort();
      } else if(var2 == 8) {
         this.field3563 = var1.getJagString();
      } else if(var2 == 9) {
         this.field3572 = var1.readUnsignedShort();
      } else if(var2 == 10) {
         this.field3578 = var1.readShort();
      } else if(var2 == 11) {
         this.field3579 = 0;
      } else if(var2 == 12) {
         this.field3581 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3582 = var1.readShort();
      } else if(var2 == 14) {
         this.field3579 = var1.readUnsignedShort();
      } else if(var2 == 17 || var2 == 18) {
         this.field3585 = var1.readUnsignedShort();
         if(this.field3585 == 65535) {
            this.field3585 = -1;
         }

         this.field3574 = var1.readUnsignedShort();
         if(this.field3574 == 65535) {
            this.field3574 = -1;
         }

         int var3 = -1;
         if(var2 == 18) {
            var3 = var1.readUnsignedShort();
            if(var3 == 65535) {
               var3 = -1;
            }
         }

         int var4 = var1.readUnsignedByte();
         this.field3569 = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field3569[var5] = var1.readUnsignedShort();
            if(this.field3569[var5] == 65535) {
               this.field3569[var5] = -1;
            }
         }

         this.field3569[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Ljf;",
      garbageValue = "-367203073"
   )
   public final class281 method4993() {
      int var1 = -1;
      if(this.field3585 != -1) {
         var1 = class88.getVarbit(this.field3585);
      } else if(this.field3574 != -1) {
         var1 = class237.clientVarps[this.field3574];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field3569.length - 1) {
         var2 = this.field3569[var1];
      } else {
         var2 = this.field3569[this.field3569.length - 1];
      }

      return var2 != -1?BoundingBox2D.method49(var2):null;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "340668312"
   )
   public String method4965(int var1) {
      String var2 = this.field3563;

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

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Lla;",
      garbageValue = "805969697"
   )
   public SpritePixels method4988() {
      if(this.field3573 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3567.get((long)this.field3573);
         if(var1 != null) {
            return var1;
         } else {
            var1 = BufferProvider.method5831(field3564, this.field3573, 0);
            if(var1 != null) {
               field3567.put(var1, (long)this.field3573);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Lla;",
      garbageValue = "-265034843"
   )
   public SpritePixels method4983() {
      if(this.field3583 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3567.get((long)this.field3583);
         if(var1 != null) {
            return var1;
         } else {
            var1 = BufferProvider.method5831(field3564, this.field3583, 0);
            if(var1 != null) {
               field3567.put(var1, (long)this.field3583);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Lla;",
      garbageValue = "962141704"
   )
   public SpritePixels method4968() {
      if(this.field3580 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3567.get((long)this.field3580);
         if(var1 != null) {
            return var1;
         } else {
            var1 = BufferProvider.method5831(field3564, this.field3580, 0);
            if(var1 != null) {
               field3567.put(var1, (long)this.field3580);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)Lla;",
      garbageValue = "3"
   )
   public SpritePixels method4969() {
      if(this.field3575 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3567.get((long)this.field3575);
         if(var1 != null) {
            return var1;
         } else {
            var1 = BufferProvider.method5831(field3564, this.field3575, 0);
            if(var1 != null) {
               field3567.put(var1, (long)this.field3575);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Lkw;",
      garbageValue = "2031625934"
   )
   public Font method4984() {
      if(this.field3570 == -1) {
         return null;
      } else {
         Font var1 = (Font)field3568.get((long)this.field3570);
         if(var1 != null) {
            return var1;
         } else {
            IndexDataBase var3 = field3564;
            IndexDataBase var4 = field3565;
            int var5 = this.field3570;
            Font var2;
            if(!class288.method5204(var3, var5, 0)) {
               var2 = null;
            } else {
               var2 = Area.method4772(var4.getConfigData(var5, 0));
            }

            if(var2 != null) {
               field3568.put(var2, (long)this.field3570);
            }

            return var2;
         }
      }
   }
}
