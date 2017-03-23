import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("hp")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("r")
   public int[] field3235;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1043811493
   )
   public int field3236;
   @ObfuscatedName("h")
   public int[] field3237;
   @ObfuscatedName("f")
   public int[] field3238;
   @ObfuscatedName("o")
   @Export("fields")
   public Field[] fields;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1312059687
   )
   public int field3240;
   @ObfuscatedName("l")
   @Export("methods")
   public Method[] methods;
   @ObfuscatedName("n")
   @Export("args")
   public byte[][][] args;
   @ObfuscatedName("d")
   static int[] field3243;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/Class;",
      garbageValue = "-741730879"
   )
   public static Class method4259(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Reflection.findClass(var0)))))))));
   }
}
