import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
public class class11 {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lm;"
   )
   public static final class11 field265;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lm;"
   )
   public static final class11 field263;
   @ObfuscatedName("ex")
   @ObfuscatedSignature(
      signature = "Lbt;"
   )
   static class69 field264;
   @ObfuscatedName("pc")
   @ObfuscatedSignature(
      signature = "Ldj;"
   )
   static class117 field262;

   static {
      field265 = new class11();
      field263 = new class11();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-26"
   )
   static void method53() {
      if(Signlink.javaVendor.toLowerCase().indexOf("microsoft") != -1) {
         KeyFocusListener.field653[186] = 57;
         KeyFocusListener.field653[187] = 27;
         KeyFocusListener.field653[188] = 71;
         KeyFocusListener.field653[189] = 26;
         KeyFocusListener.field653[190] = 72;
         KeyFocusListener.field653[191] = 73;
         KeyFocusListener.field653[192] = 58;
         KeyFocusListener.field653[219] = 42;
         KeyFocusListener.field653[220] = 74;
         KeyFocusListener.field653[221] = 43;
         KeyFocusListener.field653[222] = 59;
         KeyFocusListener.field653[223] = 28;
      } else {
         KeyFocusListener.field653[44] = 71;
         KeyFocusListener.field653[45] = 26;
         KeyFocusListener.field653[46] = 72;
         KeyFocusListener.field653[47] = 73;
         KeyFocusListener.field653[59] = 57;
         KeyFocusListener.field653[61] = 27;
         KeyFocusListener.field653[91] = 42;
         KeyFocusListener.field653[92] = 74;
         KeyFocusListener.field653[93] = 43;
         KeyFocusListener.field653[192] = 28;
         KeyFocusListener.field653[222] = 58;
         KeyFocusListener.field653[520] = 59;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)[Lha;",
      garbageValue = "12"
   )
   public static class233[] method56() {
      return new class233[]{class233.field3186, class233.field3188, class233.field3184, class233.field3187, class233.field3185, class233.field3189};
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIS)V",
      garbageValue = "15586"
   )
   static void method57(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(World.field1293[var5] != var0) {
            var2[var4] = World.field1293[var5];
            var3[var4] = World.field1292[var5];
            ++var4;
         }
      }

      World.field1293 = var2;
      World.field1292 = var3;
      ScriptEvent.method1163(World.worldList, 0, World.worldList.length - 1, World.field1293, World.field1292);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "43"
   )
   static final int method55(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return (var3 * (var0 & 16711935) + (var1 & 16711935) * var2 & -16711936) + ((var0 & '\uff00') * var3 + (var1 & '\uff00') * var2 & 16711680) >> 8;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "45131985"
   )
   static final void method54(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var3 + var1; ++var4) {
         for(int var5 = var0; var5 <= var0 + var2; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class61.field784[0][var5][var4] = 127;
               if(var0 == var5 && var5 > 0) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5 - 1][var4];
               }

               if(var5 == var0 + var2 && var5 < 103) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5 + 1][var4];
               }

               if(var4 == var1 && var4 > 0) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5][var4 - 1];
               }

               if(var3 + var1 == var4 && var4 < 103) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5][var4 + 1];
               }
            }
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ILcj;ZI)I",
      garbageValue = "1956922798"
   )
   static int method52(int var0, Script var1, boolean var2) {
      if(var0 == 5306) {
         class84.intStack[++class84.intStackSize - 1] = class13.method77();
         return 1;
      } else {
         int var3;
         if(var0 == 5307) {
            var3 = class84.intStack[--class84.intStackSize];
            if(var3 == 1 || var3 == 2) {
               Client.field1139 = 0L;
               if(var3 >= 2) {
                  Client.isResized = true;
               } else {
                  Client.isResized = false;
               }

               if(class13.method77() == 1) {
                  class27.clientInstance.method888(765, 503);
               } else {
                  class27.clientInstance.method888(7680, 2160);
               }

               if(Client.gameState >= 25) {
                  class88.method1705();
               }
            }

            return 1;
         } else if(var0 == 5308) {
            class84.intStack[++class84.intStackSize - 1] = class3.preferences.screenType;
            return 1;
         } else if(var0 != 5309) {
            return 2;
         } else {
            var3 = class84.intStack[--class84.intStackSize];
            if(var3 == 1 || var3 == 2) {
               class3.preferences.screenType = var3;
               class33.method372();
            }

            return 1;
         }
      }
   }
}
