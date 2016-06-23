import java.awt.Frame;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ca")
@Implements("FrameMap")
public class class102 extends class208 {
   @ObfuscatedName("qc")
   protected static Frame field1764;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1293587793
   )
   int field1765;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 138934325
   )
   int field1766;
   @ObfuscatedName("b")
   int[][] field1767;
   @ObfuscatedName("x")
   int[] field1769;

   class102(int var1, byte[] var2) {
      this.field1766 = var1;
      class119 var3 = new class119(var2);
      this.field1765 = var3.method2554();
      this.field1769 = new int[this.field1765];
      this.field1767 = new int[this.field1765][];

      int var4;
      for(var4 = 0; var4 < this.field1765; ++var4) {
         this.field1769[var4] = var3.method2554();
      }

      for(var4 = 0; var4 < this.field1765; ++var4) {
         this.field1767[var4] = new int[var3.method2554()];
      }

      for(var4 = 0; var4 < this.field1765; ++var4) {
         for(int var5 = 0; var5 < this.field1767[var4].length; ++var5) {
            this.field1767[var4][var5] = var3.method2554();
         }
      }

   }
}
