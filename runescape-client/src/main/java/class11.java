import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
public class class11 {
   @ObfuscatedName("ox")
   @ObfuscatedGetter(
      intValue = 1740536565
   )
   static int field259;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lc;"
   )
   @Export("BoundingBox3DDrawMode_mouseOver")
   public static final class11 BoundingBox3DDrawMode_mouseOver;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lc;"
   )
   @Export("BoundingBox3DDrawMode_all")
   public static final class11 BoundingBox3DDrawMode_all;
   @ObfuscatedName("dt")
   @Export("host")
   static String host;

   static {
      BoundingBox3DDrawMode_mouseOver = new class11();
      BoundingBox3DDrawMode_all = new class11();
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1499767798"
   )
   static void method52(int var0) {
      if(var0 != -1) {
         if(GraphicsObject.loadWidget(var0)) {
            Widget[] var1 = Widget.widgets[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               Widget var3 = var1[var2];
               if(var3.field2840 != null) {
                  ScriptEvent var4 = new ScriptEvent();
                  var4.widget = var3;
                  var4.objs = var3.field2840;
                  class21.method153(var4, 2000000);
               }
            }

         }
      }
   }
}
