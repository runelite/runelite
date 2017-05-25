import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("et")
public final class class146 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 190473615
   )
   int field2128;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1223325271
   )
   int field2129;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1072340851
   )
   int field2130;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1652291107
   )
   int field2131;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -641942881
   )
   int field2132;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 701320789
   )
   int field2133;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 513557537
   )
   int field2134;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 350711533
   )
   int field2135;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1098086271
   )
   int field2136;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -287558729
   )
   int field2137;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1989964347
   )
   int field2138;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 902596149
   )
   int field2139;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1935981757
   )
   int field2140;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 536369683
   )
   int field2141;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 891713043
   )
   int field2142;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1934722681
   )
   int field2143;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -663557857
   )
   int field2144;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -318287445
   )
   int field2145;
   @ObfuscatedName("ep")
   @ObfuscatedGetter(
      intValue = -1196130045
   )
   @Export("baseY")
   static int baseY;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)Ljava/lang/String;",
      garbageValue = "-102"
   )
   static String method2935(Buffer var0, int var1) {
      try {
         int var2 = var0.method3212();
         if(var2 > var1) {
            var2 = var1;
         }

         byte[] var3 = new byte[var2];
         var0.offset += class265.field3655.method3119(var0.payload, var0.offset, var3, 0, var2);
         String var4 = class228.method4153(var3, 0, var2);
         return var4;
      } catch (Exception var6) {
         return "Cabbage";
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LBuffer;IIIIIII)V",
      garbageValue = "10086985"
   )
   static final void method2936(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class61.tileSettings[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               if(var1 == 0) {
                  class61.tileHeights[0][var2][var3] = -class112.method2129(var4 + var2 + 932731, var5 + var3 + 556238) * 8;
               } else {
                  class61.tileHeights[var1][var2][var3] = class61.tileHeights[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var8 = var0.readUnsignedByte();
               if(var8 == 1) {
                  var8 = 0;
               }

               if(var1 == 0) {
                  class61.tileHeights[0][var2][var3] = -var8 * 8;
               } else {
                  class61.tileHeights[var1][var2][var3] = class61.tileHeights[var1 - 1][var2][var3] - var8 * 8;
               }
               break;
            }

            if(var7 <= 49) {
               class61.overlayIds[var1][var2][var3] = var0.readByte();
               class61.overlayPaths[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class61.overlayRotations[var1][var2][var3] = (byte)(var6 + (var7 - 2) & 3);
            } else if(var7 <= 81) {
               class61.tileSettings[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class90.underlayIds[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               break;
            }

            if(var7 == 1) {
               var0.readUnsignedByte();
               break;
            }

            if(var7 <= 49) {
               var0.readUnsignedByte();
            }
         }
      }

   }
}
