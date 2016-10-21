import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dt")
public class class124 {
   @ObfuscatedName("t")
   static byte[][] field2061 = new byte[1000][];
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -327496845
   )
   static int field2062 = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1384477005
   )
   static int field2063 = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1104427425
   )
   static int field2065 = 0;
   @ObfuscatedName("b")
   static byte[][] field2066 = new byte[50][];
   @ObfuscatedName("el")
   static SpritePixels[] field2067;
   @ObfuscatedName("v")
   static byte[][] field2068 = new byte[250][];

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-976773407"
   )
   static synchronized byte[] method2763(int var0) {
      byte[] var1;
      if(var0 == 100 && field2065 > 0) {
         var1 = field2061[--field2065];
         field2061[field2065] = null;
         return var1;
      } else if(var0 == 5000 && field2062 > 0) {
         var1 = field2068[--field2062];
         field2068[field2062] = null;
         return var1;
      } else if(var0 == 30000 && field2063 > 0) {
         var1 = field2066[--field2063];
         field2066[field2063] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "619540048"
   )
   static final void method2765(int var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = 2048 - var3 & 2047;
      int var7 = 2048 - var4 & 2047;
      int var8 = 0;
      int var9 = 0;
      int var10 = var5;
      int var11;
      int var12;
      int var13;
      if(var6 != 0) {
         var11 = class94.field1635[var6];
         var12 = class94.field1646[var6];
         var13 = var12 * var9 - var11 * var5 >> 16;
         var10 = var11 * var9 + var12 * var5 >> 16;
         var9 = var13;
      }

      if(var7 != 0) {
         var11 = class94.field1635[var7];
         var12 = class94.field1646[var7];
         var13 = var11 * var10 + var12 * var8 >> 16;
         var10 = var12 * var10 - var8 * var11 >> 16;
         var8 = var13;
      }

      class139.cameraX = var0 - var8;
      class172.cameraZ = var1 - var9;
      class77.cameraY = var2 - var10;
      class144.cameraPitch = var3;
      Frames.cameraYaw = var4;
   }
}
