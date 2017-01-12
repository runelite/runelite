import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bn")
public class class60 {
   @ObfuscatedName("u")
   class182 field1072;
   @ObfuscatedName("x")
   class182 field1073;
   @ObfuscatedName("gn")
   @ObfuscatedGetter(
      intValue = 1011292969
   )
   @Export("plane")
   static int plane;
   @ObfuscatedName("a")
   XHashTable field1075 = new XHashTable(256);
   @ObfuscatedName("i")
   XHashTable field1076 = new XHashTable(256);
   @ObfuscatedName("nr")
   @ObfuscatedGetter(
      intValue = -913572445
   )
   static int field1079;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II[II)Lclass55;",
      garbageValue = "-33150655"
   )
   class55 method1082(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class55 var7 = (class55)this.field1075.method2339(var5);
      if(var7 != null) {
         return var7;
      } else if(null != var3 && var3[0] <= 0) {
         return null;
      } else {
         class53 var8 = class53.method955(this.field1072, var1, var2);
         if(null == var8) {
            return null;
         } else {
            var7 = var8.method953();
            this.field1075.method2340(var7, var5);
            if(null != var3) {
               var3[0] -= var7.field1015.length;
            }

            return var7;
         }
      }
   }

   public class60(class182 var1, class182 var2) {
      this.field1072 = var1;
      this.field1073 = var2;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass55;",
      garbageValue = "-1864463249"
   )
   public class55 method1084(int var1, int[] var2) {
      if(this.field1072.method3291() == 1) {
         return this.method1082(0, var1, var2);
      } else if(this.field1072.method3323(var1) == 1) {
         return this.method1082(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I[IB)Lclass55;",
      garbageValue = "1"
   )
   public class55 method1085(int var1, int[] var2) {
      if(this.field1073.method3291() == 1) {
         return this.method1090(0, var1, var2);
      } else if(this.field1073.method3323(var1) == 1) {
         return this.method1090(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II[II)Lclass55;",
      garbageValue = "-2055794295"
   )
   class55 method1090(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class55 var7 = (class55)this.field1075.method2339(var5);
      if(null != var7) {
         return var7;
      } else if(null != var3 && var3[0] <= 0) {
         return null;
      } else {
         class54 var8 = (class54)this.field1076.method2339(var5);
         if(var8 == null) {
            var8 = class54.method960(this.field1073, var1, var2);
            if(var8 == null) {
               return null;
            }

            this.field1076.method2340(var8, var5);
         }

         var7 = var8.method969(var3);
         if(null == var7) {
            return null;
         } else {
            var8.unlink();
            this.field1075.method2340(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("ec")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "908980645"
   )
   static final void method1096(String var0, boolean var1) {
      if(null != var0) {
         if((Client.ignoreCount < 100 || Client.field461 == 1) && Client.ignoreCount < 400) {
            String var2 = class139.method2601(var0, Ignore.field209);
            if(var2 != null) {
               int var3;
               String var5;
               String var6;
               for(var3 = 0; var3 < Client.ignoreCount; ++var3) {
                  Ignore var4 = Client.ignores[var3];
                  var5 = class139.method2601(var4.name, Ignore.field209);
                  if(null != var5 && var5.equals(var2)) {
                     class7.method99(31, "", var0 + " is already on your ignore list");
                     return;
                  }

                  if(var4.previousName != null) {
                     var6 = class139.method2601(var4.previousName, Ignore.field209);
                     if(null != var6 && var6.equals(var2)) {
                        class7.method99(31, "", var0 + " is already on your ignore list");
                        return;
                     }
                  }
               }

               for(var3 = 0; var3 < Client.friendCount; ++var3) {
                  Friend var7 = Client.friends[var3];
                  var5 = class139.method2601(var7.name, Ignore.field209);
                  if(var5 != null && var5.equals(var2)) {
                     class7.method99(31, "", "Please remove " + var0 + " from your friend list first");
                     return;
                  }

                  if(var7.previousName != null) {
                     var6 = class139.method2601(var7.previousName, Ignore.field209);
                     if(var6 != null && var6.equals(var2)) {
                        class7.method99(31, "", "Please remove " + var0 + " from your friend list first");
                        return;
                     }
                  }
               }

               if(class139.method2601(class148.localPlayer.name, Ignore.field209).equals(var2)) {
                  class7.method99(31, "", "You can\'t add yourself to your own ignore list");
               } else {
                  Client.field326.method3029(231);
                  Client.field326.method2760(class148.method2740(var0));
                  Client.field326.method2811(var0);
               }
            }
         } else {
            class7.method99(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1929727962"
   )
   static final void method1097() {
      try {
         if(Client.field329 == 0) {
            if(null != class37.field774) {
               class37.field774.method2026();
               class37.field774 = null;
            }

            ClassInfo.field3223 = null;
            Client.field337 = false;
            Client.field318 = 0;
            Client.field329 = 1;
         }

         if(Client.field329 == 1) {
            if(null == ClassInfo.field3223) {
               ClassInfo.field3223 = class44.field881.method1915(class152.host, Tile.field1351);
            }

            if(ClassInfo.field3223.field1648 == 2) {
               throw new IOException();
            }

            if(ClassInfo.field3223.field1648 == 1) {
               class37.field774 = new class110((Socket)ClassInfo.field3223.field1652, class44.field881);
               ClassInfo.field3223 = null;
               Client.field329 = 2;
            }
         }

         if(Client.field329 == 2) {
            Client.field326.offset = 0;
            Client.field326.method2760(14);
            class37.field774.method2018(Client.field326.payload, 0, 1);
            Client.field409.offset = 0;
            Client.field329 = 3;
         }

         int var0;
         if(Client.field329 == 3) {
            if(Client.field522 != null) {
               Client.field522.method1020();
            }

            if(null != class13.field150) {
               class13.field150.method1020();
            }

            var0 = class37.field774.method2021();
            if(null != Client.field522) {
               Client.field522.method1020();
            }

            if(class13.field150 != null) {
               class13.field150.method1020();
            }

            if(var0 != 0) {
               class37.method733(var0);
               return;
            }

            Client.field409.offset = 0;
            Client.field329 = 5;
         }

         int var1;
         int var2;
         if(Client.field329 == 5) {
            int[] var7 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D)};
            Client.field326.offset = 0;
            Client.field326.method2760(1);
            Client.field326.method2760(class41.field834.vmethod4062());
            Client.field326.method2763(var7[0]);
            Client.field326.method2763(var7[1]);
            Client.field326.method2763(var7[2]);
            Client.field326.method2763(var7[3]);
            switch(class41.field834.field1622) {
            case 0:
            case 3:
               Client.field326.method2914(RSCanvas.field1747);
               Client.field326.offset += 5;
               break;
            case 1:
               Client.field326.method2763(((Integer)class2.field21.field691.get(Integer.valueOf(CombatInfo2.method3531(class41.username)))).intValue());
               Client.field326.offset += 4;
               break;
            case 2:
               Client.field326.offset += 8;
            }

            Client.field326.method2811(class41.field833);
            Client.field326.method2796(class39.field797, class39.field793);
            Client.field417.offset = 0;
            if(Client.gameState == 40) {
               Client.field417.method2760(18);
            } else {
               Client.field417.method2760(16);
            }

            Client.field417.method2918(0);
            var1 = Client.field417.offset;
            Client.field417.method2763(130);
            Client.field417.method2769(Client.field326.payload, 0, Client.field326.offset);
            var2 = Client.field417.offset;
            Client.field417.method2811(class41.username);
            Client.field417.method2760((Client.isResized?1:0) << 1 | (Client.field286?1:0));
            Client.field417.method2918(class0.field1);
            Client.field417.method2918(class65.field1099);
            class159 var3 = Client.field417;
            byte[] var4 = new byte[24];

            int var5;
            try {
               class104.field1682.method1335(0L);
               class104.field1682.method1337(var4);

               for(var5 = 0; var5 < 24 && var4[var5] == 0; ++var5) {
                  ;
               }

               if(var5 >= 24) {
                  throw new IOException();
               }
            } catch (Exception var12) {
               for(int var6 = 0; var6 < 24; ++var6) {
                  var4[var6] = -1;
               }
            }

            var3.method2769(var4, 0, 24);
            Client.field417.method2811(class217.field3167);
            Client.field417.method2763(class171.field2331);
            Buffer var17 = new Buffer(DecorativeObject.field1595.method4246());
            DecorativeObject.field1595.method4243(var17);
            Client.field417.method2769(var17.payload, 0, var17.payload.length);
            Client.field417.method2760(Overlay.field3034);
            Client.field417.method2763(class5.field46.field2698);
            Client.field417.method2763(class11.field120.field2698);
            Client.field417.method2763(class48.field936.field2698);
            Client.field417.method2763(Client.field349.field2698);
            Client.field417.method2763(class10.field94.field2698);
            Client.field417.method2763(Client.field563.field2698);
            Client.field417.method2763(class37.field781.field2698);
            Client.field417.method2763(Client.field314.field2698);
            Client.field417.method2763(class0.field4.field2698);
            Client.field417.method2763(class5.field49.field2698);
            Client.field417.method2763(ChatLineBuffer.field956.field2698);
            Client.field417.method2763(class162.field2136.field2698);
            Client.field417.method2763(class137.field1898.field2698);
            Client.field417.method2763(class119.field1843.field2698);
            Client.field417.method2763(XItemContainer.field136.field2698);
            Client.field417.method2763(Client.field343.field2698);
            Client.field417.method2794(var7, var2, Client.field417.offset);
            Client.field417.method2771(Client.field417.offset - var1);
            class37.field774.method2018(Client.field417.payload, 0, Client.field417.offset);
            Client.field326.method3028(var7);

            for(var5 = 0; var5 < 4; ++var5) {
               var7[var5] += 50;
            }

            Client.field409.method3028(var7);
            Client.field329 = 6;
         }

         if(Client.field329 == 6 && class37.field774.method2017() > 0) {
            var0 = class37.field774.method2021();
            if(var0 == 21 && Client.gameState == 20) {
               Client.field329 = 7;
            } else if(var0 == 2) {
               Client.field329 = 9;
            } else if(var0 == 15 && Client.gameState == 40) {
               Client.field328 = -1;
               Client.field329 = 13;
            } else if(var0 == 23 && Client.field319 < 1) {
               ++Client.field319;
               Client.field329 = 0;
            } else {
               if(var0 != 29) {
                  class37.method733(var0);
                  return;
               }

               Client.field329 = 11;
            }
         }

         if(Client.field329 == 7 && class37.field774.method2017() > 0) {
            Client.field320 = (class37.field774.method2021() + 3) * 60;
            Client.field329 = 8;
         }

         if(Client.field329 == 8) {
            Client.field318 = 0;
            class116.method2225("You have only just left another world.", "Your profile will be transferred in:", Client.field320 / 60 + " seconds.");
            if(--Client.field320 <= 0) {
               Client.field329 = 0;
            }

         } else {
            if(Client.field329 == 9 && class37.field774.method2017() >= 13) {
               boolean var14 = class37.field774.method2021() == 1;
               class37.field774.method2014(Client.field409.payload, 0, 4);
               Client.field409.offset = 0;
               boolean var15 = false;
               if(var14) {
                  var1 = Client.field409.method3030() << 24;
                  var1 |= Client.field409.method3030() << 16;
                  var1 |= Client.field409.method3030() << 8;
                  var1 |= Client.field409.method3030();
                  var2 = CombatInfo2.method3531(class41.username);
                  if(class2.field21.field691.size() >= 10 && !class2.field21.field691.containsKey(Integer.valueOf(var2))) {
                     Iterator var16 = class2.field21.field691.entrySet().iterator();
                     var16.next();
                     var16.remove();
                  }

                  class2.field21.field691.put(Integer.valueOf(var2), Integer.valueOf(var1));
                  class7.method108();
               }

               Client.field352 = class37.field774.method2021();
               Client.field449 = class37.field774.method2021() == 1;
               Client.localInteractingIndex = class37.field774.method2021();
               Client.localInteractingIndex <<= 8;
               Client.localInteractingIndex += class37.field774.method2021();
               Client.field461 = class37.field774.method2021();
               class37.field774.method2014(Client.field409.payload, 0, 1);
               Client.field409.offset = 0;
               Client.packetOpcode = Client.field409.method3030();
               class37.field774.method2014(Client.field409.payload, 0, 2);
               Client.field409.offset = 0;
               Client.field328 = Client.field409.readUnsignedShort();

               try {
                  class100.method1901(Client.field279, "zap");
               } catch (Throwable var11) {
                  ;
               }

               Client.field329 = 10;
            }

            if(Client.field329 == 10) {
               if(class37.field774.method2017() >= Client.field328) {
                  Client.field409.offset = 0;
                  class37.field774.method2014(Client.field409.payload, 0, Client.field328);
                  ItemLayer.method1412();
                  CombatInfoListHolder.method712(Client.field409);
                  MessageNode.field231 = -1;
                  class32.xteaChanged(false);
                  Client.packetOpcode = -1;
               }

            } else {
               if(Client.field329 == 11 && class37.field774.method2017() >= 2) {
                  Client.field409.offset = 0;
                  class37.field774.method2014(Client.field409.payload, 0, 2);
                  Client.field409.offset = 0;
                  class142.field1976 = Client.field409.readUnsignedShort();
                  Client.field329 = 12;
               }

               if(Client.field329 == 12 && class37.field774.method2017() >= class142.field1976) {
                  Client.field409.offset = 0;
                  class37.field774.method2014(Client.field409.payload, 0, class142.field1976);
                  Client.field409.offset = 0;
                  String var18 = Client.field409.method2965();
                  String var10 = Client.field409.method2965();
                  String var9 = Client.field409.method2965();
                  class116.method2225(var18, var10, var9);
                  Friend.setGameState(10);
               }

               if(Client.field329 == 13) {
                  if(Client.field328 == -1) {
                     if(class37.field774.method2017() < 2) {
                        return;
                     }

                     class37.field774.method2014(Client.field409.payload, 0, 2);
                     Client.field409.offset = 0;
                     Client.field328 = Client.field409.readUnsignedShort();
                  }

                  if(class37.field774.method2017() >= Client.field328) {
                     class37.field774.method2014(Client.field409.payload, 0, Client.field328);
                     Client.field409.offset = 0;
                     var0 = Client.field328;
                     Ignore.method189();
                     CombatInfoListHolder.method712(Client.field409);
                     if(Client.field409.offset != var0) {
                        throw new RuntimeException();
                     }
                  }
               } else {
                  ++Client.field318;
                  if(Client.field318 > 2000) {
                     if(Client.field319 < 1) {
                        if(class107.field1719 == Tile.field1351) {
                           Tile.field1351 = class9.field90;
                        } else {
                           Tile.field1351 = class107.field1719;
                        }

                        ++Client.field319;
                        Client.field329 = 0;
                     } else {
                        class37.method733(-3);
                     }
                  }
               }
            }
         }
      } catch (IOException var13) {
         if(Client.field319 < 1) {
            if(Tile.field1351 == class107.field1719) {
               Tile.field1351 = class9.field90;
            } else {
               Tile.field1351 = class107.field1719;
            }

            ++Client.field319;
            Client.field329 = 0;
         } else {
            class37.method733(-2);
         }
      }
   }

   @ObfuscatedName("dv")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Z",
      garbageValue = "1094810241"
   )
   static boolean method1098(String var0, boolean var1) {
      if(null == var0) {
         return false;
      } else {
         String var2 = class139.method2601(var0, Ignore.field209);

         for(int var3 = 0; var3 < Client.friendCount; ++var3) {
            if(var2.equalsIgnoreCase(class139.method2601(Client.friends[var3].name, Ignore.field209)) && (!var1 || Client.friends[var3].world != 0)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(class139.method2601(class148.localPlayer.name, Ignore.field209))) {
            return true;
         } else {
            return false;
         }
      }
   }
}
