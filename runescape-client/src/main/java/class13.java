import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
public class class13 implements Runnable {
   @ObfuscatedName("r")
   Object field190 = new Object();
   @ObfuscatedName("p")
   public static byte[][] field191;
   @ObfuscatedName("x")
   boolean field192 = true;
   @ObfuscatedName("z")
   int[] field193 = new int[500];
   @ObfuscatedName("i")
   int[] field194 = new int[500];
   @ObfuscatedName("l")
   static SpritePixels field195;
   @ObfuscatedName("dl")
   @ObfuscatedGetter(
      intValue = 434146453
   )
   static int field196;
   @ObfuscatedName("mo")
   @Export("clanMembers")
   static XClanMember[] clanMembers;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 610233547
   )
   int field200 = 0;

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   static final void method155() {
      int var0 = class92.menuX;
      int var1 = class85.menuY;
      int var2 = class109.menuWidth;
      int var3 = class138.menuHeight;
      int var4 = 6116423;
      class82.method1831(var0, var1, var2, var3, var4);
      class82.method1831(1 + var0, 1 + var1, var2 - 2, 16, 0);
      class82.method1837(1 + var0, var1 + 18, var2 - 2, var3 - 19, 0);
      VertexNormal.field1680.method4079("Choose Option", var0 + 3, 14 + var1, var4, -1);
      int var5 = class143.field2204;
      int var6 = class143.field2210;

      int var7;
      int var8;
      int var9;
      for(var7 = 0; var7 < Client.menuOptionCount; ++var7) {
         var8 = 31 + var1 + 15 * (Client.menuOptionCount - 1 - var7);
         var9 = 16777215;
         if(var5 > var0 && var5 < var0 + var2 && var6 > var8 - 13 && var6 < 3 + var8) {
            var9 = 16776960;
         }

         class227 var10 = VertexNormal.field1680;
         String var12;
         if(Client.menuTargets[var7].length() > 0) {
            var12 = Client.menuOptions[var7] + " " + Client.menuTargets[var7];
         } else {
            var12 = Client.menuOptions[var7];
         }

         var10.method4079(var12, var0 + 3, var8, var9, 0);
      }

      var7 = class92.menuX;
      var8 = class85.menuY;
      var9 = class109.menuWidth;
      int var13 = class138.menuHeight;

      for(int var11 = 0; var11 < Client.field547; ++var11) {
         if(Client.widgetPositionX[var11] + Client.widgetBoundsWidth[var11] > var7 && Client.widgetPositionX[var11] < var9 + var7 && Client.widgetPositionY[var11] + Client.widgetBoundsHeight[var11] > var8 && Client.widgetPositionY[var11] < var13 + var8) {
            Client.field485[var11] = true;
         }
      }

   }

   public void run() {
      for(; this.field192; class125.method2820(50L)) {
         Object var1 = this.field190;
         synchronized(this.field190) {
            if(this.field200 < 500) {
               this.field193[this.field200] = class143.field2204;
               this.field194[this.field200] = class143.field2210;
               ++this.field200;
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1647599354"
   )
   public static int method158(int var0) {
      var0 = (var0 >>> 1 & 1431655765) + (var0 & 1431655765);
      var0 = (var0 & 858993459) + (var0 >>> 2 & 858993459);
      var0 = var0 + (var0 >>> 4) & 252645135;
      var0 += var0 >>> 8;
      var0 += var0 >>> 16;
      return var0 & 255;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "21"
   )
   @Export("xteaChanged")
   static final void xteaChanged(boolean var0) {
      Client.field341 = var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if(!Client.field341) {
         var1 = Client.field446.method2593();
         var2 = Client.field446.method2592();
         var3 = Client.field446.method2551();
         class192.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class192.xteaKeys[var4][var5] = Client.field446.method2561();
            }
         }

         class175.mapRegions = new int[var3];
         class170.field2734 = new int[var3];
         Renderable.field1505 = new int[var3];
         class22.field587 = new byte[var3][];
         Ignore.field126 = new byte[var3][];
         boolean var13 = false;
         if((var2 / 8 == 48 || var2 / 8 == 49) && var1 / 8 == 48) {
            var13 = true;
         }

         if(var2 / 8 == 48 && var1 / 8 == 148) {
            var13 = true;
         }

         var3 = 0;

         for(var5 = (var2 - 6) / 8; var5 <= (var2 + 6) / 8; ++var5) {
            for(var6 = (var1 - 6) / 8; var6 <= (6 + var1) / 8; ++var6) {
               var7 = var6 + (var5 << 8);
               if(!var13 || var6 != 49 && var6 != 149 && var6 != 147 && var5 != 50 && (var5 != 49 || var6 != 47)) {
                  class175.mapRegions[var3] = var7;
                  class170.field2734[var3] = class140.field2165.method3359("m" + var5 + "_" + var6);
                  Renderable.field1505[var3] = class140.field2165.method3359("l" + var5 + "_" + var6);
                  ++var3;
               }
            }
         }

         Friend.method192(var2, var1);
      } else {
         var1 = Client.field446.method2592();
         var2 = Client.field446.method2591();
         var3 = Client.field446.method2551();
         Client.field446.method2824();

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = Client.field446.method2827(1);
                  if(var7 == 1) {
                     Client.field389[var4][var5][var6] = Client.field446.method2827(26);
                  } else {
                     Client.field389[var4][var5][var6] = -1;
                  }
               }
            }
         }

         Client.field446.method2822();
         class192.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class192.xteaKeys[var4][var5] = Client.field446.method2561();
            }
         }

         class175.mapRegions = new int[var3];
         class170.field2734 = new int[var3];
         Renderable.field1505 = new int[var3];
         class22.field587 = new byte[var3][];
         Ignore.field126 = new byte[var3][];
         var3 = 0;

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = Client.field389[var4][var5][var6];
                  if(var7 != -1) {
                     int var8 = var7 >> 14 & 1023;
                     int var9 = var7 >> 3 & 2047;
                     int var10 = var9 / 8 + (var8 / 8 << 8);

                     int var11;
                     for(var11 = 0; var11 < var3; ++var11) {
                        if(var10 == class175.mapRegions[var11]) {
                           var10 = -1;
                           break;
                        }
                     }

                     if(var10 != -1) {
                        class175.mapRegions[var3] = var10;
                        var11 = var10 >> 8 & 255;
                        int var12 = var10 & 255;
                        class170.field2734[var3] = class140.field2165.method3359("m" + var11 + "_" + var12);
                        Renderable.field1505[var3] = class140.field2165.method3359("l" + var11 + "_" + var12);
                        ++var3;
                     }
                  }
               }
            }
         }

         Friend.method192(var1, var2);
      }

   }

   @ObfuscatedName("dw")
   @ObfuscatedSignature(
      signature = "(LWidget;IIII)V",
      garbageValue = "-9943202"
   )
   static final void method160(Widget var0, int var1, int var2, int var3) {
      class92.method2127();
      class178 var4 = var0.method3449(false);
      if(var4 != null) {
         class82.method1825(var1, var2, var4.field2953 + var1, var2 + var4.field2952);
         if(Client.field515 != 2 && Client.field515 != 5) {
            int var5 = Client.mapAngle + Client.mapScale & 2047;
            int var6 = class48.localPlayer.x / 32 + 48;
            int var7 = 464 - class48.localPlayer.y / 32;
            class143.field2205.method1739(var1, var2, var4.field2953, var4.field2952, var6, var7, var5, 256 + Client.mapScaleDelta, var4.field2954, var4.field2956);

            int var8;
            int var9;
            int var10;
            for(var8 = 0; var8 < Client.field287; ++var8) {
               var9 = 4 * Client.field451[var8] + 2 - class48.localPlayer.x / 32;
               var10 = Client.field511[var8] * 4 + 2 - class48.localPlayer.y / 32;
               Sequence.method883(var1, var2, var9, var10, Client.field512[var8], var4);
            }

            int var11;
            int var12;
            for(var8 = 0; var8 < 104; ++var8) {
               for(var9 = 0; var9 < 104; ++var9) {
                  Deque var17 = Client.groundItemDeque[FrameMap.plane][var8][var9];
                  if(var17 != null) {
                     var11 = 2 + 4 * var8 - class48.localPlayer.x / 32;
                     var12 = var9 * 4 + 2 - class48.localPlayer.y / 32;
                     Sequence.method883(var1, var2, var11, var12, Client.field450[0], var4);
                  }
               }
            }

            for(var8 = 0; var8 < Client.field319; ++var8) {
               NPC var18 = Client.cachedNPCs[Client.field320[var8]];
               if(var18 != null && var18.vmethod750()) {
                  NPCComposition var21 = var18.composition;
                  if(var21 != null && null != var21.field914) {
                     var21 = var21.method779();
                  }

                  if(null != var21 && var21.isMinimapVisible && var21.field917) {
                     var11 = var18.x / 32 - class48.localPlayer.x / 32;
                     var12 = var18.y / 32 - class48.localPlayer.y / 32;
                     Sequence.method883(var1, var2, var11, var12, Client.field450[1], var4);
                  }
               }
            }

            var8 = class34.field760;
            int[] var22 = class34.field755;

            for(var10 = 0; var10 < var8; ++var10) {
               Player var19 = Client.cachedPlayers[var22[var10]];
               if(null != var19 && var19.vmethod750() && !var19.field29 && class48.localPlayer != var19) {
                  var12 = var19.x / 32 - class48.localPlayer.x / 32;
                  int var13 = var19.y / 32 - class48.localPlayer.y / 32;
                  boolean var14 = false;
                  if(class109.method2436(var19.name, true)) {
                     var14 = true;
                  }

                  boolean var15 = false;

                  for(int var16 = 0; var16 < class1.field25; ++var16) {
                     if(var19.name.equals(clanMembers[var16].username)) {
                        var15 = true;
                        break;
                     }
                  }

                  boolean var20 = false;
                  if(class48.localPlayer.team != 0 && var19.team != 0 && class48.localPlayer.team == var19.team) {
                     var20 = true;
                  }

                  if(var14) {
                     Sequence.method883(var1, var2, var12, var13, Client.field450[3], var4);
                  } else if(var20) {
                     Sequence.method883(var1, var2, var12, var13, Client.field450[4], var4);
                  } else if(var15) {
                     Sequence.method883(var1, var2, var12, var13, Client.field450[5], var4);
                  } else {
                     Sequence.method883(var1, var2, var12, var13, Client.field450[2], var4);
                  }
               }
            }

            if(Client.field525 != 0 && Client.gameCycle % 20 < 10) {
               if(Client.field525 == 1 && Client.field299 >= 0 && Client.field299 < Client.cachedNPCs.length) {
                  NPC var23 = Client.cachedNPCs[Client.field299];
                  if(var23 != null) {
                     var11 = var23.x / 32 - class48.localPlayer.x / 32;
                     var12 = var23.y / 32 - class48.localPlayer.y / 32;
                     class5.method63(var1, var2, var11, var12, ObjectComposition.field942[1], var4);
                  }
               }

               if(Client.field525 == 2) {
                  var10 = 2 + (Client.field419 * 4 - class28.baseX * 4) - class48.localPlayer.x / 32;
                  var11 = Client.field302 * 4 - class159.baseY * 4 + 2 - class48.localPlayer.y / 32;
                  class5.method63(var1, var2, var10, var11, ObjectComposition.field942[1], var4);
               }

               if(Client.field525 == 10 && Client.field300 >= 0 && Client.field300 < Client.cachedPlayers.length) {
                  Player var24 = Client.cachedPlayers[Client.field300];
                  if(var24 != null) {
                     var11 = var24.x / 32 - class48.localPlayer.x / 32;
                     var12 = var24.y / 32 - class48.localPlayer.y / 32;
                     class5.method63(var1, var2, var11, var12, ObjectComposition.field942[1], var4);
                  }
               }
            }

            if(Client.flagX != 0) {
               var10 = Client.flagX * 4 + 2 - class48.localPlayer.x / 32;
               var11 = 2 + Client.flagY * 4 - class48.localPlayer.y / 32;
               Sequence.method883(var1, var2, var10, var11, ObjectComposition.field942[0], var4);
            }

            if(!class48.localPlayer.field29) {
               class82.method1831(var4.field2953 / 2 + var1 - 1, var2 + var4.field2952 / 2 - 1, 3, 3, 16777215);
            }
         } else {
            class82.method1844(var1, var2, 0, var4.field2954, var4.field2956);
         }

         Client.field485[var3] = true;
      }
   }

   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1087683033"
   )
   static final void method161(String var0) {
      if(null != var0) {
         String var1 = class10.method123(var0, class127.field2087);
         if(null != var1) {
            for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
               Ignore var3 = Client.ignores[var2];
               String var4 = var3.name;
               String var5 = class10.method123(var4, class127.field2087);
               if(class107.method2356(var0, var1, var4, var5)) {
                  --Client.ignoreCount;

                  for(int var6 = var2; var6 < Client.ignoreCount; ++var6) {
                     Client.ignores[var6] = Client.ignores[1 + var6];
                  }

                  Client.field472 = Client.field532;
                  Client.field323.method2818(31);
                  Client.field323.method2715(class43.method857(var0));
                  Client.field323.method2616(var0);
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IS)LKitDefinition;",
      garbageValue = "21320"
   )
   @Export("getKitDefinition")
   public static KitDefinition getKitDefinition(int var0) {
      KitDefinition var1 = (KitDefinition)KitDefinition.field1035.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = KitDefinition.field1036.method3290(3, var0);
         var1 = new KitDefinition();
         if(null != var2) {
            var1.method923(new Buffer(var2));
         }

         KitDefinition.field1035.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "1452285130"
   )
   @Export("addChatMessage")
   static void addChatMessage(int var0, String var1, String var2, String var3) {
      ChatLineBuffer var4 = (ChatLineBuffer)class11.chatLineMap.get(Integer.valueOf(var0));
      if(null == var4) {
         var4 = new ChatLineBuffer();
         class11.chatLineMap.put(Integer.valueOf(var0), var4);
      }

      MessageNode var5 = var4.method644(var0, var1, var2, var3);
      class11.field164.method3834(var5, (long)var5.id);
      class11.field165.method3877(var5);
      Client.field471 = Client.field532;
   }
}
