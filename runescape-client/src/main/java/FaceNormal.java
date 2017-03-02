import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cf")
@Implements("FaceNormal")
public class FaceNormal {
   @ObfuscatedName("fn")
   @ObfuscatedGetter(
      intValue = -203511157
   )
   @Export("cameraPitch")
   static int cameraPitch;
   @ObfuscatedName("qu")
   @ObfuscatedGetter(
      intValue = -116088509
   )
   protected static int field1553;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -696039895
   )
   @Export("z")
   int z;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1433953213
   )
   @Export("x")
   int x;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 81326045
   )
   @Export("y")
   int y;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1713152049
   )
   public static int field1561;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;I)V",
      garbageValue = "-1063988486"
   )
   public static void method1950(String var0, Throwable var1) {
      var1.printStackTrace();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-72"
   )
   static final void method1951(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var1 + var3; ++var4) {
         for(int var5 = var0; var5 <= var0 + var2; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               Item.field884[0][var5][var4] = 127;
               if(var5 == var0 && var5 > 0) {
                  class10.tileHeights[0][var5][var4] = class10.tileHeights[0][var5 - 1][var4];
               }

               if(var2 + var0 == var5 && var5 < 103) {
                  class10.tileHeights[0][var5][var4] = class10.tileHeights[0][var5 + 1][var4];
               }

               if(var1 == var4 && var4 > 0) {
                  class10.tileHeights[0][var5][var4] = class10.tileHeights[0][var5][var4 - 1];
               }

               if(var4 == var1 + var3 && var4 < 103) {
                  class10.tileHeights[0][var5][var4] = class10.tileHeights[0][var5][var4 + 1];
               }
            }
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIS)I",
      garbageValue = "4811"
   )
   public static int method1952(int var0, int var1) {
      int var2;
      for(var2 = 1; var1 > 1; var1 >>= 1) {
         if((var1 & 1) != 0) {
            var2 *= var0;
         }

         var0 *= var0;
      }

      if(var1 == 1) {
         return var0 * var2;
      } else {
         return var2;
      }
   }
}
