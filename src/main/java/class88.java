import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cn")
public class class88 {
   @ObfuscatedName("m")
   int[] field1540;
   @ObfuscatedName("w")
   static int[] field1541 = new int[500];
   @ObfuscatedName("d")
   static int[] field1542 = new int[500];
   @ObfuscatedName("c")
   static int[] field1543 = new int[500];
   @ObfuscatedName("a")
   static int[] field1544 = new int[500];
   @ObfuscatedName("k")
   int field1545 = -1;
   @ObfuscatedName("r")
   int[] field1546;
   @ObfuscatedName("p")
   int[] field1547;
   @ObfuscatedName("q")
   int[] field1548;
   @ObfuscatedName("y")
   class102 field1549 = null;
   @ObfuscatedName("e")
   boolean field1550 = false;

   class88(byte[] var1, class102 var2) {
      this.field1549 = var2;
      class119 var3 = new class119(var1);
      class119 var4 = new class119(var1);
      var3.field1992 = 2;
      int var5 = var3.method2613();
      int var6 = -1;
      int var7 = 0;
      var4.field1992 = var3.field1992 + var5;

      int var8;
      for(var8 = 0; var8 < var5; ++var8) {
         int var9 = var3.method2613();
         if(var9 > 0) {
            if(this.field1549.field1761[var8] != 0) {
               for(int var10 = var8 - 1; var10 > var6; --var10) {
                  if(this.field1549.field1761[var10] == 0) {
                     field1544[var7] = var10;
                     field1541[var7] = 0;
                     field1542[var7] = 0;
                     field1543[var7] = 0;
                     ++var7;
                     break;
                  }
               }
            }

            field1544[var7] = var8;
            short var11 = 0;
            if(this.field1549.field1761[var8] == 3) {
               var11 = 128;
            }

            if((var9 & 1) != 0) {
               field1541[var7] = var4.method2642();
            } else {
               field1541[var7] = var11;
            }

            if((var9 & 2) != 0) {
               field1542[var7] = var4.method2642();
            } else {
               field1542[var7] = var11;
            }

            if((var9 & 4) != 0) {
               field1543[var7] = var4.method2642();
            } else {
               field1543[var7] = var11;
            }

            var6 = var8;
            ++var7;
            if(this.field1549.field1761[var8] == 5) {
               this.field1550 = true;
            }
         }
      }

      if(var4.field1992 != var1.length) {
         throw new RuntimeException();
      } else {
         this.field1545 = var7;
         this.field1546 = new int[var7];
         this.field1547 = new int[var7];
         this.field1548 = new int[var7];
         this.field1540 = new int[var7];

         for(var8 = 0; var8 < var7; ++var8) {
            this.field1546[var8] = field1544[var8];
            this.field1547[var8] = field1541[var8];
            this.field1548[var8] = field1542[var8];
            this.field1540[var8] = field1543[var8];
         }

      }
   }
}
