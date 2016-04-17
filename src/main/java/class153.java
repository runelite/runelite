import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eg")
public class class153 {
   @ObfuscatedName("w")
   static final class153 field2271 = new class153("BUILDLIVE", 3);
   @ObfuscatedName("d")
   static final class153 field2272 = new class153("RC", 1);
   @ObfuscatedName("c")
   static final class153 field2273 = new class153("WIP", 2);
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1008460329
   )
   public final int field2274;
   @ObfuscatedName("a")
   static final class153 field2276 = new class153("LIVE", 0);
   @ObfuscatedName("y")
   public final String field2278;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class153(String var1, int var2) {
      this.field2278 = var1;
      this.field2274 = var2;
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-17"
   )
   static final void method3250(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < client.field496; ++var4) {
         if(client.field311[var4] + client.field503[var4] > var0 && client.field311[var4] < var0 + var2 && client.field497[var4] + client.field504[var4] > var1 && client.field497[var4] < var3 + var1) {
            client.field520[var4] = true;
         }
      }

   }
}
