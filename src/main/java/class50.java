import java.awt.Font;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("az")
public class class50 extends class203 {
   @ObfuscatedName("px")
   @ObfuscatedGetter(
      longValue = -5880015446861991619L
   )
   static long field1096;
   @ObfuscatedName("r")
   public static class192 field1097 = new class192(64);
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1457379063
   )
   public int field1098 = 0;
   @ObfuscatedName("qu")
   protected static Font field1099;
   @ObfuscatedName("a")
   public static class166 field1100;

   @ObfuscatedName("r")
   public void method1032(class118 var1) {
      while(true) {
         int var2 = var1.method2579();
         if(0 == var2) {
            return;
         }

         this.method1041(var1, var2);
      }
   }

   @ObfuscatedName("f")
   void method1041(class118 var1, int var2) {
      if(2 == var2) {
         this.field1098 = var1.method2514();
      }

   }
}
