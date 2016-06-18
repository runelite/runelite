import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fa")
public class class158 {
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = 2112549197
   )
   static int field2587;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2068311457"
   )
   static final void method3182() {
      if(null != class13.field195) {
         class13.field195.method3025();
         class13.field195 = null;
      }

      class99.method2203();
      class150.field2230.method2006();

      for(int var0 = 0; var0 < 4; ++var0) {
         client.field291[var0].method2419();
      }

      System.gc();
      class183.field2953 = 1;
      class50.field1075 = null;
      class177.field2903 = -1;
      class183.field2951 = -1;
      class181.field2929 = 0;
      class183.field2956 = false;
      class183.field2955 = 2;
      client.field525 = -1;
      client.field526 = false;
      class99.method2201();
      class43.method919(10);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "27"
   )
   static void method3183() {
      Object var0 = class170.field2706;
      synchronized(class170.field2706) {
         if(class170.field2701 == 0) {
            class40.field924.method2917(new class170(), 5);
         }

         class170.field2701 = 600;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-1914487"
   )
   static String method3184(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }
}
