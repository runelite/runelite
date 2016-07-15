import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
@Implements("NPCComposition")
public class class41 extends class207 {
   @ObfuscatedName("h")
   @Export("npcModelCache")
   static class196 field918 = new class196(50);
   @ObfuscatedName("l")
   static class170 field919;
   @ObfuscatedName("c")
   static class196 field920 = new class196(64);
   @ObfuscatedName("s")
   @Export("isVisible")
   public boolean field921 = false;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1894299433
   )
   @Export("id")
   public int field922;
   @ObfuscatedName("t")
   short[] field923;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 2065989829
   )
   public int field924 = 1;
   @ObfuscatedName("u")
   @Export("models")
   int[] field925;
   @ObfuscatedName("o")
   int[] field926;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1717113925
   )
   public int field927 = 30;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 868326927
   )
   public int field928 = -1;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 877513281
   )
   public int field929 = -1;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 804860891
   )
   int field930 = -1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 902390309
   )
   public int field931 = -1;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -900086955
   )
   public int field932 = -1;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1134815567
   )
   public int field933 = -1;
   @ObfuscatedName("f")
   short[] field934;
   @ObfuscatedName("aw")
   public boolean field935 = false;
   @ObfuscatedName("z")
   short[] field936;
   @ObfuscatedName("y")
   short[] field937;
   @ObfuscatedName("m")
   @Export("actions")
   public String[] field938 = new String[5];
   @ObfuscatedName("v")
   @Export("isMinimapVisible")
   public boolean field939 = true;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -371109569
   )
   @Export("combatLevel")
   public int field940 = -1;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1154936607
   )
   int field941 = 128;
   @ObfuscatedName("a")
   @Export("name")
   public String field942 = "null";
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1062368537
   )
   int field943 = 128;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 764103871
   )
   int field944 = 0;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -330689623
   )
   int field945 = 0;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 2062931163
   )
   public int field946 = -1;
   @ObfuscatedName("ap")
   public boolean field947 = true;
   @ObfuscatedName("ao")
   public int[] field948;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 881412891
   )
   public int field950 = -1;
   @ObfuscatedName("e")
   static class170 field951;
   @ObfuscatedName("an")
   @Export("isClickable")
   public boolean field952 = true;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 666490843
   )
   public int field953 = -1;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1837160059
   )
   public int field954 = 32;
   @ObfuscatedName("fd")
   @ObfuscatedGetter(
      intValue = 823982077
   )
   @Export("cameraZ")
   static int field955;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1295601621
   )
   int field956 = -1;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "329365703"
   )
   void method806() {
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass122;II)V",
      garbageValue = "-94903670"
   )
   void method807(class122 var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2610();
         this.field925 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field925[var4] = var1.method2612();
         }
      } else if(var2 == 2) {
         this.field942 = var1.method2617();
      } else if(var2 == 12) {
         this.field924 = var1.method2610();
      } else if(var2 == 13) {
         this.field950 = var1.method2612();
      } else if(var2 == 14) {
         this.field953 = var1.method2612();
      } else if(var2 == 15) {
         this.field928 = var1.method2612();
      } else if(var2 == 16) {
         this.field929 = var1.method2612();
      } else if(var2 == 17) {
         this.field953 = var1.method2612();
         this.field931 = var1.method2612();
         this.field932 = var1.method2612();
         this.field933 = var1.method2612();
      } else if(var2 >= 30 && var2 < 35) {
         this.field938[var2 - 30] = var1.method2617();
         if(this.field938[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.field938[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.method2610();
         this.field934 = new short[var3];
         this.field923 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field934[var4] = (short)var1.method2612();
            this.field923[var4] = (short)var1.method2612();
         }
      } else if(var2 == 41) {
         var3 = var1.method2610();
         this.field936 = new short[var3];
         this.field937 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field936[var4] = (short)var1.method2612();
            this.field937[var4] = (short)var1.method2612();
         }
      } else if(var2 == 60) {
         var3 = var1.method2610();
         this.field926 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field926[var4] = var1.method2612();
         }
      } else if(var2 == 93) {
         this.field939 = false;
      } else if(var2 == 95) {
         this.field940 = var1.method2612();
      } else if(var2 == 97) {
         this.field941 = var1.method2612();
      } else if(var2 == 98) {
         this.field943 = var1.method2612();
      } else if(var2 == 99) {
         this.field921 = true;
      } else if(var2 == 100) {
         this.field944 = var1.method2611();
      } else if(var2 == 101) {
         this.field945 = var1.method2611() * 5;
      } else if(var2 == 102) {
         this.field946 = var1.method2612();
      } else if(var2 == 103) {
         this.field954 = var1.method2612();
      } else if(var2 == 106) {
         this.field956 = var1.method2612();
         if(this.field956 == '\uffff') {
            this.field956 = -1;
         }

         this.field930 = var1.method2612();
         if(this.field930 == '\uffff') {
            this.field930 = -1;
         }

         var3 = var1.method2610();
         this.field948 = new int[1 + var3];

         for(var4 = 0; var4 <= var3; ++var4) {
            this.field948[var4] = var1.method2612();
            if(this.field948[var4] == '\uffff') {
               this.field948[var4] = -1;
            }
         }
      } else if(var2 == 107) {
         this.field947 = false;
      } else if(var2 == 109) {
         this.field952 = false;
      } else if(var2 == 111) {
         this.field935 = true;
      } else if(var2 == 112) {
         this.field927 = var1.method2610();
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass122;B)V",
      garbageValue = "25"
   )
   void method808(class122 var1) {
      while(true) {
         int var2 = var1.method2610();
         if(var2 == 0) {
            return;
         }

         this.method807(var1, var2);
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Lclass103;",
      garbageValue = "1285777780"
   )
   public final class103 method811() {
      if(null != this.field948) {
         class41 var1 = this.method824();
         return null == var1?null:var1.method811();
      } else if(this.field926 == null) {
         return null;
      } else {
         boolean var5 = false;

         for(int var2 = 0; var2 < this.field926.length; ++var2) {
            if(!field919.method3344(this.field926[var2], 0)) {
               var5 = true;
            }
         }

         if(var5) {
            return null;
         } else {
            class103[] var6 = new class103[this.field926.length];

            for(int var7 = 0; var7 < this.field926.length; ++var7) {
               var6[var7] = class103.method2311(field919, this.field926[var7], 0);
            }

            class103 var3;
            if(var6.length == 1) {
               var3 = var6[0];
            } else {
               var3 = new class103(var6, var6.length);
            }

            int var4;
            if(this.field934 != null) {
               for(var4 = 0; var4 < this.field934.length; ++var4) {
                  var3.method2350(this.field934[var4], this.field923[var4]);
               }
            }

            if(this.field936 != null) {
               for(var4 = 0; var4 < this.field936.length; ++var4) {
                  var3.method2301(this.field936[var4], this.field937[var4]);
               }
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1101382811"
   )
   public boolean method813() {
      if(this.field948 == null) {
         return true;
      } else {
         int var1 = -1;
         if(this.field956 != -1) {
            var1 = class174.method3475(this.field956);
         } else if(this.field930 != -1) {
            var1 = class179.field2944[this.field930];
         }

         return var1 >= 0 && var1 < this.field948.length && this.field948[var1] != -1;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Lclass41;",
      garbageValue = "-211072722"
   )
   public final class41 method824() {
      int var1 = -1;
      if(this.field956 != -1) {
         var1 = class174.method3475(this.field956);
      } else if(this.field930 != -1) {
         var1 = class179.field2944[this.field930];
      }

      return var1 >= 0 && var1 < this.field948.length && this.field948[var1] != -1?class59.method1282(this.field948[var1]):null;
   }

   @ObfuscatedName("eh")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-90"
   )
   static final void method826(String var0) {
      if(var0 != null) {
         String var1 = class17.method167(var0, client.field296);
         if(null != var1) {
            for(int var2 = 0; var2 < client.field511; ++var2) {
               class17 var3 = client.field564[var2];
               String var4 = var3.field253;
               String var5 = class17.method167(var4, client.field296);
               if(class48.method1048(var0, var1, var4, var5)) {
                  --client.field511;

                  for(int var6 = var2; var6 < client.field511; ++var6) {
                     client.field564[var6] = client.field564[var6 + 1];
                  }

                  client.field515 = client.field506 * -522622283;
                  client.field336.method2854(42);
                  client.field336.method2795(class29.method650(var0));
                  client.field336.method2601(var0);
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass44;ILclass44;II)Lclass108;",
      garbageValue = "-716562921"
   )
   public final class108 method828(class44 var1, int var2, class44 var3, int var4) {
      if(null != this.field948) {
         class41 var12 = this.method824();
         return var12 == null?null:var12.method828(var1, var2, var3, var4);
      } else {
         class108 var5 = (class108)field918.method3834((long)this.field922);
         if(var5 == null) {
            boolean var6 = false;

            for(int var10 = 0; var10 < this.field925.length; ++var10) {
               if(!field919.method3344(this.field925[var10], 0)) {
                  var6 = true;
               }
            }

            if(var6) {
               return null;
            }

            class103[] var8 = new class103[this.field925.length];

            int var9;
            for(var9 = 0; var9 < this.field925.length; ++var9) {
               var8[var9] = class103.method2311(field919, this.field925[var9], 0);
            }

            class103 var7;
            if(var8.length == 1) {
               var7 = var8[0];
            } else {
               var7 = new class103(var8, var8.length);
            }

            if(this.field934 != null) {
               for(var9 = 0; var9 < this.field934.length; ++var9) {
                  var7.method2350(this.field934[var9], this.field923[var9]);
               }
            }

            if(this.field936 != null) {
               for(var9 = 0; var9 < this.field936.length; ++var9) {
                  var7.method2301(this.field936[var9], this.field937[var9]);
               }
            }

            var5 = var7.method2308(this.field944 + 64, 850 + this.field945, -30, -50, -30);
            field918.method3836(var5, (long)this.field922);
         }

         class108 var11;
         if(var1 != null && var3 != null) {
            var11 = var1.method932(var5, var2, var3, var4);
         } else if(var1 != null) {
            var11 = var1.method919(var5, var2);
         } else if(var3 != null) {
            var11 = var3.method919(var5, var4);
         } else {
            var11 = var5.method2452(true);
         }

         if(this.field941 != 128 || this.field943 != 128) {
            var11.method2404(this.field941, this.field943, this.field941);
         }

         return var11;
      }
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "-276176707"
   )
   static final void method835(int var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = 2048 - var3 & 2047;
      int var7 = 2048 - var4 & 2047;
      int var8 = 0;
      int var9 = 0;
      int var10 = var5;
      int var11;
      int var12;
      int var13;
      if(var6 != 0) {
         var11 = class94.field1655[var6];
         var12 = class94.field1653[var6];
         var13 = var9 * var12 - var11 * var5 >> 16;
         var10 = var12 * var5 + var9 * var11 >> 16;
         var9 = var13;
      }

      if(var7 != 0) {
         var11 = class94.field1655[var7];
         var12 = class94.field1653[var7];
         var13 = var8 * var12 + var10 * var11 >> 16;
         var10 = var12 * var10 - var11 * var8 >> 16;
         var8 = var13;
      }

      class85.field1500 = var0 - var8;
      field955 = var1 - var9;
      class157.field2342 = var2 - var10;
      class98.field1694 = var3;
      class99.field1703 = var4;
   }

   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1841355663"
   )
   static final void method836() {
      client.field336.method2854(200);

      for(class3 var0 = (class3)client.field455.method3867(); null != var0; var0 = (class3)client.field455.method3868()) {
         if(var0.field59 == 0 || var0.field59 == 3) {
            class214.method4018(var0, true);
         }
      }

      if(client.field371 != null) {
         class51.method1124(client.field371);
         client.field371 = null;
      }

   }
}
