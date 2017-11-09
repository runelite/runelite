import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jb")
public class class261 extends CacheableNode {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   static IndexDataBase field3479;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   static IndexDataBase field3462;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   static IndexDataBase field3463;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   public static NodeCache field3482;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   public static NodeCache field3465;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   public static NodeCache field3485;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1253814217
   )
   int field3473;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1902835325
   )
   public int field3471;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -586726787
   )
   public int field3472;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1074761001
   )
   int field3484;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1575137577
   )
   int field3474;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1768206139
   )
   int field3475;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -299630363
   )
   int field3461;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1157821135
   )
   public int field3477;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 446485591
   )
   public int field3478;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1487642107
   )
   public int field3464;
   @ObfuscatedName("o")
   String field3480;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 940255759
   )
   public int field3481;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1713222583
   )
   public int field3470;
   @ObfuscatedName("f")
   public int[] field3483;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1670749233
   )
   int field3476;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1074029963
   )
   int field3468;

   static {
      field3482 = new NodeCache(64);
      field3465 = new NodeCache(64);
      field3485 = new NodeCache(20);
   }

   class261() {
      this.field3473 = -1;
      this.field3471 = 16777215;
      this.field3472 = 70;
      this.field3484 = -1;
      this.field3474 = -1;
      this.field3475 = -1;
      this.field3461 = -1;
      this.field3477 = 0;
      this.field3478 = 0;
      this.field3464 = -1;
      this.field3480 = "";
      this.field3481 = -1;
      this.field3470 = 0;
      this.field3476 = -1;
      this.field3468 = -1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lfv;I)V",
      garbageValue = "1067676758"
   )
   void method4654(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4666(var1, var2);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lfv;II)V",
      garbageValue = "1061227"
   )
   void method4666(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3473 = var1.method3301();
      } else if(var2 == 2) {
         this.field3471 = var1.read24BitInt();
      } else if(var2 == 3) {
         this.field3484 = var1.method3301();
      } else if(var2 == 4) {
         this.field3475 = var1.method3301();
      } else if(var2 == 5) {
         this.field3474 = var1.method3301();
      } else if(var2 == 6) {
         this.field3461 = var1.method3301();
      } else if(var2 == 7) {
         this.field3477 = var1.readShort();
      } else if(var2 == 8) {
         this.field3480 = var1.getJagString();
      } else if(var2 == 9) {
         this.field3472 = var1.readUnsignedShort();
      } else if(var2 == 10) {
         this.field3478 = var1.readShort();
      } else if(var2 == 11) {
         this.field3464 = 0;
      } else if(var2 == 12) {
         this.field3481 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3470 = var1.readShort();
      } else if(var2 == 14) {
         this.field3464 = var1.readUnsignedShort();
      } else if(var2 == 17 || var2 == 18) {
         this.field3476 = var1.readUnsignedShort();
         if(this.field3476 == 65535) {
            this.field3476 = -1;
         }

         this.field3468 = var1.readUnsignedShort();
         if(this.field3468 == 65535) {
            this.field3468 = -1;
         }

         int var3 = -1;
         if(var2 == 18) {
            var3 = var1.readUnsignedShort();
            if(var3 == 65535) {
               var3 = -1;
            }
         }

         int var4 = var1.readUnsignedByte();
         this.field3483 = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field3483[var5] = var1.readUnsignedShort();
            if(this.field3483[var5] == 65535) {
               this.field3483[var5] = -1;
            }
         }

         this.field3483[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)Ljb;",
      garbageValue = "123"
   )
   public final class261 method4656() {
      int var1 = -1;
      if(this.field3476 != -1) {
         var1 = Item.method1849(this.field3476);
      } else if(this.field3468 != -1) {
         var1 = class218.widgetSettings[this.field3468];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field3483.length - 1) {
         var2 = this.field3483[var1];
      } else {
         var2 = this.field3483[this.field3483.length - 1];
      }

      return var2 != -1?class10.method55(var2):null;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-868475904"
   )
   public String method4684(int var1) {
      String var2 = this.field3480;

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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Lkd;",
      garbageValue = "903189846"
   )
   public SpritePixels method4658() {
      if(this.field3484 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3465.get((long)this.field3484);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class21.method176(field3462, this.field3484, 0);
            if(var1 != null) {
               field3465.put(var1, (long)this.field3484);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Lkd;",
      garbageValue = "1880144469"
   )
   public SpritePixels method4659() {
      if(this.field3474 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3465.get((long)this.field3474);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class21.method176(field3462, this.field3474, 0);
            if(var1 != null) {
               field3465.put(var1, (long)this.field3474);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)Lkd;",
      garbageValue = "16"
   )
   public SpritePixels method4690() {
      if(this.field3475 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3465.get((long)this.field3475);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class21.method176(field3462, this.field3475, 0);
            if(var1 != null) {
               field3465.put(var1, (long)this.field3475);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Lkd;",
      garbageValue = "-2147264616"
   )
   public SpritePixels method4661() {
      if(this.field3461 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3465.get((long)this.field3461);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class21.method176(field3462, this.field3461, 0);
            if(var1 != null) {
               field3465.put(var1, (long)this.field3461);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Ljt;",
      garbageValue = "-800121669"
   )
   public Font method4662() {
      if(this.field3473 == -1) {
         return null;
      } else {
         Font var1 = (Font)field3485.get((long)this.field3473);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class232.method4242(field3462, field3463, this.field3473, 0);
            if(var1 != null) {
               field3485.put(var1, (long)this.field3473);
            }

            return var1;
         }
      }
   }
}
