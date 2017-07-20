import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
public class class83 {
   @ObfuscatedName("g")
   static int[] field1320;
   @ObfuscatedName("m")
   @Export("SHAPE_VERTICIES")
   static int[][] SHAPE_VERTICIES;
   @ObfuscatedName("s")
   @Export("intStack")
   static int[] intStack;
   @ObfuscatedName("p")
   @Export("scriptStringStack")
   static String[] scriptStringStack;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 978273867
   )
   @Export("scriptStackCount")
   static int scriptStackCount;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Lbj;"
   )
   @Export("scriptStack")
   static ScriptState[] scriptStack;
   @ObfuscatedName("t")
   static Calendar field1335;
   @ObfuscatedName("a")
   static final String[] field1332;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1759908985
   )
   static int field1333;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 960029405
   )
   @Export("scriptStringStackSize")
   static int scriptStringStackSize;
   @ObfuscatedName("i")
   @Export("scriptLocalInts")
   static int[] scriptLocalInts;
   @ObfuscatedName("u")
   @Export("scriptLocalStrings")
   static String[] scriptLocalStrings;
   @ObfuscatedName("qd")
   @ObfuscatedGetter(
      intValue = 788382763
   )
   static int field1334;

   static {
      field1320 = new int[5];
      SHAPE_VERTICIES = new int[5][5000];
      intStack = new int[1000];
      scriptStringStack = new String[1000];
      scriptStackCount = 0;
      scriptStack = new ScriptState[50];
      field1335 = Calendar.getInstance();
      field1332 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
      field1333 = 0;
   }
}
