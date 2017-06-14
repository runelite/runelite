import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
public class class90 {
   @ObfuscatedName("n")
   @Export("rsaKeyExponent")
   static final BigInteger rsaKeyExponent;
   @ObfuscatedName("bd")
   static ModIcon[] field1405;
   @ObfuscatedName("p")
   @Export("rsaKeyModulus")
   static final BigInteger rsaKeyModulus;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ILScript;ZB)I",
      garbageValue = "0"
   )
   static int method1697(int var0, Script var1, boolean var2) {
      if(var0 == 6200) {
         class165.intStackSize -= 2;
         Client.field1169 = (short)class83.intStack[class165.intStackSize];
         if(Client.field1169 <= 0) {
            Client.field1169 = 256;
         }

         Client.field1057 = (short)class83.intStack[class165.intStackSize + 1];
         if(Client.field1057 <= 0) {
            Client.field1057 = 205;
         }

         return 1;
      } else if(var0 == 6201) {
         class165.intStackSize -= 2;
         Client.field1037 = (short)class83.intStack[class165.intStackSize];
         if(Client.field1037 <= 0) {
            Client.field1037 = 256;
         }

         Client.field1172 = (short)class83.intStack[class165.intStackSize + 1];
         if(Client.field1172 <= 0) {
            Client.field1172 = 320;
         }

         return 1;
      } else if(var0 == 6202) {
         class165.intStackSize -= 4;
         Client.field1173 = (short)class83.intStack[class165.intStackSize];
         if(Client.field1173 <= 0) {
            Client.field1173 = 1;
         }

         Client.field1192 = (short)class83.intStack[class165.intStackSize + 1];
         if(Client.field1192 <= 0) {
            Client.field1192 = 32767;
         } else if(Client.field1192 < Client.field1173) {
            Client.field1192 = Client.field1173;
         }

         Client.field1175 = (short)class83.intStack[class165.intStackSize + 2];
         if(Client.field1175 <= 0) {
            Client.field1175 = 1;
         }

         Client.field975 = (short)class83.intStack[class165.intStackSize + 3];
         if(Client.field975 <= 0) {
            Client.field975 = 32767;
         } else if(Client.field975 < Client.field1175) {
            Client.field975 = Client.field1175;
         }

         return 1;
      } else if(var0 == 6203) {
         if(Client.field1088 != null) {
            class211.method3950(0, 0, Client.field1088.width, Client.field1088.height, false);
            class83.intStack[++class165.intStackSize - 1] = Client.viewportHeight;
            class83.intStack[++class165.intStackSize - 1] = Client.viewportWidth;
         } else {
            class83.intStack[++class165.intStackSize - 1] = -1;
            class83.intStack[++class165.intStackSize - 1] = -1;
         }

         return 1;
      } else if(var0 == 6204) {
         class83.intStack[++class165.intStackSize - 1] = Client.field1037;
         class83.intStack[++class165.intStackSize - 1] = Client.field1172;
         return 1;
      } else if(var0 == 6205) {
         class83.intStack[++class165.intStackSize - 1] = Client.field1169;
         class83.intStack[++class165.intStackSize - 1] = Client.field1057;
         return 1;
      } else {
         return 2;
      }
   }

   static {
      rsaKeyExponent = new BigInteger("10001", 16);
      rsaKeyModulus = new BigInteger("9acb58ad0f840ca64d5419c67bae04e93d95693e3a99fea353d4b99ce93ddd466c04c49bb9f032eb0fcf14f36f0628524388b8e1baf465dbf71c9aa570f6ea5e334d2cf499b7f1bd1e4a9be0614ed8a696a55208f0ec7aabf5bb5f74d2e25d25427417e6c2fcce828e461b0ed23ad0a0a7dc05ffced69574ebef7008e93318f1", 16);
   }

   @ObfuscatedName("fw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "311450559"
   )
   static final void method1698() {
      int var0 = class12.field273 * 128 + 64;
      int var1 = MessageNode.field856 * 128 + 64;
      int var2 = class181.method3424(var0, var1, class92.plane) - PacketBuffer.field2429;
      if(class2.cameraX < var0) {
         class2.cameraX += class25.field373 + WallObject.field2136 * (var0 - class2.cameraX) / 1000;
         if(class2.cameraX > var0) {
            class2.cameraX = var0;
         }
      }

      if(class2.cameraX > var0) {
         class2.cameraX -= WallObject.field2136 * (class2.cameraX - var0) / 1000 + class25.field373;
         if(class2.cameraX < var0) {
            class2.cameraX = var0;
         }
      }

      if(class203.cameraZ < var2) {
         class203.cameraZ += class25.field373 + WallObject.field2136 * (var2 - class203.cameraZ) / 1000;
         if(class203.cameraZ > var2) {
            class203.cameraZ = var2;
         }
      }

      if(class203.cameraZ > var2) {
         class203.cameraZ -= WallObject.field2136 * (class203.cameraZ - var2) / 1000 + class25.field373;
         if(class203.cameraZ < var2) {
            class203.cameraZ = var2;
         }
      }

      if(XItemContainer.cameraY < var1) {
         XItemContainer.cameraY += class25.field373 + (var1 - XItemContainer.cameraY) * WallObject.field2136 / 1000;
         if(XItemContainer.cameraY > var1) {
            XItemContainer.cameraY = var1;
         }
      }

      if(XItemContainer.cameraY > var1) {
         XItemContainer.cameraY -= WallObject.field2136 * (XItemContainer.cameraY - var1) / 1000 + class25.field373;
         if(XItemContainer.cameraY < var1) {
            XItemContainer.cameraY = var1;
         }
      }

      var0 = GameEngine.field708 * 128 + 64;
      var1 = SceneTilePaint.field2052 * 128 + 64;
      var2 = class181.method3424(var0, var1, class92.plane) - class2.field19;
      int var3 = var0 - class2.cameraX;
      int var4 = var2 - class203.cameraZ;
      int var5 = var1 - XItemContainer.cameraY;
      int var6 = (int)Math.sqrt((double)(var3 * var3 + var5 * var5));
      int var7 = (int)(Math.atan2((double)var4, (double)var6) * 325.949D) & 2047;
      int var8 = (int)(Math.atan2((double)var3, (double)var5) * -325.949D) & 2047;
      if(var7 < 128) {
         var7 = 128;
      }

      if(var7 > 383) {
         var7 = 383;
      }

      if(Client.cameraPitch < var7) {
         Client.cameraPitch += class73.field868 + (var7 - Client.cameraPitch) * XGrandExchangeOffer.field313 / 1000;
         if(Client.cameraPitch > var7) {
            Client.cameraPitch = var7;
         }
      }

      if(Client.cameraPitch > var7) {
         Client.cameraPitch -= class73.field868 + XGrandExchangeOffer.field313 * (Client.cameraPitch - var7) / 1000;
         if(Client.cameraPitch < var7) {
            Client.cameraPitch = var7;
         }
      }

      int var9 = var8 - GraphicsObject.cameraYaw;
      if(var9 > 1024) {
         var9 -= 2048;
      }

      if(var9 < -1024) {
         var9 += 2048;
      }

      if(var9 > 0) {
         GraphicsObject.cameraYaw += var9 * XGrandExchangeOffer.field313 / 1000 + class73.field868;
         GraphicsObject.cameraYaw &= 2047;
      }

      if(var9 < 0) {
         GraphicsObject.cameraYaw -= class73.field868 + -var9 * XGrandExchangeOffer.field313 / 1000;
         GraphicsObject.cameraYaw &= 2047;
      }

      int var10 = var8 - GraphicsObject.cameraYaw;
      if(var10 > 1024) {
         var10 -= 2048;
      }

      if(var10 < -1024) {
         var10 += 2048;
      }

      if(var10 < 0 && var9 > 0 || var10 > 0 && var9 < 0) {
         GraphicsObject.cameraYaw = var8;
      }

   }
}
