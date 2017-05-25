import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dc")
@Implements("GroundObject")
public final class GroundObject {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -819003167
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1577829391
   )
   @Export("x")
   int x;
   @ObfuscatedName("ah")
   static int[] field1847;
   @ObfuscatedName("q")
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1082660123
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -743787227
   )
   @Export("y")
   int y;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1893982255
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("fw")
   @ObfuscatedGetter(
      intValue = 2026640323
   )
   static int field1858;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILScript;ZB)I",
      garbageValue = "122"
   )
   static int method2521(int var0, Script var1, boolean var2) {
      if(var0 == 5630) {
         Client.field986 = 250;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass69;S)V",
      garbageValue = "-11209"
   )
   public static void method2522(class69 var0) {
      class48.method739(var0, 200000);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1290646086"
   )
   static void method2523() {
      FileOnDisk var0 = null;

      try {
         var0 = XGrandExchangeOffer.getPreferencesFile("", class4.field25.name, true);
         Buffer var1 = class134.field1989.method1602();
         var0.method2384(var1.payload, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if(var0 != null) {
            var0.method2385();
         }
      } catch (Exception var2) {
         ;
      }

   }
}
