import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ho")
public class class212 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -405594809
   )
   public int field2600;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1651555163
   )
   public int field2601;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1865577855
   )
   public int field2603;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(BI)C",
      garbageValue = "1802023354"
   )
   public static char method3989(byte var0) {
      int var1 = var0 & 255;
      if(var1 == 0) {
         throw new IllegalArgumentException("");
      } else {
         if(var1 >= 128 && var1 < 160) {
            char var2 = class266.field3658[var1 - 128];
            if(var2 == 0) {
               var2 = 63;
            }

            var1 = var2;
         }

         return (char)var1;
      }
   }

   public class212() {
      this.field2603 = -1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1990922717"
   )
   public int method3991() {
      return this.field2603 << 28 | this.field2600 << 14 | this.field2601;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-975800986"
   )
   public void method3992(int var1, int var2, int var3) {
      this.field2603 = var1;
      this.field2600 = var2;
      this.field2601 = var3;
   }

   public class212(class212 var1) {
      this.field2603 = var1.field2603;
      this.field2600 = var1.field2600;
      this.field2601 = var1.field2601;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1635445800"
   )
   public static boolean method3993() {
      ClassInfo var0 = (ClassInfo)class280.field3745.method3620();
      return var0 != null;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass212;B)Z",
      garbageValue = "100"
   )
   boolean method3994(class212 var1) {
      return var1.field2603 != this.field2603?false:(this.field2600 != var1.field2600?false:var1.field2601 == this.field2601);
   }

   public int hashCode() {
      return this.method3991();
   }

   public String toString() {
      return this.field2603 + "," + (this.field2600 >> 6) + "," + (this.field2601 >> 6) + "," + (this.field2600 & 63) + "," + (this.field2601 & 63);
   }

   public boolean equals(Object var1) {
      return this == var1?true:(!(var1 instanceof class212)?false:this.method3994((class212)var1));
   }

   public class212(int var1) {
      if(var1 == -1) {
         this.field2603 = -1;
      } else {
         this.field2603 = var1 >> 28 & 3;
         this.field2600 = var1 >> 14 & 16383;
         this.field2601 = var1 & 16383;
      }

   }

   public class212(int var1, int var2, int var3) {
      this.field2603 = var1;
      this.field2600 = var2;
      this.field2601 = var3;
   }
}
