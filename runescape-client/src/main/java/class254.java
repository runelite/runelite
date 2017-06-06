import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iz")
public class class254 extends CacheableNode {
   @ObfuscatedName("c")
   static IndexDataBase field3407;
   @ObfuscatedName("e")
   static IndexDataBase field3408;
   @ObfuscatedName("v")
   static NodeCache field3409;
   @ObfuscatedName("b")
   static NodeCache field3410;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 697275899
   )
   public int field3411;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 949521783
   )
   int field3414;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1182771475
   )
   int field3415;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1418167289
   )
   public int field3416;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -967849695
   )
   int field3417;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 481112197
   )
   int field3418;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1319354749
   )
   int field3419;
   @ObfuscatedName("y")
   static NodeCache field3420;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1838964339
   )
   public int field3421;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -857624137
   )
   public int field3423;
   @ObfuscatedName("w")
   String field3424;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1198903211
   )
   public int field3425;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1893399441
   )
   public int field3426;
   @ObfuscatedName("u")
   public int[] field3427;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2137158685
   )
   public int field3428;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1294819701
   )
   int field3429;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -409250357
   )
   int field3430;
   @ObfuscatedName("af")
   static java.awt.Font field3431;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-155297522"
   )
   void method4485(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4486(var1, var2);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "-35"
   )
   void method4486(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3414 = var1.method3156();
      } else if(var2 == 2) {
         this.field3411 = var1.read24BitInt();
      } else if(var2 == 3) {
         this.field3417 = var1.method3156();
      } else if(var2 == 4) {
         this.field3419 = var1.method3156();
      } else if(var2 == 5) {
         this.field3418 = var1.method3156();
      } else if(var2 == 6) {
         this.field3430 = var1.method3156();
      } else if(var2 == 7) {
         this.field3421 = var1.readShort();
      } else if(var2 == 8) {
         this.field3424 = var1.method3167();
      } else if(var2 == 9) {
         this.field3416 = var1.readUnsignedShort();
      } else if(var2 == 10) {
         this.field3423 = var1.readShort();
      } else if(var2 == 11) {
         this.field3428 = 0;
      } else if(var2 == 12) {
         this.field3425 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3426 = var1.readShort();
      } else if(var2 == 14) {
         this.field3428 = var1.readUnsignedShort();
      } else if(var2 == 17 || var2 == 18) {
         this.field3415 = var1.readUnsignedShort();
         if(this.field3415 == '\uffff') {
            this.field3415 = -1;
         }

         this.field3429 = var1.readUnsignedShort();
         if(this.field3429 == '\uffff') {
            this.field3429 = -1;
         }

         int var3 = -1;
         if(var2 == 18) {
            var3 = var1.readUnsignedShort();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         int var4 = var1.readUnsignedByte();
         this.field3427 = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field3427[var5] = var1.readUnsignedShort();
            if(this.field3427[var5] == '\uffff') {
               this.field3427[var5] = -1;
            }
         }

         this.field3427[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Lclass254;",
      garbageValue = "-1964694067"
   )
   public final class254 method4487() {
      int var1 = -1;
      if(this.field3415 != -1) {
         var1 = FileOnDisk.method2363(this.field3415);
      } else if(this.field3429 != -1) {
         var1 = class211.widgetSettings[this.field3429];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field3427.length - 1) {
         var2 = this.field3427[var1];
      } else {
         var2 = this.field3427[this.field3427.length - 1];
      }

      return var2 != -1?class27.method203(var2):null;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-136404265"
   )
   public String method4488(int var1) {
      String var2 = this.field3424;

      while(true) {
         int var3 = var2.indexOf("%1");
         if(var3 < 0) {
            return var2;
         }

         var2 = var2.substring(0, var3) + RSCanvas.method774(var1, false) + var2.substring(var3 + 2);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)Z",
      garbageValue = "88"
   )
   public static boolean method4490(CharSequence var0) {
      return FloorUnderlayDefinition.method4368(var0, 10, true);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "1841525919"
   )
   public SpritePixels method4491() {
      if(this.field3418 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3410.get((long)this.field3418);
         if(var1 != null) {
            return var1;
         } else {
            var1 = GameEngine.method827(field3407, this.field3418, 0);
            if(var1 != null) {
               field3410.put(var1, (long)this.field3418);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-1764481852"
   )
   public SpritePixels method4492() {
      if(this.field3430 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3410.get((long)this.field3430);
         if(var1 != null) {
            return var1;
         } else {
            var1 = GameEngine.method827(field3407, this.field3430, 0);
            if(var1 != null) {
               field3410.put(var1, (long)this.field3430);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)LFont;",
      garbageValue = "1744690025"
   )
   public Font method4493() {
      if(this.field3414 == -1) {
         return null;
      } else {
         Font var1 = (Font)field3420.get((long)this.field3414);
         if(var1 != null) {
            return var1;
         } else {
            IndexDataBase var3 = field3407;
            IndexDataBase var4 = field3408;
            int var5 = this.field3414;
            Font var2;
            if(!class7.method28(var3, var5, 0)) {
               var2 = null;
            } else {
               var2 = method4524(var4.getConfigData(var5, 0));
            }

            if(var2 != null) {
               field3420.put(var2, (long)this.field3414);
            }

            return var2;
         }
      }
   }

   class254() {
      this.field3414 = -1;
      this.field3411 = 16777215;
      this.field3416 = 70;
      this.field3417 = -1;
      this.field3418 = -1;
      this.field3419 = -1;
      this.field3430 = -1;
      this.field3421 = 0;
      this.field3423 = 0;
      this.field3428 = -1;
      this.field3424 = "";
      this.field3425 = -1;
      this.field3426 = 0;
      this.field3415 = -1;
      this.field3429 = -1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-2114005508"
   )
   public SpritePixels method4509() {
      if(this.field3417 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3410.get((long)this.field3417);
         if(var1 != null) {
            return var1;
         } else {
            var1 = GameEngine.method827(field3407, this.field3417, 0);
            if(var1 != null) {
               field3410.put(var1, (long)this.field3417);
            }

            return var1;
         }
      }
   }

   static {
      field3409 = new NodeCache(64);
      field3410 = new NodeCache(64);
      field3420 = new NodeCache(20);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "1479059625"
   )
   public SpritePixels method4510() {
      if(this.field3419 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3410.get((long)this.field3419);
         if(var1 != null) {
            return var1;
         } else {
            var1 = GameEngine.method827(field3407, this.field3419, 0);
            if(var1 != null) {
               field3410.put(var1, (long)this.field3419);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BI)LFont;",
      garbageValue = "-1461338052"
   )
   public static Font method4524(byte[] var0) {
      if(var0 == null) {
         return null;
      } else {
         Font var1 = new Font(var0, class286.field3793, class266.field3657, class233.field3205, ScriptState.field779, class4.field33, IndexFile.field2307);
         class251.method4451();
         return var1;
      }
   }
}
