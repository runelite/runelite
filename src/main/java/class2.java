import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
@Implements("Player")
public final class class2 extends class37 {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -659032801
   )
   int field33;
   @ObfuscatedName("l")
   @Export("composition")
   class178 field34;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1565891289
   )
   int field35;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 445778359
   )
   int field36 = -1;
   @ObfuscatedName("m")
   String[] field38 = new String[3];
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1059759119
   )
   @Export("combatLevel")
   int field39;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 2011259531
   )
   int field40;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1934693589
   )
   int field41 = -1;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1600424217
   )
   int field42;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1764853731
   )
   @Export("totalLevel")
   int field43;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1590755453
   )
   int field44;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1437789095
   )
   int field45;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1561409859
   )
   int field46;
   @ObfuscatedName("g")
   @Export("model")
   class104 field47;
   @ObfuscatedName("j")
   @Export("name")
   String field48;
   @ObfuscatedName("e")
   boolean field49;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -965082207
   )
   int field50;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1795003459
   )
   int field51;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -509906061
   )
   int field52;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -907063375
   )
   @Export("team")
   int field53;
   @ObfuscatedName("t")
   boolean field54;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -55327597
   )
   int field55;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 928239687
   )
   int field56;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 505131573
   )
   int field57;
   @ObfuscatedName("p")
   boolean field58;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -142671587
   )
   int field59;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass118;I)V",
      garbageValue = "-1557444878"
   )
   final void method11(class118 var1) {
      var1.field1998 = 0;
      int var2 = var1.method2453();
      this.field41 = var1.method2454();
      this.field36 = var1.method2454();
      int var3 = -1;
      this.field53 = 0;
      int[] var4 = new int[12];

      int var6;
      int var7;
      for(int var5 = 0; var5 < 12; ++var5) {
         var6 = var1.method2453();
         if(0 == var6) {
            var4[var5] = 0;
         } else {
            var7 = var1.method2453();
            var4[var5] = (var6 << 8) + var7;
            if(0 == var5 && var4[0] == '\uffff') {
               var3 = var1.method2455();
               break;
            }

            if(var4[var5] >= 512) {
               int var8 = class22.method581(var4[var5] - 512).field1119;
               if(0 != var8) {
                  this.field53 = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.method2453();
         if(var7 < 0 || var7 >= class133.field2079[var6].length) {
            var7 = 0;
         }

         var9[var6] = var7;
      }

      super.field815 = var1.method2455();
      if('\uffff' == super.field815) {
         super.field815 = -1;
      }

      super.field816 = var1.method2455();
      if(super.field816 == '\uffff') {
         super.field816 = -1;
      }

      super.field857 = super.field816;
      super.field818 = var1.method2455();
      if('\uffff' == super.field818) {
         super.field818 = -1;
      }

      super.field819 = var1.method2455();
      if('\uffff' == super.field819) {
         super.field819 = -1;
      }

      super.field811 = var1.method2455();
      if('\uffff' == super.field811) {
         super.field811 = -1;
      }

      super.field821 = var1.method2455();
      if(super.field821 == '\uffff') {
         super.field821 = -1;
      }

      super.field822 = var1.method2455();
      if(super.field822 == '\uffff') {
         super.field822 = -1;
      }

      this.field48 = var1.method2461();
      if(this == class148.field2249) {
         class147.field2235 = this.field48;
      }

      this.field39 = var1.method2453();
      this.field40 = var1.method2455();
      this.field54 = var1.method2453() == 1;
      if(client.field288 == 0 && client.field455 >= 2) {
         this.field54 = false;
      }

      if(null == this.field34) {
         this.field34 = new class178();
      }

      this.field34.method3433(var4, var9, 1 == var2, var3);
   }

   @ObfuscatedName("f")
   void method12(int var1, int var2) {
      super.field824 = 0;
      super.field868 = 0;
      super.field867 = 0;
      super.field864[0] = var1;
      super.field817[0] = var2;
      int var3 = this.method31();
      super.field839 = super.field864[0] * 128 + 64 * var3;
      super.field848 = var3 * 64 + super.field817[0] * 128;
   }

   @ObfuscatedName("a")
   protected final class104 vmethod1870() {
      if(null == this.field34) {
         return null;
      } else {
         class42 var1 = -1 != super.field820 && 0 == super.field844?class36.method741(super.field820):null;
         class42 var2 = -1 == super.field838 || this.field58 || super.field815 == super.field838 && null != var1?null:class36.method741(super.field838);
         class104 var3 = this.field34.method3438(var1, super.field827, var2, super.field829);
         if(var3 == null) {
            return null;
         } else {
            var3.method2261();
            super.field843 = var3.field1461;
            class104 var4;
            class104[] var5;
            if(!this.field58 && super.field846 != -1 && super.field847 != -1) {
               var4 = class26.method635(super.field846).method899(super.field847);
               if(null != var4) {
                  var4.method2270(0, -super.field850, 0);
                  var5 = new class104[]{var3, var4};
                  var3 = new class104(var5, 2);
               }
            }

            if(!this.field58 && null != this.field47) {
               if(client.field394 >= this.field52) {
                  this.field47 = null;
               }

               if(client.field394 >= this.field43 && client.field394 < this.field52) {
                  var4 = this.field47;
                  var4.method2270(this.field44 - super.field839, this.field45 - this.field42, this.field46 - super.field848);
                  if(super.field860 == 512) {
                     var4.method2266();
                     var4.method2266();
                     var4.method2266();
                  } else if(1024 == super.field860) {
                     var4.method2266();
                     var4.method2266();
                  } else if(1536 == super.field860) {
                     var4.method2266();
                  }

                  var5 = new class104[]{var3, var4};
                  var3 = new class104(var5, 2);
                  if(512 == super.field860) {
                     var4.method2266();
                  } else if(1024 == super.field860) {
                     var4.method2266();
                     var4.method2266();
                  } else if(1536 == super.field860) {
                     var4.method2266();
                     var4.method2266();
                     var4.method2266();
                  }

                  var4.method2270(super.field839 - this.field44, this.field42 - this.field45, super.field848 - this.field46);
               }
            }

            var3.field1829 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("ah")
   static final void method14(boolean var0) {
      class38.method764();
      ++client.field337;
      if(client.field337 >= 50 || var0) {
         client.field337 = 0;
         if(!client.field304 && null != class209.field3115) {
            client.field329.method2686(149);

            try {
               class209.field3115.method2932(client.field329.field1995, 0, client.field329.field1998);
               client.field329.field1998 = 0;
            } catch (IOException var2) {
               client.field304 = true;
            }
         }

      }
   }

   @ObfuscatedName("m")
   final void method16(int var1, int var2, byte var3) {
      if(super.field824 < 9) {
         ++super.field824;
      }

      for(int var4 = super.field824; var4 > 0; --var4) {
         super.field864[var4] = super.field864[var4 - 1];
         super.field817[var4] = super.field817[var4 - 1];
         super.field866[var4] = super.field866[var4 - 1];
      }

      super.field864[0] = var1;
      super.field817[0] = var2;
      super.field866[0] = var3;
   }

   @ObfuscatedName("o")
   final boolean vmethod753() {
      return this.field34 != null;
   }

   @ObfuscatedName("r")
   static boolean method24(class166 var0, int var1) {
      byte[] var2 = var0.method3219(var1);
      if(var2 == null) {
         return false;
      } else {
         class51.method1036(var2);
         return true;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "2082524716"
   )
   final void method26(int var1, int var2, byte var3) {
      if(super.field820 != -1 && class36.method741(super.field820).field998 == 1) {
         super.field820 = -1;
      }

      super.field853 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.field864[0] >= 0 && super.field864[0] < 104 && super.field817[0] >= 0 && super.field817[0] < 104) {
            if(2 == var3) {
               class8.method112(this, var1, var2, (byte)2);
            }

            this.method16(var1, var2, var3);
         } else {
            this.method12(var1, var2);
         }
      } else {
         this.method12(var1, var2);
      }

   }

   @ObfuscatedName("l")
   int method31() {
      return null != this.field34 && this.field34.field2916 != -1?class14.method162(this.field34.field2916).field885:1;
   }

   class2() {
      for(int var1 = 0; var1 < 3; ++var1) {
         this.field38[var1] = "";
      }

      this.field39 = 0;
      this.field40 = 0;
      this.field43 = 0;
      this.field52 = 0;
      this.field58 = false;
      this.field53 = 0;
      this.field54 = false;
      this.field49 = false;
   }
}
