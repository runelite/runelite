import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
public class class95 implements class92 {
   @ObfuscatedName("w")
   class199 field1594 = new class199();
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 984283613
   )
   int field1595 = 0;
   @ObfuscatedName("e")
   class83[] field1596;
   @ObfuscatedName("p")
   double field1597 = 1.0D;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -958825517
   )
   int field1598 = 128;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 713837095
   )
   int field1599;
   @ObfuscatedName("nl")
   @ObfuscatedGetter(
      intValue = -36813259
   )
   static int field1601;
   @ObfuscatedName("r")
   static int[][] field1602;
   @ObfuscatedName("g")
   class167 field1603;

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(Lclass2;IIBI)V",
      garbageValue = "-313754774"
   )
   static final void method2186(class2 var0, int var1, int var2, byte var3) {
      int var4 = var0.field842[0];
      int var5 = var0.field843[0];
      int var6 = var0.method22();
      if(var4 >= var6 && var4 < 104 - var6 && var5 >= var6 && var5 < 104 - var6) {
         if(var1 >= var6 && var1 < 104 - var6 && var2 >= var6 && var2 < 104 - var6) {
            int var7 = class10.method142(var4, var5, var0.method22(), class35.method730(var1, var2), client.field338[var0.field55], client.field558, client.field559);
            if(var7 >= 1) {
               for(int var8 = 0; var8 < var7 - 1; ++var8) {
                  var0.method26(client.field558[var8], client.field559[var8], var3);
               }

            }
         }
      }
   }

   @ObfuscatedName("n")
   public void method2187(double var1) {
      this.field1597 = var1;
      this.method2205();
   }

   @ObfuscatedName("e")
   public int[] vmethod2188(int var1) {
      class83 var2 = this.field1596[var1];
      if(var2 != null) {
         if(null != var2.field1425) {
            this.field1594.method3821(var2);
            var2.field1426 = true;
            return var2.field1425;
         }

         boolean var3 = var2.method1909(this.field1597, this.field1598, this.field1603);
         if(var3) {
            if(0 == this.field1595) {
               class83 var4 = (class83)this.field1594.method3824();
               var4.method1908();
            } else {
               --this.field1595;
            }

            this.field1594.method3821(var2);
            var2.field1426 = true;
            return var2.field1425;
         }
      }

      return null;
   }

   @ObfuscatedName("w")
   public int vmethod2189(int var1) {
      return this.field1596[var1] != null?this.field1596[var1].field1417:0;
   }

   @ObfuscatedName("s")
   public boolean vmethod2191() {
      return this.field1598 == 64;
   }

   @ObfuscatedName("i")
   public void method2196(int var1) {
      for(int var2 = 0; var2 < this.field1596.length; ++var2) {
         class83 var3 = this.field1596[var2];
         if(null != var3 && 0 != var3.field1423 && var3.field1426) {
            var3.method1911(var1);
            var3.field1426 = false;
         }
      }

   }

   public class95(class167 var1, class167 var2, int var3, double var4, int var6) {
      this.field1603 = var2;
      this.field1599 = var3;
      this.field1595 = this.field1599;
      this.field1597 = var4;
      this.field1598 = var6;
      int[] var7 = var1.method3265(0);
      int var8 = var7.length;
      this.field1596 = new class83[var1.method3307(0)];

      for(int var9 = 0; var9 < var8; ++var9) {
         class119 var10 = new class119(var1.method3280(0, var7[var9]));
         this.field1596[var7[var9]] = new class83(var10);
      }

   }

   @ObfuscatedName("y")
   public void method2205() {
      for(int var1 = 0; var1 < this.field1596.length; ++var1) {
         if(this.field1596[var1] != null) {
            this.field1596[var1].method1908();
         }
      }

      this.field1594 = new class199();
      this.field1595 = this.field1599;
   }

   @ObfuscatedName("f")
   public boolean vmethod2208(int var1) {
      return this.field1596[var1].field1418;
   }
}
