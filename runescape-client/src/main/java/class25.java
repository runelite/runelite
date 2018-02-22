import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
public class class25 {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -440707557
   )
   @Export("canvasHeight")
   protected static int canvasHeight;
   @ObfuscatedName("fm")
   @ObfuscatedSignature(
      signature = "[Llm;"
   )
   @Export("crossSprites")
   static SpritePixels[] crossSprites;
   @ObfuscatedName("ho")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   static Widget field348;
   @ObfuscatedName("jg")
   @ObfuscatedGetter(
      intValue = 239558237
   )
   @Export("menuX")
   static int menuX;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 753914887
   )
   int field347;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   Coordinates field342;

   @ObfuscatedSignature(
      signature = "(ILhp;)V"
   )
   class25(int var1, Coordinates var2) {
      this.field347 = var1;
      this.field342 = var2;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-137367787"
   )
   static int method201(byte[] var0, int var1, int var2) {
      int var3 = -1;

      for(int var4 = var1; var4 < var2; ++var4) {
         var3 = var3 >>> 8 ^ Buffer.crc32Table[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1508172841"
   )
   static void method202(boolean var0) {
      class89.loginMessage1 = "";
      class89.loginMessage2 = "Enter your username/email & password.";
      class89.loginMessage3 = "";
      class89.loginIndex = 2;
      if(var0) {
         class89.password = "";
      }

      if(class89.username == null || class89.username.length() <= 0) {
         if(Client.preferences.rememberedUsername != null) {
            class89.username = Client.preferences.rememberedUsername;
            class89.Login_isUsernameRemembered = true;
         } else {
            class89.Login_isUsernameRemembered = false;
         }
      }

      NPC.method1846();
   }
}
