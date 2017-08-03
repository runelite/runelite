import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bl")
@Implements("ScriptState")
public class ScriptState {
   @ObfuscatedName("gi")
   @ObfuscatedSignature(
      signature = "[Lji;"
   )
   static SpritePixels[] field724;
   @ObfuscatedName("gb")
   @ObfuscatedGetter(
      intValue = -648076281
   )
   @Export("cameraYaw")
   static int cameraYaw;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -761208449
   )
   @Export("invokedFromPc")
   int invokedFromPc;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lcd;"
   )
   @Export("invokedFromScript")
   Script invokedFromScript;
   @ObfuscatedName("x")
   @Export("savedLocalInts")
   int[] savedLocalInts;
   @ObfuscatedName("y")
   @Export("savedLocalStrings")
   String[] savedLocalStrings;

   ScriptState() {
      this.invokedFromPc = -1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lev;IIII)Z",
      garbageValue = "1923365217"
   )
   public static final boolean method1057(Model var0, int var1, int var2, int var3) {
      if(!class152.method2950()) {
         return false;
      } else {
         int var4;
         int var5;
         int var6;
         int var7;
         int var10;
         int var11;
         int var12;
         int var15;
         int var16;
         if(!class134.field1965) {
            var4 = Region.pitchSin;
            var5 = Region.pitchCos;
            var6 = Region.yawSin;
            var7 = Region.yawCos;
            byte var8 = 50;
            short var9 = 3500;
            var10 = (class134.field1967 - Graphics3D.centerX) * var8 / Graphics3D.field1998;
            var11 = (class134.field1964 - Graphics3D.centerY) * var8 / Graphics3D.field1998;
            var12 = (class134.field1967 - Graphics3D.centerX) * var9 / Graphics3D.field1998;
            int var13 = (class134.field1964 - Graphics3D.centerY) * var9 / Graphics3D.field1998;
            int var14 = Graphics3D.method2627(var11, var8, var5, var4);
            var15 = Graphics3D.method2624(var11, var8, var5, var4);
            var11 = var14;
            var14 = Graphics3D.method2627(var13, var9, var5, var4);
            var16 = Graphics3D.method2624(var13, var9, var5, var4);
            var13 = var14;
            var14 = Graphics3D.method2625(var10, var15, var7, var6);
            var15 = Graphics3D.method2626(var10, var15, var7, var6);
            var10 = var14;
            var14 = Graphics3D.method2625(var12, var16, var7, var6);
            var16 = Graphics3D.method2626(var12, var16, var7, var6);
            class134.field1966 = (var10 + var14) / 2;
            class90.field1377 = (var11 + var13) / 2;
            SoundTask.field1647 = (var15 + var16) / 2;
            class40.field509 = (var14 - var10) / 2;
            BufferProvider.field3744 = (var13 - var11) / 2;
            class134.field1969 = (var16 - var15) / 2;
            class134.field1968 = Math.abs(class40.field509);
            CacheFile.field1538 = Math.abs(BufferProvider.field3744);
            class134.field1972 = Math.abs(class134.field1969);
         }

         var4 = var0.field1925 + var1;
         var5 = var2 + var0.field1953;
         var6 = var3 + var0.field1926;
         var7 = var0.field1906;
         var15 = var0.field1928;
         var16 = var0.field1929;
         var10 = class134.field1966 - var4;
         var11 = class90.field1377 - var5;
         var12 = SoundTask.field1647 - var6;
         return Math.abs(var10) > var7 + class134.field1968?false:(Math.abs(var11) > var15 + CacheFile.field1538?false:(Math.abs(var12) > var16 + class134.field1972?false:(Math.abs(var12 * BufferProvider.field3744 - var11 * class134.field1969) > var15 * class134.field1972 + var16 * CacheFile.field1538?false:(Math.abs(var10 * class134.field1969 - var12 * class40.field509) > var16 * class134.field1968 + var7 * class134.field1972?false:Math.abs(var11 * class40.field509 - var10 * BufferProvider.field3744) <= var7 * CacheFile.field1538 + var15 * class134.field1968))));
      }
   }
}
