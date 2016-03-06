import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("aa")
@Implements("MessageNode")
public class class35 extends class203 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -761643961
   )
   int field780;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 381982765
   )
   @Export("type")
   int field781;
   @ObfuscatedName("i")
   String field783;
   @ObfuscatedName("f")
   @Export("sender")
   String field784;
   @ObfuscatedName("m")
   @Export("value")
   String field785;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -620492733
   )
   int field789;
   @ObfuscatedName("p")
   public static String field790;

   @ObfuscatedName("j")
   void method737(int var1, String var2, String var3, String var4) {
      int var5 = (class11.field176 += -341843965) * 835832491 - 1;
      this.field789 = var5;
      this.field780 = client.field394;
      this.field781 = var1;
      this.field783 = var2;
      this.field784 = var3;
      this.field785 = var4;
   }

   @ObfuscatedName("o")
   static final void method738(class121 var0) {
      for(int var1 = 0; var1 < class32.field756; ++var1) {
         int var2 = class32.field748[var1];
         class2 var3 = client.field410[var2];
         int var4 = var0.method2453();
         if((var4 & 1) != 0) {
            var4 += var0.method2453() << 8;
         }

         class147.method3082(var0, var2, var3, var4);
      }

   }

   class35(int var1, String var2, String var3, String var4) {
      int var5 = (class11.field176 += -341843965) * 835832491 - 1;
      this.field789 = var5;
      this.field780 = client.field394;
      this.field781 = var1;
      this.field783 = var2;
      this.field784 = var3;
      this.field785 = var4;
   }
}
