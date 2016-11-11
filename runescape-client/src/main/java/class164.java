import java.awt.Canvas;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ff")
public class class164 {
   @ObfuscatedName("e")
   static int[] field2689;
   @ObfuscatedName("h")
   static char[] field2690;
   @ObfuscatedName("i")
   static char[] field2691 = new char[64];
   @ObfuscatedName("qk")
   @Export("canvas")
   public static Canvas canvas;
   @ObfuscatedName("d")
   static SpritePixels field2694;

   static {
      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field2691[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field2691[var0] = (char)(97 + var0 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field2691[var0] = (char)(48 + var0 - 52);
      }

      field2691[62] = 43;
      field2691[63] = 47;
      field2690 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field2690[var0] = (char)(65 + var0);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field2690[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field2690[var0] = (char)(var0 + 48 - 52);
      }

      field2690[62] = 42;
      field2690[63] = 45;
      field2689 = new int[128];

      for(var0 = 0; var0 < field2689.length; ++var0) {
         field2689[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field2689[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field2689[var0] = 26 + (var0 - 97);
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field2689[var0] = 52 + (var0 - 48);
      }

      int[] var2 = field2689;
      field2689[43] = 62;
      var2[42] = 62;
      int[] var1 = field2689;
      field2689[47] = 63;
      var1[45] = 63;
   }
}
