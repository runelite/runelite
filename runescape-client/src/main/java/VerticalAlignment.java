import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jx")
@Implements("VerticalAlignment")
public enum VerticalAlignment implements Enumerated {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ljx;"
   )
   field3442(0, 0),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Ljx;"
   )
   field3440(1, 1),
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ljx;"
   )
   field3439(2, 2);

   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 169303621
   )
   @Export("value")
   public final int value;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1756699981
   )
   final int field3443;

   VerticalAlignment(int var3, int var4) {
      this.value = var3;
      this.field3443 = var4;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-369819377"
   )
   public int rsOrdinal() {
      return this.field3443;
   }

   @ObfuscatedName("jy")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Ljava/lang/String;",
      garbageValue = "-1513409365"
   )
   static String method4715(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.socketType == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.socketType == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.socketType == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.socketType == 5) {
         var0 = var0 + "-wti";
      } else if(Client.socketType == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(class55.sessionToken != null) {
         var3 = "/p=" + class55.sessionToken;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.languageId + "/a=" + WidgetNode.field795 + var3 + "/";
   }
}
