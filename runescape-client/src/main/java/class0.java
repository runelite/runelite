import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
public class class0 extends Node {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1604941785
   )
   int field0;
   @ObfuscatedName("f")
   Object[] field1;
   @ObfuscatedName("n")
   Widget field2;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1532177743
   )
   int field3;
   @ObfuscatedName("rl")
   protected static String field4;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 821233305
   )
   int field5;
   @ObfuscatedName("m")
   Widget field6;
   @ObfuscatedName("e")
   boolean field7;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -308585769
   )
   int field8;
   @ObfuscatedName("w")
   String field9;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1405020789
   )
   int field10;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1787796983
   )
   int field11;
   @ObfuscatedName("pd")
   static class163 field12;
   @ObfuscatedName("nf")
   static class59 field14;
   @ObfuscatedName("hq")
   @ObfuscatedGetter(
      intValue = 807629809
   )
   @Export("menuY")
   static int menuY;
   @ObfuscatedName("ad")
   static class171 field16;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;Lclass170;I)V",
      garbageValue = "557593832"
   )
   public static void method0(class170 var0, class170 var1, class170 var2) {
      Sequence.field1003 = var0;
      Sequence.field988 = var1;
      Sequence.field989 = var2;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Lclass49;",
      garbageValue = "1370993810"
   )
   public static class49 method1(int var0) {
      class49 var1 = (class49)class49.field1086.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class49.field1080.method3304(33, var0);
         var1 = new class49();
         if(null != var2) {
            var1.method984(new Buffer(var2));
         }

         class49.field1086.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "41"
   )
   static int method2(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.method3849((long)var0);
      return null == var2?-1:(var1 >= 0 && var1 < var2.itemIds.length?var2.itemIds[var1]:-1);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)I",
      garbageValue = "19"
   )
   public static int method3(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if(var4 <= 127) {
            ++var2;
         } else if(var4 <= 2047) {
            var2 += 2;
         } else {
            var2 += 3;
         }
      }

      return var2;
   }
}
