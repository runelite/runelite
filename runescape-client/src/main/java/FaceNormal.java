import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eu")
@Implements("FaceNormal")
public class FaceNormal {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 627534855
   )
   public static int field2134;
   @ObfuscatedName("os")
   static byte field2133;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 218499981
   )
   @Export("z")
   int z;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -666058631
   )
   @Export("y")
   int y;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1514479043
   )
   @Export("x")
   int x;

   @ObfuscatedName("hb")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1379877524"
   )
   static boolean method2866(int var0) {
      return var0 == 57 || var0 == 58 || var0 == 1007 || var0 == 25 || var0 == 30;
   }
}
