import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gz")
public class class205 extends Node {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1747114901
   )
   int field2516;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   class202 field2511;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   class207 field2509;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Ldm;"
   )
   class107 field2517;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lde;"
   )
   class117 field2510;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1171966655
   )
   int field2518;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 2001462103
   )
   int field2526;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -730054071
   )
   int field2508;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -700734343
   )
   int field2522;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1030379593
   )
   int field2523;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1233783813
   )
   int field2515;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -462911357
   )
   int field2527;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -798879891
   )
   int field2514;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 137171785
   )
   int field2528;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 945443547
   )
   int field2513;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1781438011
   )
   int field2519;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 910536785
   )
   int field2524;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1502568947
   )
   int field2512;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -49317961
   )
   int field2520;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -245758493
   )
   int field2521;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 325553539
   )
   int field2525;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1459672328"
   )
   void method3755() {
      this.field2509 = null;
      this.field2517 = null;
      this.field2511 = null;
      this.field2510 = null;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)Liz;",
      garbageValue = "1040187403"
   )
   @Export("getSpotAnimType")
   public static Spotanim getSpotAnimType(int var0) {
      Spotanim var1 = (Spotanim)Spotanim.spotanims.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Spotanim.field3297.getConfigData(13, var0);
         var1 = new Spotanim();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         Spotanim.spotanims.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lip;I)V",
      garbageValue = "1155505228"
   )
   public static void method3760(IndexDataBase var0) {
      Enum.field3374 = var0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ILcv;ZI)I",
      garbageValue = "-1786045175"
   )
   static int method3761(int var0, Script var1, boolean var2) {
      String var3;
      if(var0 == 3100) {
         var3 = class83.scriptStringStack[--class83.scriptStringStackSize];
         Item.sendGameMessage(0, "", var3);
         return 1;
      } else if(var0 == 3101) {
         BufferProvider.intStackSize -= 2;
         class14.method81(class226.localPlayer, class83.intStack[BufferProvider.intStackSize], class83.intStack[BufferProvider.intStackSize + 1]);
         return 1;
      } else if(var0 == 3103) {
         class229.method3988();
         return 1;
      } else {
         int var13;
         if(var0 == 3104) {
            var3 = class83.scriptStringStack[--class83.scriptStringStackSize];
            var13 = 0;
            if(WorldMapType2.method509(var3)) {
               var13 = GameObject.method2836(var3);
            }

            Client.secretPacketBuffer1.putOpcode(201);
            Client.secretPacketBuffer1.putInt(var13);
            return 1;
         } else if(var0 == 3105) {
            var3 = class83.scriptStringStack[--class83.scriptStringStackSize];
            Client.secretPacketBuffer1.putOpcode(97);
            Client.secretPacketBuffer1.putByte(var3.length() + 1);
            Client.secretPacketBuffer1.putString(var3);
            return 1;
         } else if(var0 == 3106) {
            var3 = class83.scriptStringStack[--class83.scriptStringStackSize];
            Client.secretPacketBuffer1.putOpcode(42);
            Client.secretPacketBuffer1.putByte(var3.length() + 1);
            Client.secretPacketBuffer1.putString(var3);
            return 1;
         } else {
            int var5;
            int var10;
            String var11;
            if(var0 != 3107) {
               if(var0 == 3108) {
                  BufferProvider.intStackSize -= 3;
                  var10 = class83.intStack[BufferProvider.intStackSize];
                  var13 = class83.intStack[BufferProvider.intStackSize + 1];
                  var5 = class83.intStack[BufferProvider.intStackSize + 2];
                  Widget var14 = class239.method4167(var5);
                  class64.method1036(var14, var10, var13);
                  return 1;
               } else if(var0 == 3109) {
                  BufferProvider.intStackSize -= 2;
                  var10 = class83.intStack[BufferProvider.intStackSize];
                  var13 = class83.intStack[BufferProvider.intStackSize + 1];
                  Widget var15 = var2?class48.field614:FaceNormal.field2099;
                  class64.method1036(var15, var10, var13);
                  return 1;
               } else if(var0 == 3110) {
                  GameEngine.field699 = class83.intStack[--BufferProvider.intStackSize] == 1;
                  return 1;
               } else if(var0 == 3111) {
                  class83.intStack[++BufferProvider.intStackSize - 1] = class34.preferences.hideRoofs?1:0;
                  return 1;
               } else if(var0 == 3112) {
                  class34.preferences.hideRoofs = class83.intStack[--BufferProvider.intStackSize] == 1;
                  class10.method51();
                  return 1;
               } else if(var0 == 3113) {
                  var3 = class83.scriptStringStack[--class83.scriptStringStackSize];
                  boolean var4 = class83.intStack[--BufferProvider.intStackSize] == 1;
                  class222.method3978(var3, var4, "openjs", false);
                  return 1;
               } else if(var0 == 3115) {
                  var10 = class83.intStack[--BufferProvider.intStackSize];
                  Client.secretPacketBuffer1.putOpcode(81);
                  Client.secretPacketBuffer1.putShort(var10);
                  return 1;
               } else if(var0 == 3116) {
                  var10 = class83.intStack[--BufferProvider.intStackSize];
                  class83.scriptStringStackSize -= 2;
                  var11 = class83.scriptStringStack[class83.scriptStringStackSize];
                  String var12 = class83.scriptStringStack[class83.scriptStringStackSize + 1];
                  if(var11.length() > 500) {
                     return 1;
                  } else if(var12.length() > 500) {
                     return 1;
                  } else {
                     Client.secretPacketBuffer1.putOpcode(95);
                     Client.secretPacketBuffer1.putShort(1 + class15.getLength(var11) + class15.getLength(var12));
                     Client.secretPacketBuffer1.putString(var12);
                     Client.secretPacketBuffer1.putString(var11);
                     Client.secretPacketBuffer1.putByte(var10);
                     return 1;
                  }
               } else if(var0 == 3117) {
                  Client.field1052 = class83.intStack[--BufferProvider.intStackSize] == 1;
                  return 1;
               } else {
                  return 2;
               }
            } else {
               var10 = class83.intStack[--BufferProvider.intStackSize];
               var11 = class83.scriptStringStack[--class83.scriptStringStackSize];
               var5 = class96.field1469;
               int[] var6 = class96.field1470;
               boolean var7 = false;

               for(int var8 = 0; var8 < var5; ++var8) {
                  Player var9 = Client.cachedPlayers[var6[var8]];
                  if(var9 != null && var9 != class226.localPlayer && var9.name != null && var9.name.equalsIgnoreCase(var11)) {
                     if(var10 == 1) {
                        Client.secretPacketBuffer1.putOpcode(139);
                        Client.secretPacketBuffer1.putShortLE(0);
                        Client.secretPacketBuffer1.putShortOb2(var6[var8]);
                     } else if(var10 == 4) {
                        Client.secretPacketBuffer1.putOpcode(184);
                        Client.secretPacketBuffer1.putShortLE(0);
                        Client.secretPacketBuffer1.putShort(var6[var8]);
                     } else if(var10 == 6) {
                        Client.secretPacketBuffer1.putOpcode(73);
                        Client.secretPacketBuffer1.putShortLE(0);
                        Client.secretPacketBuffer1.method3129(var6[var8]);
                     } else if(var10 == 7) {
                        Client.secretPacketBuffer1.putOpcode(118);
                        Client.secretPacketBuffer1.putLEInt(var6[var8]);
                        Client.secretPacketBuffer1.method3217(0);
                     }

                     var7 = true;
                     break;
                  }
               }

               if(!var7) {
                  Item.sendGameMessage(4, "", "Unable to find " + var11);
               }

               return 1;
            }
         }
      }
   }
}
