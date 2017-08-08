import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ek")
public enum class150 implements RSEnum {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lek;"
   )
   field2185(2, 0),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lek;"
   )
   field2181(1, 1),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lek;"
   )
   field2184(3, 2),
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lek;"
   )
   field2183(0, 3);

   @ObfuscatedName("pv")
   @ObfuscatedGetter(
      intValue = -127659451
   )
   static int field2180;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 419290233
   )
   public final int field2182;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -939141307
   )
   final int field2186;

   class150(int var3, int var4) {
      this.field2182 = var3;
      this.field2186 = var4;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "834678576"
   )
   public int rsOrdinal() {
      return this.field2186;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(CI)C",
      garbageValue = "-1867126434"
   )
   static char method2942(char var0) {
      return (char)(var0 == 198?'E':(var0 == 230?'e':(var0 == 223?'s':(var0 == 338?'E':(var0 == 339?'e':'\u0000')))));
   }
}
