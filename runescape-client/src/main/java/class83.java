import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cv")
public class class83 {
   @ObfuscatedName("y")
   static Calendar field1340;
   @ObfuscatedName("j")
   @Export("scriptLocalStrings")
   static String[] scriptLocalStrings;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -545984461
   )
   static int field1344;
   @ObfuscatedName("m")
   static int[][] field1345;
   @ObfuscatedName("c")
   @Export("intStack")
   static int[] intStack;
   @ObfuscatedName("h")
   @Export("scriptStringStack")
   static String[] scriptStringStack;
   @ObfuscatedName("i")
   @Export("scriptLocalInts")
   static int[] scriptLocalInts;
   @ObfuscatedName("o")
   @Export("scriptStack")
   static ScriptState[] scriptStack;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1842378179
   )
   @Export("scriptStackCount")
   static int scriptStackCount;
   @ObfuscatedName("r")
   static final String[] field1351;
   @ObfuscatedName("b")
   static class47 field1352;
   @ObfuscatedName("f")
   static int[] field1353;
   @ObfuscatedName("ko")
   static Widget field1354;
   @ObfuscatedName("x")
   public static boolean field1355;

   static {
      field1353 = new int[5];
      field1345 = new int[5][5000];
      intStack = new int[1000];
      scriptStringStack = new String[1000];
      scriptStackCount = 0;
      scriptStack = new ScriptState[50];
      field1340 = Calendar.getInstance();
      field1351 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
      field1344 = 0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "446504761"
   )
   static int method1624(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if(var0 == 4000) {
         class165.intStackSize -= 2;
         var3 = intStack[class165.intStackSize];
         var4 = intStack[class165.intStackSize + 1];
         intStack[++class165.intStackSize - 1] = var4 + var3;
         return 1;
      } else if(var0 == 4001) {
         class165.intStackSize -= 2;
         var3 = intStack[class165.intStackSize];
         var4 = intStack[class165.intStackSize + 1];
         intStack[++class165.intStackSize - 1] = var3 - var4;
         return 1;
      } else if(var0 == 4002) {
         class165.intStackSize -= 2;
         var3 = intStack[class165.intStackSize];
         var4 = intStack[class165.intStackSize + 1];
         intStack[++class165.intStackSize - 1] = var3 * var4;
         return 1;
      } else if(var0 == 4003) {
         class165.intStackSize -= 2;
         var3 = intStack[class165.intStackSize];
         var4 = intStack[class165.intStackSize + 1];
         intStack[++class165.intStackSize - 1] = var3 / var4;
         return 1;
      } else if(var0 == 4004) {
         var3 = intStack[--class165.intStackSize];
         intStack[++class165.intStackSize - 1] = (int)(Math.random() * (double)var3);
         return 1;
      } else if(var0 == 4005) {
         var3 = intStack[--class165.intStackSize];
         intStack[++class165.intStackSize - 1] = (int)(Math.random() * (double)(var3 + 1));
         return 1;
      } else if(var0 == 4006) {
         class165.intStackSize -= 5;
         var3 = intStack[class165.intStackSize];
         var4 = intStack[class165.intStackSize + 1];
         int var5 = intStack[class165.intStackSize + 2];
         int var6 = intStack[class165.intStackSize + 3];
         int var7 = intStack[class165.intStackSize + 4];
         intStack[++class165.intStackSize - 1] = (var7 - var5) * (var4 - var3) / (var6 - var5) + var3;
         return 1;
      } else if(var0 == 4007) {
         class165.intStackSize -= 2;
         var3 = intStack[class165.intStackSize];
         var4 = intStack[class165.intStackSize + 1];
         intStack[++class165.intStackSize - 1] = var4 * var3 / 100 + var3;
         return 1;
      } else if(var0 == 4008) {
         class165.intStackSize -= 2;
         var3 = intStack[class165.intStackSize];
         var4 = intStack[class165.intStackSize + 1];
         intStack[++class165.intStackSize - 1] = var3 | 1 << var4;
         return 1;
      } else if(var0 == 4009) {
         class165.intStackSize -= 2;
         var3 = intStack[class165.intStackSize];
         var4 = intStack[class165.intStackSize + 1];
         intStack[++class165.intStackSize - 1] = var3 & -1 - (1 << var4);
         return 1;
      } else if(var0 == 4010) {
         class165.intStackSize -= 2;
         var3 = intStack[class165.intStackSize];
         var4 = intStack[class165.intStackSize + 1];
         intStack[++class165.intStackSize - 1] = (var3 & 1 << var4) != 0?1:0;
         return 1;
      } else if(var0 == 4011) {
         class165.intStackSize -= 2;
         var3 = intStack[class165.intStackSize];
         var4 = intStack[class165.intStackSize + 1];
         intStack[++class165.intStackSize - 1] = var3 % var4;
         return 1;
      } else if(var0 == 4012) {
         class165.intStackSize -= 2;
         var3 = intStack[class165.intStackSize];
         var4 = intStack[class165.intStackSize + 1];
         if(var3 == 0) {
            intStack[++class165.intStackSize - 1] = 0;
         } else {
            intStack[++class165.intStackSize - 1] = (int)Math.pow((double)var3, (double)var4);
         }

         return 1;
      } else if(var0 == 4013) {
         class165.intStackSize -= 2;
         var3 = intStack[class165.intStackSize];
         var4 = intStack[class165.intStackSize + 1];
         if(var3 == 0) {
            intStack[++class165.intStackSize - 1] = 0;
         } else if(var4 == 0) {
            intStack[++class165.intStackSize - 1] = Integer.MAX_VALUE;
         } else {
            intStack[++class165.intStackSize - 1] = (int)Math.pow((double)var3, 1.0D / (double)var4);
         }

         return 1;
      } else if(var0 == 4014) {
         class165.intStackSize -= 2;
         var3 = intStack[class165.intStackSize];
         var4 = intStack[class165.intStackSize + 1];
         intStack[++class165.intStackSize - 1] = var3 & var4;
         return 1;
      } else if(var0 == 4015) {
         class165.intStackSize -= 2;
         var3 = intStack[class165.intStackSize];
         var4 = intStack[class165.intStackSize + 1];
         intStack[++class165.intStackSize - 1] = var3 | var4;
         return 1;
      } else if(var0 == 4018) {
         class165.intStackSize -= 3;
         long var11 = (long)intStack[class165.intStackSize];
         long var13 = (long)intStack[class165.intStackSize + 1];
         long var9 = (long)intStack[class165.intStackSize + 2];
         intStack[++class165.intStackSize - 1] = (int)(var11 * var9 / var13);
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("fz")
   @ObfuscatedSignature(
      signature = "(Lclass66;I)V",
      garbageValue = "-1130539200"
   )
   static final void method1650(class66 var0) {
      if(class168.localPlayer.x >> 7 == Client.flagX && class168.localPlayer.y >> 7 == Client.flagY) {
         Client.flagX = 0;
      }

      int var1 = class96.field1499;
      int[] var2 = class96.field1501;
      int var3 = var1;
      if(class66.field800 == var0 || class66.field805 == var0) {
         var3 = 1;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         Player var5;
         int var6;
         if(class66.field800 == var0) {
            var5 = class168.localPlayer;
            var6 = class168.localPlayer.field892 << 14;
         } else if(var0 == class66.field805) {
            var5 = Client.cachedPlayers[Client.field1044];
            var6 = Client.field1044 << 14;
         } else {
            var5 = Client.cachedPlayers[var2[var4]];
            var6 = var2[var4] << 14;
            if(var0 == class66.field802 && var2[var4] == Client.field1044) {
               continue;
            }
         }

         if(var5 != null && var5.vmethod1669() && !var5.hidden) {
            var5.field895 = false;
            if((Client.field918 && var1 > 50 || var1 > 200) && class66.field800 != var0 && var5.poseAnimation == var5.idlePoseAnimation) {
               var5.field895 = true;
            }

            int var7 = var5.x >> 7;
            int var8 = var5.y >> 7;
            if(var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
               if(var5.model != null && Client.gameCycle >= var5.totalLevel2 && Client.gameCycle < var5.field879) {
                  var5.field895 = false;
                  var5.field877 = class181.method3424(var5.x, var5.y, class92.plane);
                  class61.region.method2687(class92.plane, var5.x, var5.y, var5.field877, 60, var5, var5.angle, var6, var5.field888, var5.field889, var5.field886, var5.field870);
               } else {
                  if((var5.x & 127) == 64 && (var5.y & 127) == 64) {
                     if(Client.field1018[var7][var8] == Client.field1019) {
                        continue;
                     }

                     Client.field1018[var7][var8] = Client.field1019;
                  }

                  var5.field877 = class181.method3424(var5.x, var5.y, class92.plane);
                  class61.region.method2686(class92.plane, var5.x, var5.y, var5.field877, 60, var5, var5.angle, var6, var5.field1229);
               }
            }
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "723742482"
   )
   static final int method1651(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return ((var0 & 16711935) * var3 + var2 * (var1 & 16711935) & -16711936) + ((var0 & '\uff00') * var3 + (var1 & '\uff00') * var2 & 16711680) >> 8;
   }
}
