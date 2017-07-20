import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
@Implements("GraphicsObject")
public final class GraphicsObject extends Renderable {
   @ObfuscatedName("qv")
   @ObfuscatedSignature(
      signature = "Lfz;"
   )
   static IndexFile field1347;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 2031527127
   )
   @Export("id")
   int id;
   @ObfuscatedName("k")
   @Export("finished")
   boolean finished;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1578750111
   )
   int field1344;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1514318143
   )
   int field1343;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   Sequence field1338;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -25469343
   )
   @Export("level")
   int level;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -138565099
   )
   @Export("x")
   int x;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1807709483
   )
   @Export("y")
   int y;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2040438783
   )
   @Export("height")
   int height;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 551105351
   )
   @Export("startCycle")
   int startCycle;

   GraphicsObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field1343 = 0;
      this.field1344 = 0;
      this.finished = false;
      this.id = var1;
      this.level = var2;
      this.x = var3;
      this.y = var4;
      this.height = var5;
      this.startCycle = var7 + var6;
      int var8 = class205.getSpotAnimType(this.id).field3299;
      if(var8 != -1) {
         this.finished = false;
         this.field1338 = class31.getAnimation(var8);
      } else {
         this.finished = true;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)Leo;",
      garbageValue = "1"
   )
   protected final Model getModel() {
      Spotanim var1 = class205.getSpotAnimType(this.id);
      Model var2;
      if(!this.finished) {
         var2 = var1.method4231(this.field1343);
      } else {
         var2 = var1.method4231(-1);
      }

      return var2 == null?null:var2;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-90"
   )
   final void method1612(int var1) {
      if(!this.finished) {
         this.field1344 += var1;

         while(this.field1344 > this.field1338.frameLenghts[this.field1343]) {
            this.field1344 -= this.field1338.frameLenghts[this.field1343];
            ++this.field1343;
            if(this.field1343 >= this.field1338.frameIDs.length) {
               this.finished = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1210739443"
   )
   public static int method1619(int var0) {
      var0 = (var0 >>> 1 & 1431655765) + (var0 & 1431655765);
      var0 = (var0 & 858993459) + (var0 >>> 2 & 858993459);
      var0 = var0 + (var0 >>> 4) & 252645135;
      var0 += var0 >>> 8;
      var0 += var0 >>> 16;
      return var0 & 255;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)[Lil;",
      garbageValue = "-501215637"
   )
   static class257[] method1618() {
      return new class257[]{class257.field3522, class257.field3523, class257.field3520};
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lip;Ljava/lang/String;Ljava/lang/String;IZB)V",
      garbageValue = "-114"
   )
   public static void method1617(IndexDataBase var0, String var1, String var2, int var3, boolean var4) {
      int var5 = var0.getFile(var1);
      int var6 = var0.getChild(var5, var2);
      class18.method136(var0, var5, var6, var3, var4);
   }

   @ObfuscatedName("fp")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-661275089"
   )
   static final void method1620(boolean var0) {
      for(int var1 = 0; var1 < Client.field953; ++var1) {
         NPC var2 = Client.cachedNPCs[Client.npcIndices[var1]];
         int var3 = (Client.npcIndices[var1] << 14) + 536870912;
         if(var2 != null && var2.hasConfig() && var2.composition.isVisible == var0 && var2.composition.method4512()) {
            int var4 = var2.x >> 7;
            int var5 = var2.y >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field1213 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                  if(Client.field1007[var4][var5] == Client.field1021) {
                     continue;
                  }

                  Client.field1007[var4][var5] = Client.field1021;
               }

               if(!var2.composition.field3559) {
                  var3 -= Integer.MIN_VALUE;
               }

               class19.region.method2671(class10.plane, var2.x, var2.y, class23.getTileHeight(var2.field1213 * 64 - 64 + var2.x, var2.field1213 * 64 - 64 + var2.y, class10.plane), var2.field1213 * 64 - 64 + 60, var2, var2.angle, var3, var2.field1233);
            }
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ILcv;ZI)I",
      garbageValue = "579521852"
   )
   static int method1616(int var0, Script var1, boolean var2) {
      if(var0 == 3600) {
         if(Client.field1170 == 0) {
            class83.intStack[++BufferProvider.intStackSize - 1] = -2;
         } else if(Client.field1170 == 1) {
            class83.intStack[++BufferProvider.intStackSize - 1] = -1;
         } else {
            class83.intStack[++BufferProvider.intStackSize - 1] = Client.friendCount;
         }

         return 1;
      } else {
         int var3;
         if(var0 == 3601) {
            var3 = class83.intStack[--BufferProvider.intStackSize];
            if(Client.field1170 == 2 && var3 < Client.friendCount) {
               class83.scriptStringStack[++class83.scriptStringStackSize - 1] = Client.friends[var3].name;
               class83.scriptStringStack[++class83.scriptStringStackSize - 1] = Client.friends[var3].previousName;
            } else {
               class83.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
               class83.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 3602) {
            var3 = class83.intStack[--BufferProvider.intStackSize];
            if(Client.field1170 == 2 && var3 < Client.friendCount) {
               class83.intStack[++BufferProvider.intStackSize - 1] = Client.friends[var3].world;
            } else {
               class83.intStack[++BufferProvider.intStackSize - 1] = 0;
            }

            return 1;
         } else if(var0 == 3603) {
            var3 = class83.intStack[--BufferProvider.intStackSize];
            if(Client.field1170 == 2 && var3 < Client.friendCount) {
               class83.intStack[++BufferProvider.intStackSize - 1] = Client.friends[var3].rank;
            } else {
               class83.intStack[++BufferProvider.intStackSize - 1] = 0;
            }

            return 1;
         } else {
            int var4;
            String var15;
            if(var0 == 3604) {
               var15 = class83.scriptStringStack[--class83.scriptStringStackSize];
               var4 = class83.intStack[--BufferProvider.intStackSize];
               WorldMapType2.method517(var15, var4);
               return 1;
            } else if(var0 == 3605) {
               var15 = class83.scriptStringStack[--class83.scriptStringStackSize];
               class37.method493(var15);
               return 1;
            } else if(var0 == 3606) {
               var15 = class83.scriptStringStack[--class83.scriptStringStackSize];
               ItemComposition.method4505(var15);
               return 1;
            } else if(var0 == 3607) {
               var15 = class83.scriptStringStack[--class83.scriptStringStackSize];
               class3.method10(var15, false);
               return 1;
            } else {
               int var5;
               String var7;
               String var8;
               int var9;
               if(var0 == 3608) {
                  var15 = class83.scriptStringStack[--class83.scriptStringStackSize];
                  if(var15 != null) {
                     String var16 = class215.method3908(var15, class22.field331);
                     if(var16 != null) {
                        for(var5 = 0; var5 < Client.ignoreCount; ++var5) {
                           Ignore var14 = Client.ignores[var5];
                           var7 = var14.name;
                           var8 = class215.method3908(var7, class22.field331);
                           if(ScriptState.method1025(var15, var16, var7, var8)) {
                              --Client.ignoreCount;

                              for(var9 = var5; var9 < Client.ignoreCount; ++var9) {
                                 Client.ignores[var9] = Client.ignores[var9 + 1];
                              }

                              Client.field1142 = Client.cycleCntr;
                              Client.secretPacketBuffer1.putOpcode(143);
                              Client.secretPacketBuffer1.putByte(class15.getLength(var15));
                              Client.secretPacketBuffer1.putString(var15);
                              break;
                           }
                        }
                     }
                  }

                  return 1;
               } else if(var0 == 3609) {
                  var15 = class83.scriptStringStack[--class83.scriptStringStackSize];
                  Permission[] var11 = class252.method4350();

                  for(var5 = 0; var5 < var11.length; ++var5) {
                     Permission var13 = var11[var5];
                     if(var13.field3146 != -1) {
                        var9 = var13.field3146;
                        var8 = "<img=" + var9 + ">";
                        if(var15.startsWith(var8)) {
                           var15 = var15.substring(6 + Integer.toString(var13.field3146).length());
                           break;
                        }
                     }
                  }

                  class83.intStack[++BufferProvider.intStackSize - 1] = DecorativeObject.isFriended(var15, false)?1:0;
                  return 1;
               } else {
                  String var6;
                  String[] var10;
                  if(var0 == 3611) {
                     if(Client.clanChatOwner != null) {
                        var10 = class83.scriptStringStack;
                        var4 = ++class83.scriptStringStackSize - 1;
                        var6 = Client.clanChatOwner;
                        var7 = DecorativeObject.method2833(KitDefinition.method4277(var6));
                        if(var7 == null) {
                           var7 = "";
                        }

                        var10[var4] = var7;
                     } else {
                        class83.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
                     }

                     return 1;
                  } else if(var0 == 3612) {
                     if(Client.clanChatOwner != null) {
                        class83.intStack[++BufferProvider.intStackSize - 1] = VarPlayerType.clanChatCount;
                     } else {
                        class83.intStack[++BufferProvider.intStackSize - 1] = 0;
                     }

                     return 1;
                  } else if(var0 == 3613) {
                     var3 = class83.intStack[--BufferProvider.intStackSize];
                     if(Client.clanChatOwner != null && var3 < VarPlayerType.clanChatCount) {
                        class83.scriptStringStack[++class83.scriptStringStackSize - 1] = KeyFocusListener.clanMembers[var3].username;
                     } else {
                        class83.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
                     }

                     return 1;
                  } else if(var0 == 3614) {
                     var3 = class83.intStack[--BufferProvider.intStackSize];
                     if(Client.clanChatOwner != null && var3 < VarPlayerType.clanChatCount) {
                        class83.intStack[++BufferProvider.intStackSize - 1] = KeyFocusListener.clanMembers[var3].world;
                     } else {
                        class83.intStack[++BufferProvider.intStackSize - 1] = 0;
                     }

                     return 1;
                  } else if(var0 == 3615) {
                     var3 = class83.intStack[--BufferProvider.intStackSize];
                     if(Client.clanChatOwner != null && var3 < VarPlayerType.clanChatCount) {
                        class83.intStack[++BufferProvider.intStackSize - 1] = KeyFocusListener.clanMembers[var3].rank;
                     } else {
                        class83.intStack[++BufferProvider.intStackSize - 1] = 0;
                     }

                     return 1;
                  } else if(var0 == 3616) {
                     class83.intStack[++BufferProvider.intStackSize - 1] = WorldMapType3.field372;
                     return 1;
                  } else if(var0 == 3617) {
                     var15 = class83.scriptStringStack[--class83.scriptStringStackSize];
                     if(KeyFocusListener.clanMembers != null) {
                        Client.secretPacketBuffer1.putOpcode(248);
                        Client.secretPacketBuffer1.putByte(class15.getLength(var15));
                        Client.secretPacketBuffer1.putString(var15);
                     }

                     return 1;
                  } else if(var0 == 3618) {
                     class83.intStack[++BufferProvider.intStackSize - 1] = CombatInfo1.clanChatRank;
                     return 1;
                  } else if(var0 == 3619) {
                     var15 = class83.scriptStringStack[--class83.scriptStringStackSize];
                     if(!var15.equals("")) {
                        Client.secretPacketBuffer1.putOpcode(111);
                        Client.secretPacketBuffer1.putByte(class15.getLength(var15));
                        Client.secretPacketBuffer1.putString(var15);
                     }

                     return 1;
                  } else if(var0 == 3620) {
                     Client.secretPacketBuffer1.putOpcode(111);
                     Client.secretPacketBuffer1.putByte(0);
                     return 1;
                  } else if(var0 == 3621) {
                     if(Client.field1170 == 0) {
                        class83.intStack[++BufferProvider.intStackSize - 1] = -1;
                     } else {
                        class83.intStack[++BufferProvider.intStackSize - 1] = Client.ignoreCount;
                     }

                     return 1;
                  } else if(var0 == 3622) {
                     var3 = class83.intStack[--BufferProvider.intStackSize];
                     if(Client.field1170 != 0 && var3 < Client.ignoreCount) {
                        class83.scriptStringStack[++class83.scriptStringStackSize - 1] = Client.ignores[var3].name;
                        class83.scriptStringStack[++class83.scriptStringStackSize - 1] = Client.ignores[var3].previousName;
                     } else {
                        class83.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
                        class83.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
                     }

                     return 1;
                  } else if(var0 == 3623) {
                     label299: {
                        var15 = class83.scriptStringStack[--class83.scriptStringStackSize];
                        String var12 = "<img=0>";
                        if(!var15.startsWith(var12)) {
                           var7 = "<img=1>";
                           if(!var15.startsWith(var7)) {
                              break label299;
                           }
                        }

                        var15 = var15.substring(7);
                     }

                     class83.intStack[++BufferProvider.intStackSize - 1] = KeyFocusListener.isIgnored(var15)?1:0;
                     return 1;
                  } else if(var0 != 3624) {
                     if(var0 == 3625) {
                        if(Client.clanChatName != null) {
                           var10 = class83.scriptStringStack;
                           var4 = ++class83.scriptStringStackSize - 1;
                           var6 = Client.clanChatName;
                           var7 = DecorativeObject.method2833(KitDefinition.method4277(var6));
                           if(var7 == null) {
                              var7 = "";
                           }

                           var10[var4] = var7;
                        } else {
                           class83.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
                        }

                        return 1;
                     } else {
                        return 2;
                     }
                  } else {
                     var3 = class83.intStack[--BufferProvider.intStackSize];
                     if(KeyFocusListener.clanMembers != null && var3 < VarPlayerType.clanChatCount && KeyFocusListener.clanMembers[var3].username.equalsIgnoreCase(class226.localPlayer.name)) {
                        class83.intStack[++BufferProvider.intStackSize - 1] = 1;
                     } else {
                        class83.intStack[++BufferProvider.intStackSize - 1] = 0;
                     }

                     return 1;
                  }
               }
            }
         }
      }
   }
}
