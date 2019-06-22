import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
public class class31 {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lac;"
   )
   static final class31 field259;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lac;"
   )
   static final class31 field254;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 214832375
   )
   final int field255;

   class31(int var1) {
      this.field255 = var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lbt;I)V",
      garbageValue = "-1277717693"
   )
   @Export("changeWorld")
   static void changeWorld(World var0) {
      if(var0.__e_144() != Client.isMembersWorld) {
         Client.isMembersWorld = var0.__e_144();
         boolean var1 = var0.__e_144();
         if(var1 != class30.inMembersWorld) {
            class72.method1780();
            class30.inMembersWorld = var1;
         }
      }

      class50.worldHost = var0.host;
      Client.worldId = var0.id;
      Client.worldProperties = var0.properties;
      class2.port1 = Client.gameBuild == 0?43594:var0.id + 40000;
      WorldMapArea.port2 = Client.gameBuild == 0?443:var0.id + 50000;
      class203.port3 = class2.port1;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(ILcg;ZI)I",
      garbageValue = "130306081"
   )
   static int method573(int var0, Script var1, boolean var2) {
      if(var0 == 6500) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = ClientParameter.loadWorlds()?1:0;
         return 1;
      } else {
         World var3;
         if(var0 == 6501) {
            var3 = class190.method3672();
            if(var3 != null) {
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.id;
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.properties;
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.activity;
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.location;
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.population;
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.host;
            } else {
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = -1;
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 0;
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 0;
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 0;
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 6502) {
            var3 = Fonts.method5647();
            if(var3 != null) {
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.id;
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.properties;
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.activity;
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.location;
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.population;
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.host;
            } else {
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = -1;
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 0;
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 0;
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 0;
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
            }

            return 1;
         } else {
            World var4;
            int var5;
            int var6;
            if(var0 == 6506) {
               var6 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
               var4 = null;

               for(var5 = 0; var5 < World.worldsCount; ++var5) {
                  if(var6 == ItemContainer.worlds[var5].id) {
                     var4 = ItemContainer.worlds[var5];
                     break;
                  }
               }

               if(var4 != null) {
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var4.id;
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var4.properties;
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var4.activity;
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var4.location;
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var4.population;
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var4.host;
               } else {
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = -1;
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 0;
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 0;
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 0;
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 6507) {
               class179.Interpreter_intStackSize -= 4;
               var6 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
               boolean var9 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1] == 1;
               var5 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 2];
               boolean var10 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 3] == 1;
               WorldMapSectionType.method248(var6, var9, var5, var10);
               return 1;
            } else if(var0 != 6511) {
               if(var0 == 6512) {
                  Client.followerOpsLowPriority = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
                  return 1;
               } else {
                  int var7;
                  ParamKeyDefinition var8;
                  if(var0 == 6513) {
                     class179.Interpreter_intStackSize -= 2;
                     var6 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
                     var7 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
                     var8 = class229.getParamKeyDefinition(var7);
                     if(var8.isString()) {
                        Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = ObjectDefinition.getNpcDefinition(var6).getStringParam(var7, var8.keyString);
                     } else {
                        Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = ObjectDefinition.getNpcDefinition(var6).getIntParam(var7, var8.keyInt);
                     }

                     return 1;
                  } else if(var0 == 6514) {
                     class179.Interpreter_intStackSize -= 2;
                     var6 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
                     var7 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
                     var8 = class229.getParamKeyDefinition(var7);
                     if(var8.isString()) {
                        Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = class50.getObjectDefinition(var6).getStringParam(var7, var8.keyString);
                     } else {
                        Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = class50.getObjectDefinition(var6).getIntParam(var7, var8.keyInt);
                     }

                     return 1;
                  } else if(var0 == 6515) {
                     class179.Interpreter_intStackSize -= 2;
                     var6 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
                     var7 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
                     var8 = class229.getParamKeyDefinition(var7);
                     if(var8.isString()) {
                        Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = Skills.getItemDefinition(var6).getStringParam(var7, var8.keyString);
                     } else {
                        Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = Skills.getItemDefinition(var6).getIntParam(var7, var8.keyInt);
                     }

                     return 1;
                  } else if(var0 == 6516) {
                     class179.Interpreter_intStackSize -= 2;
                     var6 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
                     var7 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
                     var8 = class229.getParamKeyDefinition(var7);
                     if(var8.isString()) {
                        Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = GzipDecompressor.method3702(var6).getStringParam(var7, var8.keyString);
                     } else {
                        Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = GzipDecompressor.method3702(var6).getIntParam(var7, var8.keyInt);
                     }

                     return 1;
                  } else if(var0 == 6518) {
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = Client.__client_bl?1:0;
                     return 1;
                  } else if(var0 == 6519) {
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = Client.clientType & 3;
                     return 1;
                  } else if(var0 == 6520) {
                     return 1;
                  } else if(var0 == 6521) {
                     return 1;
                  } else if(var0 == 6522) {
                     --Interpreter.Interpreter_stringStackSize;
                     --class179.Interpreter_intStackSize;
                     return 1;
                  } else if(var0 == 6523) {
                     --Interpreter.Interpreter_stringStackSize;
                     --class179.Interpreter_intStackSize;
                     return 1;
                  } else if(var0 == 6524) {
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = -1;
                     return 1;
                  } else if(var0 == 6525) {
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 1;
                     return 1;
                  } else if(var0 == 6526) {
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 1;
                     return 1;
                  } else {
                     return 2;
                  }
               }
            } else {
               var6 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
               if(var6 >= 0 && var6 < World.worldsCount) {
                  var4 = ItemContainer.worlds[var6];
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var4.id;
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var4.properties;
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var4.activity;
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var4.location;
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var4.population;
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var4.host;
               } else {
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = -1;
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 0;
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 0;
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 0;
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
               }

               return 1;
            }
         }
      }
   }

   @ObfuscatedName("kd")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-110"
   )
   static final void method574(String var0) {
      if(!var0.equals("")) {
         PacketBufferNode var1 = Interpreter.method1915(ClientPacket.__gs_cr, Client.packetWriter.isaacCipher);
         var1.packetBuffer.writeByte(WorldMapRegion.method550(var0));
         var1.packetBuffer.writeStringCp1252NullTerminated(var0);
         Client.packetWriter.__q_167(var1);
      }

   }

   static {
      field259 = new class31(0);
      field254 = new class31(1);
   }
}
