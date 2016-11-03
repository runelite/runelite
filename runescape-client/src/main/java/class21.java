import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
public class class21 implements class115 {
   @ObfuscatedName("f")
   static final class21 field570 = new class21(2);
   @ObfuscatedName("q")
   static final class21 field571 = new class21(1);
   @ObfuscatedName("df")
   @ObfuscatedGetter(
      intValue = 2028436583
   )
   @Export("baseY")
   static int baseY;
   @ObfuscatedName("c")
   static final class21 field573 = new class21(3);
   @ObfuscatedName("nu")
   @ObfuscatedGetter(
      intValue = -22632549
   )
   static int field576;
   @ObfuscatedName("k")
   static final class21 field577 = new class21(0);
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -758194333
   )
   static int field578;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -937382447
   )
   final int field579;
   @ObfuscatedName("z")
   static int[] field582;

   @ObfuscatedName("dl")
   @ObfuscatedSignature(
      signature = "(LWidget;B)LWidget;",
      garbageValue = "-83"
   )
   static Widget method573(Widget var0) {
      int var1 = GroundObject.method2236(FrameMap.method2356(var0));
      if(var1 == 0) {
         return null;
      } else {
         for(int var2 = 0; var2 < var1; ++var2) {
            var0 = class144.method3012(var0.parentId);
            if(null == var0) {
               return null;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-116"
   )
   public int vmethod3197() {
      return this.field579;
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class21(int var1) {
      this.field579 = var1;
   }
}
