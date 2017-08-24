import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
public class class1 {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lj;"
   )
   static final class1 field12;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lj;"
   )
   static final class1 field1;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lj;"
   )
   static final class1 field2;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lj;"
   )
   static final class1 field0;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lj;"
   )
   static final class1 field4;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lj;"
   )
   static final class1 field3;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lj;"
   )
   static final class1 field6;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1933692685
   )
   final int field7;

   static {
      field12 = new class1(6);
      field1 = new class1(2);
      field2 = new class1(3);
      field0 = new class1(1);
      field4 = new class1(4);
      field3 = new class1(5);
      field6 = new class1(0);
   }

   class1(int var1) {
      this.field7 = var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Lcq;",
      garbageValue = "390861271"
   )
   static Preferences method0() {
      FileOnDisk var0 = null;
      Preferences var1 = new Preferences();

      try {
         var0 = class163.getPreferencesFile("", class56.field695.field3199, false);
         byte[] var2 = new byte[(int)var0.length()];

         int var4;
         for(int var3 = 0; var3 < var2.length; var3 += var4) {
            var4 = var0.read(var2, var3, var2.length - var3);
            if(var4 == -1) {
               throw new IOException();
            }
         }

         var1 = new Preferences(new Buffer(var2));
      } catch (Exception var6) {
         ;
      }

      try {
         if(var0 != null) {
            var0.close();
         }
      } catch (Exception var5) {
         ;
      }

      return var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1016415555"
   )
   static void method1(int var0) {
      ItemContainer var1 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if(var1 != null) {
         var1.unlink();
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lii;I)V",
      garbageValue = "2078011764"
   )
   public static void method2(IndexDataBase var0) {
      InvType.field3284 = var0;
   }
}
