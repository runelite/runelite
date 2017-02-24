import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
public class class99 extends class109 {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -65626969
   )
   int field1644;
   @ObfuscatedName("is")
   @ObfuscatedGetter(
      intValue = 1561238703
   )
   static int field1645;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = 3595773501045279709L
   )
   long field1646 = class0.method11();
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -797208685
   )
   int field1647 = 0;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = 792280195
   )
   static int field1648;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1187961683
   )
   int field1649 = 256;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 668979971
   )
   int field1650 = 1;
   @ObfuscatedName("q")
   long[] field1653 = new long[10];

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIS)I",
      garbageValue = "-4340"
   )
   int vmethod2108(int var1, int var2) {
      int var3 = this.field1649;
      int var4 = this.field1650;
      this.field1649 = 300;
      this.field1650 = 1;
      this.field1646 = class0.method11();
      if(0L == this.field1653[this.field1644]) {
         this.field1649 = var3;
         this.field1650 = var4;
      } else if(this.field1646 > this.field1653[this.field1644]) {
         this.field1649 = (int)((long)(2560 * var1) / (this.field1646 - this.field1653[this.field1644]));
      }

      if(this.field1649 < 25) {
         this.field1649 = 25;
      }

      if(this.field1649 > 256) {
         this.field1649 = 256;
         this.field1650 = (int)((long)var1 - (this.field1646 - this.field1653[this.field1644]) / 10L);
      }

      if(this.field1650 > var1) {
         this.field1650 = var1;
      }

      this.field1653[this.field1644] = this.field1646;
      this.field1644 = (1 + this.field1644) % 10;
      int var5;
      if(this.field1650 > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(0L != this.field1653[var5]) {
               this.field1653[var5] += (long)this.field1650;
            }
         }
      }

      if(this.field1650 < var2) {
         this.field1650 = var2;
      }

      class115.method2292((long)this.field1650);

      for(var5 = 0; this.field1647 < 256; this.field1647 += this.field1649) {
         ++var5;
      }

      this.field1647 &= 255;
      return var5;
   }

   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIZI)V",
      garbageValue = "349310057"
   )
   static void method1995(Widget[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         Widget var6 = var0[var5];
         if(var6 != null && var1 == var6.parentId) {
            class140.method2662(var6, var2, var3, var4);
            ObjectComposition.method3660(var6, var2, var3);
            if(var6.scrollX > var6.scrollWidth - var6.width) {
               var6.scrollX = var6.scrollWidth - var6.width;
            }

            if(var6.scrollX < 0) {
               var6.scrollX = 0;
            }

            if(var6.scrollY > var6.scrollHeight - var6.height) {
               var6.scrollY = var6.scrollHeight - var6.height;
            }

            if(var6.scrollY < 0) {
               var6.scrollY = 0;
            }

            if(var6.type == 0) {
               class154.method3034(var0, var6, var4);
            }
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-1"
   )
   static void method1996() {
      FileOnDisk var0 = null;

      try {
         var0 = class22.method220("", Client.field306.field2689, true);
         Buffer var1 = class184.field2735.method684();
         var0.method1469(var1.payload, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if(var0 != null) {
            var0.method1475();
         }
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1005407619"
   )
   public void vmethod2107() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field1653[var1] = 0L;
      }

   }

   class99() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field1653[var1] = this.field1646;
      }

   }
}
