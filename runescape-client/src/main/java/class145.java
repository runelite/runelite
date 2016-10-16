import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eu")
public class class145 {
   @ObfuscatedName("in")
   @ObfuscatedGetter(
      intValue = 1168533863
   )
   static int field2215;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "1032485077"
   )
   public static void method2980(Component var0) {
      var0.addMouseListener(class143.mouse);
      var0.addMouseMotionListener(class143.mouse);
      var0.addFocusListener(class143.mouse);
   }
}
