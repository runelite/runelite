import java.awt.Canvas;
import java.awt.Color;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hl")
public class class216 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -606997077
   )
   public final int field3153;
   @ObfuscatedName("d")
   public static final class216 field3154 = new class216(1);
   @ObfuscatedName("m")
   public static final class216 field3155 = new class216(2);
   @ObfuscatedName("n")
   public static final class216 field3156 = new class216(0);
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 13463563
   )
   static int field3158;

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class216(int var1) {
      this.field3153 = var1;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "124"
   )
   static void method4024() {
      Canvas var0 = class107.canvas;
      var0.removeKeyListener(class105.keyboard);
      var0.removeFocusListener(class105.keyboard);
      class105.field1718 = -1;
      class10.method119(class107.canvas);
      if(class183.field2732 != null) {
         class183.field2732.vmethod2135(class107.canvas);
      }

      Client.field281.method2149();
      class107.canvas.setBackground(Color.black);
      class57.method1090(class107.canvas);
      class0.method11(class107.canvas);
      if(null != class183.field2732) {
         class183.field2732.vmethod2134(class107.canvas);
      }

      if(Client.widgetRoot != -1) {
         class101.method1990(Client.widgetRoot, class16.field169, class65.field1103, false);
      }

      GameEngine.field1782 = true;
   }
}
