import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
public class class148 {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 86475233
   )
   public static int field2203;
   @ObfuscatedName("bo")
   @Export("sessionToken")
   static String sessionToken;
   @ObfuscatedName("e")
   volatile byte[] field2204;
   @ObfuscatedName("k")
   volatile boolean field2199;
   @ObfuscatedName("d")
   final URL field2201;

   class148(URL var1) {
      this.field2201 = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-41"
   )
   public boolean method2990() {
      return this.field2199;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "1081987069"
   )
   public byte[] method2984() {
      return this.field2204;
   }

   @ObfuscatedName("il")
   @ObfuscatedSignature(
      signature = "(IIIIS)V",
      garbageValue = "-14620"
   )
   static final void method2982(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field1116; ++var4) {
         if(Client.widgetBoundsWidth[var4] + Client.widgetPositionX[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetPositionY[var4] + Client.widgetBoundsHeight[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field1119[var4] = true;
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lfg;IIIIIII)V",
      garbageValue = "-35816606"
   )
   @Export("loadTerrain")
   static final void loadTerrain(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class61.tileSettings[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               if(var1 == 0) {
                  class61.tileHeights[0][var2][var3] = -Player.method1189(var2 + 932731 + var4, var3 + 556238 + var5) * 8;
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
               class277.overlayPaths[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class61.overlayRotations[var1][var2][var3] = (byte)(var7 - 2 + var6 & 3);
            } else if(var7 <= 81) {
               class61.tileSettings[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class61.underlayIds[var1][var2][var3] = (byte)(var7 - 81);
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
