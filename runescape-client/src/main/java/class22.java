import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
public class class22 extends class119 {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "0"
   )
   static void method204(String var0, String var1, String var2) {
      class41.loginMessage1 = var0;
      class41.loginMessage2 = var1;
      class41.loginMessage3 = var2;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIILCollisionData;B)Z",
      garbageValue = "96"
   )
   protected boolean vmethod2255(int var1, int var2, int var3, CollisionData var4) {
      return super.field1851 == var2 && var3 == super.field1855;
   }
}
