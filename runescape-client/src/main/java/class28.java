import java.util.LinkedList;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Opcodes;

@ObfuscatedName("al")
public abstract class class28 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1268099393
   )
   int field417;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 282618559
   )
   int field414;
   @ObfuscatedName("q")
   short[][][] field420;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 800987949
   )
   int field419;
   @ObfuscatedName("b")
   short[][][] field418;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "[[[[Lab;"
   )
   class31[][][][] field424;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1519372151
   )
   int field422;
   @ObfuscatedName("k")
   byte[][][] field421;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 824743745
   )
   int field415;
   @ObfuscatedName("s")
   byte[][][] field423;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1982814939
   )
   int field416;

   class28() {
      new LinkedList();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "0"
   )
   int method254(int var1, int var2) {
      return var1 >= 0 && var2 >= 0?(var1 < 64 && var2 < 64?this.field420[0][var1][var2] - 1:-1):-1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IILfp;II)V",
      garbageValue = "-1870576737"
   )
   void method252(int var1, int var2, Buffer var3, int var4) {
      boolean var5 = (var4 & 2) != 0;
      if(var5) {
         this.field418[0][var1][var2] = (short)var3.readUnsignedByte();
      }

      this.field420[0][var1][var2] = (short)var3.readUnsignedByte();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IILfp;IS)V",
      garbageValue = "12518"
   )
   void method253(int var1, int var2, Buffer var3, int var4) {
      int var5 = ((var4 & 24) >> 3) + 1;
      boolean var6 = (var4 & 2) != 0;
      boolean var7 = (var4 & 4) != 0;
      this.field420[0][var1][var2] = (short)var3.readUnsignedByte();
      int var8;
      int var9;
      int var11;
      if(var6) {
         var8 = var3.readUnsignedByte();

         for(var9 = 0; var9 < var8; ++var9) {
            int var10 = var3.readUnsignedByte();
            if(var10 != 0) {
               this.field418[var9][var1][var2] = (short)var10;
               var11 = var3.readUnsignedByte();
               this.field421[var9][var1][var2] = (byte)(var11 >> 2);
               this.field423[var9][var1][var2] = (byte)(var11 & 3);
            }
         }
      }

      if(var7) {
         for(var8 = 0; var8 < var5; ++var8) {
            var9 = var3.readUnsignedByte();
            if(var9 != 0) {
               class31[] var14 = this.field424[var8][var1][var2] = new class31[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  int var12 = var3.method3262();
                  int var13 = var3.readUnsignedByte();
                  var14[var11] = new class31(var12, var13 >> 2, var13 & 3);
               }
            }
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2132181383"
   )
   int method250() {
      return this.field414;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1968962075"
   )
   int method256() {
      return this.field417;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IILfp;I)V",
      garbageValue = "-535995384"
   )
   void method269(int var1, int var2, Buffer var3) {
      int var4 = var3.readUnsignedByte();
      if(var4 != 0) {
         if((var4 & 1) != 0) {
            this.method252(var1, var2, var3, var4);
         } else {
            this.method253(var1, var2, var3, var4);
         }

      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Lic;",
      garbageValue = "1602509254"
   )
   public static class245 method270(int var0) {
      class245 var1 = (class245)class245.field3321.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class245.field3325.getConfigData(15, var0);
         var1 = new class245();
         if(var2 != null) {
            var1.method4321(new Buffer(var2));
         }

         class245.field3321.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-801626099"
   )
   public static void method262() {
      PlayerComposition.field2627.reset();
   }

   @ObfuscatedName("gy")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1667258781"
   )
   static final void method263(boolean var0) {
      Client.field1054 = 0;
      Client.pendingNpcFlagsCount = 0;
      Client.secretPacketBuffer2.bitAccess();
      int var1 = Client.secretPacketBuffer2.getBits(8);
      int var2;
      if(var1 < Client.field946) {
         for(var2 = var1; var2 < Client.field946; ++var2) {
            Client.field1055[++Client.field1054 - 1] = Client.npcIndices[var2];
         }
      }

      if(var1 > Client.field946) {
         throw new RuntimeException("");
      } else {
         Client.field946 = 0;

         int var5;
         int var6;
         int var7;
         int var8;
         for(var2 = 0; var2 < var1; ++var2) {
            int var3 = Client.npcIndices[var2];
            NPC var4 = Client.cachedNPCs[var3];
            var5 = Client.secretPacketBuffer2.getBits(1);
            if(var5 == 0) {
               Client.npcIndices[++Client.field946 - 1] = var3;
               var4.field1260 = Client.gameCycle;
            } else {
               var6 = Client.secretPacketBuffer2.getBits(2);
               if(var6 == 0) {
                  Client.npcIndices[++Client.field946 - 1] = var3;
                  var4.field1260 = Client.gameCycle;
                  Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var3;
               } else if(var6 == 1) {
                  Client.npcIndices[++Client.field946 - 1] = var3;
                  var4.field1260 = Client.gameCycle;
                  var7 = Client.secretPacketBuffer2.getBits(3);
                  var4.method1696(var7, (byte)1);
                  var8 = Client.secretPacketBuffer2.getBits(1);
                  if(var8 == 1) {
                     Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var3;
                  }
               } else if(var6 == 2) {
                  Client.npcIndices[++Client.field946 - 1] = var3;
                  var4.field1260 = Client.gameCycle;
                  var7 = Client.secretPacketBuffer2.getBits(3);
                  var4.method1696(var7, (byte)2);
                  var8 = Client.secretPacketBuffer2.getBits(3);
                  var4.method1696(var8, (byte)2);
                  int var9 = Client.secretPacketBuffer2.getBits(1);
                  if(var9 == 1) {
                     Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var3;
                  }
               } else if(var6 == 3) {
                  Client.field1055[++Client.field1054 - 1] = var3;
               }
            }
         }

         while(Client.secretPacketBuffer2.bitsAvail(Client.packetLength) >= 27) {
            var1 = Client.secretPacketBuffer2.getBits(15);
            if(var1 == 32767) {
               break;
            }

            boolean var12 = false;
            if(Client.cachedNPCs[var1] == null) {
               Client.cachedNPCs[var1] = new NPC();
               var12 = true;
            }

            NPC var10 = Client.cachedNPCs[var1];
            Client.npcIndices[++Client.field946 - 1] = var1;
            var10.field1260 = Client.gameCycle;
            int var11;
            if(var0) {
               var11 = Client.secretPacketBuffer2.getBits(8);
               if(var11 > 127) {
                  var11 -= 256;
               }
            } else {
               var11 = Client.secretPacketBuffer2.getBits(5);
               if(var11 > 15) {
                  var11 -= 32;
               }
            }

            if(var0) {
               var5 = Client.secretPacketBuffer2.getBits(8);
               if(var5 > 127) {
                  var5 -= 256;
               }
            } else {
               var5 = Client.secretPacketBuffer2.getBits(5);
               if(var5 > 15) {
                  var5 -= 32;
               }
            }

            var6 = Client.secretPacketBuffer2.getBits(1);
            var7 = Client.secretPacketBuffer2.getBits(1);
            if(var7 == 1) {
               Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var1;
            }

            var10.composition = class171.getNpcDefinition(Client.secretPacketBuffer2.getBits(14));
            var8 = Client.field1051[Client.secretPacketBuffer2.getBits(3)];
            if(var12) {
               var10.orientation = var10.angle = var8;
            }

            var10.field1233 = var10.composition.field3574;
            var10.field1282 = var10.composition.field3575;
            if(var10.field1282 == 0) {
               var10.angle = 0;
            }

            var10.field1268 = var10.composition.field3558;
            var10.field1238 = var10.composition.field3559;
            var10.field1288 = var10.composition.field3560;
            var10.field1230 = var10.composition.field3561;
            var10.idlePoseAnimation = var10.composition.field3555;
            var10.field1253 = var10.composition.field3557;
            var10.field1251 = var10.composition.field3546;
            var10.method1704(Player.localPlayer.pathX[0] + var11, Player.localPlayer.pathY[0] + var5, var6 == 1);
         }

         Client.secretPacketBuffer2.byteAccess();
         Huffman.method3170();

         for(var1 = 0; var1 < Client.field1054; ++var1) {
            var2 = Client.field1055[var1];
            if(Client.cachedNPCs[var2].field1260 != Client.gameCycle) {
               Client.cachedNPCs[var2].composition = null;
               Client.cachedNPCs[var2] = null;
            }
         }

         if(Client.packetLength != Client.secretPacketBuffer2.offset) {
            throw new RuntimeException(Client.secretPacketBuffer2.offset + "," + Client.packetLength);
         } else {
            for(var1 = 0; var1 < Client.field946; ++var1) {
               if(Client.cachedNPCs[Client.npcIndices[var1]] == null) {
                  throw new RuntimeException(var1 + "," + Client.field946);
               }
            }

         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILck;ZS)I",
      garbageValue = "28584"
   )
   static int method267(int var0, Script var1, boolean var2) {
      if(var0 < 1000) {
         return class86.method1705(var0, var1, var2);
      } else if(var0 < 1100) {
         return ScriptState.method1103(var0, var1, var2);
      } else if(var0 < 1200) {
         return class19.method165(var0, var1, var2);
      } else if(var0 < 1300) {
         return class218.method4079(var0, var1, var2);
      } else if(var0 < 1400) {
         return class56.method867(var0, var1, var2);
      } else if(var0 < 1500) {
         return Actor.method1539(var0, var1, var2);
      } else {
         byte var3;
         Widget var37;
         if(var0 < 1600) {
            var37 = var2?class31.field452:class23.field366;
            if(var0 == 1500) {
               class82.intStack[++Ignore.intStackSize - 1] = var37.relativeX;
               var3 = 1;
            } else if(var0 == 1501) {
               class82.intStack[++Ignore.intStackSize - 1] = var37.relativeY;
               var3 = 1;
            } else if(var0 == 1502) {
               class82.intStack[++Ignore.intStackSize - 1] = var37.width;
               var3 = 1;
            } else if(var0 == 1503) {
               class82.intStack[++Ignore.intStackSize - 1] = var37.height;
               var3 = 1;
            } else if(var0 == 1504) {
               class82.intStack[++Ignore.intStackSize - 1] = var37.isHidden?1:0;
               var3 = 1;
            } else if(var0 == 1505) {
               class82.intStack[++Ignore.intStackSize - 1] = var37.parentId;
               var3 = 1;
            } else {
               var3 = 2;
            }

            return var3;
         } else if(var0 < 1700) {
            return Varcs.method1842(var0, var1, var2);
         } else if(var0 < 1800) {
            return class17.method136(var0, var1, var2);
         } else {
            int var6;
            int var8;
            int var19;
            int[] var44;
            int var64;
            Widget var68;
            if(var0 < 1900) {
               var68 = var2?class31.field452:class23.field366;
               if(var0 == 1800) {
                  var44 = class82.intStack;
                  var6 = ++Ignore.intStackSize - 1;
                  var8 = Coordinates.getWidgetConfig(var68);
                  var64 = var8 >> 11 & 63;
                  var44[var6] = var64;
                  var3 = 1;
               } else if(var0 == 1801) {
                  var19 = class82.intStack[--Ignore.intStackSize];
                  --var19;
                  if(var68.actions != null && var19 < var68.actions.length && var68.actions[var19] != null) {
                     class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var68.actions[var19];
                  } else {
                     class82.scriptStringStack[++class169.scriptStringStackSize - 1] = "";
                  }

                  var3 = 1;
               } else if(var0 == 1802) {
                  if(var68.name == null) {
                     class82.scriptStringStack[++class169.scriptStringStackSize - 1] = "";
                  } else {
                     class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var68.name;
                  }

                  var3 = 1;
               } else {
                  var3 = 2;
               }

               return var3;
            } else if(var0 < 2000) {
               return class8.method43(var0, var1, var2);
            } else if(var0 < 2100) {
               return ScriptState.method1103(var0, var1, var2);
            } else if(var0 < 2200) {
               return class19.method165(var0, var1, var2);
            } else if(var0 < 2300) {
               return class218.method4079(var0, var1, var2);
            } else if(var0 < 2400) {
               return class56.method867(var0, var1, var2);
            } else if(var0 < 2500) {
               return Actor.method1539(var0, var1, var2);
            } else if(var0 < 2600) {
               var68 = GZipDecompressor.method3177(class82.intStack[--Ignore.intStackSize]);
               if(var0 == 2500) {
                  class82.intStack[++Ignore.intStackSize - 1] = var68.relativeX;
                  var3 = 1;
               } else if(var0 == 2501) {
                  class82.intStack[++Ignore.intStackSize - 1] = var68.relativeY;
                  var3 = 1;
               } else if(var0 == 2502) {
                  class82.intStack[++Ignore.intStackSize - 1] = var68.width;
                  var3 = 1;
               } else if(var0 == 2503) {
                  class82.intStack[++Ignore.intStackSize - 1] = var68.height;
                  var3 = 1;
               } else if(var0 == 2504) {
                  class82.intStack[++Ignore.intStackSize - 1] = var68.isHidden?1:0;
                  var3 = 1;
               } else if(var0 == 2505) {
                  class82.intStack[++Ignore.intStackSize - 1] = var68.parentId;
                  var3 = 1;
               } else {
                  var3 = 2;
               }

               return var3;
            } else if(var0 < 2700) {
               return class47.method743(var0, var1, var2);
            } else if(var0 < 2800) {
               return class170.method3213(var0, var1, var2);
            } else if(var0 < 2900) {
               var68 = GZipDecompressor.method3177(class82.intStack[--Ignore.intStackSize]);
               if(var0 == 2800) {
                  var44 = class82.intStack;
                  var6 = ++Ignore.intStackSize - 1;
                  var8 = Coordinates.getWidgetConfig(var68);
                  var64 = var8 >> 11 & 63;
                  var44[var6] = var64;
                  var3 = 1;
               } else if(var0 == 2801) {
                  var19 = class82.intStack[--Ignore.intStackSize];
                  --var19;
                  if(var68.actions != null && var19 < var68.actions.length && var68.actions[var19] != null) {
                     class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var68.actions[var19];
                  } else {
                     class82.scriptStringStack[++class169.scriptStringStackSize - 1] = "";
                  }

                  var3 = 1;
               } else if(var0 == 2802) {
                  if(var68.name == null) {
                     class82.scriptStringStack[++class169.scriptStringStackSize - 1] = "";
                  } else {
                     class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var68.name;
                  }

                  var3 = 1;
               } else {
                  var3 = 2;
               }

               return var3;
            } else if(var0 < 3000) {
               return class8.method43(var0, var1, var2);
            } else {
               int var4;
               String var5;
               int var10;
               int var11;
               int var12;
               int var13;
               char var46;
               boolean var50;
               String var58;
               String var60;
               if(var0 < 3200) {
                  if(var0 == 3100) {
                     var58 = class82.scriptStringStack[--class169.scriptStringStackSize];
                     Client.sendGameMessage(0, "", var58);
                     var3 = 1;
                  } else if(var0 == 3101) {
                     Ignore.intStackSize -= 2;
                     class15.method95(Player.localPlayer, class82.intStack[Ignore.intStackSize], class82.intStack[Ignore.intStackSize + 1]);
                     var3 = 1;
                  } else if(var0 == 3103) {
                     Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_174);

                     for(WidgetNode var67 = (WidgetNode)Client.componentTable.method3628(); var67 != null; var67 = (WidgetNode)Client.componentTable.method3625()) {
                        if(var67.owner == 0 || var67.owner == 3) {
                           MessageNode.method1143(var67, true);
                        }
                     }

                     if(Client.field1086 != null) {
                        class7.method34(Client.field1086);
                        Client.field1086 = null;
                     }

                     var3 = 1;
                  } else if(var0 == 3104) {
                     var58 = class82.scriptStringStack[--class169.scriptStringStackSize];
                     var19 = 0;
                     boolean var47 = false;
                     boolean var42 = false;
                     var10 = 0;
                     var11 = var58.length();
                     var12 = 0;

                     boolean var66;
                     while(true) {
                        if(var12 >= var11) {
                           var66 = var42;
                           break;
                        }

                        label2239: {
                           var46 = var58.charAt(var12);
                           if(var12 == 0) {
                              if(var46 == 45) {
                                 var47 = true;
                                 break label2239;
                              }

                              if(var46 == 43) {
                                 break label2239;
                              }
                           }

                           if(var46 >= 48 && var46 <= 57) {
                              var13 = var46 - 48;
                           } else if(var46 >= 65 && var46 <= 90) {
                              var13 = var46 - 55;
                           } else {
                              if(var46 < 97 || var46 > 122) {
                                 var66 = false;
                                 break;
                              }

                              var13 = var46 - 87;
                           }

                           if(var13 >= 10) {
                              var66 = false;
                              break;
                           }

                           if(var47) {
                              var13 = -var13;
                           }

                           int var14 = var13 + var10 * 10;
                           if(var10 != var14 / 10) {
                              var66 = false;
                              break;
                           }

                           var10 = var14;
                           var42 = true;
                        }

                        ++var12;
                     }

                     if(var66) {
                        var64 = class227.parseInt(var58, 10, true);
                        var19 = var64;
                     }

                     Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_NUMERIC_INPUT);
                     Client.secretPacketBuffer1.putInt(var19);
                     var3 = 1;
                  } else if(var0 == 3105) {
                     var58 = class82.scriptStringStack[--class169.scriptStringStackSize];
                     Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_175);
                     Client.secretPacketBuffer1.putByte(var58.length() + 1);
                     Client.secretPacketBuffer1.putString(var58);
                     var3 = 1;
                  } else if(var0 == 3106) {
                     var58 = class82.scriptStringStack[--class169.scriptStringStackSize];
                     Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_216);
                     Client.secretPacketBuffer1.putByte(var58.length() + 1);
                     Client.secretPacketBuffer1.putString(var58);
                     var3 = 1;
                  } else if(var0 == 3107) {
                     var4 = class82.intStack[--Ignore.intStackSize];
                     var5 = class82.scriptStringStack[--class169.scriptStringStackSize];
                     CacheFile.method2363(var4, var5);
                     var3 = 1;
                  } else if(var0 == 3108) {
                     Ignore.intStackSize -= 3;
                     var4 = class82.intStack[Ignore.intStackSize];
                     var19 = class82.intStack[Ignore.intStackSize + 1];
                     var6 = class82.intStack[Ignore.intStackSize + 2];
                     var37 = GZipDecompressor.method3177(var6);
                     VertexNormal.method2614(var37, var4, var19);
                     var3 = 1;
                  } else if(var0 == 3109) {
                     Ignore.intStackSize -= 2;
                     var4 = class82.intStack[Ignore.intStackSize];
                     var19 = class82.intStack[Ignore.intStackSize + 1];
                     Widget var63 = var2?class31.field452:class23.field366;
                     VertexNormal.method2614(var63, var4, var19);
                     var3 = 1;
                  } else if(var0 == 3110) {
                     Client.field951 = class82.intStack[--Ignore.intStackSize] == 1;
                     var3 = 1;
                  } else if(var0 == 3111) {
                     class82.intStack[++Ignore.intStackSize - 1] = Buffer.preferences.hideRoofs?1:0;
                     var3 = 1;
                  } else if(var0 == 3112) {
                     Buffer.preferences.hideRoofs = class82.intStack[--Ignore.intStackSize] == 1;
                     class20.method176();
                     var3 = 1;
                  } else if(var0 == 3113) {
                     var58 = class82.scriptStringStack[--class169.scriptStringStackSize];
                     var50 = class82.intStack[--Ignore.intStackSize] == 1;
                     class35.method517(var58, var50, false);
                     var3 = 1;
                  } else if(var0 == 3115) {
                     var4 = class82.intStack[--Ignore.intStackSize];
                     Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_ITEM_PRICE);
                     Client.secretPacketBuffer1.putShort(var4);
                     var3 = 1;
                  } else if(var0 == 3116) {
                     var4 = class82.intStack[--Ignore.intStackSize];
                     class169.scriptStringStackSize -= 2;
                     var5 = class82.scriptStringStack[class169.scriptStringStackSize];
                     var60 = class82.scriptStringStack[class169.scriptStringStackSize + 1];
                     if(var5.length() > 500) {
                        var3 = 1;
                     } else if(var60.length() > 500) {
                        var3 = 1;
                     } else {
                        Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_165);
                        Client.secretPacketBuffer1.putShort(1 + ClanMember.getLength(var5) + ClanMember.getLength(var60));
                        Client.secretPacketBuffer1.method3311(var4);
                        Client.secretPacketBuffer1.putString(var60);
                        Client.secretPacketBuffer1.putString(var5);
                        var3 = 1;
                     }
                  } else if(var0 == 3117) {
                     Client.field969 = class82.intStack[--Ignore.intStackSize] == 1;
                     var3 = 1;
                  } else {
                     var3 = 2;
                  }

                  return var3;
               } else if(var0 < 3300) {
                  if(var0 == 3200) {
                     Ignore.intStackSize -= 3;
                     var4 = class82.intStack[Ignore.intStackSize];
                     var19 = class82.intStack[Ignore.intStackSize + 1];
                     var6 = class82.intStack[Ignore.intStackSize + 2];
                     if(Client.field1185 != 0 && var19 != 0 && Client.field1172 < 50) {
                        Client.field1173[Client.field1172] = var4;
                        Client.field1174[Client.field1172] = var19;
                        Client.field1001[Client.field1172] = var6;
                        Client.audioEffects[Client.field1172] = null;
                        Client.field1176[Client.field1172] = 0;
                        ++Client.field1172;
                     }

                     var3 = 1;
                  } else if(var0 == 3201) {
                     class148.method2956(class82.intStack[--Ignore.intStackSize]);
                     var3 = 1;
                  } else if(var0 == 3202) {
                     Ignore.intStackSize -= 2;
                     class9.method55(class82.intStack[Ignore.intStackSize], class82.intStack[Ignore.intStackSize + 1]);
                     var3 = 1;
                  } else {
                     var3 = 2;
                  }

                  return var3;
               } else if(var0 < 3400) {
                  return class163.method3143(var0, var1, var2);
               } else {
                  int var9;
                  if(var0 < 3500) {
                     if(var0 == 3400) {
                        Ignore.intStackSize -= 2;
                        var4 = class82.intStack[Ignore.intStackSize];
                        var19 = class82.intStack[Ignore.intStackSize + 1];
                        Enum var62 = class204.method3764(var4);
                        if(var62.valType != 115) {
                           ;
                        }

                        for(var64 = 0; var64 < var62.size; ++var64) {
                           if(var19 == var62.keys[var64]) {
                              class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var62.stringVals[var64];
                              var62 = null;
                              break;
                           }
                        }

                        if(var62 != null) {
                           class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var62.defaultString;
                        }

                        var3 = 1;
                     } else if(var0 == 3408) {
                        Ignore.intStackSize -= 4;
                        var4 = class82.intStack[Ignore.intStackSize];
                        var19 = class82.intStack[Ignore.intStackSize + 1];
                        var6 = class82.intStack[Ignore.intStackSize + 2];
                        var64 = class82.intStack[Ignore.intStackSize + 3];
                        Enum var56 = class204.method3764(var6);
                        if(var4 == var56.keyType && var19 == var56.valType) {
                           for(var9 = 0; var9 < var56.size; ++var9) {
                              if(var64 == var56.keys[var9]) {
                                 if(var19 == 115) {
                                    class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var56.stringVals[var9];
                                 } else {
                                    class82.intStack[++Ignore.intStackSize - 1] = var56.intVals[var9];
                                 }

                                 var56 = null;
                                 break;
                              }
                           }

                           if(var56 != null) {
                              if(var19 == 115) {
                                 class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var56.defaultString;
                              } else {
                                 class82.intStack[++Ignore.intStackSize - 1] = var56.defaultInt;
                              }
                           }

                           var3 = 1;
                        } else {
                           if(var19 == 115) {
                              class82.scriptStringStack[++class169.scriptStringStackSize - 1] = "null";
                           } else {
                              class82.intStack[++Ignore.intStackSize - 1] = 0;
                           }

                           var3 = 1;
                        }
                     } else {
                        var3 = 2;
                     }

                     return var3;
                  } else if(var0 < 3700) {
                     return class8.method45(var0, var1, var2);
                  } else {
                     long var27;
                     boolean var39;
                     if(var0 < 4000) {
                        if(var0 == 3903) {
                           var4 = class82.intStack[--Ignore.intStackSize];
                           class82.intStack[++Ignore.intStackSize - 1] = Client.grandExchangeOffers[var4].method114();
                           var3 = 1;
                        } else if(var0 == 3904) {
                           var4 = class82.intStack[--Ignore.intStackSize];
                           class82.intStack[++Ignore.intStackSize - 1] = Client.grandExchangeOffers[var4].itemId;
                           var3 = 1;
                        } else if(var0 == 3905) {
                           var4 = class82.intStack[--Ignore.intStackSize];
                           class82.intStack[++Ignore.intStackSize - 1] = Client.grandExchangeOffers[var4].price;
                           var3 = 1;
                        } else if(var0 == 3906) {
                           var4 = class82.intStack[--Ignore.intStackSize];
                           class82.intStack[++Ignore.intStackSize - 1] = Client.grandExchangeOffers[var4].totalQuantity;
                           var3 = 1;
                        } else if(var0 == 3907) {
                           var4 = class82.intStack[--Ignore.intStackSize];
                           class82.intStack[++Ignore.intStackSize - 1] = Client.grandExchangeOffers[var4].quantitySold;
                           var3 = 1;
                        } else if(var0 == 3908) {
                           var4 = class82.intStack[--Ignore.intStackSize];
                           class82.intStack[++Ignore.intStackSize - 1] = Client.grandExchangeOffers[var4].spent;
                           var3 = 1;
                        } else if(var0 == 3910) {
                           var4 = class82.intStack[--Ignore.intStackSize];
                           var19 = Client.grandExchangeOffers[var4].method118();
                           class82.intStack[++Ignore.intStackSize - 1] = var19 == 0?1:0;
                           var3 = 1;
                        } else if(var0 == 3911) {
                           var4 = class82.intStack[--Ignore.intStackSize];
                           var19 = Client.grandExchangeOffers[var4].method118();
                           class82.intStack[++Ignore.intStackSize - 1] = var19 == 2?1:0;
                           var3 = 1;
                        } else if(var0 == 3912) {
                           var4 = class82.intStack[--Ignore.intStackSize];
                           var19 = Client.grandExchangeOffers[var4].method118();
                           class82.intStack[++Ignore.intStackSize - 1] = var19 == 5?1:0;
                           var3 = 1;
                        } else if(var0 == 3913) {
                           var4 = class82.intStack[--Ignore.intStackSize];
                           var19 = Client.grandExchangeOffers[var4].method118();
                           class82.intStack[++Ignore.intStackSize - 1] = var19 == 1?1:0;
                           var3 = 1;
                        } else if(var0 == 3914) {
                           var39 = class82.intStack[--Ignore.intStackSize] == 1;
                           if(ISAACCipher.field2441 != null) {
                              ISAACCipher.field2441.method77(class13.field285, var39);
                           }

                           var3 = 1;
                        } else if(var0 == 3915) {
                           var39 = class82.intStack[--Ignore.intStackSize] == 1;
                           if(ISAACCipher.field2441 != null) {
                              ISAACCipher.field2441.method77(class13.field284, var39);
                           }

                           var3 = 1;
                        } else if(var0 == 3916) {
                           Ignore.intStackSize -= 2;
                           var39 = class82.intStack[Ignore.intStackSize] == 1;
                           var50 = class82.intStack[Ignore.intStackSize + 1] == 1;
                           if(ISAACCipher.field2441 != null) {
                              ISAACCipher.field2441.method77(new class94(var50), var39);
                           }

                           var3 = 1;
                        } else if(var0 == 3917) {
                           var39 = class82.intStack[--Ignore.intStackSize] == 1;
                           if(ISAACCipher.field2441 != null) {
                              ISAACCipher.field2441.method77(class13.field283, var39);
                           }

                           var3 = 1;
                        } else if(var0 == 3918) {
                           var39 = class82.intStack[--Ignore.intStackSize] == 1;
                           if(ISAACCipher.field2441 != null) {
                              ISAACCipher.field2441.method77(class13.field291, var39);
                           }

                           var3 = 1;
                        } else if(var0 == 3919) {
                           class82.intStack[++Ignore.intStackSize - 1] = ISAACCipher.field2441 == null?0:ISAACCipher.field2441.field289.size();
                           var3 = 1;
                        } else {
                           class14 var48;
                           if(var0 == 3920) {
                              var4 = class82.intStack[--Ignore.intStackSize];
                              var48 = (class14)ISAACCipher.field2441.field289.get(var4);
                              class82.intStack[++Ignore.intStackSize - 1] = var48.field298;
                              var3 = 1;
                           } else if(var0 == 3921) {
                              var4 = class82.intStack[--Ignore.intStackSize];
                              var48 = (class14)ISAACCipher.field2441.field289.get(var4);
                              class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var48.method88();
                              var3 = 1;
                           } else if(var0 == 3922) {
                              var4 = class82.intStack[--Ignore.intStackSize];
                              var48 = (class14)ISAACCipher.field2441.field289.get(var4);
                              class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var48.method91();
                              var3 = 1;
                           } else if(var0 == 3923) {
                              var4 = class82.intStack[--Ignore.intStackSize];
                              var48 = (class14)ISAACCipher.field2441.field289.get(var4);
                              var27 = class45.currentTimeMs() - class19.field334 - var48.field295;
                              var8 = (int)(var27 / 3600000L);
                              var9 = (int)((var27 - (long)(var8 * 3600000)) / 60000L);
                              var10 = (int)((var27 - (long)(var8 * 3600000) - (long)(var9 * '\uea60')) / 1000L);
                              String var65 = var8 + ":" + var9 / 10 + var9 % 10 + ":" + var10 / 10 + var10 % 10;
                              class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var65;
                              var3 = 1;
                           } else if(var0 == 3924) {
                              var4 = class82.intStack[--Ignore.intStackSize];
                              var48 = (class14)ISAACCipher.field2441.field289.get(var4);
                              class82.intStack[++Ignore.intStackSize - 1] = var48.field296.totalQuantity;
                              var3 = 1;
                           } else if(var0 == 3925) {
                              var4 = class82.intStack[--Ignore.intStackSize];
                              var48 = (class14)ISAACCipher.field2441.field289.get(var4);
                              class82.intStack[++Ignore.intStackSize - 1] = var48.field296.price;
                              var3 = 1;
                           } else if(var0 == 3926) {
                              var4 = class82.intStack[--Ignore.intStackSize];
                              var48 = (class14)ISAACCipher.field2441.field289.get(var4);
                              class82.intStack[++Ignore.intStackSize - 1] = var48.field296.itemId;
                              var3 = 1;
                           } else {
                              var3 = 2;
                           }
                        }

                        return var3;
                     } else if(var0 < 4100) {
                        if(var0 == 4000) {
                           Ignore.intStackSize -= 2;
                           var4 = class82.intStack[Ignore.intStackSize];
                           var19 = class82.intStack[Ignore.intStackSize + 1];
                           class82.intStack[++Ignore.intStackSize - 1] = var19 + var4;
                           var3 = 1;
                        } else if(var0 == 4001) {
                           Ignore.intStackSize -= 2;
                           var4 = class82.intStack[Ignore.intStackSize];
                           var19 = class82.intStack[Ignore.intStackSize + 1];
                           class82.intStack[++Ignore.intStackSize - 1] = var4 - var19;
                           var3 = 1;
                        } else if(var0 == 4002) {
                           Ignore.intStackSize -= 2;
                           var4 = class82.intStack[Ignore.intStackSize];
                           var19 = class82.intStack[Ignore.intStackSize + 1];
                           class82.intStack[++Ignore.intStackSize - 1] = var4 * var19;
                           var3 = 1;
                        } else if(var0 == 4003) {
                           Ignore.intStackSize -= 2;
                           var4 = class82.intStack[Ignore.intStackSize];
                           var19 = class82.intStack[Ignore.intStackSize + 1];
                           class82.intStack[++Ignore.intStackSize - 1] = var4 / var19;
                           var3 = 1;
                        } else if(var0 == 4004) {
                           var4 = class82.intStack[--Ignore.intStackSize];
                           class82.intStack[++Ignore.intStackSize - 1] = (int)(Math.random() * (double)var4);
                           var3 = 1;
                        } else if(var0 == 4005) {
                           var4 = class82.intStack[--Ignore.intStackSize];
                           class82.intStack[++Ignore.intStackSize - 1] = (int)(Math.random() * (double)(var4 + 1));
                           var3 = 1;
                        } else if(var0 == 4006) {
                           Ignore.intStackSize -= 5;
                           var4 = class82.intStack[Ignore.intStackSize];
                           var19 = class82.intStack[Ignore.intStackSize + 1];
                           var6 = class82.intStack[Ignore.intStackSize + 2];
                           var64 = class82.intStack[Ignore.intStackSize + 3];
                           var8 = class82.intStack[Ignore.intStackSize + 4];
                           class82.intStack[++Ignore.intStackSize - 1] = var4 + (var8 - var6) * (var19 - var4) / (var64 - var6);
                           var3 = 1;
                        } else if(var0 == 4007) {
                           Ignore.intStackSize -= 2;
                           var4 = class82.intStack[Ignore.intStackSize];
                           var19 = class82.intStack[Ignore.intStackSize + 1];
                           class82.intStack[++Ignore.intStackSize - 1] = var4 + var4 * var19 / 100;
                           var3 = 1;
                        } else if(var0 == 4008) {
                           Ignore.intStackSize -= 2;
                           var4 = class82.intStack[Ignore.intStackSize];
                           var19 = class82.intStack[Ignore.intStackSize + 1];
                           class82.intStack[++Ignore.intStackSize - 1] = var4 | 1 << var19;
                           var3 = 1;
                        } else if(var0 == 4009) {
                           Ignore.intStackSize -= 2;
                           var4 = class82.intStack[Ignore.intStackSize];
                           var19 = class82.intStack[Ignore.intStackSize + 1];
                           class82.intStack[++Ignore.intStackSize - 1] = var4 & -1 - (1 << var19);
                           var3 = 1;
                        } else if(var0 == 4010) {
                           Ignore.intStackSize -= 2;
                           var4 = class82.intStack[Ignore.intStackSize];
                           var19 = class82.intStack[Ignore.intStackSize + 1];
                           class82.intStack[++Ignore.intStackSize - 1] = (var4 & 1 << var19) != 0?1:0;
                           var3 = 1;
                        } else if(var0 == 4011) {
                           Ignore.intStackSize -= 2;
                           var4 = class82.intStack[Ignore.intStackSize];
                           var19 = class82.intStack[Ignore.intStackSize + 1];
                           class82.intStack[++Ignore.intStackSize - 1] = var4 % var19;
                           var3 = 1;
                        } else if(var0 == 4012) {
                           Ignore.intStackSize -= 2;
                           var4 = class82.intStack[Ignore.intStackSize];
                           var19 = class82.intStack[Ignore.intStackSize + 1];
                           if(var4 == 0) {
                              class82.intStack[++Ignore.intStackSize - 1] = 0;
                           } else {
                              class82.intStack[++Ignore.intStackSize - 1] = (int)Math.pow((double)var4, (double)var19);
                           }

                           var3 = 1;
                        } else if(var0 == 4013) {
                           Ignore.intStackSize -= 2;
                           var4 = class82.intStack[Ignore.intStackSize];
                           var19 = class82.intStack[Ignore.intStackSize + 1];
                           if(var4 == 0) {
                              class82.intStack[++Ignore.intStackSize - 1] = 0;
                           } else if(var19 == 0) {
                              class82.intStack[++Ignore.intStackSize - 1] = Integer.MAX_VALUE;
                           } else {
                              class82.intStack[++Ignore.intStackSize - 1] = (int)Math.pow((double)var4, 1.0D / (double)var19);
                           }

                           var3 = 1;
                        } else if(var0 == 4014) {
                           Ignore.intStackSize -= 2;
                           var4 = class82.intStack[Ignore.intStackSize];
                           var19 = class82.intStack[Ignore.intStackSize + 1];
                           class82.intStack[++Ignore.intStackSize - 1] = var4 & var19;
                           var3 = 1;
                        } else if(var0 == 4015) {
                           Ignore.intStackSize -= 2;
                           var4 = class82.intStack[Ignore.intStackSize];
                           var19 = class82.intStack[Ignore.intStackSize + 1];
                           class82.intStack[++Ignore.intStackSize - 1] = var4 | var19;
                           var3 = 1;
                        } else if(var0 == 4018) {
                           Ignore.intStackSize -= 3;
                           long var30 = (long)class82.intStack[Ignore.intStackSize];
                           var27 = (long)class82.intStack[Ignore.intStackSize + 1];
                           long var32 = (long)class82.intStack[Ignore.intStackSize + 2];
                           class82.intStack[++Ignore.intStackSize - 1] = (int)(var32 * var30 / var27);
                           var3 = 1;
                        } else {
                           var3 = 2;
                        }

                        return var3;
                     } else if(var0 < 4200) {
                        return class46.method727(var0, var1, var2);
                     } else if(var0 < 4300) {
                        if(var0 == 4200) {
                           var4 = class82.intStack[--Ignore.intStackSize];
                           class82.scriptStringStack[++class169.scriptStringStackSize - 1] = class169.getItemDefinition(var4).name;
                           var3 = 1;
                        } else {
                           ItemComposition var61;
                           if(var0 == 4201) {
                              Ignore.intStackSize -= 2;
                              var4 = class82.intStack[Ignore.intStackSize];
                              var19 = class82.intStack[Ignore.intStackSize + 1];
                              var61 = class169.getItemDefinition(var4);
                              if(var19 >= 1 && var19 <= 5 && var61.groundActions[var19 - 1] != null) {
                                 class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var61.groundActions[var19 - 1];
                              } else {
                                 class82.scriptStringStack[++class169.scriptStringStackSize - 1] = "";
                              }

                              var3 = 1;
                           } else if(var0 == 4202) {
                              Ignore.intStackSize -= 2;
                              var4 = class82.intStack[Ignore.intStackSize];
                              var19 = class82.intStack[Ignore.intStackSize + 1];
                              var61 = class169.getItemDefinition(var4);
                              if(var19 >= 1 && var19 <= 5 && var61.inventoryActions[var19 - 1] != null) {
                                 class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var61.inventoryActions[var19 - 1];
                              } else {
                                 class82.scriptStringStack[++class169.scriptStringStackSize - 1] = "";
                              }

                              var3 = 1;
                           } else if(var0 == 4203) {
                              var4 = class82.intStack[--Ignore.intStackSize];
                              class82.intStack[++Ignore.intStackSize - 1] = class169.getItemDefinition(var4).price;
                              var3 = 1;
                           } else if(var0 == 4204) {
                              var4 = class82.intStack[--Ignore.intStackSize];
                              class82.intStack[++Ignore.intStackSize - 1] = class169.getItemDefinition(var4).isStackable == 1?1:0;
                              var3 = 1;
                           } else {
                              ItemComposition var45;
                              if(var0 == 4205) {
                                 var4 = class82.intStack[--Ignore.intStackSize];
                                 var45 = class169.getItemDefinition(var4);
                                 if(var45.notedTemplate == -1 && var45.note >= 0) {
                                    class82.intStack[++Ignore.intStackSize - 1] = var45.note;
                                 } else {
                                    class82.intStack[++Ignore.intStackSize - 1] = var4;
                                 }

                                 var3 = 1;
                              } else if(var0 == 4206) {
                                 var4 = class82.intStack[--Ignore.intStackSize];
                                 var45 = class169.getItemDefinition(var4);
                                 if(var45.notedTemplate >= 0 && var45.note >= 0) {
                                    class82.intStack[++Ignore.intStackSize - 1] = var45.note;
                                 } else {
                                    class82.intStack[++Ignore.intStackSize - 1] = var4;
                                 }

                                 var3 = 1;
                              } else if(var0 == 4207) {
                                 var4 = class82.intStack[--Ignore.intStackSize];
                                 class82.intStack[++Ignore.intStackSize - 1] = class169.getItemDefinition(var4).isMembers?1:0;
                                 var3 = 1;
                              } else if(var0 == 4208) {
                                 var4 = class82.intStack[--Ignore.intStackSize];
                                 var45 = class169.getItemDefinition(var4);
                                 if(var45.field3497 == -1 && var45.field3536 >= 0) {
                                    class82.intStack[++Ignore.intStackSize - 1] = var45.field3536;
                                 } else {
                                    class82.intStack[++Ignore.intStackSize - 1] = var4;
                                 }

                                 var3 = 1;
                              } else if(var0 == 4209) {
                                 var4 = class82.intStack[--Ignore.intStackSize];
                                 var45 = class169.getItemDefinition(var4);
                                 if(var45.field3497 >= 0 && var45.field3536 >= 0) {
                                    class82.intStack[++Ignore.intStackSize - 1] = var45.field3536;
                                 } else {
                                    class82.intStack[++Ignore.intStackSize - 1] = var4;
                                 }

                                 var3 = 1;
                              } else if(var0 == 4210) {
                                 var58 = class82.scriptStringStack[--class169.scriptStringStackSize];
                                 var19 = class82.intStack[--Ignore.intStackSize];
                                 class86.method1708(var58, var19 == 1);
                                 class82.intStack[++Ignore.intStackSize - 1] = class182.field2443;
                                 var3 = 1;
                              } else if(var0 == 4211) {
                                 if(class271.field3676 != null && class244.field3319 < class182.field2443) {
                                    class82.intStack[++Ignore.intStackSize - 1] = class271.field3676[++class244.field3319 - 1] & '\uffff';
                                 } else {
                                    class82.intStack[++Ignore.intStackSize - 1] = -1;
                                 }

                                 var3 = 1;
                              } else if(var0 == 4212) {
                                 class244.field3319 = 0;
                                 var3 = 1;
                              } else {
                                 var3 = 2;
                              }
                           }
                        }

                        return var3;
                     } else if(var0 < 5100) {
                        if(var0 == 5000) {
                           class82.intStack[++Ignore.intStackSize - 1] = Client.field1148;
                           var3 = 1;
                        } else if(var0 == 5001) {
                           Ignore.intStackSize -= 3;
                           Client.field1148 = class82.intStack[Ignore.intStackSize];
                           var19 = class82.intStack[Ignore.intStackSize + 1];
                           class277[] var57 = new class277[]{class277.field3736, class277.field3737, class277.field3735};
                           class277[] var7 = var57;
                           var8 = 0;

                           class277 var53;
                           while(true) {
                              if(var8 >= var7.length) {
                                 var53 = null;
                                 break;
                              }

                              class277 var22 = var7[var8];
                              if(var19 == var22.field3738) {
                                 var53 = var22;
                                 break;
                              }

                              ++var8;
                           }

                           class13.field293 = var53;
                           if(class13.field293 == null) {
                              class13.field293 = class277.field3735;
                           }

                           Client.field1149 = class82.intStack[Ignore.intStackSize + 2];
                           Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_CHATFILTER_UPDATE);
                           Client.secretPacketBuffer1.putByte(Client.field1148);
                           Client.secretPacketBuffer1.putByte(class13.field293.field3738);
                           Client.secretPacketBuffer1.putByte(Client.field1149);
                           var3 = 1;
                        } else if(var0 == 5002) {
                           var58 = class82.scriptStringStack[--class169.scriptStringStackSize];
                           Ignore.intStackSize -= 2;
                           var19 = class82.intStack[Ignore.intStackSize];
                           var6 = class82.intStack[Ignore.intStackSize + 1];
                           Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_REPORTED_PLAYER);
                           Client.secretPacketBuffer1.putByte(ClanMember.getLength(var58) + 2);
                           Client.secretPacketBuffer1.putString(var58);
                           Client.secretPacketBuffer1.putByte(var19 - 1);
                           Client.secretPacketBuffer1.putByte(var6);
                           var3 = 1;
                        } else if(var0 == 5003) {
                           Ignore.intStackSize -= 2;
                           var4 = class82.intStack[Ignore.intStackSize];
                           var19 = class82.intStack[Ignore.intStackSize + 1];
                           ChatLineBuffer var35 = (ChatLineBuffer)class97.chatLineMap.get(Integer.valueOf(var4));
                           MessageNode var59 = var35.method1868(var19);
                           if(var59 != null) {
                              class82.intStack[++Ignore.intStackSize - 1] = var59.id;
                              class82.intStack[++Ignore.intStackSize - 1] = var59.tick;
                              class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var59.name != null?var59.name:"";
                              class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var59.sender != null?var59.sender:"";
                              class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var59.value != null?var59.value:"";
                           } else {
                              class82.intStack[++Ignore.intStackSize - 1] = -1;
                              class82.intStack[++Ignore.intStackSize - 1] = 0;
                              class82.scriptStringStack[++class169.scriptStringStackSize - 1] = "";
                              class82.scriptStringStack[++class169.scriptStringStackSize - 1] = "";
                              class82.scriptStringStack[++class169.scriptStringStackSize - 1] = "";
                           }

                           var3 = 1;
                        } else if(var0 == 5004) {
                           var4 = class82.intStack[--Ignore.intStackSize];
                           MessageNode var43 = (MessageNode)class97.field1532.get((long)var4);
                           if(var43 != null) {
                              class82.intStack[++Ignore.intStackSize - 1] = var43.type;
                              class82.intStack[++Ignore.intStackSize - 1] = var43.tick;
                              class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var43.name != null?var43.name:"";
                              class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var43.sender != null?var43.sender:"";
                              class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var43.value != null?var43.value:"";
                           } else {
                              class82.intStack[++Ignore.intStackSize - 1] = -1;
                              class82.intStack[++Ignore.intStackSize - 1] = 0;
                              class82.scriptStringStack[++class169.scriptStringStackSize - 1] = "";
                              class82.scriptStringStack[++class169.scriptStringStackSize - 1] = "";
                              class82.scriptStringStack[++class169.scriptStringStackSize - 1] = "";
                           }

                           var3 = 1;
                        } else if(var0 == 5005) {
                           if(class13.field293 == null) {
                              class82.intStack[++Ignore.intStackSize - 1] = -1;
                           } else {
                              class82.intStack[++Ignore.intStackSize - 1] = class13.field293.field3738;
                           }

                           var3 = 1;
                        } else if(var0 == 5008) {
                           var58 = class82.scriptStringStack[--class169.scriptStringStackSize];
                           var19 = class82.intStack[--Ignore.intStackSize];
                           var60 = var58.toLowerCase();
                           byte var18 = 0;
                           if(var60.startsWith("yellow:")) {
                              var18 = 0;
                              var58 = var58.substring("yellow:".length());
                           } else if(var60.startsWith("red:")) {
                              var18 = 1;
                              var58 = var58.substring("red:".length());
                           } else if(var60.startsWith("green:")) {
                              var18 = 2;
                              var58 = var58.substring("green:".length());
                           } else if(var60.startsWith("cyan:")) {
                              var18 = 3;
                              var58 = var58.substring("cyan:".length());
                           } else if(var60.startsWith("purple:")) {
                              var18 = 4;
                              var58 = var58.substring("purple:".length());
                           } else if(var60.startsWith("white:")) {
                              var18 = 5;
                              var58 = var58.substring("white:".length());
                           } else if(var60.startsWith("flash1:")) {
                              var18 = 6;
                              var58 = var58.substring("flash1:".length());
                           } else if(var60.startsWith("flash2:")) {
                              var18 = 7;
                              var58 = var58.substring("flash2:".length());
                           } else if(var60.startsWith("flash3:")) {
                              var18 = 8;
                              var58 = var58.substring("flash3:".length());
                           } else if(var60.startsWith("glow1:")) {
                              var18 = 9;
                              var58 = var58.substring("glow1:".length());
                           } else if(var60.startsWith("glow2:")) {
                              var18 = 10;
                              var58 = var58.substring("glow2:".length());
                           } else if(var60.startsWith("glow3:")) {
                              var18 = 11;
                              var58 = var58.substring("glow3:".length());
                           } else if(Client.languageId != 0) {
                              if(var60.startsWith("yellow:")) {
                                 var18 = 0;
                                 var58 = var58.substring("yellow:".length());
                              } else if(var60.startsWith("red:")) {
                                 var18 = 1;
                                 var58 = var58.substring("red:".length());
                              } else if(var60.startsWith("green:")) {
                                 var18 = 2;
                                 var58 = var58.substring("green:".length());
                              } else if(var60.startsWith("cyan:")) {
                                 var18 = 3;
                                 var58 = var58.substring("cyan:".length());
                              } else if(var60.startsWith("purple:")) {
                                 var18 = 4;
                                 var58 = var58.substring("purple:".length());
                              } else if(var60.startsWith("white:")) {
                                 var18 = 5;
                                 var58 = var58.substring("white:".length());
                              } else if(var60.startsWith("flash1:")) {
                                 var18 = 6;
                                 var58 = var58.substring("flash1:".length());
                              } else if(var60.startsWith("flash2:")) {
                                 var18 = 7;
                                 var58 = var58.substring("flash2:".length());
                              } else if(var60.startsWith("flash3:")) {
                                 var18 = 8;
                                 var58 = var58.substring("flash3:".length());
                              } else if(var60.startsWith("glow1:")) {
                                 var18 = 9;
                                 var58 = var58.substring("glow1:".length());
                              } else if(var60.startsWith("glow2:")) {
                                 var18 = 10;
                                 var58 = var58.substring("glow2:".length());
                              } else if(var60.startsWith("glow3:")) {
                                 var18 = 11;
                                 var58 = var58.substring("glow3:".length());
                              }
                           }

                           var60 = var58.toLowerCase();
                           byte var40 = 0;
                           if(var60.startsWith("wave:")) {
                              var40 = 1;
                              var58 = var58.substring("wave:".length());
                           } else if(var60.startsWith("wave2:")) {
                              var40 = 2;
                              var58 = var58.substring("wave2:".length());
                           } else if(var60.startsWith("shake:")) {
                              var40 = 3;
                              var58 = var58.substring("shake:".length());
                           } else if(var60.startsWith("scroll:")) {
                              var40 = 4;
                              var58 = var58.substring("scroll:".length());
                           } else if(var60.startsWith("slide:")) {
                              var40 = 5;
                              var58 = var58.substring("slide:".length());
                           } else if(Client.languageId != 0) {
                              if(var60.startsWith("wave:")) {
                                 var40 = 1;
                                 var58 = var58.substring("wave:".length());
                              } else if(var60.startsWith("wave2:")) {
                                 var40 = 2;
                                 var58 = var58.substring("wave2:".length());
                              } else if(var60.startsWith("shake:")) {
                                 var40 = 3;
                                 var58 = var58.substring("shake:".length());
                              } else if(var60.startsWith("scroll:")) {
                                 var40 = 4;
                                 var58 = var58.substring("scroll:".length());
                              } else if(var60.startsWith("slide:")) {
                                 var40 = 5;
                                 var58 = var58.substring("slide:".length());
                              }
                           }

                           Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_13);
                           Client.secretPacketBuffer1.putByte(0);
                           var9 = Client.secretPacketBuffer1.offset;
                           Client.secretPacketBuffer1.putByte(var19);
                           Client.secretPacketBuffer1.putByte(var18);
                           Client.secretPacketBuffer1.putByte(var40);
                           PacketBuffer var23 = Client.secretPacketBuffer1;
                           var11 = var23.offset;
                           var13 = var58.length();
                           byte[] var24 = new byte[var13];

                           for(int var15 = 0; var15 < var13; ++var15) {
                              char var16 = var58.charAt(var15);
                              if(var16 > 0 && var16 < 128 || var16 >= 160 && var16 <= 255) {
                                 var24[var15] = (byte)var16;
                              } else if(var16 == 8364) {
                                 var24[var15] = -128;
                              } else if(var16 == 8218) {
                                 var24[var15] = -126;
                              } else if(var16 == 402) {
                                 var24[var15] = -125;
                              } else if(var16 == 8222) {
                                 var24[var15] = -124;
                              } else if(var16 == 8230) {
                                 var24[var15] = -123;
                              } else if(var16 == 8224) {
                                 var24[var15] = -122;
                              } else if(var16 == 8225) {
                                 var24[var15] = -121;
                              } else if(var16 == 710) {
                                 var24[var15] = -120;
                              } else if(var16 == 8240) {
                                 var24[var15] = -119;
                              } else if(var16 == 352) {
                                 var24[var15] = -118;
                              } else if(var16 == 8249) {
                                 var24[var15] = -117;
                              } else if(var16 == 338) {
                                 var24[var15] = -116;
                              } else if(var16 == 381) {
                                 var24[var15] = -114;
                              } else if(var16 == 8216) {
                                 var24[var15] = -111;
                              } else if(var16 == 8217) {
                                 var24[var15] = -110;
                              } else if(var16 == 8220) {
                                 var24[var15] = -109;
                              } else if(var16 == 8221) {
                                 var24[var15] = -108;
                              } else if(var16 == 8226) {
                                 var24[var15] = -107;
                              } else if(var16 == 8211) {
                                 var24[var15] = -106;
                              } else if(var16 == 8212) {
                                 var24[var15] = -105;
                              } else if(var16 == 732) {
                                 var24[var15] = -104;
                              } else if(var16 == 8482) {
                                 var24[var15] = -103;
                              } else if(var16 == 353) {
                                 var24[var15] = -102;
                              } else if(var16 == 8250) {
                                 var24[var15] = -101;
                              } else if(var16 == 339) {
                                 var24[var15] = -100;
                              } else if(var16 == 382) {
                                 var24[var15] = -98;
                              } else if(var16 == 376) {
                                 var24[var15] = -97;
                              } else {
                                 var24[var15] = 63;
                              }
                           }

                           var23.putShortSmart(var24.length);
                           var23.offset += class266.field3656.compress(var24, 0, var24.length, var23.payload, var23.offset);
                           Client.secretPacketBuffer1.putLength(Client.secretPacketBuffer1.offset - var9);
                           var3 = 1;
                        } else if(var0 == 5009) {
                           class169.scriptStringStackSize -= 2;
                           var58 = class82.scriptStringStack[class169.scriptStringStackSize];
                           var5 = class82.scriptStringStack[class169.scriptStringStackSize + 1];
                           Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_101);
                           Client.secretPacketBuffer1.putShort(0);
                           var6 = Client.secretPacketBuffer1.offset;
                           Client.secretPacketBuffer1.putString(var58);
                           PacketBuffer var36 = Client.secretPacketBuffer1;
                           var8 = var36.offset;
                           var10 = var5.length();
                           byte[] var29 = new byte[var10];

                           for(var12 = 0; var12 < var10; ++var12) {
                              var46 = var5.charAt(var12);
                              if((var46 <= 0 || var46 >= 128) && (var46 < 160 || var46 > 255)) {
                                 if(var46 == 8364) {
                                    var29[var12] = -128;
                                 } else if(var46 == 8218) {
                                    var29[var12] = -126;
                                 } else if(var46 == 402) {
                                    var29[var12] = -125;
                                 } else if(var46 == 8222) {
                                    var29[var12] = -124;
                                 } else if(var46 == 8230) {
                                    var29[var12] = -123;
                                 } else if(var46 == 8224) {
                                    var29[var12] = -122;
                                 } else if(var46 == 8225) {
                                    var29[var12] = -121;
                                 } else if(var46 == 710) {
                                    var29[var12] = -120;
                                 } else if(var46 == 8240) {
                                    var29[var12] = -119;
                                 } else if(var46 == 352) {
                                    var29[var12] = -118;
                                 } else if(var46 == 8249) {
                                    var29[var12] = -117;
                                 } else if(var46 == 338) {
                                    var29[var12] = -116;
                                 } else if(var46 == 381) {
                                    var29[var12] = -114;
                                 } else if(var46 == 8216) {
                                    var29[var12] = -111;
                                 } else if(var46 == 8217) {
                                    var29[var12] = -110;
                                 } else if(var46 == 8220) {
                                    var29[var12] = -109;
                                 } else if(var46 == 8221) {
                                    var29[var12] = -108;
                                 } else if(var46 == 8226) {
                                    var29[var12] = -107;
                                 } else if(var46 == 8211) {
                                    var29[var12] = -106;
                                 } else if(var46 == 8212) {
                                    var29[var12] = -105;
                                 } else if(var46 == 732) {
                                    var29[var12] = -104;
                                 } else if(var46 == 8482) {
                                    var29[var12] = -103;
                                 } else if(var46 == 353) {
                                    var29[var12] = -102;
                                 } else if(var46 == 8250) {
                                    var29[var12] = -101;
                                 } else if(var46 == 339) {
                                    var29[var12] = -100;
                                 } else if(var46 == 382) {
                                    var29[var12] = -98;
                                 } else if(var46 == 376) {
                                    var29[var12] = -97;
                                 } else {
                                    var29[var12] = 63;
                                 }
                              } else {
                                 var29[var12] = (byte)var46;
                              }
                           }

                           var36.putShortSmart(var29.length);
                           var36.offset += class266.field3656.compress(var29, 0, var29.length, var36.payload, var36.offset);
                           Client.secretPacketBuffer1.putShortLength(Client.secretPacketBuffer1.offset - var6);
                           var3 = 1;
                        } else if(var0 == 5015) {
                           if(Player.localPlayer != null && Player.localPlayer.name != null) {
                              var58 = Player.localPlayer.name;
                           } else {
                              var58 = "";
                           }

                           class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var58;
                           var3 = 1;
                        } else if(var0 == 5016) {
                           class82.intStack[++Ignore.intStackSize - 1] = Client.field1149;
                           var3 = 1;
                        } else if(var0 == 5017) {
                           var4 = class82.intStack[--Ignore.intStackSize];
                           var44 = class82.intStack;
                           var6 = ++Ignore.intStackSize - 1;
                           ChatLineBuffer var21 = (ChatLineBuffer)class97.chatLineMap.get(Integer.valueOf(var4));
                           if(var21 == null) {
                              var64 = 0;
                           } else {
                              var64 = var21.method1869();
                           }

                           var44[var6] = var64;
                           var3 = 1;
                        } else if(var0 == 5018) {
                           var4 = class82.intStack[--Ignore.intStackSize];
                           var44 = class82.intStack;
                           var6 = ++Ignore.intStackSize - 1;
                           MessageNode var55 = (MessageNode)class97.field1532.get((long)var4);
                           if(var55 == null) {
                              var64 = -1;
                           } else if(var55.previous == class97.field1536.field2492) {
                              var64 = -1;
                           } else {
                              var64 = ((MessageNode)var55.previous).id;
                           }

                           var44[var6] = var64;
                           var3 = 1;
                        } else if(var0 == 5019) {
                           var4 = class82.intStack[--Ignore.intStackSize];
                           class82.intStack[++Ignore.intStackSize - 1] = class44.method665(var4);
                           var3 = 1;
                        } else if(var0 == 5020) {
                           var58 = class82.scriptStringStack[--class169.scriptStringStackSize];
                           if(var58.equalsIgnoreCase("toggleroof")) {
                              Buffer.preferences.hideRoofs = !Buffer.preferences.hideRoofs;
                              class20.method176();
                              if(Buffer.preferences.hideRoofs) {
                                 Client.sendGameMessage(99, "", "Roofs are now all hidden");
                              } else {
                                 Client.sendGameMessage(99, "", "Roofs will only be removed selectively");
                              }
                           }

                           if(var58.equalsIgnoreCase("displayfps")) {
                              Client.displayFps = !Client.displayFps;
                           }

                           if(Client.rights >= 2) {
                              if(var58.equalsIgnoreCase("aabb")) {
                                 if(!class7.field232) {
                                    class7.field232 = true;
                                    class7.field229 = class11.field273;
                                 } else if(class11.field273 == class7.field229) {
                                    class7.field232 = true;
                                    class7.field229 = class11.field276;
                                 } else {
                                    class7.field232 = false;
                                 }
                              }

                              if(var58.equalsIgnoreCase("fpson")) {
                                 Client.displayFps = true;
                              }

                              if(var58.equalsIgnoreCase("fpsoff")) {
                                 Client.displayFps = false;
                              }

                              if(var58.equalsIgnoreCase("gc")) {
                                 System.gc();
                              }

                              if(var58.equalsIgnoreCase("clientdrop")) {
                                 if(Client.field1058 > 0) {
                                    class35.method518();
                                 } else {
                                    WorldMapType2.setGameState(40);
                                    class206.field2565 = ScriptEvent.rssocket;
                                    ScriptEvent.rssocket = null;
                                 }
                              }

                              if(var58.equalsIgnoreCase("errortest") && Client.socketType == 2) {
                                 throw new RuntimeException();
                              }
                           }

                           Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_64);
                           Client.secretPacketBuffer1.putByte(var58.length() + 1);
                           Client.secretPacketBuffer1.putString(var58);
                           var3 = 1;
                        } else if(var0 == 5021) {
                           Client.field1150 = class82.scriptStringStack[--class169.scriptStringStackSize].toLowerCase().trim();
                           var3 = 1;
                        } else if(var0 == 5022) {
                           class82.scriptStringStack[++class169.scriptStringStackSize - 1] = Client.field1150;
                           var3 = 1;
                        } else {
                           var3 = 2;
                        }

                        return var3;
                     } else if(var0 >= 5400) {
                        if(var0 < 5600) {
                           return DynamicObject.method1865(var0, var1, var2);
                        } else if(var0 < 5700) {
                           return class8.method42(var0, var1, var2);
                        } else if(var0 < 6300) {
                           return class44.method668(var0, var1, var2);
                        } else if(var0 < 6600) {
                           return class44.method667(var0, var1, var2);
                        } else if(var0 < 6700) {
                           if(var0 == 6600) {
                              var4 = class27.plane;
                              var19 = (Player.localPlayer.x >> 7) + class149.baseX;
                              var6 = (Player.localPlayer.y >> 7) + class67.baseY;
                              class48.method767().method5175(var4, var19, var6, true);
                              var3 = 1;
                           } else {
                              WorldMapData var20;
                              if(var0 == 6601) {
                                 var4 = class82.intStack[--Ignore.intStackSize];
                                 var5 = "";
                                 var20 = class48.method767().method5184(var4);
                                 if(var20 != null) {
                                    var5 = var20.method323();
                                 }

                                 class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var5;
                                 var3 = 1;
                              } else if(var0 == 6602) {
                                 var4 = class82.intStack[--Ignore.intStackSize];
                                 class48.method767().method5166(var4);
                                 var3 = 1;
                              } else if(var0 == 6603) {
                                 class82.intStack[++Ignore.intStackSize - 1] = class48.method767().method5178();
                                 var3 = 1;
                              } else if(var0 == 6604) {
                                 var4 = class82.intStack[--Ignore.intStackSize];
                                 class48.method767().method5192(var4);
                                 var3 = 1;
                              } else if(var0 == 6605) {
                                 class82.intStack[++Ignore.intStackSize - 1] = class48.method767().method5291()?1:0;
                                 var3 = 1;
                              } else {
                                 Coordinates var49;
                                 if(var0 == 6606) {
                                    var49 = new Coordinates(class82.intStack[--Ignore.intStackSize]);
                                    class48.method767().method5182(var49.worldX, var49.worldY);
                                    var3 = 1;
                                 } else if(var0 == 6607) {
                                    var49 = new Coordinates(class82.intStack[--Ignore.intStackSize]);
                                    class48.method767().method5183(var49.worldX, var49.worldY);
                                    var3 = 1;
                                 } else if(var0 == 6608) {
                                    var49 = new Coordinates(class82.intStack[--Ignore.intStackSize]);
                                    class48.method767().method5179(var49.plane, var49.worldX, var49.worldY);
                                    var3 = 1;
                                 } else if(var0 == 6609) {
                                    var49 = new Coordinates(class82.intStack[--Ignore.intStackSize]);
                                    class48.method767().method5307(var49.plane, var49.worldX, var49.worldY);
                                    var3 = 1;
                                 } else if(var0 == 6610) {
                                    class82.intStack[++Ignore.intStackSize - 1] = class48.method767().method5243();
                                    class82.intStack[++Ignore.intStackSize - 1] = class48.method767().method5212();
                                    var3 = 1;
                                 } else {
                                    WorldMapData var34;
                                    if(var0 == 6611) {
                                       var4 = class82.intStack[--Ignore.intStackSize];
                                       var34 = class48.method767().method5184(var4);
                                       if(var34 == null) {
                                          class82.intStack[++Ignore.intStackSize - 1] = 0;
                                       } else {
                                          class82.intStack[++Ignore.intStackSize - 1] = var34.method306().method3970();
                                       }

                                       var3 = 1;
                                    } else if(var0 == 6612) {
                                       var4 = class82.intStack[--Ignore.intStackSize];
                                       var34 = class48.method767().method5184(var4);
                                       if(var34 == null) {
                                          class82.intStack[++Ignore.intStackSize - 1] = 0;
                                          class82.intStack[++Ignore.intStackSize - 1] = 0;
                                       } else {
                                          class82.intStack[++Ignore.intStackSize - 1] = (var34.method320() - var34.method360() + 1) * 64;
                                          class82.intStack[++Ignore.intStackSize - 1] = (var34.method322() - var34.method373() + 1) * 64;
                                       }

                                       var3 = 1;
                                    } else if(var0 == 6613) {
                                       var4 = class82.intStack[--Ignore.intStackSize];
                                       var34 = class48.method767().method5184(var4);
                                       if(var34 == null) {
                                          class82.intStack[++Ignore.intStackSize - 1] = 0;
                                          class82.intStack[++Ignore.intStackSize - 1] = 0;
                                          class82.intStack[++Ignore.intStackSize - 1] = 0;
                                          class82.intStack[++Ignore.intStackSize - 1] = 0;
                                       } else {
                                          class82.intStack[++Ignore.intStackSize - 1] = var34.method360() * 64;
                                          class82.intStack[++Ignore.intStackSize - 1] = var34.method373() * 64;
                                          class82.intStack[++Ignore.intStackSize - 1] = var34.method320() * 64 + 64 - 1;
                                          class82.intStack[++Ignore.intStackSize - 1] = var34.method322() * 64 + 64 - 1;
                                       }

                                       var3 = 1;
                                    } else if(var0 == 6614) {
                                       var4 = class82.intStack[--Ignore.intStackSize];
                                       var34 = class48.method767().method5184(var4);
                                       if(var34 == null) {
                                          class82.intStack[++Ignore.intStackSize - 1] = -1;
                                       } else {
                                          class82.intStack[++Ignore.intStackSize - 1] = var34.method318();
                                       }

                                       var3 = 1;
                                    } else if(var0 == 6615) {
                                       var49 = class48.method767().method5164();
                                       if(var49 == null) {
                                          class82.intStack[++Ignore.intStackSize - 1] = -1;
                                          class82.intStack[++Ignore.intStackSize - 1] = -1;
                                       } else {
                                          class82.intStack[++Ignore.intStackSize - 1] = var49.worldX;
                                          class82.intStack[++Ignore.intStackSize - 1] = var49.worldY;
                                       }

                                       var3 = 1;
                                    } else if(var0 == 6616) {
                                       class82.intStack[++Ignore.intStackSize - 1] = class48.method767().method5281();
                                       var3 = 1;
                                    } else if(var0 == 6617) {
                                       var49 = new Coordinates(class82.intStack[--Ignore.intStackSize]);
                                       var34 = class48.method767().method5168();
                                       if(var34 == null) {
                                          class82.intStack[++Ignore.intStackSize - 1] = -1;
                                          class82.intStack[++Ignore.intStackSize - 1] = -1;
                                          var3 = 1;
                                       } else {
                                          int[] var52 = var34.method310(var49.plane, var49.worldX, var49.worldY);
                                          if(var52 == null) {
                                             class82.intStack[++Ignore.intStackSize - 1] = -1;
                                             class82.intStack[++Ignore.intStackSize - 1] = -1;
                                          } else {
                                             class82.intStack[++Ignore.intStackSize - 1] = var52[0];
                                             class82.intStack[++Ignore.intStackSize - 1] = var52[1];
                                          }

                                          var3 = 1;
                                       }
                                    } else {
                                       Coordinates var54;
                                       if(var0 == 6618) {
                                          var49 = new Coordinates(class82.intStack[--Ignore.intStackSize]);
                                          var34 = class48.method767().method5168();
                                          if(var34 == null) {
                                             class82.intStack[++Ignore.intStackSize - 1] = -1;
                                             class82.intStack[++Ignore.intStackSize - 1] = -1;
                                             var3 = 1;
                                          } else {
                                             var54 = var34.method311(var49.worldX, var49.worldY);
                                             if(var54 == null) {
                                                class82.intStack[++Ignore.intStackSize - 1] = -1;
                                             } else {
                                                class82.intStack[++Ignore.intStackSize - 1] = var54.method3970();
                                             }

                                             var3 = 1;
                                          }
                                       } else {
                                          Coordinates var38;
                                          if(var0 == 6619) {
                                             Ignore.intStackSize -= 2;
                                             var4 = class82.intStack[Ignore.intStackSize];
                                             var38 = new Coordinates(class82.intStack[Ignore.intStackSize + 1]);
                                             class39.method572(var4, var38, false);
                                             var3 = 1;
                                          } else if(var0 == 6620) {
                                             Ignore.intStackSize -= 2;
                                             var4 = class82.intStack[Ignore.intStackSize];
                                             var38 = new Coordinates(class82.intStack[Ignore.intStackSize + 1]);
                                             class39.method572(var4, var38, true);
                                             var3 = 1;
                                          } else if(var0 == 6621) {
                                             Ignore.intStackSize -= 2;
                                             var4 = class82.intStack[Ignore.intStackSize];
                                             var38 = new Coordinates(class82.intStack[Ignore.intStackSize + 1]);
                                             var20 = class48.method767().method5184(var4);
                                             if(var20 == null) {
                                                class82.intStack[++Ignore.intStackSize - 1] = 0;
                                                var3 = 1;
                                             } else {
                                                class82.intStack[++Ignore.intStackSize - 1] = var20.method308(var38.plane, var38.worldX, var38.worldY)?1:0;
                                                var3 = 1;
                                             }
                                          } else if(var0 == 6622) {
                                             class82.intStack[++Ignore.intStackSize - 1] = class48.method767().method5189();
                                             class82.intStack[++Ignore.intStackSize - 1] = class48.method767().method5190();
                                             var3 = 1;
                                          } else if(var0 == 6623) {
                                             var49 = new Coordinates(class82.intStack[--Ignore.intStackSize]);
                                             var34 = class48.method767().method5162(var49.plane, var49.worldX, var49.worldY);
                                             if(var34 == null) {
                                                class82.intStack[++Ignore.intStackSize - 1] = -1;
                                             } else {
                                                class82.intStack[++Ignore.intStackSize - 1] = var34.method313();
                                             }

                                             var3 = 1;
                                          } else if(var0 == 6624) {
                                             class48.method767().method5191(class82.intStack[--Ignore.intStackSize]);
                                             var3 = 1;
                                          } else if(var0 == 6625) {
                                             class48.method767().method5297();
                                             var3 = 1;
                                          } else if(var0 == 6626) {
                                             class48.method767().method5193(class82.intStack[--Ignore.intStackSize]);
                                             var3 = 1;
                                          } else if(var0 == 6627) {
                                             class48.method767().method5194();
                                             var3 = 1;
                                          } else if(var0 == 6628) {
                                             var39 = class82.intStack[--Ignore.intStackSize] == 1;
                                             class48.method767().method5195(var39);
                                             var3 = 1;
                                          } else if(var0 == 6629) {
                                             var4 = class82.intStack[--Ignore.intStackSize];
                                             class48.method767().method5250(var4);
                                             var3 = 1;
                                          } else if(var0 == 6630) {
                                             var4 = class82.intStack[--Ignore.intStackSize];
                                             class48.method767().method5303(var4);
                                             var3 = 1;
                                          } else if(var0 == 6631) {
                                             class48.method767().method5198();
                                             var3 = 1;
                                          } else if(var0 == 6632) {
                                             var39 = class82.intStack[--Ignore.intStackSize] == 1;
                                             class48.method767().method5199(var39);
                                             var3 = 1;
                                          } else if(var0 == 6633) {
                                             Ignore.intStackSize -= 2;
                                             var4 = class82.intStack[Ignore.intStackSize];
                                             var50 = class82.intStack[Ignore.intStackSize + 1] == 1;
                                             class48.method767().method5322(var4, var50);
                                             var3 = 1;
                                          } else if(var0 == 6634) {
                                             Ignore.intStackSize -= 2;
                                             var4 = class82.intStack[Ignore.intStackSize];
                                             var50 = 1 == class82.intStack[Ignore.intStackSize + 1];
                                             class48.method767().method5201(var4, var50);
                                             var3 = 1;
                                          } else if(var0 == 6635) {
                                             class82.intStack[++Ignore.intStackSize - 1] = class48.method767().method5202()?1:0;
                                             var3 = 1;
                                          } else if(var0 == 6636) {
                                             var4 = class82.intStack[--Ignore.intStackSize];
                                             class82.intStack[++Ignore.intStackSize - 1] = class48.method767().method5203(var4)?1:0;
                                             var3 = 1;
                                          } else if(var0 == 6637) {
                                             var4 = class82.intStack[--Ignore.intStackSize];
                                             class82.intStack[++Ignore.intStackSize - 1] = class48.method767().method5204(var4)?1:0;
                                             var3 = 1;
                                          } else if(var0 == 6638) {
                                             Ignore.intStackSize -= 2;
                                             var4 = class82.intStack[Ignore.intStackSize];
                                             var38 = new Coordinates(class82.intStack[Ignore.intStackSize + 1]);
                                             var54 = class48.method767().method5207(var4, var38);
                                             if(var54 == null) {
                                                class82.intStack[++Ignore.intStackSize - 1] = -1;
                                             } else {
                                                class82.intStack[++Ignore.intStackSize - 1] = var54.method3970();
                                             }

                                             var3 = 1;
                                          } else {
                                             class39 var51;
                                             if(var0 == 6639) {
                                                var51 = class48.method767().method5209();
                                                if(var51 == null) {
                                                   class82.intStack[++Ignore.intStackSize - 1] = -1;
                                                   class82.intStack[++Ignore.intStackSize - 1] = -1;
                                                } else {
                                                   class82.intStack[++Ignore.intStackSize - 1] = var51.field543;
                                                   class82.intStack[++Ignore.intStackSize - 1] = var51.field552.method3970();
                                                }

                                                var3 = 1;
                                             } else if(var0 == 6640) {
                                                var51 = class48.method767().method5257();
                                                if(var51 == null) {
                                                   class82.intStack[++Ignore.intStackSize - 1] = -1;
                                                   class82.intStack[++Ignore.intStackSize - 1] = -1;
                                                } else {
                                                   class82.intStack[++Ignore.intStackSize - 1] = var51.field543;
                                                   class82.intStack[++Ignore.intStackSize - 1] = var51.field552.method3970();
                                                }

                                                var3 = 1;
                                             } else {
                                                Area var41;
                                                if(var0 == 6693) {
                                                   var4 = class82.intStack[--Ignore.intStackSize];
                                                   var41 = Area.field3294[var4];
                                                   if(var41.name == null) {
                                                      class82.scriptStringStack[++class169.scriptStringStackSize - 1] = "";
                                                   } else {
                                                      class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var41.name;
                                                   }

                                                   var3 = 1;
                                                } else if(var0 == 6694) {
                                                   var4 = class82.intStack[--Ignore.intStackSize];
                                                   var41 = Area.field3294[var4];
                                                   class82.intStack[++Ignore.intStackSize - 1] = var41.field3301;
                                                   var3 = 1;
                                                } else if(var0 == 6695) {
                                                   var4 = class82.intStack[--Ignore.intStackSize];
                                                   var41 = Area.field3294[var4];
                                                   if(var41 == null) {
                                                      class82.intStack[++Ignore.intStackSize - 1] = -1;
                                                   } else {
                                                      class82.intStack[++Ignore.intStackSize - 1] = var41.field3313;
                                                   }

                                                   var3 = 1;
                                                } else if(var0 == 6696) {
                                                   var4 = class82.intStack[--Ignore.intStackSize];
                                                   var41 = Area.field3294[var4];
                                                   if(var41 == null) {
                                                      class82.intStack[++Ignore.intStackSize - 1] = -1;
                                                   } else {
                                                      class82.intStack[++Ignore.intStackSize - 1] = var41.spriteId;
                                                   }

                                                   var3 = 1;
                                                } else if(var0 == 6697) {
                                                   class82.intStack[++Ignore.intStackSize - 1] = Script.field1543.field613;
                                                   var3 = 1;
                                                } else if(var0 == 6698) {
                                                   class82.intStack[++Ignore.intStackSize - 1] = Script.field1543.field615.method3970();
                                                   var3 = 1;
                                                } else if(var0 == 6699) {
                                                   class82.intStack[++Ignore.intStackSize - 1] = Script.field1543.field614.method3970();
                                                   var3 = 1;
                                                } else {
                                                   var3 = 2;
                                                }
                                             }
                                          }
                                       }
                                    }
                                 }
                              }
                           }

                           return var3;
                        } else {
                           return 2;
                        }
                     } else {
                        if(var0 == 5306) {
                           int[] var17 = class82.intStack;
                           var19 = ++Ignore.intStackSize - 1;
                           var6 = Client.isResized?2:1;
                           var17[var19] = var6;
                           var3 = 1;
                        } else if(var0 == 5307) {
                           var4 = class82.intStack[--Ignore.intStackSize];
                           if(var4 == 1 || var4 == 2) {
                              Client.field1104 = 0L;
                              if(var4 >= 2) {
                                 Client.isResized = true;
                              } else {
                                 Client.isResized = false;
                              }

                              if(class41.method595() == 1) {
                                 class87.clientInstance.method888(765, 503);
                              } else {
                                 class87.clientInstance.method888(7680, 2160);
                              }

                              if(Client.gameState >= 25) {
                                 class17.method144();
                              }
                           }

                           var3 = 1;
                        } else if(var0 == 5308) {
                           class82.intStack[++Ignore.intStackSize - 1] = Buffer.preferences.screenType;
                           var3 = 1;
                        } else if(var0 == 5309) {
                           var4 = class82.intStack[--Ignore.intStackSize];
                           if(var4 == 1 || var4 == 2) {
                              Buffer.preferences.screenType = var4;
                              class20.method176();
                           }

                           var3 = 1;
                        } else {
                           var3 = 2;
                        }

                        return var3;
                     }
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lii;Lii;I)V",
      garbageValue = "520373158"
   )
   public static void method271(IndexDataBase var0, IndexDataBase var1) {
      CombatInfo2.field3370 = var0;
      CombatInfo2.field3367 = var1;
   }
}
