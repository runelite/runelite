import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("aw")
public class class32 {
   @ObfuscatedName("u")
   static int[] field739;
   @ObfuscatedName("h")
   static String[] field740;
   @ObfuscatedName("r")
   static int[] field741 = new int[5];
   @ObfuscatedName("o")
   static int[][] field742 = new int[5][5000];
   @ObfuscatedName("l")
   static int[] field743 = new int[1000];
   @ObfuscatedName("y")
   static final String[] field744 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -250770567
   )
   @Export("scriptStackCount")
   static int scriptStackCount = 0;
   @ObfuscatedName("q")
   static Widget field746;
   @ObfuscatedName("s")
   @Export("scriptStack")
   static ScriptState[] scriptStack = new ScriptState[50];
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1877349179
   )
   @Export("scriptStringStackSize")
   static int scriptStringStackSize;
   @ObfuscatedName("m")
   @Export("scriptStringStack")
   static String[] scriptStringStack = new String[1000];
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1004546177
   )
   static int field751 = 0;
   @ObfuscatedName("p")
   static Calendar field752 = Calendar.getInstance();
   @ObfuscatedName("qy")
   @ObfuscatedGetter(
      intValue = -171190581
   )
   public static int field755;

   class32() throws Throwable {
      throw new Error();
   }
}
