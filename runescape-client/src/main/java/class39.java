import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
@Implements("NPCComposition")
public class class39 extends class204 {
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1038413467
   )
   int field863 = -1;
   @ObfuscatedName("f")
   @Export("isVisible")
   public boolean field864 = false;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 742156799
   )
   @Export("combatLevel")
   public int field865 = -1;
   @ObfuscatedName("b")
   short[] field866;
   @ObfuscatedName("e")
   @Export("name")
   public String field867 = "null";
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 463113267
   )
   public int field868 = 1;
   @ObfuscatedName("c")
   @Export("models")
   int[] field869;
   @ObfuscatedName("n")
   int[] field870;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 105871753
   )
   public int field871 = -1;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 2107134903
   )
   public int field872 = 30;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 954633851
   )
   public int field873 = -1;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2123807809
   )
   public int field874 = -1;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1296666197
   )
   public int field875 = -1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 674976785
   )
   public int field876 = -1;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1195395591
   )
   public int field877 = -1;
   @ObfuscatedName("z")
   static class193 field878 = new class193(50);
   @ObfuscatedName("t")
   short[] field879;
   @ObfuscatedName("ao")
   public boolean field880 = true;
   @ObfuscatedName("w")
   short[] field881;
   @ObfuscatedName("g")
   @Export("actions")
   public String[] field882 = new String[5];
   @ObfuscatedName("s")
   @Export("isMinimapVisible")
   public boolean field883 = true;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 448331587
   )
   public int field884 = -1;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 38496073
   )
   int field885 = 0;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1660133785
   )
   int field886 = 128;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1786757217
   )
   int field888 = 0;
   @ObfuscatedName("y")
   short[] field889;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1219402739
   )
   public int field890 = -1;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1311080257
   )
   int field891 = 128;
   @ObfuscatedName("an")
   public int[] field892;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 776327791
   )
   int field893 = -1;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -653538645
   )
   public int field894 = 32;
   @ObfuscatedName("j")
   public static class167 field895;
   @ObfuscatedName("ag")
   @Export("isClickable")
   public boolean field896 = true;
   @ObfuscatedName("as")
   public boolean field897 = false;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -499572507
   )
   @Export("id")
   public int field898;
   @ObfuscatedName("qp")
   @ObfuscatedGetter(
      intValue = -353949825
   )
   public static int field901;
   @ObfuscatedName("m")
   static class193 field902 = new class193(64);
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = 719261863
   )
   static int field903;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass42;ILclass42;II)Lclass105;",
      garbageValue = "-1921135770"
   )
   public final class105 method755(class42 var1, int var2, class42 var3, int var4) {
      if(this.field892 != null) {
         class39 var11 = this.method759();
         return var11 == null?null:var11.method755(var1, var2, var3, var4);
      } else {
         class105 var5 = (class105)field878.method3704((long)this.field898);
         if(null == var5) {
            boolean var6 = false;

            for(int var7 = 0; var7 < this.field869.length; ++var7) {
               if(!class177.field2912.method3294(this.field869[var7], 0)) {
                  var6 = true;
               }
            }

            if(var6) {
               return null;
            }

            class100[] var8 = new class100[this.field869.length];

            int var9;
            for(var9 = 0; var9 < this.field869.length; ++var9) {
               var8[var9] = class100.method2198(class177.field2912, this.field869[var9], 0);
            }

            class100 var12;
            if(var8.length == 1) {
               var12 = var8[0];
            } else {
               var12 = new class100(var8, var8.length);
            }

            if(null != this.field866) {
               for(var9 = 0; var9 < this.field866.length; ++var9) {
                  var12.method2202(this.field866[var9], this.field879[var9]);
               }
            }

            if(this.field889 != null) {
               for(var9 = 0; var9 < this.field889.length; ++var9) {
                  var12.method2214(this.field889[var9], this.field881[var9]);
               }
            }

            var5 = var12.method2218(this.field888 + 64, this.field885 + 850, -30, -50, -30);
            field878.method3706(var5, (long)this.field898);
         }

         class105 var10;
         if(var1 != null && var3 != null) {
            var10 = var1.method856(var5, var2, var3, var4);
         } else if(var1 != null) {
            var10 = var1.method858(var5, var2);
         } else if(null != var3) {
            var10 = var3.method858(var5, var4);
         } else {
            var10 = var5.method2286(true);
         }

         if(128 != this.field891 || this.field886 != 128) {
            var10.method2324(this.field891, this.field886, this.field891);
         }

         return var10;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "-562748926"
   )
   void method756(class119 var1) {
      while(true) {
         int var2 = var1.method2500();
         if(var2 == 0) {
            return;
         }

         this.method780(var1, var2);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Lclass100;",
      garbageValue = "385851976"
   )
   public final class100 method758() {
      if(this.field892 != null) {
         class39 var5 = this.method759();
         return null == var5?null:var5.method758();
      } else if(this.field870 == null) {
         return null;
      } else {
         boolean var1 = false;

         for(int var2 = 0; var2 < this.field870.length; ++var2) {
            if(!class177.field2912.method3294(this.field870[var2], 0)) {
               var1 = true;
            }
         }

         if(var1) {
            return null;
         } else {
            class100[] var6 = new class100[this.field870.length];

            for(int var3 = 0; var3 < this.field870.length; ++var3) {
               var6[var3] = class100.method2198(class177.field2912, this.field870[var3], 0);
            }

            class100 var7;
            if(var6.length == 1) {
               var7 = var6[0];
            } else {
               var7 = new class100(var6, var6.length);
            }

            int var4;
            if(null != this.field866) {
               for(var4 = 0; var4 < this.field866.length; ++var4) {
                  var7.method2202(this.field866[var4], this.field879[var4]);
               }
            }

            if(this.field889 != null) {
               for(var4 = 0; var4 < this.field889.length; ++var4) {
                  var7.method2214(this.field889[var4], this.field881[var4]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Lclass39;",
      garbageValue = "-1214399462"
   )
   public final class39 method759() {
      int var1 = -1;
      if(this.field893 != -1) {
         var1 = class59.method1263(this.field893);
      } else if(-1 != this.field863) {
         var1 = class176.field2900[this.field863];
      }

      return var1 >= 0 && var1 < this.field892.length && -1 != this.field892[var1]?class156.method3130(this.field892[var1]):null;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "364932433"
   )
   public boolean method760() {
      if(null == this.field892) {
         return true;
      } else {
         int var1 = -1;
         if(-1 != this.field893) {
            var1 = class59.method1263(this.field893);
         } else if(-1 != this.field863) {
            var1 = class176.field2900[this.field863];
         }

         return var1 >= 0 && var1 < this.field892.length && -1 != this.field892[var1];
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BIIII[Lclass108;I)V",
      garbageValue = "2024607046"
   )
   static final void method769(byte[] var0, int var1, int var2, int var3, int var4, class108[] var5) {
      int var7;
      int var8;
      for(int var6 = 0; var6 < 4; ++var6) {
         for(var7 = 0; var7 < 64; ++var7) {
            for(var8 = 0; var8 < 64; ++var8) {
               if(var7 + var1 > 0 && var7 + var1 < 103 && var8 + var2 > 0 && var8 + var2 < 103) {
                  var5[var6].field1879[var7 + var1][var2 + var8] &= -16777217;
               }
            }
         }
      }

      class119 var10 = new class119(var0);

      for(var7 = 0; var7 < 4; ++var7) {
         for(var8 = 0; var8 < 64; ++var8) {
            for(int var9 = 0; var9 < 64; ++var9) {
               class85.method1902(var10, var7, var8 + var1, var2 + var9, var3, var4, 0);
            }
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "-2127790753"
   )
   void method780(class119 var1, int var2) {
      int var3;
      int var4;
      if(1 == var2) {
         var3 = var1.method2500();
         this.field869 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field869[var4] = var1.method2502();
         }
      } else if(var2 == 2) {
         this.field867 = var1.method2508();
      } else if(12 == var2) {
         this.field868 = var1.method2500();
      } else if(var2 == 13) {
         this.field871 = var1.method2502();
      } else if(14 == var2) {
         this.field874 = var1.method2502();
      } else if(15 == var2) {
         this.field884 = var1.method2502();
      } else if(var2 == 16) {
         this.field873 = var1.method2502();
      } else if(var2 == 17) {
         this.field874 = var1.method2502();
         this.field875 = var1.method2502();
         this.field876 = var1.method2502();
         this.field877 = var1.method2502();
      } else if(var2 >= 30 && var2 < 35) {
         this.field882[var2 - 30] = var1.method2508();
         if(this.field882[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.field882[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.method2500();
         this.field866 = new short[var3];
         this.field879 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field866[var4] = (short)var1.method2502();
            this.field879[var4] = (short)var1.method2502();
         }
      } else if(var2 == 41) {
         var3 = var1.method2500();
         this.field889 = new short[var3];
         this.field881 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field889[var4] = (short)var1.method2502();
            this.field881[var4] = (short)var1.method2502();
         }
      } else if(var2 == 60) {
         var3 = var1.method2500();
         this.field870 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field870[var4] = var1.method2502();
         }
      } else if(var2 == 93) {
         this.field883 = false;
      } else if(var2 == 95) {
         this.field865 = var1.method2502();
      } else if(var2 == 97) {
         this.field891 = var1.method2502();
      } else if(98 == var2) {
         this.field886 = var1.method2502();
      } else if(99 == var2) {
         this.field864 = true;
      } else if(100 == var2) {
         this.field888 = var1.method2670();
      } else if(var2 == 101) {
         this.field885 = var1.method2670() * 5;
      } else if(var2 == 102) {
         this.field890 = var1.method2502();
      } else if(103 == var2) {
         this.field894 = var1.method2502();
      } else if(106 == var2) {
         this.field893 = var1.method2502();
         if('\uffff' == this.field893) {
            this.field893 = -1;
         }

         this.field863 = var1.method2502();
         if('\uffff' == this.field863) {
            this.field863 = -1;
         }

         var3 = var1.method2500();
         this.field892 = new int[1 + var3];

         for(var4 = 0; var4 <= var3; ++var4) {
            this.field892[var4] = var1.method2502();
            if(this.field892[var4] == '\uffff') {
               this.field892[var4] = -1;
            }
         }
      } else if(var2 == 107) {
         this.field880 = false;
      } else if(var2 == 109) {
         this.field896 = false;
      } else if(var2 == 111) {
         this.field897 = true;
      } else if(112 == var2) {
         this.field872 = var1.method2500();
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "519212151"
   )
   void method782() {
   }
}
