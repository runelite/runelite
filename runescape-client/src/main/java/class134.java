import java.awt.Component;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ei")
public abstract class class134 {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "2048700153"
   )
   public abstract void vmethod3107(Component var1);

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "64"
   )
   public abstract void vmethod3097(Component var1);

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "787452028"
   )
   public abstract int vmethod3100();

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BZI)Ljava/lang/Object;",
      garbageValue = "-118383524"
   )
   public static Object method2841(byte[] var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else {
         if(var0.length > 136 && !class128.field2073) {
            try {
               class121 var2 = new class121();
               var2.vmethod2794(var0);
               return var2;
            } catch (Throwable var3) {
               class128.field2073 = true;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "440738730"
   )
   static void method2842(int var0) {
      if(var0 == -1 && !Client.field507) {
         class186.field3007.method3587();
         class186.field3002 = 1;
         XItemContainer.field200 = null;
      } else if(var0 != -1 && Client.field506 != var0 && Client.field424 != 0 && !Client.field507) {
         class77.method1614(2, class47.field1024, var0, 0, Client.field424, false);
      }

      Client.field506 = var0;
   }
}
