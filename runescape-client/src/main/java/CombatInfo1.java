import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cf")
@Implements("CombatInfo1")
public class CombatInfo1 extends Node {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1205031655
   )
   int field1283;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1373393115
   )
   @Export("healthRatio")
   int healthRatio;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -759204783
   )
   @Export("health")
   int health;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1565969763
   )
   int field1279;

   CombatInfo1(int var1, int var2, int var3, int var4) {
      this.field1283 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field1279 = var4;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-84"
   )
   void method1545(int var1, int var2, int var3, int var4) {
      this.field1283 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field1279 = var4;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIS)I",
      garbageValue = "8562"
   )
   public static int method1544(int var0, int var1) {
      int var2;
      if(var1 > var0) {
         var2 = var0;
         var0 = var1;
         var1 = var2;
      }

      while(var1 != 0) {
         var2 = var0 % var1;
         var0 = var1;
         var1 = var2;
      }

      return var0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II[BIB)I",
      garbageValue = "-39"
   )
   public static int method1552(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var6 + var1);
         if(var7 > 0 && var7 < 128 || var7 >= 160 && var7 <= 255) {
            var3[var6 + var4] = (byte)var7;
         } else if(var7 == 8364) {
            var3[var6 + var4] = -128;
         } else if(var7 == 8218) {
            var3[var6 + var4] = -126;
         } else if(var7 == 402) {
            var3[var6 + var4] = -125;
         } else if(var7 == 8222) {
            var3[var6 + var4] = -124;
         } else if(var7 == 8230) {
            var3[var6 + var4] = -123;
         } else if(var7 == 8224) {
            var3[var6 + var4] = -122;
         } else if(var7 == 8225) {
            var3[var6 + var4] = -121;
         } else if(var7 == 710) {
            var3[var6 + var4] = -120;
         } else if(var7 == 8240) {
            var3[var6 + var4] = -119;
         } else if(var7 == 352) {
            var3[var6 + var4] = -118;
         } else if(var7 == 8249) {
            var3[var6 + var4] = -117;
         } else if(var7 == 338) {
            var3[var6 + var4] = -116;
         } else if(var7 == 381) {
            var3[var6 + var4] = -114;
         } else if(var7 == 8216) {
            var3[var6 + var4] = -111;
         } else if(var7 == 8217) {
            var3[var6 + var4] = -110;
         } else if(var7 == 8220) {
            var3[var6 + var4] = -109;
         } else if(var7 == 8221) {
            var3[var6 + var4] = -108;
         } else if(var7 == 8226) {
            var3[var6 + var4] = -107;
         } else if(var7 == 8211) {
            var3[var6 + var4] = -106;
         } else if(var7 == 8212) {
            var3[var6 + var4] = -105;
         } else if(var7 == 732) {
            var3[var6 + var4] = -104;
         } else if(var7 == 8482) {
            var3[var6 + var4] = -103;
         } else if(var7 == 353) {
            var3[var6 + var4] = -102;
         } else if(var7 == 8250) {
            var3[var6 + var4] = -101;
         } else if(var7 == 339) {
            var3[var6 + var4] = -100;
         } else if(var7 == 382) {
            var3[var6 + var4] = -98;
         } else if(var7 == 376) {
            var3[var6 + var4] = -97;
         } else {
            var3[var6 + var4] = 63;
         }
      }

      return var5;
   }

   @ObfuscatedName("jh")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)Ljava/lang/String;",
      garbageValue = "-41"
   )
   static String method1553(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.socketType == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.socketType == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.socketType == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.socketType == 5) {
         var0 = var0 + "-wti";
      } else if(Client.socketType == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(Client.sessionToken != null) {
         var3 = "/p=" + Client.sessionToken;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.languageId + "/a=" + class96.field1501 + var3 + "/";
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "2140621687"
   )
   public static int method1551(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0:(var2 == 2?7 - var1:var0));
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ILcj;ZI)I",
      garbageValue = "1408998827"
   )
   static int method1549(int var0, Script var1, boolean var2) {
      if(var0 == 5000) {
         class84.intStack[++class84.intStackSize - 1] = Client.field1097;
         return 1;
      } else {
         int var4;
         if(var0 == 5001) {
            class84.intStackSize -= 3;
            Client.field1097 = class84.intStack[class84.intStackSize];
            var4 = class84.intStack[class84.intStackSize + 1];
            class277[] var16 = new class277[]{class277.field3720, class277.field3719, class277.field3722};
            class277[] var17 = var16;
            int var18 = 0;

            class277 var22;
            while(true) {
               if(var18 >= var17.length) {
                  var22 = null;
                  break;
               }

               class277 var8 = var17[var18];
               if(var4 == var8.field3721) {
                  var22 = var8;
                  break;
               }

               ++var18;
            }

            Projectile.field1488 = var22;
            if(Projectile.field1488 == null) {
               Projectile.field1488 = class277.field3719;
            }

            Client.field1191 = class84.intStack[class84.intStackSize + 2];
            Client.secretPacketBuffer1.putOpcode(125);
            Client.secretPacketBuffer1.putByte(Client.field1097);
            Client.secretPacketBuffer1.putByte(Projectile.field1488.field3721);
            Client.secretPacketBuffer1.putByte(Client.field1191);
            return 1;
         } else {
            String var3;
            int var9;
            if(var0 == 5002) {
               var3 = class84.scriptStringStack[--class91.scriptStringStackSize];
               class84.intStackSize -= 2;
               var4 = class84.intStack[class84.intStackSize];
               var9 = class84.intStack[class84.intStackSize + 1];
               Client.secretPacketBuffer1.putOpcode(31);
               Client.secretPacketBuffer1.putByte(class169.getLength(var3) + 2);
               Client.secretPacketBuffer1.putString(var3);
               Client.secretPacketBuffer1.putByte(var4 - 1);
               Client.secretPacketBuffer1.putByte(var9);
               return 1;
            } else {
               int var10;
               if(var0 == 5003) {
                  class84.intStackSize -= 2;
                  var10 = class84.intStack[class84.intStackSize];
                  var4 = class84.intStack[class84.intStackSize + 1];
                  ChatLineBuffer var6 = (ChatLineBuffer)class99.chatLineMap.get(Integer.valueOf(var10));
                  MessageNode var15 = var6.method1882(var4);
                  if(var15 != null) {
                     class84.intStack[++class84.intStackSize - 1] = var15.id;
                     class84.intStack[++class84.intStackSize - 1] = var15.tick;
                     class84.scriptStringStack[++class91.scriptStringStackSize - 1] = var15.name != null?var15.name:"";
                     class84.scriptStringStack[++class91.scriptStringStackSize - 1] = var15.sender != null?var15.sender:"";
                     class84.scriptStringStack[++class91.scriptStringStackSize - 1] = var15.value != null?var15.value:"";
                  } else {
                     class84.intStack[++class84.intStackSize - 1] = -1;
                     class84.intStack[++class84.intStackSize - 1] = 0;
                     class84.scriptStringStack[++class91.scriptStringStackSize - 1] = "";
                     class84.scriptStringStack[++class91.scriptStringStackSize - 1] = "";
                     class84.scriptStringStack[++class91.scriptStringStackSize - 1] = "";
                  }

                  return 1;
               } else if(var0 == 5004) {
                  var10 = class84.intStack[--class84.intStackSize];
                  MessageNode var20 = (MessageNode)class99.field1530.get((long)var10);
                  if(var20 != null) {
                     class84.intStack[++class84.intStackSize - 1] = var20.type;
                     class84.intStack[++class84.intStackSize - 1] = var20.tick;
                     class84.scriptStringStack[++class91.scriptStringStackSize - 1] = var20.name != null?var20.name:"";
                     class84.scriptStringStack[++class91.scriptStringStackSize - 1] = var20.sender != null?var20.sender:"";
                     class84.scriptStringStack[++class91.scriptStringStackSize - 1] = var20.value != null?var20.value:"";
                  } else {
                     class84.intStack[++class84.intStackSize - 1] = -1;
                     class84.intStack[++class84.intStackSize - 1] = 0;
                     class84.scriptStringStack[++class91.scriptStringStackSize - 1] = "";
                     class84.scriptStringStack[++class91.scriptStringStackSize - 1] = "";
                     class84.scriptStringStack[++class91.scriptStringStackSize - 1] = "";
                  }

                  return 1;
               } else if(var0 == 5005) {
                  if(Projectile.field1488 == null) {
                     class84.intStack[++class84.intStackSize - 1] = -1;
                  } else {
                     class84.intStack[++class84.intStackSize - 1] = Projectile.field1488.field3721;
                  }

                  return 1;
               } else if(var0 == 5008) {
                  var3 = class84.scriptStringStack[--class91.scriptStringStackSize];
                  var4 = class84.intStack[--class84.intStackSize];
                  String var5 = var3.toLowerCase();
                  byte var21 = 0;
                  if(var5.startsWith("yellow:")) {
                     var21 = 0;
                     var3 = var3.substring("yellow:".length());
                  } else if(var5.startsWith("red:")) {
                     var21 = 1;
                     var3 = var3.substring("red:".length());
                  } else if(var5.startsWith("green:")) {
                     var21 = 2;
                     var3 = var3.substring("green:".length());
                  } else if(var5.startsWith("cyan:")) {
                     var21 = 3;
                     var3 = var3.substring("cyan:".length());
                  } else if(var5.startsWith("purple:")) {
                     var21 = 4;
                     var3 = var3.substring("purple:".length());
                  } else if(var5.startsWith("white:")) {
                     var21 = 5;
                     var3 = var3.substring("white:".length());
                  } else if(var5.startsWith("flash1:")) {
                     var21 = 6;
                     var3 = var3.substring("flash1:".length());
                  } else if(var5.startsWith("flash2:")) {
                     var21 = 7;
                     var3 = var3.substring("flash2:".length());
                  } else if(var5.startsWith("flash3:")) {
                     var21 = 8;
                     var3 = var3.substring("flash3:".length());
                  } else if(var5.startsWith("glow1:")) {
                     var21 = 9;
                     var3 = var3.substring("glow1:".length());
                  } else if(var5.startsWith("glow2:")) {
                     var21 = 10;
                     var3 = var3.substring("glow2:".length());
                  } else if(var5.startsWith("glow3:")) {
                     var21 = 11;
                     var3 = var3.substring("glow3:".length());
                  } else if(Client.languageId != 0) {
                     if(var5.startsWith("yellow:")) {
                        var21 = 0;
                        var3 = var3.substring("yellow:".length());
                     } else if(var5.startsWith("red:")) {
                        var21 = 1;
                        var3 = var3.substring("red:".length());
                     } else if(var5.startsWith("green:")) {
                        var21 = 2;
                        var3 = var3.substring("green:".length());
                     } else if(var5.startsWith("cyan:")) {
                        var21 = 3;
                        var3 = var3.substring("cyan:".length());
                     } else if(var5.startsWith("purple:")) {
                        var21 = 4;
                        var3 = var3.substring("purple:".length());
                     } else if(var5.startsWith("white:")) {
                        var21 = 5;
                        var3 = var3.substring("white:".length());
                     } else if(var5.startsWith("flash1:")) {
                        var21 = 6;
                        var3 = var3.substring("flash1:".length());
                     } else if(var5.startsWith("flash2:")) {
                        var21 = 7;
                        var3 = var3.substring("flash2:".length());
                     } else if(var5.startsWith("flash3:")) {
                        var21 = 8;
                        var3 = var3.substring("flash3:".length());
                     } else if(var5.startsWith("glow1:")) {
                        var21 = 9;
                        var3 = var3.substring("glow1:".length());
                     } else if(var5.startsWith("glow2:")) {
                        var21 = 10;
                        var3 = var3.substring("glow2:".length());
                     } else if(var5.startsWith("glow3:")) {
                        var21 = 11;
                        var3 = var3.substring("glow3:".length());
                     }
                  }

                  var5 = var3.toLowerCase();
                  byte var7 = 0;
                  if(var5.startsWith("wave:")) {
                     var7 = 1;
                     var3 = var3.substring("wave:".length());
                  } else if(var5.startsWith("wave2:")) {
                     var7 = 2;
                     var3 = var3.substring("wave2:".length());
                  } else if(var5.startsWith("shake:")) {
                     var7 = 3;
                     var3 = var3.substring("shake:".length());
                  } else if(var5.startsWith("scroll:")) {
                     var7 = 4;
                     var3 = var3.substring("scroll:".length());
                  } else if(var5.startsWith("slide:")) {
                     var7 = 5;
                     var3 = var3.substring("slide:".length());
                  } else if(Client.languageId != 0) {
                     if(var5.startsWith("wave:")) {
                        var7 = 1;
                        var3 = var3.substring("wave:".length());
                     } else if(var5.startsWith("wave2:")) {
                        var7 = 2;
                        var3 = var3.substring("wave2:".length());
                     } else if(var5.startsWith("shake:")) {
                        var7 = 3;
                        var3 = var3.substring("shake:".length());
                     } else if(var5.startsWith("scroll:")) {
                        var7 = 4;
                        var3 = var3.substring("scroll:".length());
                     } else if(var5.startsWith("slide:")) {
                        var7 = 5;
                        var3 = var3.substring("slide:".length());
                     }
                  }

                  Client.secretPacketBuffer1.putOpcode(140);
                  Client.secretPacketBuffer1.putByte(0);
                  int var13 = Client.secretPacketBuffer1.offset;
                  Client.secretPacketBuffer1.putByte(var4);
                  Client.secretPacketBuffer1.putByte(var21);
                  Client.secretPacketBuffer1.putByte(var7);
                  class244.method4348(Client.secretPacketBuffer1, var3);
                  Client.secretPacketBuffer1.putLength(Client.secretPacketBuffer1.offset - var13);
                  return 1;
               } else if(var0 == 5009) {
                  class91.scriptStringStackSize -= 2;
                  var3 = class84.scriptStringStack[class91.scriptStringStackSize];
                  String var19 = class84.scriptStringStack[class91.scriptStringStackSize + 1];
                  Client.secretPacketBuffer1.putOpcode(71);
                  Client.secretPacketBuffer1.putShort(0);
                  var9 = Client.secretPacketBuffer1.offset;
                  Client.secretPacketBuffer1.putString(var3);
                  class244.method4348(Client.secretPacketBuffer1, var19);
                  Client.secretPacketBuffer1.putShortLength(Client.secretPacketBuffer1.offset - var9);
                  return 1;
               } else if(var0 != 5015) {
                  if(var0 == 5016) {
                     class84.intStack[++class84.intStackSize - 1] = Client.field1191;
                     return 1;
                  } else if(var0 == 5017) {
                     var10 = class84.intStack[--class84.intStackSize];
                     class84.intStack[++class84.intStackSize - 1] = class97.method1815(var10);
                     return 1;
                  } else {
                     int[] var11;
                     int var12;
                     MessageNode var14;
                     if(var0 == 5018) {
                        var10 = class84.intStack[--class84.intStackSize];
                        var11 = class84.intStack;
                        var9 = ++class84.intStackSize - 1;
                        var14 = (MessageNode)class99.field1530.get((long)var10);
                        if(var14 == null) {
                           var12 = -1;
                        } else if(var14.previous == class99.field1531.field2487) {
                           var12 = -1;
                        } else {
                           var12 = ((MessageNode)var14.previous).id;
                        }

                        var11[var9] = var12;
                        return 1;
                     } else if(var0 == 5019) {
                        var10 = class84.intStack[--class84.intStackSize];
                        var11 = class84.intStack;
                        var9 = ++class84.intStackSize - 1;
                        var14 = (MessageNode)class99.field1530.get((long)var10);
                        if(var14 == null) {
                           var12 = -1;
                        } else if(var14.next == class99.field1531.field2487) {
                           var12 = -1;
                        } else {
                           var12 = ((MessageNode)var14.next).id;
                        }

                        var11[var9] = var12;
                        return 1;
                     } else if(var0 == 5020) {
                        var3 = class84.scriptStringStack[--class91.scriptStringStackSize];
                        if(var3.equalsIgnoreCase("toggleroof")) {
                           class3.preferences.hideRoofs = !class3.preferences.hideRoofs;
                           class33.method372();
                           if(class3.preferences.hideRoofs) {
                              NPC.sendGameMessage(99, "", "Roofs are now all hidden");
                           } else {
                              NPC.sendGameMessage(99, "", "Roofs will only be removed selectively");
                           }
                        }

                        if(var3.equalsIgnoreCase("displayfps")) {
                           Client.displayFps = !Client.displayFps;
                        }

                        if(Client.rights >= 2) {
                           if(var3.equalsIgnoreCase("aabb")) {
                              if(!class7.field227) {
                                 class7.field227 = true;
                                 class7.field230 = class11.field263;
                              } else if(class7.field230 == class11.field263) {
                                 class7.field227 = true;
                                 class7.field230 = class11.field265;
                              } else {
                                 class7.field227 = false;
                              }
                           }

                           if(var3.equalsIgnoreCase("fpson")) {
                              Client.displayFps = true;
                           }

                           if(var3.equalsIgnoreCase("fpsoff")) {
                              Client.displayFps = false;
                           }

                           if(var3.equalsIgnoreCase("gc")) {
                              System.gc();
                           }

                           if(var3.equalsIgnoreCase("clientdrop")) {
                              if(Client.field987 > 0) {
                                 class33.method374();
                              } else {
                                 MouseInput.setGameState(40);
                                 class20.field337 = VertexNormal.rssocket;
                                 VertexNormal.rssocket = null;
                              }
                           }

                           if(var3.equalsIgnoreCase("errortest") && Client.socketType == 2) {
                              throw new RuntimeException();
                           }
                        }

                        Client.secretPacketBuffer1.putOpcode(233);
                        Client.secretPacketBuffer1.putByte(var3.length() + 1);
                        Client.secretPacketBuffer1.putString(var3);
                        return 1;
                     } else if(var0 == 5021) {
                        Client.field1144 = class84.scriptStringStack[--class91.scriptStringStackSize].toLowerCase().trim();
                        return 1;
                     } else if(var0 == 5022) {
                        class84.scriptStringStack[++class91.scriptStringStackSize - 1] = Client.field1144;
                        return 1;
                     } else {
                        return 2;
                     }
                  }
               } else {
                  if(GrandExchangeOffer.localPlayer != null && GrandExchangeOffer.localPlayer.name != null) {
                     var3 = GrandExchangeOffer.localPlayer.name;
                  } else {
                     var3 = "";
                  }

                  class84.scriptStringStack[++class91.scriptStringStackSize - 1] = var3;
                  return 1;
               }
            }
         }
      }
   }
}
