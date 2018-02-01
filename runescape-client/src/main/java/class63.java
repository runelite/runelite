import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bu")
public class class63 {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1858453033
   )
   static int field718;
   @ObfuscatedName("ci")
   public static char field722;
   @ObfuscatedName("eb")
   @ObfuscatedSignature(
      signature = "Leh;"
   )
   @Export("urlRequester")
   static UrlRequester urlRequester;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   final IndexData field715;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1034280109
   )
   final int field712;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 62415631
   )
   int field713;

   @ObfuscatedSignature(
      signature = "(Lio;Ljava/lang/String;)V"
   )
   class63(IndexData var1, String var2) {
      this.field713 = 0;
      this.field715 = var1;
      this.field712 = var1.size();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-550595688"
   )
   boolean method1052() {
      this.field713 = 0;

      for(int var1 = 0; var1 < this.field712; ++var1) {
         if(!this.field715.method4482(var1) || this.field715.method4503(var1)) {
            ++this.field713;
         }
      }

      return this.field713 >= this.field712;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1600040376"
   )
   static void method1055() {
      if(class89.username == null || class89.username.length() <= 0) {
         if(class221.preferences.rememberedUsername != null) {
            class89.username = class221.preferences.rememberedUsername;
            class89.Login_isUsernameRemembered = true;
         } else {
            class89.Login_isUsernameRemembered = false;
         }

      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1955549763"
   )
   static final void method1054(String var0) {
      class240.sendGameMessage(30, "", var0);
   }
}
