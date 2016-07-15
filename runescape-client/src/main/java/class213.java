import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hc")
@Implements("ClassInfo")
public class class213 extends class211 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1911117073
   )
   int field3169;
   @ObfuscatedName("u")
   @Export("args")
   byte[][][] field3170;
   @ObfuscatedName("c")
   int[] field3171;
   @ObfuscatedName("h")
   int[] field3172;
   @ObfuscatedName("r")
   @Export("fields")
   Field[] field3173;
   @ObfuscatedName("a")
   int[] field3174;
   @ObfuscatedName("b")
   @Export("methods")
   Method[] field3175;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2110143683
   )
   int field3176;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Ljava/lang/Class;",
      garbageValue = "23"
   )
   static Class method4010(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Class.forName(var0)))))))));
   }
}
