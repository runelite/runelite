import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ip")
public class class254 extends CacheableNode {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   public static NodeCache field3393;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   public static NodeCache field3392;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   public static NodeCache field3391;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   static IndexDataBase field3410;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   static IndexDataBase field3389;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   static IndexDataBase field3390;
   @ObfuscatedName("fi")
   @ObfuscatedSignature(
      signature = "[Lji;"
   )
   @Export("hitmarks")
   static SpritePixels[] hitmarks;
   @ObfuscatedName("m")
   String field3405;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1032704559
   )
   int field3409;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 909110589
   )
   int field3398;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1308090427
   )
   int field3395;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1796937769
   )
   int field3399;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -173082297
   )
   int field3406;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1226138315
   )
   int field3400;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -837032211
   )
   int field3397;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -981851891
   )
   public int field3411;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1026191549
   )
   public int field3396;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1310402811
   )
   public int field3413;
   @ObfuscatedName("z")
   public int[] field3408;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -107107561
   )
   public int field3402;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1932480223
   )
   public int field3404;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 171531053
   )
   public int field3401;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -2039615113
   )
   public int field3407;

   static {
      field3392 = new NodeCache(64);
      field3391 = new NodeCache(64);
      field3393 = new NodeCache(20);
   }

   class254() {
      this.field3395 = -1;
      this.field3396 = 16777215;
      this.field3413 = 70;
      this.field3398 = -1;
      this.field3399 = -1;
      this.field3400 = -1;
      this.field3406 = -1;
      this.field3402 = 0;
      this.field3401 = 0;
      this.field3404 = -1;
      this.field3405 = "";
      this.field3411 = -1;
      this.field3407 = 0;
      this.field3409 = -1;
      this.field3397 = -1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lfw;II)V",
      garbageValue = "1236988654"
   )
   void method4490(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3395 = var1.method3216();
      } else if(var2 == 2) {
         this.field3396 = var1.read24BitInt();
      } else if(var2 == 3) {
         this.field3398 = var1.method3216();
      } else if(var2 == 4) {
         this.field3400 = var1.method3216();
      } else if(var2 == 5) {
         this.field3399 = var1.method3216();
      } else if(var2 == 6) {
         this.field3406 = var1.method3216();
      } else if(var2 == 7) {
         this.field3402 = var1.readShort();
      } else if(var2 == 8) {
         this.field3405 = var1.getJagString();
      } else if(var2 == 9) {
         this.field3413 = var1.readUnsignedShort();
      } else if(var2 == 10) {
         this.field3401 = var1.readShort();
      } else if(var2 == 11) {
         this.field3404 = 0;
      } else if(var2 == 12) {
         this.field3411 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3407 = var1.readShort();
      } else if(var2 == 14) {
         this.field3404 = var1.readUnsignedShort();
      } else if(var2 == 17 || var2 == 18) {
         this.field3409 = var1.readUnsignedShort();
         if(this.field3409 == '\uffff') {
            this.field3409 = -1;
         }

         this.field3397 = var1.readUnsignedShort();
         if(this.field3397 == '\uffff') {
            this.field3397 = -1;
         }

         int var3 = -1;
         if(var2 == 18) {
            var3 = var1.readUnsignedShort();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         int var4 = var1.readUnsignedByte();
         this.field3408 = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field3408[var5] = var1.readUnsignedShort();
            if(this.field3408[var5] == '\uffff') {
               this.field3408[var5] = -1;
            }
         }

         this.field3408[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lfw;B)V",
      garbageValue = "4"
   )
   void method4473(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4490(var1, var2);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Lip;",
      garbageValue = "-942582498"
   )
   public final class254 method4460() {
      int var1 = -1;
      if(this.field3409 != -1) {
         var1 = class90.method1720(this.field3409);
      } else if(this.field3397 != -1) {
         var1 = class211.widgetSettings[this.field3397];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field3408.length - 1) {
         var2 = this.field3408[var1];
      } else {
         var2 = this.field3408[this.field3408.length - 1];
      }

      return var2 != -1?FileSystem.method4110(var2):null;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(S)Lji;",
      garbageValue = "-8885"
   )
   public SpritePixels method4462() {
      if(this.field3398 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3391.get((long)this.field3398);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class13.method72(field3389, this.field3398, 0);
            if(var1 != null) {
               field3391.put(var1, (long)this.field3398);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Lji;",
      garbageValue = "1063157064"
   )
   public SpritePixels method4488() {
      if(this.field3399 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3391.get((long)this.field3399);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class13.method72(field3389, this.field3399, 0);
            if(var1 != null) {
               field3391.put(var1, (long)this.field3399);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)Lji;",
      garbageValue = "0"
   )
   public SpritePixels method4470() {
      if(this.field3400 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3391.get((long)this.field3400);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class13.method72(field3389, this.field3400, 0);
            if(var1 != null) {
               field3391.put(var1, (long)this.field3400);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)Lji;",
      garbageValue = "24"
   )
   public SpritePixels method4465() {
      if(this.field3406 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3391.get((long)this.field3406);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class13.method72(field3389, this.field3406, 0);
            if(var1 != null) {
               field3391.put(var1, (long)this.field3406);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)Ljt;",
      garbageValue = "60"
   )
   public Font method4459() {
      if(this.field3395 == -1) {
         return null;
      } else {
         Font var1 = (Font)field3393.get((long)this.field3395);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class87.method1713(field3389, field3390, this.field3395, 0);
            if(var1 != null) {
               field3393.put(var1, (long)this.field3395);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "14"
   )
   public String method4475(int var1) {
      String var2 = this.field3405;

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
}
