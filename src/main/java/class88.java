import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cf")
public class class88 {
   @ObfuscatedName("x")
   static int[] field1543 = new int[500];
   @ObfuscatedName("l")
   int[] field1544;
   @ObfuscatedName("t")
   static int[] field1545 = new int[500];
   @ObfuscatedName("p")
   static int[] field1546 = new int[500];
   @ObfuscatedName("e")
   class102 field1547 = null;
   @ObfuscatedName("y")
   int field1548 = -1;
   @ObfuscatedName("v")
   int[] field1549;
   @ObfuscatedName("c")
   int[] field1550;
   @ObfuscatedName("m")
   int[] field1551;
   @ObfuscatedName("w")
   static int[] field1552 = new int[500];
   @ObfuscatedName("z")
   boolean field1553 = false;

   class88(byte[] var1, class102 var2) {
      this.field1547 = var2;
      class119 var3 = new class119(var1);
      class119 var4 = new class119(var1);
      var3.field2011 = 2;
      int var5 = var3.method2506();
      int var6 = -1;
      int var7 = 0;
      var4.field2011 = var3.field2011 + var5;

      int var8;
      for(var8 = 0; var8 < var5; ++var8) {
         int var9 = var3.method2506();
         if(var9 > 0) {
            if(this.field1547.field1779[var8] != 0) {
               for(int var10 = var8 - 1; var10 > var6; --var10) {
                  if(this.field1547.field1779[var10] == 0) {
                     field1552[var7] = var10;
                     field1543[var7] = 0;
                     field1545[var7] = 0;
                     field1546[var7] = 0;
                     ++var7;
                     break;
                  }
               }
            }

            field1552[var7] = var8;
            short var11 = 0;
            if(this.field1547.field1779[var8] == 3) {
               var11 = 128;
            }

            if((var9 & 1) != 0) {
               field1543[var7] = var4.method2518();
            } else {
               field1543[var7] = var11;
            }

            if((var9 & 2) != 0) {
               field1545[var7] = var4.method2518();
            } else {
               field1545[var7] = var11;
            }

            if((var9 & 4) != 0) {
               field1546[var7] = var4.method2518();
            } else {
               field1546[var7] = var11;
            }

            var6 = var8;
            ++var7;
            if(this.field1547.field1779[var8] == 5) {
               this.field1553 = true;
            }
         }
      }

      if(var4.field2011 != var1.length) {
         throw new RuntimeException();
      } else {
         this.field1548 = var7;
         this.field1551 = new int[var7];
         this.field1550 = new int[var7];
         this.field1549 = new int[var7];
         this.field1544 = new int[var7];

         for(var8 = 0; var8 < var7; ++var8) {
            this.field1551[var8] = field1552[var8];
            this.field1550[var8] = field1543[var8];
            this.field1549[var8] = field1545[var8];
            this.field1544[var8] = field1546[var8];
         }

      }
   }
}
