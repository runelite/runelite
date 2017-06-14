import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
public class class24 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2013927721
   )
   final int field364;
   @ObfuscatedName("p")
   public static final class24 field365;
   @ObfuscatedName("n")
   public static final class24 field366;
   @ObfuscatedName("j")
   final String field367;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -741206353
   )
   final int field368;
   @ObfuscatedName("ow")
   @ObfuscatedGetter(
      intValue = -615766411
   )
   @Export("clanChatCount")
   static int clanChatCount;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -647627465
   )
   final int field370;
   @ObfuscatedName("i")
   public static final class24 field372;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(FI)Z",
      garbageValue = "1596947812"
   )
   boolean method197(float var1) {
      return var1 >= (float)this.field370;
   }

   static {
      field366 = new class24("SMALL", 0, 0, 4);
      field365 = new class24("MEDIUM", 1, 1, 2);
      field372 = new class24("LARGE", 2, 2, 0);
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;III)V",
      garbageValue = "4"
   )
   class24(String var1, int var2, int var3, int var4) {
      this.field367 = var1;
      this.field368 = var2;
      this.field364 = var3;
      this.field370 = var4;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)[Lclass24;",
      garbageValue = "1270309482"
   )
   static class24[] method200() {
      return new class24[]{field372, field365, field366};
   }

   @ObfuscatedName("gj")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-600301817"
   )
   static final void method201(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = class181.method3424(var0, var1, class92.plane) - var2;
         var0 -= class2.cameraX;
         var3 -= class203.cameraZ;
         var1 -= XItemContainer.cameraY;
         int var4 = class136.SINE[Client.cameraPitch];
         int var5 = class136.COSINE[Client.cameraPitch];
         int var6 = class136.SINE[GraphicsObject.cameraYaw];
         int var7 = class136.COSINE[GraphicsObject.cameraYaw];
         int var8 = var1 * var6 + var7 * var0 >> 16;
         var1 = var1 * var7 - var0 * var6 >> 16;
         var0 = var8;
         var8 = var5 * var3 - var1 * var4 >> 16;
         var1 = var4 * var3 + var1 * var5 >> 16;
         if(var1 >= 50) {
            Client.field1020 = Client.viewportHeight / 2 + Client.scale * var0 / var1;
            Client.field1163 = Client.viewportWidth / 2 + var8 * Client.scale / var1;
         } else {
            Client.field1020 = -1;
            Client.field1163 = -1;
         }

      } else {
         Client.field1020 = -1;
         Client.field1163 = -1;
      }
   }

   @ObfuscatedName("fa")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1034123208"
   )
   static final void method202() {
      if(class154.field2250 != null) {
         class154.field2250.method2009();
      }

      if(RSSocket.field2287 != null) {
         RSSocket.field2287.method2009();
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "13"
   )
   static final boolean method203(int var0, int var1) {
      ObjectComposition var2 = class61.getObjectDefinition(var0);
      if(var1 == 11) {
         var1 = 10;
      }

      if(var1 >= 5 && var1 <= 8) {
         var1 = 4;
      }

      return var2.method4542(var1);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1676279439"
   )
   static final void method204(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var1 + var3; ++var4) {
         for(int var5 = var0; var5 <= var0 + var2; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class10.field261[0][var5][var4] = 127;
               if(var5 == var0 && var5 > 0) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5 - 1][var4];
               }

               if(var0 + var2 == var5 && var5 < 103) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5 + 1][var4];
               }

               if(var1 == var4 && var4 > 0) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5][var4 - 1];
               }

               if(var3 + var1 == var4 && var4 < 103) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5][var4 + 1];
               }
            }
         }
      }

   }
}
