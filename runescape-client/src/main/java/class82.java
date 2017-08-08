import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cm")
public final class class82 extends Node {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgv;"
   )
   static Deque field1314;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1376990283
   )
   int field1310;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   ObjectComposition field1317;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -513147661
   )
   int field1306;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1349328989
   )
   int field1303;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1165141025
   )
   int field1313;
   @ObfuscatedName("l")
   int[] field1311;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Ldq;"
   )
   class118 field1316;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -393032741
   )
   int field1307;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -418169973
   )
   int field1305;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1000785789
   )
   int field1308;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1052044535
   )
   int field1304;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 905834051
   )
   int field1315;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Ldq;"
   )
   class118 field1312;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1086125481
   )
   int field1309;

   static {
      field1314 = new Deque();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   void method1609() {
      int var1 = this.field1310;
      ObjectComposition var2 = this.field1317.getImpostor();
      if(var2 != null) {
         this.field1310 = var2.ambientSoundId;
         this.field1306 = var2.field3457 * 128;
         this.field1303 = var2.field3472;
         this.field1313 = var2.field3473;
         this.field1311 = var2.field3474;
      } else {
         this.field1310 = -1;
         this.field1306 = 0;
         this.field1303 = 0;
         this.field1313 = 0;
         this.field1311 = null;
      }

      if(var1 != this.field1310 && this.field1316 != null) {
         class36.field513.method1934(this.field1316);
         this.field1316 = null;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILcc;ZI)I",
      garbageValue = "-113976482"
   )
   static int method1611(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class269.field3661:DecorativeObject.field2164;
      if(var0 == 1800) {
         int[] var4 = class84.intStack;
         int var5 = ++class84.intStackSize - 1;
         int var7 = class15.getWidgetConfig(var3);
         int var6 = var7 >> 11 & 63;
         var4[var5] = var6;
         return 1;
      } else if(var0 != 1801) {
         if(var0 == 1802) {
            if(var3.name == null) {
               class84.scriptStringStack[++class84.scriptStringStackSize - 1] = "";
            } else {
               class84.scriptStringStack[++class84.scriptStringStackSize - 1] = var3.name;
            }

            return 1;
         } else {
            return 2;
         }
      } else {
         int var8 = class84.intStack[--class84.intStackSize];
         --var8;
         if(var3.actions != null && var8 < var3.actions.length && var3.actions[var8] != null) {
            class84.scriptStringStack[++class84.scriptStringStackSize - 1] = var3.actions[var8];
         } else {
            class84.scriptStringStack[++class84.scriptStringStackSize - 1] = "";
         }

         return 1;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ILcc;ZI)I",
      garbageValue = "-199432891"
   )
   static int method1619(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if(var0 == 3400) {
         class84.intStackSize -= 2;
         var3 = class84.intStack[class84.intStackSize];
         var4 = class84.intStack[class84.intStackSize + 1];
         Enum var6 = (Enum)Enum.field3392.get((long)var3);
         Enum var5;
         if(var6 != null) {
            var5 = var6;
         } else {
            byte[] var14 = Enum.field3393.getConfigData(8, var3);
            var6 = new Enum();
            if(var14 != null) {
               var6.decode(new Buffer(var14));
            }

            Enum.field3392.put(var6, (long)var3);
            var5 = var6;
         }

         var6 = var5;
         if(var5.valType != 115) {
            ;
         }

         for(int var7 = 0; var7 < var6.size; ++var7) {
            if(var4 == var6.keys[var7]) {
               class84.scriptStringStack[++class84.scriptStringStackSize - 1] = var6.stringVals[var7];
               var6 = null;
               break;
            }
         }

         if(var6 != null) {
            class84.scriptStringStack[++class84.scriptStringStackSize - 1] = var6.defaultString;
         }

         return 1;
      } else if(var0 == 3408) {
         class84.intStackSize -= 4;
         var3 = class84.intStack[class84.intStackSize];
         var4 = class84.intStack[class84.intStackSize + 1];
         int var11 = class84.intStack[class84.intStackSize + 2];
         int var12 = class84.intStack[class84.intStackSize + 3];
         Enum var8 = (Enum)Enum.field3392.get((long)var11);
         Enum var10;
         if(var8 != null) {
            var10 = var8;
         } else {
            byte[] var13 = Enum.field3393.getConfigData(8, var11);
            var8 = new Enum();
            if(var13 != null) {
               var8.decode(new Buffer(var13));
            }

            Enum.field3392.put(var8, (long)var11);
            var10 = var8;
         }

         var8 = var10;
         if(var3 == var10.keyType && var4 == var10.valType) {
            for(int var9 = 0; var9 < var8.size; ++var9) {
               if(var12 == var8.keys[var9]) {
                  if(var4 == 115) {
                     class84.scriptStringStack[++class84.scriptStringStackSize - 1] = var8.stringVals[var9];
                  } else {
                     class84.intStack[++class84.intStackSize - 1] = var8.intVals[var9];
                  }

                  var8 = null;
                  break;
               }
            }

            if(var8 != null) {
               if(var4 == 115) {
                  class84.scriptStringStack[++class84.scriptStringStackSize - 1] = var8.defaultString;
               } else {
                  class84.intStack[++class84.intStackSize - 1] = var8.defaultInt;
               }
            }

            return 1;
         } else {
            if(var4 == 115) {
               class84.scriptStringStack[++class84.scriptStringStackSize - 1] = "null";
            } else {
               class84.intStack[++class84.intStackSize - 1] = 0;
            }

            return 1;
         }
      } else {
         return 2;
      }
   }
}
