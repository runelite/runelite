import java.io.IOException;
import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gv")
public class class185 {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1719042035
   )
   public static int field2745 = 0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1322479331
   )
   public static int field2746 = 0;
   @ObfuscatedName("k")
   public static XHashTable field2747 = new XHashTable(4096);
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1128438565
   )
   public static int field2748 = 0;
   @ObfuscatedName("n")
   public static XHashTable field2749 = new XHashTable(32);
   @ObfuscatedName("i")
   public static class110 field2750;
   @ObfuscatedName("q")
   public static Node2LinkedList field2751 = new Node2LinkedList();
   @ObfuscatedName("m")
   public static Buffer field2752 = new Buffer(8);
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -67135991
   )
   public static int field2753 = 0;
   @ObfuscatedName("h")
   public static XHashTable field2754 = new XHashTable(4096);
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -289163197
   )
   public static int field2755 = 0;
   @ObfuscatedName("l")
   public static boolean field2756;
   @ObfuscatedName("w")
   static XHashTable field2757 = new XHashTable(4096);
   @ObfuscatedName("r")
   public static Buffer field2758;
   @ObfuscatedName("x")
   public static CRC32 field2760 = new CRC32();
   @ObfuscatedName("y")
   public static class184[] field2761 = new class184[256];
   @ObfuscatedName("s")
   public static byte field2762 = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1875862407
   )
   public static int field2763 = 0;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1444535953
   )
   public static int field2764 = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -223550893
   )
   public static int field2765 = 0;

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "1192669544"
   )
   @Export("menuAction")
   static final void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      if(var2 == 18) {
         Client.field395 = var6;
         Client.field396 = var7;
         Client.field398 = 2;
         Client.field397 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field294.method2976(247);
         Client.field294.method2763(class15.baseX + var0);
         Client.field294.method2793(var3);
         Client.field294.method2746(var1 + class20.baseY);
         Client.field294.method2932(class105.field1693[82]?1:0);
      }

      if(var2 == 16) {
         Client.field395 = var6;
         Client.field396 = var7;
         Client.field398 = 2;
         Client.field397 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field294.method2976(225);
         Client.field294.method2935(class105.field1693[82]?1:0);
         Client.field294.method2792(class160.field2132);
         Client.field294.method2763(class20.baseY + var1);
         Client.field294.method2793(var3);
         Client.field294.method2746(class15.baseX + var0);
         Client.field294.method2763(class10.field103);
         Client.field294.method2804(ObjectComposition.field2941);
      }

      NPC var8;
      if(var2 == 9) {
         var8 = Client.cachedNPCs[var3];
         if(var8 != null) {
            Client.field395 = var6;
            Client.field396 = var7;
            Client.field398 = 2;
            Client.field397 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field294.method2976(96);
            Client.field294.method2763(var3);
            Client.field294.method2784(class105.field1693[82]?1:0);
         }
      }

      int var9;
      Widget var19;
      if(var2 == 29) {
         Client.field294.method2976(97);
         Client.field294.method2748(var1);
         var19 = class191.method3433(var1);
         if(null != var19.dynamicValues && var19.dynamicValues[0][0] == 5) {
            var9 = var19.dynamicValues[0][1];
            if(var19.field2322[0] != class165.widgetSettings[var9]) {
               class165.widgetSettings[var9] = var19.field2322[0];
               class47.method835(var9);
            }
         }
      }

      if(var2 == 36) {
         Client.field294.method2976(193);
         Client.field294.method2763(var0);
         Client.field294.method2893(var1);
         Client.field294.method2792(var3);
         Client.field399 = 0;
         class10.field107 = class191.method3433(var1);
         Client.field506 = var0;
      }

      if(var2 == 35) {
         Client.field294.method2976(9);
         Client.field294.method2746(var3);
         Client.field294.method2893(var1);
         Client.field294.method2792(var0);
         Client.field399 = 0;
         class10.field107 = class191.method3433(var1);
         Client.field506 = var0;
      }

      if(var2 == 21) {
         Client.field395 = var6;
         Client.field396 = var7;
         Client.field398 = 2;
         Client.field397 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field294.method2976(113);
         Client.field294.method2793(class15.baseX + var0);
         Client.field294.method2792(var1 + class20.baseY);
         Client.field294.method2746(var3);
         Client.field294.method2935(class105.field1693[82]?1:0);
      }

      if(var2 == 23) {
         Client.region.method1728(class171.plane, var0, var1);
      }

      if(var2 == 25) {
         var19 = class26.method561(var1, var0);
         if(var19 != null) {
            class9.method101();
            var9 = RSCanvas.method2049(class143.method2647(var19));
            int var15 = var19.item;
            Widget var22 = class26.method561(var1, var0);
            if(var22 != null && var22.field2334 != null) {
               class18 var12 = new class18();
               var12.field187 = var22;
               var12.field188 = var22.field2334;
               Ignore.method191(var12);
            }

            Client.field338 = var15;
            Client.field523 = true;
            MessageNode.field232 = var1;
            Client.field442 = var0;
            class187.field2780 = var9;
            class94.method1890(var22);
            Client.field526 = 0;
            Client.field444 = class142.method2644(var19);
            if(null == Client.field444) {
               Client.field444 = "Null";
            }

            if(var19.field2198) {
               Client.field327 = var19.name + class155.method2949(16777215);
            } else {
               Client.field327 = class155.method2949('\uff00') + var19.field2272 + class155.method2949(16777215);
            }
         }

      } else {
         if(var2 == 1004) {
            Client.field395 = var6;
            Client.field396 = var7;
            Client.field398 = 2;
            Client.field397 = 0;
            Client.field294.method2976(209);
            Client.field294.method2792(var3);
         }

         if(var2 == 6) {
            Client.field395 = var6;
            Client.field396 = var7;
            Client.field398 = 2;
            Client.field397 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field294.method2976(34);
            Client.field294.method2746(var3 >> 14 & 32767);
            Client.field294.method2793(var1 + class20.baseY);
            Client.field294.method2784(class105.field1693[82]?1:0);
            Client.field294.method2763(var0 + class15.baseX);
         }

         if(var2 == 7) {
            var8 = Client.cachedNPCs[var3];
            if(null != var8) {
               Client.field395 = var6;
               Client.field396 = var7;
               Client.field398 = 2;
               Client.field397 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field294.method2976(37);
               Client.field294.method2763(var3);
               Client.field294.method2793(class10.field103);
               Client.field294.method2784(class105.field1693[82]?1:0);
               Client.field294.method2748(ObjectComposition.field2941);
               Client.field294.method2793(class160.field2132);
            }
         }

         if(var2 == 34) {
            Client.field294.method2976(136);
            Client.field294.method2746(var0);
            Client.field294.method2793(var3);
            Client.field294.method2748(var1);
            Client.field399 = 0;
            class10.field107 = class191.method3433(var1);
            Client.field506 = var0;
         }

         if(var2 == 1003) {
            Client.field395 = var6;
            Client.field396 = var7;
            Client.field398 = 2;
            Client.field397 = 0;
            var8 = Client.cachedNPCs[var3];
            if(null != var8) {
               NPCComposition var16 = var8.composition;
               if(var16.field3028 != null) {
                  var16 = var16.method3635();
               }

               if(null != var16) {
                  Client.field294.method2976(106);
                  Client.field294.method2763(var16.id);
               }
            }
         }

         if(var2 == 26) {
            CombatInfoListHolder.method674();
         }

         if(var2 == 1001) {
            Client.field395 = var6;
            Client.field396 = var7;
            Client.field398 = 2;
            Client.field397 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field294.method2976(92);
            Client.field294.method2746(var0 + class15.baseX);
            Client.field294.method2792(var3 >> 14 & 32767);
            Client.field294.method2792(var1 + class20.baseY);
            Client.field294.method2932(class105.field1693[82]?1:0);
         }

         if(var2 == 20) {
            Client.field395 = var6;
            Client.field396 = var7;
            Client.field398 = 2;
            Client.field397 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field294.method2976(11);
            Client.field294.method2792(class15.baseX + var0);
            Client.field294.method2792(class20.baseY + var1);
            Client.field294.method2784(class105.field1693[82]?1:0);
            Client.field294.method2793(var3);
         }

         if(var2 == 5) {
            Client.field395 = var6;
            Client.field396 = var7;
            Client.field398 = 2;
            Client.field397 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field294.method2976(158);
            Client.field294.method2792(var3 >> 14 & 32767);
            Client.field294.method2932(class105.field1693[82]?1:0);
            Client.field294.method2746(var1 + class20.baseY);
            Client.field294.method2763(var0 + class15.baseX);
         }

         Player var20;
         if(var2 == 15) {
            var20 = Client.cachedPlayers[var3];
            if(var20 != null) {
               Client.field395 = var6;
               Client.field396 = var7;
               Client.field398 = 2;
               Client.field397 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field294.method2976(222);
               Client.field294.method2935(class105.field1693[82]?1:0);
               Client.field294.method2746(Client.field442);
               Client.field294.method2746(var3);
               Client.field294.method2893(MessageNode.field232);
            }
         }

         if(var2 == 10) {
            var8 = Client.cachedNPCs[var3];
            if(null != var8) {
               Client.field395 = var6;
               Client.field396 = var7;
               Client.field398 = 2;
               Client.field397 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field294.method2976(249);
               Client.field294.method2935(class105.field1693[82]?1:0);
               Client.field294.method2746(var3);
            }
         }

         if(var2 == 37) {
            Client.field294.method2976(33);
            Client.field294.method2793(var0);
            Client.field294.method2804(var1);
            Client.field294.method2792(var3);
            Client.field399 = 0;
            class10.field107 = class191.method3433(var1);
            Client.field506 = var0;
         }

         if(var2 == 1) {
            Client.field395 = var6;
            Client.field396 = var7;
            Client.field398 = 2;
            Client.field397 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field294.method2976(185);
            Client.field294.method2893(ObjectComposition.field2941);
            Client.field294.method2763(class15.baseX + var0);
            Client.field294.method2763(class20.baseY + var1);
            Client.field294.method2784(class105.field1693[82]?1:0);
            Client.field294.method2746(class10.field103);
            Client.field294.method2793(class160.field2132);
            Client.field294.method2793(var3 >> 14 & 32767);
         }

         if(var2 == 12) {
            var8 = Client.cachedNPCs[var3];
            if(null != var8) {
               Client.field395 = var6;
               Client.field396 = var7;
               Client.field398 = 2;
               Client.field397 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field294.method2976(81);
               Client.field294.method2784(class105.field1693[82]?1:0);
               Client.field294.method2763(var3);
            }
         }

         if(var2 == 50) {
            var20 = Client.cachedPlayers[var3];
            if(var20 != null) {
               Client.field395 = var6;
               Client.field396 = var7;
               Client.field398 = 2;
               Client.field397 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field294.method2976(203);
               Client.field294.method2793(var3);
               Client.field294.method2785(class105.field1693[82]?1:0);
            }
         }

         if(var2 == 31) {
            Client.field294.method2976(218);
            Client.field294.method2792(var3);
            Client.field294.method2748(ObjectComposition.field2941);
            Client.field294.method2792(class160.field2132);
            Client.field294.method2763(class10.field103);
            Client.field294.method2748(var1);
            Client.field294.method2793(var0);
            Client.field399 = 0;
            class10.field107 = class191.method3433(var1);
            Client.field506 = var0;
         }

         if(var2 == 49) {
            var20 = Client.cachedPlayers[var3];
            if(null != var20) {
               Client.field395 = var6;
               Client.field396 = var7;
               Client.field398 = 2;
               Client.field397 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field294.method2976(181);
               Client.field294.method2793(var3);
               Client.field294.method2785(class105.field1693[82]?1:0);
            }
         }

         if(var2 == 22) {
            Client.field395 = var6;
            Client.field396 = var7;
            Client.field398 = 2;
            Client.field397 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field294.method2976(215);
            Client.field294.method2784(class105.field1693[82]?1:0);
            Client.field294.method2793(var3);
            Client.field294.method2763(var1 + class20.baseY);
            Client.field294.method2746(var0 + class15.baseX);
         }

         if(var2 == 42) {
            Client.field294.method2976(70);
            Client.field294.method2746(var3);
            Client.field294.method2893(var1);
            Client.field294.method2746(var0);
            Client.field399 = 0;
            class10.field107 = class191.method3433(var1);
            Client.field506 = var0;
         }

         if(var2 == 17) {
            Client.field395 = var6;
            Client.field396 = var7;
            Client.field398 = 2;
            Client.field397 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field294.method2976(71);
            Client.field294.method2793(class20.baseY + var1);
            Client.field294.method2785(class105.field1693[82]?1:0);
            Client.field294.method2792(Client.field442);
            Client.field294.method2792(class15.baseX + var0);
            Client.field294.method2792(var3);
            Client.field294.method2748(MessageNode.field232);
         }

         if(var2 == 47) {
            var20 = Client.cachedPlayers[var3];
            if(var20 != null) {
               Client.field395 = var6;
               Client.field396 = var7;
               Client.field398 = 2;
               Client.field397 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field294.method2976(57);
               Client.field294.method2784(class105.field1693[82]?1:0);
               Client.field294.method2746(var3);
            }
         }

         if(var2 == 14) {
            var20 = Client.cachedPlayers[var3];
            if(var20 != null) {
               Client.field395 = var6;
               Client.field396 = var7;
               Client.field398 = 2;
               Client.field397 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field294.method2976(202);
               Client.field294.method2935(class105.field1693[82]?1:0);
               Client.field294.method2746(class160.field2132);
               Client.field294.method2804(ObjectComposition.field2941);
               Client.field294.method2792(class10.field103);
               Client.field294.method2793(var3);
            }
         }

         if(var2 == 24) {
            var19 = class191.method3433(var1);
            boolean var21 = true;
            if(var19.contentType > 0) {
               var21 = class44.method789(var19);
            }

            if(var21) {
               Client.field294.method2976(97);
               Client.field294.method2748(var1);
            }
         }

         if(var2 == 57 || var2 == 1007) {
            var19 = class26.method561(var1, var0);
            if(var19 != null) {
               var9 = var19.item;
               Widget var10 = class26.method561(var1, var0);
               if(null != var10) {
                  if(var10.field2308 != null) {
                     class18 var11 = new class18();
                     var11.field187 = var10;
                     var11.field198 = var3;
                     var11.field194 = var5;
                     var11.field188 = var10.field2308;
                     Ignore.method191(var11);
                  }

                  boolean var17 = true;
                  if(var10.contentType > 0) {
                     var17 = class44.method789(var10);
                  }

                  if(var17) {
                     int var13 = class143.method2647(var10);
                     int var14 = var3 - 1;
                     boolean var18 = (var13 >> var14 + 1 & 1) != 0;
                     if(var18) {
                        if(var3 == 1) {
                           Client.field294.method2976(48);
                           Client.field294.method2748(var1);
                           Client.field294.method2746(var0);
                           Client.field294.method2746(var9);
                        }

                        if(var3 == 2) {
                           Client.field294.method2976(2);
                           Client.field294.method2748(var1);
                           Client.field294.method2746(var0);
                           Client.field294.method2746(var9);
                        }

                        if(var3 == 3) {
                           Client.field294.method2976(50);
                           Client.field294.method2748(var1);
                           Client.field294.method2746(var0);
                           Client.field294.method2746(var9);
                        }

                        if(var3 == 4) {
                           Client.field294.method2976(155);
                           Client.field294.method2748(var1);
                           Client.field294.method2746(var0);
                           Client.field294.method2746(var9);
                        }

                        if(var3 == 5) {
                           Client.field294.method2976(231);
                           Client.field294.method2748(var1);
                           Client.field294.method2746(var0);
                           Client.field294.method2746(var9);
                        }

                        if(var3 == 6) {
                           Client.field294.method2976(29);
                           Client.field294.method2748(var1);
                           Client.field294.method2746(var0);
                           Client.field294.method2746(var9);
                        }

                        if(var3 == 7) {
                           Client.field294.method2976(84);
                           Client.field294.method2748(var1);
                           Client.field294.method2746(var0);
                           Client.field294.method2746(var9);
                        }

                        if(var3 == 8) {
                           Client.field294.method2976(229);
                           Client.field294.method2748(var1);
                           Client.field294.method2746(var0);
                           Client.field294.method2746(var9);
                        }

                        if(var3 == 9) {
                           Client.field294.method2976(104);
                           Client.field294.method2748(var1);
                           Client.field294.method2746(var0);
                           Client.field294.method2746(var9);
                        }

                        if(var3 == 10) {
                           Client.field294.method2976(128);
                           Client.field294.method2748(var1);
                           Client.field294.method2746(var0);
                           Client.field294.method2746(var9);
                        }
                     }
                  }
               }
            }
         }

         if(var2 == 28) {
            Client.field294.method2976(97);
            Client.field294.method2748(var1);
            var19 = class191.method3433(var1);
            if(null != var19.dynamicValues && var19.dynamicValues[0][0] == 5) {
               var9 = var19.dynamicValues[0][1];
               class165.widgetSettings[var9] = 1 - class165.widgetSettings[var9];
               class47.method835(var9);
            }
         }

         if(var2 == 39) {
            Client.field294.method2976(211);
            Client.field294.method2804(var1);
            Client.field294.method2792(var0);
            Client.field294.method2793(var3);
            Client.field399 = 0;
            class10.field107 = class191.method3433(var1);
            Client.field506 = var0;
         }

         if(var2 == 2) {
            Client.field395 = var6;
            Client.field396 = var7;
            Client.field398 = 2;
            Client.field397 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field294.method2976(131);
            Client.field294.method2793(Client.field442);
            Client.field294.method2793(class15.baseX + var0);
            Client.field294.method2932(class105.field1693[82]?1:0);
            Client.field294.method2793(var1 + class20.baseY);
            Client.field294.method2746(var3 >> 14 & 32767);
            Client.field294.method2802(MessageNode.field232);
         }

         if(var2 == 38) {
            class9.method101();
            var19 = class191.method3433(var1);
            Client.field526 = 1;
            class10.field103 = var0;
            ObjectComposition.field2941 = var1;
            class160.field2132 = var3;
            class94.method1890(var19);
            Client.field375 = class155.method2949(16748608) + class7.getItemDefinition(var3).name + class155.method2949(16777215);
            if(Client.field375 == null) {
               Client.field375 = "null";
            }

         } else {
            if(var2 == 33) {
               Client.field294.method2976(40);
               Client.field294.method2746(var0);
               Client.field294.method2804(var1);
               Client.field294.method2793(var3);
               Client.field399 = 0;
               class10.field107 = class191.method3433(var1);
               Client.field506 = var0;
            }

            if(var2 == 40) {
               Client.field294.method2976(170);
               Client.field294.method2792(var3);
               Client.field294.method2804(var1);
               Client.field294.method2792(var0);
               Client.field399 = 0;
               class10.field107 = class191.method3433(var1);
               Client.field506 = var0;
            }

            if(var2 == 46) {
               var20 = Client.cachedPlayers[var3];
               if(var20 != null) {
                  Client.field395 = var6;
                  Client.field396 = var7;
                  Client.field398 = 2;
                  Client.field397 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field294.method2976(165);
                  Client.field294.method2932(class105.field1693[82]?1:0);
                  Client.field294.method2746(var3);
               }
            }

            if(var2 == 51) {
               var20 = Client.cachedPlayers[var3];
               if(var20 != null) {
                  Client.field395 = var6;
                  Client.field396 = var7;
                  Client.field398 = 2;
                  Client.field397 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field294.method2976(124);
                  Client.field294.method2784(class105.field1693[82]?1:0);
                  Client.field294.method2763(var3);
               }
            }

            if(var2 == 30 && Client.field450 == null) {
               class26.method556(var1, var0);
               Client.field450 = class26.method561(var1, var0);
               class94.method1890(Client.field450);
            }

            if(var2 == 48) {
               var20 = Client.cachedPlayers[var3];
               if(var20 != null) {
                  Client.field395 = var6;
                  Client.field396 = var7;
                  Client.field398 = 2;
                  Client.field397 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field294.method2976(228);
                  Client.field294.method2784(class105.field1693[82]?1:0);
                  Client.field294.method2792(var3);
               }
            }

            if(var2 == 1002) {
               Client.field395 = var6;
               Client.field396 = var7;
               Client.field398 = 2;
               Client.field397 = 0;
               Client.field294.method2976(180);
               Client.field294.method2792(var3 >> 14 & 32767);
            }

            if(var2 == 4) {
               Client.field395 = var6;
               Client.field396 = var7;
               Client.field398 = 2;
               Client.field397 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field294.method2976(10);
               Client.field294.method2746(class20.baseY + var1);
               Client.field294.method2792(var3 >> 14 & 32767);
               Client.field294.method2793(class15.baseX + var0);
               Client.field294.method2932(class105.field1693[82]?1:0);
            }

            if(var2 == 44) {
               var20 = Client.cachedPlayers[var3];
               if(var20 != null) {
                  Client.field395 = var6;
                  Client.field396 = var7;
                  Client.field398 = 2;
                  Client.field397 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field294.method2976(197);
                  Client.field294.method2785(class105.field1693[82]?1:0);
                  Client.field294.method2792(var3);
               }
            }

            if(var2 == 32) {
               Client.field294.method2976(220);
               Client.field294.method2804(var1);
               Client.field294.method2746(Client.field442);
               Client.field294.method2802(MessageNode.field232);
               Client.field294.method2763(var0);
               Client.field294.method2793(var3);
               Client.field399 = 0;
               class10.field107 = class191.method3433(var1);
               Client.field506 = var0;
            }

            if(var2 == 41) {
               Client.field294.method2976(12);
               Client.field294.method2793(var0);
               Client.field294.method2804(var1);
               Client.field294.method2793(var3);
               Client.field399 = 0;
               class10.field107 = class191.method3433(var1);
               Client.field506 = var0;
            }

            if(var2 == 1005) {
               var19 = class191.method3433(var1);
               if(null != var19 && var19.itemQuantities[var0] >= 100000) {
                  ObjectComposition.method3581(27, "", var19.itemQuantities[var0] + " x " + class7.getItemDefinition(var3).name);
               } else {
                  Client.field294.method2976(209);
                  Client.field294.method2792(var3);
               }

               Client.field399 = 0;
               class10.field107 = class191.method3433(var1);
               Client.field506 = var0;
            }

            if(var2 == 3) {
               Client.field395 = var6;
               Client.field396 = var7;
               Client.field398 = 2;
               Client.field397 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field294.method2976(151);
               Client.field294.method2763(var3 >> 14 & 32767);
               Client.field294.method2792(class20.baseY + var1);
               Client.field294.method2746(var0 + class15.baseX);
               Client.field294.method2935(class105.field1693[82]?1:0);
            }

            if(var2 == 43) {
               Client.field294.method2976(44);
               Client.field294.method2804(var1);
               Client.field294.method2746(var3);
               Client.field294.method2792(var0);
               Client.field399 = 0;
               class10.field107 = class191.method3433(var1);
               Client.field506 = var0;
            }

            if(var2 == 8) {
               var8 = Client.cachedNPCs[var3];
               if(null != var8) {
                  Client.field395 = var6;
                  Client.field396 = var7;
                  Client.field398 = 2;
                  Client.field397 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field294.method2976(6);
                  Client.field294.method2793(Client.field442);
                  Client.field294.method2804(MessageNode.field232);
                  Client.field294.method2785(class105.field1693[82]?1:0);
                  Client.field294.method2746(var3);
               }
            }

            if(var2 == 13) {
               var8 = Client.cachedNPCs[var3];
               if(var8 != null) {
                  Client.field395 = var6;
                  Client.field396 = var7;
                  Client.field398 = 2;
                  Client.field397 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field294.method2976(69);
                  Client.field294.method2784(class105.field1693[82]?1:0);
                  Client.field294.method2763(var3);
               }
            }

            if(var2 == 11) {
               var8 = Client.cachedNPCs[var3];
               if(var8 != null) {
                  Client.field395 = var6;
                  Client.field396 = var7;
                  Client.field398 = 2;
                  Client.field397 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field294.method2976(82);
                  Client.field294.method2932(class105.field1693[82]?1:0);
                  Client.field294.method2746(var3);
               }
            }

            if(var2 == 58) {
               var19 = class26.method561(var1, var0);
               if(null != var19) {
                  Client.field294.method2976(226);
                  Client.field294.method2748(var1);
                  Client.field294.method2792(var19.item);
                  Client.field294.method2792(Client.field442);
                  Client.field294.method2763(var0);
                  Client.field294.method2792(Client.field338);
                  Client.field294.method2804(MessageNode.field232);
               }
            }

            if(var2 == 19) {
               Client.field395 = var6;
               Client.field396 = var7;
               Client.field398 = 2;
               Client.field397 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field294.method2976(74);
               Client.field294.method2793(var3);
               Client.field294.method2785(class105.field1693[82]?1:0);
               Client.field294.method2792(var1 + class20.baseY);
               Client.field294.method2792(var0 + class15.baseX);
            }

            if(var2 == 45) {
               var20 = Client.cachedPlayers[var3];
               if(null != var20) {
                  Client.field395 = var6;
                  Client.field396 = var7;
                  Client.field398 = 2;
                  Client.field397 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field294.method2976(42);
                  Client.field294.method2763(var3);
                  Client.field294.method2935(class105.field1693[82]?1:0);
               }
            }

            if(Client.field526 != 0) {
               Client.field526 = 0;
               class94.method1890(class191.method3433(ObjectComposition.field2941));
            }

            if(Client.field523) {
               class9.method101();
            }

            if(null != class10.field107 && Client.field399 == 0) {
               class94.method1890(class10.field107);
            }

         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1841665522"
   )
   public static void method3360(boolean var0) {
      if(field2750 != null) {
         try {
            Buffer var1 = new Buffer(4);
            var1.method2932(var0?2:3);
            var1.method2747(0);
            field2750.method2032(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               field2750.method2035();
            } catch (Exception var3) {
               ;
            }

            ++field2764;
            field2750 = null;
         }

      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2022383972"
   )
   public static void method3361() {
      class225.field3217 = null;
      RSCanvas.field1748 = null;
      class225.field3218 = null;
      Item.field897 = null;
      class167.field2191 = null;
      class154.field2106 = null;
   }
}
