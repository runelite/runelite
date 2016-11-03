import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
@Implements("TextureProvider")
public class TextureProvider implements class95 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1303937067
   )
   int field1682;
   @ObfuscatedName("q")
   Deque field1683 = new Deque();
   @ObfuscatedName("v")
   double field1684 = 1.0D;
   @ObfuscatedName("k")
   class86[] field1685;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1932814155
   )
   int field1686 = 128;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1421516969
   )
   int field1687 = 0;
   @ObfuscatedName("m")
   class170 field1688;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1399503723"
   )
   public int vmethod2240(int var1) {
      return this.field1685[var1] != null?this.field1685[var1].field1501:0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(D)V",
      garbageValue = "0.9"
   )
   public void method2241(double var1) {
      this.field1684 = var1;
      this.method2246();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "1931023319"
   )
   @Export("load")
   public int[] load(int var1) {
      class86 var2 = this.field1685[var1];
      if(var2 != null) {
         if(var2.field1504 != null) {
            this.field1683.method3845(var2);
            var2.field1500 = true;
            return var2.field1504;
         }

         boolean var3 = var2.method1940(this.field1684, this.field1686, this.field1688);
         if(var3) {
            if(this.field1687 == 0) {
               class86 var4 = (class86)this.field1683.method3848();
               var4.method1942();
            } else {
               --this.field1687;
            }

            this.field1683.method3845(var2);
            var2.field1500 = true;
            return var2.field1504;
         }
      }

      return null;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-98"
   )
   public boolean vmethod2244(int var1) {
      return this.field1685[var1].field1508;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1719817066"
   )
   public void method2246() {
      for(int var1 = 0; var1 < this.field1685.length; ++var1) {
         if(this.field1685[var1] != null) {
            this.field1685[var1].method1942();
         }
      }

      this.field1683 = new Deque();
      this.field1687 = this.field1682;
   }

   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;IDI)V",
      garbageValue = "64"
   )
   public TextureProvider(class170 var1, class170 var2, int var3, double var4, int var6) {
      this.field1688 = var2;
      this.field1682 = var3;
      this.field1687 = this.field1682;
      this.field1684 = var4;
      this.field1686 = var6;
      int[] var7 = var1.method3289(0);
      int var8 = var7.length;
      this.field1685 = new class86[var1.method3290(0)];

      for(int var9 = 0; var9 < var8; ++var9) {
         Buffer var10 = new Buffer(var1.method3305(0, var7[var9]));
         this.field1685[var7[var9]] = new class86(var10);
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(LActor;IS)V",
      garbageValue = "18095"
   )
   static final void method2253(Actor var0, int var1) {
      class77.method1658(var0.x, var0.y, var1);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "0"
   )
   public boolean vmethod2257(int var1) {
      return this.field1686 == 64;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "96"
   )
   public void method2258(int var1) {
      for(int var2 = 0; var2 < this.field1685.length; ++var2) {
         class86 var3 = this.field1685[var2];
         if(var3 != null && var3.field1506 != 0 && var3.field1500) {
            var3.method1941(var1);
            var3.field1500 = false;
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "117"
   )
   public static void method2264() {
      try {
         class152.field2279.method4177();

         for(int var0 = 0; var0 < class21.field578; ++var0) {
            XItemContainer.field218[var0].method4177();
         }

         class152.field2284.method4177();
         class152.field2283.method4177();
      } catch (Exception var2) {
         ;
      }

   }
}
