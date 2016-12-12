import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hi")
public class class215 {
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/Class;",
      garbageValue = "-1375301108"
   )
   static Class method3871(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Class.forName(var0)))))))));
   }
}
