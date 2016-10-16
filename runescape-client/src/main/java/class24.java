import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
public final class class24 extends Node {
   @ObfuscatedName("t")
   static Deque field590 = new Deque();
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1480527513
   )
   int field591;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 494761239
   )
   int field592;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1014288045
   )
   int field593;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1919387467
   )
   int field594;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 156524001
   )
   int field595;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1050469335
   )
   int field596;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1977554607
   )
   int field597;
   @ObfuscatedName("h")
   class67 field598;
   @ObfuscatedName("d")
   class67 field599;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1092638849
   )
   int field600;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1265196733
   )
   int field601;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 215169267
   )
   int field602;
   @ObfuscatedName("bo")
   static class171 field603;
   @ObfuscatedName("r")
   ObjectComposition field604;
   @ObfuscatedName("u")
   int[] field605;
   @ObfuscatedName("c")
   public static String field606;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IB)Lclass54;",
      garbageValue = "-27"
   )
   public static class54 method578(int var0) {
      class54 var1 = (class54)class54.field1128.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class54.field1136.method3272(5, var0);
         var1 = new class54();
         if(var2 != null) {
            var1.method1074(new Buffer(var2));
         }

         class54.field1128.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1077935689"
   )
   void method584() {
      int var1 = this.field597;
      ObjectComposition var2 = this.field604.getImpostor();
      if(var2 != null) {
         this.field597 = var2.field952;
         this.field596 = var2.field953 * 128;
         this.field592 = var2.field954;
         this.field600 = var2.field955;
         this.field605 = var2.field956;
      } else {
         this.field597 = -1;
         this.field596 = 0;
         this.field592 = 0;
         this.field600 = 0;
         this.field605 = null;
      }

      if(this.field597 != var1 && this.field598 != null) {
         class75.field1389.method1144(this.field598);
         this.field598 = null;
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)Lclass49;",
      garbageValue = "1171841095"
   )
   public static class49 method587(int var0) {
      class49 var1 = (class49)class49.field1048.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class49.field1049.method3272(33, var0);
         var1 = new class49();
         if(null != var2) {
            var1.method968(new Buffer(var2));
         }

         class49.field1048.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1107790976"
   )
   public static int method588(int var0) {
      var0 = (var0 >>> 1 & 1431655765) + (var0 & 1431655765);
      var0 = (var0 >>> 2 & 858993459) + (var0 & 858993459);
      var0 = (var0 >>> 4) + var0 & 252645135;
      var0 += var0 >>> 8;
      var0 += var0 >>> 16;
      return var0 & 255;
   }
}
