import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Opcodes;

@ObfuscatedName("an")
public class class44 extends WorldMapData {
   @ObfuscatedName("fy")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   @Export("compass")
   static SpritePixels compass;
   @ObfuscatedName("v")
   List field590;
   @ObfuscatedName("t")
   HashSet field589;
   @ObfuscatedName("y")
   HashSet field594;

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "(Lfp;ZS)V",
      garbageValue = "1423"
   )
   void method657(Buffer var1, boolean var2) {
      this.field590 = new LinkedList();
      int var3 = var1.readUnsignedShort();

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = var1.method3262();
         Coordinates var6 = new Coordinates(var1.readInt());
         boolean var7 = var1.readUnsignedByte() == 1;
         if(var2 || !var7) {
            this.field590.add(new class25(var5, var6));
         }
      }

   }

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "(Lfp;Lfp;Lfp;IZS)V",
      garbageValue = "23020"
   )
   void method656(Buffer var1, Buffer var2, Buffer var3, int var4, boolean var5) {
      this.loadMapData(var1, var4);
      int var6 = var3.readUnsignedShort();
      this.field589 = new HashSet(var6);

      int var7;
      for(var7 = 0; var7 < var6; ++var7) {
         class22 var8 = new class22();

         try {
            var8.method188(var2, var3);
         } catch (IllegalStateException var13) {
            continue;
         }

         this.field589.add(var8);
      }

      var7 = var3.readUnsignedShort();
      this.field594 = new HashSet(var7);

      for(int var11 = 0; var11 < var7; ++var11) {
         class45 var9 = new class45();

         try {
            var9.method671(var2, var3);
         } catch (IllegalStateException var12) {
            continue;
         }

         this.field594.add(var9);
      }

      this.method657(var2, var5);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1858237147"
   )
   static String method659() {
      return Buffer.preferences.field1320?class263.method4703(class91.username):class91.username;
   }

   @ObfuscatedName("fv")
   @ObfuscatedSignature(
      signature = "(Lhx;III)V",
      garbageValue = "-26506794"
   )
   static final void method666(Widget var0, int var1, int var2) {
      if(Client.field1079 == 0 || Client.field1079 == 3) {
         if(MouseInput.field754 == 1 || !Client.field951 && MouseInput.field754 == 4) {
            class211 var3 = var0.method4031(true);
            if(var3 == null) {
               return;
            }

            int var4 = MouseInput.field753 - var1;
            int var5 = MouseInput.field739 - var2;
            if(var3.method3963(var4, var5)) {
               var4 -= var3.field2600 / 2;
               var5 -= var3.field2599 / 2;
               int var6 = Client.mapAngle & 2047;
               int var7 = Graphics3D.SINE[var6];
               int var8 = Graphics3D.COSINE[var6];
               int var9 = var4 * var8 + var7 * var5 >> 11;
               int var10 = var5 * var8 - var4 * var7 >> 11;
               int var11 = var9 + Player.localPlayer.x >> 7;
               int var12 = Player.localPlayer.y - var10 >> 7;
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_128);
               Client.secretPacketBuffer1.putByte(18);
               Client.secretPacketBuffer1.putShortLE(var11 + class149.baseX);
               Client.secretPacketBuffer1.putShort(var12 + class67.baseY);
               Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field651[82]?(KeyFocusListener.field651[81]?2:1):0);
               Client.secretPacketBuffer1.putByte(var4);
               Client.secretPacketBuffer1.putByte(var5);
               Client.secretPacketBuffer1.putShort(Client.mapAngle);
               Client.secretPacketBuffer1.putByte(57);
               Client.secretPacketBuffer1.putByte(0);
               Client.secretPacketBuffer1.putByte(0);
               Client.secretPacketBuffer1.putByte(89);
               Client.secretPacketBuffer1.putShort(Player.localPlayer.x);
               Client.secretPacketBuffer1.putShort(Player.localPlayer.y);
               Client.secretPacketBuffer1.putByte(63);
               Client.destinationX = var11;
               Client.destinationY = var12;
            }
         }

      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILck;ZB)I",
      garbageValue = "119"
   )
   static int method668(int var0, Script var1, boolean var2) {
      if(var0 == 6200) {
         Ignore.intStackSize -= 2;
         Client.field1184 = (short)class82.intStack[Ignore.intStackSize];
         if(Client.field1184 <= 0) {
            Client.field1184 = 256;
         }

         Client.field1097 = (short)class82.intStack[Ignore.intStackSize + 1];
         if(Client.field1097 <= 0) {
            Client.field1097 = 205;
         }

         return 1;
      } else if(var0 == 6201) {
         Ignore.intStackSize -= 2;
         Client.field1186 = (short)class82.intStack[Ignore.intStackSize];
         if(Client.field1186 <= 0) {
            Client.field1186 = 256;
         }

         Client.field1052 = (short)class82.intStack[Ignore.intStackSize + 1];
         if(Client.field1052 <= 0) {
            Client.field1052 = 320;
         }

         return 1;
      } else if(var0 == 6202) {
         Ignore.intStackSize -= 4;
         Client.field1188 = (short)class82.intStack[Ignore.intStackSize];
         if(Client.field1188 <= 0) {
            Client.field1188 = 1;
         }

         Client.field1189 = (short)class82.intStack[Ignore.intStackSize + 1];
         if(Client.field1189 <= 0) {
            Client.field1189 = 32767;
         } else if(Client.field1189 < Client.field1188) {
            Client.field1189 = Client.field1188;
         }

         Client.field1190 = (short)class82.intStack[Ignore.intStackSize + 2];
         if(Client.field1190 <= 0) {
            Client.field1190 = 1;
         }

         Client.field1191 = (short)class82.intStack[Ignore.intStackSize + 3];
         if(Client.field1191 <= 0) {
            Client.field1191 = 32767;
         } else if(Client.field1191 < Client.field1190) {
            Client.field1191 = Client.field1190;
         }

         return 1;
      } else if(var0 == 6203) {
         if(Client.field1103 != null) {
            class33.method383(0, 0, Client.field1103.width, Client.field1103.height, false);
            class82.intStack[++Ignore.intStackSize - 1] = Client.viewportHeight;
            class82.intStack[++Ignore.intStackSize - 1] = Client.viewportWidth;
         } else {
            class82.intStack[++Ignore.intStackSize - 1] = -1;
            class82.intStack[++Ignore.intStackSize - 1] = -1;
         }

         return 1;
      } else if(var0 == 6204) {
         class82.intStack[++Ignore.intStackSize - 1] = Client.field1186;
         class82.intStack[++Ignore.intStackSize - 1] = Client.field1052;
         return 1;
      } else if(var0 == 6205) {
         class82.intStack[++Ignore.intStackSize - 1] = Client.field1184;
         class82.intStack[++Ignore.intStackSize - 1] = Client.field1097;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(ILck;ZI)I",
      garbageValue = "-1586801281"
   )
   static int method667(int var0, Script var1, boolean var2) {
      if(var0 == 6500) {
         class82.intStack[++Ignore.intStackSize - 1] = Actor.loadWorlds()?1:0;
         return 1;
      } else {
         World var3;
         if(var0 == 6501) {
            World.field1301 = 0;
            var3 = class164.method3150();
            if(var3 != null) {
               class82.intStack[++Ignore.intStackSize - 1] = var3.id;
               class82.intStack[++Ignore.intStackSize - 1] = var3.mask;
               class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var3.activity;
               class82.intStack[++Ignore.intStackSize - 1] = var3.location;
               class82.intStack[++Ignore.intStackSize - 1] = var3.playerCount;
               class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var3.address;
            } else {
               class82.intStack[++Ignore.intStackSize - 1] = -1;
               class82.intStack[++Ignore.intStackSize - 1] = 0;
               class82.scriptStringStack[++class169.scriptStringStackSize - 1] = "";
               class82.intStack[++Ignore.intStackSize - 1] = 0;
               class82.intStack[++Ignore.intStackSize - 1] = 0;
               class82.scriptStringStack[++class169.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 6502) {
            if(World.field1301 < World.worldCount) {
               var3 = World.worldList[++World.field1301 - 1];
            } else {
               var3 = null;
            }

            if(var3 != null) {
               class82.intStack[++Ignore.intStackSize - 1] = var3.id;
               class82.intStack[++Ignore.intStackSize - 1] = var3.mask;
               class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var3.activity;
               class82.intStack[++Ignore.intStackSize - 1] = var3.location;
               class82.intStack[++Ignore.intStackSize - 1] = var3.playerCount;
               class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var3.address;
            } else {
               class82.intStack[++Ignore.intStackSize - 1] = -1;
               class82.intStack[++Ignore.intStackSize - 1] = 0;
               class82.scriptStringStack[++class169.scriptStringStackSize - 1] = "";
               class82.intStack[++Ignore.intStackSize - 1] = 0;
               class82.intStack[++Ignore.intStackSize - 1] = 0;
               class82.scriptStringStack[++class169.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else {
            World var4;
            int var5;
            int var11;
            if(var0 == 6506) {
               var11 = class82.intStack[--Ignore.intStackSize];
               var4 = null;

               for(var5 = 0; var5 < World.worldCount; ++var5) {
                  if(var11 == World.worldList[var5].id) {
                     var4 = World.worldList[var5];
                     break;
                  }
               }

               if(var4 != null) {
                  class82.intStack[++Ignore.intStackSize - 1] = var4.id;
                  class82.intStack[++Ignore.intStackSize - 1] = var4.mask;
                  class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var4.activity;
                  class82.intStack[++Ignore.intStackSize - 1] = var4.location;
                  class82.intStack[++Ignore.intStackSize - 1] = var4.playerCount;
                  class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var4.address;
               } else {
                  class82.intStack[++Ignore.intStackSize - 1] = -1;
                  class82.intStack[++Ignore.intStackSize - 1] = 0;
                  class82.scriptStringStack[++class169.scriptStringStackSize - 1] = "";
                  class82.intStack[++Ignore.intStackSize - 1] = 0;
                  class82.intStack[++Ignore.intStackSize - 1] = 0;
                  class82.scriptStringStack[++class169.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 6507) {
               Ignore.intStackSize -= 4;
               var11 = class82.intStack[Ignore.intStackSize];
               boolean var15 = class82.intStack[Ignore.intStackSize + 1] == 1;
               var5 = class82.intStack[Ignore.intStackSize + 2];
               boolean var6 = class82.intStack[Ignore.intStackSize + 3] == 1;
               class46.method735(var11, var15, var5, var6);
               return 1;
            } else if(var0 != 6511) {
               if(var0 == 6512) {
                  Client.field1047 = class82.intStack[--Ignore.intStackSize] == 1;
                  return 1;
               } else {
                  int var12;
                  class252 var13;
                  if(var0 == 6513) {
                     Ignore.intStackSize -= 2;
                     var11 = class82.intStack[Ignore.intStackSize];
                     var12 = class82.intStack[Ignore.intStackSize + 1];
                     var13 = class48.method774(var12);
                     if(var13.method4444()) {
                        class82.scriptStringStack[++class169.scriptStringStackSize - 1] = class171.getNpcDefinition(var11).method4624(var12, var13.field3392);
                     } else {
                        class82.intStack[++Ignore.intStackSize - 1] = class171.getNpcDefinition(var11).method4639(var12, var13.field3390);
                     }

                     return 1;
                  } else if(var0 == 6514) {
                     Ignore.intStackSize -= 2;
                     var11 = class82.intStack[Ignore.intStackSize];
                     var12 = class82.intStack[Ignore.intStackSize + 1];
                     var13 = class48.method774(var12);
                     if(var13.method4444()) {
                        class82.scriptStringStack[++class169.scriptStringStackSize - 1] = GameObject.getObjectDefinition(var11).method4528(var12, var13.field3392);
                     } else {
                        class82.intStack[++Ignore.intStackSize - 1] = GameObject.getObjectDefinition(var11).method4524(var12, var13.field3390);
                     }

                     return 1;
                  } else if(var0 == 6515) {
                     Ignore.intStackSize -= 2;
                     var11 = class82.intStack[Ignore.intStackSize];
                     var12 = class82.intStack[Ignore.intStackSize + 1];
                     var13 = class48.method774(var12);
                     if(var13.method4444()) {
                        class82.scriptStringStack[++class169.scriptStringStackSize - 1] = class169.getItemDefinition(var11).method4562(var12, var13.field3392);
                     } else {
                        class82.intStack[++Ignore.intStackSize - 1] = class169.getItemDefinition(var11).method4561(var12, var13.field3390);
                     }

                     return 1;
                  } else if(var0 == 6516) {
                     Ignore.intStackSize -= 2;
                     var11 = class82.intStack[Ignore.intStackSize];
                     var12 = class82.intStack[Ignore.intStackSize + 1];
                     var13 = class48.method774(var12);
                     if(var13.method4444()) {
                        String[] var14 = class82.scriptStringStack;
                        int var7 = ++class169.scriptStringStackSize - 1;
                        class253 var9 = (class253)class253.field3399.get((long)var11);
                        class253 var8;
                        if(var9 != null) {
                           var8 = var9;
                        } else {
                           byte[] var10 = class239.field3272.getConfigData(34, var11);
                           var9 = new class253();
                           if(var10 != null) {
                              var9.method4456(new Buffer(var10));
                           }

                           var9.method4455();
                           class253.field3399.put(var9, (long)var11);
                           var8 = var9;
                        }

                        var14[var7] = var8.method4474(var12, var13.field3392);
                     } else {
                        class82.intStack[++Ignore.intStackSize - 1] = class215.method4021(var11).method4458(var12, var13.field3390);
                     }

                     return 1;
                  } else if(var0 == 6518) {
                     class82.intStack[++Ignore.intStackSize - 1] = 0;
                     return 1;
                  } else {
                     return var0 == 6520?1:(var0 == 6521?1:2);
                  }
               }
            } else {
               var11 = class82.intStack[--Ignore.intStackSize];
               if(var11 >= 0 && var11 < World.worldCount) {
                  var4 = World.worldList[var11];
                  class82.intStack[++Ignore.intStackSize - 1] = var4.id;
                  class82.intStack[++Ignore.intStackSize - 1] = var4.mask;
                  class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var4.activity;
                  class82.intStack[++Ignore.intStackSize - 1] = var4.location;
                  class82.intStack[++Ignore.intStackSize - 1] = var4.playerCount;
                  class82.scriptStringStack[++class169.scriptStringStackSize - 1] = var4.address;
               } else {
                  class82.intStack[++Ignore.intStackSize - 1] = -1;
                  class82.intStack[++Ignore.intStackSize - 1] = 0;
                  class82.scriptStringStack[++class169.scriptStringStackSize - 1] = "";
                  class82.intStack[++Ignore.intStackSize - 1] = 0;
                  class82.intStack[++Ignore.intStackSize - 1] = 0;
                  class82.scriptStringStack[++class169.scriptStringStackSize - 1] = "";
               }

               return 1;
            }
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-1637969450"
   )
   public static boolean method660(char var0) {
      return var0 >= 48 && var0 <= 57 || var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IS)I",
      garbageValue = "2160"
   )
   static int method665(int var0) {
      MessageNode var1 = (MessageNode)class97.field1532.get((long)var0);
      return var1 == null?-1:(var1.next == class97.field1536.field2492?-1:((MessageNode)var1.next).id);
   }
}
