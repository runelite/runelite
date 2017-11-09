import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("js")
public class class279 {
   @ObfuscatedName("n")
   public static short[][] field3739;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lik;Lik;Ljava/lang/String;Ljava/lang/String;I)Ljt;",
      garbageValue = "1076405766"
   )
   public static Font method5095(IndexDataBase var0, IndexDataBase var1, String var2, String var3) {
      int var4 = var0.getFile(var2);
      int var5 = var0.getChild(var4, var3);
      return class232.method4242(var0, var1, var4, var5);
   }
}
