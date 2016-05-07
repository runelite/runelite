import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
public class class10 extends class107 {
   @ObfuscatedName("m")
   static String field164;
   @ObfuscatedName("i")
   static boolean field166;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIILclass108;I)Z",
      garbageValue = "-1542389522"
   )
   public boolean vmethod2368(int var1, int var2, int var3, class108 var4) {
      return var2 == super.field1889 && super.field1898 == var3;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "216"
   )
   static void method135() {
      class15.field204 = new class196(32);
   }

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "(IIB)Ljava/lang/String;",
      garbageValue = "-76"
   )
   static final String method136(int var0, int var1) {
      int var2 = var1 - var0;
      return var2 < -9?class12.method163(16711680):(var2 < -6?class12.method163(16723968):(var2 < -3?class12.method163(16740352):(var2 < 0?class12.method163(16756736):(var2 > 9?class12.method163('\uff00'):(var2 > 6?class12.method163(4259584):(var2 > 3?class12.method163(8453888):(var2 > 0?class12.method163(12648192):class12.method163(16776960))))))));
   }
}
