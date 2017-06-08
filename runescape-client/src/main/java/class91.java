import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
public class class91 implements class178 {
   @ObfuscatedName("ke")
   static class89 field1409;
   @ObfuscatedName("p")
   static final class91 field1410;
   @ObfuscatedName("i")
   static final class91 field1411;
   @ObfuscatedName("n")
   static final class91 field1412;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 160818205
   )
   final int field1413;
   @ObfuscatedName("j")
   static final class91 field1414;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1469137335"
   )
   public int vmethod5059() {
      return this.field1413;
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class91(int var1) {
      this.field1413 = var1;
   }

   static {
      field1412 = new class91(0);
      field1410 = new class91(1);
      field1411 = new class91(2);
      field1414 = new class91(3);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "-2116830759"
   )
   public static String method1702(CharSequence var0) {
      String var1 = class146.method2902(class77.method1490(var0));
      if(var1 == null) {
         var1 = "";
      }

      return var1;
   }
}
