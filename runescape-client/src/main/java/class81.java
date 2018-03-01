import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
public class class81 {
   @ObfuscatedName("n")
   @Export("scriptLocalInts")
   static int[] scriptLocalInts;
   @ObfuscatedName("r")
   @Export("scriptLocalStrings")
   static String[] scriptLocalStrings;
   @ObfuscatedName("e")
   static int[] field1264;
   @ObfuscatedName("y")
   @Export("SHAPE_VERTICES")
   static int[][] SHAPE_VERTICES;
   @ObfuscatedName("k")
   @Export("intStack")
   static int[] intStack;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1149371675
   )
   @Export("intStackSize")
   static int intStackSize;
   @ObfuscatedName("p")
   @Export("scriptStringStack")
   static String[] scriptStringStack;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1369718521
   )
   @Export("scriptStackCount")
   static int scriptStackCount;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "[Lbx;"
   )
   @Export("scriptStack")
   static ScriptState[] scriptStack;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Liw;"
   )
   static Widget field1267;
   @ObfuscatedName("u")
   static Calendar field1268;
   @ObfuscatedName("q")
   static final String[] field1269;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1389089625
   )
   static int field1270;

   static {
      field1264 = new int[5];
      SHAPE_VERTICES = new int[5][5000];
      intStack = new int[1000];
      scriptStringStack = new String[1000];
      scriptStackCount = 0;
      scriptStack = new ScriptState[50];
      field1268 = Calendar.getInstance();
      field1269 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
      field1270 = 0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljk;Ljava/lang/String;Ljava/lang/String;I)Llv;",
      garbageValue = "1136550099"
   )
   @Export("getSprite")
   public static IndexedSprite getSprite(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      IndexedSprite var5;
      if(!AbstractByteBuffer.method3843(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = class19.method140();
      }

      return var5;
   }
}
