import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fl")
public class class174 {
   @ObfuscatedName("r")
   static CRC32 field2760 = new CRC32();
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1329427405
   )
   static int field2761 = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = -7700566270376198017L
   )
   static long field2762;
   @ObfuscatedName("l")
   static XHashTable field2764 = new XHashTable(4096);
   @ObfuscatedName("j")
   static XHashTable field2765 = new XHashTable(32);
   @ObfuscatedName("z")
   static byte field2766 = 0;
   @ObfuscatedName("y")
   static Node2LinkedList field2767 = new Node2LinkedList();
   @ObfuscatedName("u")
   static XHashTable field2768 = new XHashTable(4096);
   @ObfuscatedName("k")
   static class146 field2769;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1897074047
   )
   public static int field2771 = 0;
   @ObfuscatedName("p")
   static Buffer field2772 = new Buffer(8);
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 2106127523
   )
   static int field2773 = 0;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1133775587
   )
   public static int field2774 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -100867139
   )
   public static int field2775 = 0;
   @ObfuscatedName("c")
   static XHashTable field2776 = new XHashTable(4096);
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 635695047
   )
   public static int field2777 = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1618692607
   )
   public static int field2778 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1023120275
   )
   public static int field2779 = 0;
   @ObfuscatedName("n")
   static class171[] field2781 = new class171[256];

   @ObfuscatedName("ds")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "-11325393"
   )
   static final boolean method3415(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 205) {
         Client.field397 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.field553.method3509(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.field553.method3530(var2, var3 == 1);
         }

         if(var1 == 324) {
            Client.field553.method3512(false);
         }

         if(var1 == 325) {
            Client.field553.method3512(true);
         }

         if(var1 == 326) {
            Client.field324.method2828(199);
            Client.field553.method3537(Client.field324);
            return true;
         } else {
            return false;
         }
      }
   }
}
