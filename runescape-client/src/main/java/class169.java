import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fq")
public class class169 {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -798419009
   )
   public static int field2325;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass186;III)I",
      garbageValue = "768236863"
   )
   static int method3168(class186 var0, int var1, int var2) {
      if(var0 == null) {
         return var2;
      } else {
         class198 var3 = (class198)var0.method3559((long)var1);
         return var3 == null?var2:var3.field2480;
      }
   }
}
