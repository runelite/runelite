import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ck")
public class class88 {
   @ObfuscatedName("e")
   static int[] field1518 = new int[500];
   @ObfuscatedName("w")
   static int[] field1519 = new int[500];
   @ObfuscatedName("f")
   static int[] field1520 = new int[500];
   @ObfuscatedName("s")
   static int[] field1521 = new int[500];
   @ObfuscatedName("p")
   class102 field1522 = null;
   @ObfuscatedName("h")
   int field1523 = -1;
   @ObfuscatedName("a")
   int[] field1524;
   @ObfuscatedName("g")
   int[] field1525;
   @ObfuscatedName("r")
   int[] field1526;
   @ObfuscatedName("k")
   int[] field1527;
   @ObfuscatedName("m")
   boolean field1528 = false;

   class88(byte[] var1, class102 var2) {
      this.field1522 = var2;
      class119 var3 = new class119(var1);
      class119 var4 = new class119(var1);
      var3.field1976 = 2;
      int var5 = var3.method2523();
      int var6 = -1;
      int var7 = 0;
      var4.field1976 = var3.field1976 + var5;

      int var8;
      for(var8 = 0; var8 < var5; ++var8) {
         int var9 = var3.method2523();
         if(var9 > 0) {
            if(this.field1522.field1742[var8] != 0) {
               for(int var10 = var8 - 1; var10 > var6; --var10) {
                  if(this.field1522.field1742[var10] == 0) {
                     field1518[var7] = var10;
                     field1519[var7] = 0;
                     field1520[var7] = 0;
                     field1521[var7] = 0;
                     ++var7;
                     break;
                  }
               }
            }

            field1518[var7] = var8;
            short var11 = 0;
            if(this.field1522.field1742[var8] == 3) {
               var11 = 128;
            }

            if((var9 & 1) != 0) {
               field1519[var7] = var4.method2535();
            } else {
               field1519[var7] = var11;
            }

            if((var9 & 2) != 0) {
               field1520[var7] = var4.method2535();
            } else {
               field1520[var7] = var11;
            }

            if((var9 & 4) != 0) {
               field1521[var7] = var4.method2535();
            } else {
               field1521[var7] = var11;
            }

            var6 = var8;
            ++var7;
            if(this.field1522.field1742[var8] == 5) {
               this.field1528 = true;
            }
         }
      }

      if(var4.field1976 != var1.length) {
         throw new RuntimeException();
      } else {
         this.field1523 = var7;
         this.field1525 = new int[var7];
         this.field1524 = new int[var7];
         this.field1526 = new int[var7];
         this.field1527 = new int[var7];

         for(var8 = 0; var8 < var7; ++var8) {
            this.field1525[var8] = field1518[var8];
            this.field1524[var8] = field1519[var8];
            this.field1526[var8] = field1520[var8];
            this.field1527[var8] = field1521[var8];
         }

      }
   }
}
