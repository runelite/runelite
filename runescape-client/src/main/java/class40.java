import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
@Implements("ObjectComposition")
public class class40 extends class204 {
   @ObfuscatedName("du")
   static int[] field904;
   @ObfuscatedName("h")
   public static class167 field905;
   @ObfuscatedName("m")
   public static class167 field906;
   @ObfuscatedName("x")
   public static class193 field908 = new class193(500);
   @ObfuscatedName("e")
   public static class193 field909 = new class193(30);
   @ObfuscatedName("i")
   public static class193 field910 = new class193(30);
   @ObfuscatedName("j")
   public static boolean field911 = false;
   @ObfuscatedName("c")
   static class100[] field912 = new class100[4];
   @ObfuscatedName("aj")
   boolean field913 = false;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -166601315
   )
   public int field914 = 0;
   @ObfuscatedName("aa")
   public boolean field915 = false;
   @ObfuscatedName("a")
   short[] field916;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1357998781
   )
   public int field917 = -1;
   @ObfuscatedName("p")
   short[] field918;
   @ObfuscatedName("q")
   short[] field919;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 925756969
   )
   public int field920 = 1;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -348908079
   )
   public int field921 = 1;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 809742435
   )
   public int field922 = 2;
   @ObfuscatedName("w")
   public boolean field923 = true;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1782720681
   )
   public int field924;
   @ObfuscatedName("r")
   @Export("name")
   public String field925 = "null";
   @ObfuscatedName("ab")
   @Export("actions")
   public String[] field926 = new String[5];
   @ObfuscatedName("o")
   public boolean field927 = false;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1153733285
   )
   public int field928 = -1;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1788229255
   )
   public int field929 = 16;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1640089369
   )
   int field930 = 0;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 1202569249
   )
   int field931 = 0;
   @ObfuscatedName("z")
   public static class193 field932 = new class193(64);
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 284638115
   )
   public int field933 = -1;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 2052757855
   )
   public int field934 = -1;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -265417395
   )
   int field935 = 0;
   @ObfuscatedName("ay")
   public boolean field936 = true;
   @ObfuscatedName("u")
   int[] field937;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 1937058021
   )
   int field938 = -1;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 1599090449
   )
   int field939 = 128;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 52189525
   )
   int field940 = 0;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1454670629
   )
   int field941 = 0;
   @ObfuscatedName("d")
   short[] field942;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 569847625
   )
   int field943 = 128;
   @ObfuscatedName("ah")
   boolean field944 = false;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 954939703
   )
   public int field945 = -1;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 51302917
   )
   int field946 = -1;
   @ObfuscatedName("l")
   int[] field947;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1393061159
   )
   int field948 = 128;
   @ObfuscatedName("k")
   boolean field949 = false;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -463857463
   )
   public int field950 = 0;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -547338685
   )
   public int field951 = -1;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 780958949
   )
   public int field952 = 0;
   @ObfuscatedName("al")
   public int[] field953;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1187422447
   )
   int field955 = -1;
   @ObfuscatedName("ae")
   public int[] field956;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lclass136;Ljava/awt/Component;III)Lclass56;",
      garbageValue = "-1766006928"
   )
   public static final class56 method785(class136 var0, Component var1, int var2, int var3) {
      if(var2 >= 0 && var2 < 2) {
         if(var3 < 256) {
            var3 = 256;
         }

         try {
            class69 var7 = new class69();
            var7.field1161 = new int[(class113.field1944?2:1) * 256];
            var7.field1166 = var3;
            var7.vmethod1521(var1);
            var7.field1169 = (var3 & -1024) + 1024;
            if(var7.field1169 > 16384) {
               var7.field1169 = 16384;
            }

            var7.vmethod1503(var7.field1169);
            if(class165.field2653 > 0 && class124.field2011 == null) {
               class124.field2011 = new class72();
               class124.field2011.field1330 = var0;
               var0.method2851(class124.field2011, class165.field2653);
            }

            if(null != class124.field2011) {
               if(class124.field2011.field1331[var2] != null) {
                  throw new IllegalArgumentException();
               }

               class124.field2011.field1331[var2] = var7;
            }

            return var7;
         } catch (Throwable var6) {
            try {
               class54 var4 = new class54(var0, var2);
               var4.field1161 = new int[(class113.field1944?2:1) * 256];
               var4.field1166 = var3;
               var4.vmethod1521(var1);
               var4.field1169 = 16384;
               var4.vmethod1503(var4.field1169);
               if(class165.field2653 > 0 && class124.field2011 == null) {
                  class124.field2011 = new class72();
                  class124.field2011.field1330 = var0;
                  var0.method2851(class124.field2011, class165.field2653);
               }

               if(class124.field2011 != null) {
                  if(null != class124.field2011.field1331[var2]) {
                     throw new IllegalArgumentException();
                  }

                  class124.field2011.field1331[var2] = var4;
               }

               return var4;
            } catch (Throwable var5) {
               return new class56();
            }
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1330650914"
   )
   public final boolean method787() {
      if(this.field947 == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field947.length; ++var2) {
            var1 &= field906.method3294(this.field947[var2] & '\uffff', 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lclass119;IB)V",
      garbageValue = "-101"
   )
   void method788(class119 var1, int var2) {
      int var3;
      int var4;
      if(1 == var2) {
         var3 = var1.method2500();
         if(var3 > 0) {
            if(null != this.field947 && !field911) {
               var1.field1971 += 3 * var3;
            } else {
               this.field937 = new int[var3];
               this.field947 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field947[var4] = var1.method2502();
                  this.field937[var4] = var1.method2500();
               }
            }
         }
      } else if(var2 == 2) {
         this.field925 = var1.method2508();
      } else if(var2 == 5) {
         var3 = var1.method2500();
         if(var3 > 0) {
            if(this.field947 != null && !field911) {
               var1.field1971 += 2 * var3;
            } else {
               this.field937 = null;
               this.field947 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field947[var4] = var1.method2502();
               }
            }
         }
      } else if(14 == var2) {
         this.field920 = var1.method2500();
      } else if(15 == var2) {
         this.field921 = var1.method2500();
      } else if(var2 == 17) {
         this.field922 = 0;
         this.field923 = false;
      } else if(var2 == 18) {
         this.field923 = false;
      } else if(19 == var2) {
         this.field917 = var1.method2500();
      } else if(21 == var2) {
         this.field946 = 0;
      } else if(var2 == 22) {
         this.field949 = true;
      } else if(23 == var2) {
         this.field927 = true;
      } else if(var2 == 24) {
         this.field928 = var1.method2502();
         if('\uffff' == this.field928) {
            this.field928 = -1;
         }
      } else if(27 == var2) {
         this.field922 = 1;
      } else if(28 == var2) {
         this.field929 = var1.method2500();
      } else if(var2 == 29) {
         this.field930 = var1.method2670();
      } else if(39 == var2) {
         this.field931 = var1.method2670() * 25;
      } else if(var2 >= 30 && var2 < 35) {
         this.field926[var2 - 30] = var1.method2508();
         if(this.field926[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.field926[var2 - 30] = null;
         }
      } else if(40 == var2) {
         var3 = var1.method2500();
         this.field916 = new short[var3];
         this.field942 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field916[var4] = (short)var1.method2502();
            this.field942[var4] = (short)var1.method2502();
         }
      } else if(41 == var2) {
         var3 = var1.method2500();
         this.field918 = new short[var3];
         this.field919 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field918[var4] = (short)var1.method2502();
            this.field919[var4] = (short)var1.method2502();
         }
      } else if(var2 == 60) {
         this.field933 = var1.method2502();
      } else if(var2 == 62) {
         this.field913 = true;
      } else if(var2 == 64) {
         this.field936 = false;
      } else if(65 == var2) {
         this.field948 = var1.method2502();
      } else if(var2 == 66) {
         this.field943 = var1.method2502();
      } else if(var2 == 67) {
         this.field939 = var1.method2502();
      } else if(var2 == 68) {
         this.field934 = var1.method2502();
      } else if(69 == var2) {
         var1.method2500();
      } else if(var2 == 70) {
         this.field940 = var1.method2501();
      } else if(var2 == 71) {
         this.field941 = var1.method2501();
      } else if(72 == var2) {
         this.field935 = var1.method2501();
      } else if(var2 == 73) {
         this.field915 = true;
      } else if(var2 == 74) {
         this.field944 = true;
      } else if(var2 == 75) {
         this.field945 = var1.method2500();
      } else if(var2 == 77) {
         this.field938 = var1.method2502();
         if('\uffff' == this.field938) {
            this.field938 = -1;
         }

         this.field955 = var1.method2502();
         if('\uffff' == this.field955) {
            this.field955 = -1;
         }

         var3 = var1.method2500();
         this.field956 = new int[1 + var3];

         for(var4 = 0; var4 <= var3; ++var4) {
            this.field956[var4] = var1.method2502();
            if(this.field956[var4] == '\uffff') {
               this.field956[var4] = -1;
            }
         }
      } else if(var2 == 78) {
         this.field951 = var1.method2502();
         this.field950 = var1.method2500();
      } else if(var2 == 79) {
         this.field914 = var1.method2502();
         this.field952 = var1.method2502();
         this.field950 = var1.method2500();
         var3 = var1.method2500();
         this.field953 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field953[var4] = var1.method2502();
         }
      } else if(var2 == 81) {
         this.field946 = var1.method2500() * 256;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "122"
   )
   public final boolean method789(int var1) {
      if(this.field937 != null) {
         for(int var4 = 0; var4 < this.field937.length; ++var4) {
            if(var1 == this.field937[var4]) {
               return field906.method3294(this.field947[var4] & '\uffff', 0);
            }
         }

         return true;
      } else if(this.field947 == null) {
         return true;
      } else if(10 != var1) {
         return true;
      } else {
         boolean var2 = true;

         for(int var3 = 0; var3 < this.field947.length; ++var3) {
            var2 &= field906.method3294(this.field947[var3] & '\uffff', 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1452536174"
   )
   void method790() {
      if(-1 == this.field917) {
         this.field917 = 0;
         if(null != this.field947 && (this.field937 == null || this.field937[0] == 10)) {
            this.field917 = 1;
         }

         for(int var1 = 0; var1 < 5; ++var1) {
            if(this.field926[var1] != null) {
               this.field917 = 1;
            }
         }
      }

      if(this.field945 == -1) {
         this.field945 = this.field922 != 0?1:0;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)Lclass85;",
      garbageValue = "1513919723"
   )
   public final class85 method791(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.field937 == null) {
         var7 = (long)(var2 + (this.field924 << 10));
      } else {
         var7 = (long)((var1 << 3) + (this.field924 << 10) + var2);
      }

      Object var9 = (class85)field909.method3704(var7);
      if(var9 == null) {
         class100 var10 = this.method793(var1, var2);
         if(null == var10) {
            return null;
         }

         if(!this.field949) {
            var9 = var10.method2218(this.field930 + 64, 768 + this.field931, -50, -10, -50);
         } else {
            var10.field1702 = (short)(64 + this.field930);
            var10.field1703 = (short)(768 + this.field931);
            var10.method2215();
            var9 = var10;
         }

         field909.method3706((class204)var9, var7);
      }

      if(this.field949) {
         var9 = ((class100)var9).method2203();
      }

      if(this.field946 >= 0) {
         if(var9 instanceof class105) {
            var9 = ((class105)var9).method2346(var3, var4, var5, var6, true, this.field946);
         } else if(var9 instanceof class100) {
            var9 = ((class100)var9).method2212(var3, var4, var5, var6, true, this.field946);
         }
      }

      return (class85)var9;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II[[IIIILclass42;II)Lclass105;",
      garbageValue = "600953216"
   )
   public final class105 method792(int var1, int var2, int[][] var3, int var4, int var5, int var6, class42 var7, int var8) {
      long var9;
      if(null == this.field937) {
         var9 = (long)((this.field924 << 10) + var2);
      } else {
         var9 = (long)((this.field924 << 10) + (var1 << 3) + var2);
      }

      class105 var11 = (class105)field910.method3704(var9);
      if(var11 == null) {
         class100 var12 = this.method793(var1, var2);
         if(var12 == null) {
            return null;
         }

         var11 = var12.method2218(64 + this.field930, this.field931 + 768, -50, -10, -50);
         field910.method3706(var11, var9);
      }

      if(null == var7 && this.field946 == -1) {
         return var11;
      } else {
         if(null != var7) {
            var11 = var7.method854(var11, var8, var2);
         } else {
            var11 = var11.method2286(true);
         }

         if(this.field946 >= 0) {
            var11 = var11.method2346(var3, var4, var5, var6, false, this.field946);
         }

         return var11;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIB)Lclass100;",
      garbageValue = "35"
   )
   final class100 method793(int var1, int var2) {
      class100 var3 = null;
      boolean var4;
      int var5;
      int var7;
      if(null == this.field937) {
         if(10 != var1) {
            return null;
         }

         if(null == this.field947) {
            return null;
         }

         var4 = this.field913;
         if(2 == var1 && var2 > 3) {
            var4 = !var4;
         }

         var5 = this.field947.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            var7 = this.field947[var6];
            if(var4) {
               var7 += 65536;
            }

            var3 = (class100)field908.method3704((long)var7);
            if(null == var3) {
               var3 = class100.method2198(field906, var7 & '\uffff', 0);
               if(var3 == null) {
                  return null;
               }

               if(var4) {
                  var3.method2213();
               }

               field908.method3706(var3, (long)var7);
            }

            if(var5 > 1) {
               field912[var6] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new class100(field912, var5);
         }
      } else {
         int var8 = -1;

         for(var5 = 0; var5 < this.field937.length; ++var5) {
            if(this.field937[var5] == var1) {
               var8 = var5;
               break;
            }
         }

         if(-1 == var8) {
            return null;
         }

         var5 = this.field947[var8];
         boolean var9 = this.field913 ^ var2 > 3;
         if(var9) {
            var5 += 65536;
         }

         var3 = (class100)field908.method3704((long)var5);
         if(var3 == null) {
            var3 = class100.method2198(field906, var5 & '\uffff', 0);
            if(null == var3) {
               return null;
            }

            if(var9) {
               var3.method2213();
            }

            field908.method3706(var3, (long)var5);
         }
      }

      if(this.field948 == 128 && 128 == this.field943 && this.field939 == 128) {
         var4 = false;
      } else {
         var4 = true;
      }

      boolean var10;
      if(this.field940 == 0 && this.field941 == 0 && 0 == this.field935) {
         var10 = false;
      } else {
         var10 = true;
      }

      class100 var11 = new class100(var3, 0 == var2 && !var4 && !var10, null == this.field916, this.field918 == null, true);
      if(4 == var1 && var2 > 3) {
         var11.method2209(256);
         var11.method2210(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var11.method2236();
      } else if(var2 == 2) {
         var11.method2207();
      } else if(3 == var2) {
         var11.method2208();
      }

      if(null != this.field916) {
         for(var7 = 0; var7 < this.field916.length; ++var7) {
            var11.method2202(this.field916[var7], this.field942[var7]);
         }
      }

      if(null != this.field918) {
         for(var7 = 0; var7 < this.field918.length; ++var7) {
            var11.method2214(this.field918[var7], this.field919[var7]);
         }
      }

      if(var4) {
         var11.method2200(this.field948, this.field943, this.field939);
      }

      if(var10) {
         var11.method2210(this.field940, this.field941, this.field935);
      }

      return var11;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "2136433717"
   )
   public static int method794(int var0, int var1) {
      int var2;
      if(var1 > var0) {
         var2 = var0;
         var0 = var1;
         var1 = var2;
      }

      while(var1 != 0) {
         var2 = var0 % var1;
         var0 = var1;
         var1 = var2;
      }

      return var0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1990221500"
   )
   public boolean method795() {
      if(this.field956 == null) {
         return -1 != this.field951 || this.field953 != null;
      } else {
         for(int var1 = 0; var1 < this.field956.length; ++var1) {
            if(-1 != this.field956[var1]) {
               class40 var2 = class85.method1903(this.field956[var1]);
               if(var2.field951 != -1 || var2.field953 != null) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II[[IIIIS)Lclass105;",
      garbageValue = "-13973"
   )
   public final class105 method801(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.field937 == null) {
         var7 = (long)(var2 + (this.field924 << 10));
      } else {
         var7 = (long)(var2 + (var1 << 3) + (this.field924 << 10));
      }

      class105 var9 = (class105)field910.method3704(var7);
      if(var9 == null) {
         class100 var10 = this.method793(var1, var2);
         if(var10 == null) {
            return null;
         }

         var9 = var10.method2218(64 + this.field930, 768 + this.field931, -50, -10, -50);
         field910.method3706(var9, var7);
      }

      if(this.field946 >= 0) {
         var9 = var9.method2346(var3, var4, var5, var6, true, this.field946);
      }

      return var9;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Lclass40;",
      garbageValue = "2057354343"
   )
   public final class40 method804() {
      int var1 = -1;
      if(-1 != this.field938) {
         var1 = class59.method1263(this.field938);
      } else if(this.field955 != -1) {
         var1 = class176.field2900[this.field955];
      }

      return var1 >= 0 && var1 < this.field956.length && -1 != this.field956[var1]?class85.method1903(this.field956[var1]):null;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1227330140"
   )
   public static void method824(int var0) {
      if(0 != class183.field2959) {
         class183.field2957 = var0;
      } else {
         class183.field2958.method3559(var0);
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "-956535619"
   )
   void method825(class119 var1) {
      while(true) {
         int var2 = var1.method2500();
         if(0 == var2) {
            return;
         }

         this.method788(var1, var2);
      }
   }
}
