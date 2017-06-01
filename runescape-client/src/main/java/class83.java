import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ca")
public class class83 {
   @ObfuscatedName("e")
   @Export("scriptLocalInts")
   static int[] scriptLocalInts;
   @ObfuscatedName("y")
   static int[][] field1357;
   @ObfuscatedName("b")
   static int[] field1359;
   @ObfuscatedName("n")
   static IndexDataBase field1361;
   @ObfuscatedName("h")
   @Export("intStack")
   static int[] intStack;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1991590583
   )
   @Export("scriptStackCount")
   static int scriptStackCount;
   @ObfuscatedName("o")
   @Export("scriptStack")
   static ScriptState[] scriptStack;
   @ObfuscatedName("j")
   static Calendar field1366;
   @ObfuscatedName("k")
   static final String[] field1367;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 864895621
   )
   static int field1368;
   @ObfuscatedName("v")
   @Export("scriptLocalStrings")
   static String[] scriptLocalStrings;
   @ObfuscatedName("f")
   @Export("scriptStringStack")
   static String[] scriptStringStack;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -883196519
   )
   @Export("intStackSize")
   static int intStackSize;

   static {
      field1359 = new int[5];
      field1357 = new int[5][5000];
      intStack = new int[1000];
      scriptStringStack = new String[1000];
      scriptStackCount = 0;
      scriptStack = new ScriptState[50];
      field1366 = Calendar.getInstance();
      field1367 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
      field1368 = 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SS)V",
      garbageValue = "32767"
   )
   public static void method1640(String[] var0, short[] var1) {
      Renderable.method2862(var0, var1, 0, var0.length - 1);
   }

   @ObfuscatedName("fs")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-2336"
   )
   static void method1656() {
      if(class1.field14 != null) {
         class1.field14.method5234(FaceNormal.plane, class41.baseX + (World.localPlayer.x >> 7), WorldMapType3.baseY + (World.localPlayer.y >> 7), false);
         class1.field14.method5194();
      }

   }
}
