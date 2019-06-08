import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lw")
@Implements("ReflectionCheck")
public class ReflectionCheck extends Node {
   @ObfuscatedName("su")
   @ObfuscatedSignature(
      signature = "Lbf;"
   )
   @Export("clientPreferences")
   static ClientPreferences clientPreferences;
   @ObfuscatedName("m")
   @Export("arguments")
   byte[][][] arguments;
   @ObfuscatedName("f")
   @Export("intReplaceValues")
   int[] intReplaceValues;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1955146989
   )
   @Export("id")
   int id;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1091722075
   )
   @Export("size")
   int size;
   @ObfuscatedName("o")
   @Export("operations")
   int[] operations;
   @ObfuscatedName("u")
   @Export("creationErrors")
   int[] creationErrors;
   @ObfuscatedName("g")
   @Export("fields")
   Field[] fields;
   @ObfuscatedName("l")
   @Export("methods")
   Method[] methods;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Z",
      garbageValue = "384237837"
   )
   static boolean method5920(String var0, int var1) {
      return FaceNormal.method3237(var0, var1, "openjs");
   }
}
