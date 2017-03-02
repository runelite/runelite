import java.io.File;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dx")
public class class104 {
   @ObfuscatedName("t")
   public static File field1677;
   @ObfuscatedName("k")
   public static File field1678;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1309948159
   )
   public static int field1679;
   @ObfuscatedName("s")
   public static class72 field1680 = null;
   @ObfuscatedName("z")
   public static class72 field1681 = null;
   @ObfuscatedName("p")
   public static class72 field1683 = null;
   @ObfuscatedName("c")
   public static String field1685;
   @ObfuscatedName("e")
   public static String field1686;
   @ObfuscatedName("du")
   static int[] field1687;

   class104() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "1057712844"
   )
   static final void method2049(int var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = 2048 - var3 & 2047;
      int var7 = 2048 - var4 & 2047;
      int var8 = 0;
      int var9 = 0;
      int var10 = var5;
      int var11;
      int var12;
      int var13;
      if(var6 != 0) {
         var11 = class84.field1435[var6];
         var12 = class84.field1432[var6];
         var13 = var12 * var9 - var5 * var11 >> 16;
         var10 = var11 * var9 + var5 * var12 >> 16;
         var9 = var13;
      }

      if(var7 != 0) {
         var11 = class84.field1435[var7];
         var12 = class84.field1432[var7];
         var13 = var11 * var10 + var8 * var12 >> 16;
         var10 = var10 * var12 - var8 * var11 >> 16;
         var8 = var13;
      }

      class206.cameraX = var0 - var8;
      class112.cameraZ = var1 - var9;
      class22.cameraY = var2 - var10;
      FaceNormal.cameraPitch = var3;
      Friend.cameraYaw = var4;
   }
}
