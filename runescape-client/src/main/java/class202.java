import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gk")
public class class202 {
   class202() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "10"
   )
   static final void method3823() {
      int var0 = class45.field923;
      int[] var1 = class45.field918;

      for(int var2 = 0; var2 < var0; ++var2) {
         Player var3 = Client.cachedPlayers[var1[var2]];
         if(var3 != null) {
            Client.method555(var3, 1);
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-946262286"
   )
   static int method3824(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = FaceNormal.method1932(class32.field743[--class30.field713]);
      } else {
         var3 = var2?class154.field2123:class32.field746;
      }

      if(var0 == 1927) {
         if(class32.field751 >= 10) {
            throw new RuntimeException();
         } else if(var3.field2341 == null) {
            return 0;
         } else {
            class18 var4 = new class18();
            var4.field207 = var3;
            var4.field199 = var3.field2341;
            var4.field208 = class32.field751 + 1;
            Client.field502.method2459(var4);
            return 1;
         }
      } else {
         return 2;
      }
   }
}
