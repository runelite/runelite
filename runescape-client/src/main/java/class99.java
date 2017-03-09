import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
public class class99 extends class109 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = -288363729759056265L
   )
   long field1649 = method2005();
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1045446179
   )
   int field1650 = 256;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 411353221
   )
   int field1651 = 1;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1225829185
   )
   int field1653 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1707580333
   )
   int field1654;
   @ObfuscatedName("bc")
   static class184 field1655;
   @ObfuscatedName("x")
   long[] field1658 = new long[10];
   @ObfuscatedName("bj")
   static ModIcon[] field1660;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass182;III)LSpritePixels;",
      garbageValue = "-1065201010"
   )
   public static SpritePixels method1997(class182 var0, int var1, int var2) {
      return !class65.method1246(var0, var1, var2)?null:Actor.method611();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "531304005"
   )
   int vmethod2108(int var1, int var2) {
      int var3 = this.field1650;
      int var4 = this.field1651;
      this.field1650 = 300;
      this.field1651 = 1;
      this.field1649 = method2005();
      if(this.field1658[this.field1654] == 0L) {
         this.field1650 = var3;
         this.field1651 = var4;
      } else if(this.field1649 > this.field1658[this.field1654]) {
         this.field1650 = (int)((long)(var1 * 2560) / (this.field1649 - this.field1658[this.field1654]));
      }

      if(this.field1650 < 25) {
         this.field1650 = 25;
      }

      if(this.field1650 > 256) {
         this.field1650 = 256;
         this.field1651 = (int)((long)var1 - (this.field1649 - this.field1658[this.field1654]) / 10L);
      }

      if(this.field1651 > var1) {
         this.field1651 = var1;
      }

      this.field1658[this.field1654] = this.field1649;
      this.field1654 = (this.field1654 + 1) % 10;
      int var5;
      if(this.field1651 > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(this.field1658[var5] != 0L) {
               this.field1658[var5] += (long)this.field1651;
            }
         }
      }

      if(this.field1651 < var2) {
         this.field1651 = var2;
      }

      class140.method2660((long)this.field1651);

      for(var5 = 0; this.field1653 < 256; this.field1653 += this.field1650) {
         ++var5;
      }

      this.field1653 &= 255;
      return var5;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-42"
   )
   public void vmethod2107() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field1658[var1] = 0L;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "21"
   )
   public static synchronized long method2005() {
      long var0 = System.currentTimeMillis();
      if(var0 < class155.field2102) {
         class155.field2103 += class155.field2102 - var0;
      }

      class155.field2102 = var0;
      return var0 + class155.field2103;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "81449917"
   )
   static void method2006() {
      Object var0 = class183.field2725;
      synchronized(class183.field2725) {
         if(class183.field2718 == 0) {
            class72.field1193.method2023(new class183(), 5);
         }

         class183.field2718 = 600;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass182;B)V",
      garbageValue = "12"
   )
   public static void method2007(class182 var0) {
      Varbit.field2845 = var0;
   }

   class99() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field1658[var1] = this.field1649;
      }

   }
}
