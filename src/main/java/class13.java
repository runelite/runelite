import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
public class class13 implements Runnable {
   @ObfuscatedName("w")
   Object field206 = new Object();
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1896657111
   )
   int field208 = 0;
   @ObfuscatedName("y")
   int[] field209 = new int[500];
   @ObfuscatedName("pf")
   @ObfuscatedGetter(
      intValue = 836688141
   )
   static int field210;
   @ObfuscatedName("x")
   static class173 field211;
   @ObfuscatedName("c")
   int[] field212 = new int[500];
   @ObfuscatedName("a")
   boolean field213 = true;

   public void run() {
      for(; this.field213; class4.method55(50L)) {
         Object var1 = this.field206;
         synchronized(this.field206) {
            if(this.field208 < 500) {
               this.field212[this.field208] = class140.field2151;
               this.field209[this.field208] = class140.field2161;
               ++this.field208;
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "4"
   )
   public static int method194(int var0, int var1, int var2) {
      var2 &= 3;
      return 0 == var2?var1:(var2 == 1?7 - var0:(var2 == 2?7 - var1:var0));
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1485086242"
   )
   static void method195() {
      int var0;
      if(client.field324 == 0) {
         class30.field717 = new class86(4, 104, 104, class5.field94);

         for(var0 = 0; var0 < 4; ++var0) {
            client.field361[var0] = new class108(104, 104);
         }

         class94.field1610 = new class78(512, 512);
         class31.field744 = "Starting game engine...";
         class31.field746 = 5;
         client.field324 = 20;
      } else {
         int var3;
         int var4;
         int var15;
         int var18;
         if(20 == client.field324) {
            int[] var28 = new int[9];

            for(var15 = 0; var15 < 9; ++var15) {
               var18 = 15 + 32 * var15 + 128;
               var3 = var18 * 3 + 600;
               var4 = class91.field1593[var18];
               var28[var15] = var4 * var3 >> 16;
            }

            class86.method2043(var28, 500, 800, 512, 334);
            class31.field744 = "Prepared visibility map";
            class31.field746 = 10;
            client.field324 = 30;
         } else if(30 == client.field324) {
            class45.field1057 = class107.method2484(0, false, true, true);
            class99.field1682 = class107.method2484(1, false, true, true);
            class29.field709 = class107.method2484(2, true, false, true);
            class181.field2943 = class107.method2484(3, false, true, true);
            class114.field1967 = class107.method2484(4, false, true, true);
            class8.field156 = class107.method2484(5, true, true, true);
            class38.field884 = class107.method2484(6, true, true, false);
            class19.field279 = class107.method2484(7, false, true, true);
            class103.field1768 = class107.method2484(8, false, true, true);
            class135.field2082 = class107.method2484(9, false, true, true);
            class48.field1089 = class107.method2484(10, false, true, true);
            class36.field814 = class107.method2484(11, false, true, true);
            class211.field3137 = class107.method2484(12, false, true, true);
            class14.field219 = class107.method2484(13, true, false, true);
            class21.field591 = class107.method2484(14, false, true, false);
            class176.field2911 = class107.method2484(15, false, true, true);
            class31.field744 = "Connecting to update server";
            class31.field746 = 20;
            client.field324 = 40;
         } else if(client.field324 == 40) {
            byte var27 = 0;
            var0 = var27 + class45.field1057.method3439() * 4 / 100;
            var0 += class99.field1682.method3439() * 4 / 100;
            var0 += class29.field709.method3439() * 2 / 100;
            var0 += class181.field2943.method3439() * 2 / 100;
            var0 += class114.field1967.method3439() * 6 / 100;
            var0 += class8.field156.method3439() * 4 / 100;
            var0 += class38.field884.method3439() * 2 / 100;
            var0 += class19.field279.method3439() * 60 / 100;
            var0 += class103.field1768.method3439() * 2 / 100;
            var0 += class135.field2082.method3439() * 2 / 100;
            var0 += class48.field1089.method3439() * 2 / 100;
            var0 += class36.field814.method3439() * 2 / 100;
            var0 += class211.field3137.method3439() * 2 / 100;
            var0 += class14.field219.method3439() * 2 / 100;
            var0 += class21.field591.method3439() * 2 / 100;
            var0 += class176.field2911.method3439() * 2 / 100;
            if(var0 != 100) {
               if(var0 != 0) {
                  class31.field744 = "Checking for updates - " + var0 + "%";
               }

               class31.field746 = 30;
            } else {
               class31.field744 = "Loaded update list";
               class31.field746 = 30;
               client.field324 = 45;
            }
         } else {
            class168 var2;
            class168 var19;
            class168 var20;
            if(45 == client.field324) {
               boolean var26 = !client.field302;
               class40.field973 = 22050;
               class96.field1633 = var26;
               class227.field3217 = 2;
               class184 var17 = new class184();
               var17.method3685(9, 128);
               class96.field1627 = class32.method788(class107.field1874, class158.field2585, 0, 22050);
               class96.field1627.method1276(var17);
               var2 = class176.field2911;
               var19 = class21.field591;
               var20 = class114.field1967;
               class183.field2969 = var2;
               class183.field2964 = var19;
               class183.field2970 = var20;
               class183.field2973 = var17;
               client.field577 = class32.method788(class107.field1874, class158.field2585, 1, 2048);
               class10.field178 = new class55();
               client.field577.method1276(class10.field178);
               class82.field1439 = new class74(22050, class40.field973);
               class31.field744 = "Prepared sound engine";
               class31.field746 = 35;
               client.field324 = 50;
            } else if(50 == client.field324) {
               var0 = 0;
               if(class148.field2220 == null) {
                  class148.field2220 = class16.method215(class103.field1768, class14.field219, "p11_full", "");
               } else {
                  ++var0;
               }

               if(class135.field2084 == null) {
                  class135.field2084 = class16.method215(class103.field1768, class14.field219, "p12_full", "");
               } else {
                  ++var0;
               }

               if(null == class33.field781) {
                  class33.field781 = class16.method215(class103.field1768, class14.field219, "b12_full", "");
               } else {
                  ++var0;
               }

               if(var0 < 3) {
                  class31.field744 = "Loading fonts - " + var0 * 100 / 3 + "%";
                  class31.field746 = 40;
               } else {
                  class20.field579 = new class160(true);
                  class31.field744 = "Loaded fonts";
                  class31.field746 = 40;
                  client.field324 = 60;
               }
            } else {
               class168 var16;
               if(60 == client.field324) {
                  var16 = class48.field1089;
                  var2 = class103.field1768;
                  var3 = 0;
                  if(var16.method3380("title.jpg", "")) {
                     ++var3;
                  }

                  if(var2.method3380("logo", "")) {
                     ++var3;
                  }

                  if(var2.method3380("logo_deadman_mode", "")) {
                     ++var3;
                  }

                  if(var2.method3380("titlebox", "")) {
                     ++var3;
                  }

                  if(var2.method3380("titlebutton", "")) {
                     ++var3;
                  }

                  if(var2.method3380("runes", "")) {
                     ++var3;
                  }

                  if(var2.method3380("title_mute", "")) {
                     ++var3;
                  }

                  if(var2.method3381("options_radio_buttons,0")) {
                     ++var3;
                  }

                  if(var2.method3381("options_radio_buttons,2")) {
                     ++var3;
                  }

                  var2.method3380("sl_back", "");
                  var2.method3380("sl_flags", "");
                  var2.method3380("sl_arrows", "");
                  var2.method3380("sl_stars", "");
                  var2.method3380("sl_button", "");
                  byte var21 = 9;
                  if(var3 < var21) {
                     class31.field744 = "Loading title screen - " + var3 * 100 / var21 + "%";
                     class31.field746 = 50;
                  } else {
                     class31.field744 = "Loaded title screen";
                     class31.field746 = 50;
                     class3.method49(5);
                     client.field324 = 70;
                  }
               } else if(70 == client.field324) {
                  if(!class29.field709.method3366()) {
                     class31.field744 = "Loading config - " + class29.field709.method3447() + "%";
                     class31.field746 = 60;
                  } else {
                     client.method449(class29.field709);
                     class168 var25 = class29.field709;
                     class163.field2639 = var25;
                     var16 = class29.field709;
                     var2 = class19.field279;
                     class44.field1039 = var16;
                     class44.field1037 = var2;
                     class44.field1038 = class44.field1039.method3372(3);
                     class170.method3467(class29.field709, class19.field279, client.field302);
                     var19 = class29.field709;
                     var20 = class19.field279;
                     class39.field892 = var19;
                     class39.field894 = var20;
                     class168 var22 = class29.field709;
                     class168 var6 = class19.field279;
                     boolean var7 = client.field301;
                     class224 var8 = class148.field2220;
                     class129.field2052 = var22;
                     class165.field2653 = var6;
                     class51.field1117 = var7;
                     class51.field1118 = class129.field2052.method3372(10);
                     class51.field1159 = var8;
                     class168 var9 = class29.field709;
                     class168 var10 = class45.field1057;
                     class168 var11 = class99.field1682;
                     class124.field2031 = var9;
                     class42.field1008 = var10;
                     class114.field1962 = var11;
                     class45.method1051(class29.field709, class19.field279);
                     class19.method257(class29.field709);
                     class168 var12 = class29.field709;
                     class52.field1173 = var12;
                     class52.field1169 = class52.field1173.method3372(16);
                     class43.method995(class181.field2943, class19.field279, class103.field1768, class14.field219);
                     method196(class29.field709);
                     class168 var13 = class29.field709;
                     class48.field1088 = var13;
                     class168 var14 = class29.field709;
                     class45.field1056 = var14;
                     class24.method675(class29.field709);
                     class171.field2723 = new class19();
                     class31.field744 = "Loaded config";
                     class31.field746 = 60;
                     client.field324 = 80;
                  }
               } else if(80 != client.field324) {
                  if(90 == client.field324) {
                     if(!class135.field2082.method3366()) {
                        class31.field744 = "Loading textures - " + class135.field2082.method3447() + "%";
                        class31.field746 = 90;
                     } else {
                        class95 var24 = new class95(class135.field2082, class103.field1768, 20, 0.8D, client.field302?64:128);
                        class91.method2173(var24);
                        class91.method2174(0.8D);
                        class31.field744 = "Loaded textures";
                        class31.field746 = 90;
                        client.field324 = 110;
                     }
                  } else if(110 == client.field324) {
                     class121.field2008 = new class13();
                     class107.field1874.method2991(class121.field2008, 10);
                     class31.field744 = "Loaded input handler";
                     class31.field746 = 94;
                     client.field324 = 120;
                  } else if(120 == client.field324) {
                     if(!class48.field1089.method3380("huffman", "")) {
                        class31.field744 = "Loading wordpack - " + 0 + "%";
                        class31.field746 = 96;
                     } else {
                        class113 var23 = new class113(class48.field1089.method3391("huffman", ""));
                        class129.field2055 = var23;
                        class31.field744 = "Loaded wordpack";
                        class31.field746 = 96;
                        client.field324 = 130;
                     }
                  } else if(client.field324 == 130) {
                     if(!class181.field2943.method3366()) {
                        class31.field744 = "Loading interfaces - " + class181.field2943.method3447() * 4 / 5 + "%";
                        class31.field746 = 100;
                     } else if(!class211.field3137.method3366()) {
                        class31.field744 = "Loading interfaces - " + (80 + class211.field3137.method3447() / 6) + "%";
                        class31.field746 = 100;
                     } else if(!class14.field219.method3366()) {
                        class31.field744 = "Loading interfaces - " + (96 + class14.field219.method3447() / 20) + "%";
                        class31.field746 = 100;
                     } else {
                        class31.field744 = "Loaded interfaces";
                        class31.field746 = 100;
                        client.field324 = 140;
                     }
                  } else if(client.field324 == 140) {
                     class3.method49(10);
                  }
               } else {
                  var0 = 0;
                  class78 var1;
                  if(class87.field1539 == null) {
                     var2 = class103.field1768;
                     var3 = var2.method3377("compass");
                     var4 = var2.method3378(var3, "");
                     var1 = class152.method3246(var2, var3, var4);
                     class87.field1539 = var1;
                  } else {
                     ++var0;
                  }

                  if(null == class17.field268) {
                     var2 = class103.field1768;
                     var3 = var2.method3377("mapedge");
                     var4 = var2.method3378(var3, "");
                     var1 = class152.method3246(var2, var3, var4);
                     class17.field268 = var1;
                  } else {
                     ++var0;
                  }

                  if(class165.field2655 == null) {
                     class165.field2655 = class84.method1995(class103.field1768, "mapscene", "");
                  } else {
                     ++var0;
                  }

                  if(null == class122.field2014) {
                     class122.field2014 = class18.method227(class103.field1768, "mapfunction", "");
                  } else {
                     ++var0;
                  }

                  if(class4.field75 == null) {
                     class4.field75 = class18.method227(class103.field1768, "hitmarks", "");
                  } else {
                     ++var0;
                  }

                  if(class0.field13 == null) {
                     class0.field13 = class18.method227(class103.field1768, "headicons_pk", "");
                  } else {
                     ++var0;
                  }

                  if(class174.field2895 == null) {
                     class174.field2895 = class18.method227(class103.field1768, "headicons_prayer", "");
                  } else {
                     ++var0;
                  }

                  if(class127.field2044 == null) {
                     class127.field2044 = class18.method227(class103.field1768, "headicons_hint", "");
                  } else {
                     ++var0;
                  }

                  if(class107.field1871 == null) {
                     class107.field1871 = class18.method227(class103.field1768, "mapmarker", "");
                  } else {
                     ++var0;
                  }

                  if(null == class138.field2134) {
                     class138.field2134 = class18.method227(class103.field1768, "cross", "");
                  } else {
                     ++var0;
                  }

                  if(null == class139.field2142) {
                     class139.field2142 = class18.method227(class103.field1768, "mapdots", "");
                  } else {
                     ++var0;
                  }

                  if(class163.field2640 == null) {
                     class163.field2640 = class84.method1995(class103.field1768, "scrollbar", "");
                  } else {
                     ++var0;
                  }

                  if(null == class99.field1684) {
                     class99.field1684 = class84.method1995(class103.field1768, "mod_icons", "");
                  } else {
                     ++var0;
                  }

                  if(var0 < 13) {
                     class31.field744 = "Loading sprites - " + 100 * var0 / 13 + "%";
                     class31.field746 = 70;
                  } else {
                     class223.field3193 = class99.field1684;
                     class17.field268.method1790();
                     var15 = (int)(Math.random() * 21.0D) - 10;
                     var18 = (int)(Math.random() * 21.0D) - 10;
                     var3 = (int)(Math.random() * 21.0D) - 10;
                     var4 = (int)(Math.random() * 41.0D) - 20;

                     for(int var5 = 0; var5 < class122.field2014.length; ++var5) {
                        class122.field2014[var5].method1805(var4 + var15, var18 + var4, var3 + var4);
                     }

                     class165.field2655[0].method1961(var4 + var15, var4 + var18, var4 + var3);
                     class31.field744 = "Loaded sprites";
                     class31.field746 = 70;
                     client.field324 = 90;
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass167;I)V",
      garbageValue = "51246096"
   )
   public static void method196(class167 var0) {
      class219.field3168 = var0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILclass134;Lclass168;S)V",
      garbageValue = "-2693"
   )
   static void method197(int var0, class134 var1, class168 var2) {
      byte[] var3 = null;
      class199 var4 = class170.field2707;
      synchronized(class170.field2707) {
         for(class169 var5 = (class169)class170.field2707.method3926(); var5 != null; var5 = (class169)class170.field2707.method3902()) {
            if(var5.field3125 == (long)var0 && var5.field2699 == var1 && 0 == var5.field2698) {
               var3 = var5.field2695;
               break;
            }
         }
      }

      if(var3 != null) {
         var2.method3444(var1, var0, var3, true);
      } else {
         byte[] var8 = var1.method2979(var0);
         var2.method3444(var1, var0, var8, true);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)Ljava/lang/String;",
      garbageValue = "68"
   )
   public static String method199(CharSequence var0) {
      return class76.method1764('*', var0.length());
   }
}
