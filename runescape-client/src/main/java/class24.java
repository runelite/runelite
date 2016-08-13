import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
public final class class24 extends Node {
   @ObfuscatedName("j")
   public static String field620;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -114433235
   )
   int field621;
   @ObfuscatedName("m")
   class67 field622;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1353368175
   )
   int field623;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1416527161
   )
   int field624;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -2083071865
   )
   int field625;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -224408197
   )
   int field626;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -373877467
   )
   int field627;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 53110893
   )
   int field628;
   @ObfuscatedName("p")
   int[] field629;
   @ObfuscatedName("l")
   static Deque field630 = new Deque();
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -39442857
   )
   int field631;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1433879281
   )
   int field632;
   @ObfuscatedName("o")
   class67 field633;
   @ObfuscatedName("r")
   ObjectComposition field634;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1254681397
   )
   int field635;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)Lclass50;",
      garbageValue = "-100"
   )
   public static class50 method602(int var0) {
      class50 var1 = (class50)class50.field1117.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class50.field1125.method3411(14, var0);
         var1 = new class50();
         if(null != var2) {
            var1.method1075(new Buffer(var2));
         }

         class50.field1117.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-361272124"
   )
   void method603() {
      int var1 = this.field627;
      ObjectComposition var2 = this.field634.getImpostor();
      if(var2 != null) {
         this.field627 = var2.field989;
         this.field626 = var2.field990 * 128;
         this.field631 = var2.field967;
         this.field625 = var2.field992;
         this.field629 = var2.field993;
      } else {
         this.field627 = -1;
         this.field626 = 0;
         this.field631 = 0;
         this.field625 = 0;
         this.field629 = null;
      }

      if(this.field627 != var1 && null != this.field622) {
         class20.field585.method1285(this.field622);
         this.field622 = null;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass125;I)I",
      garbageValue = "511997140"
   )
   static int method613(class125 var0) {
      int var1 = var0.method2907(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.method2907(5);
      } else if(var1 == 2) {
         var2 = var0.method2907(8);
      } else {
         var2 = var0.method2907(11);
      }

      return var2;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass170;II)Z",
      garbageValue = "1096379950"
   )
   static boolean method614(class170 var0, int var1) {
      byte[] var2 = var0.method3402(var1);
      if(null == var2) {
         return false;
      } else {
         Player.method28(var2);
         return true;
      }
   }
}
