import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
public class class151 extends class283 {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -135369585
   )
   static int field2085;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "[Lde;"
   )
   @Export("idxFiles")
   public static CacheFile[] idxFiles;
   @ObfuscatedName("ez")
   @ObfuscatedGetter(
      intValue = -973266613
   )
   static int field2086;
   @ObfuscatedName("b")
   final boolean field2088;

   public class151(boolean var1) {
      this.field2088 = var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lku;Lku;B)I",
      garbageValue = "-67"
   )
   int method3121(ChatPlayer var1, ChatPlayer var2) {
      return Client.world == var1.world && var2.world == Client.world?(this.field2088?var1.field3718 - var2.field3718:var2.field3718 - var1.field3718):this.method5214(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3121((ChatPlayer)var1, (ChatPlayer)var2);
   }
}
