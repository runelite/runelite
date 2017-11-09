import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jd")
public class class268 {
   @ObfuscatedName("oe")
   @ObfuscatedSignature(
      signature = "Lcm;"
   )
   static class101 field3675;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Ljd;"
   )
   public static final class268 field3677;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Ljd;"
   )
   public static final class268 field3673;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Ljd;"
   )
   public static final class268 field3678;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Ljd;"
   )
   public static final class268 field3676;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Ljd;"
   )
   public static final class268 field3687;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ljd;"
   )
   public static final class268 field3674;
   @ObfuscatedName("o")
   @Export("osName")
   public static String osName;
   @ObfuscatedName("bo")
   static String field3685;
   @ObfuscatedName("e")
   final String field3679;
   @ObfuscatedName("l")
   String field3680;

   static {
      field3677 = new class268("PLAIN11", "p11_full");
      field3673 = new class268("PLAIN12", "p12_full");
      field3678 = new class268("BOLD12", "b12_full");
      field3676 = new class268("VERDANA11", "verdana_11pt_regular");
      field3687 = new class268("VERDANA13", "verdana_13pt_regular");
      field3674 = new class268("VERDANA15", "verdana_15pt_regular");
   }

   class268(String var1, String var2) {
      this.field3679 = var1;
      this.field3680 = var2;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "1531227342"
   )
   @Export("currentTimeMs")
   public static synchronized long currentTimeMs() {
      long var0 = System.currentTimeMillis();
      if(var0 < class182.field2511) {
         class182.field2510 += class182.field2511 - var0;
      }

      class182.field2511 = var0;
      return var0 + class182.field2510;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)[Ljd;",
      garbageValue = "1428073418"
   )
   public static class268[] method4911() {
      return new class268[]{field3676, field3674, field3687, field3678, field3673, field3677};
   }

   @ObfuscatedName("fc")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "635843929"
   )
   static final void method4913(String var0) {
      if(var0.equalsIgnoreCase("toggleroof")) {
         Buffer.preferences.hideRoofs = !Buffer.preferences.hideRoofs;
         class169.method3187();
         if(Buffer.preferences.hideRoofs) {
            class96.sendGameMessage(99, "", "Roofs are now all hidden");
         } else {
            class96.sendGameMessage(99, "", "Roofs will only be removed selectively");
         }
      }

      if(var0.equalsIgnoreCase("displayfps")) {
         Client.displayFps = !Client.displayFps;
      }

      if(Client.rights >= 2) {
         if(var0.equalsIgnoreCase("aabb")) {
            if(!class7.field233) {
               class7.field233 = true;
               class7.field229 = class11.field261;
            } else if(class7.field229 == class11.field261) {
               class7.field233 = true;
               class7.field229 = class11.field263;
            } else {
               class7.field233 = false;
            }
         }

         if(var0.equalsIgnoreCase("fpson")) {
            Client.displayFps = true;
         }

         if(var0.equalsIgnoreCase("fpsoff")) {
            Client.displayFps = false;
         }

         if(var0.equalsIgnoreCase("gc")) {
            System.gc();
         }

         if(var0.equalsIgnoreCase("clientdrop")) {
            WidgetNode.method1156();
         }

         if(var0.equalsIgnoreCase("errortest") && Client.socketType == 2) {
            throw new RuntimeException();
         }
      }

      PacketNode var1 = Actor.method1628(ClientPacket.field2345, Client.field952.field1478);
      var1.packetBuffer.putByte(var0.length() + 1);
      var1.packetBuffer.putString(var0);
      Client.field952.method1951(var1);
   }
}
