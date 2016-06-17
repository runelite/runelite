import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
@Implements("ObjectComposition")
public class class40 extends class204 {
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 407235851
   )
   int field899 = 0;
   @ObfuscatedName("g")
   public static class167 field900;
   @ObfuscatedName("x")
   public static class193 field901 = new class193(500);
   @ObfuscatedName("d")
   static class193 field902 = new class193(64);
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 2005898471
   )
   public int field903 = -1;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 921810371
   )
   public int field904 = 1;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 178964243
   )
   int field905 = 0;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 1725739007
   )
   public int field906 = 0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 794354321
   )
   public int field907;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -38155525
   )
   public int field908 = 16;
   @ObfuscatedName("p")
   int[] field909;
   @ObfuscatedName("n")
   @Export("name")
   public String field910 = "null";
   @ObfuscatedName("w")
   short[] field911;
   @ObfuscatedName("b")
   public static boolean field912 = false;
   @ObfuscatedName("k")
   short[] field913;
   @ObfuscatedName("o")
   short[] field914;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 688299483
   )
   public int field915 = 1;
   @ObfuscatedName("j")
   public static class167 field916;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1299969333
   )
   public int field917 = 2;
   @ObfuscatedName("a")
   public boolean field918 = true;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1927703853
   )
   public int field919 = -1;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1591388827
   )
   int field920 = -1;
   @ObfuscatedName("af")
   public boolean field921 = true;
   @ObfuscatedName("s")
   public boolean field922 = false;
   @ObfuscatedName("mk")
   @Export("clanMembers")
   static class24[] field923;
   @ObfuscatedName("pn")
   public static class136 field924;
   @ObfuscatedName("m")
   boolean field925 = false;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -450804695
   )
   int field926 = 0;
   @ObfuscatedName("ag")
   @Export("actions")
   public String[] field927 = new String[5];
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -333364137
   )
   public int field928 = -1;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -1610970041
   )
   int field929 = 128;
   @ObfuscatedName("ah")
   boolean field930 = false;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 2041496117
   )
   public int field931 = 0;
   @ObfuscatedName("u")
   int[] field932;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 2064759931
   )
   int field933 = 128;
   @ObfuscatedName("y")
   static class193 field934 = new class193(30);
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1290122735
   )
   int field935 = 0;
   @ObfuscatedName("z")
   short[] field936;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1049301631
   )
   int field937 = 0;
   @ObfuscatedName("ay")
   public boolean field938 = false;
   @ObfuscatedName("as")
   boolean field939 = false;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -553744431
   )
   public int field940 = -1;
   @ObfuscatedName("r")
   static class193 field941 = new class193(30);
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -204662395
   )
   int field942 = -1;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 421969801
   )
   int field943 = -1;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1176860775
   )
   public int field944 = -1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 197088489
   )
   public int field945 = -1;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 443112597
   )
   int field946 = 128;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1119810959
   )
   public int field947 = 0;
   @ObfuscatedName("ao")
   public int[] field948;
   @ObfuscatedName("au")
   @Export("impostorIds")
   public int[] field949;
   @ObfuscatedName("c")
   static class100[] field950 = new class100[4];

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)Lclass105;",
      garbageValue = "-728297333"
   )
   public final class105 method801(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.field909 == null) {
         var7 = (long)(var2 + (this.field907 << 10));
      } else {
         var7 = (long)((var1 << 3) + (this.field907 << 10) + var2);
      }

      class105 var9 = (class105)field941.method3764(var7);
      if(var9 == null) {
         class100 var10 = this.method808(var1, var2);
         if(var10 == null) {
            return null;
         }

         var9 = var10.method2229(64 + this.field899, this.field926 + 768, -50, -10, -50);
         field941.method3759(var9, var7);
      }

      if(this.field920 >= 0) {
         var9 = var9.method2372(var3, var4, var5, var6, true, this.field920);
      }

      return var9;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-849340185"
   )
   static final void method802(int var0, int var1, int var2) {
      int var3;
      for(var3 = 0; var3 < 8; ++var3) {
         for(int var4 = 0; var4 < 8; ++var4) {
            class5.field83[var0][var3 + var1][var4 + var2] = 0;
         }
      }

      if(var1 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class5.field83[var0][var1][var3 + var2] = class5.field83[var0][var1 - 1][var2 + var3];
         }
      }

      if(var2 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class5.field83[var0][var3 + var1][var2] = class5.field83[var0][var3 + var1][var2 - 1];
         }
      }

      if(var1 > 0 && class5.field83[var0][var1 - 1][var2] != 0) {
         class5.field83[var0][var1][var2] = class5.field83[var0][var1 - 1][var2];
      } else if(var2 > 0 && class5.field83[var0][var1][var2 - 1] != 0) {
         class5.field83[var0][var1][var2] = class5.field83[var0][var1][var2 - 1];
      } else if(var1 > 0 && var2 > 0 && class5.field83[var0][var1 - 1][var2 - 1] != 0) {
         class5.field83[var0][var1][var2] = class5.field83[var0][var1 - 1][var2 - 1];
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1044097565"
   )
   public final boolean method803(int var1) {
      if(null != this.field909) {
         for(int var4 = 0; var4 < this.field909.length; ++var4) {
            if(var1 == this.field909[var4]) {
               return field916.method3268(this.field932[var4] & '\uffff', 0);
            }
         }

         return true;
      } else if(this.field932 == null) {
         return true;
      } else if(var1 != 10) {
         return true;
      } else {
         boolean var2 = true;

         for(int var3 = 0; var3 < this.field932.length; ++var3) {
            var2 &= field916.method3268(this.field932[var3] & '\uffff', 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "105"
   )
   public final boolean method804() {
      if(null == this.field932) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field932.length; ++var2) {
            var1 &= field916.method3268(this.field932[var2] & '\uffff', 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Lclass40;",
      garbageValue = "1844675164"
   )
   @Export("getImpostor")
   public final class40 method805() {
      int var1 = -1;
      if(this.field942 != -1) {
         var1 = class7.method90(this.field942);
      } else if(this.field943 != -1) {
         var1 = class176.field2896[this.field943];
      }

      return var1 >= 0 && var1 < this.field949.length && this.field949[var1] != -1?class172.method3399(this.field949[var1]):null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1155395106"
   )
   void method806() {
      if(this.field919 == -1) {
         this.field919 = 0;
         if(null != this.field932 && (null == this.field909 || this.field909[0] == 10)) {
            this.field919 = 1;
         }

         for(int var1 = 0; var1 < 5; ++var1) {
            if(this.field927[var1] != null) {
               this.field919 = 1;
            }
         }
      }

      if(this.field940 == -1) {
         this.field940 = this.field917 != 0?1:0;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II[[IIIILclass42;II)Lclass105;",
      garbageValue = "-1181750664"
   )
   public final class105 method807(int var1, int var2, int[][] var3, int var4, int var5, int var6, class42 var7, int var8) {
      long var9;
      if(this.field909 == null) {
         var9 = (long)((this.field907 << 10) + var2);
      } else {
         var9 = (long)((this.field907 << 10) + (var1 << 3) + var2);
      }

      class105 var11 = (class105)field941.method3764(var9);
      if(null == var11) {
         class100 var12 = this.method808(var1, var2);
         if(null == var12) {
            return null;
         }

         var11 = var12.method2229(this.field899 + 64, this.field926 + 768, -50, -10, -50);
         field941.method3759(var11, var9);
      }

      if(null == var7 && this.field920 == -1) {
         return var11;
      } else {
         if(var7 != null) {
            var11 = var7.method867(var11, var8, var2);
         } else {
            var11 = var11.method2296(true);
         }

         if(this.field920 >= 0) {
            var11 = var11.method2372(var3, var4, var5, var6, false, this.field920);
         }

         return var11;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIB)Lclass100;",
      garbageValue = "-116"
   )
   final class100 method808(int var1, int var2) {
      class100 var3 = null;
      boolean var4;
      int var5;
      int var7;
      if(null == this.field909) {
         if(var1 != 10) {
            return null;
         }

         if(null == this.field932) {
            return null;
         }

         var4 = this.field930;
         if(var1 == 2 && var2 > 3) {
            var4 = !var4;
         }

         var5 = this.field932.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            var7 = this.field932[var6];
            if(var4) {
               var7 += 65536;
            }

            var3 = (class100)field901.method3764((long)var7);
            if(var3 == null) {
               var3 = class100.method2208(field916, var7 & '\uffff', 0);
               if(null == var3) {
                  return null;
               }

               if(var4) {
                  var3.method2223();
               }

               field901.method3759(var3, (long)var7);
            }

            if(var5 > 1) {
               field950[var6] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new class100(field950, var5);
         }
      } else {
         int var9 = -1;

         for(var5 = 0; var5 < this.field909.length; ++var5) {
            if(var1 == this.field909[var5]) {
               var9 = var5;
               break;
            }
         }

         if(var9 == -1) {
            return null;
         }

         var5 = this.field932[var9];
         boolean var10 = this.field930 ^ var2 > 3;
         if(var10) {
            var5 += 65536;
         }

         var3 = (class100)field901.method3764((long)var5);
         if(null == var3) {
            var3 = class100.method2208(field916, var5 & '\uffff', 0);
            if(null == var3) {
               return null;
            }

            if(var10) {
               var3.method2223();
            }

            field901.method3759(var3, (long)var5);
         }
      }

      if(this.field946 == 128 && this.field933 == 128 && this.field929 == 128) {
         var4 = false;
      } else {
         var4 = true;
      }

      boolean var11;
      if(this.field935 == 0 && this.field905 == 0 && this.field937 == 0) {
         var11 = false;
      } else {
         var11 = true;
      }

      class100 var8 = new class100(var3, var2 == 0 && !var4 && !var11, null == this.field911, null == this.field913, true);
      if(var1 == 4 && var2 > 3) {
         var8.method2209(256);
         var8.method2220(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var8.method2216();
      } else if(var2 == 2) {
         var8.method2217();
      } else if(var2 == 3) {
         var8.method2218();
      }

      if(this.field911 != null) {
         for(var7 = 0; var7 < this.field911.length; ++var7) {
            var8.method2221(this.field911[var7], this.field936[var7]);
         }
      }

      if(this.field913 != null) {
         for(var7 = 0; var7 < this.field913.length; ++var7) {
            var8.method2222(this.field913[var7], this.field914[var7]);
         }
      }

      if(var4) {
         var8.method2271(this.field946, this.field933, this.field929);
      }

      if(var11) {
         var8.method2220(this.field935, this.field905, this.field937);
      }

      return var8;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "0"
   )
   public boolean method810() {
      if(this.field949 == null) {
         return this.field944 != -1 || null != this.field948;
      } else {
         for(int var1 = 0; var1 < this.field949.length; ++var1) {
            if(this.field949[var1] != -1) {
               class40 var2 = class172.method3399(this.field949[var1]);
               if(var2.field944 != -1 || var2.field948 != null) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "492990982"
   )
   void method819(class119 var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2514();
         if(var3 > 0) {
            if(this.field932 != null && !field912) {
               var1.field1976 += 3 * var3;
            } else {
               this.field909 = new int[var3];
               this.field932 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field932[var4] = var1.method2516();
                  this.field909[var4] = var1.method2514();
               }
            }
         }
      } else if(var2 == 2) {
         this.field910 = var1.method2522();
      } else if(var2 == 5) {
         var3 = var1.method2514();
         if(var3 > 0) {
            if(null != this.field932 && !field912) {
               var1.field1976 += var3 * 2;
            } else {
               this.field909 = null;
               this.field932 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field932[var4] = var1.method2516();
               }
            }
         }
      } else if(var2 == 14) {
         this.field915 = var1.method2514();
      } else if(var2 == 15) {
         this.field904 = var1.method2514();
      } else if(var2 == 17) {
         this.field917 = 0;
         this.field918 = false;
      } else if(var2 == 18) {
         this.field918 = false;
      } else if(var2 == 19) {
         this.field919 = var1.method2514();
      } else if(var2 == 21) {
         this.field920 = 0;
      } else if(var2 == 22) {
         this.field925 = true;
      } else if(var2 == 23) {
         this.field922 = true;
      } else if(var2 == 24) {
         this.field945 = var1.method2516();
         if(this.field945 == '\uffff') {
            this.field945 = -1;
         }
      } else if(var2 == 27) {
         this.field917 = 1;
      } else if(var2 == 28) {
         this.field908 = var1.method2514();
      } else if(var2 == 29) {
         this.field899 = var1.method2515();
      } else if(var2 == 39) {
         this.field926 = var1.method2515() * 25;
      } else if(var2 >= 30 && var2 < 35) {
         this.field927[var2 - 30] = var1.method2522();
         if(this.field927[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.field927[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.method2514();
         this.field911 = new short[var3];
         this.field936 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field911[var4] = (short)var1.method2516();
            this.field936[var4] = (short)var1.method2516();
         }
      } else if(var2 == 41) {
         var3 = var1.method2514();
         this.field913 = new short[var3];
         this.field914 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field913[var4] = (short)var1.method2516();
            this.field914[var4] = (short)var1.method2516();
         }
      } else if(var2 == 60) {
         this.field928 = var1.method2516();
      } else if(var2 == 62) {
         this.field930 = true;
      } else if(var2 == 64) {
         this.field921 = false;
      } else if(var2 == 65) {
         this.field946 = var1.method2516();
      } else if(var2 == 66) {
         this.field933 = var1.method2516();
      } else if(var2 == 67) {
         this.field929 = var1.method2516();
      } else if(var2 == 68) {
         this.field903 = var1.method2516();
      } else if(var2 == 69) {
         var1.method2514();
      } else if(var2 == 70) {
         this.field935 = var1.method2517();
      } else if(var2 == 71) {
         this.field905 = var1.method2517();
      } else if(var2 == 72) {
         this.field937 = var1.method2517();
      } else if(var2 == 73) {
         this.field938 = true;
      } else if(var2 == 74) {
         this.field939 = true;
      } else if(var2 == 75) {
         this.field940 = var1.method2514();
      } else if(var2 == 77) {
         this.field942 = var1.method2516();
         if(this.field942 == '\uffff') {
            this.field942 = -1;
         }

         this.field943 = var1.method2516();
         if(this.field943 == '\uffff') {
            this.field943 = -1;
         }

         var3 = var1.method2514();
         this.field949 = new int[1 + var3];

         for(var4 = 0; var4 <= var3; ++var4) {
            this.field949[var4] = var1.method2516();
            if(this.field949[var4] == '\uffff') {
               this.field949[var4] = -1;
            }
         }
      } else if(var2 == 78) {
         this.field944 = var1.method2516();
         this.field906 = var1.method2514();
      } else if(var2 == 79) {
         this.field931 = var1.method2516();
         this.field947 = var1.method2516();
         this.field906 = var1.method2514();
         var3 = var1.method2514();
         this.field948 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field948[var4] = var1.method2516();
         }
      } else if(var2 == 81) {
         this.field920 = var1.method2514() * 256;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)Lclass85;",
      garbageValue = "1093527833"
   )
   public final class85 method833(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.field909 == null) {
         var7 = (long)((this.field907 << 10) + var2);
      } else {
         var7 = (long)((this.field907 << 10) + (var1 << 3) + var2);
      }

      Object var9 = (class85)field934.method3764(var7);
      if(var9 == null) {
         class100 var10 = this.method808(var1, var2);
         if(null == var10) {
            return null;
         }

         if(!this.field925) {
            var9 = var10.method2229(64 + this.field899, 768 + this.field926, -50, -10, -50);
         } else {
            var10.field1699 = (short)(this.field899 + 64);
            var10.field1700 = (short)(this.field926 + 768);
            var10.method2212();
            var9 = var10;
         }

         field934.method3759((class204)var9, var7);
      }

      if(this.field925) {
         var9 = ((class100)var9).method2213();
      }

      if(this.field920 >= 0) {
         if(var9 instanceof class105) {
            var9 = ((class105)var9).method2372(var3, var4, var5, var6, true, this.field920);
         } else if(var9 instanceof class100) {
            var9 = ((class100)var9).method2214(var3, var4, var5, var6, true, this.field920);
         }
      }

      return (class85)var9;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "11467753"
   )
   void method842(class119 var1) {
      while(true) {
         int var2 = var1.method2514();
         if(var2 == 0) {
            return;
         }

         this.method819(var1, var2);
      }
   }
}
