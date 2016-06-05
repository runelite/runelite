import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ei")
public class class153 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1160516043
   )
   public final int field2303;
   @ObfuscatedName("t")
   static final class153 field2304 = new class153("LIVE", 0);
   @ObfuscatedName("i")
   static final class153 field2305 = new class153("BUILDLIVE", 3);
   @ObfuscatedName("g")
   static final class153 field2306 = new class153("RC", 1);
   @ObfuscatedName("z")
   public final String field2307;
   @ObfuscatedName("h")
   static final class153 field2308 = new class153("WIP", 2);

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class153(String var1, int var2) {
      this.field2307 = var1;
      this.field2303 = var2;
   }
}
