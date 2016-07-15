import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
@Implements("TextureProvider")
public class class98 implements class95 {
   @ObfuscatedName("nv")
   @ObfuscatedGetter(
      intValue = 720421611
   )
   static int field1684;
   @ObfuscatedName("r")
   double field1685 = 1.0D;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -533313561
   )
   int field1686;
   @ObfuscatedName("b")
   class170 field1687;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -2053889169
   )
   int field1688 = 0;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1179379729
   )
   int field1689 = 128;
   @ObfuscatedName("l")
   class202 field1690 = new class202();
   @ObfuscatedName("e")
   class86[] field1691;
   @ObfuscatedName("fo")
   @ObfuscatedGetter(
      intValue = 1621835521
   )
   @Export("cameraPitch")
   static int field1694;
   @ObfuscatedName("g")
   public static class62 field1695;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(D)V",
      garbageValue = "0.9"
   )
   public void method2264(double var1) {
      this.field1685 = var1;
      this.method2269();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "395229080"
   )
   @Export("load")
   public int[] vmethod2265(int var1) {
      class86 var2 = this.field1691[var1];
      if(null != var2) {
         if(null != var2.field1517) {
            this.field1690.method3896(var2);
            var2.field1518 = true;
            return var2.field1517;
         }

         boolean var3 = var2.method1992(this.field1685, this.field1689, this.field1687);
         if(var3) {
            if(this.field1688 == 0) {
               class86 var4 = (class86)this.field1690.method3898();
               var4.method1987();
            } else {
               --this.field1688;
            }

            this.field1690.method3896(var2);
            var2.field1518 = true;
            return var2.field1517;
         }
      }

      return null;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1975991690"
   )
   public boolean vmethod2266(int var1) {
      return this.field1689 == 64;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "105"
   )
   public boolean vmethod2267(int var1) {
      return this.field1691[var1].field1510;
   }

   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;IDI)V",
      garbageValue = "128"
   )
   public class98(class170 var1, class170 var2, int var3, double var4, int var6) {
      this.field1687 = var2;
      this.field1686 = var3;
      this.field1688 = this.field1686;
      this.field1685 = var4;
      this.field1689 = var6;
      int[] var7 = var1.method3346(0);
      int var8 = var7.length;
      this.field1691 = new class86[var1.method3352(0)];

      for(int var9 = 0; var9 < var8; ++var9) {
         class122 var10 = new class122(var1.method3340(0, var7[var9]));
         this.field1691[var7[var9]] = new class86(var10);
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-457504240"
   )
   public void method2269() {
      for(int var1 = 0; var1 < this.field1691.length; ++var1) {
         if(this.field1691[var1] != null) {
            this.field1691[var1].method1987();
         }
      }

      this.field1690 = new class202();
      this.field1688 = this.field1686;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1733125104"
   )
   public int vmethod2271(int var1) {
      return this.field1691[var1] != null?this.field1691[var1].field1509:0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-123"
   )
   public void method2278(int var1) {
      for(int var2 = 0; var2 < this.field1691.length; ++var2) {
         class86 var3 = this.field1691[var2];
         if(var3 != null && var3.field1515 != 0 && var3.field1518) {
            var3.method1988(var1);
            var3.field1518 = false;
         }
      }

   }
}
