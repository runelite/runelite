import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fr")
public class class163 {
   @ObfuscatedName("a")
   static int[][] field2307;
   @ObfuscatedName("r")
   static int[][] field2310;
   @ObfuscatedName("b")
   static int[] field2306;
   @ObfuscatedName("k")
   static int[] field2312;

   static {
      field2307 = new int[128][128];
      field2310 = new int[128][128];
      field2306 = new int[4096];
      field2312 = new int[4096];
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZI)Ldc;",
      garbageValue = "309792936"
   )
   @Export("getPreferencesFile")
   public static FileOnDisk getPreferencesFile(String var0, String var1, boolean var2) {
      File var3 = new File(class46.field612, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            FileOnDisk var10 = new FileOnDisk(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(class39.field551 == 33) {
         var4 = "_rc";
      } else if(class39.field551 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(class156.userHome, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      FileOnDisk var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new FileOnDisk(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new FileOnDisk(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILck;ZB)I",
      garbageValue = "18"
   )
   static int method3143(int var0, Script var1, boolean var2) {
      if(var0 == 3300) {
         class82.intStack[++Ignore.intStackSize - 1] = Client.gameCycle;
         return 1;
      } else {
         int var3;
         int var4;
         int[] var5;
         int var6;
         int var7;
         ItemContainer var8;
         if(var0 == 3301) {
            Ignore.intStackSize -= 2;
            var3 = class82.intStack[Ignore.intStackSize];
            var4 = class82.intStack[Ignore.intStackSize + 1];
            var5 = class82.intStack;
            var6 = ++Ignore.intStackSize - 1;
            var8 = (ItemContainer)ItemContainer.itemContainers.get((long)var3);
            if(var8 == null) {
               var7 = -1;
            } else if(var4 >= 0 && var4 < var8.itemIds.length) {
               var7 = var8.itemIds[var4];
            } else {
               var7 = -1;
            }

            var5[var6] = var7;
            return 1;
         } else if(var0 == 3302) {
            Ignore.intStackSize -= 2;
            var3 = class82.intStack[Ignore.intStackSize];
            var4 = class82.intStack[Ignore.intStackSize + 1];
            class82.intStack[++Ignore.intStackSize - 1] = class17.method131(var3, var4);
            return 1;
         } else if(var0 == 3303) {
            Ignore.intStackSize -= 2;
            var3 = class82.intStack[Ignore.intStackSize];
            var4 = class82.intStack[Ignore.intStackSize + 1];
            class82.intStack[++Ignore.intStackSize - 1] = class88.method1715(var3, var4);
            return 1;
         } else {
            int var10;
            if(var0 == 3304) {
               var3 = class82.intStack[--Ignore.intStackSize];
               int[] var9 = class82.intStack;
               var10 = ++Ignore.intStackSize - 1;
               InvType var11 = (InvType)InvType.inventoryCache.get((long)var3);
               InvType var12;
               if(var11 != null) {
                  var12 = var11;
               } else {
                  byte[] var13 = InvType.field3284.getConfigData(5, var3);
                  var11 = new InvType();
                  if(var13 != null) {
                     var11.decode(new Buffer(var13));
                  }

                  InvType.inventoryCache.put(var11, (long)var3);
                  var12 = var11;
               }

               var9[var10] = var12.size;
               return 1;
            } else if(var0 == 3305) {
               var3 = class82.intStack[--Ignore.intStackSize];
               class82.intStack[++Ignore.intStackSize - 1] = Client.boostedSkillLevels[var3];
               return 1;
            } else if(var0 == 3306) {
               var3 = class82.intStack[--Ignore.intStackSize];
               class82.intStack[++Ignore.intStackSize - 1] = Client.realSkillLevels[var3];
               return 1;
            } else if(var0 == 3307) {
               var3 = class82.intStack[--Ignore.intStackSize];
               class82.intStack[++Ignore.intStackSize - 1] = Client.skillExperiences[var3];
               return 1;
            } else if(var0 == 3308) {
               var3 = class27.plane;
               var4 = (Player.localPlayer.x >> 7) + class149.baseX;
               var10 = (Player.localPlayer.y >> 7) + class67.baseY;
               class82.intStack[++Ignore.intStackSize - 1] = (var4 << 14) + var10 + (var3 << 28);
               return 1;
            } else if(var0 == 3309) {
               var3 = class82.intStack[--Ignore.intStackSize];
               class82.intStack[++Ignore.intStackSize - 1] = var3 >> 14 & 16383;
               return 1;
            } else if(var0 == 3310) {
               var3 = class82.intStack[--Ignore.intStackSize];
               class82.intStack[++Ignore.intStackSize - 1] = var3 >> 28;
               return 1;
            } else if(var0 == 3311) {
               var3 = class82.intStack[--Ignore.intStackSize];
               class82.intStack[++Ignore.intStackSize - 1] = var3 & 16383;
               return 1;
            } else if(var0 == 3312) {
               class82.intStack[++Ignore.intStackSize - 1] = Client.isMembers?1:0;
               return 1;
            } else if(var0 != 3313) {
               if(var0 == 3314) {
                  Ignore.intStackSize -= 2;
                  var3 = class82.intStack[Ignore.intStackSize] + '耀';
                  var4 = class82.intStack[Ignore.intStackSize + 1];
                  class82.intStack[++Ignore.intStackSize - 1] = class17.method131(var3, var4);
                  return 1;
               } else if(var0 == 3315) {
                  Ignore.intStackSize -= 2;
                  var3 = class82.intStack[Ignore.intStackSize] + '耀';
                  var4 = class82.intStack[Ignore.intStackSize + 1];
                  class82.intStack[++Ignore.intStackSize - 1] = class88.method1715(var3, var4);
                  return 1;
               } else if(var0 == 3316) {
                  if(Client.rights >= 2) {
                     class82.intStack[++Ignore.intStackSize - 1] = Client.rights;
                  } else {
                     class82.intStack[++Ignore.intStackSize - 1] = 0;
                  }

                  return 1;
               } else if(var0 == 3317) {
                  class82.intStack[++Ignore.intStackSize - 1] = Client.field1059;
                  return 1;
               } else if(var0 == 3318) {
                  class82.intStack[++Ignore.intStackSize - 1] = Client.world;
                  return 1;
               } else if(var0 == 3321) {
                  class82.intStack[++Ignore.intStackSize - 1] = Client.energy;
                  return 1;
               } else if(var0 == 3322) {
                  class82.intStack[++Ignore.intStackSize - 1] = Client.weight;
                  return 1;
               } else if(var0 == 3323) {
                  if(Client.field952) {
                     class82.intStack[++Ignore.intStackSize - 1] = 1;
                  } else {
                     class82.intStack[++Ignore.intStackSize - 1] = 0;
                  }

                  return 1;
               } else if(var0 == 3324) {
                  class82.intStack[++Ignore.intStackSize - 1] = Client.flags;
                  return 1;
               } else if(var0 == 3325) {
                  Ignore.intStackSize -= 4;
                  var3 = class82.intStack[Ignore.intStackSize];
                  var4 = class82.intStack[Ignore.intStackSize + 1];
                  var10 = class82.intStack[Ignore.intStackSize + 2];
                  var6 = class82.intStack[Ignore.intStackSize + 3];
                  var3 += var4 << 14;
                  var3 += var10 << 28;
                  var3 += var6;
                  class82.intStack[++Ignore.intStackSize - 1] = var3;
                  return 1;
               } else {
                  return 2;
               }
            } else {
               Ignore.intStackSize -= 2;
               var3 = class82.intStack[Ignore.intStackSize] + '耀';
               var4 = class82.intStack[Ignore.intStackSize + 1];
               var5 = class82.intStack;
               var6 = ++Ignore.intStackSize - 1;
               var8 = (ItemContainer)ItemContainer.itemContainers.get((long)var3);
               if(var8 == null) {
                  var7 = -1;
               } else if(var4 >= 0 && var4 < var8.itemIds.length) {
                  var7 = var8.itemIds[var4];
               } else {
                  var7 = -1;
               }

               var5[var6] = var7;
               return 1;
            }
         }
      }
   }
}
