import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
@Implements("TextureProvider")
public class TextureProvider implements class95 {
   @ObfuscatedName("bv")
   static ModIcon[] field1671;
   @ObfuscatedName("h")
   Deque field1672 = new Deque();
   @ObfuscatedName("i")
   class86[] field1673;
   @ObfuscatedName("n")
   double field1675 = 1.0D;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1833917839
   )
   int field1676 = 128;
   @ObfuscatedName("d")
   class170 field1677;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 445497123
   )
   int field1679 = 0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1243999391
   )
   int field1680;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IS)[I",
      garbageValue = "739"
   )
   @Export("load")
   public int[] load(int var1) {
      class86 var2 = this.field1673[var1];
      if(null != var2) {
         if(var2.field1500 != null) {
            this.field1672.method3841(var2);
            var2.field1492 = true;
            return var2.field1500;
         }

         boolean var3 = var2.method1936(this.field1675, this.field1676, this.field1677);
         if(var3) {
            if(this.field1679 == 0) {
               class86 var4 = (class86)this.field1672.method3844();
               var4.method1929();
            } else {
               --this.field1679;
            }

            this.field1672.method3841(var2);
            var2.field1492 = true;
            return var2.field1500;
         }
      }

      return null;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1248869884"
   )
   public int vmethod2214(int var1) {
      return null != this.field1673[var1]?this.field1673[var1].field1494:0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "974891448"
   )
   public void method2215() {
      for(int var1 = 0; var1 < this.field1673.length; ++var1) {
         if(null != this.field1673[var1]) {
            this.field1673[var1].method1929();
         }
      }

      this.field1672 = new Deque();
      this.field1679 = this.field1680;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1117706081"
   )
   public boolean vmethod2216(int var1) {
      return this.field1676 == 64;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2056215812"
   )
   public void method2218(int var1) {
      for(int var2 = 0; var2 < this.field1673.length; ++var2) {
         class86 var3 = this.field1673[var2];
         if(null != var3 && var3.field1493 != 0 && var3.field1492) {
            var3.method1927(var1);
            var3.field1492 = false;
         }
      }

   }

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "-12"
   )
   static final String method2220(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + class137.method2909('ﾀ') + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + class137.method2909(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + class137.method2909(16776960) + var1 + "</col>");
   }

   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;IDI)V",
      garbageValue = "64"
   )
   public TextureProvider(class170 var1, class170 var2, int var3, double var4, int var6) {
      this.field1677 = var2;
      this.field1680 = var3;
      this.field1679 = this.field1680;
      this.field1675 = var4;
      this.field1676 = var6;
      int[] var7 = var1.method3298(0);
      int var8 = var7.length;
      this.field1673 = new class86[var1.method3299(0)];

      for(int var9 = 0; var9 < var8; ++var9) {
         Buffer var10 = new Buffer(var1.method3292(0, var7[var9]));
         this.field1673[var7[var9]] = new class86(var10);
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(D)V",
      garbageValue = "0.9"
   )
   public void method2231(double var1) {
      this.field1675 = var1;
      this.method2215();
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "219510156"
   )
   static final boolean method2237(int var0) {
      if(var0 < 0) {
         return false;
      } else {
         int var1 = Client.menuTypes[var0];
         if(var1 >= 2000) {
            var1 -= 2000;
         }

         return var1 == 1007;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "106"
   )
   public boolean vmethod2238(int var1) {
      return this.field1673[var1].field1490;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-1"
   )
   public static boolean method2239() {
      ClassInfo var0 = (ClassInfo)class214.field3187.method3881();
      return var0 != null;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1068439430"
   )
   public static void method2240() {
      try {
         class152.field2286.method4173();

         for(int var0 = 0; var0 < class152.field2282; ++var0) {
            class118.field2025[var0].method4173();
         }

         class152.field2285.method4173();
         class152.field2283.method4173();
      } catch (Exception var2) {
         ;
      }

   }
}
