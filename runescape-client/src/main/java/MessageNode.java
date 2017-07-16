import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bv")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 981617223
   )
   @Export("id")
   int id;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -606268411
   )
   @Export("tick")
   int tick;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1349628075
   )
   @Export("type")
   int type;
   @ObfuscatedName("r")
   @Export("name")
   String name;
   @ObfuscatedName("v")
   @Export("sender")
   String sender;
   @ObfuscatedName("e")
   @Export("value")
   String value;

   MessageNode(int var1, String var2, String var3, String var4) {
      this.id = NPC.method1677();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-1548603725"
   )
   void method1104(int var1, String var2, String var3, String var4) {
      this.id = NPC.method1677();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(ILcg;ZI)I",
      garbageValue = "41773227"
   )
   static int method1107(int var0, Script var1, boolean var2) {
      if(var0 == 6500) {
         class83.intStack[++WorldMapType2.intStackSize - 1] = class217.loadWorlds()?1:0;
         return 1;
      } else {
         World var3;
         if(var0 == 6501) {
            var3 = WorldMapType1.method273();
            if(var3 != null) {
               class83.intStack[++WorldMapType2.intStackSize - 1] = var3.id;
               class83.intStack[++WorldMapType2.intStackSize - 1] = var3.mask;
               class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var3.activity;
               class83.intStack[++WorldMapType2.intStackSize - 1] = var3.location;
               class83.intStack[++WorldMapType2.intStackSize - 1] = var3.playerCount;
               class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var3.address;
            } else {
               class83.intStack[++WorldMapType2.intStackSize - 1] = -1;
               class83.intStack[++WorldMapType2.intStackSize - 1] = 0;
               class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = "";
               class83.intStack[++WorldMapType2.intStackSize - 1] = 0;
               class83.intStack[++WorldMapType2.intStackSize - 1] = 0;
               class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 6502) {
            if(World.field1289 < World.worldCount) {
               var3 = World.worldList[++World.field1289 - 1];
            } else {
               var3 = null;
            }

            if(var3 != null) {
               class83.intStack[++WorldMapType2.intStackSize - 1] = var3.id;
               class83.intStack[++WorldMapType2.intStackSize - 1] = var3.mask;
               class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var3.activity;
               class83.intStack[++WorldMapType2.intStackSize - 1] = var3.location;
               class83.intStack[++WorldMapType2.intStackSize - 1] = var3.playerCount;
               class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var3.address;
            } else {
               class83.intStack[++WorldMapType2.intStackSize - 1] = -1;
               class83.intStack[++WorldMapType2.intStackSize - 1] = 0;
               class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = "";
               class83.intStack[++WorldMapType2.intStackSize - 1] = 0;
               class83.intStack[++WorldMapType2.intStackSize - 1] = 0;
               class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else {
            World var4;
            int var5;
            int var11;
            if(var0 == 6506) {
               var11 = class83.intStack[--WorldMapType2.intStackSize];
               var4 = null;

               for(var5 = 0; var5 < World.worldCount; ++var5) {
                  if(var11 == World.worldList[var5].id) {
                     var4 = World.worldList[var5];
                     break;
                  }
               }

               if(var4 != null) {
                  class83.intStack[++WorldMapType2.intStackSize - 1] = var4.id;
                  class83.intStack[++WorldMapType2.intStackSize - 1] = var4.mask;
                  class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var4.activity;
                  class83.intStack[++WorldMapType2.intStackSize - 1] = var4.location;
                  class83.intStack[++WorldMapType2.intStackSize - 1] = var4.playerCount;
                  class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var4.address;
               } else {
                  class83.intStack[++WorldMapType2.intStackSize - 1] = -1;
                  class83.intStack[++WorldMapType2.intStackSize - 1] = 0;
                  class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = "";
                  class83.intStack[++WorldMapType2.intStackSize - 1] = 0;
                  class83.intStack[++WorldMapType2.intStackSize - 1] = 0;
                  class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 6507) {
               WorldMapType2.intStackSize -= 4;
               var11 = class83.intStack[WorldMapType2.intStackSize];
               boolean var15 = class83.intStack[WorldMapType2.intStackSize + 1] == 1;
               var5 = class83.intStack[WorldMapType2.intStackSize + 2];
               boolean var6 = class83.intStack[WorldMapType2.intStackSize + 3] == 1;
               if(World.worldList != null) {
                  GroundObject.method2479(0, World.worldList.length - 1, var11, var15, var5, var6);
               }

               return 1;
            } else if(var0 != 6511) {
               if(var0 == 6512) {
                  Client.field1052 = class83.intStack[--WorldMapType2.intStackSize] == 1;
                  return 1;
               } else {
                  int var12;
                  class251 var13;
                  if(var0 == 6513) {
                     WorldMapType2.intStackSize -= 2;
                     var11 = class83.intStack[WorldMapType2.intStackSize];
                     var12 = class83.intStack[WorldMapType2.intStackSize + 1];
                     var13 = class228.method4068(var12);
                     if(var13.method4382()) {
                        class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = class224.getNpcDefinition(var11).method4575(var12, var13.field3384);
                     } else {
                        class83.intStack[++WorldMapType2.intStackSize - 1] = class224.getNpcDefinition(var11).method4574(var12, var13.field3387);
                     }

                     return 1;
                  } else if(var0 == 6514) {
                     WorldMapType2.intStackSize -= 2;
                     var11 = class83.intStack[WorldMapType2.intStackSize];
                     var12 = class83.intStack[WorldMapType2.intStackSize + 1];
                     var13 = class228.method4068(var12);
                     if(var13.method4382()) {
                        class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = PlayerComposition.getObjectDefinition(var11).method4501(var12, var13.field3384);
                     } else {
                        class83.intStack[++WorldMapType2.intStackSize - 1] = PlayerComposition.getObjectDefinition(var11).method4474(var12, var13.field3387);
                     }

                     return 1;
                  } else if(var0 == 6515) {
                     WorldMapType2.intStackSize -= 2;
                     var11 = class83.intStack[WorldMapType2.intStackSize];
                     var12 = class83.intStack[WorldMapType2.intStackSize + 1];
                     var13 = class228.method4068(var12);
                     if(var13.method4382()) {
                        class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = class83.getItemDefinition(var11).method4557(var12, var13.field3384);
                     } else {
                        class83.intStack[++WorldMapType2.intStackSize - 1] = class83.getItemDefinition(var11).method4515(var12, var13.field3387);
                     }

                     return 1;
                  } else if(var0 == 6516) {
                     WorldMapType2.intStackSize -= 2;
                     var11 = class83.intStack[WorldMapType2.intStackSize];
                     var12 = class83.intStack[WorldMapType2.intStackSize + 1];
                     var13 = class228.method4068(var12);
                     int var7;
                     class252 var8;
                     class252 var9;
                     byte[] var10;
                     if(var13.method4382()) {
                        String[] var14 = class83.scriptStringStack;
                        var7 = ++BaseVarType.scriptStringStackSize - 1;
                        var9 = (class252)class252.field3394.get((long)var11);
                        if(var9 != null) {
                           var8 = var9;
                        } else {
                           var10 = class217.field2790.getConfigData(34, var11);
                           var9 = new class252();
                           if(var10 != null) {
                              var9.method4397(new Buffer(var10));
                           }

                           var9.method4420();
                           class252.field3394.put(var9, (long)var11);
                           var8 = var9;
                        }

                        var14[var7] = var8.method4414(var12, var13.field3384);
                     } else {
                        int[] var16 = class83.intStack;
                        var7 = ++WorldMapType2.intStackSize - 1;
                        var9 = (class252)class252.field3394.get((long)var11);
                        if(var9 != null) {
                           var8 = var9;
                        } else {
                           var10 = class217.field2790.getConfigData(34, var11);
                           var9 = new class252();
                           if(var10 != null) {
                              var9.method4397(new Buffer(var10));
                           }

                           var9.method4420();
                           class252.field3394.put(var9, (long)var11);
                           var8 = var9;
                        }

                        var16[var7] = var8.method4399(var12, var13.field3387);
                     }

                     return 1;
                  } else {
                     return 2;
                  }
               }
            } else {
               var11 = class83.intStack[--WorldMapType2.intStackSize];
               if(var11 >= 0 && var11 < World.worldCount) {
                  var4 = World.worldList[var11];
                  class83.intStack[++WorldMapType2.intStackSize - 1] = var4.id;
                  class83.intStack[++WorldMapType2.intStackSize - 1] = var4.mask;
                  class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var4.activity;
                  class83.intStack[++WorldMapType2.intStackSize - 1] = var4.location;
                  class83.intStack[++WorldMapType2.intStackSize - 1] = var4.playerCount;
                  class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var4.address;
               } else {
                  class83.intStack[++WorldMapType2.intStackSize - 1] = -1;
                  class83.intStack[++WorldMapType2.intStackSize - 1] = 0;
                  class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = "";
                  class83.intStack[++WorldMapType2.intStackSize - 1] = 0;
                  class83.intStack[++WorldMapType2.intStackSize - 1] = 0;
                  class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = "";
               }

               return 1;
            }
         }
      }
   }
}
