import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
public class class48 extends class203 {
   @ObfuscatedName("a")
   public static class166 field1069;
   @ObfuscatedName("f")
   public char field1070;
   @ObfuscatedName("s")
   public char field1071;
   @ObfuscatedName("y")
   public String field1072 = "null";
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1186688449
   )
   public int field1073;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1160630989
   )
   public int field1075 = 0;
   @ObfuscatedName("r")
   public static class192 field1076 = new class192(64);
   @ObfuscatedName("n")
   public String[] field1077;
   @ObfuscatedName("gl")
   @ObfuscatedGetter(
      intValue = 184537967
   )
   @Export("plane")
   static int field1078;
   @ObfuscatedName("ae")
   static class167 field1079;
   @ObfuscatedName("j")
   public int[] field1080;
   @ObfuscatedName("m")
   public int[] field1087;

   @ObfuscatedName("f")
   void method1012(class118 var1, int var2) {
      if(var2 == 1) {
         this.field1070 = (char)var1.method2579();
      } else if(var2 == 2) {
         this.field1071 = (char)var1.method2579();
      } else if(3 == var2) {
         this.field1072 = var1.method2520();
      } else if(4 == var2) {
         this.field1073 = var1.method2517();
      } else {
         int var3;
         if(var2 == 5) {
            this.field1075 = var1.method2514();
            this.field1087 = new int[this.field1075];
            this.field1077 = new String[this.field1075];

            for(var3 = 0; var3 < this.field1075; ++var3) {
               this.field1087[var3] = var1.method2517();
               this.field1077[var3] = var1.method2520();
            }
         } else if(var2 == 6) {
            this.field1075 = var1.method2514();
            this.field1087 = new int[this.field1075];
            this.field1080 = new int[this.field1075];

            for(var3 = 0; var3 < this.field1075; ++var3) {
               this.field1087[var3] = var1.method2517();
               this.field1080[var3] = var1.method2517();
            }
         }
      }

   }

   @ObfuscatedName("r")
   public void method1013(class118 var1) {
      while(true) {
         int var2 = var1.method2579();
         if(0 == var2) {
            return;
         }

         this.method1012(var1, var2);
      }
   }

   @ObfuscatedName("s")
   public static class80 method1017(class166 var0, String var1, String var2) {
      int var3 = var0.method3278(var1);
      int var4 = var0.method3328(var3, var2);
      return class88.method2098(var0, var3, var4);
   }

   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "-293985158"
   )
   static final void method1018(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(class103.method2303(var0)) {
         class11.field170 = null;
         class150.method3147(class172.field2850[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(class11.field170 != null) {
            class150.method3147(class11.field170, -1412584499, var1, var2, var3, var4, class13.field200, class59.field1215, var7);
            class11.field170 = null;
         }

      } else {
         if(-1 != var7) {
            client.field499[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               client.field499[var8] = true;
            }
         }

      }
   }

   @ObfuscatedName("m")
   static final int method1019(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return ((var0 & 16711935) * var3 + (var1 & 16711935) * var2 & -16711936) + ((var0 & '\uff00') * var3 + (var1 & '\uff00') * var2 & 16711680) >> 8;
   }
}
