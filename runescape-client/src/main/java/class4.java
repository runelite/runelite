import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
public class class4 {
   @ObfuscatedName("d")
   static final BigInteger field70 = new BigInteger("9b84bacb956daabca42453b86cfc9478f1a5a8af23678a833f2c9974fc3884cd4b54b0f04b3bcebd376d7c3508fef5802be96b55de90ff3b1b82f39b10da35b4d748601c421ddabb72a0d8624ae602f64528323eb411bbee9a707907602fdbd2a2f392bf521a741a8f82f82e29c1702953751f939042073c26af2e80c3a44f6b", 16);
   @ObfuscatedName("a")
   static final BigInteger field71 = new BigInteger("10001", 16);
   @ObfuscatedName("k")
   static int[] field72;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1174674625"
   )
   public static void method46() {
      PlayerComposition.field2979.reset();
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(IIS)V",
      garbageValue = "-22811"
   )
   static final void method47(int var0, int var1) {
      if(Client.field298 == 2) {
         class85.method1926(Client.field304 + (Client.field301 - class9.baseX << 7), Client.field532 + (Client.field302 - KitDefinition.baseY << 7), Client.field303 * 2);
         if(Client.field388 > -1 && Client.gameCycle % 20 < 10) {
            class139.field2167[0].method1746(Client.field388 + var0 - 12, Client.field389 + var1 - 28);
         }

      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(CII)Ljava/lang/String;",
      garbageValue = "2069605426"
   )
   static String method48(char var0, int var1) {
      char[] var2 = new char[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[var3] = var0;
      }

      return new String(var2);
   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(IS)Ljava/lang/String;",
      garbageValue = "11202"
   )
   static final String method49(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + class153.method3186('ﾀ') + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + class153.method3186(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + class153.method3186(16776960) + var1 + "</col>");
   }
}
