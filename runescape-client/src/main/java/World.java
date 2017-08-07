import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
@Implements("World")
public class World {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -824414041
   )
   @Export("worldCount")
   static int worldCount;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 741538481
   )
   static int field1277;
   @ObfuscatedName("z")
   static int[] field1291;
   @ObfuscatedName("r")
   static int[] field1281;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lcu;"
   )
   @Export("listFetcher")
   static class83 listFetcher;
   @ObfuscatedName("co")
   public static char field1292;
   @ObfuscatedName("dj")
   @ObfuscatedGetter(
      intValue = -1707488227
   )
   static int field1282;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 799113253
   )
   @Export("mask")
   int mask;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1047210027
   )
   @Export("index")
   int index;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -784945215
   )
   @Export("playerCount")
   int playerCount;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1579155663
   )
   @Export("id")
   int id;
   @ObfuscatedName("h")
   @Export("address")
   String address;
   @ObfuscatedName("s")
   @Export("activity")
   String activity;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1942965417
   )
   @Export("location")
   int location;

   static {
      worldCount = 0;
      field1277 = 0;
      field1291 = new int[]{1, 1, 1, 1};
      field1281 = new int[]{0, 1, 2, 3};
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "-30658"
   )
   boolean method1550() {
      return (1 & this.mask) != 0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "0"
   )
   boolean method1555() {
      return (33554432 & this.mask) != 0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1921283523"
   )
   boolean method1554() {
      return (536870912 & this.mask) != 0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-109"
   )
   boolean method1552() {
      return (4 & this.mask) != 0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1765493796"
   )
   boolean method1553() {
      return (8 & this.mask) != 0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "771721477"
   )
   boolean method1582() {
      return (2 & this.mask) != 0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;Ljava/io/File;B)V",
      garbageValue = "10"
   )
   static void method1593(File var0, File var1) {
      try {
         FileOnDisk var2 = new FileOnDisk(class156.field2228, "rw", 10000L);
         Buffer var3 = new Buffer(500);
         var3.putByte(3);
         var3.putByte(var1 != null?1:0);
         var3.putCESU8(var0.getPath());
         if(var1 != null) {
            var3.putCESU8("");
         }

         var2.write(var3.payload, 0, var3.offset);
         var2.close();
      } catch (IOException var4) {
         var4.printStackTrace();
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILcc;ZB)I",
      garbageValue = "-90"
   )
   static int method1595(int var0, Script var1, boolean var2) {
      if(var0 == 3300) {
         class84.intStack[++class84.intStackSize - 1] = Client.gameCycle;
         return 1;
      } else {
         int var3;
         int var4;
         int[] var5;
         int var6;
         int var7;
         XItemContainer var8;
         if(var0 == 3301) {
            class84.intStackSize -= 2;
            var3 = class84.intStack[class84.intStackSize];
            var4 = class84.intStack[class84.intStackSize + 1];
            var5 = class84.intStack;
            var6 = ++class84.intStackSize - 1;
            var8 = (XItemContainer)XItemContainer.itemContainers.get((long)var3);
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
            class84.intStackSize -= 2;
            var3 = class84.intStack[class84.intStackSize];
            var4 = class84.intStack[class84.intStackSize + 1];
            class84.intStack[++class84.intStackSize - 1] = SceneTilePaint.method2708(var3, var4);
            return 1;
         } else {
            int var9;
            int var10;
            if(var0 == 3303) {
               class84.intStackSize -= 2;
               var3 = class84.intStack[class84.intStackSize];
               var4 = class84.intStack[class84.intStackSize + 1];
               var5 = class84.intStack;
               var6 = ++class84.intStackSize - 1;
               var8 = (XItemContainer)XItemContainer.itemContainers.get((long)var3);
               if(var8 == null) {
                  var7 = 0;
               } else if(var4 == -1) {
                  var7 = 0;
               } else {
                  var9 = 0;

                  for(var10 = 0; var10 < var8.stackSizes.length; ++var10) {
                     if(var4 == var8.itemIds[var10]) {
                        var9 += var8.stackSizes[var10];
                     }
                  }

                  var7 = var9;
               }

               var5[var6] = var7;
               return 1;
            } else {
               int var12;
               if(var0 == 3304) {
                  var3 = class84.intStack[--class84.intStackSize];
                  int[] var11 = class84.intStack;
                  var12 = ++class84.intStackSize - 1;
                  InvType var13 = (InvType)InvType.inventoryCache.get((long)var3);
                  InvType var14;
                  if(var13 != null) {
                     var14 = var13;
                  } else {
                     byte[] var15 = InvType.field3265.getConfigData(5, var3);
                     var13 = new InvType();
                     if(var15 != null) {
                        var13.decode(new Buffer(var15));
                     }

                     InvType.inventoryCache.put(var13, (long)var3);
                     var14 = var13;
                  }

                  var11[var12] = var14.size;
                  return 1;
               } else if(var0 == 3305) {
                  var3 = class84.intStack[--class84.intStackSize];
                  class84.intStack[++class84.intStackSize - 1] = Client.boostedSkillLevels[var3];
                  return 1;
               } else if(var0 == 3306) {
                  var3 = class84.intStack[--class84.intStackSize];
                  class84.intStack[++class84.intStackSize - 1] = Client.realSkillLevels[var3];
                  return 1;
               } else if(var0 == 3307) {
                  var3 = class84.intStack[--class84.intStackSize];
                  class84.intStack[++class84.intStackSize - 1] = Client.skillExperiences[var3];
                  return 1;
               } else if(var0 == 3308) {
                  var3 = class29.plane;
                  var4 = (class54.localPlayer.x >> 7) + class25.baseX;
                  var12 = (class54.localPlayer.y >> 7) + ScriptEvent.baseY;
                  class84.intStack[++class84.intStackSize - 1] = (var4 << 14) + var12 + (var3 << 28);
                  return 1;
               } else if(var0 == 3309) {
                  var3 = class84.intStack[--class84.intStackSize];
                  class84.intStack[++class84.intStackSize - 1] = var3 >> 14 & 16383;
                  return 1;
               } else if(var0 == 3310) {
                  var3 = class84.intStack[--class84.intStackSize];
                  class84.intStack[++class84.intStackSize - 1] = var3 >> 28;
                  return 1;
               } else if(var0 == 3311) {
                  var3 = class84.intStack[--class84.intStackSize];
                  class84.intStack[++class84.intStackSize - 1] = var3 & 16383;
                  return 1;
               } else if(var0 == 3312) {
                  class84.intStack[++class84.intStackSize - 1] = Client.isMembers?1:0;
                  return 1;
               } else if(var0 == 3313) {
                  class84.intStackSize -= 2;
                  var3 = class84.intStack[class84.intStackSize] + '耀';
                  var4 = class84.intStack[class84.intStackSize + 1];
                  var5 = class84.intStack;
                  var6 = ++class84.intStackSize - 1;
                  var8 = (XItemContainer)XItemContainer.itemContainers.get((long)var3);
                  if(var8 == null) {
                     var7 = -1;
                  } else if(var4 >= 0 && var4 < var8.itemIds.length) {
                     var7 = var8.itemIds[var4];
                  } else {
                     var7 = -1;
                  }

                  var5[var6] = var7;
                  return 1;
               } else if(var0 == 3314) {
                  class84.intStackSize -= 2;
                  var3 = class84.intStack[class84.intStackSize] + '耀';
                  var4 = class84.intStack[class84.intStackSize + 1];
                  class84.intStack[++class84.intStackSize - 1] = SceneTilePaint.method2708(var3, var4);
                  return 1;
               } else if(var0 != 3315) {
                  if(var0 == 3316) {
                     if(Client.rights >= 2) {
                        class84.intStack[++class84.intStackSize - 1] = Client.rights;
                     } else {
                        class84.intStack[++class84.intStackSize - 1] = 0;
                     }

                     return 1;
                  } else if(var0 == 3317) {
                     class84.intStack[++class84.intStackSize - 1] = Client.field931;
                     return 1;
                  } else if(var0 == 3318) {
                     class84.intStack[++class84.intStackSize - 1] = Client.world;
                     return 1;
                  } else if(var0 == 3321) {
                     class84.intStack[++class84.intStackSize - 1] = Client.energy;
                     return 1;
                  } else if(var0 == 3322) {
                     class84.intStack[++class84.intStackSize - 1] = Client.weight;
                     return 1;
                  } else if(var0 == 3323) {
                     if(Client.field1071) {
                        class84.intStack[++class84.intStackSize - 1] = 1;
                     } else {
                        class84.intStack[++class84.intStackSize - 1] = 0;
                     }

                     return 1;
                  } else if(var0 == 3324) {
                     class84.intStack[++class84.intStackSize - 1] = Client.flags;
                     return 1;
                  } else if(var0 == 3325) {
                     class84.intStackSize -= 4;
                     var3 = class84.intStack[class84.intStackSize];
                     var4 = class84.intStack[class84.intStackSize + 1];
                     var12 = class84.intStack[class84.intStackSize + 2];
                     var6 = class84.intStack[class84.intStackSize + 3];
                     var3 += var4 << 14;
                     var3 += var12 << 28;
                     var3 += var6;
                     class84.intStack[++class84.intStackSize - 1] = var3;
                     return 1;
                  } else {
                     return 2;
                  }
               } else {
                  class84.intStackSize -= 2;
                  var3 = class84.intStack[class84.intStackSize] + '耀';
                  var4 = class84.intStack[class84.intStackSize + 1];
                  var5 = class84.intStack;
                  var6 = ++class84.intStackSize - 1;
                  var8 = (XItemContainer)XItemContainer.itemContainers.get((long)var3);
                  if(var8 == null) {
                     var7 = 0;
                  } else if(var4 == -1) {
                     var7 = 0;
                  } else {
                     var9 = 0;

                     for(var10 = 0; var10 < var8.stackSizes.length; ++var10) {
                        if(var4 == var8.itemIds[var10]) {
                           var9 += var8.stackSizes[var10];
                        }
                     }

                     var7 = var9;
                  }

                  var5[var6] = var7;
                  return 1;
               }
            }
         }
      }
   }
}
