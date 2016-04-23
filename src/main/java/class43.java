import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
public class class43 extends class204 {
   @ObfuscatedName("m")
   static class193 field989 = new class193(64);
   @ObfuscatedName("z")
   static class193 field990 = new class193(30);
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1780990643
   )
   int field991 = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1891545163
   )
   public int field993 = -1;
   @ObfuscatedName("c")
   short[] field994;
   @ObfuscatedName("n")
   short[] field995;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1014108777
   )
   int field996 = 0;
   @ObfuscatedName("u")
   short[] field997;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1419923613
   )
   int field998 = 128;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1724868175
   )
   int field999;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 8038707
   )
   int field1000 = 0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -984876817
   )
   int field1001;
   @ObfuscatedName("l")
   short[] field1002;
   @ObfuscatedName("h")
   public static class167 field1004;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -434764579
   )
   int field1006 = 128;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "-1163204958"
   )
   void method886(class119 var1) {
      while(true) {
         int var2 = var1.method2500();
         if(0 == var2) {
            return;
         }

         this.method887(var1, var2);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "1693569940"
   )
   void method887(class119 var1, int var2) {
      if(var2 == 1) {
         this.field1001 = var1.method2502();
      } else if(2 == var2) {
         this.field993 = var1.method2502();
      } else if(var2 == 4) {
         this.field998 = var1.method2502();
      } else if(var2 == 5) {
         this.field1006 = var1.method2502();
      } else if(var2 == 6) {
         this.field1000 = var1.method2502();
      } else if(var2 == 7) {
         this.field991 = var1.method2500();
      } else if(var2 == 8) {
         this.field996 = var1.method2500();
      } else {
         int var3;
         int var4;
         if(40 == var2) {
            var3 = var1.method2500();
            this.field994 = new short[var3];
            this.field995 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field994[var4] = (short)var1.method2502();
               this.field995[var4] = (short)var1.method2502();
            }
         } else if(var2 == 41) {
            var3 = var1.method2500();
            this.field1002 = new short[var3];
            this.field997 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1002[var4] = (short)var1.method2502();
               this.field997[var4] = (short)var1.method2502();
            }
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)Lclass105;",
      garbageValue = "575028476"
   )
   public final class105 method888(int var1) {
      class105 var2 = (class105)field990.method3704((long)this.field999);
      if(var2 == null) {
         class100 var3 = class100.method2198(field1004, this.field1001, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(null != this.field994) {
            for(var4 = 0; var4 < this.field994.length; ++var4) {
               var3.method2202(this.field994[var4], this.field995[var4]);
            }
         }

         if(this.field1002 != null) {
            for(var4 = 0; var4 < this.field1002.length; ++var4) {
               var3.method2214(this.field1002[var4], this.field997[var4]);
            }
         }

         var2 = var3.method2218(this.field991 + 64, 850 + this.field996, -30, -50, -30);
         field990.method3706(var2, (long)this.field999);
      }

      class105 var5;
      if(-1 != this.field993 && -1 != var1) {
         var5 = class161.method3153(this.field993).method853(var2, var1);
      } else {
         var5 = var2.method2287(true);
      }

      if(this.field998 != 128 || 128 != this.field1006) {
         var5.method2324(this.field998, this.field1006, this.field998);
      }

      if(this.field1000 != 0) {
         if(90 == this.field1000) {
            var5.method2293();
         }

         if(180 == this.field1000) {
            var5.method2293();
            var5.method2293();
         }

         if(this.field1000 == 270) {
            var5.method2293();
            var5.method2293();
            var5.method2293();
         }
      }

      return var5;
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "74"
   )
   static final void method889(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < client.field476; ++var4) {
         if(client.field483[var4] + client.field321[var4] > var0 && client.field321[var4] < var0 + var2 && client.field315[var4] + client.field551[var4] > var1 && client.field315[var4] < var3 + var1) {
            client.field478[var4] = true;
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ILclass134;Lclass168;I)V",
      garbageValue = "1584546372"
   )
   static void method900(int var0, class134 var1, class168 var2) {
      byte[] var3 = null;
      class199 var4 = class170.field2702;
      synchronized(class170.field2702) {
         for(class169 var5 = (class169)class170.field2702.method3784(); null != var5; var5 = (class169)class170.field2702.method3777()) {
            if(var5.field3122 == (long)var0 && var5.field2699 == var1 && var5.field2694 == 0) {
               var3 = var5.field2693;
               break;
            }
         }
      }

      if(var3 != null) {
         var2.method3301(var1, var0, var3, true);
      } else {
         byte[] var8 = var1.method2831(var0);
         var2.method3301(var1, var0, var8, true);
      }
   }
}
