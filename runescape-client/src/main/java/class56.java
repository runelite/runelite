import java.applet.Applet;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("by")
public class class56 {
   @ObfuscatedName("j")
   public static Applet field678;
   @ObfuscatedName("h")
   public static String field686;
   @ObfuscatedName("ow")
   @ObfuscatedSignature(
      signature = "Lck;"
   )
   static class103 field679;

   static {
      field678 = null;
      field686 = null;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)[Lis;",
      garbageValue = "1203147075"
   )
   static class240[] method860() {
      return new class240[]{class240.field3258, class240.field3262, class240.field3257};
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-10"
   )
   static void method869() {
      for(class82 var0 = (class82)class82.field1330.getFront(); var0 != null; var0 = (class82)class82.field1330.getNext()) {
         if(var0.field1323 != null) {
            field679.method1923(var0.field1323);
            var0.field1323 = null;
         }

         if(var0.field1328 != null) {
            field679.method1923(var0.field1328);
            var0.field1328 = null;
         }
      }

      class82.field1330.clear();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-38"
   )
   public static boolean method867(int var0) {
      return (var0 >> 29 & 1) != 0;
   }
}
