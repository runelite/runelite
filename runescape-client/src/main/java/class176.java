import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fa")
public class class176 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = 4423716568838645943L
   )
   static long field2407;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "[[Lhi;"
   )
   @Export("widgets")
   public static Widget[][] widgets;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = 3136283812362462127L
   )
   static long field2404;
   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   @Export("indexSprites")
   static IndexData indexSprites;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lia;Lia;Lia;B)V",
      garbageValue = "96"
   )
   public static void method3394(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2) {
      class255.field3405 = var0;
      class255.field3400 = var1;
      class255.field3401 = var2;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ILcj;ZI)I",
      garbageValue = "-1584418015"
   )
   static int method3390(int var0, Script var1, boolean var2) {
      if(var0 == 5630) {
         Client.field987 = 250;
         return 1;
      } else {
         return 2;
      }
   }
}
