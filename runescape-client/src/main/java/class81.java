import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
public class class81 {
   @ObfuscatedName("rl")
   @ObfuscatedGetter(
      intValue = 1392282369
   )
   static int field1287;
   @ObfuscatedName("t")
   @Export("scriptLocalInts")
   static int[] scriptLocalInts;
   @ObfuscatedName("d")
   @Export("scriptLocalStrings")
   static String[] scriptLocalStrings;
   @ObfuscatedName("h")
   static int[] field1282;
   @ObfuscatedName("m")
   @Export("SHAPE_VERTICES")
   static int[][] SHAPE_VERTICES;
   @ObfuscatedName("z")
   @Export("intStack")
   static int[] intStack;
   @ObfuscatedName("u")
   @Export("scriptStringStack")
   static String[] scriptStringStack;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1788554331
   )
   @Export("scriptStackCount")
   static int scriptStackCount;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "[Lbo;"
   )
   @Export("scriptStack")
   static ScriptState[] scriptStack;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lin;"
   )
   static Widget field1285;
   @ObfuscatedName("l")
   static Calendar field1284;
   @ObfuscatedName("s")
   static final String[] field1291;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 311283157
   )
   static int field1288;

   static {
      field1282 = new int[5];
      SHAPE_VERTICES = new int[5][5000];
      intStack = new int[1000];
      scriptStringStack = new String[1000];
      scriptStackCount = 0;
      scriptStack = new ScriptState[50];
      field1284 = Calendar.getInstance();
      field1291 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
      field1288 = 0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(CB)C",
      garbageValue = "1"
   )
   static char method1849(char var0) {
      return var0 != 181 && var0 != 131?Character.toTitleCase(var0):var0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIZIZI)V",
      garbageValue = "-1939266148"
   )
   static void method1848(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var0 + var1) / 2;
         int var7 = var0;
         World var8 = World.worldList[var6];
         World.worldList[var6] = World.worldList[var1];
         World.worldList[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            if(Client.method1503(World.worldList[var9], var8, var2, var3, var4, var5) <= 0) {
               World var10 = World.worldList[var9];
               World.worldList[var9] = World.worldList[var7];
               World.worldList[var7++] = var10;
            }
         }

         World.worldList[var1] = World.worldList[var7];
         World.worldList[var7] = var8;
         method1848(var0, var7 - 1, var2, var3, var4, var5);
         method1848(var7 + 1, var1, var2, var3, var4, var5);
      }

   }
}
