import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ft")
public class class181 extends CacheableNode {
   @ObfuscatedName("o")
   public class184 field2708;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -385280891
   )
   public int field2709;
   @ObfuscatedName("b")
   public byte field2710;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1619480893
   )
   public static int field2711;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/Class;",
      garbageValue = "1991660969"
   )
   static Class method3199(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Class.forName(var0)))))))));
   }
}
