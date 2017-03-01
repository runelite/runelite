import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
public class class32 {
   @ObfuscatedName("g")
   static int[] field720;
   @ObfuscatedName("v")
   static String[] field723;
   @ObfuscatedName("y")
   static int[] field724 = new int[5];
   @ObfuscatedName("k")
   @Export("scriptStack")
   static ScriptState[] scriptStack = new ScriptState[50];
   @ObfuscatedName("j")
   static int[] field726 = new int[1000];
   @ObfuscatedName("p")
   static int[][] field727 = new int[5][5000];
   @ObfuscatedName("a")
   @Export("scriptStringStack")
   static String[] scriptStringStack = new String[1000];
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -205270317
   )
   @Export("scriptStackCount")
   static int scriptStackCount = 0;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 927742707
   )
   static int field730 = 0;
   @ObfuscatedName("o")
   static Widget field731;
   @ObfuscatedName("q")
   static Calendar field732 = Calendar.getInstance();
   @ObfuscatedName("c")
   static final String[] field733 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1912730233
   )
   static int field735;
   @ObfuscatedName("mr")
   static byte field737;
   @ObfuscatedName("u")
   public static String field738;
   @ObfuscatedName("qr")
   @ObfuscatedGetter(
      intValue = 335750221
   )
   static int field739;

   class32() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(IIB)Lclass119;",
      garbageValue = "0"
   )
   static class119 method768(int var0, int var1) {
      Client.field569.field1858 = var0;
      Client.field569.field1857 = var1;
      Client.field569.field1861 = 1;
      Client.field569.field1856 = 1;
      return Client.field569;
   }
}
