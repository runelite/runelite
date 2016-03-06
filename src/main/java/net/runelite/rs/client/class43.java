import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("aq")
public class class43 extends class203 {
   @ObfuscatedName("i")
   static class192 field1006 = new class192(30);
   @ObfuscatedName("l")
   public static class166 field1007;
   @ObfuscatedName("a")
   static class192 field1008 = new class192(64);
   @ObfuscatedName("h")
   short[] field1010;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1200648845
   )
   int field1011;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 852797433
   )
   public int field1012 = -1;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -367617197
   )
   int field1013 = 128;
   @ObfuscatedName("n")
   short[] field1014;
   @ObfuscatedName("k")
   short[] field1015;
   @ObfuscatedName("j")
   public static class166 field1016;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1511306219
   )
   int field1017 = 0;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1637255547
   )
   int field1018 = 128;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -676978135
   )
   int field1019 = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1841000249
   )
   int field1020 = 0;
   @ObfuscatedName("r")
   short[] field1021;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1351146673
   )
   int field1022;

   @ObfuscatedName("i")
   public final class104 method899(int var1) {
      class104 var2 = (class104)field1006.method3711((long)this.field1022);
      if(var2 == null) {
         class99 var3 = class99.method2237(field1007, this.field1011, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(null != this.field1010) {
            for(var4 = 0; var4 < this.field1010.length; ++var4) {
               var3.method2189(this.field1010[var4], this.field1014[var4]);
            }
         }

         if(null != this.field1015) {
            for(var4 = 0; var4 < this.field1015.length; ++var4) {
               var3.method2183(this.field1015[var4], this.field1021[var4]);
            }
         }

         var2 = var3.method2169(this.field1020 + 64, this.field1017 + 850, -30, -50, -30);
         field1006.method3713(var2, (long)this.field1022);
      }

      class104 var5;
      if(this.field1012 != -1 && var1 != -1) {
         var5 = class36.method741(this.field1012).method880(var2, var1);
      } else {
         var5 = var2.method2294(true);
      }

      if(this.field1013 != 128 || this.field1018 != 128) {
         var5.method2310(this.field1013, this.field1018, this.field1013);
      }

      if(0 != this.field1019) {
         if(this.field1019 == 90) {
            var5.method2266();
         }

         if(180 == this.field1019) {
            var5.method2266();
            var5.method2266();
         }

         if(this.field1019 == 270) {
            var5.method2266();
            var5.method2266();
            var5.method2266();
         }
      }

      return var5;
   }

   @ObfuscatedName("a")
   void method900(class118 var1, int var2) {
      if(var2 == 1) {
         this.field1011 = var1.method2455();
      } else if(var2 == 2) {
         this.field1012 = var1.method2455();
      } else if(var2 == 4) {
         this.field1013 = var1.method2455();
      } else if(5 == var2) {
         this.field1018 = var1.method2455();
      } else if(6 == var2) {
         this.field1019 = var1.method2455();
      } else if(var2 == 7) {
         this.field1020 = var1.method2453();
      } else if(8 == var2) {
         this.field1017 = var1.method2453();
      } else {
         int var3;
         int var4;
         if(40 == var2) {
            var3 = var1.method2453();
            this.field1010 = new short[var3];
            this.field1014 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1010[var4] = (short)var1.method2455();
               this.field1014[var4] = (short)var1.method2455();
            }
         } else if(41 == var2) {
            var3 = var1.method2453();
            this.field1015 = new short[var3];
            this.field1021 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1015[var4] = (short)var1.method2455();
               this.field1021[var4] = (short)var1.method2455();
            }
         }
      }

   }

   @ObfuscatedName("l")
   void method904(class118 var1) {
      while(true) {
         int var2 = var1.method2453();
         if(0 == var2) {
            return;
         }

         this.method900(var1, var2);
      }
   }
}
