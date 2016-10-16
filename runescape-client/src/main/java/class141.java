import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eo")
public class class141 {
   @ObfuscatedName("s")
   public static Applet field2172 = null;
   @ObfuscatedName("z")
   public static String field2176 = null;
   @ObfuscatedName("kr")
   @Export("chatMessages")
   static ChatMessages chatMessages;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1832761402"
   )
   static void method2922() {
      class11.chatLineMap.clear();
      class11.field168.method3794();
      class11.field165.method3839();
      class11.field162 = 0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1245372161"
   )
   public static void method2927() {
      class49.field1048.reset();
      class49.field1061.reset();
   }
}
