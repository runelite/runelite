import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bw")
public class class52 extends class207 {
   @ObfuscatedName("o")
   public int[] field1144;
   @ObfuscatedName("l")
   public static class196 field1145 = new class196(64);
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -640949297
   )
   public int field1146;
   @ObfuscatedName("h")
   public char field1147;
   @ObfuscatedName("r")
   public String field1148 = "null";
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1426384577
   )
   public int field1150 = 0;
   @ObfuscatedName("e")
   public static class170 field1152;
   @ObfuscatedName("u")
   public int[] field1153;
   @ObfuscatedName("at")
   static class149 field1154;
   @ObfuscatedName("c")
   public char field1155;
   @ObfuscatedName("p")
   public String[] field1157;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass122;B)V",
      garbageValue = "-38"
   )
   public void method1125(class122 var1) {
      while(true) {
         int var2 = var1.method2610();
         if(var2 == 0) {
            return;
         }

         this.method1126(var1, var2);
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass122;IB)V",
      garbageValue = "34"
   )
   void method1126(class122 var1, int var2) {
      if(var2 == 1) {
         this.field1155 = (char)var1.method2610();
      } else if(var2 == 2) {
         this.field1147 = (char)var1.method2610();
      } else if(var2 == 3) {
         this.field1148 = var1.method2617();
      } else if(var2 == 4) {
         this.field1146 = var1.method2614();
      } else {
         int var3;
         if(var2 == 5) {
            this.field1150 = var1.method2612();
            this.field1153 = new int[this.field1150];
            this.field1157 = new String[this.field1150];

            for(var3 = 0; var3 < this.field1150; ++var3) {
               this.field1153[var3] = var1.method2614();
               this.field1157[var3] = var1.method2617();
            }
         } else if(var2 == 6) {
            this.field1150 = var1.method2612();
            this.field1153 = new int[this.field1150];
            this.field1144 = new int[this.field1150];

            for(var3 = 0; var3 < this.field1150; ++var3) {
               this.field1153[var3] = var1.method2614();
               this.field1144[var3] = var1.method2614();
            }
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass125;S)I",
      garbageValue = "16590"
   )
   static int method1132(class125 var0) {
      int var1 = var0.method2859(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.method2859(5);
      } else if(var1 == 2) {
         var2 = var0.method2859(8);
      } else {
         var2 = var0.method2859(11);
      }

      return var2;
   }

   @ObfuscatedName("ed")
   @ObfuscatedSignature(
      signature = "(Lclass176;I)Ljava/lang/String;",
      garbageValue = "1756308147"
   )
   static String method1133(class176 var0) {
      return class182.method3601(class27.method644(var0)) == 0?null:(null != var0.field2873 && var0.field2873.trim().length() != 0?var0.field2873:null);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1707616845"
   )
   public static void method1134() {
      class79.field1449 = null;
      class11.field192 = null;
      class138.field2134 = null;
      class169.field2703 = null;
      class178.field2941 = null;
      class93.field1626 = null;
   }
}
