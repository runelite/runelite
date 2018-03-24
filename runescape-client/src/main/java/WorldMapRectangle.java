import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
@Implements("WorldMapRectangle")
public final class WorldMapRectangle {
   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "Lju;"
   )
   @Export("indexCache4")
   static IndexData indexCache4;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1665657935
   )
   @Export("worldMapRegionWidth")
   int worldMapRegionWidth;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1530669957
   )
   @Export("worldMapRegionHeight")
   int worldMapRegionHeight;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1379484405
   )
   @Export("worldMapRegionX")
   int worldMapRegionX;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -700497625
   )
   @Export("worldMapRegionY")
   int worldMapRegionY;
   // $FF: synthetic field
   @ObfuscatedSignature(
      signature = "Lag;"
   )
   final WorldMapManager this$0;

   @ObfuscatedSignature(
      signature = "(Lag;)V"
   )
   WorldMapRectangle(WorldMapManager var1) {
      this.this$0 = var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([Lgl;II)Lgl;",
      garbageValue = "-1861817750"
   )
   @Export("forOrdinal")
   public static Enumerated forOrdinal(Enumerated[] var0, int var1) {
      Enumerated[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         Enumerated var4 = var2[var3];
         if(var1 == var4.rsOrdinal()) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IB)I",
      garbageValue = "48"
   )
   public static int method255(CharSequence var0, CharSequence var1, int var2) {
      int var3 = var0.length();
      int var4 = var1.length();
      int var5 = 0;
      int var6 = 0;
      char var7 = 0;
      char var8 = 0;

      while(var5 - var7 < var3 || var6 - var8 < var4) {
         if(var5 - var7 >= var3) {
            return -1;
         }

         if(var6 - var8 >= var4) {
            return 1;
         }

         char var9;
         if(var7 != 0) {
            var9 = var7;
            boolean var14 = false;
         } else {
            var9 = var0.charAt(var5++);
         }

         char var10;
         if(var8 != 0) {
            var10 = var8;
            boolean var15 = false;
         } else {
            var10 = var1.charAt(var6++);
         }

         var7 = ScriptState.method1125(var9);
         var8 = ScriptState.method1125(var10);
         var9 = MilliTimer.method3187(var9, var2);
         var10 = MilliTimer.method3187(var10, var2);
         if(var10 != var9 && Character.toUpperCase(var9) != Character.toUpperCase(var10)) {
            var9 = Character.toLowerCase(var9);
            var10 = Character.toLowerCase(var10);
            if(var10 != var9) {
               return Signlink.method3237(var9, var2) - Signlink.method3237(var10, var2);
            }
         }
      }

      int var16 = Math.min(var3, var4);

      char var12;
      int var17;
      for(var17 = 0; var17 < var16; ++var17) {
         char var11 = var0.charAt(var17);
         var12 = var1.charAt(var17);
         if(var11 != var12 && Character.toUpperCase(var11) != Character.toUpperCase(var12)) {
            var11 = Character.toLowerCase(var11);
            var12 = Character.toLowerCase(var12);
            if(var11 != var12) {
               return Signlink.method3237(var11, var2) - Signlink.method3237(var12, var2);
            }
         }
      }

      var17 = var3 - var4;
      if(var17 != 0) {
         return var17;
      } else {
         for(int var18 = 0; var18 < var16; ++var18) {
            var12 = var0.charAt(var18);
            char var13 = var1.charAt(var18);
            if(var12 != var13) {
               return Signlink.method3237(var12, var2) - Signlink.method3237(var13, var2);
            }
         }

         return 0;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ILcj;ZI)I",
      garbageValue = "181930329"
   )
   static int method254(int var0, Script var1, boolean var2) {
      if(var0 == 6500) {
         class81.intStack[++class5.intStackSize - 1] = class155.loadWorlds()?1:0;
         return 1;
      } else {
         World var3;
         if(var0 == 6501) {
            World.field1211 = 0;
            var3 = CombatInfoListHolder.method1879();
            if(var3 != null) {
               class81.intStack[++class5.intStackSize - 1] = var3.id;
               class81.intStack[++class5.intStackSize - 1] = var3.mask;
               class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var3.activity;
               class81.intStack[++class5.intStackSize - 1] = var3.location;
               class81.intStack[++class5.intStackSize - 1] = var3.playerCount;
               class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var3.address;
            } else {
               class81.intStack[++class5.intStackSize - 1] = -1;
               class81.intStack[++class5.intStackSize - 1] = 0;
               class81.scriptStringStack[++class316.scriptStringStackSize - 1] = "";
               class81.intStack[++class5.intStackSize - 1] = 0;
               class81.intStack[++class5.intStackSize - 1] = 0;
               class81.scriptStringStack[++class316.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 6502) {
            var3 = CombatInfoListHolder.method1879();
            if(var3 != null) {
               class81.intStack[++class5.intStackSize - 1] = var3.id;
               class81.intStack[++class5.intStackSize - 1] = var3.mask;
               class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var3.activity;
               class81.intStack[++class5.intStackSize - 1] = var3.location;
               class81.intStack[++class5.intStackSize - 1] = var3.playerCount;
               class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var3.address;
            } else {
               class81.intStack[++class5.intStackSize - 1] = -1;
               class81.intStack[++class5.intStackSize - 1] = 0;
               class81.scriptStringStack[++class316.scriptStringStackSize - 1] = "";
               class81.intStack[++class5.intStackSize - 1] = 0;
               class81.intStack[++class5.intStackSize - 1] = 0;
               class81.scriptStringStack[++class316.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else {
            World var4;
            int var5;
            int var7;
            if(var0 == 6506) {
               var7 = class81.intStack[--class5.intStackSize];
               var4 = null;

               for(var5 = 0; var5 < World.worldCount; ++var5) {
                  if(var7 == World.worldList[var5].id) {
                     var4 = World.worldList[var5];
                     break;
                  }
               }

               if(var4 != null) {
                  class81.intStack[++class5.intStackSize - 1] = var4.id;
                  class81.intStack[++class5.intStackSize - 1] = var4.mask;
                  class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var4.activity;
                  class81.intStack[++class5.intStackSize - 1] = var4.location;
                  class81.intStack[++class5.intStackSize - 1] = var4.playerCount;
                  class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var4.address;
               } else {
                  class81.intStack[++class5.intStackSize - 1] = -1;
                  class81.intStack[++class5.intStackSize - 1] = 0;
                  class81.scriptStringStack[++class316.scriptStringStackSize - 1] = "";
                  class81.intStack[++class5.intStackSize - 1] = 0;
                  class81.intStack[++class5.intStackSize - 1] = 0;
                  class81.scriptStringStack[++class316.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 6507) {
               class5.intStackSize -= 4;
               var7 = class81.intStack[class5.intStackSize];
               boolean var10 = class81.intStack[class5.intStackSize + 1] == 1;
               var5 = class81.intStack[class5.intStackSize + 2];
               boolean var6 = class81.intStack[class5.intStackSize + 3] == 1;
               GrandExchangeOffer.method117(var7, var10, var5, var6);
               return 1;
            } else if(var0 != 6511) {
               if(var0 == 6512) {
                  Client.field993 = class81.intStack[--class5.intStackSize] == 1;
                  return 1;
               } else {
                  int var8;
                  class278 var9;
                  if(var0 == 6513) {
                     class5.intStackSize -= 2;
                     var7 = class81.intStack[class5.intStackSize];
                     var8 = class81.intStack[class5.intStackSize + 1];
                     var9 = class88.method1916(var8);
                     if(var9.method4889()) {
                        class81.scriptStringStack[++class316.scriptStringStackSize - 1] = class233.getNpcDefinition(var7).method5117(var8, var9.field3547);
                     } else {
                        class81.intStack[++class5.intStackSize - 1] = class233.getNpcDefinition(var7).method5116(var8, var9.field3550);
                     }

                     return 1;
                  } else if(var0 == 6514) {
                     class5.intStackSize -= 2;
                     var7 = class81.intStack[class5.intStackSize];
                     var8 = class81.intStack[class5.intStackSize + 1];
                     var9 = class88.method1916(var8);
                     if(var9.method4889()) {
                        class81.scriptStringStack[++class316.scriptStringStackSize - 1] = Spotanim.getObjectDefinition(var7).method4991(var8, var9.field3547);
                     } else {
                        class81.intStack[++class5.intStackSize - 1] = Spotanim.getObjectDefinition(var7).method4998(var8, var9.field3550);
                     }

                     return 1;
                  } else if(var0 == 6515) {
                     class5.intStackSize -= 2;
                     var7 = class81.intStack[class5.intStackSize];
                     var8 = class81.intStack[class5.intStackSize + 1];
                     var9 = class88.method1916(var8);
                     if(var9.method4889()) {
                        class81.scriptStringStack[++class316.scriptStringStackSize - 1] = class81.getItemDefinition(var7).method5052(var8, var9.field3547);
                     } else {
                        class81.intStack[++class5.intStackSize - 1] = class81.getItemDefinition(var7).method5051(var8, var9.field3550);
                     }

                     return 1;
                  } else if(var0 == 6516) {
                     class5.intStackSize -= 2;
                     var7 = class81.intStack[class5.intStackSize];
                     var8 = class81.intStack[class5.intStackSize + 1];
                     var9 = class88.method1916(var8);
                     if(var9.method4889()) {
                        class81.scriptStringStack[++class316.scriptStringStackSize - 1] = CombatInfo1.method1671(var7).method4910(var8, var9.field3547);
                     } else {
                        class81.intStack[++class5.intStackSize - 1] = CombatInfo1.method1671(var7).method4908(var8, var9.field3550);
                     }

                     return 1;
                  } else if(var0 == 6518) {
                     class81.intStack[++class5.intStackSize - 1] = 0;
                     return 1;
                  } else {
                     return var0 == 6520?1:(var0 == 6521?1:2);
                  }
               }
            } else {
               var7 = class81.intStack[--class5.intStackSize];
               if(var7 >= 0 && var7 < World.worldCount) {
                  var4 = World.worldList[var7];
                  class81.intStack[++class5.intStackSize - 1] = var4.id;
                  class81.intStack[++class5.intStackSize - 1] = var4.mask;
                  class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var4.activity;
                  class81.intStack[++class5.intStackSize - 1] = var4.location;
                  class81.intStack[++class5.intStackSize - 1] = var4.playerCount;
                  class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var4.address;
               } else {
                  class81.intStack[++class5.intStackSize - 1] = -1;
                  class81.intStack[++class5.intStackSize - 1] = 0;
                  class81.scriptStringStack[++class316.scriptStringStackSize - 1] = "";
                  class81.intStack[++class5.intStackSize - 1] = 0;
                  class81.intStack[++class5.intStackSize - 1] = 0;
                  class81.scriptStringStack[++class316.scriptStringStackSize - 1] = "";
               }

               return 1;
            }
         }
      }
   }
}
