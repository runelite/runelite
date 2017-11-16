import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jb")
public class class261 extends CacheableNode {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   public static IndexDataBase field3460;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   public static IndexDataBase field3468;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   public static IndexDataBase field3462;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   public static NodeCache field3469;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   public static NodeCache field3464;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   public static NodeCache field3465;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 854613423
   )
   int field3480;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1336075769
   )
   public int field3463;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1004776183
   )
   public int field3470;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1847375029
   )
   int field3471;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -732742685
   )
   int field3473;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1065802427
   )
   int field3474;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -946059839
   )
   int field3472;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -2067951471
   )
   public int field3475;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1308573177
   )
   public int field3476;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 2085588597
   )
   public int field3477;
   @ObfuscatedName("l")
   String field3478;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -38100459
   )
   public int field3479;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 477299235
   )
   public int field3466;
   @ObfuscatedName("v")
   public int[] field3481;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 855334725
   )
   int field3482;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1130277911
   )
   int field3483;

   static {
      field3469 = new NodeCache(64);
      field3464 = new NodeCache(64);
      field3465 = new NodeCache(20);
   }

   class261() {
      this.field3480 = -1;
      this.field3463 = 16777215;
      this.field3470 = 70;
      this.field3471 = -1;
      this.field3473 = -1;
      this.field3474 = -1;
      this.field3472 = -1;
      this.field3475 = 0;
      this.field3476 = 0;
      this.field3477 = -1;
      this.field3478 = "";
      this.field3479 = -1;
      this.field3466 = 0;
      this.field3482 = -1;
      this.field3483 = -1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lfs;I)V",
      garbageValue = "2117700141"
   )
   void method4510(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4496(var1, var2);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lfs;IB)V",
      garbageValue = "44"
   )
   void method4496(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3480 = var1.method3201();
      } else if(var2 == 2) {
         this.field3463 = var1.read24BitInt();
      } else if(var2 == 3) {
         this.field3471 = var1.method3201();
      } else if(var2 == 4) {
         this.field3474 = var1.method3201();
      } else if(var2 == 5) {
         this.field3473 = var1.method3201();
      } else if(var2 == 6) {
         this.field3472 = var1.method3201();
      } else if(var2 == 7) {
         this.field3475 = var1.readShort();
      } else if(var2 == 8) {
         this.field3478 = var1.getJagString();
      } else if(var2 == 9) {
         this.field3470 = var1.readUnsignedShort();
      } else if(var2 == 10) {
         this.field3476 = var1.readShort();
      } else if(var2 == 11) {
         this.field3477 = 0;
      } else if(var2 == 12) {
         this.field3479 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3466 = var1.readShort();
      } else if(var2 == 14) {
         this.field3477 = var1.readUnsignedShort();
      } else if(var2 == 17 || var2 == 18) {
         this.field3482 = var1.readUnsignedShort();
         if(this.field3482 == 65535) {
            this.field3482 = -1;
         }

         this.field3483 = var1.readUnsignedShort();
         if(this.field3483 == 65535) {
            this.field3483 = -1;
         }

         int var3 = -1;
         if(var2 == 18) {
            var3 = var1.readUnsignedShort();
            if(var3 == 65535) {
               var3 = -1;
            }
         }

         int var4 = var1.readUnsignedByte();
         this.field3481 = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field3481[var5] = var1.readUnsignedShort();
            if(this.field3481[var5] == 65535) {
               this.field3481[var5] = -1;
            }
         }

         this.field3481[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)Ljb;",
      garbageValue = "15"
   )
   public final class261 method4475() {
      int var1 = -1;
      if(this.field3482 != -1) {
         var1 = class18.method131(this.field3482);
      } else if(this.field3483 != -1) {
         var1 = class218.widgetSettings[this.field3483];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field3481.length - 1) {
         var2 = this.field3481[var1];
      } else {
         var2 = this.field3481[this.field3481.length - 1];
      }

      return var2 != -1?GameEngine.method935(var2):null;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "-117"
   )
   public String method4499(int var1) {
      String var2 = this.field3478;

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

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(S)Lkb;",
      garbageValue = "-10112"
   )
   public SpritePixels method4477() {
      if(this.field3471 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3464.get((long)this.field3471);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class163.method3082(field3468, this.field3471, 0);
            if(var1 != null) {
               field3464.put(var1, (long)this.field3471);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Lkb;",
      garbageValue = "264517447"
   )
   public SpritePixels method4478() {
      if(this.field3473 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3464.get((long)this.field3473);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class163.method3082(field3468, this.field3473, 0);
            if(var1 != null) {
               field3464.put(var1, (long)this.field3473);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Lkb;",
      garbageValue = "-370463794"
   )
   public SpritePixels method4506() {
      if(this.field3474 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3464.get((long)this.field3474);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class163.method3082(field3468, this.field3474, 0);
            if(var1 != null) {
               field3464.put(var1, (long)this.field3474);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Lkb;",
      garbageValue = "-399080956"
   )
   public SpritePixels method4480() {
      if(this.field3472 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3464.get((long)this.field3472);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class163.method3082(field3468, this.field3472, 0);
            if(var1 != null) {
               field3464.put(var1, (long)this.field3472);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)Ljn;",
      garbageValue = "1"
   )
   public Font method4481() {
      if(this.field3480 == -1) {
         return null;
      } else {
         Font var1 = (Font)field3465.get((long)this.field3480);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class287.method4954(field3468, field3462, this.field3480, 0);
            if(var1 != null) {
               field3465.put(var1, (long)this.field3480);
            }

            return var1;
         }
      }
   }
}
