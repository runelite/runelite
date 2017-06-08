import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dj")
@Implements("TextureProvider")
public class TextureProvider implements class145 {
   @ObfuscatedName("rg")
   @ObfuscatedGetter(
      longValue = 5248817895960721461L
   )
   static long field1779;
   @ObfuscatedName("c")
   IndexDataBase field1780;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 970685379
   )
   int field1781;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -886378225
   )
   int field1782;
   @ObfuscatedName("f")
   double field1783;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1194221527
   )
   int field1784;
   @ObfuscatedName("p")
   Deque field1785;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -752375693
   )
   static int field1786;
   @ObfuscatedName("ol")
   static SpritePixels field1787;
   @ObfuscatedName("n")
   class130[] field1788;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "16"
   )
   public int vmethod2887(int var1) {
      return this.field1788[var1] != null?this.field1788[var1].field1885:0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "752661737"
   )
   public boolean vmethod2888(int var1) {
      return this.field1784 == 64;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1177838567"
   )
   public void method2393() {
      for(int var1 = 0; var1 < this.field1788.length; ++var1) {
         if(this.field1788[var1] != null) {
            this.field1788[var1].method2501();
         }
      }

      this.field1785 = new Deque();
      this.field1782 = this.field1781;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "161852671"
   )
   @Export("load")
   public int[] load(int var1) {
      class130 var2 = this.field1788[var1];
      if(var2 != null) {
         if(var2.field1884 != null) {
            this.field1785.method3603(var2);
            var2.field1894 = true;
            return var2.field1884;
         }

         boolean var3 = var2.method2498(this.field1783, this.field1784, this.field1780);
         if(var3) {
            if(this.field1782 == 0) {
               class130 var4 = (class130)this.field1785.method3606();
               var4.method2501();
            } else {
               --this.field1782;
            }

            this.field1785.method3603(var2);
            var2.field1894 = true;
            return var2.field1884;
         }
      }

      return null;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IS)Z",
      garbageValue = "6699"
   )
   public boolean vmethod2894(int var1) {
      return this.field1788[var1].field1893;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(D)V",
      garbageValue = "0.8"
   )
   public void method2400(double var1) {
      this.field1783 = var1;
      this.method2393();
   }

   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;IDI)V",
      garbageValue = "64"
   )
   public TextureProvider(IndexDataBase var1, IndexDataBase var2, int var3, double var4, int var6) {
      this.field1785 = new Deque();
      this.field1782 = 0;
      this.field1783 = 1.0D;
      this.field1784 = 128;
      this.field1780 = var2;
      this.field1781 = var3;
      this.field1782 = this.field1781;
      this.field1783 = var4;
      this.field1784 = var6;
      int[] var7 = var1.method4156(0);
      int var8 = var7.length;
      this.field1788 = new class130[var1.method4174(0)];

      for(int var9 = 0; var9 < var8; ++var9) {
         Buffer var10 = new Buffer(var1.getConfigData(0, var7[var9]));
         this.field1788[var7[var9]] = new class130(var10);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1377515472"
   )
   public void method2405(int var1) {
      for(int var2 = 0; var2 < this.field1788.length; ++var2) {
         class130 var3 = this.field1788[var2];
         if(var3 != null && var3.field1891 != 0 && var3.field1894) {
            var3.method2502(var1);
            var3.field1894 = false;
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SS)V",
      garbageValue = "-11347"
   )
   public static void method2413(String[] var0, short[] var1) {
      class40.method546(var0, var1, 0, var0.length - 1);
   }

   @ObfuscatedName("n")
   public static String method2414(long var0) {
      class182.field2457.setTime(new Date(var0));
      int var2 = class182.field2457.get(7);
      int var3 = class182.field2457.get(5);
      int var4 = class182.field2457.get(2);
      int var5 = class182.field2457.get(1);
      int var6 = class182.field2457.get(11);
      int var7 = class182.field2457.get(12);
      int var8 = class182.field2457.get(13);
      return class182.field2451[var2 - 1] + ", " + var3 / 10 + var3 % 10 + "-" + class182.field2452[0][var4] + "-" + var5 + " " + var6 / 10 + var6 % 10 + ":" + var7 / 10 + var7 % 10 + ":" + var8 / 10 + var8 % 10 + " GMT";
   }
}
