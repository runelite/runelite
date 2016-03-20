import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
@Implements("Player")
public final class class2 extends class37 {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 835005905
   )
   int field25;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 259534483
   )
   int field27 = -1;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1662232799
   )
   int field28;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1692308441
   )
   int field29;
   @ObfuscatedName("e")
   String[] field30 = new String[3];
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 10726615
   )
   @Export("combatLevel")
   int field31;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1040161273
   )
   int field32;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -755207263
   )
   int field33;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 301224879
   )
   @Export("totalLevel")
   int field34;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -2008147529
   )
   int field35;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2019003809
   )
   int field36 = -1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 312560839
   )
   int field37;
   @ObfuscatedName("z")
   @Export("model")
   class104 field39;
   @ObfuscatedName("a")
   @Export("name")
   String field40;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -597961087
   )
   int field41;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1266439097
   )
   int field42;
   @ObfuscatedName("r")
   @Export("composition")
   class178 field43;
   @ObfuscatedName("x")
   boolean field44;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -100224169
   )
   @Export("team")
   int field45;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 2091625213
   )
   int field46;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1669730869
   )
   int field47;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 2138137791
   )
   int field48;
   @ObfuscatedName("k")
   boolean field49;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 80758835
   )
   int field50;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1444026925
   )
   int field51;
   @ObfuscatedName("p")
   boolean field52;
   @ObfuscatedName("ng")
   static class56 field53;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass118;B)V",
      garbageValue = "82"
   )
   final void method19(class118 var1) {
      var1.field1979 = 0;
      int var2 = var1.method2579();
      this.field27 = var1.method2707();
      this.field36 = var1.method2707();
      int var3 = -1;
      this.field45 = 0;
      int[] var4 = new int[12];

      int var6;
      int var7;
      for(int var5 = 0; var5 < 12; ++var5) {
         var6 = var1.method2579();
         if(0 == var6) {
            var4[var5] = 0;
         } else {
            var7 = var1.method2579();
            var4[var5] = (var6 << 8) + var7;
            if(var5 == 0 && var4[0] == '\uffff') {
               var3 = var1.method2514();
               break;
            }

            if(var4[var5] >= 512) {
               int var8 = class75.method1648(var4[var5] - 512).field1152;
               if(var8 != 0) {
                  this.field45 = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.method2579();
         if(var7 < 0 || var7 >= class123.field2027[var6].length) {
            var7 = 0;
         }

         var9[var6] = var7;
      }

      super.field817 = var1.method2514();
      if(super.field817 == '\uffff') {
         super.field817 = -1;
      }

      super.field830 = var1.method2514();
      if('\uffff' == super.field830) {
         super.field830 = -1;
      }

      super.field819 = super.field830 * -1;
      super.field820 = var1.method2514();
      if('\uffff' == super.field820) {
         super.field820 = -1;
      }

      super.field821 = var1.method2514();
      if('\uffff' == super.field821) {
         super.field821 = -1;
      }

      super.field860 = var1.method2514();
      if('\uffff' == super.field860) {
         super.field860 = -1;
      }

      super.field823 = var1.method2514();
      if('\uffff' == super.field823) {
         super.field823 = -1;
      }

      super.field828 = var1.method2514();
      if(super.field828 == '\uffff') {
         super.field828 = -1;
      }

      this.field40 = var1.method2520();
      if(this == class151.field2253) {
         class147.field2209 = this.field40;
      }

      this.field31 = var1.method2579();
      this.field32 = var1.method2514();
      this.field52 = var1.method2579() == 1;
      if(client.field295 == 0 && client.field460 >= 2) {
         this.field52 = false;
      }

      if(null == this.field43) {
         this.field43 = new class178();
      }

      this.field43.method3496(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("r")
   int method20() {
      return this.field43 != null && this.field43.field2905 != -1?class23.method593(this.field43.field2905).field881:1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "-1612926201"
   )
   final void method22(int var1, int var2, byte var3) {
      if(-1 != super.field869 && class134.method2875(super.field869).field992 == 1) {
         super.field869 = -1;
      }

      super.field839 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.field866[0] >= 0 && super.field866[0] < 104 && super.field867[0] >= 0 && super.field867[0] < 104) {
            if(var3 == 2) {
               class2 var4 = this;
               int var5 = super.field866[0];
               int var6 = super.field867[0];
               int var7 = this.method20();
               if(var5 >= var7 && var5 < 104 - var7 && var6 >= var7 && var6 < 104 - var7 && var1 >= var7 && var1 < 104 - var7 && var2 >= var7 && var2 < 104 - var7) {
                  int var8 = class9.method137(var5, var6, this.method20(), class129.method2837(var1, var2), client.field359[this.field47], client.field576, client.field300);
                  if(var8 >= 1) {
                     for(int var9 = 0; var9 < var8 - 1; ++var9) {
                        var4.method37(client.field576[var9], client.field300[var9], (byte)2);
                     }
                  }
               }
            }

            this.method37(var1, var2, var3);
         } else {
            this.method39(var1, var2);
         }
      } else {
         this.method39(var1, var2);
      }

   }

   class2() {
      for(int var1 = 0; var1 < 3; ++var1) {
         this.field30[var1] = "";
      }

      this.field31 = 0;
      this.field32 = 0;
      this.field34 = 0;
      this.field35 = 0;
      this.field44 = false;
      this.field45 = 0;
      this.field52 = false;
      this.field49 = false;
   }

   @ObfuscatedName("g")
   final boolean vmethod755() {
      return this.field43 != null;
   }

   @ObfuscatedName("f")
   protected final class104 vmethod1919() {
      if(this.field43 == null) {
         return null;
      } else {
         class42 var1 = -1 != super.field869 && 0 == super.field846?class134.method2875(super.field869):null;
         class42 var2 = super.field840 == -1 || this.field44 || super.field840 == super.field817 && null != var1?null:class134.method2875(super.field840);
         class104 var3 = this.field43.method3502(var1, super.field844, var2, super.field841);
         if(var3 == null) {
            return null;
         } else {
            var3.method2305();
            super.field845 = var3.field1448;
            class104 var4;
            class104[] var5;
            if(!this.field44 && super.field859 != -1 && -1 != super.field849) {
               var4 = class24.method595(super.field859).method909(super.field849);
               if(var4 != null) {
                  var4.method2320(0, -super.field852, 0);
                  var5 = new class104[]{var3, var4};
                  var3 = new class104(var5, 2);
               }
            }

            if(!this.field44 && null != this.field39) {
               if(client.field303 >= this.field35) {
                  this.field39 = null;
               }

               if(client.field303 >= this.field34 && client.field303 < this.field35) {
                  var4 = this.field39;
                  var4.method2320(this.field46 - super.field870, this.field37 - this.field33, this.field42 - super.field813);
                  if(super.field862 == 512) {
                     var4.method2316();
                     var4.method2316();
                     var4.method2316();
                  } else if(1024 == super.field862) {
                     var4.method2316();
                     var4.method2316();
                  } else if(1536 == super.field862) {
                     var4.method2316();
                  }

                  var5 = new class104[]{var3, var4};
                  var3 = new class104(var5, 2);
                  if(super.field862 == 512) {
                     var4.method2316();
                  } else if(super.field862 == 1024) {
                     var4.method2316();
                     var4.method2316();
                  } else if(super.field862 == 1536) {
                     var4.method2316();
                     var4.method2316();
                     var4.method2316();
                  }

                  var4.method2320(super.field870 - this.field46, this.field33 - this.field37, super.field813 - this.field42);
               }
            }

            var3.field1812 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("r")
   public static class49 method28(int var0) {
      class49 var1 = (class49)class49.field1089.method3792((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class49.field1091.method3263(15, var0);
         var1 = new class49();
         if(null != var2) {
            var1.method1021(new class118(var2));
         }

         class49.field1089.method3794(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("e")
   final void method37(int var1, int var2, byte var3) {
      if(super.field865 < 9) {
         ++super.field865;
      }

      for(int var4 = super.field865; var4 > 0; --var4) {
         super.field866[var4] = super.field866[var4 - 1];
         super.field867[var4] = super.field867[var4 - 1];
         super.field831[var4] = super.field831[var4 - 1];
      }

      super.field866[0] = var1;
      super.field867[0] = var2;
      super.field831[0] = var3;
   }

   @ObfuscatedName("y")
   void method39(int var1, int var2) {
      super.field865 = 0;
      super.field861 = 0;
      super.field848 = 0;
      super.field866[0] = var1;
      super.field867[0] = var2;
      int var3 = this.method20();
      super.field870 = 64 * var3 + super.field866[0] * 128;
      super.field813 = var3 * 64 + super.field867[0] * 128;
   }

   @ObfuscatedName("ad")
   static final void method43() {
      int var0 = class32.field774;
      int[] var1 = class32.field759;

      for(int var2 = 0; var2 < var0; ++var2) {
         class2 var3 = client.field415[var1[var2]];
         if(var3 != null) {
            class49.method1026(var3);
         }
      }

   }
}
