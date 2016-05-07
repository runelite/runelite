import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ej")
public class class151 {
   @ObfuscatedName("k")
   static class80[] field2263;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -581439731
   )
   public static int field2268;
   @ObfuscatedName("eu")
   static class80[] field2270;

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1809335153"
   )
   static final void method3122(int var0) {
      if(var0 >= 0) {
         int var1 = client.field420[var0];
         int var2 = client.field421[var0];
         int var3 = client.field422[var0];
         int var4 = client.field378[var0];
         String var5 = client.field424[var0];
         String var6 = client.field425[var0];
         class13.method171(var1, var2, var3, var4, var5, var6, class140.field2169, class140.field2170);
      }
   }
}
