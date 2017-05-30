import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("is")
public class class254 extends CacheableNode {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 624467739
   )
   public int field3403;
   @ObfuscatedName("h")
   static IndexDataBase field3404;
   @ObfuscatedName("g")
   static NodeCache field3405;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 776054093
   )
   public int field3406;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1752871791
   )
   public int field3407;
   @ObfuscatedName("i")
   static IndexDataBase field3409;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -216167781
   )
   int field3411;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -873814299
   )
   public int field3412;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1000068881
   )
   int field3413;
   @ObfuscatedName("v")
   static NodeCache field3414;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 400761433
   )
   int field3415;
   @ObfuscatedName("q")
   static NodeCache field3416;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1474426415
   )
   int field3417;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1495399995
   )
   int field3419;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -397702455
   )
   int field3420;
   @ObfuscatedName("y")
   String field3421;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1647712165
   )
   public int field3422;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 712628127
   )
   public int field3423;
   @ObfuscatedName("c")
   public int[] field3424;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 481006337
   )
   int field3425;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1433816577
   )
   public int field3426;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1132653383"
   )
   void method4544(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4554(var1, var2);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-1029164747"
   )
   public SpritePixels method4545() {
      if(this.field3413 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3405.get((long)this.field3413);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class123.method2381(field3404, this.field3413, 0);
            if(var1 != null) {
               field3405.put(var1, (long)this.field3413);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Lclass254;",
      garbageValue = "1096534523"
   )
   public final class254 method4546() {
      int var1 = -1;
      if(this.field3425 != -1) {
         var1 = Actor.method1539(this.field3425);
      } else if(this.field3419 != -1) {
         var1 = class211.widgetSettings[this.field3419];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field3424.length - 1) {
         var2 = this.field3424[var1];
      } else {
         var2 = this.field3424[this.field3424.length - 1];
      }

      return var2 != -1?class149.method2942(var2):null;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "0"
   )
   public String method4547(int var1) {
      String var2 = this.field3421;

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

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "-32"
   )
   public SpritePixels method4550() {
      if(this.field3420 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3405.get((long)this.field3420);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class123.method2381(field3404, this.field3420, 0);
            if(var1 != null) {
               field3405.put(var1, (long)this.field3420);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "1997900772"
   )
   public SpritePixels method4551() {
      if(this.field3417 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3405.get((long)this.field3417);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class123.method2381(field3404, this.field3417, 0);
            if(var1 != null) {
               field3405.put(var1, (long)this.field3417);
            }

            return var1;
         }
      }
   }

   static {
      field3416 = new NodeCache(64);
      field3405 = new NodeCache(64);
      field3414 = new NodeCache(20);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1180005001"
   )
   void method4554(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3411 = var1.method3214();
      } else if(var2 == 2) {
         this.field3412 = var1.read24BitInt();
      } else if(var2 == 3) {
         this.field3413 = var1.method3214();
      } else if(var2 == 4) {
         this.field3420 = var1.method3214();
      } else if(var2 == 5) {
         this.field3415 = var1.method3214();
      } else if(var2 == 6) {
         this.field3417 = var1.method3214();
      } else if(var2 == 7) {
         this.field3407 = var1.readShort();
      } else if(var2 == 8) {
         this.field3421 = var1.method3208();
      } else if(var2 == 9) {
         this.field3426 = var1.readUnsignedShort();
      } else if(var2 == 10) {
         this.field3406 = var1.readShort();
      } else if(var2 == 11) {
         this.field3403 = 0;
      } else if(var2 == 12) {
         this.field3422 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3423 = var1.readShort();
      } else if(var2 == 14) {
         this.field3403 = var1.readUnsignedShort();
      } else if(var2 == 17 || var2 == 18) {
         this.field3425 = var1.readUnsignedShort();
         if(this.field3425 == '\uffff') {
            this.field3425 = -1;
         }

         this.field3419 = var1.readUnsignedShort();
         if(this.field3419 == '\uffff') {
            this.field3419 = -1;
         }

         int var3 = -1;
         if(var2 == 18) {
            var3 = var1.readUnsignedShort();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         int var4 = var1.readUnsignedByte();
         this.field3424 = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field3424[var5] = var1.readUnsignedShort();
            if(this.field3424[var5] == '\uffff') {
               this.field3424[var5] = -1;
            }
         }

         this.field3424[var4 + 1] = var3;
      }

   }

   class254() {
      this.field3411 = -1;
      this.field3412 = 16777215;
      this.field3426 = 70;
      this.field3413 = -1;
      this.field3415 = -1;
      this.field3420 = -1;
      this.field3417 = -1;
      this.field3407 = 0;
      this.field3406 = 0;
      this.field3403 = -1;
      this.field3421 = "";
      this.field3422 = -1;
      this.field3423 = 0;
      this.field3425 = -1;
      this.field3419 = -1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-108101143"
   )
   public SpritePixels method4561() {
      if(this.field3415 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3405.get((long)this.field3415);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class123.method2381(field3404, this.field3415, 0);
            if(var1 != null) {
               field3405.put(var1, (long)this.field3415);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)LFont;",
      garbageValue = "2125065338"
   )
   public Font method4567() {
      if(this.field3411 == -1) {
         return null;
      } else {
         Font var1 = (Font)field3414.get((long)this.field3411);
         if(var1 != null) {
            return var1;
         } else {
            var1 = WorldMapType1.method265(field3404, Frames.field2126, this.field3411, 0);
            if(var1 != null) {
               field3414.put(var1, (long)this.field3411);
            }

            return var1;
         }
      }
   }
}
