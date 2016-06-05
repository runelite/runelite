import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ew")
public final class class150 {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "23"
   )
   static int method3118(int var0, int var1) {
      class15 var2 = (class15)class15.field222.method3748((long)var0);
      return var2 == null?-1:(var1 >= 0 && var1 < var2.field220.length?var2.field220[var1]:-1);
   }
}
