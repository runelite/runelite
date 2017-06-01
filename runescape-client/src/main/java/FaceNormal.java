import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ef")
@Implements("FaceNormal")
public class FaceNormal {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -190126105
   )
   @Export("z")
   int z;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -687616175
   )
   @Export("y")
   int y;
   @ObfuscatedName("pd")
   static class109 field2155;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1713777981
   )
   @Export("x")
   int x;
   @ObfuscatedName("ib")
   @ObfuscatedGetter(
      intValue = 760280513
   )
   @Export("plane")
   static int plane;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "1"
   )
   public static boolean method2865(char var0) {
      return var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BII)I",
      garbageValue = "-743222655"
   )
   public static int method2866(byte[] var0, int var1) {
      return class15.method75(var0, 0, var1);
   }

   @ObfuscatedName("ij")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1137308577"
   )
   static final void method2867(int var0) {
      if(RSSocket.method2986(var0)) {
         class253.method4473(CombatInfo1.widgets[var0], -1);
      }
   }
}
