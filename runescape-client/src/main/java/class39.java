import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
@Implements("NPCComposition")
public class class39 extends class204 {
   @ObfuscatedName("ha")
   @ObfuscatedGetter(
      intValue = 1240433461
   )
   static int field882;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1303695467
   )
   int field883 = -1;
   @ObfuscatedName("s")
   public static class167 field884;
   @ObfuscatedName("x")
   static class193 field885 = new class193(50);
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1080763305
   )
   @Export("id")
   public int field886;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -477372321
   )
   public int field887 = 1;
   @ObfuscatedName("p")
   static class193 field888 = new class193(64);
   @ObfuscatedName("b")
   @Export("models")
   int[] field889;
   @ObfuscatedName("k")
   int[] field890;
   @ObfuscatedName("a")
   short[] field891;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1119886487
   )
   public int field892 = -1;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 916127889
   )
   public int field893 = -1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 732199375
   )
   public int field894 = -1;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -1910720153
   )
   public int field895 = 32;
   @ObfuscatedName("ai")
   public boolean field896 = false;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 429899845
   )
   public int field897 = -1;
   @ObfuscatedName("h")
   short[] field898;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 137607265
   )
   public int field899 = -1;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1498006567
   )
   @Export("combatLevel")
   public int field900 = -1;
   @ObfuscatedName("w")
   short[] field901;
   @ObfuscatedName("g")
   @Export("actions")
   public String[] field902 = new String[5];
   @ObfuscatedName("y")
   @Export("isMinimapVisible")
   public boolean field903 = true;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 513073645
   )
   int field904 = 0;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1078416461
   )
   int field905 = 128;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 554363043
   )
   int field906 = 128;
   @ObfuscatedName("v")
   @Export("isVisible")
   public boolean field907 = false;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 1000676227
   )
   int field908 = 0;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -843602535
   )
   public int field909 = -1;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 739336157
   )
   public int field910 = -1;
   @ObfuscatedName("z")
   short[] field911;
   @ObfuscatedName("j")
   public static class167 field912;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1206362791
   )
   int field913 = -1;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 92132913
   )
   public int field914 = -1;
   @ObfuscatedName("ao")
   public boolean field915 = true;
   @ObfuscatedName("as")
   @Export("isClickable")
   public boolean field916 = true;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 2142914691
   )
   public int field917 = 30;
   @ObfuscatedName("u")
   @Export("name")
   public String field918 = "null";
   @ObfuscatedName("eq")
   static class78[] field919;
   @ObfuscatedName("af")
   static class143 field920;
   @ObfuscatedName("ap")
   public int[] field921;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-44"
   )
   public boolean method739() {
      if(null == this.field921) {
         return true;
      } else {
         int var1 = -1;
         if(this.field913 != -1) {
            var1 = class32.method691(this.field913);
         } else if(this.field883 != -1) {
            var1 = class176.field2920[this.field883];
         }

         return var1 >= 0 && var1 < this.field921.length && -1 != this.field921[var1];
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)Lclass39;",
      garbageValue = "15"
   )
   public final class39 method740() {
      int var1 = -1;
      if(this.field913 != -1) {
         var1 = class32.method691(this.field913);
      } else if(-1 != this.field883) {
         var1 = class176.field2920[this.field883];
      }

      return var1 >= 0 && var1 < this.field921.length && -1 != this.field921[var1]?class99.method2179(this.field921[var1]):null;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "-1604421713"
   )
   void method741(class119 var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2492();
         this.field889 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field889[var4] = var1.method2584();
         }
      } else if(2 == var2) {
         this.field918 = var1.method2500();
      } else if(var2 == 12) {
         this.field887 = var1.method2492();
      } else if(13 == var2) {
         this.field914 = var1.method2584();
      } else if(14 == var2) {
         this.field894 = var1.method2584();
      } else if(var2 == 15) {
         this.field899 = var1.method2584();
      } else if(16 == var2) {
         this.field893 = var1.method2584();
      } else if(var2 == 17) {
         this.field894 = var1.method2584();
         this.field909 = var1.method2584();
         this.field892 = var1.method2584();
         this.field897 = var1.method2584();
      } else if(var2 >= 30 && var2 < 35) {
         this.field902[var2 - 30] = var1.method2500();
         if(this.field902[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.field902[var2 - 30] = null;
         }
      } else if(40 == var2) {
         var3 = var1.method2492();
         this.field898 = new short[var3];
         this.field911 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field898[var4] = (short)var1.method2584();
            this.field911[var4] = (short)var1.method2584();
         }
      } else if(41 == var2) {
         var3 = var1.method2492();
         this.field891 = new short[var3];
         this.field901 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field891[var4] = (short)var1.method2584();
            this.field901[var4] = (short)var1.method2584();
         }
      } else if(60 == var2) {
         var3 = var1.method2492();
         this.field890 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field890[var4] = var1.method2584();
         }
      } else if(93 == var2) {
         this.field903 = false;
      } else if(var2 == 95) {
         this.field900 = var1.method2584();
      } else if(97 == var2) {
         this.field905 = var1.method2584();
      } else if(98 == var2) {
         this.field906 = var1.method2584();
      } else if(var2 == 99) {
         this.field907 = true;
      } else if(100 == var2) {
         this.field908 = var1.method2493();
      } else if(101 == var2) {
         this.field904 = var1.method2493() * 5;
      } else if(102 == var2) {
         this.field910 = var1.method2584();
      } else if(103 == var2) {
         this.field895 = var1.method2584();
      } else if(var2 == 106) {
         this.field913 = var1.method2584();
         if('\uffff' == this.field913) {
            this.field913 = -1;
         }

         this.field883 = var1.method2584();
         if('\uffff' == this.field883) {
            this.field883 = -1;
         }

         var3 = var1.method2492();
         this.field921 = new int[var3 + 1];

         for(var4 = 0; var4 <= var3; ++var4) {
            this.field921[var4] = var1.method2584();
            if(this.field921[var4] == '\uffff') {
               this.field921[var4] = -1;
            }
         }
      } else if(var2 == 107) {
         this.field915 = false;
      } else if(109 == var2) {
         this.field916 = false;
      } else if(var2 == 111) {
         this.field896 = true;
      } else if(112 == var2) {
         this.field917 = var1.method2492();
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass42;ILclass42;IS)Lclass105;",
      garbageValue = "1266"
   )
   public final class105 method742(class42 var1, int var2, class42 var3, int var4) {
      if(null != this.field921) {
         class39 var11 = this.method740();
         return var11 == null?null:var11.method742(var1, var2, var3, var4);
      } else {
         class105 var5 = (class105)field885.method3743((long)this.field886);
         if(null == var5) {
            boolean var6 = false;

            for(int var7 = 0; var7 < this.field889.length; ++var7) {
               if(!field912.method3272(this.field889[var7], 0)) {
                  var6 = true;
               }
            }

            if(var6) {
               return null;
            }

            class100[] var8 = new class100[this.field889.length];

            int var9;
            for(var9 = 0; var9 < this.field889.length; ++var9) {
               var8[var9] = class100.method2181(field912, this.field889[var9], 0);
            }

            class100 var12;
            if(var8.length == 1) {
               var12 = var8[0];
            } else {
               var12 = new class100(var8, var8.length);
            }

            if(null != this.field898) {
               for(var9 = 0; var9 < this.field898.length; ++var9) {
                  var12.method2194(this.field898[var9], this.field911[var9]);
               }
            }

            if(null != this.field891) {
               for(var9 = 0; var9 < this.field891.length; ++var9) {
                  var12.method2195(this.field891[var9], this.field901[var9]);
               }
            }

            var5 = var12.method2202(64 + this.field908, 850 + this.field904, -30, -50, -30);
            field885.method3745(var5, (long)this.field886);
         }

         class105 var10;
         if(var1 != null && var3 != null) {
            var10 = var1.method844(var5, var2, var3, var4);
         } else if(null != var1) {
            var10 = var1.method841(var5, var2);
         } else if(null != var3) {
            var10 = var3.method841(var5, var4);
         } else {
            var10 = var5.method2284(true);
         }

         if(128 != this.field905 || 128 != this.field906) {
            var10.method2301(this.field905, this.field906, this.field905);
         }

         return var10;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Lclass100;",
      garbageValue = "1816951751"
   )
   public final class100 method743() {
      if(this.field921 != null) {
         class39 var5 = this.method740();
         return null == var5?null:var5.method743();
      } else if(null == this.field890) {
         return null;
      } else {
         boolean var1 = false;

         for(int var2 = 0; var2 < this.field890.length; ++var2) {
            if(!field912.method3272(this.field890[var2], 0)) {
               var1 = true;
            }
         }

         if(var1) {
            return null;
         } else {
            class100[] var6 = new class100[this.field890.length];

            for(int var3 = 0; var3 < this.field890.length; ++var3) {
               var6[var3] = class100.method2181(field912, this.field890[var3], 0);
            }

            class100 var7;
            if(var6.length == 1) {
               var7 = var6[0];
            } else {
               var7 = new class100(var6, var6.length);
            }

            int var4;
            if(null != this.field898) {
               for(var4 = 0; var4 < this.field898.length; ++var4) {
                  var7.method2194(this.field898[var4], this.field911[var4]);
               }
            }

            if(this.field891 != null) {
               for(var4 = 0; var4 < this.field891.length; ++var4) {
                  var7.method2195(this.field891[var4], this.field901[var4]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1485800567"
   )
   void method745() {
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "-1368507632"
   )
   void method746(class119 var1) {
      while(true) {
         int var2 = var1.method2492();
         if(var2 == 0) {
            return;
         }

         this.method741(var1, var2);
      }
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "2123231539"
   )
   static final void method772(int var0, int var1) {
      int var2 = class164.field2665.method3997("Choose Option");

      int var3;
      for(var3 = 0; var3 < client.field496; ++var3) {
         class224 var4 = class164.field2665;
         String var5;
         if(client.field425[var3].length() > 0) {
            var5 = client.field424[var3] + " " + client.field425[var3];
         } else {
            var5 = client.field424[var3];
         }

         int var6 = var4.method3997(var5);
         if(var6 > var2) {
            var2 = var6;
         }
      }

      var2 += 8;
      var3 = 22 + client.field496 * 15;
      int var7 = var0 - var2 / 2;
      if(var7 + var2 > class15.field214) {
         var7 = class15.field214 - var2;
      }

      if(var7 < 0) {
         var7 = 0;
      }

      int var8 = var1;
      if(var3 + var1 > class15.field215) {
         var8 = class15.field215 - var3;
      }

      if(var8 < 0) {
         var8 = 0;
      }

      client.field418 = true;
      field882 = var7;
      class7.field136 = var8;
      class172.field2749 = var2;
      class0.field0 = 22 + client.field496 * 15;
   }
}
