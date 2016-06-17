import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
public class class43 extends class204 {
   @ObfuscatedName("j")
   public static class193 field984 = new class193(64);
   @ObfuscatedName("g")
   public static class167 field985;
   @ObfuscatedName("cx")
   static class224 field986;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 502620767
   )
   int field988;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 188053655
   )
   int field989;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -934981433
   )
   public int field990 = -1;
   @ObfuscatedName("c")
   short[] field991;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 942922421
   )
   int field992 = 0;
   @ObfuscatedName("d")
   public static class193 field993 = new class193(30);
   @ObfuscatedName("l")
   short[] field994;
   @ObfuscatedName("bh")
   static class168 field995;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 964764391
   )
   int field996 = 128;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1620654561
   )
   int field997 = 0;
   @ObfuscatedName("p")
   short[] field998;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -2055075383
   )
   int field999 = 0;
   @ObfuscatedName("u")
   short[] field1000;
   @ObfuscatedName("b")
   public static class167 field1001;
   @ObfuscatedName("bm")
   @Export("host")
   static String field1002;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1781968395
   )
   int field1004 = 128;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "-644248148"
   )
   void method907(class119 var1, int var2) {
      if(var2 == 1) {
         this.field989 = var1.method2516();
      } else if(var2 == 2) {
         this.field990 = var1.method2516();
      } else if(var2 == 4) {
         this.field1004 = var1.method2516();
      } else if(var2 == 5) {
         this.field996 = var1.method2516();
      } else if(var2 == 6) {
         this.field997 = var1.method2516();
      } else if(var2 == 7) {
         this.field992 = var1.method2514();
      } else if(var2 == 8) {
         this.field999 = var1.method2514();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.method2514();
            this.field991 = new short[var3];
            this.field994 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field991[var4] = (short)var1.method2516();
               this.field994[var4] = (short)var1.method2516();
            }
         } else if(var2 == 41) {
            var3 = var1.method2514();
            this.field1000 = new short[var3];
            this.field998 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1000[var4] = (short)var1.method2516();
               this.field998[var4] = (short)var1.method2516();
            }
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)Lclass105;",
      garbageValue = "-16"
   )
   public final class105 method908(int var1) {
      class105 var2 = (class105)field993.method3764((long)this.field988);
      if(null == var2) {
         class100 var3 = class100.method2208(field985, this.field989, 0);
         if(null == var3) {
            return null;
         }

         int var4;
         if(null != this.field991) {
            for(var4 = 0; var4 < this.field991.length; ++var4) {
               var3.method2221(this.field991[var4], this.field994[var4]);
            }
         }

         if(null != this.field1000) {
            for(var4 = 0; var4 < this.field1000.length; ++var4) {
               var3.method2222(this.field1000[var4], this.field998[var4]);
            }
         }

         var2 = var3.method2229(64 + this.field992, this.field999 + 850, -30, -50, -30);
         field993.method3759(var2, (long)this.field988);
      }

      class105 var5;
      if(this.field990 != -1 && var1 != -1) {
         var5 = class17.method178(this.field990).method871(var2, var1);
      } else {
         var5 = var2.method2297(true);
      }

      if(this.field1004 != 128 || this.field996 != 128) {
         var5.method2310(this.field1004, this.field996, this.field1004);
      }

      if(this.field997 != 0) {
         if(this.field997 == 90) {
            var5.method2305();
         }

         if(this.field997 == 180) {
            var5.method2305();
            var5.method2305();
         }

         if(this.field997 == 270) {
            var5.method2305();
            var5.method2305();
            var5.method2305();
         }
      }

      return var5;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "1510901954"
   )
   void method911(class119 var1) {
      while(true) {
         int var2 = var1.method2514();
         if(var2 == 0) {
            return;
         }

         this.method907(var1, var2);
      }
   }

   @ObfuscatedName("g")
   static final void method918(long var0) {
      try {
         Thread.sleep(var0);
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1167772655"
   )
   @Export("setGameState")
   static void method919(int var0) {
      if(client.field294 != var0) {
         if(client.field294 == 0) {
            class106.field1854 = null;
            class56.field1168 = null;
            class123.field2018 = null;
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            client.field482 = 0;
            client.field345 = 0;
            client.field566 = 0;
         }

         if(var0 != 20 && var0 != 40 && class89.field1530 != null) {
            class89.field1530.method3025();
            class89.field1530 = null;
         }

         if(client.field294 == 25) {
            client.field348 = 0;
            client.field554 = 0;
            client.field380 = 1;
            client.field346 = 0;
            client.field287 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               class26.method636(class46.field1040, class12.field186, class129.field2038, true, client.field294 == 11?4:0);
            } else if(var0 == 11) {
               class26.method636(class46.field1040, class12.field186, class129.field2038, false, 4);
            } else if(class31.field701) {
               class31.field708 = null;
               class31.field714 = null;
               class31.field720 = null;
               class31.field699 = null;
               class31.field730 = null;
               class31.field696 = null;
               class90.field1539 = null;
               class38.field855 = null;
               class209.field3117 = null;
               class123.field2015 = null;
               class166.field2659 = null;
               class87.field1502 = null;
               class82.field1405 = null;
               class23.field614 = null;
               class11.field165 = null;
               class31.field706 = null;
               class164.field2650 = null;
               class12.field184 = null;
               class28.field673 = null;
               class82.field1406 = null;
               class36.field788 = null;
               class98.field1633 = null;
               class183.field2953 = 1;
               class50.field1075 = null;
               class177.field2903 = -1;
               class183.field2951 = -1;
               class181.field2929 = 0;
               class183.field2956 = false;
               class183.field2955 = 2;
               class98.method2200(true);
               class31.field701 = false;
            }
         } else {
            class26.method636(class46.field1040, class12.field186, class129.field2038, true, 0);
         }

         client.field294 = var0;
      }
   }
}
