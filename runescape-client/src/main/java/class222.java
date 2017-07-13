import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ht")
public class class222 {
   @ObfuscatedName("j")
   public static final boolean[] field2841;
   @ObfuscatedName("n")
   public static int[] field2839;

   static {
      field2841 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
      field2839 = new int[99];
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = var1 + 1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2839[var1] = var0 / 4;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-929296159"
   )
   static int method4057(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class83.field1336:class1.field9;
      if(var0 == 1600) {
         class83.intStack[++WorldMapType2.intStackSize - 1] = var3.scrollX;
         return 1;
      } else if(var0 == 1601) {
         class83.intStack[++WorldMapType2.intStackSize - 1] = var3.scrollY;
         return 1;
      } else if(var0 == 1602) {
         class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var3.text;
         return 1;
      } else if(var0 == 1603) {
         class83.intStack[++WorldMapType2.intStackSize - 1] = var3.scrollWidth;
         return 1;
      } else if(var0 == 1604) {
         class83.intStack[++WorldMapType2.intStackSize - 1] = var3.scrollHeight;
         return 1;
      } else if(var0 == 1605) {
         class83.intStack[++WorldMapType2.intStackSize - 1] = var3.modelZoom;
         return 1;
      } else if(var0 == 1606) {
         class83.intStack[++WorldMapType2.intStackSize - 1] = var3.rotationX;
         return 1;
      } else if(var0 == 1607) {
         class83.intStack[++WorldMapType2.intStackSize - 1] = var3.rotationY;
         return 1;
      } else if(var0 == 1608) {
         class83.intStack[++WorldMapType2.intStackSize - 1] = var3.rotationZ;
         return 1;
      } else if(var0 == 1609) {
         class83.intStack[++WorldMapType2.intStackSize - 1] = var3.opacity;
         return 1;
      } else if(var0 == 1610) {
         class83.intStack[++WorldMapType2.intStackSize - 1] = var3.field2708;
         return 1;
      } else if(var0 == 1611) {
         class83.intStack[++WorldMapType2.intStackSize - 1] = var3.textColor;
         return 1;
      } else if(var0 == 1612) {
         class83.intStack[++WorldMapType2.intStackSize - 1] = var3.field2703;
         return 1;
      } else if(var0 == 1613) {
         class83.intStack[++WorldMapType2.intStackSize - 1] = var3.field2683.rsOrdinal();
         return 1;
      } else {
         return 2;
      }
   }
}
