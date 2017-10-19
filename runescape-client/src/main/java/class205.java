import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gu")
public class class205 extends Node {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgf;"
   )
   class202 field2537;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1551196891
   )
   int field2534;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   class207 field2551;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ldi;"
   )
   class105 field2536;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Ldl;"
   )
   class115 field2552;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1483672565
   )
   int field2542;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 717127085
   )
   int field2549;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -8855109
   )
   int field2541;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 637317575
   )
   int field2544;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 865361469
   )
   int field2535;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1882551857
   )
   int field2543;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1426805589
   )
   int field2538;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 434238685
   )
   int field2540;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -818501461
   )
   int field2554;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -250241659
   )
   int field2539;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1133965931
   )
   int field2550;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1415069567
   )
   int field2545;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1636988085
   )
   int field2546;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1770665375
   )
   int field2553;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -608150529
   )
   int field2547;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 939398725
   )
   int field2548;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1979180989"
   )
   void method3903() {
      this.field2551 = null;
      this.field2536 = null;
      this.field2537 = null;
      this.field2552 = null;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Lic;",
      garbageValue = "-1798897340"
   )
   public static class254 method3904(int var0) {
      class254 var1 = (class254)class254.field3413.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class254.field3430.getConfigData(32, var0);
         var1 = new class254();
         if(var2 != null) {
            var1.method4559(new Buffer(var2));
         }

         class254.field3413.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-11"
   )
   public static void method3905() {
      while(true) {
         Deque var1 = class236.field3229;
         FileSystem var0;
         synchronized(class236.field3229) {
            var0 = (FileSystem)class236.field3227.popFront();
         }

         if(var0 == null) {
            return;
         }

         var0.data.method4298(var0.index, (int)var0.hash, var0.field3197, false);
      }
   }
}
