import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ay")
public class class48 extends class203 {
   @ObfuscatedName("n")
   public int[] field1076;
   @ObfuscatedName("l")
   public static class192 field1077 = new class192(64);
   @ObfuscatedName("a")
   public char field1078;
   @ObfuscatedName("h")
   public int[] field1079;
   @ObfuscatedName("f")
   public String field1080 = "null";
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -952299599
   )
   public int field1081;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 616489301
   )
   public int field1082 = 0;
   @ObfuscatedName("j")
   public static class166 field1083;
   @ObfuscatedName("k")
   public String[] field1085;
   @ObfuscatedName("i")
   public char field1086;

   @ObfuscatedName("a")
   void method982(class118 var1, int var2) {
      if(1 == var2) {
         this.field1078 = (char)var1.method2453();
      } else if(2 == var2) {
         this.field1086 = (char)var1.method2453();
      } else if(3 == var2) {
         this.field1080 = var1.method2461();
      } else if(4 == var2) {
         this.field1081 = var1.method2458();
      } else {
         int var3;
         if(var2 == 5) {
            this.field1082 = var1.method2455();
            this.field1079 = new int[this.field1082];
            this.field1085 = new String[this.field1082];

            for(var3 = 0; var3 < this.field1082; ++var3) {
               this.field1079[var3] = var1.method2458();
               this.field1085[var3] = var1.method2461();
            }
         } else if(var2 == 6) {
            this.field1082 = var1.method2455();
            this.field1079 = new int[this.field1082];
            this.field1076 = new int[this.field1082];

            for(var3 = 0; var3 < this.field1082; ++var3) {
               this.field1079[var3] = var1.method2458();
               this.field1076[var3] = var1.method2458();
            }
         }
      }

   }

   @ObfuscatedName("l")
   public void method985(class118 var1) {
      while(true) {
         int var2 = var1.method2453();
         if(0 == var2) {
            return;
         }

         this.method982(var1, var2);
      }
   }

   @ObfuscatedName("az")
   static final void method994(class66 var0) {
      var0.field1273 = false;
      if(null != var0.field1272) {
         var0.field1272.field1270 = 0;
      }

      for(class66 var1 = var0.vmethod3677(); null != var1; var1 = var0.vmethod3678()) {
         method994(var1);
      }

   }

   @ObfuscatedName("a")
   static int method995(char var0) {
      int var1 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var1 = (var0 << 4) + 1;
      }

      return var1;
   }

   @ObfuscatedName("j")
   public static class40 method996(int var0) {
      class40 var1 = (class40)class40.field935.method3711((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class40.field948.method3214(6, var0);
         var1 = new class40();
         var1.field924 = var0;
         if(null != var2) {
            var1.method800(new class118(var2));
         }

         var1.method799();
         if(var1.field942) {
            var1.field934 = 0;
            var1.field918 = false;
         }

         class40.field935.method3713(var1, (long)var0);
         return var1;
      }
   }
}
