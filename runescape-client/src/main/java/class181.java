import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fv")
public class class181 extends CacheableNode {
   @ObfuscatedName("u")
   byte field2721;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -524036015
   )
   int field2722;
   @ObfuscatedName("f")
   IndexData field2723;

   @ObfuscatedName("dv")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1541867859"
   )
   static final void method3331(String var0) {
      if(null != class156.clanMembers) {
         Client.secretCipherBuffer1.putOpcode(23);
         Client.secretCipherBuffer1.putByte(class72.method1439(var0));
         Client.secretCipherBuffer1.method2931(var0);
      }
   }

   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      signature = "([BII)V",
      garbageValue = "405842844"
   )
   static void method3332(byte[] var0, int var1) {
      if(Client.field529 == null) {
         Client.field529 = new byte[24];
      }

      class163.method3147(var0, var1, Client.field529, 0, 24);
   }
}
