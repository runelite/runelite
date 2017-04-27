import java.io.File;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dv")
public class class120 {
   @ObfuscatedName("c")
   static File field1866;

   class120() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;S)V",
      garbageValue = "-32356"
   )
   public static void method2299(IndexDataBase var0, IndexDataBase var1) {
      class6.field57 = var0;
      KitDefinition.field2844 = var1;
      KitDefinition.field2840 = class6.field57.method3305(3);
   }
}
