import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
public class class40 extends class210 {
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = 1474535599
   )
   static int field911;
   @ObfuscatedName("c")
   short field912;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2136046421
   )
   int field913 = (int)(client.method424() / 1000L);
   @ObfuscatedName("l")
   String field914;
   @ObfuscatedName("u")
   public static short[][] field916;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass170;B)V",
      garbageValue = "-26"
   )
   public static void method804(class170 var0) {
      class56.field1233 = var0;
      class56.field1229 = class56.field1233.method3352(16);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)Lclass49;",
      garbageValue = "38"
   )
   public static class49 method805(int var0) {
      class49 var1 = (class49)class49.field1097.method3834((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class49.field1109.method3340(33, var0);
         var1 = new class49();
         if(var2 != null) {
            var1.method1051(new class122(var2));
         }

         class49.field1097.method3836(var1, (long)var0);
         return var1;
      }
   }

   class40(String var1, int var2) {
      this.field914 = var1;
      this.field912 = (short)var2;
   }
}
