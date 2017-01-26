import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
public class class39 {
   @ObfuscatedName("g")
   static final BigInteger field800 = new BigInteger("c8506b430570b2255380b829d3c6408f2f12862103e140b97017add3877dd23d8cebfd88dfb792ac4003f6f5f90b4809a7274cb466919c9c98e7f86c9def40edddcc2f37edbb369899f9d06ff469dcd306879cd37d7cec5a54ac8f8c6665fb7237d7687d3a5b5245685e7a21a2917b6917884706242c508bef2c8dbb2be2f221", 16);
   @ObfuscatedName("gz")
   static Widget field802;
   @ObfuscatedName("p")
   static final BigInteger field804 = new BigInteger("10001", 16);

   class39() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-885189021"
   )
   public static boolean method738(int var0) {
      return (var0 & 1) != 0;
   }

   @ObfuscatedName("df")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "372371525"
   )
   static final void method739(String var0) {
      if(null != Renderable.clanMembers) {
         Client.field394.method3037(79);
         Client.field394.method2799(class37.method737(var0));
         Client.field394.method2805(var0);
      }
   }
}
