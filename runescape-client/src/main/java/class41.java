import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
@Implements("NPCComposition")
public class class41 extends class207 {
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -651291941
   )
   int field907 = 0;
   @ObfuscatedName("g")
   public static class170 field908;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1647841037
   )
   int field909 = 128;
   @ObfuscatedName("e")
   @Export("npcModelCache")
   static class196 field910 = new class196(50);
   @ObfuscatedName("i")
   short[] field911;
   @ObfuscatedName("s")
   @Export("name")
   public String field912 = "null";
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1754332403
   )
   public int field913 = 1;
   @ObfuscatedName("u")
   @Export("models")
   int[] field914;
   @ObfuscatedName("n")
   int[] field915;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1775259135
   )
   int field916 = 128;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1055781361
   )
   public int field917 = -1;
   @ObfuscatedName("c")
   @Export("isVisible")
   public boolean field918 = false;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 505418297
   )
   public int field919 = -1;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1732609405
   )
   @Export("combatLevel")
   public int field920 = -1;
   @ObfuscatedName("l")
   public static class170 field921;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1285448113
   )
   public int field922 = -1;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1343466873
   )
   public int field923 = -1;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -965663117
   )
   @Export("id")
   public int field924;
   @ObfuscatedName("f")
   short[] field925;
   @ObfuscatedName("v")
   short[] field926;
   @ObfuscatedName("j")
   @Export("actions")
   public String[] field927 = new String[5];
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -497760511
   )
   public int field928 = -1;
   @ObfuscatedName("r")
   static class196 field929 = new class196(64);
   @ObfuscatedName("z")
   short[] field930;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -75050061
   )
   public int field931 = -1;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1245172423
   )
   public int field932 = -1;
   @ObfuscatedName("x")
   @Export("isMinimapVisible")
   public boolean field933 = true;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 1746572411
   )
   int field934 = 0;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -1678730625
   )
   public int field935 = -1;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1413058687
   )
   public int field936 = 32;
   @ObfuscatedName("am")
   public int[] field937;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1039221475
   )
   int field938 = -1;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -1287887143
   )
   int field939 = -1;
   @ObfuscatedName("ak")
   public boolean field940 = true;
   @ObfuscatedName("ag")
   @Export("isClickable")
   public boolean field941 = true;
   @ObfuscatedName("af")
   public boolean field942 = false;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1225576323"
   )
   void method815() {
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass44;ILclass44;II)Lclass108;",
      garbageValue = "1543275936"
   )
   public final class108 method818(class44 var1, int var2, class44 var3, int var4) {
      if(this.field937 != null) {
         class41 var12 = this.method820();
         return var12 == null?null:var12.method818(var1, var2, var3, var4);
      } else {
         class108 var5 = (class108)field910.method3905((long)this.field924);
         if(null == var5) {
            boolean var6 = false;

            for(int var10 = 0; var10 < this.field914.length; ++var10) {
               if(!field908.method3453(this.field914[var10], 0)) {
                  var6 = true;
               }
            }

            if(var6) {
               return null;
            }

            class103[] var8 = new class103[this.field914.length];

            int var9;
            for(var9 = 0; var9 < this.field914.length; ++var9) {
               var8[var9] = class103.method2369(field908, this.field914[var9], 0);
            }

            class103 var7;
            if(var8.length == 1) {
               var7 = var8[0];
            } else {
               var7 = new class103(var8, var8.length);
            }

            if(null != this.field925) {
               for(var9 = 0; var9 < this.field925.length; ++var9) {
                  var7.method2305(this.field925[var9], this.field930[var9]);
               }
            }

            if(this.field911 != null) {
               for(var9 = 0; var9 < this.field911.length; ++var9) {
                  var7.method2306(this.field911[var9], this.field926[var9]);
               }
            }

            var5 = var7.method2321(64 + this.field907, this.field934 + 850, -30, -50, -30);
            field910.method3907(var5, (long)this.field924);
         }

         class108 var11;
         if(null != var1 && var3 != null) {
            var11 = var1.method914(var5, var2, var3, var4);
         } else if(var1 != null) {
            var11 = var1.method943(var5, var2);
         } else if(null != var3) {
            var11 = var3.method943(var5, var4);
         } else {
            var11 = var5.method2399(true);
         }

         if(this.field909 != 128 || this.field916 != 128) {
            var11.method2404(this.field909, this.field916, this.field909);
         }

         return var11;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)Lclass103;",
      garbageValue = "44"
   )
   public final class103 method819() {
      if(null != this.field937) {
         class41 var1 = this.method820();
         return var1 == null?null:var1.method819();
      } else if(this.field915 == null) {
         return null;
      } else {
         boolean var6 = false;

         for(int var5 = 0; var5 < this.field915.length; ++var5) {
            if(!field908.method3453(this.field915[var5], 0)) {
               var6 = true;
            }
         }

         if(var6) {
            return null;
         } else {
            class103[] var2 = new class103[this.field915.length];

            for(int var7 = 0; var7 < this.field915.length; ++var7) {
               var2[var7] = class103.method2369(field908, this.field915[var7], 0);
            }

            class103 var3;
            if(var2.length == 1) {
               var3 = var2[0];
            } else {
               var3 = new class103(var2, var2.length);
            }

            int var4;
            if(null != this.field925) {
               for(var4 = 0; var4 < this.field925.length; ++var4) {
                  var3.method2305(this.field925[var4], this.field930[var4]);
               }
            }

            if(this.field911 != null) {
               for(var4 = 0; var4 < this.field911.length; ++var4) {
                  var3.method2306(this.field911[var4], this.field926[var4]);
               }
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Lclass41;",
      garbageValue = "308631255"
   )
   public final class41 method820() {
      int var1 = -1;
      if(this.field938 != -1) {
         var1 = class54.method1164(this.field938);
      } else if(this.field939 != -1) {
         var1 = class179.field2958[this.field939];
      }

      return var1 >= 0 && var1 < this.field937.length && this.field937[var1] != -1?class16.method202(this.field937[var1]):null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass122;IB)V",
      garbageValue = "3"
   )
   void method833(class122 var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2633();
         this.field914 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field914[var4] = var1.method2635();
         }
      } else if(var2 == 2) {
         this.field912 = var1.method2663();
      } else if(var2 == 12) {
         this.field913 = var1.method2633();
      } else if(var2 == 13) {
         this.field931 = var1.method2635();
      } else if(var2 == 14) {
         this.field919 = var1.method2635();
      } else if(var2 == 15) {
         this.field928 = var1.method2635();
      } else if(var2 == 16) {
         this.field923 = var1.method2635();
      } else if(var2 == 17) {
         this.field919 = var1.method2635();
         this.field917 = var1.method2635();
         this.field932 = var1.method2635();
         this.field922 = var1.method2635();
      } else if(var2 >= 30 && var2 < 35) {
         this.field927[var2 - 30] = var1.method2663();
         if(this.field927[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.field927[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.method2633();
         this.field925 = new short[var3];
         this.field930 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field925[var4] = (short)var1.method2635();
            this.field930[var4] = (short)var1.method2635();
         }
      } else if(var2 == 41) {
         var3 = var1.method2633();
         this.field911 = new short[var3];
         this.field926 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field911[var4] = (short)var1.method2635();
            this.field926[var4] = (short)var1.method2635();
         }
      } else if(var2 == 60) {
         var3 = var1.method2633();
         this.field915 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field915[var4] = var1.method2635();
         }
      } else if(var2 == 93) {
         this.field933 = false;
      } else if(var2 == 95) {
         this.field920 = var1.method2635();
      } else if(var2 == 97) {
         this.field909 = var1.method2635();
      } else if(var2 == 98) {
         this.field916 = var1.method2635();
      } else if(var2 == 99) {
         this.field918 = true;
      } else if(var2 == 100) {
         this.field907 = var1.method2634();
      } else if(var2 == 101) {
         this.field934 = var1.method2634() * 5;
      } else if(var2 == 102) {
         this.field935 = var1.method2635();
      } else if(var2 == 103) {
         this.field936 = var1.method2635();
      } else if(var2 == 106) {
         this.field938 = var1.method2635();
         if(this.field938 == '\uffff') {
            this.field938 = -1;
         }

         this.field939 = var1.method2635();
         if(this.field939 == '\uffff') {
            this.field939 = -1;
         }

         var3 = var1.method2633();
         this.field937 = new int[var3 + 1];

         for(var4 = 0; var4 <= var3; ++var4) {
            this.field937[var4] = var1.method2635();
            if(this.field937[var4] == '\uffff') {
               this.field937[var4] = -1;
            }
         }
      } else if(var2 == 107) {
         this.field940 = false;
      } else if(var2 == 109) {
         this.field941 = false;
      } else if(var2 == 111) {
         this.field942 = true;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass122;I)V",
      garbageValue = "1602304248"
   )
   void method838(class122 var1) {
      while(true) {
         int var2 = var1.method2633();
         if(var2 == 0) {
            return;
         }

         this.method833(var1, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Lclass52;",
      garbageValue = "-1054819598"
   )
   public static class52 method843(int var0) {
      class52 var1 = (class52)class52.field1157.method3905((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class52.field1152.method3411(8, var0);
         var1 = new class52();
         if(var2 != null) {
            var1.method1124(new class122(var2));
         }

         class52.field1157.method3907(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1673062880"
   )
   public boolean method844() {
      if(this.field937 == null) {
         return true;
      } else {
         int var1 = -1;
         if(this.field938 != -1) {
            var1 = class54.method1164(this.field938);
         } else if(this.field939 != -1) {
            var1 = class179.field2958[this.field939];
         }

         return var1 >= 0 && var1 < this.field937.length && this.field937[var1] != -1;
      }
   }
}
