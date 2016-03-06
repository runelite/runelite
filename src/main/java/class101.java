import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cc")
public class class101 extends class207 {
   @ObfuscatedName("nv")
   @ObfuscatedGetter(
      intValue = 291517887
   )
   static int field1769;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1454401067
   )
   int field1770;
   @ObfuscatedName("a")
   int[] field1771;
   @ObfuscatedName("i")
   int[][] field1772;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1630656453
   )
   int field1776;

   @ObfuscatedName("h")
   public static boolean method2245(char var0) {
      return var0 >= 48 && var0 <= 57 || var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }

   @ObfuscatedName("j")
   static void method2246() {
      for(class23 var0 = (class23)class23.field615.method3773(); var0 != null; var0 = (class23)class23.field615.method3772()) {
         if(null != var0.field616) {
            var0.method583();
         }
      }

   }

   class101(int var1, byte[] var2) {
      this.field1776 = var1;
      class118 var3 = new class118(var2);
      this.field1770 = var3.method2453();
      this.field1771 = new int[this.field1770];
      this.field1772 = new int[this.field1770][];

      int var4;
      for(var4 = 0; var4 < this.field1770; ++var4) {
         this.field1771[var4] = var3.method2453();
      }

      for(var4 = 0; var4 < this.field1770; ++var4) {
         this.field1772[var4] = new int[var3.method2453()];
      }

      for(var4 = 0; var4 < this.field1770; ++var4) {
         for(int var5 = 0; var5 < this.field1772[var4].length; ++var5) {
            this.field1772[var4][var5] = var3.method2453();
         }
      }

   }
}
