import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
public class class13 implements Runnable {
   @ObfuscatedName("ci")
   static class143 field195;
   @ObfuscatedName("b")
   boolean field196 = true;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -958823347
   )
   int field197 = 0;
   @ObfuscatedName("x")
   int[] field198 = new int[500];
   @ObfuscatedName("dw")
   static byte[][] field199;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -180448007
   )
   static int field200;
   @ObfuscatedName("g")
   Object field201 = new Object();
   @ObfuscatedName("d")
   int[] field202 = new int[500];

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1773809853"
   )
   public static int method156(int var0) {
      return var0 > 0?1:(var0 < 0?-1:0);
   }

   public void run() {
      for(; this.field196; class116.method2459(50L)) {
         Object var1 = this.field201;
         synchronized(this.field201) {
            if(this.field197 < 500) {
               this.field202[this.field197] = class140.field2134;
               this.field198[this.field197] = class140.field2135;
               ++this.field197;
            }
         }
      }

   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1003953566"
   )
   static final void method159(boolean var0) {
      class124.method2824();
      ++client.field337;
      if(client.field337 >= 50 || var0) {
         client.field337 = 0;
         if(!client.field342 && null != field195) {
            client.field331.method2781(210);

            try {
               field195.method3020(client.field331.field1982, 0, client.field331.field1976);
               client.field331.field1976 = 0;
            } catch (IOException var2) {
               client.field342 = true;
            }
         }

      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1668102717"
   )
   static final int method160(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = var1 * (var0 & 127) / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }
}
