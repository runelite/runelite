import java.awt.Frame;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
@Implements("Player")
public final class class2 extends class37 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1375067971
   )
   int field34 = -1;
   @ObfuscatedName("w")
   @Export("composition")
   class179 field35;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 661071389
   )
   int field36;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1745286075
   )
   int field37 = -1;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1221304479
   )
   int field38;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1839855925
   )
   @Export("combatLevel")
   int field39;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2039669101
   )
   int field40;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -309393289
   )
   int field41;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2055087717
   )
   @Export("totalLevel")
   int field42;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -579164705
   )
   int field43;
   @ObfuscatedName("z")
   boolean field44;
   @ObfuscatedName("e")
   @Export("name")
   String field45;
   @ObfuscatedName("h")
   String[] field46 = new String[3];
   @ObfuscatedName("j")
   @Export("model")
   class105 field47;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1845270559
   )
   int field48;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1683853945
   )
   int field49;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1699744173
   )
   int field50;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 959655173
   )
   int field51;
   @ObfuscatedName("b")
   boolean field52;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 2037048931
   )
   int field53;
   @ObfuscatedName("u")
   boolean field54;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -487069995
   )
   int field55;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1302290505
   )
   int field56;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -374402675
   )
   int field58;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1365300757
   )
   int field59;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1686489001
   )
   static int field60;
   @ObfuscatedName("qk")
   protected static Frame field61;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1151384389
   )
   @Export("team")
   int field62;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass119;B)V",
      garbageValue = "112"
   )
   final void method21(class119 var1) {
      var1.field1976 = 0;
      int var2 = var1.method2523();
      this.field34 = var1.method2633();
      this.field37 = var1.method2633();
      int var3 = -1;
      this.field62 = 0;
      int[] var4 = new int[12];

      int var6;
      int var7;
      for(int var5 = 0; var5 < 12; ++var5) {
         var6 = var1.method2523();
         if(var6 == 0) {
            var4[var5] = 0;
         } else {
            var7 = var1.method2523();
            var4[var5] = var7 + (var6 << 8);
            if(0 == var5 && '\uffff' == var4[0]) {
               var3 = var1.method2700();
               break;
            }

            if(var4[var5] >= 512) {
               int var8 = class33.method711(var4[var5] - 512).field1124;
               if(var8 != 0) {
                  this.field62 = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.method2523();
         if(var7 < 0 || var7 >= class179.field2923[var6].length) {
            var7 = 0;
         }

         var9[var6] = var7;
      }

      super.field847 = var1.method2700();
      if('\uffff' == super.field847) {
         super.field847 = -1;
      }

      super.field794 = var1.method2700();
      if(super.field794 == '\uffff') {
         super.field794 = -1;
      }

      super.field795 = super.field794;
      super.field796 = var1.method2700();
      if('\uffff' == super.field796) {
         super.field796 = -1;
      }

      super.field829 = var1.method2700();
      if('\uffff' == super.field829) {
         super.field829 = -1;
      }

      super.field798 = var1.method2700();
      if(super.field798 == '\uffff') {
         super.field798 = -1;
      }

      super.field799 = var1.method2700();
      if(super.field799 == '\uffff') {
         super.field799 = -1;
      }

      super.field797 = var1.method2700();
      if(super.field797 == '\uffff') {
         super.field797 = -1;
      }

      this.field45 = var1.method2531();
      if(class20.field572 == this) {
         class209.field3117 = this.field45;
      }

      this.field39 = var1.method2523();
      this.field40 = var1.method2700();
      this.field54 = var1.method2523() == 1;
      if(client.field282 == 0 && client.field482 >= 2) {
         this.field54 = false;
      }

      if(null == this.field35) {
         this.field35 = new class179();
      }

      this.field35.method3493(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("w")
   int method22() {
      return null != this.field35 && this.field35.field2928 != -1?class172.method3370(this.field35.field2928).field871:1;
   }

   @ObfuscatedName("s")
   final void method23(int var1, int var2, byte var3) {
      if(-1 != super.field819 && class46.method974(super.field819).field978 == 1) {
         super.field819 = -1;
      }

      super.field815 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.field842[0] >= 0 && super.field842[0] < 104 && super.field843[0] >= 0 && super.field843[0] < 104) {
            if(var3 == 2) {
               class95.method2186(this, var1, var2, (byte)2);
            }

            this.method26(var1, var2, var3);
         } else {
            this.method25(var1, var2);
         }
      } else {
         this.method25(var1, var2);
      }

   }

   @ObfuscatedName("f")
   protected final class105 vmethod1921() {
      if(this.field35 == null) {
         return null;
      } else {
         class42 var1 = -1 != super.field819 && super.field822 == 0?class46.method974(super.field819):null;
         class42 var2 = super.field838 != -1 && !this.field52 && (super.field847 != super.field838 || null == var1)?class46.method974(super.field838):null;
         class105 var3 = this.field35.method3469(var1, super.field789, var2, super.field839);
         if(var3 == null) {
            return null;
         } else {
            var3.method2341();
            super.field808 = var3.field1438;
            class105 var4;
            class105[] var5;
            if(!this.field52 && -1 != super.field824 && super.field817 != -1) {
               var4 = class82.method1906(super.field824).method914(super.field817);
               if(null != var4) {
                  var4.method2337(0, -super.field828, 0);
                  var5 = new class105[]{var3, var4};
                  var3 = new class105(var5, 2);
               }
            }

            if(!this.field52 && this.field47 != null) {
               if(client.field289 >= this.field59) {
                  this.field47 = null;
               }

               if(client.field289 >= this.field42 && client.field289 < this.field59) {
                  var4 = this.field47;
                  var4.method2337(this.field38 - super.field804, this.field53 - this.field41, this.field43 - super.field814);
                  if(512 == super.field793) {
                     var4.method2381();
                     var4.method2381();
                     var4.method2381();
                  } else if(1024 == super.field793) {
                     var4.method2381();
                     var4.method2381();
                  } else if(1536 == super.field793) {
                     var4.method2381();
                  }

                  var5 = new class105[]{var3, var4};
                  var3 = new class105(var5, 2);
                  if(super.field793 == 512) {
                     var4.method2381();
                  } else if(super.field793 == 1024) {
                     var4.method2381();
                     var4.method2381();
                  } else if(super.field793 == 1536) {
                     var4.method2381();
                     var4.method2381();
                     var4.method2381();
                  }

                  var4.method2337(super.field804 - this.field38, this.field41 - this.field53, super.field814 - this.field43);
               }
            }

            var3.field1801 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("p")
   void method25(int var1, int var2) {
      super.field834 = 0;
      super.field811 = 0;
      super.field832 = 0;
      super.field842[0] = var1;
      super.field843[0] = var2;
      int var3 = this.method22();
      super.field804 = var3 * 64 + super.field842[0] * 128;
      super.field814 = 128 * super.field843[0] + var3 * 64;
   }

   @ObfuscatedName("h")
   final void method26(int var1, int var2, byte var3) {
      if(super.field834 < 9) {
         ++super.field834;
      }

      for(int var4 = super.field834; var4 > 0; --var4) {
         super.field842[var4] = super.field842[var4 - 1];
         super.field843[var4] = super.field843[var4 - 1];
         super.field844[var4] = super.field844[var4 - 1];
      }

      super.field842[0] = var1;
      super.field843[0] = var2;
      super.field844[0] = var3;
   }

   @ObfuscatedName("g")
   final boolean vmethod744() {
      return null != this.field35;
   }

   class2() {
      for(int var1 = 0; var1 < 3; ++var1) {
         this.field46[var1] = "";
      }

      this.field39 = 0;
      this.field40 = 0;
      this.field42 = 0;
      this.field59 = 0;
      this.field52 = false;
      this.field62 = 0;
      this.field54 = false;
      this.field44 = false;
   }

   @ObfuscatedName("p")
   public static void method39(int var0) {
      class140.field2139 = var0;
   }
}
