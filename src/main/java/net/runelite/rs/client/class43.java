package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ag")
public class class43 extends class203 {
   @ObfuscatedName("j")
   public static class166 field991;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1055882027
   )
   int field992 = 0;
   @ObfuscatedName("f")
   public static class192 field993 = new class192(64);
   @ObfuscatedName("l")
   public static class192 field994 = new class192(30);
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -178620239
   )
   int field995;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1399508815
   )
   int field996;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 152704939
   )
   int field997 = 128;
   @ObfuscatedName("i")
   short[] field998;
   @ObfuscatedName("t")
   short[] field999;
   @ObfuscatedName("m")
   public static class166 field1000;
   @ObfuscatedName("s")
   short[] field1001;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -422593603
   )
   int field1002 = 128;
   @ObfuscatedName("k")
   short[] field1003;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1834130107
   )
   int field1004 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -944987493
   )
   public int field1005 = -1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 613210019
   )
   int field1006 = 0;

   @ObfuscatedName("i")
   public static int method944(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + class154.method3204(var0.charAt(var3));
      }

      return var2;
   }

   @ObfuscatedName("m")
   void method947(class118 var1) {
      while(true) {
         int var2 = var1.method2536();
         if(var2 == 0) {
            return;
         }

         this.method953(var1, var2);
      }
   }

   @ObfuscatedName("l")
   public final class104 method948(int var1) {
      class104 var2 = (class104)field994.method3808((long)this.field995);
      if(var2 == null) {
         class99 var3 = class99.method2218(field1000, this.field996, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(this.field998 != null) {
            for(var4 = 0; var4 < this.field998.length; ++var4) {
               var3.method2298(this.field998[var4], this.field999[var4]);
            }
         }

         if(this.field1003 != null) {
            for(var4 = 0; var4 < this.field1003.length; ++var4) {
               var3.method2233(this.field1003[var4], this.field1001[var4]);
            }
         }

         var2 = var3.method2247(this.field992 + 64, 850 + this.field1006, -30, -50, -30);
         field994.method3805(var2, (long)this.field995);
      }

      class104 var5;
      if(-1 != this.field1005 && -1 != var1) {
         var5 = client.method584(this.field1005).method932(var2, var1);
      } else {
         var5 = var2.method2380(true);
      }

      if(this.field1002 != 128 || this.field997 != 128) {
         var5.method2355(this.field1002, this.field997, this.field1002);
      }

      if(this.field1004 != 0) {
         if(this.field1004 == 90) {
            var5.method2340();
         }

         if(this.field1004 == 180) {
            var5.method2340();
            var5.method2340();
         }

         if(this.field1004 == 270) {
            var5.method2340();
            var5.method2340();
            var5.method2340();
         }
      }

      return var5;
   }

   @ObfuscatedName("f")
   void method953(class118 var1, int var2) {
      if(1 == var2) {
         this.field996 = var1.method2538();
      } else if(var2 == 2) {
         this.field1005 = var1.method2538();
      } else if(var2 == 4) {
         this.field1002 = var1.method2538();
      } else if(5 == var2) {
         this.field997 = var1.method2538();
      } else if(6 == var2) {
         this.field1004 = var1.method2538();
      } else if(var2 == 7) {
         this.field992 = var1.method2536();
      } else if(8 == var2) {
         this.field1006 = var1.method2536();
      } else {
         int var3;
         int var4;
         if(40 == var2) {
            var3 = var1.method2536();
            this.field998 = new short[var3];
            this.field999 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field998[var4] = (short)var1.method2538();
               this.field999[var4] = (short)var1.method2538();
            }
         } else if(var2 == 41) {
            var3 = var1.method2536();
            this.field1003 = new short[var3];
            this.field1001 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1003[var4] = (short)var1.method2538();
               this.field1001[var4] = (short)var1.method2538();
            }
         }
      }

   }

   @ObfuscatedName("m")
   static int method955() {
      return 9;
   }

   @ObfuscatedName("cs")
   static final void method956(int var0) {
      if(class167.method3400(var0)) {
         class172[] var1 = class172.field2857[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            class172 var3 = var1[var2];
            if(var3 != null) {
               var3.field2854 = 0;
               var3.field2773 = 0;
            }
         }

      }
   }

   @ObfuscatedName("t")
   public static Object method958(byte[] var0) {
      if(var0 == null) {
         return null;
      } else {
         if(var0.length > 136 && !class124.field2023) {
            try {
               class117 var1 = new class117();
               var1.vmethod2820(var0);
               return var1;
            } catch (Throwable var2) {
               class124.field2023 = true;
            }
         }

         return var0;
      }
   }
}
