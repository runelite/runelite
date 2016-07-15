import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
public class class49 extends class207 {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 548594119
   )
   public int field1095 = 255;
   @ObfuscatedName("l")
   public static class170 field1096;
   @ObfuscatedName("c")
   static class196 field1097 = new class196(64);
   @ObfuscatedName("h")
   static class196 field1098 = new class196(64);
   @ObfuscatedName("az")
   static class171 field1099;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -26369395
   )
   public int field1100;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1332353799
   )
   public int field1101 = -1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -448855623
   )
   public int field1103 = 1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 413497321
   )
   public int field1104 = 70;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1492408119
   )
   int field1105 = -1;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1446400663
   )
   int field1106 = -1;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1206511775
   )
   public int field1107 = 255;
   @ObfuscatedName("e")
   public static class170 field1109;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass122;B)V",
      garbageValue = "118"
   )
   void method1051(class122 var1) {
      while(true) {
         int var2 = var1.method2610();
         if(var2 == 0) {
            return;
         }

         this.method1064(var1, var2);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Lclass81;",
      garbageValue = "-529977354"
   )
   public class81 method1054() {
      if(this.field1106 < 0) {
         return null;
      } else {
         class81 var1 = (class81)field1098.method3834((long)this.field1106);
         if(null != var1) {
            return var1;
         } else {
            var1 = class117.method2533(field1096, this.field1106, 0);
            if(null != var1) {
               field1098.method3836(var1, (long)this.field1106);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)Lclass81;",
      garbageValue = "77"
   )
   public class81 method1055() {
      if(this.field1105 < 0) {
         return null;
      } else {
         class81 var1 = (class81)field1098.method3834((long)this.field1105);
         if(null != var1) {
            return var1;
         } else {
            var1 = class117.method2533(field1096, this.field1105, 0);
            if(var1 != null) {
               field1098.method3836(var1, (long)this.field1105);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("ei")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Ljava/lang/String;",
      garbageValue = "673420925"
   )
   static String method1060(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(client.field399 == 1) {
         var0 = var0 + "-wtrc";
      } else if(client.field399 == 2) {
         var0 = var0 + "-wtqa";
      } else if(client.field399 == 3) {
         var0 = var0 + "-wtwip";
      } else if(client.field399 == 5) {
         var0 = var0 + "-wti";
      } else if(client.field399 == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(null != class28.field702) {
         var3 = "/p=" + class28.field702;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + client.field299 + "/a=" + client.field300 + var3 + "/";
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   static void method1062() {
      class230 var0 = null;

      try {
         var0 = class110.method2465("", client.field372.field2335, true);
         class122 var1 = client.field571.method94();
         var0.method4212(var1.field2054, 0, var1.field2061);
      } catch (Exception var3) {
         ;
      }

      try {
         if(null != var0) {
            var0.method4213();
         }
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass122;II)V",
      garbageValue = "-944874611"
   )
   void method1064(class122 var1, int var2) {
      if(var2 == 1) {
         var1.method2612();
      } else if(var2 == 2) {
         this.field1095 = var1.method2610();
      } else if(var2 == 3) {
         this.field1107 = var1.method2610();
      } else if(var2 == 4) {
         this.field1101 = 0;
      } else if(var2 == 5) {
         this.field1104 = var1.method2612();
      } else if(var2 == 6) {
         var1.method2610();
      } else if(var2 == 7) {
         this.field1105 = var1.method2624();
      } else if(var2 == 8) {
         this.field1106 = var1.method2624();
      } else if(var2 == 9) {
         var1.method2624();
      } else if(var2 == 10) {
         var1.method2624();
      } else if(var2 == 11) {
         this.field1101 = var1.method2612();
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1827190362"
   )
   public static void method1071() {
      class55.field1177.method3835();
      class55.field1206.method3835();
      class55.field1179.method3835();
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2136534589"
   )
   static final void method1073() {
      int var0 = class34.field804;
      int[] var1 = class34.field807;

      for(int var2 = 0; var2 < var0; ++var2) {
         class2 var3 = client.field467[var1[var2]];
         if(var3 != null) {
            class128.method2916(var3, 1);
         }
      }

   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "4969"
   )
   static final void method1074() {
      int var0;
      if(client.field454 != -1) {
         var0 = client.field454;
         if(class10.method112(var0)) {
            class35.method748(class176.field2811[var0], -1);
         }
      }

      for(var0 = 0; var0 < client.field457; ++var0) {
         if(client.field500[var0]) {
            client.field501[var0] = true;
         }

         client.field502[var0] = client.field500[var0];
         client.field500[var0] = false;
      }

      client.field499 = client.field567;
      client.field295 = -1;
      client.field443 = -1;
      class0.field14 = null;
      if(client.field454 != -1) {
         client.field457 = 0;
         class21.method553(client.field454, 0, 0, class142.field2191, class132.field2109, 0, 0, -1);
      }

      class82.method1882();
      int var1;
      int var2;
      int var3;
      int var5;
      int var6;
      int var7;
      if(!client.field540) {
         if(client.field295 != -1) {
            class45.method979(client.field295, client.field443);
         }
      } else {
         var0 = class145.field2224;
         var1 = class172.field2749;
         var2 = class13.field213;
         var3 = class113.field1979;
         int var12 = 6116423;
         class82.method1911(var0, var1, var2, var3, var12);
         class82.method1911(1 + var0, 1 + var1, var2 - 2, 16, 0);
         class82.method1925(1 + var0, 18 + var1, var2 - 2, var3 - 19, 0);
         class146.field2233.method4177("Choose Option", 3 + var0, var1 + 14, var12, -1);
         var5 = class143.field2198;
         var6 = class143.field2201;

         for(var7 = 0; var7 < client.field435; ++var7) {
            int var13 = 15 * (client.field435 - 1 - var7) + 31 + var1;
            int var9 = 16777215;
            if(var5 > var0 && var5 < var0 + var2 && var6 > var13 - 13 && var6 < 3 + var13) {
               var9 = 16776960;
            }

            class146.field2233.method4177(class146.method3106(var7), 3 + var0, var13, var9, 0);
         }

         class26.method600(class145.field2224, class172.field2749, class13.field213, class113.field1979);
      }

      if(client.field507 == 3) {
         for(var0 = 0; var0 < client.field457; ++var0) {
            if(client.field502[var0]) {
               class82.method1895(client.field503[var0], client.field504[var0], client.field505[var0], client.field466[var0], 16711935, 128);
            } else if(client.field501[var0]) {
               class82.method1895(client.field503[var0], client.field504[var0], client.field505[var0], client.field466[var0], 16711680, 128);
            }
         }
      }

      var0 = class50.field1119;
      var1 = class118.field2035.field896;
      var2 = class118.field2035.field879;
      var3 = client.field485;

      for(class24 var4 = (class24)class24.field628.method3899(); null != var4; var4 = (class24)class24.field628.method3918()) {
         if(var4.field633 != -1 || null != var4.field637) {
            var5 = 0;
            if(var1 > var4.field630) {
               var5 += var1 - var4.field630;
            } else if(var1 < var4.field640) {
               var5 += var4.field640 - var1;
            }

            if(var2 > var4.field631) {
               var5 += var2 - var4.field631;
            } else if(var2 < var4.field629) {
               var5 += var4.field629 - var2;
            }

            if(var5 - 64 <= var4.field626 && client.field536 != 0 && var4.field627 == var0) {
               var5 -= 64;
               if(var5 < 0) {
                  var5 = 0;
               }

               var6 = client.field536 * (var4.field626 - var5) / var4.field626;
               Object var10000;
               if(var4.field634 == null) {
                  if(var4.field633 >= 0) {
                     var10000 = null;
                     class61 var14 = class61.method1356(class17.field254, var4.field633, 0);
                     if(var14 != null) {
                        class65 var8 = var14.method1342().method1381(class7.field135);
                        class67 var11 = class67.method1440(var8, 100, var6);
                        var11.method1411(-1);
                        class31.field742.method1241(var11);
                        var4.field634 = var11;
                     }
                  }
               } else {
                  var4.field634.method1530(var6);
               }

               if(var4.field639 == null) {
                  if(var4.field637 != null && (var4.field638 -= var3) <= 0) {
                     var7 = (int)(Math.random() * (double)var4.field637.length);
                     var10000 = null;
                     class61 var15 = class61.method1356(class17.field254, var4.field637[var7], 0);
                     if(null != var15) {
                        class65 var16 = var15.method1342().method1381(class7.field135);
                        class67 var10 = class67.method1440(var16, 100, var6);
                        var10.method1411(0);
                        class31.field742.method1241(var10);
                        var4.field639 = var10;
                        var4.field638 = var4.field635 + (int)(Math.random() * (double)(var4.field636 - var4.field635));
                     }
                  }
               } else {
                  var4.field639.method1530(var6);
                  if(!var4.field639.method4001()) {
                     var4.field639 = null;
                  }
               }
            } else {
               if(null != var4.field634) {
                  class31.field742.method1254(var4.field634);
                  var4.field634 = null;
               }

               if(null != var4.field639) {
                  class31.field742.method1254(var4.field639);
                  var4.field639 = null;
               }
            }
         }
      }

      client.field485 = 0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-202390511"
   )
   static void method1075(byte[] var0) {
      class122 var1 = new class122(var0);
      var1.field2061 = var0.length - 2;
      class79.field1450 = var1.method2612();
      class79.field1449 = new int[class79.field1450];
      class11.field192 = new int[class79.field1450];
      class138.field2134 = new int[class79.field1450];
      class169.field2703 = new int[class79.field1450];
      class93.field1626 = new byte[class79.field1450][];
      var1.field2061 = var0.length - 7 - class79.field1450 * 8;
      class79.field1458 = var1.method2612();
      class79.field1452 = var1.method2612();
      int var2 = (var1.method2610() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class79.field1450; ++var3) {
         class79.field1449[var3] = var1.method2612();
      }

      for(var3 = 0; var3 < class79.field1450; ++var3) {
         class11.field192[var3] = var1.method2612();
      }

      for(var3 = 0; var3 < class79.field1450; ++var3) {
         class138.field2134[var3] = var1.method2612();
      }

      for(var3 = 0; var3 < class79.field1450; ++var3) {
         class169.field2703[var3] = var1.method2612();
      }

      var1.field2061 = var0.length - 7 - class79.field1450 * 8 - (var2 - 1) * 3;
      class178.field2941 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class178.field2941[var3] = var1.method2703();
         if(class178.field2941[var3] == 0) {
            class178.field2941[var3] = 1;
         }
      }

      var1.field2061 = 0;

      for(var3 = 0; var3 < class79.field1450; ++var3) {
         int var4 = class138.field2134[var3];
         int var5 = class169.field2703[var3];
         int var6 = var4 * var5;
         byte[] var7 = new byte[var6];
         class93.field1626[var3] = var7;
         int var8 = var1.method2610();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.method2611();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var4 * var10 + var9] = var1.method2611();
               }
            }
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1844537504"
   )
   static final void method1076() {
      if(null != class8.field150) {
         class8.field150.method3088();
         class8.field150 = null;
      }

      class10.method115();
      class79.field1453.method2009();

      for(int var1 = 0; var1 < 4; ++var1) {
         client.field407[var1].method2486();
      }

      System.gc();
      class182.method3600(2);
      client.field533 = -1;
      client.field411 = false;

      for(class24 var0 = (class24)class24.field628.method3899(); var0 != null; var0 = (class24)class24.field628.method3918()) {
         if(var0.field634 != null) {
            class31.field742.method1254(var0.field634);
            var0.field634 = null;
         }

         if(null != var0.field639) {
            class31.field742.method1254(var0.field639);
            var0.field639 = null;
         }
      }

      class24.field628.method3917();
      class92.method2179(10);
   }
}
