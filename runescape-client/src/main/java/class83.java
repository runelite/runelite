import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("co")
public class class83 {
   @ObfuscatedName("t")
   @Export("scriptLocalStrings")
   static String[] scriptLocalStrings;
   @ObfuscatedName("w")
   static int[] field1327;
   @ObfuscatedName("g")
   static Calendar field1328;
   @ObfuscatedName("j")
   @Export("intStack")
   static int[] intStack;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 506278977
   )
   @Export("intStackSize")
   static int intStackSize;
   @ObfuscatedName("f")
   @Export("scriptStringStack")
   static String[] scriptStringStack;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -834739151
   )
   @Export("scriptStackCount")
   static int scriptStackCount;
   @ObfuscatedName("q")
   @Export("scriptStack")
   static ScriptState[] scriptStack;
   @ObfuscatedName("z")
   static int[][] field1334;
   @ObfuscatedName("v")
   static final String[] field1335;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 2004309725
   )
   static int field1336;
   @ObfuscatedName("e")
   @Export("scriptLocalInts")
   static int[] scriptLocalInts;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Ljava/lang/Class;",
      garbageValue = "5"
   )
   public static Class method1560(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Reflection.findClass(var0)))))))));
   }

   static {
      field1327 = new int[5];
      field1334 = new int[5][5000];
      intStack = new int[1000];
      scriptStringStack = new String[1000];
      scriptStackCount = 0;
      scriptStack = new ScriptState[50];
      field1328 = Calendar.getInstance();
      field1335 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
      field1336 = 0;
   }
}
