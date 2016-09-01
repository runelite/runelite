import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ea")
public abstract class class136 {
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1920699192"
   )
   abstract void vmethod3173();

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "10"
   )
   abstract int vmethod3169(int var1, int var2);

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;Lclass170;Lclass170;I)V",
      garbageValue = "-1831058410"
   )
   public static void method2910(class170 var0, class170 var1, class170 var2, class170 var3) {
      class214.field3186 = var0;
      class214.field3188 = var1;
      class62.field1264 = var2;
      class178.field2951 = var3;
      Widget.widgets = new Widget[class214.field3186.method3300()][];
      Widget.validInterfaces = new boolean[class214.field3186.method3300()];
   }

   @ObfuscatedName("da")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-320130459"
   )
   static final void method2911(int var0) {
      if(class175.method3419(var0)) {
         Widget[] var1 = Widget.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(null != var3) {
               var3.field2932 = 0;
               var3.field2945 = 0;
            }
         }

      }
   }
}
