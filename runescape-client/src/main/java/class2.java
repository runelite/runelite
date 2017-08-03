import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
final class class2 implements class0 {
   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "Lfz;"
   )
   @Export("rssocket")
   static RSSocket rssocket;
   @ObfuscatedName("oy")
   @ObfuscatedSignature(
      signature = "Ldb;"
   )
   static class104 field18;
   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("indexTrack1")
   static IndexData indexTrack1;

   @ObfuscatedName("fv")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "115784836"
   )
   @Export("setGameState")
   static void setGameState(int var0) {
      if(var0 != Client.gameState) {
         if(Client.gameState == 0) {
            Projectile.clientInstance.method884();
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.loginState = 0;
            Client.field1058 = 0;
            Client.field928 = 0;
         }

         if(var0 != 20 && var0 != 40 && NPC.field1339 != null) {
            NPC.field1339.close();
            NPC.field1339 = null;
         }

         if(Client.gameState == 25) {
            Client.field953 = 0;
            Client.field949 = 0;
            Client.field950 = 1;
            Client.field951 = 0;
            Client.field952 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               class40.method553(class221.field2806, CombatInfo1.indexSprites, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               class40.method553(class221.field2806, CombatInfo1.indexSprites, false, 4);
            } else {
               MouseInput.method1047();
            }
         } else {
            class40.method553(class221.field2806, CombatInfo1.indexSprites, true, 0);
         }

         Client.gameState = var0;
      }
   }

   @ObfuscatedName("ib")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "-604125466"
   )
   @Export("drawWidget")
   static final void drawWidget(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(class7.loadWidget(var0)) {
         class67.field797 = null;
         class215.gameDraw(class170.widgets[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(class67.field797 != null) {
            class215.gameDraw(class67.field797, -1412584499, var1, var2, var3, var4, class51.field623, class7.field226, var7);
            class67.field797 = null;
         }

      } else {
         if(var7 != -1) {
            Client.field1088[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               Client.field1088[var8] = true;
            }
         }

      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-1398674076"
   )
   static long method3() {
      try {
         URL var0 = new URL(class71.method1131("services", false) + "m=accountappeal/login.ws");
         URLConnection var1 = var0.openConnection();
         var1.setRequestProperty("connection", "close");
         var1.setDoInput(true);
         var1.setDoOutput(true);
         var1.setConnectTimeout(5000);
         OutputStreamWriter var2 = new OutputStreamWriter(var1.getOutputStream());
         var2.write("data1=req");
         var2.flush();
         InputStream var3 = var1.getInputStream();
         Buffer var4 = new Buffer(new byte[1000]);

         do {
            int var5 = var3.read(var4.payload, var4.offset, 1000 - var4.offset);
            if(var5 == -1) {
               var4.offset = 0;
               long var7 = var4.readLong();
               return var7;
            }

            var4.offset += var5;
         } while(var4.offset < 1000);

         return 0L;
      } catch (Exception var9) {
         return 0L;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ILcd;ZI)I",
      garbageValue = "778830813"
   )
   static int method2(int var0, Script var1, boolean var2) {
      if(var0 == 5000) {
         class83.intStack[++class83.intStackSize - 1] = Client.field1100;
         return 1;
      } else {
         int var4;
         int var6;
         if(var0 == 5001) {
            class83.intStackSize -= 3;
            Client.field1100 = class83.intStack[class83.intStackSize];
            var4 = class83.intStack[class83.intStackSize + 1];
            class276[] var27 = class140.method2890();
            var6 = 0;

            class276 var31;
            while(true) {
               if(var6 >= var27.length) {
                  var31 = null;
                  break;
               }

               class276 var28 = var27[var6];
               if(var4 == var28.field3722) {
                  var31 = var28;
                  break;
               }

               ++var6;
            }

            class276.field3721 = var31;
            if(class276.field3721 == null) {
               class276.field3721 = class276.field3718;
            }

            Client.field1044 = class83.intStack[class83.intStackSize + 2];
            Client.secretPacketBuffer1.putOpcode(215);
            Client.secretPacketBuffer1.putByte(Client.field1100);
            Client.secretPacketBuffer1.putByte(class276.field3721.field3722);
            Client.secretPacketBuffer1.putByte(Client.field1044);
            return 1;
         } else {
            String var3;
            int var16;
            if(var0 == 5002) {
               var3 = class83.scriptStringStack[--Timer.scriptStringStackSize];
               class83.intStackSize -= 2;
               var4 = class83.intStack[class83.intStackSize];
               var16 = class83.intStack[class83.intStackSize + 1];
               Client.secretPacketBuffer1.putOpcode(160);
               Client.secretPacketBuffer1.putByte(VertexNormal.getLength(var3) + 2);
               Client.secretPacketBuffer1.putString(var3);
               Client.secretPacketBuffer1.putByte(var4 - 1);
               Client.secretPacketBuffer1.putByte(var16);
               return 1;
            } else {
               int var17;
               if(var0 == 5003) {
                  class83.intStackSize -= 2;
                  var17 = class83.intStack[class83.intStackSize];
                  var4 = class83.intStack[class83.intStackSize + 1];
                  MessageNode var26 = WorldMapType2.method543(var17, var4);
                  if(var26 != null) {
                     class83.intStack[++class83.intStackSize - 1] = var26.id;
                     class83.intStack[++class83.intStackSize - 1] = var26.tick;
                     class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = var26.name != null?var26.name:"";
                     class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = var26.sender != null?var26.sender:"";
                     class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = var26.value != null?var26.value:"";
                  } else {
                     class83.intStack[++class83.intStackSize - 1] = -1;
                     class83.intStack[++class83.intStackSize - 1] = 0;
                     class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = "";
                     class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = "";
                     class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = "";
                  }

                  return 1;
               } else if(var0 == 5004) {
                  var17 = class83.intStack[--class83.intStackSize];
                  MessageNode var33 = (MessageNode)class98.field1494.get((long)var17);
                  if(var33 != null) {
                     class83.intStack[++class83.intStackSize - 1] = var33.type;
                     class83.intStack[++class83.intStackSize - 1] = var33.tick;
                     class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = var33.name != null?var33.name:"";
                     class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = var33.sender != null?var33.sender:"";
                     class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = var33.value != null?var33.value:"";
                  } else {
                     class83.intStack[++class83.intStackSize - 1] = -1;
                     class83.intStack[++class83.intStackSize - 1] = 0;
                     class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = "";
                     class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = "";
                     class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = "";
                  }

                  return 1;
               } else if(var0 == 5005) {
                  if(class276.field3721 == null) {
                     class83.intStack[++class83.intStackSize - 1] = -1;
                  } else {
                     class83.intStack[++class83.intStackSize - 1] = class276.field3721.field3722;
                  }

                  return 1;
               } else if(var0 == 5008) {
                  var3 = class83.scriptStringStack[--Timer.scriptStringStackSize];
                  var4 = class83.intStack[--class83.intStackSize];
                  String var5 = var3.toLowerCase();
                  byte var29 = 0;
                  if(var5.startsWith("yellow:")) {
                     var29 = 0;
                     var3 = var3.substring("yellow:".length());
                  } else if(var5.startsWith("red:")) {
                     var29 = 1;
                     var3 = var3.substring("red:".length());
                  } else if(var5.startsWith("green:")) {
                     var29 = 2;
                     var3 = var3.substring("green:".length());
                  } else if(var5.startsWith("cyan:")) {
                     var29 = 3;
                     var3 = var3.substring("cyan:".length());
                  } else if(var5.startsWith("purple:")) {
                     var29 = 4;
                     var3 = var3.substring("purple:".length());
                  } else if(var5.startsWith("white:")) {
                     var29 = 5;
                     var3 = var3.substring("white:".length());
                  } else if(var5.startsWith("flash1:")) {
                     var29 = 6;
                     var3 = var3.substring("flash1:".length());
                  } else if(var5.startsWith("flash2:")) {
                     var29 = 7;
                     var3 = var3.substring("flash2:".length());
                  } else if(var5.startsWith("flash3:")) {
                     var29 = 8;
                     var3 = var3.substring("flash3:".length());
                  } else if(var5.startsWith("glow1:")) {
                     var29 = 9;
                     var3 = var3.substring("glow1:".length());
                  } else if(var5.startsWith("glow2:")) {
                     var29 = 10;
                     var3 = var3.substring("glow2:".length());
                  } else if(var5.startsWith("glow3:")) {
                     var29 = 11;
                     var3 = var3.substring("glow3:".length());
                  } else if(Client.languageId != 0) {
                     if(var5.startsWith("yellow:")) {
                        var29 = 0;
                        var3 = var3.substring("yellow:".length());
                     } else if(var5.startsWith("red:")) {
                        var29 = 1;
                        var3 = var3.substring("red:".length());
                     } else if(var5.startsWith("green:")) {
                        var29 = 2;
                        var3 = var3.substring("green:".length());
                     } else if(var5.startsWith("cyan:")) {
                        var29 = 3;
                        var3 = var3.substring("cyan:".length());
                     } else if(var5.startsWith("purple:")) {
                        var29 = 4;
                        var3 = var3.substring("purple:".length());
                     } else if(var5.startsWith("white:")) {
                        var29 = 5;
                        var3 = var3.substring("white:".length());
                     } else if(var5.startsWith("flash1:")) {
                        var29 = 6;
                        var3 = var3.substring("flash1:".length());
                     } else if(var5.startsWith("flash2:")) {
                        var29 = 7;
                        var3 = var3.substring("flash2:".length());
                     } else if(var5.startsWith("flash3:")) {
                        var29 = 8;
                        var3 = var3.substring("flash3:".length());
                     } else if(var5.startsWith("glow1:")) {
                        var29 = 9;
                        var3 = var3.substring("glow1:".length());
                     } else if(var5.startsWith("glow2:")) {
                        var29 = 10;
                        var3 = var3.substring("glow2:".length());
                     } else if(var5.startsWith("glow3:")) {
                        var29 = 11;
                        var3 = var3.substring("glow3:".length());
                     }
                  }

                  var5 = var3.toLowerCase();
                  byte var34 = 0;
                  if(var5.startsWith("wave:")) {
                     var34 = 1;
                     var3 = var3.substring("wave:".length());
                  } else if(var5.startsWith("wave2:")) {
                     var34 = 2;
                     var3 = var3.substring("wave2:".length());
                  } else if(var5.startsWith("shake:")) {
                     var34 = 3;
                     var3 = var3.substring("shake:".length());
                  } else if(var5.startsWith("scroll:")) {
                     var34 = 4;
                     var3 = var3.substring("scroll:".length());
                  } else if(var5.startsWith("slide:")) {
                     var34 = 5;
                     var3 = var3.substring("slide:".length());
                  } else if(Client.languageId != 0) {
                     if(var5.startsWith("wave:")) {
                        var34 = 1;
                        var3 = var3.substring("wave:".length());
                     } else if(var5.startsWith("wave2:")) {
                        var34 = 2;
                        var3 = var3.substring("wave2:".length());
                     } else if(var5.startsWith("shake:")) {
                        var34 = 3;
                        var3 = var3.substring("shake:".length());
                     } else if(var5.startsWith("scroll:")) {
                        var34 = 4;
                        var3 = var3.substring("scroll:".length());
                     } else if(var5.startsWith("slide:")) {
                        var34 = 5;
                        var3 = var3.substring("slide:".length());
                     }
                  }

                  Client.secretPacketBuffer1.putOpcode(174);
                  Client.secretPacketBuffer1.putByte(0);
                  int var8 = Client.secretPacketBuffer1.offset;
                  Client.secretPacketBuffer1.putByte(var4);
                  Client.secretPacketBuffer1.putByte(var29);
                  Client.secretPacketBuffer1.putByte(var34);
                  PacketBuffer var9 = Client.secretPacketBuffer1;
                  int var10 = var9.offset;
                  int var30 = var3.length();
                  byte[] var13 = new byte[var30];

                  for(int var14 = 0; var14 < var30; ++var14) {
                     char var15 = var3.charAt(var14);
                     if(var15 > 0 && var15 < 128 || var15 >= 160 && var15 <= 255) {
                        var13[var14] = (byte)var15;
                     } else if(var15 == 8364) {
                        var13[var14] = -128;
                     } else if(var15 == 8218) {
                        var13[var14] = -126;
                     } else if(var15 == 402) {
                        var13[var14] = -125;
                     } else if(var15 == 8222) {
                        var13[var14] = -124;
                     } else if(var15 == 8230) {
                        var13[var14] = -123;
                     } else if(var15 == 8224) {
                        var13[var14] = -122;
                     } else if(var15 == 8225) {
                        var13[var14] = -121;
                     } else if(var15 == 710) {
                        var13[var14] = -120;
                     } else if(var15 == 8240) {
                        var13[var14] = -119;
                     } else if(var15 == 352) {
                        var13[var14] = -118;
                     } else if(var15 == 8249) {
                        var13[var14] = -117;
                     } else if(var15 == 338) {
                        var13[var14] = -116;
                     } else if(var15 == 381) {
                        var13[var14] = -114;
                     } else if(var15 == 8216) {
                        var13[var14] = -111;
                     } else if(var15 == 8217) {
                        var13[var14] = -110;
                     } else if(var15 == 8220) {
                        var13[var14] = -109;
                     } else if(var15 == 8221) {
                        var13[var14] = -108;
                     } else if(var15 == 8226) {
                        var13[var14] = -107;
                     } else if(var15 == 8211) {
                        var13[var14] = -106;
                     } else if(var15 == 8212) {
                        var13[var14] = -105;
                     } else if(var15 == 732) {
                        var13[var14] = -104;
                     } else if(var15 == 8482) {
                        var13[var14] = -103;
                     } else if(var15 == 353) {
                        var13[var14] = -102;
                     } else if(var15 == 8250) {
                        var13[var14] = -101;
                     } else if(var15 == 339) {
                        var13[var14] = -100;
                     } else if(var15 == 382) {
                        var13[var14] = -98;
                     } else if(var15 == 376) {
                        var13[var14] = -97;
                     } else {
                        var13[var14] = 63;
                     }
                  }

                  var9.putShortSmart(var13.length);
                  var9.offset += class265.field3639.compress(var13, 0, var13.length, var9.payload, var9.offset);
                  Client.secretPacketBuffer1.putLength(Client.secretPacketBuffer1.offset - var8);
                  return 1;
               } else if(var0 == 5009) {
                  Timer.scriptStringStackSize -= 2;
                  var3 = class83.scriptStringStack[Timer.scriptStringStackSize];
                  String var32 = class83.scriptStringStack[Timer.scriptStringStackSize + 1];
                  Client.secretPacketBuffer1.putOpcode(45);
                  Client.secretPacketBuffer1.putShort(0);
                  var16 = Client.secretPacketBuffer1.offset;
                  Client.secretPacketBuffer1.putString(var3);
                  PacketBuffer var21 = Client.secretPacketBuffer1;
                  int var19 = var21.offset;
                  int var22 = var32.length();
                  byte[] var23 = new byte[var22];

                  for(int var24 = 0; var24 < var22; ++var24) {
                     char var12 = var32.charAt(var24);
                     if((var12 <= 0 || var12 >= 128) && (var12 < 160 || var12 > 255)) {
                        if(var12 == 8364) {
                           var23[var24] = -128;
                        } else if(var12 == 8218) {
                           var23[var24] = -126;
                        } else if(var12 == 402) {
                           var23[var24] = -125;
                        } else if(var12 == 8222) {
                           var23[var24] = -124;
                        } else if(var12 == 8230) {
                           var23[var24] = -123;
                        } else if(var12 == 8224) {
                           var23[var24] = -122;
                        } else if(var12 == 8225) {
                           var23[var24] = -121;
                        } else if(var12 == 710) {
                           var23[var24] = -120;
                        } else if(var12 == 8240) {
                           var23[var24] = -119;
                        } else if(var12 == 352) {
                           var23[var24] = -118;
                        } else if(var12 == 8249) {
                           var23[var24] = -117;
                        } else if(var12 == 338) {
                           var23[var24] = -116;
                        } else if(var12 == 381) {
                           var23[var24] = -114;
                        } else if(var12 == 8216) {
                           var23[var24] = -111;
                        } else if(var12 == 8217) {
                           var23[var24] = -110;
                        } else if(var12 == 8220) {
                           var23[var24] = -109;
                        } else if(var12 == 8221) {
                           var23[var24] = -108;
                        } else if(var12 == 8226) {
                           var23[var24] = -107;
                        } else if(var12 == 8211) {
                           var23[var24] = -106;
                        } else if(var12 == 8212) {
                           var23[var24] = -105;
                        } else if(var12 == 732) {
                           var23[var24] = -104;
                        } else if(var12 == 8482) {
                           var23[var24] = -103;
                        } else if(var12 == 353) {
                           var23[var24] = -102;
                        } else if(var12 == 8250) {
                           var23[var24] = -101;
                        } else if(var12 == 339) {
                           var23[var24] = -100;
                        } else if(var12 == 382) {
                           var23[var24] = -98;
                        } else if(var12 == 376) {
                           var23[var24] = -97;
                        } else {
                           var23[var24] = 63;
                        }
                     } else {
                        var23[var24] = (byte)var12;
                     }
                  }

                  var21.putShortSmart(var23.length);
                  var21.offset += class265.field3639.compress(var23, 0, var23.length, var21.payload, var21.offset);
                  Client.secretPacketBuffer1.putShortLength(Client.secretPacketBuffer1.offset - var16);
                  return 1;
               } else if(var0 != 5015) {
                  if(var0 == 5016) {
                     class83.intStack[++class83.intStackSize - 1] = Client.field1044;
                     return 1;
                  } else if(var0 == 5017) {
                     var17 = class83.intStack[--class83.intStackSize];
                     class83.intStack[++class83.intStackSize - 1] = DynamicObject.method1870(var17);
                     return 1;
                  } else if(var0 == 5018) {
                     var17 = class83.intStack[--class83.intStackSize];
                     class83.intStack[++class83.intStackSize - 1] = class64.method1104(var17);
                     return 1;
                  } else if(var0 == 5019) {
                     var17 = class83.intStack[--class83.intStackSize];
                     int[] var18 = class83.intStack;
                     var16 = ++class83.intStackSize - 1;
                     MessageNode var7 = (MessageNode)class98.field1494.get((long)var17);
                     if(var7 == null) {
                        var6 = -1;
                     } else if(var7.next == class98.field1495.field2458) {
                        var6 = -1;
                     } else {
                        var6 = ((MessageNode)var7.next).id;
                     }

                     var18[var16] = var6;
                     return 1;
                  } else if(var0 == 5020) {
                     var3 = class83.scriptStringStack[--Timer.scriptStringStackSize];
                     class17.method123(var3);
                     return 1;
                  } else if(var0 == 5021) {
                     Client.field1102 = class83.scriptStringStack[--Timer.scriptStringStackSize].toLowerCase().trim();
                     return 1;
                  } else if(var0 == 5022) {
                     class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = Client.field1102;
                     return 1;
                  } else {
                     return 2;
                  }
               } else {
                  if(class224.localPlayer != null && class224.localPlayer.name != null) {
                     var3 = class224.localPlayer.name;
                  } else {
                     var3 = "";
                  }

                  class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = var3;
                  return 1;
               }
            }
         }
      }
   }
}
