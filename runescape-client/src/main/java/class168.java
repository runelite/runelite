import java.util.HashMap;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fy")
public class class168 {
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = 1869466843
   )
   public static int field2346;

   static {
      new HashMap();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1747149636"
   )
   static void method3108() {
      for(class82 var0 = (class82)class82.field1349.getFront(); var0 != null; var0 = (class82)class82.field1349.getNext()) {
         if(var0.field1346 != null) {
            class19.field328.method1887(var0.field1346);
            var0.field1346 = null;
         }

         if(var0.field1351 != null) {
            class19.field328.method1887(var0.field1351);
            var0.field1351 = null;
         }
      }

      class82.field1349.clear();
   }
}
