import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
@Implements("TextureProvider")
public class class95 implements class92 {
   @ObfuscatedName("g")
   public static short[] field1620;
   @ObfuscatedName("u")
   class199 field1621 = new class199();
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1100217191
   )
   int field1622;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -108472579
   )
   int field1623 = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -2053327759
   )
   int field1625 = 128;
   @ObfuscatedName("n")
   class167 field1626;
   @ObfuscatedName("f")
   class83[] field1627;
   @ObfuscatedName("l")
   double field1630 = 1.0D;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "1968621716"
   )
   @Export("load")
   public int[] vmethod2231(int var1) {
      class83 var2 = this.field1627[var1];
      if(var2 != null) {
         if(var2.field1457 != null) {
            this.field1621.method3851(var2);
            var2.field1458 = true;
            return var2.field1457;
         }

         boolean var3 = var2.method1950(this.field1630, this.field1625, this.field1626);
         if(var3) {
            if(this.field1623 == 0) {
               class83 var4 = (class83)this.field1621.method3850();
               var4.method1949();
            } else {
               --this.field1623;
            }

            this.field1621.method3851(var2);
            var2.field1458 = true;
            return var2.field1457;
         }
      }

      return null;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1882836254"
   )
   public int vmethod2232(int var1) {
      return this.field1627[var1] != null?this.field1627[var1].field1449:0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-522080218"
   )
   public void method2235() {
      for(int var1 = 0; var1 < this.field1627.length; ++var1) {
         if(null != this.field1627[var1]) {
            this.field1627[var1].method1949();
         }
      }

      this.field1621 = new class199();
      this.field1623 = this.field1622;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-795826329"
   )
   public void method2236(int var1) {
      for(int var2 = 0; var2 < this.field1627.length; ++var2) {
         class83 var3 = this.field1627[var2];
         if(var3 != null && var3.field1455 != 0 && var3.field1458) {
            var3.method1951(var1);
            var3.field1458 = false;
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(D)V",
      garbageValue = "0.9"
   )
   public void method2238(double var1) {
      this.field1630 = var1;
      this.method2235();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass119;IIIIIII)V",
      garbageValue = "-538603657"
   )
   static final void method2244(class119 var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class5.field82[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.method2554();
            if(var7 == 0) {
               if(var1 == 0) {
                  class5.field99[0][var2][var3] = -class162.method3211(var4 + var2 + 932731, var3 + 556238 + var5) * 8;
               } else {
                  class5.field99[var1][var2][var3] = class5.field99[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var8 = var0.method2554();
               if(var8 == 1) {
                  var8 = 0;
               }

               if(var1 == 0) {
                  class5.field99[0][var2][var3] = -var8 * 8;
               } else {
                  class5.field99[var1][var2][var3] = class5.field99[var1 - 1][var2][var3] - 8 * var8;
               }
               break;
            }

            if(var7 <= 49) {
               class222.field3180[var1][var2][var3] = var0.method2538();
               class5.field81[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class5.field86[var1][var2][var3] = (byte)(var7 - 2 + var6 & 3);
            } else if(var7 <= 81) {
               class5.field82[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class5.field84[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.method2554();
            if(var7 == 0) {
               break;
            }

            if(var7 == 1) {
               var0.method2554();
               break;
            }

            if(var7 <= 49) {
               var0.method2554();
            }
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-37"
   )
   public boolean vmethod2248(int var1) {
      return this.field1625 == 64;
   }

   @ObfuscatedSignature(
      signature = "(Lclass167;Lclass167;IDI)V",
      garbageValue = "64"
   )
   public class95(class167 var1, class167 var2, int var3, double var4, int var6) {
      this.field1626 = var2;
      this.field1622 = var3;
      this.field1623 = this.field1622;
      this.field1630 = var4;
      this.field1625 = var6;
      int[] var7 = var1.method3342(0);
      int var8 = var7.length;
      this.field1627 = new class83[var1.method3321(0)];

      for(int var9 = 0; var9 < var8; ++var9) {
         class119 var10 = new class119(var1.method3286(0, var7[var9]));
         this.field1627[var7[var9]] = new class83(var10);
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1565351386"
   )
   public boolean vmethod2259(int var1) {
      return this.field1627[var1].field1451;
   }
}
