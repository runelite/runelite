import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
public class class51 implements class102 {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   @Export("varplayer_ref")
   public static IndexDataBase varplayer_ref;
   @ObfuscatedName("fl")
   @ObfuscatedSignature(
      signature = "[Lko;"
   )
   static IndexedSprite[] field627;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Ldi;",
      garbageValue = "-270098985"
   )
   public AbstractSoundSystem vmethod2015() {
      return new SourceDataSoundSystem();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-247314763"
   )
   public static final boolean method839() {
      KeyFocusListener var0 = KeyFocusListener.keyboard;
      synchronized(KeyFocusListener.keyboard) {
         if(KeyFocusListener.field619 == KeyFocusListener.field621) {
            return false;
         } else {
            CombatInfoListHolder.field1289 = KeyFocusListener.field616[KeyFocusListener.field619];
            class285.field3792 = KeyFocusListener.field608[KeyFocusListener.field619];
            KeyFocusListener.field619 = KeyFocusListener.field619 + 1 & 127;
            return true;
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lgi;II)V",
      garbageValue = "152741603"
   )
   @Export("decodeMovement")
   static void decodeMovement(PacketBuffer var0, int var1) {
      boolean var2 = var0.getBits(1) == 1;
      if(var2) {
         class94.field1415[++class94.field1408 - 1] = var1;
      }

      int var3 = var0.getBits(2);
      Player var4 = Client.cachedPlayers[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field854 = false;
         } else if(Client.localInteractingIndex == var1) {
            throw new RuntimeException();
         } else {
            class94.field1409[var1] = (var4.field852 << 28) + (ItemLayer.baseX + var4.pathX[0] >> 13 << 14) + (ItemLayer.baseY + var4.pathY[0] >> 13);
            if(var4.field1202 != -1) {
               class94.field1410[var1] = var4.field1202;
            } else {
               class94.field1410[var1] = var4.orientation;
            }

            class94.field1412[var1] = var4.interacting;
            Client.cachedPlayers[var1] = null;
            if(var0.getBits(1) != 0) {
               class37.decodeRegionHash(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.getBits(3);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               --var6;
               --var7;
            } else if(var5 == 1) {
               --var7;
            } else if(var5 == 2) {
               ++var6;
               --var7;
            } else if(var5 == 3) {
               --var6;
            } else if(var5 == 4) {
               ++var6;
            } else if(var5 == 5) {
               --var6;
               ++var7;
            } else if(var5 == 6) {
               ++var7;
            } else if(var5 == 7) {
               ++var6;
               ++var7;
            }

            if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
               var4.method1191(var6, var7);
               var4.field854 = false;
            } else if(var2) {
               var4.field854 = true;
               var4.field855 = var6;
               var4.field858 = var7;
            } else {
               var4.field854 = false;
               var4.method1190(var6, var7, class94.field1411[var1]);
            }

         } else if(var3 == 2) {
            var5 = var0.getBits(4);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               var6 -= 2;
               var7 -= 2;
            } else if(var5 == 1) {
               --var6;
               var7 -= 2;
            } else if(var5 == 2) {
               var7 -= 2;
            } else if(var5 == 3) {
               ++var6;
               var7 -= 2;
            } else if(var5 == 4) {
               var6 += 2;
               var7 -= 2;
            } else if(var5 == 5) {
               var6 -= 2;
               --var7;
            } else if(var5 == 6) {
               var6 += 2;
               --var7;
            } else if(var5 == 7) {
               var6 -= 2;
            } else if(var5 == 8) {
               var6 += 2;
            } else if(var5 == 9) {
               var6 -= 2;
               ++var7;
            } else if(var5 == 10) {
               var6 += 2;
               ++var7;
            } else if(var5 == 11) {
               var6 -= 2;
               var7 += 2;
            } else if(var5 == 12) {
               --var6;
               var7 += 2;
            } else if(var5 == 13) {
               var7 += 2;
            } else if(var5 == 14) {
               ++var6;
               var7 += 2;
            } else if(var5 == 15) {
               var6 += 2;
               var7 += 2;
            }

            if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
               var4.method1191(var6, var7);
               var4.field854 = false;
            } else if(var2) {
               var4.field854 = true;
               var4.field855 = var6;
               var4.field858 = var7;
            } else {
               var4.field854 = false;
               var4.method1190(var6, var7, class94.field1411[var1]);
            }

         } else {
            var5 = var0.getBits(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.getBits(12);
               var7 = var6 >> 10;
               var8 = var6 >> 5 & 31;
               if(var8 > 15) {
                  var8 -= 32;
               }

               var9 = var6 & 31;
               if(var9 > 15) {
                  var9 -= 32;
               }

               var10 = var8 + var4.pathX[0];
               var11 = var9 + var4.pathY[0];
               if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
                  var4.method1191(var10, var11);
                  var4.field854 = false;
               } else if(var2) {
                  var4.field854 = true;
                  var4.field855 = var10;
                  var4.field858 = var11;
               } else {
                  var4.field854 = false;
                  var4.method1190(var10, var11, class94.field1411[var1]);
               }

               var4.field852 = (byte)(var7 + var4.field852 & 3);
               if(Client.localInteractingIndex == var1) {
                  Ignore.plane = var4.field852;
               }

            } else {
               var6 = var0.getBits(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var8 + ItemLayer.baseX + var4.pathX[0] & 16383) - ItemLayer.baseX;
               var11 = (var9 + ItemLayer.baseY + var4.pathY[0] & 16383) - ItemLayer.baseY;
               if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field854 = true;
                     var4.field855 = var10;
                     var4.field858 = var11;
                  } else {
                     var4.field854 = false;
                     var4.method1190(var10, var11, class94.field1411[var1]);
                  }
               } else {
                  var4.method1191(var10, var11);
                  var4.field854 = false;
               }

               var4.field852 = (byte)(var7 + var4.field852 & 3);
               if(Client.localInteractingIndex == var1) {
                  Ignore.plane = var4.field852;
               }

            }
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ILcw;ZB)I",
      garbageValue = "68"
   )
   static int method840(int var0, Script var1, boolean var2) {
      if(var0 == 6200) {
         class56.intStackSize -= 2;
         Client.field1103 = (short)class82.intStack[class56.intStackSize];
         if(Client.field1103 <= 0) {
            Client.field1103 = 256;
         }

         Client.field1104 = (short)class82.intStack[class56.intStackSize + 1];
         if(Client.field1104 <= 0) {
            Client.field1104 = 205;
         }

         return 1;
      } else if(var0 == 6201) {
         class56.intStackSize -= 2;
         Client.field1105 = (short)class82.intStack[class56.intStackSize];
         if(Client.field1105 <= 0) {
            Client.field1105 = 256;
         }

         Client.field1106 = (short)class82.intStack[class56.intStackSize + 1];
         if(Client.field1106 <= 0) {
            Client.field1106 = 320;
         }

         return 1;
      } else if(var0 == 6202) {
         class56.intStackSize -= 4;
         Client.field1107 = (short)class82.intStack[class56.intStackSize];
         if(Client.field1107 <= 0) {
            Client.field1107 = 1;
         }

         Client.field911 = (short)class82.intStack[class56.intStackSize + 1];
         if(Client.field911 <= 0) {
            Client.field911 = 32767;
         } else if(Client.field911 < Client.field1107) {
            Client.field911 = Client.field1107;
         }

         Client.field881 = (short)class82.intStack[class56.intStackSize + 2];
         if(Client.field881 <= 0) {
            Client.field881 = 1;
         }

         Client.field1108 = (short)class82.intStack[class56.intStackSize + 3];
         if(Client.field1108 <= 0) {
            Client.field1108 = 32767;
         } else if(Client.field1108 < Client.field881) {
            Client.field1108 = Client.field881;
         }

         return 1;
      } else if(var0 == 6203) {
         if(Client.field923 != null) {
            class175.method3246(0, 0, Client.field923.width, Client.field923.height, false);
            class82.intStack[++class56.intStackSize - 1] = Client.viewportHeight;
            class82.intStack[++class56.intStackSize - 1] = Client.viewportWidth;
         } else {
            class82.intStack[++class56.intStackSize - 1] = -1;
            class82.intStack[++class56.intStackSize - 1] = -1;
         }

         return 1;
      } else if(var0 == 6204) {
         class82.intStack[++class56.intStackSize - 1] = Client.field1105;
         class82.intStack[++class56.intStackSize - 1] = Client.field1106;
         return 1;
      } else if(var0 == 6205) {
         class82.intStack[++class56.intStackSize - 1] = Client.field1103;
         class82.intStack[++class56.intStackSize - 1] = Client.field1104;
         return 1;
      } else {
         return 2;
      }
   }
}
