import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gb")
public class class206 {
   @ObfuscatedName("j")
   static char[] field3097;
   @ObfuscatedName("x")
   static char[] field3099 = new char[64];
   @ObfuscatedName("i")
   public static String[] field3100;
   @ObfuscatedName("c")
   static int[] field3101;

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "65536"
   )
   static final void method3834(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(class44.method892(var0)) {
         TextureProvider.field1213 = null;
         FaceNormal.gameDraw(Widget.widgets[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(TextureProvider.field1213 != null) {
            FaceNormal.gameDraw(TextureProvider.field1213, -1412584499, var1, var2, var3, var4, class32.field749, class210.field3129, var7);
            TextureProvider.field1213 = null;
         }

      } else {
         if(var7 != -1) {
            Client.field518[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               Client.field518[var8] = true;
            }
         }

      }
   }

   static {
      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field3099[var0] = (char)(65 + var0);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3099[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3099[var0] = (char)(48 + var0 - 52);
      }

      field3099[62] = 43;
      field3099[63] = 47;
      field3097 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field3097[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3097[var0] = (char)(97 + var0 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3097[var0] = (char)(var0 + 48 - 52);
      }

      field3097[62] = 42;
      field3097[63] = 45;
      field3101 = new int[128];

      for(var0 = 0; var0 < field3101.length; ++var0) {
         field3101[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field3101[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field3101[var0] = var0 - 97 + 26;
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field3101[var0] = 52 + (var0 - 48);
      }

      int[] var2 = field3101;
      field3101[43] = 62;
      var2[42] = 62;
      int[] var1 = field3101;
      field3101[47] = 63;
      var1[45] = 63;
   }

   class206() throws Throwable {
      throw new Error();
   }
}
