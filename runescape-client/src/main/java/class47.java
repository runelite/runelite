import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("al")
public class class47 {
   @ObfuscatedName("ng")
   @ObfuscatedGetter(
      intValue = -517677971
   )
   static int field950;
   @ObfuscatedName("j")
   static final class121 field951 = new class121(1024);
   @ObfuscatedName("c")
   static final class136 field952 = new class136();
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 559861345
   )
   static int field953 = 0;
   @ObfuscatedName("x")
   @Export("chatLineMap")
   static final Map chatLineMap = new HashMap();
   @ObfuscatedName("k")
   @Export("isMembersWorld")
   public static boolean isMembersWorld;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1142280270"
   )
   static final void method950() {
      if(class140.field1977 != null) {
         class140.field1977.method1122();
      }

      if(Buffer.field2089 != null) {
         Buffer.field2089.method1122();
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass159;I)I",
      garbageValue = "1790967084"
   )
   static int method954(CipherBuffer var0) {
      int var1 = var0.method3097(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.method3097(5);
      } else if(var1 == 2) {
         var2 = var0.method3097(8);
      } else {
         var2 = var0.method3097(11);
      }

      return var2;
   }

   class47() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "-1950346014"
   )
   public static String method962(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 < 97 || var4 > 122) && (var4 < 65 || var4 > 90) && (var4 < 48 || var4 > 57) && var4 != 46 && var4 != 45 && var4 != 42 && var4 != 95) {
            if(var4 == 32) {
               var2.append('+');
            } else {
               byte var5 = class18.method215(var4);
               var2.append('%');
               int var6 = var5 >> 4 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }

               var6 = var5 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(48 + var6));
               }
            }
         } else {
            var2.append(var4);
         }
      }

      return var2.toString();
   }

   @ObfuscatedName("dl")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "157188828"
   )
   static final void method964() {
      class2.method36(Client.field486);
      ++World.field709;
      if(Client.field450 && Client.field491) {
         int var0 = class115.field1807;
         int var1 = class115.field1801;
         var0 -= Client.field526;
         var1 -= Client.field470;
         if(var0 < Client.field344) {
            var0 = Client.field344;
         }

         if(Client.field486.width + var0 > Client.field487.width + Client.field344) {
            var0 = Client.field487.width + Client.field344 - Client.field486.width;
         }

         if(var1 < Client.field590) {
            var1 = Client.field590;
         }

         if(Client.field486.height + var1 > Client.field487.height + Client.field590) {
            var1 = Client.field487.height + Client.field590 - Client.field486.height;
         }

         int var2 = var0 - Client.field495;
         int var3 = var1 - Client.field530;
         int var4 = Client.field486.field2262;
         if(World.field709 > Client.field486.field2216 && (var2 > var4 || var2 < -var4 || var3 > var4 || var3 < -var4)) {
            Client.field398 = true;
         }

         int var5 = Client.field487.scrollX + (var0 - Client.field344);
         int var6 = var1 - Client.field590 + Client.field487.scrollY;
         class18 var7;
         if(Client.field486.field2275 != null && Client.field398) {
            var7 = new class18();
            var7.field223 = Client.field486;
            var7.field222 = var5;
            var7.field225 = var6;
            var7.field232 = Client.field486.field2275;
            Frames.method1963(var7);
         }

         if(class115.field1806 == 0) {
            if(Client.field398) {
               if(null != Client.field486.field2303) {
                  var7 = new class18();
                  var7.field223 = Client.field486;
                  var7.field222 = var5;
                  var7.field225 = var6;
                  var7.field227 = Client.field490;
                  var7.field232 = Client.field486.field2303;
                  Frames.method1963(var7);
               }

               if(Client.field490 != null) {
                  Widget var8 = Client.field486;
                  int var10 = class174.method3271(var8);
                  int var9 = var10 >> 17 & 7;
                  int var11 = var9;
                  Widget var15;
                  if(var9 == 0) {
                     var15 = null;
                  } else {
                     int var12 = 0;

                     while(true) {
                        if(var12 >= var11) {
                           var15 = var8;
                           break;
                        }

                        var8 = World.method670(var8.parentId);
                        if(null == var8) {
                           var15 = null;
                           break;
                        }

                        ++var12;
                     }
                  }

                  if(var15 != null) {
                     Client.secretCipherBuffer1.putOpcode(157);
                     Client.secretCipherBuffer1.method2864(Client.field490.item);
                     Client.secretCipherBuffer1.method2864(Client.field486.index);
                     Client.secretCipherBuffer1.method2865(Client.field490.index);
                     Client.secretCipherBuffer1.method2909(Client.field486.item);
                     Client.secretCipherBuffer1.method2873(Client.field490.id);
                     Client.secretCipherBuffer1.putInt(Client.field486.id);
                  }
               }
            } else {
               label193: {
                  int var14 = class145.method2764();
                  if(Client.menuOptionCount > 2) {
                     label190: {
                        label155: {
                           if(Client.field388 == 1) {
                              boolean var13;
                              if(Client.menuOptionCount <= 0) {
                                 var13 = false;
                              } else if(Client.field561 && class105.field1725[81] && Client.field391 != -1) {
                                 var13 = true;
                              } else {
                                 var13 = false;
                              }

                              if(!var13) {
                                 break label155;
                              }
                           }

                           if(!Player.method272(var14)) {
                              break label190;
                           }
                        }

                        class30.method687(Client.field526 + Client.field495, Client.field530 + Client.field470);
                        break label193;
                     }
                  }

                  if(Client.menuOptionCount > 0) {
                     Renderable.method1940(Client.field526 + Client.field495, Client.field470 + Client.field530);
                  }
               }
            }

            Client.field486 = null;
         }

      } else {
         if(World.field709 > 1) {
            Client.field486 = null;
         }

      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1854459198"
   )
   static final void processLoginState() {
      try {
         if(Client.loginState == 0) {
            if(null != class1.field15) {
               class1.field15.method2115();
               class1.field15 = null;
            }

            WidgetNode.field213 = null;
            Client.field587 = false;
            Client.field471 = 0;
            Client.loginState = 1;
         }

         if(Client.loginState == 1) {
            if(null == WidgetNode.field213) {
               WidgetNode.field213 = class72.field1193.method2022(WallObject.host, GameObject.field1636);
            }

            if(WidgetNode.field213.field1673 == 2) {
               throw new IOException();
            }

            if(WidgetNode.field213.field1673 == 1) {
               class1.field15 = new RSSocket((Socket)WidgetNode.field213.field1677, class72.field1193);
               WidgetNode.field213 = null;
               Client.loginState = 2;
            }
         }

         if(Client.loginState == 2) {
            Client.secretCipherBuffer1.offset = 0;
            Client.secretCipherBuffer1.putByte(14);
            class1.field15.queueForWrite(Client.secretCipherBuffer1.payload, 0, 1);
            Client.secretCipherBuffer2.offset = 0;
            Client.loginState = 3;
         }

         int var0;
         if(Client.loginState == 3) {
            if(Buffer.field2089 != null) {
               Buffer.field2089.method1123();
            }

            if(null != class140.field1977) {
               class140.field1977.method1123();
            }

            var0 = class1.field15.method2118();
            if(Buffer.field2089 != null) {
               Buffer.field2089.method1123();
            }

            if(null != class140.field1977) {
               class140.field1977.method1123();
            }

            if(var0 != 0) {
               class8.method105(var0);
               return;
            }

            Client.secretCipherBuffer2.offset = 0;
            Client.loginState = 4;
         }

         if(Client.loginState == 4) {
            if(Client.secretCipherBuffer2.offset < 8) {
               var0 = class1.field15.method2116();
               if(var0 > 8 - Client.secretCipherBuffer2.offset) {
                  var0 = 8 - Client.secretCipherBuffer2.offset;
               }

               if(var0 > 0) {
                  class1.field15.method2119(Client.secretCipherBuffer2.payload, Client.secretCipherBuffer2.offset, var0);
                  Client.secretCipherBuffer2.offset += var0;
               }
            }

            if(Client.secretCipherBuffer2.offset == 8) {
               Client.secretCipherBuffer2.offset = 0;
               WidgetNode.field216 = Client.secretCipherBuffer2.readLong();
               Client.loginState = 5;
            }
         }

         int var1;
         int var2;
         if(Client.loginState == 5) {
            int[] secret = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(WidgetNode.field216 >> 32), (int)(WidgetNode.field216 & -1L)};
            Client.secretCipherBuffer1.offset = 0;
            Client.secretCipherBuffer1.putByte(1);
            Client.secretCipherBuffer1.putByte(class41.field874.vmethod4085());
            Client.secretCipherBuffer1.putInt(secret[0]);
            Client.secretCipherBuffer1.putInt(secret[1]);
            Client.secretCipherBuffer1.putInt(secret[2]);
            Client.secretCipherBuffer1.putInt(secret[3]);
            switch(class41.field874.field1642) {
            case 0:
               Client.secretCipherBuffer1.putInt(((Integer)class8.field84.field722.get(Integer.valueOf(class152.method2814(class41.username)))).intValue());
               Client.secretCipherBuffer1.offset += 4;
               break;
            case 1:
            case 2:
               Client.secretCipherBuffer1.put24bitInt(CombatInfoListHolder.field781);
               Client.secretCipherBuffer1.offset += 5;
               break;
            case 3:
               Client.secretCipherBuffer1.offset += 8;
            }

            Client.secretCipherBuffer1.method2822(class41.password);
            Client.secretCipherBuffer1.method2852(class39.field833, class39.field834);
            Client.field356.offset = 0;
            if(Client.gameState == 40) {
               Client.field356.putByte(18);
            } else {
               Client.field356.putByte(16);
            }

            Client.field356.putShort(0);
            var1 = Client.field356.offset;
            Client.field356.putInt(138);
            Client.field356.putBytes(Client.secretCipherBuffer1.payload, 0, Client.secretCipherBuffer1.offset);
            var2 = Client.field356.offset;
            Client.field356.method2822(class41.username);
            Client.field356.putByte((Client.isResized?1:0) << 1 | (Client.field439?1:0));
            Client.field356.putShort(class108.field1748);
            Client.field356.putShort(class145.field2018);
            CipherBuffer var3 = Client.field356;
            if(Client.field349 != null) {
               var3.putBytes(Client.field349, 0, Client.field349.length);
            } else {
               byte[] var5 = new byte[24];

               try {
                  class104.field1695.method1446(0L);
                  class104.field1695.method1448(var5);

                  int var6;
                  for(var6 = 0; var6 < 24 && var5[var6] == 0; ++var6) {
                     ;
                  }

                  if(var6 >= 24) {
                     throw new IOException();
                  }
               } catch (Exception var14) {
                  for(int var7 = 0; var7 < 24; ++var7) {
                     var5[var7] = -1;
                  }
               }

               var3.putBytes(var5, 0, var5.length);
            }

            Client.field356.method2822(class178.field2666);
            Client.field356.putInt(Client.field316);
            Buffer var4 = new Buffer(class7.field75.method4293());
            class7.field75.method4292(var4);
            Client.field356.putBytes(var4.payload, 0, var4.payload.length);
            Client.field356.putByte(class25.field611);
            Client.field356.putInt(0);
            Client.field356.putInt(Client.field341.field2711);
            Client.field356.putInt(FloorUnderlayDefinition.field2811.field2711);
            Client.field356.putInt(class2.field27.field2711);
            Client.field356.putInt(RSCanvas.field1765.field2711);
            Client.field356.putInt(class188.field2778.field2711);
            Client.field356.putInt(class33.field778.field2711);
            Client.field356.putInt(class3.field39.field2711);
            Client.field356.putInt(class195.field2859.field2711);
            Client.field356.putInt(class0.field2.field2711);
            Client.field356.putInt(KitDefinition.field2825.field2711);
            Client.field356.putInt(class99.field1655.field2711);
            Client.field356.putInt(class1.field12.field2711);
            Client.field356.putInt(RSSocket.field1763.field2711);
            Client.field356.putInt(class140.field1965.field2711);
            Client.field356.putInt(class37.field820.field2711);
            Client.field356.putInt(Client.field460.field2711);
            Client.field356.encryptXtea(secret, var2, Client.field356.offset);
            Client.field356.method2945(Client.field356.offset - var1);
            class1.field15.queueForWrite(Client.field356.payload, 0, Client.field356.offset);
            Client.secretCipherBuffer1.seed(secret);

            for(int var10 = 0; var10 < 4; ++var10) {
               secret[var10] += 50;
            }

            Client.secretCipherBuffer2.seed(secret);
            Client.loginState = 6;
         }

         if(Client.loginState == 6 && class1.field15.method2116() > 0) {
            var0 = class1.field15.method2118();
            if(var0 == 21 && Client.gameState == 20) {
               Client.loginState = 7;
            } else if(var0 == 2) {
               Client.loginState = 9;
            } else if(var0 == 15 && Client.gameState == 40) {
               Client.field358 = -1;
               Client.loginState = 13;
            } else if(var0 == 23 && Client.field565 < 1) {
               ++Client.field565;
               Client.loginState = 0;
            } else {
               if(var0 != 29) {
                  class8.method105(var0);
                  return;
               }

               Client.loginState = 11;
            }
         }

         if(Client.loginState == 7 && class1.field15.method2116() > 0) {
            Client.field347 = (class1.field15.method2118() + 3) * 60;
            Client.loginState = 8;
         }

         if(Client.loginState == 8) {
            Client.field471 = 0;
            class5.method67("You have only just left another world.", "Your profile will be transferred in:", Client.field347 / 60 + " seconds.");
            if(--Client.field347 <= 0) {
               Client.loginState = 0;
            }

         } else {
            if(Client.loginState == 9 && class1.field15.method2116() >= 13) {
               boolean var17 = class1.field15.method2118() == 1;
               class1.field15.method2119(Client.secretCipherBuffer2.payload, 0, 4);
               Client.secretCipherBuffer2.offset = 0;
               boolean var16 = false;
               if(var17) {
                  var1 = Client.secretCipherBuffer2.readOpcode() << 24;
                  var1 |= Client.secretCipherBuffer2.readOpcode() << 16;
                  var1 |= Client.secretCipherBuffer2.readOpcode() << 8;
                  var1 |= Client.secretCipherBuffer2.readOpcode();
                  var2 = class152.method2814(class41.username);
                  if(class8.field84.field722.size() >= 10 && !class8.field84.field722.containsKey(Integer.valueOf(var2))) {
                     Iterator var18 = class8.field84.field722.entrySet().iterator();
                     var18.next();
                     var18.remove();
                  }

                  class8.field84.field722.put(Integer.valueOf(var2), Integer.valueOf(var1));
                  class0.method10();
               }

               Client.field480 = class1.field15.method2118();
               Client.field482 = class1.field15.method2118() == 1;
               Client.localInteractingIndex = class1.field15.method2118();
               Client.localInteractingIndex <<= 8;
               Client.localInteractingIndex += class1.field15.method2118();
               Client.field529 = class1.field15.method2118();
               class1.field15.method2119(Client.secretCipherBuffer2.payload, 0, 1);
               Client.secretCipherBuffer2.offset = 0;
               Client.packetOpcode = Client.secretCipherBuffer2.readOpcode();
               class1.field15.method2119(Client.secretCipherBuffer2.payload, 0, 2);
               Client.secretCipherBuffer2.offset = 0;
               Client.field358 = Client.secretCipherBuffer2.readUnsignedShort();

               try {
                  Client var11 = Client.field308;
                  JSObject.getWindow(var11).call("zap", (Object[])null);
               } catch (Throwable var13) {
                  ;
               }

               Client.loginState = 10;
            }

            if(Client.loginState == 10) {
               if(class1.field15.method2116() >= Client.field358) {
                  Client.secretCipherBuffer2.offset = 0;
                  class1.field15.method2119(Client.secretCipherBuffer2.payload, 0, Client.field358);
                  class154.method3038();
                  Ignore.method216(Client.secretCipherBuffer2);
                  FileOnDisk.field1203 = -1;
                  FrameMap.xteaChanged(false);
                  Client.packetOpcode = -1;
               }

            } else {
               if(Client.loginState == 11 && class1.field15.method2116() >= 2) {
                  Client.secretCipherBuffer2.offset = 0;
                  class1.field15.method2119(Client.secretCipherBuffer2.payload, 0, 2);
                  Client.secretCipherBuffer2.offset = 0;
                  FileOnDisk.field1201 = Client.secretCipherBuffer2.readUnsignedShort();
                  Client.loginState = 12;
               }

               if(Client.loginState == 12 && class1.field15.method2116() >= FileOnDisk.field1201) {
                  Client.secretCipherBuffer2.offset = 0;
                  class1.field15.method2119(Client.secretCipherBuffer2.payload, 0, FileOnDisk.field1201);
                  Client.secretCipherBuffer2.offset = 0;
                  String var19 = Client.secretCipherBuffer2.readString();
                  String var12 = Client.secretCipherBuffer2.readString();
                  String var20 = Client.secretCipherBuffer2.readString();
                  class5.method67(var19, var12, var20);
                  class187.setGameState(10);
               }

               if(Client.loginState != 13) {
                  ++Client.field471;
                  if(Client.field471 > 2000) {
                     if(Client.field565 < 1) {
                        if(GameObject.field1636 == Ignore.field238) {
                           GameObject.field1636 = Client.field446;
                        } else {
                           GameObject.field1636 = Ignore.field238;
                        }

                        ++Client.field565;
                        Client.loginState = 0;
                     } else {
                        class8.method105(-3);
                     }
                  }
               } else {
                  if(Client.field358 == -1) {
                     if(class1.field15.method2116() < 2) {
                        return;
                     }

                     class1.field15.method2119(Client.secretCipherBuffer2.payload, 0, 2);
                     Client.secretCipherBuffer2.offset = 0;
                     Client.field358 = Client.secretCipherBuffer2.readUnsignedShort();
                  }

                  if(class1.field15.method2116() >= Client.field358) {
                     class1.field15.method2119(Client.secretCipherBuffer2.payload, 0, Client.field358);
                     Client.secretCipherBuffer2.offset = 0;
                     var0 = Client.field358;
                     Client.secretCipherBuffer1.offset = 0;
                     Client.secretCipherBuffer2.offset = 0;
                     Client.packetOpcode = -1;
                     Client.field483 = -1;
                     Client.field363 = -1;
                     Client.field364 = -1;
                     Client.field358 = 0;
                     Client.field360 = 0;
                     Client.field327 = 0;
                     Client.menuOptionCount = 0;
                     Client.field391 = -1;
                     Client.isMenuOpen = false;
                     Client.field549 = 0;
                     Client.flagX = 0;

                     for(var1 = 0; var1 < 2048; ++var1) {
                        Client.cachedPlayers[var1] = null;
                     }

                     class22.localPlayer = null;

                     for(var1 = 0; var1 < Client.cachedNPCs.length; ++var1) {
                        NPC var21 = Client.cachedNPCs[var1];
                        if(null != var21) {
                           var21.interacting = -1;
                           var21.field652 = false;
                        }
                     }

                     class10.method167();
                     class187.setGameState(30);

                     for(var1 = 0; var1 < 100; ++var1) {
                        Client.field518[var1] = true;
                     }

                     class45.method910();
                     Ignore.method216(Client.secretCipherBuffer2);
                     if(var0 != Client.secretCipherBuffer2.offset) {
                        throw new RuntimeException();
                     }
                  }
               }
            }
         }
      } catch (IOException var15) {
         if(Client.field565 < 1) {
            if(Ignore.field238 == GameObject.field1636) {
               GameObject.field1636 = Client.field446;
            } else {
               GameObject.field1636 = Ignore.field238;
            }

            ++Client.field565;
            Client.loginState = 0;
         } else {
            class8.method105(-2);
         }
      }
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "477806217"
   )
   static final void method966() {
      for(class33 var0 = (class33)Client.field443.method2448(); null != var0; var0 = (class33)Client.field443.method2445()) {
         if(var0.field766 == class31.plane && !var0.field773) {
            if(Client.gameCycle >= var0.field765) {
               var0.method754(Client.field328);
               if(var0.field773) {
                  var0.unlink();
               } else {
                  Friend.region.method1765(var0.field766, var0.field767, var0.field768, var0.field776, 60, var0, 0, -1, false);
               }
            }
         } else {
            var0.unlink();
         }
      }

   }
}
