import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fi")
public class class175 extends class204 {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1157264487
   )
   public final int field2888;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1170464861
   )
   public final int field2889;
   @ObfuscatedName("il")
   static class173 field2890;
   @ObfuscatedName("d")
   public final int[] field2891;
   @ObfuscatedName("j")
   public final int[] field2892;

   class175(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2888 = var1;
      this.field2889 = var2;
      this.field2892 = var3;
      this.field2891 = var4;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1441108912"
   )
   public boolean method3452(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2891.length) {
         int var3 = this.field2891[var2];
         if(var1 >= var3 && var1 <= this.field2892[var2] + var3) {
            return true;
         }
      }

      return false;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "4"
   )
   static void method3453() {
      int var0;
      if(client.field314 == 0) {
         class150.field2230 = new class86(4, 104, 104, class5.field83);

         for(var0 = 0; var0 < 4; ++var0) {
            client.field291[var0] = new class108(104, 104);
         }

         class44.field1017 = new class78(512, 512);
         class31.field709 = "Starting game engine...";
         class31.field700 = 5;
         client.field314 = 20;
      } else {
         int var1;
         int var2;
         int var3;
         int var4;
         if(client.field314 == 20) {
            int[] var28 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = 15 + 32 * var1 + 128;
               var3 = 600 + 3 * var2;
               var4 = class91.field1563[var2];
               var28[var1] = var3 * var4 >> 16;
            }

            class86.method1992(var28, 500, 800, 512, 334);
            class31.field709 = "Prepared visibility map";
            class31.field700 = 10;
            client.field314 = 30;
         } else if(client.field314 == 30) {
            client.field317 = class141.method3010(0, false, true, true);
            class8.field137 = class141.method3010(1, false, true, true);
            class144.field2185 = class141.method3010(2, true, false, true);
            class50.field1071 = class141.method3010(3, false, true, true);
            client.field466 = class141.method3010(4, false, true, true);
            class35.field771 = class141.method3010(5, true, true, true);
            client.field358 = class141.method3010(6, true, true, false);
            class21.field583 = class141.method3010(7, false, true, true);
            class129.field2038 = class141.method3010(8, false, true, true);
            class168.field2692 = class141.method3010(9, false, true, true);
            class12.field186 = class141.method3010(10, false, true, true);
            class84.field1422 = class141.method3010(11, false, true, true);
            class172.field2735 = class141.method3010(12, false, true, true);
            class43.field995 = class141.method3010(13, true, false, true);
            class135.field2069 = class141.method3010(14, false, true, false);
            class104.field1778 = class141.method3010(15, false, true, true);
            class31.field709 = "Connecting to update server";
            class31.field700 = 20;
            client.field314 = 40;
         } else if(client.field314 == 40) {
            byte var24 = 0;
            var0 = var24 + client.field317.method3347() * 4 / 100;
            var0 += class8.field137.method3347() * 4 / 100;
            var0 += class144.field2185.method3347() * 2 / 100;
            var0 += class50.field1071.method3347() * 2 / 100;
            var0 += client.field466.method3347() * 6 / 100;
            var0 += class35.field771.method3347() * 4 / 100;
            var0 += client.field358.method3347() * 2 / 100;
            var0 += class21.field583.method3347() * 60 / 100;
            var0 += class129.field2038.method3347() * 2 / 100;
            var0 += class168.field2692.method3347() * 2 / 100;
            var0 += class12.field186.method3347() * 2 / 100;
            var0 += class84.field1422.method3347() * 2 / 100;
            var0 += class172.field2735.method3347() * 2 / 100;
            var0 += class43.field995.method3347() * 2 / 100;
            var0 += class135.field2069.method3347() * 2 / 100;
            var0 += class104.field1778.method3347() * 2 / 100;
            if(var0 != 100) {
               if(var0 != 0) {
                  class31.field709 = "Checking for updates - " + var0 + "%";
               }

               class31.field700 = 30;
            } else {
               class31.field709 = "Loaded update list";
               class31.field700 = 30;
               client.field314 = 45;
            }
         } else {
            class168 var17;
            class168 var18;
            class168 var29;
            if(client.field314 == 45) {
               class17.method179(22050, !client.field383, 2);
               class184 var27 = new class184();
               var27.method3694(9, 128);
               class93.field1572 = class31.method669(class40.field924, class46.field1040, 0, 22050);
               class93.field1572.method1171(var27);
               var29 = class104.field1778;
               var17 = class135.field2069;
               var18 = client.field466;
               class183.field2958 = var29;
               class183.field2950 = var17;
               class183.field2957 = var18;
               class183.field2952 = var27;
               class50.field1074 = class31.method669(class40.field924, class46.field1040, 1, 2048);
               class52.field1134 = new class55();
               class50.field1074.method1171(class52.field1134);
               class95.field1589 = new class74(22050, class56.field1153);
               class31.field709 = "Prepared sound engine";
               class31.field700 = 35;
               client.field314 = 50;
            } else {
               int var5;
               if(client.field314 == 50) {
                  var0 = 0;
                  class224 var6;
                  if(class43.field986 == null) {
                     var17 = class129.field2038;
                     var18 = class43.field995;
                     var4 = var17.method3281("p11_full");
                     var5 = var17.method3282(var4, "");
                     if(!class38.method766(var17, var4, var5)) {
                        var6 = null;
                     } else {
                        var6 = class150.method3150(var18.method3266(var4, var5));
                     }

                     class43.field986 = var6;
                  } else {
                     ++var0;
                  }

                  if(class44.field1021 == null) {
                     var17 = class129.field2038;
                     var18 = class43.field995;
                     var4 = var17.method3281("p12_full");
                     var5 = var17.method3282(var4, "");
                     if(!class38.method766(var17, var4, var5)) {
                        var6 = null;
                     } else {
                        var6 = class150.method3150(var18.method3266(var4, var5));
                     }

                     class44.field1021 = var6;
                  } else {
                     ++var0;
                  }

                  if(class162.field2636 == null) {
                     var17 = class129.field2038;
                     var18 = class43.field995;
                     var4 = var17.method3281("b12_full");
                     var5 = var17.method3282(var4, "");
                     if(!class38.method766(var17, var4, var5)) {
                        var6 = null;
                     } else {
                        var6 = class150.method3150(var18.method3266(var4, var5));
                     }

                     class162.field2636 = var6;
                  } else {
                     ++var0;
                  }

                  if(var0 < 3) {
                     class31.field709 = "Loading fonts - " + var0 * 100 / 3 + "%";
                     class31.field700 = 40;
                  } else {
                     class102.field1742 = new class160(true);
                     class31.field709 = "Loaded fonts";
                     class31.field700 = 40;
                     client.field314 = 60;
                  }
               } else if(client.field314 == 60) {
                  var0 = class6.method89(class12.field186, class129.field2038);
                  var1 = class138.method2962();
                  if(var0 < var1) {
                     class31.field709 = "Loading title screen - " + 100 * var0 / var1 + "%";
                     class31.field700 = 50;
                  } else {
                     class31.field709 = "Loaded title screen";
                     class31.field700 = 50;
                     class43.method919(5);
                     client.field314 = 70;
                  }
               } else if(client.field314 == 70) {
                  if(!class144.field2185.method3270()) {
                     class31.field709 = "Loading config - " + class144.field2185.method3355() + "%";
                     class31.field700 = 60;
                  } else {
                     class12.method149(class144.field2185);
                     class168 var26 = class144.field2185;
                     class124.field2022 = var26;
                     class75.method1656(class144.field2185, class21.field583);
                     var29 = class144.field2185;
                     var17 = class21.field583;
                     boolean var23 = client.field383;
                     class40.field900 = var29;
                     class40.field916 = var17;
                     class40.field912 = var23;
                     client.method547(class144.field2185, class21.field583);
                     class168 var21 = class144.field2185;
                     class168 var22 = class21.field583;
                     boolean var19 = client.field290;
                     class224 var7 = class43.field986;
                     class34.field761 = var21;
                     class50.field1073 = var22;
                     class10.field157 = var19;
                     class51.field1078 = class34.field761.method3276(10);
                     class51.field1124 = var7;
                     class168 var8 = class144.field2185;
                     class168 var9 = client.field317;
                     class168 var10 = class8.field137;
                     class42.field969 = var8;
                     class42.field962 = var9;
                     class42.field963 = var10;
                     class168 var11 = class144.field2185;
                     class168 var12 = class21.field583;
                     class43.field1001 = var11;
                     class43.field985 = var12;
                     class168 var13 = class144.field2185;
                     class47.field1044 = var13;
                     class168 var14 = class144.field2185;
                     class52.field1131 = var14;
                     class52.field1129 = class52.field1131.method3276(16);
                     class157.method3179(class50.field1071, class21.field583, class129.field2038, class43.field995);
                     class167.method3333(class144.field2185);
                     class168 var15 = class144.field2185;
                     class48.field1053 = var15;
                     class82.method1892(class144.field2185);
                     class37.method756(class144.field2185);
                     class139.field2124 = new class19();
                     class31.field709 = "Loaded config";
                     class31.field700 = 60;
                     client.field314 = 80;
                  }
               } else if(client.field314 != 80) {
                  if(client.field314 == 90) {
                     if(!class168.field2692.method3270()) {
                        class31.field709 = "Loading textures - " + class168.field2692.method3355() + "%";
                        class31.field700 = 90;
                     } else {
                        class95 var25 = new class95(class168.field2692, class129.field2038, 20, 0.8D, client.field383?64:128);
                        class91.method2097(var25);
                        class91.method2093(0.8D);
                        class31.field709 = "Loaded textures";
                        class31.field700 = 90;
                        client.field314 = 110;
                     }
                  } else if(client.field314 == 110) {
                     class12.field182 = new class13();
                     class40.field924.method2917(class12.field182, 10);
                     class31.field709 = "Loaded input handler";
                     class31.field700 = 94;
                     client.field314 = 120;
                  } else if(client.field314 == 120) {
                     if(!class12.field186.method3341("huffman", "")) {
                        class31.field709 = "Loading wordpack - " + 0 + "%";
                        class31.field700 = 96;
                     } else {
                        class113 var16 = new class113(class12.field186.method3294("huffman", ""));
                        class209.field3118 = var16;
                        class31.field709 = "Loaded wordpack";
                        class31.field700 = 96;
                        client.field314 = 130;
                     }
                  } else if(client.field314 == 130) {
                     if(!class50.field1071.method3270()) {
                        class31.field709 = "Loading interfaces - " + class50.field1071.method3355() * 4 / 5 + "%";
                        class31.field700 = 100;
                     } else if(!class172.field2735.method3270()) {
                        class31.field709 = "Loading interfaces - " + (80 + class172.field2735.method3355() / 6) + "%";
                        class31.field700 = 100;
                     } else if(!class43.field995.method3270()) {
                        class31.field709 = "Loading interfaces - " + (96 + class43.field995.method3355() / 20) + "%";
                        class31.field700 = 100;
                     } else {
                        class31.field709 = "Loaded interfaces";
                        class31.field700 = 100;
                        client.field314 = 140;
                     }
                  } else if(client.field314 == 140) {
                     class43.method919(10);
                  }
               } else {
                  var0 = 0;
                  class78 var20;
                  if(class153.field2263 == null) {
                     var17 = class129.field2038;
                     var3 = var17.method3281("compass");
                     var4 = var17.method3282(var3, "");
                     var20 = class143.method3022(var17, var3, var4);
                     class153.field2263 = var20;
                  } else {
                     ++var0;
                  }

                  if(null == class165.field2656) {
                     var17 = class129.field2038;
                     var3 = var17.method3281("mapedge");
                     var4 = var17.method3282(var3, "");
                     var20 = class143.method3022(var17, var3, var4);
                     class165.field2656 = var20;
                  } else {
                     ++var0;
                  }

                  if(class136.field2073 == null) {
                     class136.field2073 = class20.method554(class129.field2038, "mapscene", "");
                  } else {
                     ++var0;
                  }

                  if(null == class26.field663) {
                     class26.field663 = class46.method960(class129.field2038, "mapfunction", "");
                  } else {
                     ++var0;
                  }

                  if(class154.field2279 == null) {
                     class154.field2279 = class46.method960(class129.field2038, "hitmarks", "");
                  } else {
                     ++var0;
                  }

                  if(null == class161.field2632) {
                     class161.field2632 = class46.method960(class129.field2038, "headicons_pk", "");
                  } else {
                     ++var0;
                  }

                  if(class113.field1946 == null) {
                     class113.field1946 = class46.method960(class129.field2038, "headicons_prayer", "");
                  } else {
                     ++var0;
                  }

                  if(null == class110.field1933) {
                     class110.field1933 = class46.method960(class129.field2038, "headicons_hint", "");
                  } else {
                     ++var0;
                  }

                  if(null == class216.field3158) {
                     class216.field3158 = class46.method960(class129.field2038, "mapmarker", "");
                  } else {
                     ++var0;
                  }

                  if(class110.field1918 == null) {
                     class110.field1918 = class46.method960(class129.field2038, "cross", "");
                  } else {
                     ++var0;
                  }

                  if(class221.field3180 == null) {
                     class221.field3180 = class46.method960(class129.field2038, "mapdots", "");
                  } else {
                     ++var0;
                  }

                  if(class177.field2905 == null) {
                     class177.field2905 = class20.method554(class129.field2038, "scrollbar", "");
                  } else {
                     ++var0;
                  }

                  if(class5.field84 == null) {
                     class5.field84 = class20.method554(class129.field2038, "mod_icons", "");
                  } else {
                     ++var0;
                  }

                  if(var0 < 13) {
                     class31.field709 = "Loading sprites - " + var0 * 100 / 13 + "%";
                     class31.field700 = 70;
                  } else {
                     class223.field3196 = class5.field84;
                     class165.field2656.method1705();
                     var1 = (int)(Math.random() * 21.0D) - 10;
                     var2 = (int)(Math.random() * 21.0D) - 10;
                     var3 = (int)(Math.random() * 21.0D) - 10;
                     var4 = (int)(Math.random() * 41.0D) - 20;

                     for(var5 = 0; var5 < class26.field663.length; ++var5) {
                        class26.field663[var5].method1706(var4 + var1, var2 + var4, var3 + var4);
                     }

                     class136.field2073[0].method1866(var4 + var1, var2 + var4, var3 + var4);
                     class31.field709 = "Loaded sprites";
                     class31.field700 = 70;
                     client.field314 = 90;
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)Ljava/lang/String;",
      garbageValue = "-351105800"
   )
   public static String method3455(class119 var0, int var1) {
      try {
         int var2 = var0.method2642();
         if(var2 > var1) {
            var2 = var1;
         }

         byte[] var3 = new byte[var2];
         var0.field1976 += class209.field3118.method2448(var0.field1982, var0.field1976, var3, 0, var2);
         String var4 = class113.method2444(var3, 0, var2);
         return var4;
      } catch (Exception var6) {
         return "Cabbage";
      }
   }
}
