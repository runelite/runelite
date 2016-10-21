import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
public class class38 {
   @ObfuscatedName("v")
   static int[] field799 = new int[5];
   @ObfuscatedName("u")
   static final String[] field800 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
   @ObfuscatedName("t")
   static String[] field801;
   @ObfuscatedName("b")
   static int[][] field802 = new int[5][5000];
   @ObfuscatedName("m")
   static int[] field804 = new int[1000];
   @ObfuscatedName("k")
   @Export("chatboxSegments")
   static String[] chatboxSegments = new String[1000];
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1764907153
   )
   static int field806 = 0;
   @ObfuscatedName("w")
   static class14[] field807 = new class14[50];
   @ObfuscatedName("i")
   static Calendar field808 = Calendar.getInstance();
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1834473405
   )
   static int field810 = 0;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1649838400"
   )
   public static void method754() {
      class48.field1062.reset();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-5615901"
   )
   public static void method762() {
      class43.field975.reset();
   }

   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "622506313"
   )
   @Export("menuAction")
   static final void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      if(var2 == 34) {
         Client.field397.method2768(158);
         Client.field397.method2627(var0);
         Client.field397.method2519(var3);
         Client.field397.method2576(var1);
         Client.field551 = 0;
         class79.field1439 = class153.method3170(var1);
         Client.field394 = var0;
      }

      Player var8;
      if(var2 == 44) {
         var8 = Client.cachedPlayers[var3];
         if(var8 != null) {
            Client.field389 = var6;
            Client.field390 = var7;
            Client.field392 = 2;
            Client.field391 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field397.method2768(28);
            Client.field397.method2627(var3);
            Client.field397.method2557(class140.field2153[82]?1:0);
         }
      }

      if(var2 == 1) {
         Client.field389 = var6;
         Client.field390 = var7;
         Client.field392 = 2;
         Client.field391 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field397.method2768(39);
         Client.field397.method2521(class62.field1263);
         Client.field397.method2559(class140.field2153[82]?1:0);
         Client.field397.method2516(class8.baseY + var1);
         Client.field397.method2516(var3 >> 14 & 32767);
         Client.field397.method2516(class32.baseX + var0);
         Client.field397.method2519(Item.field691);
         Client.field397.method2516(class52.field1128);
      }

      Widget var11;
      if(var2 == 24) {
         var11 = class153.method3170(var1);
         boolean var9 = true;
         if(var11.contentType > 0) {
            var9 = class5.method80(var11);
         }

         if(var9) {
            Client.field397.method2768(239);
            Client.field397.method2521(var1);
         }
      }

      if(var2 == 50) {
         var8 = Client.cachedPlayers[var3];
         if(var8 != null) {
            Client.field389 = var6;
            Client.field390 = var7;
            Client.field392 = 2;
            Client.field391 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field397.method2768(179);
            Client.field397.method2559(class140.field2153[82]?1:0);
            Client.field397.method2627(var3);
         }
      }

      if(var2 == 2) {
         Client.field389 = var6;
         Client.field390 = var7;
         Client.field392 = 2;
         Client.field391 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field397.method2768(147);
         Client.field397.method2567(Client.field344);
         Client.field397.method2519(var0 + class32.baseX);
         Client.field397.method2567(var1 + class8.baseY);
         Client.field397.method2574(class32.field711);
         Client.field397.method2627(var3 >> 14 & 32767);
         Client.field397.method2558(class140.field2153[82]?1:0);
      }

      if(var2 == 19) {
         Client.field389 = var6;
         Client.field390 = var7;
         Client.field392 = 2;
         Client.field391 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field397.method2768(244);
         Client.field397.method2518(class140.field2153[82]?1:0);
         Client.field397.method2627(var3);
         Client.field397.method2627(class8.baseY + var1);
         Client.field397.method2627(var0 + class32.baseX);
      }

      if(var2 == 4) {
         Client.field389 = var6;
         Client.field390 = var7;
         Client.field392 = 2;
         Client.field391 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field397.method2768(138);
         Client.field397.method2627(var0 + class32.baseX);
         Client.field397.method2519(var3 >> 14 & 32767);
         Client.field397.method2558(class140.field2153[82]?1:0);
         Client.field397.method2627(var1 + class8.baseY);
      }

      if(var2 == 49) {
         var8 = Client.cachedPlayers[var3];
         if(null != var8) {
            Client.field389 = var6;
            Client.field390 = var7;
            Client.field392 = 2;
            Client.field391 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field397.method2768(48);
            Client.field397.method2559(class140.field2153[82]?1:0);
            Client.field397.method2519(var3);
         }
      }

      if(var2 == 1005) {
         var11 = class153.method3170(var1);
         if(var11 != null && var11.itemQuantities[var0] >= 100000) {
            class190.sendGameMessage(27, "", var11.itemQuantities[var0] + " x " + class45.getItemDefinition(var3).name);
         } else {
            Client.field397.method2768(94);
            Client.field397.method2567(var3);
         }

         Client.field551 = 0;
         class79.field1439 = class153.method3170(var1);
         Client.field394 = var0;
      }

      if(var2 == 5) {
         Client.field389 = var6;
         Client.field390 = var7;
         Client.field392 = 2;
         Client.field391 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field397.method2768(171);
         Client.field397.method2627(var3 >> 14 & 32767);
         Client.field397.method2567(class32.baseX + var0);
         Client.field397.method2627(var1 + class8.baseY);
         Client.field397.method2557(class140.field2153[82]?1:0);
      }

      if(var2 == 23) {
         class9.region.method2001(XItemContainer.plane, var0, var1);
      }

      NPC var12;
      if(var2 == 1003) {
         Client.field389 = var6;
         Client.field390 = var7;
         Client.field392 = 2;
         Client.field391 = 0;
         var12 = Client.cachedNPCs[var3];
         if(null != var12) {
            NPCComposition var10 = var12.composition;
            if(null != var10.field913) {
               var10 = var10.method798();
            }

            if(null != var10) {
               Client.field397.method2768(141);
               Client.field397.method2516(var10.id);
            }
         }
      }

      if(var2 == 10) {
         var12 = Client.cachedNPCs[var3];
         if(null != var12) {
            Client.field389 = var6;
            Client.field390 = var7;
            Client.field392 = 2;
            Client.field391 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field397.method2768(186);
            Client.field397.method2567(var3);
            Client.field397.method2518(class140.field2153[82]?1:0);
         }
      }

      if(var2 == 39) {
         Client.field397.method2768(91);
         Client.field397.method2516(var0);
         Client.field397.method2521(var1);
         Client.field397.method2516(var3);
         Client.field551 = 0;
         class79.field1439 = class153.method3170(var1);
         Client.field394 = var0;
      }

      int var13;
      if(var2 == 28) {
         Client.field397.method2768(239);
         Client.field397.method2521(var1);
         var11 = class153.method3170(var1);
         if(null != var11.dynamicValues && var11.dynamicValues[0][0] == 5) {
            var13 = var11.dynamicValues[0][1];
            class179.widgetSettings[var13] = 1 - class179.widgetSettings[var13];
            BufferProvider.method1745(var13);
         }
      }

      if(var2 == 51) {
         var8 = Client.cachedPlayers[var3];
         if(null != var8) {
            Client.field389 = var6;
            Client.field390 = var7;
            Client.field392 = 2;
            Client.field391 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field397.method2768(207);
            Client.field397.method2516(var3);
            Client.field397.method2558(class140.field2153[82]?1:0);
         }
      }

      if(var2 == 7) {
         var12 = Client.cachedNPCs[var3];
         if(null != var12) {
            Client.field389 = var6;
            Client.field390 = var7;
            Client.field392 = 2;
            Client.field391 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field397.method2768(184);
            Client.field397.method2627(class52.field1128);
            Client.field397.method2516(Item.field691);
            Client.field397.method2627(var3);
            Client.field397.method2576(class62.field1263);
            Client.field397.method2557(class140.field2153[82]?1:0);
         }
      }

      if(var2 == 6) {
         Client.field389 = var6;
         Client.field390 = var7;
         Client.field392 = 2;
         Client.field391 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field397.method2768(118);
         Client.field397.method2627(class32.baseX + var0);
         Client.field397.method2559(class140.field2153[82]?1:0);
         Client.field397.method2627(var1 + class8.baseY);
         Client.field397.method2627(var3 >> 14 & 32767);
      }

      if(var2 == 8) {
         var12 = Client.cachedNPCs[var3];
         if(null != var12) {
            Client.field389 = var6;
            Client.field390 = var7;
            Client.field392 = 2;
            Client.field391 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field397.method2768(100);
            Client.field397.method2557(class140.field2153[82]?1:0);
            Client.field397.method2516(var3);
            Client.field397.method2574(class32.field711);
            Client.field397.method2567(Client.field344);
         }
      }

      if(var2 == 58) {
         var11 = Player.method44(var1, var0);
         if(var11 != null) {
            Client.field397.method2768(166);
            Client.field397.method2567(var0);
            Client.field397.method2574(class32.field711);
            Client.field397.method2521(var1);
            Client.field397.method2567(Client.field344);
            Client.field397.method2567(var11.item);
            Client.field397.method2516(Client.field484);
         }
      }

      if(var2 == 20) {
         Client.field389 = var6;
         Client.field390 = var7;
         Client.field392 = 2;
         Client.field391 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field397.method2768(122);
         Client.field397.method2516(class8.baseY + var1);
         Client.field397.method2516(var3);
         Client.field397.method2518(class140.field2153[82]?1:0);
         Client.field397.method2516(class32.baseX + var0);
      }

      if(var2 == 11) {
         var12 = Client.cachedNPCs[var3];
         if(var12 != null) {
            Client.field389 = var6;
            Client.field390 = var7;
            Client.field392 = 2;
            Client.field391 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field397.method2768(136);
            Client.field397.method2557(class140.field2153[82]?1:0);
            Client.field397.method2627(var3);
         }
      }

      if(var2 == 41) {
         Client.field397.method2768(109);
         Client.field397.method2627(var0);
         Client.field397.method2567(var3);
         Client.field397.method2521(var1);
         Client.field551 = 0;
         class79.field1439 = class153.method3170(var1);
         Client.field394 = var0;
      }

      if(var2 == 45) {
         var8 = Client.cachedPlayers[var3];
         if(var8 != null) {
            Client.field389 = var6;
            Client.field390 = var7;
            Client.field392 = 2;
            Client.field391 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field397.method2768(131);
            Client.field397.method2557(class140.field2153[82]?1:0);
            Client.field397.method2519(var3);
         }
      }

      if(var2 == 32) {
         Client.field397.method2768(253);
         Client.field397.method2574(class32.field711);
         Client.field397.method2627(var0);
         Client.field397.method2521(var1);
         Client.field397.method2627(var3);
         Client.field397.method2516(Client.field344);
         Client.field551 = 0;
         class79.field1439 = class153.method3170(var1);
         Client.field394 = var0;
      }

      if(var2 == 38) {
         class16.method186();
         var11 = class153.method3170(var1);
         Client.field432 = 1;
         class52.field1128 = var0;
         class62.field1263 = var1;
         Item.field691 = var3;
         MessageNode.method750(var11);
         Client.field433 = class92.method2126(16748608) + class45.getItemDefinition(var3).name + class92.method2126(16777215);
         if(null == Client.field433) {
            Client.field433 = "null";
         }

      } else {
         if(var2 == 9) {
            var12 = Client.cachedNPCs[var3];
            if(var12 != null) {
               Client.field389 = var6;
               Client.field390 = var7;
               Client.field392 = 2;
               Client.field391 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field397.method2768(174);
               Client.field397.method2557(class140.field2153[82]?1:0);
               Client.field397.method2627(var3);
            }
         }

         if(var2 == 1002) {
            Client.field389 = var6;
            Client.field390 = var7;
            Client.field392 = 2;
            Client.field391 = 0;
            Client.field397.method2768(61);
            Client.field397.method2567(var3 >> 14 & 32767);
         }

         if(var2 == 14) {
            var8 = Client.cachedPlayers[var3];
            if(null != var8) {
               Client.field389 = var6;
               Client.field390 = var7;
               Client.field392 = 2;
               Client.field391 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field397.method2768(82);
               Client.field397.method2557(class140.field2153[82]?1:0);
               Client.field397.method2627(class52.field1128);
               Client.field397.method2627(var3);
               Client.field397.method2576(class62.field1263);
               Client.field397.method2567(Item.field691);
            }
         }

         if(var2 == 30 && null == Client.field443) {
            class75.method1623(var1, var0);
            Client.field443 = Player.method44(var1, var0);
            MessageNode.method750(Client.field443);
         }

         if(var2 == 1001) {
            Client.field389 = var6;
            Client.field390 = var7;
            Client.field392 = 2;
            Client.field391 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field397.method2768(169);
            Client.field397.method2627(var3 >> 14 & 32767);
            Client.field397.method2567(class8.baseY + var1);
            Client.field397.method2558(class140.field2153[82]?1:0);
            Client.field397.method2567(var0 + class32.baseX);
         }

         if(var2 == 57 || var2 == 1007) {
            var11 = Player.method44(var1, var0);
            if(var11 != null) {
               class110.method2402(var3, var1, var0, var11.item, var5);
            }
         }

         if(var2 == 18) {
            Client.field389 = var6;
            Client.field390 = var7;
            Client.field392 = 2;
            Client.field391 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field397.method2768(128);
            Client.field397.method2627(var0 + class32.baseX);
            Client.field397.method2558(class140.field2153[82]?1:0);
            Client.field397.method2516(var3);
            Client.field397.method2516(class8.baseY + var1);
         }

         if(var2 == 3) {
            Client.field389 = var6;
            Client.field390 = var7;
            Client.field392 = 2;
            Client.field391 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field397.method2768(188);
            Client.field397.method2516(var0 + class32.baseX);
            Client.field397.method2567(class8.baseY + var1);
            Client.field397.method2516(var3 >> 14 & 32767);
            Client.field397.method2559(class140.field2153[82]?1:0);
         }

         if(var2 == 12) {
            var12 = Client.cachedNPCs[var3];
            if(null != var12) {
               Client.field389 = var6;
               Client.field390 = var7;
               Client.field392 = 2;
               Client.field391 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field397.method2768(11);
               Client.field397.method2567(var3);
               Client.field397.method2559(class140.field2153[82]?1:0);
            }
         }

         if(var2 == 21) {
            Client.field389 = var6;
            Client.field390 = var7;
            Client.field392 = 2;
            Client.field391 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field397.method2768(60);
            Client.field397.method2519(class8.baseY + var1);
            Client.field397.method2519(var3);
            Client.field397.method2627(var0 + class32.baseX);
            Client.field397.method2558(class140.field2153[82]?1:0);
         }

         if(var2 == 36) {
            Client.field397.method2768(247);
            Client.field397.method2516(var0);
            Client.field397.method2521(var1);
            Client.field397.method2516(var3);
            Client.field551 = 0;
            class79.field1439 = class153.method3170(var1);
            Client.field394 = var0;
         }

         if(var2 == 13) {
            var12 = Client.cachedNPCs[var3];
            if(null != var12) {
               Client.field389 = var6;
               Client.field390 = var7;
               Client.field392 = 2;
               Client.field391 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field397.method2768(8);
               Client.field397.method2518(class140.field2153[82]?1:0);
               Client.field397.method2519(var3);
            }
         }

         if(var2 == 48) {
            var8 = Client.cachedPlayers[var3];
            if(var8 != null) {
               Client.field389 = var6;
               Client.field390 = var7;
               Client.field392 = 2;
               Client.field391 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field397.method2768(80);
               Client.field397.method2516(var3);
               Client.field397.method2518(class140.field2153[82]?1:0);
            }
         }

         if(var2 == 35) {
            Client.field397.method2768(159);
            Client.field397.method2567(var0);
            Client.field397.method2516(var3);
            Client.field397.method2574(var1);
            Client.field551 = 0;
            class79.field1439 = class153.method3170(var1);
            Client.field394 = var0;
         }

         if(var2 == 31) {
            Client.field397.method2768(75);
            Client.field397.method2521(var1);
            Client.field397.method2627(class52.field1128);
            Client.field397.method2567(var3);
            Client.field397.method2519(var0);
            Client.field397.method2516(Item.field691);
            Client.field397.method2575(class62.field1263);
            Client.field551 = 0;
            class79.field1439 = class153.method3170(var1);
            Client.field394 = var0;
         }

         if(var2 == 33) {
            Client.field397.method2768(198);
            Client.field397.method2574(var1);
            Client.field397.method2627(var3);
            Client.field397.method2567(var0);
            Client.field551 = 0;
            class79.field1439 = class153.method3170(var1);
            Client.field394 = var0;
         }

         if(var2 == 25) {
            var11 = Player.method44(var1, var0);
            if(null != var11) {
               class16.method186();
               Renderable.method1959(var1, var0, class175.method3438(class93.method2130(var11)), var11.item);
               Client.field432 = 0;
               String var14;
               if(class175.method3438(class93.method2130(var11)) == 0) {
                  var14 = null;
               } else if(null != var11.field2897 && var11.field2897.trim().length() != 0) {
                  var14 = var11.field2897;
               } else {
                  var14 = null;
               }

               Client.field492 = var14;
               if(null == Client.field492) {
                  Client.field492 = "Null";
               }

               if(var11.field2787) {
                  Client.field438 = var11.name + class92.method2126(16777215);
               } else {
                  Client.field438 = class92.method2126('\uff00') + var11.field2904 + class92.method2126(16777215);
               }
            }

         } else {
            if(var2 == 22) {
               Client.field389 = var6;
               Client.field390 = var7;
               Client.field392 = 2;
               Client.field391 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field397.method2768(106);
               Client.field397.method2519(var0 + class32.baseX);
               Client.field397.method2627(var1 + class8.baseY);
               Client.field397.method2627(var3);
               Client.field397.method2558(class140.field2153[82]?1:0);
            }

            if(var2 == 15) {
               var8 = Client.cachedPlayers[var3];
               if(var8 != null) {
                  Client.field389 = var6;
                  Client.field390 = var7;
                  Client.field392 = 2;
                  Client.field391 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field397.method2768(222);
                  Client.field397.method2574(class32.field711);
                  Client.field397.method2559(class140.field2153[82]?1:0);
                  Client.field397.method2516(Client.field344);
                  Client.field397.method2516(var3);
               }
            }

            if(var2 == 26) {
               Client.field397.method2768(243);

               for(WidgetNode var15 = (WidgetNode)Client.componentTable.method3852(); var15 != null; var15 = (WidgetNode)Client.componentTable.method3857()) {
                  if(var15.field58 == 0 || var15.field58 == 3) {
                     Player.method33(var15, true);
                  }
               }

               if(null != Client.field443) {
                  MessageNode.method750(Client.field443);
                  Client.field443 = null;
               }
            }

            if(var2 == 40) {
               Client.field397.method2768(132);
               Client.field397.method2516(var3);
               Client.field397.method2567(var0);
               Client.field397.method2574(var1);
               Client.field551 = 0;
               class79.field1439 = class153.method3170(var1);
               Client.field394 = var0;
            }

            if(var2 == 42) {
               Client.field397.method2768(7);
               Client.field397.method2567(var3);
               Client.field397.method2521(var1);
               Client.field397.method2516(var0);
               Client.field551 = 0;
               class79.field1439 = class153.method3170(var1);
               Client.field394 = var0;
            }

            if(var2 == 17) {
               Client.field389 = var6;
               Client.field390 = var7;
               Client.field392 = 2;
               Client.field391 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field397.method2768(245);
               Client.field397.method2519(class8.baseY + var1);
               Client.field397.method2557(class140.field2153[82]?1:0);
               Client.field397.method2576(class32.field711);
               Client.field397.method2567(class32.baseX + var0);
               Client.field397.method2627(var3);
               Client.field397.method2519(Client.field344);
            }

            if(var2 == 29) {
               Client.field397.method2768(239);
               Client.field397.method2521(var1);
               var11 = class153.method3170(var1);
               if(null != var11.dynamicValues && var11.dynamicValues[0][0] == 5) {
                  var13 = var11.dynamicValues[0][1];
                  if(var11.field2889[0] != class179.widgetSettings[var13]) {
                     class179.widgetSettings[var13] = var11.field2889[0];
                     BufferProvider.method1745(var13);
                  }
               }
            }

            if(var2 == 16) {
               Client.field389 = var6;
               Client.field390 = var7;
               Client.field392 = 2;
               Client.field391 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field397.method2768(130);
               Client.field397.method2519(class52.field1128);
               Client.field397.method2575(class62.field1263);
               Client.field397.method2627(var3);
               Client.field397.method2558(class140.field2153[82]?1:0);
               Client.field397.method2627(class32.baseX + var0);
               Client.field397.method2567(var1 + class8.baseY);
               Client.field397.method2627(Item.field691);
            }

            if(var2 == 43) {
               Client.field397.method2768(35);
               Client.field397.method2567(var3);
               Client.field397.method2576(var1);
               Client.field397.method2516(var0);
               Client.field551 = 0;
               class79.field1439 = class153.method3170(var1);
               Client.field394 = var0;
            }

            if(var2 == 37) {
               Client.field397.method2768(142);
               Client.field397.method2516(var3);
               Client.field397.method2576(var1);
               Client.field397.method2516(var0);
               Client.field551 = 0;
               class79.field1439 = class153.method3170(var1);
               Client.field394 = var0;
            }

            if(var2 == 47) {
               var8 = Client.cachedPlayers[var3];
               if(var8 != null) {
                  Client.field389 = var6;
                  Client.field390 = var7;
                  Client.field392 = 2;
                  Client.field391 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field397.method2768(191);
                  Client.field397.method2557(class140.field2153[82]?1:0);
                  Client.field397.method2567(var3);
               }
            }

            if(var2 == 1004) {
               Client.field389 = var6;
               Client.field390 = var7;
               Client.field392 = 2;
               Client.field391 = 0;
               Client.field397.method2768(94);
               Client.field397.method2567(var3);
            }

            if(var2 == 46) {
               var8 = Client.cachedPlayers[var3];
               if(null != var8) {
                  Client.field389 = var6;
                  Client.field390 = var7;
                  Client.field392 = 2;
                  Client.field391 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field397.method2768(155);
                  Client.field397.method2518(class140.field2153[82]?1:0);
                  Client.field397.method2516(var3);
               }
            }

            if(Client.field432 != 0) {
               Client.field432 = 0;
               MessageNode.method750(class153.method3170(class62.field1263));
            }

            if(Client.field434) {
               class16.method186();
            }

            if(null != class79.field1439 && Client.field551 == 0) {
               MessageNode.method750(class79.field1439);
            }

         }
      }
   }

   @ObfuscatedName("dl")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)V",
      garbageValue = "-1988144815"
   )
   static final void method764(String var0, int var1) {
      Client.field397.method2768(205);
      Client.field397.method2518(class75.method1624(var0) + 1);
      Client.field397.method2524(var0);
      Client.field397.method2559(var1);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-28308"
   )
   static void method765(int var0) {
      if(var0 != -1) {
         if(class171.method3404(var0)) {
            Widget[] var1 = Widget.widgets[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               Widget var3 = var1[var2];
               if(null != var3.field2869) {
                  class0 var4 = new class0();
                  var4.field2 = var3;
                  var4.field1 = var3.field2869;
                  class26.method613(var4, 2000000);
               }
            }

         }
      }
   }
}
