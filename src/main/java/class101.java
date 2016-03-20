import java.awt.Image;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cg")
public class class101 extends class207 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 997843893
   )
   int field1751;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -84622943
   )
   int field1752;
   @ObfuscatedName("s")
   int[][] field1753;
   @ObfuscatedName("qz")
   protected static Image field1754;
   @ObfuscatedName("f")
   int[] field1756;
   @ObfuscatedName("po")
   static short[] field1757;

   class101(int var1, byte[] var2) {
      this.field1752 = var1;
      class118 var3 = new class118(var2);
      this.field1751 = var3.method2579();
      this.field1756 = new int[this.field1751];
      this.field1753 = new int[this.field1751][];

      int var4;
      for(var4 = 0; var4 < this.field1751; ++var4) {
         this.field1756[var4] = var3.method2579();
      }

      for(var4 = 0; var4 < this.field1751; ++var4) {
         this.field1753[var4] = new int[var3.method2579()];
      }

      for(var4 = 0; var4 < this.field1751; ++var4) {
         for(int var5 = 0; var5 < this.field1753[var4].length; ++var5) {
            this.field1753[var4][var5] = var3.method2579();
         }
      }

   }

   @ObfuscatedName("f")
   static class8 method2293() {
      class226 var0 = null;
      class8 var1 = new class8();

      try {
         var0 = class135.method2882("", class18.field274.field2272, false);
         byte[] var2 = new byte[(int)var0.method4156()];

         int var4;
         for(int var3 = 0; var3 < var2.length; var3 += var4) {
            var4 = var0.method4157(var2, var3, var2.length - var3);
            if(-1 == var4) {
               throw new IOException();
            }
         }

         var1 = new class8(new class118(var2));
      } catch (Exception var6) {
         ;
      }

      try {
         if(var0 != null) {
            var0.method4168();
         }
      } catch (Exception var5) {
         ;
      }

      return var1;
   }

   @ObfuscatedName("dg")
   static int method2294(class172 var0) {
      class200 var1 = (class200)client.field366.method3824((long)var0.field2744 + ((long)(var0.field2800 * -1) << 32));
      return var1 != null?var1.field3096:var0.field2806;
   }
}
