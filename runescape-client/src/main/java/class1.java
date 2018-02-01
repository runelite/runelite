import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
public class class1 {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Li;"
   )
   static final class1 field1;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Li;"
   )
   static final class1 field5;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Li;"
   )
   static final class1 field2;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Li;"
   )
   static final class1 field3;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Li;"
   )
   static final class1 field0;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Li;"
   )
   static final class1 field6;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Li;"
   )
   static final class1 field9;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -423417693
   )
   final int field7;

   static {
      field1 = new class1(1);
      field5 = new class1(6);
      field2 = new class1(2);
      field3 = new class1(3);
      field0 = new class1(0);
      field6 = new class1(4);
      field9 = new class1(5);
   }

   class1(int var1) {
      this.field7 = var1;
   }

   @ObfuscatedName("p")
   public static final void method3(long var0) {
      if(var0 > 0L) {
         if(0L == var0 % 10L) {
            long var2 = var0 - 1L;

            try {
               Thread.sleep(var2);
            } catch (InterruptedException var8) {
               ;
            }

            try {
               Thread.sleep(1L);
            } catch (InterruptedException var7) {
               ;
            }
         } else {
            try {
               Thread.sleep(var0);
            } catch (InterruptedException var6) {
               ;
            }
         }

      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-464766908"
   )
   @Export("getColTags")
   static String getColTags(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(CIB)I",
      garbageValue = "-64"
   )
   static int method1(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "262962612"
   )
   static void method0() {
      ItemContainer.itemContainers = new HashTable(32);
   }
}
