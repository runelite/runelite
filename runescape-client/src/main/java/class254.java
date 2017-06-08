import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("io")
public class class254 extends CacheableNode {
   @ObfuscatedName("d")
   public int[] field3417;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1451643543
   )
   public int field3418;
   @ObfuscatedName("j")
   public static NodeCache field3419;
   @ObfuscatedName("f")
   public static NodeCache field3420;
   @ObfuscatedName("m")
   public static NodeCache field3421;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -2067407947
   )
   int field3423;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 625166191
   )
   int field3424;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -717063439
   )
   public int field3425;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 2017327427
   )
   public int field3426;
   @ObfuscatedName("l")
   String field3428;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 9382075
   )
   public int field3429;
   @ObfuscatedName("n")
   public static IndexDataBase field3430;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1751270787
   )
   public int field3431;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -340106725
   )
   public int field3432;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1412101611
   )
   int field3434;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -223135823
   )
   public int field3435;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1469261237
   )
   int field3436;
   @ObfuscatedName("p")
   public static IndexDataBase field3437;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 21210509
   )
   int field3438;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1714698633
   )
   int field3439;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1430642393
   )
   int field3440;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "-55"
   )
   public SpritePixels method4502() {
      if(this.field3440 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3420.get((long)this.field3440);
         if(var1 != null) {
            return var1;
         } else {
            var1 = WallObject.method2876(field3437, this.field3440, 0);
            if(var1 != null) {
               field3420.put(var1, (long)this.field3440);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "4"
   )
   void method4503(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4537(var1, var2);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-1506098973"
   )
   public SpritePixels method4505() {
      if(this.field3423 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3420.get((long)this.field3423);
         if(var1 != null) {
            return var1;
         } else {
            var1 = WallObject.method2876(field3437, this.field3423, 0);
            if(var1 != null) {
               field3420.put(var1, (long)this.field3423);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "1143037006"
   )
   public SpritePixels method4506() {
      if(this.field3434 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3420.get((long)this.field3434);
         if(var1 != null) {
            return var1;
         } else {
            var1 = WallObject.method2876(field3437, this.field3434, 0);
            if(var1 != null) {
               field3420.put(var1, (long)this.field3434);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Lclass254;",
      garbageValue = "2072599028"
   )
   public final class254 method4507() {
      int var1 = -1;
      if(this.field3438 != -1) {
         var1 = class205.method3843(this.field3438);
      } else if(this.field3439 != -1) {
         var1 = class211.widgetSettings[this.field3439];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field3417.length - 1) {
         var2 = this.field3417[var1];
      } else {
         var2 = this.field3417[this.field3417.length - 1];
      }

      return var2 != -1?class270.method4936(var2):null;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "22"
   )
   public SpritePixels method4508() {
      if(this.field3436 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3420.get((long)this.field3436);
         if(var1 != null) {
            return var1;
         } else {
            var1 = WallObject.method2876(field3437, this.field3436, 0);
            if(var1 != null) {
               field3420.put(var1, (long)this.field3436);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)LFont;",
      garbageValue = "-652684785"
   )
   public Font method4509() {
      if(this.field3424 == -1) {
         return null;
      } else {
         Font var1 = (Font)field3421.get((long)this.field3424);
         if(var1 != null) {
            return var1;
         } else {
            IndexDataBase var3 = field3437;
            IndexDataBase var4 = class2.field20;
            int var5 = this.field3424;
            Font var2;
            if(!class112.method2092(var3, var5, 0)) {
               var2 = null;
            } else {
               byte[] var7 = var4.getConfigData(var5, 0);
               Font var6;
               if(var7 == null) {
                  var6 = null;
               } else {
                  Font var8 = new Font(var7, class95.field1493, class286.field3790, class286.field3793, class241.field3293, class174.field2410, class31.field449);
                  VertexNormal.method2592();
                  var6 = var8;
               }

               var2 = var6;
            }

            if(var2 != null) {
               field3421.put(var2, (long)this.field3424);
            }

            return var2;
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
      this.field3425 = 16777215;
      this.field3426 = 70;
      this.field3423 = -1;
      this.field3434 = -1;
      this.field3440 = -1;
      this.field3436 = -1;
      this.field3431 = 0;
      this.field3432 = 0;
      this.field3429 = -1;
      this.field3428 = "";
      this.field3435 = -1;
      this.field3418 = 0;
      this.field3438 = -1;
      this.field3439 = -1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-1601121427"
   )
   public String method4511(int var1) {
      String var2 = this.field3428;

      while(true) {
         int var3 = var2.indexOf("%1");
         if(var3 < 0) {
            return var2;
         }

         var2 = var2.substring(0, var3) + class8.method52(var1, false) + var2.substring(var3 + 2);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "-61"
   )
   void method4537(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3424 = var1.method3338();
      } else if(var2 == 2) {
         this.field3425 = var1.read24BitInt();
      } else if(var2 == 3) {
         this.field3423 = var1.method3338();
      } else if(var2 == 4) {
         this.field3440 = var1.method3338();
      } else if(var2 == 5) {
         this.field3434 = var1.method3338();
      } else if(var2 == 6) {
         this.field3436 = var1.method3338();
      } else if(var2 == 7) {
         this.field3431 = var1.readShort();
      } else if(var2 == 8) {
         this.field3428 = var1.method3263();
      } else if(var2 == 9) {
         this.field3426 = var1.readUnsignedShort();
      } else if(var2 == 10) {
         this.field3432 = var1.readShort();
      } else if(var2 == 11) {
         this.field3429 = 0;
      } else if(var2 == 12) {
         this.field3435 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3418 = var1.readShort();
      } else if(var2 == 14) {
         this.field3429 = var1.readUnsignedShort();
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
         this.field3417 = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field3417[var5] = var1.readUnsignedShort();
            if(this.field3417[var5] == '\uffff') {
               this.field3417[var5] = -1;
            }
         }

         this.field3417[var4 + 1] = var3;
      }

   }
}
