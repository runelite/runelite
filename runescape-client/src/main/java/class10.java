import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
public class class10 {
   @ObfuscatedName("s")
   static String field91;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1249019355
   )
   int field92 = -1;
   @ObfuscatedName("m")
   int[] field93;
   @ObfuscatedName("n")
   class48 field94;
   @ObfuscatedName("el")
   static SpritePixels[] field96;
   @ObfuscatedName("h")
   String[] field98;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-1711310255"
   )
   public static void method119(Component var0) {
      var0.removeMouseListener(class115.mouse);
      var0.removeMouseMotionListener(class115.mouse);
      var0.removeFocusListener(class115.mouse);
      class115.field1798 = 0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "1664070077"
   )
   static void method120(int var0, String var1, String var2) {
      class37.addChatMessage(var0, var1, var2, (String)null);
   }
}
