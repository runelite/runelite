import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fb")
public class class172 extends Node {
   @ObfuscatedName("j")
   class137 field2762;
   @ObfuscatedName("r")
   byte[] field2763;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -154545885
   )
   int field2764;
   @ObfuscatedName("z")
   class171 field2765;
   @ObfuscatedName("q")
   static int[] field2766;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/Class;",
      garbageValue = "-761133707"
   )
   public static Class method3393(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Class.forName(var0)))))))));
   }
}
