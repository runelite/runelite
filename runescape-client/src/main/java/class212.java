import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hq")
public final class class212 {
   @ObfuscatedName("j")
   static byte[][][] field3169;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/Class;",
      garbageValue = "484747659"
   )
   public static Class method3957(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Class.forName(var0)))))))));
   }

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1992636068"
   )
   static void method3959() {
      if(Client.field435) {
         Widget var0 = class162.method3195(class85.field1490, Client.field436);
         if(var0 != null && var0.field2814 != null) {
            class0 var1 = new class0();
            var1.field11 = var0;
            var1.field0 = var0.field2814;
            SecondaryBufferProvider.method1661(var1);
         }

         Client.field435 = false;
         class166.method3253(var0);
      }
   }
}
