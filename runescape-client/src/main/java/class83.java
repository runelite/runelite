import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
public class class83 {
   @ObfuscatedName("s")
   static int[] field1358;
   @ObfuscatedName("r")
   @Export("SHAPE_VERTICIES")
   static int[][] SHAPE_VERTICIES;
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
   @ObfuscatedName("o")
   @Export("scriptStack")
   static ScriptState[] scriptStack;
   @ObfuscatedName("c")
   static Calendar field1365;
   @ObfuscatedName("m")
   static final String[] field1359;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1498047889
   )
   static int field1367;
   @ObfuscatedName("y")
   @Export("logoSprite")
   static ModIcon logoSprite;
   @ObfuscatedName("q")
   static int[] field1370;
   @ObfuscatedName("a")
   @Export("scriptLocalInts")
   static int[] scriptLocalInts;
   @ObfuscatedName("t")
   @Export("scriptLocalStrings")
   static String[] scriptLocalStrings;
   @ObfuscatedName("l")
   static Widget field1364;

   static {
      field1358 = new int[5];
      SHAPE_VERTICIES = new int[5][5000];
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
      MouseInput.mouseIdleTicks = var0;
   }
}
