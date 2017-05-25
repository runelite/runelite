import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dd")
@Implements("TextureProvider")
public class TextureProvider implements class145 {
   @ObfuscatedName("i")
   class130[] field1757;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1451707371
   )
   int field1758;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1795897649
   )
   int field1759;
   @ObfuscatedName("g")
   double field1760;
   @ObfuscatedName("h")
   Deque field1761;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1164851801
   )
   int field1762;
   @ObfuscatedName("t")
   IndexDataBase field1763;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "1501786373"
   )
   @Export("load")
   public int[] load(int var1) {
      class130 var2 = this.field1757[var1];
      if(var2 != null) {
         if(var2.field1873 != null) {
            this.field1761.method3686(var2);
            var2.field1872 = true;
            return var2.field1873;
         }

         boolean var3 = var2.method2525(this.field1760, this.field1762, this.field1763);
         if(var3) {
            if(this.field1758 == 0) {
               class130 var4 = (class130)this.field1761.method3659();
               var4.method2529();
            } else {
               --this.field1758;
            }

            this.field1761.method3686(var2);
            var2.field1872 = true;
            return var2.field1873;
         }
      }

      return null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-39"
   )
   public boolean vmethod2926(int var1) {
      return this.field1762 == 64;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "80"
   )
   public int vmethod2918(int var1) {
      return this.field1757[var1] != null?this.field1757[var1].field1863:0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "24"
   )
   public boolean vmethod2919(int var1) {
      return this.field1757[var1].field1864;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;Ljava/lang/String;Ljava/lang/String;IZI)V",
      garbageValue = "2050271919"
   )
   public static void method2414(IndexDataBase var0, String var1, String var2, int var3, boolean var4) {
      int var5 = var0.method4189(var1);
      int var6 = var0.method4190(var5, var2);
      class32.method322(var0, var5, var6, var3, var4);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "30182625"
   )
   public void method2415() {
      for(int var1 = 0; var1 < this.field1757.length; ++var1) {
         if(this.field1757[var1] != null) {
            this.field1757[var1].method2529();
         }
      }

      this.field1761 = new Deque();
      this.field1758 = this.field1759;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-15279"
   )
   public void method2416(int var1) {
      for(int var2 = 0; var2 < this.field1757.length; ++var2) {
         class130 var3 = this.field1757[var2];
         if(var3 != null && var3.field1870 != 0 && var3.field1872) {
            var3.method2526(var1);
            var3.field1872 = false;
         }
      }

   }

   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;IDI)V",
      garbageValue = "64"
   )
   public TextureProvider(IndexDataBase var1, IndexDataBase var2, int var3, double var4, int var6) {
      this.field1761 = new Deque();
      this.field1758 = 0;
      this.field1760 = 1.0D;
      this.field1762 = 128;
      this.field1763 = var2;
      this.field1759 = var3;
      this.field1758 = this.field1759;
      this.field1760 = var4;
      this.field1762 = var6;
      int[] var7 = var1.method4183(0);
      int var8 = var7.length;
      this.field1757 = new class130[var1.method4184(0)];

      for(int var9 = 0; var9 < var8; ++var9) {
         Buffer var10 = new Buffer(var1.getConfigData(0, var7[var9]));
         this.field1757[var7[var9]] = new class130(var10);
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(D)V",
      garbageValue = "0.9"
   )
   public void method2437(double var1) {
      this.field1760 = var1;
      this.method2415();
   }
}
