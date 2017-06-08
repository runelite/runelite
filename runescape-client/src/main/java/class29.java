import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
public final class class29 {
   // $FF: synthetic field
   final class41 this$0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -339319019
   )
   int field423;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1535612075
   )
   int field424;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -870153051
   )
   int field425;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1668454901
   )
   int field428;
   @ObfuscatedName("y")
   public static class123[] field432;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)LWidget;",
      garbageValue = "1575558767"
   )
   public static Widget method254(int var0, int var1) {
      Widget var2 = class177.method3390(var0);
      return var1 == -1?var2:(var2 != null && var2.children != null && var1 < var2.children.length?var2.children[var1]:null);
   }

   class29(class41 var1) {
      this.this$0 = var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1967325718"
   )
   public static void method255() {
      try {
         class155.field2254.method2351();

         for(int var0 = 0; var0 < class155.field2253; ++var0) {
            field432[var0].method2351();
         }

         class155.field2259.method2351();
         class155.field2257.method2351();
      } catch (Exception var2) {
         ;
      }

   }
}
