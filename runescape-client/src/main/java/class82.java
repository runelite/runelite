import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
public class class82 {
   @ObfuscatedName("pa")
   @ObfuscatedGetter(
      intValue = 1763093101
   )
   static int field1272;
   @ObfuscatedName("y")
   @Export("scriptLocalInts")
   static int[] scriptLocalInts;
   @ObfuscatedName("r")
   @Export("scriptLocalStrings")
   static String[] scriptLocalStrings;
   @ObfuscatedName("h")
   static int[] field1260;
   @ObfuscatedName("d")
   @Export("SHAPE_VERTICES")
   static int[][] SHAPE_VERTICES;
   @ObfuscatedName("s")
   @Export("intStack")
   static int[] intStack;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1553638675
   )
   @Export("intStackSize")
   static int intStackSize;
   @ObfuscatedName("e")
   @Export("scriptStringStack")
   static String[] scriptStringStack;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -2098419305
   )
   @Export("scriptStackCount")
   static int scriptStackCount;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "[Lbu;"
   )
   @Export("scriptStack")
   static ScriptState[] scriptStack;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   static Widget field1267;
   @ObfuscatedName("t")
   static Calendar field1258;
   @ObfuscatedName("o")
   static final String[] field1269;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lau;"
   )
   static class47 field1270;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 626139937
   )
   static int field1271;

   static {
      field1260 = new int[5];
      SHAPE_VERTICES = new int[5][5000];
      intStack = new int[1000];
      scriptStringStack = new String[1000];
      scriptStackCount = 0;
      scriptStack = new ScriptState[50];
      field1258 = Calendar.getInstance();
      field1269 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
      field1271 = 0;
   }
}
