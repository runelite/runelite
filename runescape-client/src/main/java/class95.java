import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
@Implements("TextureProvider")
public class class95 implements class92 {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -140973381
   )
   int field1627 = 128;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1257500665
   )
   int field1628;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -437396473
   )
   int field1629 = 0;
   @ObfuscatedName("d")
   double field1631 = 1.0D;
   @ObfuscatedName("o")
   class167 field1632;
   @ObfuscatedName("j")
   class199 field1633 = new class199();
   @ObfuscatedName("nz")
   @ObfuscatedGetter(
      intValue = -419427387
   )
   static int field1634;
   @ObfuscatedName("s")
   class83[] field1635;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IS)[I",
      garbageValue = "26066"
   )
   @Export("load")
   public int[] vmethod2149(int var1) {
      class83 var2 = this.field1635[var1];
      if(null != var2) {
         if(var2.field1455 != null) {
            this.field1633.method3808(var2);
            var2.field1445 = true;
            return var2.field1455;
         }

         boolean var3 = var2.method1883(this.field1631, this.field1627, this.field1632);
         if(var3) {
            if(0 == this.field1629) {
               class83 var4 = (class83)this.field1633.method3813();
               var4.method1871();
            } else {
               --this.field1629;
            }

            this.field1633.method3808(var2);
            var2.field1445 = true;
            return var2.field1455;
         }
      }

      return null;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-888536116"
   )
   public int vmethod2150(int var1) {
      return this.field1635[var1] != null?this.field1635[var1].field1447:0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-50"
   )
   public boolean vmethod2151(int var1) {
      return this.field1635[var1].field1448;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1901719750"
   )
   public boolean vmethod2152(int var1) {
      return this.field1627 == 64;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
   )
   public void method2154(int var1) {
      for(int var2 = 0; var2 < this.field1635.length; ++var2) {
         class83 var3 = this.field1635[var2];
         if(var3 != null && var3.field1446 != 0 && var3.field1445) {
            var3.method1872(var1);
            var3.field1445 = false;
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1717904826"
   )
   public void method2160() {
      for(int var1 = 0; var1 < this.field1635.length; ++var1) {
         if(null != this.field1635[var1]) {
            this.field1635[var1].method1871();
         }
      }

      this.field1633 = new class199();
      this.field1629 = this.field1628;
   }

   @ObfuscatedSignature(
      signature = "(Lclass167;Lclass167;IDI)V",
      garbageValue = "20"
   )
   public class95(class167 var1, class167 var2, int var3, double var4, int var6) {
      this.field1632 = var2;
      this.field1628 = var3;
      this.field1629 = this.field1628;
      this.field1631 = var4;
      this.field1627 = var6;
      int[] var7 = var1.method3281(0);
      int var8 = var7.length;
      this.field1635 = new class83[var1.method3249(0)];

      for(int var9 = 0; var9 < var8; ++var9) {
         class119 var10 = new class119(var1.method3239(0, var7[var9]));
         this.field1635[var7[var9]] = new class83(var10);
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(D)V",
      garbageValue = "0.9"
   )
   public void method2170(double var1) {
      this.field1631 = var1;
      this.method2160();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-2064413766"
   )
   static boolean method2175(int var0, int var1) {
      return 4 != var0 || var1 < 8;
   }
}
