import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("go")
@Implements("ISAACCipher")
public final class ISAACCipher {
   @ObfuscatedName("ju")
   @ObfuscatedGetter(
      intValue = -895670685
   )
   static int field2620;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1834693185
   )
   @Export("valuesRemaining")
   int valuesRemaining;
   @ObfuscatedName("n")
   @Export("randResult")
   int[] randResult;
   @ObfuscatedName("l")
   @Export("mm")
   int[] mm;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 88798231
   )
   int field2617;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -680056203
   )
   int field2618;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1260179201
   )
   int field2619;

   public ISAACCipher(int[] var1) {
      this.mm = new int[256];
      this.randResult = new int[256];

      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.randResult[var2] = var1[var2];
      }

      this.method3898();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-321160907"
   )
   @Export("nextInt")
   final int nextInt() {
      if(0 == --this.valuesRemaining + 1) {
         this.generateMoreResults();
         this.valuesRemaining = 255;
      }

      return this.randResult[this.valuesRemaining];
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1239147924"
   )
   final int method3897() {
      if(this.valuesRemaining == 0) {
         this.generateMoreResults();
         this.valuesRemaining = 256;
      }

      return this.randResult[this.valuesRemaining - 1];
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1547330581"
   )
   @Export("generateMoreResults")
   final void generateMoreResults() {
      this.field2618 += ++this.field2619;

      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = this.mm[var1];
         if((var1 & 2) == 0) {
            if((var1 & 1) == 0) {
               this.field2617 ^= this.field2617 << 13;
            } else {
               this.field2617 ^= this.field2617 >>> 6;
            }
         } else if((var1 & 1) == 0) {
            this.field2617 ^= this.field2617 << 2;
         } else {
            this.field2617 ^= this.field2617 >>> 16;
         }

         this.field2617 += this.mm[128 + var1 & 255];
         int var3;
         this.mm[var1] = var3 = this.mm[(var2 & 1020) >> 2] + this.field2618 + this.field2617;
         this.randResult[var1] = this.field2618 = this.mm[(var3 >> 8 & 1020) >> 2] + var2;
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2127799616"
   )
   final void method3898() {
      int var9 = -1640531527;
      int var8 = -1640531527;
      int var7 = -1640531527;
      int var6 = -1640531527;
      int var5 = -1640531527;
      int var4 = -1640531527;
      int var3 = -1640531527;
      int var2 = -1640531527;

      int var1;
      for(var1 = 0; var1 < 4; ++var1) {
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.randResult[var1];
         var3 += this.randResult[var1 + 1];
         var4 += this.randResult[var1 + 2];
         var5 += this.randResult[var1 + 3];
         var6 += this.randResult[var1 + 4];
         var7 += this.randResult[var1 + 5];
         var8 += this.randResult[var1 + 6];
         var9 += this.randResult[var1 + 7];
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
         this.mm[var1] = var2;
         this.mm[var1 + 1] = var3;
         this.mm[var1 + 2] = var4;
         this.mm[var1 + 3] = var5;
         this.mm[var1 + 4] = var6;
         this.mm[var1 + 5] = var7;
         this.mm[var1 + 6] = var8;
         this.mm[var1 + 7] = var9;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.mm[var1];
         var3 += this.mm[var1 + 1];
         var4 += this.mm[var1 + 2];
         var5 += this.mm[var1 + 3];
         var6 += this.mm[var1 + 4];
         var7 += this.mm[var1 + 5];
         var8 += this.mm[var1 + 6];
         var9 += this.mm[var1 + 7];
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
         this.mm[var1] = var2;
         this.mm[var1 + 1] = var3;
         this.mm[var1 + 2] = var4;
         this.mm[var1 + 3] = var5;
         this.mm[var1 + 4] = var6;
         this.mm[var1 + 5] = var7;
         this.mm[var1 + 6] = var8;
         this.mm[var1 + 7] = var9;
      }

      this.generateMoreResults();
      this.valuesRemaining = 256;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lgl;IB)V",
      garbageValue = "56"
   )
   @Export("decodeMovement")
   static void decodeMovement(PacketBuffer var0, int var1) {
      boolean var2 = var0.getBits(1) == 1;
      if(var2) {
         class93.field1413[++class93.field1414 - 1] = var1;
      }

      int var3 = var0.getBits(2);
      Player var4 = Client.cachedPlayers[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field840 = false;
         } else if(Client.localInteractingIndex == var1) {
            throw new RuntimeException();
         } else {
            class93.Players_regions[var1] = (var4.field831 << 28) + (MapIconReference.baseY + var4.pathY[0] >> 13) + (ClientPacket.baseX + var4.pathX[0] >> 13 << 14);
            if(var4.field1168 != -1) {
               class93.Players_orientations[var1] = var4.field1168;
            } else {
               class93.Players_orientations[var1] = var4.orientation;
            }

            class93.Players_targetIndices[var1] = var4.interacting;
            Client.cachedPlayers[var1] = null;
            if(var0.getBits(1) != 0) {
               Preferences.decodeRegionHash(var0, var1);
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
               var4.method1250(var6, var7);
               var4.field840 = false;
            } else if(var2) {
               var4.field840 = true;
               var4.field842 = var6;
               var4.field839 = var7;
            } else {
               var4.field840 = false;
               var4.method1216(var6, var7, class93.field1416[var1]);
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

            if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
               if(var2) {
                  var4.field840 = true;
                  var4.field842 = var6;
                  var4.field839 = var7;
               } else {
                  var4.field840 = false;
                  var4.method1216(var6, var7, class93.field1416[var1]);
               }
            } else {
               var4.method1250(var6, var7);
               var4.field840 = false;
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
                  var4.method1250(var10, var11);
                  var4.field840 = false;
               } else if(var2) {
                  var4.field840 = true;
                  var4.field842 = var10;
                  var4.field839 = var11;
               } else {
                  var4.field840 = false;
                  var4.method1216(var10, var11, class93.field1416[var1]);
               }

               var4.field831 = (byte)(var7 + var4.field831 & 3);
               if(Client.localInteractingIndex == var1) {
                  ScriptVarType.plane = var4.field831;
               }

            } else {
               var6 = var0.getBits(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var8 + ClientPacket.baseX + var4.pathX[0] & 16383) - ClientPacket.baseX;
               var11 = (var9 + MapIconReference.baseY + var4.pathY[0] & 16383) - MapIconReference.baseY;
               if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
                  var4.method1250(var10, var11);
                  var4.field840 = false;
               } else if(var2) {
                  var4.field840 = true;
                  var4.field842 = var10;
                  var4.field839 = var11;
               } else {
                  var4.field840 = false;
                  var4.method1216(var10, var11, class93.field1416[var1]);
               }

               var4.field831 = (byte)(var7 + var4.field831 & 3);
               if(Client.localInteractingIndex == var1) {
                  ScriptVarType.plane = var4.field831;
               }

            }
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(ILjr;IIIZI)V",
      garbageValue = "-791499752"
   )
   public static void method3902(int var0, IndexDataBase var1, int var2, int var3, int var4, boolean var5) {
      class229.field2694 = 1;
      class132.field1905 = var1;
      class321.field3940 = var2;
      class132.field1897 = var3;
      AttackOption.field1334 = var4;
      Signlink.field2193 = var5;
      class20.field335 = var0;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(ILcr;ZI)I",
      garbageValue = "1003521875"
   )
   static int method3895(int var0, Script var1, boolean var2) {
      if(var0 == 6500) {
         class81.intStack[++class171.intStackSize - 1] = MouseRecorder.loadWorlds()?1:0;
         return 1;
      } else {
         World var4;
         if(var0 == 6501) {
            World.field1211 = 0;
            if(World.field1211 < World.worldCount) {
               var4 = class171.worldList[++World.field1211 - 1];
            } else {
               var4 = null;
            }

            if(var4 != null) {
               class81.intStack[++class171.intStackSize - 1] = var4.id;
               class81.intStack[++class171.intStackSize - 1] = var4.mask;
               class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var4.activity;
               class81.intStack[++class171.intStackSize - 1] = var4.location;
               class81.intStack[++class171.intStackSize - 1] = var4.playerCount;
               class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var4.address;
            } else {
               class81.intStack[++class171.intStackSize - 1] = -1;
               class81.intStack[++class171.intStackSize - 1] = 0;
               class81.scriptStringStack[++class81.scriptStringStackSize - 1] = "";
               class81.intStack[++class171.intStackSize - 1] = 0;
               class81.intStack[++class171.intStackSize - 1] = 0;
               class81.scriptStringStack[++class81.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 6502) {
            World var3;
            if(World.field1211 < World.worldCount) {
               var3 = class171.worldList[++World.field1211 - 1];
            } else {
               var3 = null;
            }

            if(var3 != null) {
               class81.intStack[++class171.intStackSize - 1] = var3.id;
               class81.intStack[++class171.intStackSize - 1] = var3.mask;
               class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var3.activity;
               class81.intStack[++class171.intStackSize - 1] = var3.location;
               class81.intStack[++class171.intStackSize - 1] = var3.playerCount;
               class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var3.address;
            } else {
               class81.intStack[++class171.intStackSize - 1] = -1;
               class81.intStack[++class171.intStackSize - 1] = 0;
               class81.scriptStringStack[++class81.scriptStringStackSize - 1] = "";
               class81.intStack[++class171.intStackSize - 1] = 0;
               class81.intStack[++class171.intStackSize - 1] = 0;
               class81.scriptStringStack[++class81.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else {
            int var5;
            int var7;
            if(var0 == 6506) {
               var7 = class81.intStack[--class171.intStackSize];
               var4 = null;

               for(var5 = 0; var5 < World.worldCount; ++var5) {
                  if(var7 == class171.worldList[var5].id) {
                     var4 = class171.worldList[var5];
                     break;
                  }
               }

               if(var4 != null) {
                  class81.intStack[++class171.intStackSize - 1] = var4.id;
                  class81.intStack[++class171.intStackSize - 1] = var4.mask;
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var4.activity;
                  class81.intStack[++class171.intStackSize - 1] = var4.location;
                  class81.intStack[++class171.intStackSize - 1] = var4.playerCount;
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var4.address;
               } else {
                  class81.intStack[++class171.intStackSize - 1] = -1;
                  class81.intStack[++class171.intStackSize - 1] = 0;
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = "";
                  class81.intStack[++class171.intStackSize - 1] = 0;
                  class81.intStack[++class171.intStackSize - 1] = 0;
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 6507) {
               class171.intStackSize -= 4;
               var7 = class81.intStack[class171.intStackSize];
               boolean var10 = class81.intStack[class171.intStackSize + 1] == 1;
               var5 = class81.intStack[class171.intStackSize + 2];
               boolean var6 = class81.intStack[class171.intStackSize + 3] == 1;
               if(class171.worldList != null) {
                  class33.method366(0, class171.worldList.length - 1, var7, var10, var5, var6);
               }

               return 1;
            } else if(var0 != 6511) {
               if(var0 == 6512) {
                  Client.field1111 = class81.intStack[--class171.intStackSize] == 1;
                  return 1;
               } else {
                  int var8;
                  class278 var9;
                  if(var0 == 6513) {
                     class171.intStackSize -= 2;
                     var7 = class81.intStack[class171.intStackSize];
                     var8 = class81.intStack[class171.intStackSize + 1];
                     var9 = class253.method4619(var8);
                     if(var9.method4993()) {
                        class81.scriptStringStack[++class81.scriptStringStackSize - 1] = SceneTilePaint.getNpcDefinition(var7).method5196(var8, var9.field3548);
                     } else {
                        class81.intStack[++class171.intStackSize - 1] = SceneTilePaint.getNpcDefinition(var7).method5195(var8, var9.field3546);
                     }

                     return 1;
                  } else if(var0 == 6514) {
                     class171.intStackSize -= 2;
                     var7 = class81.intStack[class171.intStackSize];
                     var8 = class81.intStack[class171.intStackSize + 1];
                     var9 = class253.method4619(var8);
                     if(var9.method4993()) {
                        class81.scriptStringStack[++class81.scriptStringStackSize - 1] = class80.getObjectDefinition(var7).method5091(var8, var9.field3548);
                     } else {
                        class81.intStack[++class171.intStackSize - 1] = class80.getObjectDefinition(var7).method5090(var8, var9.field3546);
                     }

                     return 1;
                  } else if(var0 == 6515) {
                     class171.intStackSize -= 2;
                     var7 = class81.intStack[class171.intStackSize];
                     var8 = class81.intStack[class171.intStackSize + 1];
                     var9 = class253.method4619(var8);
                     if(var9.method4993()) {
                        class81.scriptStringStack[++class81.scriptStringStackSize - 1] = NetWriter.getItemDefinition(var7).method5141(var8, var9.field3548);
                     } else {
                        class81.intStack[++class171.intStackSize - 1] = NetWriter.getItemDefinition(var7).method5140(var8, var9.field3546);
                     }

                     return 1;
                  } else if(var0 == 6516) {
                     class171.intStackSize -= 2;
                     var7 = class81.intStack[class171.intStackSize];
                     var8 = class81.intStack[class171.intStackSize + 1];
                     var9 = class253.method4619(var8);
                     if(var9.method4993()) {
                        class81.scriptStringStack[++class81.scriptStringStackSize - 1] = UrlRequest.method3173(var7).method5010(var8, var9.field3548);
                     } else {
                        class81.intStack[++class171.intStackSize - 1] = UrlRequest.method3173(var7).method5011(var8, var9.field3546);
                     }

                     return 1;
                  } else if(var0 == 6518) {
                     class81.intStack[++class171.intStackSize - 1] = Client.field859?1:0;
                     return 1;
                  } else if(var0 == 6520) {
                     return 1;
                  } else if(var0 == 6521) {
                     return 1;
                  } else if(var0 == 6522) {
                     --class81.scriptStringStackSize;
                     --class171.intStackSize;
                     return 1;
                  } else if(var0 == 6523) {
                     --class81.scriptStringStackSize;
                     --class171.intStackSize;
                     return 1;
                  } else {
                     return 2;
                  }
               }
            } else {
               var7 = class81.intStack[--class171.intStackSize];
               if(var7 >= 0 && var7 < World.worldCount) {
                  var4 = class171.worldList[var7];
                  class81.intStack[++class171.intStackSize - 1] = var4.id;
                  class81.intStack[++class171.intStackSize - 1] = var4.mask;
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var4.activity;
                  class81.intStack[++class171.intStackSize - 1] = var4.location;
                  class81.intStack[++class171.intStackSize - 1] = var4.playerCount;
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var4.address;
               } else {
                  class81.intStack[++class171.intStackSize - 1] = -1;
                  class81.intStack[++class171.intStackSize - 1] = 0;
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = "";
                  class81.intStack[++class171.intStackSize - 1] = 0;
                  class81.intStack[++class171.intStackSize - 1] = 0;
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = "";
               }

               return 1;
            }
         }
      }
   }

   @ObfuscatedName("ka")
   @ObfuscatedSignature(
      signature = "([BII)V",
      garbageValue = "1897611403"
   )
   static void method3908(byte[] var0, int var1) {
      if(Client.field1071 == null) {
         Client.field1071 = new byte[24];
      }

      class205.method3924(var0, var1, Client.field1071, 0, 24);
   }
}
