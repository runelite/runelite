package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("af")
public class class48 extends class203 {
   @ObfuscatedName("i")
   public int[] field1059;
   @ObfuscatedName("k")
   public String[] field1060;
   @ObfuscatedName("f")
   public char field1061;
   @ObfuscatedName("l")
   public char field1062;
   @ObfuscatedName("u")
   public String field1064 = "null";
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -249506521
   )
   public int field1065 = 0;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1428131783
   )
   public int field1066;
   @ObfuscatedName("t")
   public int[] field1067;
   @ObfuscatedName("m")
   public static class192 field1068 = new class192(64);
   @ObfuscatedName("j")
   public static class166 field1069;
   @ObfuscatedName("ky")
   @ObfuscatedGetter(
      intValue = -955686883
   )
   static int field1070;
   @ObfuscatedName("bq")
   static class167 field1071;

   @ObfuscatedName("f")
   void method1027(class118 var1, int var2) {
      if(var2 == 1) {
         this.field1061 = (char)var1.method2536();
      } else if(var2 == 2) {
         this.field1062 = (char)var1.method2536();
      } else if(var2 == 3) {
         this.field1064 = var1.method2544();
      } else if(4 == var2) {
         this.field1066 = var1.method2541();
      } else {
         int var3;
         if(var2 == 5) {
            this.field1065 = var1.method2538();
            this.field1059 = new int[this.field1065];
            this.field1060 = new String[this.field1065];

            for(var3 = 0; var3 < this.field1065; ++var3) {
               this.field1059[var3] = var1.method2541();
               this.field1060[var3] = var1.method2544();
            }
         } else if(var2 == 6) {
            this.field1065 = var1.method2538();
            this.field1059 = new int[this.field1065];
            this.field1067 = new int[this.field1065];

            for(var3 = 0; var3 < this.field1065; ++var3) {
               this.field1059[var3] = var1.method2541();
               this.field1067[var3] = var1.method2541();
            }
         }
      }

   }

   @ObfuscatedName("m")
   public void method1028(class118 var1) {
      while(true) {
         int var2 = var1.method2536();
         if(var2 == 0) {
            return;
         }

         this.method1027(var1, var2);
      }
   }

   @ObfuscatedName("e")
   static void method1035() {
      int var0;
      if(client.field321 == 0) {
         class24.field610 = new class85(4, 104, 104, class5.field79);

         for(var0 = 0; var0 < 4; ++var0) {
            client.field335[var0] = new class107(104, 104);
         }

         class97.field1655 = new class78(512, 512);
         class31.field700 = "Starting game engine...";
         class31.field707 = 5;
         client.field321 = 20;
      } else {
         int var1;
         int var2;
         int var3;
         int var4;
         if(20 == client.field321) {
            int[] var22 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = var1 * 32 + 128 + 15;
               var3 = var2 * 3 + 600;
               var4 = class90.field1571[var2];
               var22[var1] = var4 * var3 >> 16;
            }

            class85.method2030(var22, 500, 800, 512, 334);
            class31.field700 = "Prepared visibility map";
            class31.field707 = 10;
            client.field321 = 30;
         } else if(client.field321 == 30) {
            class44.field1019 = class180.method3587(0, false, true, true);
            class92.field1579 = class180.method3587(1, false, true, true);
            class50.field1087 = class180.method3587(2, true, false, true);
            class180.field2917 = class180.method3587(3, false, true, true);
            class158.field2583 = class180.method3587(4, false, true, true);
            class12.field185 = class180.method3587(5, true, true, true);
            class142.field2165 = class180.method3587(6, true, true, false);
            class152.field2268 = class180.method3587(7, false, true, true);
            class4.field70 = class180.method3587(8, false, true, true);
            class22.field586 = class180.method3587(9, false, true, true);
            field1071 = class180.method3587(10, false, true, true);
            class118.field1985 = class180.method3587(11, false, true, true);
            class5.field90 = class180.method3587(12, false, true, true);
            class7.field131 = class180.method3587(13, true, false, true);
            class153.field2278 = class180.method3587(14, false, true, false);
            class75.field1364 = class180.method3587(15, false, true, true);
            class31.field700 = "Connecting to update server";
            class31.field707 = 20;
            client.field321 = 40;
         } else if(client.field321 == 40) {
            byte var21 = 0;
            var0 = var21 + class44.field1019.method3401() * 4 / 100;
            var0 += class92.field1579.method3401() * 4 / 100;
            var0 += class50.field1087.method3401() * 2 / 100;
            var0 += class180.field2917.method3401() * 2 / 100;
            var0 += class158.field2583.method3401() * 6 / 100;
            var0 += class12.field185.method3401() * 4 / 100;
            var0 += class142.field2165.method3401() * 2 / 100;
            var0 += class152.field2268.method3401() * 60 / 100;
            var0 += class4.field70.method3401() * 2 / 100;
            var0 += class22.field586.method3401() * 2 / 100;
            var0 += field1071.method3401() * 2 / 100;
            var0 += class118.field1985.method3401() * 2 / 100;
            var0 += class5.field90.method3401() * 2 / 100;
            var0 += class7.field131.method3401() * 2 / 100;
            var0 += class153.field2278.method3401() * 2 / 100;
            var0 += class75.field1364.method3401() * 2 / 100;
            if(100 != var0) {
               if(0 != var0) {
                  class31.field700 = "Checking for updates - " + var0 + "%";
               }

               class31.field707 = 30;
            } else {
               class31.field700 = "Loaded update list";
               class31.field707 = 30;
               client.field321 = 45;
            }
         } else {
            class167 var12;
            class167 var13;
            if(client.field321 == 45) {
               boolean var20 = !client.field527;
               class56.field1183 = 22050;
               class228.field3215 = var20;
               class56.field1162 = 2;
               class183 var11 = new class183();
               var11.method3660(9, 128);
               class15.field212 = class36.method788(class25.field630, 0, 22050);
               class15.field212.method1217(var11);
               var12 = class75.field1364;
               var13 = class153.field2278;
               class167 var15 = class158.field2583;
               class182.field2939 = var12;
               class182.field2937 = var13;
               class182.field2938 = var15;
               class182.field2943 = var11;
               class29.field675 = class36.method788(class25.field630, 1, 2048);
               class16.field235 = new class55();
               class29.field675.method1217(class16.field235);
               class103.field1774 = new class74(22050, class56.field1183);
               class31.field700 = "Prepared sound engine";
               class31.field707 = 35;
               client.field321 = 50;
            } else if(client.field321 == 50) {
               var0 = 0;
               if(null == class88.field1532) {
                  class88.field1532 = class105.method2415(class4.field70, class7.field131, "p11_full", "");
               } else {
                  ++var0;
               }

               if(class8.field139 == null) {
                  class8.field139 = class105.method2415(class4.field70, class7.field131, "p12_full", "");
               } else {
                  ++var0;
               }

               if(class143.field2174 == null) {
                  class143.field2174 = class105.method2415(class4.field70, class7.field131, "b12_full", "");
               } else {
                  ++var0;
               }

               if(var0 < 3) {
                  class31.field700 = "Loading fonts - " + var0 * 100 / 3 + "%";
                  class31.field707 = 40;
               } else {
                  class125.field2029 = new class159(true);
                  class31.field700 = "Loaded fonts";
                  class31.field707 = 40;
                  client.field321 = 60;
               }
            } else if(60 == client.field321) {
               var0 = class9.method151(field1071, class4.field70);
               var1 = class43.method955();
               if(var0 < var1) {
                  class31.field700 = "Loading title screen - " + var0 * 100 / var1 + "%";
                  class31.field707 = 50;
               } else {
                  class31.field700 = "Loaded title screen";
                  class31.field707 = 50;
                  class31.method714(5);
                  client.field321 = 70;
               }
            } else if(70 == client.field321) {
               if(!class50.field1087.method3316()) {
                  class31.field700 = "Loading config - " + class50.field1087.method3409() + "%";
                  class31.field707 = 60;
               } else {
                  class109.method2452(class50.field1087);
                  class26.method677(class50.field1087);
                  class167 var19 = class50.field1087;
                  class167 var10 = class152.field2268;
                  class44.field1012 = var19;
                  class44.field1009 = var10;
                  class44.field1008 = class44.field1012.method3322(3);
                  var12 = class50.field1087;
                  var13 = class152.field2268;
                  boolean var14 = client.field527;
                  class42.field990 = var12;
                  class228.field3213 = var13;
                  class40.field924 = var14;
                  class105.method2411(class50.field1087, class152.field2268);
                  class98.method2217(class50.field1087, class152.field2268, client.field281, class88.field1532);
                  class7.method122(class50.field1087, class44.field1019, class92.field1579);
                  class167 var16 = class50.field1087;
                  class167 var6 = class152.field2268;
                  class43.field991 = var16;
                  class43.field1000 = var6;
                  class167 var7 = class50.field1087;
                  class47.field1046 = var7;
                  class89.method2101(class50.field1087);
                  class103.method2324(class180.field2917, class152.field2268, class4.field70, class7.field131);
                  class167 var8 = class50.field1087;
                  class50.field1081 = var8;
                  class115.method2476(class50.field1087);
                  class167 var9 = class50.field1087;
                  class45.field1027 = var9;
                  class76.method1698(class50.field1087);
                  class83.field1439 = new class19();
                  class31.field700 = "Loaded config";
                  class31.field707 = 60;
                  client.field321 = 80;
               }
            } else if(80 != client.field321) {
               if(90 == client.field321) {
                  if(!class22.field586.method3316()) {
                     class31.field700 = "Loading textures - " + class22.field586.method3409() + "%";
                     class31.field707 = 90;
                  } else {
                     class94 var18 = new class94(class22.field586, class4.field70, 20, 0.8D, client.field527?64:128);
                     class90.method2157(var18);
                     class90.method2150(0.8D);
                     class31.field700 = "Loaded textures";
                     class31.field707 = 90;
                     client.field321 = 110;
                  }
               } else if(110 == client.field321) {
                  class161.field2632 = new class13();
                  class25.field630.method2919(class161.field2632, 10);
                  class31.field700 = "Loaded input handler";
                  class31.field707 = 94;
                  client.field321 = 120;
               } else if(120 == client.field321) {
                  if(!field1071.method3330("huffman", "")) {
                     class31.field700 = "Loading wordpack - " + 0 + "%";
                     class31.field707 = 96;
                  } else {
                     class112 var17 = new class112(field1071.method3329("huffman", ""));
                     class108.method2451(var17);
                     class31.field700 = "Loaded wordpack";
                     class31.field707 = 96;
                     client.field321 = 130;
                  }
               } else if(client.field321 == 130) {
                  if(!class180.field2917.method3316()) {
                     class31.field700 = "Loading interfaces - " + class180.field2917.method3409() * 4 / 5 + "%";
                     class31.field707 = 100;
                  } else if(!class5.field90.method3316()) {
                     class31.field700 = "Loading interfaces - " + (80 + class5.field90.method3409() / 6) + "%";
                     class31.field707 = 100;
                  } else if(!class7.field131.method3316()) {
                     class31.field700 = "Loading interfaces - " + (96 + class7.field131.method3409() / 20) + "%";
                     class31.field707 = 100;
                  } else {
                     class31.field700 = "Loaded interfaces";
                     class31.field707 = 100;
                     client.field321 = 140;
                  }
               } else if(client.field321 == 140) {
                  class31.method714(10);
               }
            } else {
               var0 = 0;
               if(class20.field563 == null) {
                  class20.field563 = class20.method594(class4.field70, "compass", "");
               } else {
                  ++var0;
               }

               if(class23.field601 == null) {
                  class23.field601 = class20.method594(class4.field70, "mapedge", "");
               } else {
                  ++var0;
               }

               if(class118.field1986 == null) {
                  class118.field1986 = class41.method896(class4.field70, "mapscene", "");
               } else {
                  ++var0;
               }

               if(null == class13.field192) {
                  class13.field192 = class36.method780(class4.field70, "mapfunction", "");
               } else {
                  ++var0;
               }

               if(null == class13.field193) {
                  class13.field193 = class36.method780(class4.field70, "hitmarks", "");
               } else {
                  ++var0;
               }

               if(class76.field1372 == null) {
                  class76.field1372 = class36.method780(class4.field70, "headicons_pk", "");
               } else {
                  ++var0;
               }

               if(null == class149.field2236) {
                  class149.field2236 = class36.method780(class4.field70, "headicons_prayer", "");
               } else {
                  ++var0;
               }

               if(null == client.field342) {
                  client.field342 = class36.method780(class4.field70, "headicons_hint", "");
               } else {
                  ++var0;
               }

               if(null == client.field353) {
                  client.field353 = class36.method780(class4.field70, "mapmarker", "");
               } else {
                  ++var0;
               }

               if(class115.field1965 == null) {
                  class115.field1965 = class36.method780(class4.field70, "cross", "");
               } else {
                  ++var0;
               }

               if(class10.field155 == null) {
                  class10.field155 = class36.method780(class4.field70, "mapdots", "");
               } else {
                  ++var0;
               }

               if(null == class182.field2941) {
                  class182.field2941 = class41.method896(class4.field70, "scrollbar", "");
               } else {
                  ++var0;
               }

               if(class34.field760 == null) {
                  class34.field760 = class41.method896(class4.field70, "mod_icons", "");
               } else {
                  ++var0;
               }

               if(var0 < 13) {
                  class31.field700 = "Loading sprites - " + var0 * 100 / 13 + "%";
                  class31.field707 = 70;
               } else {
                  class222.field3185 = class34.field760;
                  class23.field601.method1722();
                  var1 = (int)(Math.random() * 21.0D) - 10;
                  var2 = (int)(Math.random() * 21.0D) - 10;
                  var3 = (int)(Math.random() * 21.0D) - 10;
                  var4 = (int)(Math.random() * 41.0D) - 20;

                  for(int var5 = 0; var5 < class13.field192.length; ++var5) {
                     class13.field192[var5].method1808(var4 + var1, var4 + var2, var3 + var4);
                  }

                  class118.field1986[0].method1880(var4 + var1, var4 + var2, var4 + var3);
                  class31.field700 = "Loaded sprites";
                  class31.field707 = 70;
                  client.field321 = 90;
               }
            }
         }
      }
   }

   @ObfuscatedName("m")
   public static class172 method1036(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if(class172.field2857[var1] == null || null == class172.field2857[var1][var2]) {
         boolean var3 = class167.method3400(var1);
         if(!var3) {
            return null;
         }
      }

      return class172.field2857[var1][var2];
   }

   @ObfuscatedName("a")
   static final void method1037(class121 var0) {
      for(int var1 = 0; var1 < class32.field740; ++var1) {
         int var2 = class32.field741[var1];
         class2 var3 = client.field397[var2];
         int var4 = var0.method2536();
         if((var4 & 32) != 0) {
            var4 += var0.method2536() << 8;
         }

         class1.method11(var0, var2, var3, var4);
      }

   }
}
