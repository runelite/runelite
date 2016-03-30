import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
@Implements("Sequence")
public class class42 extends class204 {
   @ObfuscatedName("qq")
   public static class77 field991;
   @ObfuscatedName("x")
   static class167 field992;
   @ObfuscatedName("p")
   public static class193 field993 = new class193(64);
   @ObfuscatedName("e")
   public static class193 field994 = new class193(100);
   @ObfuscatedName("y")
   public int[] field995;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -394682033
   )
   public int field996 = -1;
   @ObfuscatedName("c")
   public int[] field997;
   @ObfuscatedName("v")
   public int[] field998;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -143674379
   )
   public int field999 = -1;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1926273803
   )
   public int field1000 = -1;
   @ObfuscatedName("s")
   @Export("stretches")
   public boolean field1001 = false;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1228156875
   )
   public int field1002 = 5;
   @ObfuscatedName("z")
   @Export("interleaveLeave")
   int[] field1003;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -816315795
   )
   public int field1004 = -1;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 620156003
   )
   @Export("maxLoops")
   public int field1005 = 99;
   @ObfuscatedName("m")
   int[] field1006;
   @ObfuscatedName("w")
   static class167 field1007;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1355962539
   )
   @Export("replyMode")
   public int field1008 = 2;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 184428715
   )
   @Export("precedenceAnimating")
   public int field1011 = -1;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "1881786092"
   )
   void method900(class119 var1, int var2) {
      int var3;
      int var4;
      if(1 == var2) {
         var3 = var1.method2508();
         this.field997 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field997[var4] = var1.method2508();
         }

         this.field995 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field995[var4] = var1.method2508();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field995[var4] += var1.method2508() << 16;
         }
      } else if(2 == var2) {
         this.field999 = var1.method2508();
      } else if(3 == var2) {
         var3 = var1.method2506();
         this.field1003 = new int[1 + var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1003[var4] = var1.method2506();
         }

         this.field1003[var3] = 9999999;
      } else if(4 == var2) {
         this.field1001 = true;
      } else if(5 == var2) {
         this.field1002 = var1.method2506();
      } else if(6 == var2) {
         this.field996 = var1.method2508();
      } else if(7 == var2) {
         this.field1000 = var1.method2508();
      } else if(var2 == 8) {
         this.field1005 = var1.method2506();
      } else if(9 == var2) {
         this.field1011 = var1.method2506();
      } else if(var2 == 10) {
         this.field1004 = var1.method2506();
      } else if(var2 == 11) {
         this.field1008 = var1.method2506();
      } else if(12 == var2) {
         var3 = var1.method2506();
         this.field1006 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1006[var4] = var1.method2508();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1006[var4] += var1.method2508() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.method2506();
         this.field998 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field998[var4] = var1.method2510();
         }
      }

   }

   @ObfuscatedName("e")
   void method901() {
      if(this.field1011 == -1) {
         if(this.field1003 != null) {
            this.field1011 = 2;
         } else {
            this.field1011 = 0;
         }
      }

      if(this.field1004 == -1) {
         if(this.field1003 != null) {
            this.field1004 = 2;
         } else {
            this.field1004 = 0;
         }
      }

   }

   @ObfuscatedName("y")
   public class105 method902(class105 var1, int var2) {
      var2 = this.field995[var2];
      class103 var3 = class17.method188(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method2311(true);
      } else {
         class105 var4 = var1.method2311(!var3.method2285(var2));
         var4.method2372(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("c")
   class105 method904(class105 var1, int var2) {
      var2 = this.field995[var2];
      class103 var3 = class17.method188(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method2302(true);
      } else {
         class105 var4 = var1.method2302(!var3.method2285(var2));
         var4.method2372(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("l")
   public class105 method906(class105 var1, int var2) {
      int var3 = this.field995[var2];
      class103 var4 = class17.method188(var3 >> 16);
      var3 &= '\uffff';
      if(null == var4) {
         return var1.method2311(true);
      } else {
         class103 var5 = null;
         int var6 = 0;
         if(null != this.field1006 && var2 < this.field1006.length) {
            var6 = this.field1006[var2];
            var5 = class17.method188(var6 >> 16);
            var6 &= '\uffff';
         }

         class105 var7;
         if(var5 != null && '\uffff' != var6) {
            var7 = var1.method2311(!var4.method2285(var3) & !var5.method2285(var6));
            var7.method2372(var4, var3);
            var7.method2372(var5, var6);
            return var7;
         } else {
            var7 = var1.method2311(!var4.method2285(var3));
            var7.method2372(var4, var3);
            return var7;
         }
      }
   }

   @ObfuscatedName("v")
   public class105 method909(class105 var1, int var2, class42 var3, int var4) {
      var2 = this.field995[var2];
      class103 var5 = class17.method188(var2 >> 16);
      var2 &= '\uffff';
      if(null == var5) {
         return var3.method902(var1, var4);
      } else {
         var4 = var3.field995[var4];
         class103 var6 = class17.method188(var4 >> 16);
         var4 &= '\uffff';
         class105 var7;
         if(var6 == null) {
            var7 = var1.method2311(!var5.method2285(var2));
            var7.method2372(var5, var2);
            return var7;
         } else {
            var7 = var1.method2311(!var5.method2285(var2) & !var6.method2285(var4));
            var7.method2308(var5, var2, var6, var4, this.field1003);
            return var7;
         }
      }
   }

   @ObfuscatedName("x")
   static char method914(char var0) {
      if(var0 >= 192 && var0 <= 255) {
         if(var0 >= 192 && var0 <= 198) {
            return 'A';
         }

         if(var0 == 199) {
            return 'C';
         }

         if(var0 >= 200 && var0 <= 203) {
            return 'E';
         }

         if(var0 >= 204 && var0 <= 207) {
            return 'I';
         }

         if(var0 >= 210 && var0 <= 214) {
            return 'O';
         }

         if(var0 >= 217 && var0 <= 220) {
            return 'U';
         }

         if(221 == var0) {
            return 'Y';
         }

         if(var0 == 223) {
            return 's';
         }

         if(var0 >= 224 && var0 <= 230) {
            return 'a';
         }

         if(231 == var0) {
            return 'c';
         }

         if(var0 >= 232 && var0 <= 235) {
            return 'e';
         }

         if(var0 >= 236 && var0 <= 239) {
            return 'i';
         }

         if(var0 >= 242 && var0 <= 246) {
            return 'o';
         }

         if(var0 >= 249 && var0 <= 252) {
            return 'u';
         }

         if(var0 == 253 || var0 == 255) {
            return 'y';
         }
      }

      if(var0 == 338) {
         return 'O';
      } else if(var0 == 339) {
         return 'o';
      } else if(376 == var0) {
         return 'Y';
      } else {
         return var0;
      }
   }

   @ObfuscatedName("t")
   void method917(class119 var1) {
      while(true) {
         int var2 = var1.method2506();
         if(0 == var2) {
            return;
         }

         this.method900(var1, var2);
      }
   }

   @ObfuscatedName("m")
   class105 method919(class105 var1, int var2, int var3) {
      var2 = this.field995[var2];
      class103 var4 = class17.method188(var2 >> 16);
      var2 &= '\uffff';
      if(null == var4) {
         return var1.method2311(true);
      } else {
         class105 var5 = var1.method2311(!var4.method2285(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method2304();
         } else if(2 == var3) {
            var5.method2307();
         } else if(var3 == 3) {
            var5.method2310();
         }

         var5.method2372(var4, var2);
         if(var3 == 1) {
            var5.method2310();
         } else if(2 == var3) {
            var5.method2307();
         } else if(var3 == 3) {
            var5.method2304();
         }

         return var5;
      }
   }
}
