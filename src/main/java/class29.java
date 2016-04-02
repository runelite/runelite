import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
public final class class29 extends class85 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1062323213
   )
   int field669;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1918785457
   )
   int field670;
   @ObfuscatedName("nj")
   @ObfuscatedGetter(
      intValue = -1206653003
   )
   static int field671;
   @ObfuscatedName("k")
   boolean field672 = false;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -991396563
   )
   int field673;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1160501535
   )
   int field674;
   @ObfuscatedName("g")
   class42 field675;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 616239661
   )
   int field676 = 0;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 932957759
   )
   int field677 = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -748797033
   )
   int field678;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 92792903
   )
   int field680;

   @ObfuscatedName("a")
   static class25 method659() {
      return class25.field613 < class25.field616?class25.field615[++class25.field613 - 1]:null;
   }

   @ObfuscatedName("s")
   public static int method660(CharSequence var0, int var1) {
      return class174.method3424(var0, var1);
   }

   @ObfuscatedName("f")
   protected final class105 vmethod1921() {
      class43 var1 = class82.method1906(this.field669);
      class105 var2;
      if(!this.field672) {
         var2 = var1.method914(this.field676);
      } else {
         var2 = var1.method914(-1);
      }

      return var2 == null?null:var2;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1767544641"
   )
   final void method662(int var1) {
      if(!this.field672) {
         this.field677 += var1;

         while(this.field677 > this.field675.field968[this.field676]) {
            this.field677 -= this.field675.field968[this.field676];
            ++this.field676;
            if(this.field676 >= this.field675.field975.length) {
               this.field672 = true;
               break;
            }
         }

      }
   }

   class29(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field669 = var1;
      this.field678 = var2;
      this.field680 = var3;
      this.field673 = var4;
      this.field674 = var5;
      this.field670 = var7 + var6;
      int var8 = class82.method1906(this.field669).field988;
      if(var8 != -1) {
         this.field672 = false;
         this.field675 = class46.method974(var8);
      } else {
         this.field672 = true;
      }

   }

   @ObfuscatedName("w")
   static int method668(class122 var0) {
      int var1 = var0.method2756(2);
      int var2;
      if(0 == var1) {
         var2 = 0;
      } else if(1 == var1) {
         var2 = var0.method2756(5);
      } else if(var1 == 2) {
         var2 = var0.method2756(8);
      } else {
         var2 = var0.method2756(11);
      }

      return var2;
   }

   @ObfuscatedName("g")
   public static boolean method669(int var0) {
      return (var0 >> 30 & 1) != 0;
   }
}
