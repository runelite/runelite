import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("di")
@Implements("FrameMap")
public class class105 extends class211 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1241198231
   )
   int field1829;
   @ObfuscatedName("e")
   int[] field1831;
   @ObfuscatedName("o")
   int[][] field1832;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 948987475
   )
   public static int field1834;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1320478393
   )
   int field1837;

   class105(int var1, byte[] var2) {
      this.field1829 = var1;
      class122 var3 = new class122(var2);
      this.field1837 = var3.method2556();
      this.field1831 = new int[this.field1837];
      this.field1832 = new int[this.field1837][];

      int var4;
      for(var4 = 0; var4 < this.field1837; ++var4) {
         this.field1831[var4] = var3.method2556();
      }

      for(var4 = 0; var4 < this.field1837; ++var4) {
         this.field1832[var4] = new int[var3.method2556()];
      }

      for(var4 = 0; var4 < this.field1837; ++var4) {
         for(int var5 = 0; var5 < this.field1832[var4].length; ++var5) {
            this.field1832[var4][var5] = var3.method2556();
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1943851820"
   )
   public static void method2359() {
      if(class174.field2766 != null) {
         class174.field2766.method3050();
      }

   }
}
