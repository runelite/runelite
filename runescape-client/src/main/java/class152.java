import java.awt.Canvas;
import java.awt.Color;
import java.io.File;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
public class class152 {
   @ObfuscatedName("ev")
   static ModIcon[] field2279;
   @ObfuscatedName("o")
   public static String field2280;
   @ObfuscatedName("n")
   public static File field2281;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1192184001
   )
   public static int field2282;
   @ObfuscatedName("y")
   public static class231 field2283 = null;
   @ObfuscatedName("p")
   public static class231 field2285 = null;
   @ObfuscatedName("s")
   public static class231 field2286 = null;

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1474048282"
   )
   static void method3163() {
      Canvas var0 = class164.canvas;
      var0.removeKeyListener(class140.keyboard);
      var0.removeFocusListener(class140.keyboard);
      class140.field2168 = -1;
      class93.method2138(class164.canvas);
      if(ItemComposition.field1217 != null) {
         ItemComposition.field1217.vmethod3137(class164.canvas);
      }

      class168.field2706.method3114();
      class164.canvas.setBackground(Color.black);
      Canvas var1 = class164.canvas;
      var1.setFocusTraversalKeysEnabled(false);
      var1.addKeyListener(class140.keyboard);
      var1.addFocusListener(class140.keyboard);
      class75.method1612(class164.canvas);
      if(ItemComposition.field1217 != null) {
         ItemComposition.field1217.vmethod3136(class164.canvas);
      }

      if(Client.widgetRoot != -1) {
         BufferProvider.method1732(false);
      }

      GameEngine.field2247 = true;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/Class;",
      garbageValue = "1379556308"
   )
   public static Class method3165(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Class.forName(var0)))))))));
   }
}
