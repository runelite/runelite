import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
public class class83 {
   @ObfuscatedName("o")
   @Export("scriptStack")
   static ScriptState[] scriptStack;
   @ObfuscatedName("t")
   @Export("scriptLocalStrings")
   static String[] scriptLocalStrings;
   @ObfuscatedName("s")
   static int[] field1358;
   @ObfuscatedName("m")
   static final String[] field1359;
   @ObfuscatedName("v")
   @Export("intStack")
   static int[] intStack;
   @ObfuscatedName("j")
   @Export("scriptStringStack")
   static String[] scriptStringStack;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 96172915
   )
   @Export("scriptStackCount")
   static int scriptStackCount;
   @ObfuscatedName("r")
   static int[][] field1363;
   @ObfuscatedName("l")
   static Widget field1364;
   @ObfuscatedName("c")
   static Calendar field1365;
   @ObfuscatedName("a")
   @Export("scriptLocalInts")
   static int[] scriptLocalInts;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1498047889
   )
   static int field1367;
   @ObfuscatedName("y")
   static ModIcon field1369;
   @ObfuscatedName("q")
   static int[] field1370;

   static {
      field1358 = new int[5];
      field1363 = new int[5][5000];
      intStack = new int[1000];
      scriptStringStack = new String[1000];
      scriptStackCount = 0;
      scriptStack = new ScriptState[50];
      field1365 = Calendar.getInstance();
      field1359 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
      field1367 = 0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1956252938"
   )
   public static void method1674(int var0) {
      class59.mouseIdleTicks = var0;
   }
}
