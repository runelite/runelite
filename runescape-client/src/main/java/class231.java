import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hu")
public class class231 {
   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   @Export("vorbisIndex")
   static IndexData vorbisIndex;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1018718647"
   )
   static void method4201() {
      if(class91.username == null || class91.username.length() <= 0) {
         if(class2.preferences.rememberedUsername != null) {
            class91.username = class2.preferences.rememberedUsername;
            class91.Login_isUsernameRemembered = true;
         } else {
            class91.Login_isUsernameRemembered = false;
         }

      }
   }
}
