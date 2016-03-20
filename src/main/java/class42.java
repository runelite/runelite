import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
@Implements("Sequence")
public class class42 extends class203 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1217481159
   )
   public int field983 = 5;
   @ObfuscatedName("r")
   static class166 field984;
   @ObfuscatedName("f")
   static class166 field985;
   @ObfuscatedName("s")
   public static class192 field986 = new class192(64);
   @ObfuscatedName("j")
   public int[] field987;
   @ObfuscatedName("e")
   public int[] field988;
   @ObfuscatedName("m")
   public int[] field990;
   @ObfuscatedName("a")
   static class166 field991;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -266259053
   )
   public int field992 = -1;
   @ObfuscatedName("l")
   @Export("interleaveLeave")
   int[] field993;
   @ObfuscatedName("h")
   @Export("stretches")
   public boolean field994 = false;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 424474019
   )
   public int field995 = -1;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -301852173
   )
   public int field996 = -1;
   @ObfuscatedName("g")
   int[] field997;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1342368047
   )
   @Export("maxLoops")
   public int field998 = 99;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 967338619
   )
   @Export("precedenceAnimating")
   public int field999 = -1;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2099353057
   )
   public int field1000 = 1;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 151742769
   )
   @Export("replyMode")
   public int field1001 = 2;
   @ObfuscatedName("mx")
   @Export("clanMembers")
   static class24[] field1003;
   @ObfuscatedName("y")
   public static class192 field1004 = new class192(100);
   @ObfuscatedName("qh")
   @ObfuscatedGetter(
      intValue = 1103734737
   )
   protected static int field1005;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "396940963"
   )
   void method870() {
      if(this.field999 == -1) {
         if(null != this.field993) {
            this.field999 = 2;
         } else {
            this.field999 = 0;
         }
      }

      if(this.field992 == -1) {
         if(null != this.field993) {
            this.field992 = 2;
         } else {
            this.field992 = 0;
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass118;II)V",
      garbageValue = "3046256"
   )
   void method871(class118 var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2514();
         this.field990 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field990[var4] = var1.method2514();
         }

         this.field988 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field988[var4] = var1.method2514();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field988[var4] += var1.method2514() << 16;
         }
      } else if(var2 == 2) {
         this.field1000 = var1.method2514() * -1;
      } else if(3 == var2) {
         var3 = var1.method2579();
         this.field993 = new int[1 + var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field993[var4] = var1.method2579();
         }

         this.field993[var3] = 9999999;
      } else if(4 == var2) {
         this.field994 = true;
      } else if(5 == var2) {
         this.field983 = var1.method2579();
      } else if(6 == var2) {
         this.field996 = var1.method2514();
      } else if(var2 == 7) {
         this.field995 = var1.method2514();
      } else if(var2 == 8) {
         this.field998 = var1.method2579();
      } else if(var2 == 9) {
         this.field999 = var1.method2579();
      } else if(var2 == 10) {
         this.field992 = var1.method2579();
      } else if(var2 == 11) {
         this.field1001 = var1.method2579();
      } else if(12 == var2) {
         var3 = var1.method2579();
         this.field997 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field997[var4] = var1.method2514();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field997[var4] += var1.method2514() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.method2579();
         this.field987 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field987[var4] = var1.method2516();
         }
      }

   }

   @ObfuscatedName("e")
   public class104 method873(class104 var1, int var2) {
      var2 = this.field988[var2];
      class102 var3 = class5.method83(var2 >> 16);
      var2 &= '\uffff';
      if(null == var3) {
         return var1.method2351(true);
      } else {
         class104 var4 = var1.method2351(!var3.method2295(var2));
         var4.method2366(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("f")
   void method874(class118 var1) {
      while(true) {
         int var2 = var1.method2579();
         if(0 == var2) {
            return;
         }

         this.method871(var1, var2);
      }
   }

   @ObfuscatedName("m")
   class104 method875(class104 var1, int var2) {
      var2 = this.field988[var2];
      class102 var3 = class5.method83(var2 >> 16);
      var2 &= '\uffff';
      if(null == var3) {
         return var1.method2308(true);
      } else {
         class104 var4 = var1.method2308(!var3.method2295(var2));
         var4.method2366(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("n")
   public class104 method877(class104 var1, int var2) {
      int var3 = this.field988[var2];
      class102 var4 = class5.method83(var3 >> 16);
      var3 &= '\uffff';
      if(null == var4) {
         return var1.method2351(true);
      } else {
         class102 var5 = null;
         int var6 = 0;
         if(null != this.field997 && var2 < this.field997.length) {
            var6 = this.field997[var2];
            var5 = class5.method83(var6 >> 16);
            var6 &= '\uffff';
         }

         class104 var7;
         if(null != var5 && '\uffff' != var6) {
            var7 = var1.method2351(!var4.method2295(var3) & !var5.method2295(var6));
            var7.method2366(var4, var3);
            var7.method2366(var5, var6);
            return var7;
         } else {
            var7 = var1.method2351(!var4.method2295(var3));
            var7.method2366(var4, var3);
            return var7;
         }
      }
   }

   @ObfuscatedName("g")
   class104 method882(class104 var1, int var2, int var3) {
      var2 = this.field988[var2];
      class102 var4 = class5.method83(var2 >> 16);
      var2 &= '\uffff';
      if(var4 == null) {
         return var1.method2351(true);
      } else {
         class104 var5 = var1.method2351(!var4.method2295(var2));
         var3 &= 3;
         if(1 == var3) {
            var5.method2318();
         } else if(var3 == 2) {
            var5.method2364();
         } else if(var3 == 3) {
            var5.method2316();
         }

         var5.method2366(var4, var2);
         if(1 == var3) {
            var5.method2316();
         } else if(2 == var3) {
            var5.method2364();
         } else if(3 == var3) {
            var5.method2318();
         }

         return var5;
      }
   }

   @ObfuscatedName("j")
   public class104 method903(class104 var1, int var2, class42 var3, int var4) {
      var2 = this.field988[var2];
      class102 var5 = class5.method83(var2 >> 16);
      var2 &= '\uffff';
      if(var5 == null) {
         return var3.method873(var1, var4);
      } else {
         var4 = var3.field988[var4];
         class102 var6 = class5.method83(var4 >> 16);
         var4 &= '\uffff';
         class104 var7;
         if(null == var6) {
            var7 = var1.method2351(!var5.method2295(var2));
            var7.method2366(var5, var2);
            return var7;
         } else {
            var7 = var1.method2351(!var5.method2295(var2) & !var6.method2295(var4));
            var7.method2314(var5, var2, var6, var4, this.field993);
            return var7;
         }
      }
   }

   @ObfuscatedName("t")
   static final int method904(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var0 / 4 << 10) + (var1 / 32 << 7) + var2 / 2;
      return var3;
   }

   @ObfuscatedName("e")
   public static boolean method905() {
      return 0 != class182.field2947?true:class182.field2942.method3666();
   }
}
