import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
public class class48 extends class204 {
   @ObfuscatedName("w")
   static class193 field1079 = new class193(64);
   @ObfuscatedName("p")
   public int[] field1080;
   @ObfuscatedName("d")
   public char field1081;
   @ObfuscatedName("c")
   public char field1082;
   @ObfuscatedName("y")
   public String field1083 = "null";
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1948072713
   )
   public int field1085 = 0;
   @ObfuscatedName("m")
   public String[] field1086;
   @ObfuscatedName("q")
   public int[] field1087;
   @ObfuscatedName("a")
   public static class167 field1088;
   @ObfuscatedName("by")
   static class168 field1089;
   @ObfuscatedName("qa")
   protected static class133 field1091;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      longValue = -6485411598322379221L
   )
   static long field1092;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 560491435
   )
   public int field1093;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "2059702382"
   )
   void method1095(class119 var1, int var2) {
      if(1 == var2) {
         this.field1081 = (char)var1.method2613();
      } else if(var2 == 2) {
         this.field1082 = (char)var1.method2613();
      } else if(3 == var2) {
         this.field1083 = var1.method2621();
      } else if(var2 == 4) {
         this.field1093 = var1.method2618();
      } else {
         int var3;
         if(5 == var2) {
            this.field1085 = var1.method2615();
            this.field1080 = new int[this.field1085];
            this.field1086 = new String[this.field1085];

            for(var3 = 0; var3 < this.field1085; ++var3) {
               this.field1080[var3] = var1.method2618();
               this.field1086[var3] = var1.method2621();
            }
         } else if(6 == var2) {
            this.field1085 = var1.method2615();
            this.field1080 = new int[this.field1085];
            this.field1087 = new int[this.field1085];

            for(var3 = 0; var3 < this.field1085; ++var3) {
               this.field1080[var3] = var1.method2618();
               this.field1087[var3] = var1.method2618();
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass119;B)V",
      garbageValue = "100"
   )
   void method1097(class119 var1) {
      while(true) {
         int var2 = var1.method2613();
         if(0 == var2) {
            return;
         }

         this.method1095(var1, var2);
      }
   }
}
