import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
public class class11 {
   @ObfuscatedName("e")
   static final class203 field182 = new class203();
   @ObfuscatedName("i")
   @Export("chatLineMap")
   static final Map chatLineMap = new HashMap();
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1274815283
   )
   static int field185 = 0;
   @ObfuscatedName("h")
   static final class201 field192 = new class201(1024);

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1026427695"
   )
   public static boolean method148(int var0) {
      return (var0 >> 30 & 1) != 0;
   }
}
