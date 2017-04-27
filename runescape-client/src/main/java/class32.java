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
   static int field716 = 0;
   @ObfuscatedName("q")
   static String[] field717;
   @ObfuscatedName("n")
   static int[] field718;
   @ObfuscatedName("t")
   static int[] field719 = new int[5];
   @ObfuscatedName("u")
   static int[] field720 = new int[1000];
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -402939849
   )
   @Export("scriptStringStackSize")
   static int scriptStringStackSize;
   @ObfuscatedName("l")
   @Export("scriptStringStack")
   static String[] scriptStringStack = new String[1000];
   @ObfuscatedName("w")
   @Export("scriptStack")
   static ScriptState[] scriptStack = new ScriptState[50];
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 74981745
   )
   @Export("scriptStackCount")
   static int scriptStackCount = 0;
   @ObfuscatedName("k")
   static Calendar field726 = Calendar.getInstance();
   @ObfuscatedName("e")
   static final String[] field727 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
   @ObfuscatedName("p")
   static int[][] field728 = new int[5][5000];
   @ObfuscatedName("y")
   static int[] field729;
   @ObfuscatedName("gn")
   static Widget field732;

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
