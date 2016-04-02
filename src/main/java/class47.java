import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("at")
public class class47 extends class204 {
   @ObfuscatedName("rx")
   protected static String field1042;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -329397491
   )
   public int field1043;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -244419517
   )
   public int field1044;
   @ObfuscatedName("e")
   public static class167 field1045;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -288630027
   )
   public int field1046;
   @ObfuscatedName("ap")
   static int[] field1047;
   @ObfuscatedName("w")
   public static class193 field1049 = new class193(64);

   @ObfuscatedName("e")
   public void method976(class119 var1) {
      while(true) {
         int var2 = var1.method2523();
         if(0 == var2) {
            return;
         }

         this.method981(var1, var2);
      }
   }

   @ObfuscatedName("w")
   void method981(class119 var1, int var2) {
      if(var2 == 1) {
         this.field1043 = var1.method2700();
         this.field1044 = var1.method2523();
         this.field1046 = var1.method2523();
      }

   }

   @ObfuscatedName("a")
   public static int method982(String var0) {
      return var0.length() + 1;
   }
}
