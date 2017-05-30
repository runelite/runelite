import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hy")
public class class215 {
   @ObfuscatedName("h")
   static IndexDataBase field2624;

   @ObfuscatedName("hp")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "-219934172"
   )
   @Export("menuAction")
   @Hook("menuActionHook")
   static final void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      Widget var8;
      if(var2 == 24) {
         var8 = class261.method4792(var1);
         boolean var9 = true;
         if(var8.contentType > 0) {
            var9 = Actor.method1543(var8);
         }

         if(var9) {
            Client.secretPacketBuffer1.putOpcode(88);
            Client.secretPacketBuffer1.putInt(var1);
         }
      }

      if(var2 == 2) {
         Client.field997 = var6;
         Client.field998 = var7;
         Client.field1016 = 2;
         Client.field999 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.secretPacketBuffer1.putOpcode(182);
         Client.secretPacketBuffer1.putByte(class50.field624[82]?1:0);
         Client.secretPacketBuffer1.method3242(CollisionData.field2278);
         Client.secretPacketBuffer1.method3234(class146.baseY + var1);
         Client.secretPacketBuffer1.method3232(Client.field1046);
         Client.secretPacketBuffer1.method3232(var3 >> 14 & 32767);
         Client.secretPacketBuffer1.putShort(class166.baseX + var0);
      }

      if(var2 == 1005) {
         var8 = class261.method4792(var1);
         if(var8 != null && var8.itemQuantities[var0] >= 100000) {
            GameObject.sendGameMessage(27, "", var8.itemQuantities[var0] + " x " + class51.getItemDefinition(var3).name);
         } else {
            Client.secretPacketBuffer1.putOpcode(39);
            Client.secretPacketBuffer1.method3382(var3);
         }

         Client.field1001 = 0;
         class37.field507 = class261.method4792(var1);
         Client.field1002 = var0;
      }

      NPC var18;
      if(var2 == 12) {
         var18 = Client.cachedNPCs[var3];
         if(var18 != null) {
            Client.field997 = var6;
            Client.field998 = var7;
            Client.field1016 = 2;
            Client.field999 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.secretPacketBuffer1.putOpcode(74);
            Client.secretPacketBuffer1.method3382(var3);
            Client.secretPacketBuffer1.putByte(class50.field624[82]?1:0);
         }
      }

      if(var2 == 40) {
         Client.secretPacketBuffer1.putOpcode(175);
         Client.secretPacketBuffer1.method3382(var3);
         Client.secretPacketBuffer1.method3234(var0);
         Client.secretPacketBuffer1.putInt(var1);
         Client.field1001 = 0;
         class37.field507 = class261.method4792(var1);
         Client.field1002 = var0;
      }

      if(var2 == 57 || var2 == 1007) {
         var8 = class66.method1099(var1, var0);
         if(var8 != null) {
            class7.method28(var3, var1, var0, var8.itemId, var5);
         }
      }

      if(var2 == 1008 || var2 == 1009 || var2 == 1010 || var2 == 1011 || var2 == 1012) {
         class83.field1325.method5304(var2, var3, new Coordinates(var0), new Coordinates(var1));
      }

      Player var19;
      if(var2 == 48) {
         var19 = Client.cachedPlayers[var3];
         if(var19 != null) {
            Client.field997 = var6;
            Client.field998 = var7;
            Client.field1016 = 2;
            Client.field999 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.secretPacketBuffer1.putOpcode(68);
            Client.secretPacketBuffer1.method3225(class50.field624[82]?1:0);
            Client.secretPacketBuffer1.method3382(var3);
         }
      }

      if(var2 == 9) {
         var18 = Client.cachedNPCs[var3];
         if(var18 != null) {
            Client.field997 = var6;
            Client.field998 = var7;
            Client.field1016 = 2;
            Client.field999 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.secretPacketBuffer1.putOpcode(161);
            Client.secretPacketBuffer1.putShort(var3);
            Client.secretPacketBuffer1.method3408(class50.field624[82]?1:0);
         }
      }

      if(var2 == 1003) {
         Client.field997 = var6;
         Client.field998 = var7;
         Client.field1016 = 2;
         Client.field999 = 0;
         var18 = Client.cachedNPCs[var3];
         if(var18 != null) {
            NPCComposition var16 = var18.composition;
            if(var16.configs != null) {
               var16 = var16.method4705();
            }

            if(var16 != null) {
               Client.secretPacketBuffer1.putOpcode(25);
               Client.secretPacketBuffer1.method3232(var16.id);
            }
         }
      }

      if(var2 == 1002) {
         Client.field997 = var6;
         Client.field998 = var7;
         Client.field1016 = 2;
         Client.field999 = 0;
         Client.secretPacketBuffer1.putOpcode(220);
         Client.secretPacketBuffer1.putShort(var3 >> 14 & 32767);
      }

      if(var2 == 1004) {
         Client.field997 = var6;
         Client.field998 = var7;
         Client.field1016 = 2;
         Client.field999 = 0;
         Client.secretPacketBuffer1.putOpcode(39);
         Client.secretPacketBuffer1.method3382(var3);
      }

      if(var2 == 37) {
         Client.secretPacketBuffer1.putOpcode(208);
         Client.secretPacketBuffer1.method3242(var1);
         Client.secretPacketBuffer1.putShort(var3);
         Client.secretPacketBuffer1.method3232(var0);
         Client.field1001 = 0;
         class37.field507 = class261.method4792(var1);
         Client.field1002 = var0;
      }

      if(var2 == 42) {
         Client.secretPacketBuffer1.putOpcode(28);
         Client.secretPacketBuffer1.method3382(var3);
         Client.secretPacketBuffer1.method3232(var0);
         Client.secretPacketBuffer1.method3242(var1);
         Client.field1001 = 0;
         class37.field507 = class261.method4792(var1);
         Client.field1002 = var0;
      }

      if(var2 == 46) {
         var19 = Client.cachedPlayers[var3];
         if(var19 != null) {
            Client.field997 = var6;
            Client.field998 = var7;
            Client.field1016 = 2;
            Client.field999 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.secretPacketBuffer1.putOpcode(241);
            Client.secretPacketBuffer1.putShort(var3);
            Client.secretPacketBuffer1.method3223(class50.field624[82]?1:0);
         }
      }

      if(var2 == 7) {
         var18 = Client.cachedNPCs[var3];
         if(var18 != null) {
            Client.field997 = var6;
            Client.field998 = var7;
            Client.field1016 = 2;
            Client.field999 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.secretPacketBuffer1.putOpcode(173);
            Client.secretPacketBuffer1.method3285(class214.field2622);
            Client.secretPacketBuffer1.method3232(WorldMapType0.field612);
            Client.secretPacketBuffer1.method3223(class50.field624[82]?1:0);
            Client.secretPacketBuffer1.putShort(WidgetNode.field809);
            Client.secretPacketBuffer1.method3382(var3);
         }
      }

      if(var2 == 23) {
         if(Client.isMenuOpen) {
            class46.region.method2745();
         } else {
            class46.region.method2744(Sequence.plane, var0, var1, true);
         }
      }

      if(var2 == 10) {
         var18 = Client.cachedNPCs[var3];
         if(var18 != null) {
            Client.field997 = var6;
            Client.field998 = var7;
            Client.field1016 = 2;
            Client.field999 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.secretPacketBuffer1.putOpcode(113);
            Client.secretPacketBuffer1.method3223(class50.field624[82]?1:0);
            Client.secretPacketBuffer1.putShort(var3);
         }
      }

      if(var2 == 14) {
         var19 = Client.cachedPlayers[var3];
         if(var19 != null) {
            Client.field997 = var6;
            Client.field998 = var7;
            Client.field1016 = 2;
            Client.field999 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.secretPacketBuffer1.putOpcode(210);
            Client.secretPacketBuffer1.method3408(class50.field624[82]?1:0);
            Client.secretPacketBuffer1.method3382(WorldMapType0.field612);
            Client.secretPacketBuffer1.method3243(class214.field2622);
            Client.secretPacketBuffer1.method3382(var3);
            Client.secretPacketBuffer1.method3232(WidgetNode.field809);
         }
      }

      if(var2 == 43) {
         Client.secretPacketBuffer1.putOpcode(181);
         Client.secretPacketBuffer1.method3232(var0);
         Client.secretPacketBuffer1.method3243(var1);
         Client.secretPacketBuffer1.method3234(var3);
         Client.field1001 = 0;
         class37.field507 = class261.method4792(var1);
         Client.field1002 = var0;
      }

      if(var2 == 34) {
         Client.secretPacketBuffer1.putOpcode(180);
         Client.secretPacketBuffer1.method3234(var3);
         Client.secretPacketBuffer1.method3285(var1);
         Client.secretPacketBuffer1.method3232(var0);
         Client.field1001 = 0;
         class37.field507 = class261.method4792(var1);
         Client.field1002 = var0;
      }

      if(var2 == 58) {
         var8 = class66.method1099(var1, var0);
         if(var8 != null) {
            Client.secretPacketBuffer1.putOpcode(184);
            Client.secretPacketBuffer1.method3242(var1);
            Client.secretPacketBuffer1.method3232(Client.field1046);
            Client.secretPacketBuffer1.method3382(var0);
            Client.secretPacketBuffer1.putShort(var8.itemId);
            Client.secretPacketBuffer1.method3234(Client.field1047);
            Client.secretPacketBuffer1.method3243(CollisionData.field2278);
         }
      }

      if(var2 == 45) {
         var19 = Client.cachedPlayers[var3];
         if(var19 != null) {
            Client.field997 = var6;
            Client.field998 = var7;
            Client.field1016 = 2;
            Client.field999 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.secretPacketBuffer1.putOpcode(218);
            Client.secretPacketBuffer1.method3232(var3);
            Client.secretPacketBuffer1.method3408(class50.field624[82]?1:0);
         }
      }

      if(var2 == 3) {
         Client.field997 = var6;
         Client.field998 = var7;
         Client.field1016 = 2;
         Client.field999 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.secretPacketBuffer1.putOpcode(41);
         Client.secretPacketBuffer1.method3408(class50.field624[82]?1:0);
         Client.secretPacketBuffer1.method3234(var1 + class146.baseY);
         Client.secretPacketBuffer1.method3382(var0 + class166.baseX);
         Client.secretPacketBuffer1.method3232(var3 >> 14 & 32767);
      }

      if(var2 == 51) {
         var19 = Client.cachedPlayers[var3];
         if(var19 != null) {
            Client.field997 = var6;
            Client.field998 = var7;
            Client.field1016 = 2;
            Client.field999 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.secretPacketBuffer1.putOpcode(12);
            Client.secretPacketBuffer1.method3408(class50.field624[82]?1:0);
            Client.secretPacketBuffer1.putShort(var3);
         }
      }

      if(var2 == 31) {
         Client.secretPacketBuffer1.putOpcode(216);
         Client.secretPacketBuffer1.putShort(WorldMapType0.field612);
         Client.secretPacketBuffer1.method3285(var1);
         Client.secretPacketBuffer1.method3382(var0);
         Client.secretPacketBuffer1.putInt(class214.field2622);
         Client.secretPacketBuffer1.putShort(var3);
         Client.secretPacketBuffer1.method3232(WidgetNode.field809);
         Client.field1001 = 0;
         class37.field507 = class261.method4792(var1);
         Client.field1002 = var0;
      }

      if(var2 == 20) {
         Client.field997 = var6;
         Client.field998 = var7;
         Client.field1016 = 2;
         Client.field999 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.secretPacketBuffer1.putOpcode(122);
         Client.secretPacketBuffer1.method3232(class146.baseY + var1);
         Client.secretPacketBuffer1.method3234(var3);
         Client.secretPacketBuffer1.putShort(var0 + class166.baseX);
         Client.secretPacketBuffer1.putByte(class50.field624[82]?1:0);
      }

      if(var2 == 30 && Client.field1054 == null) {
         Script.method1887(var1, var0);
         Client.field1054 = class66.method1099(var1, var0);
         class219.method4130(Client.field1054);
      }

      if(var2 == 47) {
         var19 = Client.cachedPlayers[var3];
         if(var19 != null) {
            Client.field997 = var6;
            Client.field998 = var7;
            Client.field1016 = 2;
            Client.field999 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.secretPacketBuffer1.putOpcode(34);
            Client.secretPacketBuffer1.putShort(var3);
            Client.secretPacketBuffer1.method3225(class50.field624[82]?1:0);
         }
      }

      if(var2 == 50) {
         var19 = Client.cachedPlayers[var3];
         if(var19 != null) {
            Client.field997 = var6;
            Client.field998 = var7;
            Client.field1016 = 2;
            Client.field999 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.secretPacketBuffer1.putOpcode(69);
            Client.secretPacketBuffer1.method3382(var3);
            Client.secretPacketBuffer1.method3225(class50.field624[82]?1:0);
         }
      }

      if(var2 == 13) {
         var18 = Client.cachedNPCs[var3];
         if(var18 != null) {
            Client.field997 = var6;
            Client.field998 = var7;
            Client.field1016 = 2;
            Client.field999 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.secretPacketBuffer1.putOpcode(201);
            Client.secretPacketBuffer1.method3225(class50.field624[82]?1:0);
            Client.secretPacketBuffer1.putShort(var3);
         }
      }

      if(var2 == 38) {
         class19.method143();
         var8 = class261.method4792(var1);
         Client.field1043 = 1;
         WorldMapType0.field612 = var0;
         class214.field2622 = var1;
         WidgetNode.field809 = var3;
         class219.method4130(var8);
         Client.field1142 = class82.method1610(16748608) + class51.getItemDefinition(var3).name + class82.method1610(16777215);
         if(Client.field1142 == null) {
            Client.field1142 = "null";
         }

      } else {
         if(var2 == 39) {
            Client.secretPacketBuffer1.putOpcode(45);
            Client.secretPacketBuffer1.method3382(var0);
            Client.secretPacketBuffer1.putShort(var3);
            Client.secretPacketBuffer1.method3243(var1);
            Client.field1001 = 0;
            class37.field507 = class261.method4792(var1);
            Client.field1002 = var0;
         }

         if(var2 == 35) {
            Client.secretPacketBuffer1.putOpcode(71);
            Client.secretPacketBuffer1.putInt(var1);
            Client.secretPacketBuffer1.method3382(var3);
            Client.secretPacketBuffer1.method3232(var0);
            Client.field1001 = 0;
            class37.field507 = class261.method4792(var1);
            Client.field1002 = var0;
         }

         int var20;
         if(var2 == 28) {
            Client.secretPacketBuffer1.putOpcode(88);
            Client.secretPacketBuffer1.putInt(var1);
            var8 = class261.method4792(var1);
            if(var8.dynamicValues != null && var8.dynamicValues[0][0] == 5) {
               var20 = var8.dynamicValues[0][1];
               class211.widgetSettings[var20] = 1 - class211.widgetSettings[var20];
               class45.method676(var20);
            }
         }

         if(var2 != 25) {
            if(var2 == 33) {
               Client.secretPacketBuffer1.putOpcode(50);
               Client.secretPacketBuffer1.putShort(var3);
               Client.secretPacketBuffer1.method3243(var1);
               Client.secretPacketBuffer1.method3234(var0);
               Client.field1001 = 0;
               class37.field507 = class261.method4792(var1);
               Client.field1002 = var0;
            }

            if(var2 == 21) {
               Client.field997 = var6;
               Client.field998 = var7;
               Client.field1016 = 2;
               Client.field999 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretPacketBuffer1.putOpcode(244);
               Client.secretPacketBuffer1.method3408(class50.field624[82]?1:0);
               Client.secretPacketBuffer1.putShort(var1 + class146.baseY);
               Client.secretPacketBuffer1.method3382(var3);
               Client.secretPacketBuffer1.method3232(var0 + class166.baseX);
            }

            if(var2 == 19) {
               Client.field997 = var6;
               Client.field998 = var7;
               Client.field1016 = 2;
               Client.field999 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretPacketBuffer1.putOpcode(138);
               Client.secretPacketBuffer1.method3234(var0 + class166.baseX);
               Client.secretPacketBuffer1.putShort(var1 + class146.baseY);
               Client.secretPacketBuffer1.method3408(class50.field624[82]?1:0);
               Client.secretPacketBuffer1.method3232(var3);
            }

            if(var2 == 8) {
               var18 = Client.cachedNPCs[var3];
               if(var18 != null) {
                  Client.field997 = var6;
                  Client.field998 = var7;
                  Client.field1016 = 2;
                  Client.field999 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.secretPacketBuffer1.putOpcode(35);
                  Client.secretPacketBuffer1.method3408(class50.field624[82]?1:0);
                  Client.secretPacketBuffer1.method3242(CollisionData.field2278);
                  Client.secretPacketBuffer1.method3234(Client.field1046);
                  Client.secretPacketBuffer1.method3382(var3);
               }
            }

            if(var2 == 29) {
               Client.secretPacketBuffer1.putOpcode(88);
               Client.secretPacketBuffer1.putInt(var1);
               var8 = class261.method4792(var1);
               if(var8.dynamicValues != null && var8.dynamicValues[0][0] == 5) {
                  var20 = var8.dynamicValues[0][1];
                  if(class211.widgetSettings[var20] != var8.field2756[0]) {
                     class211.widgetSettings[var20] = var8.field2756[0];
                     class45.method676(var20);
                  }
               }
            }

            if(var2 == 22) {
               Client.field997 = var6;
               Client.field998 = var7;
               Client.field1016 = 2;
               Client.field999 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretPacketBuffer1.putOpcode(223);
               Client.secretPacketBuffer1.method3408(class50.field624[82]?1:0);
               Client.secretPacketBuffer1.method3232(var0 + class166.baseX);
               Client.secretPacketBuffer1.method3232(var3);
               Client.secretPacketBuffer1.method3234(class146.baseY + var1);
            }

            if(var2 == 4) {
               Client.field997 = var6;
               Client.field998 = var7;
               Client.field1016 = 2;
               Client.field999 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretPacketBuffer1.putOpcode(240);
               Client.secretPacketBuffer1.method3408(class50.field624[82]?1:0);
               Client.secretPacketBuffer1.method3382(class166.baseX + var0);
               Client.secretPacketBuffer1.method3382(var3 >> 14 & 32767);
               Client.secretPacketBuffer1.method3232(var1 + class146.baseY);
            }

            if(var2 == 36) {
               Client.secretPacketBuffer1.putOpcode(56);
               Client.secretPacketBuffer1.method3232(var3);
               Client.secretPacketBuffer1.method3242(var1);
               Client.secretPacketBuffer1.method3382(var0);
               Client.field1001 = 0;
               class37.field507 = class261.method4792(var1);
               Client.field1002 = var0;
            }

            if(var2 == 41) {
               Client.secretPacketBuffer1.putOpcode(159);
               Client.secretPacketBuffer1.method3285(var1);
               Client.secretPacketBuffer1.method3234(var3);
               Client.secretPacketBuffer1.putShort(var0);
               Client.field1001 = 0;
               class37.field507 = class261.method4792(var1);
               Client.field1002 = var0;
            }

            if(var2 == 18) {
               Client.field997 = var6;
               Client.field998 = var7;
               Client.field1016 = 2;
               Client.field999 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretPacketBuffer1.putOpcode(151);
               Client.secretPacketBuffer1.method3223(class50.field624[82]?1:0);
               Client.secretPacketBuffer1.method3234(var1 + class146.baseY);
               Client.secretPacketBuffer1.method3382(var0 + class166.baseX);
               Client.secretPacketBuffer1.method3382(var3);
            }

            if(var2 == 15) {
               var19 = Client.cachedPlayers[var3];
               if(var19 != null) {
                  Client.field997 = var6;
                  Client.field998 = var7;
                  Client.field1016 = 2;
                  Client.field999 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.secretPacketBuffer1.putOpcode(230);
                  Client.secretPacketBuffer1.method3232(var3);
                  Client.secretPacketBuffer1.method3408(class50.field624[82]?1:0);
                  Client.secretPacketBuffer1.putInt(CollisionData.field2278);
                  Client.secretPacketBuffer1.putShort(Client.field1046);
               }
            }

            if(var2 == 16) {
               Client.field997 = var6;
               Client.field998 = var7;
               Client.field1016 = 2;
               Client.field999 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretPacketBuffer1.putOpcode(203);
               Client.secretPacketBuffer1.method3382(var1 + class146.baseY);
               Client.secretPacketBuffer1.method3382(WidgetNode.field809);
               Client.secretPacketBuffer1.method3234(var3);
               Client.secretPacketBuffer1.method3285(class214.field2622);
               Client.secretPacketBuffer1.method3225(class50.field624[82]?1:0);
               Client.secretPacketBuffer1.method3382(class166.baseX + var0);
               Client.secretPacketBuffer1.method3232(WorldMapType0.field612);
            }

            if(var2 == 6) {
               Client.field997 = var6;
               Client.field998 = var7;
               Client.field1016 = 2;
               Client.field999 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretPacketBuffer1.putOpcode(80);
               Client.secretPacketBuffer1.method3382(var3 >> 14 & 32767);
               Client.secretPacketBuffer1.putShort(class166.baseX + var0);
               Client.secretPacketBuffer1.putShort(class146.baseY + var1);
               Client.secretPacketBuffer1.method3408(class50.field624[82]?1:0);
            }

            if(var2 == 44) {
               var19 = Client.cachedPlayers[var3];
               if(var19 != null) {
                  Client.field997 = var6;
                  Client.field998 = var7;
                  Client.field1016 = 2;
                  Client.field999 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.secretPacketBuffer1.putOpcode(207);
                  Client.secretPacketBuffer1.method3225(class50.field624[82]?1:0);
                  Client.secretPacketBuffer1.method3234(var3);
               }
            }

            if(var2 == 26) {
               Friend.method1097();
            }

            if(var2 == 49) {
               var19 = Client.cachedPlayers[var3];
               if(var19 != null) {
                  Client.field997 = var6;
                  Client.field998 = var7;
                  Client.field1016 = 2;
                  Client.field999 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.secretPacketBuffer1.putOpcode(139);
                  Client.secretPacketBuffer1.method3223(class50.field624[82]?1:0);
                  Client.secretPacketBuffer1.putShort(var3);
               }
            }

            if(var2 == 17) {
               Client.field997 = var6;
               Client.field998 = var7;
               Client.field1016 = 2;
               Client.field999 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretPacketBuffer1.putOpcode(81);
               Client.secretPacketBuffer1.method3285(CollisionData.field2278);
               Client.secretPacketBuffer1.method3234(var0 + class166.baseX);
               Client.secretPacketBuffer1.method3408(class50.field624[82]?1:0);
               Client.secretPacketBuffer1.putShort(var1 + class146.baseY);
               Client.secretPacketBuffer1.method3382(var3);
               Client.secretPacketBuffer1.method3232(Client.field1046);
            }

            if(var2 == 5) {
               Client.field997 = var6;
               Client.field998 = var7;
               Client.field1016 = 2;
               Client.field999 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretPacketBuffer1.putOpcode(116);
               Client.secretPacketBuffer1.putShort(class146.baseY + var1);
               Client.secretPacketBuffer1.method3234(var3 >> 14 & 32767);
               Client.secretPacketBuffer1.method3223(class50.field624[82]?1:0);
               Client.secretPacketBuffer1.method3382(class166.baseX + var0);
            }

            if(var2 == 11) {
               var18 = Client.cachedNPCs[var3];
               if(var18 != null) {
                  Client.field997 = var6;
                  Client.field998 = var7;
                  Client.field1016 = 2;
                  Client.field999 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.secretPacketBuffer1.putOpcode(130);
                  Client.secretPacketBuffer1.method3408(class50.field624[82]?1:0);
                  Client.secretPacketBuffer1.putShort(var3);
               }
            }

            if(var2 == 32) {
               Client.secretPacketBuffer1.putOpcode(76);
               Client.secretPacketBuffer1.method3234(var0);
               Client.secretPacketBuffer1.method3232(Client.field1046);
               Client.secretPacketBuffer1.method3243(var1);
               Client.secretPacketBuffer1.method3382(var3);
               Client.secretPacketBuffer1.method3243(CollisionData.field2278);
               Client.field1001 = 0;
               class37.field507 = class261.method4792(var1);
               Client.field1002 = var0;
            }

            if(var2 == 1) {
               Client.field997 = var6;
               Client.field998 = var7;
               Client.field1016 = 2;
               Client.field999 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretPacketBuffer1.putOpcode(13);
               Client.secretPacketBuffer1.method3285(class214.field2622);
               Client.secretPacketBuffer1.method3232(class146.baseY + var1);
               Client.secretPacketBuffer1.method3232(var3 >> 14 & 32767);
               Client.secretPacketBuffer1.method3234(WorldMapType0.field612);
               Client.secretPacketBuffer1.method3382(var0 + class166.baseX);
               Client.secretPacketBuffer1.method3223(class50.field624[82]?1:0);
               Client.secretPacketBuffer1.putShort(WidgetNode.field809);
            }

            if(var2 == 1001) {
               Client.field997 = var6;
               Client.field998 = var7;
               Client.field1016 = 2;
               Client.field999 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretPacketBuffer1.putOpcode(4);
               Client.secretPacketBuffer1.method3232(var1 + class146.baseY);
               Client.secretPacketBuffer1.method3234(var3 >> 14 & 32767);
               Client.secretPacketBuffer1.putByte(class50.field624[82]?1:0);
               Client.secretPacketBuffer1.putShort(class166.baseX + var0);
            }

            if(Client.field1043 != 0) {
               Client.field1043 = 0;
               class219.method4130(class261.method4792(class214.field2622));
            }

            if(Client.field1045) {
               class19.method143();
            }

            if(class37.field507 != null && Client.field1001 == 0) {
               class219.method4130(class37.field507);
            }

         } else {
            var8 = class66.method1099(var1, var0);
            if(var8 != null) {
               class19.method143();
               int var10 = class43.method626(var8);
               var20 = var10 >> 11 & 63;
               int var12 = var8.itemId;
               Widget var13 = class66.method1099(var1, var0);
               if(var13 != null && var13.field2733 != null) {
                  class69 var14 = new class69();
                  var14.field816 = var13;
                  var14.field826 = var13.field2733;
                  GroundObject.method2522(var14);
               }

               Client.field1047 = var12;
               Client.field1045 = true;
               CollisionData.field2278 = var1;
               Client.field1046 = var0;
               class24.field364 = var20;
               class219.method4130(var13);
               Client.field1043 = 0;
               int var15 = class43.method626(var8);
               int var17 = var15 >> 11 & 63;
               String var21;
               if(var17 == 0) {
                  var21 = null;
               } else if(var8.field2721 != null && var8.field2721.trim().length() != 0) {
                  var21 = var8.field2721;
               } else {
                  var21 = null;
               }

               Client.field1048 = var21;
               if(Client.field1048 == null) {
                  Client.field1048 = "Null";
               }

               if(var8.hasScript) {
                  Client.field1049 = var8.name + class82.method1610(16777215);
               } else {
                  Client.field1049 = class82.method1610('\uff00') + var8.field2750 + class82.method1610(16777215);
               }
            }

         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-1883181210"
   )
   static final boolean method4046(char var0) {
      return var0 == 160 || var0 == 32 || var0 == 95 || var0 == 45;
   }
}
