import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("et")
public abstract class class136 {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-355225866"
   )
   abstract void vmethod3139();

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1507060313"
   )
   abstract int vmethod3137(int var1, int var2);

   @ObfuscatedName("dr")
   @ObfuscatedSignature(
      signature = "(LWidget;IIIB)V",
      garbageValue = "83"
   )
   static final void method2897(Widget var0, int var1, int var2, int var3) {
      class178 var4 = var0.method3425(false);
      if(null != var4) {
         if(Client.field516 < 3) {
            class157.field2325.method1825(var1, var2, var4.field2947, var4.field2942, 25, 25, Client.mapAngle, 256, var4.field2944, var4.field2941);
         } else {
            class82.method1852(var1, var2, 0, var4.field2944, var4.field2941);
         }

      }
   }
}
