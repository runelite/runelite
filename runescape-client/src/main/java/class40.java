import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
@Implements("ObjectComposition")
public class class40 extends class204 {
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 776536587
   )
   public int field935 = 0;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 461760143
   )
   int field936 = 0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1649802513
   )
   public int field937 = 1;
   @ObfuscatedName("b")
   public static class193 field938 = new class193(64);
   @ObfuscatedName("r")
   int[] field939;
   @ObfuscatedName("d")
   public static class193 field940 = new class193(30);
   @ObfuscatedName("s")
   int[] field941;
   @ObfuscatedName("m")
   static class100[] field942 = new class100[4];
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 913215195
   )
   public int field943;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -91121431
   )
   int field944 = 0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1472189129
   )
   public int field945 = 1;
   @ObfuscatedName("h")
   short[] field946;
   @ObfuscatedName("aa")
   @Export("impostorIds")
   public int[] field947;
   @ObfuscatedName("q")
   short[] field948;
   @ObfuscatedName("p")
   short[] field949;
   @ObfuscatedName("n")
   public static class193 field950 = new class193(30);
   @ObfuscatedName("x")
   static class167 field951;
   @ObfuscatedName("an")
   boolean field952 = false;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 423290879
   )
   public int field953 = 2;
   @ObfuscatedName("v")
   public boolean field954 = true;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 515901123
   )
   public int field955 = -1;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1917013995
   )
   int field956 = -1;
   @ObfuscatedName("i")
   boolean field957 = false;
   @ObfuscatedName("a")
   public boolean field958 = false;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 454746003
   )
   public int field959 = -1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 694654273
   )
   public int field960 = 16;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 938076077
   )
   int field961 = 0;
   @ObfuscatedName("k")
   @Export("name")
   public String field962 = "null";
   @ObfuscatedName("ao")
   @Export("actions")
   public String[] field963 = new String[5];
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -1278227629
   )
   public int field964 = -1;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 526753447
   )
   public int field965 = -1;
   @ObfuscatedName("l")
   public static class193 field966 = new class193(500);
   @ObfuscatedName("al")
   public boolean field967 = true;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -863916979
   )
   int field968 = 128;
   @ObfuscatedName("u")
   static class167 field969;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 405536543
   )
   int field970 = 128;
   @ObfuscatedName("ap")
   boolean field971 = false;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 2004680555
   )
   int field972 = 0;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 2064997873
   )
   int field973 = 0;
   @ObfuscatedName("f")
   static boolean field974 = false;
   @ObfuscatedName("o")
   short[] field975;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -459740627
   )
   public int field976 = -1;
   @ObfuscatedName("ah")
   public boolean field977 = false;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 436727801
   )
   int field978 = -1;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1687219447
   )
   int field979 = -1;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 941104611
   )
   int field980 = 128;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -361315399
   )
   public int field981 = -1;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -2052639863
   )
   public int field982 = 0;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1062170319
   )
   public int field983 = 0;
   @ObfuscatedName("ar")
   public int[] field984;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass119;IB)V",
      garbageValue = "13"
   )
   void method843(class119 var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2554();
         if(var3 > 0) {
            if(this.field941 != null && !field974) {
               var1.field1998 += 3 * var3;
            } else {
               this.field939 = new int[var3];
               this.field941 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field941[var4] = var1.method2556();
                  this.field939[var4] = var1.method2554();
               }
            }
         }
      } else if(var2 == 2) {
         this.field962 = var1.method2668();
      } else if(var2 == 5) {
         var3 = var1.method2554();
         if(var3 > 0) {
            if(null != this.field941 && !field974) {
               var1.field1998 += 2 * var3;
            } else {
               this.field939 = null;
               this.field941 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field941[var4] = var1.method2556();
               }
            }
         }
      } else if(var2 == 14) {
         this.field945 = var1.method2554();
      } else if(var2 == 15) {
         this.field937 = var1.method2554();
      } else if(var2 == 17) {
         this.field953 = 0;
         this.field954 = false;
      } else if(var2 == 18) {
         this.field954 = false;
      } else if(var2 == 19) {
         this.field955 = var1.method2554();
      } else if(var2 == 21) {
         this.field956 = 0;
      } else if(var2 == 22) {
         this.field957 = true;
      } else if(var2 == 23) {
         this.field958 = true;
      } else if(var2 == 24) {
         this.field959 = var1.method2556();
         if(this.field959 == '\uffff') {
            this.field959 = -1;
         }
      } else if(var2 == 27) {
         this.field953 = 1;
      } else if(var2 == 28) {
         this.field960 = var1.method2554();
      } else if(var2 == 29) {
         this.field961 = var1.method2538();
      } else if(var2 == 39) {
         this.field944 = var1.method2538() * 25;
      } else if(var2 >= 30 && var2 < 35) {
         this.field963[var2 - 30] = var1.method2668();
         if(this.field963[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.field963[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.method2554();
         this.field975 = new short[var3];
         this.field948 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field975[var4] = (short)var1.method2556();
            this.field948[var4] = (short)var1.method2556();
         }
      } else if(var2 == 41) {
         var3 = var1.method2554();
         this.field949 = new short[var3];
         this.field946 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field949[var4] = (short)var1.method2556();
            this.field946[var4] = (short)var1.method2556();
         }
      } else if(var2 == 60) {
         this.field964 = var1.method2556();
      } else if(var2 == 62) {
         this.field952 = true;
      } else if(var2 == 64) {
         this.field967 = false;
      } else if(var2 == 65) {
         this.field968 = var1.method2556();
      } else if(var2 == 66) {
         this.field980 = var1.method2556();
      } else if(var2 == 67) {
         this.field970 = var1.method2556();
      } else if(var2 == 68) {
         this.field965 = var1.method2556();
      } else if(var2 == 69) {
         var1.method2554();
      } else if(var2 == 70) {
         this.field936 = var1.method2557();
      } else if(var2 == 71) {
         this.field972 = var1.method2557();
      } else if(var2 == 72) {
         this.field973 = var1.method2557();
      } else if(var2 == 73) {
         this.field977 = true;
      } else if(var2 == 74) {
         this.field971 = true;
      } else if(var2 == 75) {
         this.field976 = var1.method2554();
      } else if(var2 == 77) {
         this.field978 = var1.method2556();
         if(this.field978 == '\uffff') {
            this.field978 = -1;
         }

         this.field979 = var1.method2556();
         if(this.field979 == '\uffff') {
            this.field979 = -1;
         }

         var3 = var1.method2554();
         this.field947 = new int[var3 + 1];

         for(var4 = 0; var4 <= var3; ++var4) {
            this.field947[var4] = var1.method2556();
            if(this.field947[var4] == '\uffff') {
               this.field947[var4] = -1;
            }
         }
      } else if(var2 == 78) {
         this.field981 = var1.method2556();
         this.field935 = var1.method2554();
      } else if(var2 == 79) {
         this.field982 = var1.method2556();
         this.field983 = var1.method2556();
         this.field935 = var1.method2554();
         var3 = var1.method2554();
         this.field984 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field984[var4] = var1.method2556();
         }
      } else if(var2 == 81) {
         this.field956 = var1.method2554() * 256;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "396031723"
   )
   public final boolean method845() {
      if(null == this.field941) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field941.length; ++var2) {
            var1 &= field951.method3288(this.field941[var2] & '\uffff', 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II[[IIIIS)Lclass105;",
      garbageValue = "-17326"
   )
   public final class105 method847(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.field939 == null) {
         var7 = (long)((this.field943 << 10) + var2);
      } else {
         var7 = (long)(var2 + (var1 << 3) + (this.field943 << 10));
      }

      class105 var9 = (class105)field950.method3797(var7);
      if(null == var9) {
         class100 var10 = this.method858(var1, var2);
         if(var10 == null) {
            return null;
         }

         var9 = var10.method2290(this.field961 + 64, this.field944 + 768, -50, -10, -50);
         field950.method3788(var9, var7);
      }

      if(this.field956 >= 0) {
         var9 = var9.method2371(var3, var4, var5, var6, true, this.field956);
      }

      return var9;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II[[IIIILclass42;IS)Lclass105;",
      garbageValue = "10840"
   )
   public final class105 method848(int var1, int var2, int[][] var3, int var4, int var5, int var6, class42 var7, int var8) {
      long var9;
      if(this.field939 == null) {
         var9 = (long)((this.field943 << 10) + var2);
      } else {
         var9 = (long)(var2 + (var1 << 3) + (this.field943 << 10));
      }

      class105 var11 = (class105)field950.method3797(var9);
      if(var11 == null) {
         class100 var12 = this.method858(var1, var2);
         if(null == var12) {
            return null;
         }

         var11 = var12.method2290(this.field961 + 64, this.field944 + 768, -50, -10, -50);
         field950.method3788(var11, var9);
      }

      if(var7 == null && this.field956 == -1) {
         return var11;
      } else {
         if(null != var7) {
            var11 = var7.method903(var11, var8, var2);
         } else {
            var11 = var11.method2354(true);
         }

         if(this.field956 >= 0) {
            var11 = var11.method2371(var3, var4, var5, var6, false, this.field956);
         }

         return var11;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Lclass40;",
      garbageValue = "-2049775807"
   )
   @Export("getImpostor")
   public final class40 method850() {
      int var1 = -1;
      if(this.field978 != -1) {
         var1 = class130.method2851(this.field978);
      } else if(this.field979 != -1) {
         var1 = class176.field2905[this.field979];
      }

      return var1 >= 0 && var1 < this.field947.length && this.field947[var1] != -1?class150.method3166(this.field947[var1]):null;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1906974064"
   )
   public boolean method851() {
      if(null == this.field947) {
         return this.field981 != -1 || null != this.field984;
      } else {
         for(int var1 = 0; var1 < this.field947.length; ++var1) {
            if(this.field947[var1] != -1) {
               class40 var2 = class150.method3166(this.field947[var1]);
               if(var2.field981 != -1 || null != var2.field984) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)Lclass100;",
      garbageValue = "-1880654253"
   )
   final class100 method858(int var1, int var2) {
      class100 var3 = null;
      boolean var4;
      int var5;
      int var7;
      if(null == this.field939) {
         if(var1 != 10) {
            return null;
         }

         if(this.field941 == null) {
            return null;
         }

         var4 = this.field952;
         if(var1 == 2 && var2 > 3) {
            var4 = !var4;
         }

         var5 = this.field941.length;

         for(int var8 = 0; var8 < var5; ++var8) {
            var7 = this.field941[var8];
            if(var4) {
               var7 += 65536;
            }

            var3 = (class100)field966.method3797((long)var7);
            if(var3 == null) {
               var3 = class100.method2280(field951, var7 & '\uffff', 0);
               if(var3 == null) {
                  return null;
               }

               if(var4) {
                  var3.method2284();
               }

               field966.method3788(var3, (long)var7);
            }

            if(var5 > 1) {
               field942[var8] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new class100(field942, var5);
         }
      } else {
         int var9 = -1;

         for(var5 = 0; var5 < this.field939.length; ++var5) {
            if(this.field939[var5] == var1) {
               var9 = var5;
               break;
            }
         }

         if(var9 == -1) {
            return null;
         }

         var5 = this.field941[var9];
         boolean var11 = this.field952 ^ var2 > 3;
         if(var11) {
            var5 += 65536;
         }

         var3 = (class100)field966.method3797((long)var5);
         if(var3 == null) {
            var3 = class100.method2280(field951, var5 & '\uffff', 0);
            if(null == var3) {
               return null;
            }

            if(var11) {
               var3.method2284();
            }

            field966.method3788(var3, (long)var5);
         }
      }

      if(this.field968 == 128 && this.field980 == 128 && this.field970 == 128) {
         var4 = false;
      } else {
         var4 = true;
      }

      boolean var10;
      if(this.field936 == 0 && this.field972 == 0 && this.field973 == 0) {
         var10 = false;
      } else {
         var10 = true;
      }

      class100 var6 = new class100(var3, var2 == 0 && !var4 && !var10, null == this.field975, null == this.field949, true);
      if(var1 == 4 && var2 > 3) {
         var6.method2311(256);
         var6.method2336(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var6.method2278();
      } else if(var2 == 2) {
         var6.method2305();
      } else if(var2 == 3) {
         var6.method2279();
      }

      if(null != this.field975) {
         for(var7 = 0; var7 < this.field975.length; ++var7) {
            var6.method2341(this.field975[var7], this.field948[var7]);
         }
      }

      if(null != this.field949) {
         for(var7 = 0; var7 < this.field949.length; ++var7) {
            var6.method2300(this.field949[var7], this.field946[var7]);
         }
      }

      if(var4) {
         var6.method2285(this.field968, this.field980, this.field970);
      }

      if(var10) {
         var6.method2336(this.field936, this.field972, this.field973);
      }

      return var6;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "358366778"
   )
   void method864(class119 var1) {
      while(true) {
         int var2 = var1.method2554();
         if(var2 == 0) {
            return;
         }

         this.method843(var1, var2);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II[[IIIIB)Lclass85;",
      garbageValue = "-14"
   )
   public final class85 method869(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(null == this.field939) {
         var7 = (long)(var2 + (this.field943 << 10));
      } else {
         var7 = (long)((this.field943 << 10) + (var1 << 3) + var2);
      }

      Object var9 = (class85)field940.method3797(var7);
      if(var9 == null) {
         class100 var10 = this.method858(var1, var2);
         if(null == var10) {
            return null;
         }

         if(!this.field957) {
            var9 = var10.method2290(this.field961 + 64, 768 + this.field944, -50, -10, -50);
         } else {
            var10.field1709 = (short)(64 + this.field961);
            var10.field1688 = (short)(this.field944 + 768);
            var10.method2286();
            var9 = var10;
         }

         field940.method3788((class204)var9, var7);
      }

      if(this.field957) {
         var9 = ((class100)var9).method2303();
      }

      if(this.field956 >= 0) {
         if(var9 instanceof class105) {
            var9 = ((class105)var9).method2371(var3, var4, var5, var6, true, this.field956);
         } else if(var9 instanceof class100) {
            var9 = ((class100)var9).method2282(var3, var4, var5, var6, true, this.field956);
         }
      }

      return (class85)var9;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-9"
   )
   void method870() {
      if(this.field955 == -1) {
         this.field955 = 0;
         if(null != this.field941 && (this.field939 == null || this.field939[0] == 10)) {
            this.field955 = 1;
         }

         for(int var1 = 0; var1 < 5; ++var1) {
            if(null != this.field963[var1]) {
               this.field955 = 1;
            }
         }
      }

      if(this.field976 == -1) {
         this.field976 = this.field953 != 0?1:0;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1195170729"
   )
   public final boolean method874(int var1) {
      if(this.field939 != null) {
         for(int var4 = 0; var4 < this.field939.length; ++var4) {
            if(this.field939[var4] == var1) {
               return field951.method3288(this.field941[var4] & '\uffff', 0);
            }
         }

         return true;
      } else if(this.field941 == null) {
         return true;
      } else if(var1 != 10) {
         return true;
      } else {
         boolean var2 = true;

         for(int var3 = 0; var3 < this.field941.length; ++var3) {
            var2 &= field951.method3288(this.field941[var3] & '\uffff', 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(Lclass66;B)V",
      garbageValue = "7"
   )
   static final void method876(class66 var0) {
      var0.field1282 = false;
      if(null != var0.field1281) {
         var0.field1281.field1278 = 0;
      }

      for(class66 var1 = var0.vmethod3760(); null != var1; var1 = var0.vmethod3752()) {
         method876(var1);
      }

   }
}
