import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
final class class7 implements Comparator {
   @ObfuscatedName("db")
   static byte[][] field59;
   @ObfuscatedName("pl")
   static class116 field60;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1259943023
   )
   public static int field65;
   @ObfuscatedName("es")
   static SpritePixels[] field66;
   @ObfuscatedName("ao")
   static SpritePixels[] field67;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-1379475654"
   )
   static void method99(int var0, String var1, String var2) {
      class207.addChatMessage(var0, var1, var2, (String)null);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "-2119681662"
   )
   int method100(class2 var1, class2 var2) {
      return var1.field17 < var2.field17?-1:(var1.field17 == var2.field17?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method100((class2)var1, (class2)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2030640065"
   )
   static void method108() {
      FileOnDisk var0 = null;

      try {
         var0 = class47.method856("", class13.field139.field2669, true);
         Buffer var1 = class2.field21.method668();
         var0.method1375(var1.payload, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if(null != var0) {
            var0.method1365();
         }
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-44"
   )
   public static void method110() {
      while(true) {
         Deque var0 = class183.field2705;
         Deque var2 = class183.field2705;
         class180 var1;
         synchronized(class183.field2705) {
            var1 = (class180)class183.field2703.method2389();
         }

         if(null == var1) {
            return;
         }

         var1.field2671.method3361(var1.field2670, (int)var1.hash, var1.field2675, false);
      }
   }
}
