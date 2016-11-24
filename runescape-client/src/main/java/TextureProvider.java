import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bx")
@Implements("TextureProvider")
public class TextureProvider implements class93 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -525524085
   )
   int field1189 = 0;
   @ObfuscatedName("d")
   Deque field1190 = new Deque();
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2061768551
   )
   int field1191;
   @ObfuscatedName("c")
   class182 field1192;
   @ObfuscatedName("w")
   double field1193 = 1.0D;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -2095171409
   )
   int field1194 = 128;
   @ObfuscatedName("n")
   class79[] field1198;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1291388267"
   )
   public boolean vmethod1935(int var1) {
      return this.field1198[var1].field1299;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)[I",
      garbageValue = "-50"
   )
   @Export("load")
   public int[] load(int var1) {
      class79 var2 = this.field1198[var1];
      if(null != var2) {
         if(null != var2.field1298) {
            this.field1190.method2455(var2);
            var2.field1307 = true;
            return var2.field1298;
         }

         boolean var3 = var2.method1572(this.field1193, this.field1194, this.field1192);
         if(var3) {
            if(this.field1189 == 0) {
               class79 var4 = (class79)this.field1190.method2458();
               var4.method1573();
            } else {
               --this.field1189;
            }

            this.field1190.method2455(var2);
            var2.field1307 = true;
            return var2.field1298;
         }
      }

      return null;
   }

   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;IDI)V",
      garbageValue = "64"
   )
   public TextureProvider(class182 var1, class182 var2, int var3, double var4, int var6) {
      this.field1192 = var2;
      this.field1191 = var3;
      this.field1189 = this.field1191;
      this.field1193 = var4;
      this.field1194 = var6;
      int[] var7 = var1.method3338(0);
      int var8 = var7.length;
      this.field1198 = new class79[var1.method3339(0)];

      for(int var9 = 0; var9 < var8; ++var9) {
         Buffer var10 = new Buffer(var1.method3329(0, var7[var9]));
         this.field1198[var7[var9]] = new class79(var10);
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(D)V",
      garbageValue = "0.9"
   )
   public void method1463(double var1) {
      this.field1193 = var1;
      this.method1465();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-326783789"
   )
   public boolean vmethod1933(int var1) {
      return this.field1194 == 64;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1424586725"
   )
   public void method1465() {
      for(int var1 = 0; var1 < this.field1198.length; ++var1) {
         if(this.field1198[var1] != null) {
            this.field1198[var1].method1573();
         }
      }

      this.field1190 = new Deque();
      this.field1189 = this.field1191;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "885846759"
   )
   public int vmethod1934(int var1) {
      return null != this.field1198[var1]?this.field1198[var1].field1302:0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1231871094"
   )
   public void method1482(int var1) {
      for(int var2 = 0; var2 < this.field1198.length; ++var2) {
         class79 var3 = this.field1198[var2];
         if(null != var3 && var3.field1304 != 0 && var3.field1307) {
            var3.method1574(var1);
            var3.field1307 = false;
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BZB)Ljava/lang/Object;",
      garbageValue = "41"
   )
   public static Object method1484(byte[] var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else {
         if(var0.length > 136 && !class163.field2314) {
            try {
               class158 var2 = new class158();
               var2.vmethod3199(var0);
               return var2;
            } catch (Throwable var3) {
               class163.field2314 = true;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2108266969"
   )
   static final void method1485(int var0, int var1) {
      int var2 = class156.field2236.method3912("Choose Option");

      int var3;
      for(var3 = 0; var3 < Client.menuOptionCount; ++var3) {
         class208 var8 = class156.field2236;
         String var7;
         if(Client.menuTargets[var3].length() > 0) {
            var7 = Client.menuOptions[var3] + " " + Client.menuTargets[var3];
         } else {
            var7 = Client.menuOptions[var3];
         }

         int var6 = var8.method3912(var7);
         if(var6 > var2) {
            var2 = var6;
         }
      }

      var2 += 8;
      var3 = Client.menuOptionCount * 15 + 22;
      int var4 = var0 - var2 / 2;
      if(var4 + var2 > class16.field169) {
         var4 = class16.field169 - var2;
      }

      if(var4 < 0) {
         var4 = 0;
      }

      int var5 = var1;
      if(var3 + var1 > class65.field1103) {
         var5 = class65.field1103 - var3;
      }

      if(var5 < 0) {
         var5 = 0;
      }

      Client.isMenuOpen = true;
      Projectile.menuX = var4;
      XClanMember.menuY = var5;
      class37.menuWidth = var2;
      class20.menuHeight = 22 + Client.menuOptionCount * 15;
   }
}
