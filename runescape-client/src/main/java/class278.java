import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jn")
public class class278 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1041626953
   )
   public int field3739;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1714593831
   )
   public int field3740;

   class278(int var1, int var2, int var3, int var4) {
      this.method4800(var1, var2);
      this.method4801(var3, var4);
   }

   public class278(int var1, int var2) {
      this(0, 0, var1, var2);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1818492052"
   )
   void method4800(int var1, int var2) {
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-23"
   )
   void method4801(int var1, int var2) {
      this.field3740 = var1;
      this.field3739 = var2;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "819870686"
   )
   static int method4806(int var0, Script var1, boolean var2) {
      String var3;
      if(var0 == 3100) {
         var3 = class83.scriptStringStack[--class24.scriptStringStackSize];
         class5.sendGameMessage(0, "", var3);
         return 1;
      } else if(var0 == 3101) {
         class83.intStackSize -= 2;
         class10.method57(class20.localPlayer, class83.intStack[class83.intStackSize], class83.intStack[class83.intStackSize + 1]);
         return 1;
      } else if(var0 == 3103) {
         class270.method4788();
         return 1;
      } else {
         int var13;
         if(var0 == 3104) {
            var3 = class83.scriptStringStack[--class24.scriptStringStackSize];
            var13 = 0;
            if(IndexFile.method2910(var3)) {
               var13 = class112.method1991(var3);
            }

            Client.secretPacketBuffer1.putOpcode(192);
            Client.secretPacketBuffer1.putInt(var13);
            return 1;
         } else if(var0 == 3105) {
            var3 = class83.scriptStringStack[--class24.scriptStringStackSize];
            Client.secretPacketBuffer1.putOpcode(98);
            Client.secretPacketBuffer1.putByte(var3.length() + 1);
            Client.secretPacketBuffer1.method3125(var3);
            return 1;
         } else if(var0 == 3106) {
            var3 = class83.scriptStringStack[--class24.scriptStringStackSize];
            Client.secretPacketBuffer1.putOpcode(141);
            Client.secretPacketBuffer1.putByte(var3.length() + 1);
            Client.secretPacketBuffer1.method3125(var3);
            return 1;
         } else {
            int var5;
            int var10;
            String var11;
            if(var0 != 3107) {
               if(var0 == 3108) {
                  class83.intStackSize -= 3;
                  var10 = class83.intStack[class83.intStackSize];
                  var13 = class83.intStack[class83.intStackSize + 1];
                  var5 = class83.intStack[class83.intStackSize + 2];
                  Widget var14 = class223.method3959(var5);
                  ScriptState.method1009(var14, var10, var13);
                  return 1;
               } else if(var0 == 3109) {
                  class83.intStackSize -= 2;
                  var10 = class83.intStack[class83.intStackSize];
                  var13 = class83.intStack[class83.intStackSize + 1];
                  Widget var15 = var2?class43.field582:class31.field457;
                  ScriptState.method1009(var15, var10, var13);
                  return 1;
               } else if(var0 == 3110) {
                  class221.field2845 = class83.intStack[--class83.intStackSize] == 1;
                  return 1;
               } else if(var0 == 3111) {
                  class83.intStack[++class83.intStackSize - 1] = Item.field1481.field1299?1:0;
                  return 1;
               } else if(var0 == 3112) {
                  Item.field1481.field1299 = class83.intStack[--class83.intStackSize] == 1;
                  class5.method16();
                  return 1;
               } else if(var0 == 3113) {
                  var3 = class83.scriptStringStack[--class24.scriptStringStackSize];
                  boolean var4 = class83.intStack[--class83.intStackSize] == 1;
                  class20.method164(var3, var4, false);
                  return 1;
               } else if(var0 == 3115) {
                  var10 = class83.intStack[--class83.intStackSize];
                  Client.secretPacketBuffer1.putOpcode(193);
                  Client.secretPacketBuffer1.putShort(var10);
                  return 1;
               } else if(var0 == 3116) {
                  var10 = class83.intStack[--class83.intStackSize];
                  class24.scriptStringStackSize -= 2;
                  var11 = class83.scriptStringStack[class24.scriptStringStackSize];
                  String var12 = class83.scriptStringStack[class24.scriptStringStackSize + 1];
                  if(var11.length() > 500) {
                     return 1;
                  } else if(var12.length() > 500) {
                     return 1;
                  } else {
                     Client.secretPacketBuffer1.putOpcode(49);
                     Client.secretPacketBuffer1.putShort(Friend.method1023(var11) + 1 + Friend.method1023(var12));
                     Client.secretPacketBuffer1.method3125(var12);
                     Client.secretPacketBuffer1.method3196(var10);
                     Client.secretPacketBuffer1.method3125(var11);
                     return 1;
                  }
               } else if(var0 == 3117) {
                  Client.field989 = class83.intStack[--class83.intStackSize] == 1;
                  return 1;
               } else {
                  return 2;
               }
            } else {
               var10 = class83.intStack[--class83.intStackSize];
               var11 = class83.scriptStringStack[--class24.scriptStringStackSize];
               var5 = class96.field1487;
               int[] var6 = class96.field1491;
               boolean var7 = false;

               for(int var8 = 0; var8 < var5; ++var8) {
                  Player var9 = Client.cachedPlayers[var6[var8]];
                  if(var9 != null && var9 != class20.localPlayer && var9.name != null && var9.name.equalsIgnoreCase(var11)) {
                     if(var10 == 1) {
                        Client.secretPacketBuffer1.putOpcode(187);
                        Client.secretPacketBuffer1.method3067(var6[var8]);
                        Client.secretPacketBuffer1.method3059(0);
                     } else if(var10 == 4) {
                        Client.secretPacketBuffer1.putOpcode(90);
                        Client.secretPacketBuffer1.method3059(0);
                        Client.secretPacketBuffer1.method3065(var6[var8]);
                     } else if(var10 == 6) {
                        Client.secretPacketBuffer1.putOpcode(196);
                        Client.secretPacketBuffer1.putShort(var6[var8]);
                        Client.secretPacketBuffer1.method3069(0);
                     } else if(var10 == 7) {
                        Client.secretPacketBuffer1.putOpcode(165);
                        Client.secretPacketBuffer1.method3065(var6[var8]);
                        Client.secretPacketBuffer1.putByte(0);
                     }

                     var7 = true;
                     break;
                  }
               }

               if(!var7) {
                  class5.sendGameMessage(4, "", "Unable to find " + var11);
               }

               return 1;
            }
         }
      }
   }
}
