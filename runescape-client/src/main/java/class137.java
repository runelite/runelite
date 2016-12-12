import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("es")
public class class137 {
   @ObfuscatedName("ae")
   static class184 field1897;
   @ObfuscatedName("e")
   byte[] field1898;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -621092333
   )
   int field1899;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1817247909
   )
   int field1900;
   @ObfuscatedName("i")
   byte[] field1901;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2141241609
   )
   int field1902;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1854697083
   )
   int field1903;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -612736085
   )
   int field1905;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 324489197
   )
   int field1907;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1692364239
   )
   int field1909;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "78"
   )
   public static void method2433() {
      try {
         class104.field1673.method1357();

         for(int var0 = 0; var0 < class40.field819; ++var0) {
            class9.field84[var0].method1357();
         }

         class104.field1666.method1357();
         class104.field1668.method1357();
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "903184794"
   )
   static final void method2434(int var0) {
      if(class212.method3870(var0)) {
         Widget[] var1 = Widget.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(var3 != null) {
               var3.field2330 = 0;
               var3.field2251 = 0;
            }
         }

      }
   }
}
