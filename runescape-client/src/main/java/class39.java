import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
@Implements("NPCComposition")
public class class39 extends class204 {
   @ObfuscatedName("f")
   static class167 field893;
   @ObfuscatedName("y")
   @Export("actions")
   public String[] field894 = new String[5];
   @ObfuscatedName("x")
   static class193 field895 = new class193(64);
   @ObfuscatedName("b")
   @Export("npcModelCache")
   static class193 field896 = new class193(50);
   @ObfuscatedName("c")
   @Export("isMinimapVisible")
   public boolean field897 = true;
   @ObfuscatedName("j")
   @Export("isVisible")
   public boolean field898 = false;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 306019021
   )
   @Export("id")
   public int field899;
   @ObfuscatedName("m")
   @Export("models")
   int[] field900;
   @ObfuscatedName("g")
   int[] field901;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -84310299
   )
   public int field902 = -1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 281961265
   )
   public int field903 = -1;
   @ObfuscatedName("u")
   static class167 field904;
   @ObfuscatedName("d")
   @Export("name")
   public String field905 = "null";
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -661274529
   )
   public int field906 = -1;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 550881985
   )
   public int field907 = 1;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1034153141
   )
   public int field908 = -1;
   @ObfuscatedName("e")
   short[] field909;
   @ObfuscatedName("aj")
   public int[] field910;
   @ObfuscatedName("w")
   short[] field911;
   @ObfuscatedName("v")
   short[] field912;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 953302773
   )
   public int field913 = -1;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1537563789
   )
   public int field914 = 30;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1102127115
   )
   int field916 = 128;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -930338759
   )
   int field917 = 128;
   @ObfuscatedName("t")
   short[] field918;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1865851683
   )
   int field919 = 0;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -27783103
   )
   int field920 = 0;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1663409709
   )
   public int field921 = -1;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 632058851
   )
   public int field922 = 32;
   @ObfuscatedName("nj")
   static class56 field923;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 1734606579
   )
   int field924 = -1;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -118576841
   )
   int field925 = -1;
   @ObfuscatedName("as")
   public boolean field926 = true;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -489535151
   )
   public int field927 = -1;
   @ObfuscatedName("am")
   public boolean field928 = false;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1268763693
   )
   public int field929 = -1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -447223817
   )
   @Export("combatLevel")
   public int field930 = -1;
   @ObfuscatedName("hg")
   @ObfuscatedGetter(
      intValue = -2081164253
   )
   @Export("menuWidth")
   static int field931;
   @ObfuscatedName("av")
   @Export("isClickable")
   public boolean field933 = true;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "-2000966630"
   )
   void method808(class119 var1) {
      while(true) {
         int var2 = var1.method2554();
         if(var2 == 0) {
            return;
         }

         this.method838(var1, var2);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass42;ILclass42;II)Lclass105;",
      garbageValue = "-2043343794"
   )
   public final class105 method811(class42 var1, int var2, class42 var3, int var4) {
      if(this.field910 != null) {
         class39 var12 = this.method813();
         return null == var12?null:var12.method811(var1, var2, var3, var4);
      } else {
         class105 var5 = (class105)field896.method3797((long)this.field899);
         if(null == var5) {
            boolean var6 = false;

            for(int var10 = 0; var10 < this.field900.length; ++var10) {
               if(!field904.method3288(this.field900[var10], 0)) {
                  var6 = true;
               }
            }

            if(var6) {
               return null;
            }

            class100[] var8 = new class100[this.field900.length];

            int var9;
            for(var9 = 0; var9 < this.field900.length; ++var9) {
               var8[var9] = class100.method2280(field904, this.field900[var9], 0);
            }

            class100 var7;
            if(var8.length == 1) {
               var7 = var8[0];
            } else {
               var7 = new class100(var8, var8.length);
            }

            if(this.field909 != null) {
               for(var9 = 0; var9 < this.field909.length; ++var9) {
                  var7.method2341(this.field909[var9], this.field918[var9]);
               }
            }

            if(this.field911 != null) {
               for(var9 = 0; var9 < this.field911.length; ++var9) {
                  var7.method2300(this.field911[var9], this.field912[var9]);
               }
            }

            var5 = var7.method2290(64 + this.field919, 850 + this.field920, -30, -50, -30);
            field896.method3788(var5, (long)this.field899);
         }

         class105 var11;
         if(var1 != null && var3 != null) {
            var11 = var1.method905(var5, var2, var3, var4);
         } else if(null != var1) {
            var11 = var1.method928(var5, var2);
         } else if(null != var3) {
            var11 = var3.method928(var5, var4);
         } else {
            var11 = var5.method2354(true);
         }

         if(this.field916 != 128 || this.field917 != 128) {
            var11.method2353(this.field916, this.field917, this.field916);
         }

         return var11;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)Lclass100;",
      garbageValue = "-63"
   )
   public final class100 method812() {
      if(null != this.field910) {
         class39 var1 = this.method813();
         return null == var1?null:var1.method812();
      } else if(null == this.field901) {
         return null;
      } else {
         boolean var5 = false;

         for(int var2 = 0; var2 < this.field901.length; ++var2) {
            if(!field904.method3288(this.field901[var2], 0)) {
               var5 = true;
            }
         }

         if(var5) {
            return null;
         } else {
            class100[] var6 = new class100[this.field901.length];

            for(int var7 = 0; var7 < this.field901.length; ++var7) {
               var6[var7] = class100.method2280(field904, this.field901[var7], 0);
            }

            class100 var3;
            if(var6.length == 1) {
               var3 = var6[0];
            } else {
               var3 = new class100(var6, var6.length);
            }

            int var4;
            if(this.field909 != null) {
               for(var4 = 0; var4 < this.field909.length; ++var4) {
                  var3.method2341(this.field909[var4], this.field918[var4]);
               }
            }

            if(this.field911 != null) {
               for(var4 = 0; var4 < this.field911.length; ++var4) {
                  var3.method2300(this.field911[var4], this.field912[var4]);
               }
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Lclass39;",
      garbageValue = "-2078919340"
   )
   public final class39 method813() {
      int var1 = -1;
      if(this.field924 != -1) {
         var1 = class130.method2851(this.field924);
      } else if(this.field925 != -1) {
         var1 = class176.field2905[this.field925];
      }

      return var1 >= 0 && var1 < this.field910.length && this.field910[var1] != -1?class172.method3424(this.field910[var1]):null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1765554349"
   )
   public boolean method814() {
      if(null == this.field910) {
         return true;
      } else {
         int var1 = -1;
         if(this.field924 != -1) {
            var1 = class130.method2851(this.field924);
         } else if(this.field925 != -1) {
            var1 = class176.field2905[this.field925];
         }

         return var1 >= 0 && var1 < this.field910.length && this.field910[var1] != -1;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1652970538"
   )
   void method817() {
   }

   @ObfuscatedName("da")
   @ObfuscatedSignature(
      signature = "(Lclass173;B)V",
      garbageValue = "5"
   )
   static void method818(class173 var0) {
      if(client.field491 == var0.field2886) {
         client.field516[var0.field2885] = true;
      }

   }

   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "-126"
   )
   static final String method827(int var0) {
      return var0 < 999999999?Integer.toString(var0):"*";
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Ljava/lang/Class;",
      garbageValue = "0"
   )
   static Class method829(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Class.forName(var0)))))))));
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1027698797"
   )
   public static void method835() {
      class43.field1025.method3796();
      class43.field1026.method3796();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "38"
   )
   public static void method837() {
      if(null != class137.field2118) {
         class137 var0 = class137.field2118;
         synchronized(class137.field2118) {
            class137.field2118 = null;
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "-1273789577"
   )
   void method838(class119 var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2554();
         this.field900 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field900[var4] = var1.method2556();
         }
      } else if(var2 == 2) {
         this.field905 = var1.method2668();
      } else if(var2 == 12) {
         this.field907 = var1.method2554();
      } else if(var2 == 13) {
         this.field902 = var1.method2556();
      } else if(var2 == 14) {
         this.field913 = var1.method2556();
      } else if(var2 == 15) {
         this.field903 = var1.method2556();
      } else if(var2 == 16) {
         this.field929 = var1.method2556();
      } else if(var2 == 17) {
         this.field913 = var1.method2556();
         this.field906 = var1.method2556();
         this.field927 = var1.method2556();
         this.field908 = var1.method2556();
      } else if(var2 >= 30 && var2 < 35) {
         this.field894[var2 - 30] = var1.method2668();
         if(this.field894[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.field894[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.method2554();
         this.field909 = new short[var3];
         this.field918 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field909[var4] = (short)var1.method2556();
            this.field918[var4] = (short)var1.method2556();
         }
      } else if(var2 == 41) {
         var3 = var1.method2554();
         this.field911 = new short[var3];
         this.field912 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field911[var4] = (short)var1.method2556();
            this.field912[var4] = (short)var1.method2556();
         }
      } else if(var2 == 60) {
         var3 = var1.method2554();
         this.field901 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field901[var4] = var1.method2556();
         }
      } else if(var2 == 93) {
         this.field897 = false;
      } else if(var2 == 95) {
         this.field930 = var1.method2556();
      } else if(var2 == 97) {
         this.field916 = var1.method2556();
      } else if(var2 == 98) {
         this.field917 = var1.method2556();
      } else if(var2 == 99) {
         this.field898 = true;
      } else if(var2 == 100) {
         this.field919 = var1.method2538();
      } else if(var2 == 101) {
         this.field920 = var1.method2538() * 5;
      } else if(var2 == 102) {
         this.field921 = var1.method2556();
      } else if(var2 == 103) {
         this.field922 = var1.method2556();
      } else if(var2 == 106) {
         this.field924 = var1.method2556();
         if(this.field924 == '\uffff') {
            this.field924 = -1;
         }

         this.field925 = var1.method2556();
         if(this.field925 == '\uffff') {
            this.field925 = -1;
         }

         var3 = var1.method2554();
         this.field910 = new int[1 + var3];

         for(var4 = 0; var4 <= var3; ++var4) {
            this.field910[var4] = var1.method2556();
            if(this.field910[var4] == '\uffff') {
               this.field910[var4] = -1;
            }
         }
      } else if(var2 == 107) {
         this.field926 = false;
      } else if(var2 == 109) {
         this.field933 = false;
      } else if(var2 == 111) {
         this.field928 = true;
      } else if(var2 == 112) {
         this.field914 = var1.method2554();
      }

   }
}
