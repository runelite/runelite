import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cv")
public class class87 {
   @ObfuscatedName("l")
   boolean field1521 = false;
   @ObfuscatedName("r")
   static int[] field1522 = new int[500];
   @ObfuscatedName("f")
   static int[] field1523 = new int[500];
   @ObfuscatedName("s")
   static int[] field1524 = new int[500];
   @ObfuscatedName("y")
   class101 field1525 = null;
   @ObfuscatedName("a")
   static int[] field1526 = new int[500];
   @ObfuscatedName("g")
   int[] field1527;
   @ObfuscatedName("j")
   int[] field1528;
   @ObfuscatedName("m")
   int[] field1529;
   @ObfuscatedName("n")
   int[] field1530;
   @ObfuscatedName("e")
   int field1531 = -1;

   class87(byte[] var1, class101 var2) {
      this.field1525 = var2;
      class118 var3 = new class118(var1);
      class118 var4 = new class118(var1);
      var3.field1979 = 2;
      int var5 = var3.method2579();
      int var6 = -1;
      int var7 = 0;
      var4.field1979 = var3.field1979 + var5;

      int var8;
      for(var8 = 0; var8 < var5; ++var8) {
         int var9 = var3.method2579();
         if(var9 > 0) {
            if(this.field1525.field1756[var8] != 0) {
               for(int var10 = var8 - 1; var10 > var6; --var10) {
                  if(this.field1525.field1756[var10] == 0) {
                     field1526[var7] = var10;
                     field1522[var7] = 0;
                     field1523[var7] = 0;
                     field1524[var7] = 0;
                     ++var7;
                     break;
                  }
               }
            }

            field1526[var7] = var8;
            short var11 = 0;
            if(this.field1525.field1756[var8] == 3) {
               var11 = 128;
            }

            if((var9 & 1) != 0) {
               field1522[var7] = var4.method2524();
            } else {
               field1522[var7] = var11;
            }

            if((var9 & 2) != 0) {
               field1523[var7] = var4.method2524();
            } else {
               field1523[var7] = var11;
            }

            if((var9 & 4) != 0) {
               field1524[var7] = var4.method2524();
            } else {
               field1524[var7] = var11;
            }

            var6 = var8;
            ++var7;
            if(this.field1525.field1756[var8] == 5) {
               this.field1521 = true;
            }
         }
      }

      if(var4.field1979 != var1.length) {
         throw new RuntimeException();
      } else {
         this.field1531 = var7;
         this.field1527 = new int[var7];
         this.field1529 = new int[var7];
         this.field1528 = new int[var7];
         this.field1530 = new int[var7];

         for(var8 = 0; var8 < var7; ++var8) {
            this.field1527[var8] = field1526[var8];
            this.field1529[var8] = field1522[var8];
            this.field1528[var8] = field1523[var8];
            this.field1530[var8] = field1524[var8];
         }

      }
   }
}
