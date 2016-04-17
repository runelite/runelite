import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
public class class31 {
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1045640929
   )
   static int field722;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1694146679
   )
   static int field723 = 0;
   @ObfuscatedName("ax")
   static String field724;
   @ObfuscatedName("c")
   static class80 field725;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 2121529701
   )
   static int field726;
   @ObfuscatedName("k")
   static class78 field727;
   @ObfuscatedName("r")
   static class78 field728;
   @ObfuscatedName("q")
   static class80[] field729;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 978144931
   )
   static int field730;
   @ObfuscatedName("g")
   static int[] field731;
   @ObfuscatedName("f")
   static int[] field732;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 720390515
   )
   static int field733;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 751979873
   )
   static int field734;
   @ObfuscatedName("aq")
   static boolean field735;
   @ObfuscatedName("a")
   static boolean field736;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -393428835
   )
   static int field737;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 206307073
   )
   static int field738;
   @ObfuscatedName("au")
   static class159 field739;
   @ObfuscatedName("ae")
   static String field740;
   @ObfuscatedName("y")
   static class80[] field741;
   @ObfuscatedName("ac")
   static String field742;
   @ObfuscatedName("ao")
   static String field743;
   @ObfuscatedName("an")
   static String field744;
   @ObfuscatedName("at")
   static String field745;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 884874365
   )
   static int field746;
   @ObfuscatedName("d")
   static class80 field747;
   @ObfuscatedName("aa")
   static boolean field748;
   @ObfuscatedName("ab")
   @Export("username")
   static String field749;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -783194461
   )
   static int field750;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 1776969337
   )
   static int field753;
   @ObfuscatedName("bh")
   static class80[] field754;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = 1059257619
   )
   static int field755;

   static {
      field730 = field723 + 202;
      field731 = new int[256];
      field733 = 0;
      field734 = 0;
      field722 = 0;
      field753 = 0;
      field737 = 0;
      field738 = 0;
      field746 = 10;
      field744 = "";
      field726 = 0;
      field742 = "";
      field743 = "";
      field724 = "";
      field745 = "";
      field749 = "";
      field740 = "";
      field739 = class159.field2596;
      field735 = true;
      field750 = 0;
      field748 = false;
      field755 = -1;
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1358114476"
   )
   static final void method756(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < client.field496; ++var4) {
         if(client.field503[var4] + client.field311[var4] > var0 && client.field311[var4] < var0 + var2 && client.field497[var4] + client.field504[var4] > var1 && client.field497[var4] < var1 + var3) {
            client.field323[var4] = true;
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass80;B)V",
      garbageValue = "0"
   )
   static final void method773(class80 var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < class110.field1947.length; ++var2) {
         class110.field1947[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         class110.field1947[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = (var3 << 7) + var4;
               class52.field1168[var5] = (class110.field1947[var5 + 1] + class110.field1947[var5 - 1] + class110.field1947[var5 - 128] + class110.field1947[var5 + 128]) / 4;
            }
         }

         int[] var8 = class110.field1947;
         class110.field1947 = class52.field1168;
         class52.field1168 = var8;
      }

      if(null != var0) {
         var2 = 0;

         for(var3 = 0; var3 < var0.field1420; ++var3) {
            for(var4 = 0; var4 < var0.field1419; ++var4) {
               if(var0.field1422[var2++] != 0) {
                  var5 = 16 + var4 + var0.field1421;
                  int var6 = 16 + var3 + var0.field1424;
                  int var7 = var5 + (var6 << 7);
                  class110.field1947[var7] = 0;
               }
            }
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "61"
   )
   static void method774() {
      client.field304 = -1L;
      client.field310 = -1;
      class121.field2008.field208 = 0;
      class121.field2010 = true;
      client.field300 = true;
      client.field351 = -1L;
      class211.field3138 = new class202();
      client.field338.field1992 = 0;
      client.field441.field1992 = 0;
      client.field394 = -1;
      client.field471 = 1;
      client.field576 = -1;
      client.field436 = -1;
      client.field371 = 0;
      client.field313 = 0;
      client.field401 = 0;
      client.field314 = 0;
      client.field434 = 0;
      client.field433 = false;
      class96.method2280(0);
      class11.field183.clear();
      class11.field181.method3891();
      class11.field182.method3941();
      class11.field185 = 0;
      client.field448 = 0;
      client.field447 = false;
      client.field536 = 0;
      client.field359 = (int)(Math.random() * 100.0D) - 50;
      client.field568 = (int)(Math.random() * 110.0D) - 55;
      client.field363 = (int)(Math.random() * 80.0D) - 40;
      client.field443 = (int)(Math.random() * 120.0D) - 60;
      client.field368 = (int)(Math.random() * 30.0D) - 20;
      client.field379 = (int)(Math.random() * 20.0D) - 10 & 2047;
      client.field530 = 0;
      client.field523 = -1;
      client.field528 = 0;
      client.field347 = 0;
      client.field322 = class20.field585;
      client.field508 = class20.field585;
      client.field343 = 0;
      class32.field771 = 0;

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         class32.field761[var0] = null;
         class32.field772[var0] = 1;
      }

      for(var0 = 0; var0 < 2048; ++var0) {
         client.field550[var0] = null;
      }

      for(var0 = 0; var0 < '耀'; ++var0) {
         client.field546[var0] = null;
      }

      client.field424 = -1;
      client.field449.method3898();
      client.field428.method3898();

      int var2;
      for(var0 = 0; var0 < 4; ++var0) {
         for(int var1 = 0; var1 < 104; ++var1) {
            for(var2 = 0; var2 < 104; ++var2) {
               client.field425[var0][var1][var2] = null;
            }
         }
      }

      client.field426 = new class199();
      client.field562 = 0;
      client.field561 = 0;
      client.field397 = 0;

      for(var0 = 0; var0 < class52.field1169; ++var0) {
         class52 var3 = class43.method1009(var0);
         if(null != var3) {
            class176.field2906[var0] = 0;
            class176.field2905[var0] = 0;
         }
      }

      class171.field2723.method252();
      client.field460 = -1;
      if(-1 != client.field452) {
         var0 = client.field452;
         if(-1 != var0 && class163.field2642[var0]) {
            class173.field2802.method3416(var0);
            if(null != class173.field2886[var0]) {
               boolean var4 = true;

               for(var2 = 0; var2 < class173.field2886[var0].length; ++var2) {
                  if(class173.field2886[var0][var2] != null) {
                     if(class173.field2886[var0][var2].field2824 != 2) {
                        class173.field2886[var0][var2] = null;
                     } else {
                        var4 = false;
                     }
                  }
               }

               if(var4) {
                  class173.field2886[var0] = null;
               }

               class163.field2642[var0] = false;
            }
         }
      }

      for(class3 var5 = (class3)client.field453.method3871(); var5 != null; var5 = (class3)client.field453.method3867()) {
         method777(var5, true);
      }

      client.field452 = -1;
      client.field453 = new class196(8);
      client.field526 = null;
      client.field433 = false;
      client.field434 = 0;
      client.field567.method3564((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

      for(var0 = 0; var0 < 8; ++var0) {
         client.field317[var0] = null;
         client.field422[var0] = false;
      }

      class183.method3675();
      client.field507 = true;

      for(var0 = 0; var0 < 100; ++var0) {
         client.field323[var0] = true;
      }

      class34.method804();
      client.field512 = null;
      class139.field2143 = 0;
      class59.field1226 = null;

      for(var0 = 0; var0 < 8; ++var0) {
         client.field570[var0] = new class220();
      }

      class25.field656 = null;
   }

   @ObfuscatedName("ec")
   @ObfuscatedSignature(
      signature = "(Lclass173;I)I",
      garbageValue = "2110560975"
   )
   static int method776(class173 var0) {
      class201 var1 = (class201)client.field495.method3868(((long)var0.field2842 << 32) + (long)var0.field2759);
      return var1 != null?var1.field3110:var0.field2830;
   }

   @ObfuscatedName("dx")
   @ObfuscatedSignature(
      signature = "(Lclass3;ZI)V",
      garbageValue = "1"
   )
   static final void method777(class3 var0, boolean var1) {
      int var2 = var0.field70;
      int var3 = (int)var0.field3125;
      var0.method3998();
      if(-1 != var2 && class163.field2642[var2]) {
         class173.field2802.method3416(var2);
         if(null != class173.field2886[var2]) {
            boolean var4 = true;

            for(int var5 = 0; var5 < class173.field2886[var2].length; ++var5) {
               if(null != class173.field2886[var2][var5]) {
                  if(2 != class173.field2886[var2][var5].field2824) {
                     class173.field2886[var2][var5] = null;
                  } else {
                     var4 = false;
                  }
               }
            }

            if(var4) {
               class173.field2886[var2] = null;
            }

            class163.field2642[var2] = false;
         }
      }

      class188.method3829(var2);
      class173 var6 = class20.method641(var3);
      if(var6 != null) {
         class23.method657(var6);
      }

      class5.method80();
      if(-1 != client.field452) {
         class124.method2904(client.field452, 1);
      }

   }
}
