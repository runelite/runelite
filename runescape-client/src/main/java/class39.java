import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
public class class39 {
   @ObfuscatedName("i")
   @Export("rsaKeyModulus")
   static final BigInteger rsaKeyModulus = new BigInteger("60944c46cf05ef4704129f650bc2334941622845bb983b49c30d1df3f1363ae64666ce663a602c9fb6af1ebd868ca415db9c75801760b6a24627971e723392b08705359f5313c800d2a061e70978f1ccaadf1be39acfc4beedaade993c79ae2815d53b008d3a7d8f003481414bd94018e5bce26151c6e2cc966a5bd26ba0304f", 16);
   @ObfuscatedName("f")
   @Export("rsaKeyExponent")
   static final BigInteger rsaKeyExponent = new BigInteger("10001", 16);

   class39() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "113"
   )
   static void method768() {
      int var0 = class32.field755;
      int var1 = class168.field2207;
      if(CombatInfo1.field682 < var0) {
         var0 = CombatInfo1.field682;
      }

      if(class33.field758 < var1) {
         var1 = class33.field758;
      }

      if(class148.field2058 != null) {
         try {
            Client var2 = Client.field433;
            int var3 = Client.isResized?2:1;
            class100.method1985(var2, "resize", new Object[]{Integer.valueOf(var3)});
         } catch (Throwable var4) {
            ;
         }
      }

   }

   @ObfuscatedName("dw")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "1"
   )
   static final void method769(String var0) {
      if(!var0.equals("")) {
         Client.secretCipherBuffer1.putOpcode(253);
         Client.secretCipherBuffer1.putByte(class72.method1439(var0));
         Client.secretCipherBuffer1.method2931(var0);
      }

   }
}
