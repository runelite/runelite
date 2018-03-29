import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
public class class81 {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1519128555
   )
   @Export("indexedSpriteHeight")
   static int indexedSpriteHeight;
   @ObfuscatedName("k")
   static int[] field1270;
   @ObfuscatedName("x")
   @Export("SHAPE_VERTICES")
   static int[][] SHAPE_VERTICES;
   @ObfuscatedName("z")
   @Export("intStack")
   static int[] intStack;
   @ObfuscatedName("w")
   @Export("scriptStringStack")
   static String[] scriptStringStack;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1641541167
   )
   @Export("scriptStackCount")
   static int scriptStackCount;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "[Lbb;"
   )
   @Export("scriptStack")
   static ScriptState[] scriptStack;
   @ObfuscatedName("l")
   static Calendar field1268;
   @ObfuscatedName("m")
   static final String[] field1277;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1498081639
   )
   static int field1278;

   static {
      field1270 = new int[5];
      SHAPE_VERTICES = new int[5][5000];
      intStack = new int[1000];
      scriptStringStack = new String[1000];
      scriptStackCount = 0;
      scriptStack = new ScriptState[50];
      field1268 = Calendar.getInstance();
      field1277 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
      field1278 = 0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)[Lgk;",
      garbageValue = "-1070839783"
   )
   public static class183[] method1786() {
      return new class183[]{class183.field2484, class183.field2489, class183.field2482, class183.field2490, class183.field2481, class183.field2485, class183.field2486, class183.field2487, class183.field2488, class183.field2483};
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1812522594"
   )
   public static final void method1796() {
      while(true) {
         BoundingBox var0 = (BoundingBox)class7.boundingBoxes.removeLast();
         if(var0 == null) {
            return;
         }

         var0.vmethod63();
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-501563263"
   )
   public static void method1763() {
      FloorUnderlayDefinition.underlays.reset();
   }
}
