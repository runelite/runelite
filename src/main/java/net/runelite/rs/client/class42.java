package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ak")
public class class42 extends class203 {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1032111723
   )
   public int field969 = 2;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2040431827
   )
   public int field970 = 5;
   @ObfuscatedName("t")
   public int[] field971;
   @ObfuscatedName("u")
   static class192 field972 = new class192(100);
   @ObfuscatedName("a")
   public int[] field973;
   @ObfuscatedName("f")
   static class166 field974;
   @ObfuscatedName("i")
   public int[] field975;
   @ObfuscatedName("h")
   int[] field976;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 533397951
   )
   public int field977 = 1;
   @ObfuscatedName("s")
   int[] field978;
   @ObfuscatedName("w")
   public boolean field979 = false;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1404598901
   )
   public int field980 = -1;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 306825789
   )
   public int field981 = -1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1584871849
   )
   public int field982 = -1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1200371909
   )
   public int field983 = 99;
   @ObfuscatedName("rs")
   protected static String field984;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -166871313
   )
   public int field985 = -1;
   @ObfuscatedName("l")
   static class192 field986 = new class192(64);
   @ObfuscatedName("qe")
   @ObfuscatedGetter(
      intValue = -1883441889
   )
   static int field988;
   @ObfuscatedName("j")
   static class166 field989;
   @ObfuscatedName("m")
   public static class166 field990;

   @ObfuscatedName("a")
   public class104 method905(class104 var1, int var2) {
      var2 = this.field973[var2];
      class102 var3 = class30.method712(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method2366(true);
      } else {
         class104 var4 = var1.method2366(!var3.method2312(var2));
         var4.method2337(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("f")
   void method906(class118 var1) {
      while(true) {
         int var2 = var1.method2536();
         if(0 == var2) {
            return;
         }

         this.method907(var1, var2);
      }
   }

   @ObfuscatedName("l")
   void method907(class118 var1, int var2) {
      int var3;
      int var4;
      if(1 == var2) {
         var3 = var1.method2538();
         this.field975 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field975[var4] = var1.method2538();
         }

         this.field973 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field973[var4] = var1.method2538();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field973[var4] += var1.method2538() << 16;
         }
      } else if(var2 == 2) {
         this.field977 = var1.method2538() * -1;
      } else if(var2 == 3) {
         var3 = var1.method2536();
         this.field978 = new int[1 + var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field978[var4] = var1.method2536();
         }

         this.field978[var3] = 9999999;
      } else if(4 == var2) {
         this.field979 = true;
      } else if(var2 == 5) {
         this.field970 = var1.method2536();
      } else if(6 == var2) {
         this.field981 = var1.method2538();
      } else if(var2 == 7) {
         this.field982 = var1.method2538();
      } else if(8 == var2) {
         this.field983 = var1.method2536();
      } else if(var2 == 9) {
         this.field980 = var1.method2536();
      } else if(var2 == 10) {
         this.field985 = var1.method2536();
      } else if(var2 == 11) {
         this.field969 = var1.method2536();
      } else if(var2 == 12) {
         var3 = var1.method2536();
         this.field976 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field976[var4] = var1.method2538();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field976[var4] += var1.method2538() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.method2536();
         this.field971 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field971[var4] = var1.method2540();
         }
      }

   }

   @ObfuscatedName("k")
   public class104 method913(class104 var1, int var2) {
      int var3 = this.field973[var2];
      class102 var4 = class30.method712(var3 >> 16);
      var3 &= '\uffff';
      if(var4 == null) {
         return var1.method2366(true);
      } else {
         class102 var5 = null;
         int var6 = 0;
         if(this.field976 != null && var2 < this.field976.length) {
            var6 = this.field976[var2];
            var5 = class30.method712(var6 >> 16);
            var6 &= '\uffff';
         }

         class104 var7;
         if(null != var5 && var6 != '\uffff') {
            var7 = var1.method2366(!var4.method2312(var3) & !var5.method2312(var6));
            var7.method2337(var4, var3);
            var7.method2337(var5, var6);
            return var7;
         } else {
            var7 = var1.method2366(!var4.method2312(var3));
            var7.method2337(var4, var3);
            return var7;
         }
      }
   }

   @ObfuscatedName("t")
   public class104 method918(class104 var1, int var2, class42 var3, int var4) {
      var2 = this.field973[var2];
      class102 var5 = class30.method712(var2 >> 16);
      var2 &= '\uffff';
      if(null == var5) {
         return var3.method905(var1, var4);
      } else {
         var4 = var3.field973[var4];
         class102 var6 = class30.method712(var4 >> 16);
         var4 &= '\uffff';
         class104 var7;
         if(null == var6) {
            var7 = var1.method2366(!var5.method2312(var2));
            var7.method2337(var5, var2);
            return var7;
         } else {
            var7 = var1.method2366(!var5.method2312(var2) & !var6.method2312(var4));
            var7.method2346(var5, var2, var6, var4, this.field978);
            return var7;
         }
      }
   }

   @ObfuscatedName("u")
   void method925() {
      if(-1 == this.field980) {
         if(this.field978 != null) {
            this.field980 = 2;
         } else {
            this.field980 = 0;
         }
      }

      if(-1 == this.field985) {
         if(null != this.field978) {
            this.field985 = 2;
         } else {
            this.field985 = 0;
         }
      }

   }

   @ObfuscatedName("h")
   class104 method931(class104 var1, int var2, int var3) {
      var2 = this.field973[var2];
      class102 var4 = class30.method712(var2 >> 16);
      var2 &= '\uffff';
      if(var4 == null) {
         return var1.method2366(true);
      } else {
         class104 var5 = var1.method2366(!var4.method2312(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method2390();
         } else if(2 == var3) {
            var5.method2341();
         } else if(3 == var3) {
            var5.method2340();
         }

         var5.method2337(var4, var2);
         if(var3 == 1) {
            var5.method2340();
         } else if(2 == var3) {
            var5.method2341();
         } else if(3 == var3) {
            var5.method2390();
         }

         return var5;
      }
   }

   @ObfuscatedName("i")
   class104 method932(class104 var1, int var2) {
      var2 = this.field973[var2];
      class102 var3 = class30.method712(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method2380(true);
      } else {
         class104 var4 = var1.method2380(!var3.method2312(var2));
         var4.method2337(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("ck")
   static void method942(class172 var0) {
      if(client.field478 == var0.field2833 * -1) {
         client.field370[var0.field2863] = true;
      }

   }

   @ObfuscatedName("k")
   public static boolean method943(char var0) {
      return var0 >= 48 && var0 <= 57;
   }
}
