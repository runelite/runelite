import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cp")
public class class87 {
   @ObfuscatedName("i")
   static int[] field1536 = new int[500];
   @ObfuscatedName("l")
   static int[] field1537 = new int[500];
   @ObfuscatedName("a")
   static int[] field1538 = new int[500];
   @ObfuscatedName("o")
   int[] field1539;
   @ObfuscatedName("f")
   class101 field1540 = null;
   @ObfuscatedName("m")
   int field1541 = -1;
   @ObfuscatedName("n")
   int[] field1542;
   @ObfuscatedName("h")
   int[] field1543;
   @ObfuscatedName("j")
   static int[] field1544 = new int[500];
   @ObfuscatedName("k")
   int[] field1545;
   @ObfuscatedName("r")
   boolean field1546 = false;

   class87(byte[] var1, class101 var2) {
      this.field1540 = var2;
      class118 var3 = new class118(var1);
      class118 var4 = new class118(var1);
      var3.field1998 = 2;
      int var5 = var3.method2453();
      int var6 = -1;
      int var7 = 0;
      var4.field1998 = var3.field1998 + var5;

      int var8;
      for(var8 = 0; var8 < var5; ++var8) {
         int var9 = var3.method2453();
         if(var9 > 0) {
            if(this.field1540.field1771[var8] != 0) {
               for(int var10 = var8 - 1; var10 > var6; --var10) {
                  if(this.field1540.field1771[var10] == 0) {
                     field1544[var7] = var10;
                     field1537[var7] = 0;
                     field1538[var7] = 0;
                     field1536[var7] = 0;
                     ++var7;
                     break;
                  }
               }
            }

            field1544[var7] = var8;
            short var11 = 0;
            if(this.field1540.field1771[var8] == 3) {
               var11 = 128;
            }

            if((var9 & 1) != 0) {
               field1537[var7] = var4.method2465();
            } else {
               field1537[var7] = var11;
            }

            if((var9 & 2) != 0) {
               field1538[var7] = var4.method2465();
            } else {
               field1538[var7] = var11;
            }

            if((var9 & 4) != 0) {
               field1536[var7] = var4.method2465();
            } else {
               field1536[var7] = var11;
            }

            var6 = var8;
            ++var7;
            if(this.field1540.field1771[var8] == 5) {
               this.field1546 = true;
            }
         }
      }

      if(var4.field1998 != var1.length) {
         throw new RuntimeException();
      } else {
         this.field1541 = var7;
         this.field1539 = new int[var7];
         this.field1543 = new int[var7];
         this.field1542 = new int[var7];
         this.field1545 = new int[var7];

         for(var8 = 0; var8 < var7; ++var8) {
            this.field1539[var8] = field1544[var8];
            this.field1543[var8] = field1537[var8];
            this.field1542[var8] = field1538[var8];
            this.field1545[var8] = field1536[var8];
         }

      }
   }
}
