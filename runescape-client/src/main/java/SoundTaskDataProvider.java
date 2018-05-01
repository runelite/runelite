import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("bq")
@Implements("SoundTaskDataProvider")
public class SoundTaskDataProvider implements class101 {
   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   @Export("indexMaps")
   static IndexData indexMaps;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)Ldk;",
      garbageValue = "-67"
   )
   public AbstractSoundSystem vmethod2215() {
      return new SourceDataSoundSystem();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lgl;I)V",
      garbageValue = "-2092651346"
   )
   @Export("encodeClassVerifier")
   public static void encodeClassVerifier(PacketBuffer var0) {
      ClassInfo var1 = (ClassInfo)class326.classInfos.last();
      if(var1 != null) {
         int var2 = var0.offset;
         var0.putInt(var1.field3956);

         for(int var3 = 0; var3 < var1.count; ++var3) {
            if(var1.errorIdentifiers[var3] != 0) {
               var0.putByte(var1.errorIdentifiers[var3]);
            } else {
               try {
                  int var4 = var1.type[var3];
                  Field var5;
                  int var6;
                  if(var4 == 0) {
                     var5 = var1.fields[var3];
                     var6 = Reflection.getInt(var5, (Object)null);
                     var0.putByte(0);
                     var0.putInt(var6);
                  } else if(var4 == 1) {
                     var5 = var1.fields[var3];
                     Reflection.setInt(var5, (Object)null, var1.field3955[var3]);
                     var0.putByte(0);
                  } else if(var4 == 2) {
                     var5 = var1.fields[var3];
                     var6 = var5.getModifiers();
                     var0.putByte(0);
                     var0.putInt(var6);
                  }

                  Method var25;
                  if(var4 != 3) {
                     if(var4 == 4) {
                        var25 = var1.methods[var3];
                        var6 = var25.getModifiers();
                        var0.putByte(0);
                        var0.putInt(var6);
                     }
                  } else {
                     var25 = var1.methods[var3];
                     byte[][] var10 = var1.args[var3];
                     Object[] var7 = new Object[var10.length];

                     for(int var8 = 0; var8 < var10.length; ++var8) {
                        ObjectInputStream var9 = new ObjectInputStream(new ByteArrayInputStream(var10[var8]));
                        var7[var8] = var9.readObject();
                     }

                     Object var11 = Reflection.invoke(var25, (Object)null, var7);
                     if(var11 == null) {
                        var0.putByte(0);
                     } else if(var11 instanceof Number) {
                        var0.putByte(1);
                        var0.putLong(((Number)var11).longValue());
                     } else if(var11 instanceof String) {
                        var0.putByte(2);
                        var0.putString((String)var11);
                     } else {
                        var0.putByte(4);
                     }
                  }
               } catch (ClassNotFoundException var13) {
                  var0.putByte(-10);
               } catch (InvalidClassException var14) {
                  var0.putByte(-11);
               } catch (StreamCorruptedException var15) {
                  var0.putByte(-12);
               } catch (OptionalDataException var16) {
                  var0.putByte(-13);
               } catch (IllegalAccessException var17) {
                  var0.putByte(-14);
               } catch (IllegalArgumentException var18) {
                  var0.putByte(-15);
               } catch (InvocationTargetException var19) {
                  var0.putByte(-16);
               } catch (SecurityException var20) {
                  var0.putByte(-17);
               } catch (IOException var21) {
                  var0.putByte(-18);
               } catch (NullPointerException var22) {
                  var0.putByte(-19);
               } catch (Exception var23) {
                  var0.putByte(-20);
               } catch (Throwable var24) {
                  var0.putByte(-21);
               }
            }
         }

         var0.putCrc(var2);
         var1.unlink();
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BI)Lcr;",
      garbageValue = "574239205"
   )
   @Export("newScript")
   static Script newScript(byte[] var0) {
      Script var1 = new Script();
      Buffer var2 = new Buffer(var0);
      var2.offset = var2.payload.length - 2;
      int var3 = var2.readUnsignedShort();
      int var4 = var2.payload.length - 2 - var3 - 12;
      var2.offset = var4;
      int var5 = var2.readInt();
      var1.localIntCount = var2.readUnsignedShort();
      var1.localStringCount = var2.readUnsignedShort();
      var1.intStackCount = var2.readUnsignedShort();
      var1.stringStackCount = var2.readUnsignedShort();
      int var6 = var2.readUnsignedByte();
      int var7;
      int var8;
      if(var6 > 0) {
         var1.switches = var1.method2099(var6);

         for(var7 = 0; var7 < var6; ++var7) {
            var8 = var2.readUnsignedShort();
            IterableHashTable var9 = new IterableHashTable(var8 > 0?CacheFile.nextPowerOfTwo(var8):1);
            var1.switches[var7] = var9;

            while(var8-- > 0) {
               int var10 = var2.readInt();
               int var11 = var2.readInt();
               var9.put(new IntegerNode(var11), (long)var10);
            }
         }
      }

      var2.offset = 0;
      var2.getNullString();
      var1.instructions = new int[var5];
      var1.intOperands = new int[var5];
      var1.stringOperands = new String[var5];

      for(var7 = 0; var2.offset < var4; var1.instructions[var7++] = var8) {
         var8 = var2.readUnsignedShort();
         if(var8 == 3) {
            var1.stringOperands[var7] = var2.readString();
         } else if(var8 < 100 && var8 != 21 && var8 != 38 && var8 != 39) {
            var1.intOperands[var7] = var2.readInt();
         } else {
            var1.intOperands[var7] = var2.readUnsignedByte();
         }
      }

      return var1;
   }

   @ObfuscatedName("fw")
   @ObfuscatedSignature(
      signature = "(Liz;III)V",
      garbageValue = "1003596516"
   )
   static final void method828(Widget var0, int var1, int var2) {
      if(Client.field1082 == 0 || Client.field1082 == 3) {
         if(MouseInput.mouseLastButton == 1 || !Occluder.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) {
            class236 var3 = var0.method4542(true);
            if(var3 == null) {
               return;
            }

            int var4 = MouseInput.mouseLastPressedX - var1;
            int var5 = MouseInput.mouseLastPressedY - var2;
            if(var3.method4466(var4, var5)) {
               var4 -= var3.field2780 / 2;
               var5 -= var3.field2782 / 2;
               int var6 = Client.mapAngle & 2047;
               int var7 = Graphics3D.SINE[var6];
               int var8 = Graphics3D.COSINE[var6];
               int var9 = var8 * var4 + var7 * var5 >> 11;
               int var10 = var5 * var8 - var7 * var4 >> 11;
               int var11 = var9 + class265.localPlayer.x >> 7;
               int var12 = class265.localPlayer.y - var10 >> 7;
               PacketNode var13 = AbstractSoundSystem.method2350(ClientPacket.field2453, Client.field911.field1460);
               var13.packetBuffer.putByte(18);
               var13.packetBuffer.putShort(var12 + MapIconReference.baseY);
               var13.packetBuffer.method3634(var11 + ClientPacket.baseX);
               var13.packetBuffer.method3624(KeyFocusListener.keyPressed[82]?(KeyFocusListener.keyPressed[81]?2:1):0);
               var13.packetBuffer.putByte(var4);
               var13.packetBuffer.putByte(var5);
               var13.packetBuffer.putShort(Client.mapAngle);
               var13.packetBuffer.putByte(57);
               var13.packetBuffer.putByte(0);
               var13.packetBuffer.putByte(0);
               var13.packetBuffer.putByte(89);
               var13.packetBuffer.putShort(class265.localPlayer.x);
               var13.packetBuffer.putShort(class265.localPlayer.y);
               var13.packetBuffer.putByte(63);
               Client.field911.method2135(var13);
               Client.destinationX = var11;
               Client.destinationY = var12;
            }
         }

      }
   }

   @ObfuscatedName("hn")
   @ObfuscatedSignature(
      signature = "(Lgd;I)V",
      garbageValue = "2058990038"
   )
   static final void method831(class183 var0) {
      PacketBuffer var1 = Client.field911.packetBuffer;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if(class183.field2484 == var0) {
         var2 = var1.method3636();
         var3 = var1.method3626();
         var4 = var1.readUnsignedByte();
         var5 = (var4 >> 4 & 7) + ServerPacket.field2363;
         var6 = (var4 & 7) + VarCString.field3477;
         var7 = var1.readUnsignedShort();
         if(var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
            var5 = var5 * 128 + 64;
            var6 = var6 * 128 + 64;
            GraphicsObject var38 = new GraphicsObject(var7, ScriptVarType.plane, var5, var6, GrandExchangeEvent.getTileHeight(var5, var6, ScriptVarType.plane) - var3, var2, Client.gameCycle);
            Client.graphicsObjectDeque.addFront(var38);
         }

      } else {
         int var31;
         if(class183.field2475 == var0) {
            var2 = var1.readUnsignedShortOb1();
            var3 = (var2 >> 4 & 7) + ServerPacket.field2363;
            var4 = (var2 & 7) + VarCString.field3477;
            var5 = var1.readUnsignedByte();
            var6 = var5 >> 2;
            var7 = var5 & 3;
            var31 = Client.field1109[var6];
            if(var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
               PacketBuffer.method3894(ScriptVarType.plane, var3, var4, var31, -1, var6, var7, 0, -1);
            }

         } else {
            int var9;
            int var10;
            if(class183.field2482 == var0) {
               var2 = var1.method3626();
               var3 = var1.method3626();
               var4 = var3 >> 4 & 15;
               var5 = var3 & 7;
               var6 = var1.readUnsignedByte();
               var7 = (var6 >> 4 & 7) + ServerPacket.field2363;
               var31 = (var6 & 7) + VarCString.field3477;
               var9 = var1.method3636();
               if(var7 >= 0 && var31 >= 0 && var7 < 104 && var31 < 104) {
                  var10 = var4 + 1;
                  if(class265.localPlayer.pathX[0] >= var7 - var10 && class265.localPlayer.pathX[0] <= var7 + var10 && class265.localPlayer.pathY[0] >= var31 - var10 && class265.localPlayer.pathY[0] <= var10 + var31 && Client.field1018 != 0 && var5 > 0 && Client.queuedSoundEffectCount < 50) {
                     Client.queuedSoundEffectIDs[Client.queuedSoundEffectCount] = var9;
                     Client.unknownSoundValues1[Client.queuedSoundEffectCount] = var5;
                     Client.unknownSoundValues2[Client.queuedSoundEffectCount] = var2;
                     Client.audioEffects[Client.queuedSoundEffectCount] = null;
                     Client.soundLocations[Client.queuedSoundEffectCount] = var4 + (var31 << 8) + (var7 << 16);
                     ++Client.queuedSoundEffectCount;
                  }
               }
            }

            int var11;
            int var12;
            int var13;
            int var14;
            byte var40;
            if(class183.field2480 == var0) {
               byte var37 = var1.method3586();
               var3 = var1.method3635();
               var4 = var1.readUnsignedShortOb1();
               var5 = var4 >> 2;
               var6 = var4 & 3;
               var7 = Client.field1109[var5];
               var31 = var1.method3627();
               byte var39 = var1.method3586();
               var40 = var1.method3630();
               var11 = var1.readUnsignedShortOb1();
               var12 = (var11 >> 4 & 7) + ServerPacket.field2363;
               var13 = (var11 & 7) + VarCString.field3477;
               var14 = var1.method3627();
               int var15 = var1.method3635();
               byte var16 = var1.method3586();
               Player var17;
               if(var31 == Client.localInteractingIndex) {
                  var17 = class265.localPlayer;
               } else {
                  var17 = Client.cachedPlayers[var31];
               }

               if(var17 != null) {
                  ObjectComposition var18 = class80.getObjectDefinition(var14);
                  int var19;
                  int var20;
                  if(var6 != 1 && var6 != 3) {
                     var19 = var18.width;
                     var20 = var18.length;
                  } else {
                     var19 = var18.length;
                     var20 = var18.width;
                  }

                  int var21 = var12 + (var19 >> 1);
                  int var22 = var12 + (var19 + 1 >> 1);
                  int var23 = var13 + (var20 >> 1);
                  int var24 = var13 + (var20 + 1 >> 1);
                  int[][] var25 = class62.tileHeights[ScriptVarType.plane];
                  int var26 = var25[var22][var24] + var25[var22][var23] + var25[var21][var23] + var25[var21][var24] >> 2;
                  int var27 = (var12 << 7) + (var19 << 6);
                  int var28 = (var13 << 7) + (var20 << 6);
                  Model var29 = var18.method5083(var5, var6, var25, var27, var26, var28);
                  if(var29 != null) {
                     PacketBuffer.method3894(ScriptVarType.plane, var12, var13, var7, -1, 0, 0, var3 + 1, var15 + 1);
                     var17.animationCycleStart = var3 + Client.gameCycle;
                     var17.animationCycleEnd = var15 + Client.gameCycle;
                     var17.model = var29;
                     var17.field825 = var12 * 128 + var19 * 64;
                     var17.field837 = var13 * 128 + var20 * 64;
                     var17.field826 = var26;
                     byte var30;
                     if(var39 > var37) {
                        var30 = var39;
                        var39 = var37;
                        var37 = var30;
                     }

                     if(var40 > var16) {
                        var30 = var40;
                        var40 = var16;
                        var16 = var30;
                     }

                     var17.field829 = var12 + var39;
                     var17.field818 = var37 + var12;
                     var17.field830 = var40 + var13;
                     var17.field836 = var16 + var13;
                  }
               }
            }

            if(class183.field2483 == var0) {
               var2 = var1.method3628();
               var3 = (var2 >> 4 & 7) + ServerPacket.field2363;
               var4 = (var2 & 7) + VarCString.field3477;
               var5 = var1.method3636();
               var6 = var1.method3628();
               var7 = var6 >> 2;
               var31 = var6 & 3;
               var9 = Client.field1109[var7];
               if(var3 >= 0 && var4 >= 0 && var3 < 103 && var4 < 103) {
                  if(var9 == 0) {
                     WallObject var32 = GameSocket.region.method2969(ScriptVarType.plane, var3, var4);
                     if(var32 != null) {
                        var11 = var32.hash >> 14 & 32767;
                        if(var7 == 2) {
                           var32.renderable1 = new DynamicObject(var11, 2, var31 + 4, ScriptVarType.plane, var3, var4, var5, false, var32.renderable1);
                           var32.renderable2 = new DynamicObject(var11, 2, var31 + 1 & 3, ScriptVarType.plane, var3, var4, var5, false, var32.renderable2);
                        } else {
                           var32.renderable1 = new DynamicObject(var11, var7, var31, ScriptVarType.plane, var3, var4, var5, false, var32.renderable1);
                        }
                     }
                  }

                  if(var9 == 1) {
                     DecorativeObject var42 = GameSocket.region.method2970(ScriptVarType.plane, var3, var4);
                     if(var42 != null) {
                        var11 = var42.hash >> 14 & 32767;
                        if(var7 != 4 && var7 != 5) {
                           if(var7 == 6) {
                              var42.renderable1 = new DynamicObject(var11, 4, var31 + 4, ScriptVarType.plane, var3, var4, var5, false, var42.renderable1);
                           } else if(var7 == 7) {
                              var42.renderable1 = new DynamicObject(var11, 4, (var31 + 2 & 3) + 4, ScriptVarType.plane, var3, var4, var5, false, var42.renderable1);
                           } else if(var7 == 8) {
                              var42.renderable1 = new DynamicObject(var11, 4, var31 + 4, ScriptVarType.plane, var3, var4, var5, false, var42.renderable1);
                              var42.renderable2 = new DynamicObject(var11, 4, (var31 + 2 & 3) + 4, ScriptVarType.plane, var3, var4, var5, false, var42.renderable2);
                           }
                        } else {
                           var42.renderable1 = new DynamicObject(var11, 4, var31, ScriptVarType.plane, var3, var4, var5, false, var42.renderable1);
                        }
                     }
                  }

                  if(var9 == 2) {
                     GameObject var43 = GameSocket.region.method2971(ScriptVarType.plane, var3, var4);
                     if(var7 == 11) {
                        var7 = 10;
                     }

                     if(var43 != null) {
                        var43.renderable = new DynamicObject(var43.hash >> 14 & 32767, var7, var31, ScriptVarType.plane, var3, var4, var5, false, var43.renderable);
                     }
                  }

                  if(var9 == 3) {
                     GroundObject var44 = GameSocket.region.getFloorDecoration(ScriptVarType.plane, var3, var4);
                     if(var44 != null) {
                        var44.renderable = new DynamicObject(var44.hash >> 14 & 32767, 22, var31, ScriptVarType.plane, var3, var4, var5, false, var44.renderable);
                     }
                  }
               }

            } else if(class183.field2478 == var0) {
               var2 = var1.readUnsignedShort();
               var3 = var1.readUnsignedShortOb1();
               var4 = (var3 >> 4 & 7) + ServerPacket.field2363;
               var5 = (var3 & 7) + VarCString.field3477;
               var6 = var1.method3626();
               var7 = var6 >> 2;
               var31 = var6 & 3;
               var9 = Client.field1109[var7];
               if(var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104) {
                  PacketBuffer.method3894(ScriptVarType.plane, var4, var5, var9, var2, var7, var31, 0, -1);
               }

            } else if(class183.field2477 == var0) {
               var2 = var1.method3635();
               var3 = var1.method3627();
               var4 = var1.method3635();
               var5 = var1.method3628();
               var6 = (var5 >> 4 & 7) + ServerPacket.field2363;
               var7 = (var5 & 7) + VarCString.field3477;
               if(var6 >= 0 && var7 >= 0 && var6 < 104 && var7 < 104) {
                  Deque var8 = Client.groundItemDeque[ScriptVarType.plane][var6][var7];
                  if(var8 != null) {
                     for(Item var33 = (Item)var8.getFront(); var33 != null; var33 = (Item)var8.getNext()) {
                        if((var2 & 32767) == var33.id && var3 == var33.quantity) {
                           var33.quantity = var4;
                           break;
                        }
                     }

                     class177.groundItemSpawned(var6, var7);
                  }
               }

            } else if(class183.field2476 == var0) {
               var2 = var1.readUnsignedShortOb1();
               var3 = var1.method3635();
               var4 = var1.method3638();
               var5 = var1.readUnsignedByte() * 4;
               var6 = var1.method3628() * 4;
               var7 = var1.readUnsignedShort();
               var31 = var1.readUnsignedShortOb1();
               var9 = var1.method3635();
               var40 = var1.method3586();
               byte var41 = var1.method3631();
               var12 = var1.method3628();
               var13 = (var12 >> 4 & 7) + ServerPacket.field2363;
               var14 = (var12 & 7) + VarCString.field3477;
               var10 = var40 + var13;
               var11 = var41 + var14;
               if(var13 >= 0 && var14 >= 0 && var13 < 104 && var14 < 104 && var10 >= 0 && var11 >= 0 && var10 < 104 && var11 < 104 && var7 != 65535) {
                  var13 = var13 * 128 + 64;
                  var14 = var14 * 128 + 64;
                  var10 = var10 * 128 + 64;
                  var11 = var11 * 128 + 64;
                  Projectile var34 = new Projectile(var7, ScriptVarType.plane, var13, var14, GrandExchangeEvent.getTileHeight(var13, var14, ScriptVarType.plane) - var5, var9 + Client.gameCycle, var3 + Client.gameCycle, var2, var31, var4, var6);
                  var34.moveProjectile(var10, var11, GrandExchangeEvent.getTileHeight(var10, var11, ScriptVarType.plane) - var6, var9 + Client.gameCycle);
                  Client.projectiles.addFront(var34);
               }

            } else {
               Item var36;
               if(class183.field2474 != var0) {
                  if(class183.field2485 == var0) {
                     var2 = var1.method3636();
                     var3 = var1.method3636();
                     var4 = var1.method3626();
                     var5 = (var4 >> 4 & 7) + ServerPacket.field2363;
                     var6 = (var4 & 7) + VarCString.field3477;
                     if(var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
                        var36 = new Item();
                        var36.id = var2;
                        var36.quantity = var3;
                        if(Client.groundItemDeque[ScriptVarType.plane][var5][var6] == null) {
                           Client.groundItemDeque[ScriptVarType.plane][var5][var6] = new Deque();
                        }

                        Client.groundItemDeque[ScriptVarType.plane][var5][var6].addFront(var36);
                        class177.groundItemSpawned(var5, var6);
                     }

                  }
               } else {
                  var2 = var1.readUnsignedByte();
                  var3 = (var2 >> 4 & 7) + ServerPacket.field2363;
                  var4 = (var2 & 7) + VarCString.field3477;
                  var5 = var1.readUnsignedShort();
                  if(var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
                     Deque var35 = Client.groundItemDeque[ScriptVarType.plane][var3][var4];
                     if(var35 != null) {
                        for(var36 = (Item)var35.getFront(); var36 != null; var36 = (Item)var35.getNext()) {
                           if((var5 & 32767) == var36.id) {
                              var36.unlink();
                              break;
                           }
                        }

                        if(var35.getFront() == null) {
                           Client.groundItemDeque[ScriptVarType.plane][var3][var4] = null;
                        }

                        class177.groundItemSpawned(var3, var4);
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("ja")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1064641646"
   )
   static boolean method830() {
      return Client.field998;
   }
}
