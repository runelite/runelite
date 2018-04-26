import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
public class class88 {
   @ObfuscatedName("g")
   static final BigInteger field1327;
   @ObfuscatedName("e")
   static final BigInteger field1324;
   @ObfuscatedName("fp")
   static byte[][] field1323;

   static {
      field1327 = new BigInteger("10001", 16);
      field1324 = new BigInteger("b98c85a657d5605e37337458a38c4ce85452c33637b27cb5644c008e582986864ae0beb8428d72910f500cd0cddb5da11a85a1af01b0fa6538c0f805c7c4e496db0528fd5beee4eb8ee4fad04eae4a699cc68252f0b37f5e03281de2e2df92c583aa67cdd103276d72a216280a214bba7f65d43d3f78bd634d701c7b834bf309", 16);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lgg;IIIIIII)V",
      garbageValue = "1963062880"
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
                  class62.tileHeights[0][var2][var3] = -class36.method540(var2 + 932731 + var4, var5 + 556238 + var3) * 8;
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
               class21.tileOverlayIds[var1][var2][var3] = var0.readByte();
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

   @ObfuscatedName("jl")
   @ObfuscatedSignature(
      signature = "(Liz;B)V",
      garbageValue = "44"
   )
   static final void method1969(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 324) {
         if(Client.field1077 == -1) {
            Client.field1077 = var0.spriteId;
            Client.field1115 = var0.field2857;
         }

         if(Client.field1113.isFemale) {
            var0.spriteId = Client.field1077;
         } else {
            var0.spriteId = Client.field1115;
         }

      } else if(var1 == 325) {
         if(Client.field1077 == -1) {
            Client.field1077 = var0.spriteId;
            Client.field1115 = var0.field2857;
         }

         if(Client.field1113.isFemale) {
            var0.spriteId = Client.field1115;
         } else {
            var0.spriteId = Client.field1077;
         }

      } else if(var1 == 327) {
         var0.rotationX = 150;
         var0.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 0;
      } else if(var1 == 328) {
         var0.rotationX = 150;
         var0.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 1;
      }
   }
}
