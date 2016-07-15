import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fv")
public class class163 extends class211 {
   @ObfuscatedName("an")
   boolean field2650;
   @ObfuscatedName("ay")
   String field2652;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -754171161
   )
   int field2653;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -1953174029
   )
   int field2654;
   @ObfuscatedName("b")
   boolean field2655;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1523057127
   )
   int field2657;
   @ObfuscatedName("ax")
   String field2659;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 401134675
   )
   int field2661;
   @ObfuscatedName("az")
   String field2662;
   @ObfuscatedName("ac")
   int[] field2663 = new int[3];
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1069405707
   )
   int field2666;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -2114838461
   )
   int field2667;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 823063751
   )
   int field2668;
   @ObfuscatedName("af")
   String field2669;
   @ObfuscatedName("ai")
   String field2671;
   @ObfuscatedName("ar")
   String field2672;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -784587015
   )
   int field2673;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1879673935
   )
   int field2674;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -1756345993
   )
   int field2675;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1961229277
   )
   int field2676;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1633093145
   )
   int field2678;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 1534307027
   )
   int field2679;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = -1796628607
   )
   int field2680;
   @ObfuscatedName("nz")
   @ObfuscatedGetter(
      intValue = 438659875
   )
   static int field2681;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 831679513
   )
   int field2682;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "28847254"
   )
   void method3268() {
      if(this.field2669.length() > 40) {
         this.field2669 = this.field2669.substring(0, 40);
      }

      if(this.field2659.length() > 40) {
         this.field2659 = this.field2659.substring(0, 40);
      }

      if(this.field2671.length() > 10) {
         this.field2671 = this.field2671.substring(0, 10);
      }

      if(this.field2672.length() > 10) {
         this.field2672 = this.field2672.substring(0, 10);
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass122;I)V",
      garbageValue = "1296657268"
   )
   public void method3269(class122 var1) {
      var1.method2795(6);
      var1.method2795(this.field2674);
      var1.method2795(this.field2655?1:0);
      var1.method2795(this.field2657);
      var1.method2795(this.field2682);
      var1.method2795(this.field2661);
      var1.method2795(this.field2679);
      var1.method2795(this.field2654);
      var1.method2795(this.field2650?1:0);
      var1.method2781(this.field2678);
      var1.method2795(this.field2666);
      var1.method2675(this.field2667);
      var1.method2781(this.field2668);
      var1.method2602(this.field2669);
      var1.method2602(this.field2659);
      var1.method2602(this.field2671);
      var1.method2602(this.field2672);
      var1.method2795(this.field2653);
      var1.method2781(this.field2673);
      var1.method2602(this.field2662);
      var1.method2602(this.field2652);
      var1.method2795(this.field2675);
      var1.method2795(this.field2676);

      for(int var2 = 0; var2 < this.field2663.length; ++var2) {
         var1.method2598(this.field2663[var2]);
      }

      var1.method2598(this.field2680);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "932088124"
   )
   public int method3270() {
      byte var1 = 38;
      String var4 = this.field2669;
      int var3 = var4.length() + 2;
      int var20 = var1 + var3;
      String var7 = this.field2659;
      int var6 = var7.length() + 2;
      var20 += var6;
      String var10 = this.field2671;
      int var9 = var10.length() + 2;
      var20 += var9;
      String var13 = this.field2672;
      int var12 = var13.length() + 2;
      var20 += var12;
      String var16 = this.field2662;
      int var15 = var16.length() + 2;
      var20 += var15;
      String var19 = this.field2652;
      int var18 = var19.length() + 2;
      var20 += var18;
      return var20;
   }

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public class163(boolean var1) {
      if(class34.field797.startsWith("win")) {
         this.field2674 = 1;
      } else if(class34.field797.startsWith("mac")) {
         this.field2674 = 2;
      } else if(class34.field797.startsWith("linux")) {
         this.field2674 = 3;
      } else {
         this.field2674 = 4;
      }

      String var2;
      try {
         var2 = System.getProperty("os.arch").toLowerCase();
      } catch (Exception var13) {
         var2 = "";
      }

      String var3;
      try {
         var3 = System.getProperty("os.version").toLowerCase();
      } catch (Exception var12) {
         var3 = "";
      }

      String var4 = "Unknown";
      String var5 = "1.1";

      try {
         var4 = System.getProperty("java.vendor");
         var5 = System.getProperty("java.version");
      } catch (Exception var11) {
         ;
      }

      if(!var2.startsWith("amd64") && !var2.startsWith("x86_64")) {
         this.field2655 = false;
      } else {
         this.field2655 = true;
      }

      if(this.field2674 == 1) {
         if(var3.indexOf("4.0") != -1) {
            this.field2657 = 1;
         } else if(var3.indexOf("4.1") != -1) {
            this.field2657 = 2;
         } else if(var3.indexOf("4.9") != -1) {
            this.field2657 = 3;
         } else if(var3.indexOf("5.0") != -1) {
            this.field2657 = 4;
         } else if(var3.indexOf("5.1") != -1) {
            this.field2657 = 5;
         } else if(var3.indexOf("5.2") != -1) {
            this.field2657 = 8;
         } else if(var3.indexOf("6.0") != -1) {
            this.field2657 = 6;
         } else if(var3.indexOf("6.1") != -1) {
            this.field2657 = 7;
         } else if(var3.indexOf("6.2") != -1) {
            this.field2657 = 9;
         } else if(var3.indexOf("6.3") != -1) {
            this.field2657 = 10;
         }
      } else if(this.field2674 == 2) {
         if(var3.indexOf("10.4") != -1) {
            this.field2657 = 20;
         } else if(var3.indexOf("10.5") != -1) {
            this.field2657 = 21;
         } else if(var3.indexOf("10.6") != -1) {
            this.field2657 = 22;
         } else if(var3.indexOf("10.7") != -1) {
            this.field2657 = 23;
         } else if(var3.indexOf("10.8") != -1) {
            this.field2657 = 24;
         } else if(var3.indexOf("10.9") != -1) {
            this.field2657 = 25;
         } else if(var3.indexOf("10.10") != -1) {
            this.field2657 = 26;
         }
      }

      if(var4.toLowerCase().indexOf("sun") != -1) {
         this.field2682 = 1;
      } else if(var4.toLowerCase().indexOf("microsoft") != -1) {
         this.field2682 = 2;
      } else if(var4.toLowerCase().indexOf("apple") != -1) {
         this.field2682 = 3;
      } else if(var4.toLowerCase().indexOf("oracle") != -1) {
         this.field2682 = 5;
      } else {
         this.field2682 = 4;
      }

      int var9 = 2;
      int var7 = 0;

      char var8;
      try {
         while(var9 < var5.length()) {
            var8 = var5.charAt(var9);
            if(var8 < 48 || var8 > 57) {
               break;
            }

            var7 = var8 - 48 + 10 * var7;
            ++var9;
         }
      } catch (Exception var16) {
         ;
      }

      this.field2661 = var7;
      var9 = var5.indexOf(46, 2) + 1;
      var7 = 0;

      try {
         while(var9 < var5.length()) {
            var8 = var5.charAt(var9);
            if(var8 < 48 || var8 > 57) {
               break;
            }

            var7 = var8 - 48 + var7 * 10;
            ++var9;
         }
      } catch (Exception var15) {
         ;
      }

      this.field2679 = var7;
      var9 = var5.indexOf(95, 4) + 1;
      var7 = 0;

      try {
         while(var9 < var5.length()) {
            var8 = var5.charAt(var9);
            if(var8 < 48 || var8 > 57) {
               break;
            }

            var7 = var8 - 48 + var7 * 10;
            ++var9;
         }
      } catch (Exception var14) {
         ;
      }

      this.field2654 = var7;
      this.field2650 = false;
      this.field2678 = (int)(Runtime.getRuntime().maxMemory() / 1048576L) + 1;
      if(this.field2661 > 3) {
         this.field2666 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field2666 = 0;
      }

      this.field2667 = 0;
      if(this.field2669 == null) {
         this.field2669 = "";
      }

      if(null == this.field2659) {
         this.field2659 = "";
      }

      if(this.field2671 == null) {
         this.field2671 = "";
      }

      if(this.field2672 == null) {
         this.field2672 = "";
      }

      if(this.field2662 == null) {
         this.field2662 = "";
      }

      if(null == this.field2652) {
         this.field2652 = "";
      }

      this.method3268();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1672347523"
   )
   static void method3275() {
      int var0;
      if(client.field288 == 0) {
         class79.field1453 = new class89(4, 104, 104, class5.field78);

         for(var0 = 0; var0 < 4; ++var0) {
            client.field407[var0] = new class111(104, 104);
         }

         class33.field793 = new class81(512, 512);
         class33.field777 = "Starting game engine...";
         class33.field776 = 5;
         client.field288 = 20;
      } else {
         int var1;
         int var2;
         int var3;
         int var4;
         if(client.field288 == 20) {
            int[] var17 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = 32 * var1 + 128 + 15;
               var3 = 600 + 3 * var2;
               var4 = class94.field1655[var2];
               var17[var1] = var4 * var3 >> 16;
            }

            class89.method2065(var17, 500, 800, 512, 334);
            class33.field777 = "Prepared visibility map";
            class33.field776 = 10;
            client.field288 = 30;
         } else if(client.field288 == 30) {
            class49.field1099 = class77.method1690(0, false, true, true);
            class126.field2076 = class77.method1690(1, false, true, true);
            class172.field2748 = class77.method1690(2, true, false, true);
            class172.field2741 = class77.method1690(3, false, true, true);
            class17.field254 = class77.method1690(4, false, true, true);
            class4.field68 = class77.method1690(5, true, true, true);
            class109.field1948 = class77.method1690(6, true, true, false);
            class48.field1083 = class77.method1690(7, false, true, true);
            class230.field3263 = class77.method1690(8, false, true, true);
            class90.field1595 = class77.method1690(9, false, true, true);
            class192.field3097 = class77.method1690(10, false, true, true);
            class104.field1813 = class77.method1690(11, false, true, true);
            class0.field11 = class77.method1690(12, false, true, true);
            class23.field623 = class77.method1690(13, true, false, true);
            class127.field2086 = class77.method1690(14, false, true, false);
            class18.field269 = class77.method1690(15, false, true, true);
            class33.field777 = "Connecting to update server";
            class33.field776 = 20;
            client.field288 = 40;
         } else if(client.field288 == 40) {
            byte var20 = 0;
            var0 = var20 + class49.field1099.method3445() * 4 / 100;
            var0 += class126.field2076.method3445() * 4 / 100;
            var0 += class172.field2748.method3445() * 2 / 100;
            var0 += class172.field2741.method3445() * 2 / 100;
            var0 += class17.field254.method3445() * 6 / 100;
            var0 += class4.field68.method3445() * 4 / 100;
            var0 += class109.field1948.method3445() * 2 / 100;
            var0 += class48.field1083.method3445() * 60 / 100;
            var0 += class230.field3263.method3445() * 2 / 100;
            var0 += class90.field1595.method3445() * 2 / 100;
            var0 += class192.field3097.method3445() * 2 / 100;
            var0 += class104.field1813.method3445() * 2 / 100;
            var0 += class0.field11.method3445() * 2 / 100;
            var0 += class23.field623.method3445() * 2 / 100;
            var0 += class127.field2086.method3445() * 2 / 100;
            var0 += class18.field269.method3445() * 2 / 100;
            if(var0 != 100) {
               if(var0 != 0) {
                  class33.field777 = "Checking for updates - " + var0 + "%";
               }

               class33.field776 = 30;
            } else {
               class33.field777 = "Loaded update list";
               class33.field776 = 30;
               client.field288 = 45;
            }
         } else {
            class171 var12;
            class171 var13;
            class171 var14;
            if(client.field288 == 45) {
               boolean var19 = !client.field298;
               class59.field1260 = 22050;
               class59.field1242 = var19;
               class59.field1243 = 2;
               class187 var18 = new class187();
               var18.method3691(9, 128);
               class34.field809 = class32.method678(class107.field1869, class158.field2346, 0, 22050);
               class34.field809.method1276(var18);
               var14 = class18.field269;
               var12 = class127.field2086;
               var13 = class17.field254;
               class186.field2994 = var14;
               class186.field3001 = var12;
               class186.field2995 = var13;
               class186.field2996 = var18;
               class31.field744 = class32.method678(class107.field1869, class158.field2346, 1, 2048);
               class31.field742 = new class58();
               class31.field744.method1276(class31.field742);
               class7.field135 = new class77(22050, class59.field1260);
               class33.field777 = "Prepared sound engine";
               class33.field776 = 35;
               client.field288 = 50;
            } else if(client.field288 == 50) {
               var0 = 0;
               if(null == class164.field2683) {
                  class164.field2683 = class124.method2852(class230.field3263, class23.field623, "p11_full", "");
               } else {
                  ++var0;
               }

               if(class104.field1834 == null) {
                  class104.field1834 = class124.method2852(class230.field3263, class23.field623, "p12_full", "");
               } else {
                  ++var0;
               }

               if(null == class146.field2233) {
                  class146.field2233 = class124.method2852(class230.field3263, class23.field623, "b12_full", "");
               } else {
                  ++var0;
               }

               if(var0 < 3) {
                  class33.field777 = "Loading fonts - " + 100 * var0 / 3 + "%";
                  class33.field776 = 40;
               } else {
                  class99.field1706 = new class163(true);
                  class33.field777 = "Loaded fonts";
                  class33.field776 = 40;
                  client.field288 = 60;
               }
            } else if(client.field288 == 60) {
               var0 = class38.method783(class192.field3097, class230.field3263);
               var1 = class23.method572();
               if(var0 < var1) {
                  class33.field777 = "Loading title screen - " + var0 * 100 / var1 + "%";
                  class33.field776 = 50;
               } else {
                  class33.field777 = "Loaded title screen";
                  class33.field776 = 50;
                  class92.method2179(5);
                  client.field288 = 70;
               }
            } else if(client.field288 == 70) {
               if(!class172.field2748.method3369()) {
                  class33.field777 = "Loading config - " + class172.field2748.method3433() + "%";
                  class33.field776 = 60;
               } else {
                  class171 var16 = class172.field2748;
                  class212.field3164 = var16;
                  class19.method195(class172.field2748);
                  class30.method660(class172.field2748, class48.field1083);
                  class117.method2528(class172.field2748, class48.field1083, client.field298);
                  client.method474(class172.field2748, class48.field1083);
                  class134.method2960(class172.field2748, class48.field1083, client.field388, class164.field2683);
                  class96.method2259(class172.field2748, class49.field1099, class126.field2076);
                  class34.method734(class172.field2748, class48.field1083);
                  class171 var10 = class172.field2748;
                  class50.field1115 = var10;
                  class40.method804(class172.field2748);
                  class77.method1693(class172.field2741, class48.field1083, class230.field3263, class23.field623);
                  class17.method165(class172.field2748);
                  var14 = class172.field2748;
                  class52.field1152 = var14;
                  var12 = class172.field2748;
                  class47.field1075 = var12;
                  class179.method3548(class172.field2748);
                  class11.field187 = new class19();
                  var13 = class172.field2748;
                  class171 var5 = class230.field3263;
                  class171 var6 = class23.field623;
                  class51.field1138 = var13;
                  class51.field1141 = var5;
                  class51.field1126 = var6;
                  class171 var7 = class172.field2748;
                  class171 var8 = class230.field3263;
                  class49.field1109 = var7;
                  class49.field1096 = var8;
                  class33.field777 = "Loaded config";
                  class33.field776 = 60;
                  client.field288 = 80;
               }
            } else if(client.field288 != 80) {
               if(client.field288 == 90) {
                  if(!class90.field1595.method3369()) {
                     class33.field777 = "Loading textures - " + class90.field1595.method3433() + "%";
                     class33.field776 = 90;
                  } else {
                     class98 var15 = new class98(class90.field1595, class230.field3263, 20, 0.8D, client.field298?64:128);
                     class94.method2188(var15);
                     class94.method2206(0.8D);
                     class33.field777 = "Loaded textures";
                     class33.field776 = 90;
                     client.field288 = 110;
                  }
               } else if(client.field288 == 110) {
                  class175.field2782 = new class13();
                  class107.field1869.method3005(class175.field2782, 10);
                  class33.field777 = "Loaded input handler";
                  class33.field776 = 94;
                  client.field288 = 120;
               } else if(client.field288 == 120) {
                  if(!class192.field3097.method3341("huffman", "")) {
                     class33.field777 = "Loading wordpack - " + 0 + "%";
                     class33.field776 = 96;
                  } else {
                     class116 var9 = new class116(class192.field3097.method3358("huffman", ""));
                     class225.field3225 = var9;
                     class33.field777 = "Loaded wordpack";
                     class33.field776 = 96;
                     client.field288 = 130;
                  }
               } else if(client.field288 == 130) {
                  if(!class172.field2741.method3369()) {
                     class33.field777 = "Loading interfaces - " + class172.field2741.method3433() * 4 / 5 + "%";
                     class33.field776 = 100;
                  } else if(!class0.field11.method3369()) {
                     class33.field777 = "Loading interfaces - " + (80 + class0.field11.method3433() / 6) + "%";
                     class33.field776 = 100;
                  } else if(!class23.field623.method3369()) {
                     class33.field777 = "Loading interfaces - " + (96 + class23.field623.method3433() / 20) + "%";
                     class33.field776 = 100;
                  } else {
                     class33.field777 = "Loaded interfaces";
                     class33.field776 = 100;
                     client.field288 = 140;
                  }
               } else if(client.field288 == 140) {
                  class92.method2179(10);
               }
            } else {
               var0 = 0;
               if(null == class170.field2729) {
                  class170.field2729 = class147.method3192(class230.field3263, "compass", "");
               } else {
                  ++var0;
               }

               if(null == class30.field719) {
                  class30.field719 = class147.method3192(class230.field3263, "mapedge", "");
               } else {
                  ++var0;
               }

               if(null == class51.field1135) {
                  class51.field1135 = class178.method3539(class230.field3263, "mapscene", "");
               } else {
                  ++var0;
               }

               if(class2.field56 == null) {
                  class2.field56 = class85.method1983(class230.field3263, "mapfunction", "");
               } else {
                  ++var0;
               }

               if(class101.field1747 == null) {
                  class101.field1747 = class85.method1983(class230.field3263, "headicons_pk", "");
               } else {
                  ++var0;
               }

               if(class19.field274 == null) {
                  class19.field274 = class85.method1983(class230.field3263, "headicons_prayer", "");
               } else {
                  ++var0;
               }

               if(null == class184.field2977) {
                  class184.field2977 = class85.method1983(class230.field3263, "headicons_hint", "");
               } else {
                  ++var0;
               }

               if(class136.field2122 == null) {
                  class136.field2122 = class85.method1983(class230.field3263, "mapmarker", "");
               } else {
                  ++var0;
               }

               if(null == class34.field811) {
                  class34.field811 = class85.method1983(class230.field3263, "cross", "");
               } else {
                  ++var0;
               }

               if(null == client.field390) {
                  client.field390 = class85.method1983(class230.field3263, "mapdots", "");
               } else {
                  ++var0;
               }

               if(null == class214.field3178) {
                  class214.field3178 = class178.method3539(class230.field3263, "scrollbar", "");
               } else {
                  ++var0;
               }

               if(null == client.field326) {
                  client.field326 = class178.method3539(class230.field3263, "mod_icons", "");
               } else {
                  ++var0;
               }

               if(var0 < 12) {
                  class33.field777 = "Loading sprites - " + var0 * 100 / 12 + "%";
                  class33.field776 = 70;
               } else {
                  class226.field3229 = client.field326;
                  class30.field719.method1794();
                  var1 = (int)(Math.random() * 21.0D) - 10;
                  var2 = (int)(Math.random() * 21.0D) - 10;
                  var3 = (int)(Math.random() * 21.0D) - 10;
                  var4 = (int)(Math.random() * 41.0D) - 20;

                  for(int var11 = 0; var11 < class2.field56.length; ++var11) {
                     class2.field56[var11].method1793(var1 + var4, var2 + var4, var3 + var4);
                  }

                  class51.field1135[0].method1954(var1 + var4, var2 + var4, var4 + var3);
                  class33.field777 = "Loaded sprites";
                  class33.field776 = 70;
                  client.field288 = 90;
               }
            }
         }
      }
   }
}
