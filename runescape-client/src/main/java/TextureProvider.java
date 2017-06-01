import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("df")
@Implements("TextureProvider")
public class TextureProvider implements class145 {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1536940847
   )
   int field1786;
   @ObfuscatedName("i")
   class130[] field1787;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1308468011
   )
   int field1788;
   @ObfuscatedName("b")
   double field1790;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1988417951
   )
   int field1791;
   @ObfuscatedName("h")
   IndexDataBase field1792;
   @ObfuscatedName("gk")
   @ObfuscatedGetter(
      intValue = 549717109
   )
   @Export("cameraX")
   static int cameraX;
   @ObfuscatedName("c")
   Deque field1794;
   @ObfuscatedName("pb")
   @ObfuscatedGetter(
      intValue = -2013803609
   )
   static int field1795;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(D)V",
      garbageValue = "0.9"
   )
   public void method2367(double var1) {
      this.field1790 = var1;
      this.method2372();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "-1462666275"
   )
   @Export("load")
   public int[] load(int var1) {
      class130 var2 = this.field1787[var1];
      if(var2 != null) {
         if(var2.field1901 != null) {
            this.field1794.method3572(var2);
            var2.field1890 = true;
            return var2.field1901;
         }

         boolean var3 = var2.method2480(this.field1790, this.field1791, this.field1792);
         if(var3) {
            if(this.field1786 == 0) {
               class130 var4 = (class130)this.field1794.method3575();
               var4.method2481();
            } else {
               --this.field1786;
            }

            this.field1794.method3572(var2);
            var2.field1890 = true;
            return var2.field1901;
         }
      }

      return null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "929330709"
   )
   public int vmethod2887(int var1) {
      return this.field1787[var1] != null?this.field1787[var1].field1888:0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "102"
   )
   public boolean vmethod2879(int var1) {
      return this.field1787[var1].field1893;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1995297545"
   )
   public void method2372() {
      for(int var1 = 0; var1 < this.field1787.length; ++var1) {
         if(this.field1787[var1] != null) {
            this.field1787[var1].method2481();
         }
      }

      this.field1794 = new Deque();
      this.field1786 = this.field1788;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-73"
   )
   public void method2373(int var1) {
      for(int var2 = 0; var2 < this.field1787.length; ++var2) {
         class130 var3 = this.field1787[var2];
         if(var3 != null && var3.field1898 != 0 && var3.field1890) {
            var3.method2487(var1);
            var3.field1890 = false;
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-49"
   )
   public boolean vmethod2881(int var1) {
      return this.field1791 == 64;
   }

   @ObfuscatedName("jb")
   @ObfuscatedSignature(
      signature = "(LWidget;IB)Ljava/lang/String;",
      garbageValue = "48"
   )
   static String method2385(Widget var0, int var1) {
      return !class20.method133(class210.method3903(var0), var1) && var0.field2751 == null?null:(var0.actions != null && var0.actions.length > var1 && var0.actions[var1] != null && var0.actions[var1].trim().length() != 0?var0.actions[var1]:null);
   }

   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;IDI)V",
      garbageValue = "64"
   )
   public TextureProvider(IndexDataBase var1, IndexDataBase var2, int var3, double var4, int var6) {
      this.field1794 = new Deque();
      this.field1786 = 0;
      this.field1790 = 1.0D;
      this.field1791 = 128;
      this.field1792 = var2;
      this.field1788 = var3;
      this.field1786 = this.field1788;
      this.field1790 = var4;
      this.field1791 = var6;
      int[] var7 = var1.method4161(0);
      int var8 = var7.length;
      this.field1787 = new class130[var1.method4187(0)];

      for(int var9 = 0; var9 < var8; ++var9) {
         Buffer var10 = new Buffer(var1.getConfigData(0, var7[var9]));
         this.field1787[var7[var9]] = new class130(var10);
      }

   }
}
