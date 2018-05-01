import java.util.HashMap;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gc")
public class class189 {
   @ObfuscatedName("c")
   static int[] field2514;

   static {
      new HashMap();
   }

   @ObfuscatedName("ku")
   @ObfuscatedSignature(
      signature = "(Lgg;II)V",
      garbageValue = "-1959520549"
   )
   static void method3559(Buffer var0, int var1) {
      ISAACCipher.method3908(var0.payload, var1);
      WorldComparator.method74(var0, var1);
   }
}
