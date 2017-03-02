import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fs")
public abstract class class156 {
   @ObfuscatedName("de")
   @ObfuscatedGetter(
      intValue = -1262239739
   )
   static int field2107;
   @ObfuscatedName("gp")
   @ObfuscatedGetter(
      intValue = -1249447287
   )
   @Export("plane")
   static int plane;
   @ObfuscatedName("l")
   static boolean field2113 = false;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "1427906278"
   )
   abstract byte[] vmethod3082();

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1652791378"
   )
   abstract void vmethod3083(byte[] var1);

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-119"
   )
   public static int method3084(int var0) {
      Varbit var2 = (Varbit)Varbit.field2850.get((long)var0);
      Varbit var1;
      if(var2 != null) {
         var1 = var2;
      } else {
         byte[] var3 = Varbit.field2853.getConfigData(14, var0);
         var2 = new Varbit();
         if(null != var3) {
            var2.method3617(new Buffer(var3));
         }

         Varbit.field2850.put(var2, (long)var0);
         var1 = var2;
      }

      int var7 = var1.leastSignificantBit;
      int var4 = var1.configId;
      int var5 = var1.mostSignificantBit;
      int var6 = class165.field2153[var5 - var4];
      return class165.widgetSettings[var7] >> var4 & var6;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ILScript;ZB)I",
      garbageValue = "2"
   )
   static int method3090(int var0, Script var1, boolean var2) {
      if(var0 == 3300) {
         class32.field729[++class101.field1648 - 1] = Client.gameCycle;
         return 1;
      } else {
         int var3;
         int var4;
         if(var0 == 3301) {
            class101.field1648 -= 2;
            var3 = class32.field729[class101.field1648];
            var4 = class32.field729[1 + class101.field1648];
            class32.field729[++class101.field1648 - 1] = class2.method31(var3, var4);
            return 1;
         } else {
            int[] var5;
            int var6;
            int var7;
            XItemContainer var8;
            if(var0 == 3302) {
               class101.field1648 -= 2;
               var3 = class32.field729[class101.field1648];
               var4 = class32.field729[1 + class101.field1648];
               var5 = class32.field729;
               var6 = ++class101.field1648 - 1;
               var8 = (XItemContainer)XItemContainer.itemContainers.method2428((long)var3);
               if(null == var8) {
                  var7 = 0;
               } else if(var4 >= 0 && var4 < var8.stackSizes.length) {
                  var7 = var8.stackSizes[var4];
               } else {
                  var7 = 0;
               }

               var5[var6] = var7;
               return 1;
            } else if(var0 == 3303) {
               class101.field1648 -= 2;
               var3 = class32.field729[class101.field1648];
               var4 = class32.field729[1 + class101.field1648];
               class32.field729[++class101.field1648 - 1] = ClassInfo.method4364(var3, var4);
               return 1;
            } else if(var0 == 3304) {
               var3 = class32.field729[--class101.field1648];
               class32.field729[++class101.field1648 - 1] = GameEngine.method2217(var3).field2762;
               return 1;
            } else if(var0 == 3305) {
               var3 = class32.field729[--class101.field1648];
               class32.field729[++class101.field1648 - 1] = Client.boostedSkillLevels[var3];
               return 1;
            } else if(var0 == 3306) {
               var3 = class32.field729[--class101.field1648];
               class32.field729[++class101.field1648 - 1] = Client.realSkillLevels[var3];
               return 1;
            } else if(var0 == 3307) {
               var3 = class32.field729[--class101.field1648];
               class32.field729[++class101.field1648 - 1] = Client.skillExperiences[var3];
               return 1;
            } else if(var0 == 3308) {
               var3 = plane;
               var4 = (class9.localPlayer.x >> 7) + MessageNode.baseX;
               int var9 = (class9.localPlayer.y >> 7) + class2.baseY;
               class32.field729[++class101.field1648 - 1] = var9 + (var3 << 28) + (var4 << 14);
               return 1;
            } else if(var0 == 3309) {
               var3 = class32.field729[--class101.field1648];
               class32.field729[++class101.field1648 - 1] = var3 >> 14 & 16383;
               return 1;
            } else if(var0 == 3310) {
               var3 = class32.field729[--class101.field1648];
               class32.field729[++class101.field1648 - 1] = var3 >> 28;
               return 1;
            } else if(var0 == 3311) {
               var3 = class32.field729[--class101.field1648];
               class32.field729[++class101.field1648 - 1] = var3 & 16383;
               return 1;
            } else if(var0 == 3312) {
               class32.field729[++class101.field1648 - 1] = Client.isMembers?1:0;
               return 1;
            } else if(var0 == 3313) {
               class101.field1648 -= 2;
               var3 = '耀' + class32.field729[class101.field1648];
               var4 = class32.field729[1 + class101.field1648];
               class32.field729[++class101.field1648 - 1] = class2.method31(var3, var4);
               return 1;
            } else if(var0 != 3314) {
               if(var0 == 3315) {
                  class101.field1648 -= 2;
                  var3 = '耀' + class32.field729[class101.field1648];
                  var4 = class32.field729[1 + class101.field1648];
                  class32.field729[++class101.field1648 - 1] = ClassInfo.method4364(var3, var4);
                  return 1;
               } else if(var0 == 3316) {
                  if(Client.field370 >= 2) {
                     class32.field729[++class101.field1648 - 1] = Client.field370;
                  } else {
                     class32.field729[++class101.field1648 - 1] = 0;
                  }

                  return 1;
               } else if(var0 == 3317) {
                  class32.field729[++class101.field1648 - 1] = Client.field504;
                  return 1;
               } else if(var0 == 3318) {
                  class32.field729[++class101.field1648 - 1] = Client.world;
                  return 1;
               } else if(var0 == 3321) {
                  class32.field729[++class101.field1648 - 1] = Client.energy;
                  return 1;
               } else if(var0 == 3322) {
                  class32.field729[++class101.field1648 - 1] = Client.weight;
                  return 1;
               } else if(var0 == 3323) {
                  if(Client.field454) {
                     class32.field729[++class101.field1648 - 1] = 1;
                  } else {
                     class32.field729[++class101.field1648 - 1] = 0;
                  }

                  return 1;
               } else if(var0 == 3324) {
                  class32.field729[++class101.field1648 - 1] = Client.flags;
                  return 1;
               } else {
                  return 2;
               }
            } else {
               class101.field1648 -= 2;
               var3 = class32.field729[class101.field1648] + '耀';
               var4 = class32.field729[class101.field1648 + 1];
               var5 = class32.field729;
               var6 = ++class101.field1648 - 1;
               var8 = (XItemContainer)XItemContainer.itemContainers.method2428((long)var3);
               if(var8 == null) {
                  var7 = 0;
               } else if(var4 >= 0 && var4 < var8.stackSizes.length) {
                  var7 = var8.stackSizes[var4];
               } else {
                  var7 = 0;
               }

               var5[var6] = var7;
               return 1;
            }
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;S)Ljava/lang/String;",
      garbageValue = "23948"
   )
   public static String method3091(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(var3 == 0) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            var5 = class150.method2825(var5);
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(var5 != 46 && var5 != 63 && var5 != 33) {
            if(Character.isSpaceChar(var5)) {
               if(var3 != 2) {
                  var3 = 1;
               }
            } else {
               var3 = 1;
            }
         } else {
            var3 = 2;
         }

         var2[var4] = var5;
      }

      return new String(var2);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-644235489"
   )
   static int method3096(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class140.method2681(class32.field729[--class101.field1648]);
      } else {
         var3 = var2?class32.field719:class185.field2760;
      }

      Frames.method1960(var3);
      if(var0 != 1200 && var0 != 1205 && var0 != 1212) {
         if(var0 == 1201) {
            var3.modelType = 2;
            var3.modelId = class32.field729[--class101.field1648];
            return 1;
         } else if(var0 == 1202) {
            var3.modelType = 3;
            var3.modelId = class9.localPlayer.composition.method3231();
            return 1;
         } else {
            return 2;
         }
      } else {
         class101.field1648 -= 2;
         int var4 = class32.field729[class101.field1648];
         int var5 = class32.field729[class101.field1648 + 1];
         var3.item = var4;
         var3.stackSize = var5;
         ItemComposition var6 = class168.getItemDefinition(var4);
         var3.rotationX = var6.xan2d;
         var3.rotationZ = var6.yan2d;
         var3.rotationY = var6.zan2d;
         var3.field2245 = var6.offsetX2d;
         var3.field2246 = var6.offsetY2d;
         var3.field2238 = var6.zoom2d;
         if(var0 == 1205) {
            var3.field2254 = 0;
         } else if(var0 == 1212 | var6.isStackable == 1) {
            var3.field2254 = 1;
         } else {
            var3.field2254 = 2;
         }

         if(var3.field2251 > 0) {
            var3.field2238 = var3.field2238 * 32 / var3.field2251;
         } else if(var3.originalWidth > 0) {
            var3.field2238 = var3.field2238 * 32 / var3.originalWidth;
         }

         return 1;
      }
   }
}
