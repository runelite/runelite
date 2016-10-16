import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
public class class10 extends class110 {
   @ObfuscatedName("af")
   static class171 field154;
   @ObfuscatedName("qb")
   @ObfuscatedGetter(
      intValue = 2128549687
   )
   static int field155;
   @ObfuscatedName("ph")
   static class137 field159;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIILCollisionData;I)Z",
      garbageValue = "2126303970"
   )
   public boolean vmethod2357(int var1, int var2, int var3, CollisionData var4) {
      return var2 == super.field1920 && super.field1917 == var3;
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIII)V",
      garbageValue = "-1601645109"
   )
   @Export("addMenuEntry")
   static final void addMenuEntry(String var0, String var1, int var2, int var3, int var4, int var5) {
      if(!Client.isMenuOpen) {
         if(Client.menuOptionCount < 500) {
            Client.menuOptions[Client.menuOptionCount] = var0;
            Client.menuTargets[Client.menuOptionCount] = var1;
            Client.menuTypes[Client.menuOptionCount] = var2;
            Client.menuIdentifiers[Client.menuOptionCount] = var3;
            Client.menuActionParams0[Client.menuOptionCount] = var4;
            Client.menuActionParams1[Client.menuOptionCount] = var5;
            ++Client.menuOptionCount;
         }

      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)LMessageNode;",
      garbageValue = "1308122603"
   )
   static MessageNode method127(int var0, int var1) {
      ChatLineBuffer var2 = (ChatLineBuffer)class11.chatLineMap.get(Integer.valueOf(var0));
      return var2.method660(var1);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Lclass53;",
      garbageValue = "-2112291105"
   )
   public static class53 method128(int var0) {
      class53 var1 = (class53)class53.field1119.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class53.field1125.method3272(15, var0);
         var1 = new class53();
         if(null != var2) {
            var1.method1053(new Buffer(var2));
         }

         class53.field1119.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-861161374"
   )
   public static int method129(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var1 + var0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II)I",
      garbageValue = "-2005562505"
   )
   public static int method130(CharSequence var0, int var1) {
      return class54.method1075(var0, var1, true);
   }
}
