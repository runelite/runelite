import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
public class class39 {
   @ObfuscatedName("i")
   static final BigInteger field822 = new BigInteger("a0211b55eb8010fd56feae6b163a67945b2ffcb6b3cd976a477f2d88e4cafefebd7174268fa9708acf26dbb44a772d4781f41ecb812f9ae459cf23fd7dc76bd70ac5b9ddaee2c1f6de8f8a8a39750f5f4a5c784079d6e7ba39a8915a6336cd681f3ce8083a344072adf5eec02a7221a05b8fda1e4ff4cf117ea89d290ed6fb7d", 16);
   @ObfuscatedName("f")
   static final BigInteger field825 = new BigInteger("10001", 16);

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
