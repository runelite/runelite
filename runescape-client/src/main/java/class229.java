import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hf")
public class class229 {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   public static IndexDataBase field2688;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   public static IndexDataBase field2691;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   public static IndexDataBase field2689;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lhw;"
   )
   public static class230 field2690;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -80246259
   )
   public static int field2687;
   @ObfuscatedName("m")
   @Export("IndexStoreActionHandler_thread")
   static Thread IndexStoreActionHandler_thread;
   @ObfuscatedName("y")
   public static boolean field2692;

   static {
      field2687 = 0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lgc;IIIIIII)V",
      garbageValue = "-400659516"
   )
   @Export("loadTerrain")
   static final void loadTerrain(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class62.tileSettings[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               if(var1 == 0) {
                  class62.tileHeights[0][var2][var3] = -ItemContainer.method1131(var2 + 932731 + var4, var5 + 556238 + var3) * 8;
               } else {
                  class62.tileHeights[var1][var2][var3] = class62.tileHeights[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var8 = var0.readUnsignedByte();
               if(var8 == 1) {
                  var8 = 0;
               }

               if(var1 == 0) {
                  class62.tileHeights[0][var2][var3] = -var8 * 8;
               } else {
                  class62.tileHeights[var1][var2][var3] = class62.tileHeights[var1 - 1][var2][var3] - var8 * 8;
               }
               break;
            }

            if(var7 <= 49) {
               class62.tileOverlayIds[var1][var2][var3] = var0.readByte();
               class62.tileOverlayPath[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class62.overlayRotations[var1][var2][var3] = (byte)(var7 - 2 + var6 & 3);
            } else if(var7 <= 81) {
               class62.tileSettings[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class62.tileUnderlayIds[var1][var2][var3] = (byte)(var7 - 81);
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
