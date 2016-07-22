import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
@Implements("NPCComposition")
public class class41 extends class207 {
   @ObfuscatedName("w")
   public static class170 field904;
   @ObfuscatedName("f")
   short[] field905;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1181298309
   )
   public int field906 = 1;
   @ObfuscatedName("o")
   @Export("npcModelCache")
   static class196 field907 = new class196(50);
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -474511121
   )
   @Export("id")
   public int field908;
   @ObfuscatedName("b")
   @Export("isVisible")
   public boolean field909 = false;
   @ObfuscatedName("c")
   @Export("actions")
   public String[] field910 = new String[5];
   @ObfuscatedName("r")
   @Export("models")
   int[] field911;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 93473621
   )
   @Export("combatLevel")
   public int field912 = -1;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1624976697
   )
   public int field913 = -1;
   @ObfuscatedName("z")
   @Export("isMinimapVisible")
   public boolean field914 = true;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1601323777
   )
   public int field915 = -1;
   @ObfuscatedName("x")
   int[] field916;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -120669125
   )
   public int field917 = -1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -203222357
   )
   public int field918 = -1;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 944170371
   )
   public int field919 = -1;
   @ObfuscatedName("l")
   @Export("name")
   public String field920 = "null";
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1356973531
   )
   int field921 = 128;
   @ObfuscatedName("d")
   short[] field922;
   @ObfuscatedName("t")
   short[] field923;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1245438459
   )
   public int field924 = -1;
   @ObfuscatedName("e")
   static class196 field925 = new class196(64);
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -182534849
   )
   int field926 = -1;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1934860557
   )
   int field927 = 128;
   @ObfuscatedName("m")
   public static class170 field928;
   @ObfuscatedName("i")
   short[] field929;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -417503237
   )
   int field930 = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1185026137
   )
   public int field931 = -1;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -841919403
   )
   public int field932 = -1;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 229281395
   )
   public int field933 = 32;
   @ObfuscatedName("ab")
   public int[] field934;
   @ObfuscatedName("ax")
   public boolean field935 = true;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 263145315
   )
   int field936 = -1;
   @ObfuscatedName("ad")
   @Export("isClickable")
   public boolean field938 = true;
   @ObfuscatedName("av")
   public boolean field939 = false;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 135234163
   )
   int field940 = 0;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "354550434"
   )
   void method792() {
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass122;I)V",
      garbageValue = "2029974109"
   )
   void method793(class122 var1) {
      while(true) {
         int var2 = var1.method2556();
         if(var2 == 0) {
            return;
         }

         this.method794(var1, var2);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass122;II)V",
      garbageValue = "2018187969"
   )
   void method794(class122 var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2556();
         this.field911 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field911[var4] = var1.method2706();
         }
      } else if(var2 == 2) {
         this.field920 = var1.method2580();
      } else if(var2 == 12) {
         this.field906 = var1.method2556();
      } else if(var2 == 13) {
         this.field913 = var1.method2706();
      } else if(var2 == 14) {
         this.field931 = var1.method2706();
      } else if(var2 == 15) {
         this.field924 = var1.method2706();
      } else if(var2 == 16) {
         this.field915 = var1.method2706();
      } else if(var2 == 17) {
         this.field931 = var1.method2706();
         this.field917 = var1.method2706();
         this.field918 = var1.method2706();
         this.field919 = var1.method2706();
      } else if(var2 >= 30 && var2 < 35) {
         this.field910[var2 - 30] = var1.method2580();
         if(this.field910[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.field910[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.method2556();
         this.field905 = new short[var3];
         this.field929 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field905[var4] = (short)var1.method2706();
            this.field929[var4] = (short)var1.method2706();
         }
      } else if(var2 == 41) {
         var3 = var1.method2556();
         this.field922 = new short[var3];
         this.field923 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field922[var4] = (short)var1.method2706();
            this.field923[var4] = (short)var1.method2706();
         }
      } else if(var2 == 60) {
         var3 = var1.method2556();
         this.field916 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field916[var4] = var1.method2706();
         }
      } else if(var2 == 93) {
         this.field914 = false;
      } else if(var2 == 95) {
         this.field912 = var1.method2706();
      } else if(var2 == 97) {
         this.field927 = var1.method2706();
      } else if(var2 == 98) {
         this.field921 = var1.method2706();
      } else if(var2 == 99) {
         this.field909 = true;
      } else if(var2 == 100) {
         this.field930 = var1.method2573();
      } else if(var2 == 101) {
         this.field940 = var1.method2573() * 5;
      } else if(var2 == 102) {
         this.field932 = var1.method2706();
      } else if(var2 == 103) {
         this.field933 = var1.method2706();
      } else if(var2 == 106) {
         this.field926 = var1.method2706();
         if(this.field926 == '\uffff') {
            this.field926 = -1;
         }

         this.field936 = var1.method2706();
         if(this.field936 == '\uffff') {
            this.field936 = -1;
         }

         var3 = var1.method2556();
         this.field934 = new int[1 + var3];

         for(var4 = 0; var4 <= var3; ++var4) {
            this.field934[var4] = var1.method2706();
            if(this.field934[var4] == '\uffff') {
               this.field934[var4] = -1;
            }
         }
      } else if(var2 == 107) {
         this.field935 = false;
      } else if(var2 == 109) {
         this.field938 = false;
      } else if(var2 == 111) {
         this.field939 = true;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass44;ILclass44;II)Lclass108;",
      garbageValue = "-934996209"
   )
   public final class108 method795(class44 var1, int var2, class44 var3, int var4) {
      if(this.field934 != null) {
         class41 var12 = this.method797();
         return var12 == null?null:var12.method795(var1, var2, var3, var4);
      } else {
         class108 var5 = (class108)field907.method3817((long)this.field908);
         if(var5 == null) {
            boolean var6 = false;

            for(int var7 = 0; var7 < this.field911.length; ++var7) {
               if(!field904.method3359(this.field911[var7], 0)) {
                  var6 = true;
               }
            }

            if(var6) {
               return null;
            }

            class103[] var8 = new class103[this.field911.length];

            int var9;
            for(var9 = 0; var9 < this.field911.length; ++var9) {
               var8[var9] = class103.method2323(field904, this.field911[var9], 0);
            }

            class103 var10;
            if(var8.length == 1) {
               var10 = var8[0];
            } else {
               var10 = new class103(var8, var8.length);
            }

            if(null != this.field905) {
               for(var9 = 0; var9 < this.field905.length; ++var9) {
                  var10.method2317(this.field905[var9], this.field929[var9]);
               }
            }

            if(null != this.field922) {
               for(var9 = 0; var9 < this.field922.length; ++var9) {
                  var10.method2298(this.field922[var9], this.field923[var9]);
               }
            }

            var5 = var10.method2305(64 + this.field930, 850 + this.field940, -30, -50, -30);
            field907.method3823(var5, (long)this.field908);
         }

         class108 var11;
         if(null != var1 && null != var3) {
            var11 = var1.method906(var5, var2, var3, var4);
         } else if(var1 != null) {
            var11 = var1.method910(var5, var2);
         } else if(var3 != null) {
            var11 = var3.method910(var5, var4);
         } else {
            var11 = var5.method2368(true);
         }

         if(this.field927 != 128 || this.field921 != 128) {
            var11.method2395(this.field927, this.field921, this.field927);
         }

         return var11;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Lclass41;",
      garbageValue = "2112842727"
   )
   public final class41 method797() {
      int var1 = -1;
      if(this.field926 != -1) {
         var1 = class12.method154(this.field926);
      } else if(this.field936 != -1) {
         var1 = class179.field2949[this.field936];
      }

      return var1 >= 0 && var1 < this.field934.length && this.field934[var1] != -1?class1.method7(this.field934[var1]):null;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1065252411"
   )
   public boolean method798() {
      if(this.field934 == null) {
         return true;
      } else {
         int var1 = -1;
         if(this.field926 != -1) {
            var1 = class12.method154(this.field926);
         } else if(this.field936 != -1) {
            var1 = class179.field2949[this.field936];
         }

         return var1 >= 0 && var1 < this.field934.length && this.field934[var1] != -1;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Lclass103;",
      garbageValue = "541753542"
   )
   public final class103 method814() {
      if(this.field934 != null) {
         class41 var1 = this.method797();
         return null == var1?null:var1.method814();
      } else if(this.field916 == null) {
         return null;
      } else {
         boolean var7 = false;

         for(int var5 = 0; var5 < this.field916.length; ++var5) {
            if(!field904.method3359(this.field916[var5], 0)) {
               var7 = true;
            }
         }

         if(var7) {
            return null;
         } else {
            class103[] var2 = new class103[this.field916.length];

            for(int var3 = 0; var3 < this.field916.length; ++var3) {
               var2[var3] = class103.method2323(field904, this.field916[var3], 0);
            }

            class103 var6;
            if(var2.length == 1) {
               var6 = var2[0];
            } else {
               var6 = new class103(var2, var2.length);
            }

            int var4;
            if(this.field905 != null) {
               for(var4 = 0; var4 < this.field905.length; ++var4) {
                  var6.method2317(this.field905[var4], this.field929[var4]);
               }
            }

            if(this.field922 != null) {
               for(var4 = 0; var4 < this.field922.length; ++var4) {
                  var6.method2298(this.field922[var4], this.field923[var4]);
               }
            }

            return var6;
         }
      }
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "2013060923"
   )
   static final void method820(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = class15.method163(var0, var1, class51.field1119) - var2;
         var0 -= class9.field144;
         var3 -= class24.field622;
         var1 -= class59.field1256;
         int var4 = class94.field1660[class31.field717];
         int var5 = class94.field1661[class31.field717];
         int var6 = class94.field1660[class10.field155];
         int var7 = class94.field1661[class10.field155];
         int var8 = var1 * var6 + var7 * var0 >> 16;
         var1 = var7 * var1 - var0 * var6 >> 16;
         var0 = var8;
         var8 = var5 * var3 - var1 * var4 >> 16;
         var1 = var1 * var5 + var4 * var3 >> 16;
         if(var1 >= 50) {
            client.field378 = client.field536 * var0 / var1 + client.field534 / 2;
            client.field397 = client.field364 / 2 + client.field536 * var8 / var1;
         } else {
            client.field378 = -1;
            client.field397 = -1;
         }

      } else {
         client.field378 = -1;
         client.field397 = -1;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-1327223728"
   )
   public static boolean method826(char var0) {
      if(var0 > 0 && var0 < 128 || var0 >= 160 && var0 <= 255) {
         return true;
      } else {
         if(var0 != 0) {
            char[] var1 = class168.field2720;

            for(int var2 = 0; var2 < var1.length; ++var2) {
               char var3 = var1[var2];
               if(var0 == var3) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "104"
   )
   public static void method827() {
      class214.field3180 = new class205();
   }
}
