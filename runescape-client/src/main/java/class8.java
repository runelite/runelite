import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Opcodes;

@ObfuscatedName("k")
public final class class8 extends class9 {
   @ObfuscatedName("q")
   @Export("colorsToFind")
   public static short[] colorsToFind;
   @ObfuscatedName("oz")
   @ObfuscatedSignature(
      signature = "Ldz;"
   )
   @Export("soundSystem1")
   static AbstractSoundSystem soundSystem1;
   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "Lky;"
   )
   static class290 field243;
   @ObfuscatedName("fn")
   @ObfuscatedSignature(
      signature = "[Ljx;"
   )
   static IndexedSprite[] field242;
   @ObfuscatedName("ni")
   static byte field244;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -897294209
   )
   final int field245;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1746720263
   )
   final int field239;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1794473767
   )
   final int field240;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1614236441
   )
   final int field241;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -43953371
   )
   final int field238;

   class8(int var1, int var2, int var3, int var4, int var5) {
      this.field245 = var1;
      this.field239 = var2;
      this.field240 = var3;
      this.field241 = var4;
      this.field238 = var5;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-56481943"
   )
   public final void vmethod58() {
      Rasterizer2D.drawRectangle(this.field245 + Rasterizer2D.draw_region_x, this.field239 + Rasterizer2D.drawingAreaTop, this.field240 - this.field245, this.field241 - this.field239, this.field238);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "84"
   )
   static void method40() {
      if(Signlink.javaVendor.toLowerCase().indexOf("microsoft") != -1) {
         KeyFocusListener.field640[186] = 57;
         KeyFocusListener.field640[187] = 27;
         KeyFocusListener.field640[188] = 71;
         KeyFocusListener.field640[189] = 26;
         KeyFocusListener.field640[190] = 72;
         KeyFocusListener.field640[191] = 73;
         KeyFocusListener.field640[192] = 58;
         KeyFocusListener.field640[219] = 42;
         KeyFocusListener.field640[220] = 74;
         KeyFocusListener.field640[221] = 43;
         KeyFocusListener.field640[222] = 59;
         KeyFocusListener.field640[223] = 28;
      } else {
         KeyFocusListener.field640[44] = 71;
         KeyFocusListener.field640[45] = 26;
         KeyFocusListener.field640[46] = 72;
         KeyFocusListener.field640[47] = 73;
         KeyFocusListener.field640[59] = 57;
         KeyFocusListener.field640[61] = 27;
         KeyFocusListener.field640[91] = 42;
         KeyFocusListener.field640[92] = 74;
         KeyFocusListener.field640[93] = 43;
         KeyFocusListener.field640[192] = 28;
         KeyFocusListener.field640[222] = 58;
         KeyFocusListener.field640[520] = 59;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(ILck;ZI)I",
      garbageValue = "-1887919972"
   )
   static int method43(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = GZipDecompressor.method3177(class82.intStack[--Ignore.intStackSize]);
      } else {
         var3 = var2?class31.field452:class23.field366;
      }

      if(var0 == 1927) {
         if(class82.field1354 >= 10) {
            throw new RuntimeException();
         } else if(var3.field2767 == null) {
            return 0;
         } else {
            ScriptEvent var4 = new ScriptEvent();
            var4.widget = var3;
            var4.field864 = var3.field2767;
            var4.field863 = class82.field1354 + 1;
            Client.field1130.addFront(var4);
            return 1;
         }
      } else {
         return 2;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILck;ZI)I",
      garbageValue = "1724627335"
   )
   static int method45(int var0, Script var1, boolean var2) {
      if(var0 == 3600) {
         if(Client.field1198 == 0) {
            class82.intStack[++Ignore.intStackSize - 1] = -2;
         } else if(Client.field1198 == 1) {
            class82.intStack[++Ignore.intStackSize - 1] = -1;
         } else {
            class82.intStack[++Ignore.intStackSize - 1] = Client.friendCount;
         }

         return 1;
      } else {
         int var3;
         if(var0 == 3601) {
            var3 = class82.intStack[--Ignore.intStackSize];
            if(Client.field1198 == 2 && var3 < Client.friendCount) {
               class82.scriptStringStack[++class169.scriptStringStackSize - 1] = Client.friends[var3].name;
               class82.scriptStringStack[++class169.scriptStringStackSize - 1] = Client.friends[var3].previousName;
            } else {
               class82.scriptStringStack[++class169.scriptStringStackSize - 1] = "";
               class82.scriptStringStack[++class169.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 3602) {
            var3 = class82.intStack[--Ignore.intStackSize];
            if(Client.field1198 == 2 && var3 < Client.friendCount) {
               class82.intStack[++Ignore.intStackSize - 1] = Client.friends[var3].world;
            } else {
               class82.intStack[++Ignore.intStackSize - 1] = 0;
            }

            return 1;
         } else if(var0 == 3603) {
            var3 = class82.intStack[--Ignore.intStackSize];
            if(Client.field1198 == 2 && var3 < Client.friendCount) {
               class82.intStack[++Ignore.intStackSize - 1] = Client.friends[var3].rank;
            } else {
               class82.intStack[++Ignore.intStackSize - 1] = 0;
            }

            return 1;
         } else {
            String var11;
            if(var0 == 3604) {
               var11 = class82.scriptStringStack[--class169.scriptStringStackSize];
               int var4 = class82.intStack[--Ignore.intStackSize];
               class27.method248(var11, var4);
               return 1;
            } else if(var0 == 3605) {
               var11 = class82.scriptStringStack[--class169.scriptStringStackSize];
               class25.method208(var11);
               return 1;
            } else {
               int var5;
               String var7;
               String var8;
               int var9;
               String var18;
               if(var0 == 3606) {
                  var11 = class82.scriptStringStack[--class169.scriptStringStackSize];
                  if(var11 != null) {
                     var18 = Frames.method2925(var11, field243);
                     if(var18 != null) {
                        for(var5 = 0; var5 < Client.friendCount; ++var5) {
                           Friend var16 = Client.friends[var5];
                           var7 = var16.name;
                           var8 = Frames.method2925(var7, field243);
                           if(class139.method2908(var11, var18, var7, var8)) {
                              --Client.friendCount;

                              for(var9 = var5; var9 < Client.friendCount; ++var9) {
                                 Client.friends[var9] = Client.friends[var9 + 1];
                              }

                              Client.field1124 = Client.cycleCntr;
                              Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_DELETE_FRIEND);
                              Client.secretPacketBuffer1.putByte(ClanMember.getLength(var11));
                              Client.secretPacketBuffer1.putString(var11);
                              break;
                           }
                        }
                     }
                  }

                  return 1;
               } else if(var0 == 3607) {
                  var11 = class82.scriptStringStack[--class169.scriptStringStackSize];
                  class253.method4462(var11, false);
                  return 1;
               } else if(var0 == 3608) {
                  var11 = class82.scriptStringStack[--class169.scriptStringStackSize];
                  if(var11 != null) {
                     var18 = Frames.method2925(var11, field243);
                     if(var18 != null) {
                        for(var5 = 0; var5 < Client.ignoreCount; ++var5) {
                           Ignore var6 = Client.ignores[var5];
                           var7 = var6.name;
                           var8 = Frames.method2925(var7, field243);
                           if(class139.method2908(var11, var18, var7, var8)) {
                              --Client.ignoreCount;

                              for(var9 = var5; var9 < Client.ignoreCount; ++var9) {
                                 Client.ignores[var9] = Client.ignores[var9 + 1];
                              }

                              Client.field1124 = Client.cycleCntr;
                              Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_DELETE_IGNORE);
                              Client.secretPacketBuffer1.putByte(ClanMember.getLength(var11));
                              Client.secretPacketBuffer1.putString(var11);
                              break;
                           }
                        }
                     }
                  }

                  return 1;
               } else if(var0 == 3609) {
                  var11 = class82.scriptStringStack[--class169.scriptStringStackSize];
                  Permission[] var12 = new Permission[]{Permission.field3175, Permission.field3174, Permission.field3177, Permission.field3179, Permission.field3178, Permission.field3181};
                  Permission[] var19 = var12;

                  for(int var14 = 0; var14 < var19.length; ++var14) {
                     Permission var17 = var19[var14];
                     if(var17.field3176 != -1) {
                        int var10 = var17.field3176;
                        String var15 = "<img=" + var10 + ">";
                        if(var11.startsWith(var15)) {
                           var11 = var11.substring(6 + Integer.toString(var17.field3176).length());
                           break;
                        }
                     }
                  }

                  class82.intStack[++Ignore.intStackSize - 1] = Actor.isFriended(var11, false)?1:0;
                  return 1;
               } else if(var0 == 3611) {
                  if(Client.clanChatOwner != null) {
                     class82.scriptStringStack[++class169.scriptStringStackSize - 1] = World.method1586(Client.clanChatOwner);
                  } else {
                     class82.scriptStringStack[++class169.scriptStringStackSize - 1] = "";
                  }

                  return 1;
               } else if(var0 == 3612) {
                  if(Client.clanChatOwner != null) {
                     class82.intStack[++Ignore.intStackSize - 1] = class13.clanChatCount;
                  } else {
                     class82.intStack[++Ignore.intStackSize - 1] = 0;
                  }

                  return 1;
               } else if(var0 == 3613) {
                  var3 = class82.intStack[--Ignore.intStackSize];
                  if(Client.clanChatOwner != null && var3 < class13.clanChatCount) {
                     class82.scriptStringStack[++class169.scriptStringStackSize - 1] = class223.clanMembers[var3].username;
                  } else {
                     class82.scriptStringStack[++class169.scriptStringStackSize - 1] = "";
                  }

                  return 1;
               } else if(var0 == 3614) {
                  var3 = class82.intStack[--Ignore.intStackSize];
                  if(Client.clanChatOwner != null && var3 < class13.clanChatCount) {
                     class82.intStack[++Ignore.intStackSize - 1] = class223.clanMembers[var3].world;
                  } else {
                     class82.intStack[++Ignore.intStackSize - 1] = 0;
                  }

                  return 1;
               } else if(var0 == 3615) {
                  var3 = class82.intStack[--Ignore.intStackSize];
                  if(Client.clanChatOwner != null && var3 < class13.clanChatCount) {
                     class82.intStack[++Ignore.intStackSize - 1] = class223.clanMembers[var3].rank;
                  } else {
                     class82.intStack[++Ignore.intStackSize - 1] = 0;
                  }

                  return 1;
               } else if(var0 == 3616) {
                  class82.intStack[++Ignore.intStackSize - 1] = field244;
                  return 1;
               } else if(var0 == 3617) {
                  var11 = class82.scriptStringStack[--class169.scriptStringStackSize];
                  if(class223.clanMembers != null) {
                     Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_139);
                     Client.secretPacketBuffer1.putByte(ClanMember.getLength(var11));
                     Client.secretPacketBuffer1.putString(var11);
                  }

                  return 1;
               } else if(var0 == 3618) {
                  class82.intStack[++Ignore.intStackSize - 1] = class35.clanChatRank;
                  return 1;
               } else if(var0 == 3619) {
                  var11 = class82.scriptStringStack[--class169.scriptStringStackSize];
                  class56.method858(var11);
                  return 1;
               } else if(var0 == 3620) {
                  Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_JOIN_CLANCHAT);
                  Client.secretPacketBuffer1.putByte(0);
                  return 1;
               } else if(var0 == 3621) {
                  if(Client.field1198 == 0) {
                     class82.intStack[++Ignore.intStackSize - 1] = -1;
                  } else {
                     class82.intStack[++Ignore.intStackSize - 1] = Client.ignoreCount;
                  }

                  return 1;
               } else if(var0 == 3622) {
                  var3 = class82.intStack[--Ignore.intStackSize];
                  if(Client.field1198 != 0 && var3 < Client.ignoreCount) {
                     class82.scriptStringStack[++class169.scriptStringStackSize - 1] = Client.ignores[var3].name;
                     class82.scriptStringStack[++class169.scriptStringStackSize - 1] = Client.ignores[var3].previousName;
                  } else {
                     class82.scriptStringStack[++class169.scriptStringStackSize - 1] = "";
                     class82.scriptStringStack[++class169.scriptStringStackSize - 1] = "";
                  }

                  return 1;
               } else if(var0 == 3623) {
                  label318: {
                     var11 = class82.scriptStringStack[--class169.scriptStringStackSize];
                     String var13 = "<img=0>";
                     if(!var11.startsWith(var13)) {
                        var7 = "<img=1>";
                        if(!var11.startsWith(var7)) {
                           break label318;
                        }
                     }

                     var11 = var11.substring(7);
                  }

                  class82.intStack[++Ignore.intStackSize - 1] = class24.isIgnored(var11)?1:0;
                  return 1;
               } else if(var0 != 3624) {
                  if(var0 == 3625) {
                     if(Client.clanChatName != null) {
                        class82.scriptStringStack[++class169.scriptStringStackSize - 1] = World.method1586(Client.clanChatName);
                     } else {
                        class82.scriptStringStack[++class169.scriptStringStackSize - 1] = "";
                     }

                     return 1;
                  } else {
                     return 2;
                  }
               } else {
                  var3 = class82.intStack[--Ignore.intStackSize];
                  if(class223.clanMembers != null && var3 < class13.clanChatCount && class223.clanMembers[var3].username.equalsIgnoreCase(Player.localPlayer.name)) {
                     class82.intStack[++Ignore.intStackSize - 1] = 1;
                  } else {
                     class82.intStack[++Ignore.intStackSize - 1] = 0;
                  }

                  return 1;
               }
            }
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ILck;ZI)I",
      garbageValue = "-2140618526"
   )
   static int method42(int var0, Script var1, boolean var2) {
      if(var0 == 5630) {
         Client.field1058 = 250;
         return 1;
      } else {
         return 2;
      }
   }
}
