import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
public class class32 {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -356794397
   )
   static int field715;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -2079097849
   )
   static int field716;
   @ObfuscatedName("q")
   static String[] field717;
   @ObfuscatedName("n")
   static int[] field718;
   @ObfuscatedName("t")
   static int[] field719;
   @ObfuscatedName("u")
   static int[] field720;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -402939849
   )
   @Export("scriptStringStackSize")
   static int scriptStringStackSize;
   @ObfuscatedName("l")
   @Export("scriptStringStack")
   static String[] scriptStringStack;
   @ObfuscatedName("w")
   @Export("scriptStack")
   static ScriptState[] scriptStack;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 74981745
   )
   @Export("scriptStackCount")
   static int scriptStackCount;
   @ObfuscatedName("k")
   static Calendar field726;
   @ObfuscatedName("e")
   static final String[] field727;
   @ObfuscatedName("p")
   static int[][] field728;
   @ObfuscatedName("y")
   static int[] field729;
   @ObfuscatedName("gn")
   static Widget field732;

   static {
      field719 = new int[5];
      field728 = new int[5][5000];
      field720 = new int[1000];
      scriptStringStack = new String[1000];
      scriptStackCount = 0;
      scriptStack = new ScriptState[50];
      field726 = Calendar.getInstance();
      field727 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
      field716 = 0;
   }

   class32() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([Lclass134;II)Lclass134;",
      garbageValue = "-1347960439"
   )
   public static class134 method708(class134[] var0, int var1) {
      class134[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class134 var4 = var2[var3];
         if(var1 == var4.vmethod4163()) {
            return var4;
         }
      }

      return null;
   }
}
