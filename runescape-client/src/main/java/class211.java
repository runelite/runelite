import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hn")
public class class211 {
   @ObfuscatedName("i")
   static class167 field3140;
   @ObfuscatedName("t")
   public static class202 field3141 = new class202();

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "131643949"
   )
   static final void method3879() {
      if(class51.field1112 != null) {
         class51.field1112.method2960();
         class51.field1112 = null;
      }

      class18.method174();
      class214.field3161.method1870();

      for(int var1 = 0; var1 < 4; ++var1) {
         client.field344[var1].method2352();
      }

      System.gc();
      class20.method549(2);
      client.field520 = -1;
      client.field521 = false;

      for(class23 var0 = (class23)class23.field599.method3797(); var0 != null; var0 = (class23)class23.field599.method3779()) {
         if(null != var0.field603) {
            class129.field2065.method1092(var0.field603);
            var0.field603 = null;
         }

         if(null != var0.field600) {
            class129.field2065.method1092(var0.field600);
            var0.field600 = null;
         }
      }

      class23.field599.method3772();
      class2.method14(10);
   }
}
