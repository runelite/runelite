import java.awt.Component;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cb")
@Implements("XClanMember")
public class class102 extends class208 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1301762175
   )
   int field1773;
   @ObfuscatedName("at")
   static class146 field1775;
   @ObfuscatedName("p")
   int[][] field1776;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -93732025
   )
   int field1777;
   @ObfuscatedName("t")
   int[] field1779;

   @ObfuscatedName("db")
   static boolean method2282(class173 var0) {
      if(client.field521) {
         if(class169.method3395(var0) != 0) {
            return false;
         }

         if(0 == var0.field2814) {
            return false;
         }
      }

      return var0.field2787;
   }

   @ObfuscatedName("w")
   public static void method2283(Component var0) {
      var0.removeMouseListener(class140.field2163);
      var0.removeMouseMotionListener(class140.field2163);
      var0.removeFocusListener(class140.field2163);
      class140.field2165 = 0;
   }

   class102(int var1, byte[] var2) {
      this.field1777 = var1;
      class119 var3 = new class119(var2);
      this.field1773 = var3.method2506();
      this.field1779 = new int[this.field1773];
      this.field1776 = new int[this.field1773][];

      int var4;
      for(var4 = 0; var4 < this.field1773; ++var4) {
         this.field1779[var4] = var3.method2506();
      }

      for(var4 = 0; var4 < this.field1773; ++var4) {
         this.field1776[var4] = new int[var3.method2506()];
      }

      for(var4 = 0; var4 < this.field1773; ++var4) {
         for(int var5 = 0; var5 < this.field1776[var4].length; ++var5) {
            this.field1776[var4][var5] = var3.method2506();
         }
      }

   }
}
