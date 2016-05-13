import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ct")
@Implements("Frame")
public class class88 {
   @ObfuscatedName("k")
   int[] field1544;
   @ObfuscatedName("o")
   int[] field1545;
   @ObfuscatedName("p")
   static int[] field1546 = new int[500];
   @ObfuscatedName("u")
   int field1547 = -1;
   @ObfuscatedName("d")
   class102 field1548 = null;
   @ObfuscatedName("x")
   static int[] field1549 = new int[500];
   @ObfuscatedName("s")
   static int[] field1550 = new int[500];
   @ObfuscatedName("b")
   int[] field1551;
   @ObfuscatedName("j")
   static int[] field1552 = new int[500];
   @ObfuscatedName("c")
   int[] field1553;
   @ObfuscatedName("l")
   boolean field1554 = false;

   class88(byte[] var1, class102 var2) {
      this.field1548 = var2;
      class119 var3 = new class119(var1);
      class119 var4 = new class119(var1);
      var3.field2005 = 2;
      int var5 = var3.method2492();
      int var6 = -1;
      int var7 = 0;
      var4.field2005 = var3.field2005 + var5;

      int var8;
      for(var8 = 0; var8 < var5; ++var8) {
         int var9 = var3.method2492();
         if(var9 > 0) {
            if(this.field1548.field1773[var8] != 0) {
               for(int var10 = var8 - 1; var10 > var6; --var10) {
                  if(this.field1548.field1773[var10] == 0) {
                     field1550[var7] = var10;
                     field1552[var7] = 0;
                     field1546[var7] = 0;
                     field1549[var7] = 0;
                     ++var7;
                     break;
                  }
               }
            }

            field1550[var7] = var8;
            short var11 = 0;
            if(this.field1548.field1773[var8] == 3) {
               var11 = 128;
            }

            if((var9 & 1) != 0) {
               field1552[var7] = var4.method2585();
            } else {
               field1552[var7] = var11;
            }

            if((var9 & 2) != 0) {
               field1546[var7] = var4.method2585();
            } else {
               field1546[var7] = var11;
            }

            if((var9 & 4) != 0) {
               field1549[var7] = var4.method2585();
            } else {
               field1549[var7] = var11;
            }

            var6 = var8;
            ++var7;
            if(this.field1548.field1773[var8] == 5) {
               this.field1554 = true;
            }
         }
      }

      if(var4.field2005 != var1.length) {
         throw new RuntimeException();
      } else {
         this.field1547 = var7;
         this.field1545 = new int[var7];
         this.field1551 = new int[var7];
         this.field1544 = new int[var7];
         this.field1553 = new int[var7];

         for(var8 = 0; var8 < var7; ++var8) {
            this.field1545[var8] = field1550[var8];
            this.field1551[var8] = field1552[var8];
            this.field1544[var8] = field1546[var8];
            this.field1553[var8] = field1549[var8];
         }

      }
   }
}
